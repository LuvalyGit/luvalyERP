
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
public class Exportercsv {
    private File file;
    private JTable tabla;
    private String nom_archivo;
    FileWriter flarchivo = null;
        

    public Exportercsv(File file, JTable tabla, String nom_archivo) throws Exception {
        
        this.file = file;
        this.tabla = tabla;
        this.nom_archivo = nom_archivo;
        
    }
    
    public boolean export(){
        
        try {
            
            flarchivo = new FileWriter(file);
            //crea un buffer o flujo intermedio antes de escribir directamente en el archivo
            BufferedWriter bfarchivo = new BufferedWriter(flarchivo);
            
            bfarchivo.write("ID,Tipo,SKU,Nombre,Publicado,¿Está destacado?,Visibilidad en el catálogo,Descripción corta,Descripción,"+
                            "Día en que empieza el precio rebajado,Día en que termina el precio rebajado,Estado del impuesto,"+
                            "Clase de impuesto,¿En inventario?,Inventario,Cantidad de bajo inventario,¿Permitir reservas de productos agotados?,"+
                            "¿Vendido individualmente?,Peso (kg),Longitud (cm),¿Permitir valoraciones de clientes?,Ancho (cm),Altura (cm),"+
                            "Nota de compra,Precio rebajado,Precio normal,Categorias,Etiquetas,Clase de envío,Imágenes,Límite de descargas,"+
                            "Días de caducidad de la descarga,Superior,Productos agrupados,Ventas dirigidas,Ventas cruzadas,URL externa,"+
                            "Texto del botón,Posición,IDCM\r");
            
            for(int i=0; i< tabla.getRowCount();i++){
            
                String col0 = tabla.getValueAt(i,0).toString();   //sku
                String col1 = tabla.getValueAt(i,1).toString();   //nombre
                String col2 = tabla.getValueAt(i,2).toString();   //publicado
                String col3 = tabla.getValueAt(i,3).toString();   //categoria
                String col4 = tabla.getValueAt(i,4).toString();   //IDCM
                String col5 = tabla.getValueAt(i,5).toString();   //Precio Normal
                
                
                if (col1.contains(",")){
                
                    col1 = col1.replaceAll(",", " ");
                }
                
                if (col3.contains(",")){
                
                    col3 = col3.replaceAll(",", " ");
                }
                
                bfarchivo.write(","+"simple,"+col0+","+col1+","+col2+",,visible,,,,,,,,,,,,,,,,,,,"+col5+","+col3+",,,,,,,,,,,,,"+col4+"\r");
            
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
