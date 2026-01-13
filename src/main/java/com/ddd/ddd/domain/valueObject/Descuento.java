package com.ddd.ddd.domain.valueObject;

import java.math.BigDecimal;

/**
 * Representa un descuento aplicado a un precio.
 * <p>
 * Es un Value Object inmutable, con un porcentaje entre 0 y 1.
 * Contiene lógica para aplicarse sobre un Precio.
 */
public class Descuento {

    private final BigDecimal porcentaje;

    public Descuento(BigDecimal porcentaje) {
        if (porcentaje.compareTo(BigDecimal.ZERO) < 0 || porcentaje.compareTo(BigDecimal.ONE) > 0)
            throw new IllegalArgumentException("Descuento fuera de rango (0-1)");
        this.porcentaje = porcentaje;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    /**
     * Aplica este descuento a un precio dado.
     */
    public Precio aplicar(Precio precio) {
        return precio.aplicarDescuento(porcentaje);
    }
}


