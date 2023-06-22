package youngcapital.hotel.JavaBackendHotel.controller;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import youngcapital.hotel.JavaBackendHotel.domain.Customer;

import java.util.List;

@Component
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    @Query(value = "Select * FROM Customer WHERE id = ?1", nativeQuery = true)
    List<Customer> getById(long customerId);
}
