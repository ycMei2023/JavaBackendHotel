package youngcapital.hotel.JavaBackendHotel.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import youngcapital.hotel.JavaBackendHotel.controller.AccountService;
import youngcapital.hotel.JavaBackendHotel.domain.Account;
import youngcapital.hotel.JavaBackendHotel.domain.Reservation;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@RestController
public class AccountEndPoint {
    @Autowired
    AccountService accountService;

    @GetMapping("accounts")
    public Iterable<Account> allAccounts(){
        return accountService.getAllAccounts();
    }

    @PostMapping("accountReservations")
    public Iterable<Reservation> accountReservations(@RequestBody Account account){
        Account user =  accountService.getAccount(account.getEmail()).iterator().next();
        return accountService.getAccountReservations(user);}

    @PostMapping("addAccount")
    public void addAccount(@RequestBody Account account){
        accountService.saveAccount(account);
    }

    @PostMapping("login")
    public Account CheckPassword(@RequestBody Account account) throws IOException {
        Account user =  accountService.getAccount(account.getEmail()).iterator().next();
        if(user.checkPassword(account.getPassword())){
            doesLowCodeHaveUser(account.getEmail());
            return user;
        }
        else{ return new Account();}
    }

    public void doesLowCodeHaveUser(String Email) throws IOException {
        URL url = new URL("https://personal-d2ikou7t.outsystemscloud.com/FawltyHotel_Rest/rest/CustomerExistCheck/CustomerExistEmail");
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestProperty("Email", Email);
        System.out.println(http.getResponseCode()+" "+http.getResponseMessage()+" "+http.getHeaderField("Exists"));
        http.disconnect();
    }
}
