package vehiculos.producto;

/**
 * ConcreteProduct: su cálculo depende principalmente del tonelaje.
 */
public class Camion extends Vehiculo {

    private static final double TASA_BASE = 120.0;
    private static final double PORCENTAJE_AVALUO = 0.01;
    private static final double VALOR_POR_TONELADA = 30.0;

    private final double tonelaje;

    public Camion(String placa, String marca, String modelo, int anioFabricacion, double avaluo,
                  double tonelaje) {
        super(placa, marca, modelo, anioFabricacion, avaluo);
        if (tonelaje <= 0) {
            throw new IllegalArgumentException("El tonelaje debe ser mayor que cero");
        }
        this.tonelaje = tonelaje;
    }

    @Override
    public double calcularMatricula() {
        return TASA_BASE + getAvaluo() * PORCENTAJE_AVALUO + tonelaje * VALOR_POR_TONELADA;
    }

    public double getTonelaje() {
        return tonelaje;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" tonelaje=%.2f t", tonelaje);
    }
}
