package com.example.final_test2.service;

import com.example.final_test2.dto.CreateOrderItemDTO;
import com.example.final_test2.dto.RemoveItemDTO;
import com.example.final_test2.entity.Order;

public interface IOrderService extends IAbstractService<Order> {
    Order addOrderItem(CreateOrderItemDTO createOrderItemDTO);

    Order removeOrderItem(RemoveItemDTO removeItemDTO);

    Order paid(Long id);

    Order cancel(Long id);
}
