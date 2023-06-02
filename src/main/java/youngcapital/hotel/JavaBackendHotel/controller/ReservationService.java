package youngcapital.hotel.JavaBackendHotel.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import youngcapital.hotel.JavaBackendHotel.domain.Customer;
import youngcapital.hotel.JavaBackendHotel.domain.Reservation;

@Service
public class ReservationService {
	@Autowired
	ReservationRepository rr;
	
	@Autowired
	CustomerRepository cr;

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
	
	public long linkReservationCustomer(Customer customer, Reservation reservation) {
		cr.save(customer);
		reservation.setCustomer(customer);
		rr.save(reservation);
		
		return reservation.getId();
	}

	public void deleteReservation(long reservationid) {
		rr.deleteById(reservationid);
	}
}
