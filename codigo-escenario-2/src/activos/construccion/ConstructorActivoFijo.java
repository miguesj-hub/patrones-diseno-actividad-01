package activos.construccion;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * ConcreteBuilder: configura el activo paso a paso, valida los atributos obligatorios
 * y entrega el producto final.
 */
public class ConstructorActivoFijo implements ActivoFijoBuilder {

    private ActivoFijo activo;

    @Override
    public void iniciarConstruccion() {
        activo = new ActivoFijo();
    }

    @Override
    public void establecerCodigo(String codigo) {
        enConstruccion().setCodigoInstitucional(codigo);
    }

    @Override
    public void establecerNombre(String nombre) {
        enConstruccion().setNombreDescripcion(nombre);
    }

    @Override
    public void establecerPrecio(BigDecimal precio) {
        if (precio != null && precio.signum() <= 0) {
            throw new IllegalArgumentException("El precio de adquisición debe ser mayor que cero");
        }
        enConstruccion().setPrecioAdquisicion(precio);
    }

    @Override
    public void establecerTipo(String tipo) {
        enConstruccion().setTipoActivo(tipo);
    }

    @Override
    public void establecerMarca(String marca) {
        enConstruccion().setMarca(marca);
    }

    @Override
    public void establecerModelo(String modelo) {
        enConstruccion().setModelo(modelo);
    }

    @Override
    public void establecerNumeroSerie(String numero) {
        enConstruccion().setNumeroSerie(numero);
    }

    @Override
    public void establecerUbicacion(String ubicacion) {
        enConstruccion().setUbicacion(ubicacion);
    }

    @Override
    public void establecerCustodio(String custodio) {
        enConstruccion().setCustodioResponsable(custodio);
    }

    @Override
    public void establecerFechaAdquisicion(LocalDate fecha) {
        if (fecha != null && fecha.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de adquisición no puede ser futura");
        }
        enConstruccion().setFechaAdquisicion(fecha);
    }

    @Override
    public void establecerGarantia(Integer meses) {
        if (meses != null && meses < 0) {
            throw new IllegalArgumentException("El período de garantía no puede ser negativo");
        }
        enConstruccion().setPeriodoGarantia(meses);
    }

    @Override
    public void establecerProveedor(String proveedor) {
        enConstruccion().setProveedor(proveedor);
    }

    @Override
    public void establecerCaracteristicas(String detalle) {
        enConstruccion().setCaracteristicasTecnicas(detalle);
    }

    @Override
    public void establecerObservaciones(String observaciones) {
        enConstruccion().setObservaciones(observaciones);
    }

    /**
     * Valida los atributos obligatorios y entrega el activo. El builder queda libre
     * para iniciar una nueva construcción.
     */
    @Override
    public ActivoFijo obtenerActivo() {
        ActivoFijo resultado = enConstruccion();
        if (esVacio(resultado.getCodigoInstitucional())) {
            throw new IllegalStateException("Falta el código institucional");
        }
        if (esVacio(resultado.getNombreDescripcion())) {
            throw new IllegalStateException("Falta el nombre o descripción");
        }
        if (resultado.getPrecioAdquisicion() == null) {
            throw new IllegalStateException("Falta el precio de adquisición");
        }
        activo = null;
        return resultado;
    }

    private ActivoFijo enConstruccion() {
        if (activo == null) {
            throw new IllegalStateException("Debe llamar a iniciarConstruccion() primero");
        }
        return activo;
    }

    private static boolean esVacio(String valor) {
        return valor == null || valor.isBlank();
    }
}
