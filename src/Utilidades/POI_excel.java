/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

/**
 *
 * @author David Alcaman
 */
public class POI_excel {
    public DefaultTableModel ImportarExcel2010(String Ruta) throws IOException{
        FileInputStream file = new FileInputStream(new File(Ruta));     //<-- Se carga el archivo desde la Ruta
	HSSFWorkbook workbook = new HSSFWorkbook(file);                 //<-- Crear el objeto que tendra el libro de Excel
        HSSFSheet sheet = workbook.getSheetAt(0);                       //<-- Se abre la primera hoja
	Iterator<Row> rowIterator = sheet.iterator();                   //<-- Se carga Iterador que recorrera el libro Excel.
        Row row;
        DefaultTableModel TModel = new DefaultTableModel();
        
        // Recorre todas las filas
        while (rowIterator.hasNext()){
            row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
	    Cell celda;
            
            //Recorremos celdas de una fila
            while (cellIterator.hasNext()){
                celda = cellIterator.next();
                // Dependiendo del formato de la celda el valor se debe mostrar como String, Fecha, boolean, entero...
		switch(celda.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC:
		    if( HSSFDateUtil.isCellDateFormatted(celda) ){
		       System.out.println(celda.getDateCellValue());
		    }else{
		       System.out.println(celda.getNumericCellValue());
		    }
		    System.out.println(celda.getNumericCellValue());
		    break;
		case Cell.CELL_TYPE_STRING:
		    System.out.println(celda.getStringCellValue());
		    break;
		case Cell.CELL_TYPE_BOOLEAN:
		    System.out.println(celda.getBooleanCellValue());
		    break;
		}
            }
            
        }
        
        return TModel;
    }
}
