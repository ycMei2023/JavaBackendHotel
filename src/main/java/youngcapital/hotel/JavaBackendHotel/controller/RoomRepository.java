package youngcapital.hotel.JavaBackendHotel.controller;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import youngcapital.hotel.JavaBackendHotel.domain.Reservation;
import youngcapital.hotel.JavaBackendHotel.domain.Room;

@Component
public interface RoomRepository extends CrudRepository<Room, Long> {
	// SELECT * FROM `reservation_rooms` WHERE `reservation_id` = ?1
	// doesn't work, Room expects a column 'id' and it complains its not found
	@Query(value = "SELECT * FROM Room", nativeQuery = true)
	List<Room> getReservedRooms();
	
}
