package vn.fis.training.ordermanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fis.training.ordermanagement.domain.Customer;
import vn.fis.training.ordermanagement.domain.Order;
import vn.fis.training.ordermanagement.domain.OrderItem;
import vn.fis.training.ordermanagement.domain.OrderStatus;
import vn.fis.training.ordermanagement.repository.OrderRepository;
import vn.fis.training.ordermanagement.service.OrderService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;


    @Override
    public Order createOrder(Order order) {
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order addOrderItem(Long id,OrderItem orderItem) {
        Optional<Order> order= orderRepository.findById(id);
        order.get().getOrderItems().add(orderItem);
        Double amount;
        amount= order.get().getTotalAmount() + (orderItem.getAmount() * orderItem.getQuantity());
        order.get().setTotalAmount(amount );
        orderRepository.save(order.get());
        return order.get();


    }

    @Override
    public Order removeOrderItem(Long id,OrderItem orderItem) {
        //TODO
        boolean exist = orderRepository.existsById(id);
        if (exist) {
            Optional<Order> order= orderRepository.findById(id);
            order.get().getOrderItems().remove(orderItem);
            Double amount;
            amount= order.get().getTotalAmount() + (orderItem.getAmount() * orderItem.getQuantity());
            order.get().setTotalAmount(amount);
            orderRepository.save(order.get());
            return order.get();
        }
        return null;
    }

    @Override
    public Order updateOrderStatus(Order order,OrderStatus orderStatus) {

        Order updateOder = orderRepository.findById(order.getId()).map(order2 -> {
            order2.setStatus(orderStatus);

            return orderRepository.save(order2);
        }).orElseGet(() -> {
            return null;
        });

        return updateOder;
    }

    @Override
    public List<Order> findOrdersBetween(LocalDateTime fromDateTime, LocalDateTime toDateTime) {
        return (List<Order>) orderRepository.findByOrderDateTimeBetween(fromDateTime,toDateTime);

    }

    @Override
    public List<Order> findWaitingApprovalOrders() {

        return (List<Order>) orderRepository.findByStatus(OrderStatus.WAITING_APPROVAL);
    }

    @Override
    public List<Order> findByAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> findOrdersByOrderStatus(OrderStatus orderStatus) {
        return orderRepository.findByStatusEquals(orderStatus);
    }

    @Override
    public List<Order> findOrdersByCustomer(Customer customer) {
        return orderRepository.findByCustomerIdEquals(customer);
    }


}
