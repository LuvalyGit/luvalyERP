package Utilidades;

public class Combo_CodStr {
    private String nombre; //1
    private String  Codigo_str;
    private int  Codigo_int;
    
 
    public Combo_CodStr(String nombre, String id, int CodId){ //2
        this.nombre=nombre;
        this.Codigo_str=id;
        this.Codigo_int = CodId;
        
    }
 
    public String  getId(){ //3
        return Codigo_str;
    }
    
    public int  getCodId(){ //3
        return Codigo_int;
    }
    
 
    @Override
    public String toString(){ //4
        return nombre;
    }    
}
