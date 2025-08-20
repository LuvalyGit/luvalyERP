package PanelForm;

import Conexion.ExeSql;
import Dialogos.jdAbrirDocto;
import Dialogos.jdAbrirOCC;
import Dialogos.jdAbrirOCCDirecto;
import Dialogos.jdAgregaBlog_occ;
import Dialogos.jdAsociaCodChilemat;
import Dialogos.jdAsociaCodPortal;
import Dialogos.jdBuscarCliPrv;
import Dialogos.jdOCCAgregaProducto;
import Dialogos.jdOCCContacto;
import Formularios.fmMain;
import static Formularios.fmMain.pnPestanas;
import Utilidades.ComboCodigos;
import static Utilidades.DocElect.BuscaArchivos;
import static Utilidades.DocElect.carpeta;
import Utilidades.Ftp;
import Utilidades.ImgTabla;
import Utilidades.LogError;
import Utilidades.PanelTab;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Point;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javamail.Window;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import org.jdom2.input.SAXBuilder;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


public class pfOCTransporte extends javax.swing.JPanel {
    public static String sku_sinasociar;
    String RutMaster;
    int Tipo; // 0::Nuevo    1:Abrir
    int PosCodigoOc;
    private enum Columnas{Sku,Nombre,UM,Cantidad,Despachado,Pendiente,Unitario,PorDesc,ValDesc,Total,UniReal};
    boolean Prioridad,Exento;
    int PosContacto = -1;
    String Master_Codigo_Oc;
    String Master_Orden;
    String pu_NumeroGuia;
    String pu_TipDocto;
    
    
    
    
    
    
                
    public pfOCTransporte() {
        initComponents();
        LimpiaTemporales();
        
        TxHistorial.setLineWrap(true);
        TxHistorial.setWrapStyleWord(true);
        jScrollPane3.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        btAgregar.setVisible(false);
        
        
        btMercadoPublico.setVisible(false);
        
        
        CargaVendedor();
        cbCodigoVendedor.setVisible(false);
        Habilita(false);
        //----------------------
        txDirDespacho.setVisible(false);
        jLabel9.setVisible(false);
        //------------------------------
        txNombre.setEditable(false);
        dtEmision.setFormats(new String[] {"dd/MM/yyyy"});
        AlinearNumerosColumna();
        lbInfo.setVisible(false);

    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PMenu = new javax.swing.JPopupMenu();
        MnuDirecto = new javax.swing.JMenuItem();
        MnuPorRut = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        pnMenu = new javax.swing.JPanel();
        btNuevo = new javax.swing.JButton();
        btGuardar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btAbrir = new javax.swing.JButton();
        btGDC = new javax.swing.JButton();
        btFAC = new javax.swing.JButton();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jButton1 = new javax.swing.JButton();
        btEliminarOCC = new javax.swing.JButton();
        btMercadoPublico = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Grilla = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txRut = new javax.swing.JTextField();
        txDv = new javax.swing.JTextField();
        btIr = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txNombre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txDirDespacho = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cbContacto = new javax.swing.JComboBox();
        btDetalleCon = new javax.swing.JButton();
        lbInfo = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbVendedor = new javax.swing.JComboBox<String>();
        cbCodigoVendedor = new javax.swing.JComboBox<String>();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txExento = new javax.swing.JTextField();
        txNeto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txIva = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txTotal = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txImpEspecifico = new javax.swing.JTextField();
        btAgregar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        chbPrioridad = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        txDespacho = new javax.swing.JTextField();
        btDetalleCon1 = new javax.swing.JButton();
        dtEmision = new org.jdesktop.swingx.JXDatePicker();
        chbExenta = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        GrillaDoc = new javax.swing.JTable();
        lbInfoMargen = new javax.swing.JLabel();
        txSkuTemporal = new javax.swing.JTextField();
        txDescTemporal = new javax.swing.JTextField();
        txUMTemporal = new javax.swing.JTextField();
        txCantidadTemporal = new javax.swing.JTextField();
        txUnitarioTemporal = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cbCodigoOc = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txNroOc = new javax.swing.JTextField();
        btAgregarBlog = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        GrillaBlog = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TxHistorial = new javax.swing.JTextArea();

        PMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        PMenu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        MnuDirecto.setText("Directa OC");
        MnuDirecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuDirectoActionPerformed(evt);
            }
        });
        PMenu.add(MnuDirecto);

        MnuPorRut.setText("Por Rut");
        MnuPorRut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuPorRutActionPerformed(evt);
            }
        });
        PMenu.add(MnuPorRut);

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setBackground(new java.awt.Color(220, 215, 226));
        jPanel2.setToolTipText("");
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnMenu.setBackground(new java.awt.Color(220, 215, 226));
        pnMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/add16.png"))); // NOI18N
        btNuevo.setText("Nuevo");
        btNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNuevoActionPerformed(evt);
            }
        });
        pnMenu.add(btNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(431, 6, -1, -1));

        btGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/save16.png"))); // NOI18N
        btGuardar.setText("Guardar");
        btGuardar.setBorder(null);
        btGuardar.setEnabled(false);
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });
        pnMenu.add(btGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 6, 91, 25));

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/Cancel16.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.setEnabled(false);
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        pnMenu.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 6, -1, -1));

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/Pencil16.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.setEnabled(false);
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });
        pnMenu.add(btEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 6, -1, -1));

        btAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/open16.png"))); // NOI18N
        btAbrir.setText("Abrir");
        btAbrir.setComponentPopupMenu(PMenu);
        btAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbrirActionPerformed(evt);
            }
        });
        pnMenu.add(btAbrir, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 80, -1));

        btGDC.setText("Emitir Guía");
        btGDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGDCActionPerformed(evt);
            }
        });
        pnMenu.add(btGDC, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 10, -1, -1));

        btFAC.setText("Emitir Factura");
        btFAC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFACActionPerformed(evt);
            }
        });
        pnMenu.add(btFAC, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 10, -1, -1));

        jXLabel1.setForeground(new java.awt.Color(0, 51, 0));
        jXLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Order24.png"))); // NOI18N
        jXLabel1.setText("ORDEN DE COMPRA TRANSPORTE");
        jXLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        pnMenu.add(jXLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 6, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/impresora16.png"))); // NOI18N
        jButton1.setText("Imp. Bodega");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnMenu.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 10, -1, -1));

        btEliminarOCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/erase16.png"))); // NOI18N
        btEliminarOCC.setText("Eliminar");
        btEliminarOCC.setEnabled(false);
        btEliminarOCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarOCCActionPerformed(evt);
            }
        });
        pnMenu.add(btEliminarOCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 10, -1, -1));

        btMercadoPublico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/mp95x23.png"))); // NOI18N
        btMercadoPublico.setMaximumSize(new java.awt.Dimension(173, 25));
        btMercadoPublico.setMinimumSize(new java.awt.Dimension(173, 25));
        btMercadoPublico.setPreferredSize(new java.awt.Dimension(173, 25));
        btMercadoPublico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMercadoPublicoActionPerformed(evt);
            }
        });
        pnMenu.add(btMercadoPublico, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, 110, 28));

        jPanel1.setBackground(new java.awt.Color(220, 215, 226));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Grilla.setAutoCreateRowSorter(true);
        Grilla.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Grilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "UM", "Cantidad", "Despachado", "Pendiente", "V. Unitario", "%Dcto", "$Dcto", "Total Linea", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
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
        Grilla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GrillaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(Grilla);
        if (Grilla.getColumnModel().getColumnCount() > 0) {
            Grilla.getColumnModel().getColumn(0).setMinWidth(70);
            Grilla.getColumnModel().getColumn(0).setPreferredWidth(70);
            Grilla.getColumnModel().getColumn(0).setMaxWidth(90);
            Grilla.getColumnModel().getColumn(1).setMinWidth(300);
            Grilla.getColumnModel().getColumn(1).setPreferredWidth(300);
            Grilla.getColumnModel().getColumn(1).setMaxWidth(400);
            Grilla.getColumnModel().getColumn(2).setResizable(false);
            Grilla.getColumnModel().getColumn(2).setPreferredWidth(20);
            Grilla.getColumnModel().getColumn(3).setMinWidth(40);
            Grilla.getColumnModel().getColumn(3).setPreferredWidth(40);
            Grilla.getColumnModel().getColumn(3).setMaxWidth(60);
            Grilla.getColumnModel().getColumn(4).setMinWidth(40);
            Grilla.getColumnModel().getColumn(4).setPreferredWidth(40);
            Grilla.getColumnModel().getColumn(4).setMaxWidth(60);
            Grilla.getColumnModel().getColumn(5).setMinWidth(40);
            Grilla.getColumnModel().getColumn(5).setPreferredWidth(40);
            Grilla.getColumnModel().getColumn(5).setMaxWidth(60);
            Grilla.getColumnModel().getColumn(6).setMinWidth(60);
            Grilla.getColumnModel().getColumn(6).setPreferredWidth(60);
            Grilla.getColumnModel().getColumn(6).setMaxWidth(90);
            Grilla.getColumnModel().getColumn(7).setMinWidth(30);
            Grilla.getColumnModel().getColumn(7).setPreferredWidth(30);
            Grilla.getColumnModel().getColumn(7).setMaxWidth(40);
            Grilla.getColumnModel().getColumn(8).setPreferredWidth(30);
            Grilla.getColumnModel().getColumn(9).setMinWidth(80);
            Grilla.getColumnModel().getColumn(9).setPreferredWidth(80);
            Grilla.getColumnModel().getColumn(9).setMaxWidth(120);
            Grilla.getColumnModel().getColumn(10).setMinWidth(0);
            Grilla.getColumnModel().getColumn(10).setPreferredWidth(0);
            Grilla.getColumnModel().getColumn(10).setMaxWidth(0);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 1026, 160));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("Rut");

        txRut.setEnabled(false);
        txRut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txRutKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txRutKeyTyped(evt);
            }
        });

        txDv.setEditable(false);

        btIr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos22/Go.png"))); // NOI18N
        btIr.setBorderPainted(false);
        btIr.setEnabled(false);
        btIr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIrActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("Nombre");

        txNombre.setEnabled(false);

        jLabel9.setForeground(new java.awt.Color(0, 0, 51));
        jLabel9.setText("Dirección Envío");

        txDirDespacho.setEnabled(false);
        txDirDespacho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txDirDespachoActionPerformed(evt);
            }
        });
        txDirDespacho.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txDirDespachoKeyTyped(evt);
            }
        });

        jLabel14.setForeground(new java.awt.Color(0, 0, 51));
        jLabel14.setText("Contacto");

        cbContacto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbContacto.setSelectedIndex(-1);
        cbContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbContactoActionPerformed(evt);
            }
        });

        btDetalleCon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos22/Go.png"))); // NOI18N
        btDetalleCon.setBorderPainted(false);
        btDetalleCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDetalleConActionPerformed(evt);
            }
        });

        lbInfo.setForeground(new java.awt.Color(255, 51, 51));
        lbInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/bloquear.png"))); // NOI18N
        lbInfo.setText("Cliente Bloqueado");

        jLabel16.setForeground(new java.awt.Color(0, 0, 51));
        jLabel16.setText("Vendedor");

        cbVendedor.setForeground(new java.awt.Color(0, 153, 0));
        cbVendedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Vendedor Luvaly" }));
        cbVendedor.setEnabled(false);
        cbVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbVendedorActionPerformed(evt);
            }
        });

        cbCodigoVendedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Codigo" }));
        cbCodigoVendedor.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(cbContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btDetalleCon, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                        .addComponent(txDirDespacho))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txRut, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txDv, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btIr, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(lbInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cbVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbCodigoVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCodigoVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(txRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btIr)
                        .addComponent(txDv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbInfo)))
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txDirDespacho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btDetalleCon, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(cbContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 174));

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel11.setText("Exento");

        txExento.setEditable(false);
        txExento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txExento.setText("0");

        txNeto.setEditable(false);
        txNeto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txNeto.setText("0");

        jLabel10.setText("Neto");

        txIva.setEditable(false);
        txIva.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txIva.setText("0");

        jLabel12.setText("I.V.A.");

        txTotal.setEditable(false);
        txTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txTotal.setText("0");

        jLabel13.setText("TOTAL");

        jLabel8.setText("Imp. específico");

        txImpEspecifico.setEditable(false);
        txImpEspecifico.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txImpEspecifico.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txNeto)
                    .addComponent(txIva)
                    .addComponent(txExento, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(txTotal)
                    .addComponent(txImpEspecifico))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txExento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txNeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txImpEspecifico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 350, -1, 180));

        btAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos22/add2.png"))); // NOI18N
        btAgregar.setText("Agregar");
        btAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));

        btEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos22/Cancel.png"))); // NOI18N
        btEliminar.setText("Eliminar");
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, -1, -1));

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel5.setForeground(new java.awt.Color(0, 0, 51));
        jLabel5.setText("F. Emisión");

        jLabel7.setForeground(new java.awt.Color(0, 0, 51));
        jLabel7.setText("Prioridad");

        chbPrioridad.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        chbPrioridad.setOpaque(false);
        chbPrioridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbPrioridadActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(0, 0, 51));
        jLabel6.setText("Despacho");

        txDespacho.setEditable(false);

        btDetalleCon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos22/Go.png"))); // NOI18N
        btDetalleCon1.setBorderPainted(false);
        btDetalleCon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDetalleCon1ActionPerformed(evt);
            }
        });

        dtEmision.setEnabled(false);
        dtEmision.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dtEmisionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dtEmisionKeyTyped(evt);
            }
        });

        chbExenta.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chbExentaStateChanged(evt);
            }
        });

        jLabel15.setForeground(new java.awt.Color(0, 0, 51));
        jLabel15.setText("Es Exenta");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel6)))
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chbExenta)
                    .addComponent(dtEmision, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chbPrioridad)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txDespacho, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btDetalleCon1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(165, 165, 165))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(dtEmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel6)
                            .addComponent(txDespacho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btDetalleCon1)))
                    .addComponent(chbPrioridad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chbExenta)
                    .addComponent(jLabel15)))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(758, 69, 278, -1));

        GrillaDoc.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        GrillaDoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Docto.", "Nro", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        GrillaDoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GrillaDocMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(GrillaDoc);
        if (GrillaDoc.getColumnModel().getColumnCount() > 0) {
            GrillaDoc.getColumnModel().getColumn(0).setMinWidth(90);
            GrillaDoc.getColumnModel().getColumn(0).setPreferredWidth(90);
            GrillaDoc.getColumnModel().getColumn(0).setMaxWidth(90);
            GrillaDoc.getColumnModel().getColumn(1).setMinWidth(75);
            GrillaDoc.getColumnModel().getColumn(1).setPreferredWidth(75);
            GrillaDoc.getColumnModel().getColumn(1).setMaxWidth(75);
            GrillaDoc.getColumnModel().getColumn(2).setMinWidth(80);
            GrillaDoc.getColumnModel().getColumn(2).setPreferredWidth(80);
            GrillaDoc.getColumnModel().getColumn(2).setMaxWidth(80);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 0, 264, 340));

        lbInfoMargen.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(lbInfoMargen, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, 270, 50));
        jPanel1.add(txSkuTemporal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 76, -1));
        jPanel1.add(txDescTemporal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 76, -1));
        jPanel1.add(txUMTemporal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 76, -1));
        jPanel1.add(txCantidadTemporal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 75, -1));
        jPanel1.add(txUnitarioTemporal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 75, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 51));
        jLabel3.setText("Código");

        cbCodigoOc.setEnabled(false);
        cbCodigoOc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCodigoOcActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 51));
        jLabel4.setText("Nro Orden");

        txNroOc.setEnabled(false);
        txNroOc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txNroOcKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txNroOcKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbCodigoOc, 0, 152, Short.MAX_VALUE)
                    .addComponent(txNroOc))
                .addGap(38, 38, 38))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(cbCodigoOc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(txNroOc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, -1, -1));

        btAgregarBlog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/Agregar.png"))); // NOI18N
        btAgregarBlog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarBlogActionPerformed(evt);
            }
        });
        jPanel1.add(btAgregarBlog, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 350, 26, -1));

        GrillaBlog.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        GrillaBlog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Historial", "id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        GrillaBlog.setToolTipText("Tool");
        GrillaBlog.setGridColor(new java.awt.Color(255, 255, 255));
        GrillaBlog.setRowHeight(20);
        GrillaBlog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GrillaBlogMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(GrillaBlog);
        if (GrillaBlog.getColumnModel().getColumnCount() > 0) {
            GrillaBlog.getColumnModel().getColumn(0).setMinWidth(20);
            GrillaBlog.getColumnModel().getColumn(0).setPreferredWidth(20);
            GrillaBlog.getColumnModel().getColumn(0).setMaxWidth(20);
            GrillaBlog.getColumnModel().getColumn(1).setMinWidth(350);
            GrillaBlog.getColumnModel().getColumn(1).setPreferredWidth(250);
            GrillaBlog.getColumnModel().getColumn(1).setMaxWidth(350);
            GrillaBlog.getColumnModel().getColumn(2).setMinWidth(30);
            GrillaBlog.getColumnModel().getColumn(2).setPreferredWidth(30);
            GrillaBlog.getColumnModel().getColumn(2).setMaxWidth(50);
        }

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 350, 260, 100));

        TxHistorial.setEditable(false);
        TxHistorial.setColumns(20);
        TxHistorial.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        TxHistorial.setRows(10);
        TxHistorial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxHistorialKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxHistorialKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(TxHistorial);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 460, 260, 110));

        pnMenu.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1320, 640));

        jPanel2.add(pnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 1310, 620));

        add(jPanel2);
    }// </editor-fold>//GEN-END:initComponents

    static public int GetCol(String Col){
        return Columnas.valueOf(Col).ordinal();
    }
    //Nota: Alinear los datos de la tabla 
    //Centrado 
    public void AlinearNumerosColumna(){ 
    DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer(); 
    modelocentrar.setHorizontalAlignment(SwingConstants.RIGHT); Grilla.getColumnModel().getColumn(GetCol("Cantidad")).setCellRenderer(modelocentrar); 

     
     modelocentrar.setHorizontalAlignment(SwingConstants.RIGHT);
     Grilla.getColumnModel().getColumn(GetCol("Cantidad")).setCellRenderer(modelocentrar); 
     Grilla.getColumnModel().getColumn(GetCol("Despachado")).setCellRenderer(modelocentrar); 
     Grilla.getColumnModel().getColumn(GetCol("Pendiente")).setCellRenderer(modelocentrar); 
     Grilla.getColumnModel().getColumn(GetCol("Unitario")).setCellRenderer(modelocentrar); 
     Grilla.getColumnModel().getColumn(GetCol("Total")).setCellRenderer(modelocentrar); 
     }
     //Fin: Alinear los datos de la tabla
