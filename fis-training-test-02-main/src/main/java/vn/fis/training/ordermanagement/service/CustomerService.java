package vn.fis.training.ordermanagement.service;

import vn.fis.training.ordermanagement.domain.Customer;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    void deleteCustomerById(Long customerId);
    Iterable<Customer> findAll();
    Customer findByMobile(String mobile);
}
