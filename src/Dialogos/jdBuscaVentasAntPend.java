
package Dialogos;

import Conexion.ExeSql;
import Formularios.fmMain;
import Utilidades.CargaGrillas;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class jdBuscaVentasAntPend extends javax.swing.JDialog {
    int ModalResult;
    String NumeroMaster;
    String TipoMaster;
    boolean Estado = false;
    
    public jdBuscaVentasAntPend(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Grilla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Grilla.setAutoCreateRowSorter(true);
        Grilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tipo", "Nro. Doc", "Codigo OC", "Orden", "Cantidad", "Sku", "ubc", "rut"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Long.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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
            Grilla.getColumnModel().getColumn(0).setMinWidth(45);
            Grilla.getColumnModel().getColumn(0).setPreferredWidth(45);
            Grilla.getColumnModel().getColumn(0).setMaxWidth(45);
            Grilla.getColumnModel().getColumn(1).setPreferredWidth(55);
            Grilla.getColumnModel().getColumn(2).setPreferredWidth(55);
            Grilla.getColumnModel().getColumn(3).setPreferredWidth(55);
            Grilla.getColumnModel().getColumn(4).setPreferredWidth(35);
            Grilla.getColumnModel().getColumn(5).setMinWidth(0);
            Grilla.getColumnModel().getColumn(5).setPreferredWidth(0);
            Grilla.getColumnModel().getColumn(5).setMaxWidth(0);
            Grilla.getColumnModel().getColumn(6).setMinWidth(0);
            Grilla.getColumnModel().getColumn(6).setPreferredWidth(0);
            Grilla.getColumnModel().getColumn(6).setMaxWidth(0);
            Grilla.getColumnModel().getColumn(7).setMinWidth(0);
            Grilla.getColumnModel().getColumn(7).setPreferredWidth(0);
            Grilla.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public String GetNumero(){
        return NumeroMaster;
    }
    
    public String GetTipo(){
        return TipoMaster;
    }
    
    public Boolean GetEstado(){
        return Estado;
    }
    
    
    
    private void GrillaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrillaMouseClicked
        
        if(evt.getClickCount()==2 && !Grilla.getValueAt(Grilla.getSelectedRow(), 0).toString().isEmpty()){
            
            NumeroMaster = Grilla.getValueAt(Grilla.getSelectedRow(), 0).toString().trim();
            TipoMaster = Grilla.getValueAt(Grilla.getSelectedRow(), 1).toString().trim();
            this.ModalResult=JOptionPane.OK_OPTION;
            Estado = true;
            dispose();
        }
        
    }//GEN-LAST:event_GrillaMouseClicked
   
    
    public void CargaPendientes(String Sku){
        
        DefaultTableModel tbMd = (DefaultTableModel) Grilla.getModel();
        
        while (tbMd.getRowCount() > 0) {
            tbMd.removeRow(0);
        }
        
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        
        try {
            
            Rs = Sql.Select("select case when va.tipdocto is null then ' ' else va.tipdocto end as tipdocto, \n"+
                            "va.nrodocto, va.codigo_oc, va.orden, va.cant, va.sku, va.ubicacion, va.rut \n" +
                            "from venta_anticipada va \n"+
                            "where va.sku IN ('"+Sku.trim()+"') and va.estado = 0");
            
            if (Sql.GetRowCount() > 0){
            
                
                while (Rs.next()){
                
                    tbMd.addRow(new Object[]{
                            Rs.getString("tipdocto").trim(), 
                            Rs.getString("nrodocto").trim(),
                            Rs.getString("codigo_oc").trim(),
                            Rs.getString("orden").trim(),
                            fmMain.FormatoNumeroSinDecimal(Rs.getDouble("cant")),
                            Rs.getString("sku").trim(),
                            Rs.getString("ubicacion").trim(),
                            Rs.getString("rut").trim()
                            
                    });
            
                }
            
            }
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(jdBuscaVentasAntPend.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(jdBuscaVentasAntPend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdBuscaVentasAntPend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdBuscaVentasAntPend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdBuscaVentasAntPend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                jdBuscaVentasAntPend dialog = new jdBuscaVentasAntPend(new javax.swing.JFrame(), true);
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
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
