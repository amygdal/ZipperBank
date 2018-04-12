package io.zipcoder.services;

import io.zipcoder.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public ResponseEntity getAllAccounts(){
        Iterable accounts = accountRepository.findAll();
        return new ResponseEntity(accounts, HttpStatus.OK);
    }

}
