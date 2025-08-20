
package Dialogos;

import Conexion.ExeSql;
import Utilidades.CargaGrillas;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class jdAbrirDocumento extends javax.swing.JDialog {
    int ModalResult;
    String NumeroMaster;
    String TipoMaster;
    public jdAbrirDocumento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txNumero = new javax.swing.JTextField();
        btAceptar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Grilla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Número");

        txNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNumeroActionPerformed(evt);
            }
        });
        txNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txNumeroKeyPressed(evt);
            }
        });

        btAceptar.setText("Aceptar");
        btAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptarActionPerformed(evt);
            }
        });

        Grilla.setAutoCreateRowSorter(true);
        Grilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tipo", "Numero", "Fecha", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Grilla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GrillaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Grilla);
        if (Grilla.getColumnModel().getColumnCount() > 0) {
            Grilla.getColumnModel().getColumn(0).setResizable(false);
            Grilla.getColumnModel().getColumn(0).setPreferredWidth(80);
            Grilla.getColumnModel().getColumn(1).setResizable(false);
            Grilla.getColumnModel().getColumn(1).setPreferredWidth(80);
            Grilla.getColumnModel().getColumn(2).setResizable(false);
            Grilla.getColumnModel().getColumn(2).setPreferredWidth(80);
            Grilla.getColumnModel().getColumn(3).setResizable(false);
            Grilla.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAceptar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAceptar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btAceptarActionPerformed
    public String GetNumero(){
        return NumeroMaster;
    }
    public String GetTipo(){
        return TipoMaster;
    }
    private void GrillaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrillaMouseClicked
        if(evt.getClickCount()==2 && !Grilla.getValueAt(Grilla.getSelectedRow(), 0).toString().isEmpty()){
            NumeroMaster = Grilla.getValueAt(Grilla.getSelectedRow(), 1).toString().trim();
            TipoMaster = Grilla.getValueAt(Grilla.getSelectedRow(), 0).toString().trim();
            this.ModalResult=JOptionPane.OK_OPTION;
            dispose();
        }
        
    }//GEN-LAST:event_GrillaMouseClicked

    private void txNumeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNumeroKeyPressed
        if(txNumero.getText().length()>1){
        for(int i=0 ; i < Grilla.getRowCount(); i++)
            {
                if(Grilla.getValueAt(i, 1).toString().indexOf(txNumero.getText().trim())>=0){
                    Grilla.setRowSelectionInterval(i, i);
                    break;
                }
            }
        }
        if(evt.getKeyCode()== KeyEvent.VK_ENTER && txNumero.getText().length()>0 && Grilla.getSelectedRow()!=-1){
            NumeroMaster = Grilla.getValueAt(Grilla.getSelectedRow(), 1).toString().trim();
            this.ModalResult=JOptionPane.OK_OPTION;
            dispose();
        }
    }//GEN-LAST:event_txNumeroKeyPressed

    private void txNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNumeroActionPerformed
//------------------------------------------------------------------------------
// SHOW MODAL
//------------------------------------------------------------------------------
    public int ShowModal(String Tipo, String Rut){
        
        CargaDocumentos(Tipo,Rut);
        setLocationRelativeTo(null);
        setVisible(true);
        
        return ModalResult;
        
    }
    public int ShowModalCondicional(String Tipo, String Rut,String Condicion){
        this.ModalResult=JOptionPane.CANCEL_OPTION;
        CargaDocumentosCondicional(Tipo,Rut,Condicion);
        setLocationRelativeTo(null);
        setVisible(true);
        
        return ModalResult;
        
    }
    public void CargaDocumentos(String Tipo, String Rut){
        DefaultTableModel tbMd = (DefaultTableModel) Grilla.getModel();
        String Tabla;
        String sql = "";
        
        
        if(Tipo.equals("FAC") || Tipo.equals("GDC") || Tipo.equals("NCC") || Tipo.equals("FEC")|| Tipo.equals("NDC") ||
          Tipo.equals("FMC")|| Tipo.equals("FAT")|| Tipo.equals("MUL") || Tipo.equals("NVC")  || Tipo.equals("BOC") ){
        
            Tabla = "ctactecli";
            
            sql = "SELECT tipdocto,nrodocto,femision,estado "+
                  "FROM "+ Tabla   +
                  " WHERE TipDocto in ('" + Tipo + "') " +
                  "AND   Rut = " + Rut + " " +
                  "ORDER BY femision desc";
            
        }else{
         
            Tabla = "ctacteprv";
            
            sql = "SELECT tipdocto,nrodocto,femision,estado "+
                  "FROM "+ Tabla   +
                  " WHERE TipDocto in ('" + Tipo + "') " +
                  "AND Rut = " + Rut + " " +
                  "ORDER BY femision desc";
        }
        
        System.out.println(sql);
        try {
            CargaGrillas c = new CargaGrillas();
            tbMd = c.returndata(sql);
            Grilla.setModel(tbMd);
            
        } catch (Exception e) {
            System.out.println("Error al buscar");
        }

            
    }
    public void CargaDocumentosCondicional(String Tipo, String Rut,String Condicion){
        DefaultTableModel tbMd = (DefaultTableModel) Grilla.getModel();
        String Tabla;
        if(Tipo.equals("FAC") || Tipo.equals("GDC") || Tipo.equals("NCC") || Tipo.equals("FEC") || Tipo.equals("NCP") || Tipo.equals("MUL")
          || Tipo.equals("NVC")  || Tipo.equals("BOC"))
           
            Tabla = "ctactecli";
        else
            Tabla = "ctacteprv";
        
        String sql = "SELECT tipdocto,nrodocto,femision,estado "+
                     "FROM "+ Tabla   +
                     " WHERE TipDocto='" + Tipo + "' " +
                     "AND   Rut = " + Rut + " " +
                     Condicion +
                     " ORDER BY femision desc";
        System.out.println(sql);
        try {
            CargaGrillas c = new CargaGrillas();
            tbMd = c.returndata(sql);
            Grilla.setModel(tbMd);
            
        } catch (Exception e) {
            System.out.println("Error al buscar");
        }

            
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
            java.util.logging.Logger.getLogger(jdAbrirDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdAbrirDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdAbrirDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdAbrirDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdAbrirDocumento dialog = new jdAbrirDocumento(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable Grilla;
    private javax.swing.JButton btAceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txNumero;
    // End of variables declaration//GEN-END:variables
}
