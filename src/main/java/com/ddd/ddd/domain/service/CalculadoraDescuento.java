package com.ddd.ddd.domain.service;

import com.ddd.ddd.domain.model.Pedido;

import java.math.BigDecimal;

/**
 * Servicio de dominio
 *
 * Contiene lógica que no pertenece a un agregado específico,
 * como cálculos de descuentos, impuestos, validaciones externas, etc.
 */
public class CalculadoraDescuento {

    public BigDecimal aplicarDescuento(Pedido pedido) {
        BigDecimal total = pedido.calcularTotal();
        if(total.compareTo(BigDecimal.valueOf(100)) > 0) {
            return total.multiply(BigDecimal.valueOf(0.9)); // 10% de descuento
        }
        return total;
    }
}
