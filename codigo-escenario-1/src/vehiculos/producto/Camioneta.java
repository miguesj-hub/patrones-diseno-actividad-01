package vehiculos.producto;

/**
 * ConcreteProduct: además del avalúo, incorpora su capacidad y uso.
 */
public class Camioneta extends Vehiculo {

    private static final double PORCENTAJE_AVALUO = 0.03;
    private static final double VALOR_POR_TONELADA = 20.0;
    private static final double RECARGO_USO_COMERCIAL = 0.15;

    private final double capacidad;
    private final String uso;

    public Camioneta(String placa, String marca, String modelo, int anioFabricacion, double avaluo,
                     double capacidad, String uso) {
        super(placa, marca, modelo, anioFabricacion, avaluo);
        validarNoNegativo(capacidad, "La capacidad");
        if (uso == null || uso.isBlank()) {
            throw new IllegalArgumentException("El uso es obligatorio");
        }
        this.capacidad = capacidad;
        this.uso = uso;
    }

    @Override
    public double calcularMatricula() {
        double valor = getAvaluo() * PORCENTAJE_AVALUO + capacidad * VALOR_POR_TONELADA;
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
