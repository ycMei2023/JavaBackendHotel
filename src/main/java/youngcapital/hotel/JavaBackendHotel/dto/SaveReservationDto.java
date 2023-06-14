package youngcapital.hotel.JavaBackendHotel.dto;

import java.time.LocalDate;

public class SaveReservationDto {

	private int amountPeople;
	private boolean breakfast;
	private boolean business;
	private boolean paymentStatus;
	private float price;
	private float discount;
	private LocalDate beginDate;
	private LocalDate endDate;
	
	private String firstName;
	private String lastName;
	
	private long roomId;
	
	private long reservationId;
	
	public boolean isBreakfast() {
		return breakfast;
	}
	public void setBreakfast(boolean breakfast) {
		this.breakfast = breakfast;
	}
	public boolean isBusiness() {
		return business;
	}
	public void setBusiness(boolean business) {
		this.business = business;
	}
	public boolean isPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
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
	public int getAmountPeople() {
		return amountPeople;
	}
	public void setAmountPeople(int amountPeople) {
		this.amountPeople = amountPeople;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getRoomId() {
		return roomId;
	}
	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	public long getReservationId() {
		return reservationId;
	}
	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}
	
}
