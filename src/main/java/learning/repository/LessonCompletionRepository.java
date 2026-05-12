package learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import learning.model.*;

import java.util.List;

public interface LessonCompletionRepository extends JpaRepository<LessonCompletion, Integer> {

    List<LessonCompletion> findByUserAndLesson_Course(User user, Course course);

    boolean existsByUserAndLesson(User user, Lesson lesson);
}