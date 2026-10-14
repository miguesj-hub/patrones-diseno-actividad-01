package activos.construccion;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Product: activo fijo institucional. Es inmutable: solo el builder (mismo paquete) puede
 * crearlo, y únicamente cuando todos los datos obligatorios están completos.
 */
public class ActivoFijo {

    // Obligatorios
    private final String codigoInstitucional;
    private final String nombreDescripcion;
    private final BigDecimal precioAdquisicion;

    // Opcionales
    private final String tipoActivo;
    private final String marca;
    private final String modelo;
    private final String numeroSerie;
    private final String ubicacion;
    private final String custodioResponsable;
    private final LocalDate fechaAdquisicion;
    private final Integer periodoGarantia;
    private final String proveedor;
    private final Map<String, String> caracteristicasTecnicas;
    private final String observaciones;

    ActivoFijo(String codigoInstitucional, String nombreDescripcion, BigDecimal precioAdquisicion,
               String tipoActivo, String marca, String modelo, String numeroSerie, String ubicacion,
               String custodioResponsable, LocalDate fechaAdquisicion, Integer periodoGarantia,
               String proveedor, Map<String, String> caracteristicasTecnicas, String observaciones) {
        this.codigoInstitucional = codigoInstitucional;
        this.nombreDescripcion = nombreDescripcion;
        this.precioAdquisicion = precioAdquisicion;
        this.tipoActivo = tipoActivo;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroSerie = numeroSerie;
        this.ubicacion = ubicacion;
        this.custodioResponsable = custodioResponsable;
        this.fechaAdquisicion = fechaAdquisicion;
        this.periodoGarantia = periodoGarantia;
        this.proveedor = proveedor;
        this.caracteristicasTecnicas = Collections.unmodifiableMap(new LinkedHashMap<>(caracteristicasTecnicas));
        this.observaciones = observaciones;
    }

    public String getCodigoInstitucional() {
        return codigoInstitucional;
    }

    public String getNombreDescripcion() {
        return nombreDescripcion;
    }

    public BigDecimal getPrecioAdquisicion() {
        return precioAdquisicion;
    }

    public String getTipoActivo() {
        return tipoActivo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getCustodioResponsable() {
        return custodioResponsable;
    }

    public LocalDate getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public Integer getPeriodoGarantia() {
        return periodoGarantia;
    }

    public String getProveedor() {
        return proveedor;
    }

    /** Vista no modificable de las características técnicas (clave → valor). */
    public Map<String, String> getCaracteristicasTecnicas() {
        return caracteristicasTecnicas;
    }

    public String getObservaciones() {
        return observaciones;
    }

    /** Muestra solo los datos registrados; los opcionales no establecidos se omiten. */
    @Override
    public String toString() {
        Map<String, Object> datos = new LinkedHashMap<>();
        datos.put("código", codigoInstitucional);
        datos.put("nombre", nombreDescripcion);
        datos.put("precio", precioAdquisicion);
        datos.put("tipo", tipoActivo);
        datos.put("marca", marca);
        datos.put("modelo", modelo);
        datos.put("número de serie", numeroSerie);
        datos.put("ubicación", ubicacion);
        datos.put("custodio", custodioResponsable);
        datos.put("fecha de adquisición", fechaAdquisicion);
        datos.put("garantía (meses)", periodoGarantia);
        datos.put("proveedor", proveedor);
        datos.put("características", caracteristicasTecnicas.isEmpty() ? null : caracteristicasTecnicas);
        datos.put("observaciones", observaciones);

        StringJoiner texto = new StringJoiner("\n  ", "ActivoFijo\n  ", "");
        datos.forEach((campo, valor) -> {
            if (valor != null) {
                texto.add(campo + ": " + valor);
            }
        });
        return texto.toString();
    }
}