//--------------------------------------------------------------------------------
// Funcion SET DE TIPOS
//--------------------------------------------------------------------------------
    private void SetTipo(int ElTipo){
      //Nada
      if(ElTipo==-1){
          fmMain.SetEstado(fmMain.pnPestanas.getSelectedIndex(),0);
          Habilita(false);
          Edicion(false);
          Limpia();
          jPanel4.setEnabled(true);
          txRut.setEnabled(true);
          cbVendedor.setEnabled(true);
          txRut.setEditable(true);
          btIr.setEnabled(true);
          txRut.requestFocus();
          btCancelar.setEnabled(false);
          btGuardar.setEnabled(false);
          btNuevo.setEnabled(true);
          btEditar.setEnabled(false);
          btEliminarOCC.setEnabled(false);
          txRut.setEditable(true);
          Tipo=-1;
          
          
      }
      //Nueva Orden
      else if(ElTipo==1){
          fmMain.SetEstado(fmMain.pnPestanas.getSelectedIndex(),1);
          btGuardar.setEnabled(true);
          btCancelar.setEnabled(true);
          
          btEditar.setEnabled(false);
          btNuevo.setEnabled(false);
          btAbrir.setEnabled(false);
          btEliminarOCC.setEnabled(false);
          jPanel4.setEnabled(true);
             
          cbCodigoOc.setEnabled(true);
          cbCodigoOc.setEditable(false);
          txNroOc.setEnabled(true);
          
          Habilita(true);
          Edicion(true);
          //CargaCodOc(RutMaster);
          //CargaContactos(RutMaster);
          txRut.requestFocus();
          txDespacho.setText("Pendiente");
          txRut.setEditable(false);
          Tipo=1;
          cbCodigoOc.setEditable(false);
          
      }
      //Abre Orden
      else if(ElTipo==2){
          fmMain.SetEstado(fmMain.pnPestanas.getSelectedIndex(),0);
          btNuevo.setEnabled(true);
          btEditar.setEnabled(true);
          btAbrir.setEnabled(true);
          btGuardar.setEnabled(false);
          btCancelar.setEnabled(false);
          btEliminarOCC.setEnabled(true);
          cbVendedor.setEnabled(false);
          
          Habilita(false);
          Edicion(false);
          cbCodigoOc.setEnabled(false);
          cbCodigoOc.setEditable(false);
          
          txNroOc.setEnabled(false);
          txRut.setEditable(false);
          txDv.setEditable(false);
//          jPanel4.setEnabled(false);
//          cbCodigoOc.setEditable(false);
          Tipo=2;
      }
      //Edita Orden
      else if(ElTipo==3){
          fmMain.SetEstado(fmMain.pnPestanas.getSelectedIndex(),1);
          Habilita(true);
          Edicion(true);
          cbCodigoOc.setEnabled(false);
          cbCodigoOc.setEditable(false);
          txNroOc.setEnabled(false);
          btGuardar.setEnabled(true);
          btCancelar.setEnabled(true);
          btNuevo.setEnabled(false);
          btEditar.setEnabled(false);
          btAbrir.setEnabled(false);
          btEliminarOCC.setEnabled(false);
          txRut.setEditable(false);
          txDv.setEditable(false);
          cbVendedor.setEnabled(true);
          Tipo=3; 
          Master_Codigo_Oc=cbCodigoOc.getSelectedItem().toString().trim();
//          jPanel4.setEnabled(false);
//          cbCodigoOc.setEditable(false);
      }
    }

//--------------------------------------------------------------------------------
// SUMADOR
//--------------------------------------------------------------------------------
private void Sumador(){    
    double Neto=0;
    double Exento=0;
    double Iva=0;
    double Total=0;
    String Unitario,Cantidad;
    
    
    for(int i=0; i< Grilla.getRowCount(); i++){
        Unitario = Grilla.getModel().getValueAt(i,GetCol("UniReal")).toString();
        Cantidad = Grilla.getModel().getValueAt(i,GetCol("Cantidad")).toString();
        Unitario = Unitario.replace(fmMain.GetMiles(), "");
        Cantidad = Cantidad.replace(fmMain.GetMiles(), "");
        Neto =  (Double.parseDouble(Unitario) * Double.parseDouble(Cantidad)) + Neto;
    }
    Neto = Math.round(Neto);
    
    if(chbExenta.isSelected()){
        Iva = 0;
        Total = Neto;
        Exento = Neto;
        Neto=0;
    }
    else{
        Iva = Math.round((Neto * Double.parseDouble("1.19"))- Neto);
        Total = Neto + Iva;
    }
    txNeto.setText(fmMain.FormatoTotal(Neto));
    txExento.setText(fmMain.FormatoTotal(Exento));
    txIva.setText(fmMain.FormatoTotal(Iva));
    txTotal.setText(fmMain.FormatoTotal(Total));
}
//--------------------------------------------------------------------------------
// EDICION
//--------------------------------------------------------------------------------
private void Edicion(boolean Estado){
    
    //txNroOc.setEditable(Estado);
    txDirDespacho.setEditable(Estado);
    txRut.setEditable(Estado);
    txDv.setEditable(Estado);
//    txNombre.setEditable(Estado);
    txDv.setEditable(Estado);

    //cbVendedor.setEnabled(Estado);
    
    
    
  
//    txNeto.setEditable(Estado);
//    txExento.setEditable(Estado);
//    txIva.setEditable(Estado);
//    txTotal.setEditable(Estado);
    btAgregar.setEnabled(Estado);
    btEliminar.setEnabled(Estado);

}
//--------------------------------------------------------------------------------
// LIMPIA
//--------------------------------------------------------------------------------
private void Limpia(){
    DefaultComboBoxModel dfCm = new DefaultComboBoxModel();
    DefaultTableModel   dfTm = (DefaultTableModel) Grilla.getModel();
    DefaultTableModel   dfTm1 = (DefaultTableModel) GrillaDoc.getModel();
    
    txRut.setText("");
    txNombre.setText("");
    txDv.setText("");
    txNeto.setText("");
    txExento.setText("");
    txIva.setText("");
    txTotal.setText("");
    txNroOc.setText("");
    txDirDespacho.setText("");
    cbCodigoOc.setModel(dfCm);
    cbContacto.setModel(dfCm);
    cbVendedor.setSelectedIndex(0);
    
    
    
        
    while(dfTm.getRowCount()>0)
        dfTm.removeRow(0);
    
    while(dfTm1.getRowCount()>0)
        dfTm1.removeRow(0);
    //chbPrioridad.
    
    dtEmision.setDate(null);
    txDespacho.setText("");
    
    // Limpia Grilla Blog
    DefaultTableModel tm = (DefaultTableModel) GrillaBlog.getModel();
    fmMain.LimpiaGrilla(tm);   
    TxHistorial.setText("");
    
    
}    
//--------------------------------------------------------------------------------
// HABILITA
//--------------------------------------------------------------------------------
private void Habilita(boolean Estado){
    
    cbContacto.setEnabled(Estado);

    btDetalleCon.setEnabled(Estado);
    btAgregar.setEnabled(Estado);
    btEliminar.setEnabled(Estado);
    //txDirDespacho.setEnabled(Estado);
    txRut.setEnabled(Estado);
    btMercadoPublico.setEnabled(Estado);
    txNombre.setEnabled(Estado);
    txDv.setEnabled(Estado);
  
    dtEmision.setEnabled(Estado);
    dtEmision.getEditor().setEditable(false);
    txNeto.setEnabled(Estado);
    txExento.setEnabled(Estado);
    txIva.setEnabled(Estado);
    txTotal.setEnabled(Estado);
    btIr.setEnabled(Estado);
    chbPrioridad.setEnabled(Estado);
    chbExenta.setEnabled(Estado);
    btDetalleCon.setEnabled(Estado);
    txDespacho.setEnabled(Estado);
    btDetalleCon1.setEnabled(Estado);
    Grilla.setEnabled(Estado);
    txImpEspecifico.setEnabled(Estado);
    btAgregarBlog.setEnabled(Estado);
}
//--------------------------------------------------------------------------------
// Funcion CODIGO desde COMBOBOX
//--------------------------------------------------------------------------------
    private int cbId_Accion(JComboBox Combo ){
        int Codigo=-1;
    if (Combo.getSelectedIndex()!=-1){
        ComboCodigos id = (ComboCodigos) Combo.getSelectedItem();
        Codigo = id.getId();
        String nombre = Combo.getSelectedItem().toString();
        Combo.hidePopup();
    } 
    return Codigo;
}
//------------------------------------------------------------------------------
// Carga Contactos
//------------------------------------------------------------------------------
private void CargaContactos(String Rut){
    ExeSql Sql = new ExeSql();
    ResultSet Rs;
    DefaultComboBoxModel cbMd = new DefaultComboBoxModel();
    cbContacto.setModel(cbMd);
    
    try {
        Rs = Sql.Select("select trim(nombre) as nombre,id \n" +
                "from clicontactopersonas\n" +
                "where rut=" + Rut);
        while(Rs.next()){

            cbMd.addElement(new ComboCodigos(Rs.getString("nombre").trim(),Rs.getInt("id")));
        }
    } catch (Exception e) {
        fmMain.Mensaje("Error: "  + e);
    } finally{
        Sql.Close();
    }
        
}
////------------------------------------------------------------------------------
//// Carga Codigos OC
////------------------------------------------------------------------------------
//    private void CargaCodOc(String Rut){
//        cbCodigoOc.removeAllItems();
//        //cbCodigoOc.setSelectedIndex(-1);
//                      
//        ExeSql Sql = new ExeSql();
//        ResultSet Rs;
//        DefaultComboBoxModel cbMd = new DefaultComboBoxModel();
//        
//        cbCodigoOc.setModel(cbMd);
//        
//
//        try {
//            Rs = Sql.Select("select distinct(codigo_oc) as codigo_oc from clicontacto where rut = " + Rut);
//            while(Rs.next()){
//              
//            cbMd.addElement(Rs.getString("codigo_oc")); 
//            }
//        } catch (Exception e) {
//            fmMain.Mensaje(" Error:  " + e);
//        } finally{
//            Sql.Close();
//        }
//            
//
//    }


