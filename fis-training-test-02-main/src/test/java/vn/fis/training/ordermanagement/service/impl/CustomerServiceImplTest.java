package vn.fis.training.ordermanagement.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.fis.training.ordermanagement.domain.Customer;
import vn.fis.training.ordermanagement.repository.CustomerRepository;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerServiceImplTest {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerServiceImpl customerService;
    @Test
    void createCustomer() {
        Customer customer = new Customer("nguyen van b","0987564555","ha noi");
        customerService.createCustomer(customer);
        assertEquals("nguyen van b",customer.getName());
    }

    @Test
    void updateCustomer() {
        Customer customer = customerRepository.findById(1L).get();
        customer.setAddress("HCM");
        customerService.updateCustomer(customer);
        assertEquals("HCM",customer.getAddress());
    }

    @Test
    void deleteCustomerById() {
        boolean exist = customerRepository.existsById(2L);
        if (exist) {
            customerService.deleteCustomerById(2L);
        }
    }

    @Test
    void findAll() {
        assertEquals(5, customerRepository.findAll().size());

    }

    @Test
    void findByMobile() {
        Customer customer = customerRepository.findById(1L).get();
        assertNotEquals("0259846325",customerService.findByMobile(customer.getMobile()));
    }
}