/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dialogos;

import Conexion.ExeSql;
import Formularios.fmMain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Roberto Lopez
 */
public class jdIngresaFacACEPTA extends javax.swing.JDialog {
    
    boolean ingresa = false;
    String ID = "";
    String CANT = "";
    String SKU = "";
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    
    Calendar cal = Calendar.getInstance();

    int year  = cal.get(Calendar.YEAR);
    String sagno = String.valueOf(year).substring(2);
    DefaultTableModel Model1;
       
    
    public jdIngresaFacACEPTA(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
                       
        txNro.setText("0");
        txExento.setText("0");
        txNeto.setText("0");
        txIva.setText("0");
        txImpHarina.setText("0");
        txImpIABA10.setText("0");
        txImpIABA18.setText("0");
        
        
        txTotal.setText("0");
        
        
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btCancelar = new javax.swing.JButton();
        txRut = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txNro = new javax.swing.JTextField();
        cbTipo = new javax.swing.JComboBox();
        dtFecha = new org.jdesktop.swingx.JXDatePicker();
        txExento = new javax.swing.JTextField();
        txNeto = new javax.swing.JTextField();
        txIva = new javax.swing.JTextField();
        txTotal = new javax.swing.JTextField();
        btGuardar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txImpHarina = new javax.swing.JTextField();
        txImpIABA10 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txImpIABA18 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        txRut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txRutActionPerformed(evt);
            }
        });
        txRut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txRutKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txRutKeyTyped(evt);
            }
        });

        jLabel1.setText("RUT ");

        jLabel2.setText("Nro Documento");

        jLabel3.setText("Tipo Documento");

        jLabel4.setText("Fecha Emision ");

        jLabel5.setText("Monto Exento");

        jLabel6.setText("Monto Neto");

        jLabel7.setText("Monto IVA");

        jLabel8.setText("Monto Total");

        txNro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNroActionPerformed(evt);
            }
        });
        txNro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txNroKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txNroKeyTyped(evt);
            }
        });

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "FAP", "NCP" }));

        txExento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txExentoFocusLost(evt);
            }
        });
        txExento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txExentoActionPerformed(evt);
            }
        });
        txExento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txExentoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txExentoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txExentoKeyTyped(evt);
            }
        });

        txNeto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txNetoFocusLost(evt);
            }
        });
        txNeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNetoActionPerformed(evt);
            }
        });
        txNeto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txNetoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txNetoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txNetoKeyTyped(evt);
            }
        });

        txIva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txIvaActionPerformed(evt);
            }
        });
        txIva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txIvaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txIvaKeyTyped(evt);
            }
        });

        txTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txTotalActionPerformed(evt);
            }
        });
        txTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txTotalKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txTotalKeyTyped(evt);
            }
        });

        btGuardar.setText("Guardar");
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });

        jLabel9.setText("Adicional Harina 12%");

        txImpHarina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txImpHarinaActionPerformed(evt);
            }
        });
        txImpHarina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txImpHarinaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txImpHarinaKeyTyped(evt);
            }
        });

        txImpIABA10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txImpIABA10ActionPerformed(evt);
            }
        });
        txImpIABA10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txImpIABA10KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txImpIABA10KeyTyped(evt);
            }
        });

        jLabel10.setText("Adicional IABA 10%");

        jLabel11.setText("Adicional IABA 18%");

        txImpIABA18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txImpIABA18ActionPerformed(evt);
            }
        });
        txImpIABA18.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txImpIABA18KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txImpIABA18KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txRut, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(txNro, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txExento, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txNeto, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txIva, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txImpHarina, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txImpIABA10, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txImpIABA18, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txRut))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txNro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txExento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txNeto)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txIva)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txImpHarina)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txImpIABA10)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txImpIABA18)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txTotal)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    public Boolean GetIngresa(){
        return ingresa;
    }
  
    
    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        ingresa=false;
        dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void txRutKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRutKeyTyped

        
        char validar = evt.getKeyChar();    //Código agregado por R. Lopez
        if (Character.isLetter(validar)){   //se valida que solo se ingresen 
           
            evt.consume();                  //números al textfield "txRut"
        }
        
        if(txRut.getText().length()>=8) {  //se valida que solo se ingresen
       
            evt.consume();                 //un máximo de 8 digitos al textfield "txRut" 
        
        }                                  //Fin código agregado
        
        
        
        if(((validar<'0') || (validar>'9')) ){
           evt.consume(); 
        }       

    }//GEN-LAST:event_txRutKeyTyped

    private void txRutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRutKeyPressed

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            
            txNro.requestFocus();
            

