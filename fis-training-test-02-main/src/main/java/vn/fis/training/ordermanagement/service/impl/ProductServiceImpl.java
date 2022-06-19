package vn.fis.training.ordermanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.fis.training.ordermanagement.domain.Product;
import vn.fis.training.ordermanagement.repository.ProductRepository;
import vn.fis.training.ordermanagement.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
@Autowired
private ProductRepository productRepository;
    @Override
    public Iterable<Product> findTop10ByPrice() {
        productRepository.findTop10ByPrice(100.0, (java.awt.print.Pageable) Pageable.unpaged());
        return null;
    }
}
