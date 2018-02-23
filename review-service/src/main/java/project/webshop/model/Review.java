package project.webshop.model;
import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class Review {


    // REVIEW: productId, rating, customerId

    private UUID reviewId;
    private UUID productId;
    private double rating;
    private String content;
    private String subject;
    private UUID customerId;

    public UUID getReviewId() {
        return reviewId;
    }

    public void setReviewId(UUID reviewId) {
        this.reviewId = reviewId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public UUID getCustomerId() {
        return customerId;
    }
    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }
    public UUID getProductId() {
        return productId;
    }
    public void setProductId(UUID productId) {
        this.productId = productId;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }



}
