package vehiculos.producto;

/**
 * ConcreteProduct: su cálculo depende del avalúo y del tonelaje.
 */
public class Camion extends Vehiculo {

    private static final double PORCENTAJE_AVALUO = 0.04;
    private static final double VALOR_POR_TONELADA = 50.0;

    private final double tonelaje;

    public Camion(String placa, String marca, String modelo, int anioFabricacion, double avaluo,
                  double tonelaje) {
        super(placa, marca, modelo, anioFabricacion, avaluo);
        validarNoNegativo(tonelaje, "El tonelaje");
        this.tonelaje = tonelaje;
    }

    @Override
    public double calcularMatricula() {
        return getAvaluo() * PORCENTAJE_AVALUO + tonelaje * VALOR_POR_TONELADA;
    }

    public double getTonelaje() {
        return tonelaje;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" tonelaje=%.2f t", tonelaje);
    }
}
