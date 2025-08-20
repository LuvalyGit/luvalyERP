package PanelForm;

import Conexion.ExeSql;
import Dialogos.*;
import Dialogos.jdBuscarCliPrv;
import Formularios.fmMain;
import static Utilidades.Ftp.busca;
import Utilidades.GeneraDTE;
import Utilidades.GeneraDTE_FTP;
import Utilidades.LogError;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class pfNCCCliente_Autoriza extends javax.swing.JPanel {
    String RutMaster;
    int Tipo; // 0::Nuevo    1:Abrir
    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
    private enum Columnas{Sku,Nombre,UM,Cantidad,Unitario,Total};
    private String Codigo_OC;
    private String NroOrden;
    private int ElTipo,PosTipoDoc;
    private String ElMotivo;
    private double vTotalAfecto;
    private double vTotalExento;
    private double vTotalIva;
    private double vTotalDocto;
    
    
    
    

    public pfNCCCliente_Autoriza() {
        initComponents();
        SetTipo(-1);
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        Grilla.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        Grilla.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        Grilla.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
        lbMotivo.setEnabled(false);
        txMotivo.setEnabled(false);
        btEmitir.setVisible(false);
        bt_emite_1.setVisible(false);
                
        
        if (fmMain.GetUsuarioAdministrador())
        {
            bt_emite_1.setVisible(true);
        }
        
        
//        cbCodigoOc.setSelectedIndex(-1);
//        cbNroOrden.setSelectedIndex(-1);
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
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        lbFolio = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txEstado = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dtEmision = new org.jdesktop.swingx.JXDatePicker();
        btPDF = new javax.swing.JButton();
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
        txDireccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txComuna = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txCiudad = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        cbTipoDocumento = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txNroDocumento = new javax.swing.JTextField();
        btCargaDocumento = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox();
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
        jPanel2 = new javax.swing.JPanel();
        lbMotivo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txMotivo = new javax.swing.JTextArea();
        bt_emite_1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tx_observacion = new javax.swing.JTextArea();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        pnMenu.setBackground(new java.awt.Color(220, 215, 226));

        btNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/add16.png"))); // NOI18N
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
        btEmitir.setText("Emitir");
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

        jXLabel1.setText("NOTA DE CRÉDITO CLIENTE");
        jXLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout pnMenuLayout = new javax.swing.GroupLayout(pnMenu);
        pnMenu.setLayout(pnMenuLayout);
        pnMenuLayout.setHorizontalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(177, 177, 177)
                .addComponent(btGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAbrir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
                .addComponent(btEmitir)
                .addGap(19, 19, 19))
        );
        pnMenuLayout.setVerticalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(btNuevo)
                            .addComponent(btEditar)
                            .addComponent(btAbrir))
                        .addComponent(btEmitir)
                        .addGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btCancelar)
                            .addComponent(btGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(7, 7, 7))
        );

        add(pnMenu);

        jPanel1.setBackground(new java.awt.Color(220, 215, 226));

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("NOTA DE CREDITO");

        lbFolio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbFolio.setForeground(new java.awt.Color(255, 51, 51));

        jLabel5.setText("F. Emisión");

        txEstado.setEditable(false);

        jLabel6.setText("Estado");

        btPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/pdf.png"))); // NOI18N
        btPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbFolio)
                .addGap(155, 155, 155))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dtEmision, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(txEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(lbFolio))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(dtEmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8))
        );

        Grilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "UM", "Cantidad", "V. Unitario", "Total Linea"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

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

        jLabel2.setText("Nombre");

        txNombre.setEnabled(false);

        jLabel9.setText("Dirección");

        txDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txDireccionActionPerformed(evt);
            }
        });

        jLabel7.setText("Comuna");

        jLabel8.setText("Ciudad");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txRut, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txDv, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btIr, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                    .addComponent(txDireccion)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(txComuna)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(txRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btIr)
                        .addComponent(txDv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txComuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        cbTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "FAC - Factura", "FEC - Factura Exenta" }));
        cbTipoDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoDocumentoActionPerformed(evt);
            }
        });

        jLabel3.setText("Tipo");

        jLabel4.setText("Numero");

        txNroDocumento.setEnabled(false);
        txNroDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txNroDocumentoKeyPressed(evt);
            }
        });

        btCargaDocumento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos22/Go.png"))); // NOI18N
        btCargaDocumento.setBorderPainted(false);
        btCargaDocumento.setEnabled(false);
        btCargaDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCargaDocumentoActionPerformed(evt);
            }
        });

        jLabel16.setText("Tipo");

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Anula", "Corrige Texto", "Corrige Monto" }));
        cbTipo.setEnabled(false);
        cbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txNroDocumento)
                    .addComponent(cbTipoDocumento, 0, 164, Short.MAX_VALUE)
                    .addComponent(cbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCargaDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txNroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btCargaDocumento))
                .addGap(8, 8, 8))
        );

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
        txIva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txIvaActionPerformed(evt);
            }
        });

        jLabel12.setText("I.V.A.");

        txTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txTotal.setText("0");

        jLabel13.setText("TOTAL");

        jLabel17.setText("Imp. específico");

        txImpEspecifico.setEditable(false);
        txImpEspecifico.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txImpEspecifico.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txExento, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(txNeto)
                    .addComponent(txIva)
                    .addComponent(txTotal)
                    .addComponent(txImpEspecifico))
                .addContainerGap())
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
                    .addComponent(jLabel17)
                    .addComponent(txImpEspecifico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbMotivo.setText("Motivo");

        txMotivo.setColumns(20);
        txMotivo.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        txMotivo.setRows(2);
        txMotivo.setEnabled(false);
        txMotivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txMotivoKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txMotivo);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lbMotivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbMotivo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                .addContainerGap())
        );

        bt_emite_1.setText("Solo Emite");
        bt_emite_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_emite_1ActionPerformed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Observación"));

        tx_observacion.setColumns(20);
        tx_observacion.setRows(5);
        jScrollPane3.setViewportView(tx_observacion);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(bt_emite_1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(bt_emite_1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btEliminar)
                        .addComponent(btAgregar))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
