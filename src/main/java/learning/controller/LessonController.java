package learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import learning.model.*;
import learning.repository.*;

import java.util.List;

@Controller
public class LessonController {

    @Autowired
    private LessonRepository lessonRepo;

    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private EnrollmentRepository enrollRepo;

    @Autowired
    private LessonCompletionRepository completionRepo;

    @GetMapping("/course/{id}")
    public String courseDetail(@PathVariable int id, Model model) {

        Course course = courseRepo.findById(id).orElse(null);
        List<Lesson> lessons = lessonRepo.findByCourseId(id);

        model.addAttribute("course", course);
        model.addAttribute("lessons", lessons);

        return "course-detail";
    }

    @GetMapping("/complete/{lessonId}")
    public String completeLesson(@PathVariable int lessonId,
                                 @RequestParam int courseId,
                                 @SessionAttribute("user") User user) {

        Lesson lesson = lessonRepo.findById(lessonId).orElse(null);

        if (lesson == null) {
            return "redirect:/course/" + courseId;
        }

        boolean alreadyDone =
                completionRepo.existsByUserAndLesson(user, lesson);

        if (!alreadyDone) {
            LessonCompletion lc = new LessonCompletion();
            lc.setUser(user);
            lc.setLesson(lesson);
            completionRepo.save(lc);
        }

        Course course = lesson.getCourse();

        int totalLessons =
                lessonRepo.findByCourseId(courseId).size();

        int completedLessons =
                completionRepo.findByUserAndLesson_Course(user, course).size();

        int progress = 0;

        if (totalLessons > 0) {
            progress = (completedLessons * 100) / totalLessons;
        }

        Enrollment e = enrollRepo.findByUser(user)
                .stream()
                .filter(en -> en.getCourse().getId() == courseId)
                .findFirst()
                .orElse(null);

        if (e != null) {
            e.setProgress(progress);
            enrollRepo.save(e);
        }

        return "redirect:/course/" + courseId;
    }
}