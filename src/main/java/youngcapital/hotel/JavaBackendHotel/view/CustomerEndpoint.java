package youngcapital.hotel.JavaBackendHotel.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import youngcapital.hotel.JavaBackendHotel.controller.CustomerService;
import youngcapital.hotel.JavaBackendHotel.domain.Customer;

@RestController
public class CustomerEndpoint {

	@Autowired
	CustomerService ws;
	
	@GetMapping("thecustomer")
	public Iterable<Customer> allCustomers() {
		return ws.giveAllCustomers();
	}
	
	@PostMapping("addcustomer")
	public void addCustomer(@RequestBody Customer customer) {
		ws.saveCustomer(customer);
	}
	
	@DeleteMapping("deletecustomer/{id}")
	public void deleteCustomer(@PathVariable("id") int id) {
		ws.deleteCustomer(id);
	}
	
	
	
}
