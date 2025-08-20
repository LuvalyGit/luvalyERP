/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import Conexion.ExeSql;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David Alcaman
 */
public class CargaGrilla {
    private static ExeSql Sql = new ExeSql();
    
    public static DefaultTableModel Carga(String Query,DefaultTableModel dfTm) throws SQLException{
        ResultSet Rs;
        ResultSetMetaData RsMd;
        int ContCol;
        
            
        try {
            Rs = Sql.Select(Query);
            RsMd = Rs.getMetaData();
            ContCol  = RsMd.getColumnCount();
            Object[] objeto = new Object[ContCol];
//            System.out.println(Query);            
            while(Rs.next()){
                for(int i=0; i<ContCol ; i++)
                {
                        objeto[i] = Rs.getObject(i+1);
                }
                dfTm.addRow(objeto);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        return dfTm;
    }
    
}
