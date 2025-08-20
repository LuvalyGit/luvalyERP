package PanelForm;
import Conexion.Econa.ExeSql_Econa;
import java.sql.ResultSet;
import java.sql.SQLException;
import Conexion.ExeSql;
import Dialogos.jdAgregaIDCH;
import Dialogos.jdAgregaIDCH_Econa;
import Dialogos.jdBuscarProductos;
import Dialogos.jdBuscarProductos_Econa;
import Dialogos.jdVoucher;
import Dialogos.jd_UbicacionProductos;
import java.security.Principal;
import Dialogos.jd_UbicacionesP;
import Dialogos.jd_UbicacionesP_Econa;
import Formularios.fmMain;
import static Formularios.fmMain.pnPestanas;
import Utilidades.ComboCodigos;
import Utilidades.Ftp;
import Utilidades.PanelTab;
import Utilidades.SubeFTP;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter.Entry;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author DavidAlcaman
 */
public class pfProductos_Econa extends javax.swing.JPanel {
    
    
    int PosUM;
    int PosLinea;
    int PosSubLinea;
    int PosImpuesto;
    int PosMarca;
    int PosConvenio;
    boolean IVA;
     FileInputStream fis;
    int longitudBytes;
    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
    int Tipo=-1; //-1 Nada de nada      1 Nuevo      2 Abierto      3.Editando
     public int guardo=0;
    
