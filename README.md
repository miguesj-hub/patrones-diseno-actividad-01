# Patrones de Diseño de Software — Actividad 01: Patrones creacionales

Maestría en Software (UPS).

- **Escenario 01** — Registro de vehículos y cálculo de matrícula: *Factory Method*.
- **Escenario 02** — Registro de activos fijos: *Builder*.

## Contenido

- [`codigo-escenario-1/`](codigo-escenario-1/README.md) — implementación en Java de Factory Method (paquete `vehiculos`).
- [`codigo-escenario-2/`](codigo-escenario-2/README.md) — implementación en Java de Builder (paquete `activos`).
- [`diagrama.tex`](diagrama.tex) — diagramas de clases UML finales de ambos escenarios (PlantUML).
- [`PDS_Actividad_01_Grupo2.md`](PDS_Actividad_01_Grupo2.md) — informe: problema, patrón, diagrama, código fuente, uso crítico de IA y conclusiones.
- [`PDS_Actividad_01_GrupoXX.docx`](PDS_Actividad_01_GrupoXX.docx) — enunciado y plantilla de entrega.
- `PDS_Actividad_01_Grupo2.docx` — informe en Word (versión de entrega).
- `sistema de pedidos-Tarea Patrones CreacionalesVehiculo.drawio.png` — diagrama de clases inicial del escenario 01.

## Ejecutar (Java 17+)

```bash
# Escenario 01
cd codigo-escenario-1
javac -d out $(find src -name "*.java")
java -cp out vehiculos.Main

# Escenario 02
cd codigo-escenario-2
javac -d out $(find src -name "*.java")
java -cp out activos.Main
```
