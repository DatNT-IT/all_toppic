package com.example.final_test2.Controller;

import com.example.final_test2.entity.Product;
import com.example.final_test2.repository.IProductRepository;
import com.example.final_test2.utili.ReadExcelExampleProduct;
import com.example.final_test2.utili.Result;
import com.example.final_test2.utili.WriteExcelExampleProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductRepository productRepository;
    @GetMapping("/write")
    ResponseEntity<Result> writeExcel() throws IOException {
        final List<Product> books = WriteExcelExampleProduct.getBooks();
        final String excelFilePath = "products.xlsx";
        WriteExcelExampleProduct.writeExcel(books, excelFilePath);
        return ResponseEntity.status(HttpStatus.OK).
                body(Result.builder().status("OK").message("output products ").data(books).build());
    }

    @GetMapping("/read")
    ResponseEntity<Result> readExcel() throws IOException{
        final String excelFilePath = "products.xlsx";
        final List<Product> books = new ReadExcelExampleProduct().readExcel(excelFilePath);
        productRepository.deleteAll();
        productRepository.saveAll(books);
        return ResponseEntity.status(HttpStatus.OK).
                body(Result.builder().status("OK").message("input products").data(books).build());
    }
}
