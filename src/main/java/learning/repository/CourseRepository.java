package learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import learning.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}