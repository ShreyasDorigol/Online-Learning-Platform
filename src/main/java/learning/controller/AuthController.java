package learning.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import learning.model.User;
import learning.repository.UserRepository;

@Controller
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    /** Register — accepts form POST, saves user, redirects to login */
    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        // TODO: hash password with BCrypt before saving
        userRepo.save(user);
        return "redirect:/login?registered=true";
    }

    /** Login — sets session, redirects to courses on success */
    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session) {

        User user = userRepo.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("user", user);
            return "redirect:/courses";
        }

        return "redirect:/login?error=true";
    }

    /** Logout — invalidates session */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}