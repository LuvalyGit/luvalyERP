/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dialogos;

import Conexion.ExeSql;
import Formularios.fmMain;
import Utilidades.Ftp;
import Utilidades.ImageSelection;
import Utilidades.ImgTabla;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author David Alcaman
 */
public class jdOCC_Transporte extends javax.swing.JDialog {

    /**
     * Creates new form jdOCC_Transporte
     */
    public jdOCC_Transporte(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Grilla.getTableHeader().setFont(new Font("Arial", Font.BOLD, 10));
    }
    public void CargaTransporte(String Codigo_Oc, String Orden){
        ExeSql Sql =new ExeSql();
        ResultSet Rs;
        DefaultTableModel Model = (DefaultTableModel) Grilla.getModel();
        String Transporte="";
        String Voucher="";
        String Bultos="";
        String Fecha="";
        String Tipo="";
        Grilla.setDefaultRenderer(Object.class, new ImgTabla());
        JLabel lbImagen  = new JLabel();
        JLabel lbPdf     = new JLabel();
        URL    urlImagen = this.getClass().getResource("/Iconos16/Imagen16.png"); 
        URL    urlPdf    = this.getClass().getResource("/Iconos16/pdf.png");
        
        ImageIcon IconoImagen =  new ImageIcon(urlImagen); 
        ImageIcon IconoPdf    =  new ImageIcon(urlPdf);
        
        
        fmMain.LimpiaGrilla(Model);
        
        try {
            Rs = Sql.Select("select g.codigo as codtransporte, c.tipdocto,c.nrodocto,g.nombre,d.otro_trans,d.voucher,d.bultos,d.peso,d.fdespacho, \n" +
                            "case when d.imagen_voucher is null then 'nulo' else d.imagen_voucher end, case when d.pdf_voucher is null then 'nulo' else d.pdf_voucher end\n" +
                            "from ctactecli c\n" +
                            "left join transporte_despachos d on c.tipdocto=d.tipdocto and c.nrodocto=d.nrodocto\n" +
                            "left join par_general g on g.tipo='TRANSPORTE' and g.codigo=d.transporte\n" +
                            "where c.codigo_oc="+ Codigo_Oc +"\n" +
                            "and occh='"+ Orden + "'" +
                            "and c.transporte=true");
            while(Rs.next()){
                try {
                    Tipo = Rs.getString("tipdocto").trim();
                    if(Rs.getString("otro_trans").trim().isEmpty())
                        Transporte = Rs.getString("nombre").trim();
                    else
                        Transporte = Rs.getString("otro_trans").trim();
                    Voucher = Rs.getString("voucher").trim();
                    Bultos = Rs.getString("bultos").trim();
                    Fecha = Rs.getString("fdespacho").trim();
                    lbImagen.setIcon(IconoImagen);
                    lbPdf.setIcon(IconoPdf);
                    
                    if(!Rs.getString("imagen_voucher").trim().equals("nulo") ){
                      
                        if(!Rs.getString("pdf_voucher").trim().equals("nulo")){
                            Model.addRow(new Object[]{
                                Tipo,
                                Rs.getString("nrodocto").trim(),
                                Transporte,
                                Voucher,
                                Fecha,
                                Bultos,
                                lbImagen,
                                lbPdf,
                                Rs.getString("codtransporte")
                                }); 
                       
                        }
                        else{
                                         
                        Model.addRow(new Object[]{
                                Tipo,
                                Rs.getString("nrodocto").trim(),
                                Transporte,
                                Voucher,
                                Fecha,
                                Bultos,
                                lbImagen,
                                "",
                                Rs.getString("codtransporte")
                                }); 
                        }
                    }
                    else{
                        if(!Rs.getString("pdf_voucher").trim().equals("nulo")){
                            Model.addRow(new Object[]{
                                Tipo,
                                Rs.getString("nrodocto").trim(),
                                Transporte,
                                Voucher,
                                Fecha,
                                Bultos,
                                "",
                                lbPdf,
                                Rs.getString("codtransporte")
                                }); 
                       
                        }
                        else{
                        Model.addRow(new Object[]{
                            Tipo,
                            Rs.getString("nrodocto").trim(),
                            Transporte,
                            Voucher,
                            Fecha,
                            Bultos,
                            "",
                            "",
                            Rs.getString("codtransporte")
                            });
                        }
                    }
                } catch (Exception e) {
                     Model.addRow(new Object[]{
                            Tipo,
                            Rs.getString("nrodocto").trim(),
                            Transporte,
                            Voucher,
                            Fecha,
                            Bultos,
                            "",
                            "",
                            Rs.getString("codtransporte")
                            });
                }
                
               
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally{
            Sql.Close();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        Grilla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jMenuItem1.setText("Copiar Voucher");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Ver Voucher");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Grilla.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        Grilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TIPO", "NUMERO", "TRANSPORTE", "VOUCHER", "FECHA", "BULTOS", "Imagen", "PDF", "cod_transporte"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Grilla.setComponentPopupMenu(jPopupMenu1);
        Grilla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GrillaMouseClicked(evt);
            }
        });
        Grilla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                GrillaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Grilla);
        if (Grilla.getColumnModel().getColumnCount() > 0) {
            Grilla.getColumnModel().getColumn(0).setPreferredWidth(60);
            Grilla.getColumnModel().getColumn(1).setMinWidth(75);
            Grilla.getColumnModel().getColumn(1).setPreferredWidth(75);
            Grilla.getColumnModel().getColumn(1).setMaxWidth(75);
            Grilla.getColumnModel().getColumn(2).setPreferredWidth(150);
            Grilla.getColumnModel().getColumn(3).setPreferredWidth(200);
            Grilla.getColumnModel().getColumn(4).setMinWidth(75);
            Grilla.getColumnModel().getColumn(4).setPreferredWidth(75);
            Grilla.getColumnModel().getColumn(4).setMaxWidth(75);
            Grilla.getColumnModel().getColumn(5).setPreferredWidth(40);
            Grilla.getColumnModel().getColumn(6).setPreferredWidth(30);
            Grilla.getColumnModel().getColumn(8).setMinWidth(10);
            Grilla.getColumnModel().getColumn(8).setPreferredWidth(10);
            Grilla.getColumnModel().getColumn(8).setMaxWidth(10);
        }

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/ok_16.png"))); // NOI18N
        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(428, 428, 428)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        public void CargaPdf(int Transporte, String Voucher,String nro){
        ResultSet Rs;
        ExeSql Sql = new ExeSql();
        String server,user,pass,ruta_local="";
        int puerto =21;
         String rutaimage="";
        try {

//            server= "192.168.0.130";
//            user="voucher";
//            pass="V2369";
            
            
           //trae datos ftp
            server="";
            puerto=0;
            user=""; 
            pass="";
            	Rs = Sql.Select("SELECT * from conexiones where tipo='ftp'");
                if (Rs.next())
                {
                    if(!fmMain.GetInternet()){
                        server = Rs.getString("serv");
                        user  = Rs.getString("usu");
                        puerto  = Rs.getInt("port");
                        pass = Rs.getString("pass");
                    }
                    else {
                        server = "186.67.157.227";
                        user  = Rs.getString("usu");
                        puerto  = 21;
                        pass = Rs.getString("pass");
                    }
                }
           //trae datos ftp
            
            Rs = Sql.Select("SELECT count(pdf_voucher) as hay from transporte_despachos where transporte="+Transporte+" and voucher='"+Voucher+"' and nrodocto = "+nro+"");
            Rs.next();
            if (Rs.getInt("hay")>=1)
            {
                if (Voucher.equals("")){
                    Voucher = Rs.getString("voucher");
                }                    
                Rs = Sql.Select("SELECT pdf_voucher as pdf from transporte_despachos where transporte ="+Transporte+" and voucher = '" + Voucher + "' and nrodocto = "+nro+"");
                Rs.next();
                if (Rs.getString("pdf") != null)
                {

                    //Verifica SO
                    String sistema = System.getProperty("os.name").toLowerCase();
                    File folder = new File("");
                    if (sistema.contains("win"))
                    {
                         ruta_local = "c:/fotos2/";
                         folder = new File(ruta_local.substring(0,ruta_local.length()-1));
                    }
                    else{
                          ruta_local = "/fotos2/";
                          folder = new File(ruta_local);
                    }
                    if (!folder.exists())
                    {
                        folder.mkdir();
                    }
                    String archivo = "";
                    rutaimage=Rs.getString("pdf");
                    
                    String rutrans="";
                    if (Transporte == 1)
                    {
                        rutrans = "/tnt/";
                        //archivo = rutaimage.substring(33,rutaimage.length());
                         archivo = fmMain.GetStringDeFinal('\\', rutaimage);
                    }
                    else if (Transporte == 7)
                    {
                        rutrans = "/blue/";
                        //archivo = rutaimage.substring(34,rutaimage.length());
                         archivo = fmMain.GetStringDeFinal('\\', rutaimage);
                    }
                    else
                        {
                        rutrans = "/";
                        archivo = fmMain.GetStringDeFinal('\\', rutaimage);
                    }
                    
                   String  Archivo_buscado = Ftp.busca_archivoFTP(server, puerto, user, pass, ruta_local,"", archivo);

                   if (Archivo_buscado.equals("") )
                   {
                       System.out.println(server +"-"+ puerto +"-"+ user+": "+pass+", "+rutrans+archivo+","+ ruta_local+archivo);
                    Ftp.baja_archivo_ftp(server, puerto,user, pass,rutrans+archivo,ruta_local + archivo);
                    File file = new File(archivo);
                    File pathCompleto = new File(ruta_local + file);
                    Desktop.getDesktop().open(pathCompleto);
                    Image img = ImageIO.read(new File(pathCompleto.toString()));//path to image file
                       ImageSelection imageSelection = new ImageSelection(img);
                       Toolkit toolkit = Toolkit.getDefaultToolkit();
                       toolkit.getSystemClipboard().setContents(imageSelection, null);
                       
                    
                   }     
                   else
                   {
                       System.out.println(server +"-"+ puerto +"-"+ user+": "+pass+", "+rutrans+archivo+","+ ruta_local+archivo);
                        rutrans = "/";
                        Ftp.baja_archivo_ftp(server, puerto,user, pass,rutrans+archivo,ruta_local + Archivo_buscado);
                        File file = new File(archivo);
                        File pathCompleto = new File(ruta_local + file);
                        
                        
                        Image img = ImageIO.read(new File(pathCompleto.toString()));//path to image file
                        ImageSelection imageSelection = new ImageSelection(img);
                        Toolkit toolkit = Toolkit.getDefaultToolkit();
                        toolkit.getSystemClipboard().setContents(imageSelection, null);
                       

        
                        Desktop.getDesktop().open(pathCompleto); 
                        
                   }                   
                }
               
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        finally{
            Sql.Close();
            
        }
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if(!Grilla.getValueAt(Grilla.getSelectedRow(), 3).toString().trim().isEmpty()){
            StringSelection Voucher = new StringSelection(Grilla.getValueAt(Grilla.getSelectedRow(), 3).toString().trim());
            Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
            cb.setContents(Voucher, null);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
         try{                                      
        if(!Grilla.getValueAt(Grilla.getSelectedRow(), 3).toString().trim().isEmpty()){

            String Tipo = Grilla.getValueAt(Grilla.getSelectedRow(), 0).toString().trim();
            String Numero = Grilla.getValueAt(Grilla.getSelectedRow(), 1).toString().trim();
            String Trans = Grilla.getValueAt(Grilla.getSelectedRow(), 2).toString().trim();
            String Voucher = Grilla.getValueAt(Grilla.getSelectedRow(), 3).toString().trim();
            
            jdVoucher Vouch = new jdVoucher(null, true);
            Vouch.Tipo=Tipo;
            Vouch.Numero=Numero;
            Vouch.Trans=Trans; 
            Vouch.Voucher=Voucher;         
            Vouch.CargaImagen(Tipo, Numero, Voucher);
            Vouch.setTitle("Voucher "+Trans+" nº"+Voucher+" - "+Tipo+" nº"+Numero);
            Vouch.setLocationRelativeTo(null);
            Vouch.setVisible(true);
        }    
         }catch (Exception e) {
     fmMain.Mensaje("Asegurese de seleccionar un voucher");
    }
         
       
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void GrillaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrillaMouseClicked
        
                if(evt.getClickCount()==2){
            
            if(evt.isAltDown())
            {
            }
            else{
              if(Grilla.getValueAt(Grilla.getSelectedRow(), 6)!=null)
                    jMenuItem2.doClick();  
            }
            
        }
    }//GEN-LAST:event_GrillaMouseClicked

    private void GrillaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GrillaKeyReleased
            if (evt.getKeyCode() == KeyEvent.VK_F12 )
       {
        String trans = String.valueOf(Grilla.getValueAt(Grilla.getSelectedRow(), 8)).trim();
        int transporte= Integer.valueOf(trans);
        String voucher= String.valueOf(Grilla.getValueAt(Grilla.getSelectedRow(), 3)).trim();
        String nro= String.valueOf(Grilla.getValueAt(Grilla.getSelectedRow(), 1)).trim();
        CargaPdf(transporte, voucher, nro);
       }
    }//GEN-LAST:event_GrillaKeyReleased

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
            java.util.logging.Logger.getLogger(jdOCC_Transporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdOCC_Transporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdOCC_Transporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdOCC_Transporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdOCC_Transporte dialog = new jdOCC_Transporte(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
