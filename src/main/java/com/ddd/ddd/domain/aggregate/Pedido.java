package com.ddd.ddd.domain.aggregate;

import com.ddd.ddd.domain.entity.LineaPedido;
import com.ddd.ddd.domain.valueObject.CategoriaProducto;
import com.ddd.ddd.domain.valueObject.Precio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Agregado raíz del dominio de pedidos.
 * <p>
 * Un Pedido es la **entidad raíz** que garantiza la consistencia de su agregado.
 * Contiene **entidades internas** (lineas) y aplica reglas de negocio.
 * Solo se puede persistir un pedido completo a través de un repositorio.
 */
public class Pedido {

    private final String id; // Identidad global del agregado
    private final List<LineaPedido> lineas = new ArrayList<>(); // Entidades internas
    private boolean pagado = false; // Estado del pedido

    public Pedido(String id) {
        this.id = id;
    }

    public String getId() { return id; }

    /**
     * Agrega una línea al pedido.
     * <p>
     * Solo se permite mientras el pedido no esté pagado.
     */
    public void agregarProducto(LineaPedido linea) {
        if (pagado)
            throw new IllegalStateException("No se puede modificar un pedido pagado");
        lineas.add(linea);
    }

    /**
     * Calcula el total del pedido aplicando reglas de negocio:
     * 1) 10% de descuento si total > 100€
     * 2) 5% de descuento adicional si hay más de 3 productos de la misma categoría
     */
    public Precio calcularTotal() {
        Precio total = new Precio(java.math.BigDecimal.ZERO);

        Map<CategoriaProducto, Long> conteoPorCategoria =
                lineas.stream()
                        .collect(Collectors.groupingBy(LineaPedido::getCategoria, Collectors.counting()));

        for (LineaPedido l : lineas) {
            total = total.sumar(l.subtotal());
        }

        // Regla 1: pedido > 100 €
        if (total.getValor().compareTo(java.math.BigDecimal.valueOf(100)) > 0) {
            total = total.aplicarDescuento(java.math.BigDecimal.valueOf(0.10));
        }

        // Regla 2: más de 3 productos de la misma categoría
        boolean categoriaRepetida = conteoPorCategoria.values().stream().anyMatch(c -> c > 3);
        if (categoriaRepetida) {
            total = total.aplicarDescuento(java.math.BigDecimal.valueOf(0.05));
        }

        return total;
    }

    /**
     * Marca el pedido como pagado.
     * <p>
     * Una vez pagado, no se pueden agregar más líneas.
     */
    public void marcarComoPagado() {
        if (lineas.isEmpty())
            throw new IllegalStateException("Pedido vacío");
        pagado = true;
    }
}

