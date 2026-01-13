package com.ddd.ddd.domain.valueObject;

/**
 * Representa una cantidad de unidades de un producto.
 * <p>
 * Es un Value Object inmutable que encapsula la validación de cantidades válidas (>0).
 */
public class Cantidad {

    private final int valor;

    public Cantidad(int valor) {
        if (valor <= 0)
            throw new IllegalArgumentException("Cantidad inválida");
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}


