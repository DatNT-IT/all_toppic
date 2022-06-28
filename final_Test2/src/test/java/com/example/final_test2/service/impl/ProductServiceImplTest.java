package com.example.final_test2.service.impl;

import com.example.final_test2.entity.Product;
import com.example.final_test2.repository.ICustomerRepository;
import com.example.final_test2.repository.IProductRepository;
import com.example.final_test2.service.IProductService;
import com.example.final_test2.service.IcustomerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Transactional
class ProductServiceImplTest {
    @Autowired
    private IProductService productService;
    @Autowired
    private IProductRepository productRepository;
    @Test
    void findById() {
        Product product = Product.builder().name("abc").price(125.0).avaiable(1L).build();
        productRepository.save(product);
        log.info("findById Product : {}", productRepository.findById(product.getId()));
    }

    @Test
    void update() {
        Product product = Product.builder().name("abc").price(125.0).avaiable(1L).build();
        productRepository.save(product);
        log.info("truoc update Product : {}", productRepository.findById(product.getId()));
        Product product1 =  productRepository.findById(product.getId()).get();
        product1.setName("xyz");
        product1.setPrice(543.0);
        productRepository.save(product);
        log.info("sau update Product : {}", productRepository.findById(product.getId()));
    }
}