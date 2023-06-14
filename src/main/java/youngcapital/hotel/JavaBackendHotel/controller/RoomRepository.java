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
	// SELECT DISTINCT room_no, room.id #SELECT * FROM `reservation` INNER JOIN reservation_rooms ON reservation.id = reservation_rooms.reservation_id INNER JOIN room ON reservation_rooms.rooms_id = room.id WHERE true;
	@Query(value = "SELECT DISTINCT room.id, room.room_no, room.reserved, room.price, room.type\r\n"
			+ "FROM room\r\n"
			+ "LEFT JOIN reservation_rooms\r\n"
			+ "ON room.id = reservation_rooms.rooms_id\r\n"
			+ "LEFT JOIN reservation\r\n"
			+ "ON reservation_rooms.reservation_id = reservation.id\r\n"
			+ "WHERE reservation.id IS NOT NULL;", nativeQuery = true)
	List<Room> getReservedRooms();
	
}
