/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelForm;

import Conexion.ExeSql;
import Dialogos.jdBuscarCliPrv;
import Dialogos.jdOC_OrdenesCompra;
import Dialogos.jdOC_PendientesFac;
import Dialogos.jdPagadoPrvCli;
import Dialogos.jdPagarPrv;
import Formularios.fmMain;
import static Formularios.fmMain.pnPestanas;
import Utilidades.Exporter;
import Utilidades.PanelTab;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author David Alcaman
 */
public class pfReporteMargen extends javax.swing.JPanel {
    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
    /**
     * Creates new form pfReportePagosPrv
     */
     public String  gano="",gmes=""; 
     public String StrEcona = "76440015";
   
    Boolean Entra = false;
    public pfReporteMargen() {
        initComponents();
        Calendar fecha = new GregorianCalendar();
       
        //Obtenemos el valor del año, mes, día,
        //hora, minuto y segundo del sistema
        //usando el método get y el parámetro correspondiente
         
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
       
            
        /* int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);*/
      
        // Deshabilita los combos OC
        chk_oc.setVisible(false);
        cboAgno1.setVisible(false);
        cboMes1.setVisible(false);
        
        
        String anox ="x";
        String mesx ="x";
        
        anox = String.valueOf(año);
        mesx = String.valueOf(mes+1);

        cboAgno.setSelectedItem(anox); 
        cboMes.setSelectedItem(mesx); 
        gano=anox;
        gmes =mesx;       
        
        cboAgno1.setSelectedItem(anox); 
        cboMes1.setSelectedItem(mesx); 
        
          
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        Grilla.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        Grilla.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        Grilla.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        
        
        
        
        // Alineacion Grilla Detalle  24-01-2017
        Grilla_Det.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        Grilla_Det.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        Grilla_Det.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        Grilla_Det.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
        Grilla_Det.getColumnModel().getColumn(7).setCellRenderer(rightRenderer);
        Grilla_Det.getColumnModel().getColumn(8).setCellRenderer(rightRenderer);
        
        Grilla_Det4.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        Grilla_Det4.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        Grilla_Det4.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        Grilla_Det4.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
        Grilla_Det4.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
        Grilla_Det4.getColumnModel().getColumn(7).setCellRenderer(rightRenderer);
        
        
        btExcel.setVisible(true);
        
        lbmar.setVisible(true);
        lblMargen.setVisible(true);
//        if (Grilla.getSelectedRow() == -1)
//            Grilla.changeSelection(0, 0 , false, false);
//        Enlaza Grilla de Factura con su Grilla de Detalle
        
        
//        Grilla.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
//        @Override
//       public void valueChanged(ListSelectionEvent e){
//           if (Grilla.getSelectedRowCount()>=0 && Grilla.getSelectedRow()>-1)
//               CargaDetMargen(Grilla.getValueAt(Grilla.getSelectedRow(), 0).toString().trim());
//       } 
//    });
//        
//        
// //        Enlaza Grilla de Ordenes con su Grilla de Detalle
//        GrillaC.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
//        @Override
//       public void valueChanged(ListSelectionEvent e){
//           if (Grilla_Det4.getSelectedRowCount()>=0 && GrillaC.getSelectedRow()>-1)
//               CargaDetMargenOrdenes(GrillaC.getValueAt(GrillaC.getSelectedRow(), 0).toString().trim());
//       } 
//    });       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuVerProducto = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuVerProdOrd = new javax.swing.JMenuItem();
        AGNO = new javax.swing.JPanel();
        cboAgno = new javax.swing.JComboBox<>();
        cboMes = new javax.swing.JComboBox<>();
        lblAgno = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btExcel = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbReg = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbRegDet = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbTotalVtasDet = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Grilla_Det = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        lbMargFAC = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Grilla = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        lbRegDet4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbTotalVtasDet4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbRegC = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbTotalC = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        GrillaC = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        Grilla_Det4 = new javax.swing.JTable();
        lbmar = new javax.swing.JLabel();
        lblMargen = new javax.swing.JLabel();
        btBuscar = new javax.swing.JButton();
        btExcelOr = new javax.swing.JButton();
        cboAgno1 = new javax.swing.JComboBox<>();
        cboMes1 = new javax.swing.JComboBox<>();
        chk_oc = new javax.swing.JCheckBox();
        chk_ECONA = new javax.swing.JCheckBox();

        jMenuVerProducto.setText("Ver Producto");
        jMenuVerProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuVerProductoActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuVerProducto);

