package youngcapital.hotel.JavaBackendHotel.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import youngcapital.hotel.JavaBackendHotel.domain.Reservation;

@Component
public interface ReservationRepository extends CrudRepository<Reservation, Long>{

}