    public pfProductos_Econa() {
        initComponents();
        txSku.requestFocus();
        Tipo=-99;
        CargaUnidades();
        CargaLineas();
        CargaConvenios();
//        CargaMarcas();
        CargaOtrosImpuestos();
         btCargarImagen.setVisible(false);
        int intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if  (intNivelUsuario==100) {       
                  btCargarImagen.setVisible(true);
        }
        //btCargarImagen.setVisible(false);
        Tipo=0;
        cbConvenio.setSelectedIndex(-1);
        cbFamilia.setSelectedIndex(-1);
        cbUnidad.setSelectedIndex(-1);
        Tipo=-1;
        Edicion(false);
        Habilita(false);
        
        cbConvenioCod.setVisible(false);
        cbFamiliaCod.setVisible(false);
        cbSubFamiliaCod.setVisible(false);
        cbConvenioSku.setVisible(false);
        cbFamiliaSku.setVisible(false);
        cbSubFamiliaSku.setVisible(false);
        cbUnidadId.setVisible(false);
        cbOtroImpuestoId.setVisible(false);
        cbOtroImpuestoTaza.setVisible(false);
        chkOferta.setEnabled(false);
        txUbicados.setEnabled(false);
        txTransito.setEnabled(false);
        lsCodbar.setVisible(false);
        lsChilecompras.setVisible(false);
        btUbica.setEnabled(false);
        txMinimo.setEnabled(false);
        txMinimo.setEditable(false);
        txPosicion.setEditable(false);
        txNuevoMinimo.setVisible(false);
        btGuardarMinimo.setVisible(false);
        lbNuevoMinimo.setVisible(false);
        txPosicion.setEditable(false);
        txPosicion.setEnabled(false);
        chkIva.setEnabled(false);
        chk_minimo.setVisible(false);
        
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        GrillaMovimientos.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
        GrillaMovimientos.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
        GrillaMovimientos.getColumnModel().getColumn(7).setCellRenderer(rightRenderer);
        
        GrillaVenta.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
        GrillaVenta.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
        GrillaVenta.getColumnModel().getColumn(7).setCellRenderer(rightRenderer);
        
        GrillaCompras.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        GrillaCompras.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
        GrillaCompras.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
        GrillaCompras.getColumnModel().getColumn(7).setCellRenderer(rightRenderer);
        GrillaCompras.getColumnModel().getColumn(8).setCellRenderer(rightRenderer);
        
        lsChilecompras.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent mouseEvent){
                String value = (String)lsChilecompras.getModel().getElementAt(lsChilecompras.locationToIndex(mouseEvent.getPoint()));
                ejecutarPosicion(value);  
            }
    
    
        });
        
        
        
        
        Tipo=0;
        PosImpuesto=-1;
        
        
        //        Enlaza OC con sus Facturas, Notas de creditos y Guias asiociadas
        GrillaCompras.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        @Override
       public void valueChanged(ListSelectionEvent e){
           if (GrillaFacturasC.getSelectedRowCount()>=0)
               
               carga_facturas_orden(GrillaCompras.getValueAt(GrillaCompras.getSelectedRow(), 3).toString().trim());
       } 
    });   
 
        
       
        
    }

    @SuppressWarnings("unchecked")
   private int BooleanToInt(boolean Input){
       if(Input==true)return 1;
       else           return 0;
   }
    private String ElTrim(String Texto)   {
    try {
        return Texto.trim();
    } catch (Exception e) {
        return Texto;
    }
}
//--------------------------------------------------------------------------------
// Funcion SET DE TIPOS
//--------------------------------------------------------------------------------
    
    void ejecutarPosicion (String valor_idch) {
        int index = lsChilecompras.getSelectedIndex();
        System.out.println("Index Selected: " + index);
        String s = (String) lsChilecompras.getSelectedValue();
        ResultSet Rs;
        String upOfer;
        ExeSql_Econa Sql = new ExeSql_Econa();
        String Query;
        Query = "  SELECT DISTINCT ON (pp.id) \n" +
                    "  p.convenio,\n" +
                    "  pp.posicion as pos,\n" +
                    "  p.sku,   pp.id as chilecodigo ,p.oferta_inicio, p.oferta_fin, \n" +
                    "  p.nombre nombre,\n" +
                    "  p.rutultprv,\n" +
                    "  pr.nombre nombre_proveedor,\n" +
                    "  CASE p.sinstock\n" +
                    "      WHEN TRUE THEN  'SI' \n" +
                    "      WHEN FALSE THEN  'NO'\n" +
                    "    END sinstock,\n" +
                    "    CASE   p.discontinuado\n" +
                    "      WHEN TRUE THEN  'SI' \n" +
                    "      WHEN FALSE THEN  'NO'\n" +
                    "    END discontinuado,\n" +
                    "  CASE  p.oferta\n" +
                    "      WHEN TRUE THEN  'SI' \n" +
                    "      WHEN FALSE THEN  'NO'\n" +
                    "    END oferta,\n" +
                    "  CASE  p.publicado\n" +
                    "      WHEN TRUE THEN  'SI' \n" +
                    "      WHEN FALSE THEN  'NO'\n" +
                    "    END publicado, \n" +
                    "  CASE  p.sincompetencia\n" +
                    "      WHEN TRUE THEN  'SI' \n" +
                    "      WHEN FALSE THEN  'NO'\n" +
                    "    END sincompetencia , pp.precio_primero,\n" +
                    "        CASE \n" +
                    "          WHEN pp.precio_primero IS NULL THEN null\n" +
                    "          WHEN  pp.precio_primero=0  THEN 0\n" +
                    "          else  \n" +
                    "          	   ((pp.precio_primero - p.costofinal)/pp.precio_primero)*100\n" +
                    "        END margen , p.costofinal \n" +
                    " FROM\n" +
                    "  public.producto p\n" +
                    "left join codchile cc on cc.sku = p.sku\n" +
                    "left join par_convenio pc on p.convenio = pc.codigo\n" +
                    "left join proveedor pr on  pr.rut = p.rutultprv  \n" +
                    "left join producto_posicion pp \n" +
                    "      	on pp.sku = p.sku\n" +
                    "        and pp.convenio = p.convenio\n" +
                    "where pp.sku = '"+txSku.getText()+"' and pp.id = '"+lsChilecompras.getSelectedValue()+"'";
          try {


                Rs = Sql.Select(Query);
                for(int i =0; Rs.next();i++){
                    txPosicion.setText(Rs.getString("pos"));
                }

                

          } catch (SQLException ex) {
              Logger.getLogger(pfProductos_Econa.class.getName()).log(Level.SEVERE, null, ex);
          }
   
    }

    private void SetTipo(int ElTipo){
        //Nada
        if(ElTipo==-1){
            fmMain.SetEstado(fmMain.pnPestanas.getSelectedIndex(),0);
            Tipo=-1;         
            Limpia();
            Habilita(false);
            Edicion(false);
            txSku.setEnabled(true);
            txSku.setEditable(true);
            btIr.setEnabled(true);
            txSku.requestFocus();
            btCancelar.setEnabled(false);
            btGuardar.setEnabled(false);
            btNuevo.setEnabled(true);
            btEditar.setEnabled(false);
            txSku.requestFocus();
            chkOferta.setSelected(false);
            btGuardarOfer.setEnabled(false);
            dtInicioOfer.setEnabled(false);
            dtFinOfer.setEnabled(false);
            txUbicados.setEnabled(false);
            txTransito.setEnabled(false);
            lsCodbar.setVisible(false);
            lsChilecompras.setVisible(false);
            btUbica.setEnabled(false);
            txMinimo.setEnabled(false);
            txMinimo.setEditable(false);
            txNuevoMinimo.setVisible(false);
            chk_minimo.setVisible(false);
            btGuardarMinimo.setVisible(false);
            lbNuevoMinimo.setVisible(false);
            txPosicion.setEnabled(false);
            txPosicion.setEditable(false);
            chkIva.setEnabled(false);
            lbImagen.setIcon(null);

        }
        //Nuevo Producto
        else if(ElTipo==1){
            Tipo=1;
            fmMain.SetEstado(fmMain.pnPestanas.getSelectedIndex(),1);
            btGuardar.setEnabled(true);
            btCancelar.setEnabled(true);
            btEditar.setEnabled(false);
            btNuevo.setEnabled(false);
            Habilita(true);
            Edicion(true);
            Limpia();
            txSku.setEditable(false);
            txNombre.requestFocus();
            Tipo=1;
//            btUbica.setEnabled(true);
//            txUbicados.setEnabled(true);
//            txTransito.setEnabled(true);
//            lsCodbar.setVisible(true);
//            lsChilecompras.setVisible(true);
//            txUbicados.setEditable(false);
//            btUbica.setEnabled(false);
            chkIva.setEnabled(true);
        }
        //Abre Producto
        else if (ElTipo==2){
            fmMain.SetEstado(fmMain.pnPestanas.getSelectedIndex(),0);
            btEditar.setEnabled(true);
            btNuevo.setEnabled(true);
            btGuardar.setEnabled(false);
            btCancelar.setEnabled(false);
//            btEliminar.setEnabled(true);
            Habilita(true);
            Edicion(false);
            txSku.setEditable(true);
            Tipo=2;
//            btUbica.setEnabled(false);
        }
        // Edita Producto 
        else if(ElTipo==3){
            
            fmMain.SetEstado(fmMain.pnPestanas.getSelectedIndex(),1);
            Habilita(true);
            Edicion(true);
//            txUbicados.setEditable(true);
//            btUbica.setEnabled(false);
            
//            ComboCodigos cbAux = (ComboCodigos) cbUnidad.getSelectedItem();
//            
//            cbUnidad.setModel(cbmUnidad);
//            cbUnidad.setSelectedItem(AuxUnidad);
            btGuardar.setEnabled(true);
            btCancelar.setEnabled(true);
            btNuevo.setEnabled(false);
            txSku.setEditable(false);
            Tipo=3;
            btUbica.setEnabled(true);
            
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btGroupMovimientos = new javax.swing.ButtonGroup();
        btGroupProveedor = new javax.swing.ButtonGroup();
        MnuOCC = new javax.swing.JPopupMenu();
        MnuAbrirOCC = new javax.swing.JMenuItem();
        MnuCopia_OC = new javax.swing.JMenuItem();
        MnuOCP = new javax.swing.JPopupMenu();
        MnuAbrirOCP = new javax.swing.JMenuItem();
        pnMenu = new javax.swing.JPanel();
        btNuevo = new javax.swing.JButton();
        btGuardar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        btCargarImagen = new javax.swing.JButton();
        pnDetalle = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btIr = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txNombre = new javax.swing.JTextField();
        txSku = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        chkCodigo = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        txPeso = new javax.swing.JTextField();
        cbUnidad = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbSubFamilia = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        cbFamilia = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        cbConvenio = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        chkIva = new javax.swing.JCheckBox();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        cbOtroImpuesto = new javax.swing.JComboBox();
        txTazaImpuesto = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        lsCodbar = new javax.swing.JList();
        jScrollPane6 = new javax.swing.JScrollPane();
        lsChilecompras = new javax.swing.JList<>();
        btAgregaID = new javax.swing.JButton();
        btEliminaID = new javax.swing.JButton();
        Pestanas = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txPPublico = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txPNeto = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txPCosto = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txTransporte = new javax.swing.JTextField();
        txMargen = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txPUltCompra = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txMinimo = new javax.swing.JTextField();
        lbNuevoMinimo = new javax.swing.JLabel();
        txNuevoMinimo = new javax.swing.JTextField();
        btGuardarMinimo = new javax.swing.JButton();
        chk_minimo = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        txStockInv = new javax.swing.JTextField();
        txStockOCP = new javax.swing.JTextField();
        txStockOCC = new javax.swing.JTextField();
        txStockGDC = new javax.swing.JTextField();
        txStockTotal = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txSeparado = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txTransito = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txUbicados = new javax.swing.JTextField();
        btUbica = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        chkPublicado = new javax.swing.JCheckBox();
        jLabel24 = new javax.swing.JLabel();
        txDisplay = new javax.swing.JTextField();
        chkStock = new javax.swing.JCheckBox();
        chkDiscontinuado = new javax.swing.JCheckBox();
        chkSinCompetencia = new javax.swing.JCheckBox();
        chkNoTransado = new javax.swing.JCheckBox();
        chkDesxPrecio = new javax.swing.JCheckBox();
        txPosicion = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txCreacionUsuario = new javax.swing.JTextField();
        txCreacionFecha = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        chkOferta = new javax.swing.JCheckBox();
        dtFinOfer = new org.jdesktop.swingx.JXDatePicker();
        dtInicioOfer = new org.jdesktop.swingx.JXDatePicker();
        btGuardarOfer = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        GrillaMovimientos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        GrillaVenta = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        GrillaRelacion = new javax.swing.JTable();
        btAgregaRelacion = new javax.swing.JButton();
        btEliminaRelacion = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        GrillaCompras = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        GrillaFacturasC = new javax.swing.JTable();
        cbConvenioCod = new javax.swing.JComboBox();
        cbFamiliaCod = new javax.swing.JComboBox();
        cbSubFamiliaCod = new javax.swing.JComboBox();
        cbUnidadId = new javax.swing.JComboBox();
        cbConvenioSku = new javax.swing.JComboBox();
        cbFamiliaSku = new javax.swing.JComboBox();
        cbSubFamiliaSku = new javax.swing.JComboBox();
        cbOtroImpuestoId = new javax.swing.JComboBox();
        cbOtroImpuestoTaza = new javax.swing.JComboBox();
        lbImagen = new javax.swing.JLabel();

        MnuAbrirOCC.setText("Abrir Orden de Cliente");
        MnuAbrirOCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuAbrirOCCActionPerformed(evt);
            }
        });
        MnuOCC.add(MnuAbrirOCC);

        MnuCopia_OC.setText("CopiaOC");
        MnuCopia_OC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuCopia_OCActionPerformed(evt);
            }
        });
        MnuOCC.add(MnuCopia_OC);

        MnuAbrirOCP.setText("Abrir Orden");
        MnuAbrirOCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuAbrirOCPActionPerformed(evt);
            }
        });
        MnuOCP.add(MnuAbrirOCP);

        setName("pnProductos"); // NOI18N
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));

        pnMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btNuevo.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/add16.png"))); // NOI18N
        btNuevo.setText("Nuevo");
        btNuevo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btNuevo.setBorderPainted(false);
        btNuevo.setFocusPainted(false);
        btNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNuevoActionPerformed(evt);
            }
        });

        btGuardar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/save16.png"))); // NOI18N
        btGuardar.setText("Guardar");
        btGuardar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btGuardar.setBorderPainted(false);
        btGuardar.setEnabled(false);
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });

        btCancelar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/Cancel16.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btCancelar.setBorderPainted(false);
        btCancelar.setEnabled(false);
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btEditar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/Pencil16.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btEditar.setBorderPainted(false);
        btEditar.setEnabled(false);
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btEliminar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/trush16.png"))); // NOI18N
        btEliminar.setText("Eliminar");
        btEliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btEliminar.setBorderPainted(false);
        btEliminar.setEnabled(false);
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
            }
        });

        btCargarImagen.setText("Cargar Imagen");
        btCargarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCargarImagenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnMenuLayout = new javax.swing.GroupLayout(pnMenu);
        pnMenu.setLayout(pnMenuLayout);
        pnMenuLayout.setHorizontalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(448, 448, 448)
                .addComponent(btCargarImagen)
                .addContainerGap(1346, Short.MAX_VALUE))
        );
        pnMenuLayout.setVerticalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btCargarImagen)))
                .addContainerGap())
        );

        add(pnMenu);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        btIr.setText("Ir");
        btIr.setBorder(null);
        btIr.setMaximumSize(new java.awt.Dimension(15, 15));
        btIr.setMinimumSize(new java.awt.Dimension(15, 15));
        btIr.setPreferredSize(new java.awt.Dimension(15, 15));
        btIr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIrActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre");

        txNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNombreActionPerformed(evt);
            }
        });
        txNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txNombreKeyTyped(evt);
            }
        });

        txSku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txSkuActionPerformed(evt);
            }
        });
        txSku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txSkuKeyPressed(evt);
            }
        });

        jLabel1.setText("Código");

        chkCodigo.setText("Cod");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(chkCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txSku, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btIr, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txNombre)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(txNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txSku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btIr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chkCodigo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        txPeso.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txPesoKeyTyped(evt);
            }
        });

        cbUnidad.setMaximumRowCount(15);
        cbUnidad.setEnabled(false);
        cbUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUnidadActionPerformed(evt);
            }
        });

        jLabel7.setText("Unidad");

        jLabel5.setText("Cod. Barra");

        cbSubFamilia.setMaximumRowCount(20);
        cbSubFamilia.setEnabled(false);
        cbSubFamilia.setOpaque(false);
        cbSubFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSubFamiliaActionPerformed(evt);
            }
        });

        jLabel9.setText("Sub Familia");

        cbFamilia.setMaximumRowCount(10);
        cbFamilia.setEnabled(false);
        cbFamilia.setOpaque(false);
        cbFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFamiliaActionPerformed(evt);
            }
        });

        jLabel8.setText("Familia");

        jLabel29.setText("Convenio");

        cbConvenio.setEnabled(false);
        cbConvenio.setOpaque(false);
        cbConvenio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbConvenioActionPerformed(evt);
            }
        });

        jLabel19.setText("Cod. Chilecompras");

        jLabel20.setText("Peso");

        chkIva.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chkIva.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel21.setText("IVA");

        jLabel23.setText("Otro Impuesto");

        cbOtroImpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOtroImpuestoActionPerformed(evt);
            }
        });

        txTazaImpuesto.setEditable(false);
        txTazaImpuesto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        lsCodbar.setEnabled(false);
        jScrollPane5.setViewportView(lsCodbar);

        lsChilecompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lsChilecomprasMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lsChilecomprasMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lsChilecomprasMouseReleased(evt);
            }
        });
        jScrollPane6.setViewportView(lsChilecompras);

        btAgregaID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/Agregar.png"))); // NOI18N
        btAgregaID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregaIDActionPerformed(evt);
            }
        });

        btEliminaID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/Eliminar.png"))); // NOI18N
        btEliminaID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminaIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel19)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btAgregaID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btEliminaID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel29)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(10, 10, 10)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbSubFamilia, 0, 394, Short.MAX_VALUE)
                            .addComponent(cbFamilia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbConvenio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(cbOtroImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txTazaImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(78, 78, 78))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(txPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel21)
                        .addGap(18, 18, 18)
                        .addComponent(chkIva)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(cbConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbSubFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbOtroImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txTazaImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23)))
                            .addComponent(jLabel29))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel19))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(txPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(chkIva)))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btAgregaID, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(btEliminaID, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setEnabled(false);

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel11.setText("Precio Venta Público");

        txPPublico.setEditable(false);
        txPPublico.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel14.setText("Precio Venta Neto");

        txPNeto.setEditable(false);
        txPNeto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel15.setText("Costo Promedio");

        txPCosto.setEditable(false);
        txPCosto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel16.setText("Costo Transporte");

        txTransporte.setEditable(false);
        txTransporte.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txMargen.setEditable(false);
        txMargen.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel25.setText("Margen");

        txPUltCompra.setEditable(false);
        txPUltCompra.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel17.setText("Costo Ult Compra");

        jLabel28.setText("Mínimo");

        txMinimo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txMinimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txMinimoActionPerformed(evt);
            }
        });

        lbNuevoMinimo.setText("Nuevo Mínimo");

        txNuevoMinimo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txNuevoMinimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNuevoMinimoActionPerformed(evt);
            }
        });
        txNuevoMinimo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txNuevoMinimoKeyTyped(evt);
            }
        });

        btGuardarMinimo.setText("OK");
        btGuardarMinimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarMinimoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txPCosto, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                    .addComponent(txPNeto)
                                    .addComponent(txPPublico)
                                    .addComponent(txPUltCompra)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel28))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txTransporte, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                    .addComponent(txMargen))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(lbNuevoMinimo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txNuevoMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(chk_minimo))
                            .addComponent(txMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btGuardarMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel11)
                    .addComponent(txPPublico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel14)
                    .addComponent(txPNeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel15)
                    .addComponent(txPCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel17)
                    .addComponent(txPUltCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel16)
                    .addComponent(txTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel25)
                    .addComponent(txMargen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNuevoMinimo)
                    .addComponent(txNuevoMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chk_minimo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btGuardarMinimo))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        txStockInv.setEditable(false);
        txStockInv.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txStockOCP.setEditable(false);
        txStockOCP.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txStockOCC.setEditable(false);
        txStockOCC.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txStockGDC.setEditable(false);
        txStockGDC.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txStockTotal.setEditable(false);
        txStockTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel13.setText("Guías");

        jLabel12.setText("OC Clientes");

        jLabel4.setText("OC Proveedor");

        jLabel3.setText("Inventario");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Total");

        jLabel10.setText("Separado");

        txSeparado.setEditable(false);
        txSeparado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel26.setText("En Transito");

        txTransito.setEditable(false);
        txTransito.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txTransito.setToolTipText("");

        jLabel27.setText("Ubicados");

        txUbicados.setEditable(false);
        txUbicados.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txUbicados.setToolTipText("");

        btUbica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/search16.png"))); // NOI18N
        btUbica.setText("jButton1");
        btUbica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUbicaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel22)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txStockTotal)
                    .addComponent(txStockOCP)
                    .addComponent(txStockOCC)
                    .addComponent(txStockGDC)
                    .addComponent(txStockInv, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(txSeparado)
                    .addComponent(txTransito)
                    .addComponent(txUbicados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btUbica, javax.swing.GroupLayout.PREFERRED_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(txStockInv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel27)
                    .addComponent(txUbicados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btUbica))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel26)
                    .addComponent(txTransito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(txStockOCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel12)
                    .addComponent(txStockOCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txStockGDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txStockTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txSeparado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        chkPublicado.setText("Publicado");
        chkPublicado.setOpaque(false);

        jLabel24.setText("Cant. por Embalaje");

        txDisplay.setEditable(false);
        txDisplay.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        chkStock.setText("Sin Stock");

        chkDiscontinuado.setText("Discontinuado");

        chkSinCompetencia.setText("Sin Competencia");

        chkNoTransado.setText("No Transado");

        chkDesxPrecio.setText("Des. x Precio");

        txPosicion.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel30.setText("Posición Producto");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkDesxPrecio)
                            .addComponent(chkNoTransado)
                            .addComponent(txDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24)
                            .addComponent(chkPublicado, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkStock)
                            .addComponent(chkSinCompetencia)
                            .addComponent(chkDiscontinuado)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(txPosicion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel30)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(chkNoTransado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkSinCompetencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkPublicado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkDesxPrecio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkStock)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkDiscontinuado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txPosicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Usuario Creador");

        jLabel18.setText("Fecha Creación");

        txCreacionUsuario.setEditable(false);

        txCreacionFecha.setEditable(false);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txCreacionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txCreacionFecha)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txCreacionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txCreacionFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        chkOferta.setText("En Oferta");
        chkOferta.setOpaque(false);
        chkOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkOfertaActionPerformed(evt);
            }
        });

        dtFinOfer.setEnabled(false);
        dtFinOfer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dtFinOferKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dtFinOferKeyTyped(evt);
            }
        });

        dtInicioOfer.setEnabled(false);
        dtInicioOfer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dtInicioOferKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dtInicioOferKeyTyped(evt);
            }
        });

        btGuardarOfer.setText("Guardar");
        btGuardarOfer.setEnabled(false);
        btGuardarOfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarOferActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtInicioOfer, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtFinOfer, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(btGuardarOfer)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chkOferta)
                .addGap(18, 18, 18)
                .addComponent(dtInicioOfer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dtFinOfer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btGuardarOfer)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("Asociar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel31.setText("Asociar código Luvaly");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(1269, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        Pestanas.addTab("Datos", jPanel3);

        jPanel2.setBackground(new java.awt.Color(220, 215, 226));

        GrillaMovimientos.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        GrillaMovimientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Fecha", "Hora", "Usuario", "Documento", "Numero", "Cantidad", "Stock Antes", "Stock Despues", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(GrillaMovimientos);
        if (GrillaMovimientos.getColumnModel().getColumnCount() > 0) {
            GrillaMovimientos.getColumnModel().getColumn(0).setMinWidth(85);
            GrillaMovimientos.getColumnModel().getColumn(0).setPreferredWidth(85);
            GrillaMovimientos.getColumnModel().getColumn(0).setMaxWidth(85);
            GrillaMovimientos.getColumnModel().getColumn(1).setMinWidth(75);
            GrillaMovimientos.getColumnModel().getColumn(1).setPreferredWidth(75);
            GrillaMovimientos.getColumnModel().getColumn(1).setMaxWidth(75);
            GrillaMovimientos.getColumnModel().getColumn(2).setMinWidth(90);
            GrillaMovimientos.getColumnModel().getColumn(2).setPreferredWidth(90);
            GrillaMovimientos.getColumnModel().getColumn(2).setMaxWidth(90);
            GrillaMovimientos.getColumnModel().getColumn(3).setMinWidth(90);
            GrillaMovimientos.getColumnModel().getColumn(3).setPreferredWidth(90);
            GrillaMovimientos.getColumnModel().getColumn(3).setMaxWidth(90);
            GrillaMovimientos.getColumnModel().getColumn(4).setMinWidth(90);
            GrillaMovimientos.getColumnModel().getColumn(4).setPreferredWidth(90);
            GrillaMovimientos.getColumnModel().getColumn(4).setMaxWidth(90);
            GrillaMovimientos.getColumnModel().getColumn(5).setMinWidth(80);
            GrillaMovimientos.getColumnModel().getColumn(5).setPreferredWidth(80);
            GrillaMovimientos.getColumnModel().getColumn(5).setMaxWidth(80);
            GrillaMovimientos.getColumnModel().getColumn(6).setMinWidth(80);
            GrillaMovimientos.getColumnModel().getColumn(6).setPreferredWidth(80);
            GrillaMovimientos.getColumnModel().getColumn(6).setMaxWidth(80);
            GrillaMovimientos.getColumnModel().getColumn(7).setMinWidth(80);
            GrillaMovimientos.getColumnModel().getColumn(7).setPreferredWidth(80);
            GrillaMovimientos.getColumnModel().getColumn(7).setMaxWidth(80);
            GrillaMovimientos.getColumnModel().getColumn(8).setMinWidth(90);
            GrillaMovimientos.getColumnModel().getColumn(8).setPreferredWidth(90);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 2311, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))
        );

        Pestanas.addTab("Movimientos", jPanel2);

        jPanel1.setBackground(new java.awt.Color(220, 215, 226));

        GrillaVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Fecha", "Rut", "Cliente", "Codigo OC", "Orden", "Solicitado", "Despachado", "Separado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        GrillaVenta.setComponentPopupMenu(MnuOCC);
        jScrollPane1.setViewportView(GrillaVenta);
        if (GrillaVenta.getColumnModel().getColumnCount() > 0) {
            GrillaVenta.getColumnModel().getColumn(2).setMinWidth(250);
            GrillaVenta.getColumnModel().getColumn(2).setPreferredWidth(300);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1172, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))
        );

        Pestanas.addTab("OC Clientes", jPanel1);

        GrillaRelacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(GrillaRelacion);
        if (GrillaRelacion.getColumnModel().getColumnCount() > 0) {
            GrillaRelacion.getColumnModel().getColumn(0).setMinWidth(85);
            GrillaRelacion.getColumnModel().getColumn(0).setPreferredWidth(85);
            GrillaRelacion.getColumnModel().getColumn(0).setMaxWidth(85);
            GrillaRelacion.getColumnModel().getColumn(1).setMinWidth(400);
            GrillaRelacion.getColumnModel().getColumn(1).setPreferredWidth(400);
            GrillaRelacion.getColumnModel().getColumn(1).setMaxWidth(400);
            GrillaRelacion.getColumnModel().getColumn(2).setMinWidth(85);
            GrillaRelacion.getColumnModel().getColumn(2).setPreferredWidth(85);
            GrillaRelacion.getColumnModel().getColumn(2).setMaxWidth(85);
        }

        btAgregaRelacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/Agregar.png"))); // NOI18N
        btAgregaRelacion.setEnabled(false);
        btAgregaRelacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregaRelacionActionPerformed(evt);
            }
        });

        btEliminaRelacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/Eliminar.png"))); // NOI18N
        btEliminaRelacion.setEnabled(false);
        btEliminaRelacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminaRelacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btAgregaRelacion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEliminaRelacion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(1699, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btAgregaRelacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEliminaRelacion)
                .addContainerGap(236, Short.MAX_VALUE))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        Pestanas.addTab("Códigos Madre", jPanel10);

        GrillaCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Fecha", "Rut", "Proveedor", "Nro Orden", "Cantidad", "Recibido", "Val.Unidad", "Val.Rebajado", "Val.Total", "Objetivo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        GrillaCompras.setComponentPopupMenu(MnuOCP);
        GrillaCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GrillaComprasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(GrillaCompras);
        if (GrillaCompras.getColumnModel().getColumnCount() > 0) {
            GrillaCompras.getColumnModel().getColumn(2).setPreferredWidth(350);
            GrillaCompras.getColumnModel().getColumn(8).setPreferredWidth(120);
            GrillaCompras.getColumnModel().getColumn(9).setMinWidth(0);
            GrillaCompras.getColumnModel().getColumn(9).setPreferredWidth(0);
            GrillaCompras.getColumnModel().getColumn(9).setMaxWidth(0);
        }

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 127, 80));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("REBAJA TODO EL DOCUMENTO");

        jTextField2.setEditable(false);
        jTextField2.setBackground(java.awt.Color.pink);
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("DESCUENTO A TODO EL DOCUMENTO");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setEditable(false);
        jTextField3.setBackground(java.awt.Color.orange);
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("DESCUENTO AL ITEM");

        jTextField4.setEditable(false);
        jTextField4.setBackground(java.awt.Color.white);
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText("SIN NOTA CREDITO ASOCIADA");

        GrillaFacturasC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Rut", "Nro Factura.", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        GrillaFacturasC.setComponentPopupMenu(MnuOCP);
        GrillaFacturasC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GrillaFacturasCMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(GrillaFacturasC);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 888, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(1115, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 21, Short.MAX_VALUE))
        );

        Pestanas.addTab("OC Proveedores", jPanel9);

        cbConvenioCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbConvenioCodActionPerformed(evt);
            }
        });

        cbFamiliaCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFamiliaCodActionPerformed(evt);
            }
        });

        cbSubFamiliaCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSubFamiliaCodActionPerformed(evt);
            }
        });

        cbOtroImpuestoId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOtroImpuestoIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnDetalleLayout = new javax.swing.GroupLayout(pnDetalle);
        pnDetalle.setLayout(pnDetalleLayout);
        pnDetalleLayout.setHorizontalGroup(
            pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDetalleLayout.createSequentialGroup()
                        .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(84, 84, 84)
                        .addComponent(lbImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDetalleLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbFamiliaCod, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbConvenioCod, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbSubFamiliaCod, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbConvenioSku, 0, 67, Short.MAX_VALUE)
                                    .addComponent(cbFamiliaSku, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbSubFamiliaSku, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbUnidadId, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnDetalleLayout.createSequentialGroup()
                                .addGap(205, 205, 205)
                                .addComponent(cbOtroImpuestoId, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbOtroImpuestoTaza, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnDetalleLayout.createSequentialGroup()
                        .addComponent(Pestanas)
                        .addGap(41, 41, 41))))
        );
        pnDetalleLayout.setVerticalGroup(
            pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDetalleLayout.createSequentialGroup()
                .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDetalleLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnDetalleLayout.createSequentialGroup()
                                .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbConvenioSku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbUnidadId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbFamiliaSku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbSubFamiliaSku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnDetalleLayout.createSequentialGroup()
                                .addComponent(cbConvenioCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbFamiliaCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbSubFamiliaCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(17, 17, 17)
                        .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbOtroImpuestoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbOtroImpuestoTaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnDetalleLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnDetalleLayout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pestanas)
                .addGap(47, 47, 47))
        );

        add(pnDetalle);
    }// </editor-fold>//GEN-END:initComponents
