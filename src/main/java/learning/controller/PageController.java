package learning.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import learning.repository.CourseRepository;

@Controller
public class PageController {

    @Autowired
    private CourseRepository courseRepo;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("featuredCourses", courseRepo.findAll());
        return "index";
    }

    @GetMapping("/login")
    public String loginPage(HttpSession session) {
        if (session.getAttribute("user") != null) return "redirect:/courses";
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}