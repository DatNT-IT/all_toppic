package com.example.final_test2.entity;

import com.example.final_test2.core.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Order{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "order_datetime")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:MM:ss")
    private LocalDateTime orderDateTime;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    @Column(name = "total_amount")
    private Double totalAmount;

    @NotNull
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
