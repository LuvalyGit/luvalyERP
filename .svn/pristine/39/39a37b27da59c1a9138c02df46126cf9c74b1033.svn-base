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
public class TableCellRendererColor_2 extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable Grilla, Object o, boolean bln, boolean bln1, int Row, int Col) {
        Component componente = super.getTableCellRendererComponent(Grilla, o, bln, bln1, Row, Col); //To change body of generated methods, choose Tools | Templates.
        int Occ;
        
        Occ = (Integer) Grilla.getValueAt(Row,8);
        
        if(Occ>0)
            componente.setForeground(Color.BLUE);
        else
            componente.setForeground(Color.BLACK);
        return componente;
    }

   
    
}
