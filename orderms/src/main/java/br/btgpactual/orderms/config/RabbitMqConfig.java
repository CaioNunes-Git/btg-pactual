package br.btgpactual.orderms.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    public static final String ORDER_CREATED_QUEUE = "btgpactual-order-created";
    public static final String EXCHANGE = "order-exchange";
    public static final String ROUTING_KEY = "order-routingKey";
}
