package activos.construccion;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Builder: declara los pasos para construir un activo fijo.
 */
public interface ActivoFijoBuilder {

    void iniciarConstruccion();

    void establecerCodigo(String codigo);

    void establecerNombre(String nombre);

    void establecerPrecio(BigDecimal precio);

    void establecerTipo(String tipo);

    void establecerMarca(String marca);

    void establecerModelo(String modelo);

    void establecerNumeroSerie(String numero);

    void establecerUbicacion(String ubicacion);

    void establecerCustodio(String custodio);

    void establecerFechaAdquisicion(LocalDate fecha);

    void establecerGarantia(Integer meses);

    void establecerProveedor(String proveedor);

    void establecerCaracteristicas(String detalle);

    void establecerObservaciones(String observaciones);

    ActivoFijo obtenerActivo();
}
