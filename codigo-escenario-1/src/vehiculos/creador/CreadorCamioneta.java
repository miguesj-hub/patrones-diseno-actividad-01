package vehiculos.creador;

import vehiculos.producto.Camioneta;
import vehiculos.producto.Vehiculo;

/**
 * ConcreteCreator: crea instancias de Camioneta; conoce su capacidad y uso.
 */
public class CreadorCamioneta extends CreadorVehiculo {

    private final double capacidad;
    private final String uso;

    public CreadorCamioneta(double capacidad, String uso) {
        this.capacidad = capacidad;
        this.uso = uso;
    }

    @Override
    public Vehiculo crearVehiculo(String placa, String marca, String modelo,
                                  int anioFabricacion, double avaluo) {
        return new Camioneta(placa, marca, modelo, anioFabricacion, avaluo, capacidad, uso);
    }
}
