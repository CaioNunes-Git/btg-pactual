package br.btgpactual.orderms.service;

import br.btgpactual.orderms.entity.OrderEntity;
import br.btgpactual.orderms.entity.OrderItem;
import br.btgpactual.orderms.listener.dto.OrderCreatedEvent;
import br.btgpactual.orderms.listener.dto.OrderItemEvent;
import br.btgpactual.orderms.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {
    public final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void saveOrder(OrderCreatedEvent event) {
        var entity = new OrderEntity();
        entity.setCustomerId(event.idCustomer());
        entity.setId(event.idOrder());
        entity.setItems(getOrderItems(event));
        entity.setTotal(getTotal(event));

        orderRepository.save(entity);

    }

    private BigDecimal getTotal(OrderCreatedEvent event) {
        return event.items().stream()
                .map(i -> i.price().multiply(BigDecimal.valueOf(i.quantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    private static List<OrderItem> getOrderItems(OrderCreatedEvent event) {
        return event.items().stream()
                .map(i -> new OrderItem(i.idProduct(), i.product(), i.quantity(), i.price())).toList();
    }
}
