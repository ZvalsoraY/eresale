package first.resale.repository;

import first.resale.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    User getUserById(Long id);
    void deleteById(Long id);
}
