package com.example.final_test2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOrderItemDTO {
    private Long orderId;
    private Long productId;
    private Integer quantity;
}
