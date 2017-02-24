package gt.umg.ventasonline.entities;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by BYRON TOLEDO on 2/22/2017.
 */

public class Producto {

    private Integer id;

    private String descripcion;

    private BigDecimal precio;

    private Date fechaIngreso;

    private Usuario usuario;

    private Categoria categoria;

    private String urlFoto;

    public Producto() {

    }

    public Producto(Integer id, String descripcion, BigDecimal precio, Date fechaIngreso, Usuario usuario, Categoria categoria, String urlFoto) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaIngreso = fechaIngreso;
        this.usuario = usuario;
        this.categoria = categoria;
        this.urlFoto = urlFoto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}
