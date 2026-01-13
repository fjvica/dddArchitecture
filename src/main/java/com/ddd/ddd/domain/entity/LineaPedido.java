package com.ddd.ddd.domain.entity;

// dominio/entidades/LineaPedido.java

import com.ddd.ddd.domain.valueObject.Cantidad;
import com.ddd.ddd.domain.valueObject.CategoriaProducto;
import com.ddd.ddd.domain.valueObject.Precio;

public class LineaPedido {
    private final String productoId;
    private final CategoriaProducto categoria;
    private final Cantidad cantidad;
    private final Precio precioUnitario;

    public LineaPedido(String productoId, CategoriaProducto categoria, Cantidad cantidad, Precio precioUnitario) {
        this.productoId = productoId;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public Precio subtotal() {
        return precioUnitario.multiplicar(cantidad.getValor());
    }

    public CategoriaProducto getCategoria() {
        return categoria;
    }
}

