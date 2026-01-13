package com.ddd.ddd.domain.model;

import java.math.BigDecimal;

/**
 * Entidad: Producto
 *
 * - Tiene identidad (productoId)
 * - Contiene atributos del producto como nombre y precio
 */
public class Producto {
    private final Long productoId;
    private String nombre;
    private BigDecimal precio;

    public Producto(Long productoId, String nombre, BigDecimal precio) {
        this.productoId = productoId;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Long getProductoId() { return productoId; }
    public String getNombre() { return nombre; }
    public BigDecimal getPrecio() { return precio; }
}

