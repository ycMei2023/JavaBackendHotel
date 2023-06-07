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
		List<Reservation> allReservations = reservationRepository.reservations();
		
		// Code to filter for date on reservations goes here
		// Return all id's of reservations that overlap with the entered date range
		// Rooms connected to those id's are occupied on the entered date range
		// For now all reservation id's are used, to get the rooms associated with them
		
		long[] matchingReservationIds = {16, 17, 18, 19};
		
		// TO-DO: use gathered reservations (List<Reservation> or long[] with id's)
		//			to get all the associated rooms. Return List<Room>.
		
		return roomRepository.getReservedRooms();
	}
}
