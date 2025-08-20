package PanelForm;

import Conexion.ExeSql;
import Dialogos.jdAddDatosPersona;
import Dialogos.jdBuscarCliPrv;
import Dialogos.jdDiasOCP;
import Formularios.fmMain;
import Utilidades.ComboCodigos;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DavidAlcaman
 */
public class pfProveedores extends javax.swing.JPanel {

    /**
     * Creates new form pfProveedores
     */
    
    
    int Tipo=-1; //-1 Nada de nada      1 Nuevo      2 Abierto      3.Editando
    int PosBanco;
    int PosRegion;
    String Eliminados ;
    int EliminadosCont;
    
    public pfProveedores() {
        Tipo=-99;
        initComponents();
        CargaRegiones();
        CargaFormaPago();
        CargaBancos();
        Limpia();
        Edicion(false);
        Habilita(false);
        txRut.requestFocus();
        cbFormaPagoId.setVisible(false);

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMenu = new javax.swing.JPanel();
        btEditar = new javax.swing.JButton();
        btNuevo = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btGuardar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        txDv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txGiro = new javax.swing.JTextField();
        btIr = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txRut = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txDireccion = new javax.swing.JTextField();
        txComuna = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txCiudad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbRegion = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        GrillaContactos = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        btAgregarContacto = new javax.swing.JButton();
        btEliminarContacto = new javax.swing.JButton();
        btEditarContacto = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        chkCredito = new javax.swing.JCheckBox();
        txCuotas = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txDias = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txCrAsignado = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txCrUtilizado = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txCrDisponible = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txNroCuenta = new javax.swing.JTextField();
        cbBancos = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbFormaPago = new javax.swing.JComboBox();
        cbFormaPagoId = new javax.swing.JComboBox();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        pnMenu.setBackground(new java.awt.Color(220, 215, 226));

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/Pencil16.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.setEnabled(false);
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/New.png"))); // NOI18N
        btNuevo.setText("Nuevo");
        btNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNuevoActionPerformed(evt);
            }
        });

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/Cancel16.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.setEnabled(false);
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/save16.png"))); // NOI18N
        btGuardar.setText("Guardar");
        btGuardar.setBorder(null);
        btGuardar.setEnabled(false);
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(220, 215, 226));

        jXLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jXLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Provider24.png"))); // NOI18N
        jXLabel1.setText("PROVEEDOR");
        jXLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(184, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        jPanel4.setBackground(new java.awt.Color(220, 215, 226));

        jPanel8.setBackground(new java.awt.Color(220, 215, 226));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txDv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txDvFocusLost(evt);
            }
        });
        txDv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txDvKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txDvKeyReleased(evt);
            }
        });
        jPanel8.add(txDv, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 32, 30));

        jLabel2.setText("Nombre");
        jPanel8.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, 20));

        txNombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txNombre.setForeground(new java.awt.Color(0, 0, 102));
        txNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txNombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txNombreKeyTyped(evt);
            }
        });
        jPanel8.add(txNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 469, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel3.setText("Giro");
        jPanel8.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 10));

        txGiro.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txGiro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txGiroKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txGiroKeyTyped(evt);
            }
        });
        jPanel8.add(txGiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 700, 30));

        btIr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos22/Go.png"))); // NOI18N
        btIr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIrActionPerformed(evt);
            }
        });
        jPanel8.add(btIr, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 28, 30));

        jLabel1.setText("Rut");
        jPanel8.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 20));

        txRut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txRutKeyPressed(evt);
            }
        });
        jPanel8.add(txRut, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 95, 30));

        jPanel10.setBackground(new java.awt.Color(220, 215, 226));
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel4.setText("Dirección");

        txDireccion.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txDireccionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txDireccionKeyTyped(evt);
            }
        });

        txComuna.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txComuna.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txComunaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txComunaKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel5.setText("Ciudad");

        txCiudad.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txCiudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txCiudadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txCiudadKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel6.setText("Comuna");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel7.setText("Región");

        cbRegion.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cbRegion.setMaximumRowCount(11);
        cbRegion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRegionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(txCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txComuna, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txDireccion))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(txDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txComuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GrillaContactos.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        GrillaContactos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Fono", "Fono 2", "Email", "Cargo", "CargoId", "id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(GrillaContactos);
        if (GrillaContactos.getColumnModel().getColumnCount() > 0) {
            GrillaContactos.getColumnModel().getColumn(0).setMinWidth(30);
            GrillaContactos.getColumnModel().getColumn(0).setPreferredWidth(290);
            GrillaContactos.getColumnModel().getColumn(0).setMaxWidth(290);
            GrillaContactos.getColumnModel().getColumn(1).setMinWidth(75);
            GrillaContactos.getColumnModel().getColumn(1).setPreferredWidth(75);
            GrillaContactos.getColumnModel().getColumn(1).setMaxWidth(320);
            GrillaContactos.getColumnModel().getColumn(2).setMinWidth(75);
            GrillaContactos.getColumnModel().getColumn(2).setPreferredWidth(75);
            GrillaContactos.getColumnModel().getColumn(2).setMaxWidth(320);
            GrillaContactos.getColumnModel().getColumn(3).setMinWidth(150);
            GrillaContactos.getColumnModel().getColumn(3).setPreferredWidth(150);
            GrillaContactos.getColumnModel().getColumn(3).setMaxWidth(150);
            GrillaContactos.getColumnModel().getColumn(4).setMinWidth(30);
            GrillaContactos.getColumnModel().getColumn(4).setPreferredWidth(150);
            GrillaContactos.getColumnModel().getColumn(4).setMaxWidth(150);
            GrillaContactos.getColumnModel().getColumn(5).setMinWidth(0);
            GrillaContactos.getColumnModel().getColumn(5).setPreferredWidth(0);
            GrillaContactos.getColumnModel().getColumn(5).setMaxWidth(0);
            GrillaContactos.getColumnModel().getColumn(6).setMinWidth(0);
            GrillaContactos.getColumnModel().getColumn(6).setPreferredWidth(0);
            GrillaContactos.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel19.setText("Contactos");

        btAgregarContacto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/Agregar.png"))); // NOI18N
        btAgregarContacto.setToolTipText("Agregar Contacto");
        btAgregarContacto.setEnabled(false);
        btAgregarContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarContactoActionPerformed(evt);
            }
        });

        btEliminarContacto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/Eliminar.png"))); // NOI18N
        btEliminarContacto.setToolTipText("Eliminar Contacto");
        btEliminarContacto.setEnabled(false);
        btEliminarContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarContactoActionPerformed(evt);
            }
        });

        btEditarContacto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/Pencil16.png"))); // NOI18N
        btEditarContacto.setToolTipText("Editar Contacto");
        btEditarContacto.setEnabled(false);
        btEditarContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarContactoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btAgregarContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btEliminarContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btEditarContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btAgregarContacto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btEliminarContacto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btEditarContacto))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnMenuLayout = new javax.swing.GroupLayout(pnMenu);
        pnMenu.setLayout(pnMenuLayout);
        pnMenuLayout.setHorizontalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEditar)
                .addContainerGap(158, Short.MAX_VALUE))
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnMenuLayout.setVerticalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btEditar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btNuevo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btGuardar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(pnMenu);

        jTabbedPane1.setBackground(new java.awt.Color(220, 215, 226));

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Condiciones Comerciales"));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        chkCredito.setText("Crédito");
        chkCredito.setEnabled(false);
        chkCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCreditoActionPerformed(evt);
            }
        });
        jPanel11.add(chkCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 23, -1, -1));
        jPanel11.add(txCuotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 48, 51, -1));

        jLabel10.setText("Cuotas");
        jPanel11.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 51, -1, -1));

        jLabel11.setText("Días");
        jPanel11.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(374, 85, -1, -1));

        txDias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txDiasMouseClicked(evt);
            }
        });
        jPanel11.add(txDias, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 82, 167, -1));

        jLabel13.setText("Cupo $");
        jPanel11.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 51, -1, -1));
        jPanel11.add(txCrAsignado, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 48, 121, -1));

        jLabel17.setText("Utilizado");
        jPanel11.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 85, -1, -1));

        txCrUtilizado.setEditable(false);
        jPanel11.add(txCrUtilizado, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 82, 121, -1));

        jLabel18.setText("Disponible");
        jPanel11.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 116, -1, -1));

        txCrDisponible.setEditable(false);
        jPanel11.add(txCrDisponible, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 113, 121, -1));
        jPanel11.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 113, 90, -1));

        jLabel14.setText("Compra Minima $");
        jPanel11.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 116, -1, -1));

        jTabbedPane1.addTab("Crédito", jPanel11);

        jLabel8.setText("Banco");

        cbBancos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbBancos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBancosActionPerformed(evt);
            }
        });

        jLabel9.setText("N° Cuenta");

        jLabel12.setText("Forma de Pago");

        cbFormaPago.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbFormaPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFormaPagoActionPerformed(evt);
            }
        });

        cbFormaPagoId.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbBancos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txNroCuenta)
                    .addComponent(cbFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbFormaPagoId, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(302, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(cbFormaPagoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cbBancos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txNroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Forma de Pago", jPanel6);

        add(jTabbedPane1);
    }// </editor-fold>//GEN-END:initComponents

    private void Limpia(){
        DefaultTableModel dfTm = (DefaultTableModel) GrillaContactos.getModel();
        txRut.setText("");
        txNombre.setText("");
        txGiro.setText("");
        txDireccion.setText("");
        txComuna.setText("");
        txCiudad.setText("");
        txNroCuenta.setText("");
        cbRegion.setSelectedIndex(-1);
        cbBancos.setSelectedIndex(-1);
        txDv.setText("");
        txCrAsignado.setText("");
        txCrUtilizado.setText("");
        txCrDisponible.setText("");
        txCuotas.setText("");
        txDias.setText("");
        chkCredito.setSelected(false);
        
        cbBancos.setSelectedIndex(-1);
        cbRegion.setSelectedIndex(-1);
        cbRegion.setVisible(false);
        cbRegion.setVisible(true);
        while (dfTm.getRowCount() > 0) {
            dfTm.removeRow(0);
        }
    }
    private void Habilita(boolean Estado){
        //txRut.setEnabled(Estado);
        txNombre.setEnabled(Estado);
        txGiro.setEnabled(Estado);
        txDireccion.setEnabled(Estado);
        txComuna.setEnabled(Estado);
        txCiudad.setEnabled(Estado);
        txNroCuenta.setEnabled(Estado);
        txDv.setEnabled(Estado);
        cbBancos.setEnabled(Estado);
        cbRegion.setEnabled(Estado);
    }
    private void Edicion(boolean Estado){
        //txRut.setEditable(Estado);
        txNombre.setEditable(Estado);
        txGiro.setEditable(Estado);
        txDireccion.setEditable(Estado);
        txComuna.setEditable(Estado);
        txCiudad.setEditable(Estado);
        txNroCuenta.setEditable(Estado);
        txDv.setEditable(Estado);
        btAgregarContacto.setEnabled(Estado);
        btEliminarContacto.setEnabled(Estado);
        btEditarContacto.setEnabled(Estado);
        chkCredito.setEnabled(Estado);
    }
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
            txRut.setEnabled(true);
            txRut.setEditable(true);
            btIr.setEnabled(true);
            txRut.requestFocus();
            btCancelar.setEnabled(false);
            btGuardar.setEnabled(false);
            btNuevo.setEnabled(true);
            btEditar.setEnabled(false);
            cbRegion.setSelectedIndex(-1);
            jTabbedPane1.setSelectedIndex(0);
            Tipo=-1;
        }
        //Nuevo Producto
        else if(ElTipo==1){
            fmMain.SetEstado(fmMain.pnPestanas.getSelectedIndex(),1);
            
            btGuardar.setEnabled(true);
            btCancelar.setEnabled(true);
            btEditar.setEnabled(false);
            btNuevo.setEnabled(false);
            
            Habilita(true);
            Edicion(true);
            Limpia();
            txRut.requestFocus();
            Tipo=1;
        }
        //Abre Producto
        else if (ElTipo==2){
            fmMain.SetEstado(fmMain.pnPestanas.getSelectedIndex(),0);
            btEditar.setEnabled(true);
            btNuevo.setEnabled(true);
            btGuardar.setEnabled(false);
            btCancelar.setEnabled(false);
            
            Habilita(true);
            Edicion(false);
            txRut.setEditable(true);
            jTabbedPane1.setSelectedIndex(0);
            Tipo=2;
        }
        // Edita Producto 
        else if(ElTipo==3){
            fmMain.SetEstado(fmMain.pnPestanas.getSelectedIndex(),1);
            Habilita(true);
            Edicion(true);
            btGuardar.setEnabled(true);
            btCancelar.setEnabled(true);
            btNuevo.setEnabled(false);
            btEditar.setEnabled(false);
            txRut.setEditable(false);
            Tipo=3;
            
        }
    }

