package PanelForm;

import Conexion.ExeSql;
import Dialogos.*;
import Formularios.fmMain;
import Dialogos.jdBuscarCliPrv;
import static PanelForm.pfBuscaDoc.BuscaArchivos;
import static Utilidades.DocElect.carpeta;
import Utilidades.Ftp;
import static Utilidades.Ftp.busca;
import Utilidades.GeneraDTE;
import Utilidades.GeneraDTE_FTP;
import facturas.ArrayOfString;
import facturas.DTE;
import facturas.DTESoap;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


public class pfGDCliente extends javax.swing.JPanel {
    String RutMaster;
    int Tipo; // 0::Nuevo    1:Abrir
    
    
    int productos = 0;
    int dif = 0;
    
    
    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
    
    
    
    private enum Columnas{Sku,Nombre,UM,Cantidad,Unitario,Total,UniReal};
    String OrdenOC;
    int PesoCorreccion=0;
    int modificarCliente = 0;
    int LimiteDireccion =80;
    String TipDocto_Master="GDC";
    private final String StTipoGDC = "GDC";
    private final String StTipoFAT = "FAT";
    

    public pfGDCliente() {
        
        initComponents();
        SetTipo(-1);
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        Grilla.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        Grilla.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        Grilla.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
        btAgregar.setVisible(false);
        btContacto.setVisible(false);
//        btEliminar.setVisible(false);
        btEmitir.setEnabled(false);
        lbBloqueo.setVisible(false);
        btEmitir.setVisible(false);
        btEmiteMan.setVisible(false);
        txRut.setEnabled(false);
        txRut.setEditable(false);
        btIr.setEnabled(false);
        btEmiteTrans.setEnabled(false);
        bt_MermaStock.setEnabled(false);
        lbTransporte.setVisible(false);
        txidContacto.setVisible(false);
        btContacto.setVisible(false);
        
        txComunaDespacho.setVisible(false);
        txCiudadDespacho.setVisible(false);
        
        
        //Despliega boton para emitir una Guian Manualmente
        if (fmMain.GetUsuarioAdministrador()){
            btEmiteMan.setVisible(true);
        }
        CargaCiudad();
        
       txTotalOCC.setVisible(false);
       txTotalGDC.setVisible(false);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMenu = new javax.swing.JPanel();
        btNuevo = new javax.swing.JButton();
        btGuardar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btEmitir = new javax.swing.JButton();
        btAbrir = new javax.swing.JButton();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        btCorrigePeso = new javax.swing.JButton();
        btActualizarDatos = new javax.swing.JToggleButton();
        btEmiteMan = new javax.swing.JButton();
        btAbrir_FAT = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Grilla = new javax.swing.JTable();
        btEliminar = new javax.swing.JButton();
        btAgregar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txExento = new javax.swing.JTextField();
        txNeto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txIva = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txTotal = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txImpEspecifico = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txRut = new javax.swing.JTextField();
        txDv = new javax.swing.JTextField();
        btIr = new javax.swing.JButton();
        lbBloqueo = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cbTipoDespacho = new javax.swing.JComboBox();
        txNombre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txGiro = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txDireccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txComuna = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txDirDespacho = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txContacto = new javax.swing.JTextField();
        txidContacto = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        cbCodigoOc = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbNroOrden = new javax.swing.JComboBox();
        txTotalOCC = new javax.swing.JTextField();
        txTotalGDC = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        lbNroDocto = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txEstado = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dtEmision = new org.jdesktop.swingx.JXDatePicker();
        btPDF = new javax.swing.JButton();
        lbTransporte = new javax.swing.JLabel();
        txCiudad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btContacto = new javax.swing.JButton();
        chk_Anticipado = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        txObservaciones = new javax.swing.JTextArea();
        lbObs = new javax.swing.JLabel();
        bt_MermaStock = new javax.swing.JButton();
        btEmiteTrans = new javax.swing.JButton();
        txCiudadDespacho = new javax.swing.JComboBox<String>();
        txComunaDespacho = new javax.swing.JComboBox<String>();
        btLiberar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        txFono = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtCiudad = new javax.swing.JTextField();
        txtComuna = new javax.swing.JTextField();
        btCiudad = new javax.swing.JButton();
        btComuna = new javax.swing.JButton();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        pnMenu.setBackground(new java.awt.Color(220, 215, 226));

        btNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/New.png"))); // NOI18N
        btNuevo.setText("Nuevo");
        btNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNuevoActionPerformed(evt);
            }
        });

        btGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/save16.png"))); // NOI18N
        btGuardar.setText("Guardar");
        btGuardar.setBorder(null);
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/Cancel16.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/Pencil16.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btEmitir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/derecha16.png"))); // NOI18N
        btEmitir.setText("Emitir Guia");
        btEmitir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEmitirActionPerformed(evt);
            }
        });

        btAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/open16.png"))); // NOI18N
        btAbrir.setText("Abrir");
        btAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbrirActionPerformed(evt);
            }
        });

        jXLabel1.setText("GUIA DE DESPACHO CLIENTE");
        jXLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        btCorrigePeso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/Peso16.png"))); // NOI18N
        btCorrigePeso.setText("Corrección");
        btCorrigePeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCorrigePesoActionPerformed(evt);
            }
        });

        btActualizarDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/Actualiza.png"))); // NOI18N
        btActualizarDatos.setText("Actualizar Datos");
        btActualizarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActualizarDatosActionPerformed(evt);
            }
        });

        btEmiteMan.setText("Emision Manual");
        btEmiteMan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEmiteManActionPerformed(evt);
            }
        });

        btAbrir_FAT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/open16.png"))); // NOI18N
        btAbrir_FAT.setText("Abrir FAT");
        btAbrir_FAT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbrir_FATActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnMenuLayout = new javax.swing.GroupLayout(pnMenu);
        pnMenu.setLayout(pnMenuLayout);
        pnMenuLayout.setHorizontalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAbrir)
                .addGap(18, 18, 18)
                .addComponent(btCorrigePeso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btActualizarDatos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEmiteMan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btAbrir_FAT, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(btEmitir)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        pnMenuLayout.setVerticalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btEditar)
                        .addComponent(btAbrir)
                        .addComponent(btCorrigePeso)
                        .addComponent(btActualizarDatos)
                        .addComponent(btEmiteMan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btEmitir)
                        .addComponent(btAbrir_FAT)))
                .addGap(7, 7, 7))
        );

        add(pnMenu);

        jPanel1.setBackground(new java.awt.Color(220, 215, 226));

        Grilla.setAutoCreateRowSorter(true);
        Grilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "UM", "Cantidad", "V. Unitario", "Total Linea", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
            Grilla.getColumnModel().getColumn(0).setResizable(false);
            Grilla.getColumnModel().getColumn(0).setPreferredWidth(60);
            Grilla.getColumnModel().getColumn(1).setResizable(false);
            Grilla.getColumnModel().getColumn(1).setPreferredWidth(350);
            Grilla.getColumnModel().getColumn(2).setResizable(false);
            Grilla.getColumnModel().getColumn(2).setPreferredWidth(30);
            Grilla.getColumnModel().getColumn(3).setResizable(false);
            Grilla.getColumnModel().getColumn(3).setPreferredWidth(60);
            Grilla.getColumnModel().getColumn(4).setResizable(false);
            Grilla.getColumnModel().getColumn(4).setPreferredWidth(60);
            Grilla.getColumnModel().getColumn(5).setResizable(false);
            Grilla.getColumnModel().getColumn(5).setPreferredWidth(80);
        }

        btEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos22/Cancel.png"))); // NOI18N
        btEliminar.setText("Eliminar");
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
            }
        });

        btAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos22/add2.png"))); // NOI18N
        btAgregar.setText("Agregar");
        btAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel11.setText("Exento");

        txExento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txExento.setText("0");

        txNeto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txNeto.setText("0");

        jLabel10.setText("Neto");

        txIva.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txIva.setText("0");

        jLabel12.setText("I.V.A.");

        txTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txTotal.setText("0");

        jLabel13.setText("TOTAL");

        jLabel17.setText("Imp. específico");

        txImpEspecifico.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txImpEspecifico.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
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
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txExento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txNeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txImpEspecifico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Rut");

        txRut.setEnabled(false);
        txRut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txRutKeyPressed(evt);
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

        lbBloqueo.setForeground(new java.awt.Color(204, 0, 0));
        lbBloqueo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/bloquear.png"))); // NOI18N
        lbBloqueo.setText("Cliente Bloqueado");

        jLabel18.setText("Venta");

        cbTipoDespacho.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal", "Directo" }));
        cbTipoDespacho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoDespachoActionPerformed(evt);
            }
        });

        txNombre.setEnabled(false);
        txNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txNombreKeyTyped(evt);
            }
        });

        jLabel9.setText("Giro");

        txGiro.setEnabled(false);
        txGiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txGiroActionPerformed(evt);
            }
        });
        txGiro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txGiroKeyReleased(evt);
            }
        });

        jLabel16.setText("Dirección");

        txDireccion.setEnabled(false);
        txDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txDireccionActionPerformed(evt);
            }
        });
        txDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txDireccionKeyReleased(evt);
            }
        });

        jLabel7.setText("Comuna");

        txComuna.setEnabled(false);
        txComuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txComunaActionPerformed(evt);
            }
        });
        txComuna.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txComunaKeyReleased(evt);
            }
        });

        jLabel14.setText("Dirección de Despacho");

        txDirDespacho.setBackground(new java.awt.Color(240, 240, 240));
        txDirDespacho.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txDirDespacho.setEnabled(false);
        txDirDespacho.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txDirDespachoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txDirDespachoKeyTyped(evt);
            }
        });

        jLabel19.setText("Comuna de Despacho");

        jLabel20.setText("Ciudad de Despacho");

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Contacto");

        txContacto.setEditable(false);
        txContacto.setEnabled(false);
        txContacto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txContactoKeyTyped(evt);
            }
        });

        txidContacto.setEditable(false);

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        cbCodigoOc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCodigoOc.setSelectedIndex(-1);
        cbCodigoOc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCodigoOcActionPerformed(evt);
            }
        });

        jLabel3.setText("Código OC");

        jLabel4.setText("Nro Orden");

        cbNroOrden.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbNroOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNroOrdenActionPerformed(evt);
            }
        });

        txTotalOCC.setText("0");

        txTotalGDC.setText("0");
        txTotalGDC.setToolTipText("");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txTotalOCC, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbCodigoOc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbNroOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txTotalGDC, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCodigoOc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbNroOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txTotalOCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txTotalGDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("GUÍA DE DESPACHO");

        lbNroDocto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbNroDocto.setForeground(new java.awt.Color(255, 51, 51));

        jLabel5.setText("F. Emisión");

        txEstado.setEditable(false);

        jLabel6.setText("Estado");

        dtEmision.setEnabled(false);

        btPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/pdf.png"))); // NOI18N
        btPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPDFActionPerformed(evt);
            }
        });

        lbTransporte.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbTransporte.setForeground(new java.awt.Color(204, 0, 0));
        lbTransporte.setText("Transporte");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(lbNroDocto)
                .addGap(93, 93, 93)
                .addComponent(lbTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(dtEmision, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(lbTransporte))
                    .addComponent(lbNroDocto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(dtEmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12))
        );

        txCiudad.setEnabled(false);
        txCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txCiudadActionPerformed(evt);
            }
        });
        txCiudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txCiudadKeyReleased(evt);
            }
        });

        jLabel8.setText("Ciudad");

        jLabel2.setText("Nombre");

        btContacto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Ok.png"))); // NOI18N
        btContacto.setBorderPainted(false);
        btContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btContactoActionPerformed(evt);
            }
        });

        chk_Anticipado.setText("Factura Anticipada");

        txObservaciones.setColumns(20);
        txObservaciones.setRows(5);
        jScrollPane2.setViewportView(txObservaciones);

        lbObs.setText("Observaciones Guia de Despacho");

        bt_MermaStock.setText("Devolucion y Pago");
        bt_MermaStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_MermaStockActionPerformed(evt);
            }
        });

        btEmiteTrans.setText("Emision Transporte");
        btEmiteTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEmiteTransActionPerformed(evt);
            }
        });

        txCiudadDespacho.setBackground(new java.awt.Color(255, 255, 204));
        txCiudadDespacho.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txComunaDespacho.setBackground(new java.awt.Color(255, 255, 204));
        txComunaDespacho.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txComunaDespacho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txComunaDespachoActionPerformed(evt);
            }
        });

        btLiberar.setText("Liberar");
        btLiberar.setToolTipText("");
        btLiberar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLiberarActionPerformed(evt);
            }
        });

        txFono.setToolTipText("");
        txFono.setEnabled(false);

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Fono");

        txtCiudad.setEditable(false);
        txtCiudad.setEnabled(false);
        txtCiudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCiudadKeyTyped(evt);
            }
        });

        txtComuna.setEditable(false);
        txtComuna.setEnabled(false);
        txtComuna.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtComunaKeyTyped(evt);
            }
        });

        btCiudad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/search16.png"))); // NOI18N
        btCiudad.setEnabled(false);
        btCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCiudadActionPerformed(evt);
            }
        });

        btComuna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/search16.png"))); // NOI18N
        btComuna.setEnabled(false);
        btComuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btComunaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(txRut, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txDv, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btIr, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbBloqueo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(chk_Anticipado)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbTipoDespacho, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txNombre)
                                    .addComponent(txGiro)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txComuna)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txDireccion)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txDirDespacho)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtComuna, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btComuna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(12, 12, 12)
                                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btCiudad)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txFono, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbObs)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btAgregar)
                                .addGap(58, 58, 58)
                                .addComponent(btEliminar))
                            .addComponent(jScrollPane2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btLiberar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txidContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btEmiteTrans, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                        .addComponent(bt_MermaStock, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txCiudadDespacho, 0, 102, Short.MAX_VALUE)
                        .addComponent(txComunaDespacho, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btIr)
                            .addComponent(txDv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel18)
                                .addComponent(cbTipoDespacho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbBloqueo)
                                .addComponent(chk_Anticipado))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txGiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btLiberar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btEmiteTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt_MermaStock, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txComuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(txCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txDirDespacho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21)
                                .addComponent(jLabel20)
                                .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel22)
                                .addComponent(txFono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel19)
                                .addComponent(txtComuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btComuna, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txidContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(txComunaDespacho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txCiudadDespacho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btEliminar)
                                    .addComponent(btAgregar))
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 26, Short.MAX_VALUE)
                                .addComponent(lbObs)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents
    static public int GetCol(String Col){
        return Columnas.valueOf(Col).ordinal();
    }

