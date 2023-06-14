package youngcapital.hotel.JavaBackendHotel.domain;

import at.favre.lib.crypto.bcrypt.BCrypt;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String password;
    private int points;
    private LocalDate birthDate;

    public void encrypt(){
        this.password = BCrypt.withDefaults().hashToString(14, this.password.toCharArray());
        System.out.println(this.password);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean checkPassword(String password) {
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(),this.password);
        return result.verified;
    }
}
