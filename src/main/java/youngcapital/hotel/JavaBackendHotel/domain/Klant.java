package youngcapital.hotel.JavaBackendHotel.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Klant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	String first_name;
	String last_name;
	Date age;
	String City;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Date getAge() {
		return age;
	}
	public void setAge(Date age) {
		this.age = age;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}

	
}
