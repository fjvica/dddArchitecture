package com.ddd.ddd.application.port.out;

import com.ddd.ddd.domain.aggregate.Pedido;

import java.util.Optional;

/**
 * Puerto de salida del agregado Pedido.
 * <p>
 * Define la abstracción para persistir o recuperar pedidos.
 * La implementación concreta (JPA, Mongo, memoria, etc.) estará en infraestructura.
 */
public interface PedidoRepository {

    Pedido guardar(Pedido pedido);

    Optional<Pedido> obtenerPorId(String id);
}

