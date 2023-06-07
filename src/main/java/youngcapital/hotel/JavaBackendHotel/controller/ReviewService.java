package youngcapital.hotel.JavaBackendHotel.controller;

import java.util.Optional;

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
    
    public Iterable<Review> returnApprovedReviews(){
    	System.out.println(reviewRepository.approvedReviews());
    	return reviewRepository.approvedReviews();
    }

    public void saveReview(Review review) {
        reviewRepository.save(review);
    }

    public void deleteReview(long reviewId) {
        reviewRepository.deleteById(reviewId);
    }

	public void approveReview(long reviewId) {
		Optional<Review> optionalApprovedReview = reviewRepository.findById(reviewId);
		if(optionalApprovedReview.isPresent()) {
			Review approvedReview = optionalApprovedReview.get();
			approvedReview.setApproved(true);
			reviewRepository.save(approvedReview);
		}
		
	}
}
