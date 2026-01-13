package com.ddd.ddd.infraestructure.adapter.in;

// infraestructura/controladores/PedidoController.java
import com.ddd.ddd.application.service.CrearPedidoService;
import com.ddd.ddd.domain.aggregate.Pedido;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final CrearPedidoService crearPedidoService;

    public PedidoController(CrearPedidoService crearPedidoService) {
        this.crearPedidoService = crearPedidoService;
    }

    @PostMapping
    public Pedido crearPedido() {
        return crearPedidoService.ejecutar();
    }
}

