package com.example.final_test2.repository;

import com.example.final_test2.core.OrderStatus;
import com.example.final_test2.entity.Customer;
import com.example.final_test2.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
@Transactional
class IOrderRepositoryTest {
    @Autowired
    IOrderRepository iOrderRepository;

    @Test
    void findAll() {
        Order order = getOrder();
        iOrderRepository.save(order);
        log.info("findAll Order : {}", iOrderRepository.findAll(PageRequest.of(1, 10)));
    }

    @Test
    void findById() {
        Order order = getOrder();
        iOrderRepository.save(order);
        Order order1 = iOrderRepository.findById(order.getId()).get();
        log.info("findById Order : {}", iOrderRepository.findById(order.getId()));
        assertEquals("2022-06-06 12:12:12", order1.getOrderDateTime());
    }

    @Test
    void update() {
        Order order = getOrder();
        iOrderRepository.save(order);
        log.info(" trước update Order : {}", iOrderRepository.findById(order.getId()));
        Order order1 = iOrderRepository.findById(order.getId()).get();
        order1.setOrderDateTime(LocalDateTime.parse("2022-07-07 12:12:12"));
        iOrderRepository.save(order);
        log.info("sau update Order : {}", iOrderRepository.findById(order1.getId()));
    }

    @Test
    void delete() {
        Order order = getOrder();
        iOrderRepository.save(order);
        iOrderRepository.deleteById(order.getId());
        List<Order> result = new ArrayList<>(iOrderRepository.findAll());
        assertEquals(1, result.size());
    }

    private Order getOrder() {
        Customer customer = Customer.builder().mobile("0888585482").address("abc").name("customerTest").build();
        Order order = Order.builder().status(OrderStatus.CREATED).customer(customer).orderDateTime(LocalDateTime.parse("2022-06-06 12:12:12")).build();
        return order;
    }
}