package br.btgpactual.orderms.listener.dto;

import java.math.BigDecimal;

public record OrderItemEvent(Long idProduct,
                             String product,
                             Integer quantity,
                             BigDecimal price) {
}
