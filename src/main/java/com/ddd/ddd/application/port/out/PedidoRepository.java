package com.ddd.ddd.application.port.out;

// aplicacion/puertos/PedidoRepository.java

import com.ddd.ddd.domain.aggregate.Pedido;

import java.util.Optional;

public interface PedidoRepository {
    Pedido guardar(Pedido pedido);
    Optional<Pedido> obtenerPorId(String id);
}