//          txRut.setEnabled(true);
//          txRut.setEditable(true);
          btIr.setEnabled(true);
          txRut.requestFocus();
          btCancelar.setEnabled(false);
          btGuardar.setEnabled(false);
          btNuevo.setEnabled(true);
          btEditar.setEnabled(false);
          Tipo=-1;
          
        }
        // NUEVA ORDEN
        else if(ElTipo==1){
          fmMain.SetEstado(fmMain.pnPestanas.getSelectedIndex(),1);
          btGuardar.setEnabled(true);
          btCancelar.setEnabled(true);
          btEditar.setEnabled(false);
          btNuevo.setEnabled(false);
          txEstado.setText("Sin Emitir");

          Habilita(true);
          Edicion(true);
          Limpia();
          txRut.requestFocus();
          Tipo=1;
        }
        else if(ElTipo==2){
          fmMain.SetEstado(fmMain.pnPestanas.getSelectedIndex(),0);
          btEditar.setEnabled(true);
          btNuevo.setEnabled(true);
          btGuardar.setEnabled(false);
          btCancelar.setEnabled(false);
          Habilita(true);
          Edicion(false);
          txRut.setEditable(true);
          Tipo=2;
        }
        else if(ElTipo==3){
            btEmitir.setEnabled(false);
            btGuardar.setEnabled(true);
            btCancelar.setEnabled(true);
            btEditar.setEnabled(false);
            btNuevo.setEnabled(false);
            Habilita(true);
            Edicion(true);
            Tipo=3;
        }
    }
//--------------------------------------------------------------------------------
// EDICION
//--------------------------------------------------------------------------------
private void Edicion(boolean Estado){
    
//    txNroOc.setEditable(Estado);
    txDireccion.setEditable(Estado);
    txCiudad.setEditable(Estado);
    txComuna.setEditable(Estado);
    txRut.setEditable(Estado);
    txNombre.setEditable(Estado);
    txDv.setEditable(Estado);
    txNroDocumento.setEditable(Estado);
    txNeto.setEditable(Estado);
    txExento.setEditable(Estado);
    txIva.setEditable(Estado);
    txTotal.setEditable(Estado);
    btAgregar.setEnabled(Estado);
    btEliminar.setEnabled(Estado);
    btCargaDocumento.setEnabled(Estado);
    txNroDocumento.setEditable(Estado);
    

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
    txDireccion.setText("");
    txComuna.setText("");
    txCiudad.setText("");
    txMotivo.setText("");
    txNroDocumento.setText("");
    dtEmision.setDate(null);
    txEstado.setText("");

//    cbTipo.setSelectedIndex(-1);
    cbTipoDocumento.setSelectedIndex(-1);
    lbFolio.setText("");
    
    while(dfTm.getRowCount()>0)
        dfTm.removeRow(0);
    
    txMotivo.setText("");
    //chbPrioridad.
    
}    
//--------------------------------------------------------------------------------
// HABILITA
//--------------------------------------------------------------------------------
private void Habilita(boolean Estado){
    
    cbTipoDocumento.setEnabled(Estado);
    cbTipo.setEnabled(Estado);
    txDireccion.setEnabled(Estado);
    txCiudad.setEnabled(Estado);
    txComuna.setEnabled(Estado);
    btAgregar.setEnabled(Estado);
    btEliminar.setEnabled(Estado);
    txRut.setEnabled(Estado);
    txNombre.setEnabled(Estado);
    txDv.setEnabled(Estado);
  
    dtEmision.setEnabled(Estado);
    txNeto.setEnabled(Estado);
    txExento.setEnabled(Estado);
    txIva.setEnabled(Estado);
    txTotal.setEnabled(Estado);
    btIr.setEnabled(Estado);
    txEstado.setEnabled(Estado);
    btCargaDocumento.setEnabled(Estado);
    txNroDocumento.setEnabled(Estado);
    txImpEspecifico.setEnabled(Estado);
    txMotivo.setEnabled(Estado);
    
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
        }
        
        else if(fmMain.OkCancel("¿Seguro de cancelar?")==JOptionPane.OK_OPTION){
            Limpia();
            Habilita(false);
            btGuardar.setEnabled(false);
            btCancelar.setEnabled(false);
            btNuevo.setEnabled(true);
            btEditar.setEnabled(false);
            btAbrir.setEnabled(true);
            
        }
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNuevoActionPerformed
        Tipo=1;
        Limpia();
        Habilita(false);
        Edicion(false);
        txRut.setEnabled(true);
        txRut.setEditable(true);
        btIr.setEnabled(true);
        btAbrir.setEnabled(false);
        btGuardar.setEnabled(true);
        btCancelar.setEnabled(true);
        txRut.requestFocus();
    }//GEN-LAST:event_btNuevoActionPerformed

    private void txRutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRutKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btIr.doClick();
        }
    }//GEN-LAST:event_txRutKeyPressed
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
        Rs.next();
        txRut.setText(Rs.getString("Rut"));
        txDv.setText(Rs.getString("dv"));
        txNombre.setText(Rs.getString("nombre").trim());
        dtEmision.setDate(new Date());
        RutMaster=Rs.getString("Rut");
        return true;
    } catch (Exception e) {
    }
        return false;
    }    
    //------------------------------------------------------------------------------
