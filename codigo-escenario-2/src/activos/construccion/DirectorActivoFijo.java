package activos.construccion;

import java.math.BigDecimal;

/**
 * Director: inicia la construcción y establece los atributos obligatorios.
 * Los opcionales los agrega el cliente directamente sobre el builder.
 */
public class DirectorActivoFijo {

    private final ActivoFijoBuilder builder;

    public DirectorActivoFijo(ActivoFijoBuilder builder) {
        this.builder = builder;
    }

    public void construirBase(String codigo, String nombre, BigDecimal precio) {
        builder.iniciarConstruccion();
        builder.establecerCodigo(codigo);
        builder.establecerNombre(nombre);
        builder.establecerPrecio(precio);
    }
}
