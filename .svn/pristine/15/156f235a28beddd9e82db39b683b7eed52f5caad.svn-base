/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

/**
 *
 * @author luvaly
 */
import java.awt.Desktop;
import  java.io.*;  
import  java.sql.*;
import  org.apache.poi.hssf.usermodel.HSSFSheet;  
import  org.apache.poi.hssf.usermodel.HSSFWorkbook; 
import  org.apache.poi.hssf.usermodel.HSSFRow;
import  org.apache.poi.hssf.usermodel.HSSFCell;  


public class Excel {

    
    
    
    
    
    
public static void main(String[]args) throws InstantiationException, IllegalAccessException{
try{
String ruta_local="c:/fotos/";
String  archivo ="data.xls" ;
String filename;
HSSFWorkbook hwb=new HSSFWorkbook();
HSSFSheet sheet =  hwb.createSheet("new sheet");

HSSFRow rowhead=   sheet.createRow((short)0);
rowhead.createCell((short) 0).setCellValue("codigo_conv");
rowhead.createCell((short) 1).setCellValue("sku");
rowhead.createCell((short) 2).setCellValue("nombre");
rowhead.createCell((short) 3).setCellValue("valor unitario");
rowhead.createCell((short) 4).setCellValue("ult compra");
rowhead.createCell((short) 5).setCellValue("Costo promedio");
rowhead.createCell((short) 6).setCellValue("femision");
rowhead.createCell((short) 7).setCellValue("orden");
rowhead.createCell((short) 8).setCellValue("margen");
rowhead.createCell((short) 9).setCellValue("totalVta");
rowhead.createCell((short) 9).setCellValue("rut");
rowhead.createCell((short) 9).setCellValue("codigo_oc");

//Class.forName("org.postgresql.Driver");

Class.forName("org.postgresql.Driver").newInstance();
Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.0.150:5432/luvaly_final", "cramirez", "78963");
//Statement st=con.createStatement();
Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY ) ;


System.out.println("Se conecto");


java.util.Date date = new java.util.Date();    


String query = "select * from fn_all_occ(2017,5)";



ResultSet rs=st.executeQuery(query);

int numCols = rs.getMetaData().getColumnCount();


rs.last();
int numRows = rs.getRow();
rs.beforeFirst(); // esto te lo deja como al principio 
System.out.print(numRows);



int i=1;
System.out.println("inicio Ciclo " + date);
//rs.last();
//System.out.println("Registros: " + rs.getRow()); 
//rs.beforeFirst();


//--------------------ORIGINAL-----------------------------
while(rs.next()){
HSSFRow row=   sheet.createRow((short)i);
//row.createCell((short) 0).setCellValue(Integer.toString(rs.getInt("codigo")));
row.createCell((short) 1).setCellValue(rs.getString("sku"));
row.createCell((short) 2).setCellValue(rs.getString("nombre"));
row.createCell((short) 3).setCellValue(Double.toString(rs.getDouble("valorunitario")));
row.createCell((short) 3).setCellValue(Double.toString(rs.getDouble("valultcompra")));

row.createCell((short) 4).setCellValue(Double.toString(rs.getDouble("costopromedio")));
row.createCell((short) 2).setCellValue(rs.getString("femision"));
row.createCell((short) 2).setCellValue(rs.getString("orden"));
row.createCell((short) 2).setCellValue(rs.getString("Margen"));
row.createCell((short) 4).setCellValue(Double.toString(rs.getDouble("totalvta")));
row.createCell((short) 4).setCellValue(Double.toString(rs.getDouble("rut")));
row.createCell((short) 4).setCellValue(Double.toString(rs.getDouble("codigo_oc")));
i++;
}
rs.close();
java.util.Date date1 = new java.util.Date();    
System.out.println("Fin Ciclo " + date1);
filename= ruta_local + archivo;
    try (FileOutputStream fileOut = new FileOutputStream(filename)) {
        System.out.println("Copiando Archivo " + filename);
        hwb.write(fileOut);
            File pathCompleto = new File(filename);
            java.util.Date date2 = new java.util.Date();    
            System.out.println("Abriendo Archivo " + filename + " " + date2);
            Desktop.getDesktop().open(pathCompleto);  
            java.util.Date date3 = new java.util.Date();    
            System.out.println("Abriendo Archivo " + filename+ " " + date3);
            
    }
    
System.out.println("Your excel file has been generated!" + i + "Registros");

} catch ( ClassNotFoundException | SQLException | IOException ex ) {
    System.out.println(ex);

}
    }
}    		