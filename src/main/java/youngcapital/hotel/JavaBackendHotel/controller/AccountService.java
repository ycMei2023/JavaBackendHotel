package youngcapital.hotel.JavaBackendHotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import youngcapital.hotel.JavaBackendHotel.domain.Account;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public Iterable<Account> getAllAccounts(){ return accountRepository.findAll();}

    public void saveAccount(Account account){
        account.encrypt();
        accountRepository.save(account);
    }

    public Iterable<Account>getAccount(String email){
       return accountRepository.account(email);
    }
}
