package project.webshop.repository;


import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import project.webshop.model.Product;


@Service
public interface ProductDetailsRepository extends MongoRepository<Product, String> {

    // find one product by product id
    Product findById(String id);

    // get all products
    List<Product> findAll();

    // find products by category

//    CompletableFuture<List<Product> > findByCategory(String category);
    List<Product> findByCategory(String category);
    // add product

    CompletableFuture<String> addProduct(Product product);
    // update product

    CompletableFuture<String> updateProduct(Product product);




}
