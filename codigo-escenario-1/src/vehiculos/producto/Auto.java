package vehiculos.producto;

/**
 * ConcreteProduct: considera principalmente el avalúo y la antigüedad.
 */
public class Auto extends Vehiculo {

    private static final double PORCENTAJE_AVALUO = 0.02;
    private static final double PORCENTAJE_POR_ANIO = 0.01;
    private static final double PORCENTAJE_MAXIMO_ANTIGUEDAD = 0.10;

    public Auto(String placa, String marca, String modelo, int anioFabricacion, double avaluo) {
        super(placa, marca, modelo, anioFabricacion, avaluo);
    }

    @Override
    public double calcularMatricula() {
        // 2 % del avalúo + 1 % por año de antigüedad (el recargo por antigüedad llega como máximo al 10 %).
        double porcentajeAntiguedad = Math.min(PORCENTAJE_MAXIMO_ANTIGUEDAD, PORCENTAJE_POR_ANIO * antiguedad());
        return getAvaluo() * (PORCENTAJE_AVALUO + porcentajeAntiguedad);
    }
}
