package project.webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.webshop.domain.User;

public interface UserRepository  extends JpaRepository<User, Long> {
}
