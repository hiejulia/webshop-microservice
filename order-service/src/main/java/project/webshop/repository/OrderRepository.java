package project.webshop.repository;
import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import project.webshop.model.Order;


@Service
public interface OrderRepository extends MongoRepository<Order, UUID> {

    public Order findById(UUID id);

    // get all order
    List<Order> findAll();


}
