package project.webshop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import project.webshop.domain.Category;
import project.webshop.exception.NotFoundException;
import project.webshop.service.CategoryService;


import java.util.List;


@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Category findOne(@PathVariable Long id) {
        return categoryService.findOne(id).orElseThrow(NotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category create(@RequestBody Category category) {
        category.setId(null);
        return categoryService.save(category);
    }

    @PutMapping(path = "/{id}")
    public void update(@PathVariable Long id, Category category) {
        categoryService.save(category);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }
}