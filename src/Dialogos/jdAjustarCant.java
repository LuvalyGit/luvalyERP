
package Dialogos;


import Formularios.fmMain;
import java.awt.event.KeyEvent;



/**
 *
 * @author Roberto Lopez
 */
public class jdAjustarCant extends javax.swing.JDialog {

    private boolean Retorno;
        
    double Cantidad = 0;
    int Cantajusta = 0;
    
    String Sku, Nombre, Medida, Pendiente = "";
    
    String txRecibido = "";
    String txCant = "";
    
    
    
    public jdAjustarCant(java.awt.Frame parent, boolean modal) {
        
        super(parent, modal);
        initComponents();
        
        
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btAjustar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txCantActual = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txCantAjustada = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btAjustar.setText("Ajustar");
        btAjustar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAjustarActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(242, 222, 184));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Cantidad a Ajustar");
        jLabel17.setToolTipText("");
        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jLabel17.setOpaque(true);

        txCantActual.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txCantActual.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txCantActual.setEnabled(false);
        txCantActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txCantActualActionPerformed(evt);
            }
        });
        txCantActual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txCantActualKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txCantActualKeyTyped(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(242, 222, 184));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Cantidad Actual");
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jLabel12.setOpaque(true);

        txCantAjustada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txCantAjustada.setText("0");
        txCantAjustada.setToolTipText("");
        txCantAjustada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txCantAjustadaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(btAjustar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(btCancelar)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txCantActual)
                    .addComponent(txCantAjustada, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                .addGap(61, 61, 61))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txCantActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txCantAjustada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAjustar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    
    public void SetValor(int cantidad){
        
       txCant = String.valueOf(cantidad);
       
       System.out.println("LA txCant ES : "+txCant);
       
       txCantActual.setText(txCant);
    }
    
    
   
    
    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
       
       Retorno= false;
       dispose(); 
       
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btAjustarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAjustarActionPerformed
        
        double diferencia = 0;
        
        if (txCantAjustada.getText().equals("") ){
        
             txCantAjustada.setText("0");
        
        }
        
        
        Cantajusta = Integer.parseInt(txCantAjustada.getText());
        
        if (Cantajusta == 0){
        
            fmMain.Mensaje("La Cantidad no puede ser 0 !");
            return;
        
        }
        
//        if (Cantajusta > Integer.parseInt(txCant)){
//        
//            fmMain.Mensaje("Nueva Cantidad no puede ser mayor a la Existente !");
//            return;
//        
//        }
        
        
        
       
        Retorno = true;
      
        dispose();
       
        
    }//GEN-LAST:event_btAjustarActionPerformed
    
    
    public int GetCant(){
    
        return Cantajusta;
    
    }
    
    
     public boolean GetRetorno(){
    
        return Retorno;
    
    }
    
    
    private void txCantActualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCantActualKeyTyped
        
//        char car = evt.getKeyChar();
//        
//        if (car=='.'){   
//           
//           char x;
//           int conta=0;
//           
//           for (int y=0; y < txPrecioActual.getText().length(); y++ ){
//                        
//                x = txPrecioActual.getText().charAt(y);
//                 
//                if (x=='.'){
//                   conta++;
//                }
//                
//                if (conta==1){
//                    evt.consume(); 
//                }
//           }
//        }
//            
//        if(((car<'0') || (car>'9')) && ((car<'.') || (car>'.'))){
//           evt.consume(); 
//        }        
        
        
    }//GEN-LAST:event_txCantActualKeyTyped

    private void txCantActualKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCantActualKeyReleased
       
    }//GEN-LAST:event_txCantActualKeyReleased

    private void txCantActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txCantActualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txCantActualActionPerformed

    private void txCantAjustadaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCantAjustadaKeyPressed
       
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
         
             btAjustar.doClick();
         
        }
        
        
    }//GEN-LAST:event_txCantAjustadaKeyPressed
     
    
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
            java.util.logging.Logger.getLogger(jdAjustarCant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdAjustarCant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdAjustarCant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdAjustarCant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                jdAjustarCant dialog = new jdAjustarCant(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btAjustar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JTextField txCantActual;
    private javax.swing.JTextField txCantAjustada;
    // End of variables declaration//GEN-END:variables
}
