package com.example.final_test2.service.impl;

import com.example.final_test2.entity.Customer;
import com.example.final_test2.repository.ICustomerRepository;
import com.example.final_test2.service.IcustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerServiceImpl implements IcustomerService {
    private ICustomerRepository iCustomerRepository;

    @Autowired
    public CustomerServiceImpl(ICustomerRepository iCustomerRepository) {
        this.iCustomerRepository = iCustomerRepository;
    }

    @Override
    public Customer create(Customer customer) {// customerDTO cua e dau e k creat qua dto ok em
        iCustomerRepository.save(customer);//
        return customer;
    }

    @Override
    public Customer findById(Long id) {

        return iCustomerRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        boolean exist = iCustomerRepository.existsById(id);
        if (exist) {
            iCustomerRepository.deleteById(id);
        }
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        log.info("Query all Order. PageNumber: {}, PageSize: {}", pageable.getPageNumber(), pageable.getPageSize());
        return iCustomerRepository.findAll(pageable);
    }


    @Override
    public Customer update(Customer entity) {
        Customer customer = iCustomerRepository.findByMobile(entity.getMobile());
        customer.setAddress(entity.getAddress());
        customer.setMobile(entity.getMobile());
        log.info("Customer update after: {}", iCustomerRepository.save(customer));
        return customer;
    }
}
