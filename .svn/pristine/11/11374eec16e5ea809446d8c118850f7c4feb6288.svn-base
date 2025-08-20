package Dialogos;

import Conexion.ExeSql;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author DavidAlcaman
 */
public class jdAbrirOCC extends javax.swing.JDialog {

    int ModalResult;
    String RutMaster;
    
    public jdAbrirOCC(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbCodigoOc = new javax.swing.JComboBox();
        cbNroOrden = new javax.swing.JComboBox();
        btAceptar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Código OC");

        jLabel3.setText("Nro. Orden");

        cbCodigoOc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCodigoOc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCodigoOcActionPerformed(evt);
            }
        });
        cbCodigoOc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbCodigoOcKeyPressed(evt);
            }
        });

        cbNroOrden.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbNroOrden.setEnabled(false);
        cbNroOrden.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbNroOrdenKeyPressed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbCodigoOc, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbNroOrden, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(btCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btAceptar)
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbCodigoOc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbNroOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAceptar)
                    .addComponent(btCancelar))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public String GetNroOc(){
        return cbCodigoOc.getSelectedItem().toString().trim();
    }
    public String GetOrden(){
    return cbNroOrden.getSelectedItem().toString().trim();
    }
    public String GetCodigoOc(){
    return cbCodigoOc.getSelectedItem().toString().trim();
    }
//------------------------------------------------------------------------------
// CANCELAR
//------------------------------------------------------------------------------
    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
      ModalResult = JOptionPane.CANCEL_OPTION;  
      dispose();
    }//GEN-LAST:event_btCancelarActionPerformed
//------------------------------------------------------------------------------
// ACEPTAR
//------------------------------------------------------------------------------
    private void btAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptarActionPerformed
      ModalResult = JOptionPane.OK_OPTION;
      dispose();
    }//GEN-LAST:event_btAceptarActionPerformed
//------------------------------------------------------------------------------
// CARGA ORDENES (cambio en codigo oc)
//------------------------------------------------------------------------------
    private void cbCodigoOcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCodigoOcActionPerformed
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        cbNroOrden.setEnabled(true);
        DefaultComboBoxModel cbMd = new DefaultComboBoxModel();
        cbNroOrden.setModel(cbMd);

        if (cbCodigoOc.getSelectedIndex() >= 0) {
            try {

                Rs = Sql.Select("select orden \n"
                        + "from occh\n"
                        + "where rut=" + RutMaster + "\n"
                        + "and codigo_oc=" + cbCodigoOc.getSelectedItem().toString().trim());
                //Rs.first();
                while (Rs.next()) {
                    cbMd.addElement(Rs.getString("orden"));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                System.out.println("Un ERROR");
            }
            finally{
                Sql.Close();
            }

        }
    }//GEN-LAST:event_cbCodigoOcActionPerformed

    private void cbCodigoOcKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbCodigoOcKeyPressed
            if(evt.getKeyCode() == KeyEvent.VK_ENTER)
                cbNroOrden.requestFocus();
    }//GEN-LAST:event_cbCodigoOcKeyPressed

    private void cbNroOrdenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbNroOrdenKeyPressed
            if(evt.getKeyCode()== KeyEvent.VK_ENTER)
               btAceptar.doClick();
    }//GEN-LAST:event_cbNroOrdenKeyPressed
//------------------------------------------------------------------------------
// SHOW MODAL
//------------------------------------------------------------------------------
    public int ShowModal(String Rut){
        
        CargaCodOc(Rut);
        setLocationRelativeTo(null);
        RutMaster=Rut;
        cbCodigoOc.setSelectedIndex(0);
        setVisible(true);
        
        return ModalResult;
        
    }
//------------------------------------------------------------------------------
// Carga Codigos OC
//------------------------------------------------------------------------------
    private void CargaCodOc(String Rut){
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        DefaultComboBoxModel cbMd = new DefaultComboBoxModel();
        cbCodigoOc.setModel(cbMd);
        
        try{
            Rs = Sql.Select("select distinct(codigo_oc) as codigo_oc from clicontacto where rut = " + Rut);
            while(Rs.next()){
                cbMd.addElement(Rs.getString("codigo_oc")); 
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
          }finally{
            Sql.Close();
        }
        

    }
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
            java.util.logging.Logger.getLogger(jdAbrirOCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdAbrirOCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdAbrirOCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdAbrirOCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdAbrirOCC dialog = new jdAbrirOCC(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox cbCodigoOc;
    private javax.swing.JComboBox cbNroOrden;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