//------------------------------------------------------------------------------
// Carga Codigos OC
//------------------------------------------------------------------------------
    private void CargaCodOc_borrar(String Rut){
        cbCodigoOc.removeAllItems();
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        DefaultComboBoxModel cbMd = new DefaultComboBoxModel();
        
        cbCodigoOc.setModel(cbMd);
        try {
            Rs = Sql.Select("select distinct(codigo_oc) as codigo_oc from clicontacto where rut = " + Rut);
            while(Rs.next()){
              
            cbMd.addElement(Rs.getString("codigo_oc")); 
            }
        } catch (Exception e) {
            fmMain.Mensaje(" Error:  " + e);
        } finally{
            Sql.Close();
        }
            

    }
    
    private void CargaBlog(){

        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        String Query ="";
        GrillaBlog.setDefaultRenderer(Object.class, new ImgTabla());
        DefaultTableModel tm = (DefaultTableModel) GrillaBlog.getModel();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy - hh:mm");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yyyy");
        
        fmMain.LimpiaGrilla(tm);
        
        
        TxHistorial.setText("");
        JLabel lbCall = new JLabel();
        JLabel lbMail = new JLabel();
        JLabel lbFin  = new JLabel();
        JLabel lbIni  = new JLabel();
        JLabel lbInfo = new JLabel();
        
        URL urlCall = this.getClass().getResource("/Iconos/Llamada.png");  
        URL urlMail = this.getClass().getResource("/Iconos/email.png");  
        URL urlIni =  this.getClass().getResource("/Iconos22/Go.png");  
        URL urlFin =  this.getClass().getResource("/Iconos/camion.png");  
        URL urlInfo =  this.getClass().getResource("/Iconos/info.png");
         
        ImageIcon IconoCall =  new ImageIcon(urlCall); 
        ImageIcon IconoMail =  new ImageIcon(urlMail); 
        ImageIcon IconoIni  =  new ImageIcon(urlIni); 
        ImageIcon IconoFin  =  new ImageIcon(urlFin); 
        ImageIcon IconoInfo =  new ImageIcon(urlInfo); 
        
        lbCall.setIcon(IconoCall);
        lbMail.setIcon(IconoMail);
        lbIni.setIcon(IconoIni);
        lbFin.setIcon(IconoFin);
        lbInfo.setIcon(IconoInfo);
        
        try {
            
            Query = "SELECT id,fecha,usuario,texto,tipo,compromiso,fcompromiso\n" +
                            " FROM blog_occ\n" +
                            " where rut=" + txRut.getText().trim() + "\n" +
                            " and codigo_oc = " + Integer.valueOf(cbCodigoOc.getSelectedItem().toString())  + " \n" + 
                            " and orden='" + txNroOc.getText().trim() + "'";
            
            Rs = Sql.Select(Query);
            
            while(Rs.next()){
                 //Tipo 0 = Llamada
                if(Rs.getInt("tipo")==1){
                    tm.addRow(new Object[]{lbCall,sdf.format(Rs.getTimestamp("fecha"))+ "   [" + Rs.getString("usuario").trim().toUpperCase() + "]",Rs.getString("id")});
                    
                }
                //Tipo 1 = Correo
                else if(Rs.getInt("tipo")==2) {
                    tm.addRow(new Object[]{lbMail,sdf.format(Rs.getTimestamp("fecha"))+ "   [" + Rs.getString("usuario").trim().toUpperCase() + "]",Rs.getString("id")});
                }
                // Tipo 2 = Bloque
                else if(Rs.getInt("tipo")==3) {
                    tm.addRow(new Object[]{lbIni,sdf.format(Rs.getTimestamp("fecha"))+ "   [" + Rs.getString("usuario").trim().toUpperCase() + "]",Rs.getString("id")});
                }
                // Tipo 3 = Desbloqueo
                else if(Rs.getInt("tipo")==4) {
                    tm.addRow(new Object[]{lbFin,sdf.format(Rs.getTimestamp("fecha"))+ "   [" + Rs.getString("usuario").trim().toUpperCase() + "]",Rs.getString("id")});
                }
                
                else if(Rs.getInt("tipo")==5) {
                    tm.addRow(new Object[]{lbInfo,sdf.format(Rs.getTimestamp("fecha"))+ "   [" + Rs.getString("usuario").trim().toUpperCase() + "]",Rs.getString("id")});
                }
                
                 //Mensaje
                tm.addRow(new Object[]{" ",Rs.getString("texto"),Rs.getString("id")});
//                if(Rs.getBoolean("compromiso"))
//                    tm.addRow(new Object[]{" ", "Compromiso: " + sdf2.format(Rs.getTimestamp("fcompromiso"))});
                    
            }
            
        } catch (Exception e) {
            fmMain.Mensaje("Ha ocurrido un error");
            LogError.Guardar(this.getClass().getSimpleName(),e.getMessage());
        } finally {
            Sql.Close();
        }
    }
    
    
    
    
    
    
    
    private void CargaCodOc(String Rut){
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        String f ="";
        
        if (cbCodigoOc.getSelectedIndex()>0){
        cbCodigoOc.removeAllItems();}
        
        try {
            Rs = Sql.Select("select distinct(codigo_oc) as codigo_oc from clicontacto where rut = " + Rut);
            if(Sql.GetRowCount()==0) return;
     
           while(Rs.next()){
          f= Rs.getString("codigo_oc");
            cbCodigoOc.addItem( f);
            } 
           
           //cbCodigoOc.setSelectedIndex(0);
        } catch (Exception e) {
                        fmMain.Mensaje(" Error:  " + e);
        }
        finally{
            Sql.Close();
        }
    }
    
    
    
    
    

//------------------------------------------------------------------------------
// Carga Cliente
//------------------------------------------------------------------------------
    private boolean CargaCliente(String Rut){
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        try {
            Rs = Sql.Select("select rut,dv,nombre\n" +
                            "from cliente\n" +
                            "where rut=" + Rut);
            if (Rs.next())
                {
                txRut.setText(Rs.getString("Rut"));
                txDv.setText(Rs.getString("dv"));
                txNombre.setText(Rs.getString("nombre").trim());
                dtEmision.setDate(new Date());
                RutMaster=Rs.getString("Rut");
                txRut.setEditable(false);
                txNombre.setEditable(false);
                return true;
                }
            else{
                fmMain.Mensaje("El cliente no existe, debe crearlo antes de continuar");
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            fmMain.Mensaje("Error: "  + e);
            return false;
        } finally{
            Sql.Close();
        }
    }
//------------------------------------------------------------------------------
// BOTON  CANCELAR
//------------------------------------------------------------------------------
    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        
        if(fmMain.GetEstado(fmMain.pnPestanas.getSelectedIndex())==0){
            Limpia();
            Habilita(false);
            btGuardar.setEnabled(false);
            btCancelar.setEnabled(false);
            btNuevo.setEnabled(true);
            btEditar.setEnabled(false);
            btAbrir.setEnabled(true);
            cbVendedor.setEnabled(false);
        }
        
        else if(fmMain.OkCancel("¿Seguro de cancelar?")==JOptionPane.OK_OPTION){
            Limpia();
            Habilita(false);
            btGuardar.setEnabled(false);
            btCancelar.setEnabled(false);
            btNuevo.setEnabled(true);
            btEditar.setEnabled(false);
            btAbrir.setEnabled(true);
            //cbCodigoOc.removeAllItems();
            
        }
    }//GEN-LAST:event_btCancelarActionPerformed

    private void cbContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbContactoActionPerformed
        if(Tipo==2 || Tipo==-1){
            cbContacto.setSelectedIndex(PosContacto);
        }
    }//GEN-LAST:event_cbContactoActionPerformed

    private void txRutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRutKeyPressed
            if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                btIr.doClick();
        }
    }//GEN-LAST:event_txRutKeyPressed
//-----------------------------------------------------------------------------
//  ABRIR ORDEN DE COMPRA
//-----------------------------------------------------------------------------
    public void AbrirOCCDirecta(String CodigoOc, String Orden) {
        ExeSql Sql = new ExeSql();
        DefaultTableModel dfTm = (DefaultTableModel) Grilla.getModel();
        DefaultTableModel dfTm2 = (DefaultTableModel) GrillaDoc.getModel();
        ResultSet Rs;

//        //Carga Combos
//        CargaCodOc(Rut);
//        CargaContactos(Rut);
        while (dfTm.getRowCount() > 0) {
            dfTm.removeRow(0);
        }
        
        while (dfTm2.getRowCount() > 0) {
            dfTm2.removeRow(0);
        }

        //Trae Informacion de Orden de Compra
        try {
            Rs = Sql.Select("select *\n"
                    + "from occh\n"
                    + "where upper(orden)='" + Orden.toUpperCase() + "'\n"
                    + "and codigo_oc=" + CodigoOc);
//            SetTipo(2);
            Rs.next();
            //Carga Datos
//                JOptionPane.showConfirmDialog(null, Rs.getDate("femision"));
            CargaCliente(Rs.getString("rut"));
            RutMaster = Rs.getString("rut");
            CargaCodOc(RutMaster);
          
            CargaContactos(RutMaster);
            txNroOc.setText(Rs.getString("orden").trim());
            //txDirDespacho.setText(Rs.getString("dirdespacho").trim());
            dtEmision.setDate(Rs.getDate("femision"));
            chbPrioridad.setSelected(Rs.getBoolean("prioridad"));
            chbExenta.setSelected(Rs.getBoolean("esexento"));
            Prioridad = Rs.getBoolean("prioridad");
            Exento = Rs.getBoolean("esexento");

            txNeto.setText(fmMain.FormatoTotal(Rs.getDouble("totalafecto")));
            txExento.setText(fmMain.FormatoTotal(Rs.getDouble("totalexento")));
            txIva.setText(fmMain.FormatoTotal(Rs.getDouble("totaliva")));
            txImpEspecifico.setText(fmMain.FormatoTotal(Rs.getDouble("totalimpespecifico")));
            txTotal.setText(fmMain.FormatoTotal(Rs.getDouble("totaldocto")));
            if (Rs.getInt("vendedor")<=0)
            {
                cbVendedor.setSelectedIndex(0);
            }
            else
            {
            cbVendedor.setSelectedIndex(Rs.getInt("vendedor"));
            }

            switch (Rs.getInt("estado")) {
                case 0:
                    txDespacho.setText("PENDIENTE");
                    break;
                case 1:
                    txDespacho.setText("PARCIAL");
                    break;
                case 2:
                    txDespacho.setText("COMPLETO");
                    break;
            }

            //Setea Combo Codigo OC 
//            int j =0;
//            for (int i = 0; i < cbCodigoOc.getItemCount(); i++) {
//               
//                if ( cbCodigoOc.getSelectedItem().toString().equals(CodigoOc)) {
//                    j=i;
//                    break;
//                }
//            }
//  cbCodigoOc.setSelectedItem(CodigoOc);
//            PosCodigoOc = cbCodigoOc.getSelectedIndex();            
  //Setea Combo Codigo OC 
            int j =0;
            for (int i = 0; i < cbCodigoOc.getItemCount(); i++) {
               cbCodigoOc.setSelectedIndex(i);
                if(cbCodigoOc.getSelectedItem().toString().equals(String.valueOf(Rs.getInt("codigo_oc")).trim()) ){
                    j=i;
                    break;
                }
            }
            
            
            PosCodigoOc = j;
            
            
            
            
            if (Rs.getString("contacto")!=null)
            {    
                    // Setea contacto
                    for (int i = 0; i <= cbContacto.getItemCount(); i++) {
                        System.out.println("entra a Contacto");
                        cbContacto.setSelectedIndex(i);
                        System.out.println("compara");
                        System.out.println(cbId_Accion(cbContacto));
                        System.out.println(Rs.getInt("contacto"));
                        if (cbId_Accion(cbContacto) == Rs.getInt("contacto")) {
                            PosContacto = i;
                            break;
                        }

                    }
            }
            //PosContacto = cbContacto.getSelectedIndex();
            
            SetTipo(2);
        } catch (Exception e) {
            fmMain.Mensaje("Error: "  + e);
        }

        //Carga Productos de la OC
        DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
        try {
            Rs = Sql.Select("select d.sku,p.nombre,u.um,d.cantidad,d.despachado, d.cantidad-d.despachado as diferencia,d.valorunitario,d.totlinea\n"
                    + "from occhdet d\n"
                    + "left join producto p\n"
                    + "on d.sku=p.sku\n"
                    + "left join par_unidad u\n"
                    + "on u.codigo=p.unidad\n"
                    + "where d.codigo_oc=" + CodigoOc + " \n"
                    + "and upper(d.orden)='" + Orden.toUpperCase() + "'");
            while (Rs.next()) {
                TableModel.addRow(new Object[]{
                    Rs.getString("sku"),
                    Rs.getString("nombre"),
                    Rs.getString("um"),
                    fmMain.FormatoNumero(Rs.getDouble("cantidad")),
                    fmMain.FormatoNumero(Rs.getDouble("despachado")),
                    fmMain.FormatoNumero(Rs.getDouble("diferencia")),
                    fmMain.FormatoNumero(Rs.getDouble("valorunitario")), 0, 0,
                    fmMain.FormatoNumero(Rs.getDouble("totlinea")),
                    Rs.getDouble("valorunitario")});
            }
            Sumador();
            
            //Carga Documentos Relacionados
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

            Rs = Sql.Select("select case tipdocto when 'FAC' then 'Factura' when 'GDC' then 'Guia' when 'NCC' then 'N.Credito' when 'FEC' then 'F.Exenta' else 'Otro' end as tipo,nrodocto,femision \n" +
                        "from ctactecli\n" +
                        "where codigo_oc="+ CodigoOc +"\n" +
                        "and occh='"+ Orden +"'");
            while(Rs.next()){
                dfTm2.addRow(new Object[]{
                    Rs.getString("tipo"),
                    Rs.getInt("nrodocto"),
                    sdf.format(Rs.getDate("femision"))});
                
            }
        } catch (Exception e) {
            System.out.println(e);
            fmMain.Mensaje("Error: "  + e);
        } finally {
            Sql.Close();
        }
        SetTipo(2);
        ValidaMargen();
    }
