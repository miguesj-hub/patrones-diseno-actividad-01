package vehiculos.creador;

import vehiculos.producto.Vehiculo;

/**
 * Creator: declara el Factory Method. Recibe los atributos comunes y las subclases
 * deciden qué vehículo concreto crear.
 */
public abstract class CreadorVehiculo {

    public abstract Vehiculo crearVehiculo(String placa, String marca, String modelo,
                                           int anioFabricacion, double avaluo);
}
