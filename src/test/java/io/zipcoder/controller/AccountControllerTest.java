package io.zipcoder.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.zipcoder.domain.Account;
import io.zipcoder.domain.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.Collections.singletonList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
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

    private Account mockAccount;
    private ObjectMapper om = new ObjectMapper();

    @Before
    public void setup() {
        Customer mockCustomer = new Customer();
        mockCustomer.setId(1L);

        mockAccount = new Account();
        mockAccount.setId(1L);
        mockAccount.setCustomer(mockCustomer);
    }

    @Test
    public void getAllAccounts() throws Exception {
        Iterable<Account> accounts = singletonList(mockAccount);
        ResponseEntity<Iterable<Account>> response = new ResponseEntity<>(accounts, HttpStatus.OK);

        given(accountController.getAllAccounts())
                .willReturn(response);

        mockMvc.perform(get("/accounts")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
