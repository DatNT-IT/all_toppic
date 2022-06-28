package com.example.final_test2.service.impl;

import com.example.final_test2.entity.Customer;
import com.example.final_test2.repository.ICustomerRepository;
import com.example.final_test2.service.IcustomerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
@Transactional
class CustomerServiceImplTest {
    @Autowired
    private IcustomerService icustomerService;
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Test
    void create() {
        Customer customer = Customer.builder().name("xyz").mobile("0564215632").build();
        iCustomerRepository.save(customer);
        log.info("creat customer : {}", icustomerService.findById(customer.getId()));
    }

    @Test
    void findById() {
        Customer customer = Customer.builder().name("xyz").mobile("0564215632").build();
        iCustomerRepository.save(customer);
        log.info("find Customer : {}", icustomerService.findById(customer.getId()));
    }

    @Test
    void delete() {
        Customer customer = icustomerService.findById(1L);
        iCustomerRepository.save(customer);
        log.info("delete customer : {}", customer);
        icustomerService.delete(customer.getId());
    }


    @Test
    void update() {
        Customer customer = icustomerService.findById(1L);
        customer.setMobile("0222254620");
        customer.setAddress("abc");
        iCustomerRepository.save(customer);
        log.info("update customer : {}", icustomerService.findById(customer.getId()));
    }


    @Test
    void testFindAll() {
        List<Customer> list = new ArrayList<>();
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        Customer customer3 = new Customer();
        list.add(customer1);
        list.add(customer2);
        list.add(customer3);
        iCustomerRepository.saveAll(list);
        icustomerService.findAll(PageRequest.of(1, list.size()));

    }


}