//-----------------------------------------------------------------------------
//  ABRIR ORDEN DE COMPRA DESDE GUIA
//-----------------------------------------------------------------------------
    private void AbrirOCCGuia(String numero, String STipDocto) {
        ExeSql Sql = new ExeSql();
        ExeSql Sql1 = new ExeSql();
        DefaultTableModel dfTm = (DefaultTableModel) Grilla.getModel();
        DefaultTableModel dfTm2 = (DefaultTableModel) GrillaDoc.getModel();
        ResultSet Rs,Rs1;
        String Rut ;

//        //Carga Combos
//        CargaCodOc(Rut);
//        CargaContactos(Rut);
        while (dfTm.getRowCount() > 0) {
            dfTm.removeRow(0);
        }
        
        while (dfTm2.getRowCount() > 0) {
            dfTm2.removeRow(0);
        }

        //Trae Informacion de Orden de Compra
        try {
            
            String query = "select c.*, oo.contacto cont_orden\n" +
                        "from ctactecli c\n" +
                        "left join occh as oo\n" +
                        "on oo.codigo_oc =  c.codigo_oc\n" +
                        "and trim(oo.orden) = (c.occh)\n" +
                        "where nrodocto =" + numero.trim() + " \n" +
                         "and tipdocto ='" + STipDocto + "'";
            Rs = Sql.Select(query);
            Rs.next();
            
//            CargaCliente(Rs.getString("rut"));
//            RutMaster = Rs.getString("rut");
//            CargaCodOc(RutMaster);
//            CargaContactos(RutMaster);
            txNroOc.setText(Rs.getString("codigo_oc") + "-" + Rs.getString("occh").trim() + "FT".trim());
            //txDirDespacho.setText(Rs.getString("dirdespacho").trim());
            Rut = Rs.getString("rut");
            java.util.Date fecha = new Date();
            
            
            dtEmision.setDate(fecha);
            chbPrioridad.setSelected(false);
            //chbExenta.setSelected(Rs.getBoolean("esexento"));
            Prioridad = false; //Rs.getBoolean("prioridad");
            
            if (STipDocto.equals("FEC"))
            {
                Exento = true;
            }    
            else
            {
                Exento = false;
            }   
            
            txNeto.setText(fmMain.FormatoTotal(Rs.getDouble("totalafecto")));
            txExento.setText(fmMain.FormatoTotal(Rs.getDouble("totalexento")));
            txIva.setText(fmMain.FormatoTotal(Rs.getDouble("totaliva")));
            txImpEspecifico.setText(fmMain.FormatoTotal(Rs.getDouble("totalimpespecifico")));
            txTotal.setText(fmMain.FormatoTotal(Rs.getDouble("totaldocto")));


            // Carga el rut de la empresa de transporte y los datos
            query = "select td.nrodocto, pg.codigo, pg.cuenta, pg.nombre from \n" +
                    "transporte_despachos td\n" +
                    "left join par_general pg\n" +
                    "on pg.codigo = td.transporte\n" +
                    "where \n" +
                    "td.nrodocto = " + numero.trim() + " and \n" +
                    "td.tipdocto = '" + STipDocto + "'\n" +
                    "and pg.tipo = 'TRANSPORTE' \n" +
                    "LIMIT 1";
            
            
            Rs1 = Sql1.Select(query);
            if (Rs1.next()){
               
                
                if (Rs1.getString("cuenta")!= null)
                {
                    RutMaster = Rs1.getString("cuenta");
                }
                else
                {
                    RutMaster = Rut;
                }
                 CargaCliente(RutMaster);
                CargaCodOc(RutMaster);
                CargaContactos(RutMaster);
            }
            cbVendedor.setSelectedIndex(0);

            //Setea codigo oc      
            PosCodigoOc=0;    
            PosContacto =0;    

//            //Setea Combo Codigo OC 
//            int j =0;
//            for (int i = 0; i < cbCodigoOc.getItemCount(); i++) {
//               cbCodigoOc.setSelectedIndex(i);
//               if(cbCodigoOc.getSelectedItem().toString().equals(String.valueOf(Rs.getInt("codigo_oc")).trim()) ){
//                   PosCodigoOc = i; 
//                    break;
//                }
//            }
//            
//            // Setea contacto
//            if (Rs.getString("cont_orden") !=null){
//                        for (int i = 0; i <= cbContacto.getItemCount(); i++) {
//                            System.out.println("entra a Contacto");
//                            cbContacto.setSelectedIndex(i);
//                            System.out.println("compara");
//                            System.out.println(cbId_Accion(cbContacto));
//                            System.out.println(Rs.getInt("cont_orden"));
//                            if (cbId_Accion(cbContacto) == Rs.getInt("cont_orden")) {
//                                PosContacto = i;
//
//                                break;
//                            }
//                            System.out.println("i = " + i);
//
//                        }
//            }           
            //PosContacto = cbContacto.getSelectedIndex();
            // Setea el tipo como un nuevo documento
            SetTipo(1);
        } catch (Exception e) {
            fmMain.Mensaje("Error: "  + e);
        }

        //Carga Productos de la OC
        DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
        try {
            Rs = Sql.Select("select d.sku,p.nombre,u.um,d.cantidad,d.cantidad-d.cantidad as despachado, d.cantidad as diferencia,d.valorunitario, d.totallinea,\n" +
                    "       d.nrodocto,\n" +
                    "       d.tipdocto\n"
                    + "from ctacteclidet d\n"
                    + "left join producto p\n"
                    + "on d.sku=p.sku\n"
                    + "left join par_unidad u\n"
                    + "on u.codigo=p.unidad\n"
                    + "where nrodocto =" + numero.trim() + " \n"
                    + "and tipdocto ='" + STipDocto + "'" );
            while (Rs.next()) {
                TableModel.addRow(new Object[]{
                    Rs.getString("sku"),
                    Rs.getString("nombre"),
                    Rs.getString("um"),
                    fmMain.FormatoNumero(Rs.getDouble("cantidad")),
                    fmMain.FormatoNumero(Rs.getDouble("despachado")),
                    fmMain.FormatoNumero(Rs.getDouble("diferencia")),
                    fmMain.FormatoNumero(Rs.getDouble("valorunitario")), 0, 0,
                    fmMain.FormatoNumero(Rs.getDouble("totallinea")),
                    Rs.getDouble("valorunitario")});
            }
            Sumador();
            
//            //Carga Documentos Relacionados
//            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
//
//            Rs = Sql.Select("select case tipdocto when 'FAC' then 'Factura' when 'GDC' then 'Guia' when 'NCC' then 'N.Credito' when 'FEC' then 'F.Exenta' else 'Otro' end as tipo,nrodocto,femision \n" +
//                        "from ctactecli\n" +
//                        "where codigo_oc="+ CodigoOc +"\n" +
//                        "and occh='"+ Orden +"'");
//            while(Rs.next()){
//                dfTm2.addRow(new Object[]{
//                    Rs.getString("tipo"),
//                    Rs.getInt("nrodocto"),
//                    sdf.format(Rs.getDate("femision"))});
//            }
        } catch (Exception e) {
            System.out.println(e);
            fmMain.Mensaje("Error: "  + e);
        } finally {
            Sql.Close();
        }
        SetTipo(1);
        ValidaMargen();
    }
    
//-----------------------------------------------------------------------------
//  ABRIR ORDEN DE COMPRA
//-----------------------------------------------------------------------------
    private void AbrirOCC(String Rut, String Orden, String CodigoOc) {
        ExeSql Sql = new ExeSql();
        DefaultTableModel dfTm = (DefaultTableModel) Grilla.getModel();
        DefaultTableModel dfTm2 = (DefaultTableModel) GrillaDoc.getModel();
        ResultSet Rs;
        String strDirOC ="";
        
        //Carga Combos
        CargaCodOc(Rut);
        CargaContactos(Rut);
        while (dfTm.getRowCount() > 0) {
            dfTm.removeRow(0);
        }
        
        while (dfTm2.getRowCount() > 0) {
            dfTm2.removeRow(0);
        }

        //Trae Informacion de Orden de Compra
        try {
            Rs = Sql.Select("select *\n"
                    + "from occh\n"
                    + "where rut=" + Rut + "\n"
                    + "and upper(orden)='" + Orden.toUpperCase() + "'\n"
                    + "and codigo_oc=" + CodigoOc);
//            SetTipo(2);
            Rs.next();
            //Carga Datos
//                JOptionPane.showConfirmDialog(null, Rs.getDate("femision"));
            txNroOc.setText(Rs.getString("orden").trim());
            //txDirDespacho.setText(Rs.getString("dirdespacho").trim());
            if (Rs.getString("dirdespacho") == null)
            {
                strDirOC="";
            }
            else{
                strDirOC=Rs.getString("dirdespacho").trim();
                }
            dtEmision.setDate(Rs.getDate("femision"));
            chbPrioridad.setSelected(Rs.getBoolean("prioridad"));
            chbExenta.setSelected(Rs.getBoolean("esexento"));
            Prioridad = Rs.getBoolean("prioridad");
            Exento = Rs.getBoolean("esexento");

            txNeto.setText(fmMain.FormatoTotal(Rs.getDouble("totalafecto")));
            txExento.setText(fmMain.FormatoTotal(Rs.getDouble("totalexento")));
            txIva.setText(fmMain.FormatoTotal(Rs.getDouble("totaliva")));
            txImpEspecifico.setText(fmMain.FormatoTotal(Rs.getDouble("totalimpespecifico")));
            txTotal.setText(fmMain.FormatoTotal(Rs.getDouble("totaldocto")));
            
            if (Rs.getInt("vendedor")<=0)
            {
                cbVendedor.setSelectedIndex(0);
            }
            else
            {
            cbVendedor.setSelectedIndex(Rs.getInt("vendedor"));
            }

            switch (Rs.getInt("estado")) {
                case 0:
                    txDespacho.setText("PENDIENTE");
                    break;
                case 1:
                    txDespacho.setText("PARCIAL");
                    break;
                case 2:
                    txDespacho.setText("COMPLETO");
                    break;
            }

//            //Setea Combo Codigo OC 
//            for (int i = 0; i < cbCodigoOc.getItemCount(); i++) {
//                cbCodigoOc.setSelectedIndex(i);
//                if (cbCodigoOc.getSelectedItem().toString().equals(CodigoOc)) {
//                    break;
//                }
//            }
            
            
            cbCodigoOc.setSelectedItem(CodigoOc);
            PosCodigoOc = cbCodigoOc.getSelectedIndex();
            
            PosContacto = cbContacto.getSelectedIndex();
            // Setea contacto
            for (int i = 0; i <= cbContacto.getItemCount(); i++) {
                System.out.println("entra a Contacto");
                cbContacto.setSelectedIndex(i);
                System.out.println("compara");
                System.out.println(cbId_Accion(cbContacto));
                System.out.println(Rs.getInt("contacto"));
                if (cbId_Accion(cbContacto) == Rs.getInt("contacto")) {
                    break;
                }
            }
            
            
            SetTipo(2);
        } catch (Exception e) {
            fmMain.Mensaje("Error: "  + e);
        }

        //Carga Productos de la OC
        DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
        try {
            Rs = Sql.Select("select d.sku,p.nombre,u.um,d.cantidad,d.despachado, d.cantidad-d.despachado as diferencia,d.valorunitario,d.totlinea\n"
                    + "from occhdet d\n"
                    + "left join producto p\n"
                    + "on d.sku=p.sku\n"
                    + "left join par_unidad u\n"
                    + "on u.codigo=p.unidad\n"
                    + "where d.rut=" + Rut + "\n"
                    + "and d.codigo_oc=" + CodigoOc + " \n"
                    + "and upper(d.orden)='" + Orden.toUpperCase() + "'");
            while (Rs.next()) {
                TableModel.addRow(new Object[]{
                    Rs.getString("sku"),
                    Rs.getString("nombre"),
                    Rs.getString("um"),
                    fmMain.FormatoNumero(Rs.getDouble("cantidad")),
                    fmMain.FormatoNumero(Rs.getDouble("despachado")),
                    fmMain.FormatoNumero(Rs.getDouble("diferencia")),
                    fmMain.FormatoNumero(Rs.getDouble("valorunitario")), 0, 0,
                    fmMain.FormatoNumero(Rs.getDouble("totlinea")),
                    Rs.getDouble("valorunitario")});
            }
            Sumador();
            
            //Carga Documentos Relacionados
            
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yyyy");
            Rs = Sql.Select("select case tipdocto when 'FEC' then 'Factura Exenta' when 'FAC' then 'Factura' when 'NCC' then 'Nota de Credito' when 'GDC' then 'Guia de Despacho' when 'FMC' then 'Factura Manual' else 'No definido' end as tipo,\n" +
                        "nrodocto, femision\n" +
                        "from ctactecli\n" +
                        "where rut="+ Rut +"\n" +
                        "and codigo_oc="+ CodigoOc +"\n" +
                        "and occh='"+ Orden +"'");
            while(Rs.next()){
                dfTm2.addRow(new Object[]{
                    Rs.getString("tipo"),
                    Rs.getInt("nrodocto"),
                sdf2.format(Rs.getDate("femision"))});
                
            }
            
            //Copia direccion de OC ya que esta se modifica.
             //txDirDespacho.setText(strDirOC);  crm
            
        } catch (Exception e) {
            System.out.println(e);
            fmMain.Mensaje("Error: "  + e);
        } finally {
            Sql.Close();
        }
        SetTipo(2);
        ValidaMargen();
    }
