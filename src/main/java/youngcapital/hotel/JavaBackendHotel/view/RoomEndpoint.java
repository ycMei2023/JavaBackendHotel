package youngcapital.hotel.JavaBackendHotel.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import youngcapital.hotel.JavaBackendHotel.controller.RoomService;
import youngcapital.hotel.JavaBackendHotel.domain.Room;

@RestController
public class RoomEndpoint {
	
	@Autowired
	RoomService rs;
	
	/* A simple example
	@GetMapping("/room")
	public Room sendRoom() {
		return new Room();
	} */
	
	@GetMapping("allRooms")
	public Iterable<Room> allRooms() {
		return rs.showAllRooms();
	}
	
	@PostMapping("addRoom")
	public void addRoom(@RequestBody Room room) {
		rs.saveRoom(room);
	}
	
	@DeleteMapping("deleteRoom")
	public void deleteRoom(@RequestBody String id) {
		int intId = Integer.parseInt(id);
		rs.deleteRoom(intId);
	}
	
	@PutMapping("updateRoom")
	public void updateRoom(@RequestBody Room room) {
		rs.saveRoom(room);
	}
}
