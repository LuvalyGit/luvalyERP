
package Dialogos;

import Conexion.ExeSql;
import Formularios.fmMain;
import static Formularios.fmMain.pnPestanas;
import PanelForm.pfClientes;
import PanelForm.pfGastosSueldos;
import PanelForm.pfProveedores;
import Utilidades.CargaGrillas;
import Utilidades.ImgTabla;
import Utilidades.LogError;
import Utilidades.PanelTab;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import javax.swing.table.DefaultTableModel;

public class jdBuscarHistorial extends javax.swing.JDialog {

int Tipo;
String RutSel;
    public jdBuscarHistorial(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public void AbrirHistorial(String StrRut, String NroOrden){
    
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        txRut.setEditable(false);
        txNroOrden.setEditable(false);
        txRut.setText(StrRut);
        txNroOrden.setText(NroOrden);
        
        Grilla.setDefaultRenderer(Object.class, new ImgTabla());
        DefaultTableModel tm = (DefaultTableModel) Grilla.getModel();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy - hh:mm");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yyyy");
        
        while(tm.getRowCount()>0)
            tm.removeRow(0); 
        
        JLabel lbCall = new JLabel();
        JLabel lbMail = new JLabel();
        JLabel lbFin  = new JLabel();
        JLabel lbIni  = new JLabel();
        JLabel lbInfo = new JLabel();
        JLabel lbReclamo  = new JLabel();
        JLabel lbDespacho = new JLabel();
        
        URL urlCall = this.getClass().getResource("/Iconos/Llamada.png");  
        URL urlMail = this.getClass().getResource("/Iconos/email.png");  
        URL urlIni =  this.getClass().getResource("/Iconos22/Go.png");  
        URL urlFin =  this.getClass().getResource("/Iconos/camion.png");  
        URL urlInfo =  this.getClass().getResource("/Iconos/info.png");
        URL urlReclamo =  this.getClass().getResource("/Iconos/reclamo.png");
        URL urlDespacho =  this.getClass().getResource("/Iconos/despacho.png");
         
        ImageIcon IconoCall =  new ImageIcon(urlCall); 
        ImageIcon IconoMail =  new ImageIcon(urlMail); 
        ImageIcon IconoIni  =  new ImageIcon(urlIni); 
        ImageIcon IconoFin  =  new ImageIcon(urlFin); 
        ImageIcon IconoInfo =  new ImageIcon(urlInfo); 
        ImageIcon IconoReclamo  =  new ImageIcon(urlReclamo); 
        ImageIcon IconoDespacho =  new ImageIcon(urlDespacho); 
        
        lbCall.setIcon(IconoCall);
        lbMail.setIcon(IconoMail);
        lbIni.setIcon(IconoIni);
        lbFin.setIcon(IconoFin);
        lbInfo.setIcon(IconoInfo);
        lbReclamo.setIcon(IconoReclamo);
        lbDespacho.setIcon(IconoDespacho);
        
        try {
            Rs = Sql.Select("SELECT id,fecha,usuario,texto,tipo,compromiso,fcompromiso\n" +
                            "FROM blog_ocp\n" +
                            "where rut=" +StrRut + "\n" +
                            "and tipdocto='OCP' \n" + 
                            "and nrodocto=" + NroOrden);
            
            while(Rs.next()){
                 //Tipo 0 = Llamada
                if(Rs.getInt("tipo")==1){
                    tm.addRow(new Object[]{lbCall,sdf.format(Rs.getTimestamp("fecha"))+ "   [" + Rs.getString("usuario").trim().toUpperCase() + "]",Rs.getString("id")});
                    
                }
                //Tipo 1 = Correo
                else if(Rs.getInt("tipo")==2) {
                    tm.addRow(new Object[]{lbMail,sdf.format(Rs.getTimestamp("fecha"))+ "   [" + Rs.getString("usuario").trim().toUpperCase() + "]",Rs.getString("id")});
                }
                // Tipo 2 = Bloque
                else if(Rs.getInt("tipo")==3) {
                    tm.addRow(new Object[]{lbIni,sdf.format(Rs.getTimestamp("fecha"))+ "   [" + Rs.getString("usuario").trim().toUpperCase() + "]",Rs.getString("id")});
                }
                // Tipo 3 = Desbloqueo
                else if(Rs.getInt("tipo")==4) {
                    tm.addRow(new Object[]{lbFin,sdf.format(Rs.getTimestamp("fecha"))+ "   [" + Rs.getString("usuario").trim().toUpperCase() + "]",Rs.getString("id")});
                }
                
                else if(Rs.getInt("tipo")==5) {
                    tm.addRow(new Object[]{lbInfo,sdf.format(Rs.getTimestamp("fecha"))+ "   [" + Rs.getString("usuario").trim().toUpperCase() + "]",Rs.getString("id")});
                }
                else if(Rs.getInt("tipo")==6) {
                    tm.addRow(new Object[]{lbReclamo,sdf.format(Rs.getTimestamp("fecha"))+ "   [" + Rs.getString("usuario").trim().toUpperCase() + "]",Rs.getString("id")});
                }else if(Rs.getInt("tipo")==7) {
                    tm.addRow(new Object[]{lbDespacho,sdf.format(Rs.getTimestamp("fecha"))+ "   [" + Rs.getString("usuario").trim().toUpperCase() + "]",Rs.getString("id")});
                }
                
                
                 //Mensaje
                String texto = Rs.getString("texto").trim(); 
                tm.addRow(new Object[]{" ",texto ,Rs.getString("id")});
                if(Rs.getBoolean("compromiso"))
                    tm.addRow(new Object[]{" ", "Compromiso: " + sdf2.format(Rs.getTimestamp("fcompromiso"))});
                    
            }
            
        } catch (Exception e) {
            fmMain.Mensaje("Ha ocurrido un error");
            LogError.Guardar(this.getClass().getSimpleName(),e.getMessage());
        } finally {
            Sql.Close();
        }
    }

    public jdBuscarHistorial() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btCerrar = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        Grilla = new javax.swing.JTable();
        txRut = new javax.swing.JTextField();
        txNroOrden = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);

        btCerrar.setText("Cerrar");
        btCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCerrarActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(204, 204, 204));

        Grilla.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        Grilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Historial", "id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Grilla.setToolTipText("");
        Grilla.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane4.setViewportView(Grilla);
        if (Grilla.getColumnModel().getColumnCount() > 0) {
            Grilla.getColumnModel().getColumn(0).setMinWidth(30);
            Grilla.getColumnModel().getColumn(0).setPreferredWidth(30);
            Grilla.getColumnModel().getColumn(0).setMaxWidth(30);
            Grilla.getColumnModel().getColumn(2).setMinWidth(0);
            Grilla.getColumnModel().getColumn(2).setPreferredWidth(0);
            Grilla.getColumnModel().getColumn(2).setMaxWidth(0);
        }

        txRut.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txRut.setText("RUT");

        txNroOrden.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txNroOrden.setText("NRO ORDEN");

        jLabel1.setText("RUT PROVEEDOR");

        jLabel2.setText("NRO. ORDEN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txRut, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txNroOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70))
            .addGroup(layout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addComponent(btCerrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txNroOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btCerrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btCerrarActionPerformed

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
            java.util.logging.Logger.getLogger(jdBuscarHistorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdBuscarHistorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdBuscarHistorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdBuscarHistorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdBuscarHistorial dialog = new jdBuscarHistorial(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txNroOrden;
    private javax.swing.JTextField txRut;
    // End of variables declaration//GEN-END:variables
}
