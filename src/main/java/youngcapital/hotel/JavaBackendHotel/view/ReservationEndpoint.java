package youngcapital.hotel.JavaBackendHotel.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

	@GetMapping("reservationsByDate")
	public Iterable<Reservation> reservationsByDate(){return rr.getReservationsByDate();}

	@PostMapping("addreservation")
	public void addReservation(@RequestBody Reservation reservation) {
		rr.saveReservation(reservation);
	}
	
	@PostMapping("addLinkedReservation")
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
		
		long roomId = saveReservationDto.getRoomId();
		
		return rr.saveReservationCustomerRoom(customer, reservation, roomId);
		//reservation.setPaymentStatus(saveReservationDto.isPaymentStatus());
	}
	@PutMapping("changereservation")
	public void changeReservation(@RequestBody Reservation reservation) {
		rr.saveReservation(reservation);
	}
	
	@PutMapping("changeLinkedReservation")
	public void changeReservation(@RequestBody SaveReservationDto saveReservationDto) {
		Customer customer = new Customer();
		customer.setFirstName(saveReservationDto.getFirstName());
		customer.setLastName(saveReservationDto.getLastName());
		
		Reservation reservation = new Reservation();
		reservation.setAmountPeople(saveReservationDto.getAmountPeople());
		reservation.setBeginDate(saveReservationDto.getBeginDate());
		reservation.setEndDate(saveReservationDto.getEndDate());
		reservation.setBreakfast(saveReservationDto.isBreakfast());
		reservation.setBusiness(saveReservationDto.isBusiness());
		reservation.setId(saveReservationDto.getReservationId());
		
		long roomId = saveReservationDto.getRoomId();
		
		rr.saveReservationCustomerRoom(customer, reservation, roomId);
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
