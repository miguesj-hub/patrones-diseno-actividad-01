package vehiculos.creador;

import vehiculos.producto.Auto;
import vehiculos.producto.Vehiculo;

/**
 * ConcreteCreator: crea instancias de Auto.
 */
public class CreadorAuto extends CreadorVehiculo {

    @Override
    public Vehiculo crearVehiculo(String placa, String marca, String modelo,
                                  int anioFabricacion, double avaluo) {
        return new Auto(placa, marca, modelo, anioFabricacion, avaluo);
    }
}