//--------------------------------------------------------------------------------
// Funcion SET DE TIPOS
//--------------------------------------------------------------------------------
    private void SetTipo(int ElTipo){
        // NADA
        if(ElTipo==-1){
          fmMain.SetEstado(fmMain.pnPestanas.getSelectedIndex(),0);
          Habilita(false);
          Edicion(false);
          Limpia();
          txRut.setEnabled(true);
          txRut.setEditable(true);
          btIr.setEnabled(true);
          txRut.requestFocus();
          btCancelar.setEnabled(false);
          btGuardar.setEnabled(false);
          btCorrigePeso.setEnabled(false);
          btNuevo.setEnabled(true);
          btEditar.setEnabled(false);
          btEmitir.setEnabled(false);
          txEstado.setText("Sin Emitir");
          
          Tipo=-1;
          
        }
        // NUEVA ORDEN
        else if(ElTipo==1){
            btGuardar.setEnabled(true);
            btCorrigePeso.setEnabled(true);
            btCancelar.setEnabled(true);
            btNuevo.setEnabled(false);
            btEditar.setEnabled(false);
            btAbrir.setEnabled(false);
            btAbrir_FAT.setEnabled(false);
            btEmitir.setEnabled(false);
            
            CargaCodOc(RutMaster);
            Habilita(true); 
            Edicion(true);
            
            
            fmMain.SetEstado(fmMain.pnPestanas.getSelectedIndex(),1);  
            
            txRut.requestFocus();
            Tipo=1;
        }
        else if(ElTipo==2){
          fmMain.SetEstado(fmMain.pnPestanas.getSelectedIndex(),0);
//          btEditar.setEnabled(true);
          btNuevo.setEnabled(true);
          btGuardar.setEnabled(false);
          btCorrigePeso.setEnabled(false);
          btCancelar.setEnabled(false);
          btEmitir.setEnabled(true);
          Habilita(true);
          Edicion(false);
          txRut.setEditable(true);
          Tipo=2;
        }
        else if(ElTipo==3){
          Habilita(true); 
            Edicion(true);
            
            btGuardar.setEnabled(true);
            btCorrigePeso.setEnabled(true);
            btCancelar.setEnabled(true);
            btNuevo.setEnabled(false);
            btEditar.setEnabled(false);
            btAbrir.setEnabled(false);
            btAbrir_FAT.setEnabled(false);
            btEmitir.setEnabled(false);  
            txDirDespacho.setEditable(true);
            txDirDespacho.setEnabled(true);
            txComunaDespacho.setEnabled(true);
            txCiudadDespacho.setEnabled(true);
            txContacto.setEnabled(true);
            txContacto.setEditable(true);
            
            txFono.setEnabled(true);
            txFono.setEditable(true);
            
            txidContacto.setEnabled(true);
            txidContacto.setEditable(true);
            txEstado.setEnabled(true);
            txEstado.setEditable(true);
            Tipo=3;
        }
    }
    
    private void FindeAgno(){
        if(fmMain.GetFacNewYear()==1){
            try {
                SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
                Date Fecha=df.parse("2015/12/31");
                dtEmision.setDate(Fecha);
                //dtEmision.setEditable(false);
                System.out.println("NewYear");
            } catch (Exception e) {
                System.out.println("Error New Year");
            }
            
        }
            
        
    }

    private void CargaCiudad() {
        ExeSql sql = new ExeSql();
        ResultSet rs = null;
        String query = "select \n" +
                        "case \n" +
                        "when (blue.localidad) is not null then (blue.localidad)\n" +
                        "when (ps.nombre) is not null then (ps.nombre)\n" +
                        "when (pt.ciudad) is not null then (pt.ciudad)\n" +
                        "end as ciudad\n" +
                        "from pd_zonageografica_blue blue\n" +
                        "full outer join pd_ciudades_samex ps on ps.nombre = blue.localidad\n" +
                        "full outer join pd_ciudades_tnt pt on pt.ciudad = blue.localidad \n" +
                        "group by blue.localidad, ps.nombre, pt.ciudad\n" +
                        "order by blue.localidad, ps.nombre, pt.ciudad";
        DefaultComboBoxModel model = (DefaultComboBoxModel) txCiudadDespacho.getModel();
        if(model.getSize()>0){
            model.removeAllElements();
        }
        DefaultComboBoxModel model2 = (DefaultComboBoxModel) txComunaDespacho.getModel();
        if(model2.getSize()>0){
            model2.removeAllElements();
        }
        try {
            rs = sql.Select(query);
            for(int i = 0; rs.next(); i++){
                model.addElement(rs.getString("ciudad"));
                model2.addElement(rs.getString("ciudad"));
            }
            model.addElement("");
            model2.addElement("");
        } catch (SQLException ex) {
            Logger.getLogger(pfGDCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            sql.Close();
        }
        
    }


    
    public void NuevaGuia(String Rut, String CodigoOc, String Numero){
    
        btNuevo.doClick();
        txRut.setText(Rut);
        btIr.doClick();
        int posOrden =0, posCodigoOC=0;
    
        for(int i=0 ; i < cbCodigoOc.getItemCount();i++){
            cbCodigoOc.setSelectedIndex(i);
            
            if(cbCodigoOc.getSelectedItem().toString().equals(CodigoOc) ){
                CargaDatosCodigoOC();
                posCodigoOC=i;
                break; 
            }
               
        }
    
        for(int i=0 ; i < cbNroOrden.getItemCount();i++){
            cbNroOrden.setSelectedIndex(i);
            cbNroOrden.getSelectedItem().toString();
            if(cbNroOrden.getSelectedItem().toString().equals(Numero) ){
                posOrden= i;
               break; 
            }   
        }
    
        cbCodigoOc.setSelectedIndex(posCodigoOC);
        cbNroOrden.setSelectedIndex(posOrden);
        
    }
//--------------------------------------------------------------------------------
// EDICION
//--------------------------------------------------------------------------------
private void Edicion(boolean Estado){
    
//    txNroOc.setEditable(Estado);
    txRut.setEditable(Estado);
    txDv.setEditable(Estado);
//    txComunaDespacho.setEnabled(Estado);
//    txCiudadDespacho.setEnabled(Estado);
    
//    txtCiudad.setEnabled(Estado);
//    txtComuna.setEnabled(Estado);
    
    
    txObservaciones.setEnabled(Estado);
    txNeto.setEditable(Estado);
    txExento.setEditable(Estado);
    txIva.setEditable(Estado);
    txTotal.setEditable(Estado);
    btAgregar.setEnabled(Estado);
    btEliminar.setEnabled(Estado);
    chk_Anticipado.setEnabled(Estado);
    //dtEmision.setEditable(Estado);
    

}
//--------------------------------------------------------------------------------
// LIMPIA
//--------------------------------------------------------------------------------
private void Limpia(){
    DefaultComboBoxModel dfCm = new DefaultComboBoxModel();
    DefaultTableModel   dfTm = (DefaultTableModel) Grilla.getModel();
    

    txRut.setText("");
    txNombre.setText("");
    txDv.setText("");
    txNeto.setText("");
    txExento.setText("");
    txIva.setText("");
    txTotal.setText("");
    txGiro.setText("");
    txComuna.setText("");
    txCiudad.setText("");
    txDireccion.setText("");
    lbNroDocto.setText("");
    txEstado.setText("");
    
//    txComunaDespacho.setSelectedItem("");
//    txCiudadDespacho.setSelectedItem("");
    
    txtCiudad.setText("");
    txtComuna.setText("");
    
    txContacto.setText("");
    txFono.setText("");
    dtEmision.setDate(new Date());
    txDirDespacho.setText("");
    cbCodigoOc.setModel(dfCm);
    cbTipoDespacho.setSelectedIndex(-1);
    chk_Anticipado.setSelected(false);
    
    // Deja fondo de color blanco.
            txDirDespacho.setBackground(Color.white);
            txComunaDespacho.setBackground(Color.white);

//    cbContacto.setModel(dfCm);
    
        
    while(dfTm.getRowCount()>0)
        dfTm.removeRow(0);
    //chbPrioridad.
    
    dtEmision.setDate(null);
    lbTransporte.setVisible(false);
    txObservaciones.setText("");

}    
//--------------------------------------------------------------------------------
// HABILITA
//--------------------------------------------------------------------------------
private void Habilita(boolean Estado){
    
    cbCodigoOc.setEnabled(Estado);
    cbNroOrden.setEnabled(Estado);
//    cbContacto.setEnabled(Estado);
//    btDetalleCon.setEnabled(Estado);
//    txNroOc.setEnabled(Estado);
    btAgregar.setEnabled(Estado);
    btEliminar.setEnabled(Estado);

    txRut.setEnabled(Estado);
    txDv.setEnabled(Estado);
  
    //dtEmision.setEnabled(Estado);
    txNeto.setEnabled(Estado);
    txExento.setEnabled(Estado);
    txIva.setEnabled(Estado);
    txTotal.setEnabled(Estado);
    btIr.setEnabled(Estado);
    txEstado.setEnabled(Estado);
    btActualizarDatos.setEnabled(Estado);
    cbTipoDespacho.setEnabled(Estado);
    //cbTipoVta.setEnabled(Estado);
    txidContacto.setEnabled(Estado);
    txImpEspecifico.setEnabled(Estado);
    txContacto.setEnabled(Estado);
   // btContacto.setVisible(Estado);
    btContacto.setEnabled(Estado);
    txDirDespacho.setEditable(false);
    txDirDespacho.setEnabled(false);
    txComunaDespacho.setEnabled(false);
    txCiudadDespacho.setEnabled(false);
    txContacto.setEnabled(false);
    txContacto.setEditable(false);
    
    txFono.setEnabled(false);
    txFono.setEditable(false);
    
    txidContacto.setEnabled(false);
    txidContacto.setEditable(false);
    txEstado.setEnabled(false);
    txEstado.setEditable(false);
    chk_Anticipado.setEnabled(Estado);
    //dtEmision.setEnabled(Estado);
    txObservaciones.setEnabled(false);
}
    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        if(fmMain.GetEstado(fmMain.pnPestanas.getSelectedIndex())==0){
            Limpia();
            Habilita(false);
            btGuardar.setEnabled(false);
            btCancelar.setEnabled(false);
            btNuevo.setEnabled(true);
            btEditar.setEnabled(false);
            btAbrir.setEnabled(true);
            btAbrir_FAT.setEnabled(true);
            lbBloqueo.setVisible(false);
            
            btCiudad.setEnabled(false);
            btComuna.setEnabled(false);
        }
        
        else if(fmMain.OkCancel("¿Seguro de cancelar?")==JOptionPane.OK_OPTION){
            Limpia();
            Habilita(false);
            btGuardar.setEnabled(false);
            btCancelar.setEnabled(false);
            btNuevo.setEnabled(true);
            btEditar.setEnabled(false);
            btAbrir.setEnabled(true);
            btAbrir_FAT.setEnabled(true);
            lbBloqueo.setVisible(false);
            
            btCiudad.setEnabled(false);
            btComuna.setEnabled(false);
            
            
        }
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNuevoActionPerformed
        
        Limpia();
        Habilita(false);
        Edicion(false);
        txRut.setEnabled(true);
        txRut.setEditable(true);

        btIr.setEnabled(true);
        btAbrir.setEnabled(false);
        btAbrir_FAT.setEnabled(false);
        btGuardar.setEnabled(true);
        btCorrigePeso.setEnabled(true);
        btCancelar.setEnabled(true);
        txRut.requestFocus();
        cbTipoDespacho.setSelectedIndex(0);
        Tipo=1;
    }//GEN-LAST:event_btNuevoActionPerformed
//------------------------------------------------------------------------------
// Carga Cliente
//------------------------------------------------------------------------------
    private boolean CargaCliente(String Rut) {
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        try {
            Rs = Sql.Select("select rut,dv,nombre\n"
                    + "from cliente\n"
                    + "where rut=" + Rut);
            Rs.next();
            txRut.setText(Rs.getString("Rut"));
            txDv.setText(Rs.getString("dv"));
            txNombre.setText(Rs.getString("nombre").trim());
            dtEmision.setDate(new Date());
            RutMaster = Rs.getString("Rut");
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            Sql.Close();
        }
    }
//------------------------------------------------------------------------------
// Carga Codigos OC
//------------------------------------------------------------------------------
    private void CargaCodOc(String Rut){
        ExeSql  Sql = new ExeSql();
        ResultSet Rs;
        DefaultComboBoxModel cbMd = new DefaultComboBoxModel();
        cbCodigoOc.setModel(cbMd);
        try {
            Rs = Sql.Select("select distinct(codigo_oc) as codigo_oc from clicontacto where rut = " + Rut);
            while (Rs.next()) {
                cbMd.addElement(Rs.getString("codigo_oc").trim());
            }
        } catch (Exception e) {
            System.out.println("e");
        } finally{
            Sql.Close();
        }
    }
    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
        if(!Grilla.getValueAt(Grilla.getSelectedRow(), 0).toString().isEmpty())
        if(JOptionPane.showConfirmDialog(null, "¿Desea Eliminar el registro?") == JOptionPane.YES_OPTION){
            DefaultTableModel tbMd = (DefaultTableModel) Grilla.getModel();
            tbMd.removeRow(Grilla.getSelectedRow());
            Sumador();
        }
    }//GEN-LAST:event_btEliminarActionPerformed

    private void btAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarActionPerformed
        DefaultTableModel tbModel = (DefaultTableModel) Grilla.getModel();
        if(tbModel.getRowCount()<=40){
            jdGDCAgregaProducto AgregaProducto = new jdGDCAgregaProducto(null,true);
            AgregaProducto.setLocationRelativeTo(null);
            AgregaProducto.setTitle("Agragar Producto");
            AgregaProducto.setVisible(true);
            tbModel.addRow(AgregaProducto.GetFila());
        }
        else {
            JOptionPane.showMessageDialog(null, "No se puede agregar más de 40 productos");
        }
