package com.example.noronapp.data.mappers;

import com.example.noronapp.data.model.Order;
import com.example.noronapp.data.response.OrderResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderResponse orderToOrderDto(Order order);

    Order orderDtoToOrder(OrderResponse orderResponse);

    List<OrderResponse> ordersToOrderDtos (List<Order> orders);

}