// Carga Codigos OC
//------------------------------------------------------------------------------
    private void CargaCodOc(String Rut){
        ExeSql  Sql = new ExeSql();
        ResultSet Rs;
        DefaultComboBoxModel cbMd = new DefaultComboBoxModel();


        try {
            Rs = Sql.Select("select distinct(codigo_oc) as codigo_oc from clicontacto where rut = " + Rut);
            while(Rs.next()){
            cbMd.addElement(Rs.getString("codigo_oc")); 
            }
        } catch (Exception e) {


        } finally{
            Sql.Close();
        }

    }
    private void txDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txDireccionActionPerformed

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

        jdOCCAgregaProducto AgregaProducto = new jdOCCAgregaProducto(null,true);
        AgregaProducto.setLocationRelativeTo(null);
        AgregaProducto.setTitle("Agregar Producto");
        AgregaProducto.setVisible(true);
        tbModel.addRow(AgregaProducto.GetFilaNCC());
        Sumador();

    }//GEN-LAST:event_btAgregarActionPerformed

    private void btAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbrirActionPerformed
        SetTipo(1);
        Habilita(false);
        Edicion(false);
        Limpia();
        txRut.setEnabled(true);
        txRut.setEditable(true);
        btIr .setEnabled(true);
        btCancelar.setEnabled(true);
        txRut.requestFocus();
        cbTipoDocumento.setSelectedIndex(-1);
        Tipo=2;
        
        
    }//GEN-LAST:event_btAbrirActionPerformed
    public void AbrirNCC(String Rut,String Numero){
        ResultSet Rs;
        ExeSql Sql = new ExeSql();
        DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
        
        
        try{
            while(TableModel.getRowCount()>0)
                  TableModel.removeRow(0);

            Tipo=0;
            Rs = Sql.Select("select c.rut,c.nrodocto,c.tipdocorigen,c.nrodocorigen,c.estado as estadoint, c.femision,c.codigo_oc,c.occh,c.totalexento,c.totalafecto,c.totaliva,totalimpespecifico,c.totaldocto, cc.giro,cc.direccion,cc.ciudad,cc.comuna,cc.region,c.estado,c.tipo as tipoem " +
                            "from ctactecli_ncc c left join clicontacto cc " +
                            "on c.rut=cc.rut and c.codigo_oc=cc.codigo_oc " +
                            "WHERE c.rut=" + Rut + " " +
                            "AND c.tipdocto='NCC' " +
                            "AND c.nrodocto=" + Numero);
            Rs.next();
            
            lbFolio.setText(Numero);
            dtEmision.setDate(Rs.getDate("femision"));
            txDireccion.setText(Rs.getString("direccion").trim());
            txCiudad.setText(Rs.getString("ciudad").trim());
            txComuna.setText(Rs.getString("comuna").trim());
            txNroDocumento.setText(Rs.getString("nrodocorigen").trim());
            Codigo_OC = Rs.getString("codigo_oc").trim();
            NroOrden = Rs.getString("occh").trim();
            
            cbTipoDocumento.setSelectedIndex(0);
            while(!cbTipoDocumento.getSelectedItem().toString().substring(0,3).equals(Rs.getString("tipdocorigen")) && cbTipoDocumento.getSelectedIndex()<2){
                cbTipoDocumento.setSelectedIndex(cbTipoDocumento.getSelectedIndex()+1);
            }
            PosTipoDoc = cbTipoDocumento.getSelectedIndex();
            ElTipo=Rs.getInt("tipoem")-1;
            cbTipo.setSelectedIndex(ElTipo);
            
            if(Rs.getInt("estadoint")==0){ 
                btEmitir.setEnabled(true);
                btPDF.setVisible(false);
            }
            else{
                btEmitir.setEnabled(false);
                btEditar.setEnabled(false);
                btPDF.setVisible(true);
            }
            
            txNeto.setText(fmMain.FormatoTotal(Rs.getDouble("totalafecto")));
            txExento.setText(fmMain.FormatoTotal(Rs.getDouble("totalexento")));
            txIva.setText(fmMain.FormatoTotal(Rs.getDouble("totaliva")));
            txImpEspecifico.setText(fmMain.FormatoTotal(Rs.getDouble("totalimpespecifico")));
            txTotal.setText(fmMain.FormatoTotal(Rs.getDouble("totaldocto")));
            
            switch(Rs.getInt("estado")){
                case 0: txEstado.setText("Sin Emitir"); break;
                case 1: txEstado.setText("Emitida");break;
            }
            Tipo=2;
        } catch (Exception e) {
            System.out.println(e);
            Tipo=2;
            }

        
        try{
            //CARGA PRODUCTOS 
            CargaProductos(Rut, "NCC", Numero);
            
            //CARGA MOTIVO
            if(ElTipo==1){
                Rs = Sql.Select("select motivo from corrige_texto_cc where nrodocto=" + Numero);
                if(Sql.GetRowCount()>0){
                    Rs.next();
                    txMotivo.setText(Rs.getString("motivo").trim());
                    txMotivo.setEnabled(true);
                }
                    
            }
            
            
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
    }
    private void FindeAgno(){
        if(fmMain.GetFacNewYear()==1){
            try {
                SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
                Date Fecha=df.parse("2015/12/31");
                dtEmision.setDate(Fecha);
                dtEmision.setEditable(false);
                System.out.println("NewYear");
            } catch (Exception e) {
                System.out.println("Error New Year");
            }
            
        }
            
        
    }
    private void btIrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIrActionPerformed
                boolean Carga;
        if(!txRut.getText().isEmpty()){
            Carga=CargaCliente(txRut.getText());
                //VERIFICA NIVEL DE USUARIO PARA EDITAR FACTURA
        int pruebaUusario = 100;
        int intNivelUsuario = 0;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if( intNivelUsuario == pruebaUusario){
                btEditar.setVisible(true);
        }else{
                btEditar.setVisible(false);
        }
        }
        else{
            jdBuscarCliPrv BPC = new jdBuscarCliPrv(null, true);
            BPC.setLocationRelativeTo(null);
            BPC.setTitle("Buscar Cliente");
            BPC.SetTipo(1);
            BPC.setVisible(true);
            Carga=CargaCliente(BPC.GetRut());
        
        }
        
        // Si cargó cliente y es nuevo.
        if(Carga && Tipo==1){
            //CargaCodOc(RutMaster);
            Habilita(true);
            Edicion(true);
            btAgregar.setEnabled(false);
            btEliminar.setEnabled(false);
            Grilla.setEnabled(false);
            txNroDocumento.requestFocus();
//            btGuardar.setEnabled(true);
//            btCancelar.setEnabled(true);
//            btNuevo.setEnabled(false);
//            btEditar.setEnabled(false);
//            btAbrir.setEnabled(false);
            txEstado.setText("Sin Emitir");
            fmMain.SetEstado(fmMain.pnPestanas.getSelectedIndex(),1);
            FindeAgno();
        }
        // Si cargó cliente y esta abriendo
        if(Carga && Tipo==2){
            
            jdAbrirDocumento ADoc = new jdAbrirDocumento(null, true);
                if(ADoc.ShowModal("NCC",RutMaster)==JOptionPane.YES_OPTION){
                    Tipo=-99;
                    AbrirNCC(RutMaster, ADoc.GetNumero());
                    SetTipo(2);
                    //VERIFICA NIVEL DE USUARIO PARA EDITAR NOTA DE CREDITO
                    int pruebaUusario = 100;
                    int intNivelUsuario = 0;
                    intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
                    if( intNivelUsuario == pruebaUusario){
                        btEditar.setVisible(true);
                    }else{
                        btEditar.setVisible(false);
                    } 
                }
                else{
                    txRut.setText("");
                    txNombre.setText("");
                    txRut.requestFocus();
                }
            
        }
        
            

    }//GEN-LAST:event_btIrActionPerformed
