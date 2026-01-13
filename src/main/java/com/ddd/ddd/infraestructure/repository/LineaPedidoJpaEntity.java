package com.ddd.ddd.infraestructure.repository;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "lineas_pedido")
public class LineaPedidoJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productoId;
    private String nombreProducto;
    private BigDecimal precio;
    private int cantidad;

    // getters y setters
}

