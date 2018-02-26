package project.webshop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import project.webshop.model.Product;
import project.webshop.repository.ProductRepositoryReactive;

@RestController
public class ProductControllerReactive {

    @Autowired
    private ProductRepositoryReactive productRepositoryReactive;

    @GetMapping("/products")
    Flux<Product> list() {
        return this.productRepositoryReactive.findAll().log();
    }

    @GetMapping("/products/{code}")
    Mono<Product> findById(@PathVariable("code") String code) {
        return this.productRepositoryReactive.findById(code).log();
    }
}
