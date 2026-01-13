package com.ddd.ddd.domain.entity;

import com.ddd.ddd.domain.valueObject.Cantidad;
import com.ddd.ddd.domain.valueObject.CategoriaProducto;
import com.ddd.ddd.domain.valueObject.Precio;

/**
 * Representa una línea de un pedido.
 * <p>
 * Es una **entidad interna** del agregado Pedido.
 * Tiene identidad dentro del pedido (productoId) y comportamiento propio (subtotal).
 * Nunca se persiste de forma independiente, solo como parte del Pedido.
 */
public class LineaPedido {

    private final String productoId; // Identificador único de producto dentro del pedido
    private final CategoriaProducto categoria; // Categoría del producto
    private final Cantidad cantidad; // Cantidad de unidades
    private final Precio precioUnitario; // Precio unitario del producto

    public LineaPedido(String productoId, CategoriaProducto categoria, Cantidad cantidad, Precio precioUnitario) {
        this.productoId = productoId;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    /**
     * Calcula el subtotal de esta línea de pedido (cantidad * precio unitario).
     */
    public Precio subtotal() {
        return precioUnitario.multiplicar(cantidad.getValor());
    }

    public CategoriaProducto getCategoria() {
        return categoria;
    }
}


