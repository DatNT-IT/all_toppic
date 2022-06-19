package vn.fis.training.ordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.fis.training.ordermanagement.domain.Customer;
import vn.fis.training.ordermanagement.domain.Order;
import vn.fis.training.ordermanagement.domain.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Iterable<Order> findByOrderDateTimeBetween(LocalDateTime start, LocalDateTime end);
    Iterable<Order> findByStatus(OrderStatus orderStatus);
    Order findOrderById(Long id);
    List<Order> findByStatusEquals(OrderStatus status);
    List<Order> findByCustomerIdEquals(Customer customer);
}
