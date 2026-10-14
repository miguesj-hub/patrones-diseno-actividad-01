package vehiculos.producto;

/**
 * ConcreteProduct: además del avalúo y la antigüedad, incorpora su capacidad y uso.
 */
public class Camioneta extends Vehiculo {

    private static final double TASA_BASE = 70.0;
    private static final double PORCENTAJE_AVALUO = 0.02;
    private static final double VALOR_POR_TONELADA = 15.0;
    private static final double RECARGO_USO_COMERCIAL = 0.20;

    private final double capacidad;
    private final String uso;

    public Camioneta(String placa, String marca, String modelo, int anioFabricacion, double avaluo,
                     double capacidad, String uso) {
        super(placa, marca, modelo, anioFabricacion, avaluo);
        if (capacidad < 0) {
            throw new IllegalArgumentException("La capacidad no puede ser negativa");
        }
        this.capacidad = capacidad;
        this.uso = uso;
    }

    @Override
    public double calcularMatricula() {
        double factorAntiguedad = Math.max(0.5, 1 - 0.04 * getAntiguedad());
        double valor = TASA_BASE
                + getAvaluo() * PORCENTAJE_AVALUO * factorAntiguedad
                + capacidad * VALOR_POR_TONELADA;
        if ("comercial".equalsIgnoreCase(uso)) {
            valor *= 1 + RECARGO_USO_COMERCIAL;
        }
        return valor;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public String getUso() {
        return uso;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" capacidad=%.2f t, uso=%s", capacidad, uso);
    }
}
