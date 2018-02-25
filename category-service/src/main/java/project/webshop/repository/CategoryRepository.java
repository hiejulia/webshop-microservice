package project.webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.webshop.domain.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {
}