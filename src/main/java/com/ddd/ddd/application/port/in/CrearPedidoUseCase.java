package com.ddd.ddd.application.port.in;

import com.ddd.ddd.domain.model.Pedido;

/**
 * Puerto de entrada (inbound port) para crear pedidos
 */
public interface CrearPedidoUseCase {
    Pedido ejecutar(Long clienteId);
}
