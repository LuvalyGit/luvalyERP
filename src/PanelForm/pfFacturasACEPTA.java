
package PanelForm;

import Conexion.ExeSql;
import Dialogos.jdIngresaFacACEPTA;
import Formularios.fmMain;
import static Formularios.fmMain.intNivelUsuario;
import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.*;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import org.jespxml.excepciones.AtributoNotFoundException;
import org.jespxml.JespXML;
import org.jespxml.excepciones.TagHijoNotFoundException;
import org.jespxml.modelo.Tag;
import org.json.JSONObject;
import org.json.JSONException;
import org.json.XML;
import org.xml.sax.SAXException;


/**
 *
 * @author Roberto Lopez
 */
public class pfFacturasACEPTA extends javax.swing.JPanel {
    
   DefaultTableModel TModelo;
   int NivelUsuario = 0;
    
    public pfFacturasACEPTA() {          
        
        initComponents();
        TModelo = (DefaultTableModel) Grilla.getModel();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btCargar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Grilla = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txFiltro = new javax.swing.JTextField();
        btIngresar = new javax.swing.JButton();
        rbIngresados = new javax.swing.JRadioButton();
        rbNoIngresados = new javax.swing.JRadioButton();
        rbTodos = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1233, 660));
        setMinimumSize(new java.awt.Dimension(0, 0));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1233, 660));

        btCargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos22/Cargar.png"))); // NOI18N
        btCargar.setText("Cargar Documentos");
        btCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCargarActionPerformed(evt);
            }
        });

        Grilla.setAutoCreateRowSorter(true);
        Grilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "RUT", "Provedor", "Tipo Doc.", "Num Doc.", "Fec. Emision", "Total Exento", "Total Afecto", "Total IVA", "Total Dcto.", "Correlativo", "Total CtaPrv.", "Documento", "Diferencia", "Estado"
            }
        ));
        jScrollPane1.setViewportView(Grilla);
        if (Grilla.getColumnModel().getColumnCount() > 0) {
            Grilla.getColumnModel().getColumn(0).setMinWidth(80);
            Grilla.getColumnModel().getColumn(0).setPreferredWidth(80);
            Grilla.getColumnModel().getColumn(0).setMaxWidth(80);
            Grilla.getColumnModel().getColumn(1).setMinWidth(390);
            Grilla.getColumnModel().getColumn(1).setPreferredWidth(390);
            Grilla.getColumnModel().getColumn(1).setMaxWidth(390);
            Grilla.getColumnModel().getColumn(2).setMinWidth(70);
            Grilla.getColumnModel().getColumn(2).setPreferredWidth(70);
            Grilla.getColumnModel().getColumn(2).setMaxWidth(70);
            Grilla.getColumnModel().getColumn(3).setMinWidth(75);
            Grilla.getColumnModel().getColumn(3).setPreferredWidth(75);
            Grilla.getColumnModel().getColumn(3).setMaxWidth(75);
            Grilla.getColumnModel().getColumn(4).setMinWidth(80);
            Grilla.getColumnModel().getColumn(4).setPreferredWidth(80);
            Grilla.getColumnModel().getColumn(4).setMaxWidth(80);
            Grilla.getColumnModel().getColumn(5).setMinWidth(85);
            Grilla.getColumnModel().getColumn(5).setPreferredWidth(85);
            Grilla.getColumnModel().getColumn(5).setMaxWidth(85);
            Grilla.getColumnModel().getColumn(6).setMinWidth(85);
            Grilla.getColumnModel().getColumn(6).setPreferredWidth(85);
            Grilla.getColumnModel().getColumn(6).setMaxWidth(85);
            Grilla.getColumnModel().getColumn(7).setMinWidth(80);
            Grilla.getColumnModel().getColumn(7).setPreferredWidth(80);
            Grilla.getColumnModel().getColumn(7).setMaxWidth(80);
            Grilla.getColumnModel().getColumn(8).setMinWidth(85);
            Grilla.getColumnModel().getColumn(8).setPreferredWidth(85);
            Grilla.getColumnModel().getColumn(8).setMaxWidth(85);
            Grilla.getColumnModel().getColumn(9).setMinWidth(0);
            Grilla.getColumnModel().getColumn(9).setPreferredWidth(0);
            Grilla.getColumnModel().getColumn(9).setMaxWidth(0);
            Grilla.getColumnModel().getColumn(10).setMinWidth(85);
            Grilla.getColumnModel().getColumn(10).setPreferredWidth(85);
            Grilla.getColumnModel().getColumn(10).setMaxWidth(85);
            Grilla.getColumnModel().getColumn(11).setMinWidth(0);
            Grilla.getColumnModel().getColumn(11).setPreferredWidth(0);
            Grilla.getColumnModel().getColumn(11).setMaxWidth(0);
            Grilla.getColumnModel().getColumn(12).setMinWidth(70);
            Grilla.getColumnModel().getColumn(12).setPreferredWidth(70);
            Grilla.getColumnModel().getColumn(12).setMaxWidth(70);
            Grilla.getColumnModel().getColumn(13).setMinWidth(0);
            Grilla.getColumnModel().getColumn(13).setPreferredWidth(0);
            Grilla.getColumnModel().getColumn(13).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Documentos Ingresados");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Documentos No Ingresados");

        jPanel5.setBackground(new java.awt.Color(255, 255, 0));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(0, 204, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setPreferredSize(new java.awt.Dimension(24, 16));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("0");
        jLabel1.setToolTipText("");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("0");
        jLabel2.setToolTipText("");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/search16.png"))); // NOI18N
        jLabel14.setText("FILTRO:");

        txFiltro.setEnabled(false);
        txFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txFiltroKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txFiltroKeyTyped(evt);
            }
        });

        btIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Order24.png"))); // NOI18N
        btIngresar.setText("Ingresar Documentos");
        btIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIngresarActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbIngresados);
        rbIngresados.setEnabled(false);
        rbIngresados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbIngresadosActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbNoIngresados);
        rbNoIngresados.setEnabled(false);
        rbNoIngresados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNoIngresadosActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbTodos);
        rbTodos.setSelected(true);
        rbTodos.setEnabled(false);
        rbTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTodosActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Todos los Documentos");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("0");
        jLabel6.setToolTipText("");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btCargar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(txFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(btIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbIngresados)
                                    .addComponent(rbNoIngresados))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbTodos)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(txFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbIngresados)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1)
                                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(14, 14, 14)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(rbNoIngresados)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(rbTodos))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCargarActionPerformed
        
        try {
            
            ExeSql Sql  = new ExeSql();
            ResultSet Rs;
            String total = "";
            String documento = "";
           
            String estado = "N";
            int ingresadas = 0;
            int noingresadas = 0;
            double diferencia = 0;
           
            txFiltro.setEnabled(true);
           
            while(TModelo.getRowCount()>0){
               
               TModelo.removeRow(0);
            }
           
          
                    
//          String Query = "SELECT * FROM doc_mail ORDER BY correlativo DESC";
           
           
            String Query = "SELECT DISTINCT p.nombre AS proveedor, \n"+
                           "case when p.dv is NULL then 'N' else p.dv end as dv,"+
                           "dm.*, \n" +
                           "case when cp.tipdocto is NULL then 'NA' else cp.tipdocto end AS tipo2,"+
                           "cp.rut AS rutemp,cp.nrodocto AS documento, " +
                           "cp.totaldocto AS Total,"+
                           "cp.autoriza \n"+
                           "FROM doc_mail dm \n"+
                           "LEFT JOIN ctacteprv cp ON dm.rut = cp.rut AND dm.nrodocto = cp.nrodocto \n"+
                           "LEFT JOIN proveedor p ON dm.rut = p.rut \n"+
                           "WHERE dm.tipdocto <> '0' \n"+
                           "AND dm.tipdocto IN ('FAP','NCP') \n"+
                           "ORDER BY dm.correlativo DESC";
           
           
            Rs = Sql.Select(Query);
           
            while(Rs.next()){
            
               
                if (Rs.getString("tipo2").equals("FAG") || Rs.getString("tipo2").equals("FAP") || Rs.getString("tipo2").equals("NCP") || Rs.getString("tipo2").equals("NA") ) {     
               
               
                    if (Rs.getString("Total") == null){
                   
                        total = "0"; 
                        //diferencia = 0;
                   
                        diferencia = Rs.getDouble("totaldocto") * -1;
                   
                
                    }else {
                
                            total = Rs.getString("Total");
                         //  diferencia = Rs.getDouble("totaldocto") - Rs.getDouble("Total");
                                            //ctacteprv           // doc_mail     
                            diferencia =  Rs.getDouble("Total") - Rs.getDouble("totaldocto");
                
                    }
                
                
                    if (Rs.getString("documento") == null){
                
                        documento = ""; 
                        estado = "N";
                        noingresadas++;
                
                    }else {
                 
                        documento = Rs.getString("documento");
                  
                        if (Rs.getInt("autoriza") == 0){
                  
                            estado = "N";
                            noingresadas++;
                  
                        }else if (Rs.getString("autoriza").equals("1") || Rs.getString("autoriza").equals("2")  || Rs.getString("autoriza").equals("3")) {
                  
                            estado = "S";
                            ingresadas++;
                        }
                
                    }
            
                    String div = "N";
                
                    if (Rs.getString("dv").trim().equals("N")){
                
                        div = String.valueOf(calculaRut(Rs.getString("rut").trim() + "-N"));
                
                
                    }else {
                
                
                        div = Rs.getString("dv");
                
                    }  
                
                
                    TModelo.addRow(new Object[]{
                                            //Rs.getString("rut")+"-"+Rs.getString("dv"), 
                                            Rs.getString("rut")+"-"+div,     
                                            Rs.getString("proveedor"), 
                                            Rs.getString("tipdocto"),  
                                            Rs.getString("nrodocto"),     
                                            Rs.getString("femision"),
                                            Rs.getString("totalexento"),
                                            Rs.getString("totalafecto"),
                                            Rs.getString("totaliva"),
                                            Rs.getString("totaldocto"),
                                            Rs.getString("correlativo"),
                                            total,
                                            documento,
                                            diferencia,
                                            estado
                                   
             
                    }); 
            
                }
                
            }
           
            TableRowSorter<TableModel>sorter = new TableRowSorter<TableModel>(Grilla.getModel());
            Grilla.setRowSorter(sorter);
            sorter.setRowFilter(null);
           
            Grilla.setDefaultRenderer(Object.class, new TableCellRendererFacturas());
            Grilla.repaint();
           
            jLabel1.setText(""+ingresadas);
            jLabel2.setText(""+noingresadas);
            jLabel6.setText(""+(ingresadas+noingresadas));
           
            rbIngresados.setEnabled(true);
            rbNoIngresados.setEnabled(true);
            rbTodos.setEnabled(true);
          
        } catch (SQLException ex) {
           Logger.getLogger(pfFacturasACEPTA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btCargarActionPerformed

    private void txFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txFiltroKeyReleased
       
//        TableRowSorter<TableModel>sorter = new TableRowSorter<>(Grilla.getModel());
//        Grilla.setRowSorter(sorter);
//        String filtro = txFiltro.getText().trim();
//       
//        if (filtro.length()==0)
//        {
//            sorter.setRowFilter(null);
//        }else{
////            int cant=0;
////            int ev=0;
////            String precio = "";
//            sorter.setRowFilter(RowFilter.regexFilter(filtro));
//        }
//        
        
        
        
        DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(TableModel); 
        ArrayList<RowFilter<TableModel,Object>> lista = new ArrayList<RowFilter<TableModel,Object>>();  
        
        
        String Texto = txFiltro.getText().trim();
               
        
        if (Texto.length()==0){
            
            lista.add(RowFilter.regexFilter(""));
            
        }else {
        
            lista.add(RowFilter.regexFilter("(?i)"+Texto));
        
        
        }
        
        
        
        //******************************************************************************************************//
        
        
        String filtrar ="";
        
        if (rbIngresados.isSelected()){
         
            filtrar ="S";
         
         
        }else if (rbNoIngresados.isSelected()) {
        
            filtrar ="N";
        
        
        }else if (rbTodos.isSelected()){
                
            filtrar ="";    
                
        }
        
        
                
        lista.add(RowFilter.regexFilter(filtrar,13));
       
        
        
                                                        
        RowFilter filtroAnd = RowFilter.andFilter(lista); // and de ambos filtros
        sorter.setRowFilter(filtroAnd);
        
      //**********************************************************************************************************//
     
                                                        
        Grilla.setRowSorter(sorter);
        
        
        
        
    }//GEN-LAST:event_txFiltroKeyReleased

    private void txFiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txFiltroKeyTyped
        
        if (Character.isLowerCase(evt.getKeyChar()))
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        
    }//GEN-LAST:event_txFiltroKeyTyped

    private void btIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIngresarActionPerformed
        
        
        
        NivelUsuario = 90;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        
        if (NivelUsuario > intNivelUsuario ){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------
        
        
        
        
        
        
        jdIngresaFacACEPTA IngFac = new jdIngresaFacACEPTA(null, true);
        IngFac.setLocationRelativeTo(null);
        IngFac.setVisible(true);
        IngFac.setAlwaysOnTop(true);  
        
        if (IngFac.GetIngresa()){
            
            btCargar.doClick();
        
        }
    }//GEN-LAST:event_btIngresarActionPerformed

    private void rbIngresadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbIngresadosActionPerformed
        
