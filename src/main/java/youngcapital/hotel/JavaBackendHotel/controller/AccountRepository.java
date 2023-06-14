package youngcapital.hotel.JavaBackendHotel.controller;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import youngcapital.hotel.JavaBackendHotel.domain.Account;

import java.util.List;

@Component
public interface AccountRepository extends CrudRepository<Account, Long> {
    @Query(value = "Select * FROM Account WHERE email = ?1", nativeQuery = true)
    List<Account> account(String email);
}
