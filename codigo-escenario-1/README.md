# Escenario 01 — Factory Method: matrícula de vehículos

| Participante    | Clase                                              |
| --------------- | -------------------------------------------------- |
| Product         | `vehiculos.producto.Vehiculo`                      |
| ConcreteProduct | `Auto`, `Camioneta`, `Camion`                      |
| Creator         | `vehiculos.creador.CreadorVehiculo`                |
| ConcreteCreator | `CreadorAuto`, `CreadorCamioneta`, `CreadorCamion` |
| Cliente         | `vehiculos.Main`                                   |

## Ejecutar (Java 17+)

```bash
javac -d out $(find src -name "*.java")
java -cp out vehiculos.Main
```

## Reglas de cálculo (supuestas, el enunciado no las define)

- **Auto:** 2 % del avalúo + 1 % por año de antigüedad (el recargo por antigüedad llega como máximo al 10 %).
- **Camioneta:** 3 % del avalúo + 20 por tonelada de capacidad; +15 % si el uso es comercial.
- **Camión:** 4 % del avalúo + 50 por tonelada.

## Decisiones de implementación

- `crearVehiculo(placa, marca, modelo, anioFabricacion, avaluo)` recibe los atributos comunes (según el UML).
  Los datos propios de cada tipo (`capacidad`, `uso`, `tonelaje`) los conoce el creador concreto.
- `Vehiculo` incluye `validarNoNegativo()` y `antiguedad()` (protegidos) y valida placa obligatoria y año ≥ 1900.
- Los atributos son `final`: un vehículo no cambia tras su creación.

## Agregar un nuevo tipo (p. ej. Motocicleta)

1. Crear `Motocicleta extends Vehiculo` con su `calcularMatricula()`.
2. Crear `CreadorMotocicleta extends CreadorVehiculo`.
3. Agregar la opción en `Main.seleccionarCreador()`. `registrar()` y el resto de la lógica no cambian.
