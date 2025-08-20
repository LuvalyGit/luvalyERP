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


public class BotonX extends JButton implements MouseListener {
 
 JTabbedPane panel;
 PanelTab btc;
 int tipo;
 
    public BotonX(JTabbedPane pane,final PanelTab btc,int op) {
     panel=pane;
     this.btc=btc;
     tipo=op;
        int size = 17;
        setPreferredSize(new Dimension(size, size));
        setToolTipText("Cerrar Pestaña");
        setUI(new BasicButtonUI());
        setContentAreaFilled(false);
        setFocusable(false);
        setBorder(BorderFactory.createEtchedBorder());
        setBorderPainted(false);
        addMouseListener(this);
        setRolloverEnabled(true);
        addActionListener(new ActionListener(){


   @Override
   public void actionPerformed(ActionEvent e) {
    int i = panel.indexOfTabComponent(BotonX.this.btc);
          if (i != -1) {
              if(fmMain.GetEstado(i)==1){
                  if(JOptionPane.OK_OPTION == fmMain.OkCancel("¿Cerrar sin guardar?")){
                        panel.remove(i);                   
                        fmMain.DeleteEstado(i);
                  }
              }
              else{
                  panel.remove(i);                   
                  fmMain.DeleteEstado(i);
              }
          }
   }
        });
    }
   

   
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        if(tipo==0){
         if (getModel().isPressed()) {
          g2.translate(1, 1);
         }
         g2.setStroke(new BasicStroke(3));
         g2.setColor(Color.BLACK);
         if (getModel().isRollover()) {
          g2.setColor(Color.RED);
         }
         g2.drawLine(5, 5, 12, 12);
         g2.drawLine(12, 6, 6, 12);
         g2.dispose();
        }
//        else{
//         ImageIcon img=new ImageIcon(this.getClass().getResource("../lib/cerrar.png"));
//         g2.drawImage(img.getImage(), 1, ,14,14, this);
//         g2.dispose();
//        }
    }


 @Override
 public void mouseClicked(MouseEvent e) {
  // TODO Auto-generated method stub
  
 }


 @Override
 public void mouseEntered(MouseEvent e) {
  Component component = e.getComponent();
        if (component instanceof AbstractButton) {
            AbstractButton button = (AbstractButton) component;
            button.setBorderPainted(true);
        }
 }


 @Override
 public void mouseExited(MouseEvent e) {
  Component component = e.getComponent();
        if (component instanceof AbstractButton) {
            AbstractButton button = (AbstractButton) component;
            button.setBorderPainted(false);
        }
 }


 @Override
 public void mousePressed(MouseEvent e) {
  // TODO Auto-generated method stub
  
 }


 @Override
 public void mouseReleased(MouseEvent e) {
  // TODO Auto-generated method stub
  
 }
}