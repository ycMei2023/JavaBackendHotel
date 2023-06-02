package youngcapital.hotel.JavaBackendHotel.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import youngcapital.hotel.JavaBackendHotel.domain.Reservation;
import youngcapital.hotel.JavaBackendHotel.domain.Room;

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
		reservation.setRooms(Arrays.asList(optional.get()) );
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

	public void deleteReservation(long reservationid) {
		rr.deleteById(reservationid);
	}
}
