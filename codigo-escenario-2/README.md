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

- Tipos del UML: `BigDecimal` para el precio, `LocalDate` para la fecha e `Integer` para la garantía (admite ausencia).
- `ActivoFijo` es **inmutable**: campos `final`, constructor de paquete y sin setters. Solo el builder lo crea,
  en `obtenerActivo()`, cuando los datos obligatorios están completos.
- `ConstructorActivoFijo` guarda los datos en campos temporales; la relación con `ActivoFijo` es de dependencia (`<<create>>`).
- `caracteristicasTecnicas` es un `Map<String, String>` (copiado y no modificable) cargado con `establecerCaracteristica(clave, valor)`;
  así procesador, material o dimensiones no necesitan atributos propios.
- `obtenerActivo()` valida código, nombre y precio mayor que cero; si falta alguno lanza `IllegalStateException`.
  Al terminar, el builder se reinicia para construir otro activo.
- `establecerGarantia` rechaza valores negativos y `establecerCaracteristica` rechaza claves vacías.
- `DirectorActivoFijo.construirBase()` inicia la construcción y fija los obligatorios; el cliente agrega los opcionales.
