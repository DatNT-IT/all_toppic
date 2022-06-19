package vn.fis.training.ordermanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fis.training.ordermanagement.domain.Customer;
import vn.fis.training.ordermanagement.repository.CustomerRepository;
import vn.fis.training.ordermanagement.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        if (customerRepository.findById(customer.getId()).isPresent()) {
            Customer customer1 = customerRepository
                    .findById(customer.getId()).get();
            if (!customer.getAddress().trim().isEmpty()) {
                customer1.setAddress(customer.getAddress());
            }

            return  customerRepository.save(customer1);
        }
        return null;
    }

    @Override
    public void deleteCustomerById(Long customerId) {
        boolean exist = customerRepository.existsById(customerId);
        if (exist) {
            customerRepository.deleteById(customerId);
        }
    }

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findByMobile(String mobile) {
        return customerRepository.findByMobile(mobile);
    }

}
