/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelForm;

import Conexion.ExeSql;
import Conexion.ExeSql1_Mysql;
import Formularios.fmMain;
import static Formularios.fmMain.pnPestanas;
import Utilidades.Exporter;
import Utilidades.PanelTab;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;  
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author infornatica
 */
public class pfReporteMovUbc extends javax.swing.JPanel {
    
    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    DefaultTableCellRenderer centerRenderer2 = new DefaultTableCellRenderer();
    
    
    Date hoy = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private static int HEADER_HEIGHT = 40;
    
    int CargaInforme = 0;
    
    Calendar cal = Calendar.getInstance();
    int year  = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH)+1;
    int day = cal.get(Calendar.DAY_OF_MONTH)-1;
    
    
    public pfReporteMovUbc() {
        initComponents();
        
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
             
        Grilla.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        Grilla.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        Grilla.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        Grilla.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        
        
        JTableHeader header = Grilla.getTableHeader();
        header.setPreferredSize(new Dimension(50, HEADER_HEIGHT));
        header.setAlignmentX(TOP_ALIGNMENT);
       
        Cargar.setVisible(false);
        
        
        //Cargar.doClick();
      
      
        System.out.println("AÑO : "+year);
        System.out.println("MES : "+month);
        System.out.println("DIA : "+day);
        
        
        CargaMovimientos();
        
      
    }

    
    public void CargaMovimientos() {
        DefaultTableModel model = (DefaultTableModel) Grilla.getModel();
        
        
        while(model.getRowCount()>0){
            model.removeRow(0);
        }
       
        ExeSql Sql = new ExeSql();
        ResultSet Rs = null;
        
        ExeSql Sql2 = new ExeSql();
        ResultSet Rs2 = null;
        
        
        String Sku = "";
        boolean ml = false;
        try {
            
            Rs = Sql.Select("select cd.sku, p.nombre, cd.tipdocto, cd.nrodocto, c.femision, i.stock, p.nropublicacion from ctacteclidet cd\n" +
                            "left join ctactecli c on cd.rut = c.rut and cd.nrodocto = c.nrodocto and cd.tipdocto IN ('BOC','FAC')\n" +
                            "left join inventario i on cd.sku = i.sku\n" +
                            "left join producto p on cd.sku = p.sku \n" +
                            "where extract(year from c.femision)= "+year+"\n" +
                            "and extract(month from c.femision)= "+month+"\n" +
                            "and extract(day from c.femision)="+day+"\n" +
                            "and i.stock <= 0 \n" +
                            "order by p.nombre, cd.nrodocto DESC ");
              
                if (Sql.GetRowCount() > 0){
              
                    while (Rs.next()) {  
             
                        
                        if (!Rs.getString("sku").trim().equals(Sku)){
                            
                            
                            if (!Rs.getString("nropublicacion").toString().trim().equals("0") ){
                
                               ml = true;
                    
                            }else {
                    
                                ml = false;
                
                            } 
                            
                            model.addRow(new Object[]{
                                                 Rs.getString("sku"),   
                                                 Rs.getString("nombre"), 
                                                 Rs.getString("tipdocto"), 
                                                 Rs.getString("nrodocto"), 
                                                 Rs.getString("femision"), 
                                                 Rs.getString("stock"),
                                                 ml
                                                  
                            });
                            
                            Sku = Rs.getString("sku").trim();
                            
                        }     
                                                    
                    }  
                            
              
                }
                
                
                 Rs2 = Sql2.Select("select ms.sku, ms.fecha, p.nombre, ms.tipdocto, ms.nrodocto,ms.cantidad, i.stock, p.nropublicacion "+
                                   "from movimientos_stock ms \n" +
                                   "left join inventario i on ms.sku = i.sku \n"+
                                   "left join producto p on ms.sku = p.sku \n" +
                                   "where extract(year from ms.fecha)= "+year+"\n" +
                                   "and extract(month from ms.fecha)= "+month+"\n" +
                                   "and extract(day from ms.fecha)="+day+"\n" +
                                   "and ms.tipdocto IN ('AJU') and ms.cantidad < 0 and i.stock <= 0 ");
              
                if (Sql2.GetRowCount() > 0){
                
                    
                     while (Rs2.next()) {
             
                        
                        if (!Rs2.getString("sku").trim().equals(Sku)){
                            
                            
                            if (!Rs2.getString("nropublicacion").toString().trim().equals("0") ){
                
                               ml = true;
                    
                
                            }else {
                    
                                ml = false;
                
                            }   
                            
                            model.addRow(new Object[]{
                                                 Rs2.getString("sku"),  
                                                 Rs2.getString("nombre"), 
                                                 Rs2.getString("tipdocto"), 
                                                 Rs2.getString("nrodocto"), 
                                                 Rs2.getString("fecha"), 
                                                 Rs2.getString("stock"),
                                                 ml
                                                 
                                                  
                            });
                            
                            Sku = Rs2.getString("sku").trim();
                            
                            
                            
                        } 
                     }
                    
                
                
                }////////
                
                
               
            
             lbTotalOrd.setText(""+model.getRowCount());
           
            
        } catch (SQLException ex) {
            Logger.getLogger(pfReporteMovUbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
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

        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Grilla = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        lbTotalOrd = new javax.swing.JLabel();
        FechaVenc = new org.jdesktop.swingx.JXMonthView();
        Cargar = new javax.swing.JButton();

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        Grilla.setAutoCreateRowSorter(true);
        Grilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Sku", "Descripción", "cod.ubc", "Ubicación", "Fecha ", "Valor Inicial", "Valor Final"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Grilla.getTableHeader().setReorderingAllowed(false);
        Grilla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GrillaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                GrillaMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(Grilla);
        if (Grilla.getColumnModel().getColumnCount() > 0) {
            Grilla.getColumnModel().getColumn(0).setMinWidth(90);
            Grilla.getColumnModel().getColumn(0).setPreferredWidth(90);
            Grilla.getColumnModel().getColumn(0).setMaxWidth(90);
            Grilla.getColumnModel().getColumn(1).setPreferredWidth(350);
            Grilla.getColumnModel().getColumn(2).setMinWidth(0);
            Grilla.getColumnModel().getColumn(2).setPreferredWidth(0);
            Grilla.getColumnModel().getColumn(2).setMaxWidth(0);
            Grilla.getColumnModel().getColumn(3).setMinWidth(70);
            Grilla.getColumnModel().getColumn(3).setPreferredWidth(70);
            Grilla.getColumnModel().getColumn(3).setMaxWidth(70);
        }

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Registros:");

        lbTotalOrd.setText("0");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 843, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(lbTotalOrd, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTotalOrd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                .addContainerGap())
        );

        FechaVenc.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        FechaVenc.setAutoscrolls(true);
        FechaVenc.setTraversable(true);
        FechaVenc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FechaVencActionPerformed(evt);
            }
        });

        Cargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/Actualiza.png"))); // NOI18N
        Cargar.setText("Cargar");
        Cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FechaVenc, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(FechaVenc, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void CargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarActionPerformed
       
        
        year  = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH)+1;
        day = cal.get(Calendar.DAY_OF_MONTH)-1;
        
        
        CargaMovimientos();
      
   
    }//GEN-LAST:event_CargarActionPerformed

    private void GrillaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrillaMousePressed
        //CargaDetalleOrdenes();        // TODO add your handling code here:
    }//GEN-LAST:event_GrillaMousePressed

    
    
    
    
    private void GrillaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrillaMouseClicked
        
        if (evt.getClickCount() == 2) {
            pfProductos Pro = new pfProductos();
            Pro.setOpaque(false);
            pnPestanas.addTab("Producto", Pro);
            PanelTab btc = new PanelTab(pnPestanas, 0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Pro), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
            Pro.txSku.requestFocus();
            Pro.CargaProducto(Grilla.getValueAt(Grilla.getSelectedRow(), 0).toString().trim());
        }
        
    }//GEN-LAST:event_GrillaMouseClicked

    private void FechaVencActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FechaVencActionPerformed
        
        day = Integer.parseInt(dateFormat.format(FechaVenc.getSelectionDate()).substring(0, 2));
        month = Integer.parseInt(dateFormat.format(FechaVenc.getSelectionDate()).substring(3, 5));
        year = Integer.parseInt(dateFormat.format(FechaVenc.getSelectionDate()).substring(6));
        
        CargaMovimientos();
      
        
        
    }//GEN-LAST:event_FechaVencActionPerformed

    
    
    
    
    
    public String getFecha() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return( sdf.format( hoy ) );
    }
    
    
    
    
    private void ActualizaWeb(String sku_web,int precio_web) {
        
        ExeSql luvaly = new ExeSql();
        ExeSql luvalyweb = new ExeSql();
        
        ResultSet producto_luvaly = null;
        ResultSet producto_web = null;
        ResultSet producto_publicado = null;
        ResultSet producto_precio_web = null;
        ResultSet producto_madre = null;
        ResultSet producto_precio_regular = null;
        
        ExeSql1_Mysql page = new ExeSql1_Mysql();
        ExeSql1_Mysql price = new ExeSql1_Mysql();
        ExeSql1_Mysql price2 = new ExeSql1_Mysql();
        ExeSql1_Mysql price3 = new ExeSql1_Mysql();
        ExeSql1_Mysql regular_price = new ExeSql1_Mysql();
        
        
        
        double precioregular = 0;
        
       
       
        try {
            
            
            String Sku = sku_web.trim();
            
             producto_luvaly = luvaly.Select("select p.sku, p.nombre from producto p \n"+
                                             "where p.sku = '"+Sku+"'");   
             

            
            if (luvaly.GetRowCount() > 0){
                
                
                producto_luvaly.next();
               
            //Precio Luvaly *****************************************************************************************
                
               String precio = "0";
               String precio_actual = ""; 
               
               precio= String.valueOf(precio_web);
              
                //Meta Página    
                producto_web = page.Select("select post_id,meta_value from wpkj_postmeta \n"+            //Se selecciona el producto por su sku
                                           "where meta_key='_sku' "+
                                           "and meta_value='"+producto_luvaly.getString("sku")+"'");
                
                
                if(producto_web.next()){
                    
                    
                //******************** Verifica si esta como publicado en Luvaly ***************************************//
                  
                
                    
                     producto_publicado = luvaly.Select("select * from codweb \n" +
                                                        "where sku = '"+producto_luvaly.getString("sku")+"'");
                
                    if(luvaly.GetRowCount() > 0) {
                
                             luvalyweb.ExeSql("update codweb set publicado = true \n"+
                                              "where sku =  '"+producto_luvaly.getString("sku")+"'");
                             luvalyweb.Commit();
                                    
                
                    }else if(luvaly.GetRowCount() == 0) {
                    
                          luvalyweb.ExeSql("insert into codweb (sku,publicado) values ('"+producto_luvaly.getString("sku")+"',true)");
                          luvalyweb.Commit();
                    
                    
                    }
                        
                //******************************************************************************************************************//    
                                          
                    producto_precio_web = price.Select("select meta_value from wpkj_postmeta \n"+           //Se selecciona el precio por su ID
                                                       "where post_id="+producto_web.getString("post_id")+ " \n"+
                                                       "and meta_key='_price'");
                        
                        
                    if(producto_precio_web.next()){
                        
                            precio_actual = producto_precio_web.getString("meta_value").trim();    //Se toma el precio publicado (actual)
                            
                            producto_precio_regular = regular_price.Select("select meta_value from wpkj_postmeta \n"+           //Se selecciona el precio regular por su ID
                                                                           "where post_id="+producto_web.getString("post_id")+ " \n"+
                                                                           "and meta_key='_regular_price'");
                            
                            producto_precio_regular.next();
                            
                            if (producto_precio_regular.getDouble("meta_value") <= Double.parseDouble(precio)){
                            
                                    precioregular = 0;
                                    
                            }else {
                                    
                                    precioregular = producto_precio_regular.getDouble("meta_value");
                            
                            }
                            
                            
                            
//                            System.out.println(""+producto_luvaly.getString("sku")+" - "+producto_luvaly.getString("nombre")+"\n");
//                            System.out.println("Precio página: " +producto_precio_web.getString("meta_value")+"\n");
//                            System.out.println("Precio luvaly: "+precio+"\n");
//                            System.out.println("Precio Regular página: " +producto_precio_regular.getString("meta_value")+"\n");
                            
                            producto_madre = price.Select("select post_type from wpkj_posts \n"+             //Se busca el ID del SKU madre
                                                          "where ID="+producto_web.getString("post_id"));
                            
                            if (producto_madre.next()){  
                             
                                if (producto_madre.getString("post_type").equals("product")){  
                                                                        
                                    if (precioregular == 0){  
                                        
                                            price2.ExeSql("update wpkj_postmeta set meta_value = 0 "+
                                                         " where post_id="+producto_web.getString("post_id")+
                                                         " and meta_key IN ('_regular_price') ");
                                            price2.Commit();
                                        
                                    }
                                    
                                    
                                 //   if (Double.parseDouble(precio) < Double.parseDouble(precio_actual)){  
                                        
                                        precio = precio.replaceAll("\\.0", "");

                                            price3.ExeSql("update wpkj_postmeta set meta_value = "+Integer.parseInt(precio)+
                                                         " where post_id="+producto_web.getString("post_id")+
                                                         " and meta_key IN ('_regular_price') ");
                                            price3.Commit();
                                        
                                  //  }
                                    
                                                                        
                                    price.ExeSql("update wpkj_postmeta set meta_value = "+Integer.parseInt(precio)+
                                                  " where post_id="+producto_web.getString("post_id")+
                                                  " and meta_key IN ('_price') ");
                                     
                                    price.Commit();
                                     
                                }
                             
                            }
                             
                        }
                            
                                                
                }else {  // If de precio.web
                
                    
                    //******************** Verifica si esta como publicado en Luvaly ***************************************//
                    
                    String query_sku2 = "select * from codweb \n" +
                                        "where sku = '"+producto_luvaly.getString("sku")+"'"; 
                
                    
                     producto_publicado = luvaly.Select(query_sku2);
                
                    if(luvaly.GetRowCount() > 0) {
                
                             luvalyweb.ExeSql("update codweb set publicado = false \n"+
                                              "where sku = '"+producto_luvaly.getString("sku")+"'");
                             luvalyweb.Commit();
                                    
                
                    }
                        
                //******************************************************************************************************************//    
                    
                    
                    
                    
                }    
            } 
            
                      
        } catch (SQLException ex) {
        
            page.Rollback();
            price.Rollback();
            price2.Rollback();
            price3.Rollback();
            luvalyweb.Rollback();
         
            Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
        
        } finally {
            luvaly.Close();
            page.Close();
            price.Close();
            price2.Close();
            price3.Close();
            regular_price.Close();
            luvalyweb.Close();
           
           
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Cargar;
    private org.jdesktop.swingx.JXMonthView FechaVenc;
    private javax.swing.JTable Grilla;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbTotalOrd;
    // End of variables declaration//GEN-END:variables
}