        jMenuVerProdOrd.setText("Ver Producto Ordenes");
        jMenuVerProdOrd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuVerProdOrdActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuVerProdOrd);

        AGNO.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "PERIODO VENCIMIENTO", 0, 0, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        cboAgno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2015", "2016", "2017", "2018", "2019", "2020" }));
        cboAgno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboAgnoMouseClicked(evt);
            }
        });
        cboAgno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboAgnoActionPerformed(evt);
            }
        });

        cboMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cboMes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboMesMouseClicked(evt);
            }
        });
        cboMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMesActionPerformed(evt);
            }
        });

        lblAgno.setText("AÑO:");

        jLabel8.setText("MES:");

        btExcel.setText("Exportar Detalle  Facturas");
        btExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcelActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("FACTURAS"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Nro Registros:");

        lbReg.setText("0.00");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Total");

        lbTotal.setText("0.00");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nro Registros:");

        lbRegDet.setText("0.00");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Total Ventas");

        lbTotalVtasDet.setText("0.00");

        Grilla_Det.setAutoCreateRowSorter(true);
        Grilla_Det.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sku", "Nom", "$ Costo Promedio", "$ Unitario", "Tipo Docto", "Fecha Emision", "Nro Docto", "Margen", "Total Vta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Grilla_Det.setComponentPopupMenu(jPopupMenu1);
        Grilla_Det.getTableHeader().setReorderingAllowed(false);
        Grilla_Det.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Grilla_DetMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Grilla_Det);
        if (Grilla_Det.getColumnModel().getColumnCount() > 0) {
            Grilla_Det.getColumnModel().getColumn(0).setMinWidth(75);
            Grilla_Det.getColumnModel().getColumn(0).setPreferredWidth(75);
            Grilla_Det.getColumnModel().getColumn(0).setMaxWidth(75);
            Grilla_Det.getColumnModel().getColumn(1).setMinWidth(60);
            Grilla_Det.getColumnModel().getColumn(1).setPreferredWidth(60);
            Grilla_Det.getColumnModel().getColumn(1).setMaxWidth(400);
            Grilla_Det.getColumnModel().getColumn(2).setMinWidth(80);
            Grilla_Det.getColumnModel().getColumn(2).setPreferredWidth(80);
            Grilla_Det.getColumnModel().getColumn(2).setMaxWidth(80);
            Grilla_Det.getColumnModel().getColumn(3).setMinWidth(80);
            Grilla_Det.getColumnModel().getColumn(3).setPreferredWidth(80);
            Grilla_Det.getColumnModel().getColumn(3).setMaxWidth(80);
            Grilla_Det.getColumnModel().getColumn(4).setMinWidth(40);
            Grilla_Det.getColumnModel().getColumn(4).setPreferredWidth(40);
            Grilla_Det.getColumnModel().getColumn(4).setMaxWidth(40);
            Grilla_Det.getColumnModel().getColumn(5).setMinWidth(80);
            Grilla_Det.getColumnModel().getColumn(5).setPreferredWidth(80);
            Grilla_Det.getColumnModel().getColumn(5).setMaxWidth(80);
            Grilla_Det.getColumnModel().getColumn(6).setMinWidth(80);
            Grilla_Det.getColumnModel().getColumn(6).setPreferredWidth(80);
            Grilla_Det.getColumnModel().getColumn(6).setMaxWidth(80);
            Grilla_Det.getColumnModel().getColumn(7).setMinWidth(40);
            Grilla_Det.getColumnModel().getColumn(7).setPreferredWidth(40);
            Grilla_Det.getColumnModel().getColumn(7).setMaxWidth(40);
            Grilla_Det.getColumnModel().getColumn(8).setMinWidth(80);
            Grilla_Det.getColumnModel().getColumn(8).setPreferredWidth(80);
            Grilla_Det.getColumnModel().getColumn(8).setMaxWidth(80);
        }

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Marg.");

        lbMargFAC.setText("0.00");

        Grilla.setAutoCreateRowSorter(true);
        Grilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Cod", "Convenio", "Margen", "Total", "Pond"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
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
        });
        jScrollPane4.setViewportView(Grilla);
        if (Grilla.getColumnModel().getColumnCount() > 0) {
            Grilla.getColumnModel().getColumn(0).setMinWidth(50);
            Grilla.getColumnModel().getColumn(0).setPreferredWidth(50);
            Grilla.getColumnModel().getColumn(0).setMaxWidth(50);
            Grilla.getColumnModel().getColumn(1).setMinWidth(300);
            Grilla.getColumnModel().getColumn(1).setPreferredWidth(300);
            Grilla.getColumnModel().getColumn(1).setMaxWidth(300);
            Grilla.getColumnModel().getColumn(2).setMinWidth(60);
            Grilla.getColumnModel().getColumn(2).setPreferredWidth(60);
            Grilla.getColumnModel().getColumn(2).setMaxWidth(60);
            Grilla.getColumnModel().getColumn(3).setMinWidth(100);
            Grilla.getColumnModel().getColumn(3).setPreferredWidth(100);
            Grilla.getColumnModel().getColumn(3).setMaxWidth(100);
            Grilla.getColumnModel().getColumn(4).setMinWidth(60);
            Grilla.getColumnModel().getColumn(4).setPreferredWidth(60);
            Grilla.getColumnModel().getColumn(4).setMaxWidth(60);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lbReg, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbMargFAC, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbRegDet, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(lbTotalVtasDet, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(lbMargFAC))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4)
                        .addComponent(lbRegDet)
                        .addComponent(lbTotalVtasDet))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(lbTotal))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(lbReg)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("ORDENES"));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Nro Registros:");

        lbRegDet4.setText("0.00");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Total Ventas");

        lbTotalVtasDet4.setText("0.00");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Nro Registros:");

        lbRegC.setText("0.00");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Total");

        lbTotalC.setText("0.00");

        GrillaC.setAutoCreateRowSorter(true);
        GrillaC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Cod", "Convenio", "Margen", "Total", "Pond"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        GrillaC.getTableHeader().setReorderingAllowed(false);
        GrillaC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GrillaCMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(GrillaC);
        if (GrillaC.getColumnModel().getColumnCount() > 0) {
            GrillaC.getColumnModel().getColumn(0).setMinWidth(50);
            GrillaC.getColumnModel().getColumn(0).setPreferredWidth(50);
            GrillaC.getColumnModel().getColumn(0).setMaxWidth(50);
            GrillaC.getColumnModel().getColumn(1).setMinWidth(300);
            GrillaC.getColumnModel().getColumn(1).setPreferredWidth(300);
            GrillaC.getColumnModel().getColumn(1).setMaxWidth(300);
            GrillaC.getColumnModel().getColumn(2).setMinWidth(60);
            GrillaC.getColumnModel().getColumn(2).setPreferredWidth(60);
            GrillaC.getColumnModel().getColumn(2).setMaxWidth(60);
            GrillaC.getColumnModel().getColumn(3).setMinWidth(100);
            GrillaC.getColumnModel().getColumn(3).setPreferredWidth(100);
            GrillaC.getColumnModel().getColumn(3).setMaxWidth(100);
            GrillaC.getColumnModel().getColumn(4).setMinWidth(60);
            GrillaC.getColumnModel().getColumn(4).setPreferredWidth(60);
            GrillaC.getColumnModel().getColumn(4).setMaxWidth(60);
        }

        Grilla_Det4.setAutoCreateRowSorter(true);
        Grilla_Det4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sku", "Nom", "$ Costo Promedio", "$ Unitario", "Fecha Emision", "Nro Docto", "Margen", "Total Vta", "Rut", "Codigo_oc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Grilla_Det4.setComponentPopupMenu(jPopupMenu2);
        Grilla_Det4.getTableHeader().setReorderingAllowed(false);
        Grilla_Det4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Grilla_Det4MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(Grilla_Det4);
        if (Grilla_Det4.getColumnModel().getColumnCount() > 0) {
            Grilla_Det4.getColumnModel().getColumn(0).setMinWidth(75);
            Grilla_Det4.getColumnModel().getColumn(0).setPreferredWidth(75);
            Grilla_Det4.getColumnModel().getColumn(0).setMaxWidth(75);
            Grilla_Det4.getColumnModel().getColumn(1).setMinWidth(60);
            Grilla_Det4.getColumnModel().getColumn(1).setPreferredWidth(60);
            Grilla_Det4.getColumnModel().getColumn(1).setMaxWidth(400);
            Grilla_Det4.getColumnModel().getColumn(2).setMinWidth(80);
            Grilla_Det4.getColumnModel().getColumn(2).setPreferredWidth(80);
            Grilla_Det4.getColumnModel().getColumn(2).setMaxWidth(80);
            Grilla_Det4.getColumnModel().getColumn(3).setMinWidth(80);
            Grilla_Det4.getColumnModel().getColumn(3).setPreferredWidth(80);
            Grilla_Det4.getColumnModel().getColumn(3).setMaxWidth(80);
            Grilla_Det4.getColumnModel().getColumn(4).setMinWidth(80);
            Grilla_Det4.getColumnModel().getColumn(4).setPreferredWidth(80);
            Grilla_Det4.getColumnModel().getColumn(4).setMaxWidth(80);
            Grilla_Det4.getColumnModel().getColumn(5).setMinWidth(80);
            Grilla_Det4.getColumnModel().getColumn(5).setPreferredWidth(80);
            Grilla_Det4.getColumnModel().getColumn(5).setMaxWidth(80);
            Grilla_Det4.getColumnModel().getColumn(6).setMinWidth(40);
            Grilla_Det4.getColumnModel().getColumn(6).setPreferredWidth(40);
            Grilla_Det4.getColumnModel().getColumn(6).setMaxWidth(40);
            Grilla_Det4.getColumnModel().getColumn(7).setMinWidth(80);
            Grilla_Det4.getColumnModel().getColumn(7).setPreferredWidth(80);
            Grilla_Det4.getColumnModel().getColumn(7).setMaxWidth(80);
            Grilla_Det4.getColumnModel().getColumn(8).setMinWidth(0);
            Grilla_Det4.getColumnModel().getColumn(8).setPreferredWidth(0);
            Grilla_Det4.getColumnModel().getColumn(8).setMaxWidth(0);
            Grilla_Det4.getColumnModel().getColumn(9).setMinWidth(0);
            Grilla_Det4.getColumnModel().getColumn(9).setPreferredWidth(0);
            Grilla_Det4.getColumnModel().getColumn(9).setMaxWidth(0);
        }

        lbmar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbmar.setText("Marg.");

        lblMargen.setText("0.00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(34, 34, 34)
                        .addComponent(lbRegC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTotalC, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbmar)
                        .addGap(18, 18, 18)
                        .addComponent(lblMargen, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbRegDet4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(lbTotalVtasDet4, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(jLabel14)
                        .addComponent(lbTotalVtasDet4)
                        .addComponent(lbRegDet4))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(lbRegC)
                        .addComponent(jLabel6)
                        .addComponent(lbTotalC)
                        .addComponent(lbmar)
                        .addComponent(lblMargen)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 19, Short.MAX_VALUE))
        );

        btBuscar.setText("Buscar Fact.");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        btExcelOr.setText("Exportar Detalle  Ordenes");
        btExcelOr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcelOrActionPerformed(evt);
            }
        });

        cboAgno1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2015", "2016", "2017", "2018", "2019", "2020" }));
        cboAgno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboAgno1ActionPerformed(evt);
            }
        });

        cboMes1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cboMes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMes1ActionPerformed(evt);
            }
        });

        chk_oc.setText("OC");
        chk_oc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_ocActionPerformed(evt);
            }
        });

        chk_ECONA.setSelected(true);
        chk_ECONA.setText("ECONA");

        javax.swing.GroupLayout AGNOLayout = new javax.swing.GroupLayout(AGNO);
        AGNO.setLayout(AGNOLayout);
        AGNOLayout.setHorizontalGroup(
            AGNOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AGNOLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(AGNOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAgno)
                    .addComponent(jLabel8))
                .addGap(37, 37, 37)
                .addGroup(AGNOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboMes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboAgno, 0, 70, Short.MAX_VALUE))
                .addGap(46, 46, 46)
                .addComponent(chk_ECONA)
                .addGap(80, 80, 80)
                .addComponent(chk_oc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AGNOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboMes1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboAgno1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btExcel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btExcelOr)
                .addGap(97, 97, 97))
            .addGroup(AGNOLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AGNOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        AGNOLayout.setVerticalGroup(
            AGNOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AGNOLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AGNOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AGNOLayout.createSequentialGroup()
                        .addGroup(AGNOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboAgno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAgno)
                            .addComponent(chk_ECONA))
                        .addGroup(AGNOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AGNOLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(AGNOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btExcel)
                                    .addComponent(btBuscar)
                                    .addComponent(btExcelOr)))
                            .addGroup(AGNOLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(AGNOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(cboMes, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(AGNOLayout.createSequentialGroup()
                        .addGroup(AGNOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chk_oc)
                            .addComponent(cboAgno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboMes1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleDescription("xczvxzvczxvcz");
        chk_oc.getAccessibleContext().setAccessibleParent(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AGNO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(AGNO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 32, Short.MAX_VALUE))
        );

        AGNO.getAccessibleContext().setAccessibleName("PERIODO VENCIMIENTO1");
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        ExeSql Sql = new ExeSql();
        ResultSet Rs,Rs1;
        String Query, QTot="";
        String NombrePersonal;
        DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
        DefaultTableModel temp = (DefaultTableModel) Grilla_Det.getModel();
//         DefaultTableModel TableGrillaC = (DefaultTableModel) GrillaC.getModel();     
//        DefaultTableModel TableModel2 = (DefaultTableModel) Grilla_Det.getModel();

        int ContPagos      =    0;
        double Total       = 0.00;
        double Margen      = 0.00;
        double ponderado   = 0.00;
        double Total_P     = 0.00;
        double Total_Linea = 0.00;
       
 System.out.println( "1- Inicio Buscar");

fmMain.LimpiaGrilla(TableModel);

System.out.println( "2- Limpia Grilla");
try {

Entra=false;    
Query = "select base.codigo,base.convenio,avg(base.Margen) margen ,SUM(base.totalVta) total from (\n" +
"          select conv.codigo,conv.convenio as convenio,\n" +
"           ((d.valorunitario - p.costopromedio) / d.valorunitario) * 100 as Margen,\n" +
//"           ((d.valorunitario - p.costofinal) / d.valorunitario) * 100 as Margen,\n" +        
"           (sum(d.cantidad)) * d.valorunitario as totalVta\n" +
"          from ctactecli c\n" +
"               left join ctacteclidet d on c.rut = d.rut and c.tipdocto = d.tipdocto and\n" +
"                c.nrodocto = d.nrodocto\n" +
"               left join producto p on d.sku = p.sku\n" +
"               left join par_convenio conv on conv.codigo = p.convenio\n";

     if (chk_oc.isSelected()){
     Query = Query + "  left join occh oc \n" +
"               		on oc.rut = c.rut and \n" +
"                    oc.codigo_oc = c.codigo_oc and \n" +
"                    oc.orden = c.occh";
        }
    Query = Query + "          where \n" +
"          extract(year from c.femision) =" + cboAgno.getSelectedItem().toString() + " and \n" +
"          extract(month from c.femision) =" + cboMes.getSelectedItem().toString() + " and \n";

    
    if (!chk_ECONA.isSelected()){
        Query = Query + " c.rut <> " + StrEcona + " and \n";
    }
    
    
         if (chk_oc.isSelected()){
        Query = Query + "          extract(year from oc.femision) =" + cboAgno1.getSelectedItem().toString() + " and \n" +
        "          extract(month from oc.femision) =" + cboMes1.getSelectedItem().toString() + " and \n";
         }       
        
Query = Query + "          c.tipdocto in ('FAC', 'FEC') and \n" +
"          conv.convenio is  not null\n" +
"          group by conv.codigo,conv.convenio,\n" +
"                   d.sku,\n" +
"                   p.nombre,\n" +
"                   p.valultcompra,\n" +
//"                   p.costofinal,\n" +
"                   p.costopromedio,\n" +
"                   d.valorunitario,\n" +
"                   c.tipdocto,\n" +
"                   c.nrodocto) base\n" +
"   group by codigo,convenio                \n" +
" order by codigo,convenio   ";



QTot =" select \n" +
"          SUM(d.cantidad * d.valorunitario) as totalVta\n" +
"          from ctactecli c\n" +
"               left join ctacteclidet d on c.rut = d.rut and c.tipdocto = d.tipdocto and\n" +
"                c.nrodocto = d.nrodocto\n" +
"               left join producto p on d.sku = p.sku\n" +
"               left join par_convenio conv on conv.codigo = p.convenio\n";
    if (chk_oc.isSelected()){
     QTot = QTot + "  left join occh oc \n" +
"               		on oc.rut = c.rut and \n" +
"                    oc.codigo_oc = c.codigo_oc and \n" +
"                    oc.orden = c.occh";
        }
QTot = QTot + "          where \n" +
"          extract(year from c.femision) =" + cboAgno.getSelectedItem().toString() + " and \n" +
"          extract(month from c.femision) =" + cboMes.getSelectedItem().toString() + " and \n";

     if (chk_oc.isSelected()){
        QTot = QTot + "  extract(year from oc.femision) =" + cboAgno1.getSelectedItem().toString() + " and \n" +
        "          extract(month from oc.femision) =" + cboMes1.getSelectedItem().toString() + " and \n";
         }       

QTot = QTot + " c.tipdocto in ('FAC', 'FEC') and \n" +
"          conv.convenio is  not null";

System.out.println( "3- Querys seteados");

Entra=true;
Rs1 = Sql.Select(QTot);

 if ( Rs1.next()){
      Total_P= Rs1.getDouble("totalVta"); 
    }
      else {
          Total_P =0.00;  
    }     
       
System.out.println( "4- Totales Seteados");  
System.out.println( "5- Limpia Grilla");  
 fmMain.LimpiaGrilla(TableModel);

  // EJECUTA CONSULTA
            Rs = Sql.Select(Query);
            
            while(Rs.next()){
               ContPagos++;
               Total  = Total+ Rs.getDouble("total");   
               Margen = Margen +  (Rs.getDouble("margen")* Rs.getDouble("total"))/Total_P;
               Total_Linea = (Rs.getDouble("total") / Total_P)*100;
               System.out.println( "6- Preparado para llenar Grilla");  
               TableModel.addRow(new Object[]{Rs.getString("codigo").trim(), 
                                              Rs.getString("convenio").trim(), 
                                              fmMain.FormatoNumero(Rs.getDouble("margen")), 
                                              fmMain.FormatoNumero(Rs.getDouble("total")),
                                              fmMain.FormatoNumero(Total_Linea)  });
                                              System.out.println( "Fila Seleccionada : " +  Grilla.getSelectedRow());
                                              System.out.println( "Fila Ingresada : " +  ContPagos);
              }
             System.out.println( "6- Grilla Llenada");     
            if (ContPagos ==0){
                        System.out.println( "7- Limpia Grillas y campos porque no se lleno nada");     
                       fmMain.LimpiaGrilla(TableModel);
                       fmMain.LimpiaGrilla(temp);
                       lbMargFAC.setText(fmMain.FormatoNumero(0));;
                       lbTotal.setText(fmMain.FormatoNumero(0));
                       lbReg.setText(fmMain.FormatoTotal(0));
                       lbRegDet.setText(fmMain.FormatoTotal(0));
                       lbTotalVtasDet.setText(fmMain.FormatoTotal(0));
                       fmMain.Mensaje("No existe Información en Facturas");
             }
            else  if (ContPagos >0) {
                  System.out.println( "7- Grilla con Datos se posiciona en la primera Fila");     
                  //fmMain.Mensaje("Fila: " + Grilla.getSelectedRow());
                 Grilla.changeSelection(0, 0 , false, false);
                 click_grilla_factura();
                 //fmMain.Mensaje("Fila: " + Grilla.getSelectedRow());
//                 Margen = Margen / ContPagos;
                  lbMargFAC.setText( fmMain.FormatoNumero(Margen));
                
                  
                  
            }
            
            Rs.close();
            
                lbTotal.setText(fmMain.FormatoNumero(Total));
                lbReg.setText(fmMain.FormatoTotal(ContPagos));
                
               carga_costopromedio();   
               //Grilla.changeSelection(0, 0 , false, false);
  }
catch (Exception e) {
            fmMain.Mensaje("Existe una inconsistencia en la información.");
        }finally{
            Sql.Close();
        }   
    }//GEN-LAST:event_btBuscarActionPerformed


void limpiaTablaEncabezadoFAC(){
        try{
            DefaultTableModel temp = (DefaultTableModel) Grilla.getModel();
            int a =temp.getRowCount()-1;
            for(int i=0; i<=a; i++)
                temp.removeRow(0); //aquí estaba el error, antes pasaba la i como parametro.... soy un bacín  XD
        }catch(Exception e){
            System.out.println(e);
        }
    }    
    void limpiaTablaEncabezadoFACDetalle(){
        try{
            DefaultTableModel temp = (DefaultTableModel) Grilla_Det.getModel();
//            int a =temp.getRowCount()-1;
//            for(int i=0; i<=a; i++)
//                temp.removeRow(0); //aquí estaba el error, antes pasaba la i como parametro.... soy un bacín  XD
            temp.setRowCount(0);
        }catch(Exception e){
            System.out.println(e);
        }
    }   
    
    
    void limpiaTablaEncabezadoOrdenes(){
        try{
            DefaultTableModel temp = (DefaultTableModel) GrillaC.getModel();
//            int a =temp.getRowCount()-1;
//            for(int i=0; i<=a; i++)
//                temp.removeRow(0); //aquí estaba el error, antes pasaba la i como parametro.... soy un bacín  XD
            temp.setRowCount(0);
        }catch(Exception e){
             System.out.println(e);
        }
    }    
    void limpiaTablaEncabezadoOrdenesDet(){
        try{
            DefaultTableModel temp = (DefaultTableModel) Grilla_Det4.getModel();
//            temp.setColumnCount(0);
//            temp.setRowCount(0);
            
//            int a =temp.getRowCount()-1;
//            for(int i=0; i<=a; i++)
//                temp.removeRow(0); //aquí estaba el error, antes pasaba la i como parametro.... soy un bacín  XD
            temp.setRowCount(0);
 
        }catch(Exception e){
            System.out.println(e);
        }
    }   
    
    
    

    
    
    public void carga_costopromedio(){
        
//    Creado por: Cristian Ramìrez    
//    Fecha: 27-01.2016    
//    Objetivo:Resumen de Costo Promedio agrupado por convenio con respecto a las ordenes de compra realizadas.
    
    
    
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        ResultSet Rs1;
        String Query="";
        String QTot="";
        String NombrePersonal;
        double Total_P         = 0.00;
        double Total_Linea     = 0.00;
        DefaultTableModel TableModel = (DefaultTableModel) GrillaC.getModel();
        limpiaTablaEncabezadoOrdenes();          
        int ContPagos_Det   =    0;
        double Total_Det    = 0.00;
        double Margen       = 0.00;
 try {
                    Query="select base.codigo,base.convenio,avg(base.Margen) margen ,SUM(base.totalVta) total from (\n" +
                   "          select conv.codigo,conv.convenio as convenio,\n" +
                   "           ((d.valorunitario - p.costopromedio) / d.valorunitario) * 100 as Margen,\n" +                           
                   "           (sum(d.cantidad)) * d.valorunitario as totalVta\n" +
                   "          from occh c\n" +
                   "         left join occhdet d on c.rut = d.rut and \n" +
                   "          lower(c.orden) = lower(d.orden) \n" +
                   "          and  c.codigo_oc   = d.codigo_oc\n" +
                   "     left join producto p on d.sku = p.sku\n" +
                   "     left join par_convenio conv on conv.codigo = p.convenio\n" +
                   "          where \n" +
                   "          extract(year from c.femision) =" + cboAgno.getSelectedItem().toString() + " and \n";
                        if (!chk_ECONA.isSelected()){
                            Query = Query + " c.rut <> " + StrEcona + " and \n";
                        }
                   Query = Query + " extract(month from c.femision) =" + cboMes.getSelectedItem().toString() + " and \n"+
                   "          conv.convenio is  not null\n" +
                   "          group by conv.codigo,conv.convenio,\n" +
                   "                   d.sku,\n" +
                   "                   p.nombre,\n" +
                   "                   p.costopromedio,\n" +
//                   "                   p.costofinal,\n" +
                   "                   d.valorunitario,\n" +
                   "                   c.orden) base\n" +
                   "   group by codigo,convenio     " +
                   "  order by codigo,convenio";


QTot = "  select tabla.totalvta from\n" +
"         (select SUM(d.cantidad * d.valorunitario) totalvta\n" +
"         from occh c\n" +
"              left join occhdet d on c.rut = d.rut and \n" +
"                lower(c.orden) = lower(d.orden) and\n" +
"                c.codigo_oc = d.codigo_oc\n" +
"              left join producto p on \n" +
"              	d.sku = p.sku\n" +
"              left join par_convenio conv on conv.codigo = p.convenio\n" +
"         where \n" +
"          extract(year from c.femision) =" + cboAgno.getSelectedItem().toString() + " and \n" +
"          extract(month from c.femision) =" + cboMes.getSelectedItem().toString() + " and \n"+
"         conv.convenio is not null) tabla";

//QTot="  select tabla.totalvta from\n" +
//"         (select SUM(d.cantidad * d.valorunitario) totalvta\n" +
//"         from occh c\n" +
//"              left join occhdet d \n" +
//"          		on upper(trim(c.rut|| '-' || c.codigo_oc || '-' || c.orden)) = upper(trim(d.rut|| '-' || d.codigo_oc || '-' || d.orden))\n" +
//"              left join producto p on \n" +
//"              	d.sku = p.sku\n" +
//"              left join par_convenio conv on conv.codigo = p.convenio\n" +
//"         where \n" +
//"          extract(year from c.femision) =" + cboAgno.getSelectedItem().toString() + " and \n" +
//"          extract(month from c.femision) =" + cboMes.getSelectedItem().toString() + " and \n"+
//"         conv.convenio is not null) tabla";


  Rs1 = Sql.Select(QTot);
  
 
 if ( Rs1.next()){
      Total_P= Rs1.getDouble("totalvta"); 
          }
      else {
          Total_P =0.00;  
    }     
      

//             
////     Limpia Ordenes Encabezado   
//               while(TableModel.getRowCount()>0)
//                   TableModel.removeRow(0);    
               
TableModel.setRowCount(0);
               
            
     
  // EJECUTA CONSULTA
            Rs = Sql.Select(Query);        
            while(Rs.next()){
               ContPagos_Det++;
               Total_Det  = Total_Det + Rs.getDouble("total");
               Total_Linea = (Rs.getDouble("total") / Total_P)*100;
//               Margen = Margen +  Rs.getDouble("margen");
                Margen = Margen +  (Rs.getDouble("margen")* Rs.getFloat("total"))/Total_P;
                
               TableModel.addRow(new Object[]{Rs.getString("codigo").trim(), 
                                              Rs.getString("convenio").trim(), 
                                              fmMain.FormatoNumero(Rs.getFloat("margen")), 
                                              fmMain.FormatoNumero(Rs.getDouble("total")),
                                              fmMain.FormatoNumero(Total_Linea)});
              }
             if (ContPagos_Det ==0){
                limpiaTablaEncabezadoOrdenes();
                limpiaTablaEncabezadoOrdenesDet();
                lbTotalC.setText(fmMain.FormatoNumero(0));
                lbRegC.setText(fmMain.FormatoTotal(0));
                lblMargen.setText(fmMain.FormatoNumero(0.00));
                lbRegDet4.setText(fmMain.FormatoTotal(0));
                lbTotalVtasDet4.setText(fmMain.FormatoTotal(0));
                 fmMain.Mensaje("No existe Información en Ordenes");
       
            }
            else  if (ContPagos_Det >0) {
                 GrillaC.changeSelection(0, 0 , false, false);
                 click_grilla_ordenes();
//                 Margen= Margen / ContPagos_Det;
                 lblMargen.setText(fmMain.FormatoNumero(Margen));
            }
          
            lbTotalC.setText(fmMain.FormatoNumero(Total_Det));
            lbRegC.setText(fmMain.FormatoTotal(ContPagos_Det));
            
            Rs.close();
            //Rs1.close();
     }
catch (Exception e) {
            fmMain.Mensaje("Existe una inconsistencia en la información.");
        }finally{
            Sql.Close();
         
            
        }
       
}
  
 public void CargaDetMargen(String convenio){
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        DefaultTableModel TableModel = (DefaultTableModel) Grilla_Det.getModel();
        double Sumador = 0.00;
        double Margen  = 0.00;
        String Query ="";    
        int ano,ano2,mes, mes2 =0;
        
        int ContReg=0;
//         while(TableModel.getRowCount()>0)
//             TableModel.removeRow(0);
       ano =  Integer.valueOf(cboAgno.getSelectedItem().toString());
       
       mes =  Integer.valueOf(cboMes.getSelectedItem().toString());
       
        try {
//            Query = "     select \n" +
//"                   conv.codigo,"+ 
//"                   conv.convenio as convenio,\n" +
//"                   d.sku,\n" +
//"                   p.nombre,\n" +
//"                   p.valultcompra,\n" +
//"                   p.costopromedio,\n" +
//"                   d.valorunitario,\n" +
//"                   c.tipdocto,\n" +
//"                   c.femision,\n" +
//"                   c.nrodocto, \n" +
//"                  ((d.valorunitario - p.valultcompra) / d.valorunitario) * 100 as Margen,\n" +
//"          	   (sum(d.cantidad)) * d.valorunitario as totalVta\n" +
//"          from ctactecli c\n" +
//"               left join ctacteclidet d on c.rut = d.rut and c.tipdocto = d.tipdocto and\n" +
//"                c.nrodocto = d.nrodocto\n" +
//"               left join producto p on d.sku = p.sku\n" +
//"               left join par_convenio conv on conv.codigo = p.convenio\n" +
//"          where \n" +
//"          extract(year from c.femision) =" + cboAgno.getSelectedItem().toString() + " and \n" +
//"          extract(month from c.femision) =" + cboMes.getSelectedItem().toString() + " and \n"+
//"          c.tipdocto in ('FAC', 'FEC') and \n" +
//"          conv.convenio is  not null    \n" +
//"           group by     \n" +
//"                   conv.codigo,conv.convenio,\n" +
//"                   d.sku,\n" +
//"                   p.nombre,\n" +
//"                   p.valultcompra,\n" +
//"                   p.costopromedio,\n" +
//"                   d.valorunitario,\n" +
//"                   c.tipdocto,\n" +
//"                   c.nrodocto,\n" +
//"                   c.femision\n" +
//"     having   conv.codigo = " + convenio; 
            
            
            Query = "  select \n" +
"                   conv.codigo,"+ 
"                   conv.convenio as convenio,\n" +
"                   d.sku,\n" +
"                   p.nombre,\n" +
"                   p.valultcompra,\n" +
"                   p.costopromedio,\n" +
"                   d.valorunitario,\n" +
"                   c.tipdocto,\n" +
"                   c.femision,\n" +
"                   c.nrodocto, \n" +
"                  ((d.valorunitario - p.valultcompra) / d.valorunitario) * 100 as Margen,\n" +
"          	   d.cantidad * d.valorunitario as totalVta\n" +
"           from ctactecli c\n" +
"               left join ctacteclidet d on c.rut = d.rut and c.tipdocto = d.tipdocto and\n" +
"                c.nrodocto = d.nrodocto\n" +
"               left join producto p on d.sku = p.sku\n" +
"               left join par_convenio conv on conv.codigo = p.convenio\n" +
"           where \n";
//"           extract(year from c.femision) =" + cboAgno.getSelectedItem().toString() + " and \n" +
//"           extract(month from c.femision) =" + cboMes.getSelectedItem().toString() + " and \n"+
         if (mes == 12)
         {
             ano2= ano+1;    
             Query = Query +  " c.femision >= '01/" + mes + "/" + ano + "' and \n";
                    Query = Query + " c.femision < '01/01/" +  ano2 + "'  and";
         }
         else
         {
             mes2= mes+1;    
             Query = Query +  " c.femision >= '01/" + mes + "/" + ano + "' and \n";
                    Query = Query + " c.femision < '01/" + mes2 + "/" +  ano + "'  and";
         }
         
    if (!chk_ECONA.isSelected()){
        Query = Query + " c.rut <> " + StrEcona + " and \n";
    }
    
Query = Query + "  c.tipdocto in ('FAC', 'FEC') and \n" +
"           conv.convenio is  not null    \n" +
"           and  conv.codigo = " + convenio;             

            System.out.println("1- Genera Recordset");
            Rs = Sql.Select(Query);
            fmMain.LimpiaGrilla(TableModel);
            System.out.println("2- Limpia Grilla y Recordset completo");
            while (Rs.next()){
                ContReg++;
                        TableModel.addRow(new Object[]{
                                               Rs.getString("sku").trim(),
                                               Rs.getString("nombre").trim(), 
                                               fmMain.FormatoNumero(Rs.getDouble("costopromedio")),
                                               fmMain.FormatoNumero(Rs.getDouble("valorunitario")),
                                               Rs.getString("tipdocto").trim(), 
                                               Rs.getString("femision").trim(), 
                                               fmMain.FormatoNumero(Rs.getDouble("nrodocto")),
                                                fmMain.FormatoTotal(Rs.getDouble("Margen")),
                                               fmMain.FormatoTotal(Rs.getDouble("totalVta"))});
                Sumador = Sumador + Rs.getDouble("totalVta");
               }
                  System.out.println("3- Termino de llenar Grilla");
                lbTotalVtasDet.setText(fmMain.FormatoNumero(Sumador));
                lbRegDet.setText(fmMain.FormatoTotal(ContReg));
                Grilla_Det.changeSelection(0, 0 , false, false);
        } catch (Exception e) {
              System.out.println("4- Se genero una excepcion: " + e);
              
        } finally{
               System.out.println("5- Sql-close");   
            Sql.Close();
        }
        
    }   
    
    public void CargaDetMargenOrdenes(String  convenio){
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        String  Query = " ";
        DefaultTableModel TableModel = (DefaultTableModel) Grilla_Det4.getModel();
        double Sumador=0;
        int ContReg=0;
        int ano,ano2,mes,mes2=0;
        
        System.out.println("1- Llenado de Grilla ");
        System.out.println("1- Limpia Grilla Detalle Ordenes");
        fmMain.LimpiaGrilla(TableModel);
        System.out.println("2- Grilla Limpiada");

       ano =  Integer.valueOf(cboAgno.getSelectedItem().toString());
       mes =  Integer.valueOf(cboMes.getSelectedItem().toString());
        
        
        try {
                if(convenio!="" ){

            Query = "   select \n" +
                "                   conv.codigo,\n" +
                "                   d.sku,\n" +
                "                   p.nombre,\n" +
                "                   d.valorunitario,\n" +        
                "                   p.valultcompra,\n" +
                "                   p.costopromedio,\n" +
                "                   c.femision,\n" +
                "                   c.orden, \n" +
                "                  ((d.valorunitario - p.costopromedio) / d.valorunitario) * 100 as Margen,\n" +
                "          	   (d.cantidad) * d.valorunitario as totalVta,\n" +
                "                   c.rut, c.codigo_oc \n" +               
                "         from occh c\n" +
                "         left join occhdet d on d.rut = c.rut and \n" +
                "          d.orden = c.orden \n" +
                "          and  d.codigo_oc   = c.codigo_oc\n" +
                "     left join producto p on p.sku = d.sku\n" +
                "     left join par_convenio conv on conv.codigo = p.convenio\n" +
                "          where \n" +
                "          extract(year from c.femision) =" + cboAgno.getSelectedItem().toString() + " and \n" +
                "          extract(month from c.femision) =" + cboMes.getSelectedItem().toString() + " and \n";
            
            if (!chk_ECONA.isSelected()){
                    Query = Query + " c.rut <> " + StrEcona + " and \n";
            }
            
                    
//         if (mes == 12)
//         {
//             ano2= ano+1;    
//             Query = Query +  " c.femision >= '01/" + mes + "/" + ano + "' and \n";
//                    Query = Query + " c.femision < '01/01/" +  ano2 + "'  and";
//         }
//         else
//         {
//             mes2= mes+1;    
//             Query = Query +  " c.femision >= '01/" + mes + "/" + ano + "' and \n";
//                    Query = Query + " c.femision < '01/" + mes2 + "/" +  ano + "'  and";
//         }    
                Query = Query + " conv.convenio is  not null\n" +
                "     and conv.codigo =" + convenio ;                
                }
                System.out.println("3. Query Asignado");
            Rs = Sql.Select(Query );
            System.out.println("4. RS Asignado");
//limpiaTablaEncabezadoOrdenesDet();
//                while(TableModel.getRowCount()>0)
//                    TableModel.removeRow(0);
//            TableModel.setRowCount(0);
            ContReg=0;    
            while (Rs.next()){
                ContReg++;
                        TableModel.addRow(new Object[]{
                                               Rs.getString("sku").trim(),
                                               Rs.getString("nombre").trim(), 
                                               fmMain.FormatoNumero(Rs.getDouble("costopromedio")),
                                               fmMain.FormatoNumero(Rs.getDouble("valorunitario")),
                                               Rs.getString("femision").trim(), 
                                               Rs.getString("orden").trim(), 
                                               fmMain.FormatoTotal(Rs.getDouble("Margen")),
                                               fmMain.FormatoTotal(Rs.getDouble("totalVta")),
                                               fmMain.FormatoTotal(Rs.getDouble("Rut")),
                                               fmMain.FormatoTotal(Rs.getInt("codigo_oc"))});
                Sumador = Sumador + Rs.getDouble("totalVta");
                
               }
         
              if (ContReg ==0){
                  
                  System.out.println("4. RS Asignado");
                  System.out.println("5 . Limpia Grilla para llenar");
                  fmMain.LimpiaGrilla(TableModel);
                   System.out.println("6 . Grilla Limpiada");
            }
            else  if (ContReg >0) {
                
                 Grilla_Det4.changeSelection(0, 0 , false, false);
                  System.out.println("7 . Si tiene Datos se posiciona en la fila: " + Grilla_Det4.getSelectedRow());
            }
             
            lbTotalVtasDet4.setText(fmMain.FormatoNumero(Sumador));
            lbRegDet4.setText(fmMain.FormatoTotal(ContReg));

          
        } catch (Exception e) {
          
        } finally{
            Sql.Close();
        }
        
    }
    
    private void jMenuVerProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuVerProductoActionPerformed
        System.out.println( Grilla_Det.getValueAt(Grilla_Det.getSelectedRow(), 2).toString().trim());
        pfProductos Pro = new pfProductos();
        Pro.setOpaque(false);
        pnPestanas.addTab("Producto", Pro);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Pro), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
        Pro.txSku.requestFocus();
        Pro.CargaProducto(Grilla_Det.getValueAt(Grilla_Det.getSelectedRow(), 0).toString().trim());        //
    }//GEN-LAST:event_jMenuVerProductoActionPerformed

    private void Grilla_DetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Grilla_DetMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Grilla_DetMouseClicked

    private void btExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcelActionPerformed
        //--------------------------------------------
        if(Grilla_Det.getRowCount()==0){
            fmMain.Mensaje("Nada que exportar");
            return;
        }


            List<JTable> tb=new ArrayList<>();
            List<String> nom=new ArrayList<>();
            
            tb.add(Grilla_Det);
            
            int mes= Integer.valueOf(cboMes.getSelectedItem().toString());
            String Smes ="";
            if (mes <10){
                Smes = "0" + cboMes.getSelectedItem().toString();
            }
            else{
                Smes = cboMes.getSelectedItem().toString();
                }
            
            String Nombre = "Facturas_" + cboAgno.getSelectedItem().toString() + Smes;
            nom.add(Nombre);
            
            File folder = new File("c:/temp");
            if (!folder.exists())
            {
                folder.mkdir();
            }
            
             String file = "C:/temp/Facturas_" +  cboAgno.getSelectedItem().toString() + Smes +".xls";       
            
            
            try {
                Exporter e = new Exporter(new File(file), tb, nom);
                
                if(e.export())
                abrir(file);
                //CargaDetMargenOrdenes(GrillaC.getValueAt(GrillaC.getSelectedRow(), 0).toString().trim());
                fmMain.Mensaje("Datos Exportados");
            } catch (Exception e) {
                fmMain.Mensaje(e.getMessage());
            }

           
        
        
    }//GEN-LAST:event_btExcelActionPerformed
    
    private void cboMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMesActionPerformed
        
      if (Entra) {   
        btBuscar.doClick();
      }
        
        
    }//GEN-LAST:event_cboMesActionPerformed

    private void cboAgnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboAgnoActionPerformed
       
     if (Entra) {   
        btBuscar.doClick();
     }    
    }//GEN-LAST:event_cboAgnoActionPerformed

    private void btExcelOrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcelOrActionPerformed
        

           jdOC_OrdenesCompra OC_Ordenes = new jdOC_OrdenesCompra(null, true);
