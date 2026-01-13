package com.ddd.ddd.domain.valueObject;

// dominio/valueobjects/Precio.java
import java.math.BigDecimal;

public class Precio {
    private final BigDecimal valor;

    public Precio(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Precio no puede ser negativo");
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Precio sumar(Precio otro) {
        return new Precio(this.valor.add(otro.valor));
    }

    public Precio multiplicar(int cantidad) {
        return new Precio(this.valor.multiply(BigDecimal.valueOf(cantidad)));
    }

    public Precio aplicarDescuento(BigDecimal porcentaje) {
        BigDecimal factor = BigDecimal.ONE.subtract(porcentaje);
        return new Precio(valor.multiply(factor));
    }
}

