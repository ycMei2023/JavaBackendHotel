package youngcapital.hotel.JavaBackendHotel.controller;

import java.util.Optional;
import java.util.ArrayList;

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

	public Iterable<Review> randomReviews(int numberOfRev) {
		// TO-DO: numberOfRev amount of random reviews in the ArrayList
		// TO-DO: ensure randomly picked id's exist in the table
		// 				Does that need re-indexing?
		ArrayList<Review> fetchedReviews = new ArrayList<Review>();
		
		for (long i=1; i<4; i++) {
			Review review = reviewRepository.findById(i).get();
			fetchedReviews.add(review);
		}
		
		return fetchedReviews;
	}
}
