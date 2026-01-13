package com.ddd.ddd.domain.valueObject;

import java.math.BigDecimal;

/**
 * Representa un valor monetario en el dominio de pedidos.
 * <p>
 * Es un Value Object, por lo que es **inmutable** y se compara por su valor.
 * Contiene lógica de negocio propia, como sumar, multiplicar o aplicar descuentos.
 */
public class Precio {

    private final BigDecimal valor;

    /**
     * Constructor del Value Object Precio.
     *
     * @param valor el valor monetario (debe ser >= 0)
     * @throws IllegalArgumentException si el valor es negativo
     */
    public Precio(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("El precio no puede ser negativo");
        this.valor = valor;
    }

    /**
     * Obtiene el valor monetario.
     */
    public BigDecimal getValor() {
        return valor;
    }

    /**
     * Suma este precio con otro.
     */
    public Precio sumar(Precio otro) {
        return new Precio(this.valor.add(otro.valor));
    }

    /**
     * Multiplica el precio por una cantidad.
     */
    public Precio multiplicar(int cantidad) {
        return new Precio(this.valor.multiply(BigDecimal.valueOf(cantidad)));
    }

    /**
     * Aplica un descuento expresado como porcentaje (0.10 = 10%)
     */
    public Precio aplicarDescuento(BigDecimal porcentaje) {
        BigDecimal factor = BigDecimal.ONE.subtract(porcentaje);
        return new Precio(valor.multiply(factor));
    }
}