//-----------------------------------------------------------------------------
//  BOTON IR
//-----------------------------------------------------------------------------
    private void btIrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIrActionPerformed
        boolean Carga;
        

        if(!txRut.getText().isEmpty()){
            Carga=CargaCliente(txRut.getText());
        }
        else{
            jdBuscarCliPrv BPC = new jdBuscarCliPrv(null, true);
            BPC.setLocationRelativeTo(null);
            BPC.setTitle("Buscar Cliente");
            BPC.SetTipo(1);
            BPC.setVisible(true);
            
            
            if (BPC.GetRut().isEmpty()){
                return    ;
            }
            else{
            Carga=CargaCliente(BPC.GetRut());    
            }
            
            
        }
        if(!Carga) SetTipo(-1);
        
        // Si cargó cliente y es nuevo.
        if(Carga && Tipo==0){
              SetTipo(1);  
        }
        // Si cargó cliente y esta abriendo
        if(Carga && Tipo==2){
            jdAbrirOCC AOC = new jdAbrirOCC(null, true);
                if(AOC.ShowModal(RutMaster)==JOptionPane.YES_OPTION){
                    
                    Tipo=0;
                    AbrirOCC(RutMaster, AOC.GetOrden(),AOC.GetCodigoOc());
                    CargaBlog();
                }
                else{
//                    txRut.setText("");
//                    txNombre.setText("");
//                    txRut.requestFocus();
                    SetTipo(-1);
                }
            
        }
    }//GEN-LAST:event_btIrActionPerformed
public void AbreOCC(String Rut,String Codigo_Oc, String Orden){
    MnuPorRut.doClick();
    Tipo=-99;
    txRut.setText(Rut);
    btIr.doClick();
    CargaContactos(Rut); 
    AbrirOCC(Rut, Orden, Codigo_Oc);
    CargaBlog();
}
//-----------------------------------------------------------------------------
//  BOTON DETALLE
//-----------------------------------------------------------------------------
    private void btDetalleConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDetalleConActionPerformed
            jdOCCContacto Contacto = new jdOCCContacto(null, true);
            Contacto.setLocationRelativeTo(null);
            Contacto.setTitle("Contacto");
            Contacto.CargaContacto(Integer.toString(cbId_Accion(cbContacto)));
            Contacto.setVisible(true);
    }//GEN-LAST:event_btDetalleConActionPerformed
//-----------------------------------------------------------------------------
//  BOTON AGREGAR PRODUCTO
//-----------------------------------------------------------------------------
    private void btAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarActionPerformed
            DefaultTableModel tbModel = (DefaultTableModel) Grilla.getModel();
            
            jdOCCAgregaProducto AgregaProducto = new jdOCCAgregaProducto(null,true);
            AgregaProducto.setLocationRelativeTo(null);
            AgregaProducto.setTitle("Agregar Producto");
            AgregaProducto.setVisible(true);
            if (fmMain.disc==1)
            {
                fmMain.Mensaje("No se puede agregar, producto discontinuado");
                return;
            }
                
            tbModel.addRow(AgregaProducto.GetFila());
           
            Sumador();
            btAgregar.requestFocus();
    }//GEN-LAST:event_btAgregarActionPerformed
//-----------------------------------------------------------------------------
//  BOTON ELIMINAR PRODUCTO
//-----------------------------------------------------------------------------
    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
     ExeSql Sql = new ExeSql();
     ResultSet Rs;   
     String Query ="";
        
        if(!Grilla.getValueAt(Grilla.getSelectedRow(), 0).toString().isEmpty())
        // Valida si tiene separados
            
        try{    
            Query = "select * from occhdet where " +
                   " rut = " + txRut.getText().trim() +
                   " and codigo_oc = " + cbCodigoOc.getSelectedItem().toString().trim() + " and " +
                   " orden ='" + txNroOc.getText() + "'"  +
                   " and sku = '" + Grilla.getValueAt(Grilla.getSelectedRow(), 0).toString().trim() + "'";
            
            Rs= Sql.Select(Query);
            if (Rs.next()){
                if (Rs.getDouble("separado")>0){
                    fmMain.Mensaje("No se puede Eliminar el producto " + Grilla.getValueAt(Grilla.getSelectedRow(), 1).toString().trim() + 
                            " de la orden ya que tiene " + Rs.getDouble("separado") + " productos separados!");
                    return;
                }
            }
            
            if (JOptionPane.showConfirmDialog(null, "¿Desea Eliminar el registro?") == JOptionPane.YES_OPTION) {
                DefaultTableModel tbMd = (DefaultTableModel) Grilla.getModel();
                int cual = Grilla.getSelectedRow();
                tbMd.removeRow(Grilla.getSelectedRow());
                Sumador();
                if (cual == Grilla.getRowCount()) {
                    Grilla.changeSelection(cual -1, 0, false, false);
                } else {
                    Grilla.changeSelection(cual, 0, false, false);
                }
                Grilla.requestFocus();
            }
         } catch (Exception e) {
                    Sql.Rollback();
                    LogError.Guardar(this.getClass().getSimpleName(),e.getMessage());
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                    fmMain.Mensaje("Error: "  + e);
                } finally {
                    Sql.Close();
                }       
    }//GEN-LAST:event_btEliminarActionPerformed
//-----------------------------------------------------------------------------
//  BOTON ABRIR
//-----------------------------------------------------------------------------
    private void btAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbrirActionPerformed
        Component source = (Component)evt.getSource();
        Point location = source.getLocation();
        Dimension size = source.getSize();
        
        int xPos = location.x + 20;
        int yPos = location.y + size.height;
        PMenu.show(source, 0, btAbrir.getHeight());        
            
 
    }//GEN-LAST:event_btAbrirActionPerformed

    
private String abrirArchivo() {
  String aux="";   
  String texto="";
  JFileChooser file=new JFileChooser();
  file.showOpenDialog(this);
  File abre=file.getSelectedFile();
  if(abre!=null)
  {
      
      texto = file.getSelectedFile().getPath();
      
  }
  return texto;
}







//-----------------------------------------------------------------------------
//  BOTON NUEVO
//-----------------------------------------------------------------------------
    private void btNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNuevoActionPerformed
        Tipo = 0;
        Limpia();
        Habilita(false);
        Edicion(false);
        txRut.setEnabled(true);
        btMercadoPublico.setEnabled(true);
        txRut.setEditable(true);
        cbVendedor.setEnabled(true);
        CargaVendedor();

        btIr.setEnabled(true);
        btNuevo.setEnabled(false);
        btAbrir.setEnabled(false);
        btGuardar.setEnabled(true);
        btCancelar.setEnabled(true);
        txRut.requestFocus();
        lbInfo.setVisible(false);
        
        
        ExeSql Sql= new ExeSql();
        ResultSet Rs;       

        jdAbrirDocto Abrir = new jdAbrirDocto(null, true);
       Abrir.setLocationRelativeTo(null);
       Abrir.setVisible(true);
       if(!Abrir.GetNumero().isEmpty()){
           String StrGuia = Abrir.GetNumero();
           String STipDocto = Abrir.GetDoc();
           pu_NumeroGuia = StrGuia;
           pu_TipDocto = STipDocto;
           
          // Habilita el boton agregar si es de Tipo FAT
          btAgregar.setVisible(true);
           
           
           
          if(!StrGuia.isEmpty()){
           String Query = "  select rut,\n" +
                            "       codigo_oc,\n" +
                            "       occh,\n" +
                            "       nrodocto,\n" +
                            "       tipdocto\n" +
                            " from ctactecli\n" +
                            " where nrodocto = " + StrGuia.trim() + "  and \n" +
                            "      tipdocto = '" + STipDocto.trim() + "'";
           
        try{   
            Rs = Sql.Select(Query);
            if (Rs.next())
            {
            AbrirOCCGuia(StrGuia ,  STipDocto);
            }
           //Limpia Grilla Doc
           DefaultTableModel   dfTm1 = (DefaultTableModel) GrillaDoc.getModel();
           fmMain.LimpiaGrilla(dfTm1);
           txRut.setEditable(true);
           txRut.setEnabled(true);
        } catch (Exception e) 
            {
                System.out.println(e.getMessage());
                fmMain.Mensaje("Error: "  + e);
            }
            finally{
                Sql.Close();
           }   
       }
       
       
       
       
    }//GEN-LAST:event_btNuevoActionPerformed
}
//-----------------------------------------------------------------------------
//  BOTON NUEVO
//-----------------------------------------------------------------------------
    private int BoolToInt(boolean Input) {    
        if(Input==true)
                return 1;
        else
                return 0;
    }

    private void ImprimeEnBodega() {
        URL in = this.getClass().getResource("/Reportes/repOCCBodega.jasper");

        HashMap<String, Object> parametros = new HashMap<>();
        try {

            parametros.put("Codigo_OC", Integer.valueOf(cbCodigoOc.getSelectedItem().toString()));
            parametros.put("RutCliente", Integer.valueOf(txRut.getText()));
            parametros.put("NombreCliente", txNombre.getText());
            parametros.put("Orden", txNroOc.getText().trim());
            parametros.put("Indice", txRut.getText() + "@" + txNroOc.getText().trim() + "@" + txNroOc.getText().trim());
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:postgresql://192.168.0.150:5432/luvaly_final", "dalcaman", "goliat");
            conn.setAutoCommit(false);

            JasperPrint print = JasperFillManager.fillReport((JasperReport) JRLoader.loadObject(in), parametros, conn);
//            JasperPrintManager.printReport(print, false);//Imprimir el informe

            PrinterJob job = PrinterJob.getPrinterJob();
            /* Create an array of PrintServices */
            PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
            int selectedService = 0;
            /* Scan found services to see if anyone suits our needs */
            for (int i = 0; i < services.length; i++) {
                if (services[i].getName().contains("Termica Recepcion")) {
//    if(services[i].getName().contains("PDFCreator")){
/*If the service is named as what we are querying we select it */
                    selectedService = i;
                }
            }
            JRPrintServiceExporter exporter;
            exporter = new JRPrintServiceExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, services[selectedService]);
            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);
            exporter.exportReport();

            exporter.print(null, null, 1);
        } catch (Exception e) {
            System.out.println(e);
            fmMain.Mensaje("Error: "  + e);
        }
    }
    private void ValidaMargen(){
        ExeSql Sql = new ExeSql();
        
        try {
            lbInfoMargen.setText(Sql.SelectUnico("select * from fn_margen_occ(" + txRut.getText() + "," + cbCodigoOc.getSelectedItem().toString().trim() + ",'" + txNroOc.getText().trim() +"')"));
        } catch (Exception e) {
        }finally{
            Sql.Close();
        }
    }
//-----------------------------------------------------------------------------
//  BOTON GUARDAR
//-----------------------------------------------------------------------------
    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
        ExeSql Sql = new ExeSql();
        ExeSql Sql2 = new ExeSql();
        String Msje="";
        ResultSet RsC;
        int intEstadoPendiente=4; 
        boolean booEstadoPendiente =false;
        String Codigos = "", Qry;
        int codigoVendedor;
        if (txNroOc.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Falta ingresar orden");
            return;
        }
        
        //fmMain.Mensaje(pu_NumeroGuia + "-" + pu_TipDocto); 
        //Se valida si la Grilla Si tiene los productos de la Guia Original, sino se tendran que autorizar.
        
//        
//        String strSku="";
//        int inCuenta =Grilla.getRowCount();
//        for (int i = 0; i < Grilla.getRowCount(); i++) {
//            strSku = strSku + "'" + Grilla.getModel().getValueAt(i, GetCol("Sku")).toString().trim() + "',";   
//        }
        
        List <String> Skus;
        Skus = new ArrayList<>();
        
        List <Double> Cant;
        Cant = new ArrayList<>();

        
        try {
        Qry = "select sku,cantidad from ctacteclidet\n" +
            "where \n" +
            "tipdocto='" + pu_TipDocto + "' \n" +
            "and nrodocto= " + pu_NumeroGuia + " \n";
            
        
        RsC = Sql2.Select(Qry);
        
        while (RsC.next()){
            Skus.add((RsC.getString("sku").trim()));
            Cant.add((RsC.getDouble("cantidad")));
        }
        
         } catch (Exception e) {
                System.out.println(e.getMessage());
                fmMain.Mensaje("Error: "  + e);
            }finally{
                Sql2.Close();
         }
        
        
