package com.ddd.ddd.domain.valueObject;

/**
 * Enum que representa las categorías de productos en el dominio de pedidos.
 * <p>
 * Se utiliza para aplicar reglas de negocio, por ejemplo, descuentos adicionales
 * cuando hay más de 3 productos de la misma categoría.
 */
public enum CategoriaProducto {
    ELECTRONICA,
    HOGAR,
    ROPA,
    ALIMENTACION
}


