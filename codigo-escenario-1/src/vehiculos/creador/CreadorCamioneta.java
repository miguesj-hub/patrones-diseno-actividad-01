package vehiculos.creador;

import vehiculos.producto.Camioneta;
import vehiculos.producto.Vehiculo;

/**
 * ConcreteCreator: crea instancias de Camioneta con los datos proporcionados por el cliente.
 */
public class CreadorCamioneta extends CreadorVehiculo {

    private final String placa;
    private final String marca;
    private final String modelo;
    private final int anioFabricacion;
    private final double avaluo;
    private final double capacidad;
    private final String uso;

    public CreadorCamioneta(String placa, String marca, String modelo, int anioFabricacion, double avaluo,
                            double capacidad, String uso) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.avaluo = avaluo;
        this.capacidad = capacidad;
        this.uso = uso;
    }

    @Override
    public Vehiculo crearVehiculo() {
        return new Camioneta(placa, marca, modelo, anioFabricacion, avaluo, capacidad, uso);
    }
}
