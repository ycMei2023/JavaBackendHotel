package youngcapital.hotel.JavaBackendHotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import youngcapital.hotel.JavaBackendHotel.domain.Customer;
import youngcapital.hotel.JavaBackendHotel.domain.Reservation;
import youngcapital.hotel.JavaBackendHotel.domain.Room;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
	@Autowired
	ReservationRepository rr;

	@Autowired
	CustomerRepository cr;

	@Autowired
	RoomRepository roomRepository;


	public Iterable<Reservation> giveAllReservations() {
		return rr.findAll();
	}

	public void saveReservation(Reservation reservation) {
		rr.save(reservation);
	}

	public void approveReservation(long reservationid, boolean paymentStatus) {
		Optional<Reservation> optionalApprovedReservation = rr.findById(reservationid);
		if (optionalApprovedReservation.isPresent()) {
			Reservation approvedReservation = optionalApprovedReservation.get();
			approvedReservation.setApprovalDate(LocalDate.now());
			approvedReservation.setPaymentStatus(paymentStatus);
			rr.save(approvedReservation);
		}
	}
	
	/* - no longer needed with saveReservationCustomerRoom (below)
	 * 
	public long linkReservationCustomer(Customer customer, Reservation reservation, long roomId) {
		// Create and set customer
		cr.save(customer);
		reservation.setCustomer(customer);
		
		// Link room (must be an existing room with valid id)
		Optional<Room> optionalRoom = roomRepository.findById(roomId);
		if (optionalRoom.isPresent()) {
			reservation.setRooms(List.of(optionalRoom.get()));
		} else {
			System.out.println("Error! Invalid room id in reservation request.");
		}
				
		rr.save(reservation);
		
		return reservation.getId();
	} 
	 *
	 */
	
	public long saveReservationCustomerRoom(Customer customer, Reservation newReservation, long roomId) {	
		// If this reservation is a new addition, the reservationId will be 0 at this point (it hasn't been set)
		// If this is an update, the reservationId will not be 0, indicating which entry needs to be updated
		// In the case of an update, the originally linked customer id needs to be retrieved
		
		long reservationId = newReservation.getId();
		if (reservationId != 0) {
			// Indicates newReservation is an update
			// Retrieve the customer originally linked to the reservation
			Reservation oldReservation = rr.findById(reservationId).get();
			long oldCustomerId = oldReservation.getCustomer().getId();
			customer.setId(oldCustomerId);			
		}
		
		cr.save(customer); // Creates a new customer in database if no id has been set yet, or updates the set id
		newReservation.setCustomer(customer); // Link customer to reservation
		
		// Link room (must be an existing room with valid id)
		Optional<Room> optionalRoom = roomRepository.findById(roomId);
		if (optionalRoom.isPresent()) {
			newReservation.setRooms(List.of(optionalRoom.get()));
		} else {
			System.out.println("Error! Invalid room id in reservation request.");
		}
				
		rr.save(newReservation);
		
		return newReservation.getId();
		
	}

	public Iterable<Reservation> getReservationsByDate(){
		return(rr.reservations());
	}

	public void deleteReservation(long reservationid) {
		rr.deleteById(reservationid);
	}
}
