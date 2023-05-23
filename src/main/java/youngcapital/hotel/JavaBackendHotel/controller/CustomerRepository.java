package youngcapital.hotel.JavaBackendHotel.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import youngcapital.hotel.JavaBackendHotel.domain.Customer;

@Component
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