//------------------------------------------------------------------------------
// Funcion CODIGO desde COMBOBOX
//------------------------------------------------------------------------------
    private int cbId_Accion(JComboBox Combo ){
        int Codigo=-1;
//    if (Combo.getSelectedIndex()!=0){
        ComboCodigos id = (ComboCodigos) Combo.getSelectedItem();
        Codigo = id.getId();
        String nombre = Combo.getSelectedItem().toString();
        Combo.hidePopup();
//    } 
    return Codigo;
}
//------------------------------------------------------------------------------
// Carga BANCOS
//------------------------------------------------------------------------------
    private void CargaBancos(){
        ExeSql  Sql = new ExeSql();
        ResultSet Rs;
        DefaultComboBoxModel cbMd = new DefaultComboBoxModel();
        cbBancos.setModel(cbMd);
        

        try {
            Rs = Sql.Select("select codigo, banco\n" +
                    "from par_banco\n" +
                    "order by codigo asc ");
            while(Rs.next()){
                cbMd.addElement(new ComboCodigos(Rs.getString("banco"),Rs.getInt("codigo")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            Sql.Close();
        }

    }
//------------------------------------------------------------------------------
// Carga Regiones
//------------------------------------------------------------------------------
    private void CargaFormaPago(){
        ExeSql  Sql = new ExeSql();
        ResultSet Rs;
        DefaultComboBoxModel mdformapago    = new DefaultComboBoxModel();
        DefaultComboBoxModel mdformapagoid  = new DefaultComboBoxModel();
        cbFormaPago.setModel(mdformapago);
        cbFormaPagoId.setModel(mdformapagoid);
        
        try {
            Rs = Sql.Select("select codigo,nombre \n" +
                            "from par_general\n" +
                            "where tipo='TIPOPAGOPRV'\n" +
                            "and vigente=1 order by codigo ");
            while(Rs.next()){
                cbFormaPago.addItem(Rs.getString("nombre").trim());
                cbFormaPagoId.addItem(Rs.getString("codigo").trim());
            }
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            Sql.Close();
        }
    }
    
//------------------------------------------------------------------------------
// Carga Regiones
//------------------------------------------------------------------------------
    private void CargaRegiones(){
        ExeSql  Sql = new ExeSql();
        ResultSet Rs;
        DefaultComboBoxModel cbMd = new DefaultComboBoxModel();
        cbRegion.setModel(cbMd);

        try {
            Rs = Sql.Select("select cast(numero as varchar(2)) || ' ' || nombre as nombre, numero\n" +
                            "from par_region\n" +
                            "order by orden asc ");
            while(Rs.next()){
                cbMd.addElement(new ComboCodigos(Rs.getString("nombre"),Rs.getInt("numero")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            Sql.Close();
        }
    }
    
private void CargaContactosPrv(String Rut){
    ExeSql Sql = new ExeSql();
    ResultSet Rs;
    DefaultTableModel TModel = (DefaultTableModel) GrillaContactos.getModel();
    String Nombre="",Fono1="",Fono2="",Email="";
    
    while(TModel.getRowCount()>0)
          TModel.removeRow(0);
    
    try {
        Rs = Sql.Select("select c.nombre, c.fono1,c.fono2,c.email,p.nombre as tipo,p.codigo, c.id \n" +
                        "from prv_contacto c\n" +
                        "left join par_general p on c.tipo=p.codigo and p.tipo='TIPCONTACTOPRV'\n" +
                        "where rut=" + Rut);
        while(Rs.next()){
            if(Rs.getObject("nombre")!= null)
                Nombre=Rs.getString("nombre").trim();
            
            if(Rs.getObject("fono1")!= null)
                Fono1=Rs.getString("fono1").trim();
            
            if(Rs.getObject("fono2")!= null)
                Fono2=Rs.getString("fono2").trim();
            
            if(Rs.getObject("email")!= null)
                Email=Rs.getString("email").trim();
            
            TModel.addRow(new Object[]{
                                      Nombre,
                                      Fono1,
                                      Fono2,
                                      Email,
                                      Rs.getString("tipo").trim(),
                                      Rs.getInt("codigo"),
                                      Rs.getInt("id")
                                      });
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    } finally{
        Sql.Close();
    }
}
//------------------------------------------------------------------------------
//  CARGA PROVEEDOR
//------------------------------------------------------------------------------
public void CargaProveedor(String Rut){
    ExeSql  Sql = new ExeSql();
    ResultSet Rs;
    Eliminados="";
    EliminadosCont=0;
    Limpia();
    Tipo=-99;
    
   

        try {
            Rs = Sql.Select("select * from proveedor where rut="+Rut);
            
            Rs.next();
            txRut.setText(Rs.getString("rut").trim());
            txDv.setText(Rs.getString("dv").trim());
            txNombre.setText(Rs.getString("nombre").trim());
            txGiro.setText(Rs.getString("giro").trim());
            txDireccion.setText(Rs.getString("direccion").trim());
            txCiudad.setText(Rs.getString("ciudad").trim());
            txComuna.setText(Rs.getString("comuna").trim());
            txNroCuenta.setText(Rs.getString("nrocuenta").trim());
            
            //Region
            if(Rs.getInt("region")==0)
                cbRegion.setSelectedIndex(-1);
            else
            for(int i=0 ; i < cbRegion.getItemCount();i++){
                    cbRegion.setSelectedIndex(i);
                    cbRegion.repaint();
                    if(cbId_Accion(cbRegion)==Rs.getInt("region") ){
                        break; 
                    }
                }
            //Banco
            if(Rs.getInt("Banco")==0)
                cbBancos.setSelectedIndex(-1);
            else
                for(int i=0 ; i <= cbBancos.getItemCount();i++){
                    cbBancos.setSelectedIndex(i);
                    if(cbId_Accion(cbBancos)==Rs.getInt("Banco") ){
                        break; 
                    }
                }
            // Contactos
            CargaContactosPrv(Rs.getString("rut").trim());
            
            // Credito
            if(Rs.getBoolean("credito")){
                chkCredito.setSelected(true);
                txCrAsignado.setText(Rs.getString("creditoasignado").trim());
                try {
                    txCuotas.setText(Rs.getString("cuotas"));
                } catch (Exception e) {
                    txCuotas.setText("");
                }
                try {
                    txDias.setText(Rs.getString("dias"));
                } catch (Exception e) {
                    txDias.setText("");
                }
                
                
                SetCredito(true);
                
            }
            else{
                chkCredito.setSelected(false);
                txCrAsignado.setText("0");
                txCuotas.setText("");
                txDias.setText("");
                
                SetCredito(false);
            }
            
            //Titulo de pestaña
            String Nombre = Rs.getString("Nombre");
            if(Nombre.length()>20){
                Nombre=Nombre.substring(0,20);
            }
            
            fmMain.pnPestanas.setTitleAt(fmMain.pnPestanas.getSelectedIndex(), Nombre);
            PosBanco = cbBancos.getSelectedIndex();
            PosRegion = cbRegion.getSelectedIndex();
            SetTipo(2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            Sql.Close();
        }
}
    private void SetCredito(boolean Estado){
        txCrAsignado.setEnabled(Estado);
        txCrUtilizado.setEnabled(Estado);
        txCrDisponible.setEnabled(Estado);
        txCuotas.setEnabled(Estado);
        txDias.setEnabled(Estado);
    }
    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        if(fmMain.GetEstado(fmMain.pnPestanas.getSelectedIndex())==1){
            if(JOptionPane.showConfirmDialog(null, "¿Cancelar sin guardar?")==JOptionPane.YES_OPTION){
                if(Tipo==1)
                    SetTipo(-1);
                else
                    CargaProveedor(txRut.getText());
            }
        }
            else
                SetTipo(-1);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void txRutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRutKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && Tipo != 1) {
            if (!txRut.getText().isEmpty()) {
                CargaProveedor(txRut.getText());
            } else {
                jdBuscarCliPrv BPC = new jdBuscarCliPrv(null, true);
                BPC.setLocationRelativeTo(null);
                BPC.setTitle("Buscar Proveedor");
                BPC.SetTipo(1);
                BPC.setVisible(true);
                CargaProveedor(BPC.GetRut());
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER && Tipo == 1) {
            txDv.requestFocus();
        }
    }//GEN-LAST:event_txRutKeyPressed

    private void btIrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIrActionPerformed
        if(!txRut.getText().isEmpty())
            CargaProveedor(txRut.getText());
        else{
            jdBuscarCliPrv BPC = new jdBuscarCliPrv(null, true);
            BPC.setLocationRelativeTo(null);
            BPC.setTitle("Buscar Proveedor");
            BPC.SetTipo(1);
            BPC.setVisible(true);
            CargaProveedor(BPC.GetRut());
        }
    }//GEN-LAST:event_btIrActionPerformed

    private void btNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNuevoActionPerformed
        if(fmMain.GetEstado(fmMain.pnPestanas.getSelectedIndex())==0){
            SetTipo(1);
        }
    }//GEN-LAST:event_btNuevoActionPerformed

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
    ExeSql  Sql = new ExeSql();
    
    /*Validaciones*/
    
    if(Integer.valueOf(txRut.getText())>99999999){
        JOptionPane.showMessageDialog(null,"Error en el rut");
        return;
    }
    if(txDv.getText().isEmpty() ||
            txNombre.getText().isEmpty() ||
            txGiro.getText().isEmpty()){
        JOptionPane.showMessageDialog(null,"Faltan Datos");
        return;
    }
        
        if(fmMain.OkCancel("¿Guardar los cambios realizados?")== JOptionPane.OK_OPTION){
            String Rut          = txRut.getText().trim();
            String Nombre       = txNombre.getText();
            String Giro         = txGiro.getText();
            String Direccion    = txDireccion.getText();   
            String Ciudad       = txCiudad.getText();
            String Comuna       = txComuna.getText();
            String NroCuenta    = txNroCuenta.getText();
            String Region;
            String Cuotas;
            String Dias;
            String Credito;
            
            //Prepara Combobox Region y Banco
            try {   Region  = String.valueOf(cbId_Accion(cbRegion)); }
            catch (Exception e) { Region = "0";            }
            String Banco;
            try {   Banco  = String.valueOf(cbId_Accion(cbBancos)); }
            catch (Exception e) { Banco = "0";            }
            
            if(Nombre.isEmpty())    Nombre="";
            if(Giro.isEmpty())      Giro="";
            if(Direccion.isEmpty()) Direccion="";
            if(Ciudad.isEmpty())    Ciudad="";
            if(Comuna.isEmpty())    Comuna="";
            if(NroCuenta.isEmpty()) NroCuenta="0";
            
            if(!txCuotas.getText().isEmpty()) Cuotas=txCuotas.getText().trim();
            else                              Cuotas="0";
            
            if(!txDias.getText().isEmpty())   Dias = txDias.getText().trim();
            else                              Dias = "0";
            
            if(!txCrAsignado.getText().isEmpty())   Credito = txCrAsignado.getText().trim();
            else                              Credito = "0";
            
            //Nuevo Proveedor
            if(Tipo==1){
                try {
                    //Valida Rut
                    if(!fmMain.validarRut(txRut.getText().trim() + "-" + txDv.getText().trim())){
                        fmMain.Mensaje("El Rut es incorrecto");
                        return;
                    }
                    
                    
                    
                    //Inserta Proveedor
                    Sql.ExeSql( " INSERT INTO proveedor\n" +
                                " (rut, dv, nombre, giro, direccion, ciudad, comuna, region, banco, nrocuenta, cuotas,dias,tipopago,credito,creditoasignado)\n" +
                                " VALUES (" +
                                txRut.getText() + ",'" +
                                txDv.getText() +  "','" +
                                Nombre + "','" +
                                Giro   + "','" + 
                                Direccion   + "','" + 
                                Ciudad   + "','" + 
                                Comuna   + "'," + 
                                Region + "," +
                                Banco + ",'" +
                                NroCuenta + "'," +
                                Cuotas+ ",'"+ 
                                Dias + "'," + 
                                cbFormaPagoId.getSelectedItem().toString().trim() + "," +
                                chkCredito.isSelected() + "," + 
                                Credito + ")");
                    
                    //Inserta Contactos
                    for(int i=0; i< GrillaContactos.getRowCount(); i++){
                         Sql.ExeSql("insert into prv_contacto \n" +
                                    "(rut,nombre,fono1,fono2,email,tipo) values (" + 
                                    txRut.getText() + ",'" +
                                    GrillaContactos.getModel().getValueAt(i,0).toString() + "','" +
                                    GrillaContactos.getModel().getValueAt(i,1).toString() + "','" +
                                    GrillaContactos.getModel().getValueAt(i,2).toString() + "','" + 
                                    GrillaContactos.getModel().getValueAt(i,3).toString() + "',"  +
                                    GrillaContactos.getModel().getValueAt(i,5).toString() + ")");
                        
                    }
                    Sql.Commit();
                    JOptionPane.showMessageDialog(null, "Guardado");
                    cbRegion.setSelectedIndex(-1);
                    SetTipo(-1);
                    CargaProveedor(Rut);
                } catch (Exception e) {
                    Sql.Rollback();
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                } finally{
                    Sql.Close();
                }

            }
            //Update PROVEEDOR  
            else if(Tipo==3){
                try {
                    Sql.ExeSql( "UPDATE proveedor SET \n" +
                                "nombre='"          + Nombre    + "',\n" +
                                "giro='"            + Giro      + "',\n" +
                                "direccion='"       + Direccion + "',\n" +
                                "ciudad='"          + Comuna    + "',\n" +
                                "region="           + Region + ",\n" +
                                "banco="            + Banco + ",\n" +
                                "nrocuenta='"       + NroCuenta + "',\n" +
                                "cuotas="           + Cuotas + ",\n "+
                                "dias='"            + Dias + "',\n " +
                                "tipopago="         + cbFormaPagoId.getSelectedItem().toString().trim() + "\n," +
                                "credito="          + chkCredito.isSelected() + ",\n" +
                                "creditoasignado="  + Credito + "\n " +
                                "where rut = " + txRut.getText());
                    
                    //CONTACTOS - DELETE a los eliminados (lista)
                    if(!Eliminados.isEmpty()){
                        Eliminados = Eliminados.substring(0, Eliminados.length()-1);
                        Sql.ExeSql( "DELETE FROM prv_contacto WHERE id in (" + Eliminados + ")");
                    }
                    String Id="";
                    for(int i=0 ; i<GrillaContactos.getRowCount() ; i++){
                        try {
                            Id = GrillaContactos.getValueAt(i, 6).toString();
                        } catch (Exception e) {
                            Id = "";
                        }
                        
                        
                    //CONTACTOS - UPDATE a los antiguos (en grilla con id)
                        if(!Id.isEmpty()){
                            Sql.ExeSql("UPDATE prv_contacto SET "+
                                       "nombre='" + GrillaContactos.getValueAt(i,0).toString().trim() + "'," +
                                       "fono1='"  + GrillaContactos.getValueAt(i,1).toString().trim() + "'," +
                                       "fono2='"  + GrillaContactos.getValueAt(i,2).toString().trim() + "'," +
                                       "email='"  + GrillaContactos.getValueAt(i,3).toString().trim() + "'," +
                                       "tipo="    + GrillaContactos.getValueAt(i,5).toString().trim() + " " +
                                       "WHERE id="+ GrillaContactos.getValueAt(i,6).toString().trim());
                        }
                    //CONTACTO - INSERT a los nuevos (en grilla sin id)
                        else{
                            Sql.ExeSql("insert into prv_contacto \n" +
                                    "(rut,nombre,fono1,fono2,email,tipo) values (" + 
                                    txRut.getText() + ",'" +
                                    GrillaContactos.getModel().getValueAt(i,0).toString() + "','" +
                                    GrillaContactos.getModel().getValueAt(i,1).toString() + "','" +
                                    GrillaContactos.getModel().getValueAt(i,2).toString() + "','" + 
                                    GrillaContactos.getModel().getValueAt(i,3).toString() + "',"  +
                                    GrillaContactos.getModel().getValueAt(i,5).toString() + ")");
                        }
                    
                    
                    }
                    Sql.Commit();
                    fmMain.Mensaje("Guardado");
                    cbRegion.setSelectedIndex(-1);
                    SetTipo(-1);
                    CargaProveedor(Rut);
                    
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } finally {
                    Sql.Close();
                }
            }
        }
    }//GEN-LAST:event_btGuardarActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        SetTipo(3);
    }//GEN-LAST:event_btEditarActionPerformed

    private void cbRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRegionActionPerformed
        if(Tipo==2)
            cbRegion.setSelectedIndex(PosRegion);
    }//GEN-LAST:event_cbRegionActionPerformed

    private void cbBancosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBancosActionPerformed
        if(Tipo==2)
            cbBancos.setSelectedIndex(PosBanco);
    }//GEN-LAST:event_cbBancosActionPerformed

    private void txDiasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txDiasMouseClicked
        if (evt.getClickCount() == 2 && (Tipo == 3 || Tipo == 1)) {
            jdDiasOCP Dias = new jdDiasOCP(null, true);
            Dias.setTitle("Dias");
            Dias.setLocationRelativeTo(txDias);
            Dias.SetFilas(Integer.valueOf(txCuotas.getText()));
            Dias.setVisible(true);
            txDias.setText(Dias.GetFilas());
        }
    }//GEN-LAST:event_txDiasMouseClicked

    private void txNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNombreKeyTyped
        if (Character.isLowerCase(evt.getKeyChar()))
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));        // TODO add your handling code here:
    }//GEN-LAST:event_txNombreKeyTyped

    private void txGiroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txGiroKeyTyped
        if (Character.isLowerCase(evt.getKeyChar()))
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));        // TODO add your handling code here:
    }//GEN-LAST:event_txGiroKeyTyped

    private void txDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txDireccionKeyTyped
        if (Character.isLowerCase(evt.getKeyChar()))
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));        // TODO add your handling code here:
    }//GEN-LAST:event_txDireccionKeyTyped

    private void txCiudadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCiudadKeyTyped
        if (Character.isLowerCase(evt.getKeyChar()))
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));        // TODO add your handling code here:
    }//GEN-LAST:event_txCiudadKeyTyped

    private void txComunaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txComunaKeyTyped
        if (Character.isLowerCase(evt.getKeyChar()))
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));        // TODO add your handling code here:
    }//GEN-LAST:event_txComunaKeyTyped

    private void txDvKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txDvKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER && Tipo==1)
            txNombre.requestFocus();
    }//GEN-LAST:event_txDvKeyPressed

    private void txNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNombreKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER && Tipo==1)
            txGiro.requestFocus();
    }//GEN-LAST:event_txNombreKeyPressed

    private void txGiroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txGiroKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER && Tipo==1)
            txDireccion.requestFocus();
    }//GEN-LAST:event_txGiroKeyPressed

    private void txDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txDireccionKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER && Tipo==1)
            txCiudad.requestFocus();
    }//GEN-LAST:event_txDireccionKeyPressed

    private void txComunaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txComunaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER && Tipo==1){
            cbRegion.requestFocus();
            cbRegion.setPopupVisible(true);
        }
            
    }//GEN-LAST:event_txComunaKeyPressed

    private void txCiudadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCiudadKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER && Tipo==1)
            txComuna.requestFocus();
    }//GEN-LAST:event_txCiudadKeyPressed

    private void cbFormaPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFormaPagoActionPerformed
        if(Tipo!=-99)
        cbFormaPagoId.setSelectedIndex(cbFormaPago.getSelectedIndex());
    }//GEN-LAST:event_cbFormaPagoActionPerformed

    private void chkCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCreditoActionPerformed
        if(chkCredito.isSelected()){
            txCrAsignado.setEnabled(true);
            txCrUtilizado.setEnabled(true);
            txCrDisponible.setEnabled(true);
            txCuotas.setEnabled(true);
            txDias.setEnabled(true);
            
            
            
        }
        else{
            txCrAsignado.setEnabled(false);
            txCrUtilizado.setEnabled(false);
            txCrDisponible.setEnabled(false);
            txCuotas.setEnabled(false);
            txDias.setEnabled(false);
        }
            
    }//GEN-LAST:event_chkCreditoActionPerformed

    private void btAgregarContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarContactoActionPerformed
        DefaultTableModel TModel = (DefaultTableModel) GrillaContactos.getModel();
        
        jdAddDatosPersona Persona = new jdAddDatosPersona(null, true);
        Persona.ConTipo("proveedor");
        Persona.setLocationRelativeTo(null);
        Persona.setVisible(true);
        TModel.addRow(Persona.GetFila());
        
    }//GEN-LAST:event_btAgregarContactoActionPerformed

    private void btEliminarContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarContactoActionPerformed
