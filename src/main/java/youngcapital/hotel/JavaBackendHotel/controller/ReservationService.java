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

		//Part of the below code is to create links to Room in Reservation
		
		//Room r = reservation.getRooms().get(0);
		//Optional<Room> optional = roomRepository.findById(r.getId());
		//reservation.setRooms(List.of(optional.get()));

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
	
	public long linkReservationCustomer(Customer customer, Reservation reservation) {
		cr.save(customer);
		reservation.setCustomer(customer);
		rr.save(reservation);
		
		return reservation.getId();
	}

	public Iterable<Reservation> getReservationsByDate(){
		System.out.println(rr.reservations());
		return(rr.reservations());
	}

	public void deleteReservation(long reservationid) {
		rr.deleteById(reservationid);
	}
}
