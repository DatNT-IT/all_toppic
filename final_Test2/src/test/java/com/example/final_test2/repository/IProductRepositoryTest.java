package com.example.final_test2.repository;

import com.example.final_test2.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
@Transactional
class IProductRepositoryTest {

    private IProductRepository productRepository;
    @Autowired
    public IProductRepositoryTest(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Test
    void findById() {
        Product product = Product.builder().name("abc").price(125.0).avaiable(1L).build();
        productRepository.save(product);
        log.info("findById Product : {}", productRepository.findById(product.getId()));
    }
}