//        Sumador();

    }//GEN-LAST:event_btAgregarActionPerformed

    private void btAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbrirActionPerformed
        Habilita(false);
        Edicion(false);
        Limpia();
        txRut.setEnabled(true);
        txRut.setEditable(true);
        btIr.setEnabled(true);
        btCancelar.setEnabled(true);
        txDirDespacho.setEditable(false);
        txRut.requestFocus();
        btEditar.setEnabled(false);
        SetTipo(2);
        TipDocto_Master =StTipoGDC;
        lbTransporte.setVisible(false);
    }//GEN-LAST:event_btAbrirActionPerformed
    public void AbrirGuia(String Rut,String Numero, String TipDocto){
        ResultSet Rs, Rs2;
        ExeSql Sql = new ExeSql();
        boolean booEmitida=false;
        
        DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
        try{//Carga Detalles
        
            Sql.Commit();
        
            while(TableModel.getRowCount()>0)
                  TableModel.removeRow(0);
            
            Rs = Sql.Select("select c.rut,c.nrodocto,c.nrodocorigen,c.estado as estadoint, c.femision,c.occh,c.contacto,c.tipodespacho, \n"
                    +       " c.totalexento,c.totalafecto,c.totaliva,totalimpespecifico,c.totaldocto, cc.giro, c.contacto_gdc, c.fono_gdc, \n"
                    +       " cc.direccion,cc.ciudad,cc.comuna,cc.region,c.estado, c.direccion_despacho, c.comuna_despacho, c.ciudad_despacho, anticipado, c.observacion \n" +
                            " from ctactecli c left join clicontacto cc \n" +
                            " on c.rut=cc.rut and c.nrodocorigen=cc.codigo_oc \n" +
                            " WHERE c.rut=" + Rut + " \n" +
                            " AND c.tipdocto='" + TipDocto + "' \n" +
                            " AND c.nrodocto=" + Numero);
            Rs.next();
            lbNroDocto.setText(Numero);
            cbTipoDespacho.setSelectedIndex(Rs.getInt("tipodespacho"));
            
            
            //BLOQUEA BOTÓN EDITAR
            
            if(Rs.getInt("estado")==1)
            {
                btEditar.setVisible(false);
                booEmitida=true;
            }else
            {
                btEditar.setVisible(true);
                booEmitida=false;
            }
            
            
            if (Rs.getInt("anticipado")==1){
                chk_Anticipado.setSelected(true);}
            else{
                chk_Anticipado.setSelected(false);
            }
            
            
            dtEmision.setDate(Rs.getDate("femision"));
            
            txGiro.setBackground(Color.white);
            txDireccion.setBackground(Color.white);
            txCiudad.setBackground(Color.white);
            txComuna.setBackground(Color.white);
            txDirDespacho.setBackground(Color.white);
//            txComunaDespacho.setBackground(Color.white);
//            txCiudadDespacho.setBackground(Color.white);
            
            txtComuna.setBackground(Color.white);
            txtCiudad.setBackground(Color.white);
        
            
            try{ txGiro.setText(Rs.getString("giro").trim()); txGiro.setBackground(Color.white);} catch (Exception e) {txGiro.setText(""); txGiro.setBackground(Color.red);}
            try{ txDireccion.setText(Rs.getString("direccion").trim()); txDireccion.setBackground(Color.white);} catch (Exception e) {txDireccion.setText("");txDireccion.setBackground(Color.red);}
            try{ txCiudad.setText(Rs.getString("ciudad").trim());txCiudad.setBackground(Color.white);}catch (Exception e) {txCiudad.setText("");txCiudad.setBackground(Color.red);}
            try{ txComuna.setText(Rs.getString("comuna").trim());txComuna.setBackground(Color.white);}catch (Exception e) {txComuna.setText("");txComuna.setBackground(Color.red);}
            try{ txDirDespacho.setText(Rs.getString("direccion_despacho").trim()); txDirDespacho.setBackground(Color.white);} catch (Exception e) {txDirDespacho.setText("");txDirDespacho.setBackground(Color.red);}
//            try{ txComunaDespacho.setSelectedItem(Rs.getString("comuna_despacho").trim());txComunaDespacho.setBackground(Color.white);}catch (Exception e) {txComunaDespacho.setSelectedItem("");txComunaDespacho.setBackground(Color.red);}
//            try{ txCiudadDespacho.setSelectedItem(Rs.getString("ciudad_despacho").trim());txCiudadDespacho.setBackground(Color.white);}catch (Exception e) {txCiudadDespacho.setSelectedItem("");txCiudadDespacho.setBackground(Color.red);}
//            
            try{ txtComuna.setText(Rs.getString("comuna_despacho").trim());txtComuna.setBackground(Color.white);}catch (Exception e) {txtComuna.setText("");txtComuna.setBackground(Color.red);}
            try{ txtCiudad.setText(Rs.getString("ciudad_despacho").trim());txtCiudad.setBackground(Color.white);}catch (Exception e) {txtCiudad.setText("");txtCiudad.setBackground(Color.red);}
            
            
            
            
//            if(Rs.getInt("estadoint")==0){ 
                btEmitir.setEnabled(true);
               // btPDF.setVisible(false);
//            }
//            else{
//                btEditar.setEnabled(false);
//                btPDF.setVisible(true);
//            }
            
            txNeto.setText(fmMain.FormatoTotal(Rs.getDouble("totalafecto")));
            txExento.setText(fmMain.FormatoTotal(Rs.getDouble("totalexento")));
            txIva.setText(fmMain.FormatoTotal(Rs.getDouble("totaliva")));
            txImpEspecifico.setText(fmMain.FormatoTotal(Rs.getDouble("totalimpespecifico")));
            txTotal.setText(fmMain.FormatoTotal(Rs.getDouble("totaldocto")));
            
            switch(Rs.getInt("estado")){
                case 0: txEstado.setText("Sin Emitir"); break;
                case 1: txEstado.setText("Emitida");break;
            }
            
            if (Rs.getInt("contacto") > 0){
            
            
                String qry = "SELECT trim(cp.nombre) || '--' || trim(cp.fono) || '--' || trim(cp.celular) Contacto \n" +
                             " FROM ctactecli c\n" +
                             " left join clicontactopersonas cp\n" +
                             " on c.contacto = cp.id \n" +
                            " where \n" +
                            " cp.id =" + Rs.getInt("contacto") + " and c.tipdocto ='" + TipDocto + "' and nrodocto = " + Numero;
            
                Rs2 = Sql.Select(qry);
                Rs2.next();
                   
                    
                txContacto.setText(Rs2.getString("Contacto"));
            
            
            }else {
            
            
                txContacto.setText(Rs.getString("contacto_gdc"));
                txFono.setText(Rs.getString("fono_gdc"));
                    
            }

            
 
            txObservaciones.setText(Rs.getString("observacion"));
            
            
            
            if (txEstado.getText().trim().equals("Emitida")){
                
                txDirDespacho.setText(Rs.getString("direccion_despacho"));
                txComunaDespacho.setSelectedItem(Rs.getString("comuna_despacho").trim());
                txCiudadDespacho.setSelectedItem(Rs.getString("ciudad_despacho").trim());
                btPDF.setVisible(true);
            }
//            else
//            {
//                txDirDespacho.setText(txDireccion.getText().trim());
//                txComunaDespacho.setText(txComuna.getText().trim());
//                txCiudadDespacho.setText(txCiudad.getText().trim());
//            }
                

            DefaultComboBoxModel cbMd = new DefaultComboBoxModel();
            cbMd.addElement(Rs.getString("nrodocorigen").trim()); 
            cbCodigoOc.setModel(cbMd);

            DefaultComboBoxModel cbMd2 = new DefaultComboBoxModel();
            cbMd2.addElement(Rs.getString("occh").trim()); 
            cbNroOrden.setModel(cbMd2);
            OrdenOC = Rs.getString("occh").trim();
           
            
        } catch (Exception e) {
            System.out.println(e);
            }


         fmMain.LimpiaGrilla(TableModel);   
        
        try {
            Rs = Sql.Select("select d.sku,p.nombre,u.um,d.cantidad,d.valorunitario,d.totallinea \n"
                    + "from ctacteclidet d\n"
                    + "left join producto p\n"
                    + "on d.sku=p.sku\n"
                    + "left join par_unidad u\n"
                    + "on p.unidad=u.codigo\n"
                    + "where d.rut=" + Rut + "\n"
                    + "and d.tipdocto='" + TipDocto + "'\n"
                    + "and d.nrodocto=" + Numero);
            while (Rs.next()) {
                TableModel.addRow(new Object[]{
                    Rs.getString("sku"),
                    Rs.getString("nombre"),
                    Rs.getString("um"),
                    fmMain.FormatoNumero(Rs.getDouble("cantidad")),
                    fmMain.FormatoNumero(Rs.getDouble("valorunitario")),
                    fmMain.FormatoNumero6(Rs.getDouble("totallinea")),
                    fmMain.FormatoNumero6(Rs.getDouble("valorunitario"))
                });
            }
            Sumador();
             if (TipDocto.equals(StTipoFAT)){
                lbTransporte.setVisible(true);
                
                if (booEmitida)
                {
                    btEmiteTrans.setEnabled(false);
                    bt_MermaStock.setEnabled(false);
                }
                else
                {
                    btEmiteTrans.setEnabled(true);
                    bt_MermaStock.setEnabled(true);
                }
                
                
             }
             else
             {
               lbTransporte.setVisible(false);
               btEmiteTrans.setEnabled(false);
               
             }
        } catch (Exception e) {
            System.out.println(e);
        } finally{
            Sql.Close();
        }
    }    
    
    private void CargaDatosCodigoOC() {
        ExeSql Sql = new ExeSql();
        ResultSet Rs, Rs1;
        DefaultComboBoxModel cbMd = new DefaultComboBoxModel();
        cbNroOrden.setModel(cbMd);

        try {
            // --Carga Datos de Cliente AV JUAN MACKENNA N° 1421

            Rs = Sql.Select("select giro,direccion,ciudad,comuna,region,bloqueo\n"
                    + "from clicontacto\n"
                    + "where rut=" + txRut.getText()
                    + " and codigo_oc=" + cbCodigoOc.getSelectedItem().toString());

            Rs.next();
            
            if(Rs.getInt("bloqueo")==1){
                lbBloqueo.setVisible(true);
                btGuardar.setEnabled(false);
            }
            else{
                lbBloqueo.setVisible(false);
                btGuardar.setEnabled(true);
            }
                

            try {
                txGiro.setText(Rs.getString("giro").trim());
                txGiro.setBackground(Color.white);
            } catch (Exception e) {
                txGiro.setText("");
                txGiro.setBackground(Color.red);
            }
            try {
                txDireccion.setText(Rs.getString("direccion").trim());
                txDireccion.setBackground(Color.white);
            } catch (Exception e) {
                txDireccion.setText("");
                txDireccion.setBackground(Color.red);
            }
            try {
                txCiudad.setText(Rs.getString("ciudad").trim());
                txCiudad.setBackground(Color.white);
            } catch (Exception e) {
                txCiudad.setText("");
                txCiudad.setBackground(Color.red);
            }
            try {
                txComuna.setText(Rs.getString("comuna").trim());
                txComuna.setBackground(Color.white);
            } catch (Exception e) {
                txComuna.setText("");
                txComuna.setBackground(Color.red);
            }
            
            
            try {
                txDirDespacho.setText(Rs.getString("direccion").trim());
                txDirDespacho.setBackground(Color.white);
            } catch (Exception e) {
                txDirDespacho.setText("");
                txDirDespacho.setBackground(Color.red);
            }
            
            try {
//                txCiudadDespacho.setSelectedItem(Rs.getString("ciudad").trim());
//                txCiudadDespacho.setBackground(Color.white);
                
                txtCiudad.setText(Rs.getString("ciudad").trim());  //nuevo campo
                txtCiudad.setBackground(Color.white);                

                btCiudad.setEnabled(true);
                
            } catch (Exception e) {
//                txCiudadDespacho.setSelectedItem("");
//                txCiudadDespacho.setBackground(Color.red);
                
                txtCiudad.setText("");  //nuevo campo
                txtCiudad.setBackground(Color.red);
                
            }
            
            try {
//                txComunaDespacho.setSelectedItem(Rs.getString("comuna").trim());
//                txComunaDespacho.setBackground(Color.white);
                
                txtComuna.setText(Rs.getString("comuna").trim());  //nuevo campo
                txtComuna.setBackground(Color.white);   
                
                btComuna.setEnabled(true);
            
            } catch (Exception e) {
//                txComunaDespacho.setSelectedItem("");
//                txComunaDespacho.setBackground(Color.red);
                
                txtComuna.setText("");  //nuevo campo
                txtComuna.setBackground(Color.red);
                
                
            }
            
            
            
            //--Carga Ordenes Pendientes de Despacho
            if (Tipo != 2) {
                
                Rs = Sql.Select("select orden\n"
                        + "from occh\n"
                        + "where estado < 2 \n"
                        + "and esexento <>1 \n" 
                        + "and  rut=" + txRut.getText() + " \n"
                        + "and codigo_oc=" + cbCodigoOc.getSelectedItem().toString());
                
                while (Rs.next()) {
                    cbMd.addElement(Rs.getString("orden").trim());
                }
             
             // Trae datos del contacto   
                Rs1 = Sql.Select("select p.nombre,c.contacto \n" +
                                 "from occh c\n" +
                                 "left join clicontactopersonas p on p.id= c.contacto \n" +
                                 "where c.codigo_oc = " + cbCodigoOc.getSelectedItem().toString() + " \n" +
                                 "and c.orden = '" + cbMd.getSelectedItem().toString() + "'");
                 
                if (Rs1.next()){
                     
//                    txContacto.setText(Rs1.getString("nombre"));
//                    txidContacto.setText(Rs1.getString("contacto"));
                }
                
                
                txContacto.setText("");
                txidContacto.setText("");
                
            }
            
        } catch (Exception e) {
            System.out.println(e);
        } finally{
            Sql.Close();
        }
    }
    
    private boolean ValidaMargen(){
    
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        String Respuesta="";
        
        try {
            Respuesta = Sql.SelectUnico("select * from fn_margen_occ(" + txRut.getText().trim() + "," + cbCodigoOc.getSelectedItem().toString().trim() + ",'" + cbNroOrden.getSelectedItem().toString().trim() +"')");
            
            if(!Respuesta.isEmpty()){       //Si no existe margen autorizado
            
                System.out.println("No está Vacío!!"+Respuesta);
                
                
                Rs = Sql.Select("select count(*) as Autorizado \n" +
                                "from autorizaciones\n" +
                                "where tipo='AUTORIZAMARGENOCC'\n" +
                                "and rut="+ txRut.getText().trim() +"\n" +
                                "and codigo_oc="+ cbCodigoOc.getSelectedItem().toString().trim() +"\n" +
                                "and orden='"+ cbNroOrden.getSelectedItem().toString().trim() +"'\n" +
                                "and estado=0");
                Rs.next();
                
                if(Rs.getInt("Autorizado")==0){         //No existe solicitud de Autorización
                
                    if(fmMain.OkCancel("Margen menor al LIMITE PERMITIDO. ¿Desea solicitar Autorización?")== JOptionPane.OK_OPTION){
                       
                        Sql.ExeSql("insert into autorizaciones\n" +
                                   "(tipo,rut,codigo_oc,orden,solicita)values\n" +
                                   "('AUTORIZAMARGENOCC',"+ txRut.getText().trim() +","+ cbCodigoOc.getSelectedItem().toString().trim() +",'"+ cbNroOrden.getSelectedItem().toString().trim() +"',user)");
                        Sql.Commit();
                    }
                
                }else{                          //Existe la solicitud pero no ha sido autorizada
                
                    fmMain.Mensaje("Margen aun no ha sido autorizado para esta Orden de Compra");
                }
                return false;
            
            }else{    //El Margen es superior al mínimo o fue Autorizado
                 
               return true;
            }
        } catch (Exception e) {
            return false;
        }finally{
            Sql.Close();
        }
    }
    
    public String getFechaAsString() {
    
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return( sdf.format( (dtEmision.getDate()).getTime() ) );
    }
    
    private Boolean  GuardaGuia(){
        
        ExeSql Sql = new ExeSql();
        ExeSql Sql2 = new ExeSql();
        ResultSet Rs;
        boolean boo_esTransporte=false, guardada =false;
        int int_guia_transporte =-1;
        String StrTipoDocto = "";
        String Query = "";
        int intAnticipado=-1;
        

        
        
        if (txidContacto.getText().trim().equals("")){
            fmMain.Mensaje("Debe seleccionar un contacto para guardar la Guia");
            btContacto.doClick();
            return guardada;
        }
            
        if (modificarCliente >= 1)
        {
            if (JOptionPane.showConfirmDialog(null, "Usted realizo cambios en la ficha del cliente, desea guardarlos?.", "Guardar", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION)
            {
           try
            {
              Sql.ExeSql("update clicontacto set "
                      + " giro='" +txGiro.getText().trim()+"',"
                      + " direccion='" +txDireccion.getText().trim()+"',"
                      + " comuna='" +txComuna.getText().trim()+"',"
                      + " ciudad='" +txCiudad.getText().trim()+"'"
                      + " where rut=" +txRut.getText().trim()+ " and codigo_oc="+cbCodigoOc.getSelectedItem().toString().trim());
              Sql.Commit();
            }
            catch(Exception e) {
                    Sql.Rollback();
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
            }
        }
        
        try {
            //Revisa si la OC es de Tipo Transporte 
            //    ----------------------------------
                Rs = Sql2.Select("select  es_transporte, guia_transporte\n"
                        + "from occh\n"
                        + "where rut= " + txRut.getText().trim() + "\n"
                        + "and codigo_oc=" + cbCodigoOc.getSelectedItem().toString().trim() + "\n"
                        + "and orden='" + cbNroOrden.getSelectedItem().toString().trim() + "'");
                Rs.next();
                
                if (Rs.getBoolean("es_transporte")==true){
                    
                    boo_esTransporte =true;
                    int_guia_transporte = Rs.getInt("guia_transporte");
                    StrTipoDocto = "FAT";
                    TipDocto_Master=StrTipoDocto;
                
                }else{
                
                    boo_esTransporte =false;
                    int_guia_transporte=-1;
                    StrTipoDocto = "GDC";
                    TipDocto_Master=StrTipoDocto;
                }
              
        }catch (Exception e) {
         
            System.out.println(e);
        
        }finally{
        
            Sql2.Close();
        }
        
        if (boo_esTransporte==false){
            
            if(!ValidaMargen()) return guardada;   //Valida Margenes menores al % 30
        }       

        if (JOptionPane.showConfirmDialog(null, "Guardar los cambios realizados.", "Guardar", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {

        //GRABA NUEVA GUIA DE DESPACHO
            //----------------------------
            if (Tipo == 1) {
                
                try {
               //OBTIENE CORRELATIVO
                    //------------------
                    
                    String NewCorrelativo="";
                    
                    if (boo_esTransporte){
                    
                        NewCorrelativo =  String.valueOf(int_guia_transporte);
                    
                    }else{
                        Sql.ExeSql("update par_correlativo set numero=numero + 1 where tipo='"+ StTipoGDC + "'");
                        NewCorrelativo = Sql.SelectUnico("select numero from par_correlativo where tipo='" + StTipoGDC +"'");
                    }
                    

                //INSERTA NUEVA GUIA DE DESPACHO
                    //------------------------------
                    //Objetivo: grabar el tipo de despacho directo o normal, se agrega en campo tipodespacho Smallint Defecto Null
                    // en la tabla ctactecli.
                    // Autor: Cristian Ramirez
                    // Fecha: 16/05/2017
                    //------------------------------
                    //------------------------------
                    //------------------------------Codigo modificado-------------------------------------
                      Query = " INSERT INTO ctactecli(\n"
                            + " rut, tipdocto, nrodocto, tipdocorigen, nrodocorigen, occh,femision, \n"
                            + " totalexento, totalafecto, totaliva,totalimpespecifico,totaldocto,codigo_oc, tipodespacho, anticipado ,  \n"
                            + " contacto,direccion_despacho, comuna_despacho,observacion,ciudad_despacho)"
                            + " VALUES ("
                            + txRut.getText() + ","
                            + "'" + StrTipoDocto + "',"
                            + NewCorrelativo + ","
                            + "'OCC',"
                            + cbCodigoOc.getSelectedItem().toString().trim() + ",'"
                            + cbNroOrden.getSelectedItem().toString().trim() + "','"
                            + getFechaAsString() + "',"
                            + fmMain.SetGuardar(txExento.getText().trim()) + ","
                            + fmMain.SetGuardar(txNeto.getText().trim()) + ","
                            + fmMain.SetGuardar(txIva.getText().trim()) + ","
                            + fmMain.SetGuardar(txImpEspecifico.getText().trim()) + ","
                            + fmMain.SetGuardar(txTotal.getText().trim()) + ","
                            + cbCodigoOc.getSelectedItem().toString().trim() + ", ";
                            
                            if (chk_Anticipado.isSelected())
                            {
                                intAnticipado = 1;
                            }
                            else
                            {                                
                                intAnticipado=0;
                            }
                      
                            Query = Query + cbTipoDespacho.getSelectedIndex() + ", " +  intAnticipado  + ", " + Integer.valueOf(txidContacto.getText().trim()) + 
                             ",'" + txDirDespacho.getText().trim() + "','" + txComunaDespacho.getSelectedItem().toString().trim() +  
                             "','" + txObservaciones.getText().trim() +         
                             "','" + txCiudadDespacho.getSelectedItem().toString().trim() + "')";  
                    //------------------------------------------------------------------------------------

                    Sql.ExeSql(Query);

                //INSERTA NUEVA GUIA DE DESPACHO PRODUCTOS
                    //---------------------------------------
                    for (int i = 0; i < Grilla.getRowCount(); i++) {
                        //Si la cantidad es mayor a cero
                        if(Double.valueOf(Grilla.getValueAt(i,GetCol("Cantidad")).toString().replace(",",""))>0){
                            Query = " INSERT INTO ctacteclidet(\n"
                                + " rut, tipdocto, nrodocto, sku, cantidad, valorunitario, totallinea)\n"
                                + " VALUES ("
                                + txRut.getText() + ","
                                + "'" + StrTipoDocto + "',"
                                + NewCorrelativo + ",'"
                                + Grilla.getModel().getValueAt(i, 0).toString().trim() + "',"
                                + fmMain.SetGuardar(Grilla.getModel().getValueAt(i, GetCol("Cantidad")).toString()) + ","
                                + fmMain.SetGuardar(Grilla.getModel().getValueAt(i, GetCol("UniReal")).toString()) + ","
                                + fmMain.SetGuardar(Grilla.getModel().getValueAt(i, GetCol("Total")).toString()) + ")";
                        Sql.ExeSql(Query);
                        }
                        
                    }
                    
                    
                    if (boo_esTransporte==true) 
                    {
                        Sql.Select("select actualiza_estado_oc_fat(" + txRut.getText() + "," + NewCorrelativo + "," + cbCodigoOc.getSelectedItem().toString().trim() + ",'" + cbNroOrden.getSelectedItem().toString().trim() + "')");
                    }
                    else
                    {    
                        Sql.Select("select actualiza_estado_oc(" + txRut.getText() + "," + NewCorrelativo + "," + cbCodigoOc.getSelectedItem().toString().trim() + ",'" + cbNroOrden.getSelectedItem().toString().trim() + "')");
                    }

                    Sql.Commit();
                    JOptionPane.showMessageDialog(null,"Guardado");
                    

                    AbrirGuia(txRut.getText(), NewCorrelativo,StrTipoDocto);  //Se Aghrega Tipdocto aa la funcion
                //    Emite_Guia();   //092018
                     
                    if (TipDocto_Master.equals(StTipoGDC))
                    {    
                        Emite_Guia();
                        SetTipo(2);
                    }  
                    else
                    {
                        SetTipo(1);
                        // deja PDF listo para imprimir
                        DocPDF(NewCorrelativo, StTipoGDC);
                    }  
                    
                    guardada=true;
                    return guardada;

                } catch (Exception e) {
                    Sql.Rollback();

                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                } finally {
                    Sql.Close();
                }

            } else {
                try {
                   // Actualiza la GDC si es de tipo FAT
                    if (StrTipoDocto.equals(StTipoFAT) )
                    {
                        
                        //Actualiza el encabezado
                            Query = "UPDATE ctactecli SET "
                            + "totalexento=" + fmMain.SetGuardar(txExento.getText().trim()) + ","
                            + "totalafecto=" + fmMain.SetGuardar(txNeto.getText().trim()) + ","
                            + "totaliva=" + fmMain.SetGuardar(txIva.getText().trim()) + ","
                            + "totalimpespecifico=" + fmMain.SetGuardar(txImpEspecifico.getText().trim()) + ",";
                            Query = Query + "tipodespacho =" + cbTipoDespacho.getSelectedIndex() + ", "
                            + "anticipado=" + intAnticipado + ", "        
                            + "observacion='" + txObservaciones.getText().trim() + "',"        
                            + "totaldocto=" + fmMain.SetGuardar(txTotal.getText().trim()) + " "
                            + " WHERE tipdocto= '" + StTipoFAT + "'" 
                            + " AND   nrodocto= " + lbNroDocto.getText().trim()
                            + " AND   rut=" + txRut.getText();
                            Sql.ExeSql(Query);
                        

                                for (int i = 0; i < Grilla.getRowCount(); i++) {
                                    if(Double.valueOf(Grilla.getValueAt(i,GetCol("Cantidad")).toString())>0){
                                        
                                            Query = " update  ctacteclidet \n" 
                                            + " set cantidad = " + fmMain.SetGuardar(Grilla.getModel().getValueAt(i, GetCol("Cantidad")).toString())
                                            + " , valorunitario = " + fmMain.SetGuardar(Grilla.getModel().getValueAt(i, GetCol("UniReal")).toString()) 
                                            + " , totallinea = "+ fmMain.SetGuardar(Grilla.getModel().getValueAt(i, GetCol("Total")).toString())    
                                            + " WHERE "
                                            + "     rut      = " + txRut.getText()
                                            + " AND tipdocto = '" + StTipoFAT + "'" 
                                            + " AND nrodocto= " + lbNroDocto.getText().trim()
                                            + " AND sku ='" + Grilla.getModel().getValueAt(i, 0).toString().trim() + "'";
                                        
                                    Sql.ExeSql(Query);
                                    
                                    }
                               }
                    }
                    Sql.Commit();
                    fmMain.Mensaje("Guia de Despacho Tipo FAT modificada correctamente");
                    guardada=true;
                    
                } catch (Exception e) {
                    Sql.Rollback();
                     guardada=false;
                  
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                } finally {
                    Sql.Close();
                }
            }
        }    
        return guardada;
}    
        
    
    
    
    
    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
       
        ExeSql Sql = new ExeSql();
        ExeSql Sql2 = new ExeSql();
        ExeSql Sql3 = new ExeSql();
        ExeSql Sql4 = new ExeSql();
        ExeSql Sql5 = new ExeSql();
        
        ResultSet Rs;
        boolean boo_esTransporte=false;
        int int_guia_transporte =-1;
        String StrTipoDocto = "";
        String Query = "";
        int intAnticipado=-1;
        
        int items = Grilla.getRowCount();
        
        
        System.out.println("Los Items SON : "+items);
        
        if (items > 38){
        
            fmMain.Mensaje("No se puede Generar documento con mas de 38 items!!");
            return;
        
        }
        
        
        if (txContacto.getText().trim().isEmpty()){
                    
            fmMain.Mensaje("Debe Ingresar Nombre del Contacto!!");
            return;
        
        }
                 
                    
        if (txFono.getText().trim().isEmpty()){
                        
            fmMain.Mensaje("Debe Ingresar Número Telefónico del Contacto!!");
            return;
                    
        }
        
        
        
//        double totalocc = Double.parseDouble(txTotalOCC.getText().trim());
//        double totalgdcant = Double.parseDouble(txTotalGDC.getText().trim());
//        double totalgdactual = Double.parseDouble(txTotal.getText().trim().replaceAll("\\,", ""));
//        
//        
//        double totalgdc = totalgdcant + totalgdactual;
//       
//        if (totalgdc > totalocc){
//        
//            fmMain.Mensaje("Total Guia(s) ( "+fmMain.FormatoNumeroSinDecimal(totalgdc)+" ) es mayor al total de la Orden ( "+fmMain.FormatoNumeroSinDecimal(totalocc)+" )");
//            return;
//        
//        }
        
        
        System.out.println("Montos Correctos.....!!");
            
        if (modificarCliente >= 1){
            
            if (JOptionPane.showConfirmDialog(null, "Usted realizo cambios en la ficha del cliente, desea guardarlos?.", "Guardar", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION){
           
                try{
              
                    Sql.ExeSql("update clicontacto set "
                             + " giro='" +txGiro.getText().trim()+"',"
                             + " direccion='" +txDireccion.getText().trim()+"',"
                             + " comuna='" +txComuna.getText().trim()+"',"
                             + " ciudad='" +txCiudad.getText().trim()+"'"
                             + " where rut=" +txRut.getText().trim()+ " and codigo_oc="+cbCodigoOc.getSelectedItem().toString().trim());
                    Sql.Commit();
              
                }catch(Exception e) {
             
                    Sql.Rollback();
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                }
            }
        }
        
        try {
            //Revisa si la OC es de Tipo Transporte 
            //----------------------------------
                Rs = Sql2.Select("select es_transporte, guia_transporte \n" +
                                 "from occh \n"+
                                 "where rut= " + txRut.getText().trim() + "\n" +
                                 "and codigo_oc=" + cbCodigoOc.getSelectedItem().toString().trim() + "\n"+
                                 "and orden='" + cbNroOrden.getSelectedItem().toString().trim() + "'");
                Rs.next();
                
                if (Rs.getBoolean("es_transporte")==true){
                    
                    boo_esTransporte =true;
                    int_guia_transporte = Rs.getInt("guia_transporte");
                    StrTipoDocto = "FAT";
                    TipDocto_Master=StrTipoDocto;
                
                }else{
                    boo_esTransporte =false;
                    int_guia_transporte=-1;
                    StrTipoDocto = "GDC";
                    TipDocto_Master=StrTipoDocto;
                }
        
        }catch (Exception e) {
            
            System.out.println(e);
        
        }finally{
        
            Sql2.Close();
        }
        
        if (boo_esTransporte==false){
            
             if(!ValidaMargen()) return;
        }

        if (JOptionPane.showConfirmDialog(null, "Guardar los cambios realizados.", "Guardar", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
           
                
            System.out.println("El Tipo ES : "+Tipo);
            
            if (Tipo == 1) {    //GRABA NUEVA GUIA DE DESPACHO
                try {
              
                    String NewCorrelativo="";
                    
                    if (boo_esTransporte){
                        
                        NewCorrelativo =  String.valueOf(int_guia_transporte);
                    
                    }else{

                        Rs = Sql.Select("select sp_getcorrelativo \n" +
                                        "from sp_getcorrelativo('GDC')");   
                        Rs.next();
                        NewCorrelativo  = Rs.getString("sp_getcorrelativo");
                        
                    }
                    
                  

                  //**************************************************** // 
                    
//                      NewCorrelativo = "22";    //Folio Provisorio
                    
                  //*****************************************************//  
                    
                //INSERTA NUEVA GUIA DE DESPACHO
                    //------------------------------
                    //Objetivo: grabar el tipo de despacho directo o normal, se agrega en campo tipodespacho Smallint Defecto Null
                    // en la tabla ctactecli.
                    //------------------------------Codigo modificado-------------------------------------
                      Query = " INSERT INTO ctactecli(\n"
                            + " rut, tipdocto, nrodocto, tipdocorigen, nrodocorigen, occh,femision, \n"
                            + " totalexento, totalafecto, totaliva,totalimpespecifico,totaldocto,codigo_oc, contacto_gdc, fono_gdc,tipodespacho, anticipado, \n"
                            + " contacto,direccion_despacho, comuna_despacho,observacion,ciudad_despacho)"
                            + " VALUES ("
                            + txRut.getText() + ","
                            + "'" + StrTipoDocto + "',"
                            + NewCorrelativo + ","
                            + "'OCC',"
                            + cbCodigoOc.getSelectedItem().toString().trim() + ",'"
                            + cbNroOrden.getSelectedItem().toString().trim() + "','"
                            + getFechaAsString() + "',"
                            + fmMain.SetGuardar(txExento.getText().trim()) + ","
                            + fmMain.SetGuardar(txNeto.getText().trim()) + ","
                            + fmMain.SetGuardar(txIva.getText().trim()) + ","
                            + fmMain.SetGuardar(txImpEspecifico.getText().trim()) + ","
                            + fmMain.SetGuardar(txTotal.getText().trim()) + ","
                            + cbCodigoOc.getSelectedItem().toString().trim() + ",'"
                            + txContacto.getText().trim() + "','"
                            + txFono.getText().trim() + "',";
                            
                            if (chk_Anticipado.isSelected()){
                                
                                intAnticipado = 1;
                            
                            }else{                                
                                
                                intAnticipado=0;
                            }
                      
                            
                            txidContacto.setText("0");
                            
                            Query = Query + cbTipoDespacho.getSelectedIndex() + ", " +  intAnticipado  + ", " + Integer.valueOf(txidContacto.getText().trim()) +  ",'" + 
                                            txDirDespacho.getText().trim() + "','" + txtComuna.getText().toString().trim() + "','" + 
                                            txObservaciones.getText().trim() + "','" + txtCiudad.getText().toString().trim() +"')";  
                            
                            
                    //------------------------------------------------------------------------------------

                    Sql4.ExeSql(Query);

                //INSERTA PRODUCTOS DE LA NUEVA GUIA DE DESPACHO
                    //---------------------------------------
                    for (int i = 0; i < Grilla.getRowCount(); i++) {
                      
                        if(Double.valueOf(Grilla.getValueAt(i,GetCol("Cantidad")).toString().replace(",",""))>0){   //Si la cantidad es mayor a cero
                            
                            Query = "INSERT INTO ctacteclidet ( \n"
                                  + " rut, tipdocto, nrodocto, sku, cantidad, valorunitario, totallinea)\n"
                                  + " VALUES ("
                                  + txRut.getText() + ","
                                  + "'" + StrTipoDocto + "',"
                                  + NewCorrelativo + ",'"
                                  + Grilla.getModel().getValueAt(i, 0).toString().trim() + "',"
                                  + fmMain.SetGuardar(Grilla.getModel().getValueAt(i, GetCol("Cantidad")).toString()) + ","
                                  + fmMain.SetGuardar(Grilla.getModel().getValueAt(i, GetCol("UniReal")).toString()) + ","
                                  + fmMain.SetGuardar(Grilla.getModel().getValueAt(i, GetCol("Total")).toString()) + ")";
                            
                            Sql5.ExeSql(Query);
                        }
                        
                    }
                    
                    Sql4.Commit();
                    Sql5.Commit();
                    
                    if (boo_esTransporte==true) 
                    {
                        
                        Sql.Select("select actualiza_estado_oc_fat(" + txRut.getText() + "," + NewCorrelativo + "," + cbCodigoOc.getSelectedItem().toString().trim() + ",'" + cbNroOrden.getSelectedItem().toString().trim() + "')");
                    
                    }else{    
                        
                        //Actualiza separado y despachado
                        
                        Sql.Select("select actualiza_estado_oc(" + txRut.getText() + "," + NewCorrelativo + "," + cbCodigoOc.getSelectedItem().toString().trim() + ",'" + cbNroOrden.getSelectedItem().toString().trim() + "')");
                    
                    }
                   
                    JOptionPane.showMessageDialog(null,"Guardado");

              
                    if (TipDocto_Master.equals(StTipoGDC)){    

                        AbrirGuia(txRut.getText(), NewCorrelativo,StrTipoDocto);  //Se Agrega Tipdocto a la función
                        Emite_Guia();
                        SetTipo(2);
                        txDireccion.setEnabled(false);
                        
                    }else{
                        
                        SetTipo(1);
                        
                    }  
//                  ********************************                   
                    
                    
                    Sql3.ExeSql("update autorizaciones set guia=3 \n"+
                                "where codigo_oc="+ cbCodigoOc.getSelectedItem() +"\n" +
                                "and rut="+txRut.getText().toString().trim() +"\n" +
                                "and orden='"+ cbNroOrden.getSelectedItem().toString().trim() +"' \n" +
                                "and guia = 0");
                    Sql3.Commit();
                    
                    
                    btCiudad.setEnabled(false);
                    btComuna.setEnabled(false);

                }catch (SQLException e) {
                
                    Sql.Rollback();
                    Sql3.Rollback();

                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                    Logger.getLogger(pfGDCliente.class.getName()).log(Level.SEVERE, null, e);
                
                }finally {
                    
                    Sql.Close();
                }

            }else {
             
                try {
                     
                   // Actualiza la GDC si es de tipo FAT
                    
                    if (StrTipoDocto.equals(StTipoFAT)){
                                                
                        //Actualiza el encabezado
                            Query = "UPDATE ctactecli SET "
                                  + "totalexento=" + fmMain.SetGuardar(txExento.getText().trim()) + ","
                                  + "totalafecto=" + fmMain.SetGuardar(txNeto.getText().trim()) + ","
                                  + "totaliva=" + fmMain.SetGuardar(txIva.getText().trim()) + ","
                                  + "totalimpespecifico=" + fmMain.SetGuardar(txImpEspecifico.getText().trim()) + ",";
                            
                            Query = Query + "tipodespacho =" + cbTipoDespacho.getSelectedIndex() + ", "
                                          + "anticipado=" + intAnticipado + ", "        
                                          + "observacion='" + txObservaciones.getText().trim() + "',"        
                                          + "totaldocto=" + fmMain.SetGuardar(txTotal.getText().trim()) + " "
                                          + " WHERE tipdocto= '" + StTipoFAT + "'" 
                                          + " AND   nrodocto= " + lbNroDocto.getText().trim()
                                          + " AND   rut=" + txRut.getText();
                            
                            Sql.ExeSql(Query);

                                for (int i = 0; i < Grilla.getRowCount(); i++) {

                                    if(Double.valueOf(Grilla.getValueAt(i,GetCol("Cantidad")).toString())>0){
        
                                            Query = " update  ctacteclidet \n" 
                                            + " set  valorunitario = " + fmMain.SetGuardar(Grilla.getModel().getValueAt(i, GetCol("UniReal")).toString()) 
                                            + " , totallinea = "+ fmMain.SetGuardar(Grilla.getModel().getValueAt(i, GetCol("Total")).toString())    
                                            + " WHERE "
                                            + " rut  = " + txRut.getText()
                                            + " AND tipdocto = '" + StTipoFAT + "'" 
                                            + " AND nrodocto= " + lbNroDocto.getText().trim()
                                            + " AND sku ='" + Grilla.getModel().getValueAt(i, 0).toString().trim() + "'";
                                        
                                    Sql.ExeSql(Query);
                                    
                                    }
                               }
                    }
                    Sql.Commit();
                    fmMain.Mensaje("Guia de Despacho Tipo FAT modificada correctamente");
                    txDireccion.setEnabled(false);
                    
                } catch (Exception e) {
                    Sql.Rollback();
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                } finally {
                    Sql.Close();
                }
            }
            
            Verifica_Completa(txRut.getText().trim(),cbCodigoOc.getSelectedItem().toString().trim(), cbNroOrden.getSelectedItem().toString().trim() );
            
            
            
        }
        
        
        btPDF.setVisible(true);
    }//GEN-LAST:event_btGuardarActionPerformed

    
    private void Verifica_Completa(String rut,String codigoOc,String orden){
    
        ExeSql Sql = new ExeSql();
        ExeSql Sql2 = new ExeSql();
        ResultSet Rs;
        
        try {
            
            Rs = Sql.Select("select o.rut,o.codigo_oc,o.orden, sum(o.cantidad) as cant, sum(o.despachado) as despacho  from occhdet o\n" +
                            "where o.rut= "+rut.trim()+" \n" +
                            "and o.codigo_oc= "+codigoOc.trim()+" \n" +
                            "and o.orden='"+orden+"'\n" +
                            "group by o.rut, o.codigo_oc,o.orden");
            
            
            if (Sql.GetRowCount() > 0){
            
                Rs.next();
                
                
                if (Rs.getInt("cant") == Rs.getInt("despacho")){
                
                    
                    Sql2.ExeSql("UPDATE occh SET \n" +
                                "estado = 2, \n" +
                                "estadodespacho = 2 \n" +
                                "WHERE rut= " + rut.trim() + " \n" +
                                "AND codigo_oc=" + codigoOc + "\n" +
                                "AND orden='" + orden + "'");
                    
                    Sql2.Commit();
                    
                
                }
            
            }
        
        
        } catch (SQLException ex) {
             Sql2.Rollback();
            Logger.getLogger(pfNVCliente.class.getName()).log(Level.SEVERE, null, ex);
        
        }finally{
            
           Sql2.Close();
        
        }
        
    
    }


//--------------------------------------------------------------------------------
// SUMADOR
//--------------------------------------------------------------------------------
private void Sumador(){    
    
    double Neto=0;
    double Neto2=0;
    double Exento=0;
    double Iva=0;
    double Total=0;
    String Unitario,Cantidad;
    
    for(int i=0; i< Grilla.getRowCount(); i++){
        Unitario = Grilla.getModel().getValueAt(i,GetCol("UniReal")).toString();
        Cantidad = Grilla.getModel().getValueAt(i,GetCol("Cantidad")).toString();
        Unitario = Unitario.replace(fmMain.GetMiles(), "");
        Cantidad = Cantidad.replace(fmMain.GetMiles(), "");
        Neto =  Double.parseDouble(Unitario) * Double.parseDouble(Cantidad) + Neto;
    }
    
    //Neto = Math.round(Neto);
    
    System.out.println("Neto ES : "+Neto);
    
    Iva = Math.round(Neto * Double.parseDouble("0.19"));
    
    
    
    if(PesoCorreccion != 0){
        if(PesoCorreccion==1)
            Iva = Iva +1;
        else
            Neto = Neto -1;
    }
    
    
    
    Total = Neto + Iva;

    
    txNeto.setText(fmMain.FormatoTotal(Neto));
    txExento.setText(fmMain.FormatoTotal(Exento));
    txIva.setText(fmMain.FormatoTotal(Iva));
    txTotal.setText(fmMain.FormatoTotal(Total));
    
}
//------------------------------------------------------------------------------
//  
//------------------------------------------------------------------------------
    private void GrillaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrillaMouseClicked
        
    double cant,prec;    
        if(evt.getClickCount()==2 && !Grilla.getValueAt(Grilla.getSelectedRow(), 0).toString().isEmpty() && Tipo == 1){
            jdIngresaNumero2 jdNumero = new jdIngresaNumero2(null, true);
            jdNumero.setLocationRelativeTo(null);
            prec = Double.parseDouble(fmMain.SetGuardar(Grilla.getValueAt(Grilla.getSelectedRow(), GetCol("Unitario")).toString()));
            cant = Double.parseDouble(fmMain.SetGuardar(Grilla.getValueAt(Grilla.getSelectedRow(), GetCol("Cantidad")).toString()));
            jdNumero.SetNumero(cant);
            jdNumero.SetPrecio(prec);
            if (TipDocto_Master == null)
                {
                    TipDocto_Master="";
                }
            jdNumero.setTipoDocto(TipDocto_Master);
            jdNumero.setVisible(true);        
            
            
            if(jdNumero.GetNumero() != -99 && TipDocto_Master.equals(StTipoGDC)){
                
                Grilla.setValueAt(fmMain.FormatoNumero(jdNumero.GetNumero()), Grilla.getSelectedRow(),GetCol("Cantidad"));
                Grilla.setValueAt(fmMain.FormatoNumero(jdNumero.GetPrecio()), Grilla.getSelectedRow(), GetCol("Unitario"));
                Grilla.setValueAt(jdNumero.GetPrecio(), Grilla.getSelectedRow(), GetCol("UniReal"));
                
                double Total = jdNumero.GetNumero() * Double.parseDouble(fmMain.SetGuardar(Grilla.getValueAt(Grilla.getSelectedRow(), GetCol("Unitario")).toString()));
                
                Grilla.setValueAt(fmMain.FormatoNumero(Total), Grilla.getSelectedRow(), GetCol("Total"));
                Sumador();
            }
            else{
                //Grilla.setValueAt(fmMain.FormatoNumero(jdNumero.GetNumero()), Grilla.getSelectedRow(),GetCol("Cantidad"));
                double Total =Double.parseDouble(fmMain.SetGuardar(Grilla.getValueAt(Grilla.getSelectedRow(), GetCol("Cantidad")).toString())) * jdNumero.GetPrecio()  ;
                Grilla.setValueAt(fmMain.FormatoNumero(jdNumero.GetPrecio()), Grilla.getSelectedRow(), GetCol("Unitario"));
                Grilla.setValueAt(fmMain.FormatoNumero(jdNumero.GetPrecio()), Grilla.getSelectedRow(), GetCol("UniReal"));
                Grilla.setValueAt(fmMain.FormatoNumero(Total), Grilla.getSelectedRow(), GetCol("Total"));
                Sumador();
            }
            
        }
        
    }//GEN-LAST:event_GrillaMouseClicked
    
    private void DocPDF(String Numero, String TipoDoc){
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        ExeSql Sql1 = new ExeSql();
        ResultSet Rs1;
        String Query="";
        String path;
        String server,user,pass,ruta_local="";
        int puerto =21;
        String filtro="";
        String archivo_local = "";
        String Tipo="";            
     
try {
           

//---------                     Trae Datos Ftp            ----------------------
//Creado por CRM - 15-06-2017            
 //trae datos ftp
            server="";
            puerto=0;
            user=""; 
            pass="";
            
                
                //Busqueda de Tipo 
                Rs1 = Sql1.Select("SELECT nrodoc from tipo_doc where tipo='" + TipoDoc + "'");
                if (Rs1.next())
                {
                    Tipo = String.valueOf(Rs1.getInt("nrodoc"));
                }
            
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
                    
                     System.out.println("Carpeta Asignada " + ruta_local );
            
                    // Primer buscara el archivo en ruta local
                    filtro = Tipo + "F" + Numero + ".pdf";
                    System.out.println("Busca en carpeta  local" + ruta_local +"/"+filtro );
                    archivo_local = BuscaArchivos(new File(ruta_local),filtro);
                    System.out.println("Busca archivo en FTP -->" + ruta_local +"/"+filtro );
                    Ftp.busca_archivo_ftp(server, puerto, user, pass, ruta_local,archivo_local, filtro);
                    System.out.println("Sale de Busca Archivo" + filtro );
                        }
catch (Exception e) {
            fmMain.Mensaje("Existe una inconsistencia en la información.");
        }finally{
            Sql.Close();
        }
    }
    
    
    private void btEmitirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEmitirActionPerformed

        
    if (TipDocto_Master.equals(StTipoGDC)){    
        Emite_Guia();
    }//GEN-LAST:event_btEmitirActionPerformed
}
    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        SetTipo(3);
    }//GEN-LAST:event_btEditarActionPerformed

    private void btCorrigePesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCorrigePesoActionPerformed
        jdAjustePesos aju = new jdAjustePesos(null, true);
        aju.setLocationRelativeTo(null);
        aju.setTitle("Ajuste Pesos");
        aju.setVisible(true);
        PesoCorreccion = aju.GetAjuste();  
        Sumador();
        
    }//GEN-LAST:event_btCorrigePesoActionPerformed

    private void btActualizarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActualizarDatosActionPerformed
        if (!lbNroDocto.getText().equals("")){
            
            JOptionPane.showMessageDialog(null,"La guia ya fue emitida, no se puede actualizar datos de cliente"); 
            return;
        }
        
            System.out.println("EL Tipo ES :"+Tipo);
            
            if (Tipo == 1) {    //NUEVA GUIA DE DESPACHO
            
                Actualizar();
                
                
            }else{ 
        
                if (btActualizarDatos.isSelected()){
                
                    txGiro.setEnabled(false);
                    txDireccion.setEnabled(false);
                    txComuna.setEnabled(false);
                    txCiudad.setEnabled(false);
                    txDirDespacho.setEnabled(true);
                    txComunaDespacho.setEnabled(true);
                    txCiudadDespacho.setEnabled(true);
                    txContacto.setEnabled(true);
                    txidContacto.setVisible(false);
           // btContacto.setVisible(true);
                    btContacto.setEnabled(true);
                    modificarCliente = 1;
                }else{
            
                    txGiro.setEnabled(false);
                    txDireccion.setEnabled(false);
                    txComuna.setEnabled(false);
                    txCiudad.setEnabled(false);
                    txDirDespacho.setEnabled(false);
            
                    txComunaDespacho.setEnabled(false);
                    txCiudadDespacho.setEnabled(false);
                    txContacto.setEnabled(false);
                    txidContacto.setVisible(false);
                    btContacto.setEnabled(false);
            
                }
        
            }
        
    }//GEN-LAST:event_btActualizarDatosActionPerformed

    
    private void Actualizar(){
    
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        
        try {
           
            Rs = Sql.Select("select * from clicontacto\n"+
                           "where rut=" + txRut.getText() + "\n"+
                           "and codigo_oc=" + cbCodigoOc.getSelectedItem().toString());
            Rs.next();
            
            if(Rs.getInt("bloqueo")==1){
                lbBloqueo.setVisible(true);
                btGuardar.setEnabled(false);
            }
            else{
                lbBloqueo.setVisible(false);
                btGuardar.setEnabled(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(pfGDCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    
    
    
    
    }
    
    
    
    private void btEmiteManActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEmiteManActionPerformed
      
            Emite_Guia();
            btPDF.setEnabled(true);  
      
      
    }//GEN-LAST:event_btEmiteManActionPerformed

    private void cbNroOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNroOrdenActionPerformed
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();

        if(Tipo==2) return; 

        //Limpia Grilla de Productos
        while (TableModel.getRowCount() > 0)
        TableModel.removeRow(0);

        String Query =  "select d.sku,p.nombre,u.um,d.separado,d.valorunitario,d.totlinea\n" +
                        "from occhdet d\n" +
                        "left join producto p \n" +
                        "on d.sku=p.sku\n" +
                        "left join par_unidad u\n" +
                        "on p.unidad=u.codigo\n" +
                        "where rut=" + txRut.getText() +
                        " and codigo_oc=" + cbCodigoOc.getSelectedItem().toString().trim() +
                        " and orden='" + cbNroOrden.getSelectedItem().toString().trim() + "' \n" +
                        "and separado > 0";
        try{
            //BLOQUEO - Revisa si esta bloqueado
            if(lbBloqueo.isVisible()){
                Rs = Sql.Select("select count(*) as contador\n" +
                    "from cli_desbloqueo\n" +
                    "where rut="+ txRut.getText() +"\n" +
                    "and Codigo_OC="+ cbCodigoOc.getSelectedItem().toString().trim() +"\n" +
                    "and orden='" + cbNroOrden.getSelectedItem().toString().trim() + "'");
                Rs.next();
                if(Rs.getInt("contador")>0){
                    lbBloqueo.setVisible(false);
                    btGuardar.setEnabled(true);
                }
            }

            Rs = Sql.Select(Query);
            while(Rs.next()){
                TableModel.addRow(new Object[]{
                    Rs.getString("sku"),
                    Rs.getString("nombre"),
                    Rs.getString("um"),
                    fmMain.FormatoNumero(Rs.getDouble("separado")),
                    fmMain.FormatoNumero(Rs.getDouble("valorunitario")),
                    fmMain.FormatoNumero(Rs.getDouble("separado")*Rs.getDouble("valorunitario")),
                    //fmMain.FormatoNumero(Rs.getDouble("totlinea")),
                    //Rs.getDouble("valorunitario")
                    fmMain.FormatoNumero2(Rs.getDouble("valorunitario"))    
                });
                
        }
        Sumador();

        CargaTotalOCC(cbCodigoOc.getSelectedItem().toString().trim(),cbNroOrden.getSelectedItem().toString().trim());
        
        
        
      
        } catch (Exception e) {
            System.out.println(e);
        } finally{
            Sql.Close();
        }
    }//GEN-LAST:event_cbNroOrdenActionPerformed

    
    
    private void CargaTotalOCC(String CodigoOc, String Orden){
    
        ExeSql Sql = new ExeSql();
        ExeSql Sql2 = new ExeSql();
        ResultSet Rs;
        ResultSet Rs2;
        
        try {
            
            Rs = Sql.Select("select totaldocto from occh\n" +
                            "where rut="+ txRut.getText() +"\n" +
                            "and codigo_oc="+ CodigoOc.trim() +"\n" +
                            "and orden IN ('" + Orden.trim() + "')");
            
            
            if (Sql.GetRowCount() > 0){
            
                Rs.next();
                txTotalOCC.setText(Rs.getString("totaldocto"));
            
            }else{
            
                txTotalOCC.setText("0");
            
            }
            
            
            Rs2 = Sql2.Select("select sum(totaldocto) as sumagdc from ctactecli\n" +
                            "where rut="+ txRut.getText() +"\n" +
                            "and codigo_oc="+ CodigoOc.trim() +"\n" +
                            "and occh IN ('" + Orden.trim() + "') \n"+
                            "and tipdocto IN ('GDC')");
            
            
            if (Sql2.GetRowCount() > 0){
            
                Rs2.next();
                txTotalGDC.setText(Rs2.getString("sumagdc"));
            
            }else{
            
                txTotalGDC.setText("0");
            
            }
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(pfGDCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    }
    
    
    
    private void cbCodigoOcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCodigoOcActionPerformed

        if(Tipo==2 || Tipo==3){
            DefaultComboBoxModel cbMd2 = new DefaultComboBoxModel();
            cbMd2.addElement(OrdenOC);
            cbNroOrden.setModel(cbMd2);

        }
        else{
            CargaDatosCodigoOC();
        }
    }//GEN-LAST:event_cbCodigoOcActionPerformed

    private void btPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPDFActionPerformed
        

        //busca_pdf();
        
        busca_pdfGdc();
        
     
    }//GEN-LAST:event_btPDFActionPerformed

    
    public void busca_pdfGdc(){
    
        int encontrado = 0;
        
        try {
            
            
            String Tipo;
            String Numero;
           
            long size = 0;
            
             
            Tipo="GDC";
            System.out.println(Tipo);
            System.out.println(lbNroDocto.getText().trim());
            Numero= Tipo+lbNroDocto.getText().trim()+".";
            
           
            File directorio = new File("C:\\doc_luvaly");

            if (directorio.exists()){
                              
                File[] archivos = directorio.listFiles();
                
                for (File elemento : archivos) {
            
                    if (elemento.getName().contains(Numero)) {
                        
                          Numero = elemento.getName();
                          encontrado = 1;
                          break;
                        
                    }else{
                    
                        encontrado = 0;
                    }
                }
                
                
                
            }else if (!directorio.exists()){
                
                directorio.mkdir();
                
                
            }
            
            
            if (encontrado == 1 ){
            
                Path filePath =  Paths.get("c:/doc_luvaly/"+Numero);
            
                size = Files.size(filePath);
                System.out.println("The file size is " + size + " bytes");
            
            }
            
            
            if (encontrado == 1 && size > 0 ){
            
                System.out.println("EL Documento ES :"+Numero);
                System.out.println("ENTRA A LOCAL !!!!!!!!!!!");

                File objetofile = new File ("c:/doc_luvaly/"+Numero);
                Desktop.getDesktop().open(objetofile);
                
                
                
            }else if (encontrado == 1 && size == 0 ){
                
                System.out.println("EL Documento ES :"+Numero);
                System.out.println("ENTRA A REMOTO 1 !!!!!!!!!!!");
                
                
                
                String ElRut = txRut.getText().trim()+"-"+txDv.getText().trim();
                
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String Fecha = sdf.format(dtEmision.getDate());
                String ElTotal = txTotal.getText().trim().replaceAll("\\,", "");
                
                Imprimir("76231391-K",ElRut,"52",lbNroDocto.getText().trim(),Fecha,ElTotal,0,2);
                
            }else if (encontrado == 0){
                
                System.out.println("EL Documento ES :"+Numero);
                System.out.println("ENTRA A REMOTO 2 !!!!!!!!!!!");
                
                
                try{
                    
                    String ElRut = txRut.getText().trim()+"-"+txDv.getText().trim();
                
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String Fecha = sdf.format(dtEmision.getDate());
                    String ElTotal = txTotal.getText().trim().replaceAll("\\,", "");
                
                    Imprimir("76231391-K",ElRut,"52",lbNroDocto.getText().trim(),Fecha,ElTotal,0,2);
                
                }catch (Exception e){
                
//                        System.out.println("El arhivo no fue encontrado...");
//                        return;
                   
                     busca_pdf();
                    
                    
                }
            
            }
            
            
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se pudo abrir el archivo,"
                    + " probablemente fue borrado","ERROR",JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(pfGDCliente.class.getName()).log(Level.SEVERE, null, e);
                
        }
    
    }
    
    
    
    
    
    
    public void busca_pdf(){
    
        int encontrado = 0;
        
        try {
            
            
            String Tipo;
            String Numero;
            int cont =0; 
            long size = 0;
             
            Tipo="52F";
            System.out.println(Tipo);
            System.out.println(lbNroDocto.getText().trim());
            Numero= Tipo+lbNroDocto.getText().trim()+".";
            
            File directorio = new File("C:\\facturas");

            if (directorio.exists()){
    
                              
                File[] archivos = directorio.listFiles();
                
                for (File elemento : archivos) {
            
                    if (elemento.getName().contains(Numero)) {
                        
                          Numero = elemento.getName();
                          encontrado = 1;
                          break;
                        
                    }else{
                    
                        encontrado = 0;
                    }
                }
                
                
                
            }else if (!directorio.exists()){
        
//                System.out.println("El directorio no existe, verifique la ruta local...");
//                return;
                
                directorio.mkdir();
                
                
            }
            
            
            if (encontrado == 1 ){
            
                Path filePath =  Paths.get("c:/facturas/"+Numero);
            
                size = Files.size(filePath);
                System.out.println("The file size is " + size + " bytes");
            
            }
            


            if (encontrado == 1 && size > 0 ){
            
                System.out.println("EL Documento ES :"+Numero);
                System.out.println("ENTRA A LOCAL !!!!!!!!!!!");

                File objetofile = new File ("c:/facturas/"+Numero);
                 Desktop.getDesktop().open(objetofile);
                
            
           
           
            }else if (encontrado == 1 && size == 0 ){
            
                
                System.out.println("ENTRA A REMOTO con Archivo LOCAL en 0   !!!!!!!!!");
                
                File directorioFtp = new File("\\\\192.168.0.130\\Documentos Electronicos");
               

                if (directorioFtp.exists()){   //Se verifica que el directorio (carpeta) exista
    
                    File[] archivos = directorioFtp.listFiles();      //se capturan los nombres de todos los archivos del directorio
                
                    for (File elemento : archivos) {     //se va leyendo cada archivo
            
                        if (elemento.getName().contains(Numero)) {    //Si el nombre del archivo contiene el nombre que se busca
                        
                           Numero = elemento.getName();           //Se nota el nombre completo del archivo 
                           encontrado = 1;                        //Se indica que se ha encontrado  
                           break;                                 //Se termona el ciclo for  
                        
                        }else{
                    
                           encontrado = 0;
                        }
                    }
                    
                    
                    //***********
                    if (encontrado == 1){   //Si el archivo fue encontrado
            
                        System.out.println("LA Documento ES :"+Numero);
            

                        //File objetofile = new File ("c:/facturas/"+Factura);
                        File objetofile = new File ("//192.168.0.130/Documentos Electronicos/"+Numero);
                        
                        Desktop.getDesktop().open(objetofile);   //Se abre el archivo segun el programa asociado a él (configurado previamente en Windows)
                
                    }else if (encontrado == 0){
                    
                        System.out.println("El Archivo no existe...");
                        
                    
                    }        
                //***********
                
                }else{
        
                    System.out.println("El directorio no existe, verifique la ruta remota...");
                    return;
                }   
               
                
            }else if (encontrado == 0){
                
                 System.out.println("ENTRA A REMOTO !!!!!!!!!!!");
                
                File directorioFtp = new File("\\\\192.168.0.130\\Documentos Electronicos");
               

                if (directorioFtp.exists()){   //Se verifica que el directorio (carpeta) exista
    
                    File[] archivos = directorioFtp.listFiles();      //se capturan los nombres de todos los archivos del directorio
                
                    for (File elemento : archivos) {     //se va leyendo cada archivo
            
                        if (elemento.getName().contains(Numero)) {    //Si el nombre del archivo contiene el nombre que se busca
                        
                           Numero = elemento.getName();           //Se nota el nombre completo del archivo 
                           encontrado = 1;                        //Se indica que se ha encontrado  
                           break;                                 //Se termona el ciclo for  
                        
                        }else{
                    
                           encontrado = 0;
                        }
                    }
                    
                    
                    //***********
                    if (encontrado == 1){   //Si el archivo fue encontrado
            
                        System.out.println("LA Documento ES :"+Numero);
            

                        //File objetofile = new File ("c:/facturas/"+Factura);
                        File objetofile = new File ("//192.168.0.130/Documentos Electronicos/"+Numero);
                        
                        Desktop.getDesktop().open(objetofile);   //Se abre el archivo segun el programa asociado a él (configurado previamente en Windows)
                
                    }else if (encontrado == 0){
                    
                        System.out.println("El Archivo no existe...");
                        
                    
                    }        
                //***********
                
                }else{
        
                    System.out.println("El directorio no existe, verifique la ruta remota...");
                    return;
                }   
            
            
            }
            
            
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se pudo abrir el archivo,"
                    + " probablemente fue borrado","ERROR",JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(pfFACCliente.class.getName()).log(Level.SEVERE, null, e);
                
        }
    
    }
    
    
    
    
    
    
    
    private void txDireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txDireccionKeyReleased
        txDireccion.setText(txDireccion.getText().toUpperCase());
    }//GEN-LAST:event_txDireccionKeyReleased

    private void txDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txDireccionActionPerformed

    private void txDirDespachoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txDirDespachoKeyTyped
        // TODO add your handling code here:
            char c=evt.getKeyChar(); 
               if(c == '(' || c == ')') { 
                    getToolkit().beep(); 
                    evt.consume(); 
                    System.out.println("Ingresar sin espacios  ." ); 
                } 
        
        
        
        if (txDirDespacho.getText().length() >= LimiteDireccion)
        {
            evt.consume();
        }
        
    }//GEN-LAST:event_txDirDespachoKeyTyped

    private void txDirDespachoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txDirDespachoKeyReleased
        txDirDespacho.setText(txDirDespacho.getText().toUpperCase());
    }//GEN-LAST:event_txDirDespachoKeyReleased

    private void txCiudadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCiudadKeyReleased
        txCiudad.setText(txCiudad.getText().toUpperCase());
    }//GEN-LAST:event_txCiudadKeyReleased

    private void txCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txCiudadActionPerformed

    private void txComunaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txComunaKeyReleased
        txComuna.setText(txComuna.getText().toUpperCase());
    }//GEN-LAST:event_txComunaKeyReleased

    private void txComunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txComunaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txComunaActionPerformed

    private void txGiroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txGiroKeyReleased
        txGiro.setText(txGiro.getText().toUpperCase());
    }//GEN-LAST:event_txGiroKeyReleased

    private void txGiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txGiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txGiroActionPerformed

    private void txNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNombreKeyTyped

    }//GEN-LAST:event_txNombreKeyTyped

    private void txNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNombreKeyReleased
        txNombre.setText(txNombre.getText().toUpperCase());
    }//GEN-LAST:event_txNombreKeyReleased

    private void btIrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIrActionPerformed
        boolean Carga;

        if (!txRut.getText().isEmpty()) {
            Carga = CargaCliente(txRut.getText());

        } else {
            jdBuscarCliPrv BPC = new jdBuscarCliPrv(null, true); 
            BPC.setLocationRelativeTo(null);
            BPC.setTitle("Buscar Cliente");
            BPC.SetTipo(1);
            BPC.setVisible(true);
            Carga = CargaCliente(BPC.GetRut());   
        }

        // Si cargó cliente y es nuevo.
        if (Carga && Tipo == 1) {
            SetTipo(1);
            FindeAgno();
            txDirDespacho.setEditable(true);
            txDirDespacho.setEnabled(true);
            txDireccion.setEditable(true);
            txDireccion.setEnabled(true);
            
            txContacto.setEditable(true);
            txContacto.setEnabled(true);
            
            txFono.setEditable(true);
            txFono.setEnabled(true);
            
            txidContacto.setEditable(true);
            txidContacto.setEnabled(true);
        }
        // Si cargó cliente y esta abriendo
        if (Carga && Tipo == 2) {

            jdAbrirDocumento ADoc = new jdAbrirDocumento(null, true);
            //if (ADoc.ShowModal("GDC", RutMaster) == JOptionPane.YES_OPTION) {
            if (ADoc.ShowModal(TipDocto_Master, RutMaster) == JOptionPane.YES_OPTION) {
                 //VERIFICA NIVEL DE USUARIO PARA EDITAR GUIA DE DESPACHO
                int pruebaUusario = 100;
                int intNivelUsuario = 0;
                intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
                if( intNivelUsuario == pruebaUusario){
                    btEditar.setVisible(true);
                }else{
                    btEditar.setVisible(false);
                }
                AbrirGuia(RutMaster, ADoc.GetNumero(),TipDocto_Master);
                SetTipo(2);
                btEditar.setEnabled(true);
                txDirDespacho.setEditable(false);
                txDirDespacho.setEnabled(false);
               
               
            }else{
                txRut.setText("");
                txNombre.setText("");
                txRut.requestFocus();
            }

        }
    }//GEN-LAST:event_btIrActionPerformed

    private void txRutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRutKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btIr.doClick();
        }
    }//GEN-LAST:event_txRutKeyPressed

    private void btContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btContactoActionPerformed
        // TODO add your handling code here:
            String Vendedor;
        try {
            jdContactosCli Con = new jdContactosCli(null, true);

            Vendedor = Con.Show(RutMaster,cbCodigoOc.getSelectedItem().toString().trim(), "TIPCONTACTOCLI",true).trim();
            if(!Vendedor.equals(""))
            txContacto.setText(Con.GetUsuario());
            txidContacto.setText(Con.GetUsuarioId());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btContactoActionPerformed

    private void cbTipoDespachoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoDespachoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipoDespachoActionPerformed

    private void btAbrir_FATActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbrir_FATActionPerformed
        Abre_FAT();
        lbTransporte.setVisible(true);
    }//GEN-LAST:event_btAbrir_FATActionPerformed

    private void btEmiteTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEmiteTransActionPerformed
        // TODO add your handling code here:
        
        if (GuardaGuia()==true){
                Emite_Transporte();
                Habilita(false);
                Edicion(false);
                btGuardar.setEnabled(false);
                btCancelar.setEnabled(false);
                btNuevo.setEnabled(true);
                btAbrir.setEnabled(true);
                btAbrir_FAT.setEnabled(true);
        }
        else
        {
            fmMain.Mensaje("Error al Grabar Datos de Guia, intente nuevamente");
            
        }
      
    }//GEN-LAST:event_btEmiteTransActionPerformed

    
    
    private void merma()
    {
        
        //ESTADO =2 MERMA.
        
        // TODO add your handling code here:
         ExeSql Sql = new ExeSql();        
        try {
            Sql.ExeSql("update ctactecli set estado=2 where tipdocto='" + StTipoGDC + "' and nrodocto=" + lbNroDocto.getText().trim()+" and rut = "+txRut.getText()+"");
            Sql.Commit();
            JOptionPane.showMessageDialog(null,"Documento Emitido a Merma");
            btEmitir.setEnabled(false);
            txEstado.setText("Emitida");
            btEditar.setEnabled(false);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
    }
    
            
    
    
    
    private void bt_MermaStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_MermaStockActionPerformed
               
           jd_Emision_Merma_Stock jdMermaStock = new jd_Emision_Merma_Stock(null, true);
           jdMermaStock.Rut = txRut.getText().trim();
           jdMermaStock.Numero = lbNroDocto.getText().trim();
           jdMermaStock.TipDocto = TipDocto_Master;
           jdMermaStock.Cliente = txNombre.getText().trim();
           jdMermaStock.Codigo_oc = cbCodigoOc.getSelectedItem().toString().trim();
           jdMermaStock.AbrirGuia2();
           jdMermaStock.setVisible(true);
           
            AbrirGuia(txRut.getText().trim(), lbNroDocto.getText().trim(), TipDocto_Master);
//            Habilita(false);
//            Edicion(false);
//            btEmiteTrans.setEnabled(false);
//            bt_MermaStock.setEnabled(false);
//            txEstado.setText("Emitido");
//            btEditar.setEnabled(false);
            
    }//GEN-LAST:event_bt_MermaStockActionPerformed

    private void btLiberarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLiberarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btLiberarActionPerformed

    private void txComunaDespachoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txComunaDespachoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txComunaDespachoActionPerformed

    private void txContactoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txContactoKeyTyped
        
        if (Character.isLowerCase(evt.getKeyChar()))
        evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        
    }//GEN-LAST:event_txContactoKeyTyped

    private void txtCiudadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCiudadKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCiudadKeyTyped

    private void txtComunaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComunaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComunaKeyTyped

    private void btComunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btComunaActionPerformed

        jd_Localidades Ubicacion = new jd_Localidades(null, true);
        Ubicacion.setLocationRelativeTo(null);
        Ubicacion.setTitle("Buscar Comuna");
        Ubicacion.Carga();
        Ubicacion.setVisible(true);

        if (Ubicacion.GetElige() == 1){

            txtComuna.setText(Ubicacion.GetNomComuna().trim());

        }

    }//GEN-LAST:event_btComunaActionPerformed

    private void btCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCiudadActionPerformed
       
        jd_Localidades Ubicacion = new jd_Localidades(null, true);
        Ubicacion.setLocationRelativeTo(null);
        Ubicacion.setTitle("Buscar Ciudad");
        Ubicacion.Carga();
        Ubicacion.setVisible(true);
        
        if (Ubicacion.GetElige() == 1){
        
            txtCiudad.setText(Ubicacion.GetNomCiudad().trim());
        
        }
        
        
    }//GEN-LAST:event_btCiudadActionPerformed

    public void Abre_FAT(){
        
        Habilita(false);
        Edicion(false);
        Limpia();
        lbTransporte.setVisible(true);
        txRut.setEnabled(true);
        txRut.setEditable(true);
        btIr.setEnabled(true);
        btCancelar.setEnabled(true);
        txDirDespacho.setEditable(false);
        txRut.requestFocus();
        btEditar.setEnabled(false);
        SetTipo(2);
        TipDocto_Master ="FAT";
    }
    
    
    private void trae_comuna(){
      
        jdComunas Comuna = new jdComunas(null, true);
        Comuna.CargaComunas();
        Comuna.setVisible(true);
        txComunaDespacho.setSelectedItem(Comuna.GetComuna());
        txCiudadDespacho.requestFocus();
    }
    
    
    
    private void Emite_Guia(){
            
        ExeSql Sql = new ExeSql();        
        
        try {
              
            Sql.ExeSql("update ctactecli set estado = 1 where tipdocto='" + StTipoGDC + "' and nrodocto=" + lbNroDocto.getText().trim()+" and rut = "+txRut.getText()+"");
            Sql.Commit();
            
            GeneraDTE_GDC(txRut.getText().trim(),"GDC" ,lbNroDocto.getText().trim());
            
            
            JOptionPane.showMessageDialog(null,"Documento Emitido");
            btEmitir.setEnabled(false);
            txEstado.setText("Emitida");
            btEditar.setEnabled(false);
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
      
    }
       
    private void Emite_Transporte(){
    
        ExeSql Sql = new ExeSql();        
        try {
            
            Sql.ExeSql("update ctactecli set estado=1 where tipdocto='" + StTipoFAT + "' and nrodocto=" + lbNroDocto.getText().trim()+" and rut = "+txRut.getText()+"");
            Sql.Commit();
            JOptionPane.showMessageDialog(null,"Documento Emitido Correctamente ");
            btEmiteTrans.setEnabled(false);
            bt_MermaStock.setEnabled(false);
            txEstado.setText("Emitida");
            btEditar.setEnabled(false);
            btEmiteTrans.setEnabled(false);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
      
    }
    
    
    private void GeneraDTE_GDC(String ParRut,String ParTipo, String ParNumero){
    
        File factura = null;
        
       // boolean Resultado=true;
        String Rut = ParRut;
        String Tipo = ParTipo;
        String Numero = ParNumero;
        String TipoNro = "";
        
        String ElRut = "";
        String ElNombre = "";
        String ElGiro = "";
        String LaDireccion = "";
        String LaComuna = "";
        String LaCiudad = "";
        
        String LaComunaDespacho = "";
        String LaDireccionDespacho = "";
        
        String Fecha = "";
        
        String ElAfecto = "";
        String ElIva = "";
        String ElTotal = "";
        
        String FolioRef = "";
        String FechaOCC = "";
                        
        ExeSql Sql = new ExeSql();
        ExeSql Sql2 = new ExeSql();
        ExeSql Sql3 = new ExeSql();
       
        ExeSql SqlLuv = new ExeSql();
        
        ResultSet Rs, Rs2, Rs3, RsLuv = null;
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
         Document doc= new Document();  
        
        try {
            
            File directorio = new File("C:\\temp_luvaly\\");  

            if (!directorio.exists()){

                directorio.mkdir();

            }
            
            
            File directorio2 = new File("C:\\doc_luvaly\\");  

            if (!directorio2.exists()){

                directorio2.mkdir();

            }
            
            
            Rs = Sql.Select("select * from ctactecli where tipdocto='" + Tipo +"' and nrodocto=" + Numero);
            Rs.next();
        
            switch (Tipo){
                case "GDC": TipoNro="52"; break;
                case "FAC": TipoNro="33"; break;
                case "NCC": TipoNro="61"; break;
                case "NDC": TipoNro="56"; break;
                case "FEC": TipoNro="34"; break;
                case "BOC": TipoNro="39"; break;
            }
            
            Fecha = sdf.format(Rs.getDate("femision"));
            
            Namespace ns= Namespace.getNamespace("http://www.sii.cl/SiiDte");
            
            //Document doc= new Document();    
            
                Element root=new Element("DTE").setAttribute("version", "1.0");
                root.setNamespace(ns);
                
                    Element documento=new Element("Documento").setAttribute("ID","F"+lbNroDocto.getText().trim()+"T"+TipoNro);
                    documento.setNamespace(ns);
        
                        Element encabezado=new Element("Encabezado"); 
                        encabezado.setNamespace(ns);
        
                            Element Iddoc=new Element("IdDoc").setNamespace(ns); 
                                            
                                Iddoc.addContent(new Element("TipoDTE").addContent(TipoNro).setNamespace(ns));
                                Iddoc.addContent(new Element("Folio").addContent(lbNroDocto.getText().trim()).setNamespace(ns));
                                Iddoc.addContent(new Element("FchEmis").addContent(Fecha).setNamespace(ns));
                               // Iddoc.addContent(new Element("TipoDespacho").addContent("1").setNamespace(ns));
                                Iddoc.addContent(new Element("IndTraslado").addContent("1").setNamespace(ns));
                                
                                
                            
                            Element Emisor=new Element("Emisor").setNamespace(ns); 
                                            
                                Emisor.addContent(new Element("RUTEmisor").addContent("76231391-K").setNamespace(ns));
                                Emisor.addContent(new Element("RznSoc").addContent("EMPRESA COMERCIALIZADORA LUIS VALDES LYON S.P.A.").setNamespace(ns));
                                Emisor.addContent(new Element("GiroEmis").addContent("COMERCIALIZADORA DE ARTICULOS DE FERRETERIA").setNamespace(ns));
                                Emisor.addContent(new Element("Telefono").addContent("+56(45)2658390").setNamespace(ns));
                                Emisor.addContent(new Element("CorreoEmisor").addContent("contacto@luvaly.cl").setNamespace(ns));
                                Emisor.addContent(new Element("Acteco").addContent("464909").setNamespace(ns));
                                Emisor.addContent(new Element("Acteco").addContent("466302").setNamespace(ns));
                                Emisor.addContent(new Element("DirOrigen").addContent("AVENIDA HUERFANOS 01871").setNamespace(ns));
                                Emisor.addContent(new Element("CmnaOrigen").addContent("TEMUCO").setNamespace(ns));
                                Emisor.addContent(new Element("CiudadOrigen").addContent("TEMUCO").setNamespace(ns));
                                
                        //**************************************************************** DATOS CLIENTE ******************************************************************//        
                                
                                String Query = "select d.rut || '-' || co.dv as rut, co.nombre,c.giro,c.direccion,c.ciudad,c.comuna, d.comuna_despacho, d.direccion_despacho \n"+
                                               "from ctactecli d \n"+
                                               "left join cliente co on co.rut=d.rut \n"+
                                               "left join clicontacto c on d.rut=c.rut and d.codigo_oc = c.codigo_oc\n"+
                                               "where d.rut=" + Rut + "\n"+
                                               "and d.tipdocto='" + Tipo + "'\n"+
                                               "and d.nrodocto=" + Numero;
                                //System.out.println(Query);
                                Rs2 = Sql2.Select(Query);
                                Rs2.next();

                                ElRut = Rs2.getString("rut").trim();
                                
                                //ElNombre = Rs2.getString("Nombre").trim().replaceAll("\\&", "&amp;");
                                ElNombre = Rs2.getString("Nombre").trim();
                                
                                
                                if(Rs2.getString("giro").trim().length()>40){
                                    
                                     ElGiro = Rs2.getString("giro").substring(0, 40).trim();
                                    
                                }else{
                                    
                                    ElGiro = Rs2.getString("giro").trim();
                                
                                }    
                                
                                LaDireccion = Rs2.getString("direccion").trim();
                                LaComuna= Rs2.getString("comuna").trim();
                                LaCiudad = Rs2.getString("ciudad").trim();
                             
                                LaComunaDespacho = Rs.getString("comuna_despacho").trim();
                                LaDireccionDespacho = Rs.getString("direccion_despacho").trim();
            
                                
                        //********************************************************************************************************************************************************//    
                            Element Receptor=new Element("Receptor").setNamespace(ns); 
                                            
                                Receptor.addContent(new Element("RUTRecep").addContent(ElRut).setNamespace(ns));
                                Receptor.addContent(new Element("RznSocRecep").addContent(ElNombre).setNamespace(ns));
                                Receptor.addContent(new Element("GiroRecep").addContent(ElGiro).setNamespace(ns));    
                                Receptor.addContent(new Element("DirRecep").addContent(LaDireccion).setNamespace(ns));    
                                Receptor.addContent(new Element("CmnaRecep").addContent(LaComuna).setNamespace(ns));    
                                Receptor.addContent(new Element("CiudadRecep").addContent(LaCiudad).setNamespace(ns));    
                                
                        //**************************************************************** TOTALES DOCUMENTO ******************************************************************//   
                                
                          ElAfecto = Rs.getString("totalafecto");
                          ElIva = Rs.getString("totaliva");
                          ElTotal = Rs.getString("totaldocto");
                                
                                
                                
                            Element Totales=new Element("Totales").setNamespace(ns); 
                                            
                                Totales.addContent(new Element("MntNeto").addContent(ElAfecto).setNamespace(ns));
                                Totales.addContent(new Element("TasaIVA").addContent("19").setNamespace(ns));
                                Totales.addContent(new Element("IVA").addContent(ElIva).setNamespace(ns));
                                Totales.addContent(new Element("MntTotal").addContent(ElTotal).setNamespace(ns));
                        
                       
                                    
                        encabezado.addContent(Iddoc);
                        encabezado.addContent(Emisor);
                        encabezado.addContent(Receptor);
                        encabezado.addContent(Totales);
                
                    documento.addContent(encabezado);    
             
                    //********************************************************************************************************************************************************//             
                    
                     //************************************************* VERIFICA DIFERENCIA EN LOS SUBTOTALES Y NETO  **************************************************************************************//             
                    
                    Verifica_Netos(Tipo, Rut, Numero,ElAfecto );
                    
                    int difpaso = 0;
                    int unidesc = 0;
                    
                    
                    System.out.println("productos ES  :"+productos);
                    System.out.println("dif ES  :"+dif);
                    
                    difpaso = dif;
                    
                    
                    
                    if (productos >= dif){
                    
                        unidesc = 1;
                    
                    
                    }
                    
                    
                    if(dif < 0){
                        
                       dif = dif * -1;
                    }
                    
                    
                    
                    
                    //**************************************************************** DETALLE PRODUCTOS ******************************************************************//   
                    
                    
                     String LaLinea = "";
                    
                    
                    
                    Rs3 = Sql3.Select("select d.sku,d.cantidad,d.valorunitario,d.totallinea\n" +
                                      "from ctacteclidet d\n" +
                                      "where d.tipdocto='"+ Tipo +"'\n" +
                                      "and d.rut="+ Rut +"\n" +
                                      "and d.nrodocto=" + Numero);
                    int linea = 1;
                    
                    while(Rs3.next()){ //Una iteración por producto
                    
                        RsLuv = SqlLuv.Select("SELECT p.nombre, u.um FROM producto p \n"+
                                              "LEFT JOIN par_unidad u ON u.codigo=p.unidad\n "+
                                              "WHERE p.sku = '"+Rs3.getString("sku").trim()+"'");
                        RsLuv.next();
               
                        
                        String ElSku = Rs3.getString("sku");
                        String ElProd = RsLuv.getString("nombre").trim();
                        String LaCantidad = fmMain.FormatoNumero3(Rs3.getDouble("cantidad"));
                        String LaUnidad = RsLuv.getString("um");
                        String ElUnitario = fmMain.FormatoNumero4(Rs3.getDouble("valorunitario"));
                        System.out.println("ElUnitario ES  :"+ElUnitario);
                        
                        if (linea > dif){
                        
                           unidesc = 0;
                            
                        }
                        
                        
                        if (difpaso > 0){
                        
                                //LaLinea = fmMain.FormatoTotal3(Rs3.getDouble("totallinea"));
                                   
                              LaLinea = String.valueOf(Math.round(Rs3.getDouble("cantidad")*Rs3.getDouble("valorunitario"))-unidesc);       
                                   
                        }else if (difpaso < 0) {
                        
                            LaLinea = String.valueOf(Math.round(Rs3.getDouble("cantidad")*Rs3.getDouble("valorunitario"))+unidesc);
                                                
                        }else if (difpaso == 0){
                        
                            LaLinea = String.valueOf(Math.round(Rs3.getDouble("cantidad")*Rs3.getDouble("valorunitario")));
                        }           
                       
                        
                        Element Detalle=new Element("Detalle").setNamespace(ns);
                        
                           
                            String nLinea = String.valueOf(linea);    
                            
                            Detalle.addContent(new Element("NroLinDet").addContent(nLinea).setNamespace(ns));
                            
                            
                            Element CdgItem=new Element("CdgItem").setNamespace(ns);  //Tipo Codificacion para los items
                                
                                CdgItem.addContent(new Element("TpoCodigo").addContent("INT1").setNamespace(ns));
                                CdgItem.addContent(new Element("VlrCodigo").addContent(ElSku).setNamespace(ns));
                            
                            Detalle.addContent(CdgItem);       
                            
                            
                            Detalle.addContent(new Element("NmbItem").addContent(ElProd).setNamespace(ns));
                            Detalle.addContent(new Element("QtyItem").addContent(LaCantidad).setNamespace(ns));
                            Detalle.addContent(new Element("UnmdItem").addContent(LaUnidad).setNamespace(ns));
                            Detalle.addContent(new Element("PrcItem").addContent(ElUnitario).setNamespace(ns));
                            Detalle.addContent(new Element("MontoItem").addContent(LaLinea).setNamespace(ns));
                            
                            linea++;
                            
                        documento.addContent(Detalle); 
                    }
                    
                    
                  //******************************************* SE AGREGAN DIRECCION Y COMUNA DE DESPACHO COMO OBSERVACION *************//  
                    
                    Element DetalleObs=new Element("Detalle").setNamespace(ns);
                    
                    String nLineaObs = String.valueOf(linea);
                    
                    DetalleObs.addContent(new Element("NroLinDet").addContent(nLineaObs).setNamespace(ns));
                    DetalleObs.addContent(new Element("NmbItem").addContent("Observación:").setNamespace(ns));
                    
                    if(!txContacto.getText().trim().isEmpty()){
                    
                        DetalleObs.addContent(new Element("DscItem").addContent("Entregar en "+LaDireccionDespacho+" | Comuna Dest.  : "+LaComunaDespacho+
                                                          " | Contacto : "+txContacto.getText().trim() + " - Fono Contacto : "+txFono.getText().trim()).setNamespace(ns));
                    
                    }else { 
                    
                        DetalleObs.addContent(new Element("DscItem").addContent("Entregar en "+LaDireccionDespacho+" | Comuna Dest.  : "+LaComunaDespacho).setNamespace(ns));
                    
                    }
                    
                    
                    
                    DetalleObs.addContent(new Element("MontoItem").addContent("0").setNamespace(ns));
                    
                    documento.addContent(DetalleObs); 
                    
                    //*************************************** AGREGAR REFERENCIA DOCUMENTOS INTERNOS *************************************************//
                   
                    
                    //********************************* Se Agrega Orden de Compra Interna ************************************//           
                          
                    ExeSql Sql4 = new ExeSql();
        
                    ResultSet Rs4 = null;
                    
                    
                    Rs4 = Sql4.Select("select o.rut as rutocc, o.codigo_oc, o.orden, o.femision from ctactecli c\n" +
                                      "left join occh o on c.rut = o.rut and c.codigo_oc = o.codigo_oc and c.occh = o.orden\n" +
                                      //"where c.tipdocto IN ('GDC') and c.tipdocrel is null\n" +
                                      "where c.tipdocto IN ('GDC') \n" +
                                      "and c.nrodocto =" + Numero);
        
                    Rs4.next();
                    
                    
                    FolioRef = cbCodigoOc.getSelectedItem().toString().trim()+"-"+cbNroOrden.getSelectedItem().toString().trim();
                    FechaOCC = sdf.format(Rs4.getDate("femision"));
                                                
                    Element Referencia=new Element("Referencia").setNamespace(ns); 
                            
                            
                    Referencia.addContent(new Element("NroLinRef").addContent("1").setNamespace(ns));
                    Referencia.addContent(new Element("TpoDocRef").addContent("801").setNamespace(ns));
                    Referencia.addContent(new Element("FolioRef").addContent(FolioRef).setNamespace(ns));
                    Referencia.addContent(new Element("FchRef").addContent(FechaOCC).setNamespace(ns));
                            
                    documento.addContent(Referencia);        
                   
                    
                //************************************************************************************************************************************//    
                    
                 
                    
           root.addContent(documento);
        doc.setRootElement(root);

       
        //Se genera el archivo XML 
//        XMLOutputter outter=new XMLOutputter();  //se crea un archivo tipo XMLOutputter
//        outter.setFormat(Format.getPrettyFormat());   //Devielve el formto del XMLOutputter
//        factura = new File("C:/temp_luvaly/miguia.xml");
//        outter.output(doc, new FileWriter(factura));  //Genera xml de salida
    
        }catch (SQLException ex) {
     
            Logger.getLogger(pfGDCliente.class.getName()).log(Level.SEVERE, null, ex);  
    
        }
    
    
 //       BufferedReader br;
        
                //******** Se traspasa el contenido del archivo XML a una variable de texto (String) *******//      
        
//            br = new BufferedReader(new InputStreamReader(new FileInputStream(factura), StandardCharsets.UTF_8));
//            String result = "";
//            String line = "";
//        
//            while( (line = br.readLine()) != null){
//        
//                result = result + line; 
//            }
        
        //    System.out.println(result);
    //*******************************************************************************************************//    
        XMLOutputter outter=new XMLOutputter();
        outter.setFormat(Format.getPrettyFormat());
        
        DTE dte = new DTE();
        DTESoap soap = dte.getDTESoap();
        
        
         
                                            //    usuario      clave     contenido (false = envío de pruebas / true = envío a SII)
                                            //                              XML
        
        // ArrayOfString respuesta = soap.ponerDTE("ws_econa", "5df28bdd52", result, false);   //pruebas
       // ArrayOfString respuesta = soap.ponerDTE("ws_econa", "5df28bdd52", outter.outputString(doc), false);   //pruebas
        
        //ArrayOfString respuesta = soap.ponerDTE("ws_econa", "5df28bdd52", result, true);  //produccion
       
        
        ArrayOfString respuesta = soap.ponerDTE("ws_econa", "5df28bdd52", outter.outputString(doc), true);  //produccion
        
        if (respuesta.getString().isEmpty()){   //Si la respuesta es una cadena vacía el envío fue exitoso
            
            System.out.println("Documento ha sido emitido");
            //*****************************************************************************************************************************
            int codimp = 0;
            
//              jdBuscaImpresora imp = new jdBuscaImpresora(null,true);
//              imp.setLocationRelativeTo(null);
//                imp.setTitle("Impresoras");
//              imp.setVisible(true);
//        
//              if (imp.GetElige()){
//               
//                   codimp = imp.GetCodigo();
//        
//                   Imprimir("76231391-K",ElRut,TipoNro,lbNroDocto.getText().trim(),Fecha,ElTotal, codimp,0);
//        
//              }else {
//           
//                  return;
//        
//              }
            
            
            Imprimir("76231391-K",ElRut,TipoNro,lbNroDocto.getText().trim(),Fecha,ElTotal, codimp,0);
            
            
            //*********************************************************************************************************************
            
        }else{        //De lo contrario el archivo XML presenta errores
            
            System.out.println("Error en envío : "+respuesta.getString());   //Se muestra los errores señalados
            
        }
        
    }
    
    
    
    public void Imprimir(String emisor, String receptor, String tipodte, String folio, String fecha, String total, int cimp,int imprime)  {
      
        System.out.println(emisor);
        System.out.println(receptor) ;
        System.out.println(tipodte);
        System.out.println(folio);
        System.out.println(fecha); 
        System.out.println(total);
        
        int Imprimir = imprime;
       
        try {
            PrintService[] services = PrinterJob.lookupPrintServices();
          
         //   int value = 4;
            
            int value = cimp; // El valor obtenido especifica la posicion de la impresora
            
            PrintService print = services[value];
           // System.out.println("EL VALOR DE LA IMPRESORA ES :"+services[value]);
            
            
            URL url=null;
            try {
           
                CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
    
                //URL de pruebas
                
//                url = new URL("https://www.efacturadelsur.cl/certificacion/pdf?rutEmisor="+emisor+"&rutReceptor="+receptor+"&tipoDte="+tipodte+
//                              "&folio="+folio+"&fechaEmision="+fecha+"&montoTotal="+total);
                
                
                //URL de producción

              url = new URL("https://www.efacturadelsur.cl/app/pdf?rutEmisor="+emisor+"&rutReceptor="+receptor+"&tipoDte="+tipodte+
                            "&folio="+folio+"&fechaEmision="+fecha+"&montoTotal="+total);
                try{    
                
                    InputStream in = url.openStream();
                    Files.copy(in, Paths.get("C:/doc_luvaly/GDC"+folio+".pdf"), StandardCopyOption.REPLACE_EXISTING);
                
                }catch(Exception e){

                      System.out.println("Archivo no encontrado !!");   //Se muestra los errores señalados
                      Logger.getLogger(pfGDCliente.class.getName()).log(Level.SEVERE, null, e);
                }    
                
          

            } catch (MalformedURLException e) {
                Logger.getLogger(pfGDCliente.class.getName()).log(Level.SEVERE, null, e);
            }
            
            
            File fin = new File("C:/doc_luvaly/GDC"+folio+".pdf");

            
            if (Imprimir == 1){
            
                PDDocument document = Loader.loadPDF(fin);

                PrinterJob job = PrinterJob.getPrinterJob();
                job.setPageable(new PDFPageable(document));
                job.setPrintService(print);
                job.print();
            
            }else if (Imprimir == 2){
                
                
                Desktop.getDesktop().open(fin);
                
            }
            
        
        }catch (FileNotFoundException ex) {
            
            Logger.getLogger(pfGDCliente.class.getName()).log(Level.SEVERE, null, ex);
        
        }catch (IOException | PrinterException ex) {
            
            Logger.getLogger(pfGDCliente.class.getName()).log(Level.SEVERE, null, ex);
        } 
    
    }
    
    
    private void Verifica_Netos(String Tipo, String Rut, String Numero, String ElAfecto){
    
        ExeSql Sql = new ExeSql();
        ResultSet Rs = null;
        
        
        double subtotal = 0;
        
        try {
           
            
            Rs = Sql.Select("select d.sku,d.cantidad,d.valorunitario,d.totallinea\n" +
                            "from ctacteclidet d\n" +
                            "where d.tipdocto='"+ Tipo +"'\n" +
                            "and d.rut="+ Rut +"\n" +
                            "and d.nrodocto=" + Numero);
                        
            while(Rs.next()){ 
                
                subtotal = subtotal +  Math.round(Rs.getDouble("cantidad")*Rs.getDouble("valorunitario"));
                
                productos++;
                
            }
            
            System.out.println("Total Lineas : "+subtotal);
            
            System.out.println("Total Neto : "+Integer.parseInt(ElAfecto));
            
            dif = (int)subtotal - Integer.parseInt(ElAfecto);
            
            System.out.println("Productos : "+productos);
            System.out.println("Diferencia : "+dif);
        
        } catch (SQLException ex) {
            Logger.getLogger(pfFACCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Grilla;
    private javax.swing.JButton btAbrir;
    private javax.swing.JButton btAbrir_FAT;
    private javax.swing.JToggleButton btActualizarDatos;
    private javax.swing.JButton btAgregar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btCiudad;
    private javax.swing.JButton btComuna;
    private javax.swing.JButton btContacto;
    private javax.swing.JButton btCorrigePeso;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btEmiteMan;
    private javax.swing.JButton btEmiteTrans;
    private javax.swing.JButton btEmitir;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btIr;
    private javax.swing.JButton btLiberar;
    private javax.swing.JButton btNuevo;
    private javax.swing.JButton btPDF;
    private javax.swing.JButton bt_MermaStock;
    private javax.swing.JComboBox cbCodigoOc;
    private javax.swing.JComboBox cbNroOrden;
    private javax.swing.JComboBox cbTipoDespacho;
    private javax.swing.JCheckBox chk_Anticipado;
    private org.jdesktop.swingx.JXDatePicker dtEmision;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private javax.swing.JLabel lbBloqueo;
    private javax.swing.JLabel lbNroDocto;
    private javax.swing.JLabel lbObs;
    private javax.swing.JLabel lbTransporte;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JTextField txCiudad;
    private javax.swing.JComboBox<String> txCiudadDespacho;
    private javax.swing.JTextField txComuna;
    private javax.swing.JComboBox<String> txComunaDespacho;
    private javax.swing.JTextField txContacto;
    private javax.swing.JTextField txDirDespacho;
    private javax.swing.JTextField txDireccion;
    private javax.swing.JTextField txDv;
    private javax.swing.JTextField txEstado;
    private javax.swing.JTextField txExento;
    private javax.swing.JTextField txFono;
    private javax.swing.JTextField txGiro;
    private javax.swing.JTextField txImpEspecifico;
    private javax.swing.JTextField txIva;
    private javax.swing.JTextField txNeto;
    private javax.swing.JTextField txNombre;
    private javax.swing.JTextArea txObservaciones;
    private javax.swing.JTextField txRut;
    private javax.swing.JTextField txTotal;
    private javax.swing.JTextField txTotalGDC;
    private javax.swing.JTextField txTotalOCC;
    private javax.swing.JTextField txidContacto;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtComuna;
    // End of variables declaration//GEN-END:variables
}
