package com.example.final_test2.dto;

import com.example.final_test2.core.OrderStatus;
import com.example.final_test2.entity.Customer;
import com.example.final_test2.entity.Order;
import com.example.final_test2.entity.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {

    private Long id;

    private LocalDateTime orderDateTime;

    private Long customerId;

    private List<OrderItem> orderItems;

    private Double totalAmount;

    private OrderStatus status;

    public static class Mapper {
        public static OrderDTO fromEntity(Order order) {
            return OrderDTO.builder().id(order.getId())
                    .orderDateTime(order.getOrderDateTime())
                    .orderItems(order.getOrderItems())
                    .customerId(order.getCustomer().getId())
                    .totalAmount(order.getTotalAmount())
                    .status(order.getStatus())
                    .build();
        }
    }
}
