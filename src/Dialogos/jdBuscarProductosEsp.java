package Dialogos;

import Conexion.ExeSql;
import Formularios.fmMain;
import Utilidades.CargaGrillas;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


public class jdBuscarProductosEsp extends javax.swing.JDialog {
    private String CodigoPro;
    private String NombrePro;
    String nombrePalabra = "";
    String codigog;
    String nombreg;
    private boolean Insumos=false;
    private boolean esCotiza=false;
    public String nombreCodigo ="";
    JTableHeader cabezera;
    
    
    
    
    public jdBuscarProductosEsp(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        initComponents();
        cabezera = Grilla_prodE.getTableHeader();
        ((DefaultTableCellRenderer)cabezera.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
       
        txSku.requestFocus();
        
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);   //se implemeta evento Window Listener
        addWindowListener(new WindowAdapter() {          //para realizar una acción cuando se cierre 
          @Override                                       //directamente la ventana sin elegir una opcion
          
          
          
          public void windowClosing(WindowEvent e) {
             fmMain.cierra = true;        //variable global que valida el cierre
            
          }
        });
        
        
    }
public String GetCodigo(){
        return CodigoPro;
        
    }
public String GetNombre(){
        return NombrePro;
        
    }
public void SetInsumo(){
    Insumos=true;
}
public void SetTexto(String Texto){
    txSku.setText(Texto);
}

public void SetCotiza(Boolean Cotiza){
    esCotiza = Cotiza;
}

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Grupo1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txSku = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txNomP = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Grilla_prodE = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel1.setText("SKU");

