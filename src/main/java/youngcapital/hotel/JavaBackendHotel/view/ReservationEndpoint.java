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
import youngcapital.hotel.JavaBackendHotel.domain.Customer;
import youngcapital.hotel.JavaBackendHotel.domain.Reservation;
import youngcapital.hotel.JavaBackendHotel.dto.SaveReservationDto;

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
	
	@PostMapping("addlinkedreservation")
	public long addReservation(@RequestBody SaveReservationDto saveReservationDto) {
		Customer customer = new Customer();
		customer.setFirstName(saveReservationDto.getFirstName());
		customer.setLastName(saveReservationDto.getLastName());
		
		Reservation reservation = new Reservation();
		reservation.setAmountPeople(saveReservationDto.getAmountPeople());
		reservation.setBeginDate(saveReservationDto.getBeginDate());
		reservation.setEndDate(saveReservationDto.getEndDate());
		reservation.setBreakfast(saveReservationDto.isBreakfast());
		reservation.setBusiness(saveReservationDto.isBusiness());
		return rr.linkReservationCustomer(customer, reservation);
		//reservation.setPaymentStatus(saveReservationDto.isPaymentStatus());
	}
	@PutMapping("changereservation")
	public void changeReservation(@RequestBody Reservation reservation) {
		rr.saveReservation(reservation);
	}

	@PutMapping("approvereservation/{paymentStatus}")
	public void approveReservation(@RequestBody long reservationid, @PathVariable("paymentStatus") boolean paymentStatus) {
		rr.approveReservation(reservationid, paymentStatus);
	}

	@DeleteMapping("deletereservation/{reservationid}")
	public void deleteReservation(@PathVariable("reservationid") long reservationid) {
		rr.deleteReservation(reservationid);
	}

}