//--------------------------------------------------------------------------------
// Funcion CODIGO desde COMBOBOX
//--------------------------------------------------------------------------------
    private int cbId_Accion(JComboBox Combo ){
        int Codigo=-1;
    if (Combo.getSelectedIndex()>=0){
        ComboCodigos id = (ComboCodigos) Combo.getSelectedItem();
        Codigo = id.getId();
        String nombre = Combo.getSelectedItem().toString();
        Combo.hidePopup();
    } 
    return Codigo;
}
private void CargaOtrosImpuestos(){
    ExeSql_Econa Sql = new ExeSql_Econa();
    ResultSet Rs;
    
    try {
        cbOtroImpuesto.removeAllItems();
        cbOtroImpuestoId.removeAllItems();
        
        Rs = Sql.Select("select *\n" +
                        "from par_impuesto\n" +
                        "order by codigo");
        while(Rs.next()){
            cbOtroImpuestoId.addItem(Rs.getInt("codigo"));
            cbOtroImpuestoTaza.addItem(Rs.getDouble("taza"));
            cbOtroImpuesto.addItem(Rs.getString("impuesto"));
        }
    } catch (Exception e) {
    }
}
    
private void CargaMovimientos (String Codigo){
    ExeSql_Econa Sql = new ExeSql_Econa();
    DefaultTableModel dftm = (DefaultTableModel) GrillaMovimientos.getModel();
    ResultSet Rs;
    // Limpia Grilla
    while (dftm.getRowCount() > 0) {
        dftm.removeRow(0);
    }

    try {
        Rs = Sql.Select("select m.fecha,cast(m.hora as time) as hora,m.usuario,m.tipdocto,m.nrodocto,m.cantidad,m.stockini,m.stockfin,m.tipomovimiento\n"
                + "from producto p\n"
                + "left join movimientos_stock m on p.sku=m.sku \n"
                + "left join par_unidad u on p.unidad=u.codigo\n"
                + "where p.sku='" + Codigo + "'\n"
                + "order by m.id desc");
        while (Rs.next()) {
            dftm.addRow(new Object[]{
                Rs.getDate("fecha"),
                Rs.getTime("hora"),
                Rs.getString("usuario"),
                Rs.getString("tipdocto"),
                Rs.getString("nrodocto"),
                fmMain.FormatoNumero(Rs.getDouble("cantidad")),
                fmMain.FormatoNumero(Rs.getDouble("stockini")),
                fmMain.FormatoNumero(Rs.getDouble("stockfin")),
                Rs.getString("tipomovimiento")});
        }
    } catch (Exception e) {
    } finally{
        Sql.Close();
    }
}

