package br.btgpactual.orderms.listener.dto;

import java.util.List;

public record OrderCreatedEvent(Long idOrder,
                                Long idCustomer,
                                List<OrderItemEvent> items) {
}
