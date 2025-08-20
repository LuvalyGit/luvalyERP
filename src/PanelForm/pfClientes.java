
package PanelForm;

import java.sql.ResultSet;
import Conexion.ExeSql;
import Dialogos.jdAddDatosPersona;
import Dialogos.jdBuscarCliPrv;
import Dialogos.jd_Localidades;
import Formularios.fmMain;
import Utilidades.CargaGrillas;
import Utilidades.ComboCodigos;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.jfree.ui.tabbedui.RootPanel;

/**
 *
 * @author DavidAlcaman
 */
 public class pfClientes extends javax.swing.JPanel {
    
    public String MpOC = "";
    public int Mp = 0;
     
    int Tipo=-1; //-1 Nada de nada      1 Nuevo      2 Abierto      3.Editando
    int PosRegion;
    String Eliminados ;
    int EliminadosCont;
    String TipoOC;
    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
    boolean Estado = true;
    
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
        DefaultComboBoxModel model = (DefaultComboBoxModel) txCiudad.getModel();
        if(model.getSize()>0){
            model.removeAllElements();
        }
        DefaultComboBoxModel model2 = (DefaultComboBoxModel) txComuna.getModel();
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
    
    
    
    public pfClientes() {
        initComponents();
        CargaRegiones();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        GrillaOCC.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        GrillaDoc.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        
        CargaCiudad();
        GrillaOCC.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            //Se ejecuta automáticamente cada vez que se hace una nueva selección. 
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(GrillaOCC.getSelectedRowCount()>0)
                    CargaDocRel(txRut.getText().trim(), GrillaOCC.getValueAt(GrillaOCC.getSelectedRow(), 0).toString(), GrillaOCC.getValueAt(GrillaOCC.getSelectedRow(), 1).toString());
            }

        });
        
        GrillaDoc.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            //Se ejecuta automáticamente cada vez que se hace una nueva selección. 
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(GrillaDoc.getSelectedRowCount()>0)
                    CargaProductosDoc(GrillaDoc.getValueAt(GrillaDoc.getSelectedRow(), 4).toString().trim(), GrillaDoc.getValueAt(GrillaDoc.getSelectedRow(), 1).toString().trim());
            }

        });
        
        
        txCiudad.setVisible(false);
        txComuna.setVisible(false);
                
        CargaVendedor();

        cbVendedor.setEnabled(false);
        cbCodigoVendedor.setVisible(false);
        cbRegion.setEnabled(false);
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        MnuCopiaCorreo = new javax.swing.JMenuItem();
        pnMenu = new javax.swing.JPanel();
        btEditar = new javax.swing.JButton();
        btNuevo = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btGuardar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        pnCentral = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txRut = new javax.swing.JTextField();
        cbCodigoOc = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txNombre = new javax.swing.JTextField();
        txDv = new javax.swing.JTextField();
        btIr = new javax.swing.JButton();
        btNuevoOC = new javax.swing.JButton();
        btEditarOc = new javax.swing.JButton();
        btGuardarOC = new javax.swing.JButton();
        btCancelarOC = new javax.swing.JButton();
        chkclienteestado = new javax.swing.JCheckBox();
        cbVendedor = new javax.swing.JComboBox();
        cbCodigoVendedor = new javax.swing.JComboBox<String>();
        jLabel10 = new javax.swing.JLabel();
        chkVentaEmpresa = new javax.swing.JCheckBox();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txGiro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txDireccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbRegion = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Grilla = new javax.swing.JTable();
        btAgregar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        btEditarContacto = new javax.swing.JButton();
        txCiudad = new javax.swing.JComboBox<String>();
        txComuna = new javax.swing.JComboBox<String>();
        btCiudad = new javax.swing.JButton();
        txtCiudad = new javax.swing.JTextField();
        btComuna = new javax.swing.JButton();
        txtComuna = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        GrillaOCC = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        GrillaDoc = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        GrillaProductos = new javax.swing.JTable();

        MnuCopiaCorreo.setText("Copiar Correo");
        MnuCopiaCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuCopiaCorreoActionPerformed(evt);
            }
        });
        jPopupMenu1.add(MnuCopiaCorreo);

        setName("pnClientes"); // NOI18N
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        pnMenu.setBackground(new java.awt.Color(220, 215, 226));
        pnMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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
        jXLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Clientes24.png"))); // NOI18N
        jXLabel1.setText("CLIENTES");
        jXLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(201, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
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
                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEditar)
                .addContainerGap(200, Short.MAX_VALUE))
        );
        pnMenuLayout.setVerticalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnMenuLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(6, 6, 6))
        );

        add(pnMenu);

        pnCentral.setBackground(new java.awt.Color(220, 215, 226));

        jLabel1.setText("Rut");

        txRut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txRutKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txRutKeyTyped(evt);
            }
        });

        cbCodigoOc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCodigoOcActionPerformed(evt);
            }
        });

        jLabel4.setText("Codigo OC");

        jLabel2.setText("Razon Social");

        txNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txNombreKeyTyped(evt);
            }
        });

        txDv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txDvFocusLost(evt);
            }
        });
        txDv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txDvKeyPressed(evt);
            }
        });

        btIr.setText("Ir");
        btIr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIrActionPerformed(evt);
            }
        });

        btNuevoOC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/Agregar.png"))); // NOI18N
        btNuevoOC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNuevoOCActionPerformed(evt);
            }
        });

        btEditarOc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/Pencil16.png"))); // NOI18N
        btEditarOc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarOcActionPerformed(evt);
            }
        });

        btGuardarOC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/save16.png"))); // NOI18N
        btGuardarOC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarOCActionPerformed(evt);
            }
        });

        btCancelarOC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/Cancel16.png"))); // NOI18N
        btCancelarOC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarOCActionPerformed(evt);
            }
        });

        chkclienteestado.setText("Cliente estado");
        chkclienteestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkclienteestadoActionPerformed(evt);
            }
        });

        cbVendedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Vendedor" }));
        cbVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbVendedorActionPerformed(evt);
            }
        });

        cbCodigoVendedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Codigo" }));
        cbCodigoVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCodigoVendedorActionPerformed(evt);
            }
        });

        jLabel10.setText("Vendedor Asociado a OC :");

        chkVentaEmpresa.setText("Venta Empresas");
        chkVentaEmpresa.setToolTipText("");
        chkVentaEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkVentaEmpresaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnCentralLayout = new javax.swing.GroupLayout(pnCentral);
        pnCentral.setLayout(pnCentralLayout);
        pnCentralLayout.setHorizontalGroup(
            pnCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCentralLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCentralLayout.createSequentialGroup()
                        .addComponent(cbCodigoOc, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btNuevoOC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btEditarOc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btGuardarOC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelarOC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnCentralLayout.createSequentialGroup()
                        .addComponent(txRut, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txDv, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btIr, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnCentralLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbVendedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnCentralLayout.createSequentialGroup()
                                .addComponent(chkVentaEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkclienteestado)
                    .addComponent(cbCodigoVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        pnCentralLayout.setVerticalGroup(
            pnCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCentralLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnCentralLayout.createSequentialGroup()
                        .addGroup(pnCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel2)
                            .addComponent(txRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(txDv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btIr)
                            .addComponent(chkclienteestado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)
                                .addComponent(cbCodigoVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(cbCodigoOc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btNuevoOC)
                                .addComponent(btEditarOc)
                                .addComponent(btGuardarOC)
                                .addComponent(btCancelarOC)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkVentaEmpresa)
                .addContainerGap())
        );

        add(pnCentral);

        jPanel1.setBackground(new java.awt.Color(220, 215, 226));

        jLabel3.setText("Giro");

        txGiro.setEditable(false);
        txGiro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txGiroKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txGiroKeyTyped(evt);
            }
        });

        jLabel5.setText("Dirección");

        txDireccion.setEditable(false);
        txDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txDireccionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txDireccionKeyTyped(evt);
            }
        });

        jLabel6.setText("Ciudad");

        jLabel7.setText("Comuna");

        jLabel8.setText("Región");

        cbRegion.setMaximumRowCount(10);
        cbRegion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRegionActionPerformed(evt);
            }
        });

        jLabel9.setText("Contactos");

        Grilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Telefono", "Celular", "email", "", "Cargo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Grilla.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(Grilla);
        if (Grilla.getColumnModel().getColumnCount() > 0) {
            Grilla.getColumnModel().getColumn(4).setMinWidth(0);
            Grilla.getColumnModel().getColumn(4).setPreferredWidth(0);
            Grilla.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        btAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/Agregar.png"))); // NOI18N
        btAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarActionPerformed(evt);
            }
        });

        btEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/Eliminar.png"))); // NOI18N
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
            }
        });

        btEditarContacto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/Pencil16.png"))); // NOI18N
        btEditarContacto.setToolTipText("Editar Contacto");
        btEditarContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarContactoActionPerformed(evt);
            }
        });

        txCiudad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txComuna.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btCiudad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/search16.png"))); // NOI18N
        btCiudad.setEnabled(false);
        btCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCiudadActionPerformed(evt);
            }
        });

        txtCiudad.setToolTipText("");
        txtCiudad.setEnabled(false);

        btComuna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/search16.png"))); // NOI18N
        btComuna.setEnabled(false);
        btComuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btComunaActionPerformed(evt);
            }
        });

        txtComuna.setToolTipText("");
        txtComuna.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btEditarContacto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbRegion, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txDireccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                            .addComponent(txGiro, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCiudad, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtComuna))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btComuna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txCiudad, 0, 157, Short.MAX_VALUE)
                                    .addComponent(txComuna, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txGiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txComuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtCiudad))
                    .addComponent(btCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtComuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cbRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btEditarContacto))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addComponent(btComuna, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Datos", jPanel1);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Orden de Compra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        GrillaOCC.setAutoCreateRowSorter(true);
        GrillaOCC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Orden", "Fecha", "Monto", "Pago"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        GrillaOCC.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        GrillaOCC.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                GrillaOCCHierarchyChanged(evt);
            }
        });
        GrillaOCC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                GrillaOCCFocusGained(evt);
            }
        });
        GrillaOCC.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                GrillaOCCCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jScrollPane2.setViewportView(GrillaOCC);
        if (GrillaOCC.getColumnModel().getColumnCount() > 0) {
            GrillaOCC.getColumnModel().getColumn(0).setMinWidth(50);
            GrillaOCC.getColumnModel().getColumn(0).setPreferredWidth(50);
            GrillaOCC.getColumnModel().getColumn(0).setMaxWidth(50);
            GrillaOCC.getColumnModel().getColumn(2).setMinWidth(75);
            GrillaOCC.getColumnModel().getColumn(2).setPreferredWidth(75);
            GrillaOCC.getColumnModel().getColumn(2).setMaxWidth(85);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Documentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        GrillaDoc.setAutoCreateRowSorter(true);
        GrillaDoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tipo", "Numero", "Fecha", "Monto", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        GrillaDoc.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(GrillaDoc);
        if (GrillaDoc.getColumnModel().getColumnCount() > 0) {
            GrillaDoc.getColumnModel().getColumn(0).setMinWidth(110);
            GrillaDoc.getColumnModel().getColumn(0).setPreferredWidth(120);
            GrillaDoc.getColumnModel().getColumn(0).setMaxWidth(130);
            GrillaDoc.getColumnModel().getColumn(1).setMinWidth(65);
            GrillaDoc.getColumnModel().getColumn(1).setPreferredWidth(70);
            GrillaDoc.getColumnModel().getColumn(1).setMaxWidth(75);
            GrillaDoc.getColumnModel().getColumn(2).setMinWidth(75);
            GrillaDoc.getColumnModel().getColumn(2).setPreferredWidth(75);
            GrillaDoc.getColumnModel().getColumn(2).setMaxWidth(80);
            GrillaDoc.getColumnModel().getColumn(4).setMinWidth(0);
            GrillaDoc.getColumnModel().getColumn(4).setPreferredWidth(0);
            GrillaDoc.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        GrillaProductos.setAutoCreateRowSorter(true);
        GrillaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Cantidad", "Unitario", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(GrillaProductos);
        if (GrillaProductos.getColumnModel().getColumnCount() > 0) {
            GrillaProductos.getColumnModel().getColumn(0).setMinWidth(80);
            GrillaProductos.getColumnModel().getColumn(0).setPreferredWidth(80);
            GrillaProductos.getColumnModel().getColumn(0).setMaxWidth(80);
            GrillaProductos.getColumnModel().getColumn(2).setMinWidth(90);
            GrillaProductos.getColumnModel().getColumn(2).setPreferredWidth(90);
            GrillaProductos.getColumnModel().getColumn(2).setMaxWidth(90);
            GrillaProductos.getColumnModel().getColumn(3).setMinWidth(90);
            GrillaProductos.getColumnModel().getColumn(3).setPreferredWidth(90);
            GrillaProductos.getColumnModel().getColumn(3).setMaxWidth(90);
            GrillaProductos.getColumnModel().getColumn(4).setMinWidth(100);
            GrillaProductos.getColumnModel().getColumn(4).setPreferredWidth(100);
            GrillaProductos.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Ordenes de Compra", jPanel2);

        add(jTabbedPane1);
    }// </editor-fold>//GEN-END:initComponents
 private void Limpia(){
        DefaultTableModel   dfTm = (DefaultTableModel) Grilla.getModel();
        txRut.setText("");
        txNombre.setText("");
        txGiro.setText("");
        txDireccion.setText("");
       
       // txCiudad.setSelectedItem("");
        txtCiudad.setText("");
        
     //   txComuna.setSelectedItem("");
        txtComuna.setText("");
        
        cbRegion.setSelectedIndex(-1);
        txDv.setText("");
        cbRegion.setSelectedIndex(-1);
        while(dfTm.getRowCount()>0)
        dfTm.removeRow(0);
        cbCodigoOc.setSelectedIndex(-1);
        cbRegion.setSelectedIndex(-1);
    }   
 private void Habilita(boolean Estado){
        //txRut.setEnabled(Estado);
        txNombre.setEnabled(Estado);
        txGiro.setEnabled(Estado);
        txDireccion.setEnabled(Estado);
        
      //  txCiudad.setEnabled(Estado);
   //     txtCiudad.setEnabled(Estado);
        
   //     txComuna.setEnabled(Estado);
   //     txtComuna.setEnabled(Estado);
        
        txDv.setEnabled(Estado);
      //  cbRegion.setEnabled(Estado);
        
       // cbVendedor.setEnabled(Estado);
    }
  private void Edicion(boolean Estado){
        //txRut.setEditable(Estado);
        txNombre.setEditable(Estado);
        
    }
    private void EdicionOC(boolean Estado){
        //txRut.setEditable(Estado);
        txNombre.setEditable(Estado);
        txGiro.setEditable(Estado);
        txDireccion.setEditable(Estado);
        
        btCiudad.setEnabled(Estado);
        btComuna.setEnabled(Estado);
        cbRegion.setEnabled(Estado);
        cbVendedor.setEnabled(Estado);
        
        txDv.setEditable(Estado);
        
        btAgregar.setEnabled(Estado);
        btEliminar.setEnabled(Estado);
        
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
            Tipo=-1;
            chkclienteestado.setEnabled(false);
            btNuevoOC.setEnabled(false);
            btEditarOc.setEnabled(false);
            btGuardarOC.setEnabled(false);
            btCancelarOC.setEnabled(false);
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
            chkclienteestado.setEnabled(true);
            btNuevoOC.setEnabled(false);
            btEditarOc.setEnabled(false);
            btGuardarOC.setEnabled(false);
            btCancelarOC.setEnabled(false);
            
            
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
            cbCodigoOc.setEnabled(true);
            chkclienteestado.setEnabled(false);
            DefaultComboBoxModel model = (DefaultComboBoxModel) cbCodigoOc.getModel();
            try {
                if(model.getSize()<1 && model.getElementAt(0).equals("")){
                    btNuevoOC.setEnabled(true);
                }
                else {
                    btNuevoOC.setEnabled(false);
                }
            }
            catch (NullPointerException e ){
                btNuevoOC.setEnabled(true);
            }
            btEditarOc.setEnabled(true);
            btGuardarOC.setEnabled(false);
            btCancelarOC.setEnabled(false);
            
            Tipo=2;
        }
        // Edita Producto 
        else if(ElTipo==3){
            chkclienteestado.setEnabled(true);
            fmMain.SetEstado(fmMain.pnPestanas.getSelectedIndex(),1);
            Habilita(true);
            Edicion(true);
            btGuardar.setEnabled(true);
            btCancelar.setEnabled(true);
            btNuevo.setEnabled(false);
            btEditar.setEnabled(false);
            txRut.setEditable(false);
            Tipo=3;
            System.out.println(cbCodigoOc.getItemCount());
            if(chkclienteestado.isSelected()){
                btNuevoOC.setEnabled(true);
            }
            else {
                try {
                    if(cbCodigoOc.getItemAt(0).equals("")){
                        btNuevoOC.setEnabled(true);
                    }
                    else {
                        btNuevoOC.setEnabled(false);
                    }
                }
                catch (NullPointerException e) {
                    btNuevoOC.setEnabled(true);
                }
            }
            btGuardarOC.setEnabled(true);
            btCancelarOC.setEnabled(false);
            
        }
    }  
//------------------------------------------------------------------------------
// Funcion CODIGO desde COMBOBOX
//------------------------------------------------------------------------------
    private int cbId_Accion(JComboBox Combo ){
        int Codigo=-1;
    if (Combo.getSelectedIndex()!=0){
        ComboCodigos id = (ComboCodigos) Combo.getSelectedItem();
        Codigo = id.getId();
        String nombre = Combo.getSelectedItem().toString();
        Combo.hidePopup();
    } 
    return Codigo;
}
//------------------------------------------------------------------------------
// Carga Codigos OC
//------------------------------------------------------------------------------
    private void CargaCodOc(String Rut){
        ExeSql  Sql = new ExeSql();
        ResultSet Rs;
        DefaultComboBoxModel cbMd = new DefaultComboBoxModel();
        cbCodigoOc.setModel(cbMd);
        
        
        
        try{
            Rs = Sql.Select("select distinct(codigo_oc) as codigo_oc from clicontacto where rut = " + Rut);
            Rs.next();
            
            if(Rs.getRow()>0){
                
                Rs.beforeFirst();
                
                while(Rs.next()){
                    cbMd.addElement(new ComboCodigos(Rs.getString("codigo_oc"),0)); 
                }
                
                
                if (Mp == 1){
                
                    cbMd.removeAllElements();
                    cbMd.addElement(MpOC);
                    
                }
                
                
                
                if(cbMd.getSize()>0 && !chkclienteestado.isSelected()){
                    btNuevoOC.setEnabled(false);
                }
                if(cbMd.getSize()==0 && !chkclienteestado.isSelected()){
                    btNuevoOC.setEnabled(true);
                }
                if(Estado==true){
                    btNuevoOC.setEnabled(true);
                }
            }
            else {
                cbCodigoOc.removeAllItems();
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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
        
        try{
            Rs = Sql.Select("select cast(numero as varchar(2)) || ' ' || nombre as nombre, numero\n" +
                            "from par_region\n" +
                            "order by numero asc ");
            while(Rs.next()){
                cbMd.addElement(new ComboCodigos(Rs.getString("nombre"),Rs.getInt("numero")));
            }
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
           }finally{
            Sql.Close();
        }
            
        
    }
  
    private void CargaOrdenes(String Rut, String Codigo_oc){
        ResultSet Rs;
        ExeSql Sql = new ExeSql();
        DefaultTableModel TableModel = (DefaultTableModel) GrillaOCC.getModel();
        
        
        
        while(TableModel.getRowCount()>0)
                        TableModel.removeRow(0);    
        
        try {
            
            Rs = Sql.Select("select oc.codigo_oc,oc.orden,cast(oc.femision as date) as fecha ,oc.totaldocto,\n" +
                            "case sum(c.totaldocto-pagado) when 0 then 'pagada' else 'Pendiente' end as estado\n" +
                            "from occh oc\n" +
                            "left join ctactecli c on c.rut=oc.rut and c.tipdocto='FAC'  and c.codigo_oc=oc.codigo_oc and c.occh=oc.orden\n" +
                            "where oc.rut="+ Rut +"\n" +
                            "and oc.codigo_oc="+ Codigo_oc +"\n" +
                            "group by  oc.codigo_oc,oc.orden,oc.femision, oc.totaldocto");
            while(Rs.next()){
                TableModel.addRow(new Object[]{Rs.getString("Codigo_oc").trim(), 
                                               Rs.getString("orden").trim(), 
                                               Rs.getString("fecha").trim(),
                                               fmMain.FormatoTotal(Rs.getDouble("totaldocto")),
                                               Rs.getString("estado").trim() });
                
            }
            
            
        } catch (Exception e) {
            fmMain.Mensaje(e.getMessage());
        }finally{
            Sql.Close();
        }
    }
   private void CargaDocRel(String Rut,String Codigo_Oc,String Orden){
       ResultSet Rs;
       ExeSql Sql = new ExeSql();
       DefaultTableModel TableModel = (DefaultTableModel) GrillaDoc.getModel();
        
        while(TableModel.getRowCount()>0)
                        TableModel.removeRow(0);    
        
       
       try {
           //Carga Documentos Relacionados
            Rs = Sql.Select("select case tipdocto when 'FEC' then 'Factura Exenta' when 'FAC' then 'Factura' when 'NCC' then 'Nota de Credito' when 'GDC' then 'Guia de Despacho' else 'No definido' end as tipo,\n" +
                            "nrodocto,cast(femision as date) as fecha, totaldocto,tipdocto\n" +
                            "from ctactecli\n" +
                            "where rut="+ Rut +"\n" +
                            "and codigo_oc="+ Codigo_Oc +"\n" +
                            "and occh='"+ Orden +"'");
            while(Rs.next()){
                TableModel.addRow(new Object[]{
                    Rs.getString("tipo"),
                    Rs.getInt("nrodocto"),
                    Rs.getString("Fecha"),
                    fmMain.FormatoTotal(Rs.getDouble("totaldocto")),
                    Rs.getString("tipdocto").trim()});
                
            }
       } catch (Exception e) {
       }finally{
           Sql.Close();
       }
   }
   private void CargaProductosDoc(String Tipo,String Numero){
       ResultSet Rs;
       ExeSql Sql = new ExeSql();
       DefaultTableModel TableModel = (DefaultTableModel) GrillaProductos.getModel();
        
        while(TableModel.getRowCount()>0)
                        TableModel.removeRow(0);    
        try {
            Rs = Sql.Select("select c.sku,p.nombre,c.cantidad,c.valorunitario,c.totallinea\n" +
                            "from ctacteclidet c\n" +
                            "left join producto p on p.sku=c.sku\n" +
                            "where c.tipdocto='"+ Tipo +"'\n" +
                            "and nrodocto=" + Numero);
             while(Rs.next()){
                TableModel.addRow(new Object[]{
                                            Rs.getString("sku").trim(),
                                            Rs.getString("nombre").trim(),
                                            fmMain.FormatoNumero(Rs.getDouble("cantidad")),
                                            fmMain.FormatoTotal(Rs.getDouble("valorunitario")),
                                            fmMain.FormatoTotal(Rs.getDouble("totallinea"))});
                
            }
           
       } catch (Exception e) {
       }finally{
            Sql.Close();
        }
          
   }
    
//------------------------------------------------------------------------------
// Carga CLIENTES
//------------------------------------------------------------------------------
    public void CargaCliente(String Rut){
    ExeSql  Sql = new ExeSql();
    ResultSet Rs;
    Eliminados="";
    EliminadosCont=0;
    
    
    
    try{
        Rs = Sql.Select("select rut,dv,nombre, cliente_estado, ventaempresa\n" +
                        "from cliente\n" +
                        "where rut=" + Rut);
    
        if(Sql.GetRowCount()==0){
            if(JOptionPane.showConfirmDialog(null, "Cliente no existe, ¿desea crearlo?","Cliente", JOptionPane.OK_CANCEL_OPTION)== JOptionPane.OK_OPTION){
                String newRut = txRut.getText();
                btNuevo.doClick();
                txRut.setText(newRut);
                           
                if(txDv.getText().isEmpty()){
                    txDv.requestFocus();
                
                }else {
                
                   txNombre.requestFocus();
                }
                
            }
            return;
        }
        Rs.next();
        String Nombre = Rs.getString("Nombre");
        if(Nombre.length()>20){
            Nombre=Nombre.substring(0,20);
        }
        txRut.setText(Rs.getString("Rut"));
        txDv.setText(Rs.getString("dv"));
        txNombre.setText(Rs.getString("nombre").trim());
        Estado=Rs.getBoolean("cliente_estado");
        chkclienteestado.setSelected(Rs.getBoolean("cliente_estado"));
        
        if (Rs.getInt("ventaempresa") == 0){
        
            chkVentaEmpresa.setSelected(false);
        
        }else if (Rs.getInt("ventaempresa") == 1){
        
            chkVentaEmpresa.setSelected(true);
        
        }
        
        
        
        fmMain.pnPestanas.setTitleAt(fmMain.pnPestanas.getSelectedIndex(), Nombre);
        CargaCodOc(Rut);
        PosRegion = cbRegion.getSelectedIndex();
        SetTipo(2);
    } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally{
        Sql.Close();
    }

    }//-----------------------------------------------------------------------------
//  CARGA PERSONAS DE CONTACTOS
//-----------------------------------------------------------------------------
    private void CargaPersonas(String Rut,String Codigo){
        DefaultTableModel tbMd = new DefaultTableModel();
        String sql = "select cli.nombre,cli.fono,cli.celular,cli.email,cli.id, par.nombre as CARGO \n" +
                     "from clicontactopersonas cli\n" +
                     "left join par_general par on cli.id_cargo=par.codigo \n" +
                     "where par.tipo='TIPCONTACTOCLI' and cli.rut="+ Rut+ "\n"+
                     "and cli.codigo_oc="+ Codigo;
        try {
            CargaGrillas c = new CargaGrillas();
            tbMd = c.returndata(sql);
            Grilla.setModel(tbMd);
            Grilla.getColumnModel().getColumn(0).setPreferredWidth(200);//Nombre
            Grilla.getColumnModel().getColumn(1).setPreferredWidth(140);//Fono
            Grilla.getColumnModel().getColumn(2).setPreferredWidth(130);//Celular
            Grilla.getColumnModel().getColumn(3).setPreferredWidth(150);//email
            Grilla.getColumnModel().getColumn(5).setPreferredWidth(150);//cargo
            
            
        } catch (Exception e) {
        }
    }
//-----------------------------------------------------------------------------
//  CARGA DATOS CODIGO ORDENES DE COMPRA
//-----------------------------------------------------------------------------
    private void cbCodigoOcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCodigoOcActionPerformed
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        try{
          if(txRut.getText().isEmpty()) return;
           

           Rs = Sql.Select("select giro,direccion,ciudad,comuna,region,vendedorluv\n" +
                            "from clicontacto\n" +
                            "where rut=" + txRut.getText() +
                            " and codigo_oc=" + cbCodigoOc.getSelectedItem().toString());
            //Rs.next();
            //if(Rs.getRow()>0){
            if(Sql.GetRowCount()>0){    
                
                Rs.next();
                
                txGiro.setText(Rs.getString("giro").trim());
                txDireccion.setText(Rs.getString("direccion").trim());
                
//                txCiudad.setSelectedItem(Rs.getString("ciudad").trim());
                txtCiudad.setText(Rs.getString("ciudad").trim());  //nuevo campo
                
//                txComuna.setSelectedItem(Rs.getString("comuna").trim());
                txtComuna.setText(Rs.getString("comuna").trim());  //nuevo campo
                 
                
                CargaPersonas(txRut.getText(),cbCodigoOc.getSelectedItem().toString());
                CargaOrdenes(txRut.getText(),cbCodigoOc.getSelectedItem().toString());
                
                
                                              
                if (Rs.getInt("vendedorluv") < 0){
                
                    cbVendedor.setSelectedIndex(0);
                
                }else{
                
                    
                
                    int index = 0;
                    for(int v = 0; v < cbCodigoVendedor.getItemCount(); v++){
                        
                        if(cbCodigoVendedor.getItemAt(v).equals(Rs.getString("vendedorluv"))){
                            index = v;
                            //break;
                        }
                    }
                    cbVendedor.setSelectedIndex(index);
                }
                
                int index2 = 0;
                
                for(int i=0 ; i < cbRegion.getItemCount();i++){

                    cbRegion.setSelectedIndex(i);
                    
                    if(cbId_Accion(cbRegion)==Rs.getInt("region") ){
                        
                        index2 = i;
                        break; 
                    }
                }
                
                 cbRegion.setSelectedIndex(index2);

                
                
              
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
             Logger.getLogger(pfClientes.class.getName()).log(Level.SEVERE, null, e);

       }
       finally {
           Sql.Close();
       }
        CargaPersonas(txRut.getText(),cbCodigoOc.getSelectedItem().toString());
        CargaOrdenes(txRut.getText(),cbCodigoOc.getSelectedItem().toString());
    }//GEN-LAST:event_cbCodigoOcActionPerformed

    private void txRutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRutKeyPressed
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER && Tipo==1){
            txDv.requestFocus();
        }
        else if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btIr.doClick();
        }
    }//GEN-LAST:event_txRutKeyPressed

    private void btNuevoOCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNuevoOCActionPerformed
        
        System.out.println("EL ESTADO ES :"+Estado);
        
        
        if(Estado==true){
            String Codigo_oc = JOptionPane.showInputDialog("Ingrese Nuevo código de Orden de compra");
            try {

                  Integer.valueOf(Codigo_oc);
                  cbCodigoOc.addItem(Codigo_oc);
                  EdicionOC(true);

                  cbCodigoOc.setSelectedIndex(cbCodigoOc.getItemCount()-1);


                  txGiro.setText("");
                  txDireccion.setText("");
                  
                  //txCiudad.setSelectedItem("");
                  txtCiudad.setText("");
                  
                  //txComuna.setSelectedItem("");
                  txtComuna.setText("");
                  
                  cbRegion.setSelectedIndex(-1);
                  fmMain.LimpiaGrilla((DefaultTableModel)Grilla.getModel());
                  btNuevoOC.setEnabled(false);
                  btGuardarOC.setEnabled(true);
                  btCancelarOC.setEnabled(true);
                  btEditarOc.setEnabled(true);
                  cbCodigoOc.setEnabled(false);
                  TipoOC="Nuevo";
                  txGiro.requestFocus();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e);
            }
        }
        else {
            String rut = txRut.getText().substring(0, 5);
            String dv = "";
            if(txDv.getText().equals("K")){
                dv = "0";
            }
            else {
                dv = txDv.getText();
            }
            String final_text = rut+dv;
            Integer.valueOf(final_text);
            cbCodigoOc.addItem(final_text);
            EdicionOC(true);
            cbCodigoOc.setSelectedIndex(cbCodigoOc.getItemCount()-1);
            txGiro.setText("");
            txDireccion.setText("");
            
//            txCiudad.setSelectedItem("");
            txtCiudad.setText("");
            
//            txComuna.setSelectedItem("");
            txtComuna.setText("");
            
            cbRegion.setSelectedIndex(-1);
            fmMain.LimpiaGrilla((DefaultTableModel)Grilla.getModel());
            btNuevoOC.setEnabled(false);
            btGuardarOC.setEnabled(true);
            btCancelarOC.setEnabled(true);
            btEditarOc.setEnabled(true);
            cbCodigoOc.setEnabled(false);
            TipoOC="Nuevo";
            txGiro.requestFocus();
        }
        
        
    }//GEN-LAST:event_btNuevoOCActionPerformed

    private void txRutKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRutKeyTyped
        
        if(txRut.getText().length()>7) {
            evt.consume();
        }
        if(evt.getKeyChar() < '0' || evt.getKeyChar() > '9' ){
            evt.consume();
        }
        
    }//GEN-LAST:event_txRutKeyTyped

    private void btIrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIrActionPerformed
        
        if(!txRut.getText().isEmpty())
            CargaCliente(txRut.getText());
        else{
            jdBuscarCliPrv BPC = new jdBuscarCliPrv(null, true);
            BPC.setLocationRelativeTo(null);
            BPC.setTitle("Buscar Cliente");
            BPC.SetTipo(1);
            BPC.setVisible(true);
            CargaCliente(BPC.GetRut());
        }
    }//GEN-LAST:event_btIrActionPerformed

    private void txGiroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txGiroKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txDireccion.requestFocus();
        }
    }//GEN-LAST:event_txGiroKeyPressed

    private void txDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txDireccionKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
           // txCiudad.requestFocus();
            txtCiudad.requestFocus();
        }
    }//GEN-LAST:event_txDireccionKeyPressed

    private void txDvKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txDvKeyPressed