private void CargaVentas (String Codigo)    {
    ExeSql_Econa  Sql = new ExeSql_Econa();
    DefaultTableModel dftm = (DefaultTableModel) GrillaVenta.getModel();
    ResultSet Rs;
    // Limpia Grilla
    while(dftm.getRowCount()>0)
        dftm.removeRow(0);
    
    try {
            Rs = Sql.Select("SELECT CAST(e.femision as date) as fecha,e.rut,trim(cl.nombre) as nombre,d.codigo_oc,d.orden,d.cantidad,d.despachado,d.separado\n" +
                            "FROM OCCHDET d\n" +
                            "LEFT JOIN OCCH e on e.rut=d.rut and e.codigo_oc=d.codigo_oc and e.orden=d.orden \n" +
                            "left join cliente cl on d.rut=cl.rut \n" +
                            "where d.sku='"+ Codigo +"'\n" +
                            "order by e.femision desc");
            while(Rs.next()){
                dftm.addRow(new Object[]{
                        Rs.getDate("fecha"), 
                        Rs.getString("rut"),
                        Rs.getString("nombre"),
                        Rs.getString("codigo_oc"),
                        Rs.getString("orden"),
                        fmMain.FormatoNumero(Rs.getDouble("cantidad")),
                        fmMain.FormatoNumero(Rs.getDouble("despachado")),
                        fmMain.FormatoNumero(Rs.getDouble("separado"))
                        });
            }
    } catch (Exception e) {
        System.out.println(e);
    } finally {
        Sql.Close();
    }
}
    private void CargaCompras(String Codigo) {
        ExeSql_Econa Sql = new ExeSql_Econa();
        String Query = "";
        DefaultTableModel dftm = (DefaultTableModel) GrillaCompras.getModel();
        ResultSet Rs;
        
        // Limpia Grilla
//        while (dftm.getRowCount() > 0) {
//            dftm.removeRow(0);
//        }
        
        dftm.setRowCount(0);

        try {
            Query = "select cast(e.femision as date) as fecha, e.rut,trim(p.nombre) as nombre,e.nrodocto,d.cantidad,d.recibido, d.valorunitario, "
                    + "(select nuevo_valor from ctacteprvdet d \n" +
                        "inner join (select femision,tipdocto,nrodocto,nrodocorigen from ctacteprv\n" +
                        "where nrodocorigen  = e.nrodocto\n" +
                        "and tipdocorigen = 'OCP' ) o\n" +
                        "on  d.nrodocto = o.nrodocto\n" +
                        "and d.tipdocto = o.tipdocto\n" +
                        "and d.sku='" + Codigo + "' order by o.femision desc LIMIT 1),\n"
                    + "d.totallinea, \n"
                    + "(select objetivo from ctacteprvdet d \n" +
                        "inner join (select femision,tipdocto,nrodocto,nrodocorigen from ctacteprv\n" +
                        "where nrodocorigen  = e.nrodocto\n" +
                        "and tipdocorigen = 'OCP' ) o\n" +
                        "on  d.nrodocto = o.nrodocto\n" +
                        "and d.tipdocto = o.tipdocto\n" +
                        "and d.sku='" + Codigo + "' order by o.femision desc LIMIT 1)\n"
                    + "from ctacteprvdet d\n"
                    + "left join ctacteprv e on d.rut=e.rut and d.tipdocto=e.tipdocto and d.nrodocto=e.nrodocto\n"
                    + "left join proveedor p on p.rut=d.rut\n"
                    + "where d.tipdocto='OCP'\n"
                    + "and d.sku='" + Codigo + "'\n"
                    + "order by e.femision desc";
            Rs = Sql.Select(Query);
            while (Rs.next()) {
                dftm.addRow(new Object[]{
                    Rs.getDate("fecha"),
                    Rs.getString("rut"),
                    Rs.getString("nombre"),
                    Rs.getString("nrodocto"),
                    fmMain.FormatoNumero(Rs.getDouble("cantidad")),
                    fmMain.FormatoNumero(Rs.getDouble("recibido")),
                    fmMain.FormatoNumero(Rs.getDouble("valorunitario")),
                    fmMain.FormatoNumero(Rs.getDouble("nuevo_valor")),
                    fmMain.FormatoNumero(Rs.getDouble("totallinea")),
                    Rs.getInt("objetivo"),
                });
                
            GrillaCompras.setDefaultRenderer(Object.class,new Utilidades.TableColor_OCProvee());
            GrillaCompras.repaint();
            }
        } catch (Exception e) {
            fmMain.Mensaje("Error al cargar: "+e);
        } finally {
            Sql.Close();
        }
    }
    
    private void CargaRelacion(String Codigo){
        DefaultTableModel TableModel = (DefaultTableModel) GrillaRelacion.getModel();
        ExeSql_Econa Sql = new ExeSql_Econa();
        ResultSet Rs;
        
        while(TableModel.getRowCount()>0)
              TableModel.removeRow(0);
        
        try {
            Rs = Sql.Select("select t.skurel,p.nombre,t.cantidad\n" +
                            "from transformacion t\n" +
                            "left join  producto p on p.sku=t.skurel\n" +
                            "where t.sku='"+ Codigo +"'");
            
            while(Rs.next()){
                TableModel.addRow(new Object[]{
                                            Rs.getString("skurel").trim(),
                                            Rs.getString("nombre").trim(),
                                            Rs.getDouble("cantidad")
                                            });
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally{
            Sql.Close();
        }
    }
//--------------------------------------------------------------------------------
// Habilita o deshabilita edicion de productos
//--------------------------------------------------------------------------------
private void GeneraCodigo() {
    ExeSql_Econa Sql = new ExeSql_Econa();
    ResultSet Rs;
    String Codigo;
    String Convenio;
    String Familia;
    String SubFamilia;
    String Contador;
    try {
        if (Tipo == 1 && cbConvenio.getSelectedIndex() > -1 && cbFamilia.getSelectedIndex() > -1 && cbSubFamilia.getSelectedIndex() > -1) {
            SubFamilia = cbSubFamiliaCod.getSelectedItem().toString().trim();
            Rs = Sql.Select("select contador from par_sublinea where codigo=" + SubFamilia);
            Rs.next();
            if (Rs.getInt("contador") < 10) {
                Contador = "00" + String.valueOf(Rs.getInt("contador"));
            } else if (Rs.getInt("contador") < 100) {
                Contador = "0" + String.valueOf(Rs.getInt("contador"));
            } else {
                Contador = String.valueOf(Rs.getInt("contador"));
            }

            Convenio = cbConvenioSku.getSelectedItem().toString().trim();
            Familia = cbFamiliaSku.getSelectedItem().toString().trim();
            SubFamilia = cbSubFamiliaSku.getSelectedItem().toString().trim();

            Codigo = Convenio + Familia + SubFamilia + Contador;
            txSku.setText(Codigo);
        }
    } catch (Exception e) {
        System.out.println(e);
    } finally{
        Sql.Close();
    }
}
//--------------------------------------------------------------------------------
// Habilita o deshabilita edicion de productos
//--------------------------------------------------------------------------------
private void Limpia(){
    int RespTipo=Tipo;
    
    
    DefaultTableModel Model = (DefaultTableModel) GrillaRelacion.getModel();
    while(Model.getRowCount()>0)
        Model.removeRow(0);
    
    
    //Limpia Grilla Venta
    DefaultTableModel ModelVta = (DefaultTableModel) GrillaVenta.getModel();
    while(ModelVta.getRowCount()>0)
        ModelVta.removeRow(0);
    
    //Limpia Grilla Venta
    DefaultTableModel ModelMov = (DefaultTableModel) GrillaMovimientos.getModel();
    while(ModelMov.getRowCount()>0)
        ModelMov.removeRow(0);
    
    //Limpia Grilla Compras
    DefaultTableModel ModelComp = (DefaultTableModel) GrillaCompras.getModel();
    while(ModelComp.getRowCount()>0)
        ModelComp.removeRow(0);
    
    //Limpia Grilla FacturasC
    DefaultTableModel ModelFact = (DefaultTableModel) GrillaFacturasC.getModel();
    while(ModelFact.getRowCount()>0)
        ModelFact.removeRow(0);
    
    Tipo=0;
    txSku.setText("");
    txNombre.setText("");
    //txCodBar.setText("");
    //txCodBar2.setText("");
    txPeso.setText("");
    txPPublico.setText("");
    txPCosto.setText("");
    txPNeto.setText("");
    txMargen.setText("");
    txStockInv.setText("");
    txStockOCP.setText("");
    txStockOCC.setText("");
    txStockGDC.setText("");
    txStockTotal.setText("");
    txSeparado.setText("");
    txCreacionFecha.setText("");
    txCreacionUsuario.setText("");
    txMinimo.setText("");
    
    cbFamilia.setSelectedIndex(-1);
    cbSubFamilia.setSelectedIndex(-1);
    cbUnidad.setSelectedIndex(-1);
    cbConvenio.setSelectedIndex(-1);
    txPosicion.setText("");
    txNuevoMinimo.setText("");
    chk_minimo.setSelected(false);
    lsCodbar.removeAll();
    
    
    

    if (lsChilecompras.isEnabled() && lsChilecompras.isVisible()) {
    
        
    DefaultListModel limpiaLsChilecompras = new DefaultListModel();    
//    DefaultListModel limpiaLsChilecompras= (DefaultListModel) lsChilecompras.getModel();
//    limpiaLsChilecompras.removeAllElements();
    }
    
    if (lsCodbar.isEnabled() && lsCodbar.isVisible()){
    DefaultListModel limpiaLsChilecompras = new DefaultListModel();    
//    DefaultListModel limpiaLsCodBarra= (DefaultListModel) lsCodbar.getModel();
//    limpiaLsCodBarra.removeAllElements();
    }
    
    
    
    
    
    
    
    
    
    chkNoTransado.setSelected(false);
    chkSinCompetencia.setSelected(false);
    chkPublicado.setSelected(false);
    chkDesxPrecio.setSelected(false);
    chkStock.setSelected(false);
    chkDiscontinuado.setSelected(false);      
    txPUltCompra.setText("");
    txUbicados.setText("");
    txTransito.setText("");
    
    txMargen.setBackground(Color.white);
    txMinimo.setBackground(Color.white);
    Tipo=RespTipo;
}
//--------------------------------------------------------------------------------
// Habilita o deshabilita edicion de productos
//--------------------------------------------------------------------------------
private void Habilita(boolean Estado){
//    cbLinea.setEnabled(Estado);
//    cbSubLinea.setEnabled(Estado);
//    cbUnidad.setEnabled(Estado);
    
    txNombre.setEnabled(Estado);
    //txCodBar2.setEnabled(Estado);
    txPeso.setEnabled(Estado);
    
    
    txPPublico.setEnabled(Estado);
    txPCosto.setEnabled(Estado);
    txPNeto.setEnabled(Estado);
    txMargen.setEnabled(Estado);
    txStockInv.setEnabled(Estado);
    txStockOCP.setEnabled(Estado);
    txStockOCC.setEnabled(Estado);
    txStockGDC.setEnabled(Estado);
    txStockTotal.setEnabled(Estado);
    txTransporte.setEnabled(Estado);
    txDisplay.setEnabled(Estado);
    txCreacionUsuario.setEnabled(Estado);
    txCreacionFecha.setEnabled(Estado);
    txTazaImpuesto.setEnabled(Estado);
    
    //if (Estado){
    cbConvenio.setEnabled(Estado);
    cbFamilia.setEnabled(Estado);
    cbSubFamilia.setEnabled(Estado);
    //}
    cbUnidad.setEnabled(Estado);
    txSeparado.setEnabled(Estado);
    txPUltCompra.setEnabled(Estado);
    cbOtroImpuesto.setEnabled(Estado);
   
    chkPublicado.setEnabled(Estado);
    chkSinCompetencia.setEnabled(Estado);
    chkDesxPrecio.setEnabled(Estado);
    chkNoTransado.setEnabled(Estado);
    
    chkStock.setEnabled(Estado);
    chkDiscontinuado.setEnabled(Estado);
    
    btUbica.setEnabled(Estado);
    txUbicados.setEnabled(Estado);
    txTransito.setEnabled(Estado);
    lsCodbar.setVisible(Estado);
    lsChilecompras.setVisible(Estado);
    lsCodbar.setEnabled(Estado);
    lsChilecompras.setEnabled(Estado);
    chkIva.setEnabled(true);
}
//--------------------------------------------------------------------------------
// Habilita o deshabilita edicion de productos
//--------------------------------------------------------------------------------
private void Edicion(boolean Estado){
    txNombre.setEditable(Estado);
    //txCodBar2.setEditable(Estado);
    txPeso.setEditable(Estado);
    txDisplay.setEditable(Estado);
    
    
    btGuardar.setEnabled(Estado);
    btCancelar.setEnabled(Estado);
    btAgregaRelacion.setEnabled(Estado);
    btEliminaRelacion.setEnabled(Estado);
//    txUbicados.setEnabled(Estado);
//    btUbica.setEnabled(Estado);

    
//    txPPublico.setEditable(Estado);
//    txPCosto.setEditable(Estado);
//    txPNeto.setEditable(Estado);
//    txMargen.setEditable(Estado);
//    txStockInv.setEditable(Estado);
//    txStockOCP.setEditable(Estado);
//    txStockOCC.setEditable(Estado);
//    txStockGDC.setEditable(Estado);
//    txStockTotal.setEditable(Estado);
}
//--------------------------------------------------------------------------------
// Carga combo UNIDAD DE MEDIDA
//--------------------------------------------------------------------------------
private void CargaUnidades() {
        ExeSql_Econa Sql = new ExeSql_Econa();
        ResultSet Rs;
        DefaultComboBoxModel cbmUnidad,cbmUnidadId;
        cbmUnidad   = new DefaultComboBoxModel();
        cbmUnidadId = new DefaultComboBoxModel();
        
        cbUnidad.setModel(cbmUnidad);
        cbUnidadId.setModel(cbmUnidadId);
        try {
            Rs = Sql.Select("select codigo,trim(unidad) as unidad from par_unidad");
            while (Rs.next()) {
                cbUnidad.addItem(Rs.getString("unidad"));
                cbUnidadId.addItem(Rs.getString("codigo"));
                //cbmUnidad.addElement(Rs.getString("unidad"));
//                cbmUnidadId.addElement(Rs.getString("codigo").trim());
            }
           // cbUnidad.setSelectedIndex(-1);
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Sql.Close();
        }
    }
//--------------------------------------------------------------------------------
// Carga OTROS IMPUESTOS
//--------------------------------------------------------------------------------
//--------------------------------------------------------------------------------
// Carga CONVENIOS
//--------------------------------------------------------------------------------
//--------------------------------------------------------------------------------
// Carga CONVENIOS
//--------------------------------------------------------------------------------
private void CargaConvenios() {
        ExeSql_Econa Sql = new ExeSql_Econa();
        ResultSet Rs;

        try {
            Rs = Sql.Select("select codigo,convenio,cod from par_convenio order by codigo");
            while (Rs.next()) {
                cbConvenio.addItem(Rs.getString("convenio"));
                cbConvenioCod.addItem(Rs.getString("codigo"));
                cbConvenioSku.addItem(Rs.getString("cod"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(fmMain.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Sql.Close();
        }
    }
//--------------------------------------------------------------------------------
// Carga LINEAS
//--------------------------------------------------------------------------------
private void CargaLineas() {
        ExeSql_Econa Sql = new ExeSql_Econa();
        ResultSet Rs;
        int TipoAux;
        
        cbFamilia.removeAllItems();
        cbFamiliaCod.removeAllItems();
        cbFamiliaSku.removeAllItems();
        TipoAux=Tipo;
        
        
        try {
            if(Tipo==1 && cbConvenioCod.getSelectedIndex()>-1)
                Rs = Sql.Select("select codigo,linea,cod from par_linea where convenio = "+ cbConvenioCod.getSelectedItem().toString().trim() +" order by codigo");
            else
                Rs = Sql.Select("select codigo,linea,cod from par_linea order by codigo");
            Tipo=-99;
            // Recorre Query
            while (Rs.next()) {
                // Carga lineas en Combo
                cbFamilia.addItem(Rs.getString("linea"));
                cbFamiliaCod.addItem(Rs.getString("codigo"));
                cbFamiliaSku.addItem(Rs.getString("cod"));
            }
            
        } catch (Exception ex) {
            System.out.println(ex);
        }finally{
            Sql.Close();
            Tipo=TipoAux;
        }
       
    }
//--------------------------------------------------------------------------------
// Carga PRODUCTOS
//--------------------------------------------------------------------------------
public void CargaProducto(String Codigo) {
        ExeSql_Econa Sql = new ExeSql_Econa();
        ResultSet Rs = null, Rs1 = null;
        Tipo = 0;
        double Margen;
        int revisa_codbar =0;
        int revisa_codchile =0;
        //Trabajando con Listas
        JList lista = new JList();
        DefaultListModel modelo2 = new DefaultListModel();
        DefaultListModel modelo = new DefaultListModel();
        
        
        cbUnidad.setEnabled(true);
        cbConvenio.setEnabled(true);
        cbFamilia.setEnabled(true);
        cbSubFamilia.setEnabled(true);
        lsCodbar.setVisible(true);
        lsChilecompras.setVisible(true);
        txUbicados.setEnabled(true);
        txTransito.setEnabled(true);
        btUbica.setEnabled(true);
        txMinimo.setEnabled(true);
        txPosicion.setEnabled(true);
        try {
            String Query;
            //Limpia la Lista
            modelo.clear();
            modelo2.clear();
            
            lsCodbar.setModel(modelo);
            lsChilecompras.setModel(modelo2);

            Rs = Sql.Select("select codbar, sku from codbar where sku='" + Codigo + "' or codbar='"+ Codigo + "'" );        
                    if (Rs.next())
                        {
                        Codigo = Rs.getString("sku").trim();
                        revisa_codbar++;
                        }
            Rs = Sql.Select("select idch, sku from codchile where sku='" + Codigo +"' or idch='"+ Codigo + "'" );
                    if (Rs.next())
                        {
                        Codigo = Rs.getString("sku").trim();
                        revisa_codchile++;
                        }
            Rs = Sql.Select("select codbar, sku from codbar where sku='" + Codigo + "' or codbar='"+ Codigo + "'" );        
                    if (Rs.next())
                        {
                        Codigo = Rs.getString("sku").trim();
                        revisa_codbar++;
                        }
                    
            if (revisa_codbar>=1)
            {
                 Rs = Sql.Select("select c.codbar, CASE WHEN p.nombre is null THEN 'nulo' ELSE p.nombre END from codbar c left join proveedor p on c.rutprv=p.rut where c.sku='" + Codigo +"'");
                 modelo.clear();
                 String prove="";
                 while (Rs.next())
                 
                 {
                     if (Rs.getString("nombre").trim().equals("nulo"))
                        {
                         prove="";
                        }
                     else{
                         prove=" - "+Rs.getString("nombre").trim();
                         
                     }
                     modelo.addElement(Rs.getString("codbar").trim()+prove);
                  }
            }
            if (revisa_codchile>=1)
            {
                 Rs = Sql.Select("select idch from codchile where sku='" + Codigo +"'");
                 modelo2.clear();
                 while (Rs.next())
                 {
                     modelo2.addElement(Rs.getString("idch").trim());
                 }
            }
            
            

            
            Query ="select p.sku,p.publicado, p.sincompetencia, p.desxprecio, p.notransado, p.discontinuado, p.sinstock, p.oferta_inicio, p.oferta_fin, p.oferta, p.display, p.sku,p.nombre,p.unidad,p.linea,p.sublinea,p.codbar,p.codbar2,p.vigente,p.peso,cast(p.fcreacion as date) as fcreacion,p.usuariocreacion,p.otroimpuesto,\n"
                    + "i.stock,i.ocp,i.occ,i.gdc, p.pventa,p.valultcompra,p.costofinal,p.imptoiva,p.convenio,p.otroimpuesto,p.marca, p.minimo,calcula_minimo, (select sum(separado) from occhdet where sku=p.sku) as separado, pr.posicion\n"
                    + "from producto p\n"
                    + "left join inventario i\n"
                    + "on p.sku=i.Sku\n"
                    + "left join producto_posicion pr\n"
                    + "on p.sku = pr.sku\n"
                    + "where p.sku='" + Codigo + "' or p.sku in (select sku from codbar where codbar='" + Codigo + "') and p.es_cotiza<>1";
              Rs = Sql.Select(Query);

              
            if(Sql.GetRowCount()==0){
                Rs = Sql.Select("select p.publicado, p.sincompetencia, p.desxprecio, p.notransado,  p.oferta, p.oferta_inicio, p.oferta_fin, p.display, p.sku,p.nombre,p.unidad,p.linea,p.sublinea,p.codbar,p.codbar2,p.vigente,p.peso,cast(p.fcreacion as date) as fcreacion,p.usuariocreacion,p.otroimpuesto,\n"
                                + "i.stock,i.ocp,i.occ,i.gdc, p.pventa,p.valultcompra,p.costofinal,p.imptoiva,p.convenio,p.otroimpuesto,p.marca,p.minimo, p.calcula_minimo,(select sum(separado) from occhdet where sku=p.sku) as separado, pr.posicion\n"
                                + "from producto p\n"
                                + "left join inventario i\n"
                                + "on p.sku=i.Sku\n"
                                + "left join producto_posicion pr\n"
                                + "on p.sku = pr.sku\n"
                        + " where p.es_cotiza<>1");
            }
            Rs.next();
            Codigo = Rs.getString("sku").trim();
            String Nombre = Rs.getString("nombre");
            if (Nombre.length() > 20) {
                Nombre.substring(0, 20);
            }
            
            int valorMinimo = 0;
            if( Rs.getString("minimo") == null){
                valorMinimo = 0;
            }else{
                valorMinimo = Rs.getInt("minimo");
            }
            double calculoMinimo = ((valorMinimo*80)/100);
            
            // carga el check_minimo
            if (Rs.getBoolean("calcula_minimo")){
                chk_minimo.setSelected(true);
            }
            else{
                chk_minimo.setSelected(false);
            }
                    
            
            
            
            
            fmMain.pnPestanas.setTitleAt(fmMain.pnPestanas.getSelectedIndex(), Nombre);
            fmMain.pnPestanas.repaint();
            txSku.setText(Rs.getString("sku"));
            txNombre.setText(ElTrim(Rs.getString("nombre")));
           // txCodBar.setText(ElTrim(Rs.getString("codbar")));
            txDisplay.setText(ElTrim(Rs.getString("display")));
            //txCodBar2.setText(ElTrim(Rs.getString("codigo_cc")));
            txPeso.setText(String.valueOf(Rs.getDouble("peso")));
            txStockInv.setText(Rs.getString("stock"));
            txStockOCP.setText(Rs.getString("ocp"));
            txStockOCC.setText(Rs.getString("occ"));
            txStockGDC.setText(Rs.getString("gdc"));
            double StockTotal = Rs.getDouble("stock") + Rs.getDouble("ocp") + Rs.getDouble("occ") + Rs.getDouble("gdc");
            txStockTotal.setText(String.valueOf(StockTotal));
            txSeparado.setText(Rs.getString("separado"));
            txCreacionUsuario.setText(Rs.getString("usuariocreacion").trim());
            txCreacionFecha.setText(Rs.getString("fcreacion").trim());
            if(StockTotal > valorMinimo){
                txMinimo.setBackground(Color.green);
            }else if(StockTotal < valorMinimo && StockTotal > calculoMinimo){
                txMinimo.setBackground(Color.yellow);
            }else if (StockTotal <= calculoMinimo){
                txMinimo.setBackground(Color.red);
            }
            txMinimo.setText(Integer.toString(valorMinimo));
            chkPublicado.setSelected(Rs.getBoolean("publicado"));
            chkSinCompetencia.setSelected(Rs.getBoolean("sincompetencia"));
            chkDesxPrecio.setSelected(Rs.getBoolean("desxprecio"));
            chkNoTransado.setSelected(Rs.getBoolean("notransado"));
            chkOferta.setSelected(Rs.getBoolean("oferta"));
            chkDiscontinuado.setSelected(Rs.getBoolean("discontinuado"));
            chkStock.setSelected(Rs.getBoolean("sinstock"));
            
            //MENSAJE POSICION DE PRODUCTO EN MERCADOPUBLICO
            if(Rs.getString("posicion") == (null)){
                txPosicion.setToolTipText("El producto no existe en el portal MercadoPublico");
                txPosicion.setText("0");
            }else if(Integer.parseInt(Rs.getString("posicion")) >= 1 && Integer.parseInt(Rs.getString("posicion")) <=10) {
                txPosicion.setText(Rs.getString("posicion"));
                txPosicion.setToolTipText("El producto se encuentra en la posición número " +(Rs.getString("posicion")) + " en el portal MercadoPublico");
            }else if(Integer.parseInt(Rs.getString("posicion")) == 11){
                txPosicion.setText(Rs.getString("posicion"));
                txPosicion.setToolTipText("El producto no se encuentra en la primera página o no existe dentro del portal MercadoPublico");
            }else if(Integer.parseInt(Rs.getString("posicion")) == 20){
                txPosicion.setText(Rs.getString("posicion"));
                txPosicion.setToolTipText("El producto no se encuentra en el portal MercadoPublico");
            }else if(Integer.parseInt(Rs.getString("posicion")) == 30){
                txPosicion.setText(Rs.getString("posicion"));
                txPosicion.setToolTipText("El producto no existe en el portal MercadoPublico o fue eliminado");
            }
            
            
            if (chkOferta.isSelected())
                {
                chkOferta.setEnabled(true);
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                
                int oferta = Integer.valueOf(Rs.getString("oferta_fin").replace("-", ""));
                int hoy = Integer.valueOf(formato.format(Calendar.getInstance().getTime()).replace("-", ""));
                       
                System.out.println(oferta);
                System.out.println(hoy);
                                          
                                   
               if (oferta<hoy)
                { 
                   chkOferta.setSelected(false);
                }
               else
               {
                   chkOferta.setEnabled(false);
               }

                dtInicioOfer.setDate(Rs.getDate("oferta_inicio"));
                dtFinOfer.setDate(Rs.getDate("oferta_fin"));
        
                }
            else{
                chkOferta.setEnabled(true);
            }
     
            
            try {
                if(Rs.getDouble("pventa")>0)
                    Margen = (Rs.getDouble("pventa")-Rs.getDouble("costofinal"))*100/Rs.getDouble("pventa");
                else
                    Margen = 0;
                txPNeto.setText(Rs.getString("pventa"));
                txPUltCompra.setText(fmMain.FormatoTotal(Rs.getDouble("valultcompra")));
                txPCosto.setText(fmMain.FormatoTotal(Rs.getDouble("costofinal")));
                txMargen.setText(fmMain.FormatoTotal(Margen) + "%");
                if(Margen>30)
                    txMargen.setBackground(Color.green);
                else if(Margen>20)
                    txMargen.setBackground(Color.yellow);
                else
                    txMargen.setBackground(Color.red);
            
            } catch (Exception e) {
                txMargen.setBackground(Color.white);
            }
            
            //MOSTRAR CAMPOS PARA EDICIÓN DEL MINIMO
                int pruebaUusario = 85;
                int intNivelUsuario = 0;
                intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
                if( intNivelUsuario >= pruebaUusario){
                    lbNuevoMinimo.setVisible(true);
                    txNuevoMinimo.setVisible(true);
                    btGuardarMinimo.setVisible(true);
                    chk_minimo.setVisible(true);
                }else{
                      lbNuevoMinimo.setVisible(false);
                    txNuevoMinimo.setVisible(false);
                    btGuardarMinimo.setVisible(false);
                    chk_minimo.setVisible(false);
                }
            
            
            
            
            //IVA
            
            cbUnidadId.setSelectedItem(Rs.getString("unidad").trim());
            cbUnidad.setSelectedIndex(cbUnidadId.getSelectedIndex());
            
            cbConvenioCod.setSelectedItem(Rs.getString("convenio").trim());
            cbConvenio.setSelectedIndex(cbConvenioCod.getSelectedIndex());
            
            cbFamiliaCod.setSelectedItem(Rs.getString("linea").trim());
            cbFamilia.setSelectedIndex(cbFamiliaCod.getSelectedIndex());
            
            cbSubFamiliaCod.setSelectedItem(Rs.getString("sublinea").trim());
            cbSubFamilia.setSelectedIndex(cbSubFamiliaCod.getSelectedIndex());
            
            cbOtroImpuestoId.setSelectedItem(Rs.getInt("otroimpuesto"));
            cbOtroImpuesto.setSelectedIndex(cbOtroImpuestoId.getSelectedIndex());

            PosUM       = cbUnidad.getSelectedIndex();
            PosLinea    = cbFamilia.getSelectedIndex();
            PosSubLinea = cbSubFamilia.getSelectedIndex();
            PosConvenio = cbConvenio.getSelectedIndex();
            PosImpuesto = cbOtroImpuesto.getSelectedIndex();
            
            //-----------------------------  trae Transito y Ubicados-----------
            Query ="select \n" +
                    " case sum(cant) when null then 0 else sum(cant) end as cantidad\n" +
                    " from mt_productos\n" +
                    " where sku = '" + Codigo + "'\n" +
                    " and ubicacion not in  ('" +  fmMain.BodegaOCDirecta() +   "','"  + fmMain.BodegaTransito() + "','"  + fmMain.BodegaAnticipada() + "','"  + fmMain.BodegaNegativos() + "' ,'"  + fmMain.BodegaPositivos() + "')";
                    //" and ubicacion not in  ('" + fmMain.BodegaTransito() + "','"  + fmMain.BodegaNCC()+ "','" + fmMain.BodegaNCP()+ "','" + fmMain.BodegaOCDirecta()+ "','" + fmMain.BodegaTransformacion()+ "')";
        
                                
              Rs1 = Sql.Select(Query);
              if (Rs1.next()){
                  txUbicados.setText(String.valueOf(Rs1.getDouble("cantidad")));
              }
            
            Query ="select \n" +
                    " case sum(cant) when null then 0 else sum(cant) end as cantidad\n" +
                    " from mt_productos\n" +
                    " where sku = '" + Codigo + "'\n" +
                    " and ubicacion = '" + fmMain.BodegaTransito() + "'";
                                
              Rs1 = Sql.Select(Query);
              if (Rs1.next()){
                  txTransito.setText(String.valueOf(Rs1.getDouble("cantidad")));
              }
            
            //------------------------------------------------------------------
            
            CargaMovimientos(Codigo);
            CargaVentas(Codigo);
            CargaCompras(Codigo);
            CargaRelacion(Codigo);
            SetTipo(2);
            cargarImagenDesdeBd();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Sql.Close();
        }
    }

private void carga_facturas_orden(String StOrden){
    ExeSql_Econa Sql = new ExeSql_Econa();
        ResultSet Rs,Rs1;
        String Query, QTot="";
        DefaultTableModel TableModel = (DefaultTableModel) GrillaFacturasC.getModel();
   try{     
        Query = "select c.rut,c.nrodocto, c.tipdocto from \n" +
                "ctacteprv c\n" +
                "where \n" +
                "c.nrodocorigen =" + StOrden + "\n" +
                "and c.tipdocorigen  ='OCP' and\n" +
                "c.tipdocto ='FAP'";
        
        
//     Limpia Ordenes Encabezado   
               while(TableModel.getRowCount()>0)
                   TableModel.removeRow(0);    
            
         Rs = Sql.Select(Query);
            
            while(Rs.next()){
               
               TableModel.addRow(new Object[]{Rs.getString("rut").trim(), 
                                              Rs.getInt("nrodocto"),Rs.getString("tipdocto")});
              }
            Rs.close();
       }
catch (Exception e) {
            fmMain.Mensaje("Existe una inconsistencia en la información.");
        }finally{
            Sql.Close();
        }    
        
}

    
    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        if(Tipo==1 || Tipo==3){
            if(JOptionPane.showConfirmDialog(null, "¿Cancelar sin guardar?")==JOptionPane.YES_OPTION){
                if(Tipo==1)
                     SetTipo(-1);
                else
                    CargaProducto(txSku.getText());
                    SetTipo(-1);
            }
        }
       else
            SetTipo(-1);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void cbFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFamiliaActionPerformed
        ExeSql_Econa Sql = new ExeSql_Econa();
        ResultSet Rs;
        int AuxTipo;
        if (Tipo == 2 || Tipo == -1 || Tipo == 3)
            cbFamilia.setSelectedIndex(PosLinea);
        else if (cbFamilia.getSelectedIndex() > -1 && Tipo != -99) {

            cbFamiliaCod.setSelectedIndex(cbFamilia.getSelectedIndex());

            // Carga Combo Linea
            if (cbFamilia.getSelectedIndex() >= 0) {
                int CodLinea = Integer.valueOf(cbFamiliaCod.getSelectedItem().toString());

                cbSubFamilia.removeAllItems();
                cbSubFamiliaCod.removeAllItems();
                cbSubFamiliaSku.removeAllItems();
                AuxTipo=Tipo;
                Tipo=-99;
                try {
                    Rs = Sql.Select("select codigo,sublinea,cod from par_sublinea where linea = " + CodLinea);
                    System.out.println("select codigo,sublinea,cod from par_sublinea where linea = " + CodLinea);
                    while (Rs.next()) {
                        cbSubFamilia.addItem(Rs.getString("sublinea"));
                        cbSubFamiliaCod.addItem(Rs.getString("codigo"));
                        cbSubFamiliaSku.addItem(Rs.getString("cod"));
                    }
                    Tipo=AuxTipo;
                } catch (SQLException ex) {
                    System.out.println(ex);
                } finally {
                    Sql.Close();
                }
            }
            GeneraCodigo();
    }//GEN-LAST:event_cbFamiliaActionPerformed
    }
    private void btIrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIrActionPerformed
//        String codbarfinal = txSku.getText().replace("'", "-");
//        txSku.setText(codbarfinal.trim());
//        if(!txSku.getText().isEmpty() && Tipo != 1)
//             CargaProducto(txSku.getText());
//        else if(!txSku.getText().isEmpty() && Tipo == 1)
//            txNombre.requestFocus();
//        
//        else{
//            jdBuscarProductos BP = new jdBuscarProductos(null, true);
//            BP.setLocationRelativeTo(null);
//            BP.setTitle("Buscar Producto");
//            BP.setVisible(true);
//            if(!"".equals(BP.GetCodigo()))
//                CargaProducto(BP.GetCodigo());
//        }
        carga_producto();    
    }//GEN-LAST:event_btIrActionPerformed

    
    private void carga_producto(){
         String codbarfinal = txSku.getText().replace("'", "-");
        txSku.setText(codbarfinal.trim());
        if(!txSku.getText().isEmpty() && Tipo != 1)
             CargaProducto(txSku.getText());
        else if(!txSku.getText().isEmpty() && Tipo == 1)
            txNombre.requestFocus();
        else{
            jdBuscarProductos_Econa BP = new jdBuscarProductos_Econa(null, true);
            BP.setLocationRelativeTo(null);
            BP.setTitle("Buscar Producto");
            BP.setVisible(true);
            BP.SetCotiza(false);
            if(!"".equals(BP.GetCodigo()))
                CargaProducto(BP.GetCodigo());
        }
    }
    
    public void ActualizarMinimo(){
        ExeSql_Econa Sql = new ExeSql_Econa();
        ResultSet Rs = null, Rs1 = null;
        String Query;
        String Sku = txSku.getText();
        try {
            
                    Query = "UPDATE producto SET\n" +

                            " minimo ="+ txNuevoMinimo.getText() + "," + "calcula_minimo = "  + chk_minimo.isSelected() +
                            " WHERE sku = '" + txSku.getText() + "'";

                    Sql.ExeSql(Query);
                    Sql.Commit();
                    JOptionPane.showMessageDialog(null, "Nuevo Mínimo Registrado");
                    CargaProducto(Sku);
                    txNuevoMinimo.setText("");
                } catch (Exception e) {
                    Sql.Rollback();
                    JOptionPane.showMessageDialog(null, "Error al guardar !!!:\n" + e.getMessage());
                    System.out.println(e);
                } finally {
                    Sql.Close();
                }
        
    }
    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        SetTipo(3);
    }//GEN-LAST:event_btEditarActionPerformed

    private void txSkuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txSkuKeyPressed
            if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                //btIr.doClick();     
                carga_producto();
              } 
             
             else if(Character.isLetter(evt.getKeyChar()) && !chkCodigo.isSelected()){
           
             jdBuscarProductos_Econa BP = new jdBuscarProductos_Econa(null, true);
             BP.setLocationRelativeTo(null);
             BP.setTitle("Buscar Producto");
             BP.SetTexto(txSku.getText() + Character.toString(evt.getKeyChar()));
             //txSku.setText("");  
             BP.setVisible(true);
             BP.SetCotiza(false);
             
             if(!"".equals(BP.GetCodigo())){
                 Limpia();
                 CargaProducto(BP.GetCodigo());
                 
                }
             
        }
    }//GEN-LAST:event_txSkuKeyPressed

    private void txSkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txSkuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txSkuActionPerformed

    private void btNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNuevoActionPerformed
        if(fmMain.GetEstado(fmMain.pnPestanas.getSelectedIndex())==0){
            SetTipo(1);
        }
    }//GEN-LAST:event_btNuevoActionPerformed
    private int AfectoIva(){
        if(chkIva.isSelected())
            return 1;
        else
            return 0;
    }

