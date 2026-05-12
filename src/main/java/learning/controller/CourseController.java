package learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import learning.model.Course;
import learning.repository.CourseRepository;
import learning.repository.LessonRepository;

import java.util.List;

@Controller
public class CourseController {

    @Autowired private CourseRepository repo;
    @Autowired private LessonRepository lessonRepo;

    @GetMapping("/courses")
    public String coursesPage(Model model) {
        model.addAttribute("courses", repo.findAll());
        return "courses";
    }

    @GetMapping("/api/courses")
    @ResponseBody
    public List<Course> getAllCoursesApi() {
        return repo.findAll();
    }

    @PostMapping("/api/courses")
    @ResponseBody
    public Course addCourse(@RequestBody Course course) {
        return repo.save(course);
    }
}