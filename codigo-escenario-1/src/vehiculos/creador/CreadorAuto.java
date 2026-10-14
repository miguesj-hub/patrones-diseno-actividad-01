package vehiculos.creador;

import vehiculos.producto.Auto;
import vehiculos.producto.Vehiculo;

/**
 * ConcreteCreator: crea instancias de Auto con los datos proporcionados por el cliente.
 */
public class CreadorAuto extends CreadorVehiculo {

    private final String placa;
    private final String marca;
    private final String modelo;
    private final int anioFabricacion;
    private final double avaluo;

    public CreadorAuto(String placa, String marca, String modelo, int anioFabricacion, double avaluo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.avaluo = avaluo;
    }

    @Override
    public Vehiculo crearVehiculo() {
        return new Auto(placa, marca, modelo, anioFabricacion, avaluo);
    }
}
