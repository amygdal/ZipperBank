package io.zipcoder.controller;

import io.zipcoder.domain.Customer;
import io.zipcoder.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity getAllCustomers(){
        return customerService.getAllControllers();
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public ResponseEntity createNewCustomer(Customer customer){
        return customerService.createNewCustomer(customer);
    }
}
