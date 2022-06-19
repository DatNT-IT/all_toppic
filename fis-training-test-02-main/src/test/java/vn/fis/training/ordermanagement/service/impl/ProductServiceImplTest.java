package vn.fis.training.ordermanagement.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import vn.fis.training.ordermanagement.repository.ProductRepository;
import vn.fis.training.ordermanagement.service.ProductService;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {
@Autowired
private ProductServiceImpl productService;
    @Test
    void findTop10ByPrice() {
     productService.findTop10ByPrice();
    }
}