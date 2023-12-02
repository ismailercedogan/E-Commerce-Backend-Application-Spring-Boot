package com.example.ecommercebackendapplicationspringboot;

import com.example.ecommercebackendapplicationspringboot.entity.Product;
import com.example.ecommercebackendapplicationspringboot.entity.Review;
import com.example.ecommercebackendapplicationspringboot.entity.User;
import com.example.ecommercebackendapplicationspringboot.repository.ProductRepository;
import com.example.ecommercebackendapplicationspringboot.repository.ReviewRepository;
import com.example.ecommercebackendapplicationspringboot.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ReviewRepositoryTest {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    public void testCreateReview() {
        // Given
        Review review = createReview();

        // When
        Review savedReview = reviewRepository.save(review);

        // Then
        assertNotNull(savedReview);
        assertNotNull(savedReview.getId());
    }

    @Test
    public void testReadReview() {
        // Given
        Review review = createReview();
        Review savedReview = reviewRepository.save(review);

        // When
        Optional<Review> foundReview = reviewRepository.findById(savedReview.getId());

        // Then
        assertTrue(foundReview.isPresent());
        assertEquals(savedReview.getId(), foundReview.get().getId());
        assertEquals(savedReview.getRating(), foundReview.get().getRating());
        assertEquals(savedReview.getComment(), foundReview.get().getComment());
    }

    @Test
    public void testUpdateReview() {
        // Given
        Review review = createReview();
        Review savedReview = reviewRepository.save(review);
        savedReview.setRating(5);
        savedReview.setComment("Updated comment");

        // When
        Review updatedReview = reviewRepository.save(savedReview);

        // Then
        assertNotNull(updatedReview);
        assertEquals(5, updatedReview.getRating());
        assertEquals("Updated comment", updatedReview.getComment());
    }

    @Test
    public void testDeleteReview() {
        // Given
        Review review = createReview();
        Review savedReview = reviewRepository.save(review);

        // When
        reviewRepository.deleteById(savedReview.getId());

        // Then
        Optional<Review> deletedReview = reviewRepository.findById(savedReview.getId());
        assertFalse(deletedReview.isPresent());
    }

    private Review createReview() {
        // Create a user
        User user = new User();
        user.setUsername("testUser");
        user.setEmail("testUser@example.com");
        user = userRepository.save(user);

        // Create a product
        Product product = new Product();
        product.setName("Test Product");
        product.setDescription("This is a test product.");
        product.setPrice(100.0);
        product = productRepository.save(product);

        // Create a review
        Review review = new Review();
        review.setRating(5);
        review.setComment("Great product!");
        review.setUser(user);
        review.setProduct(product);

        return review;
    }


}
