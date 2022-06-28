package com.example.final_test2.service.impl;

import com.example.final_test2.core.OrderStatus;
import com.example.final_test2.dto.CreateOrderItemDTO;
import com.example.final_test2.dto.OrderDTO;
import com.example.final_test2.dto.RemoveItemDTO;
import com.example.final_test2.entity.Customer;
import com.example.final_test2.entity.Order;
import com.example.final_test2.entity.OrderItem;
import com.example.final_test2.entity.Product;
import com.example.final_test2.repository.IOrderItemRepository;
import com.example.final_test2.repository.IOrderRepository;
import com.example.final_test2.repository.IProductRepository;
import com.example.final_test2.service.IOrderService;
import com.example.final_test2.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class OrderServiceImpl implements IOrderService {

    private IProductRepository productRepository;

    private IOrderRepository orderRepository;

    private IOrderItemRepository orderItemRepository;

    private IProductService productService;

    @Autowired
    public OrderServiceImpl(IOrderRepository orderRepository, IProductRepository productRepository,
                            IOrderItemRepository orderItemRepository,IProductService productService) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.orderItemRepository=orderItemRepository;
        this.productService=productService;
    }

    @Override
    public Order create(Order entity) {
        Product product = productService.findById(1L);
        List<OrderItem> list = new ArrayList<>();
        OrderItem orderItem = OrderItem.builder()
                .product(product)
                .build();
        list.add(orderItem);
        Order order = Order.builder().orderDateTime(entity.getOrderDateTime()).customer(entity.getCustomer()).
                status(entity.getStatus()).orderItems(list).status(OrderStatus.CREATED).build();
        orderRepository.save(entity);
        return order;
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        boolean exist = orderRepository.existsById(id);
        if (exist) {
            orderRepository.deleteById(id);
        }
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        log.info("Query all Order. PageNumber: {}, PageSize: {}", pageable.getPageNumber(), pageable.getPageSize());
        return orderRepository.findAll(pageable);
    }

    @Override
    public Order update(Order entity) {
       Order order = orderRepository.findById(entity.getId()).get();
       order.setOrderItems(entity.getOrderItems());
       order.setOrderDateTime(entity.getOrderDateTime());
       order.setCustomer(entity.getCustomer());
       order.setStatus(entity.getStatus());
       order.setTotalAmount(entity.getTotalAmount());
       return order;
    }

    @Override
    public Order addOrderItem(CreateOrderItemDTO createOrderItemDTO) {
        Order order = orderRepository.findById(createOrderItemDTO.getOrderId()).orElseThrow(
                () -> new IllegalArgumentException("Order Not Found. Order Id " + createOrderItemDTO.getOrderId()));
        Product product = productRepository.findById(createOrderItemDTO.getProductId()).orElseThrow(
                () -> new IllegalArgumentException("Product Not Found. Product Id " + createOrderItemDTO.getProductId()));

        OrderItem orderItem = OrderItem.builder().order(order)
                .product(product)
                .quantity(Long.valueOf(createOrderItemDTO.getQuantity()))
                .amount(product.getPrice() * createOrderItemDTO.getQuantity())
                .build();
        order.getOrderItems().add(orderItem);
        order.setTotalAmount(order.getOrderItems().stream().mapToDouble(value -> value.getAmount()).reduce(0, (aone, atwo) -> aone + atwo));
        return order;
    }

    @Override
    public Order removeOrderItem(RemoveItemDTO removeItemDTO) {
        Order order = findById(removeItemDTO.getOrderId());
        OrderItem orderItem = orderItemRepository.findById(removeItemDTO.getOrderItemId()).get();
        order.setTotalAmount(order.getTotalAmount() - orderItem.getAmount());
        Product product = productService.findById(orderItem.getProduct().getId());
        product.setAvaiable(product.getAvaiable() + orderItem.getQuantity());
        orderItemRepository.deleteById(removeItemDTO.getOrderItemId());

        return findById(removeItemDTO.getOrderId());
    }

    @Override
    public Order paid(Long id) {
        Order order = findById(id);
        if (order.getStatus().equals(OrderStatus.CREATED)){
            order.setStatus(OrderStatus.PAID);
        }
        return order;
    }

    @Override
    public Order cancel(Long id) {
        Order order = findById(id);
        if (order.getStatus().equals(OrderStatus.CREATED)){
            order.setStatus(OrderStatus.CANCELLED);
        }
        return order;
    }


}
