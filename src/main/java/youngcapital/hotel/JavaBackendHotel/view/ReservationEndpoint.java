package youngcapital.hotel.JavaBackendHotel.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import youngcapital.hotel.JavaBackendHotel.controller.ReservationService;
import youngcapital.hotel.JavaBackendHotel.domain.Reservation;

@RestController
public class ReservationEndpoint {
	@Autowired
	ReservationService rr;

	@GetMapping("reservations")
	public Iterable<Reservation> allReservations() {
		return rr.giveAllReservations();
	}

	@PostMapping("addreservation")
	public void addReservation(@RequestBody Reservation reservation) {
		rr.saveReservation(reservation);
	}

	@PutMapping("changereservation")
	public void changeReservation(@RequestBody Reservation reservation) {
		rr.saveReservation(reservation);
	}

	@PutMapping("approvereservation")
	public void approveReservation(@RequestBody long reservationid) {
		rr.approveReservation(reservationid);
	}

	@DeleteMapping("deletereservation/{reservationid}")
	public void deleteReservation(@PathVariable("reservationid") long reservationid) {
		rr.deleteReservation(reservationid);
	}

}
