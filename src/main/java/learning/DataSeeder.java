package learning;

import learning.model.Course;
import learning.model.Lesson;
import learning.model.User;
import learning.repository.CourseRepository;
import learning.repository.LessonRepository;
import learning.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Seeds demo data on first run so the platform isn't empty.
 * Safe to delete once you have real data.
 */
@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedData(CourseRepository courseRepo,
                               LessonRepository lessonRepo,
                               UserRepository userRepo) {
        return args -> {

            // Only seed if empty
            if (courseRepo.count() > 0) return;

            // ── Demo admin user ──
            User admin = new User();
            admin.setName("Admin");
            admin.setEmail("admin@learnforge.com");
            admin.setPassword("admin123"); // hash with BCrypt in production!
            userRepo.save(admin);

            // ── Course 1 ──
            Course c1 = new Course();
            c1.setTitle("Java Spring Boot from Zero");
            c1.setDescription("Build production-ready REST APIs and full-stack apps with Spring Boot.");
            courseRepo.save(c1);

            String[][] c1Lessons = {
                {"Introduction & Setup", "Install JDK 17, configure Spring Initializr, run your first Hello World application."},
                {"REST Controllers", "Deep dive into @RestController, @GetMapping, @PostMapping and request/response handling."},
                {"Spring Data JPA", "JpaRepository interface, derived queries, and custom JPQL."},
                {"Entity Relationships", "Map OneToMany and ManyToOne relationships between JPA entities."},
                {"Exception Handling", "@ControllerAdvice, @ExceptionHandler, custom error response bodies."},
                {"Validation", "@Valid, @NotNull, @Size — validating request bodies automatically."}
            };
            for (String[] l : c1Lessons) {
                Lesson lesson = new Lesson();
                lesson.setTitle(l[0]);
                lesson.setContent(l[1]);
                lesson.setCourse(c1);
                lessonRepo.save(lesson);
            }

            // ── Course 2 ──
            Course c2 = new Course();
            c2.setTitle("Modern React & TypeScript");
            c2.setDescription("Hooks, context, TypeScript generics — everything to build real-world React apps.");
            courseRepo.save(c2);

            String[][] c2Lessons = {
                {"React Fundamentals", "Components, props, JSX and the virtual DOM."},
                {"useState & useEffect", "Managing state and side effects in functional components."},
                {"TypeScript Basics", "Types, interfaces, generics — making React components type-safe."},
                {"React Context & useReducer", "Global state without Redux — Context API patterns."},
                {"React Router v6", "File-based routing, dynamic segments, protected routes."}
            };
            for (String[] l : c2Lessons) {
                Lesson lesson = new Lesson();
                lesson.setTitle(l[0]);
                lesson.setContent(l[1]);
                lesson.setCourse(c2);
                lessonRepo.save(lesson);
            }

            System.out.println("✅ LearnForge demo data seeded successfully.");
        };
    }
}