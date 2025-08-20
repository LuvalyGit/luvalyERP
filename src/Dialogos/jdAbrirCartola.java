
package Dialogos;

import Conexion.ExeSql;
import Utilidades.CargaGrillas;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jcifs.smb.*;
import org.apache.commons.io.FileUtils;


public class jdAbrirCartola extends javax.swing.JDialog {
    int ModalResult;
    String NumeroMaster;
    String TipoMaster;
    DefaultTableModel TablaModelo;
    String sCarpAct = "";
    
    public jdAbrirCartola(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        String[] listado;
        
        TablaModelo = (DefaultTableModel) Grilla.getModel();
        //String sCarpAct = System.getProperty("user.dir");
        
        
         String sSistemaOperativo = System.getProperty("os.name");               //Determina el Sistema Operativo del Equipo
            
            if (sSistemaOperativo.contains("Win")){
        
                sCarpAct = "\\\\192.168.0.130\\cartolas";
                System.out.println(sCarpAct);
                File carpeta = new File(sCarpAct);
       
                listado = carpeta.list();
                if (listado == null || listado.length == 0) {
                    System.out.println("No hay elementos dentro de la carpeta actual");
                    return;
        
                }else {
        
                    for (int i=0; i< listado.length; i++) {
                        
                        System.out.println(listado[i]);
                        TablaModelo.addRow(new Object[]{listado[i]});
                    }
                }
                
            }else{
            
                sCarpAct = "smb://192.168.0.130/cartolas/";
            
                try {
                
                    SmbFile carpeta = new SmbFile(sCarpAct);
                    listado = carpeta.list();
                    for (int i=0; i< listado.length; i++) {
                        
                        System.out.println(listado[i]);
                        TablaModelo.addRow(new Object[]{listado[i]});
                    }
                    
                    
                    
                
                } catch (MalformedURLException | SmbException ex) {
                    
                    Logger.getLogger(jdAbrirCartola.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        
        
        
        
        
        
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

            },
            new String [] {
                "Cartola"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
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
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public String GetNumero(){
        return NumeroMaster;
    }
    public String GetTipo(){
        return TipoMaster;
    }
    private void GrillaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrillaMouseClicked
        
        if(evt.getClickCount()==2 ){
            
            String sSistemaOperativo = System.getProperty("os.name");               //Determina el Sistema Operativo del Equipo
            if (sSistemaOperativo.contains("Win")){
            
                try {

                    String archivo = sCarpAct+"\\"+Grilla.getValueAt(Grilla.getSelectedRow(), 0).toString().trim();
            
                    File objetofile = new File (archivo);
                    Desktop.getDesktop().open(objetofile);
                    dispose();

                }catch (IOException ex) {

                    System.out.println(ex);

                }
            
            }else{
            
                try {

                    String archivo = sCarpAct+"//"+Grilla.getValueAt(Grilla.getSelectedRow(), 0).toString().trim();
                    SmbFile carpeta = new SmbFile(archivo);
                    InputStream In = carpeta.getInputStream();
                    File targetFile = new File("/fotos/cartola/"+Grilla.getValueAt(Grilla.getSelectedRow(), 0).toString().trim()+"/");
                    FileUtils.copyInputStreamToFile(In, targetFile);
                    Desktop.getDesktop().open(targetFile);
                    dispose();

                }catch (IOException ex) {

                    System.out.println(ex);

                }
                
                
            
            }
                        
        }
        
    }//GEN-LAST:event_GrillaMouseClicked
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
        if(Tipo.equals("FAC") || Tipo.equals("GDC") || Tipo.equals("NCC") || Tipo.equals("FEC")|| Tipo.equals("NDC") || Tipo.equals("FMC")|| Tipo.equals("FAT")|| Tipo.equals("MUL") )
            Tabla = "ctactecli";
        else
            Tabla = "ctacteprv";
        
        String sql = "SELECT tipdocto,nrodocto,femision,estado "+
                     "FROM "+ Tabla   +
                     " WHERE TipDocto in ('" + Tipo + "') " +
                     "AND   Rut = " + Rut + " " +
                     "ORDER BY femision desc";
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
        if(Tipo.equals("FAC") || Tipo.equals("GDC") || Tipo.equals("NCC") || Tipo.equals("FEC") || Tipo.equals("NCP") || Tipo.equals("MUL") )
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
            java.util.logging.Logger.getLogger(jdAbrirCartola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdAbrirCartola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdAbrirCartola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdAbrirCartola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdAbrirCartola dialog = new jdAbrirCartola(new javax.swing.JFrame(), true);
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