public String getFechaAsString() {
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
return( sdf.format( (dtEmision.getDate()).getTime() ) );
}
    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
        //Valida NCC que anulan
        double NCCactual =Double.valueOf(fmMain.SetGuardar(txTotal.getText()));
        double Diferencia = NCCactual - vTotalDocto;
        ResultSet Rs;
        
        if(cbTipo.getSelectedItem().toString().equals("Anula") && Diferencia>0 ){
            fmMain.Mensaje("No se puede anular. El total de la factura no coincide con el total de la nota de crédito");
            return;
        }
        
        
        if(fmMain.OkCancel("¿Guardar Documento?")== JOptionPane.OK_OPTION){
            ExeSql  Sql = new ExeSql();
            String Query="";
            
                if (txDireccion.getText().trim().equals(""))
                {
                    fmMain.Mensaje("Datos Faltantes, comunicarse con Informática.");
                    return;
                }
                else if (txCiudad.getText().trim().equals(""))
                {
                    fmMain.Mensaje("Datos Faltantes, comunicarse con Informática.");
                    return;
                }
                
                else if (txComuna.getText().trim().equals(""))
                {
                    fmMain.Mensaje("Datos Faltantes, comunicarse con Informática.");
                    return;
                }
            
            //Graba Nueva Guia
        if(Tipo==1){
            try{
                 //Obtiene Correlativo
//                Sql.ExeSql("update par_correlativo set numero=numero + 1 where tipo='NCC'");
//                String NewCorrelativo = Sql.SelectUnico("select numero from par_correlativo where tipo='NCC'");
                
                Rs = Sql.Select("select sp_getcorrelativo \n" +
                            "from sp_getcorrelativo('NCC')");   
                Rs.next();
                String NewCorrelativo  = Rs.getString("sp_getcorrelativo");
                Rs.close();
            
                Query = " INSERT INTO ctactecli_ncc(\n" +
                        " rut, tipdocto, nrodocto, tipdocorigen, nrodocorigen, femision, \n" +
                        " totalexento, totalafecto, totaliva, totalimpespecifico,totaldocto,codigo_oc,occh,tipo,autorizado)\n" +
                        " VALUES (" +
                        txRut.getText() + "," +
                        "'NCC'," + 
                        NewCorrelativo +  "," +
                        "'"+ cbTipoDocumento.getSelectedItem().toString().substring(0,3) +"'," +
                        txNroDocumento.getText().trim() + ",'" +
                        getFechaAsString() + "'," +
                        fmMain.SetGuardar(txExento.getText().trim()) + "," +
                        fmMain.SetGuardar(txNeto.getText().trim()) + "," +
                        fmMain.SetGuardar(txIva.getText().trim()) + "," +
                        fmMain.SetGuardar(txImpEspecifico.getText().trim()) + "," +
                        fmMain.SetGuardar(txTotal.getText().trim()) + "," +
                        Codigo_OC + ",'" +
                        NroOrden + "'," + 
                        String.valueOf(cbTipo.getSelectedIndex() + 1) + ","
                        + "false)";
                Sql.ExeSql(Query);
                String text = tx_observacion.getText();
                Sql.ExeSql("insert into observacion_ncc (nrodocto,observacion,autorizada) values ("+NewCorrelativo+", '"+text+"',false)");
                Sql.Commit();
                for(int i=0; i< Grilla.getRowCount(); i++){
                    Query = " INSERT INTO ctacteclidet_ncc(\n" +
                            " rut, tipdocto, nrodocto, sku, cantidad, valorunitario, totallinea)\n" + 
                            " VALUES (" +
                             txRut.getText() +"," +
                            "'NCC'," + 
                            NewCorrelativo + ",'" +
                            Grilla.getModel().getValueAt(i,GetCol("Sku")).toString() + "'," +
                            fmMain.SetGuardar(Grilla.getModel().getValueAt(i,GetCol("Cantidad")).toString()) + "," +
                            fmMain.SetGuardar(Grilla.getModel().getValueAt(i,GetCol("Unitario")).toString()) + "," +
                            fmMain.SetGuardar(Grilla.getModel().getValueAt(i,GetCol("Total")).toString()) + ")";
                    Sql.ExeSql(Query);
                    
                }      
                //Si es Corrige Texto: GUARDA MOTIVO
                if(cbTipo.getSelectedIndex()==1){
                    Query = "insert into corrige_texto_ncc\n" +
                            "(nrodocto,motivo) values\n" +
                            "(" + NewCorrelativo+ ",'" + txMotivo.getText().trim().toUpperCase() + "')";
                    Sql.ExeSql(Query);
                }
            
            Sql.Commit();
            
            // Cambia el llamado de doclick por una funcion de emision de nota de credito
            lbFolio.setText(NewCorrelativo);
            tx_observacion.setText("");
//            emite_nota();
            JOptionPane.showMessageDialog(null,"Guardado");
            btEmitir.setEnabled(true);
            SetTipo(2);

            } catch (Exception e) {
                Sql.Rollback();
                fmMain.Mensaje(e.getMessage());
            }finally{
                Sql.Close();
            }
            
        }
        else{
            try{
                //ENCABEZADO
                Sql.ExeSql( "UPDATE ctactecli SET " +
                            "tipdocorigen='"+ cbTipoDocumento.getSelectedItem().toString().substring(0,3) +"', " +
                            "nrodocorigen=" + txNroDocumento.getText().trim() + ","+
                            "codigo_oc=" + Codigo_OC + "," +
                            "occh = '" + NroOrden + "'," +
                            "tipo=" + String.valueOf(cbTipo.getSelectedIndex() + 1) + "," +
                            "femision='"+ getFechaAsString() + "'," + 
                            "totalexento=" + fmMain.SetGuardar(txExento.getText().trim()) + "," +
                            "totalafecto=" + fmMain.SetGuardar(txNeto.getText().trim()) + "," +
                            "totaliva="    + fmMain.SetGuardar(txIva.getText().trim()) + "," +
                            "totaldocto="  + fmMain.SetGuardar(txTotal.getText().trim()) +" " +
                            "WHERE tipdocto='NCC' " + 
                            "AND   nrodocto=" + lbFolio.getText() + "\n"+
                            "AND   rut=" + txRut.getText());
                //MOTIVO
                Sql.ExeSql("delete from corrige_texto where nrodocto=" + lbFolio.getText());
                if(cbTipo.getSelectedIndex()==1){
                    Sql.ExeSql("insert into corrige_texto\n" +
                            "(nrodocto,motivo) values\n" +
                            "(" + lbFolio.getText()+ ",'" + txMotivo.getText().trim().toUpperCase() + "')");
                }
                
                
                //PRODUCTOS
                Sql.ExeSql( "DELETE FROM ctacteclidet "+
                            "WHERE tipdocto='NCC' " + 
                            "AND   nrodocto=" +  lbFolio.getText() + " " +
                            "AND   rut=" + txRut.getText());
            
                for(int i=0; i< Grilla.getRowCount(); i++){
                    Sql.ExeSql(" INSERT INTO ctacteclidet(\n" +
                            " rut, tipdocto, nrodocto, sku, cantidad, valorunitario, totallinea)\n" + 
                            " VALUES (" +
                             txRut.getText() +"," +
                            "'NCC'," + 
                            lbFolio.getText().trim() + ",'" +
                            Grilla.getModel().getValueAt(i,GetCol("Sku")).toString() + "'," +
                            fmMain.SetGuardar(Grilla.getModel().getValueAt(i,GetCol("Cantidad")).toString()) + "," +
                            fmMain.SetGuardar(Grilla.getModel().getValueAt(i,GetCol("Unitario")).toString()) + "," +
                            fmMain.SetGuardar(Grilla.getModel().getValueAt(i,GetCol("Total")).toString()) + ")");
                }
                
            Sql.Commit();
            
            
            JOptionPane.showMessageDialog(null, "Guardado");
                SetTipo(2);
           } catch (Exception e) {
                Sql.Rollback();
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }finally{
                Sql.Close();
            }
        }
    }
                
    
    }//GEN-LAST:event_btGuardarActionPerformed