//-----------------------------------------------------------------------------
//  BOTON GUARDAR
//-----------------------------------------------------------------------------
    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
        ExeSql_Econa Sql = new ExeSql_Econa();
        String Query;   
        String Sku = txSku.getText().trim();
    
    if(cbConvenio.getSelectedIndex()    ==-1    || 
       cbFamilia.getSelectedIndex()     ==-1    || 
       cbSubFamilia.getSelectedIndex()  ==-1    ||
       cbUnidad.getSelectedIndex()==-1){
            JOptionPane.showMessageDialog(null, "Faltan datos");
            return;
    }
        if(fmMain.OkCancel("¿Guardar Cambios?")== JOptionPane.OK_OPTION){
            boolean Publicado = chkPublicado.isSelected();
            boolean SinCompetencia = chkSinCompetencia.isSelected();
            boolean DesxPrecio = chkDesxPrecio.isSelected();
            boolean NoTransado = chkNoTransado.isSelected();
            boolean EnOferta = chkOferta.isSelected();
            boolean Discontinuado = chkDiscontinuado.isSelected();
            boolean SinStock = chkStock.isSelected();
            String PPublico = txPNeto.getText();
            String Peso     = txPeso.getText();
            String Display  = txDisplay.getText();
            String Familia;
            String SubFamilia;
            String Marca;
            String Convenio;
            String OtroImpuesto;
            fmMain.SetGuardar(Display);
            if(PPublico.isEmpty())  PPublico= "0";
            
            
            if (Peso.isEmpty()) {
                Peso = "0";
            }
            if (Display.isEmpty()) {
                Display = null;
            }
            try {
                Familia = cbFamiliaCod.getSelectedItem().toString().trim();
            } catch (Exception e) {
                Familia = "0";
            }

            try {
                SubFamilia = cbSubFamiliaCod.getSelectedItem().toString().trim();
            } catch (Exception e) {
                SubFamilia = "0";
            }

            try {
                Marca = "0";
            } catch (Exception e) {
                Marca = "1";
            }

            try {
                Convenio = cbConvenioCod.getSelectedItem().toString().trim();
            } catch (Exception e) {
                Convenio = "1";
            }

            
            
            if(txNombre.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Debe definir un nombre para el producto");
                return;
            }
            
           //Nuevo Producto
            if (Tipo == 1) {
                try {
                    Query = "INSERT INTO producto\n"
                            //+ "(sku, unidad, nombre, pventa, imptoiva, linea, sublinea, codbar, codigo_cc, peso,marca, display, publicado, oferta, convenio)\n"
                            + "(sku, unidad, nombre, pventa, imptoiva, linea, sublinea, peso,marca, display, publicado, sincompetencia, discontinuado, sinstock, desxprecio, notransado, convenio)\n"
                            + "VALUES \n"
                            + "('" + txSku.getText() + "', "
                            + cbUnidadId.getSelectedItem().toString().trim() + ","
                            + "'" + txNombre.getText().trim() + "',"
                            + PPublico + ","
                            + AfectoIva() + "," 
                            + Familia + ","
                            + SubFamilia + ","
                            //+ fmMain.SetString(txCodBar.getText().trim()) + ","
                            //+ fmMain.SetString(txCodBar2.getText().trim()) + ","
                            + fmMain.SetGuardar(Peso) + ","
                            + Marca + ","
                            + Display + ","
                            + Publicado + ","
                            + SinCompetencia + ","
                            + Discontinuado + ","
                            + SinStock + ","
                            + DesxPrecio + ","
                            + NoTransado + ","
                            + Convenio + ")";
                    System.out.println(Query);
                    Sql.ExeSql(Query);
                    System.out.println("Listo 1");
                    Sql.ExeSql("delete from transformacion where sku='" + txSku.getText() + "'");
                    System.out.println("Listo 2");
                    for(int i=0; i< GrillaRelacion.getRowCount(); i++){
                    Sql.ExeSql("INSERT into TRANSFORMACION (sku,skurel,cantidad) VALUES ("
                        + "'" + txSku.getText() + "',"
                        + "'" + GrillaRelacion.getValueAt(i, 0).toString().trim() + "',"
                        + GrillaRelacion.getValueAt(i, 2).toString() + ")");
                    }
                    Sql.Commit();
                    guardarImagen(); //Cuando este OK
                    JOptionPane.showMessageDialog(null, "Producto Guardado");
                    SetTipo(-1);
                    CargaProducto(Sku);
                    
                } catch (Exception e) {
                    Sql.Rollback();
                    JOptionPane.showMessageDialog(null, "Error al guardar2 " + e.getMessage());
                } finally {
                    Sql.Close();
                }
            }
           //Update Producto
           else if (Tipo == 3) {
                try {
                    Query = "UPDATE producto SET\n"
                            + "  unidad= " + cbUnidadId.getSelectedItem().toString().trim()
                            + ", nombre='" + txNombre.getText().trim() + "'"
                            + ", pventa=" + PPublico
                            + ", linea=" + cbFamiliaCod.getSelectedItem().toString().trim()
                            + ", sublinea=" + cbSubFamiliaCod.getSelectedItem().toString().trim()
                            //+ ", codbar=" + fmMain.SetString(txCodBar.getText().trim())
                            //+ ", codigo_cc=" + fmMain.SetString(txCodBar2.getText().trim())
                            + ", peso=" + fmMain.SetGuardar(Peso)
                            + ", display=" + Display
                            + ", publicado=" + Publicado
                            + ", sincompetencia=" + SinCompetencia
                            //+ ", oferta=" + EnOferta
                            + ", discontinuado=" + Discontinuado
                            + ", sinstock=" + SinStock
                            + ", desxprecio=" + DesxPrecio
                            + ", notransado=" + NoTransado
                            + ", marca=" + Marca
                            + ", convenio=" + Convenio
                            + "  WHERE sku = '" + txSku.getText() + "'";
                    Sql.ExeSql(Query);
                    Sql.ExeSql("delete from transformacion where sku='" + txSku.getText() + "'");
            
                    for(int i=0; i< GrillaRelacion.getRowCount(); i++){
                    Sql.ExeSql("INSERT into TRANSFORMACION (sku,skurel,cantidad) VALUES ("
                        + "'" + txSku.getText() + "',"
                        + "'" + GrillaRelacion.getValueAt(i, 0).toString().trim() + "',"
                        + GrillaRelacion.getValueAt(i, 2).toString() + ")");
                    }
                    Sql.Commit();
                    guardarImagen();  // comentar
                    JOptionPane.showMessageDialog(null, "Producto Guardado");
                    SetTipo(-1);
                    CargaProducto(Sku);
                } catch (Exception e) {
                    Sql.Rollback();
                    JOptionPane.showMessageDialog(null, "Error al guardar !!!:\n" + e.getMessage());
                    System.out.println(e);
                } finally {
                    Sql.Close();
                }
            }
       }
    }//GEN-LAST:event_btGuardarActionPerformed

    
    public void guardarImagen(){
        ExeSql_Econa Sql = new ExeSql_Econa();
         String qryInsAudito;
         String Query ="";
         String sku;
         sku = txSku.getText();
         Image img;
//         ImageIcon icon = (ImageIcon) lbImagen.getIcon();
//         BufferedImage image = new BufferedImage(icon.getIconWidth(),
//         icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
//         Image scaledInstance = img.getScaledInstance(170, 170, Image.SCALE_DEFAULT);
//         lbImagen.setIcon(new ImageIcon(scaledInstance));
//         lbImagen.setText("");
//         guardo=0;
         
         if (lbImagen.getIcon()==null)
         {
             return;
         }
        ImageIcon icon = (ImageIcon) lbImagen.getIcon();
        BufferedImage imgproc = new BufferedImage(icon.getIconWidth(),
        icon.getIconHeight(),BufferedImage.TYPE_INT_RGB);
        Graphics g = imgproc.createGraphics(); 
        icon.paintIcon(null, g, 0,0);
                g.setColor(Color.WHITE);
                g.dispose();
 

        
        
        Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");

        System.out.println(date.format(now));
        System.out.println(hour.format(now));
        System.out.println(now);
        try {
                String ruta ="";
                String sistema = System.getProperty("os.name").toLowerCase();
                 File folder = new File("");
                   if (sistema.contains("win"))
                   {
                       ruta = "c:/fotosproductos/";
                       folder = new File(ruta.substring(0,ruta.length()-1));
                   }
                   else{
                       ruta = "/fotosproductos/";
                        folder = new File(ruta);
                   } 
            System.out.println("1- indica la ruta");
            System.out.println(ruta);
           
            System.out.println("2- pregunta Si la ruta Existe");
            if (!folder.exists())
            {
                folder.mkdir();
                System.out.println("3");
            }

            System.out.println("4-Indicamos Ruta - Directorio estaba creado");
            System.out.println(ruta+sku+".png");
            File file = new File(ruta+sku+".png");
            System.out.println("4-1 (");
            file.setReadable(true);
            System.out.println("4-2");
            ImageIO.write((RenderedImage) imgproc, "png", file);
            System.out.println("5");
            
            
            //SubeFTP Sube = new SubeFTP();
            String laruta = ruta+sku+".png";
            String rutafinal = sku+".png";
            
            //CODIGO ACTIVAR ---------------------------------------------------------------------------
            SubeFTP.SubeArch(laruta, rutafinal);   
            Query = " update producto set imagen = '\\\\\\\\192.168.0.130\\\\fotosproductos\\\\" + rutafinal + "' where sku='" + sku +"'" ;
            Sql.ExeSql(Query);
            //CODIGO ACTIVAR ---------------------------------------------------------------------------
            
            Sql.Commit();
            guardo=1;
            //fmMain.Mensaje("Se ha guardado la imagen correctamente");
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            fmMain.Mensaje("Verifique que este creada la carpeta c:\\fotosproductos\\ y que tenga conexion al servidor 130");
        } catch (SQLException ex) {
            Logger.getLogger(jdVoucher.class.getName()).log(Level.SEVERE, null, ex);
            Sql.Rollback();
        }
        finally{
            Sql.Close();
            
        }
    }
    
    public void cargarImagenDesdeBd(){
        ResultSet Rs;
        ExeSql_Econa Sql = new ExeSql_Econa();
        String server,user,pass,ruta_local="";
        int puerto =21;
        String rutaimage="";
        String sku ="";
        String skuBusca = txSku.getText();
        try {

//            server= "192.168.0.130";
//            user="voucher";
//            pass="V2369";
            
            
           //trae datos ftp
            server="";
            puerto=0;
            user=""; 
            pass="";
            	Rs = Sql.Select("SELECT * from conexiones where usu='fotoproducto'");
                if (Rs.next())
                {
                    server = Rs.getString("serv");
                    user  = Rs.getString("usu");
                    puerto  = Rs.getInt("port");
                    pass = Rs.getString("pass");
                }
           //trae datos ftp
            
            Rs = Sql.Select("SELECT imagen, sku from producto where sku='"+skuBusca+"';");
            Rs.next();
            if (Rs.getInt("sku")>=1)
            {
                if (sku.equals("")){
                    sku = Rs.getString("sku");
                }                    
                Rs = Sql.Select("SELECT imagen, sku from producto where sku='"+skuBusca+"';");
                Rs.next();
                if (Rs.getString("imagen") != null)
                {

                    //Verifica SO
                    String sistema = System.getProperty("os.name").toLowerCase();
                    File folder = new File("");
                    if (sistema.contains("win"))
                    {
                         ruta_local = "c:/fotosproductos/";
                         folder = new File(ruta_local.substring(0,ruta_local.length()-1));
                    }
                    else{
                          ruta_local = "/fotosproductos/";
                          folder = new File(ruta_local);
                    }
                    if (!folder.exists())
                    {
                        folder.mkdir();
                    }
                    
                    rutaimage=Rs.getString("imagen");
                    String archivo = rutaimage.substring(35,rutaimage.length());
                    Ftp.baja_archivo_ftp(server, puerto,user, pass,"/"+archivo,ruta_local + archivo);
                    
                    
                     File file = new File(ruta_local+archivo);
//                     BufferedImage read = ImageIO.read(file);
//                    Image scaledInstance = read.getScaledInstance(220, 220, Image.SCALE_DEFAULT);
//                    lbImagen.setIcon(new ImageIcon(scaledInstance));
//                    lbImagen.setText("");
                    
                     try{
                                fis=new FileInputStream(file);
                                //necesitamos saber la cantidad de bytes
                                this.longitudBytes=(int)file.length();
                                try {
                                    Image icono=ImageIO.read(file).getScaledInstance
                                            (lbImagen.getWidth(),lbImagen.getHeight(),Image.SCALE_DEFAULT);
                                    lbImagen.setIcon(new ImageIcon(icono));
                                    lbImagen.updateUI();

                                } catch (IOException ex) {
                                }
                            }catch(FileNotFoundException ex){
                                ex.printStackTrace();
                            }
                    
                    
                    
                    
                }
               
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        finally{
            Sql.Close();
            
        }
    }
    
    
    
    
    private void cbUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUnidadActionPerformed
        if(Tipo==2 || Tipo==-1)
            cbUnidad.setSelectedIndex(PosUM);
        else if(Tipo!=-99)
        cbUnidadId.setSelectedIndex(cbUnidad.getSelectedIndex());
    }//GEN-LAST:event_cbUnidadActionPerformed

    private void cbSubFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSubFamiliaActionPerformed
        if(Tipo==2 || Tipo==-1 || Tipo==3)
            cbSubFamilia.setSelectedIndex(PosSubLinea);
        else if(cbSubFamilia.getSelectedIndex()>=0 && cbSubFamiliaCod.getItemCount()>0 ){
            cbSubFamiliaCod.setSelectedIndex(cbSubFamilia.getSelectedIndex());
            GeneraCodigo();
        }
            
    }//GEN-LAST:event_cbSubFamiliaActionPerformed

    private void cbConvenioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbConvenioActionPerformed
        if(Tipo==2 || Tipo==-1 || Tipo==3)
            cbConvenio.setSelectedIndex(PosConvenio);
        else if(Tipo==1){
            cbConvenioCod.setSelectedIndex(cbConvenio.getSelectedIndex());
            CargaLineas();
        }
        else if (Tipo != -99 ){
           cbConvenioCod.setSelectedIndex(cbConvenio.getSelectedIndex());
           GeneraCodigo();
        }

    }//GEN-LAST:event_cbConvenioActionPerformed

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btEliminarActionPerformed

    private void txPesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txPesoKeyTyped
       if(evt.getKeyChar()==',' || evt.getKeyChar()=='.' ){
            evt.consume();
            if(!txPeso.getText().contains(fmMain.GetDecimal()))
                txPeso.setText(txPeso.getText() + fmMain.GetDecimal() );
        }
    }//GEN-LAST:event_txPesoKeyTyped

    private void txNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNombreActionPerformed

    private void txNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNombreKeyTyped
       int asciivalor; 
