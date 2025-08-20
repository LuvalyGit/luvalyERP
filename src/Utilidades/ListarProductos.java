
package Utilidades;

public class ListarProductos {
    private String codigo;
    private String nombre;
    private String um;
    private String cantidad;
    private String valorunitario;
    private String totallinea;
    private String codprv;
    


    public ListarProductos(String codigo, String nombre, String um, String cantidad, String valorunitario, String totallinea, String codprv) {
        this.codigo = codigo.trim();
        this.nombre = nombre;
        this.um = um;
        this.cantidad = cantidad;
        this.valorunitario = valorunitario;
        this.totallinea = totallinea;
        this.codprv= codprv;
        
        
    }
    
    public void setCodprv(String codprv) {
         this.codprv= codprv;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUm(String um) {
        this.um = um;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public void setValorunitario(String valorunitario) {
        this.valorunitario = valorunitario;
    }

    public void setTotallinea(String totallinea) {
        this.totallinea = totallinea;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUm() {
        return um;
    }

    public String getCantidad() {
        return cantidad;
    }

    public String getValorunitario() {
        return valorunitario;
    }

    public String getTotallinea() {
        return totallinea;
    }
    
    public String getCodprv() {
        return codprv;
    }
}
