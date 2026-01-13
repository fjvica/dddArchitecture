package com.ddd.ddd.domain.valueObject;

// dominio/valueobjects/Descuento.java
import java.math.BigDecimal;

public class Descuento {
    private final BigDecimal porcentaje; // 0.10 = 10%

    public Descuento(BigDecimal porcentaje) {
        if (porcentaje.compareTo(BigDecimal.ZERO) < 0 || porcentaje.compareTo(BigDecimal.ONE) > 0)
            throw new IllegalArgumentException("Descuento fuera de rango 0-1");
        this.porcentaje = porcentaje;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public Precio aplicar(Precio precio) {
        return precio.aplicarDescuento(porcentaje);
    }
}

