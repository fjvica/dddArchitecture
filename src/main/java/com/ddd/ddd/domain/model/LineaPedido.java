package com.ddd.ddd.domain.model;
/**
 * Value Object: representa una línea de pedido (producto + cantidad)
 *
 * Características:
 * - Inmutable
 * - Igualdad por valor, no por identidad
 * - Encapsula reglas simples del concepto (por ejemplo, cantidad > 0)
 */
public final class LineaPedido {

    private final Producto producto;
    private final int cantidad;

    public LineaPedido(Producto producto, int cantidad) {
        if(cantidad <= 0) throw new IllegalArgumentException("Cantidad debe ser mayor que 0");
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LineaPedido)) return false;
        LineaPedido otra = (LineaPedido) o;
        return producto.equals(otra.producto) && cantidad == otra.cantidad;
    }

    @Override
    public int hashCode() {
        return producto.hashCode() * 31 + cantidad;
    }
}