//    for (int i = 0; i < Grilla.getRowCount(); i++) {
//          if (Skus.contains(Grilla.getModel().getValueAt(i, 0)) == false)
//          {
//              booEstadoPendiente=true;
//             Msje = "La orden se guardara en un estado pendiente de autorización \n" +
//                    " ya que el Sku " + Grilla.getModel().getValueAt(i, 0) +  " " + Grilla.getModel().getValueAt(i, GetCol("Nombre")).toString().trim()  + "\n" +
//                    " No pertenece a la Guia Original."; 
//              fmMain.Mensaje(Msje);
//              break;
//          }
//        }
    
    // revisa si tiene algun Sku Adicional
           for (int i = 0; i < Grilla.getRowCount(); i++) {
                for (int j = 0; j <= Skus.size()-1; j++) 
                {
                        if (!Grilla.getModel().getValueAt(i, 0).toString().trim().equals(Skus.get(j)))
                        {
                                booEstadoPendiente=true;
                        }  
                        else
                        {
                            booEstadoPendiente=false;
                            break;
                        }
                }
                if (booEstadoPendiente ==true)
                {
                    Msje = "La orden se guardara en un estado pendiente de autorización \n" +
                                       " ya que el Sku " + Grilla.getModel().getValueAt(i, 0) +  " " + Grilla.getModel().getValueAt(i, GetCol("Nombre")).toString().trim()  + "\n" +
                                       " No pertenece a la Guia Original."; 
                    fmMain.Mensaje(Msje);
                    break;
                }
            }
    

        if (booEstadoPendiente==false)
        {
            // Revision de las cantidades
            
//          for (int i = 0; i < Grilla.getRowCount(); i++) {
//          if (Skus.get(i).equals(Grilla.getModel().getValueAt(i, 0).toString().trim()))
//          {
//              if (Cant.get(i) < Double.valueOf( Grilla.getModel().getValueAt(i, GetCol("Cantidad")).toString())  )
//              {
//                  booEstadoPendiente=true;
//                  
//                  Msje = "La orden se guardara en un estado pendiente de autorización \n"  +
//                          " ya que para el Sku " + Skus.get(i) + " la cantidad es mayor que " + Cant.get(i);
//                   fmMain.Mensaje(Msje);
//                    break;
//              }
//          }
//        }
          
               for (int i = 0; i < Grilla.getRowCount(); i++) {
                for (int j = 0; j < Skus.size()-1; j++) 
                {
                        if (Skus.get(j).equals(Grilla.getModel().getValueAt(i, 0).toString().trim()))
                        {
                         
                            String Cantidad = Grilla.getModel().getValueAt(i, GetCol("Cantidad")).toString().replaceAll(",", "");
                            
                             //if (Cant.get(j) < Double.valueOf( Grilla.getModel().getValueAt(i, GetCol("Cantidad")).toString())  )
                            if (Cant.get(j) < Double.valueOf(Cantidad)  )
                            {
                                booEstadoPendiente=true;

                                Msje = "La orden se guardara en un estado pendiente de autorización \n"  +
                                        " ya que para el Sku " + Grilla.getModel().getValueAt(i, 0) +  " " + Grilla.getModel().getValueAt(i, GetCol("Nombre")).toString().trim() + " la cantidad es mayor que " + Cant.get(j);
                                 fmMain.Mensaje(Msje);
                                  break;
                            }
                        }  
                }
            }
        }//IF   
    
        
//         if (booEstadoPendiente==true)
//         {    
//            fmMain.Mensaje("Pendiente =true");
//         }   
//         else
//         {    
//            fmMain.Mensaje("Pendiente =false");
//         }   
        
        
        
        
    
        if (cbCodigoVendedor.getSelectedItem().toString().trim().equals("Codigo") )
            {
            codigoVendedor=0;
            }
        else
        {
            codigoVendedor = Integer.valueOf(cbCodigoVendedor.getSelectedItem().toString().trim());
        }

        if(fmMain.OkCancel("¿Guardar Documento?")== JOptionPane.OK_OPTION){
            String Query = "";
            Prioridad = chbPrioridad.isSelected();
            Exento = chbExenta.isSelected();
            PosContacto = cbContacto.getSelectedIndex();

            //GUARDA NUEVA OCC
            //----------------
            if (Tipo == 1) {
                try {
                    
                    Query = "INSERT INTO occh\n"
                            + "(vendedor, rut, codigo_oc, orden, femision,contacto, totalafecto,totalexento, totaliva, totaldocto, "
                            //+ " dirdespacho,"
                            + " prioridad,esexento,es_transporte,";
                    if (booEstadoPendiente==true){
                        Query = Query + " estado ,"; 
                    }
                    
                            Query = Query +  " guia_transporte)\n"
                            + "VALUES \n"
                            + "("
                            + codigoVendedor+ ","
                            + txRut.getText() + ","
                            + cbCodigoOc.getSelectedItem().toString().trim() + ","
                            + "'" + txNroOc.getText().toLowerCase().trim() + "',"
                            + "'" + getFechaAsString() + "',"
                            + cbId_Accion(cbContacto) + ","
                            + fmMain.SetGuardar(txNeto.getText()) + ","
                            + fmMain.SetGuardar(txExento.getText()) + ","
                            + fmMain.SetGuardar(txIva.getText()) + ","
                            + fmMain.SetGuardar(txTotal.getText()) + ","
                            //+ txDirDespacho.getText() + "',"
                            + BoolToInt(chbPrioridad.isSelected()) + ","
                            + BoolToInt(chbExenta.isSelected()) + "," + true + ",";
                             if (booEstadoPendiente==true){
                                    Query = Query + intEstadoPendiente + ","; 
                                }       
                            Query = Query +  pu_NumeroGuia + ")";

                    Sql.ExeSql(Query);

                    if (booEstadoPendiente==true){
                    Sql.ExeSql("insert into autorizaciones\n" +
                        "(tipo,rut,codigo_oc,orden,solicita)values\n" +
                        "('AUTORIZA_OCT',"+ txRut.getText().trim() +","+ cbCodigoOc.getSelectedItem().toString().trim() +",'"+  txNroOc.getText().toLowerCase().trim() +"',user)");
                    }
                    
                    // Guarda Productos
                    for (int i = 0; i < Grilla.getRowCount(); i++) {
                        
                        Query = " INSERT INTO occhdet( rut, codigo_oc, orden, sku, cantidad, valorunitario, totlinea)\n"
                                + " VALUES ("
                                + txRut.getText() + ","
                                + cbCodigoOc.getSelectedItem().toString().trim() + ","
                                + "'" + txNroOc.getText().toLowerCase().trim()
                                + "','"
                                + Grilla.getModel().getValueAt(i, GetCol("Sku")).toString() + "',"
                                + fmMain.SetGuardar(Grilla.getModel().getValueAt(i, GetCol("Cantidad")).toString()) + ","
                                + fmMain.SetGuardar(Grilla.getModel().getValueAt(i, GetCol("UniReal")).toString()) + ","
                                + fmMain.SetGuardar(Grilla.getModel().getValueAt(i, GetCol("Total")).toString()) + ")";
                               
                                
                        Sql.ExeSql(Query);
                    }

                    Sql.Commit();
//                    ImprimeEnBodega();
                    JOptionPane.showMessageDialog(null, "Orden Guardada");
                    ValidaMargen();
                    SetTipo(2);
                } catch (Exception e) {
                    Sql.Rollback();
                    LogError.Guardar(this.getClass().getSimpleName(),e.getMessage());
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                    fmMain.Mensaje("Error: "  + e);
                } finally {
                    Sql.Close();
                }

            } //GUARDA OCC ABIERTA
            //------------------
            else {
                try {
                    // ACTUALIZA ENCABEZADO                
                    Query = "UPDATE occh SET \n"
                            + "contacto="           + cbId_Accion(cbContacto) + ", \n"
                            + "  totalafecto="      + fmMain.SetGuardar(txNeto.getText()) + ","
                            + "       totalexento=" + fmMain.SetGuardar(txExento.getText()) + ","
                            + "       totaliva="    + fmMain.SetGuardar(txIva.getText()) + ","
                            + "       totaldocto="  + fmMain.SetGuardar(txTotal.getText()) + ","
                            //+ "       dirdespacho='"+ txDirDespacho.getText() + "', " crm
                            + "       femision='"   + getFechaAsString() + "', "
                            + "       esexento="    +  BoolToInt(chbExenta.isSelected()) + ",\n"
                            + "       prioridad="   + BoolToInt(chbPrioridad.isSelected()) + ",\n"
                            + "       codigo_oc="   + cbCodigoOc.getSelectedItem().toString().trim() + ",\n"
                            + "       orden='"       + txNroOc.getText().trim().toLowerCase().trim() + "',\n"
                            + "       vendedor="    + codigoVendedor + "\n"
                            + " WHERE rut= "        + txRut.getText()
                            + "   AND codigo_oc="   + Master_Codigo_Oc
                            + "   AND orden='"      + Master_Orden + "'";
                    Sql.ExeSql(Query);

               // ACTUALIZA EL DETALLE
                    ResultSet Rs;
                    for (int i = 0; i < Grilla.getRowCount(); i++) {

                        // 1.- Verifica si existe 
                        Rs = Sql.Select("select count(*) as Existe from occhdet \n"
                                + "  where  rut= " + txRut.getText()
                                + "  and codigo_oc=" + Master_Codigo_Oc
                                + "  and orden='" + Master_Orden + "'\n"
                                + "  and sku='" + Grilla.getModel().getValueAt(i, GetCol("Sku")).toString() + "'");
                        Rs.next();

                        // 2.- Si Existe UPDATE
                        if (Rs.getInt("Existe") > 0) {
                            Query = "  update occhdet set \n"
                                    + "cantidad = " + fmMain.SetGuardar(Grilla.getModel().getValueAt(i, GetCol("Cantidad")).toString()) + ",\n"
                                    + "valorunitario=" + fmMain.SetGuardar(Grilla.getModel().getValueAt(i, GetCol("UniReal")).toString()) + ",\n"
                                    + "totlinea =" + fmMain.SetGuardar(Grilla.getModel().getValueAt(i, GetCol("Total")).toString()) + ",\n"
                                    + "codigo_oc=" + cbCodigoOc.getSelectedItem().toString().trim() + ",\n"
                                    + "orden='" + txNroOc.getText().trim().toLowerCase() + "'\n"
                                    + "where  rut= " + txRut.getText() + "\n"
                                    + "and codigo_oc=" + Master_Codigo_Oc + "\n"
                                    + "and orden='" + Master_Orden + "'\n" 
                                    + "and sku='" + Grilla.getModel().getValueAt(i, GetCol("Sku")).toString() + "'";
                        } // 3.- Si no existe INSERT
                        else {
                            Query = " INSERT INTO occhdet( rut, codigo_oc, orden, sku, cantidad, valorunitario, totlinea)\n"
                                    + " VALUES ("
                                    + txRut.getText() + ","
                                    + cbCodigoOc.getSelectedItem().toString().trim() + ","
                                    + "'" + txNroOc.getText().toLowerCase() + "','"
                                    + Grilla.getModel().getValueAt(i, GetCol("Sku")).toString() + "',"
                                    + fmMain.SetGuardar(Grilla.getModel().getValueAt(i, GetCol("Cantidad")).toString()) + ","
                                    + fmMain.SetGuardar(Grilla.getModel().getValueAt(i, GetCol("UniReal")).toString()) + ","
                                    + fmMain.SetGuardar(Grilla.getModel().getValueAt(i, GetCol("Total")).toString()) + ")";
                        }
                        Sql.ExeSql(Query);

                        Codigos = Codigos + "'" + Grilla.getModel().getValueAt(i, GetCol("Sku")).toString().trim() + "',";
                    }

                    // ELIMINA LOS PRODUCTOS QUE YA NO PERTENECEN a la oc
                    Query = "DELETE from occhdet \n"
                            + "WHERE  rut= " + txRut.getText() + "\n"
                            + "AND codigo_oc=" + Master_Codigo_Oc + "\n"
                            + "AND orden='" + Master_Orden + "'\n" 
                            + "AND sku not in (" + Codigos.substring(0, Codigos.length() - 1) + ")";
                    Sql.ExeSql(Query);

                    Sql.Commit();
                    JOptionPane.showMessageDialog(null, "Orden Guardada");
                    ValidaMargen();
                    SetTipo(2);
                } catch (Exception e) {
                    Sql.Rollback();
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                    fmMain.Mensaje("Error: "  + e);
                } finally {
                    Sql.Close();
                }

            }
        }
    }//GEN-LAST:event_btGuardarActionPerformed

    private void btDetalleCon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDetalleCon1ActionPerformed
