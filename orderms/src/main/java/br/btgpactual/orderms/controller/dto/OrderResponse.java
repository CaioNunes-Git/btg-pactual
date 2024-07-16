package br.btgpactual.orderms.controller.dto;

import br.btgpactual.orderms.entity.OrderEntity;

import java.math.BigDecimal;

public record OrderResponse(Long orderId,
                            Long customerId,
                            BigDecimal total) {

    public static OrderResponse fromEntity(OrderEntity orderEntity){
        return new OrderResponse(orderEntity.getId(), orderEntity.getCustomerId(), orderEntity.getTotal());
    }
}
