package youngcapital.hotel.JavaBackendHotel.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import youngcapital.hotel.JavaBackendHotel.domain.Reservation;
import youngcapital.hotel.JavaBackendHotel.domain.Room;

@Service
public class RoomService {
	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	public Optional<Room> findById(long id) {
		return roomRepository.findById(id);
	}
	
	public Iterable<Room> showAllRooms() {
		return roomRepository.findAll();
	}
	
	public void saveRoom(Room room) {
		roomRepository.save(room);
	}

	public void deleteRoom(long id) {
		roomRepository.deleteById(id);
		
	}

	public Iterable<Room> getReservedRooms() {
		return roomRepository.getReservedRooms();
	}
}
