package com.ddd.ddd.application.port.in;

// aplicacion/puertos/PedidoRepository.java

import com.ddd.ddd.domain.aggregate.Pedido;

public interface CrearPedido {
    Pedido ejecutar();
}