//--------------------------------------------------------------------------------
// SUMADOR
//--------------------------------------------------------------------------------
private void Sumador(){    
    double Neto=0;
    double Exento=0;
    double Iva=0;
    double Total=0;
    String Valor;
    
    for(int i=0; i< Grilla.getRowCount(); i++){
        Valor = Grilla.getModel().getValueAt(i,GetCol("Total")).toString();
        Valor = Valor.replace(fmMain.GetMiles(), "");
        Neto =  Float.parseFloat(Valor) + Neto;
    }
    //Si es exenta se suma en Exento.
    if(cbTipoDocumento.getSelectedItem().toString().substring(0,3).equals("FEC")){
       Exento=Math.round(Neto);
       Neto=0;
       Iva = 0;
       Total = Exento;
    }
    else{
        Neto = Math.round(Neto);
        Iva = Math.round((Neto * Double.parseDouble("0.19")));
        Total = Neto + Iva; 
    }
    if(cbTipo.getSelectedItem().toString().equals("Anula") && Tipo!=2){
        txNeto.setText(fmMain.FormatoTotal(vTotalAfecto));
        txExento.setText(fmMain.FormatoTotal(vTotalExento));
        txIva.setText(fmMain.FormatoTotal(vTotalIva));
        txTotal.setText(fmMain.FormatoTotal(vTotalDocto));
    }
    else if(Math.abs(Total-vTotalDocto)<2){
        txNeto.setText(fmMain.FormatoTotal(vTotalAfecto));
        txExento.setText(fmMain.FormatoTotal(vTotalExento));
        txIva.setText(fmMain.FormatoTotal(vTotalIva));
        txTotal.setText(fmMain.FormatoTotal(vTotalDocto));
    }
    else{
        txNeto.setText(fmMain.FormatoTotal(Neto));
        txExento.setText(fmMain.FormatoTotal(Exento));
        txIva.setText(fmMain.FormatoTotal(Iva));
        txTotal.setText(fmMain.FormatoTotal(Total));
    }
    
}
//------------------------------------------------------------------------------
//  
//------------------------------------------------------------------------------
    private void GrillaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrillaMouseClicked
        if(evt.getClickCount()==2 && !Grilla.getValueAt(Grilla.getSelectedRow(), 0).toString().isEmpty()){
            jdIngresaNumero jdNumero = new jdIngresaNumero(null, true);
            jdNumero.setLocationRelativeTo(null);
            jdNumero.setVisible(true);        
            if(jdNumero.GetNumero() != -99 ){
                try {
                    
                
                //double TotLinea = jdNumero.GetNumero() * Float.parseFloat(fmMain.SetGuardar(Grilla.getValueAt(Grilla.getSelectedRow(), GetCol("Unitario")).toString()));
                double TotLinea = jdNumero.GetNumero() * jdNumero.GetPrecio();
                
                Grilla.setValueAt(jdNumero.GetNumero(), Grilla.getSelectedRow(),GetCol("Cantidad"));
                Grilla.setValueAt(jdNumero.GetPrecio(), Grilla.getSelectedRow(),4);
                
                Grilla.setValueAt(fmMain.FormatoNumero(TotLinea),Grilla.getSelectedRow(),GetCol("Total"));
                Sumador();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        
    }//GEN-LAST:event_GrillaMouseClicked

    private void btEmitirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEmitirActionPerformed
        ExeSql Sql = new ExeSql();
        
        try {
            //GeneraDTE.Generar(txRut.getText().trim(),"NCC" ,lbFolio.getText().trim());
            GeneraDTE_FTP.Generar(txRut.getText().trim(),"NCC" ,lbFolio.getText().trim());
            Sql.ExeSql("update ctactecli set estado=1 where tipdocto='NCC' and nrodocto=" + lbFolio.getText().trim());  //Estado a Emitida
            Sql.Commit();
            JOptionPane.showMessageDialog(null,"Documento Emitido");
            btEmitir.setEnabled(false);
            txEstado.setText("Emitido");
            btEditar.setEnabled(false);
        } catch (Exception ex) {
            fmMain.Mensaje(ex.getMessage());
        } finally{
            Sql.Close();
        }      
       
    }//GEN-LAST:event_btEmitirActionPerformed
    void CargaProductos(String Rut,String TipDocto,String NroDocto){
        ExeSql  Sql = new ExeSql();
        DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
        ResultSet Rs;
        
        while(TableModel.getRowCount()>0)
            TableModel.removeRow(0);
        
        
        try {
            Rs = Sql.Select("select d.sku,p.nombre,u.um,d.cantidad,d.valorunitario,d.totallinea \n" +
                            "from ctacteclidet d\n" +
                            "left join producto p\n" +
                            "on d.sku=p.sku\n" +
                            "left join par_unidad u\n" +
                            "on p.unidad=u.codigo\n" +
                            "where d.rut=" + Rut + "\n" +
                            "and d.tipdocto='"+ TipDocto +"'\n" +
                            "and d.nrodocto=" + NroDocto);
            while(Rs.next()){
                TableModel.addRow(new Object[]{
                        Rs.getString("sku"), 
                        Rs.getString("nombre"), 
                        Rs.getString("um"),
                        fmMain.FormatoNumero(Rs.getDouble("cantidad")),
                        fmMain.FormatoNumero(Rs.getDouble("valorunitario")),
                        fmMain.FormatoNumero(Rs.getDouble("totallinea"))});
            }
            Sumador();
        } catch (Exception e) {
        } finally{
            Sql.Close();
        }
    }
    
    void CargaDocumentoOrigen(String TipDocto, String NroDocto){
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        
        txNroDocumento.setText(NroDocto);
        
        try {
            //CARGA DATOS DE CLIENTE
            Rs= Sql.Select( "select cc.direccion,cc.comuna,cc.ciudad,cc.codigo_oc, c.occh,c.totalexento,c.totalafecto,c.totaliva,c.totaldocto\n" +
                            "from ctactecli c\n" +
                            "left join clicontacto cc on c.rut=cc.rut and c.codigo_oc=cc.codigo_oc \n" +
                            "where c.tipdocto='"+ TipDocto +"'\n" +
                            "and nrodocto=" + NroDocto);
            if(Sql.GetRowCount()==0){
                JOptionPane.showMessageDialog(null, "Documento no encontrado");
                return;
            }
            
            Rs.next();
            
            txDireccion.setText(Rs.getString("direccion").trim());
            txComuna.setText(Rs.getString("Comuna").trim());
            txCiudad.setText(Rs.getString("Ciudad").trim());
            Codigo_OC = Rs.getString("codigo_oc").trim();
            NroOrden  = Rs.getString("occh").trim();
            
            vTotalDocto = Rs.getDouble("totaldocto");
            vTotalAfecto = Rs.getDouble("totalafecto");
            vTotalExento = Rs.getDouble("totalexento");
            vTotalIva = Rs.getDouble("totaliva");
            
           
            //CARGA PRODUCTOS DE DOCUMENTO DE ORIGEN
            CargaProductos(txRut.getText().trim(),TipDocto,NroDocto);
            
            
        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }
        finally {
            Sql.Close();
        }
    }
    
    private void btCargaDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCargaDocumentoActionPerformed
        
        if(txRut.getText().isEmpty()) return;
        
        if(!txNroDocumento.getText().isEmpty()){
                CargaDocumentoOrigen(cbTipoDocumento.getSelectedItem().toString().substring(0, 3), txNroDocumento.getText().trim());
        }
        else{
            jdAbrirDocumento ADoc = new jdAbrirDocumento(null, true);
            if(ADoc.ShowModal(cbTipoDocumento.getSelectedItem().toString().substring(0, 3),txRut.getText().trim())==JOptionPane.YES_OPTION){
                CargaDocumentoOrigen(cbTipoDocumento.getSelectedItem().toString().substring(0, 3), ADoc.GetNumero());
            }
        }
            
        
    }//GEN-LAST:event_btCargaDocumentoActionPerformed

    private void txNroDocumentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNroDocumentoKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            btCargaDocumento.doClick();
        }
    }//GEN-LAST:event_txNroDocumentoKeyPressed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        SetTipo(3);
    }//GEN-LAST:event_btEditarActionPerformed

    private void cbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoActionPerformed
        if(Tipo==0)
            return;
        
        if(Tipo==2){
            cbTipo.setSelectedIndex(ElTipo);
        }
        else{
            //ANULA 
            if(cbTipo.getSelectedIndex()==0 ){
                lbMotivo.setEnabled(false);
                txMotivo.setEnabled(false);
                ElMotivo = txMotivo.getText();
                txMotivo.setText("");
                Grilla.setEnabled(false);
                btAgregar.setEnabled(false);
                btEliminar.setEnabled(false);
                if(!txRut.getText().isEmpty() && !txNroDocumento.getText().isEmpty())
                    CargaProductos(txRut.getText().trim(), cbTipoDocumento.getSelectedItem().toString().substring(0, 3), txNroDocumento.getText().trim());
            }
            //CORRIGE MONTO
            else if(cbTipo.getSelectedIndex()==2){
                lbMotivo.setEnabled(false);
                txMotivo.setEnabled(false);
                ElMotivo = txMotivo.getText();
                txMotivo.setText("");
                Grilla.setEnabled(true);
                btAgregar.setEnabled(true);
                btEliminar.setEnabled(true);
                if(!txRut.getText().isEmpty() && !txNroDocumento.getText().isEmpty())
                    CargaProductos(txRut.getText().trim(), cbTipoDocumento.getSelectedItem().toString().substring(0, 3), txNroDocumento.getText().trim());
            }
            //CORRIGE TEXTO
            else{
                DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
                while(TableModel.getRowCount()>0)
                       TableModel.removeRow(0);
                Sumador();
                txMotivo.setText(ElMotivo);
                lbMotivo.setEnabled(true);
                txMotivo.setEnabled(true);
                Grilla.setEnabled(false);
                btAgregar.setEnabled(false);
                txMotivo.requestFocus();
            }
        }
    }//GEN-LAST:event_cbTipoActionPerformed

    private void cbTipoDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoDocumentoActionPerformed
        if(Tipo==2)
            cbTipoDocumento.setSelectedIndex(PosTipoDoc);
    }//GEN-LAST:event_cbTipoDocumentoActionPerformed

    private void txMotivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txMotivoKeyTyped
        if(txMotivo.getText().length() >= 500)
            evt.consume();
        else if (Character.isLowerCase(evt.getKeyChar()))
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
    }//GEN-LAST:event_txMotivoKeyTyped

    private void txIvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txIvaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txIvaActionPerformed

    private void btPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPDFActionPerformed
