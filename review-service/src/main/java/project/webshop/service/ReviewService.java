package project.webshop.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.webshop.model.Review;
import project.webshop.repository.ReviewRepository;


@Service("reviewService")
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review addNewRating(Review review) {
        return reviewRepository.save(review);

    }

    public Review getRating(UUID productId) {
        List<Review> reviewsForProduct = reviewRepository.find(productId);
        Double rating=0.0;
        Review review = new Review();
        Double sum=0.0;
        for(Review each:reviewsForProduct){
            sum=sum+each.getRating();
        }
        rating= sum/(reviewsForProduct.size());
        review.setProductId(productId);
        review.setRating(rating);
        review.setCustomerId(null);
        return review;
    }


}