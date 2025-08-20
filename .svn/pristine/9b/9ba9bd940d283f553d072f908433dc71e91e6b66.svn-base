/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import Formularios.fmMain;
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
public class TableColor_OCProvee extends DefaultTableCellRenderer{
    int ColMaster;

    public void SetCol(int Col){
        ColMaster=Col;
    }
    @Override
    public Component getTableCellRendererComponent(JTable Grilla, Object o, boolean bln, boolean bln1, int Row, int Col) {
        Component componente = super.getTableCellRendererComponent(Grilla, o, bln, bln1, Row, Col); //To change body of generated methods, choose Tools | Templates.
        
        if(Grilla.getValueAt(Row, 9).toString().trim().equals("1")){
            //Si Se Selecciona Fila
            if(Row==Grilla.getSelectedRow()){
                componente.setForeground(Color.white);
                
                componente.setBackground( Color.blue);
                componente.setFont(new Font("Arial", Font.BOLD, 12));
            }
            //Si NO se Selecciona Fila
            else  {
                componente.setForeground(Color.black);
                //Color Similar al rojo, pero no tan fuerte
                componente.setBackground(new  Color(255, 127, 80));
                componente.setFont(new Font("Arial", Font.PLAIN, 12));
            }
            
        }
        //Si separacion NO esta completa
        else if(Grilla.getValueAt(Row, 9).toString().trim().equals("2")){
                if(Row==Grilla.getSelectedRow()){
                    componente.setForeground(Color.WHITE);
                    //componente.setBackground(new  Color(185, 60, 14));  //parecido al naranjo
                    componente.setBackground(Color.BLUE);
                    componente.setFont(new Font("Arial", Font.BOLD, 12));
                }
                else{
                    // Color Pink
                    componente.setForeground(Color.black);
                    componente.setBackground(Color.PINK);
                    componente.setFont(new Font("Arial", Font.PLAIN, 12));
                }
                
            }
        else if(Grilla.getValueAt(Row, 9).toString().trim().equals("3")) {
        // else if(Grilla.getValueAt(Row, 9).toString().trim().equals("3")) {
                if(Row==Grilla.getSelectedRow()){
                    componente.setForeground(Color.WHITE);
                    //componente.setBackground(new  Color(140, 90, 8));
                    //componente.setBackground( new  Color(166 ,166, 119));
                    componente.setBackground(Color.BLUE);
                    componente.setFont(new Font("Arial", Font.BOLD, 12));
                }
                else{
                    componente.setForeground(Color.black);
                    
                    componente.setBackground(Color.yellow);
                    componente.setFont(new Font("Arial", Font.PLAIN, 12));
                }
                
            }
        else 
                if(Row==Grilla.getSelectedRow()){
                    componente.setForeground(Color.WHITE);
                    componente.setBackground(Color.blue);
                    componente.setFont(new Font("Arial", Font.BOLD, 12));
                }
                else{
                    componente.setForeground(Color.black);
                    componente.setBackground(Color.WHITE);
                    componente.setFont(new Font("Arial", Font.PLAIN, 12));
                }
        return componente;
    }
    
}