//        if (rbIngresados.isSelected()){                 
//                        
//            TableRowSorter<TableModel>sorter = new TableRowSorter<TableModel>(Grilla.getModel());
//            Grilla.setRowSorter(sorter);
//            sorter.setRowFilter(RowFilter.regexFilter("S",13));
//                    
//        }
        
        
        
        
        DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(TableModel); 
        ArrayList<RowFilter<TableModel,Object>> lista = new ArrayList<RowFilter<TableModel,Object>>();  
        
        
        String filtrar ="S";
        
        
        String Texto = txFiltro.getText().trim();
                
        
        //******************************************************************************************************//
        
                
        lista.add(RowFilter.regexFilter(filtrar,13));
       
        
        if (!Texto.trim().isEmpty()){
        
            lista.add(RowFilter.regexFilter("(?i)"+Texto));
            
        }    
                                                        
        RowFilter filtroAnd = RowFilter.andFilter(lista); // and de ambos filtros
        sorter.setRowFilter(filtroAnd);
      //**********************************************************************************************************//
     
                                                        
        Grilla.setRowSorter(sorter);
        
        
        
        
    }//GEN-LAST:event_rbIngresadosActionPerformed

    private void rbNoIngresadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNoIngresadosActionPerformed
        
//        if (rbNoIngresados.isSelected()){                 
//                        
//            TableRowSorter<TableModel>sorter = new TableRowSorter<TableModel>(Grilla.getModel());
//            Grilla.setRowSorter(sorter);
//             sorter.setRowFilter(RowFilter.regexFilter("N",13));
//         
//        }
        
        
        
        
        
        DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(TableModel); 
        ArrayList<RowFilter<TableModel,Object>> lista = new ArrayList<RowFilter<TableModel,Object>>();  
        
        
        String filtrar ="N";
        
        
        String Texto = txFiltro.getText().trim();
                
        
        //******************************************************************************************************//
        
                
        lista.add(RowFilter.regexFilter(filtrar,13));
       
        
        if (!Texto.trim().isEmpty()){
        
            lista.add(RowFilter.regexFilter("(?i)"+Texto));
            
        }    
                                                        
        RowFilter filtroAnd = RowFilter.andFilter(lista); // and de ambos filtros
        sorter.setRowFilter(filtroAnd);
      //**********************************************************************************************************//
     
                                                        
        Grilla.setRowSorter(sorter);
        
        
        
        
        
        
    }//GEN-LAST:event_rbNoIngresadosActionPerformed

    private void rbTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTodosActionPerformed
        
        
