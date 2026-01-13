package com.ddd.ddd.infraestructure.adapter.out;

import com.ddd.ddd.application.port.out.PedidoRepository;
import com.ddd.ddd.domain.aggregate.Pedido;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Implementación del repositorio en memoria para desarrollo o pruebas.
 * <p>
 * Persiste el agregado Pedido como una unidad completa.
 */
@Repository
public class InMemoryPedidoRepository implements PedidoRepository {

    private final Map<String, Pedido> memoria = new HashMap<>();

    @Override
    public Pedido guardar(Pedido pedido) {
        memoria.put(pedido.getId(), pedido);
        return pedido;
    }

    @Override
    public Optional<Pedido> obtenerPorId(String id) {
        return Optional.ofNullable(memoria.get(id));
    }
}


