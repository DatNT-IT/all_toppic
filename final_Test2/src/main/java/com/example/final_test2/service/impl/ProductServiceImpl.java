package com.example.final_test2.service.impl;

import com.example.final_test2.entity.Product;
import com.example.final_test2.repository.IProductRepository;
import com.example.final_test2.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceImpl implements IProductService {

    private IProductRepository productRepository;

    public ProductServiceImpl(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findById(Long productId) {
        log.info("Product with id : {}", productRepository.findById(productId));
        return productRepository.findById(productId).get();
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }
}
