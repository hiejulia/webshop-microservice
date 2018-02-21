package project.webshop.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import project.webshop.model.Review;


public interface ReviewRepository extends  CrudRepository<Review, UUID>{

    public List<Review> find(UUID productId);

    public Review save(Review review);

    public Review update(Review review);



}
