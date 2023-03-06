package security.demo2_security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import security.demo2_security.entities.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
