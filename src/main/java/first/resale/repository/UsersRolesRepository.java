package first.resale.repository;

import first.resale.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRolesRepository  extends JpaRepository<Role, Long> {
}
