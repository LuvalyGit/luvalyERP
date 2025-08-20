
package Utilidades;


import Formularios.fmMain;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JTable;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;


/**
 *
 * @author David Alcaman
 */
public class Exporterxls {
    private File file;
    private JTable tabla;
    private String nom_archivo;
    FileWriter flarchivo = null;
        

    public Exporterxls(File file, JTable tabla, String nom_archivo) throws Exception {
        
        this.file = file;
        this.tabla = tabla;
        this.nom_archivo = nom_archivo;
        
    }
    
    public boolean export(){
        
        try {
            
            String col11 = "";
            flarchivo = new FileWriter(file);
            //crea un buffer o flujo intermedio antes de escribir directamente en el archivo
            BufferedWriter bfarchivo = new BufferedWriter(flarchivo);
            
//            bfarchivo.write("Rut,Proveedor,O.C.P.,Origen,Nro. Docto.,Fecha, Sku,Descripción, Precio Unitario,Precio Ajustado, Diferencia, Emisor\r");
            bfarchivo.write("Rut;Proveedor;O.C.P.;Origen;Nro. Docto.;Fecha; Sku;Descripción; Precio Unitario;Precio Ajustado; Diferencia; Emisor\r");
            
            for(int i=0; i< tabla.getRowCount();i++){
            
                if (tabla.getValueAt(i,11) == null) {
                    
                    col11 = "";
                   
                }else{
                
                  col11 = tabla.getValueAt(i,11).toString();   //Precio Normal
                }
                
                String col0 = tabla.getValueAt(i,0).toString();   //rut provvedor
                String col1 = tabla.getValueAt(i,1).toString();   //nombre proveedor
                String col2 = tabla.getValueAt(i,2).toString();   //Orden de Compra Proveedor
                String col3 = tabla.getValueAt(i,3).toString();   //Tipo documento Origen
                String col4 = tabla.getValueAt(i,4).toString();   //Número documento Origen
                String col5 = tabla.getValueAt(i,5).toString();   //Fecha Emision documento Origen
                String col6 = tabla.getValueAt(i,6).toString();   //Sku
                String col7 = tabla.getValueAt(i,7).toString();   //Descripcion del Producto
                String col8 = tabla.getValueAt(i,8).toString();   //Precio Unitario (anterior)
                String col9 = tabla.getValueAt(i,9).toString();   //Precio Ajustado
                String col10 = tabla.getValueAt(i,10).toString();   //Diferencia
               
                
                if (col1.contains(";")){
                
                    col1 = col1.replaceAll(";", ",");
                }
                
                if (col3.contains(",")){
                
                    col3 = col3.replaceAll(";", ",");
                }
      
                if (col8.contains(",") && col8.contains(".")){
                
                    col8 = col8.replace(".", ",");
                    col8 = col8.replaceFirst(",", ".");
                   
                }else{
                    
                    col8 = col8.replace(".", ",");
                   
                }
                
                
                if (col9.contains(",") && col9.contains(".")){
                
                    col9 = col9.replace(".", ",");
                    col9 = col9.replaceFirst(",", ".");
                   
                }else{
                    
                    col9 = col9.replace(".", ",");
                   
                }
                
                
                if (col10.contains(",") && col10.contains(".")){
                
                    col10 = col10.replace(".", ",");
                    col10 = col10.replaceFirst(",", ".");
                   
                }else{
                    
                    col10 = col10.replace(".", ",");
                   
                }
                
                
                bfarchivo.write(col0+";"+col1+";"+col2+";"+col3+";"+col4+";"+col5+";"+col6+";"+col7+";"+col8+
                                ";"+col9+";"+col10+";"+col11+"\r");
            
            }
            
            bfarchivo.close();
            
            if (flarchivo != null) {
		
                try {              
	    	    
                    flarchivo.close();   //cierra el flujo principal
                   
                }catch (IOException e){
		
                    e.printStackTrace();
		
                }
                
	    }
            return true;   

        } catch (IOException e) {
            return false;
        
        }
    }
    
}
