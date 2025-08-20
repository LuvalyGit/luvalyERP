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
public class pfIndicadoresInventario extends javax.swing.JPanel {
    public static Color DARK_GREEN = new Color(0,153,0);
    DecimalFormat formateador = new DecimalFormat("###,###");
    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
   
    public pfIndicadoresInventario() {
        initComponents();
       
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        Grilla_mt1.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        jPanelHasta.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        CargaBodega();
       
        Carga_Indicadores();
        txtUbicacion.setVisible(false);
        txtNomUbicacion.setVisible(false);
        jScrollPane4.setVisible(false);
        jScrollPane5.setVisible(false);
        btAjustar.setVisible(false);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanelHasta = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        cbBodega = new javax.swing.JComboBox<String>();
        cbRack = new javax.swing.JComboBox<String>();
        cbMetro = new javax.swing.JComboBox<String>();
        btCargar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Grilla_mt1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        Grilla_mt2 = new javax.swing.JTable();
        txtUbicacion = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        Grilla_mt3 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        Grilla_mt4 = new javax.swing.JTable();
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
        btAjustar = new javax.swing.JButton();
        txtNomUbicacion = new javax.swing.JTextField();

        jPanelHasta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("UBICACION"));

        cbBodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBodegaActionPerformed(evt);
            }
        });

        cbRack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRackActionPerformed(evt);
            }
        });

        cbMetro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMetroActionPerformed(evt);
            }
        });

        btCargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/search16.png"))); // NOI18N
        btCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbBodega, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbRack, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbMetro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btCargar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbBodega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbMetro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbRack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Grilla_mt1.setAutoCreateRowSorter(true);
        Grilla_mt1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ubicacion", "SKU", "Nombre", "Cant"
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
            Grilla_mt1.getColumnModel().getColumn(1).setMinWidth(100);
            Grilla_mt1.getColumnModel().getColumn(1).setPreferredWidth(100);
            Grilla_mt1.getColumnModel().getColumn(1).setMaxWidth(100);
            Grilla_mt1.getColumnModel().getColumn(2).setPreferredWidth(400);
            Grilla_mt1.getColumnModel().getColumn(3).setMinWidth(60);
            Grilla_mt1.getColumnModel().getColumn(3).setPreferredWidth(60);
            Grilla_mt1.getColumnModel().getColumn(3).setMaxWidth(60);
        }

        Grilla_mt2.setAutoCreateRowSorter(true);
        Grilla_mt2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ubicacion", "SKU", "Nombre", "Cant", "Diferencia", "estado", "Cant2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
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
            Grilla_mt2.getColumnModel().getColumn(1).setMinWidth(100);
            Grilla_mt2.getColumnModel().getColumn(1).setPreferredWidth(100);
            Grilla_mt2.getColumnModel().getColumn(1).setMaxWidth(100);
            Grilla_mt2.getColumnModel().getColumn(2).setPreferredWidth(400);
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
                "Ubicacion", "SKU", "Nombre", "Cant", "Diferencia", "estado", "Cant2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
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
            Grilla_mt3.getColumnModel().getColumn(1).setMinWidth(100);
            Grilla_mt3.getColumnModel().getColumn(1).setPreferredWidth(100);
            Grilla_mt3.getColumnModel().getColumn(1).setMaxWidth(100);
            Grilla_mt3.getColumnModel().getColumn(2).setPreferredWidth(400);
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
                "Ubicacion", "SKU", "Nombre", "Cant", "Diferencia", "estado", "Cant2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
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
            Grilla_mt4.getColumnModel().getColumn(1).setMinWidth(100);
            Grilla_mt4.getColumnModel().getColumn(1).setPreferredWidth(100);
            Grilla_mt4.getColumnModel().getColumn(1).setMaxWidth(100);
            Grilla_mt4.getColumnModel().getColumn(2).setPreferredWidth(400);
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

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel4.setText("TOTAL ITEMS A CONTAR    :");

        jLabel5.setText("TOTAL SKU A CONTAR        :");

        jLabel6.setText("TOTAL VALORIZADO          :");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText(" PORCENTAJE DE AVANCE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
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
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(85, 85, 85)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
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
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        btAjustar.setText("Ajustar");
        btAjustar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAjustarActionPerformed(evt);
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
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139)
                        .addGroup(jPanelHastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                            .addComponent(jScrollPane4)))
                    .addGroup(jPanelHastaLayout.createSequentialGroup()
                        .addGroup(jPanelHastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelHastaLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(txtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtNomUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelHastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHastaLayout.createSequentialGroup()
                                .addComponent(btAjustar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(267, 267, 267)))))
                .addContainerGap())
        );
        jPanelHastaLayout.setVerticalGroup(
            jPanelHastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHastaLayout.createSequentialGroup()
                .addGroup(jPanelHastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHastaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelHastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelHastaLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btAjustar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelHastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelHastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHastaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanelHastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(jPanelHastaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84))))
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
                .addGap(0, 59, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void Carga_Indicadores(){
        ExeSql Sql = new ExeSql();
        ResultSet Rs, Rs2, Rs3, Rs4, Rs5, Rs6 = null;
        int valorizado1 = 0;
        double valorizado2 = 0.0;
        int items1 = 0;
        double items2 = 0.0;
        int sku1 = 0;
        double sku2 = 0.0;
        String Query, Query2, Query3, Query4, Query5, Query6 ;
     
        try{
            
            Query = "SELECT SUM(stock) AS total FROM inventario WHERE stock > 0";
            Query2 = "SELECT COUNT(DISTINCT(sku)) AS ctotal FROM inventario WHERE stock > 0"; 
            Query3 = "SELECT SUM((i.stock+i.gdc)*p.costofinal) AS valorizado FROM inventario i LEFT JOIN producto p ON i.sku=p.sku WHERE i.stock>0";
            
            Rs = Sql.Select(Query);
            Rs.next();
            items1 = Rs.getInt("total");
            
            Rs2 = Sql.Select(Query2);
            Rs2.next();
            sku1 = Rs2.getInt("ctotal");
            
            Rs3 = Sql.Select(Query3);
            Rs3.next();
            valorizado1 = Rs3.getInt("valorizado");
             
             
            jLabel7.setText(String.valueOf(items1));
            jLabel8.setText(String.valueOf(sku1));
            jLabel9.setText("$ "+formateador.format(valorizado1));
              
             
             Query4 = "SELECT (SUM (mt.cant * p.costofinal))*100/"+valorizado1+" AS valorizado\n" +
                      "FROM mt_productos2 mt\n" +
                      "LEFT JOIN producto p ON p.sku=mt.sku";
             
             Query5 = "SELECT (SUM(mt.cant)*100)/"+items1+" AS items\n" +
                      "FROM mt_productos2 mt\n" +
                      "LEFT JOIN producto p ON p.sku=mt.sku"; 
             
             Query6 = "SELECT (COUNT(DISTINCT(mt.sku))*100)/"+sku1+" AS sku1 FROM mt_productos2 mt";
                  
             
             Rs4 = Sql.Select(Query4);
             Rs4.next();
             valorizado2 = Rs4.getInt("valorizado");
            
             Rs5 = Sql.Select(Query5);
             Rs5.next();
             items2 = Rs5.getInt("items");
            
             Rs6 = Sql.Select(Query6);
             Rs6.next();
             sku2 = Rs6.getInt("sku1");
             
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
        String strUbicacion = "";
       
        DefaultTableModel gmt1 = (DefaultTableModel) Grilla_mt1.getModel();
        DefaultTableModel gmt2 = (DefaultTableModel) Grilla_mt2.getModel();
        DefaultTableModel gmt3 = (DefaultTableModel) Grilla_mt3.getModel();
        DefaultTableModel gmt4 = (DefaultTableModel) Grilla_mt4.getModel();
        fmMain.LimpiaGrilla(gmt1);
        fmMain.LimpiaGrilla(gmt2);
        fmMain.LimpiaGrilla(gmt3);
        fmMain.LimpiaGrilla(gmt4);
        try{
           strUbicacion = txtUbicacion.getText().trim();
            
            Query = "SELECT mp.ubicacion, mp.sku, p.nombre, mp.cant FROM mt_productos mp \n" +  //Productos que están en mt
                    "LEFT JOIN producto p on p.sku = mp.sku\n"+
                    "WHERE mp.ubicacion ='"+strUbicacion+"' AND cant > 0"; 
            
            
            Query2 = "SELECT mp2.ubicacion UBICACION,\n"+           //Productos que están en ambas tablas (negro)
                     "mp2.sku SKU, mp2.cant CANTIDAD,\n"+
                     "mp.cant CANTIDAD2, p.nombre NOMBRE \n"+ 
                     "FROM mt_productos2 mp2 \n" +
                     "LEFT JOIN mt_productos mp ON mp.sku = mp2.sku\n" +
                     "LEFT JOIN producto p ON p.sku = mp2.sku\n"+
                     "WHERE mp.ubicacion='"+strUbicacion+"' AND mp2.ubicacion='"+strUbicacion+"'";  
            
            Query3 = "SELECT * FROM mt_productos2 mt2 \n" +                     //Productos que están en mt2 pero no en mt (verde)
                     "LEFT JOIN producto p ON p.sku = mt2.sku\n" +
                     "WHERE NOT EXISTS(SELECT  * FROM  mt_productos mt1 WHERE mt2.sku = sku AND mt2.ubicacion = mt1.ubicacion) \n" +
                     "AND mt2.ubicacion = '"+strUbicacion+"'";
            
            
            Query4 = "SELECT * FROM mt_productos mt \n" +                        //Productos que están en mt pero no en mt2 (rojo)
                     "LEFT JOIN producto p ON p.sku = mt.sku\n" +
                     "WHERE NOT EXISTS(SELECT  * FROM  mt_productos2 mt2 WHERE mt.sku = sku AND mt.ubicacion = mt2.ubicacion) \n" +
                     "AND mt.ubicacion = '"+strUbicacion+"' AND cant > 0";
           
            Rs3 = Sql.Select(Query3);
            
            while(Rs3.next()){
            
                if (Rs3.getDouble("cant") > 0){ 
                   
                   diferencia2 = Rs3.getDouble("cant") - 0;
                   
                   gmt3.addRow(new Object[]{Rs3.getString("ubicacion"),
                                            Rs3.getString("sku"),
                                            Rs3.getString("nombre"),
                                            Math.round(Rs3.getDouble("cant")),
                                            Math.round(diferencia2),
                                            "1",
                                            0
                   });
                   
                   k++;
               }
            }
            
            Rs4 = Sql.Select(Query4);
            
            while(Rs4.next()){
               
                diferencia3 = 0 - Rs4.getDouble("cant"); 
                  
                gmt4.addRow(new Object[]{Rs4.getString("ubicacion"),
                                         Rs4.getString("sku"),
                                         Rs4.getString("nombre"),
                                         Math.round(Rs4.getDouble("cant")),
                                         Math.round(diferencia3),
                                         "2",
                                         0
                });
                  
                l++;
                  
           }
                        
            
            Rs = Sql.Select(Query);
            
            while(Rs.next()){
              
                gmt1.addRow(new Object[]{Rs.getString("ubicacion"),
                                         Rs.getString("sku"),
                                         Rs.getString("nombre"),
                                         Math.round(Rs.getDouble("cant"))
                });
                 
                i++;
           }
               
            
           Rs2 = Sql.Select(Query2);
           while(Rs2.next()){
               
              if (Rs2.getDouble("CANTIDAD") > 0){  
                  
                  cant1 = Rs2.getDouble("CANTIDAD");     
                  cant2 = Rs2.getDouble("CANTIDAD2");
           
                  diferencia = cant1 - cant2;
                  gmt2.addRow(new Object[]{Rs2.getString("UBICACION"),
                                           Rs2.getString("SKU"),
                                           Rs2.getString("NOMBRE"),
                                           Math.round(Rs2.getDouble("CANTIDAD")),
                                           Math.round(diferencia),
                                           "0",
                                           Math.round(Rs2.getDouble("CANTIDAD2"))
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
                                         gmt3.getValueAt(g, 6)
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
                                         gmt4.getValueAt(h, 6)
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
        }
    }//GEN-LAST:event_btCargarActionPerformed

    private void cbMetroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMetroActionPerformed
       
        if ((cbBodega.getSelectedIndex()>0) && (cbRack.getSelectedIndex()>0) && (cbMetro.getSelectedIndex()>0))
        {
          
            txtNomUbicacion.setText(cbBodega.getSelectedItem().toString());
            txtNomUbicacion.setText(txtNomUbicacion.getText().trim()+ "-" +  cbRack.getSelectedItem().toString());
            txtNomUbicacion.setText(txtNomUbicacion.getText().trim()+ "-" +  cbMetro.getSelectedItem().toString());
            
            
            despliegaUbicacion();
            btCargar.doClick();
            btAjustar.setVisible(true);
        }
        else{
            txtUbicacion.setText("");
    
        }
    }//GEN-LAST:event_cbMetroActionPerformed

    private void cbRackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRackActionPerformed

        if (cbRack.getItemCount()==0)
        {
            return;
        }

        if ((cbBodega.getSelectedIndex()>0) && (cbRack.getSelectedIndex()>0) && (cbMetro.getSelectedIndex()>0)){

            txtNomUbicacion.setText(cbBodega.getSelectedItem().toString());
            txtNomUbicacion.setText(txtNomUbicacion.getText().trim()+ "-" +  cbRack.getSelectedItem().toString());
            txtNomUbicacion.setText(txtNomUbicacion.getText().trim()+ "-" +  cbMetro.getSelectedItem().toString());
            
            despliegaUbicacion();
            btCargar.doClick();
            btAjustar.setVisible(true);
        }
        CargaMetro();
    }//GEN-LAST:event_cbRackActionPerformed

    private void cbBodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBodegaActionPerformed
  
        if ((cbBodega.getSelectedIndex()>0) && (cbRack.getSelectedIndex()>0) && (cbBodega.getSelectedIndex()>0)){
            
            txtNomUbicacion.setText(cbBodega.getSelectedItem().toString());
            txtNomUbicacion.setText(txtNomUbicacion.getText().trim()+ "-" +  cbRack.getSelectedItem().toString());
            txtNomUbicacion.setText(txtNomUbicacion.getText().trim()+ "-" +  cbMetro.getSelectedItem().toString());
            
            despliegaUbicacion();
            btCargar.doClick();
            btAjustar.setVisible(true);
        }

        try{
           
            CargaRack();

        }
        catch(Exception e)
        {
            Toolkit.getDefaultToolkit().beep();
            fmMain.Mensaje("Error: "+e);

        }
    }//GEN-LAST:event_cbBodegaActionPerformed

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
     //
        if ((cbBodega.getSelectedIndex()>0) && (cbRack.getSelectedIndex()>0) && (cbMetro.getSelectedIndex()>0)){    
        
            int cant = 0;
            String Folio = "";
            //***************************************************AJUSTE STOCK *****************************************************//
            String ubica2 = txtUbicacion.getText().trim();
                        
            try {   
                Rs = Sql2.Select("SELECT sp_getcorrelativo FROM sp_getcorrelativo('AJU')");
                Rs.next();
            
                Folio = Rs.getString("sp_getcorrelativo");
                       
                Sql3.ExeSql( "INSERT INTO ajusteenc(folio,motivo,comentario) \n" +
                             "VALUES (\n" +
                             Folio + ",\n" +
                             7 + ",'AJUSTE " + ubica2 + "')");
                
                Sql3.Commit();
                
                
            } catch (SQLException ex) {
                Logger.getLogger(pfIndicadoresInventario.class.getName()).log(Level.SEVERE, null, ex);
                Sql.Rollback();
            }
            
            //***********************************************************************************************************************//
            
            
            
            for (int i=0; i<=gmt2.getRowCount()-1; i++ ){                        
            
                String ubica = gmt2.getValueAt(i,0).toString();
                String sku = gmt2.getValueAt(i,1).toString();
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
                         //******************************** actualiza mt_productos ***********************//
                            Sql.ExeSql("UPDATE mt_productos SET cant ="+cant+ "\n" +               
                                       "WHERE ubicacion = '"+ubica+"' AND sku = '"+sku+"' ");
                
                            Sql.Commit();
                     
                        //*************************************Crea un registro ajuste stock******************************//    
                            
                            if (tipo == 1){
                            
                               diferencia = diferencia * -1;
                            
                            }
                            
                            Sql2.ExeSql("INSERT INTO ajustedet(folio,sku,cantidad,tipo) \n" +
                                        "VALUES (" + Folio + ",'" + sku + "'," + diferencia + ",\n" +
                                        tipo + "\n" +
                                        ")");
                            
                            Sql2.Commit();
                        //****************************************************************************************************//    
                     
                        } catch (SQLException ex) {
                            
                            Logger.getLogger(pfIndicadoresInventario.class.getName()).log(Level.SEVERE, null, ex);
                            Sql.Rollback();
                            Sql2.Rollback();
                        }
                     
                    }
                
                }else if (estado == 1){         //  color verde
                    
                    tipo = 0;
                    
                    try {
                        
                        Sql.ExeSql("INSERT INTO mt_productos \n" +
                                   "SELECT * FROM mt_productos2 WHERE ubicacion = '"+ubica+"' AND sku = '"+sku+"' ");                
                        Sql.Commit();
                    
                         //*************************************Crea un registro ajuste stock******************************//    
                            
                            Sql2.ExeSql("INSERT INTO ajustedet(folio,sku,cantidad,tipo) \n" +
                                        "VALUES (" + Folio + ",'" + sku + "'," + cantidad + ",\n" +
                                        tipo + "\n" +
                                        ")");
                            
                            Sql2.Commit();
                        //****************************************************************************************************//    
                     
                    
                    }catch (SQLException ex) {
               
                        Logger.getLogger(pfIndicadoresInventario.class.getName()).log(Level.SEVERE, null, ex);
                        Sql.Rollback();
                        Sql2.Rollback();
                    }
                
            
                }else if (estado == 2){                 //color rojo
                    
                    tipo = 1;
                    
                    cant = cantidad + diferencia;
            
                    try {
                    
                        Sql.ExeSql("UPDATE mt_productos SET cant ="+cant+ "\n" +               
                                   "WHERE ubicacion = '"+ubica+"' AND sku = '"+sku+"' ");
                
                        Sql.Commit();
                    
                                    
                   
                     //*************************************Crea un registro ajuste stock******************************//    
                            
                        diferencia = diferencia * -1;
                        Sql2.ExeSql("INSERT INTO ajustedet(folio,sku,cantidad,tipo) \n" +
                                    "VALUES (" + Folio + ",'" + sku + "'," + diferencia + ",\n" +
                                    tipo + "\n" +
                                    ")");
                            
                        Sql2.Commit();
                        //****************************************************************************************************//    
                        
                        
                        
                        
                     
                    } catch (SQLException ex) {
                        
                        Logger.getLogger(pfIndicadoresInventario.class.getName()).log(Level.SEVERE, null, ex);
                        Sql.Rollback();
                        Sql2.Rollback();
                    }
                   
                }
             
               
            }
        
            btCargar.doClick();
        
        }else{
        
        
           if (cbBodega.getSelectedIndex()==0) {
        
               fmMain.Mensaje("Debe elegir una Bodega");
               return;
        
          } 
           
          if (cbRack.getSelectedIndex()==0){
          
              fmMain.Mensaje("Debe elegir un Rack");
               return;
              
          }
              
          if (cbMetro.getSelectedIndex()==0){
          
             fmMain.Mensaje("Debe elegir un Metro");
             return; 
          
          }
        
        
        
        }   
        //
        
        
    }//GEN-LAST:event_btAjustarActionPerformed
    
    public void CargaBodega(){
         
        DefaultComboBoxModel value;
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        String Query="";
        cbBodega.removeAllItems();
        int i=0;
        value =new DefaultComboBoxModel();
        
        try {
            
            Query="SELECT split_part(mt.nombre, '-',1) AS nombre \n"+
                  "FROM mt_codmetro mt \n"+
                  "GROUP BY split_part(mt.nombre, '-',1) \n"+
                  "ORDER BY split_part(mt.nombre, '-',1)";
            
            Rs = Sql.Select(Query);
            
            if(Sql.GetRowCount()==0) return;
                
            value.addElement(new Combo_CodStr("Seleccione","",0));     
            
            while(Rs.next()){

              value.addElement(new Combo_CodStr(Rs.getString("nombre").trim(),"",i));
              System.out.println(Rs.getString("nombre").trim());
              i++;
            } 
            
           cbBodega.setModel(value);
           cbBodega.setSelectedIndex(0);
           

        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Sql.Close();
        }
     }
    
    
    //*********************************************************************************************************************************//
    
    
    
     
