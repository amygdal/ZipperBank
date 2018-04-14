package io.zipcoder.controller;

import io.zipcoder.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public ResponseEntity getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @RequestMapping(value = "/accounts/{accountid}", method = RequestMethod.GET)
    public ResponseEntity getAccountById(@PathVariable Long id){
        return accountService.getById(id);
    }

}
