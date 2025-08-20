/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
/**
 *
 * @author infornatica
 */
public class MyCellRenderer extends JLabel implements ListCellRenderer {


     // This is the only method defined by ListCellRenderer.
     // We just reconfigure the JLabel each time we're called.

     @Override
     public Component getListCellRendererComponent(
       JList list,
       Object value,            // value to display
       int index,               // cell index
       boolean isSelected,      // is the cell selected
       boolean cellHasFocus)    // the list and the cell have the focus
     {
         String s = value.toString();
         setText(s);
         
         if(value.toString().contains("-")){
            if(value.toString().split("-")[1].equals("rel")){
                if(isSelected){
                    setBackground(Color.orange);
                    setForeground(Color.black);
                }
                else {
                    setBackground(Color.yellow);
                    setForeground(Color.black);
                }
            }

           setEnabled(list.isEnabled());
           setFont(list.getFont());
            setOpaque(true);
         }
         else {
             if(isSelected){
                setBackground(Color.blue);
                setForeground(Color.white);
             }
             else {
                setBackground(Color.white);
                setForeground(Color.black);
             }
         }
             
         return this;
     }
 }