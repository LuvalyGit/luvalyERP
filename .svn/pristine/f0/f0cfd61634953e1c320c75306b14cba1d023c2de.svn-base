/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.font.TextAttribute;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author David Alcaman
 */
public class TableCellRendererColor extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable Grilla, Object o, boolean bln, boolean bln1, int Row, int Col) {
        Component componente = super.getTableCellRendererComponent(Grilla, o, bln, bln1, Row, Col); //To change body of generated methods, choose Tools | Templates.
        
        
        
        if(Grilla.getValueAt(Row, 0).toString().isEmpty()){
            //componente.setForeground(Color.RED);
            componente.setFont(new Font("Arial", Font.BOLD, 14));
        }
        return componente;
    }

   
    
}
