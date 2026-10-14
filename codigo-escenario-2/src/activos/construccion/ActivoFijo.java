package activos.construccion;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Product: activo fijo institucional. Solo puede ser configurado por el builder
 * (constructor y setters con visibilidad de paquete); el cliente únicamente lo consulta.
 */
public class ActivoFijo {

    // Obligatorios
    private String codigoInstitucional;
    private String nombreDescripcion;
    private BigDecimal precioAdquisicion;

    // Opcionales
    private String tipoActivo;
    private String marca;
    private String modelo;
    private String numeroSerie;
    private String ubicacion;
    private String custodioResponsable;
    private LocalDate fechaAdquisicion;
    private Integer periodoGarantia;
    private String proveedor;
    private String caracteristicasTecnicas;
    private String observaciones;

    ActivoFijo() {
    }

    void setCodigoInstitucional(String codigoInstitucional) {
        this.codigoInstitucional = codigoInstitucional;
    }

    void setNombreDescripcion(String nombreDescripcion) {
        this.nombreDescripcion = nombreDescripcion;
    }

    void setPrecioAdquisicion(BigDecimal precioAdquisicion) {
        this.precioAdquisicion = precioAdquisicion;
    }

    void setTipoActivo(String tipoActivo) {
        this.tipoActivo = tipoActivo;
    }

    void setMarca(String marca) {
        this.marca = marca;
    }

    void setModelo(String modelo) {
        this.modelo = modelo;
    }

    void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    void setCustodioResponsable(String custodioResponsable) {
        this.custodioResponsable = custodioResponsable;
    }

    void setFechaAdquisicion(LocalDate fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    void setPeriodoGarantia(Integer periodoGarantia) {
        this.periodoGarantia = periodoGarantia;
    }

    void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    void setCaracteristicasTecnicas(String caracteristicasTecnicas) {
        this.caracteristicasTecnicas = caracteristicasTecnicas;
    }

    void setObservaciones(String observaciones) {
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

    public String getCaracteristicasTecnicas() {
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
        datos.put("características", caracteristicasTecnicas);
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
