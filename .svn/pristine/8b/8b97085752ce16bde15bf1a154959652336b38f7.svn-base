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
public class TableCellRendererConvenio extends DefaultTableCellRenderer {
    
    private Component c;
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                
        c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //Para cambiar la fila 
        
        
        
        double margen = Double.parseDouble(table.getValueAt(row, 15).toString());
        
        if(margen >= 25){
        
            c.setBackground(Color.green);
            c.setForeground(Color.black);
        
        }else if(margen >= 15 && margen < 25 ){
            c.setBackground(Color.yellow);
            c.setForeground(Color.black);
        }else{
            c.setBackground(Color.white);
            c.setForeground(Color.black);    
        }
        
        return c;
        
    }

}