package youngcapital.hotel.JavaBackendHotel.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//Attributes of Room
	private String type;
	private double price;
	private boolean reserved;
	private String date_bookings;
	private int room_no;
	
	//Getters and Setters
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isReserved() {
		return reserved;
	}
	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}
	public String getDate_bookings() {
		return date_bookings;
	}
	public void setDate_bookings(String date_bookings) {
		this.date_bookings = date_bookings;
	}
	public int getRoom_no() {
		return room_no;
	}
	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}
	
	
}
