package vehiculos.creador;

import vehiculos.producto.Camion;
import vehiculos.producto.Vehiculo;

/**
 * ConcreteCreator: crea instancias de Camion; conoce su tonelaje.
 */
public class CreadorCamion extends CreadorVehiculo {

    private final double tonelaje;

    public CreadorCamion(double tonelaje) {
        this.tonelaje = tonelaje;
    }

    @Override
    public Vehiculo crearVehiculo(String placa, String marca, String modelo,
                                  int anioFabricacion, double avaluo) {
        return new Camion(placa, marca, modelo, anioFabricacion, avaluo, tonelaje);
    }
}