//            Vouch.Tipo=Tipo;
//            Vouch.Numero=Numero;
//            Vouch.Trans=Trans; 
//            Vouch.Voucher=Voucher;         
//            Vouch.CargaImagen(Tipo, Numero);

              String mes = cboMes.getSelectedItem().toString();
              String ano = cboAgno.getSelectedItem().toString();
                
                OC_Ordenes.setTitle("Año: "+ano +" Mes: "+ mes );
                OC_Ordenes.CargaDetMargenOrdenes(ano,mes);
            
            OC_Ordenes.setLocationRelativeTo(null);
            OC_Ordenes.setVisible(true);
            OC_Ordenes.dispose();  
           
//        CargaDetMargenOrdenes("");
//        if(Grilla_Det4.getRowCount()==0){
//            fmMain.Mensaje("Nada que exportar");
//            return;
//        }
//
//            List<JTable> tb=new ArrayList<>();
//            List<String> nom=new ArrayList<>();
//            
//            tb.add(Grilla_Det4);
//            
//            int mes= Integer.valueOf(cboMes.getSelectedItem().toString());
//            String Smes ="";
//            if (mes <10){
//                Smes = "0" + cboMes.getSelectedItem().toString();
//            }
//            else{
//                Smes = cboMes.getSelectedItem().toString();
//                }
//            
//            String Nombre = "OC_" + cboAgno.getSelectedItem().toString() + Smes;
//            nom.add(Nombre);
//            
//            File folder = new File("c:/temp");
//            if (!folder.exists())
//            {
//                folder.mkdir();
//            }
//            
//             String file = "C:/temp/Ordenes_" +  cboAgno.getSelectedItem().toString() + Smes +".xls";       
//            
//            
//            try {
//                Exporter e = new Exporter(new File(file), tb, nom);
//                
//                if(e.export())
//                abrir(file);
//                CargaDetMargenOrdenes(GrillaC.getValueAt(GrillaC.getSelectedRow(), 0).toString().trim());
//                fmMain.Mensaje("Datos Exportados");
//            } catch (Exception e) {
//                fmMain.Mensaje(e.getMessage());
//            }

           
    }//GEN-LAST:event_btExcelOrActionPerformed

    public void abrir(String file ){
        
       try {
           String url = file;
           ProcessBuilder p = new ProcessBuilder();
           p.command("cmd.exe", "/c",url);
           p.start();
       } catch (IOException ex) {
           Logger.getLogger(jdOC_PendientesFac.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }
    
    
    
    private void Grilla_Det4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Grilla_Det4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Grilla_Det4MouseClicked

    private void GrillaCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrillaCMouseClicked
        // TODO add your handling code here:
          if (Grilla_Det4.getSelectedRowCount()>=0 )
               CargaDetMargenOrdenes(GrillaC.getValueAt(GrillaC.getSelectedRow(), 0).toString().trim());
       
    }//GEN-LAST:event_GrillaCMouseClicked

    
    private void click_grilla_ordenes(){
    if (Grilla_Det4.getSelectedRowCount()>=0 )
               CargaDetMargenOrdenes(GrillaC.getValueAt(GrillaC.getSelectedRow(), 0).toString().trim());
    }
    
    private void jMenuVerProdOrdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuVerProdOrdActionPerformed
        System.out.println( Grilla_Det4.getValueAt(Grilla_Det4.getSelectedRow(), 2).toString().trim());
        pfProductos Pro1 = new pfProductos();
        Pro1.setOpaque(false);
        pnPestanas.addTab("Producto", Pro1);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Pro1), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
        Pro1.txSku.requestFocus();
        Pro1.CargaProducto(Grilla_Det4.getValueAt(Grilla_Det4.getSelectedRow(), 0).toString().trim());         // TODO add your handling code here:
    }//GEN-LAST:event_jMenuVerProdOrdActionPerformed

    private void cboAgno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboAgno1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboAgno1ActionPerformed

    private void cboMes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMes1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboMes1ActionPerformed

    private void chk_ocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_ocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_ocActionPerformed

    private void cboAgnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboAgnoMouseClicked
        // TODO add your handling code here:
        gano=cboAgno.getSelectedItem().toString().trim();
        
    }//GEN-LAST:event_cboAgnoMouseClicked

    private void cboMesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboMesMouseClicked
        // TODO add your handling code here:
        gmes=cboMes.getSelectedItem().toString().trim();
    }//GEN-LAST:event_cboMesMouseClicked

    private void GrillaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrillaMouseClicked
        // TODO add your handling code here:
        if (Grilla.getSelectedRowCount()>=0 )
               CargaDetMargen(Grilla.getValueAt(Grilla.getSelectedRow(), 0).toString().trim());
        
    }//GEN-LAST:event_GrillaMouseClicked
