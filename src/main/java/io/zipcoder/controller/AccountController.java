package io.zipcoder.controller;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Customer;
import io.zipcoder.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public ResponseEntity getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @RequestMapping(value = "/accounts/{id}", method = RequestMethod.GET)
    public ResponseEntity getAccountById(@PathVariable Long id){
        return accountService.getById(id);
    }

    @RequestMapping(value = "/accounts/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateAccount(@PathVariable Long id, @RequestBody Account account){
        return accountService.updateAccount(id, account);
    }

    @RequestMapping(value = "/accounts/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteAccount(@PathVariable Long id){
        return accountService.deleteAccount(id);
    }

    @RequestMapping(value = "/accounts/{accountId}/customer", method = RequestMethod.GET)
    public ResponseEntity getAccountCustomer(@PathVariable Long accountId){
        return accountService.getAccountCustomer(accountId);
    }

    @RequestMapping(value = "/customers/{id}/accounts", method = RequestMethod.GET)
    public ResponseEntity getCustomerAccounts(@PathVariable Long id){
        return accountService.getCustomerAccounts(id);
    }

    @RequestMapping(value = "/customers/{id}/accounts", method = RequestMethod.POST)
    public ResponseEntity createCustomerAccount(@PathVariable long id, @RequestBody Account account){
        return accountService.createAccount(id, account);
    }


}
