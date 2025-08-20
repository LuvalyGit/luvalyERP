/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelForm;

import Conexion.ExeSql;
import Conexion.ExeSql1_Mysql;
import Dialogos.jdAjustarCant;
import Formularios.fmMain;
import static Formularios.fmMain.pnPestanas;
import Utilidades.Exporter;
import Utilidades.PanelTab;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;  
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
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
public class pfReportePrecio extends javax.swing.JPanel {
    
    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    DefaultTableCellRenderer centerRenderer2 = new DefaultTableCellRenderer();
    
    
    Date hoy = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private static int HEADER_HEIGHT = 40;
    
    public static Color DARK_GREEN = new Color(0,153,0);
    int CargaInforme = 0;
    
    int cant = 0;
    double dcant = 0;
    
    
    public pfReportePrecio() {
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
        
        
        jPanel10.setVisible(false);
        lbCarga.setVisible(false);
        CargaReportes();
      
      
    }

    
    public void CargaDocumentos() {
        DefaultTableModel model = (DefaultTableModel) Grilla.getModel();
        
        
        while(model.getRowCount()>0){
            model.removeRow(0);
        }
       
        ExeSql Sql = new ExeSql();
       
        ResultSet Rs = null;
        
        
        double compra = 0;
        double margen = 0;
        String Web = "";
        
        try {
            
            Rs = Sql.Select("SELECT p.sku,p.nombre, p.pventa_web, p.pventa_web2, \n"+
                            "case when p.valultcompra is null then 0 else p.valultcompra end as ucompra, cw.publicado, p.compra, p.compra2 \n"+
                            "FROM producto p \n"+
                            "LEFT JOIN inventario i ON p.sku = i.sku \n"+
                            "LEFT JOIN codweb cw ON p.sku = cw.sku \n"+
                            "WHERE i.stock > 0 AND p.pventa_web <> p.pventa_web2 AND p.compra = 1  \n"+
                            "ORDER BY p.nombre ");
              
                if (Sql.GetRowCount() > 0){
              
                    while (Rs.next()) {
             
                        double venta_web = (Rs.getDouble("pventa_web2")/1.19);  
                        
                        if (venta_web > 0){
                        
                            compra = Rs.getDouble("ucompra");
                            margen = (venta_web-compra)*100/venta_web;     
                            
                        }else {
                            
                            margen = 0;
                        }
                        
                        if (Rs.getBoolean("publicado")){
                        
                            Web = "     X";
                            
                        }else {
                        
                                Web = "";
                        
                        }
                        
                        
                        model.addRow(new Object[]{
                                                 Rs.getString("sku"),  
                                                 Rs.getString("nombre"), 
                                                 Rs.getString("pventa_web2"), 
                                                 Rs.getString("pventa_web"), 
                                                 String.valueOf(Math.round(venta_web)),
                                                 fmMain.FormatoTotal(margen) + "%",false,Web,Rs.getString("compra"),Rs.getString("compra2")
                                                 
                                                  
                        });
                            
                                                    
                    }   
                            
              
                }
               
            
             lbTotalOrd.setText(""+model.getRowCount());
             Grilla.setDefaultRenderer(Object.class, new Elrender()); 
           
          
           //TableCellRendererColor_2
            
        } catch (SQLException ex) {
            Logger.getLogger(pfReportePrecio.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        btGenerar = new javax.swing.JButton();
        CargaButton = new javax.swing.JButton();
        lbCarga = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        GrillaImp = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Grilla = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        lbTotalOrd = new javax.swing.JLabel();
        btImprimir = new javax.swing.JButton();
        cbReporte = new javax.swing.JComboBox();
        Panel_Paso = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Grilla_Paso = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Reporte Precios"));
        jPanel1.setToolTipText("");

        btGenerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Order24.png"))); // NOI18N
        btGenerar.setText("Generar Reporte");
        btGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGenerarActionPerformed(evt);
            }
        });

        CargaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/Actualiza.png"))); // NOI18N
        CargaButton.setText("Cargar");
        CargaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargaButtonActionPerformed(evt);
            }
        });

        lbCarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Carga.gif"))); // NOI18N
        lbCarga.setText("    Actualizando Precio...");
        lbCarga.setToolTipText("");

        GrillaImp.setAutoCreateRowSorter(true);
        GrillaImp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Descripción", "P.Web2", "P. Web"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        GrillaImp.getTableHeader().setReorderingAllowed(false);
        GrillaImp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                GrillaImpMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(GrillaImp);
        if (GrillaImp.getColumnModel().getColumnCount() > 0) {
            GrillaImp.getColumnModel().getColumn(0).setMinWidth(70);
            GrillaImp.getColumnModel().getColumn(0).setPreferredWidth(70);
            GrillaImp.getColumnModel().getColumn(0).setMaxWidth(70);
        }

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CargaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btGenerar)
                .addGap(112, 112, 112)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addComponent(lbCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CargaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btGenerar, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)))
                    .addComponent(lbCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Productos"));

        Grilla.setAutoCreateRowSorter(true);
        Grilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Descripción", "<html>Precio Web </br>&nbsp;&nbsp;&nbsp;&nbsp;Actual</html>", "<html>&nbsp;&nbsp;&nbsp;Nuevo</br>&nbsp;&nbsp; Precio Web</html>", "<html>Precio Web </br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Neto)</html>", "% Margen", "Actualiza", "Web", "compra", "compra2"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Grilla.setDragEnabled(true);
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
            Grilla.getColumnModel().getColumn(0).setMinWidth(75);
            Grilla.getColumnModel().getColumn(0).setPreferredWidth(75);
            Grilla.getColumnModel().getColumn(0).setMaxWidth(75);
            Grilla.getColumnModel().getColumn(1).setPreferredWidth(350);
            Grilla.getColumnModel().getColumn(2).setMinWidth(70);
            Grilla.getColumnModel().getColumn(2).setPreferredWidth(70);
            Grilla.getColumnModel().getColumn(2).setMaxWidth(70);
            Grilla.getColumnModel().getColumn(3).setMinWidth(70);
            Grilla.getColumnModel().getColumn(3).setPreferredWidth(70);
            Grilla.getColumnModel().getColumn(3).setMaxWidth(70);
            Grilla.getColumnModel().getColumn(4).setMinWidth(70);
            Grilla.getColumnModel().getColumn(4).setPreferredWidth(70);
            Grilla.getColumnModel().getColumn(4).setMaxWidth(70);
            Grilla.getColumnModel().getColumn(5).setMinWidth(65);
            Grilla.getColumnModel().getColumn(5).setPreferredWidth(65);
            Grilla.getColumnModel().getColumn(5).setMaxWidth(65);
            Grilla.getColumnModel().getColumn(6).setMinWidth(55);
            Grilla.getColumnModel().getColumn(6).setPreferredWidth(55);
            Grilla.getColumnModel().getColumn(6).setMaxWidth(55);
            Grilla.getColumnModel().getColumn(7).setMinWidth(35);
            Grilla.getColumnModel().getColumn(7).setPreferredWidth(35);
            Grilla.getColumnModel().getColumn(7).setMaxWidth(35);
            Grilla.getColumnModel().getColumn(8).setMinWidth(0);
            Grilla.getColumnModel().getColumn(8).setPreferredWidth(0);
            Grilla.getColumnModel().getColumn(8).setMaxWidth(0);
            Grilla.getColumnModel().getColumn(9).setMinWidth(0);
            Grilla.getColumnModel().getColumn(9).setPreferredWidth(0);
            Grilla.getColumnModel().getColumn(9).setMaxWidth(0);
        }

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Registros:");

        lbTotalOrd.setText("0");

        btImprimir.setText("Imprimir");
        btImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirActionPerformed(evt);
            }
        });

        cbReporte.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbReporteActionPerformed(evt);
            }
        });

        Grilla_Paso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Sku", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Grilla_Paso);

        javax.swing.GroupLayout Panel_PasoLayout = new javax.swing.GroupLayout(Panel_Paso);
        Panel_Paso.setLayout(Panel_PasoLayout);
        Panel_PasoLayout.setHorizontalGroup(
            Panel_PasoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_PasoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        Panel_PasoLayout.setVerticalGroup(
            Panel_PasoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_PasoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(lbTotalOrd, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Panel_Paso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTotalOrd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(cbReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Panel_Paso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void CargaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargaButtonActionPerformed
       
        CargaDocumentos();
   
    }//GEN-LAST:event_CargaButtonActionPerformed

    private void GrillaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrillaMousePressed
        //CargaDetalleOrdenes();        // TODO add your handling code here:
    }//GEN-LAST:event_GrillaMousePressed

    private void btGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGenerarActionPerformed
      
        if(fmMain.OkCancel("¿Desea Generar Reporte?")== JOptionPane.OK_OPTION){
        
            Runnable miRunnable = new Runnable() {
            
                public void run() {
                    
                  try{
                
                    lbCarga.setVisible(true);
                    
                    Generar();
                    
                    lbCarga.setVisible(false);
                        
                    } catch (Exception e) {
                        
                        e.printStackTrace();
                        
                        lbCarga.setVisible(false);
                    }
                    
                } 
            };
            
            Thread hilo = new Thread(miRunnable);
            hilo.start();
            lbCarga.setVisible(false);

       }     
    }//GEN-LAST:event_btGenerarActionPerformed

    private void Generar(){
    
           
        ExeSql Sql = new ExeSql();
        ExeSql Sql3 = new ExeSql();
        ExeSql Sql4 = new ExeSql();
        ExeSql Sql5 = new ExeSql();
                
        ResultSet Rs = null;
        ResultSet Rs4 = null;    
           
        DefaultTableModel model = (DefaultTableModel) Grilla_Paso.getModel();
        
        while(model.getRowCount()>0){
            model.removeRow(0);
        }
       
        try {

           
                
                Rs4 = Sql4.Select("select sp_getcorrelativo \n" +
                                  "from sp_getcorrelativo('RPW')");
                Rs4.next();
                
                String Numero  = Rs4.getString("sp_getcorrelativo");
                Rs4.close();
               
                int compra2 = 0;
                
                for (int i = 0; i < Grilla.getRowCount(); i++) {
                    
                    String sku = Grilla.getValueAt(i,0).toString().trim();
                    int pventa_web2 = Integer.valueOf(Grilla.getValueAt(i,2).toString());
                    int pventa_web = Integer.valueOf(Grilla.getValueAt(i,3).toString());
                    String margen = Grilla.getValueAt(i,5).toString().trim();
                    boolean Actualiza = (boolean) Grilla.getValueAt(i,6);
                    String Web = Grilla.getValueAt(i,7).toString().trim();
                    
                    
                    if (Actualiza){ 
                    
                        Sql3.ExeSql("INSERT INTO reporte_precios_web (\n" +
                                    "sku, pventa_web2,pventa_web, margen, numero)\n" +
                                    "VALUES ('" +
                                    sku + "'," +
                                    pventa_web2 + "," +
                                    pventa_web + ",'" +
                                    margen + "'," +
                                    Numero + ")");
                    
                        
                        if (fmMain.GetUsuario().equals("LEORUBILAR")){
                        
                            compra2 = 3;
                        
                        }else {
                        
                            compra2 = 0;
                        
                        }
                        
                        
                        
                    
                        Sql5.ExeSql("UPDATE producto SET\n" +
                                    "pventa_web2 = " + pventa_web + ", \n" + 
                                    "compra = 0, \n" +
                                    "compra2 = "+compra2+" \n" +
                                    "WHERE sku='" + sku + "'" );
                        
                        
                        if (!Web.isEmpty() || !Web.equals("")){
              
                            lbCarga.setText("Subiendo Precio a la Web...");
                            ActualizaWeb(sku,pventa_web);
                            
                        }
                        
                    
                    }

                }
                
                Sql3.Commit();
                Sql5.Commit();
                
                
                CargaReportes();
             
            

        } catch (SQLException ex) {
            Sql3.Rollback();
            Sql5.Rollback();
            Logger.getLogger(pfReportePrecio.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
        
            Sql3.Close();
            Sql5.Close();
        }
        
    
    }
    
    
    
    private void btImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirActionPerformed

        
        
        DefaultTableModel model = (DefaultTableModel) GrillaImp.getModel();
        
        
        while(model.getRowCount()>0){
            model.removeRow(0);
        }
      
        ExeSql Sql2 = new ExeSql();
        ResultSet Rs2 = null;
        
        
    //****************************************************************************************************************************************************//         
        
             
        ExeSql Sql = new ExeSql();
        ResultSet Rs = null;
       
        String Nombre = "";
        
        
       

        try {
                
            
               
            Rs2 = Sql2.Select("SELECT pw.*, p.nombre FROM reporte_precios_web pw \n"+
                              "LEFT JOIN producto p ON pw.sku = p.sku \n"+
                              "WHERE pw.numero = "+cbReporte.getSelectedItem().toString().trim()+" \n"+
                              "ORDER BY p.nombre");
              
            if (Sql2.GetRowCount() > 0){
              
                while (Rs2.next()) {
                          
                    model.addRow(new Object[]{
                                             Rs2.getString("sku"),  
                                             Rs2.getString("nombre"), 
                                             Rs2.getString("pventa_web2") ,
                                             Rs2.getString("pventa_web") ,
                                             Rs2.getString("margen")
                                                  
                    });
                            
              
                }
            }
        
            
       //****************************************************************************************************************************************************//     
            
                Rs = Sql.Select("SELECT p.nombre, p.apellidopaterno, p.apellidomaterno from personal p\n" +
                                "WHERE p.usuario =  '"+fmMain.GetUsuario()+"'");
            
                if (Sql.GetRowCount() > 0){
            
                    Rs.next();
                
                    Nombre = Rs.getString("nombre") + " " + Rs.getString("apellidopaterno") + " " + Rs.getString("apellidomaterno");
            
                }
                

                Map parametro = new HashMap();

                parametro.put("FECHA",dateFormat.format(hoy));
                parametro.put("FOLIO",cbReporte.getSelectedItem().toString().trim());
                parametro.put("NOMREPO",Nombre );

                JasperReport jasperReport = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/rpReportePrecio.jasper"));
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, new JRTableModelDataSource(GrillaImp.getModel()));
                JasperViewer view = new JasperViewer(jasperPrint,false);
                view.setVisible(true);
           

        }catch (JRException e) {
            
            e.printStackTrace ();
            System.out.println ("informes r" + e.toString ());
            Logger.getLogger(pfReportePrecio.class.getName()).log(Level.SEVERE, null, e);

        } catch (SQLException ex) {
            
            Logger.getLogger(pfReportePrecio.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
        
            Sql.Close();
            
        }
    
        
    }//GEN-LAST:event_btImprimirActionPerformed

    private void GrillaImpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrillaImpMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_GrillaImpMousePressed

    private void GrillaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrillaMouseClicked
        
        if (evt.getClickCount() == 2) {
            
            int columna = Grilla.getSelectedColumn(); // luego, obtengo la columna seleccionada
           
            
            if (columna == 2 || columna == 3){
            
                
                if (Grilla.getValueAt(Grilla.getSelectedRow(),9).toString().trim().equals("3")){
                
                
                    if (!fmMain.GetUsuario().equals("LRUBILAR") && !fmMain.GetUsuario().equals("LEORUBILAR")){
                
                        fmMain.Mensaje("No está autorizado!!");
                        return;
                
                
                    }
                                
                }
                jdAjustarCant Ajustar =  new jdAjustarCant(null,true);
                Ajustar.setLocationRelativeTo(null);
                      
                dcant = Double.parseDouble(Grilla.getValueAt(Grilla.getSelectedRow(),columna).toString().trim());
            
                cant = (int) dcant;
            
                Ajustar.SetValor(cant);
            
                Ajustar.setVisible(true);
            
                if (Ajustar.GetRetorno()){
            
                    Grilla.setValueAt(Ajustar.GetCant(),Grilla.getSelectedRow(),columna);
                
                }
                
                
            
            }else{
            
            
                pfProductos Pro = new pfProductos();
                Pro.setOpaque(false);
                pnPestanas.addTab("Producto", Pro);
                PanelTab btc = new PanelTab(pnPestanas, 0);
                pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Pro), btc);
                pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
                Pro.txSku.requestFocus();
                Pro.CargaProducto(Grilla.getValueAt(Grilla.getSelectedRow(), 0).toString());
            }
            
        }
        
    }//GEN-LAST:event_GrillaMouseClicked

    private void cbReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbReporteActionPerformed
        
        
    }//GEN-LAST:event_cbReporteActionPerformed

    
    private void CargaReportes(){
        
        ExeSql Sql= new ExeSql();
        ResultSet Rs;
         
        cbReporte.removeAllItems();
        DefaultComboBoxModel dfCm = new DefaultComboBoxModel();
        cbReporte.setModel(dfCm);
        
        try{
            
            Rs = Sql.Select("SELECT numero \n" +
                            "FROM reporte_precios_web \n" +
                            "WHERE numero > 0 \n" +
                            "GROUP BY numero ORDER BY numero DESC");
               
            if (Sql.GetRowCount() > 0){
            
                while( Rs.next()){
               
                    cbReporte.addItem(Rs.getString("numero"));
                   
                }
            
            }
            
        }catch (Exception e){
                
            System.out.println(e.getMessage());
            fmMain.Mensaje("Error: "  + e);
        
        }finally{
        
            Sql.Close();
        }
        
    }
    
    
    
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
    
    
    
    
    
    class Elrender extends DefaultTableCellRenderer {
         
        @Override
        public Component getTableCellRendererComponent(JTable tabla, Object valor, boolean isSelected, boolean hasFocus, int fila, int columna) {
        
            super.getTableCellRendererComponent(tabla,valor,isSelected, hasFocus, fila, columna);
            
            
            if( tabla.getValueAt(fila,9).toString().trim().equals("3"))
            {
//                if(isSelected==true){
                    
                    this.setBackground(DARK_GREEN);
                    this.setForeground(Color.white);   
                    this.setFont(new Font("Tahoma", Font.BOLD, 11));
                   
                
//                }else{
//                
//                    this.setForeground(DARK_GREEN);
//                    this.setBackground(Color.white);
//                    this.setFont(new Font("Tahoma", Font.BOLD, 11));
//                
//                }
            
            }else {
                if(isSelected==true){
                
                    this.setForeground(Color.white);  
                    this.setBackground(Color.BLUE);
                    
                
                }else{
                
                    this.setForeground(Color.black);  
                    this.setBackground(Color.white);
                }
            } 
            return this;
        }
    }    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton CargaButton;
    private javax.swing.JTable Grilla;
    private javax.swing.JTable GrillaImp;
    private javax.swing.JTable Grilla_Paso;
    private javax.swing.JPanel Panel_Paso;
    private javax.swing.JButton btGenerar;
    private javax.swing.JButton btImprimir;
    private javax.swing.JComboBox cbReporte;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbCarga;
    private javax.swing.JLabel lbTotalOrd;
    // End of variables declaration//GEN-END:variables
}
