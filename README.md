src/main/java/com/miempresa/tienda/
│
├── domain/                     <-- Núcleo del dominio (DDD)
│   ├── model/
│   │   ├── Pedido.java         <-- Agregado raíz
│   │   ├── Cliente.java        <-- Entidad
│   │   ├── Producto.java       <-- Entidad
│   │   └── LineaPedido.java    <-- Value Object
│   └── service/
│       └── CalculadoraDescuento.java
│   └── repository/
│       └── PedidoRepository.java  <-- Puerto de salida (interfaz)
│
├── application/
│   ├── service/
│   │   └── CrearPedidoService.java
│   └── port/
│       ├── in/
│       │   └── CrearPedidoUseCase.java  <-- Puerto de entrada
│       └── out/
│           └── GuardarPedidoPort.java  <-- Puerto de salida
│
├── infrastructure/
│   ├── adapter/
│   │   ├── in/
│   │   │   └── PedidoRestController.java
│   │   └── out/
│   │       └── PedidoJpaAdapter.java
│   └── repository/
│       ├── PedidoJpaEntity.java
│       └── PedidoJpaRepository.java
│
└── TiendaApplication.java