//        jdTrasnporte TR = new jdTrasnporte(null, true);
//        TR.setLocationRelativeTo(null);
//        TR.setVisible(true);
    }//GEN-LAST:event_btDetalleCon1ActionPerformed

    public void CargaVendedor()
        {
            ExeSql Sql= new ExeSql();
            ResultSet Rs;
           
            try {
                cbVendedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
                cbVendedor.addItem("Vendedor Luvaly");
                cbCodigoVendedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
                cbCodigoVendedor.addItem("Codigo");
                Rs = Sql.Select("select nombre, vendedor\n" +
                                "from personal\n" +
                                "where vendedor>0 order by vendedor");
               
                while( Rs.next()){
                    cbVendedor.addItem(Rs.getString("nombre"));
                    cbCodigoVendedor.addItem(Rs.getString("vendedor"));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                fmMain.Mensaje("Error: "  + e);
            }finally{
                Sql.Close();
            }

        }
    private void btGDCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGDCActionPerformed
        pfGDCliente GDC = new pfGDCliente();
        GDC.setOpaque(false);
        pnPestanas.addTab("GUÍA DE DESPACHO", GDC);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(GDC), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
        GDC.NuevaGuia(txRut.getText(), cbCodigoOc.getSelectedItem().toString(), txNroOc.getText());
        
    }//GEN-LAST:event_btGDCActionPerformed

    private void btFACActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFACActionPerformed
       jPanel4.setEnabled(false);
        cbCodigoOc.setEditable(false);
    }//GEN-LAST:event_btFACActionPerformed

    private void txDirDespachoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txDirDespachoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txDirDespachoActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        Master_Orden = txNroOc.getText().trim();
        SetTipo(3);
    }//GEN-LAST:event_btEditarActionPerformed

    private void dtEmisionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dtEmisionMouseClicked
        if(Tipo==2)
            evt.consume();
    }//GEN-LAST:event_dtEmisionMouseClicked

    private void cbCodigoOcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCodigoOcActionPerformed
        if(Tipo==2 || Tipo==-1 || Tipo == 3)
            cbCodigoOc.setSelectedIndex(PosCodigoOc);
        else{
            ExeSql Sql= new ExeSql();
            ResultSet Rs;
            
            try {
                Rs = Sql.Select("select morosidad,bloqueo,direccion\n" +
                                "from clicontacto\n" +
                                "where rut="+ txRut.getText().trim() +"\n" +
                                "and codigo_oc="+ cbCodigoOc.getSelectedItem().toString().trim());
                Rs.next();
                if(Rs.getInt("bloqueo")==1){
                    lbInfo.setVisible(true);
                    lbInfo.setText("Cliente Bloqueado.");
                }
//                else if (Rs.getInt("morosidad")==1){
//                    lbInfo.setVisible(true);
//                    lbInfo.setText("Cliente con facturas vencidas");
//                }
                else{
                    lbInfo.setVisible(false);
                }
                
                // txDirDespacho.setText(Rs.getString("direccion").trim()); crm
                    
            } catch (Exception e) {
                System.out.println(e.getMessage());
                fmMain.Mensaje("Error: "  + e);
            }finally{
                Sql.Close();
            }
        }
    }//GEN-LAST:event_cbCodigoOcActionPerformed

    private void chbPrioridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbPrioridadActionPerformed
        if(Tipo==2 || Tipo==-1){
            chbPrioridad.setSelected(Prioridad);
        }
    }//GEN-LAST:event_chbPrioridadActionPerformed

    private void GrillaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrillaMouseClicked
        DefaultTableModel tbModel = (DefaultTableModel) Grilla.getModel();
        try {
            
        
        if(evt.getClickCount()==2 && Tipo==1 || Tipo==3){
            jdOCCAgregaProducto AgregaProducto = new jdOCCAgregaProducto(null,true);
            AgregaProducto.setLocationRelativeTo(null);
            AgregaProducto.setTitle("Agregar Producto");
            AgregaProducto.SetProducto(Grilla.getValueAt(Grilla.getSelectedRow(),GetCol("Sku")).toString().trim(),
                                       Grilla.getValueAt(Grilla.getSelectedRow(),GetCol("Cantidad")).toString(),
                                       Grilla.getValueAt(Grilla.getSelectedRow(),GetCol("UniReal")).toString()
                                       );
            AgregaProducto.setTipDocto("FAT");
            AgregaProducto.setVisible(true);
            if(AgregaProducto.GetFila()!=null){
                
                tbModel.insertRow(Grilla.getSelectedRow(), AgregaProducto.GetFila());
                tbModel.removeRow(Grilla.getSelectedRow());
                Sumador();
            }
        }
        } catch (Exception e) {
            System.out.println(e);
        }
            
    }//GEN-LAST:event_GrillaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ImprimeEnBodega();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void chbExentaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chbExentaStateChanged
        if(Tipo==2 || Tipo==-1){
            chbExenta.setSelected(Exento);
        }
        else{
        Sumador();
        }
    }//GEN-LAST:event_chbExentaStateChanged

    private void txDirDespachoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txDirDespachoKeyTyped
        if (Character.isLowerCase(evt.getKeyChar()))
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));        // TODO add your handling code here:
    }//GEN-LAST:event_txDirDespachoKeyTyped

    private void btEliminarOCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarOCCActionPerformed
        ExeSql Sql = new ExeSql();
        
        if(Tipo!=2) return;
        
        if (fmMain.OkCancel("¿Desea eliminar ésta orden?") == JOptionPane.OK_OPTION) {
            try {
                Sql.ExeSql("delete from occh\n"
                        + "where rut=" + txRut.getText().trim() + "\n"
                        + "and codigo_oc=" + cbCodigoOc.getSelectedItem().toString().trim() + "\n"
                        + "and orden='" + txNroOc.getText().trim() + "'");
                Sql.Commit();
                JOptionPane.showMessageDialog(null, "Orden Eliminada");
                SetTipo(-1);
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
                Sql.Rollback();
            } finally {
                Sql.Close();
            }
        }


    }//GEN-LAST:event_btEliminarOCCActionPerformed

    private void MnuPorRutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuPorRutActionPerformed
        Habilita(false);
        Edicion(false);
        Limpia();
        txRut.setEnabled(true);
        txRut.setEditable(true);
        btIr .setEnabled(true);
        btCancelar.setEnabled(true);
        txRut.requestFocus();
        Tipo=2;
    }//GEN-LAST:event_MnuPorRutActionPerformed

    private void MnuDirectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuDirectoActionPerformed
    ExeSql Sql= new ExeSql();
    ResultSet Rs;       

    
