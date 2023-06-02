package youngcapital.hotel.JavaBackendHotel.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int roomNumber;
	private int amountPeople;
	private boolean breakfast;
	private boolean business;
	private boolean paymentStatus;
	private float price;
	private float discount;
	private LocalDate beginDate;
	private LocalDate endDate;
	private LocalDate approvalDate;
	
	@ManyToMany(cascade = {CascadeType.ALL}) //in Room is a list named reservations
	private List<Room> rooms;

	public LocalDate getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(LocalDate beginDate) {
		this.beginDate = beginDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalDate getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(LocalDate approvalDate) {
		this.approvalDate = approvalDate;
	}

	public boolean isBusiness() {
		return business;
	}

	public void setBusiness(boolean business) {
		this.business = business;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public boolean isPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public boolean isBreakfast() {
		return breakfast;
	}

	public void setBreakfast(boolean breakfast) {
		this.breakfast = breakfast;
	}

	public int getAmountPeople() {
		return amountPeople;
	}

	public void setAmountPeople(int amountPeople) {
		this.amountPeople = amountPeople;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	public List<Room> getRooms() {
		return rooms;
	}
}
