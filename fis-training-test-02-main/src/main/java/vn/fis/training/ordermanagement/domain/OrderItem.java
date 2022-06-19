package vn.fis.training.ordermanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name="tbl_order_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
    @Min(0)
    @Max(20)
    transient private Long amount;
    @Min(0)
   transient private Double quantity;

    public OrderItem(Order order, Product product, Long amount, Double quantity) {
        this.order = order;
        this.product = product;
        this.amount = amount;
        this.quantity = quantity;
    }
}
