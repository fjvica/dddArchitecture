package com.ddd.ddd.infraestructure.adapter.in;

import com.ddd.ddd.application.service.CrearPedidoService;
import com.ddd.ddd.domain.aggregate.Pedido;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para el agregado Pedido.
 * <p>
 * Exposición de los casos de uso de la aplicación a clientes externos.
 */
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final CrearPedidoService crearPedidoService;

    public PedidoController(CrearPedidoService crearPedidoService) {
        this.crearPedidoService = crearPedidoService;
    }

    /**
     * Endpoint para crear un pedido.
     * <p>
     * Devuelve el agregado Pedido completo con su total calculado.
     */
    @PostMapping
    public Pedido crearPedido() {
        return crearPedidoService.ejecutar();
    }
}
