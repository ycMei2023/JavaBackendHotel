package youngcapital.hotel.JavaBackendHotel.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import youngcapital.hotel.JavaBackendHotel.domain.Room;

@Service
public class RoomService {
	@Autowired
	RoomRepository rr;
	
	public Optional<Room> findById(long id) {
		return rr.findById(id);
	}
	
	public Iterable<Room> showAllRooms() {
		return rr.findAll();
	}
	
	public void saveRoom(Room room) {
		rr.save(room);
	}

	public void deleteRoom(long id) {
		rr.deleteById(id);
		
	}
}
