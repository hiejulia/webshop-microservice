package project.webshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import project.webshop.model.Product;

public interface InventoryRepository extends MongoRepository<Product, String> {

}
