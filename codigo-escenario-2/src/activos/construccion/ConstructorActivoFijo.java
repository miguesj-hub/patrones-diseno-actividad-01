package activos.construccion;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ConcreteBuilder: mantiene los datos en construcción, valida los atributos obligatorios
 * y crea el producto final en obtenerActivo().
 */
public class ConstructorActivoFijo implements ActivoFijoBuilder {

    private String codigo;
    private String nombre;
    private BigDecimal precio;
    private String tipo;
    private String marca;
    private String modelo;
    private String numeroSerie;
    private String ubicacion;
    private String custodio;
    private LocalDate fechaAdquisicion;
    private Integer garantia;
    private String proveedor;
    private Map<String, String> caracteristicas = new LinkedHashMap<>();
    private String observaciones;

    @Override
    public void iniciarConstruccion() {
        codigo = null;
        nombre = null;
        precio = null;
        tipo = null;
        marca = null;
        modelo = null;
        numeroSerie = null;
        ubicacion = null;
        custodio = null;
        fechaAdquisicion = null;
        garantia = null;
        proveedor = null;
        caracteristicas = new LinkedHashMap<>();
        observaciones = null;
    }

    @Override
    public void establecerCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public void establecerNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void establecerPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @Override
    public void establecerTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void establecerMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public void establecerModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public void establecerNumeroSerie(String numero) {
        this.numeroSerie = numero;
    }

    @Override
    public void establecerUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public void establecerCustodio(String custodio) {
        this.custodio = custodio;
    }

    @Override
    public void establecerFechaAdquisicion(LocalDate fecha) {
        if (fecha != null && fecha.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de adquisición no puede ser futura");
        }
        this.fechaAdquisicion = fecha;
    }

    @Override
    public void establecerGarantia(Integer meses) {
        if (meses != null && meses < 0) {
            throw new IllegalArgumentException("El período de garantía no puede ser negativo");
        }
        this.garantia = meses;
    }

    @Override
    public void establecerProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public void establecerCaracteristica(String clave, String valor) {
        if (esVacio(clave)) {
            throw new IllegalArgumentException("La clave de la característica no puede estar vacía");
        }
        caracteristicas.put(clave, valor);
    }

    @Override
    public void establecerObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * Valida los atributos obligatorios y crea el activo. Al terminar, el builder se
     * reinicia para poder construir otro activo sin arrastrar datos del anterior.
     */
    @Override
    public ActivoFijo obtenerActivo() {
        if (esVacio(codigo)) {
            throw new IllegalStateException("Falta el código institucional");
        }
        if (esVacio(nombre)) {
            throw new IllegalStateException("Falta el nombre o descripción");
        }
        if (precio == null || precio.signum() <= 0) {
            throw new IllegalStateException("Falta el precio de adquisición o no es mayor que cero");
        }
        ActivoFijo resultado = new ActivoFijo(codigo, nombre, precio, tipo, marca, modelo, numeroSerie,
                ubicacion, custodio, fechaAdquisicion, garantia, proveedor, caracteristicas, observaciones);
        iniciarConstruccion();
        return resultado;
    }

    private static boolean esVacio(String valor) {
        return valor == null || valor.isBlank();
    }
}
