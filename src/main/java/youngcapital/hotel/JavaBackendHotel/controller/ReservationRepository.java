package youngcapital.hotel.JavaBackendHotel.controller;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import youngcapital.hotel.JavaBackendHotel.domain.Reservation;

import java.util.List;

@Component
public interface ReservationRepository extends CrudRepository<Reservation, Long>{
    @Query(value = "SELECT * FROM Reservation ORDER BY begin_date ASC", nativeQuery = true)
    List<Reservation> reservations();

    @Query(value = "SELECT * FROM Reservation WHERE customer_id = ?1", nativeQuery = true)
    Iterable<Reservation> getByAccount(Long CustomerId);
}
