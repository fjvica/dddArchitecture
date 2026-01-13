package com.ddd.ddd.domain.model;

/**
 * Entidad: Cliente
 *
 * - Tiene identidad propia (clienteId)
 * - Puede cambiar atributos (nombre)
 * - No contiene lógica compleja, solo atributos y comportamiento del cliente
 */
public class Cliente {
    private final Long clienteId;
    private String nombre;

    public Cliente(Long clienteId, String nombre) {
        this.clienteId = clienteId;
        this.nombre = nombre;
    }

    public Long getClienteId() { return clienteId; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}

