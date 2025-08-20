package Utilidades;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author darta_000
 */
public class TableCellRendererFeriado implements TableCellRenderer {
    private Integer fila;
    public static final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();
    
    /**
     * Creamos el resaltador indicando que fila se coloreara por defecto
     * @param row 
     */
    public TableCellRendererFeriado(){
    }
    
    /**
     * Colorea la celda si pertenece a la fila indicada, esta funcion es llamada internamente por la tabla
     * que use esta clase como renderizados
     * @param table Tabla
     * @param value Valor de la celda
     * @param isSelected Celda selecionada
     * @param hasFocus Celta tiene el foco
     * @param row Fila de la celda
     * @param column Columna de la celda
     * @return Celda de la tabla
     */    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Obtenemos la celda que se esta renderizando
        Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if(row==table.getSelectedRow()){
            c.setBackground(Color.blue);
            c.setForeground(Color.white);
            
        }
        else {
            if(table.getValueAt(row, 1).equals("Día de Semana") && table.getValueAt(row, 2).equals("No feriado")){
                c.setBackground(Color.yellow);
                c.setForeground(Color.black);
            }
            else if (table.getValueAt(row, 1).equals("Fin de Semana") && table.getValueAt(row, 2).equals("No feriado")){
                c.setBackground(Color.green);
                c.setForeground(Color.black);
            }
            else if (table.getValueAt(row, 2).equals("Feriado")){
                c.setBackground(Color.pink);
                c.setForeground(Color.black);
            }
            else {
                c.setBackground(Color.white);
                c.setForeground(Color.black);
            }
            
            
        }
        
        return c;
        
        
    }

    /**
     * @return the fila
     */

}