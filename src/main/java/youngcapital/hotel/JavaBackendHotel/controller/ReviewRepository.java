package youngcapital.hotel.JavaBackendHotel.controller;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import youngcapital.hotel.JavaBackendHotel.domain.Reservation;
import youngcapital.hotel.JavaBackendHotel.domain.Review;
@Component
public interface ReviewRepository extends CrudRepository<Review, Long> {
	@Query(value = "SELECT * FROM Review WHERE approved = 1", nativeQuery = true)
    List<Review> approvedReviews();
}
