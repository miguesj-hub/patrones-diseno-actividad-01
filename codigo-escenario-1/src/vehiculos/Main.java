package vehiculos;

import java.util.Locale;
import java.util.Scanner;

import vehiculos.creador.CreadorAuto;
import vehiculos.creador.CreadorCamion;
import vehiculos.creador.CreadorCamioneta;
import vehiculos.creador.CreadorVehiculo;
import vehiculos.producto.Vehiculo;

/**
 * Cliente: el tipo de vehículo se elige en tiempo de ejecución. El único punto que conoce
 * los creadores concretos es seleccionarCreador(); el resto del proceso trabaja solo con
 * CreadorVehiculo y Vehiculo.
 */
public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("=== Registro de vehículos y cálculo de matrícula ===");
        System.out.println("Tipo de vehículo: 1) Auto  2) Camioneta  3) Camión");

        try {
            int tipo = leerEntero(entrada, "Opción: ");
            CreadorVehiculo creador = seleccionarCreador(tipo, entrada);
            registrar(creador, entrada);
        } catch (IllegalArgumentException e) {
            System.out.println("No se pudo registrar el vehículo: " + e.getMessage());
        }
    }

    private static CreadorVehiculo seleccionarCreador(int tipo, Scanner entrada) {
        return switch (tipo) {
            case 1 -> new CreadorAuto();
            case 2 -> new CreadorCamioneta(
                    leerDecimal(entrada, "Capacidad (t): "),
                    leerTexto(entrada, "Uso (particular/comercial): "));
            case 3 -> new CreadorCamion(leerDecimal(entrada, "Tonelaje (t): "));
            default -> throw new IllegalArgumentException("Tipo de vehículo no soportado: " + tipo);
        };
    }

    /** Lógica principal: no depende de Auto, Camioneta ni Camion. */
    private static void registrar(CreadorVehiculo creador, Scanner entrada) {
        String placa = leerTexto(entrada, "Placa: ");
        String marca = leerTexto(entrada, "Marca: ");
        String modelo = leerTexto(entrada, "Modelo: ");
        int anio = leerEntero(entrada, "Año de fabricación: ");
        double avaluo = leerDecimal(entrada, "Avalúo: ");

        Vehiculo vehiculo = creador.crearVehiculo(placa, marca, modelo, anio, avaluo);

        System.out.println();
        System.out.println("Vehículo registrado: " + vehiculo);
        System.out.printf("Valor de matrícula: $%.2f%n", vehiculo.calcularMatricula());
    }

    private static String leerTexto(Scanner entrada, String mensaje) {
        System.out.print(mensaje);
        return entrada.nextLine().trim();
    }

    private static int leerEntero(Scanner entrada, String mensaje) {
        return Integer.parseInt(leerTexto(entrada, mensaje));
    }

    private static double leerDecimal(Scanner entrada, String mensaje) {
        return Double.parseDouble(leerTexto(entrada, mensaje));
    }
}