//         if(evt.getKeyChar()==',' || evt.getKeyChar()=='.'    ){
//            evt.consume();
//        }
        
            char c=evt.getKeyChar(); 
            asciivalor = (int) c;
            
            
            switch (asciivalor){
            case 39:
            case 44:
            //case 46:
              getToolkit().beep(); 
              evt.consume(); 
              System.out.println("Ingresar sin apostrofes, comas ni puntos" + "  caracter---> " + evt.getKeyChar() + "   (-----)    codigo ascii " + asciivalor ); 
            }  
            
//             if(asciivalor == 39) { 
//              getToolkit().beep(); 
//              evt.consume(); 
//              System.out.println("Ingresar sin apostrofes  ." ); 
//         }  
        
        if (Character.isLowerCase(evt.getKeyChar()))
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));        // TODO add your handling code here:
    }//GEN-LAST:event_txNombreKeyTyped

    private void cbConvenioCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbConvenioCodActionPerformed
        if(Tipo!=-99)    
            cbConvenioSku.setSelectedIndex(cbConvenioCod.getSelectedIndex());
            
    }//GEN-LAST:event_cbConvenioCodActionPerformed

    private void cbFamiliaCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFamiliaCodActionPerformed
        if(Tipo!=-99)   
            cbFamiliaSku.setSelectedIndex(cbFamiliaCod.getSelectedIndex());
    }//GEN-LAST:event_cbFamiliaCodActionPerformed

    private void cbSubFamiliaCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSubFamiliaCodActionPerformed
        if(Tipo!=-99)   
            cbSubFamiliaSku.setSelectedIndex(cbSubFamiliaCod.getSelectedIndex());
    }//GEN-LAST:event_cbSubFamiliaCodActionPerformed

    private void btAgregaRelacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregaRelacionActionPerformed
        jdBuscarProductos_Econa BP = new jdBuscarProductos_Econa(null, true);
        BP.setLocationRelativeTo(null);
        BP.setTitle("Buscar Producto");
        BP.setVisible(true);
        if(!BP.GetCodigo().isEmpty()){
            String Cantidad;
            DefaultTableModel TableModel = (DefaultTableModel) GrillaRelacion.getModel();
            Cantidad = JOptionPane.showInputDialog("Cantidad");
             Cantidad=Cantidad.replace(",", "."); 
            
             TableModel.addRow(new Object[] {BP.GetCodigo(),BP.GetNombre(),Cantidad});
            
        }
    }//GEN-LAST:event_btAgregaRelacionActionPerformed

    private void btEliminaRelacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminaRelacionActionPerformed
        if(fmMain.OkCancel("¿Eliminar Producto?")== JOptionPane.OK_OPTION){
            DefaultTableModel TableModel = (DefaultTableModel) GrillaRelacion.getModel();
            TableModel.removeRow(GrillaRelacion.getSelectedRow());
        }
    }//GEN-LAST:event_btEliminaRelacionActionPerformed

    private void cbOtroImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOtroImpuestoActionPerformed
        if(Tipo==2 || Tipo==-1)
            cbOtroImpuesto.setSelectedIndex(PosImpuesto);
        else if(Tipo!=-99){
            cbOtroImpuestoId.setSelectedIndex(cbOtroImpuesto.getSelectedIndex());
            cbOtroImpuestoTaza.setSelectedIndex(cbOtroImpuesto.getSelectedIndex());
            txTazaImpuesto.setText(cbOtroImpuestoTaza.getSelectedItem().toString().trim() + "%");
        }
            
    }//GEN-LAST:event_cbOtroImpuestoActionPerformed

    private void cbOtroImpuestoIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOtroImpuestoIdActionPerformed
        if(Tipo!=-99)    {
            cbOtroImpuesto.setSelectedIndex(cbOtroImpuestoId.getSelectedIndex());
            cbOtroImpuestoTaza.setSelectedIndex(cbOtroImpuestoId.getSelectedIndex());
            txTazaImpuesto.setText(cbOtroImpuestoTaza.getSelectedItem().toString().trim() + "%");
        }
            
            cbConvenioSku.setSelectedIndex(cbConvenioCod.getSelectedIndex());
    }//GEN-LAST:event_cbOtroImpuestoIdActionPerformed

    private void MnuAbrirOCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuAbrirOCCActionPerformed
        pfOCCliente OCC = new pfOCCliente();
        OCC.AbreOCC(GrillaVenta.getValueAt(GrillaVenta.getSelectedRow(),1).toString().trim(),GrillaVenta.getValueAt(GrillaVenta.getSelectedRow(),3).toString().trim(),GrillaVenta.getValueAt(GrillaVenta.getSelectedRow(),4).toString().trim());
        pnPestanas.addTab("OC Cliente", OCC);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(OCC), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
    }//GEN-LAST:event_MnuAbrirOCCActionPerformed

    private void MnuAbrirOCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuAbrirOCPActionPerformed
        pfOCProveedor PrvOC = new pfOCProveedor();
        PrvOC.AbrirOCP(GrillaCompras.getValueAt(GrillaCompras.getSelectedRow(), 3).toString().trim());
        pnPestanas.addTab("OC Proveedor", PrvOC);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(PrvOC), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
    }//GEN-LAST:event_MnuAbrirOCPActionPerformed

    private void dtFinOferKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dtFinOferKeyPressed

    }//GEN-LAST:event_dtFinOferKeyPressed

    private void dtFinOferKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dtFinOferKeyTyped
        char car =evt.getKeyChar();
        if(((car<'0') || (car>'9')) && ((car<'.') || (car>'.')))
        {

            evt.consume();
        }
    }//GEN-LAST:event_dtFinOferKeyTyped

    private void dtInicioOferKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dtInicioOferKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_dtInicioOferKeyPressed

    private void dtInicioOferKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dtInicioOferKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_dtInicioOferKeyTyped

    private void chkOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkOfertaActionPerformed
        if (chkOferta.isSelected())
             {
            dtInicioOfer.setEnabled(true);
            dtInicioOfer.setDate(Calendar.getInstance().getTime());
            dtFinOfer.setEnabled(true);
            dtFinOfer.setDate(Calendar.getInstance().getTime());
            btGuardarOfer.setEnabled(true);
            }
        if (!chkOferta.isSelected())
                {
            dtInicioOfer.setEnabled(false);
            dtFinOfer.setEnabled(false);
            btGuardarOfer.setEnabled(false);
        }
    }//GEN-LAST:event_chkOfertaActionPerformed

    private void btGuardarOferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarOferActionPerformed
        ResultSet Rs;
        String upOfer;
        ExeSql_Econa Sql = new ExeSql_Econa();

        
        try {
                    upOfer = "UPDATE producto SET\n"
                            + "  oferta= true" 
                            + ", oferta_inicio='" + getFechaInicio() + "'"
                            + ", oferta_fin='" + getFechaFin() + "'"
                            + ", oferta_conta = oferta_conta+1 "
                            + "  WHERE sku = '" + txSku.getText() + "'";
                    Sql.ExeSql(upOfer);
                    
                    Sql.Commit();
                    JOptionPane.showMessageDialog(null, "Oferta Guardada");

                } catch (Exception e) {
                    Sql.Rollback();
                    JOptionPane.showMessageDialog(null, "Error al guardar !!!:\n" + e.getMessage());
                    System.out.println(e);
                } finally {
                    Sql.Close();
                }
    }//GEN-LAST:event_btGuardarOferActionPerformed

    private void btAgregaIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregaIDActionPerformed
        // TODO add your handling code here:
        if (!txSku.getText().toString().trim().equals("") || !txNombre.getText().toString().trim().equals(""))
        {
            jdAgregaIDCH_Econa agregarCH = new jdAgregaIDCH_Econa(null, true);
            agregarCH.setLocationRelativeTo(null);
            agregarCH.Datos(txSku.getText().toString().trim(), txNombre.getText().toString().trim());
            agregarCH.setTitle("Agregar ID");
            agregarCH.setVisible(true);
            ResultSet Rs;
            ExeSql_Econa Sql = new ExeSql_Econa();
            DefaultListModel modelo2 = new DefaultListModel();
            lsChilecompras.setModel(modelo2);
            try{
                 Rs = Sql.Select("select idch from codchile where sku='" + txSku.getText().trim() +"'");
                 modelo2.clear();
                 while (Rs.next())
                 {
                     modelo2.addElement(Rs.getString("idch").trim());
                 }
            }
            catch (Exception e)
            {
                
            }
            finally{
                Sql.Close();
            }
        }
        
        
    }//GEN-LAST:event_btAgregaIDActionPerformed

    private void btEliminaIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminaIDActionPerformed
        if(lsChilecompras.getSelectedIndex() !=-1)
            if(JOptionPane.showConfirmDialog(null, "¿Desea Eliminar el ID?") == JOptionPane.YES_OPTION){
                ResultSet Rs;
                ExeSql_Econa Sql = new ExeSql_Econa();
                try{
              
                    Sql.ExeSql("DELETE from codchile where sku='"+txSku.getText().toString().trim()+"' and idch='"+lsChilecompras.getSelectedValue().toString().trim()+ "'");

                    Sql.Commit();
                    fmMain.Mensaje("ID ELIMINADA");

                    }
                    catch (Exception e){  
                        Sql.Rollback();
                        fmMain.Mensaje("Error al eliminar: "+e);
                        return;
                    }
                    finally{
                        Sql.Close();
                        }
                DefaultListModel model = (DefaultListModel) lsChilecompras.getModel();
                model.remove(lsChilecompras.getSelectedIndex());
            }
        
    }//GEN-LAST:event_btEliminaIDActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void GrillaFacturasCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrillaFacturasCMouseClicked
        // TODO add your handling code here:
        //System.out.println( Grilla_Det.getValueAt(Grilla_Det.getSelectedRow(), 2).toString().trim());
        
            String Tipodoc = GrillaFacturasC.getValueAt(GrillaFacturasC.getSelectedRow(), 2).toString().trim();
            String nrodoc = GrillaFacturasC.getValueAt(GrillaFacturasC.getSelectedRow(), 1).toString().trim();
            String rut  = GrillaFacturasC.getValueAt(GrillaFacturasC.getSelectedRow(), 0).toString().trim();
        
            
            
        if (Tipodoc.equals("FAP")  )
        {    
                pfFAProveedor Pro = new pfFAProveedor();
                Pro.setOpaque(false);
                pnPestanas.addTab("Factura Proveedor", Pro);
                PanelTab btc = new PanelTab(pnPestanas, 0);
                pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Pro), btc);
                pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
                Pro.CargaFactura(rut,nrodoc);
                
        }