//        if(evt.getKeyChar() < '0' || evt.getKeyChar() > '9'  || evt.getKeyChar() != KeyEvent.VK_K){
//            evt.consume();
//        }
        if(evt.getKeyCode() == KeyEvent.VK_ENTER && Tipo==1 ){
            txNombre.requestFocus();
        }
        if(txDv.getText().length()>0) {

            evt.consume();
            txDv.setText(txDv.getText().substring(0, 0));
        }
        System.out.println(evt.getKeyChar());
        
        String[] valid = {"1","2","3","4","5","6","7","8","9","0","k","K"};
        String value = String.valueOf(evt.getKeyChar());
        boolean found = false;
        for(int i = 0 ; i < valid.length; i ++){
            if(valid[i].equals(value)){
                System.out.println("DV Encontrado");
                found = true;
                break;
            }
            else {
                found = false;
            }  
        }
        if(found==false){
            System.out.println("DV No Válido");
            JOptionPane.showMessageDialog(pnMenu,"Debe ingresar un DV válido.");   
        }
        else {
            System.out.println("DV Válido");
        }
    }//GEN-LAST:event_txDvKeyPressed

    private void btAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarActionPerformed
       
        jdAddDatosPersona PrvCon = new jdAddDatosPersona(null, true);
        PrvCon.setLocationRelativeTo(null);
        PrvCon.setTitle("Nuevo Contacto");
        PrvCon.ConTipo("cliente");
        PrvCon.Nuevo(1, Integer.valueOf(txRut.getText()),Integer.valueOf(cbCodigoOc.getSelectedItem().toString()) );
        PrvCon.setVisible(true);
        CargaPersonas(txRut.getText(),cbCodigoOc.getSelectedItem().toString());

