package learning.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import learning.model.*;
import learning.repository.*;

@Controller
public class AdminController {

    @Autowired private CourseRepository courseRepo;
    @Autowired private LessonRepository lessonRepo;
    @Autowired private UserRepository userRepo;
    @Autowired private EnrollmentRepository enrollRepo;

    /** Admin dashboard page */
    @GetMapping("/admin")
    public String adminPage(Model model, HttpSession session) {

        // Basic guard: require a logged-in user
        // (Replace with Spring Security for production)
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/login";

        model.addAttribute("courses",         courseRepo.findAll());
        model.addAttribute("courseCount",     courseRepo.count());
        model.addAttribute("lessonCount",     lessonRepo.count());
        model.addAttribute("userCount",       userRepo.count());
        model.addAttribute("enrollmentCount", enrollRepo.count());
        model.addAttribute("enrollments",     enrollRepo.findAll());

        return "admin";
    }

    /** Add a lesson to a course */
    @PostMapping("/add-lesson")
    public String addLesson(@RequestParam String title,
                            @RequestParam String content,
                            @RequestParam int courseId,
                            HttpSession session) {

        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/login";

        Course course = courseRepo.findById(courseId).orElse(null);
        if (course == null) return "redirect:/admin";

        Lesson lesson = new Lesson();
        lesson.setTitle(title);
        lesson.setContent(content);
        lesson.setCourse(course);
        lessonRepo.save(lesson);

        return "redirect:/admin";
    }
}