        txSku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txSkuActionPerformed(evt);
            }
        });
        txSku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txSkuKeyPressed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos22/add2.png"))); // NOI18N
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos22/Cancel.png"))); // NOI18N
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("AGREGAR PRODUCTO");

        jLabel4.setText("ELIMINAR PRODUCTO");

        txNomP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNomPActionPerformed(evt);
            }
        });

        jLabel5.setText("Nombre");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txNomP, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txSku, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txSku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txNomP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        Grilla_prodE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "sku", "codigobarra", "Nombre", "Unidad"
            }
        ));
        Grilla_prodE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Grilla_prodEMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Grilla_prodE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1016, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private String TextoBusqueda(){
        String Texto="upper(p.nombre) like '%";
        String Palabras[] = txSku.getText().split(" ");
        
        if(Palabras.length>0){
            Texto = Texto + Palabras[0] + "%' ";
            for(int i=1; i< Palabras.length; i++){
            Texto = Texto + "or upper(p.nombre) like '%" + Palabras[i] + "%' ";
        }
        }
        else{
            Texto = Texto + txSku.getText() + "%' ";
        }
        return Texto;
    }
   
        public void buscar_prod(){  
        DefaultTableModel tbMd = new DefaultTableModel();         
        String sql = "select p.sku,cd.codbar,p.nombre,u.unidad\n" +
                     "from producto p\n" +
                     "left join par_unidad u\n" +
                     "on p.unidad=u.codigo\n" +
                     "left join inventario i\n" +
                     "on p.sku=i.sku\n" +
                     "left join codbar cd\n" +
                     "on cd.sku=i.sku\n" ;
        sql = sql + "where estado_codigo = true";
              

        try {
            CargaGrillas c = new CargaGrillas();
            tbMd = c.returndata(sql);
            Grilla_prodE.setModel(tbMd);
            Grilla_prodE.getColumnModel().getColumn(0).setPreferredWidth(10);//Sku
            Grilla_prodE.getColumnModel().getColumn(1).setPreferredWidth(10);//codigobarra
            Grilla_prodE.getColumnModel().getColumn(2).setPreferredWidth(280);//nombre
            Grilla_prodE.getColumnModel().getColumn(3).setPreferredWidth(10);//unidad

            jScrollPane1.getViewport().add(Grilla_prodE);
            //((DefaultTableCellRenderer)cabezera.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        } catch (Exception e) {
        }
    }
    
    private void txSkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txSkuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txSkuActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (txSku.getText().equals("")){
            fmMain.Mensaje("Ingrese un Código");
            txSku.setText("");
            txSku.requestFocus();
        }
        else{
            agrega_productoE(false,txSku.getText().trim());
            jButton1.setEnabled(false);
            jButton1.setEnabled(false);
            txNomP.setText("");
            txSku.setText("");
            txSku.requestFocus();
            fmMain.elimina=true;
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txNomPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNomPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNomPActionPerformed

    private void txSkuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txSkuKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
              String skufinal = txSku.getText().replace("'", "-");
              nombrePalabra =txSku.getText().trim() + Character.toString(evt.getKeyChar());
              if (nombrePalabra.substring(0,3).trim().equals("LVL") || nombrePalabra.substring(0,4).trim().equals("TRAN") || nombrePalabra.substring(0,3).trim().equals("INV") ) {
                 txSku.setText("");
                 nombrePalabra = nombrePalabra.trim();
                 txSku.requestFocus();
               return; 
              }
              else{
                 skufinal = skufinal.trim();
                 CargaProductoE(skufinal);
              }
        }  
    }//GEN-LAST:event_txSkuKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txSku.getText().equals("")){
            fmMain.Mensaje("Ingrese un Código");
            txSku.setText("");
            txSku.requestFocus();
        }
        else{
           
            agrega_productoE(true,txSku.getText().trim());
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
            txNomP.setText("");
            txSku.setText("");
            txSku.requestFocus();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Grilla_prodEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Grilla_prodEMouseClicked
        if(evt.getClickCount()==2){
            codigog = Grilla_prodE.getValueAt(Grilla_prodE.getSelectedRow(),0).toString().trim();
            nombreg = Grilla_prodE.getValueAt(Grilla_prodE.getSelectedRow(), 2).toString().trim();
            txSku.setText(codigog);
            txNomP.setText(nombreg);
            jButton2.setEnabled(true);
        }
    }//GEN-LAST:event_Grilla_prodEMouseClicked
    
    public void agrega_productoE(Boolean cod, String skup){
        ExeSql Sql2 = new ExeSql();    
        ExeSql Sql3 = new ExeSql();   
        DefaultTableModel TModel = new DefaultTableModel();
            
        try {
            Sql2.ExeSql("update producto set estado_codigo= '"+ cod +"' where sku ='" + skup+ "'");   
            Sql2.Commit();
           
        }
        catch(SQLException ex){
            
        }
        finally{
            CargaGrillas c = new CargaGrillas();
            String sqlx = "select p.sku,cd.codbar,p.nombre,u.unidad\n" +
                     "from producto p\n" +
                     "left join par_unidad u\n" +
                     "on p.unidad=u.codigo\n" +
                     "left join inventario i\n" +
                     "on p.sku=i.sku\n" +
                     "left join codbar cd\n" +
                     "on cd.sku=i.sku\n" ;
            sqlx = sqlx + "where estado_codigo = true";
            TModel = c.returndata(sqlx);
            Grilla_prodE.setModel(TModel);
            Sql2.Close();
        }
    }
    
    public void CargaProductoE(String Codigo) {   
        ExeSql Sql3 = new ExeSql();
       
        ResultSet resultado = null;
        
        String Query3;
        int revisa_codbar =0;
        int revisa_codchile =0;
   
        try {
           
            resultado = Sql3.Select("select codbar, sku from codbar where sku='" + Codigo + "' or codbar='"+ Codigo + "'" );        
                    if (resultado.next())
                    {
                        Codigo = resultado.getString("sku").trim();
                        revisa_codbar++;
                    }
            resultado = Sql3.Select("select idch, sku from codchile where sku='" + Codigo +"' or idch='"+ Codigo + "'" );
                    if (resultado.next())
                    {
                        Codigo = resultado.getString("sku").trim();
                        revisa_codchile++;
                    }
            resultado = Sql3.Select("select codbar, sku from codbar where sku='" + Codigo + "' or codbar='"+ Codigo + "'" );        
                    if (resultado.next())
                    {
                        Codigo = resultado.getString("sku").trim();
                        revisa_codbar++;
                    }
            
            
             Query3 ="select p.sku,p.nombre, u.unidad " 
                    + " from producto p \n"
                    + " left join inventario i\n"
                    + " on p.sku=i.Sku\n"
                    + " left join par_unidad u on  u.codigo = p.unidad\n "
                    + " where p.sku='" + Codigo + "' or p.sku in (select sku from codbar where codbar='" + Codigo + "')";
            
            
            resultado = Sql3.Select(Query3);
             
            if(Sql3.GetRowCount()==0){  
                 fmMain.Mensaje("SKU: " + txSku.getText().trim() + " no está en la Bases de Datos! ");
                 txSku.setText("");
                 txNomP.setText("");
                 txSku.requestFocus();
                 return;
            }
            else if (Sql3.GetRowCount()>0){ 
                 resultado.next();
                 txSku.setText(resultado.getString("sku"));
                 txNomP.setText(resultado.getString("nombre"));
                 jButton1.setEnabled(true);
                 jButton2.setEnabled(true);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Sql3.Close();
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
            java.util.logging.Logger.getLogger(jdBuscarProductosEsp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdBuscarProductosEsp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdBuscarProductosEsp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdBuscarProductosEsp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdBuscarProductosEsp dialog = new jdBuscarProductosEsp(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable Grilla_prodE;
    private javax.swing.ButtonGroup Grupo1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txNomP;
    private javax.swing.JTextField txSku;
    // End of variables declaration//GEN-END:variables
}