//        String path = "\\\\192.168.0.130\\Documentos Electronicos";
//        String files;
//        File folder = new File(path);
//        File[] listOfFiles = folder.listFiles(new FilenameFilter() {
//            @Override
//            public boolean accept(File folder, String Nombre) {
//                return Nombre.contains("61F" + lbFolio.getText().trim());
//            }
//        });
//        for (int i = 0; i < listOfFiles.length; i++)         {
//
//            if (listOfFiles[i].isFile())             {
//
//                files = listOfFiles[i].getName();
//                try {
//                    File pathCompleto = new File(path + "\\" +files);
//                        Desktop.getDesktop().open(pathCompleto);
//                    } catch (IOException ex) {
//                        ex.printStackTrace();
//                    }
//                }
//            }
           busca("33F",  lbFolio.getText().trim());
    }//GEN-LAST:event_btPDFActionPerformed

    private void bt_emite_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_emite_1ActionPerformed
        // TODO add your handling code here:
     emite_nota();
       
    }//GEN-LAST:event_bt_emite_1ActionPerformed

    private void emite_nota(){
         ExeSql Sql = new ExeSql();
        
        try {
            //GeneraDTE.Generar(txRut.getText().trim(),"NCC" ,lbFolio.getText().trim());
            GeneraDTE_FTP.Generar(txRut.getText().trim(),"NCC" ,lbFolio.getText().trim());
            Sql.ExeSql("update ctactecli set estado=1 where tipdocto='NCC' and nrodocto=" + lbFolio.getText().trim());  //Estado a Emitida
            Sql.Commit();
            JOptionPane.showMessageDialog(null,"Documento Emitido");
            btEmitir.setEnabled(false);
            txEstado.setText("Emitido");
            btEditar.setEnabled(false);
        } catch (Exception ex) {
            fmMain.Mensaje(ex.getMessage());
        } finally{
            Sql.Close();
        }      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Grilla;
    private javax.swing.JButton btAbrir;
    private javax.swing.JButton btAgregar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btCargaDocumento;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btEmitir;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btIr;
    private javax.swing.JButton btNuevo;
    private javax.swing.JButton btPDF;
    private javax.swing.JButton bt_emite_1;
    private javax.swing.JComboBox cbTipo;
    private javax.swing.JComboBox cbTipoDocumento;
    private org.jdesktop.swingx.JXDatePicker dtEmision;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private javax.swing.JLabel lbFolio;
    private javax.swing.JLabel lbMotivo;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JTextField txCiudad;
    private javax.swing.JTextField txComuna;
    private javax.swing.JTextField txDireccion;
    private javax.swing.JTextField txDv;
    private javax.swing.JTextField txEstado;
    private javax.swing.JTextField txExento;
    private javax.swing.JTextField txImpEspecifico;
    private javax.swing.JTextField txIva;
    private javax.swing.JTextArea txMotivo;
    private javax.swing.JTextField txNeto;
    private javax.swing.JTextField txNombre;
    private javax.swing.JTextField txNroDocumento;
    private javax.swing.JTextField txRut;
    private javax.swing.JTextField txTotal;
    private javax.swing.JTextArea tx_observacion;
    // End of variables declaration//GEN-END:variables
}
