package youngcapital.hotel.JavaBackendHotel.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import youngcapital.hotel.JavaBackendHotel.domain.Review;
@Component
public interface ReviewRepository extends CrudRepository<Review, Long> {

}
