package Utilidades;

public class Unidades {
    public String texto;
    public int id;
    
    public Unidades(String nombre, int id){ //2
        this.texto=nombre;
        this.id=id;
    }
    
    public String toString() {
        return texto;
    }
    @Override  
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (!(o instanceof Unidades)) {
            return false;
        }
        Unidades provincia = (Unidades) o;
        if (id != provincia.id) {
            return false;
        }
        if (texto != null ? !texto.equals(provincia.texto) : provincia.texto != null) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.texto != null ? this.texto.hashCode() : 0);
        hash = 89 * hash + this.id;
        return hash;
    }
}