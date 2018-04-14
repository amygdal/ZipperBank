package io.zipcoder.controller;

import io.zipcoder.domain.Account;
import io.zipcoder.domain.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.Collections.singletonList;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SuppressWarnings("unchecked")
@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerTest{

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountController accountController;

    private Account account;
    private Customer customer;

    @Before
    public void setup() {
        customer = new Customer();
        customer.setId(1L);
        account = new Account();
        account.setId(1L);
        account.setCustomer(customer);
    }

    @Test
    public void getAllAccountsTest() throws Exception {
        Iterable<Account> accounts = singletonList(account);
        ResponseEntity<Iterable<Account>> responseEntity = new ResponseEntity<>(accounts, HttpStatus.OK);
        given(accountController.getAllAccounts()).willReturn(responseEntity);
        mockMvc.perform(get("/accounts").contentType(APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void getAccountByIdTest() throws Exception {
        ResponseEntity responseEntity = new ResponseEntity(customer, HttpStatus.OK);
        given(accountController.getAccountById(account.getId())).willReturn(responseEntity);
        mockMvc.perform(get("/accounts/1").contentType(APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void updateAccountTest() throws Exception {
        Account updateAccount = new Account();
        ResponseEntity responseEntity = new ResponseEntity(updateAccount, HttpStatus.OK);
        given(accountController.updateAccount(1L, updateAccount)).willReturn(responseEntity);
        mockMvc.perform(get("accounts/1").contentType(APPLICATION_JSON)).andExpect(status().isOk());
    }

}
