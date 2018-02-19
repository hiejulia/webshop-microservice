package project.webshop.repository;


import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import project.webshop.model.Product;


@Service
public interface ProductDetailsRepository extends MongoRepository<Product, String> {

    // find one product by product id
    public Product findById(String id);

    // get all products
    public List<Product> findAll();

    // find products by category

    List<Product> findByCategory(String category);



}
