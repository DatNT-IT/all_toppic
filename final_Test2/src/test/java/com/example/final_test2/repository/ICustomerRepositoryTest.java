package com.example.final_test2.repository;

import com.example.final_test2.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
@Transactional
 class ICustomerRepositoryTest {
    @Autowired
    ICustomerRepository iCustomerRepository;

    @Test
    void findAll() {
        Customer customer = getCustomer();
        iCustomerRepository.save(customer);
        log.info("findAll Customer : {}",iCustomerRepository.findAll(PageRequest.of(1, 10)));
    }

    @Test
    void findById() {
        Customer customer = getCustomer();
        iCustomerRepository.save(customer);
        Customer customer1 = iCustomerRepository.findById(customer.getId()).get();
        log.info("findById Customer : {}",iCustomerRepository.findById(customer.getId()));
        assertEquals("0888585482",customer1.getMobile());
    }

    @Test
    void update() {
        Customer customer = getCustomer();
        iCustomerRepository.save(customer);
        log.info(" trước update Customer : {}",iCustomerRepository.findById(customer.getId()));
        Customer customer1 = iCustomerRepository.findById(customer.getId()).get();
        customer1.setName("xyz");
        iCustomerRepository.save(customer1);
        log.info("sau update Customer : {}",iCustomerRepository.findById(customer1.getId()));
    }

    @Test
    void delete() {
        Customer customer = getCustomer();
        iCustomerRepository.save(customer);
        iCustomerRepository.deleteById(customer.getId());
        List<Customer> result = new ArrayList<>(iCustomerRepository.findAll());
        assertEquals(1, result.size());
    }

    private Customer getCustomer() {
        Customer customer = Customer.builder().mobile("0888585482").address("abc").name("customerTest").build();
        return customer;
    }

    @Test
    void findByMobile() {
        Customer customer = getCustomer();
        iCustomerRepository.save(customer);
        Customer customer1 =iCustomerRepository.findByMobile(customer.getMobile());
        assertEquals(customer.getId(),customer1.getId());
    }
}