//DefaultTableModel tbModel = (DefaultTableModel) Grilla.getModel();

//        jdAddDatosPersona PrvCon = new jdAddDatosPersona(null, true);
//        PrvCon.setLocationRelativeTo(null);
//        PrvCon.setTitle("Nuevo Contacto");
//        PrvCon.ConTipo("cliente");
//        PrvCon.setVisible(true);
//        try {
//            tbModel.addRow(PrvCon.GetFila());
//        } catch (Exception e) {
//            System.out.println(e);
//        }
        
    }//GEN-LAST:event_btAgregarActionPerformed

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
      ExeSql  Sql = new ExeSql();
      String Query;   
        
        
        if(!Grilla.getValueAt(Grilla.getSelectedRow(), 0).toString().isEmpty())
        
        if(JOptionPane.showConfirmDialog(null, "¿Desea Eliminar el Contacto?") == JOptionPane.YES_OPTION){
            
            Eliminados=Eliminados + Grilla.getValueAt(Grilla.getSelectedRow(), 4).toString() + "@";
            EliminadosCont++;
            
            try
            {    
            
                Query = "delete from clicontactopersonas where id = " + Grilla.getValueAt(Grilla.getSelectedRow(), 4).toString();
                Sql.ExeSql(Query);
                Sql.Commit();
            } catch (Exception e) {
            
                Sql.Rollback();
                JOptionPane.showMessageDialog(null,"Error: " +e.getMessage() );
            
            }finally{
            
                Sql.Close();
            }
            
            DefaultTableModel tbMd = (DefaultTableModel) Grilla.getModel();
            tbMd.removeRow(Grilla.getSelectedRow());
            
            
            
            
        }
    }//GEN-LAST:event_btEliminarActionPerformed

    private void cbRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRegionActionPerformed
