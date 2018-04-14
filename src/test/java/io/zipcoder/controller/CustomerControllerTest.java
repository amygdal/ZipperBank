package io.zipcoder.controller;

import org.junit.runner.RunWith;
import io.zipcoder.domain.Account;
import io.zipcoder.domain.Customer;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.Collections.singletonList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerController customerController;

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

    @Test
    public void getAllCustomersTest() throws Exception {
        Iterable<Customer> customers = singletonList(customer);
        ResponseEntity<Iterable<Customer>> responseEntity = new ResponseEntity<>(customers, HttpStatus.OK);
        given(customerController.getAllCustomers()).willReturn(responseEntity);
        mockMvc.perform(get("/customers").contentType(APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void getCustomerByIdTest() throws Exception {
        ResponseEntity responseEntity = new ResponseEntity(customer, HttpStatus.OK);
        given(customerController.findById(1L)).willReturn(responseEntity);
        mockMvc.perform(get("/customers/1").contentType(APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void createNewCustomerTest() throws Exception {
        String requestBody = objectMapper.writeValueAsString(customer);
        given(customerController.createNewCustomer(customer)).willReturn(mock(ResponseEntity.class));
        mockMvc.perform(post("/customers").contentType(APPLICATION_JSON).content(requestBody)).andExpect(status().isOk());
    }

    @Test
    public void deleteCustomerTest() throws Exception {
        mockMvc.perform(delete("/customers/1").contentType(APPLICATION_JSON)).andExpect(status().isOk());
    }

}
