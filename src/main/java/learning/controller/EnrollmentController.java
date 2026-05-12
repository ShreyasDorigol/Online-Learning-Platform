package learning.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import learning.model.*;
import learning.repository.*;

import java.util.List;

@RestController
@RequestMapping("/api/enroll")
public class EnrollmentController {

    @Autowired private EnrollmentRepository enrollRepo;
    @Autowired private CourseRepository courseRepo;
    @Autowired private UserRepository userRepo;

    @PostMapping("/{userId}/{courseId}")
    public String enroll(@PathVariable int userId,
                         @PathVariable int courseId) {

        User user = userRepo.findById(userId).orElse(null);
        Course course = courseRepo.findById(courseId).orElse(null);

        if (user == null || course == null) return "Invalid data";

        boolean exists = enrollRepo.findByUser(user)
                .stream()
                .anyMatch(e -> e.getCourse().getId() == courseId);

        if (!exists) {
            Enrollment e = new Enrollment();
            e.setUser(user);
            e.setCourse(course);
            e.setProgress(0);
            enrollRepo.save(e);
        }

        return "Enrolled Successfully";
    }

    @GetMapping("/{userId}")
    public List<Enrollment> getUserCourses(@PathVariable int userId) {
        User user = userRepo.findById(userId).orElse(null);
        if (user == null) return List.of();
        return enrollRepo.findByUser(user);
    }
}