# Escenario 02 — Builder: registro de activos fijos

| Participante    | Clase                                           |
| --------------- | ----------------------------------------------- |
| Product         | `activos.construccion.ActivoFijo`               |
| Builder         | `activos.construccion.ActivoFijoBuilder`        |
| ConcreteBuilder | `activos.construccion.ConstructorActivoFijo`    |
| Director        | `activos.construccion.DirectorActivoFijo`       |
| Cliente         | `activos.Main`                                  |

## Ejecutar (Java 17+)

```bash
javac -d out $(find src -name "*.java")
java -cp out activos.Main
```

## Decisiones de implementación

- Tipos del UML: `Decimal` → `BigDecimal`, `Date` → `LocalDate`, `Integer` → `Integer` (admite ausencia de garantía).
- `ActivoFijo` tiene constructor y setters con visibilidad de paquete: solo el builder puede configurarlo; el cliente solo lo consulta.
- `DirectorActivoFijo.construirBase()` inicia la construcción y fija los atributos obligatorios; el cliente agrega los opcionales.
- `obtenerActivo()` valida código, nombre y precio; si falta alguno lanza `IllegalStateException`. Tras entregar el activo, el builder queda vacío (multiplicidad 0..1) y debe reiniciarse.
- Datos específicos que no tienen atributo propio (procesador, material, dimensiones) se registran en `caracteristicasTecnicas`.
