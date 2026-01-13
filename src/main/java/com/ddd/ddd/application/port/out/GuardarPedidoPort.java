package com.ddd.ddd.application.port.out;

import com.ddd.ddd.domain.model.Pedido;

/**
 * Puerto de salida (outbound port) para persistir pedidos
 */
public interface GuardarPedidoPort {
    Pedido guardar(Pedido pedido);
}