//        DefaultTableModel TModel = (DefaultTableModel) GrillaContactos.getModel();
//        if(GrillaContactos.getValueAt(GrillaContactos.getSelectedRow(), 6).toString().isEmpty())
//            TModel.removeRow(GrillaContactos.getSelectedRow());
//        else{
//            Eliminados = Eliminados + GrillaContactos.getValueAt(GrillaContactos.getSelectedRow(), 6).toString() + "," ;
//            EliminadosCont++;
//            TModel.removeRow(GrillaContactos.getSelectedRow());
//        }
        

             if(fmMain.OkCancel("¿Esta Seguro de Eliminar el Contacto?")== JOptionPane.OK_OPTION){    
        
        ExeSql Sql = new ExeSql();
        try {
            String id_elimina =GrillaContactos.getValueAt(GrillaContactos.getSelectedRow(),6).toString().trim();
            Sql.ExeSql("DELETE FROM prv_contacto WHERE id = " + id_elimina);
            Sql.Commit();
              CargaContactosPrv(txRut.getText());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally{
            Sql.Close();
        }
     }  
    }//GEN-LAST:event_btEliminarContactoActionPerformed

    private void txDvFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txDvFocusLost
        if(!txRut.getText().isEmpty() && !txDv.getText().isEmpty()){
            if(!fmMain.validarRut(txRut.getText().trim() + "-" + txDv.getText().trim()))
                fmMain.Mensaje("Error en el Rut");
        }
    }//GEN-LAST:event_txDvFocusLost

    private void btEditarContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarContactoActionPerformed
        // TODO add your handling code here:
        DefaultTableModel TModel = (DefaultTableModel) GrillaContactos.getModel();
        
        jdAddDatosPersona Persona = new jdAddDatosPersona(null, true);
        Persona.ConTipo("proveedor");
        String idd =GrillaContactos.getValueAt(GrillaContactos.getSelectedRow(),6).toString().trim();
         
        
        
        Persona.Editar(3, GrillaContactos.getValueAt(GrillaContactos.getSelectedRow(),0).toString().trim(), GrillaContactos.getValueAt(GrillaContactos.getSelectedRow(),1).toString().trim(), GrillaContactos.getValueAt(GrillaContactos.getSelectedRow(),2).toString().trim(), GrillaContactos.getValueAt(GrillaContactos.getSelectedRow(),3).toString().trim(), Integer.parseInt(idd), GrillaContactos.getValueAt(GrillaContactos.getSelectedRow(),5).toString().trim());
        
        //Persona.EditarContactoPrv(txRut.getText().trim(),GrillaContactos.getValueAt(GrillaContactos.getSelectedRow(),6).toString().trim());
        Persona.setLocationRelativeTo(null);
        Persona.setVisible(true);
        btIr.doClick();
    }//GEN-LAST:event_btEditarContactoActionPerformed

    private void txDvKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txDvKeyReleased
        txDv.setText(txDv.getText().toUpperCase());
    }//GEN-LAST:event_txDvKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable GrillaContactos;
    private javax.swing.JButton btAgregarContacto;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btEditarContacto;
    private javax.swing.JButton btEliminarContacto;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btIr;
    public javax.swing.JButton btNuevo;
    private javax.swing.JComboBox cbBancos;
    private javax.swing.JComboBox cbFormaPago;
    private javax.swing.JComboBox cbFormaPagoId;
    private javax.swing.JComboBox cbRegion;
    private javax.swing.JCheckBox chkCredito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JTextField txCiudad;
    private javax.swing.JTextField txComuna;
    private javax.swing.JTextField txCrAsignado;
    private javax.swing.JTextField txCrDisponible;
    private javax.swing.JTextField txCrUtilizado;
    private javax.swing.JTextField txCuotas;
    private javax.swing.JTextField txDias;
    private javax.swing.JTextField txDireccion;
    private javax.swing.JTextField txDv;
    private javax.swing.JTextField txGiro;
    private javax.swing.JTextField txNombre;
    private javax.swing.JTextField txNroCuenta;
    public javax.swing.JTextField txRut;
    // End of variables declaration//GEN-END:variables
}
