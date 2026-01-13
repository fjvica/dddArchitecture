package com.ddd.ddd.domain.aggregate;

// dominio/agregado/Pedido.java

import com.ddd.ddd.domain.entity.LineaPedido;
import com.ddd.ddd.domain.valueObject.CategoriaProducto;
import com.ddd.ddd.domain.valueObject.Precio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Pedido {
    private final String id;
    private final List<LineaPedido> lineas = new ArrayList<>();
    private boolean pagado = false;

    public Pedido(String id) {
        this.id = id;
    }

    public String getId() { return id; }

    public void agregarProducto(LineaPedido linea) {
        if (pagado) throw new IllegalStateException("No se puede modificar un pedido pagado");
        lineas.add(linea);
    }

    public Precio calcularTotal() {
        Precio total = new Precio(java.math.BigDecimal.ZERO);

        Map<CategoriaProducto, Long> conteoPorCategoria =
                lineas.stream()
                        .collect(Collectors.groupingBy(LineaPedido::getCategoria, Collectors.counting()));

        for (LineaPedido l : lineas) {
            total = total.sumar(l.subtotal());
        }

        // Regla 1: pedido > 100 € → 10% descuento
        if (total.getValor().compareTo(java.math.BigDecimal.valueOf(100)) > 0) {
            total = total.aplicarDescuento(java.math.BigDecimal.valueOf(0.10));
        }

        // Regla 2: más de 3 productos de la misma categoría → 5% adicional
        boolean categoriaRepetida = conteoPorCategoria.values().stream().anyMatch(c -> c > 3);
        if (categoriaRepetida) {
            total = total.aplicarDescuento(java.math.BigDecimal.valueOf(0.05));
        }

        return total;
    }

    public void marcarComoPagado() {
        if (lineas.isEmpty()) throw new IllegalStateException("Pedido vacío");
        pagado = true;
    }
}

