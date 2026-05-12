package learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import learning.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}