//       jdAbrirOCCDirecto Abrir = new jdAbrirOCCDirecto(null, true);
//       Abrir.setLocationRelativeTo(null);
//       Abrir.setVisible(true);
//       if(!Abrir.GetOrden().isEmpty()){
//           String StrGuia = Abrir.GetOrden();
//           String Query = "  select rut,\n" +
//                            "       codigo_oc,\n" +
//                            "       occh,\n" +
//                            "       nrodocto,\n" +
//                            "       tipdocto\n" +
//                            " from ctactecli\n" +
//                            " where nrodocto = " + StrGuia + "  and \n" +
//                            "      tipdocto = 'GDC'";
//           
//        try{   
//            
//            
//            Rs = Sql.Select(Query);
//            
//            
//            if (Rs.next())
//            {
//                
//            AbrirOCCDirecta(Rs.getString("codigo_oc").trim() ,  Rs.getString("occh").trim());
//            }
//           CargaBlog();
//        } catch (Exception e) 
//            {
//                System.out.println(e.getMessage());
//                fmMain.Mensaje("Error: "  + e);
//            }
//            finally{
//                Sql.Close();
//           }   
//       }
       
       jdAbrirOCCDirecto Abrir = new jdAbrirOCCDirecto(null, true);
       Abrir.setLocationRelativeTo(null);
       Abrir.setVisible(true);
       if(!Abrir.GetOrden().isEmpty()){
           String Orden = Abrir.GetOrden();
           int Pos = Orden.indexOf("-");
           AbrirOCCDirecta(Orden.substring(0, Pos),Orden.substring(Pos+1));
           CargaBlog();
       }       
    }//GEN-LAST:event_MnuDirectoActionPerformed

    private void dtEmisionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dtEmisionKeyPressed


    }//GEN-LAST:event_dtEmisionKeyPressed

    private void dtEmisionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dtEmisionKeyTyped
                char car =evt.getKeyChar();
                   if(((car<'0') || (car>'9')) && ((car<'.') || (car>'.')))
                {

                  evt.consume(); 
                }   
    }//GEN-LAST:event_dtEmisionKeyTyped

    private void cbVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbVendedorActionPerformed
        cbCodigoVendedor.setSelectedIndex(cbVendedor.getSelectedIndex());
    }//GEN-LAST:event_cbVendedorActionPerformed

    private void GrillaDocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrillaDocMouseClicked
        ExeSql Sql = new ExeSql();
        if (evt.getClickCount() == 2) {
            try {
                final String Tipo;
                final String Numero;
                String server,user,pass,ruta_local="";
                int puerto =21;
                String filtro="";
                String archivo_local = "";
                
                ResultSet Rs;
                if(GrillaDoc.getValueAt(GrillaDoc.getSelectedRow(), 0).toString().toUpperCase().contains("FACTURA"))
                    Tipo="33";
                else if (GrillaDoc.getValueAt(GrillaDoc.getSelectedRow(), 0).toString().toUpperCase().contains("CREDITO"))
                    Tipo="61";
                else if (GrillaDoc.getValueAt(GrillaDoc.getSelectedRow(), 0).toString().toUpperCase().contains("GUIA"))
                    Tipo="52";
                else if (GrillaDoc.getValueAt(GrillaDoc.getSelectedRow(), 0).toString().toUpperCase().contains("EXENTA"))
                    Tipo="34";
                else
                    Tipo="52";
                Numero=GrillaDoc.getValueAt(GrillaDoc.getSelectedRow(), 1).toString().trim();
                //---------                     Trae Datos Ftp            ----------------------
                //Creado por CRM - 15-06-2017
                //trae datos ftp
                server="";
                puerto=0;
                user="";
                pass="";
                Rs = Sql.Select("SELECT * from conexiones where tipo='ftp_dte'");
                if (Rs.next())
                {
                    server = Rs.getString("serv");
                    user  = Rs.getString("usu");
                    puerto  = Rs.getInt("port");
                    pass = Rs.getString("pass");
                }
                //                  //Verifica SO
                String sistema = System.getProperty("os.name").toLowerCase();
                File folder = new File("");
                if (sistema.contains("win"))
                {
                    ruta_local = "c:/" + carpeta + "/";
                    folder = new File(ruta_local.substring(0,ruta_local.length()-1));
                }
                else{
                    ruta_local = "/" + carpeta + "/";
                    folder = new File(ruta_local);
                    }
                if (!folder.exists())
                {
                    folder.mkdir();
                }
                // Primer buscara el archivo en ruta local
                filtro = Tipo + "F" + Numero + ".pdf";
                archivo_local = BuscaArchivos(new File(ruta_local),filtro);
                Ftp.busca_archivo_ftp(server, puerto, user, pass, ruta_local,archivo_local, filtro);
            
                
//-------------------------------codigo Anterior------------------------------------------            
//            String path="";
//            String sistema = System.getProperty("os.name").toLowerCase();
//            if (sistema.contains("win"))
//            {
//               System.out.println(sistema);
//               path = "\\\\192.168.0.130\\Documentos Electronicos\\"; 
//            }
//            else{
//               System.out.println(sistema);
//               path = "/mnt/DocElectronicos/";
//                
//            }
                
                
                
                
//            String files;
//            File folder = new File(path);
//            File[] listOfFiles = folder.listFiles(new FilenameFilter() {
//                @Override
//                public boolean accept(File folder, String Nombre) {
//                    return Nombre.contains(Tipo + "F" + Numero);
//                }
//            });
//            for (int i = 0; i < listOfFiles.length; i++)         {
//
//            if (listOfFiles[i].isFile())             {
//                
//                files = listOfFiles[i].getName();
//                try {
//                    File pathCompleto = new File(path + files);
//                    Desktop.getDesktop().open(pathCompleto);
//                } catch (IOException ex) {
//                    fmMain.Mensaje("Error al abrir: "+ex);
//                }
//            }
//        }
//----------------------------------------------------------------------------------------------
            } catch (SQLException ex) {
                Logger.getLogger(pfOCTransporte.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally {
                Sql.Close();
            }
        }
    }//GEN-LAST:event_GrillaDocMouseClicked

    private void txRutKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRutKeyTyped
     char c=evt.getKeyChar(); 
     if(Character.isLetter(c)) { 
              getToolkit().beep(); 
              evt.consume(); 
              System.out.println("Ingresa Solo Letras -->" + c ); 
               
          }         // TODO add your handling code here:
    }//GEN-LAST:event_txRutKeyTyped

    private void txNroOcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNroOcKeyTyped
        // TODO add your handling code here:char c=evt.getKeyChar();  
      char c=evt.getKeyChar(); 
               if(c == ' ') { 
              getToolkit().beep(); 
              evt.consume(); 
              System.out.println("Ingresar sin espacios  ." ); 
         }  
    }//GEN-LAST:event_txNroOcKeyTyped

    private void txNroOcKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNroOcKeyReleased
             txNroOc.setText( txNroOc.getText().toLowerCase());
    }//GEN-LAST:event_txNroOcKeyReleased
   
    private void btMercadoPublicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMercadoPublicoActionPerformed
        String ocmp = JOptionPane.showInputDialog("Ingrese OC Mercado publico:");
        String cod_oc = "";
        String orden = "";
        sku_sinasociar="";
        
        //Limpiar Grilla
        DefaultTableModel tbModel = (DefaultTableModel) Grilla.getModel();
        fmMain.LimpiaGrilla(tbModel);
        int cuenta=0;
        for (int x=0; x<=ocmp.length(); x++)
                                {
                                  if (ocmp.substring(0, x).contains("-") && cuenta<=0)
                                          {
                                            cod_oc=ocmp.substring(0, x);
                                            cuenta++;
                                            //System.out.println(precio_primero);
                                          }
                                }
        cod_oc = cod_oc.replaceAll("-","").trim();
        orden =  ocmp.substring(cod_oc.length()+1,ocmp.length()).trim();           
               
        SAXBuilder builder = new SAXBuilder(); 
        //String ocmp = "2281-224-cm18";
        try{
        Document OrdenCompra = (Document) builder.build("http://api.mercadopublico.cl/servicios/v1/publico/ordenesdecompra.xml?codigo="+ocmp+"&ticket=ABF46B87-D82E-4497-BEE4-BE934CBE5DD7");
                
        Element rootNode       = OrdenCompra.getRootElement();
        Element Listado        = (Element) rootNode.getChild("Listado");
        Element OC             = (Element) Listado.getChild("OrdenCompra");
        Element Fechas         = (Element) OC.getChild("Fechas");
        Element Comprador      = (Element) OC.getChild("Comprador");
        Element NombreContacto = (Element) Comprador.getChild("NombreContacto");
        Element TotalNeto      = (Element) OC.getChild("TotalNeto");
        Element Observaciones  = (Element) OC.getChild("Descripcion");
        Element Descuentos     = (Element) OC.getChild("Descuentos");
        Element Items          = (Element) OC.getChild("Items");
        Element ItemsListado   = (Element) Items.getChild("Listado");
        
        //CALCULAR PORCENTAJE DE DESCUENTO
        String Observacion = Observaciones.getValue().trim().toLowerCase();
        double descuento = Double.valueOf(Descuentos.getValue().trim());
        double totalneto = Double.valueOf(TotalNeto.getValue().trim());
        double porcentajedesc = (descuento*100)/totalneto;
        
        String Femision = Fechas.getChildText("FechaEnvio");
        Femision = Femision.substring(0, 10);
        Femision = Femision.replace("-", "//");
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy//MM//dd");
        Date fe = sdf.parse(Femision);
        Calendar c = Calendar.getInstance();
        c.setTime(fe);
        
        
        String rutcli = Comprador.getChildText("RutUnidad");
        rutcli = rutcli.substring(0, rutcli.length() - 2);
        rutcli = rutcli.replace(".", "");
        
        //fmMain.Mensaje(rutcli);
        if (Observacion.contains("rut"))
                        {
                        if(JOptionPane.showConfirmDialog(null, "El rut de facturacion es el mismo de la OC?") == JOptionPane.NO_OPTION){
                        String rutfactura = JOptionPane.showInputDialog("Ingrese RUT de FACTURACION (sin puntos ni guion ej 12.345.678-9 -> 12345678):"); 
                        txRut.setText(rutfactura);
                        btIr.doClick();
                        rutcli=rutfactura;
                        }                    
                    }
        txRut.setText(rutcli);
        btIr.doClick();
        cbCodigoOc.setSelectedItem(cod_oc);
        if (!cbCodigoOc.getSelectedItem().equals(cod_oc)){
            fmMain.Mensaje("El codigo de OC no esta creado!");
            Limpia();
            Habilita(false);
            btGuardar.setEnabled(false);
            btCancelar.setEnabled(false);
            btNuevo.setEnabled(true);
            btEditar.setEnabled(false);
            btAbrir.setEnabled(true);
            pfClientes Cli = new pfClientes();
            pnPestanas.addTab("Nuevo Cliente", Cli);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Cli), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
            Cli.txRut.setText(rutcli);
            Cli.btIr.doClick();
            Cli.btEditar.doClick();
            Cli.btNuevoOC.doClick();
            return;
            }
        txNroOc.setText(orden.toLowerCase());
        dtEmision.setDate(fe);
        String Contacto = Comprador.getChildText("NombreContacto").trim();
        Contacto = Normalizer.normalize(Contacto, Normalizer.Form.NFD);
        Contacto = Contacto.replaceAll("[^\\p{ASCII}]", "");
        System.out.println(Contacto);
        
        try{
        for (int i = 0; i <= cbContacto.getItemCount(); i++) {
                cbContacto.setSelectedIndex(i);
                String conSistema="";
                conSistema = cbContacto.getSelectedItem().toString();
                conSistema = Normalizer.normalize(conSistema, Normalizer.Form.NFD);
                conSistema = conSistema.replaceAll("[^\\p{ASCII}]", "");
                System.out.println("Se busca "+Contacto+" en la cadena "+conSistema);
                if (conSistema.contains(Contacto.toUpperCase())) {
                    break;
                }
            }
        }
        catch (Exception e){
            cbContacto.setSelectedIndex(0);
            fmMain.Mensaje("Revise el contacto antes de guardar");
        }
        
        
         List pro = ItemsListado.getChildren();
            for ( int p = 0; p < pro.size(); p++ )
                {
                    ExeSql Sql2 = new ExeSql();
                    ResultSet Rs1;
                    Element Producto = (Element) pro.get(p);
                    String sku_portal_original = Producto.getChildText("EspecificacionProveedor");
                    String sku_portal = Producto.getChildText("EspecificacionProveedor");
                    sku_sinasociar="";
                    
                  
                            for (int x=0; x<=sku_portal.length(); x++)
                                {
                                  if (sku_portal.substring(0, x).contains("Código: "))
                                          {
                                            sku_portal=sku_portal.substring(x, x+9);
                                            //System.out.println(precio_primero);
                                          }
                                }
                            sku_portal = sku_portal.replaceAll("\\D+","").trim();
                            if (sku_portal.length()==8)
                            {
                                sku_portal= "0"+sku_portal;
                            }
                            Rs1 = Sql2.Select("select p.sku, p.nombre, u.um from producto p left"
                                + " join par_unidad u on p.unidad=u.codigo where p.sku='"+sku_portal.trim()+"'");
                            if (!Rs1.next())
                                {
                                 sku_portal="";
                            }
                            
                            if (sku_portal.length()<8 || sku_portal.length()>9)
                            {
                                sku_portal="";
                            }
                            
                            if (sku_portal.trim().equals(""))
                            {
                                String dentroParent = sku_portal_original.substring(sku_portal_original.indexOf("(")+1, sku_portal_original.indexOf(")")); 
                                dentroParent = dentroParent.replaceAll("\\D+","").trim();
                                sku_portal = dentroParent;
                                Rs1 = Sql2.Select("select count(sku) as cuantos from codchile where idch='"+sku_portal.trim()+"'");
                                Rs1.next();
                                if (Rs1.getInt("cuantos")==0)
                                    {  
                                    sku_sinasociar="";
                                    jdAsociaCodPortal acp = new jdAsociaCodPortal(null, true);
                                    acp.setLocationRelativeTo(null);
                                    acp.setTitle("Asociar Codigos Chilecompra");
                                    acp.txCodPortal.setText(sku_portal);
                                    acp.txDescPortal.setText(sku_portal_original.substring(0,sku_portal_original.indexOf(";")));
                                    acp.setVisible(true);
                                    }
                                if (sku_sinasociar.equals(""))
                                    {
                                    Rs1 = Sql2.Select("select sku from codchile where idch='"+sku_portal.trim()+"'");
                                    Rs1.next();
                                    sku_portal = Rs1.getString("sku").trim();
                                    }
                                else{
                                    sku_portal = sku_sinasociar;
                                }
                                                               
                            }
                            
                            
                    
                    double netofinal = Double.valueOf(Producto.getChildText("PrecioNeto").trim());
                    netofinal = netofinal - ((netofinal*porcentajedesc)/100);
                    String el_neto= String.valueOf(netofinal);
                    
                    Rs1 = Sql2.Select("select p.sku, p.nombre, u.um from producto p left"
                                + " join par_unidad u on p.unidad=u.codigo where p.sku='"+sku_portal.trim()+"'");
                    Rs1.next();
                        
                        txSkuTemporal.setText(Rs1.getString("sku").trim());
                        txDescTemporal.setText(Rs1.getString("nombre").trim());
                        txUMTemporal.setText(Rs1.getString("um").trim());
                        txCantidadTemporal.setText(Producto.getChildText("Cantidad").trim().replace(",", "."));
                        txUnitarioTemporal.setText(el_neto.trim().replace(",", "."));
                         

                   
                    
                    //DefaultTableModel tbModel = (DefaultTableModel) Grilla.getModel();

                    
                                tbModel.addRow(GetTemporalOCCH()); 
                                Sumador();
                    LimpiaTemporales();  
                   /* if (Observacion.contains("rut"))
                        {
                        if(JOptionPane.showConfirmDialog(null, "El rut de facturacion es el mismo de la OC?") == JOptionPane.NO_OPTION){
                        String rutfactura = JOptionPane.showInputDialog("Ingrese RUT de FACTURACION (sin puntos ni guion ej 12.345.678-9 -> 12345678):"); 
                        txRut.setText(rutfactura);
                        btIr.doClick();
                        cbCodigoOc.setSelectedItem(cod_oc);
                        
                        }   
                    }*/
                }
        
        }
        catch (Exception e)
        {
            fmMain.Mensaje("error al cargar la oc "+e);
        }
    }//GEN-LAST:event_btMercadoPublicoActionPerformed

    private void GrillaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GrillaKeyPressed
        if(evt.getKeyCode() == evt.VK_DELETE) {
            btEliminar.doClick();
            }
    }//GEN-LAST:event_GrillaKeyPressed

    
    
    
    
    
    private void btAgregarBlogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarBlogActionPerformed
    int cod =0;     
        jdAgregaBlog_occ AddBlog = new jdAgregaBlog_occ(null, true);
        cod = Integer.valueOf(cbCodigoOc.getSelectedItem().toString());
        AddBlog.SetDatos(txRut.getText(), cod , txNroOc.getText());

        //AddBlog.SetDatos(Grilla.getValueAt(Grilla.getSelectedRow(), 0),"GDC",Grilla.getValueAt(Grilla.getSelectedRow(), 3));
        AddBlog.setTitle("Nuevo Registro");
        AddBlog.setLocationRelativeTo(btAgregarBlog);
        AddBlog.setVisible(true);
        if(AddBlog.GetGuardar())
        CargaBlog();
    }//GEN-LAST:event_btAgregarBlogActionPerformed

    private void TxHistorialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxHistorialKeyPressed
        // TODO add your handling code here:
        if (Character.isLowerCase(evt.getKeyChar()))
        evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
    }//GEN-LAST:event_TxHistorialKeyPressed

    private void TxHistorialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxHistorialKeyReleased
        // TODO add your handling code here:
        TxHistorial.setText(TxHistorial.getText().toUpperCase());
    }//GEN-LAST:event_TxHistorialKeyReleased

    private void GrillaBlogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrillaBlogMouseClicked
        // TODO add your handling code here:
        TxHistorial.setText(GrillaBlog.getValueAt(GrillaBlog.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_GrillaBlogMouseClicked


    
    public void LimpiaTemporales(){
        txSkuTemporal.setVisible(false);
        txDescTemporal.setVisible(false);
        txUMTemporal.setVisible(false);
        txCantidadTemporal.setVisible(false);
        txUnitarioTemporal.setVisible(false);
        
        txSkuTemporal.setText("");
        txDescTemporal.setText("");
        txUMTemporal.setText("");
        txCantidadTemporal.setText("");
        txUnitarioTemporal.setText("");
    }
    
    public Object[] GetTemporalOCCH(){
        double TotLineaTemporal =  Float.parseFloat(txCantidadTemporal.getText().trim()) * Float.parseFloat(txUnitarioTemporal.getText().trim());
        //double TotLinea =  Float.parseFloat(txCantidad.getText()) * Float.parseFloat(txPrecio.getText());
        return new Object[]{txSkuTemporal.getText().trim(),
                            txDescTemporal.getText().trim(),
                            txUMTemporal.getText().trim(),
                            fmMain.FormatoNumero(Double.valueOf(fmMain.SetGuardar(txCantidadTemporal.getText().trim()))),
                            0,
                            fmMain.FormatoNumero(Double.valueOf(fmMain.SetGuardar(txCantidadTemporal.getText().trim()))),
                            fmMain.FormatoNumero(Double.valueOf(fmMain.SetGuardar(txUnitarioTemporal.getText().trim()))),
                            0,
                            fmMain.FormatoNumero(0),
                            fmMain.FormatoNumero(TotLineaTemporal),
                            Double.valueOf(fmMain.SetGuardar(txUnitarioTemporal.getText().trim()))};  
    }
    
    public String getFechaAsString() {
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
return( sdf.format( (dtEmision.getDate()).getTime() ) );
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Grilla;
    private javax.swing.JTable GrillaBlog;
    private javax.swing.JTable GrillaDoc;
    private javax.swing.JMenuItem MnuDirecto;
    private javax.swing.JMenuItem MnuPorRut;
    private javax.swing.JPopupMenu PMenu;
    private javax.swing.JTextArea TxHistorial;
    private javax.swing.JButton btAbrir;
    private javax.swing.JButton btAgregar;
    private javax.swing.JButton btAgregarBlog;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btDetalleCon;
    private javax.swing.JButton btDetalleCon1;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btEliminarOCC;
    private javax.swing.JButton btFAC;
    private javax.swing.JButton btGDC;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btIr;
    private javax.swing.JButton btMercadoPublico;
    private javax.swing.JButton btNuevo;
    private javax.swing.JComboBox cbCodigoOc;
    private javax.swing.JComboBox<String> cbCodigoVendedor;
    private javax.swing.JComboBox cbContacto;
    private javax.swing.JComboBox<String> cbVendedor;
    private javax.swing.JCheckBox chbExenta;
    private javax.swing.JCheckBox chbPrioridad;
    private org.jdesktop.swingx.JXDatePicker dtEmision;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private javax.swing.JLabel lbInfo;
    private javax.swing.JLabel lbInfoMargen;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JTextField txCantidadTemporal;
    private javax.swing.JTextField txDescTemporal;
    private javax.swing.JTextField txDespacho;
    private javax.swing.JTextField txDirDespacho;
    private javax.swing.JTextField txDv;
    private javax.swing.JTextField txExento;
    private javax.swing.JTextField txImpEspecifico;
    private javax.swing.JTextField txIva;
    private javax.swing.JTextField txNeto;
    private javax.swing.JTextField txNombre;
    private javax.swing.JTextField txNroOc;
    private javax.swing.JTextField txRut;
    private javax.swing.JTextField txSkuTemporal;
    private javax.swing.JTextField txTotal;
    private javax.swing.JTextField txUMTemporal;
    private javax.swing.JTextField txUnitarioTemporal;
    // End of variables declaration//GEN-END:variables
}