//6700
    
    
    private void click_grilla_factura(){
         if (Grilla.getSelectedRowCount()>=0 )
               CargaDetMargen(Grilla.getValueAt(Grilla.getSelectedRow(), 0).toString().trim());
    }
            

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AGNO;
    private javax.swing.JTable Grilla;
    private javax.swing.JTable GrillaC;
    private javax.swing.JTable Grilla_Det;
    private javax.swing.JTable Grilla_Det4;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btExcel;
    private javax.swing.JButton btExcelOr;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> cboAgno;
    private javax.swing.JComboBox<String> cboAgno1;
    private javax.swing.JComboBox<String> cboMes;
    private javax.swing.JComboBox<String> cboMes1;
    private javax.swing.JCheckBox chk_ECONA;
    private javax.swing.JCheckBox chk_oc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenuVerProdOrd;
    private javax.swing.JMenuItem jMenuVerProducto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JLabel lbMargFAC;
    private javax.swing.JLabel lbReg;
    private javax.swing.JLabel lbRegC;
    private javax.swing.JLabel lbRegDet;
    private javax.swing.JLabel lbRegDet4;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JLabel lbTotalC;
    private javax.swing.JLabel lbTotalVtasDet;
    private javax.swing.JLabel lbTotalVtasDet4;
    private javax.swing.JLabel lblAgno;
    private javax.swing.JLabel lblMargen;
    private javax.swing.JLabel lbmar;
    // End of variables declaration//GEN-END:variables
}