//        if (rbTodos.isSelected()){                 
//                        
//           btCargar.doClick();
//         
//        }
        
        
        
         DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(TableModel); 
        ArrayList<RowFilter<TableModel,Object>> lista = new ArrayList<RowFilter<TableModel,Object>>();  
        
               
        
        String Texto = txFiltro.getText().trim();
                
        
        //******************************************************************************************************//
        
                
        lista.add(RowFilter.regexFilter(""));
       
        
        if (!Texto.trim().isEmpty()){
        
            lista.add(RowFilter.regexFilter("(?i)"+Texto));
            
        }    
                                                        
        RowFilter filtroAnd = RowFilter.andFilter(lista); // and de ambos filtros
        sorter.setRowFilter(filtroAnd);
      //**********************************************************************************************************//
     
                                                        
        Grilla.setRowSorter(sorter);
        
        
        
        
        
        
    }//GEN-LAST:event_rbTodosActionPerformed

   
    public static char calculaRut(String rut) {
    
        
        boolean validacion = false;
        char dvx = 'N';
        try{
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            dvx = rut.charAt(rut.length() - 1);
            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            
            dvx = (char) (s != 0 ? s + 47 : 75);
            
            if (dvx == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }
            
        }catch (java.lang.NumberFormatException e) {
        }catch (Exception e) {
        }
        return dvx;
    }
    
   
    
    
    
    
    public class TableCellRendererFacturas extends DefaultTableCellRenderer {
    
    private Component c;
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                
        c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //Para cambiar la fila 
        
        
        
        String documento = table.getValueAt(row, 11).toString();
        String estado = table.getValueAt(row, 13).toString();
        
        if(!documento.equals("")){
        
            if (estado.equals("S")){
            
                c.setBackground(Color.green);
                c.setForeground(Color.black);
                
            }else if (estado.equals("N")){
            
              c.setBackground(Color.yellow);
              c.setForeground(Color.black);
            
            }
        
        }else if(documento.equals("")){
            
            c.setBackground(Color.yellow);
            c.setForeground(Color.black);
        }
        
        return c;
        
    }

}
   
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Grilla;
    private javax.swing.JButton btCargar;
    private javax.swing.JButton btIngresar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbIngresados;
    private javax.swing.JRadioButton rbNoIngresados;
    private javax.swing.JRadioButton rbTodos;
    private javax.swing.JTextField txFiltro;
    // End of variables declaration//GEN-END:variables
}
