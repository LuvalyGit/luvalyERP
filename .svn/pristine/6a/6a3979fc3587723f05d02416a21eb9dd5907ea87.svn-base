/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dialogos;

import Formularios.fmMain;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;

/**
 *
 * @author Roberto Lopez
 */
public class jdProductosVenc extends javax.swing.JDialog {
    
    boolean ingresa = false;
    int esFecha = 0;
    Date hoy = new Date();
    String Fecha = "";
    String Codigo = "";
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    
    public jdProductosVenc(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
         jXFecha.getEditor().setEditable(false);     //bloquea entrada de fecha en forma manual
         jXFecha.setEnabled(false);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btAceptar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jXFecha = new org.jdesktop.swingx.JXDatePicker();
        jLabel2 = new javax.swing.JLabel();
        txCodigo = new javax.swing.JTextField();
        check1 = new javax.swing.JCheckBox();
        check2 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Ingrese Fecha Vencimiento");

        btAceptar.setText("Aceptar");
        btAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptarActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        jXFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXFechaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Ingrese Código");

        txCodigo.setToolTipText("");
        txCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txCodigoActionPerformed(evt);
            }
        });

        check1.setSelected(true);
        check1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check1ActionPerformed(evt);
            }
        });

        check2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(btAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jXFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addComponent(check2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(check1)))))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(check1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(check2))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public String GetFecha(){
        return Fecha;
    }
    
    public Boolean GetIngresa(){
        return ingresa;
    }
    
    public Integer GetesFecha(){
        return esFecha;
    }
    
    public String GetCodigo(){
        return Codigo;
    }
    
    
    
    
    private void btAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptarActionPerformed
        
        try {
            
            if (esFecha == 1){              //Si se ingreso como fecha
            
                String sid,sid1,sid2,sid3 = "";
                
                if (jXFecha.getDate() == null){
                
                    fmMain.Mensaje("Debe Ingresar una fecha");
                    jXFecha.requestFocus();
                    return;
                
                }
            
                String sfecha = dateFormat.format(jXFecha.getDate());
                
                 System.out.println("FECHA COMO String : "+sfecha);
                
                
                String sfechahoy = dateFormat.format(hoy);
          
                Date fecha = dateFormat.parse(sfecha);
                Date fechahoy = dateFormat.parse(sfechahoy);

                long fec = calculaDias(fecha);
                long fhoy = calculaDias(fechahoy);
           
            
                int dias = (int) ((fec - fhoy) / (86400000));
           
                System.out.println("LA DIFERENCIA de dias2 ES : "+dias);
                
            
                if (dias < 29){
                
                    fmMain.Mensaje("Fecha debe ser desde 29 dias corridos o mas");
                    jXFecha.requestFocus();
                    return;
                
                }
            
                Fecha = dateFormat.format(jXFecha.getDate());
                
                sid = sfecha.replaceAll("-", "");
                sid1 = sid.substring(6);  //año
                sid2 = sid.substring(2,4);  //mes               
                sid3 = sid.substring(0,2);  //dia
                
                Codigo = sid1+sid2+sid3;     //Se crea código a partir de la fecha con prefijo "4"
                
                ingresa = true;
            
           
            
            }else if (esFecha == 0){            //Si se Ingresó como código
            
                if (txCodigo.getText().equals("")){
                
                    fmMain.Mensaje("Debe Ingresar un Codigo");
                    txCodigo.requestFocus();
                    return;
                
                }
            
                Codigo = txCodigo.getText().trim();
                
                if(Codigo.length()< 6) {  //se valida que solo se ingresen
       
                    fmMain.Mensaje("Formato ID no valido");
                    txCodigo.requestFocus();
                    return;
        
                }         
        
        
                String agno = Codigo.substring(0,2);
                String mes = Codigo.substring(2,4);
                String dia = Codigo.substring(4);
         
                int nmes = Integer.parseInt(mes);
                int ndia = Integer.parseInt(dia);
                int nagno = Integer.parseInt(agno);
                //int hoy = Integer.parseInt(sagno);
         
               // System.out.println("EL AÑO ACTUAL ES :"+hoy);
                System.out.println("EL AÑO ES :"+nagno);
                System.out.println("EL MES ES :"+nmes);
                System.out.println("EL DIA ES :"+ndia);
         
         
//                if (nagno < hoy){
//         
//                    fmMain.Mensaje("Formato ID no valido");
//                    txCodigo.requestFocus();
//                    return;
//         
//                } 
            
                if (nmes > 12 || nmes < 1){
         
                    fmMain.Mensaje("Formato ID no valido");
                    txCodigo.requestFocus();
                    return;
         
                }
         
                if (ndia > 31 || ndia < 1){
         
                    fmMain.Mensaje("Formato ID no valido");
                    txCodigo.requestFocus();
                    return;
         
                }
        
                Fecha = dia+"-"+mes+"-"+"20"+agno;
                ingresa = true;
            
            } 
            
            dispose();
            
            
        } catch (ParseException ex) {
            Logger.getLogger(jdProductosVenc.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btAceptarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        ingresa=false;
        dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void check1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check1ActionPerformed
        
        if (check1.isSelected()){
        
            check2.setSelected(false);
            jXFecha.setEnabled(false);
            txCodigo.setEnabled(true);
            esFecha = 0;
        
        }
        
        
    }//GEN-LAST:event_check1ActionPerformed

    private void check2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check2ActionPerformed
        if (check2.isSelected()){
        
            check1.setSelected(false);
            jXFecha.setEnabled(true);
            txCodigo.setEnabled(false);
            esFecha = 1;
        
        }
    }//GEN-LAST:event_check2ActionPerformed

    private void txCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txCodigoActionPerformed
        btAceptar.doClick();
    }//GEN-LAST:event_txCodigoActionPerformed

    private void jXFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXFechaActionPerformed
        
    }//GEN-LAST:event_jXFechaActionPerformed

    
    private long calculaDias(Date fecha){
    
    
        Calendar fecCal = Calendar.getInstance();
            
        fecCal.setTime(fecha);
            
        int agno =  fecCal.get(Calendar.YEAR);
        int mes =  fecCal.get(Calendar.MONTH)+1;
        int dia =  fecCal.get(Calendar.DAY_OF_MONTH);
            
            
        fecCal.set(agno,mes,dia);
        fecCal.set(Calendar.HOUR, 0);
        fecCal.set(Calendar.HOUR_OF_DAY, 0);
        fecCal.set(Calendar.MINUTE, 0);
        fecCal.set(Calendar.SECOND, 0);
        
        long diasfec = fecCal.getTimeInMillis();
    
        return diasfec;
    
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
            java.util.logging.Logger.getLogger(jdProductosVenc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdProductosVenc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdProductosVenc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdProductosVenc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdProductosVenc dialog = new jdProductosVenc(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btAceptar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JCheckBox check1;
    private javax.swing.JCheckBox check2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private org.jdesktop.swingx.JXDatePicker jXFecha;
    private javax.swing.JTextField txCodigo;
    // End of variables declaration//GEN-END:variables
}
