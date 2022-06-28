package com.example.final_test2.Controller;

import com.example.final_test2.core.OrderStatus;
import com.example.final_test2.entity.Customer;
import com.example.final_test2.entity.Order;
import com.example.final_test2.service.IcustomerService;
import com.example.final_test2.utili.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@Slf4j
public class CustomerController {
    private IcustomerService customerService;

    @Autowired
    public CustomerController(IcustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/findAll/{pageNumber}/{pageSize}")
    public Page<Customer> findAll(@PathVariable Integer pageNumber
            , @PathVariable Integer pageSize) {
        log.info("Request All Order. PageNumber: {}, PageSize: {}", pageNumber, pageSize);
        return customerService.findAll(PageRequest.of(pageNumber, pageSize));
    }

    @GetMapping("/findById/{customerId}")
    ResponseEntity<Result> findById(@PathVariable(name = "customerId") Long customerId) {
        Customer customer = customerService.findById(customerId);
        return (customer != null) ? ResponseEntity.status(HttpStatus.OK).
                body(Result.builder().status("OK").message("tim thay customer").data(customer).build()) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).
                        body(Result.builder().status("NO").message("khong tim thay customer").data("").build());
    }


    @PutMapping("/update/{customerId}")
    ResponseEntity<Result> update(@PathVariable Long customerId, @RequestBody Customer customer) {

        Customer updatedCustomer = customerService.update(customer);

        return ResponseEntity.status(HttpStatus.OK).
                body(Result.builder().status("OK").message("update Customer").data(updatedCustomer).build());
    }

   @PostMapping("/creat")
   ResponseEntity<Result> create(@RequestBody Customer customer) {
       customerService.create(customer);
       return ResponseEntity.status(HttpStatus.OK).
               body(Result.builder().status("OK").message("create order").data(customer).build());
   }
}