//            if (txRut.getText() == null){
//
//                fmMain.Mensaje("Debe Ingresar ID del producto");
//                txRut.requestFocus();
//                return;
//
//            }
//
//            if(txRut.getText().length()< 6) {  //se valida que solo se ingresen
//
//                fmMain.Mensaje("Formato ID no valido");
//                txRut.requestFocus();
//                return;
//
//            }
//
//            ID = txRut.getText().trim();
//            ingresa = true;
//            dispose();

        }

    }//GEN-LAST:event_txRutKeyPressed

    private void txRutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txRutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txRutActionPerformed

    private void txNroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNroActionPerformed

    private void txNroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNroKeyPressed
       
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            
            dtFecha.requestFocus();
        
        }
    }//GEN-LAST:event_txNroKeyPressed

    private void txNroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNroKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txNroKeyTyped

    private void txExentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txExentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txExentoActionPerformed

    private void txExentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txExentoKeyPressed
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                       
            double total = Double.parseDouble(txExento.getText());
            
            txTotal.setText(""+Math.round(total));
        
        }
        
        
    }//GEN-LAST:event_txExentoKeyPressed

    private void txExentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txExentoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txExentoKeyTyped

    private void txNetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNetoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNetoActionPerformed

    private void txNetoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNetoKeyPressed
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            double tiva = Double.parseDouble(txNeto.getText()) * 0.19;

            txIva.setText(""+Math.round(tiva));
            
            double total = tiva + Double.parseDouble(txNeto.getText())+Double.parseDouble(txImpHarina.getText())+Double.parseDouble(txImpIABA10.getText())+Double.parseDouble(txImpIABA18.getText());
            
            txTotal.setText(""+Math.round(total));
        
        }
        
        
        
    }//GEN-LAST:event_txNetoKeyPressed

    private void txNetoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNetoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txNetoKeyTyped

    private void txIvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txIvaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txIvaActionPerformed

    private void txIvaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txIvaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txIvaKeyPressed

    private void txIvaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txIvaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txIvaKeyTyped

    private void txTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txTotalActionPerformed

    private void txTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txTotalKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txTotalKeyPressed

    private void txTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txTotalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txTotalKeyTyped

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
        
        if(txRut.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe Ingresar RUT");
            return;
        }
        
        System.out.println("EL LARGO ES : "+txRut.getText().length());
        
        if(txRut.getText().length()>1 && txRut.getText().length()<7){
            
            JOptionPane.showMessageDialog(null, "Error Formato RUT");
            return;
        }
        
        if(txNro.getText().equals("0")){
            JOptionPane.showMessageDialog(null, "Debe Ingresar Número del Documento");
            return;
        }
        
        if(dtFecha.getDate() == null){
            JOptionPane.showMessageDialog(null, "Debe Ingresar Fecha de Emisión");
            return;
        }
        
        if(txExento.getText().equals("0") && txNeto.getText().equals("0")  ){
            JOptionPane.showMessageDialog(null,"Debe Ingresar un Monto Exento o Neto");
            return;
        }
        
        
        if(!txNeto.getText().equals("0") && txIva.getText().equals("0")){
            JOptionPane.showMessageDialog(null,"Debe Ingresar IVA");
            return;
        }
        
        
        
        if(txImpHarina.getText().trim().isEmpty()){
           txImpHarina.setText("0");
            
        }
        
        
        if(txImpIABA10.getText().trim().isEmpty()){
           txImpIABA10.setText("0");
            
        }
        
        if(txImpIABA18.getText().trim().isEmpty()){
           txImpIABA18.setText("0");
            
        }
        
        
        
        if(txTotal.getText().equals("0")){
            JOptionPane.showMessageDialog(null,"Debe Ingresar Monto Total");
            return;
        }
        
        try {
            ExeSql Sql = new ExeSql();
            ExeSql Sql2 = new ExeSql();
            ExeSql Sql3 = new ExeSql();
            ResultSet Rs, Rs2;
            
            String Rut = txRut.getText().trim();
            String Tipo = cbTipo.getSelectedItem().toString();
            String Numero = txNro.getText().trim();
            
            Rs = Sql.Select("SELECT rut,tipdocto,nrodocto FROM doc_mail \n" +
                            "WHERE rut = "+Rut+ "\n"+
                            "AND nrodocto=" + Numero);
                        
            if(Sql.GetRowCount() > 0){
                
                JOptionPane.showMessageDialog(null,"Documento ya existe");
                txRut.requestFocus();
                return;
            
            }else{
                     
                    Rs2 = Sql2.Select("SELECT correlativo FROM doc_mail ORDER BY correlativo DESC LIMIT 1");
                    
                    Rs2.next();
                    int Correlativo = Rs2.getInt("correlativo")+1;
                
                
                
                    Sql3.ExeSql("INSERT INTO doc_mail(rut,tipdocto,nrodocto,femision,totalexento,totalafecto,totaliva,totaldocto,\n"+
                                "impharina,impiaba10,impiaba18,correlativo ) \n" +  

                                "VALUES (" +
                                txRut.getText().trim() + ",'" +
                                Tipo + "'," +
                                Numero + ",'" +
                                getFechaAsString() + "'," +
                                fmMain.SetGuardar(txExento.getText()) + "," +
                                fmMain.SetGuardar(txNeto.getText()) +"," +
                                fmMain.SetGuardar(txIva.getText()) + "," +
                                fmMain.SetGuardar(txTotal.getText()) + "," +
                                fmMain.SetGuardar(txImpHarina.getText()) + "," +
                                fmMain.SetGuardar(txImpIABA10.getText()) + "," +
                                fmMain.SetGuardar(txImpIABA18.getText()) + "," +
                                Correlativo +")" );
            
                    Sql3.Commit();
                    
                    ingresa = true;
                    dispose();
                    
            }
        
        
        } catch (SQLException ex) {
            Logger.getLogger(jdIngresaFacACEPTA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btGuardarActionPerformed

    private void txExentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txExentoKeyReleased
       
      
    }//GEN-LAST:event_txExentoKeyReleased

    private void txNetoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNetoKeyReleased
        
       
    }//GEN-LAST:event_txNetoKeyReleased

    private void txNetoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txNetoFocusLost
            
        double tiva = Double.parseDouble(txNeto.getText()) * 0.19;

        txIva.setText(""+Math.round(tiva));
            
        double total = tiva + Double.parseDouble(txNeto.getText())+Double.parseDouble(txImpHarina.getText())+Double.parseDouble(txImpIABA10.getText())+Double.parseDouble(txImpIABA18.getText());

            
        txTotal.setText(""+Math.round(total));
        
        
    }//GEN-LAST:event_txNetoFocusLost

    private void txExentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txExentoFocusLost
        
        double total = Double.parseDouble(txExento.getText());
           
        txTotal.setText(""+Math.round(total));
    }//GEN-LAST:event_txExentoFocusLost

    private void txImpHarinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txImpHarinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txImpHarinaActionPerformed

    private void txImpHarinaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txImpHarinaKeyPressed
       
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            double tiva = Double.parseDouble(txNeto.getText()) * 0.19;

            txIva.setText(""+Math.round(tiva));
            
            double total = tiva + Double.parseDouble(txNeto.getText())+Double.parseDouble(txImpHarina.getText())+Double.parseDouble(txImpIABA10.getText())+Double.parseDouble(txImpIABA18.getText());
            
            txTotal.setText(""+Math.round(total));
        
        }
        
        
        
    }//GEN-LAST:event_txImpHarinaKeyPressed

    private void txImpHarinaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txImpHarinaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txImpHarinaKeyTyped

    private void txImpIABA10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txImpIABA10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txImpIABA10ActionPerformed

    private void txImpIABA10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txImpIABA10KeyPressed
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            double tiva = Double.parseDouble(txNeto.getText()) * 0.19;

            txIva.setText(""+Math.round(tiva));
            
            double total = tiva + Double.parseDouble(txNeto.getText())+Double.parseDouble(txImpHarina.getText())+Double.parseDouble(txImpIABA10.getText())+Double.parseDouble(txImpIABA18.getText());
            
            txTotal.setText(""+Math.round(total));
        
        }
        
                
    }//GEN-LAST:event_txImpIABA10KeyPressed

    private void txImpIABA10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txImpIABA10KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txImpIABA10KeyTyped

    private void txImpIABA18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txImpIABA18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txImpIABA18ActionPerformed

    private void txImpIABA18KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txImpIABA18KeyPressed
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            double tiva = Double.parseDouble(txNeto.getText()) * 0.19;

            txIva.setText(""+Math.round(tiva));
            
            double total = tiva + Double.parseDouble(txNeto.getText())+Double.parseDouble(txImpHarina.getText())+Double.parseDouble(txImpIABA10.getText())+Double.parseDouble(txImpIABA18.getText());
            
            txTotal.setText(""+Math.round(total));
        
        }
        
        
    }//GEN-LAST:event_txImpIABA18KeyPressed

    private void txImpIABA18KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txImpIABA18KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txImpIABA18KeyTyped

     public String getFechaAsString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return( sdf.format( (dtFecha.getDate()).getTime() ) );
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jdIngresaFacACEPTA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdIngresaFacACEPTA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdIngresaFacACEPTA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdIngresaFacACEPTA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdIngresaFacACEPTA dialog = new jdIngresaFacACEPTA(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btGuardar;
    private javax.swing.JComboBox cbTipo;
    private org.jdesktop.swingx.JXDatePicker dtFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txExento;
    private javax.swing.JTextField txImpHarina;
    private javax.swing.JTextField txImpIABA10;
    private javax.swing.JTextField txImpIABA18;
    private javax.swing.JTextField txIva;
    private javax.swing.JTextField txNeto;
    private javax.swing.JTextField txNro;
    private javax.swing.JTextField txRut;
    private javax.swing.JTextField txTotal;
    // End of variables declaration//GEN-END:variables
}
