package com.ddd.ddd.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Agregado raíz: Pedido
 *
 * - Contiene las reglas de negocio de un pedido
 * - Encapsula las líneas de pedido
 * - Controla su estado (pendiente, confirmado)
 */
public class Pedido {
    private Long id;
    private Cliente cliente;
    private List<LineaPedido> lineas = new ArrayList<>();
    private EstadoPedido estado = EstadoPedido.PENDIENTE;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public void añadirProducto(Producto producto, int cantidad) {
        if(estado != EstadoPedido.PENDIENTE)
            throw new IllegalStateException("No se pueden añadir productos a un pedido confirmado");

        lineas.add(new LineaPedido(producto, cantidad));
    }

    public void confirmar() {
        if(lineas.isEmpty())
            throw new IllegalStateException("No se puede confirmar un pedido vacío");

        estado = EstadoPedido.CONFIRMADO;
    }

    public BigDecimal calcularTotal() {
        return lineas.stream()
                .map(l -> l.getProducto().getPrecio().multiply(BigDecimal.valueOf(l.getCantidad())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // Getters
    public Long getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public List<LineaPedido> getLineas() { return List.copyOf(lineas); }
    public EstadoPedido getEstado() { return estado; }
}
