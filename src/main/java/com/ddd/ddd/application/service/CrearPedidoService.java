package com.ddd.ddd.application.service;

import com.ddd.ddd.application.port.in.CrearPedidoUseCase;
import com.ddd.ddd.application.port.out.GuardarPedidoPort;
import com.ddd.ddd.domain.model.Cliente;
import com.ddd.ddd.domain.model.Pedido;
import com.ddd.ddd.domain.model.Producto;
import com.ddd.ddd.domain.service.CalculadoraDescuento;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Servicio de aplicación:
 * - Orquesta la creación de un pedido
 * - No contiene reglas de negocio
 * - Llama a los agregados y a los puertos de salida
 */
@Service
public class CrearPedidoService implements CrearPedidoUseCase {

    private final GuardarPedidoPort pedidoRepository;
    private final CalculadoraDescuento calculadoraDescuento;

    public CrearPedidoService(GuardarPedidoPort pedidoRepository, CalculadoraDescuento calculadoraDescuento) {
        this.pedidoRepository = pedidoRepository;
        this.calculadoraDescuento = calculadoraDescuento;
    }

    @Override
    public Pedido ejecutar(Long clienteId) {
        // 1️⃣ Crear agregado raíz
        Cliente cliente = new Cliente(clienteId, "Cliente " + clienteId);
        Pedido pedido = new Pedido(cliente);

        // 2️⃣ Añadir productos al pedido
        pedido.añadirProducto(new Producto(1L, "Camiseta", BigDecimal.valueOf(60)), 1);
        pedido.añadirProducto(new Producto(2L, "Pantalón", BigDecimal.valueOf(50)), 1);

        // 3️⃣ Aplicar descuentos usando servicio de dominio
        BigDecimal totalConDescuento = calculadoraDescuento.aplicarDescuento(pedido);
        System.out.println("Total con descuento: " + totalConDescuento);

        // 4️⃣ Confirmar el pedido si quieres (opcional)
        pedido.confirmar();

        // 5️⃣ Guardar mediante puerto de salida
        return pedidoRepository.guardar(pedido);
    }

}

