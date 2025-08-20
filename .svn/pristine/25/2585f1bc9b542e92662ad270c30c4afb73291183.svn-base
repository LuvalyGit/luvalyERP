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
 * @author infornatica
 */
public class TableCellSkuRepetido extends DefaultTableCellRenderer {
    
    String sku;

    public TableCellSkuRepetido(String sku) {
        this.sku = sku;
    }
    public String getSku() {
        return this.sku;
    }
    @Override
    public Component getTableCellRendererComponent(JTable Grilla, Object o, boolean bln, boolean bln1, int Row, int Col) {
        Component componente = super.getTableCellRendererComponent(Grilla, o, bln, bln1, Row, Col); //To change body of generated methods, choose Tools | Templates.
        if(!Grilla.isRowSelected(Row)){
            if(Grilla.getValueAt(Row, 0).toString().equals(getSku())){
                componente.setBackground(Color.RED);
                componente.setForeground(Color.black);
            }
            else if(Grilla.getValueAt(Row, 2).toString().equals("Tiene Relación")){
                componente.setBackground(Color.yellow);
                componente.setForeground(Color.black);
            }
            else {
                componente.setBackground(Color.WHITE);
                componente.setForeground(Color.black);
            }
        }

        else {
            componente.setBackground(Color.BLUE);
            componente.setForeground(Color.white);
        }
        return componente;
    }
 }