package youngcapital.hotel.JavaBackendHotel.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import youngcapital.hotel.JavaBackendHotel.domain.Room;

@Component
public interface RoomRepository extends CrudRepository<Room, Long> {
	
}
