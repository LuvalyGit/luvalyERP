package Utilidades;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author darta_000
 */
public class TableCellRendererBuscaProducto extends DefaultTableCellRenderer {
    
    private Component c;
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                
        c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //Para cambiar la fila 
        
        boolean notr = (Boolean) table.getValueAt(row, 4);
        boolean dxprecio = (Boolean) table.getValueAt(row, 5);
        boolean nstck = (Boolean) table.getValueAt(row, 6);
        
        if(notr || dxprecio || nstck){
           
            c.setBackground(Color.white);
            c.setForeground(Color.red);
       
        }else{
            c.setBackground(Color.white);
            c.setForeground(Color.black);    
        }
        
        return c;
        
    }

}