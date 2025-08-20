/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author David Alcaman
 */
public class TableCellRenderer_Proveedor extends DefaultTableCellRenderer{
    

@Override
    public Component  getTableCellRendererComponent(JTable table, Object  
       value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        Component componente = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.           
        
        
            
            if(row == table.getSelectedRow()){
                componente.setBackground(Color.blue);
                componente.setForeground(Color.white);
                
            }
            else {
                if(table.getValueAt(row, 14).toString().trim().equals("1")){   
                    componente.setBackground(Color.yellow);
                    componente.setForeground(Color.black);
                }
                else{
                    componente.setForeground(Color.black);
                    componente.setBackground(Color.white); 
                }
            }
        return componente;
        

    } 
    
    
}