package com.example.final_test2.Controller;

import com.example.final_test2.entity.Customer;
import com.example.final_test2.repository.ICustomerRepository;
import com.example.final_test2.service.IcustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
@WebMvcTest(CustomerController.class)
@Slf4j
class CustomerControllerTest {
    @MockBean
    private IcustomerService customerService;
    @MockBean
    private ICustomerRepository customerRepository;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void findAll() throws Exception {
        List<Customer> customerList = new ArrayList<>();
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        Customer customer3 = new Customer();
        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);

        Page<Customer> customerPage = new PageImpl<>(customerList);
        Mockito.when(customerService.findAll(PageRequest.of(1, customerList.size())).toList());
        customerPage.forEach(customer -> log.info("Customer in response: {}", customer));
        ResultActions response = mockMvc.perform(get("/api//findAll/{pageNumber}/{pageSize}", 1, customerList.size())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customerList)));

        response.andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        Customer customer = Customer.builder()
                .id(1L)
                .name("abc")
                .mobile("0259874560")
                .address("Ha Noi2")
                .build();

        Mockito.when(customerService.findById(1L)).thenReturn(customer);
        ResultActions response = mockMvc.perform(get("/api/findById/{customerId}", customer.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customer)));
    }

    @Test
    void update() throws Exception {
        Customer  updcatedCustomer = Customer.builder()
                .mobile("0123456789")
                .address("Ha Noi")
                .build();

        Customer customer = Customer.builder()
                .id(2L)
                .name("abc")
                .mobile("0259874560")
                .address("Ha Noi2")
                .build();
        Mockito.when(customerService.update(customer)).thenReturn(updcatedCustomer);
        ResultActions response = mockMvc.perform(put("/api/update/{customerId}", updcatedCustomer.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customer)));

        response.andExpect(status().isOk());
    }

    @Test
    void create() throws Exception {
        Customer customer = Customer.builder()
                .id(2L)
                .name("abc")
                .mobile("0259874560")
                .address("Ha Noi2")
                .build();
        Mockito.when(customerService.create(customer)).thenReturn(customer);
        ResultActions response = mockMvc.perform(post("/api/creat")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customer)));
        response.andExpect(status().isOk());
    }
}