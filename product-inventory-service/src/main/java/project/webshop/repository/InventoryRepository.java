package project.webshop.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import project.webshop.model.Inventory;


@Service
public interface InventoryRepository extends  MongoRepository<Inventory, UUID> {

    // find by product id
    public Inventory findByProductId(UUID productId);

    // find all
    List<Inventory> findAll();

    public Inventory save(Inventory inventory);


}