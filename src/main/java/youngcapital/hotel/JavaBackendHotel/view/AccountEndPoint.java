package youngcapital.hotel.JavaBackendHotel.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import youngcapital.hotel.JavaBackendHotel.controller.AccountService;
import youngcapital.hotel.JavaBackendHotel.domain.Account;

@RestController
public class AccountEndPoint {
    @Autowired
    AccountService accountService;

    @GetMapping("accounts")
    public Iterable<Account> allAccounts(){
        return accountService.getAllAccounts();
    }
    @PostMapping("addAccount")
    public void addAccount(@RequestBody Account account){
        accountService.saveAccount(account);
    }
}
