package com.ddd.ddd.domain.valueObject;

// dominio/valueobjects/Cantidad.java
public class Cantidad {
    private final int valor;

    public Cantidad(int valor) {
        if (valor <= 0) throw new IllegalArgumentException("Cantidad inválida");
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}

