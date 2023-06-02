package youngcapital.hotel.JavaBackendHotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	RoomRepository roomRepository;

	public Iterable<Reservation> giveAllReservations() {
		return rr.findAll();
	}

	public void saveReservation(Reservation reservation) {
		Room r = reservation.getRooms().get(0);
		Optional<Room> optional = roomRepository.findById(r.getId());
		reservation.setRooms(List.of(optional.get()));
		rr.save(reservation);
	}

	public void approveReservation(long reservationid) {
		Optional<Reservation> optionalApprovedReservation = rr.findById(reservationid);
		if (optionalApprovedReservation.isPresent()) {
			Reservation approvedReservation = optionalApprovedReservation.get();
			approvedReservation.setApprovalDate(LocalDate.now());
			rr.save(approvedReservation);
		}
	}

	public Iterable<Reservation> getReservationsByDate(){
		System.out.println(rr.reservations());
		return(rr.reservations());
	}

	public void deleteReservation(long reservationid) {
		rr.deleteById(reservationid);
	}
}
