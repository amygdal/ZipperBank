package io.zipcoder.services;

import io.zipcoder.domain.Customer;
import io.zipcoder.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity getAllControllers() {
        Iterable customers = customerRepository.findAll();
        return new ResponseEntity(customers, HttpStatus.OK);
    }

    public ResponseEntity createNewCustomer(Customer customer) {
        customerRepository.save(customer);
        return new ResponseEntity(customer, HttpStatus.CREATED);
    }

    public ResponseEntity findById(long id) {
        Customer customer = customerRepository.findOne(id);
        return new ResponseEntity(customer, HttpStatus.OK);
    }
}
