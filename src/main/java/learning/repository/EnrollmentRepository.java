package learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import learning.model.*;
import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
    List<Enrollment> findByUser(User user);
}