package project.webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.webshop.domain.Category;
import project.webshop.repository.CategoryRepository;


import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Optional<Category> findOne(Long id) {
        return Optional.ofNullable(categoryRepository.findOne(id));
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public void delete(Long id) {
        categoryRepository.delete(id);
    }
}