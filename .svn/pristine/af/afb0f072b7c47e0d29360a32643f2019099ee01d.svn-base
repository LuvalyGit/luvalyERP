/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;



import Formularios.fmMain;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;


public class PanelTab extends JPanel {
   
 JTabbedPane pestañas;
 int tipo;
 int EstadoF;


 public int GetEstado(){
     return EstadoF;
 }
 public PanelTab(JTabbedPane p,int op) {
     
        if (p != null) {
         
         this.pestañas = p;
         tipo=op;
         
            setOpaque(false);
           
            JLabel titulo = new JLabel() {
             
                public String getText() {
                    int i = pestañas.indexOfTabComponent(PanelTab.this);
                    if (i != -1) {
                        return pestañas.getTitleAt(i);
                    }
                    return null;
                }
            };
            titulo.setFont(fmMain.pnPestanas.getFont());
                    
            add(titulo);
            titulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
            JButton button = new BotonX(pestañas,this,tipo);
            add(button);
        }
    }
}
