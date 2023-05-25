package youngcapital.hotel.JavaBackendHotel.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import youngcapital.hotel.JavaBackendHotel.controller.ReviewService;
import youngcapital.hotel.JavaBackendHotel.domain.Review;

@RestController
public class ReviewEndpoint {
    @Autowired
    ReviewService reviewService;

    @GetMapping("/Reviews")
    public Iterable<Review> allReviews(){
        return reviewService.returnAllReviews();
    }
    @PostMapping("/AddReview")
    public void addReview(@RequestBody Review review){
        reviewService.saveReview(review);
    }
    @DeleteMapping("DeleteReview/{reviewId}")
    public void deleteReview(@PathVariable("reviewId") int reviewId){
        reviewService.deleteReview(reviewId);
    }

    @PutMapping("/UpdateReview")
    public void updateReview(@RequestBody Review review){
        reviewService.saveReview(review);
    }
}
