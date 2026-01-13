package com.ddd.ddd.infraestructure.adapter.out;

// infraestructura/adaptadores/InMemoryPedidoRepository.java

import com.ddd.ddd.application.port.out.PedidoRepository;
import com.ddd.ddd.domain.aggregate.Pedido;
import org.springframework.stereotype.Repository;

import java.util.*;

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

