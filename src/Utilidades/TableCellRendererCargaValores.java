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
public class TableCellRendererCargaValores extends DefaultTableCellRenderer {
    
    private Component c;
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                
        c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //Para cambiar la fila 
        
        boolean noexiste = (Boolean) table.getValueAt(row, 4);
        
        if(!isSelected){
            if(!noexiste){

                c.setBackground(new Color(240, 63, 28));
                c.setForeground(Color.black);

            }else{
                c.setBackground(Color.white);
                c.setForeground(Color.black);    
            }
        }
        else {
            if(!noexiste ){

                c.setBackground(new Color(168, 71, 52));
                c.setForeground(Color.white);

            }else{
                c.setBackground(new Color(205, 205, 205));
                c.setForeground(Color.black);    
            }
        }
        
        return c;
        
    }

}