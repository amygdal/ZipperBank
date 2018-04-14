package io.zipcoder.services;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Customer;
import io.zipcoder.repository.AccountRepository;
import io.zipcoder.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    CustomerRepository customerRepository;

    public ResponseEntity getAllAccounts(){
        Iterable accounts = accountRepository.findAll();
        return new ResponseEntity(accounts, HttpStatus.OK);
    }

    public ResponseEntity getById(Long id){
        Account account = accountRepository.findOne(id);
        return new ResponseEntity(account, HttpStatus.OK);
    }

    public ResponseEntity createAccount(Long id, Account account){
        Customer customer = customerRepository.findOne(id);
        account.setCustomer(customer);
        accountRepository.save(account);
        return new ResponseEntity(account, HttpStatus.CREATED);
    }

    public ResponseEntity getCustomerAccounts(Long id){
        return null;
    }

}
