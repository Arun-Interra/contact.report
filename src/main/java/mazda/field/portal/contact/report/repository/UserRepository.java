package mazda.field.portal.contact.report.repository;

import mazda.field.portal.contact.report.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String username);
}
