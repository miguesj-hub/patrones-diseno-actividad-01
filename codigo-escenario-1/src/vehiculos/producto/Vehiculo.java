package vehiculos.producto;

import java.time.Year;

/**
 * Product: contrato común para todos los vehículos.
 * Cada subclase define su propia lógica de cálculo de matrícula.
 */
public abstract class Vehiculo {

    private static final int ANIO_MINIMO = 1900;

    private final String placa;
    private final String marca;
    private final String modelo;
    private final int anioFabricacion;
    private final double avaluo;

    protected Vehiculo(String placa, String marca, String modelo, int anioFabricacion, double avaluo) {
        if (placa == null || placa.isBlank()) {
            throw new IllegalArgumentException("La placa es obligatoria");
        }
        if (anioFabricacion < ANIO_MINIMO || anioFabricacion > Year.now().getValue()) {
            throw new IllegalArgumentException(
                    "El año de fabricación debe estar entre " + ANIO_MINIMO + " y " + Year.now().getValue());
        }
        validarNoNegativo(avaluo, "El avalúo");
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.avaluo = avaluo;
    }

    public abstract double calcularMatricula();

    /** Evita repetir en cada subclase la validación de valores no negativos. */
    protected static void validarNoNegativo(double valor, String nombre) {
        if (valor < 0) {
            throw new IllegalArgumentException(nombre + " no puede ser negativo");
        }
    }

    /** Años transcurridos desde la fabricación; usado por las subclases en su cálculo. */
    protected int antiguedad() {
        return Year.now().getValue() - anioFabricacion;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public double getAvaluo() {
        return avaluo;
    }

    @Override
    public String toString() {
        return String.format("%s [placa=%s, marca=%s, modelo=%s, año=%d, avalúo=%.2f]",
                getClass().getSimpleName(), placa, marca, modelo, anioFabricacion, avaluo);
    }
}
