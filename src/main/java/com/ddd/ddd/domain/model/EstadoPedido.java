package com.ddd.ddd.domain.model;

/**
 * Enum que representa los posibles estados de un pedido
 * - PENDIENTE: se acaba de crear, todavía no se confirma
 * - CONFIRMADO: el pedido fue confirmado
 * - CANCELADO: el pedido fue cancelado
 */
public enum EstadoPedido {
    PENDIENTE,
    CONFIRMADO,
    CANCELADO
}

