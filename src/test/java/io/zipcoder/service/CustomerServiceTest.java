package io.zipcoder.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.zipcoder.domain.Account;
import io.zipcoder.domain.Customer;
import io.zipcoder.services.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerService.class)
public class CustomerServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    private Account account;
    private Customer customer;
    private ObjectMapper objectMapper;

    @Before
    public void setup() {
        customer = new Customer();
        customer.setId(1L);
        account = new Account();
        account.setId(1L);
        account.setCustomer(customer);
        objectMapper = new ObjectMapper();
    }

}
