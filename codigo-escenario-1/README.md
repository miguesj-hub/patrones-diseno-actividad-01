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

- **Auto:** 50 + avalúo × 1,5 % × factor de antigüedad (−5 % por año, mínimo 50 %).
- **Camioneta:** (70 + avalúo × 2 % × factor de antigüedad (−4 % por año, mínimo 50 %) + capacidad × 15) × 1,20 si el uso es comercial.
- **Camión:** 120 + avalúo × 1 % + tonelaje × 30.

## Agregar un nuevo tipo (p. ej. Motocicleta)

1. Crear `Motocicleta extends Vehiculo` con su `calcularMatricula()`.
2. Crear `CreadorMotocicleta extends CreadorVehiculo`.
3. Agregar la opción en `Main.seleccionarCreador()`. `registrar()` y el resto de la lógica no cambian.
