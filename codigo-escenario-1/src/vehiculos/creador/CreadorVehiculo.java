package vehiculos.creador;

import vehiculos.producto.Vehiculo;

/**
 * Creator: declara el Factory Method. Las subclases deciden qué vehículo concreto crear.
 */
public abstract class CreadorVehiculo {

    public abstract Vehiculo crearVehiculo();
}
