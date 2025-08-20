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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
/**
 *
 * @author informática
 */
public class pfControlAvanceInventario extends javax.swing.JPanel {
    public static Color DARK_GREEN = new Color(0,153,0);
    DecimalFormat formateador = new DecimalFormat("###,###");
    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
    String Sku = "";
   
    public pfControlAvanceInventario() {
        initComponents();
       
      
        jPanelHasta.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
       
        Carga_Indicadores();
        Carga_Nocontados();
        
        
        
        Grilla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            //Se ejecuta automáticamente cada vez que se hace una nueva selección. 
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(Grilla.getSelectedRowCount()>0)
                    
                   Sku = Grilla.getValueAt(Grilla.getSelectedRow(), 0).toString().trim(); 
                   CargaUbicacion(Sku);
                    
            }

        });
       
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanelHasta = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Grilla = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbNoContados = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbNoCont_Ferr = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        Grilla_Inv = new javax.swing.JTable();

        jPanelHasta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel4.setText("TOTAL ITEMS A CONTAR    :");

        jLabel5.setText("TOTAL SKU A CONTAR        :");

        jLabel6.setText("TOTAL VALORIZADO          :");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("0");
        jLabel7.setToolTipText("");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Total Avance");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText(" PORCENTAJE DE AVANCE");

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("% Avance");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelHastaLayout = new javax.swing.GroupLayout(jPanelHasta);
        jPanelHasta.setLayout(jPanelHastaLayout);
        jPanelHastaLayout.setHorizontalGroup(
            jPanelHastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHastaLayout.createSequentialGroup()
                .addGroup(jPanelHastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelHastaLayout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(142, 142, 142))
        );
        jPanelHastaLayout.setVerticalGroup(
            jPanelHastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHastaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Grilla.setAutoCreateRowSorter(true);
        Grilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Sku", "Nombre", "Valorizado", "Convenio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
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
            Grilla.getColumnModel().getColumn(0).setMinWidth(70);
            Grilla.getColumnModel().getColumn(0).setPreferredWidth(70);
            Grilla.getColumnModel().getColumn(0).setMaxWidth(70);
            Grilla.getColumnModel().getColumn(2).setMinWidth(100);
            Grilla.getColumnModel().getColumn(2).setPreferredWidth(100);
            Grilla.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        jButton2.setText("Actualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("SKU NO CONTADOS");

        lbNoContados.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbNoContados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNoContados.setText("0");
        lbNoContados.setToolTipText("");
        lbNoContados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("NO CONTADOS FERRETERIA");

        lbNoCont_Ferr.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbNoCont_Ferr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNoCont_Ferr.setText("0");
        lbNoCont_Ferr.setToolTipText("");
        lbNoCont_Ferr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 865, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(lbNoContados, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbNoCont_Ferr, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbNoContados, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNoCont_Ferr, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(139, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Ubicaciones"));

        Grilla_Inv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cod. Ubc", "Ubicación", "Sku", "Cant", "Unidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane10.setViewportView(Grilla_Inv);
        if (Grilla_Inv.getColumnModel().getColumnCount() > 0) {
            Grilla_Inv.getColumnModel().getColumn(0).setMinWidth(0);
            Grilla_Inv.getColumnModel().getColumn(0).setPreferredWidth(0);
            Grilla_Inv.getColumnModel().getColumn(0).setMaxWidth(0);
            Grilla_Inv.getColumnModel().getColumn(2).setMinWidth(80);
            Grilla_Inv.getColumnModel().getColumn(2).setPreferredWidth(80);
            Grilla_Inv.getColumnModel().getColumn(2).setMaxWidth(80);
            Grilla_Inv.getColumnModel().getColumn(3).setMinWidth(50);
            Grilla_Inv.getColumnModel().getColumn(3).setPreferredWidth(50);
            Grilla_Inv.getColumnModel().getColumn(3).setMaxWidth(50);
            Grilla_Inv.getColumnModel().getColumn(4).setMinWidth(80);
            Grilla_Inv.getColumnModel().getColumn(4).setPreferredWidth(80);
            Grilla_Inv.getColumnModel().getColumn(4).setMaxWidth(80);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Carga_Indicadores();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Carga_Nocontados();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void GrillaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrillaMouseClicked
       
        
        
        
    }//GEN-LAST:event_GrillaMouseClicked
    private void Carga_Indicadores(){
        ExeSql Sql = new ExeSql();
        ResultSet Rs, Rs2, Rs3, Rs4, Rs5, Rs6, Rs7, Rs8, Rs9 = null;
        double valorizado1 = 0;
        double valorizado2 = 0.0;
        double valorizado3 = 0.0;
        int items1 = 0;
        double items2 = 0.0;
        int items3 = 0;
        int sku1 = 0;
        double sku2 = 0.0;
        int sku3 = 0;
        
        String Query, Query2, Query3, Query4, Query5, Query6, Query7, Query8, Query9 ;
     
        try{
            
            Query = "SELECT SUM(stock) AS total FROM inventario WHERE stock + gdc > 0";
            Query2 = "SELECT COUNT(DISTINCT(sku)) AS ctotal FROM inventario WHERE stock + gdc > 0"; 
                      
            Query3 = "select sum(i.stock*(case when p.costofinal is null then p.valultcompra else p.costofinal end))\n" +
                      "+sum(i.gdc*(case when p.costofinal is null then p.valultcompra else p.costofinal end)) as valorizado\n" +
                      "from inventario i\n" +
                      "left join producto p on i.sku=p.sku\n" +
                      "where i.stock+i.gdc>0 ";
            
            Rs = Sql.Select(Query);
            Rs.next();
            items1 = Rs.getInt("total");
            
            Rs2 = Sql.Select(Query2);
            Rs2.next();
            sku1 = Rs2.getInt("ctotal");
            
            Rs3 = Sql.Select(Query3);
            Rs3.next();
            valorizado1 = Rs3.getDouble("valorizado");
             
             
            jLabel7.setText(String.valueOf(items1));
             
            jLabel8.setText(String.valueOf(sku1));
            jLabel9.setText("$ "+formateador.format(valorizado1));
              
             
             Query4 = "SELECT (SUM (mt.cant * p.costofinal))*100/"+valorizado1+" AS valorizado\n" +
                      "FROM mt_productos2 mt\n" +
                      "LEFT JOIN producto p ON p.sku=mt.sku";
                        
   //****************************************************************************************************          
             Query9 = "SELECT SUM (mt.cant * p.costofinal) AS valorizado3\n" +
                      "FROM mt_productos2 mt\n" +
                      "LEFT JOIN producto p ON p.sku=mt.sku";
             
    //*****************************************************************************************         
             Query5 = "SELECT (SUM(mt.cant)*100)/"+items1+" AS items\n" +
                      "FROM mt_productos2 mt\n" +
                      "LEFT JOIN producto p ON p.sku=mt.sku"; 
             
             Query7 = "SELECT SUM(mt.cant) AS items2 \n" +
                      "FROM mt_productos2 mt\n" +
                      "LEFT JOIN producto p ON p.sku=mt.sku"; 
     //**********************************************************************************************        
             Query6 = "SELECT (COUNT(DISTINCT(mt.sku))*100)/"+sku1+" AS sku1 FROM mt_productos2 mt";
    
             Query8 = "SELECT COUNT(DISTINCT(mt.sku)) AS sku2 FROM mt_productos2 mt";
             
     //**********************************************************************************************        
                  
             
             Rs4 = Sql.Select(Query4);
             Rs4.next();
             valorizado2 = Rs4.getInt("valorizado");
             
             Rs9 = Sql.Select(Query9);
             Rs9.next();
             valorizado3= Rs9.getInt("valorizado3");
            
             Rs5 = Sql.Select(Query5);
             Rs5.next();
             items2 = Rs5.getInt("items");
             
             Rs7 = Sql.Select(Query7);
             Rs7.next();
             items3 = Rs7.getInt("items2");
             
            
             Rs6 = Sql.Select(Query6);
             Rs6.next();
             sku2 = Rs6.getInt("sku1");
             
             
             Rs8 = Sql.Select(Query8);
             Rs8.next();
             sku3 = Rs8.getInt("sku2");
             
             jLabel14.setText(String.valueOf(items3));
             jLabel15.setText(String.valueOf(sku3));
             jLabel16.setText("$ "+formateador.format(valorizado3));
            
             
             jLabel10.setText("% "+String.valueOf(items2));
             jLabel11.setText("% "+String.valueOf(sku2));
             jLabel12.setText("% "+String.valueOf(valorizado2));
 
         }
        catch (Exception e) {
            System.out.println(e.getMessage());
        } finally{
            Sql.Close();
        }
        
    }
 
    private void Carga_Nocontados(){
        
        DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
        
        while(TableModel.getRowCount()>0){
            TableModel.removeRow(0);
        }
        
        ExeSql Sql = new ExeSql();
        ResultSet Rs = null;
        
        int cont = 0;
        int cont_ferr = 0;
        String Query = "";
     
        try{
            
            Query = "select p.sku, p.nombre,(i.stock*(case when p.costofinal is null then p.valultcompra else p.costofinal end)) \n" +
                    "+sum(i.gdc*(case when p.costofinal is null then p.valultcompra else p.costofinal end)) as valorizado, pc.convenio, pc.codigo \n" +
                    "from inventario i \n" +
                    "left join producto p on i.sku=p.sku \n" +
                    "left join mt_productos2 mt on p.sku = mt.sku \n" +
                    "left join mt_productos mt1 on p.sku = mt1.sku \n" +
                    "left join par_convenio pc on p.convenio = pc.codigo \n" +
                    "where i.stock+i.gdc>0 and mt.cant is NULL and mt1.cant <> 0 \n" +
                    "group by p.sku, i.stock, pc.convenio, pc.codigo \n" +
                    "order by p.sku"; 
           
            
            Rs = Sql.Select(Query);
            
            if (Sql.GetRowCount() > 0){
            
                while (Rs.next()){  
            
                    
                    if (Rs.getDouble("valorizado") > 0  && !Rs.getString("sku").equals("099999999")){
                    
                        TableModel.addRow(new Object[]{Rs.getString("sku"),
                                                       Rs.getString("nombre"),
                                                       Math.round(Rs.getDouble("valorizado")),
                                                       Rs.getString("convenio")
                        });
                        
                        cont++;
                        
                        if (Rs.getInt("codigo") == 2){
                        
                            cont_ferr++;
                        
                        }
                        
                        
                    
                    }
             
                }
                
                
                lbNoContados.setText(""+cont);
                lbNoCont_Ferr.setText(""+cont_ferr);
              
            }
             
             
             
    
         }
        catch (Exception e) {
            System.out.println(e.getMessage());
        } finally{
            Sql.Close();
        }
        
    }
    
    private void CargaUbicacion(String Sku){
    
        try {
            ExeSql Sql = new ExeSql();
            ResultSet Rs = null;
            DefaultTableModel TableModel2 = (DefaultTableModel) Grilla_Inv.getModel();
            
            while(TableModel2.getRowCount()>0){
                 TableModel2.removeRow(0);
            }
            
            
            Rs = Sql.Select("SELECT mt.ubicacion, cm.nombre, mt.sku, mt.cant, pu.unidad FROM mt_productos mt \n"+
                            "LEFT JOIN mt_codmetro cm ON mt.ubicacion = cm.codmetro "+
                            "LEFT JOIN producto p ON mt.sku = p.sku \n"+
                            "LEFT JOIN par_unidad pu ON pu.codigo = p.unidad \n"+
                            "WHERE mt.sku ='"+Sku+"' and mt.cant <> 0");
            
            if (Sql.GetRowCount() > 0){
            
                while (Rs.next()){
                
                            TableModel2.addRow(new Object[] {Rs.getString("ubicacion"),Rs.getString("nombre"),Rs.getString("sku"),Rs.getString("cant"), Rs.getString("unidad")});        
                
                
                }
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Grilla;
    private javax.swing.JTable Grilla_Inv;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelHasta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JLabel lbNoCont_Ferr;
    private javax.swing.JLabel lbNoContados;
    // End of variables declaration//GEN-END:variables
    
}
