package vn.fis.training.ordermanagement.service.impl;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.fis.training.ordermanagement.domain.*;
import vn.fis.training.ordermanagement.repository.OrderRepository;
import vn.fis.training.ordermanagement.service.CustomerService;
import vn.fis.training.ordermanagement.service.OrderService;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OrderServiceImplTest {
    private static final Logger log = LoggerFactory.getLogger(OrderServiceImplTest.class);
    @Autowired
    private OrderService orderService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderRepository orderRepository;
    @Test
    void createOrder() {
        Order order= new Order();
        order.setStatus(OrderStatus.CREATED);
        order.setTotalAmount(123456d);
        order.setOrderDateTime(LocalDateTime.now());
        orderService.createOrder(order);
        assertEquals(3, orderService.findByAll().size());
    }

    @Test
    void addOrderItem() {
        OrderItem orderItem= new OrderItem();
        orderItem.setAmount(123456L);
        orderItem.setQuantity(22d);
        Product product= new Product();
        product.setName("it");
        product.setPrice(3210d);
        orderItem.setProduct(product);
        orderService.addOrderItem(1L,orderItem);
        log.info("them order item :", orderRepository.findOrderById(1L));
    }

    @Test
    void removeOrderItem() {
        OrderItem orderItem= new OrderItem();
        orderItem.setAmount(3210L);
        orderItem.setQuantity(33d);

        orderService.removeOrderItem(1L, orderItem);
        log.info("remove order item :", orderRepository.findOrderById(1L));
    }

    @Test
    void updateOrderStatus() {
        Optional<Order> order= orderRepository.findById(2L);

        orderService.updateOrderStatus(order.get(),OrderStatus.APPROVED);

        assertEquals(OrderStatus.APPROVED, order.get().getStatus());
    }

    @Test
    void findOrdersBetween() {
        assertEquals(2, orderService.findOrdersBetween(LocalDateTime.of(2022,02,
                22,22,22,22),LocalDateTime.of(2022,03,22,22,
                22,22)).size());
    }

    @Test
    void findWaitingApprovalOrders() {
        assertEquals(0, orderService.findWaitingApprovalOrders());
    }

    @Test
    void findByAll() {
        assertEquals(5, orderRepository.findAll().size());

    }

    @Test
    void findOrdersByOrderStatus() {
        assertEquals(2, orderService.findOrdersByOrderStatus(OrderStatus.CREATED));
    }

    @Test
    void findOrdersByCustomer() {
        Customer customer = customerService.findByMobile("03568432102");
        assertEquals(2, orderService.findOrdersByCustomer(customer).size());
    }
}