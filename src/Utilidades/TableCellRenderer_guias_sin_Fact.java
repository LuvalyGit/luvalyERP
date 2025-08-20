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
public class TableCellRenderer_guias_sin_Fact extends DefaultTableCellRenderer{

   @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        javax.swing.JTextArea etiqueta = new javax.swing.JTextArea();
       
        
        etiqueta.setRows(10);           
       
        if(value instanceof String)
            etiqueta.setText((String)value);
        return etiqueta;
    }
}

