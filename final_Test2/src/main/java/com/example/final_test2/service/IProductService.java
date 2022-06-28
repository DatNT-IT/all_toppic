package com.example.final_test2.service;

import com.example.final_test2.entity.Product;

public interface IProductService {
    Product findById(Long productId);
    Product update(Product product);
}
