package io.zipcoder.controller;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Customer;
import io.zipcoder.services.AccountService;
import io.zipcoder.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity getAllCustomers(){
        return customerService.getAllControllers();
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public ResponseEntity createNewCustomer(@RequestBody Customer customer){
        return customerService.createNewCustomer(customer);
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public ResponseEntity findById(@PathVariable long id){
        return customerService.findById(id);
    }

    @RequestMapping(value = "/customers/{id}/accounts", method = RequestMethod.GET)
    public ResponseEntity getCustomerAccounts(@PathVariable Long id){
        return accountService.getCustomerAccounts(id);
    }

    @RequestMapping(value = "/customers/{id}/accounts", method = RequestMethod.POST)
    public ResponseEntity createCustomerAccount(@PathVariable long id, @RequestBody Account account){
        return accountService.createAccount(id, account);
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.PUT)
    public ResponseEntity deleteCustomer(@PathVariable Long id){
        return customerService.deleteCustomer(id);
    }
}
