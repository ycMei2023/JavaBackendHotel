package youngcapital.hotel.JavaBackendHotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import youngcapital.hotel.JavaBackendHotel.domain.Customer;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository wr;
	
	
	public Iterable<Customer> giveAllCustomers() {
		return wr.findAll();
	}


	public void saveCustomer(Customer customer) {
		wr.save(customer);
		
	}


	public void deleteCustomer(long id) {
		wr.deleteById(id);
	}
	
}
