package learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import learning.model.Lesson;
import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
    List<Lesson> findByCourseId(int courseId);
}