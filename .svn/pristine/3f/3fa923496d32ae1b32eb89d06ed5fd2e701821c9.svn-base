/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelForm;

import Conexion.ExeSql;

import Formularios.fmMain;
import static Formularios.fmMain.intNivelUsuario;
import Utilidades.ComboCodigos;
import Utilidades.Combo_CodStr;
import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
/**
 *
 * @author informática
 */
public class pfIndicadoresVencimiento extends javax.swing.JPanel {
    public static Color DARK_GREEN = new Color(0,153,0);
    DecimalFormat formateador = new DecimalFormat("###,###");
    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
   
    public pfIndicadoresVencimiento() {
        initComponents();
       
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        Grilla_mt1.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        jPanelHasta.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
              
       
        jScrollPane4.setVisible(false);
        jScrollPane5.setVisible(false);
        btAjustar.setVisible(false);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanelHasta = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Grilla_mt1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        Grilla_mt2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        Grilla_mt3 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        Grilla_mt4 = new javax.swing.JTable();
        btAjustar = new javax.swing.JButton();
        btCargar = new javax.swing.JButton();

        jPanelHasta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Grilla_mt1.setAutoCreateRowSorter(true);
        Grilla_mt1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SKU", "Nombre", "Fecha", "Cantidad", "Idvenc"
            }
        ));
        Grilla_mt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Grilla_mt1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Grilla_mt1);
        if (Grilla_mt1.getColumnModel().getColumnCount() > 0) {
            Grilla_mt1.getColumnModel().getColumn(0).setMinWidth(100);
            Grilla_mt1.getColumnModel().getColumn(0).setPreferredWidth(100);
            Grilla_mt1.getColumnModel().getColumn(0).setMaxWidth(100);
            Grilla_mt1.getColumnModel().getColumn(1).setPreferredWidth(400);
            Grilla_mt1.getColumnModel().getColumn(2).setPreferredWidth(100);
            Grilla_mt1.getColumnModel().getColumn(3).setMinWidth(60);
            Grilla_mt1.getColumnModel().getColumn(3).setPreferredWidth(60);
            Grilla_mt1.getColumnModel().getColumn(3).setMaxWidth(60);
        }

        Grilla_mt2.setAutoCreateRowSorter(true);
        Grilla_mt2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SKU", "Nombre", "Fecha", "Cantidad", "Diferencia", "estado", "Cant2", "Idvenc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Grilla_mt2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Grilla_mt2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Grilla_mt2);
        if (Grilla_mt2.getColumnModel().getColumnCount() > 0) {
            Grilla_mt2.getColumnModel().getColumn(0).setResizable(false);
            Grilla_mt2.getColumnModel().getColumn(0).setPreferredWidth(100);
            Grilla_mt2.getColumnModel().getColumn(1).setPreferredWidth(400);
            Grilla_mt2.getColumnModel().getColumn(2).setPreferredWidth(100);
            Grilla_mt2.getColumnModel().getColumn(3).setPreferredWidth(100);
            Grilla_mt2.getColumnModel().getColumn(5).setMinWidth(0);
            Grilla_mt2.getColumnModel().getColumn(5).setPreferredWidth(0);
            Grilla_mt2.getColumnModel().getColumn(5).setMaxWidth(0);
            Grilla_mt2.getColumnModel().getColumn(6).setMinWidth(0);
            Grilla_mt2.getColumnModel().getColumn(6).setPreferredWidth(0);
            Grilla_mt2.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        Grilla_mt3.setAutoCreateRowSorter(true);
        Grilla_mt3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SKU", "Nombre", "Fecha", "Cantidad", "Diferencia", "estado", "Cant2", "idVenc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Grilla_mt3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Grilla_mt3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(Grilla_mt3);
        if (Grilla_mt3.getColumnModel().getColumnCount() > 0) {
            Grilla_mt3.getColumnModel().getColumn(0).setMinWidth(100);
            Grilla_mt3.getColumnModel().getColumn(0).setPreferredWidth(100);
            Grilla_mt3.getColumnModel().getColumn(0).setMaxWidth(100);
            Grilla_mt3.getColumnModel().getColumn(1).setPreferredWidth(400);
            Grilla_mt3.getColumnModel().getColumn(2).setPreferredWidth(100);
            Grilla_mt3.getColumnModel().getColumn(3).setMinWidth(100);
            Grilla_mt3.getColumnModel().getColumn(3).setPreferredWidth(100);
            Grilla_mt3.getColumnModel().getColumn(3).setMaxWidth(100);
            Grilla_mt3.getColumnModel().getColumn(4).setMinWidth(100);
            Grilla_mt3.getColumnModel().getColumn(4).setPreferredWidth(100);
            Grilla_mt3.getColumnModel().getColumn(4).setMaxWidth(100);
            Grilla_mt3.getColumnModel().getColumn(5).setMinWidth(50);
            Grilla_mt3.getColumnModel().getColumn(5).setPreferredWidth(50);
            Grilla_mt3.getColumnModel().getColumn(5).setMaxWidth(50);
            Grilla_mt3.getColumnModel().getColumn(6).setMinWidth(0);
            Grilla_mt3.getColumnModel().getColumn(6).setPreferredWidth(0);
            Grilla_mt3.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        jLabel1.setText(" 0");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText(" 0");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Grilla_mt4.setAutoCreateRowSorter(true);
        Grilla_mt4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SKU", "Nombre", "Fecha", "Cantidad", "Diferencia", "estado", "Cant2", "idVenc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Grilla_mt4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Grilla_mt4MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(Grilla_mt4);
        if (Grilla_mt4.getColumnModel().getColumnCount() > 0) {
            Grilla_mt4.getColumnModel().getColumn(0).setMinWidth(100);
            Grilla_mt4.getColumnModel().getColumn(0).setPreferredWidth(100);
            Grilla_mt4.getColumnModel().getColumn(0).setMaxWidth(100);
            Grilla_mt4.getColumnModel().getColumn(1).setPreferredWidth(400);
            Grilla_mt4.getColumnModel().getColumn(2).setPreferredWidth(100);
            Grilla_mt4.getColumnModel().getColumn(3).setMinWidth(100);
            Grilla_mt4.getColumnModel().getColumn(3).setPreferredWidth(100);
            Grilla_mt4.getColumnModel().getColumn(3).setMaxWidth(100);
            Grilla_mt4.getColumnModel().getColumn(4).setMinWidth(100);
            Grilla_mt4.getColumnModel().getColumn(4).setPreferredWidth(100);
            Grilla_mt4.getColumnModel().getColumn(4).setMaxWidth(100);
            Grilla_mt4.getColumnModel().getColumn(5).setMinWidth(50);
            Grilla_mt4.getColumnModel().getColumn(5).setPreferredWidth(50);
            Grilla_mt4.getColumnModel().getColumn(5).setMaxWidth(50);
            Grilla_mt4.getColumnModel().getColumn(6).setMinWidth(0);
            Grilla_mt4.getColumnModel().getColumn(6).setPreferredWidth(0);
            Grilla_mt4.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        btAjustar.setText("Ajustar");
        btAjustar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAjustarActionPerformed(evt);
            }
        });

        btCargar.setText("Cargar");
        btCargar.setToolTipText("");
        btCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelHastaLayout = new javax.swing.GroupLayout(jPanelHasta);
        jPanelHasta.setLayout(jPanelHastaLayout);
        jPanelHastaLayout.setHorizontalGroup(
            jPanelHastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHastaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHastaLayout.createSequentialGroup()
                        .addGroup(jPanelHastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelHastaLayout.createSequentialGroup()
                                .addComponent(btCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btAjustar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelHastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelHastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane5)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelHastaLayout.setVerticalGroup(
            jPanelHastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHastaLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanelHastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btCargar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btAjustar, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanelHastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanelHastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 187, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
   
    
    
    private void Grilla_mt1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Grilla_mt1MouseClicked
        
    }//GEN-LAST:event_Grilla_mt1MouseClicked

    private void btCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCargarActionPerformed
        // TODO add your handling code here:
        ExeSql Sql = new ExeSql();
        ResultSet Rs, Rs2, Rs3, Rs4 = null;
        double diferencia = 0.00;
        double diferencia2 = 0.00;
        double diferencia3 = 0.00;
        double cant1, cant2 = 0.00; 
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        String Query, Query2, Query3, Query4 ;
              
        DefaultTableModel gmt1 = (DefaultTableModel) Grilla_mt1.getModel();
        DefaultTableModel gmt2 = (DefaultTableModel) Grilla_mt2.getModel();
        DefaultTableModel gmt3 = (DefaultTableModel) Grilla_mt3.getModel();
        DefaultTableModel gmt4 = (DefaultTableModel) Grilla_mt4.getModel();
        fmMain.LimpiaGrilla(gmt1);
        fmMain.LimpiaGrilla(gmt2);
        fmMain.LimpiaGrilla(gmt3);
        fmMain.LimpiaGrilla(gmt4);
        try{
         
           
            Query = "SELECT pv.sku, p.nombre, pv.cantidad_venc, pv.fecha_venc,pv.id_venc FROM producto_venc pv \n" +  //Productos que están en venc
                    "LEFT JOIN producto p on p.sku = pv.sku\n"+
                    "WHERE p.convenio = 4 ORDER BY pv.sku"; 
            

            Query2 = "SELECT pv2.sku SKU, p.nombre NOMBRE, pv2.cantidad_venc CANTIDAD, pv.cantidad_venc CANTIDAD2, pv2.fecha_venc FECHA,pv2.id_venc \n"+       //Productos que están en ambas tablas (negro)
                     "FROM producto_venc2 pv2 \n" +
                     "LEFT JOIN producto_venc pv ON pv.sku = pv2.sku AND pv.id_venc = pv2.id_venc \n" +
                     "LEFT JOIN producto p ON p.sku = pv.sku\n"+
                     "WHERE p.convenio = 4 ORDER BY pv2.sku"; 

            Query3 = "SELECT pv2.sku, p.nombre, pv2.cantidad_venc, pv2.fecha_venc,pv2.id_venc FROM producto_venc2 pv2 \n" +    //Productos que están en pv2 pero no en pv (verde)
                     "LEFT JOIN producto p ON p.sku = pv2.sku\n" +
                     "WHERE NOT EXISTS(SELECT * FROM  producto_venc pv WHERE pv2.sku = pv.sku AND pv2.id_venc = pv.id_venc) \n" +
                     "AND p.convenio = 4 ORDER BY pv2.sku" ;
            
            Query4 = "SELECT pv.sku, p.nombre, pv.cantidad_venc, pv.fecha_venc,pv.id_venc FROM producto_venc pv \n" +          //Productos que están en pv2 pero no en pv (rojo)
                     "LEFT JOIN producto p ON p.sku = pv.sku\n" +
                     "WHERE NOT EXISTS(SELECT * FROM  producto_venc2 pv2 WHERE pv.sku = pv2.sku AND pv.id_venc = pv2.id_venc) \n" +
                     "AND p.convenio = 4 ORDER BY pv.sku" ;
            
            
           
            Rs3 = Sql.Select(Query3);
            
            while(Rs3.next()){
            
                if (Rs3.getDouble("cantidad_venc") > 0){ 
                   
                   diferencia2 = Rs3.getDouble("cantidad_venc") - 0;
                   
                   gmt3.addRow(new Object[]{Rs3.getString("sku"),
                                            Rs3.getString("nombre"),
                                            Rs3.getString("fecha_venc"),
                                            Math.round(Rs3.getDouble("cantidad_venc")),
                                            Math.round(diferencia2),
                                            "1",
                                            0,
                                            Rs3.getString("id_venc")
                   });
                   
                   k++;
               }
            }
            
            Rs4 = Sql.Select(Query4);
            
            while(Rs4.next()){
               
                diferencia3 = 0 - Rs4.getDouble("cantidad_venc"); 
                  
                gmt4.addRow(new Object[]{Rs4.getString("sku"),
                                         Rs4.getString("nombre"),
                                         Rs4.getString("fecha_venc"),
                                         Math.round(Rs4.getDouble("cantidad_venc")),
                                         Math.round(diferencia3),
                                         "2",
                                         0,
                                         Rs4.getString("id_venc")
                });
                  
                l++;
                  
           }
                        
            
            Rs = Sql.Select(Query);
            
            while(Rs.next()){
              
                gmt1.addRow(new Object[]{Rs.getString("sku"),
                                         Rs.getString("nombre"),
                                         Rs.getString("fecha_venc"),
                                         Math.round(Rs.getDouble("cantidad_venc")),
                                         Rs.getString("id_venc")        
                });
                 
                i++;
           }
               
            
           Rs2 = Sql.Select(Query2);
           while(Rs2.next()){
               
              if (Rs2.getDouble("CANTIDAD") > 0){  
                  
                  cant1 = Rs2.getDouble("CANTIDAD");     
                  cant2 = Rs2.getDouble("CANTIDAD2");
           
                  diferencia = cant1 - cant2;
                  gmt2.addRow(new Object[]{Rs2.getString("SKU"),
                                           Rs2.getString("NOMBRE"),
                                           Rs2.getString("FECHA"),
                                           Math.round(Rs2.getDouble("CANTIDAD")),
                                           Math.round(diferencia),
                                           "0",
                                           Math.round(Rs2.getDouble("CANTIDAD2")),
                                           Rs2.getString("id_venc")
                          
                  });
                  j++;
              }    
           }  
           
    //**********************************************************************************************************//       
           for (int g=0; g<=gmt3.getRowCount()-1; g++ ){                        //Se cargan Productos que están en mt2 pero no en mt (verde)
               
               gmt2.addRow(new Object[] {gmt3.getValueAt(g, 0),
                                         gmt3.getValueAt(g, 1),
                                         gmt3.getValueAt(g, 2),
                                         gmt3.getValueAt(g, 3),
                                         gmt3.getValueAt(g, 4),
                                         gmt3.getValueAt(g, 5),
                                         gmt3.getValueAt(g, 6),
                                         gmt3.getValueAt(g, 7)
               });
               j++;
           }
           Grilla_mt2.setDefaultRenderer(Object.class, new Elrender());    
            
            
           for (int h=0; h<=gmt4.getRowCount()-1; h++ ){                        //Se cargan Productos que están en mt pero no en mt2 (rojo)
               
               gmt2.addRow(new Object[] {gmt4.getValueAt(h, 0),
                                         gmt4.getValueAt(h, 1),
                                         gmt4.getValueAt(h, 2),
                                         gmt4.getValueAt(h, 3),
                                         gmt4.getValueAt(h, 4),
                                         gmt4.getValueAt(h, 5),
                                         gmt4.getValueAt(h, 6),
                                         gmt4.getValueAt(h, 7)
               });
               j++;
           }
           Grilla_mt2.setDefaultRenderer(Object.class, new Elrender()); 
           
              
           Grilla_mt1.changeSelection(0, 0 , false, false);
           Grilla_mt2.changeSelection(0, 0 , false, false);
           Grilla_mt3.changeSelection(0, 0 , false, false);
           Grilla_mt4.changeSelection(0, 0 , false, false);
           
           jLabel1.setText(" N° de Registros : "+String.valueOf(i));
           jLabel2.setText(" N° de Registros : "+String.valueOf(j));
                    
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        } finally{
            Sql.Close();
            btAjustar.setVisible(true);
        }
    }//GEN-LAST:event_btCargarActionPerformed

    private void Grilla_mt2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Grilla_mt2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Grilla_mt2MouseClicked

    private void Grilla_mt3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Grilla_mt3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Grilla_mt3MouseClicked

    private void Grilla_mt4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Grilla_mt4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Grilla_mt4MouseClicked

    private void btAjustarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAjustarActionPerformed
        
        DefaultTableModel gmt1 = (DefaultTableModel) Grilla_mt1.getModel();
        DefaultTableModel gmt2 = (DefaultTableModel) Grilla_mt2.getModel();
        ExeSql Sql = new ExeSql();
        ExeSql Sql2 = new ExeSql();
        ExeSql Sql3 = new ExeSql();
        ResultSet Rs = null;
            
            int cant = 0;
            String Folio = "";
            //***************************************************AJUSTE STOCK *****************************************************//
         
            //***********************************************************************************************************************//
            
            
            
            for (int i=0; i<=gmt2.getRowCount()-1; i++ ){                        
            
                String idvenc = gmt2.getValueAt(i,7).toString();
                String sku = gmt2.getValueAt(i,0).toString();
                int tipo = 0;
                
                int cantidad = Integer.parseInt(gmt2.getValueAt(i,3).toString());
                int diferencia = Integer.parseInt(gmt2.getValueAt(i,4).toString());
                int estado = Integer.parseInt(gmt2.getValueAt(i,5).toString());
                int cantidad2 = Integer.parseInt(gmt2.getValueAt(i,6).toString());
            
                if (estado == 0){           //color negro
            
                    if (diferencia > 0 || diferencia < 0){              //Si hay diferencia en las cantidades
                
                        if (diferencia > 0 ){           //Si es positivo aumenta stock
                            
                             tipo = 0;
                        
                        }else if (diferencia < 0 ){      //Si es negativo disminuye stock
                        
                             tipo = 1;
                        
                        } 
                        
                        cant = cantidad2 + diferencia;
                     
                        try {
                         //******************************** actualiza producto_venc ***********************//
                            Sql.ExeSql("UPDATE producto_venc SET cantidad_venc ="+cant+ "\n" +               
                                       "WHERE id_venc = '"+idvenc+"' AND sku = '"+sku+"' ");
                
                            Sql.Commit();
                     
                     
                        } catch (SQLException ex) {
                            
                            Logger.getLogger(pfIndicadoresVencimiento.class.getName()).log(Level.SEVERE, null, ex);
                            Sql.Rollback();
                          
                        }
                     
                    }
                
                }else if (estado == 1){         //  color verde
                    
                    tipo = 0;
                    
                    try {
                        
                        Sql.ExeSql("INSERT INTO producto_venc \n" +
                                   "SELECT * FROM producto_venc2 WHERE id_venc = '"+idvenc+"' AND sku = '"+sku+"' ");                
                        Sql.Commit();
                    
                                           
                    
                    }catch (SQLException ex) {
               
                        Logger.getLogger(pfIndicadoresVencimiento.class.getName()).log(Level.SEVERE, null, ex);
                        Sql.Rollback();
                                           }
                
            
                }else if (estado == 2){                 //color rojo
                    
                    tipo = 1;
                    
                    cant = cantidad + diferencia;
            
                    try {
                    
//                        Sql.ExeSql("UPDATE producto_venc SET cantidad_venc ="+cant+ "\n" +               
//                                   "WHERE id_venc = '"+idvenc+"' AND sku = '"+sku+"' ");
                        
                        Sql.ExeSql("DELETE FROM producto_venc \n" +               
                                   "WHERE id_venc = '"+idvenc+"' AND sku = '"+sku+"' ");
                        
                
                        Sql.Commit();
                        
                     
                    } catch (SQLException ex) {
                        
                        Logger.getLogger(pfIndicadoresVencimiento.class.getName()).log(Level.SEVERE, null, ex);
                        Sql.Rollback();
                       
                    }
                   
                }
             
               
            }
        
            btCargar.doClick();
        
    }//GEN-LAST:event_btAjustarActionPerformed
     

    class Elrender extends DefaultTableCellRenderer {
         
        @Override
        public Component getTableCellRendererComponent(JTable tabla, Object valor, boolean isSelected, boolean hasFocus, int fila, int columna) {
        super.getTableCellRendererComponent(tabla,valor,isSelected, hasFocus, fila, columna);
         
            if(tabla.getValueAt(fila,5).equals("1"))
            {
                 this.setForeground(DARK_GREEN);
            }
            else if(tabla.getValueAt(fila,5).equals("2")){
                 this.setForeground(Color.red);  
            }     
            else {
                 this.setForeground(Color.black);  
            } 
            return this;
        }
    } 


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Grilla_mt1;
    private javax.swing.JTable Grilla_mt2;
    private javax.swing.JTable Grilla_mt3;
    private javax.swing.JTable Grilla_mt4;
    private javax.swing.JButton btAjustar;
    private javax.swing.JButton btCargar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelHasta;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
    
}