//        else if (Tipodoc.equals("NCP")    )
//        {    
//                pfNCPProveedor NCP = new pfNCPProveedor();
//                NCP.setOpaque(false);
//                pnPestanas.addTab("Nota Credito Proveedor", NCP);
//                PanelTab btc = new PanelTab(pnPestanas, 0);
//                pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(NCP), btc);
//                pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
//                 NCP.AbrirNCP(rut, nrodoc);
//        }
//        
        
        
        
        
  
    }//GEN-LAST:event_GrillaFacturasCMouseClicked

    private void GrillaComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrillaComprasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_GrillaComprasMouseClicked

    private void btUbicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUbicaActionPerformed
        // TODO add your handling code here:
          jd_UbicacionesP_Econa Ubicacion = new jd_UbicacionesP_Econa(null, true);
         Ubicacion.CargaBultos(txSku.getText().trim(),txNombre.getText().trim());
         Ubicacion.selecciona_reg();
                  
            Ubicacion.setVisible(true);
//            txtUbicacionOrig.setText(Ubicacion.GetUbicacionCod());
//            txNombreUbicaOrig.setText(Ubicacion.GetUbicacion());
    }//GEN-LAST:event_btUbicaActionPerformed

    private void MnuCopia_OCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuCopia_OCActionPerformed
        // TODO add your handling code here:
        //Copiar Ordenes
        if((!GrillaVenta.getValueAt(GrillaVenta.getSelectedRow(), 3).toString().trim().isEmpty()) && (!GrillaVenta.getValueAt(GrillaVenta.getSelectedRow(), 4).toString().trim().isEmpty())){
            StringSelection Voucher = new StringSelection(GrillaVenta.getValueAt(GrillaVenta.getSelectedRow(), 3).toString().trim() + "-" + GrillaVenta.getValueAt(GrillaVenta.getSelectedRow(), 4).toString().trim());
            Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
            cb.setContents(Voucher, null);
        }
    }//GEN-LAST:event_MnuCopia_OCActionPerformed

    private void txMinimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txMinimoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txMinimoActionPerformed

    private void btGuardarMinimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarMinimoActionPerformed
        String NuevoMinimo = txNuevoMinimo.getText();
        if(!txNuevoMinimo.getText().equals("")){
            if(fmMain.OkCancel("El mínimo actual de "+txNombre.getText()+" es "+txMinimo.getText()+", ¿Quiere que el nuevo mínimo sea "+txNuevoMinimo.getText()+"?")== JOptionPane.OK_OPTION){
            ActualizarMinimo();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debe ingresar un valor al campo Nuevo Mínimo");
        }
    }//GEN-LAST:event_btGuardarMinimoActionPerformed

    private void txNuevoMinimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNuevoMinimoActionPerformed

    }//GEN-LAST:event_txNuevoMinimoActionPerformed

    private void txNuevoMinimoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNuevoMinimoKeyTyped
        char C= evt.getKeyChar();
        if(Character.isLetter(C)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Ingrese solo Números");
            txNuevoMinimo.setCursor(null);
        }else if((int)evt.getKeyChar()>=32 && (int)evt.getKeyChar()<=47 || (int)evt.getKeyChar()>=58 && (int)evt.getKeyChar()<=64
                ||(int)evt.getKeyChar()>=91 && (int)evt.getKeyChar()<=96 || (int)evt.getKeyChar()>=123 && (int)evt.getKeyChar()<=255){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Ingrese solo Números");
            txNuevoMinimo.setCursor(null);
        }
    }//GEN-LAST:event_txNuevoMinimoKeyTyped

    private void btCargarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCargarImagenActionPerformed
        
                String ruta ="";
                String sistema = System.getProperty("os.name").toLowerCase();
                 
                   if (sistema.contains("win"))
                   {
                       ruta = "c:/fotografias/";
                   }
                   else{
                       ruta = "/fotografias/";
                   } 
        
        
        
        
        
        lbImagen.setIcon(null);
        JFileChooser j=new JFileChooser(ruta);
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);//solo archivos y no carpetas
        int estado=j.showOpenDialog(null);
        if(estado== JFileChooser.APPROVE_OPTION){
            try{
                fis=new FileInputStream(j.getSelectedFile());
                //necesitamos saber la cantidad de bytes
                this.longitudBytes=(int)j.getSelectedFile().length();
                try {
                    Image icono=ImageIO.read(j.getSelectedFile()).getScaledInstance
                            (lbImagen.getWidth(),lbImagen.getHeight(),Image.SCALE_DEFAULT);
                    lbImagen.setIcon(new ImageIcon(icono));
                    lbImagen.updateUI();

                } catch (IOException ex) {
                }
            }catch(FileNotFoundException ex){
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btCargarImagenActionPerformed

    private void lsChilecomprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lsChilecomprasMouseClicked
             


    }//GEN-LAST:event_lsChilecomprasMouseClicked
    public void setRel(String sku) {
        jTextField5.setText(sku);
    }
    
    private void lsChilecomprasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lsChilecomprasMousePressed
       
    }//GEN-LAST:event_lsChilecomprasMousePressed

    private void lsChilecomprasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lsChilecomprasMouseReleased
           // TODO add your handling code here:
    }//GEN-LAST:event_lsChilecomprasMouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ExeSql sql_luvaly = new ExeSql();
        ExeSql_Econa sql_econa = new ExeSql_Econa();
        ResultSet rs = null;
        String sku_luvaly = jTextField5.getText().trim();
        if(!txSku.getText().equals("")){
            String sku = txSku.getText().trim();
            String sql = "select rel_luvaly from producto where sku = '"+sku+"'";
            try {
                rs = sql_econa.Select(sql);
                rs.next();
                if(rs.getRow()>0){
                    if(rs.getString("rel_luvaly").equals("0")){
                        if(JOptionPane.showConfirmDialog(null, "No tiene código Luvaly asociado\n"
                                + "Desea asociar el SKU: "+jTextField5.getText().trim()+" ?")==0){
                            int resultado = sql_econa.ExeSqlInt("update producto set rel_luvaly = '"+jTextField5.getText().trim()+"' where sku = '"+sku+"'");
                            if(resultado >0){
                                JOptionPane.showMessageDialog(null, "Se asoció con éxito.");
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "No se pudo asociar.");
                            }
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Ya posee un SKU relacionado.");
                        if(JOptionPane.showConfirmDialog(null, "Desea asociar el SKU: "+jTextField5.getText().trim()+" ?")==0){
                            int resultado = sql_econa.ExeSqlInt("update producto set rel_luvaly = '"+jTextField5.getText().trim()+"' where sku = '"+sku+"'");
                            if(resultado >0){
                                JOptionPane.showMessageDialog(null, "Se asoció con éxito.");
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "No se pudo asociar.");
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Se conservó el SKU relacionado.");
                        }
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Se existe producto en base de datos.");
                }
            } catch (SQLException ex) {
                Logger.getLogger(pfProductos_Econa.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally {
                sql_econa.Close();
                sql_luvaly.Close();
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Debe cargar un producto.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public String getFechaInicio() {
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
return( sdf.format( (dtInicioOfer.getDate()).getTime() ) );
}
       
    public String getFechaFin() {
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
return( sdf.format( (dtFinOfer.getDate()).getTime() ) );
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable GrillaCompras;
    private javax.swing.JTable GrillaFacturasC;
    private javax.swing.JTable GrillaMovimientos;
    private javax.swing.JTable GrillaRelacion;
    private javax.swing.JTable GrillaVenta;
    private javax.swing.JMenuItem MnuAbrirOCC;
    private javax.swing.JMenuItem MnuAbrirOCP;
    private javax.swing.JMenuItem MnuCopia_OC;
    private javax.swing.JPopupMenu MnuOCC;
    private javax.swing.JPopupMenu MnuOCP;
    private javax.swing.JTabbedPane Pestanas;
    private javax.swing.JButton btAgregaID;
    private javax.swing.JButton btAgregaRelacion;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btCargarImagen;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btEliminaID;
    private javax.swing.JButton btEliminaRelacion;
    private javax.swing.JButton btEliminar;
    private javax.swing.ButtonGroup btGroupMovimientos;
    private javax.swing.ButtonGroup btGroupProveedor;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btGuardarMinimo;
    private javax.swing.JButton btGuardarOfer;
    private javax.swing.JButton btIr;
    private javax.swing.JButton btNuevo;
    private javax.swing.JButton btUbica;
    private javax.swing.JComboBox cbConvenio;
    private javax.swing.JComboBox cbConvenioCod;
    private javax.swing.JComboBox cbConvenioSku;
    private javax.swing.JComboBox cbFamilia;
    private javax.swing.JComboBox cbFamiliaCod;
    private javax.swing.JComboBox cbFamiliaSku;
    private javax.swing.JComboBox cbOtroImpuesto;
    private javax.swing.JComboBox cbOtroImpuestoId;
    private javax.swing.JComboBox cbOtroImpuestoTaza;
    private javax.swing.JComboBox cbSubFamilia;
    private javax.swing.JComboBox cbSubFamiliaCod;
    private javax.swing.JComboBox cbSubFamiliaSku;
    private javax.swing.JComboBox cbUnidad;
    private javax.swing.JComboBox cbUnidadId;
    private javax.swing.JCheckBox chkCodigo;
    private javax.swing.JCheckBox chkDesxPrecio;
    private javax.swing.JCheckBox chkDiscontinuado;
    private javax.swing.JCheckBox chkIva;
    private javax.swing.JCheckBox chkNoTransado;
    private javax.swing.JCheckBox chkOferta;
    private javax.swing.JCheckBox chkPublicado;
    private javax.swing.JCheckBox chkSinCompetencia;
    private javax.swing.JCheckBox chkStock;
    private javax.swing.JCheckBox chk_minimo;
    private org.jdesktop.swingx.JXDatePicker dtFinOfer;
    private org.jdesktop.swingx.JXDatePicker dtInicioOfer;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel lbImagen;
    private javax.swing.JLabel lbNuevoMinimo;
    public javax.swing.JList<String> lsChilecompras;
    private javax.swing.JList lsCodbar;
    private javax.swing.JPanel pnDetalle;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JTextField txCreacionFecha;
    private javax.swing.JTextField txCreacionUsuario;
    private javax.swing.JTextField txDisplay;
    private javax.swing.JTextField txMargen;
    private javax.swing.JTextField txMinimo;
    private javax.swing.JTextField txNombre;
    private javax.swing.JTextField txNuevoMinimo;
    private javax.swing.JTextField txPCosto;
    private javax.swing.JTextField txPNeto;
    private javax.swing.JTextField txPPublico;
    private javax.swing.JTextField txPUltCompra;
    private javax.swing.JTextField txPeso;
    private javax.swing.JTextField txPosicion;
    private javax.swing.JTextField txSeparado;
    public javax.swing.JTextField txSku;
    private javax.swing.JTextField txStockGDC;
    private javax.swing.JTextField txStockInv;
    private javax.swing.JTextField txStockOCC;
    private javax.swing.JTextField txStockOCP;
    private javax.swing.JTextField txStockTotal;
    private javax.swing.JTextField txTazaImpuesto;
    private javax.swing.JTextField txTransito;
    private javax.swing.JTextField txTransporte;
    private javax.swing.JTextField txUbicados;
    // End of variables declaration//GEN-END:variables
}
