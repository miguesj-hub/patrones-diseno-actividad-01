package activos;

import java.math.BigDecimal;
import java.time.LocalDate;

import activos.construccion.ActivoFijo;
import activos.construccion.ActivoFijoBuilder;
import activos.construccion.ConstructorActivoFijo;
import activos.construccion.DirectorActivoFijo;

/**
 * Cliente: el director establece la base obligatoria y el cliente agrega solo
 * los atributos opcionales y las características técnicas que corresponden a cada activo.
 */
public class Main {

    public static void main(String[] args) {
        ActivoFijoBuilder builder = new ConstructorActivoFijo();
        DirectorActivoFijo director = new DirectorActivoFijo(builder);

        System.out.println("=== Registro de activos fijos ===");

        // Computador: marca, modelo, número de serie, procesador y garantía.
        director.construirBase("AF001", "Computador portátil", new BigDecimal("1200.00"));
        builder.establecerTipo("Computador");
        builder.establecerMarca("Dell");
        builder.establecerModelo("Latitude 5440");
        builder.establecerNumeroSerie("DL-5440-88213");
        builder.establecerCaracteristica("Procesador", "Intel Core i7");
        builder.establecerCaracteristica("Memoria RAM", "16 GB");
        builder.establecerCaracteristica("Almacenamiento", "512 GB SSD");
        builder.establecerGarantia(36);
        builder.establecerFechaAdquisicion(LocalDate.of(2026, 3, 15));
        builder.establecerProveedor("Tecnología Andina S.A.");
        ActivoFijo computador = builder.obtenerActivo();
        System.out.println(computador);

        // Mesa: solo material, dimensiones, ubicación y custodio.
        director.construirBase("AF002", "Mesa de reuniones", new BigDecimal("350.00"));
        builder.establecerTipo("Mueble");
        builder.establecerCaracteristica("Material", "Madera de roble");
        builder.establecerCaracteristica("Dimensiones", "2,40 x 1,10 m");
        builder.establecerUbicacion("Cuenca - Sala de juntas 2");
        builder.establecerCustodio("Departamento Administrativo");
        ActivoFijo mesa = builder.obtenerActivo();
        System.out.println(mesa);

        // Validación: no se entrega un activo sin sus datos obligatorios.
        builder.iniciarConstruccion();
        builder.establecerCodigo("AF003");
        builder.establecerMarca("Epson");
        try {
            builder.obtenerActivo();
        } catch (IllegalStateException e) {
            System.out.println("Activo rechazado: " + e.getMessage());
        }
    }
}
