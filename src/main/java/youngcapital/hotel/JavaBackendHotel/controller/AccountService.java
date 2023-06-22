package youngcapital.hotel.JavaBackendHotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import youngcapital.hotel.JavaBackendHotel.domain.Account;
import youngcapital.hotel.JavaBackendHotel.domain.Reservation;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ReservationRepository reservationRepository;

    public Iterable<Account> getAllAccounts(){ return accountRepository.findAll();}

    public void saveAccount(Account account){
        account.encrypt();
        account.insertCustomer();
        accountRepository.save(account);
    }

    public Iterable<Reservation> getAccountReservations(Account account){
        return reservationRepository.getByAccount(account.getCustomer().getId());
    }

    public Iterable<Account>getAccount(String email){
       return accountRepository.account(email);
    }
}
