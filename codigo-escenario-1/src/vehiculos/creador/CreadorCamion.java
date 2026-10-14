package vehiculos.creador;

import vehiculos.producto.Camion;
import vehiculos.producto.Vehiculo;

/**
 * ConcreteCreator: crea instancias de Camion con los datos proporcionados por el cliente.
 */
public class CreadorCamion extends CreadorVehiculo {

    private final String placa;
    private final String marca;
    private final String modelo;
    private final int anioFabricacion;
    private final double avaluo;
    private final double tonelaje;

    public CreadorCamion(String placa, String marca, String modelo, int anioFabricacion, double avaluo,
                         double tonelaje) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.avaluo = avaluo;
        this.tonelaje = tonelaje;
    }

    @Override
    public Vehiculo crearVehiculo() {
        return new Camion(placa, marca, modelo, anioFabricacion, avaluo, tonelaje);
    }
}
