package youngcapital.hotel.JavaBackendHotel.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import youngcapital.hotel.JavaBackendHotel.domain.Account;

@Component
public interface AccountRepository extends CrudRepository<Account, Long> {
}
