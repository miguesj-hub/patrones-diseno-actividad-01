package vehiculos.producto;

/**
 * ConcreteProduct: considera principalmente el avalúo y la antigüedad.
 */
public class Auto extends Vehiculo {

    private static final double TASA_BASE = 50.0;
    private static final double PORCENTAJE_AVALUO = 0.015;

    public Auto(String placa, String marca, String modelo, int anioFabricacion, double avaluo) {
        super(placa, marca, modelo, anioFabricacion, avaluo);
    }

    @Override
    public double calcularMatricula() {
        // Descuento del 5 % por año de antigüedad, hasta un máximo del 50 %.
        double factorAntiguedad = Math.max(0.5, 1 - 0.05 * getAntiguedad());
        return TASA_BASE + getAvaluo() * PORCENTAJE_AVALUO * factorAntiguedad;
    }
}
