package youngcapital.hotel.JavaBackendHotel.controller;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import youngcapital.hotel.JavaBackendHotel.domain.Room;

@Component
public interface RoomRepository extends CrudRepository<Room, Long> {

	@Query(value = "SELECT DISTINCT room.id, room.room_no, room.reserved, room.price, room.type\r\n"
			+ "FROM room\r\n"
			+ "LEFT JOIN reservation_rooms\r\n"
			+ "ON room.id = reservation_rooms.rooms_id\r\n"
			+ "LEFT JOIN reservation\r\n"
			+ "ON reservation_rooms.reservation_id = reservation.id\r\n"
			+ "WHERE reservation.id IS NOT NULL;", nativeQuery = true)
	List<Room> getReservedRooms();
	
	/* java.sql.SQLException -- Not working, uses Statement.executeQuery() which requires a response. Not all statements produce results.;
	@Query(value = "SET @checkin = '2023-06-25';\r\n"
			+ "SET @checkout = '2023-06-30';\r\n"
			+ "CREATE TEMPORARY TABLE overlapping_reservations\r\n"
			+ "SELECT * FROM reservation\r\n"
			+ "LEFT JOIN reservation_rooms ON reservation.id = reservation_rooms.reservation_id\r\n"
			+ "WHERE @checkin < end_date AND @checkout > begin_date;\r\n"
			+ "CREATE TEMPORARY TABLE room_copy\r\n"
			+ "SELECT * FROM room;\r\n"
			+ "DELETE FROM room_copy WHERE EXISTS(\r\n"
			+ "SELECT 1 FROM overlapping_reservations\r\n"
			+ "WHERE overlapping_reservations.room_id = room_copy.id);\r\n"
			+ "SELECT * FROM room_copy;", nativeQuery = true)
	Iterable<Room> getVacantRooms(String checkOutDate, String checkInDate);
	*/

	@Query(value = "SELECT DISTINCT room.id, room.room_no, room.reserved, room.price, room.type\r\n"
			+ "FROM room\r\n"
			+ "LEFT JOIN reservation_rooms ON room.id = reservation_rooms.rooms_id\r\n"
			+ "LEFT JOIN reservation ON reservation_rooms.reservation_id = reservation.id\r\n"
			+ "WHERE ? < end_date AND ? > begin_date;", nativeQuery = true)
	List<Room> getReservedRooms(String checkInDate, String checkOutDate);

}
