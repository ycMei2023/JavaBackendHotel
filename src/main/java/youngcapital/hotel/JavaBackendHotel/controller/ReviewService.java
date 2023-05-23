package youngcapital.hotel.JavaBackendHotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import youngcapital.hotel.JavaBackendHotel.domain.Review;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    public ReviewService() {
    }

    public Iterable<Review> returnAllReviews(){
        return reviewRepository.findAll();
    }

    public void saveReview(Review review) {
        reviewRepository.save(review);
    }

    public void deleteReview(long reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
