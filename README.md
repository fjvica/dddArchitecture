# 📦 Pedidos DDD con Spring Boot y Arquitectura Hexagonal

## 1️⃣ Descripción

Este proyecto es un **ejemplo de Domain-Driven Design (DDD) aplicado en Spring Boot** usando **arquitectura hexagonal**.

Incluye:

* **Agregado raíz**: `Pedido`
* **Entidades internas**: `LineaPedido`
* **Value Objects**: `Precio`, `Cantidad`, `Descuento`, `CategoriaProducto`
* **Casos de uso**: `CrearPedidoService`
* **Puertos y adaptadores**:

    * Puerto de salida: `PedidoRepository`
    * Adaptador de infraestructura: `InMemoryPedidoRepository`
    * Puerto de entrada: `PedidoController` (REST)

El objetivo es mostrar cómo modelar **un dominio rico** con reglas de negocio y mantener el **desacoplamiento entre dominio e infraestructura**.

---

## 2️⃣ Estructura del proyecto

```
src/main/java
│
├── dominio
│   ├── agregado
│   │   └── Pedido.java          # Agregado raíz
│   ├── entidades
│   │   └── LineaPedido.java     # Entidad interna
│   └── valueobjects
│       ├── Precio.java
│       ├── Cantidad.java
│       ├── CategoriaProducto.java
│       └── Descuento.java
│
├── aplicacion
│   ├── puertos
│   │   └── PedidoRepository.java # Puerto de salida
│   └── servicios
│       └── CrearPedidoService.java # Caso de uso
│
└── infraestructura
    ├── adaptadores
    │   └── InMemoryPedidoRepository.java # Implementación del puerto
    ├── controladores
    │   └── PedidoController.java         # REST
    └── config
        └── BeanConfig.java               # Configuración de beans Spring
```

---

## 3️⃣ Cómo ejecutar el proyecto

1. **Clonar el repositorio**:

```bash
git clone https://github.com/tu-usuario/pedidos-ddd.git
cd pedidos-ddd
```

2. **Compilar y ejecutar con Maven**:

```bash
./mvnw spring-boot:run
```

3. **Probar el endpoint de creación de pedidos**:

```bash
POST http://localhost:8080/pedidos
```

**Respuesta ejemplo:**

```json
{
  "id": "c9e1b8b8-1234-5678-9101-abcdef123456",
  "lineas": [
    {"productoId":"p1","categoria":"ELECTRONICA","cantidad":{"valor":2},"precioUnitario":{"valor":50}},
    {"productoId":"p2","categoria":"HOGAR","cantidad":{"valor":1},"precioUnitario":{"valor":30}},
    {"productoId":"p3","categoria":"ELECTRONICA","cantidad":{"valor":2},"precioUnitario":{"valor":20}}
  ],
  "pagado": false
}
```

---

## 4️⃣ Conceptos clave de DDD aplicados

| Concepto          | Clase / Elemento                                       | Descripción                                                                  |
| ----------------- | ------------------------------------------------------ | ---------------------------------------------------------------------------- |
| Agregado raíz     | `Pedido`                                               | Controla la consistencia de todo el agregado y define las reglas de negocio. |
| Entidad interna   | `LineaPedido`                                          | Forma parte del agregado, tiene identidad local y comportamiento.            |
| Value Object      | `Precio`, `Cantidad`, `Descuento`, `CategoriaProducto` | Inmutables, sin identidad, representan valores importantes del dominio.      |
| Puerto de salida  | `PedidoRepository`                                     | Abstracción para persistir el agregado raíz.                                 |
| Adaptador         | `InMemoryPedidoRepository`                             | Implementación concreta del repositorio.                                     |
| Puerto de entrada | `PedidoController`                                     | Exposición REST de los casos de uso.                                         |
| Caso de uso       | `CrearPedidoService`                                   | Orquesta la creación de un pedido completo con reglas de negocio.            |

---

## 5️⃣ Reglas de negocio implementadas

1. **10% de descuento** si el total del pedido > 100€.
2. **5% adicional** si hay más de 3 productos de la misma categoría.
3. No se pueden modificar los pedidos **pagados**.
4. No se puede marcar como pagado un pedido **vacío**.

---

## 6️⃣ Extensiones posibles

* Persistencia con JPA / MongoDB reemplazando `InMemoryPedidoRepository`.
* Validaciones más complejas sobre productos o stock.
* Casos de uso adicionales: `AgregarLinea`, `EliminarLinea`, `MarcarComoPagado`.
* Exposición de endpoints REST adicionales (GET por ID, listar pedidos, filtrar por categoría).
