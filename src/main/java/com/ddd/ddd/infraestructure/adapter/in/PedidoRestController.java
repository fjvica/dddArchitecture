package com.ddd.ddd.infraestructure.adapter.in;

import com.ddd.ddd.application.port.in.CrearPedidoUseCase;
import com.ddd.ddd.domain.model.Pedido;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoRestController {

    private final CrearPedidoUseCase crearPedidoUseCase;

    public PedidoRestController(CrearPedidoUseCase crearPedidoUseCase) {
        this.crearPedidoUseCase = crearPedidoUseCase;
    }

    @PostMapping
    public Pedido crearPedido(@RequestParam Long clienteId) {
        return crearPedidoUseCase.ejecutar(clienteId);
    }
}

