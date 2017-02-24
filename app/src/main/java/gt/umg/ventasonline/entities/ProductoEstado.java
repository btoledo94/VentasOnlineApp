package gt.umg.ventasonline.entities;

/**
 * Created by BYRON TOLEDO on 2/22/2017.
 */

public class ProductoEstado {

    private Integer id;

    private String descripcion;

    private boolean activo;

    public ProductoEstado() {

    }

    public ProductoEstado(Integer id, String descripcion, boolean activo) {
        this.id = id;
        this.descripcion = descripcion;
        this.activo = activo;
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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