//        if(Tipo==2 && !TipoOC.equals("Editar"))
//            cbRegion.setSelectedIndex(PosRegion);
    }//GEN-LAST:event_cbRegionActionPerformed

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed

        ExeSql  Sql = new ExeSql();
        String Query;
        String QueryDet;
        String Nombre       = txNombre.getText();
        String Giro         = txGiro.getText();
        String Direccion    = txDireccion.getText();
//        String Ciudad       = txCiudad.getSelectedItem().toString().trim();
        String Ciudad       = txtCiudad.getText().toString().trim();
                
//        String Comuna       = txComuna.getSelectedItem().toString().trim();
        String Comuna       = txtComuna.getText().toString().trim();
        
        boolean estado      = chkclienteestado.isSelected();
        String Region;
        try {   Region  = String.valueOf(cbId_Accion(cbRegion)); }
        catch (Exception e) { Region = "0";            }
        if(Nombre.isEmpty())    Nombre=" ";
        if(Giro.isEmpty())      Giro=" ";
        if(Direccion.isEmpty()) Direccion=" ";
        if(Ciudad.isEmpty())    Ciudad=" ";
        if(Comuna.isEmpty())    Comuna=" ";

        if(JOptionPane.showConfirmDialog(null, "¿Guardar los cambios realizados?")==JOptionPane.YES_OPTION){
            
            PosRegion = cbRegion.getSelectedIndex();
            //Nuevo Cliente
            if(Tipo==1){
                try {
                    //Cliente
                    Query =  "INSERT INTO cliente \n" +
                             "(rut,dv,nombre, cliente_estado, usuario_modifica) \n" +
                             "values \n" +
                             "(" +
                                txRut.getText() + ",'" +
                                txDv.getText() + "','" +
                                Nombre + "',"+estado+",'"+fmMain.GetUsuario().trim().toLowerCase()+
                              "')";
                    
                    System.out.println(Query);
                    
                    Sql.ExeSql(Query);
                    Sql.Commit();
                    
                    JOptionPane.showMessageDialog(null, "Guardado");
                    SetTipo(2);
                } catch (Exception e) {
                    Sql.Rollback();
                    JOptionPane.showMessageDialog(null,"Error: " +e.getMessage() );
                }finally{
                    Sql.Close();
                }
            
            }else{
                try {
                    System.out.println("--------- UPDATE --------");
                    //Cliente
                    Query = "UPDATE cliente SET \n" +
                            "Nombre='" + txNombre.getText().trim() + "', cliente_estado = "+estado+", \n"+
                            "usuario_modifica ='"+fmMain.GetUsuario().trim().toLowerCase() +"' \n" +
                            "WHERE rut=" + txRut.getText();
                    System.out.println(Query);
                    Sql.ExeSql(Query);


                    Sql.Commit();
                    JOptionPane.showMessageDialog(null, "Guardado");
                    SetTipo(2);
                } catch (Exception e) {
                    Sql.Rollback();
                    JOptionPane.showMessageDialog(null,"Error:" + e.getMessage());
                }finally{
                    Sql.Close();
                }
                    
            }
        }

    }//GEN-LAST:event_btGuardarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        
        if(fmMain.GetEstado(fmMain.pnPestanas.getSelectedIndex())==1){
        
            if(JOptionPane.showConfirmDialog(null, "¿Cancelar sin guardar?")==JOptionPane.YES_OPTION){
            
                if(Tipo==1){
                
                    SetTipo(-1);
                    EdicionOC(false);
                
                }else{
                
                    CargaCliente(txRut.getText());
                    EdicionOC(false);
                }
            }
        
        }else{
        
            SetTipo(-1);
            EdicionOC(false);
        }
        
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNuevoActionPerformed
        if(fmMain.GetEstado(fmMain.pnPestanas.getSelectedIndex())==0){
            SetTipo(1);
        }
        else{
            Limpia();
        }
    }//GEN-LAST:event_btNuevoActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        SetTipo(3);
        btNuevoOC.setEnabled(true);
    }//GEN-LAST:event_btEditarActionPerformed

    private void txDvFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txDvFocusLost
        if(txDv.getText().equals("k"))
            txDv.setText("K");
    }//GEN-LAST:event_txDvFocusLost

    private void btEditarOcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarOcActionPerformed
              btNuevoOC.setEnabled(false);
              btGuardarOC.setEnabled(true);
              btCancelarOC.setEnabled(true);
              btEditarOc.setEnabled(true);
              cbCodigoOc.setEnabled(false);
              TipoOC="Editar";
              
              EdicionOC(true);
              txGiro.requestFocus();
              
              
    }//GEN-LAST:event_btEditarOcActionPerformed

    private void btGuardarOCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarOCActionPerformed
        ExeSql  Sql = new ExeSql();
        ExeSql Rs = new ExeSql();
        String Query;
        String Region;
        try {   Region  = String.valueOf(cbId_Accion(cbRegion)); }
        catch (Exception e) { Region = "0";   
        }

        try {
            
            //Elimino el Codigo
            Sql.ExeSql("DELETE FROM clicontacto WHERE rut=" + txRut.getText().trim() + 
                       " and codigo_oc=" + cbCodigoOc.getSelectedItem().toString().trim());
            //010803001
            //Agrego el Codigo
            Sql.ExeSql(" INSERT INTO clicontacto(\n" +
                    " rut, codigo_oc, giro, direccion, comuna, ciudad, region, vendedorluv )\n" +
                    " VALUES (" +
                    txRut.getText() + "," +
                    cbCodigoOc.getSelectedItem().toString() + "," +
                    fmMain.SetString(txGiro.getText()) + "," +
                    fmMain.SetString(txDireccion.getText()) + "," +
                    //fmMain.SetString(txComuna.getSelectedItem().toString().trim()) + "," +
                    fmMain.SetString(txtComuna.getText().toString().trim()) + "," +
                  //  fmMain.SetString(txCiudad.getSelectedItem().toString().trim()) + "," +
                    fmMain.SetString(txtCiudad.getText().toString().trim()) + "," +
                    Region +","+cbCodigoVendedor.getSelectedItem()+ ")");

        Sql.Commit();
        TipoOC = "";
        
        
        ActualizaVendedorAsociado(txRut.getText().trim(), cbCodigoOc.getSelectedItem().toString().trim(),cbCodigoVendedor.getSelectedItem().toString().trim());
        
        
        
        } catch (Exception e) {
            Sql.Rollback();
            System.out.println(e);
        }finally{
            Sql.Close();
            if(Estado=false){
                btNuevoOC.setEnabled(false);
            }
        }
                

        SetTipo(2);
        EdicionOC(false);    
        
            
    }//GEN-LAST:event_btGuardarOCActionPerformed

    
    private void ActualizaVendedorAsociado(String rut, String codigo_oc,String IdVendedor){
        
        ExeSql Sql = new ExeSql();
        ExeSql Sql2 = new ExeSql();
    
        ResultSet Rs;
    
        String Vendedor = "";
       
                
       
       
            try {
                      
                    Rs = Sql.Select("select cta.vendedorluv,\n"+
                                    "case when p.vendedor is null then 0 else p.vendedor end as vendedor, \n"+
                                    "cta.codigo_oc, \n"+
                                    "case when p.nombre is null then ' ' else p.nombre end as nombre, \n"+
                                    "case when p.apellidopaterno is null then ' ' else p.apellidopaterno end as apellido, \n"+
                                    "case when p.apellidomaterno is null then ' ' else p.apellidomaterno end as apellido2, \n"+
                                    "case when cta.rut is null then 0 else cta.rut end as rut \n"+
                                    "from clicontacto cta\n" +
                                    "left join personal p on cta.vendedorluv = p.vendedor\n" +
                                    "where cta.codigo_oc > 1  and cta.codigo_oc = "+codigo_oc+" and cta.rut = "+rut);
                        
                 
                    if (Sql.GetRowCount() > 0){
                     
                            Rs.next();
                     
                            if (!Rs.getString("apellido").trim().isEmpty()){
                                
                                String[] Nombre = Rs.getString("nombre").split(" ");
                            
                                Vendedor = Nombre[0]+" "+Rs.getString("apellido")+" "+Rs.getString("apellido2");
                            
                            }else{
                            
                                Vendedor = " ";
                            }
                                   
                     
                    } else {
                     
                     
                            Vendedor = " "; 
                            
                    }
            
                    
                    Sql2.ExeSql("UPDATE compraagil SET \n" +
                                 "idvendedor=" + IdVendedor.trim() + ", \n" +
                                 "vendedor='" + Vendedor.trim() + "' \n" +
                                 "WHERE codigo_oc=" + codigo_oc.trim());
            
            
                    Sql2.Commit();
                    
                 
             } catch (SQLException ex) {
                 Logger.getLogger(pfClientes.class.getName()).log(Level.SEVERE, null, ex);
             }
       
    
    }
    
    
    private void btCancelarOCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarOCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btCancelarOCActionPerformed

    private void txNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNombreKeyTyped
        if (Character.isLowerCase(evt.getKeyChar()))
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
    }//GEN-LAST:event_txNombreKeyTyped

    private void txGiroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txGiroKeyTyped
        if (Character.isLowerCase(evt.getKeyChar()))
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
    }//GEN-LAST:event_txGiroKeyTyped

    private void txDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txDireccionKeyTyped
        if (Character.isLowerCase(evt.getKeyChar()))
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));        // TODO add your handling code here:
    }//GEN-LAST:event_txDireccionKeyTyped

    private void GrillaOCCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_GrillaOCCFocusGained
        
    }//GEN-LAST:event_GrillaOCCFocusGained

    private void GrillaOCCHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_GrillaOCCHierarchyChanged
          // TODO add your handling code here:
    }//GEN-LAST:event_GrillaOCCHierarchyChanged

    private void GrillaOCCCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_GrillaOCCCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_GrillaOCCCaretPositionChanged

    private void btEditarContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarContactoActionPerformed
        jdAddDatosPersona PrvCon = new jdAddDatosPersona(null, true);
        PrvCon.setLocationRelativeTo(null);
        PrvCon.setTitle("Editar Contacto");
        PrvCon.ConTipo("cliente");
        PrvCon.Editar(1, Grilla.getValueAt(Grilla.getSelectedRow(), 0).toString().trim(), 
                         Grilla.getValueAt(Grilla.getSelectedRow(), 1).toString().trim(),
                         Grilla.getValueAt(Grilla.getSelectedRow(), 2).toString().trim(),
                         Grilla.getValueAt(Grilla.getSelectedRow(), 3).toString().trim(),
                         Integer.valueOf(Grilla.getValueAt(Grilla.getSelectedRow(), 4).toString().trim()),
                         Grilla.getValueAt(Grilla.getSelectedRow(), 5).toString().trim()
        );
        PrvCon.setVisible(true);
        CargaPersonas(txRut.getText(),cbCodigoOc.getSelectedItem().toString());
        

    }//GEN-LAST:event_btEditarContactoActionPerformed

    private void MnuCopiaCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuCopiaCorreoActionPerformed
        // TODO add your handling code here:
          StringSelection Transporte = new StringSelection(Grilla.getValueAt(Grilla.getSelectedRow(), 3).toString().trim());
         Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
         cb.setContents(Transporte, null);
    }//GEN-LAST:event_MnuCopiaCorreoActionPerformed

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

    private void cbVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbVendedorActionPerformed

       cbCodigoVendedor.setSelectedIndex(cbVendedor.getSelectedIndex());
       
    }//GEN-LAST:event_cbVendedorActionPerformed

    private void cbCodigoVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCodigoVendedorActionPerformed
       
        //cbVendedor.setSelectedIndex(cbCodigoVendedor.getSelectedIndex());
    }//GEN-LAST:event_cbCodigoVendedorActionPerformed

    private void chkVentaEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkVentaEmpresaActionPerformed
        
        ExeSql Sql = new ExeSql();
        String Rut = txRut.getText().trim();
        ResultSet Rs = null;
        
        int ventaemp = 0;
        
        
        if(Rut.trim().equals("")){
            JOptionPane.showMessageDialog(pnMenu, "Debe cargar un Cliente!!");
            chkVentaEmpresa.setSelected(false);
            return;
        }
        
        
        try {  
                
                
                Rs = Sql.Select("SELECT * FROM cliente WHERE rut = "+Rut);
                
                
                if(Sql.GetRowCount()> 0){
                    Rs.next();
                     
                    
                    if(chkVentaEmpresa.isSelected()){
                    
                        
                        ventaemp = 1;
                    
                    }else if(!chkVentaEmpresa.isSelected()){
                    
                        ventaemp = 0;
                    
                    }
                    
                    
                    
                    int resultado = Sql.ExeSqlInt("UPDATE cliente set ventaempresa = "+ventaemp+" \n"+
                                                  "WHERE rut = "+Rut);
                    Sql.Commit();
                        
                    if(resultado > 0){
                         
                        if (ventaemp == 1){
                        
                        JOptionPane.showMessageDialog(pnMenu, "Habilitado Venta Empresa"); 
                        
                        }else if (ventaemp == 0){
                        
                            JOptionPane.showMessageDialog(pnMenu, "Deshabilitado Venta Empresa"); 
                                               
                        }
                        
                        
                        
                    }else {
                           
                        JOptionPane.showMessageDialog(pnMenu, "No se cambió estado");
                    }
                    
                   
                }else {
                    JOptionPane.showMessageDialog(pnMenu, "No existe Cliente!! ");
                }
                
              
                
        } catch (SQLException ex) {
            
            Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
            
        }finally {
             
            Sql.Close();
        }
        
        
        
        
        
    }//GEN-LAST:event_chkVentaEmpresaActionPerformed

    private void chkclienteestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkclienteestadoActionPerformed
        
        if (chkclienteestado.isSelected()){
        
            Estado = true;
        
        }else if (!chkclienteestado.isSelected()){
        
            Estado = false;
        
        }
        
    }//GEN-LAST:event_chkclienteestadoActionPerformed

    
    
    public void CargaVendedor() {
        ExeSql Sql= new ExeSql();
        ResultSet Rs;
           
        try{
            cbVendedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
            cbCodigoVendedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
            
            cbCodigoVendedor.addItem("0");
            cbVendedor.addItem("Seleccione Vendedor");
           
            Rs = Sql.Select("SELECT nombre,\n"+
                            "case when apellidopaterno is null then ' ' else apellidopaterno end as apellido, \n"+
                            "case when apellidomaterno is null then ' ' else apellidomaterno end as apellido2, \n"+
                            "vendedor\n" +
                            "FROM personal\n" +
                            "WHERE tipo_vendedor IN (0,1) and activo = true and vendedor is not null ORDER BY vendedor asc ");
               
            while( Rs.next()){
                
                
                String[] Nombre = Rs.getString("nombre").split(" ");
                            
                String Vendedor = Nombre[0]+" "+Rs.getString("apellido")+" "+Rs.getString("apellido2");
                
                cbVendedor.addItem(Vendedor);
                cbCodigoVendedor.addItem(String.valueOf(Rs.getInt("vendedor")));
            }
            
        }catch (Exception e){
                System.out.println(e.getMessage());
                fmMain.Mensaje("Error: "  + e);
        }finally{
                Sql.Close();
        }

    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Grilla;
    private javax.swing.JTable GrillaDoc;
    private javax.swing.JTable GrillaOCC;
    private javax.swing.JTable GrillaProductos;
    private javax.swing.JMenuItem MnuCopiaCorreo;
    private javax.swing.JButton btAgregar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btCancelarOC;
    private javax.swing.JButton btCiudad;
    private javax.swing.JButton btComuna;
    public javax.swing.JButton btEditar;
    private javax.swing.JButton btEditarContacto;
    private javax.swing.JButton btEditarOc;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btGuardarOC;
    public static javax.swing.JButton btIr;
    private javax.swing.JButton btNuevo;
    public javax.swing.JButton btNuevoOC;
    public javax.swing.JComboBox cbCodigoOc;
    private javax.swing.JComboBox<String> cbCodigoVendedor;
    private javax.swing.JComboBox cbRegion;
    private javax.swing.JComboBox cbVendedor;
    private javax.swing.JCheckBox chkVentaEmpresa;
    public javax.swing.JCheckBox chkclienteestado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private javax.swing.JPanel pnCentral;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JComboBox<String> txCiudad;
    private javax.swing.JComboBox<String> txComuna;
    private javax.swing.JTextField txDireccion;
    private javax.swing.JTextField txDv;
    private javax.swing.JTextField txGiro;
    private javax.swing.JTextField txNombre;
    public static javax.swing.JTextField txRut;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtComuna;
    // End of variables declaration//GEN-END:variables
}
