package com.example.final_test2.repository;

import com.example.final_test2.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByMobile(String mobile);
}
