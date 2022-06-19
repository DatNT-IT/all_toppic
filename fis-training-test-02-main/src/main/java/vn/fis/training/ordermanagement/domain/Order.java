package vn.fis.training.ordermanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="tbl_order")
@Data
@NoArgsConstructor
@ToString
@NamedQuery(name = "Order.findByStatusEquals",
        query = "select o from Order o where o.status = ?1")
@NamedQuery(name = "Order.findByCustomerEquals",
        query = "select o from Order o where Customer = ?1")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="order_datetime")
    private LocalDateTime orderDateTime;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    @Column(name="totalAmount")

    private Double totalAmount;

    /**
     * Bao gom cac trang thai duoc dinh nghia trong OrderStatus Class
     */
    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Order(LocalDateTime orderDateTime, Customer customer, List<OrderItem> orderItems, Double totalAmount, OrderStatus status) {
        this.orderDateTime = orderDateTime;
        this.customer = customer;
        this.orderItems = orderItems;
        this.totalAmount = totalAmount;
        this.status = status;
    }
}
