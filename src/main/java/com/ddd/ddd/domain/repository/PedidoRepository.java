package com.ddd.ddd.domain.repository;

import com.ddd.ddd.domain.model.Pedido;

import java.util.Optional;

/**
 * Puerto de salida: define cómo se guarda o recupera un agregado Pedido.
 * La implementación concreta se hace en la capa de infraestructura.
 */
public interface PedidoRepository {
    Pedido guardar(Pedido pedido);
    Optional<Pedido> obtenerPorId(Long id);
}

