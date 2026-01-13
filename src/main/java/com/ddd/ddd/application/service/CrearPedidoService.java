package com.ddd.ddd.application.service;

// aplicacion/servicios/CrearPedidoService.java

import com.ddd.ddd.application.port.in.CrearPedido;
import com.ddd.ddd.application.port.out.PedidoRepository;
import com.ddd.ddd.domain.aggregate.Pedido;
import com.ddd.ddd.domain.entity.LineaPedido;
import com.ddd.ddd.domain.valueObject.Cantidad;
import com.ddd.ddd.domain.valueObject.CategoriaProducto;
import com.ddd.ddd.domain.valueObject.Precio;

public class CrearPedidoService implements CrearPedido {

    private final PedidoRepository pedidoRepository;

    public CrearPedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido ejecutar() {
        Pedido pedido = new Pedido(java.util.UUID.randomUUID().toString());

        // Lógica de negocio: agregar algunos productos iniciales
        pedido.agregarProducto(new LineaPedido("p1", CategoriaProducto.ELECTRONICA, new Cantidad(2), new Precio(java.math.BigDecimal.valueOf(50))));
        pedido.agregarProducto(new LineaPedido("p2", CategoriaProducto.HOGAR, new Cantidad(1), new Precio(java.math.BigDecimal.valueOf(30))));
        pedido.agregarProducto(new LineaPedido("p3", CategoriaProducto.ELECTRONICA, new Cantidad(2), new Precio(java.math.BigDecimal.valueOf(20))));

        // Guardar usando el puerto
        return pedidoRepository.guardar(pedido);
    }
}


