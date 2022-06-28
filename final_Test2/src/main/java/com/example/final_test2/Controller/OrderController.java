package com.example.final_test2.Controller;

import com.example.final_test2.core.OrderStatus;
import com.example.final_test2.dto.CreateOrderItemDTO;
import com.example.final_test2.dto.RemoveItemDTO;
import com.example.final_test2.entity.Order;
import com.example.final_test2.service.IOrderService;
import com.example.final_test2.utili.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@Slf4j
public class OrderController {
    private IOrderService orderService;

    @Autowired
    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/findAll/{pageNumber}/{pageSize}")
    public Page<Order> findAll(@PathVariable Integer pageNumber, @PathVariable Integer pageSize) {
        log.info("Request All Order. PageNumber: {}, PageSize: {}", pageNumber, pageSize);
        return orderService.findAll(PageRequest.of(pageNumber, pageSize));
    }

    @GetMapping("/findById/{orderId}")
    ResponseEntity<Result> findById(@PathVariable Long orderId) {
        Order order = orderService.findById(orderId);
        return (order != null) ? ResponseEntity.status(HttpStatus.OK).
                body(Result.builder().status("OK").message("tim thay order").data(order).build()) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).
                        body(Result.builder().status("NO").message("khong tim thay order").data("").build());
    }

    @PostMapping("/creat")
    ResponseEntity<Result> create(@RequestBody Order order) {
        orderService.create(order);
        return ResponseEntity.status(HttpStatus.OK).
                body(Result.builder().status("OK").message("create order").data(order).build());
    }

    @DeleteMapping("/delete/{orderId}")
    ResponseEntity<Result> deleteOrder(@PathVariable Long orderId) {
        Order order = orderService.findById(orderId);

        if (order.getStatus() == OrderStatus.CREATED || order.getStatus() == OrderStatus.CANCELLED) {
            orderService.delete(order.getId());
            return ResponseEntity.status(HttpStatus.OK).
                    body(Result.builder().status("OK").message("delete order").data(order).build());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).
                body(Result.builder().status("NO").message("no delete order").data(order).build());
    }

    @PostMapping("/addOrderItem")
    ResponseEntity<Result> addOrderItem(@RequestBody CreateOrderItemDTO createOrderItemDTO) {
        Order order = orderService.addOrderItem(createOrderItemDTO);
        log.info("Order (Added new OrderItem): {}", order);
        return ResponseEntity.status(HttpStatus.OK).
                body(Result.builder().status("OK").message("addOrderItem order").data(order).build());
    }

    @PostMapping("/removeOrderItem")
    ResponseEntity<Result> removeOrderItem(@RequestBody RemoveItemDTO removeItemDTO) {
        log.info("Remove Item: {}", removeItemDTO);
        Order order = orderService.removeOrderItem(removeItemDTO);
        log.info("Order (Removed): {}", order);
        return ResponseEntity.status(HttpStatus.OK).
                body(Result.builder().status("OK").message("removeOrderItem order").data(order).build());
    }


    @PostMapping("/paid/{orderId}")
    ResponseEntity<Result> paid(@PathVariable Long orderId) {
        Order order = orderService.findById(orderId);
        if (order != null) {
            orderService.paid(order.getId());
            return ResponseEntity.status(HttpStatus.OK).
                    body(Result.builder().status("OK").message("Paid customer").data(order).build());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).
                body(Result.builder().status("NO").message("Paid customer no").data("").build());
    }

    @PostMapping("/cancel/{orderId}")
    ResponseEntity<Result> cancel(@PathVariable Long orderId) {
        Order order = orderService.findById(orderId);
        if (order != null) {
            orderService.cancel(order.getId());
            return ResponseEntity.status(HttpStatus.OK).
                    body(Result.builder().status("OK").message("cancel customer").data(order).build());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).
                body(Result.builder().status("NO").message("cancel customer no").data("").build());
    }
}