//    public void CargaRack2(){
//        DefaultComboBoxModel value;
//        ExeSql Sql = new ExeSql();
//        ResultSet Rs;
//        String Query="";
//        cbRack.removeAllItems();
//        int i=0;
//        
//
//        value =new DefaultComboBoxModel();
//        try {
//           
//            Query="Select r.rack, r.codigo from mt_rack r \n" +
//                  "where r.bodega = (select b.codigo from mt_bodega b where b.bodega='"+cbBodega.getSelectedItem().toString().trim()+"')";
//            
//            Rs = Sql.Select(Query);
//            if(Sql.GetRowCount()==0) return;
//               value.addElement(new ComboCodigos("Seleccione",0)); 
//            while(Rs.next()){
//                value.addElement(new ComboCodigos(Rs.getString("rack").trim(),Rs.getInt("codigo")));
//                System.out.println(Rs.getString("rack").trim());
//                i++;
//            } 
//            cbRack.setModel(value);
//           
//            if (cbRack.getSelectedIndex()>0){
//               cbRack.setSelectedIndex(0);}
//           
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        finally{
//            Sql.Close();
//        }
//    }
    
    
    //**************************************************** RACK ************************************************************//
    
    
    public void CargaRack(){
        
        DefaultComboBoxModel value;
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        String Query="";
        cbRack.removeAllItems();
        int i=0;
     
        value =new DefaultComboBoxModel();
  
        try {
 
            
            Query ="SELECT split_part(mt.nombre, '-',2) AS nombre \n"+
                   "FROM mt_codmetro mt \n"+
                   "where split_part(mt.nombre, '-',1) = '"+cbBodega.getSelectedItem().toString().trim()+"' \n"+
                   "GROUP BY split_part(mt.nombre, '-',2)\n"+
                   "ORDER BY split_part(mt.nombre, '-',2)";
            
            
            Rs = Sql.Select(Query);
            
            if(Sql.GetRowCount()==0) return;
             
            value.addElement(new ComboCodigos("Seleccione",0)); 
           
            while(Rs.next()){
                
                 value.addElement(new ComboCodigos(Rs.getString("nombre").trim(),0));
                
                System.out.println(Rs.getString("nombre").trim());
                
                i++;
           } 
           cbRack.setModel(value);
           
           if (cbRack.getSelectedIndex()>0){
               
               cbRack.setSelectedIndex(0);
           
           }
           
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Sql.Close();
        }
     }
    
    
    
    //*************************************************************************************************************************//
    
     
//    public void CargaMetro(){
//        DefaultComboBoxModel value;
//        ExeSql Sql = new ExeSql();
//        ResultSet Rs;
//        String Query="";
//        cbMetro.removeAllItems();
//
//        value =new DefaultComboBoxModel();
//        try {
//            String strbodega="";
//
//               if ((cbRack.getSelectedIndex()>0) && (cbBodega.getSelectedIndex()>0)){
//                   
//                        Combo_CodStr bodega = (Combo_CodStr) cbBodega.getSelectedItem();
//                        bodega.getId(); 
//                        
//                        ComboCodigos RackCodigo = (ComboCodigos) cbRack.getSelectedItem();
//                        RackCodigo.getId();
//            
//                      
//                         
//                     Query =" Select m.metro,m.codigo from mt_bodega b\n" +
//                    " left join mt_rack r\n" +
//                    " on b.codigo = r.bodega\n" +
//                    " left join mt_metro m\n" +
//                    " on m.rack = r.codigo\n" +
//                    " where m.rack =" + RackCodigo.getId() + " and r.bodega = '" + bodega.getId() +"' order by m.codigo;";    
//                   } 
//               else
//               {
//                   return;
//               }
//            
//            Rs = Sql.Select(Query);
//            if(Sql.GetRowCount()==0) return;
//             value.addElement(new ComboCodigos("Seleccione",0)); 
//           while(Rs.next()){
//            value.addElement(new ComboCodigos(Rs.getString("metro").trim(),Rs.getInt("codigo")));
//            System.out.println(Rs.getString("metro").trim());
//            
//           } 
//           cbMetro.setModel(value);
//           cbMetro.setSelectedIndex(0);
//           
//           
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        finally{
//            Sql.Close();
//        }
//    }
    
    
    //***************************************************  METRO  *************************************************************//
    
    public void CargaMetro(){
       
        DefaultComboBoxModel value;
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        String Query="";
        cbMetro.removeAllItems();

        value =new DefaultComboBoxModel();

        try {
            String strbodega="";

            if ((cbRack.getSelectedIndex()>=0) && (cbBodega.getSelectedIndex()>=0)){
                   
                Combo_CodStr bodegaOR = (Combo_CodStr) cbBodega.getSelectedItem();
                bodegaOR.getId(); 
                        
                ComboCodigos RackCodigoOR = (ComboCodigos) cbRack.getSelectedItem();
                RackCodigoOR.getId();
                   
                Query = "SELECT split_part(mt.nombre, '-',3) AS nombre,  mt.codmetro \n"+
                        "FROM mt_codmetro mt \n"+
                        "WHERE split_part(mt.nombre, '-',1) = '"+cbBodega.getSelectedItem().toString().trim()+"' \n"+
                        "AND split_part(mt.nombre, '-',2) = '"+cbRack.getSelectedItem().toString().trim()+"' \n"+
                        "GROUP BY split_part(mt.nombre, '-',3), mt.codmetro \n"+
                        "ORDER BY split_part(mt.nombre, '-',3)"; 
                     
            }else{
                   
                return;
            }
            
            Rs = Sql.Select(Query);
            
            if(Sql.GetRowCount()==0) return;
             value.addElement(new ComboCodigos("Seleccione",0)); 
           
            while(Rs.next()){

                value.addElement(new ComboCodigos(Rs.getString("nombre").trim(),0));
                System.out.println(Rs.getString("nombre").trim());
            
            } 
            
            cbMetro.setModel(value);
            cbMetro.setSelectedIndex(0);
           
           
        }catch (Exception e) {
         
            System.out.println(e);
        }finally{
            
            Sql.Close();
        }
     }    
    
    
    
    //*****************************************************************************************************************************//
    
    public void despliegaUbicacion(){
        
        ExeSql Sql = new ExeSql();
        ResultSet Rs, Rs1;
        String Query2 ;
        String strUbicacion = "";
        String strNombreUbicacion = "";

        if ((cbBodega.getSelectedIndex()>0) && (cbRack.getSelectedIndex()>0) && (cbMetro.getSelectedIndex()>0))
        if ((cbBodega.getSelectedIndex()>0) && (cbRack.getSelectedIndex()>0) && (cbMetro.getSelectedIndex()>0))    
        {
            txtNomUbicacion.setText(cbBodega.getSelectedItem().toString());
            txtNomUbicacion.setText(txtNomUbicacion.getText().trim()+ "-" +  cbRack.getSelectedItem().toString());
            txtNomUbicacion.setText(txtNomUbicacion.getText().trim()+ "-" +  cbMetro.getSelectedItem().toString());
        }
        else{
            txtNomUbicacion.setText("");
        }

            try{
            
                strNombreUbicacion = txtNomUbicacion.getText().trim();
          
                Query2 = "SELECT codmetro AS ubc, nombre from mt_codmetro \n" +
                         "WHERE nombre = '" +strNombreUbicacion+"'" ;
            
                Rs1 = Sql.Select(Query2);
                if (Rs1.next()){
                    strNombreUbicacion =Rs1.getString("nombre").trim();
                    strUbicacion =Rs1.getString("ubc").trim();
                    txtUbicacion.setText(strUbicacion);
               
                }
                else
                {
                    fmMain.Mensaje("Ubicacion no encontrada, favor revise la ubicación");
                }
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            } finally{
                Sql.Close();
            }

        
    }
    
    
    

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
    private javax.swing.JComboBox<String> cbBodega;
    private javax.swing.JComboBox<String> cbMetro;
    private javax.swing.JComboBox<String> cbRack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelHasta;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField txtNomUbicacion;
    private javax.swing.JTextField txtUbicacion;
    // End of variables declaration//GEN-END:variables
    
}
