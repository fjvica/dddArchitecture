package com.ddd.ddd.infraestructure.adapter.out;

import com.ddd.ddd.domain.model.Cliente;
import com.ddd.ddd.domain.model.Pedido;
import com.ddd.ddd.domain.model.Producto;
import com.ddd.ddd.domain.repository.PedidoRepository;
import com.ddd.ddd.infraestructure.repository.LineaPedidoJpaEntity;
import com.ddd.ddd.infraestructure.repository.PedidoJpaEntity;
import com.ddd.ddd.infraestructure.repository.PedidoJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Adaptador de salida JPA:
 * - Implementa el puerto de salida definido en el dominio
 * - Convierte entre agregados del dominio y entidades JPA
 */
@Component
public class PedidoJpaAdapter implements PedidoRepository {

    private final PedidoJpaRepository repository;

    public PedidoJpaAdapter(PedidoJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pedido guardar(Pedido pedido) {
        PedidoJpaEntity entity = convertirADomainEntity(pedido);
        PedidoJpaEntity guardado = repository.save(entity);
        return convertirADominio(guardado);
    }

    @Override
    public Optional<Pedido> obtenerPorId(Long id) {
        return repository.findById(id)
                .map(this::convertirADominio);
    }

    // -------------------------
    // Métodos de conversión
    // -------------------------

    private PedidoJpaEntity convertirADomainEntity(Pedido pedido) {
        PedidoJpaEntity entity = new PedidoJpaEntity();
        entity.setId(pedido.getId());
        entity.setClienteId(pedido.getCliente().getClienteId());
        entity.setEstado(pedido.getEstado().name());
        entity.setLineas(pedido.getLineas().stream()
                .map(l -> {
                    LineaPedidoJpaEntity linea = new LineaPedidoJpaEntity();
                    linea.setProductoId(l.getProducto().getProductoId());
                    linea.setNombreProducto(l.getProducto().getNombre());
                    linea.setPrecio(l.getProducto().getPrecio());
                    linea.setCantidad(l.getCantidad());
                    return linea;
                })
                .collect(Collectors.toList()));
        return entity;
    }

    private Pedido convertirADominio(PedidoJpaEntity entity) {
        Cliente cliente = new Cliente(entity.getClienteId(), "Cliente " + entity.getClienteId());
        Pedido pedido = new Pedido(cliente);
        entity.getLineas().forEach(l -> {
            Producto producto = new Producto(l.getProductoId(), l.getNombreProducto(), l.getPrecio());
            pedido.añadirProducto(producto, l.getCantidad());
        });

        // Configuramos estado
        switch(entity.getEstado()) {
            case "CONFIRMADO": pedido.confirmar(); break;
            case "CANCELADO": /* opcional: método cancelar */ break;
            default: /* PENDIENTE, ya viene por defecto */ break;
        }

        return pedido;
    }
}


