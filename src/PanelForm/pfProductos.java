package PanelForm;

import Conexion.Disosur.ExeSqlDisosur;
import Conexion.Econa.ExeSql_Econa;
import java.sql.ResultSet;
import java.sql.SQLException;
import Conexion.ExeSql;
import Conexion.ExeSql1_Mysql;
import Dialogos.jdAgregaIDCH;
import Dialogos.jdAgregaIDCHMADRE;
import Dialogos.jdBuscaAsjustesPend;
import Dialogos.jdBuscaFolioAud;
import Dialogos.jdBuscaVentasAntPend;
import Dialogos.jdBuscarCliPrv;
import Dialogos.jdBuscarProductos;
import Dialogos.jdBuscarProductosTransforma;
import Dialogos.jdCargaValores;
import Dialogos.jdFechaLlegadaProveedor;
import Dialogos.jdImagenProducto;
import Dialogos.jdNuevoSku;
import Dialogos.jdRelacionadosReporte;
import Dialogos.jdRelacionarProductos;
import Dialogos.jdVoucher;
import java.security.Principal;
import Dialogos.jd_UbicacionesP;
import Formularios.fmMain;
import static Formularios.fmMain.pnPestanas;
import Utilidades.ComboCodigos;
import Utilidades.Ftp;
import Utilidades.PanelTab;
import Utilidades.SubeFTP;
import Utilidades.MyCellRenderer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ValueAxis;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.DefaultCaret;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.apache.commons.math3.util.Precision;

/**
 *
 * @author DavidAlcaman
 */
public class pfProductos extends javax.swing.JPanel {

    int PosUM;
    int PosLinea;
    int PosSubLinea;
    int PosImpuesto;
    int PosMarca;
    int PosConvenio;
    boolean IVA;

    double precioWeb = 0;
    double precioWeb2 = 0;

    int actualizaWeb = 0;
    int compra = 0;
    int compra2 = 0;

    int cargaocp = 0;

    boolean existe = false;

    double ultcompra = 0;
    double propuesta = 0;
    double preciopublica = 0;
    double comision = 0;
    double envio = 0;
    double publicadoIVA = 0;
    double publicadoNETO = 0;
    double Margen2 = 0;

    double largo = 0;
    double ancho = 0;
    double alto = 0;

    double TotalM3 = 0;

    String TablaConvenio = "";

    FileInputStream fis;
    int longitudBytes;
    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();

    int Tipo = -1; //-1 Nada de nada      1 Nuevo      2 Abierto      3.Editando
    public int guardo = 0;
    public static Color DARK_GREEN = new Color(0, 153, 0);
    //****************************************************************************** 

    Calendar calendario = Calendar.getInstance();
    Calendar calendario1 = Calendar.getInstance();
    Calendar calendario2 = Calendar.getInstance();
    Calendar calendario3 = Calendar.getInstance();
    Calendar calendario4 = Calendar.getInstance();
    Calendar calendario5 = Calendar.getInstance();
    Calendar calendario6 = Calendar.getInstance();

    DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols();

    DecimalFormat decimalformat = null;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    DefaultTableModel tModel = null;

    String fechaIni = "";
    String fechaFin = "";

    String ucant = "";

    int Carga = 0;

    //************************************************************************    
    public pfProductos() {
        initComponents();
        iniciarPestanaLotes();
        txSku.requestFocus();
        Tipo = -99;
        CargaUnidades();
        CargaLineas();
        CargaConvenios();

        CargaOtrosImpuestos();

        btCargarImagen.setVisible(false);

        int intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());

        if (intNivelUsuario == 100) {
            btCargarImagen.setVisible(true);
        }

        Tipo = 0;
        cbConvenio.setSelectedIndex(-1);
        cbFamilia.setSelectedIndex(-1);
        cbUnidad.setSelectedIndex(-1);
        Tipo = -1;
        Edicion(false);
        Habilita(false);
        url_mercado.setEnabled(false);
        url_web.setEnabled(false);
        url_yapo.setEnabled(false);
        valor_publico.setEnabled(false);
        valor_mercadolibre.setEnabled(false);
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
        chkdeshabilitado.setEnabled(false);
        btEstablecerRelacionado.setEnabled(false);
        btBuscarRelacionado.setEnabled(false);
        txtCrearRelacion.setEnabled(false);
        valor_vendedor.setEnabled(false);
        jButton4.setEnabled(false);

        txPPublico.setVisible(false);
        jLabel11.setVisible(false);

        skulabel.setVisible(false);

        txNombreGen.setVisible(false);
        txMarca.setVisible(false);
        txModelo.setVisible(false);
        txTallaCont.setVisible(false);

//        jLabel46.setVisible(false);
//        lb3.setVisible(false);
        chkWeb1.setVisible(false);
        chkNoTransado.setVisible(false);

//        jPanel12.setVisible(false);
        jPanel25.setVisible(false);
        jPanel12.setVisible(false);
        jPanel13.setVisible(false);

        jButton6.setVisible(false); //boton descontinuar
        txconvenio.setVisible(false);

        if (fmMain.GetUsuarioAjuste()) {

            btAjustes.setEnabled(true);

        } else {

            btAjustes.setEnabled(false);

        }

        btUbica.setVisible(false);

        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        GrillaMovimientos.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
        GrillaMovimientos.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
        GrillaMovimientos.getColumnModel().getColumn(7).setCellRenderer(rightRenderer);

        GrillaVenta.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
        GrillaVenta.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
        GrillaVenta.getColumnModel().getColumn(7).setCellRenderer(rightRenderer);

        GrillaCompras.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        GrillaCompras.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        GrillaCompras.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
        GrillaCompras.getColumnModel().getColumn(7).setCellRenderer(rightRenderer);
        GrillaCompras.getColumnModel().getColumn(8).setCellRenderer(rightRenderer);
//        
        //************************************************************************************************************************************************************//     

        valor_vendedor.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_COMMA) || (c == KeyEvent.VK_COLON))) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
        valor_mercadolibre.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9')
                        || (c == KeyEvent.VK_BACK_SPACE)
                        || (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
        valor_publico.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9')
                        || (c == KeyEvent.VK_BACK_SPACE)
                        || (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });

//        Pestanas.addChangeListener(new ChangeListener() {
//            public void stateChanged(ChangeEvent e) {
//                System.out.println("Tab: " + Pestanas.getSelectedIndex());
//                
//                if(Pestanas.getSelectedIndex()==7){
//                    url_mercado.setEnabled(false);
//                    url_web.setEnabled(false);
//                    url_yapo.setEnabled(false);
//                    valor_publico.setEnabled(false);
//                    valor_mercadolibre.setEnabled(false);
//                    jLabel43.setEnabled(false);
//                    Runnable miRunnable = new Runnable() {
//                        public void run() {
//                            try{
//                                ExeSql sql = new ExeSql();
//                                ResultSet rs = null;
//                                if(Pestanas.getSelectedIndex()==7){
//                                    String sku = txSku.getText().trim();
//                                    if(!sku.equals("")) {
//                                        if(CheckIfExist(sku)) {
//                                            String query = "select url_luvaly, url_mercadolibre, url_yapo, pvp_coniva, ml_coniva, valor_general from producto where sku = '"+sku+"'";
//                                            try {
//                                                rs = sql.Select(query);
//                                                if(rs.next()){
//                                                    url_mercado.setText(rs.getString("url_mercadolibre"));
//                                                    url_web.setText(rs.getString("url_luvaly"));
//                                                    url_yapo.setText(rs.getString("url_yapo"));
//                                                    valor_mercadolibre.setText(rs.getString("ml_coniva"));
//                                                    valor_publico.setText(rs.getString("pvp_coniva"));
//                                                    jLabel43.setText(rs.getString("valor_general"));
//                                                }
//                                                else {
//                                                    JOptionPane.showMessageDialog(null, "No se encontraron datos");
//                                                }
//                                            } catch (SQLException ex) {
//                                                Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
//                                            }
//                                        }
//                                        else {
//                                            JOptionPane.showMessageDialog(null, "No se encontró producto");
//                                        }
//                                    }
//                                }
//                                jButton5.setEnabled(true);
//                                lbcargando.setVisible(false);
//                                lbcargando.setEnabled(false);
//                                url_mercado.setEnabled(true);
//                                url_web.setEnabled(true);
//                                url_yapo.setEnabled(true);
//                                valor_publico.setEnabled(true);
//                                valor_mercadolibre.setEnabled(true);
//                                jLabel43.setEnabled(true);
//                            } catch (Exception e) { 
//                                e.printStackTrace();
//                            }
//                        }
//                    };
//                    Thread hilo = new Thread(miRunnable);
//                    hilo.start();  
//                    lbcargando.setText("Cargando.....");
//                    URL urlInfo =  this.getClass().getResource("/Iconos16/wait.gif");
//                    ImageIcon IconoInfo =  new ImageIcon(urlInfo); 
//                    lbcargando.setIcon(IconoInfo);
//                    lbcargando.setForeground(Color.red);  
//                }
//            }
//        });
        Tipo = 0;
        PosImpuesto = -1;

        //        Enlaza OC con sus Facturas, Notas de creditos y Guias asiociadas
//        GrillaCompras.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
//        @Override
//       public void valueChanged(ListSelectionEvent e){
//           if (GrillaFacturasC.getSelectedRowCount()>=0)
//               
//               carga_facturas_orden(GrillaCompras.getValueAt(GrillaCompras.getSelectedRow(), 3).toString().trim());
//       } 
//    });   
        jPanel14.setVisible(false);

        jButton5.setVisible(false);
        btCargarImagen.setVisible(false);
        jtPosiciones.setVisible(false);
        jtEnOferta.setVisible(false);

        jLabel68.setVisible(false);
        txidchmadre.setVisible(false);
        btAgregaIDMadre.setVisible(false);
        btEliminaIDMadre.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    private int BooleanToInt(boolean Input) {
        if (Input == true) {
            return 1;
        } else {
            return 0;
        }
    }

    private String ElTrim(String Texto) {
        try {
            return Texto.trim();
        } catch (Exception e) {
            return Texto;
        }
    }

//private void OrdenesProveedor(){
//
//    Runnable miRunnable = new Runnable() {
//                        public void run() {
//                            try{
//
//                                lbcargando.setEnabled(true);
//                                lbcargando.setVisible(true);
//
//                                CargaCompras(txSku.getText().trim());
//                               
//                                jButton5.setEnabled(true);
//
//                                lbcargando.setVisible(false);
//                                lbcargando.setEnabled(false);
//                                
//
//
//                            } catch (Exception e) { 
//                                e.printStackTrace();
//                            }
//                        }   
//                    };
//         
//                    Thread hilo2 = new Thread(miRunnable);
//                    hilo2.start();        
//                    lbcargando.setText("Cargando.....");
//                    URL urlInfo =  this.getClass().getResource("/Iconos16/wait.gif");
//                    ImageIcon IconoInfo =  new ImageIcon(urlInfo); 
//                    lbcargando.setIcon(IconoInfo);
//                    lbcargando.setForeground(Color.red);
//    
//    
//    
//    
//
//
//}    
//--------------------------------------------------------------------------------
// Funcion SET DE TIPOS
//--------------------------------------------------------------------------------
    void ejecutarPosicion(String valor_idch) {
        int index = lsChilecompras.getSelectedIndex();
        System.out.println("Index Selected: " + index);
        String s = (String) lsChilecompras.getSelectedValue();
        ResultSet Rs;
        String upOfer;
        ExeSql Sql = new ExeSql();
        String Query;
        Query = "  SELECT DISTINCT ON (pp.id) \n"
                + "  p.convenio,\n"
                + "  pp.posicion as pos,\n"
                + "  p.sku,   pp.id as chilecodigo ,p.oferta_inicio, p.oferta_fin, \n"
                + "  p.nombre nombre,\n"
                + "  p.rutultprv,\n"
                + "  pr.nombre nombre_proveedor,\n"
                + "  CASE p.sinstock\n"
                + "      WHEN TRUE THEN  'SI' \n"
                + "      WHEN FALSE THEN  'NO'\n"
                + "    END sinstock,\n"
                + "    CASE   p.discontinuado\n"
                + "      WHEN TRUE THEN  'SI' \n"
                + "      WHEN FALSE THEN  'NO'\n"
                + "    END discontinuado,\n"
                + "  CASE  p.oferta\n"
                + "      WHEN TRUE THEN  'SI' \n"
                + "      WHEN FALSE THEN  'NO'\n"
                + "    END oferta,\n"
                + "  CASE  p.publicado\n"
                + "      WHEN TRUE THEN  'SI' \n"
                + "      WHEN FALSE THEN  'NO'\n"
                + "    END publicado, \n"
                + "  CASE  p.sincompetencia\n"
                + "      WHEN TRUE THEN  'SI' \n"
                + "      WHEN FALSE THEN  'NO'\n"
                + "    END sincompetencia , pp.precio_primero,\n"
                + "        CASE \n"
                + "          WHEN pp.precio_primero IS NULL THEN null\n"
                + "          WHEN  pp.precio_primero=0  THEN 0\n"
                + "          else  \n"
                + "          	   ((pp.precio_primero - p.costofinal)/pp.precio_primero)*100\n"
                + "        END margen , p.costofinal \n"
                + " FROM\n"
                + "  public.producto p\n"
                + "left join codchile cc on cc.sku = p.sku\n"
                + "left join par_convenio pc on p.convenio = pc.codigo\n"
                + "left join proveedor pr on  pr.rut = p.rutultprv  \n"
                + "left join producto_posicion pp \n"
                + "      	on pp.sku = p.sku\n"
                + "        and pp.convenio = p.convenio\n"
                + "where pp.sku = '" + txSku.getText() + "' and pp.id = '" + lsChilecompras.getSelectedValue() + "'";
        try {

            Rs = Sql.Select(Query);

            if (Rs.next()) {
                Rs.beforeFirst();
                for (int i = 0; Rs.next(); i++) {
                    txPosicion.setText(Rs.getString("pos"));
                }
            } else {
                String text = lsChilecompras.getSelectedValue();
                String[] parts = text.split("-");
                String Query2 = "  SELECT DISTINCT ON (pp.id) \n"
                        + "  p.convenio,\n"
                        + "  pp.posicion as pos,\n"
                        + "  p.sku,   pp.id as chilecodigo ,p.oferta_inicio, p.oferta_fin, \n"
                        + "  p.nombre nombre,\n"
                        + "  p.rutultprv,\n"
                        + "  pr.nombre nombre_proveedor,\n"
                        + "  CASE p.sinstock\n"
                        + "      WHEN TRUE THEN  'SI' \n"
                        + "      WHEN FALSE THEN  'NO'\n"
                        + "    END sinstock,\n"
                        + "    CASE   p.discontinuado\n"
                        + "      WHEN TRUE THEN  'SI' \n"
                        + "      WHEN FALSE THEN  'NO'\n"
                        + "    END discontinuado,\n"
                        + "  CASE  p.oferta\n"
                        + "      WHEN TRUE THEN  'SI' \n"
                        + "      WHEN FALSE THEN  'NO'\n"
                        + "    END oferta,\n"
                        + "  CASE  p.publicado\n"
                        + "      WHEN TRUE THEN  'SI' \n"
                        + "      WHEN FALSE THEN  'NO'\n"
                        + "    END publicado, \n"
                        + "  CASE  p.sincompetencia\n"
                        + "      WHEN TRUE THEN  'SI' \n"
                        + "      WHEN FALSE THEN  'NO'\n"
                        + "    END sincompetencia , pp.precio_primero,\n"
                        + "        CASE \n"
                        + "          WHEN pp.precio_primero IS NULL THEN null\n"
                        + "          WHEN  pp.precio_primero=0  THEN 0\n"
                        + "          else  \n"
                        + "          	   ((pp.precio_primero - p.costofinal)/pp.precio_primero)*100\n"
                        + "        END margen , p.costofinal \n"
                        + " FROM\n"
                        + "  public.producto p\n"
                        + "left join codchile cc on cc.sku = p.sku\n"
                        + "left join par_convenio pc on p.convenio = pc.codigo\n"
                        + "left join proveedor pr on  pr.rut = p.rutultprv  \n"
                        + "left join producto_posicion pp \n"
                        + "      	on pp.sku = p.sku\n"
                        + "        and pp.convenio = p.convenio\n"
                        + "where pp.sku = (select sku_rel from codproducto_rel where sku ='" + txSku.getText() + "') and pp.id = '" + parts[0] + "'";
                Rs = Sql.Select(Query2);
                Rs.beforeFirst();
                for (int i = 0; Rs.next(); i++) {
                    txPosicion.setText(Rs.getString("pos"));
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void SetTipo(int ElTipo) {
        //Nada
        if (ElTipo == -1) {

            fmMain.SetEstado(fmMain.pnPestanas.getSelectedIndex(), 0);
            Tipo = -1;
            Limpia();
            Habilita(false);
            Edicion(false);
            txSku.setEnabled(true);
            txSku.setEditable(true);
            btIr.setEnabled(true);
            txSku.requestFocus();
            chkDisosur.setEnabled(true);
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

        } //Nuevo Producto
        else if (ElTipo == 1) {
            chkDisosur.setEnabled(true);
            Tipo = 1;
            fmMain.SetEstado(fmMain.pnPestanas.getSelectedIndex(), 1);
            btGuardar.setEnabled(true);
            btCancelar.setEnabled(true);
            btEditar.setEnabled(false);
            btNuevo.setEnabled(false);
            Habilita(true);
            Edicion(true);
            Limpia();
            txSku.setEditable(false);
            txNombre.requestFocus();
            Tipo = 1;
//            btUbica.setEnabled(true);
//            txUbicados.setEnabled(true);
//            txTransito.setEnabled(true);
//            lsCodbar.setVisible(true);
//            lsChilecompras.setVisible(true);
//            txUbicados.setEditable(false);
//            btUbica.setEnabled(false);
            chkIva.setEnabled(true);
        } //Abre Producto
        else if (ElTipo == 2) {
            chkDisosur.setEnabled(false);
            fmMain.SetEstado(fmMain.pnPestanas.getSelectedIndex(), 0);
            btEditar.setEnabled(true);
            btNuevo.setEnabled(true);
            btGuardar.setEnabled(false);
            btCancelar.setEnabled(false);
//            btEliminar.setEnabled(true);
            Habilita(true);
            Edicion(false);
            txSku.setEditable(true);
            Tipo = 2;
//            btUbica.setEnabled(false);
        } // Edita Producto 
        else if (ElTipo == 3) {
            chkDisosur.setEnabled(true);
            fmMain.SetEstado(fmMain.pnPestanas.getSelectedIndex(), 1);
            Habilita(true);
            Edicion(true);

            btGuardar.setEnabled(true);
            btCancelar.setEnabled(true);
            btNuevo.setEnabled(false);
            txSku.setEditable(false);
            Tipo = 3;
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
        pnDetalle = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btIr = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txNombre = new javax.swing.JTextField();
        txSku = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        chkCodigo = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
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
        chkIva = new javax.swing.JCheckBox();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        cbOtroImpuesto = new javax.swing.JComboBox();
        txTazaImpuesto = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        lsCodbar = new javax.swing.JList();
        jScrollPane6 = new javax.swing.JScrollPane();
        lsChilecompras = new javax.swing.JList<String>();
        btAgregaID = new javax.swing.JButton();
        btEliminaID = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        txCantUnidad = new javax.swing.JTextField();
        jtCantidad = new javax.swing.JToggleButton();
        chkDisosur = new javax.swing.JCheckBox();
        jLabel68 = new javax.swing.JLabel();
        txidchmadre = new javax.swing.JTextField();
        btAgregaIDMadre = new javax.swing.JButton();
        btEliminaIDMadre = new javax.swing.JButton();
        txconvenio = new javax.swing.JTextField();
        Pestanas = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
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
        jSeparator1 = new javax.swing.JSeparator();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        txStockEcona = new javax.swing.JTextField();
        txStockDisosur = new javax.swing.JTextField();
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
        txAuditoria = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        btVerAuditoria = new javax.swing.JButton();
        jPanel28 = new javax.swing.JPanel();
        btAjustes = new javax.swing.JButton();
        lbAjustes = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        chkPublicado = new javax.swing.JCheckBox();
        jLabel24 = new javax.swing.JLabel();
        txDisplay = new javax.swing.JTextField();
        chkStock = new javax.swing.JCheckBox();
        chkDiscontinuado = new javax.swing.JCheckBox();
        chkNoTransado = new javax.swing.JCheckBox();
        chkDesxPrecio = new javax.swing.JCheckBox();
        txPosicion = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        chkdeshabilitado = new javax.swing.JCheckBox();
        jLabel32 = new javax.swing.JLabel();
        jtFechaLlegada = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        chkWeb = new javax.swing.JCheckBox();
        chkWeb1 = new javax.swing.JCheckBox();
        jLabel67 = new javax.swing.JLabel();
        txCritico = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        chkOferta = new javax.swing.JCheckBox();
        dtFinOfer = new org.jdesktop.swingx.JXDatePicker();
        dtInicioOfer = new org.jdesktop.swingx.JXDatePicker();
        btGuardarOfer = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        Grilla = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        btBuscarRelacionado = new javax.swing.JButton();
        txtCrearRelacion = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        btEstablecerRelacionado = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        lbWeb = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        txWeb = new javax.swing.JTextField();
        btActWeb = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        pMargen = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        txPropuesta = new javax.swing.JTextField();
        txPublicacion = new javax.swing.JTextField();
        txComision = new javax.swing.JTextField();
        txEnvio = new javax.swing.JTextField();
        txPublicadoIva = new javax.swing.JTextField();
        txPublicadoNeto = new javax.swing.JTextField();
        txMargen2 = new javax.swing.JTextField();
        txNroPublicacion = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
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
        jPanel11 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txCreacionUsuario = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txCreacionFecha = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        valor_vendedor = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jtDescripcion = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jtURL = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        chbOfertaAutomatica = new javax.swing.JCheckBox();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        url_mercado = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        url_web = new javax.swing.JTextField();
        url_yapo = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        valor_publico = new javax.swing.JTextField();
        valor_mercadolibre = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
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
        skulabel = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        Grilla_Inv = new javax.swing.JTable();
        jPanel25 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txPeso = new javax.swing.JTextField();
        txLargo = new javax.swing.JTextField();
        txAncho = new javax.swing.JTextField();
        txAlto = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        lbM3 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        pnMenu = new javax.swing.JPanel();
        btNuevo = new javax.swing.JButton();
        btGuardar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        btCargarImagen = new javax.swing.JButton();
        lbcargando = new javax.swing.JLabel();
        jtPosiciones = new javax.swing.JToggleButton();
        jtEnOferta = new javax.swing.JToggleButton();
        jButton5 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txPPublico = new javax.swing.JTextField();
        txNombreGen = new javax.swing.JTextField();
        txMarca = new javax.swing.JTextField();
        txModelo = new javax.swing.JTextField();
        txTallaCont = new javax.swing.JTextField();

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

        pnDetalle.setMaximumSize(new java.awt.Dimension(32767, 650));
        pnDetalle.setPreferredSize(new java.awt.Dimension(2911, 650));

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

        txNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txNombreMouseClicked(evt);
            }
        });
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
                .addComponent(txNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

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
        lsChilecompras.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lsChilecomprasValueChanged(evt);
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

        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel34.setText("Cantidad (unidades)");

        txCantUnidad.setEditable(false);
        txCantUnidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txCantUnidad.setEnabled(false);

        jtCantidad.setText("Editar");
        jtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtCantidadActionPerformed(evt);
            }
        });

        chkDisosur.setText("Guardar en Disosur");
        chkDisosur.setEnabled(false);

        jLabel68.setText("ID. Madre");

        txidchmadre.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txidchmadre.setEnabled(false);
        txidchmadre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txidchmadreKeyTyped(evt);
            }
        });

        btAgregaIDMadre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/Agregar.png"))); // NOI18N
        btAgregaIDMadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregaIDMadreActionPerformed(evt);
            }
        });

        btEliminaIDMadre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/Eliminar.png"))); // NOI18N
        btEliminaIDMadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminaIDMadreActionPerformed(evt);
            }
        });

        txconvenio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txconvenio.setText("0");
        txconvenio.setToolTipText("");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel19))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel68, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                        .addComponent(txidchmadre, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(btAgregaIDMadre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btEliminaIDMadre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btEliminaID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btAgregaID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cbSubFamilia, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbFamilia, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbConvenio, javax.swing.GroupLayout.Alignment.LEADING, 0, 297, Short.MAX_VALUE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(cbOtroImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txTazaImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkIva)
                                .addGap(18, 18, 18)
                                .addComponent(chkDisosur)))
                        .addGap(30, 38, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(txconvenio, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txCantUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbSubFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbOtroImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txTazaImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(chkIva)
                            .addComponent(chkDisosur))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(txCantUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtCantidad)
                            .addComponent(txconvenio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(btAgregaID, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btEliminaID, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel68)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txidchmadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btAgregaIDMadre, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btEliminaIDMadre, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        Pestanas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                PestanasStateChanged(evt);
            }
        });
        Pestanas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PestanasMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PestanasMousePressed(evt);
            }
        });

        jPanel3.setEnabled(false);

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

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

        jLabel65.setText("Stock Econa ");

        jLabel66.setText("Stock Disosur");
        jLabel66.setToolTipText("");

        txStockEcona.setEditable(false);
        txStockEcona.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txStockEcona.setText("0");
        txStockEcona.setToolTipText("");

        txStockDisosur.setEditable(false);
        txStockDisosur.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txStockDisosur.setText("0");
        txStockDisosur.setToolTipText("");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(lbNuevoMinimo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(0, 29, Short.MAX_VALUE)
                                .addComponent(txMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txNuevoMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chk_minimo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addComponent(btGuardarMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txPCosto, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                            .addComponent(txPNeto)
                                            .addComponent(txPUltCompra)))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel28))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txTransporte, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                            .addComponent(txMargen)))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel66, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                    .addComponent(jLabel65, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txStockEcona, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                                    .addComponent(txStockDisosur))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
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
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbNuevoMinimo)
                        .addComponent(txNuevoMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chk_minimo)
                    .addComponent(btGuardarMinimo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(txStockEcona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(txStockDisosur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
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

        txAuditoria.setEditable(false);
        txAuditoria.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel55.setText("Auditoría");

        btVerAuditoria.setText("Ver");
        btVerAuditoria.setToolTipText("");
        btVerAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVerAuditoriaActionPerformed(evt);
            }
        });

        jPanel28.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btAjustes.setText("Ajustes");
        btAjustes.setToolTipText("");
        btAjustes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAjustesActionPerformed(evt);
            }
        });

        lbAjustes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAjustes.setText("0");
        lbAjustes.setToolTipText("");
        lbAjustes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(btAjustes))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbAjustes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(lbAjustes, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btAjustes, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

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
                    .addComponent(jLabel27)
                    .addComponent(jLabel55))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btVerAuditoria))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txTransito, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                                .addComponent(txUbicados, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txStockInv, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txSeparado, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                                .addComponent(txStockTotal, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txStockGDC, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txStockOCC, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txStockOCP, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(btUbica, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(txStockInv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel27)
                    .addComponent(txUbicados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btUbica))
                .addGap(3, 3, 3)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel26)
                    .addComponent(txTransito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txStockOCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel12)
                            .addComponent(txStockOCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txStockGDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txStockTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)))
                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txSeparado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(txAuditoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btVerAuditoria))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        chkPublicado.setText("Publicado");
        chkPublicado.setOpaque(false);
        chkPublicado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkPublicadoActionPerformed(evt);
            }
        });

        jLabel24.setText("Cant. por Embalaje");

        txDisplay.setEditable(false);
        txDisplay.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        chkStock.setText("Sin Stock");

        chkDiscontinuado.setText("Discontinuado");
        chkDiscontinuado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDiscontinuadoActionPerformed(evt);
            }
        });

        chkNoTransado.setText("Actualiza precio Web");

        chkDesxPrecio.setText("Des. x Precio");
        chkDesxPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDesxPrecioActionPerformed(evt);
            }
        });

        txPosicion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txPosicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txPosicionActionPerformed(evt);
            }
        });

        jLabel30.setText("Posición Producto");

        chkdeshabilitado.setText("Sin publicar");
        chkdeshabilitado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkdeshabilitadoActionPerformed(evt);
            }
        });

        jLabel32.setText("Fecha Llegada Prv:");

        jtFechaLlegada.setEditable(false);

        jButton6.setText("Descontinuar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        chkWeb.setText("WEB");
        chkWeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkWebActionPerformed(evt);
            }
        });

        chkWeb1.setText("ML");
        chkWeb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkWeb1ActionPerformed(evt);
            }
        });

        jLabel67.setText("Stock Crítico");

        txCritico.setEditable(false);
        txCritico.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txCritico, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtFechaLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chkPublicado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkDiscontinuado)
                            .addComponent(chkStock)
                            .addComponent(chkdeshabilitado)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(chkDesxPrecio)
                                .addGap(4, 4, 4)))
                        .addGap(68, 68, 68)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(chkWeb)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkWeb1))
                            .addComponent(chkNoTransado, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txPosicion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel30)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txPosicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30))
                        .addGap(17, 17, 17))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(chkNoTransado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkWeb)
                            .addComponent(chkWeb1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(chkPublicado)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(chkDesxPrecio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkStock))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkDiscontinuado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkdeshabilitado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txCritico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jtFechaLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        chkOferta.setText("En Oferta");
        chkOferta.setOpaque(false);
        chkOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkOfertaActionPerformed(evt);
            }
        });

        dtFinOfer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dtFinOferKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dtFinOferKeyTyped(evt);
            }
        });

        dtInicioOfer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dtInicioOferKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dtInicioOferKeyTyped(evt);
            }
        });

        btGuardarOfer.setText("Guardar");
        btGuardarOfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarOferActionPerformed(evt);
            }
        });

        Grilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1"
            }
        ));
        jScrollPane8.setViewportView(Grilla);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(chkOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(dtFinOfer, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btGuardarOfer))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(dtInicioOfer, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chkOferta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dtInicioOfer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dtFinOfer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btGuardarOfer))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Relacionados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        btBuscarRelacionado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/search16.png"))); // NOI18N
        btBuscarRelacionado.setText("Buscar");
        btBuscarRelacionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarRelacionadoActionPerformed(evt);
            }
        });

        jLabel31.setText("Producto Origen:");

        btEstablecerRelacionado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/ok_16.png"))); // NOI18N
        btEstablecerRelacionado.setText("Establecer");
        btEstablecerRelacionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEstablecerRelacionadoActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/derecha16.png"))); // NOI18N
        jButton1.setText("Relacionados");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Múltiple");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCrearRelacion, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btBuscarRelacionado)
                        .addContainerGap())
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btEstablecerRelacionado, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtCrearRelacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscarRelacionado))
                .addGap(20, 20, 20)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEstablecerRelacionado)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 179, Short.MAX_VALUE)
        );

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Precios de Venta (c/IVA)"));

        jLabel45.setText("Tienda / Web");

        jLabel46.setText("Venta Empresas");
        jLabel46.setToolTipText("");

        lbWeb.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbWeb.setText("0");
        lbWeb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        lbWeb.setPreferredSize(new java.awt.Dimension(8, 20));

        lb3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb3.setText("0");
        lb3.setToolTipText("");
        lb3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        lb3.setPreferredSize(new java.awt.Dimension(8, 20));

        txWeb.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txWeb.setText("0");
        txWeb.setToolTipText("");
        txWeb.setEnabled(false);
        txWeb.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txWebFocusGained(evt);
            }
        });
        txWeb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txWebKeyPressed(evt);
            }
        });

        btActWeb.setText("Actualizar");
        btActWeb.setToolTipText("");
        btActWeb.setEnabled(false);
        btActWeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActWebActionPerformed(evt);
            }
        });

        jLabel44.setText("Econa / Disosur");

        lb1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb1.setText("0");
        lb1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        lb1.setPreferredSize(new java.awt.Dimension(8, 20));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(txWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btActWeb)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel46)
                        .addComponent(lb3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel45)
                        .addComponent(lbWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btActWeb)))
                .addGap(5, 5, 5)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pMargen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel47.setText("Propuesta Precio");

        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel48.setText("Precio Publicacion");

        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel49.setText("Comisión");

        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel50.setText("Envío");

        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel51.setText("Publicado - Gastos (con IVA)");

        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel52.setText("Publicado (NETO)");

        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel53.setText("Margen %");

        txPropuesta.setEditable(false);
        txPropuesta.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txPublicacion.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txPublicacion.setEnabled(false);
        txPublicacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txPublicacionKeyPressed(evt);
            }
        });

        txComision.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txComision.setEnabled(false);
        txComision.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txComisionKeyPressed(evt);
            }
        });

        txEnvio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txEnvio.setEnabled(false);
        txEnvio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txEnvioKeyPressed(evt);
            }
        });

        txPublicadoIva.setEditable(false);
        txPublicadoIva.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txPublicadoNeto.setEditable(false);
        txPublicadoNeto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txMargen2.setEditable(false);
        txMargen2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txNroPublicacion.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txNroPublicacion.setEnabled(false);

        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("N° Publicación");

        javax.swing.GroupLayout pMargenLayout = new javax.swing.GroupLayout(pMargen);
        pMargen.setLayout(pMargenLayout);
        pMargenLayout.setHorizontalGroup(
            pMargenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMargenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pMargenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pMargenLayout.createSequentialGroup()
                        .addGroup(pMargenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pMargenLayout.createSequentialGroup()
                                .addGroup(pMargenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pMargenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txPropuesta)
                                    .addComponent(txPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txNroPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pMargenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel51)
                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pMargenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txMargen2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pMargenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txPublicadoNeto)
                                .addComponent(txPublicadoIva, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txEnvio, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txComision, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pMargenLayout.setVerticalGroup(
            pMargenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMargenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pMargenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pMargenLayout.createSequentialGroup()
                        .addGroup(pMargenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txComision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel49))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pMargenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pMargenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txPublicadoIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pMargenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txPublicadoNeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel52))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pMargenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txMargen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel53)))
                    .addGroup(pMargenLayout.createSequentialGroup()
                        .addComponent(txNroPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(pMargenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47)
                            .addComponent(txPropuesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pMargenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48)
                            .addComponent(txPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pMargen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(pMargen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(459, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE))
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
                .addContainerGap(569, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE))
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
                .addContainerGap(1096, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btAgregaRelacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEliminaRelacion)
                .addContainerGap(227, Short.MAX_VALUE))
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
                "Fecha", "Rut", "Proveedor", "Nro Orden", "Pedido", "Recibido", "Val.OCP", "Valor Recibido", "Val.Total", "Objetivo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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
            GrillaCompras.getColumnModel().getColumn(7).setPreferredWidth(100);
            GrillaCompras.getColumnModel().getColumn(8).setPreferredWidth(100);
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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(450, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
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
                .addGap(0, 18, Short.MAX_VALUE))
        );

        Pestanas.addTab("OC Proveedores", jPanel9);

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Usuario Creador");

        txCreacionUsuario.setEditable(false);

        jButton3.setText("Llegada Proveedor");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel18.setText("Fecha Creación");

        txCreacionFecha.setEditable(false);

        jButton4.setText("Guardar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel33.setText("Valor Proveedor:");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txCreacionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(valor_vendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel33))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txCreacionFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel15Layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(jButton4)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txCreacionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txCreacionFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel33)
                .addGap(18, 18, 18)
                .addComponent(valor_vendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jButton10.setText("Carga Valor");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton10)
                .addContainerGap(288, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(956, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        Pestanas.addTab("Proveedor", jPanel11);

        jPanel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel35.setText("Descripción");

        jLabel36.setText("URL");

        jButton7.setText("Copiar URL");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Guardar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtDescripcion)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addComponent(jLabel36))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jtURL)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton7)))
                .addContainerGap())
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jButton8)
                .addContainerGap(291, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7)
                .addGap(18, 18, 18)
                .addComponent(jButton8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton9.setText("Guardar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        chbOfertaAutomatica.setText("Sin Oferta Automática");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chbOfertaAutomatica)
                    .addComponent(jButton9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(chbOfertaAutomatica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jButton9)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(1092, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Pestanas.addTab("Mercado Público", jPanel16);

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "URLs"));

        jLabel37.setText("URL Mercado Libre: ");

        jLabel38.setText("URL Luvaly WEB:");

        jLabel39.setText("URL Yapo.cl");

        jButton12.setText("Guardar");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel21Layout.createSequentialGroup()
                                        .addComponent(jLabel39)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(url_yapo, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel21Layout.createSequentialGroup()
                                        .addComponent(jLabel38)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                        .addComponent(url_web, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(url_mercado, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jButton12)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(url_mercado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(url_web, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(url_yapo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(jButton12)
                .addContainerGap())
        );

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Valores"));

        jLabel40.setText("Valor Público: ");

        jLabel41.setText("Valor Mercado Libre: ");

        jButton11.setText("Guardar");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel42.setText("Valor General: ");

        jLabel43.setText("0");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel22Layout.createSequentialGroup()
                            .addComponent(jLabel40)
                            .addGap(18, 18, 18)
                            .addComponent(valor_publico, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel22Layout.createSequentialGroup()
                            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel41)
                                .addComponent(jLabel42))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel43)
                                .addComponent(valor_mercadolibre))))
                    .addComponent(jButton11))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(valor_publico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(valor_mercadolibre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jLabel43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton11)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(961, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        Pestanas.addTab("Web", jPanel20);

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

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Ubicaciones Inventario"));

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
        Grilla_Inv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Grilla_InvMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(Grilla_Inv);
        if (Grilla_Inv.getColumnModel().getColumnCount() > 0) {
            Grilla_Inv.getColumnModel().getColumn(0).setMinWidth(0);
            Grilla_Inv.getColumnModel().getColumn(0).setPreferredWidth(0);
            Grilla_Inv.getColumnModel().getColumn(0).setMaxWidth(0);
            Grilla_Inv.getColumnModel().getColumn(2).setPreferredWidth(80);
            Grilla_Inv.getColumnModel().getColumn(2).setMaxWidth(90);
            Grilla_Inv.getColumnModel().getColumn(3).setMinWidth(60);
            Grilla_Inv.getColumnModel().getColumn(3).setPreferredWidth(60);
            Grilla_Inv.getColumnModel().getColumn(3).setMaxWidth(60);
            Grilla_Inv.getColumnModel().getColumn(4).setMinWidth(80);
            Grilla_Inv.getColumnModel().getColumn(4).setPreferredWidth(80);
            Grilla_Inv.getColumnModel().getColumn(4).setMaxWidth(80);
        }

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 61, Short.MAX_VALUE)
        );

        jPanel26.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setText("Peso");

        txPeso.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txPesoKeyTyped(evt);
            }
        });

        txLargo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txLargo.setText("0");
        txLargo.setToolTipText("");
        txLargo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txLargoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txLargoFocusLost(evt);
            }
        });
        txLargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txLargoKeyPressed(evt);
            }
        });

        txAncho.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txAncho.setText("0");
        txAncho.setToolTipText("");
        txAncho.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txAnchoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txAnchoFocusLost(evt);
            }
        });
        txAncho.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txAnchoKeyPressed(evt);
            }
        });

        txAlto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txAlto.setText("0");
        txAlto.setToolTipText("");
        txAlto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txAltoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txAltoFocusLost(evt);
            }
        });
        txAlto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txAltoKeyPressed(evt);
            }
        });

        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("Largo");
        jLabel56.setToolTipText("");

        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("Ancho");

        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("Alto");

        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("cms.");

        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("cms.");

        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("cms.");

        lbM3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbM3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbM3.setText("0");
        lbM3.setToolTipText("");
        lbM3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel63.setText("m3");

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setText("=");

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setText("Kgs.");
        jLabel62.setToolTipText("");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txLargo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txAncho)
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txAlto)
                    .addComponent(jLabel61, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lbM3, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(jLabel57)
                    .addComponent(jLabel58))
                .addGap(1, 1, 1)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txLargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txAncho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txAlto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbM3, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                    .addComponent(jLabel63)
                    .addComponent(jLabel64)
                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(jLabel60)
                    .addComponent(jLabel61)))
        );

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
        btCargarImagen.setEnabled(false);
        btCargarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCargarImagenActionPerformed(evt);
            }
        });

        lbcargando.setText("Cargando");
        lbcargando.setEnabled(false);

        jtPosiciones.setText("Posiciones");
        jtPosiciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtPosicionesActionPerformed(evt);
            }
        });

        jtEnOferta.setText("En Oferta");
        jtEnOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtEnOfertaActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/Imagen16.png"))); // NOI18N
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
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
                .addGap(51, 51, 51)
                .addComponent(lbcargando, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCargarImagen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtPosiciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtEnOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(253, 253, 253))
        );
        pnMenuLayout.setVerticalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbcargando, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5)))
                    .addGroup(pnMenuLayout.createSequentialGroup()
                        .addGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btCargarImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtPosiciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtEnOferta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(2, 2, 2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(btGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel11.setText("Precio Venta Público");

        txPPublico.setEditable(false);
        txPPublico.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txMarca.setToolTipText("");

        txModelo.setToolTipText("");

        txTallaCont.setToolTipText("");

        javax.swing.GroupLayout pnDetalleLayout = new javax.swing.GroupLayout(pnDetalle);
        pnDetalle.setLayout(pnDetalleLayout);
        pnDetalleLayout.setHorizontalGroup(
            pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDetalleLayout.createSequentialGroup()
                        .addComponent(pnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDetalleLayout.createSequentialGroup()
                                .addGap(239, 239, 239)
                                .addComponent(skulabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnDetalleLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txNombreGen, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txTallaCont, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(pnDetalleLayout.createSequentialGroup()
                        .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Pestanas, javax.swing.GroupLayout.PREFERRED_SIZE, 1733, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnDetalleLayout.createSequentialGroup()
                                .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 710, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(63, 63, 63)
                                .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnDetalleLayout.createSequentialGroup()
                                        .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cbFamiliaCod, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbConvenioCod, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbSubFamiliaCod, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbConvenioSku, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbFamiliaSku, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbSubFamiliaSku, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(pnDetalleLayout.createSequentialGroup()
                                        .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cbOtroImpuestoId, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbUnidadId, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(cbOtroImpuestoTaza, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnDetalleLayout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txPPublico, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59))
        );
        pnDetalleLayout.setVerticalGroup(
            pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnDetalleLayout.createSequentialGroup()
                        .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txNombreGen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txTallaCont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(2, 2, 2)
                .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDetalleLayout.createSequentialGroup()
                        .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDetalleLayout.createSequentialGroup()
                                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnDetalleLayout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnDetalleLayout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnDetalleLayout.createSequentialGroup()
                                        .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(pnDetalleLayout.createSequentialGroup()
                                                .addComponent(cbConvenioSku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                        .addGap(18, 18, 18)
                                        .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(cbOtroImpuestoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbOtroImpuestoTaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(17, 17, 17)
                                        .addComponent(cbUnidadId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnDetalleLayout.createSequentialGroup()
                                        .addGap(162, 162, 162)
                                        .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                            .addComponent(jLabel11)
                                            .addComponent(txPPublico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Pestanas, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(skulabel, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnDetalleLayout.createSequentialGroup()
                        .addGroup(pnDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        add(pnDetalle);
    }// </editor-fold>//GEN-END:initComponents
//--------------------------------------------------------------------------------
// Funcion CODIGO desde COMBOBOX
//--------------------------------------------------------------------------------

    private int cbId_Accion(JComboBox Combo) {
        int Codigo = -1;
        if (Combo.getSelectedIndex() >= 0) {

            ComboCodigos id = (ComboCodigos) Combo.getSelectedItem();
            Codigo = id.getId();
            String nombre = Combo.getSelectedItem().toString();
            Combo.hidePopup();
        }
        return Codigo;
    }

    private void CargaOtrosImpuestos() {
        ExeSql Sql = new ExeSql();
        ResultSet Rs;

        try {
            cbOtroImpuesto.removeAllItems();
            cbOtroImpuestoId.removeAllItems();

            Rs = Sql.Select("select *\n"
                    + "from par_impuesto\n"
                    + "order by codigo");
            while (Rs.next()) {
                cbOtroImpuestoId.addItem(Rs.getInt("codigo"));
                cbOtroImpuestoTaza.addItem(Rs.getDouble("taza"));
                cbOtroImpuesto.addItem(Rs.getString("impuesto"));
            }
        } catch (Exception e) {
        }
    }

    private void CargaMovimientos(String Codigo) {

        ExeSql Sql = new ExeSql();
        DefaultTableModel dftm = (DefaultTableModel) GrillaMovimientos.getModel();
        ResultSet Rs;
        // Limpia Grilla
        while (dftm.getRowCount() > 0) {
            dftm.removeRow(0);
        }

        try {
//        Rs = Sql.Select("select m.fecha,cast(m.hora as time) as hora,m.usuario,m.tipdocto,m.nrodocto,m.cantidad,m.stockini,m.stockfin,m.tipomovimiento\n"
//                + "from producto p\n"
//                + "left join movimientos_stock m on p.sku=m.sku \n"
//                + "left join par_unidad u on p.unidad=u.codigo\n"
//                + "where p.sku='" + Codigo + "'\n"
//                + "order by m.fecha desc, cast(m.hora as time)  desc");

            Rs = Sql.Select("select m.fecha,cast(m.hora as time) as hora,m.usuario,m.tipdocto,m.nrodocto,m.cantidad,m.stockini,m.stockfin,m.tipomovimiento, a.folio, \n"
                    + "case when a.usuario is null then m.usuario else a.usuario end as solicita\n"
                    + "from producto p\n"
                    + "left join movimientos_stock m on p.sku=m.sku \n"
                    + "left join par_unidad u on p.unidad=u.codigo\n"
                    + "left join ajusteenc_autoriza a on m.nrodocto=a.folio and m.tipdocto IN ('AJU') \n"
                    + "where p.sku='" + Codigo + "'\n"
                    + "order by m.fecha desc, cast(m.hora as time) desc, m.id desc");

            //   + "order by m.id desc");
            while (Rs.next()) {

                dftm.addRow(new Object[]{
                    Rs.getDate("fecha"),
                    Rs.getTime("hora"),
                    //Rs.getString("usuario"),
                    Rs.getString("solicita"),
                    Rs.getString("tipdocto"),
                    Rs.getString("nrodocto"),
                    fmMain.FormatoNumero(Rs.getDouble("cantidad")),
                    fmMain.FormatoNumero(Rs.getDouble("stockini")),
                    fmMain.FormatoNumero(Rs.getDouble("stockfin")),
                    Rs.getString("tipomovimiento")});
            }
        } catch (Exception e) {
        } finally {
            Sql.Close();
        }
    }

    private void CargaVentas(String Codigo) {
        ExeSql Sql = new ExeSql();
        DefaultTableModel dftm = (DefaultTableModel) GrillaVenta.getModel();
        ResultSet Rs;
        // Limpia Grilla
        while (dftm.getRowCount() > 0) {
            dftm.removeRow(0);
        }

        try {
//            Rs = Sql.Select("SELECT CAST(e.femision as date) as fecha,e.rut,trim(cl.nombre) as nombre,d.codigo_oc,d.orden,d.cantidad,d.despachado,d.separado\n" +
//                            "FROM OCCHDET d\n" +
//                            "LEFT JOIN OCCH e on e.rut=d.rut and e.codigo_oc=d.codigo_oc and e.orden=d.orden \n" +
//                            "left join cliente cl on d.rut=cl.rut \n" +
//                            "where d.sku='"+ Codigo +"'\n" +
//                            "order by e.femision desc");

            Rs = Sql.Select("SELECT CAST(e.femision as date) as fecha,e.rut,trim(cl.nombre) as nombre,d.codigo_oc,d.orden,d.cantidad,d.despachado,d.separado\n"
                    + "FROM OCCHDET d\n"
                    + "LEFT JOIN OCCH e on e.rut=d.rut and e.codigo_oc=d.codigo_oc and e.orden=d.orden \n"
                    + "left join cliente cl on d.rut=cl.rut \n"
                    + "where d.sku='" + Codigo + "' and e.rut is not null and d.codigo_oc <> 99999 \n"
                    + "order by e.femision desc");

            while (Rs.next()) {
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

        ExeSql Sql = new ExeSql();
        ExeSql Sql2 = new ExeSql();

        String Query = "";
        String Query2 = "";

        DefaultTableModel dftm = (DefaultTableModel) GrillaCompras.getModel();

        ResultSet Rs;
        ResultSet Rs2;

        dftm.setRowCount(0);

        try {
//            Query = "select cast(e.femision as date) as fecha, e.rut,trim(p.nombre) as nombre,e.nrodocto,d.cantidad,d.recibido, d.valorunitario, "
//                    + "(select nuevo_valor from ctacteprvdet d \n" +
//                        "inner join (select femision,tipdocto,nrodocto,nrodocorigen from ctacteprv\n" +
//                        "where nrodocorigen  = e.nrodocto\n" +
//                        "and tipdocorigen = 'OCP' ) o\n" +
//                        "on  d.nrodocto = o.nrodocto\n" +
//                        "and d.tipdocto = o.tipdocto\n" +
//                        "and d.sku='" + Codigo + "' order by o.femision desc LIMIT 1),\n"
//                    + "d.totallinea, \n"
//                    + "(select objetivo from ctacteprvdet d \n" +
//                        "inner join (select femision,tipdocto,nrodocto,nrodocorigen from ctacteprv\n" +
//                        "where nrodocorigen  = e.nrodocto\n" +
//                        "and tipdocorigen = 'OCP' ) o\n" +
//                        "on  d.nrodocto = o.nrodocto\n" +
//                        "and d.tipdocto = o.tipdocto\n" +
//                        "and d.sku='" + Codigo + "' order by o.femision desc LIMIT 1)\n"
//                    + "from ctacteprvdet d\n"
//                    + "left join ctacteprv e on d.rut=e.rut and d.tipdocto=e.tipdocto and d.nrodocto=e.nrodocto\n"
//                    + "left join proveedor p on p.rut=d.rut\n"
//                    + "where d.tipdocto='OCP'\n"
//                    + "and d.sku='" + Codigo + "'\n"
//                    + "order by e.femision desc";

            Query = "select cast(e.femision as date) as fecha, e.rut,trim(p.nombre) as nombre,e.nrodocto,d.cantidad,d.recibido, d.valorunitario, \n"
                    + "d.totallinea \n"
                    + "from ctacteprvdet d\n"
                    + "left join ctacteprv e on d.rut=e.rut and d.tipdocto=e.tipdocto and d.nrodocto=e.nrodocto\n"
                    + "left join proveedor p on p.rut=d.rut\n"
                    + "where d.tipdocto='OCP'\n"
                    + "and d.sku='" + Codigo + "' and e.estado <> -1 \n"
                    + "order by e.femision desc \n"
                    + "limit 30";

            Rs = Sql.Select(Query);

            double nuevo = 0;
            int objetivo = 0;

            while (Rs.next()) {

//                Query2 = "select d.nuevo_valor,d.objetivo  from ctacteprvdet d \n" +
//                         "left join ctacteprv c on d.rut = c.rut and d.tipdocto = c.tipdocto and d.nrodocto = c.nrodocto\n" +
//                         "where c.nrodocorigen = "+Rs.getInt("nrodocto")+"\n" +
//                         "and c.tipdocorigen = 'OCP' \n" +
//                         "and d.sku='"+Codigo+"' \n" +
//                         "order by c.femision desc LIMIT 1";
                Query2 = "select d.valorunitario,d.objetivo  from ctacteprvdet d \n"
                        + "left join ctacteprv c on d.rut = c.rut and d.tipdocto = c.tipdocto and d.nrodocto = c.nrodocto\n"
                        + "where c.nrodocorigen = " + Rs.getInt("nrodocto") + "\n"
                        + "and c.tipdocorigen IN ('OCP') \n"
                        + "and c.tipdocto IN ('FAP') \n"
                        + "and d.sku='" + Codigo + "' \n"
                        + "order by c.femision desc LIMIT 1";

                Rs2 = Sql2.Select(Query2);

                if (Sql2.GetRowCount() > 0) {

                    Rs2.next();

                    //nuevo = Rs2.getDouble("nuevo_valor");
                    nuevo = Rs2.getDouble("valorunitario");
                    objetivo = Rs2.getInt("objetivo");

                } else {

                    nuevo = 0;
                    objetivo = 0;

                }

                dftm.addRow(new Object[]{ //011507011
                    Rs.getDate("fecha"),
                    Rs.getString("rut"),
                    Rs.getString("nombre"),
                    Rs.getString("nrodocto"),
                    fmMain.FormatoNumeroSinDecimal(Rs.getDouble("cantidad")),
                    fmMain.FormatoNumeroSinDecimal(Rs.getDouble("recibido")),
                    fmMain.FormatoNumeroSinDecimal(Rs.getDouble("valorunitario")),
                    fmMain.FormatoNumeroSinDecimal(nuevo),
                    fmMain.FormatoNumeroSinDecimal(Rs.getDouble("totallinea")),
                    objetivo,});

                // GrillaCompras.setDefaultRenderer(Object.class, new Elrender());  
                GrillaCompras.setDefaultRenderer(Object.class, new Utilidades.TableColor_OCProvee());
                GrillaCompras.repaint();
                TableColumnModel columnModel = GrillaCompras.getColumnModel();
                TableColumn column = columnModel.getColumn(3); // Give column index here
                column.setCellRenderer(new Utilidades.TableColor_OCProvee());

                TableColumn column2 = columnModel.getColumn(4); // Give column index here
                column2.setCellRenderer(new Utilidades.TableColor_OCProvee());

                TableColumn column3 = columnModel.getColumn(5); // Give column index here
                column3.setCellRenderer(new Utilidades.TableColor_OCProvee());

                TableColumn column4 = columnModel.getColumn(6); // Give column index here
                column4.setCellRenderer(new Utilidades.TableColor_OCProvee());
                TableColumn column5 = columnModel.getColumn(7); // Give column index here
                column5.setCellRenderer(new Utilidades.TableColor_OCProvee());
                TableColumn column6 = columnModel.getColumn(8); // Give column index here
                column6.setCellRenderer(new Utilidades.TableColor_OCProvee());

            }
        } catch (Exception e) {
            fmMain.Mensaje("Error al cargar: " + e);
            Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Sql.Close();
        }
    }

    private void CargaRelacion(String Codigo) {
        DefaultTableModel TableModel = (DefaultTableModel) GrillaRelacion.getModel();
        ExeSql Sql = new ExeSql();
        ResultSet Rs;

        while (TableModel.getRowCount() > 0) {
            TableModel.removeRow(0);
        }

        try {
            Rs = Sql.Select("select t.skurel,p.nombre,t.cantidad\n"
                    + "from transformacion t\n"
                    + "left join  producto p on p.sku=t.skurel\n"
                    + "where t.sku='" + Codigo + "'");

            while (Rs.next()) {
                TableModel.addRow(new Object[]{
                    Rs.getString("skurel").trim(),
                    Rs.getString("nombre").trim(),
                    Rs.getDouble("cantidad")
                });
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Sql.Close();
        }
    }
//--------------------------------------------------------------------------------
// Habilita o deshabilita edicion de productos
//--------------------------------------------------------------------------------

    private void GeneraCodigo() {
        ExeSql Sql = new ExeSql();
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
        } finally {
            Sql.Close();
        }
    }
//--------------------------------------------------------------------------------
// Habilita o deshabilita edicion de productos
//--------------------------------------------------------------------------------

    private void Limpia() {
        int RespTipo = Tipo;

        DefaultTableModel Model = (DefaultTableModel) GrillaRelacion.getModel();
        while (Model.getRowCount() > 0) {
            Model.removeRow(0);
        }

        //Limpia Grilla Venta
        DefaultTableModel ModelVta = (DefaultTableModel) GrillaVenta.getModel();
        while (ModelVta.getRowCount() > 0) {
            ModelVta.removeRow(0);
        }

        //Limpia Grilla Venta
        DefaultTableModel ModelMov = (DefaultTableModel) GrillaMovimientos.getModel();
        while (ModelMov.getRowCount() > 0) {
            ModelMov.removeRow(0);
        }

        //Limpia Grilla Compras
        DefaultTableModel ModelComp = (DefaultTableModel) GrillaCompras.getModel();
        while (ModelComp.getRowCount() > 0) {
            ModelComp.removeRow(0);
        }

        //Limpia Grilla FacturasC
        DefaultTableModel ModelFact = (DefaultTableModel) GrillaFacturasC.getModel();
        while (ModelFact.getRowCount() > 0) {
            ModelFact.removeRow(0);
        }

        Tipo = 0;
        txSku.setText("");
        txNombre.setText("");
        //txCodBar.setText("");
        //txCodBar2.setText("");
        txPeso.setText("");

        txLargo.setText("");
        txAncho.setText("");
        txAlto.setText("");

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
        jtDescripcion.setText("");
        jtURL.setText("");
        cbFamilia.setSelectedIndex(-1);
        cbSubFamilia.setSelectedIndex(-1);
        cbUnidad.setSelectedIndex(-1);
        cbConvenio.setSelectedIndex(-1);
        txPosicion.setText("");
        txNuevoMinimo.setText("");
        chk_minimo.setSelected(false);
        lsCodbar.removeAll();
        chbOfertaAutomatica.setSelected(false);

        if (lsChilecompras.isEnabled() && lsChilecompras.isVisible()) {

            DefaultListModel limpiaLsChilecompras = new DefaultListModel();
//    DefaultListModel limpiaLsChilecompras= (DefaultListModel) lsChilecompras.getModel();
//    limpiaLsChilecompras.removeAllElements();
        }

        if (lsCodbar.isEnabled() && lsCodbar.isVisible()) {
            DefaultListModel limpiaLsChilecompras = new DefaultListModel();
//    DefaultListModel limpiaLsCodBarra= (DefaultListModel) lsCodbar.getModel();
//    limpiaLsCodBarra.removeAllElements();
        }

        if (modelLotes != null) {
            while (modelLotes.getRowCount() > 0) {
                modelLotes.removeRow(0);
            }
        }

        chkNoTransado.setSelected(false);
        chkWeb.setSelected(false);
        chkPublicado.setSelected(false);
        chkDesxPrecio.setSelected(false);
        chkStock.setSelected(false);
        chkDiscontinuado.setSelected(false);
        chkdeshabilitado.setSelected(false);
        txPUltCompra.setText("");
        txUbicados.setText("");
        txTransito.setText("");
        txPosicion.setText("");
        txMargen.setBackground(Color.white);
        txMinimo.setBackground(Color.white);
        Tipo = RespTipo;
    }
//--------------------------------------------------------------------------------
// Habilita o deshabilita edicion de productos
//--------------------------------------------------------------------------------

    private void Habilita(boolean Estado) {
//    cbLinea.setEnabled(Estado);
//    cbSubLinea.setEnabled(Estado);
//    cbUnidad.setEnabled(Estado);

        txNombre.setEnabled(Estado);
        //txCodBar2.setEnabled(Estado);
        txPeso.setEnabled(Estado);

        txLargo.setEnabled(Estado);
        txAncho.setEnabled(Estado);
        txAlto.setEnabled(Estado);

        Pestanas.setEnabled(Estado);
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
        chkWeb.setEnabled(Estado);
        chkDesxPrecio.setEnabled(Estado);
        chkNoTransado.setEnabled(Estado);

        chkStock.setEnabled(Estado);
        chkDiscontinuado.setEnabled(Estado);
        chkdeshabilitado.setEnabled(Estado);
        btUbica.setEnabled(Estado);
        txUbicados.setEnabled(Estado);
        txTransito.setEnabled(Estado);

        lsCodbar.setVisible(Estado);
        lsChilecompras.setVisible(Estado);
        lsCodbar.setEnabled(Estado);
        lsChilecompras.setEnabled(Estado);
        txidchmadre.setEnabled(Estado);
        chkIva.setEnabled(true);

    }
//--------------------------------------------------------------------------------
// Habilita o deshabilita edicion de productos
//--------------------------------------------------------------------------------

    private void Edicion(boolean Estado) {
        txNombre.setEditable(Estado);
        //txCodBar2.setEditable(Estado);
        txPeso.setEditable(Estado);

        txLargo.setEditable(Estado);
        txAncho.setEditable(Estado);
        txAlto.setEditable(Estado);

        txDisplay.setEditable(Estado);

        btGuardar.setEnabled(Estado);
        btCancelar.setEnabled(Estado);
        btAgregaRelacion.setEnabled(Estado);
        btEliminaRelacion.setEnabled(Estado);

        txidchmadre.setEditable(Estado);
        // 1. Obtener usuario actual (Asumiendo que fmMain.GetUsuario() devuelve el String del login)
        String usuarioActual = "";
        try {
            usuarioActual = fmMain.GetUsuario().trim();
        } catch (Exception e) {
            usuarioActual = "";
        }

        // 2. Definir quiénes tienen permiso (Lista Blanca)
        boolean tienePermisoLotes = usuarioActual.equals("LRUBILAR")
                || usuarioActual.equals("LEORUBILAR")
                || usuarioActual.equals("ALOPEZ");

        // 3. Aplicar lógica a los botones
        if (btAgregaLote != null && btEliminaLote != null && btEditarLote != null) {

            if (Estado && tienePermisoLotes) {
                // Si está editando (Estado=true) Y tiene permiso -> HABILITAR
                btAgregaLote.setEnabled(true);
                btEliminaLote.setEnabled(true);
                btEditarLote.setEnabled(true);
            } else {
                // Si no está editando O no tiene permiso -> DESHABILITAR
                btAgregaLote.setEnabled(false);
                btEliminaLote.setEnabled(false);
                btEditarLote.setEnabled(false);
            }
        }

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
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        DefaultComboBoxModel cbmUnidad, cbmUnidadId;
        cbmUnidad = new DefaultComboBoxModel();
        cbmUnidadId = new DefaultComboBoxModel();

        cbUnidad.setModel(cbmUnidad);
        cbUnidadId.setModel(cbmUnidadId);
        try {
            Rs = Sql.Select("select codigo,trim(unidad) as unidad from par_unidad");
            while (Rs.next()) {
                cbUnidad.addItem(Rs.getString("unidad"));
                cbUnidadId.addItem(Rs.getString("codigo"));

            }

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
        ExeSql Sql = new ExeSql();
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
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        int TipoAux;

        cbFamilia.removeAllItems();
        cbFamiliaCod.removeAllItems();
        cbFamiliaSku.removeAllItems();
        TipoAux = Tipo;

        try {
            if (Tipo == 1 && cbConvenioCod.getSelectedIndex() > -1) {
                Rs = Sql.Select("select codigo,linea,cod from par_linea where convenio = " + cbConvenioCod.getSelectedItem().toString().trim() + " order by codigo");
            } else {
                Rs = Sql.Select("select codigo,linea,cod from par_linea order by codigo");
            }
            Tipo = -99;
            // Recorre Query
            while (Rs.next()) {
                // Carga lineas en Combo
                cbFamilia.addItem(Rs.getString("linea"));
                cbFamiliaCod.addItem(Rs.getString("codigo"));
                cbFamiliaSku.addItem(Rs.getString("cod"));
            }

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            Sql.Close();
            Tipo = TipoAux;
        }

    }
//--------------------------------------------------------------------------------
// Carga PRODUCTOS
//--------------------------------------------------------------------------------

    public void CargaProducto(String Codigo) {

        ExeSql Sql = new ExeSql();
        ExeSql Sql2 = new ExeSql();
        ResultSet Rs = null, Rs1 = null, Rs2 = null, Rs3 = null;
        Tipo = 0;
        double Margen;
        int revisa_codbar = 0;
        int revisa_codchile = 0;
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
        txtCrearRelacion.setEnabled(true);
        btBuscarRelacionado.setEnabled(true);
        btEstablecerRelacionado.setEnabled(true);
        valor_vendedor.setEnabled(true);
        jButton4.setEnabled(true);

        try {
            String Query;
            //Limpia la Lista

            modelo.removeAllElements();
            modelo2.removeAllElements();

            lsCodbar.setModel(modelo);
            lsChilecompras.setModel(modelo2);

            Rs = Sql.Select("select codbar, sku from codbar where sku='" + Codigo + "' or codbar='" + Codigo + "'");

            if (Rs.next()) {

                Codigo = Rs.getString("sku").trim();
                revisa_codbar++;
            }

            Rs = Sql.Select("select idch, sku from codchile where sku='" + Codigo + "' or idch='" + Codigo + "'");

            if (Rs.next()) {

                Codigo = Rs.getString("sku").trim();
                revisa_codchile++;
            }

            Rs = Sql.Select("select codbar, sku from codbar where sku='" + Codigo + "' or codbar='" + Codigo + "'");

            if (Rs.next()) {

                Codigo = Rs.getString("sku").trim();
                revisa_codbar++;
            }

            Rs = Sql.Select("select nropublicacion, sku from producto where nropublicacion IN ('" + Codigo.trim() + "')");

            if (Rs.next()) {

                Codigo = Rs.getString("sku").trim();

            }

            if (revisa_codbar >= 1) {

                Rs = Sql.Select("select c.codbar, CASE WHEN p.nombre is null THEN 'nulo' ELSE p.nombre END from codbar c left join proveedor p on c.rutprv=p.rut where c.sku='" + Codigo + "'");
                modelo.clear();
                String prove = "";

                while (Rs.next()) {

                    if (Rs.getString("nombre").trim().equals("nulo")) {

                        prove = "";

                    } else {

                        prove = " - " + Rs.getString("nombre").trim();

                    }

                    modelo.addElement(Rs.getString("codbar").trim() + prove);
                }
            }

            if (revisa_codchile >= 1) {

                Rs = Sql.Select("select idch from codchile where sku='" + Codigo + "' order by idch");
                modelo2.clear();

                while (Rs.next()) {

                    modelo2.addElement(Rs.getString("idch").trim());

                }

            }

            Rs3 = Sql.Select("select codweb, publicado from codweb where sku = '" + Codigo + "'");
            Rs3.next();

            if (Rs3.getRow() > 0) {

                chkWeb.setSelected(Rs3.getBoolean("publicado"));

            } else {

                chkWeb.setSelected(false);
            }

            if (lsChilecompras.getModel().getSize() == 0) {

                Rs2 = Sql.Select("SELECT sku, discontinuado from producto where sku = '" + Codigo + "'");
                Rs2.next();

                chkDiscontinuado.setSelected(Rs2.getBoolean("discontinuado"));

            }

            Query = "select p.sku,p.publicado, p.sincompetencia, p.desxprecio, p.notransado, p.discontinuado, p.sinstock, p.oferta_inicio, p.oferta_fin, p.oferta, p.display, "
                    + "p.sku,p.nombre,p.unidad,p.linea,p.sublinea,p.codbar,p.codbar2,p.vigente,"
                    + "p.peso,p.largo, p.ancho,p.alto,cast(p.fcreacion as date) as fcreacion,p.usuariocreacion,p.otroimpuesto,\n"
                    + "i.stock,i.ocp,i.occ,i.gdc, p.pventa,p.valultcompra,p.nropublicacion,p.precio_publicar,p.comision,p.envio, p.costofinal, \n"
                    + "p.imptoiva,p.convenio,p.otroimpuesto,p.marca, p.minimo,calcula_minimo, \n"
                    + "(select sum(separado) from occhdet where sku=p.sku and codigo_oc <> 99999) as separado, pr.posicion, p.sin_publicar ,\n"
                    + "(select sum(diferencia) from mt_auditoria_ubicaciones where sku=p.sku ) as auditoria \n"
                    + "from producto p\n"
                    + "left join inventario i\n"
                    + "on p.sku=i.sku\n"
                    + "left join producto_posicion pr\n"
                    + "on p.sku = pr.sku\n"
                    + "where p.es_cotiza<>1 and (p.sku='" + Codigo + "' or p.sku in (select sku from codbar where codbar='" + Codigo + "')) ";

            Rs = Sql.Select(Query);

            if (Sql.GetRowCount() == 0) {
                Rs = Sql.Select("select p.publicado, p.sincompetencia, p.desxprecio, p.notransado,  p.oferta, p.oferta_inicio, p.oferta_fin, p.display, "
                        + "p.sku,p.nombre,p.unidad,p.linea,p.sublinea,p.codbar,p.codbar2,p.vigente,"
                        + "p.peso,p.largo, p.ancho,p.alto,cast(p.fcreacion as date) as fcreacion,p.usuariocreacion,p.otroimpuesto,\n"
                        + "i.stock,i.ocp,i.occ,i.gdc, p.pventa,p.valultcompra,p.nropublicacion, p.precio_publicar,p.comision,p.envio,p.costofinal,\n"
                        + "p.imptoiva,p.convenio,p.otroimpuesto,p.marca,p.minimo,calcula_minimo, \n"
                        + "(select sum(separado) from occhdet where sku=p.sku and codigo_oc <> 99999) as separado, pr.posicion, p.sin_publicar\n"
                        + "from producto p\n"
                        + "left join inventario i\n"
                        + "on p.sku=i.sku and p.es_cotiza<>1\n"
                        + "left join producto_posicion pr\n"
                        + "on p.sku = pr.sku\n");
            }
            Rs.next();
            Codigo = Rs.getString("sku").trim();
            skulabel.setText(Codigo);

            chkNoTransado.setSelected(Rs.getBoolean("notransado"));
            String Nombre = Rs.getString("nombre");
            if (Nombre.length() > 20) {
                Nombre.substring(0, 20);//***
            }

            int valorMinimo = 0;
            if (Rs.getString("minimo") == null) {
                valorMinimo = 0;
            } else {
                valorMinimo = Rs.getInt("minimo");
            }
            double calculoMinimo = ((valorMinimo * 80) / 100);

            // carga el check_minimo
            if (Rs.getBoolean("calcula_minimo")) {
                chk_minimo.setSelected(true);
            } else {
                chk_minimo.setSelected(false);
            }

            fmMain.pnPestanas.setTitleAt(fmMain.pnPestanas.getSelectedIndex(), Nombre);
            fmMain.pnPestanas.repaint();
            txSku.setText(Rs.getString("sku"));
            txNombre.setText(ElTrim(Rs.getString("nombre")));

            txDisplay.setText(ElTrim(Rs.getString("display")));

            int critico = (int) Math.ceil(Double.parseDouble(txDisplay.getText().trim()) / 4);  //  (Math.ceil) devuelve el entero mayor o igual más próximo
            txCritico.setText("" + critico);

            txPeso.setText(String.valueOf(Rs.getDouble("peso")));

            txLargo.setText(String.valueOf(Rs.getInt("largo")));
            txAncho.setText(String.valueOf(Rs.getInt("ancho")));
            txAlto.setText(String.valueOf(Rs.getInt("alto")));

            CalculaM3();

            txStockInv.setText(Rs.getString("stock"));
            txStockOCP.setText(Rs.getString("ocp"));
            txStockOCC.setText(Rs.getString("occ"));
            txStockGDC.setText(Rs.getString("gdc"));
            double StockTotal = Rs.getDouble("stock") + Rs.getDouble("ocp") + Rs.getDouble("occ") + Rs.getDouble("gdc");
            txStockTotal.setText(String.valueOf(StockTotal));
            txSeparado.setText(Rs.getString("separado"));

            txAuditoria.setText("" + (Rs.getInt("auditoria") * -1));

            SumaAjustes();

            if (lbAjustes.getText().trim().equals("0")) {

                btAjustes.setEnabled(false);

            } else {

                btAjustes.setEnabled(true);

            }

            txCreacionUsuario.setText(Rs.getString("usuariocreacion").trim());
            txCreacionFecha.setText(Rs.getString("fcreacion").trim());

            double critico2 = Double.parseDouble(txCritico.getText().trim());

            if (valorMinimo > critico2) {

                txMinimo.setBackground(Color.green);

            } else if (valorMinimo <= critico2) {

                txMinimo.setBackground(Color.red);
            }

            txMinimo.setText(Integer.toString(valorMinimo));

            //MENSAJE POSICION DE PRODUCTO EN MERCADOPUBLICO
            if (Rs.getString("posicion") == (null)) {
                txPosicion.setToolTipText("El producto no existe en el portal MercadoPublico");
                txPosicion.setText("0");
            } else if (Integer.parseInt(Rs.getString("posicion")) >= 1 && Integer.parseInt(Rs.getString("posicion")) <= 500) {
                txPosicion.setText(Rs.getString("posicion"));
                txPosicion.setToolTipText("El producto se encuentra en la posición número " + (Rs.getString("posicion")) + " en el portal MercadoPublico");
            } else if (Integer.parseInt(Rs.getString("posicion")) == 1011) {
                txPosicion.setText(Rs.getString("posicion"));
                txPosicion.setToolTipText("El producto no se encuentra en la primera página o no existe dentro del portal MercadoPublico");
            } else if (Integer.parseInt(Rs.getString("posicion")) == 1020) {
                txPosicion.setText(Rs.getString("posicion"));
                txPosicion.setToolTipText("El producto no se encuentra en el portal MercadoPublico");
            } else if (Integer.parseInt(Rs.getString("posicion")) == 1030) {
                txPosicion.setText(Rs.getString("posicion"));
                txPosicion.setToolTipText("El producto no existe en el portal MercadoPublico o fue eliminado");
            }

            try {
                if (Rs.getDouble("pventa") > 0) {
                    Margen = (Rs.getDouble("pventa") - Rs.getDouble("costofinal")) * 100 / Rs.getDouble("pventa");
                } else {
                    Margen = 0;
                }
                txPNeto.setText(Rs.getString("pventa"));
                txPUltCompra.setText(fmMain.FormatoTotal(Rs.getDouble("valultcompra")));
                txPCosto.setText(fmMain.FormatoTotal(Rs.getDouble("costofinal")));
                txMargen.setText(fmMain.FormatoTotal(Margen) + "%");

                if (Margen > 30) {
                    txMargen.setBackground(Color.green);
                } else if (Margen > 20) {
                    txMargen.setBackground(Color.yellow);
                } else {
                    txMargen.setBackground(Color.red);
                }

            } catch (Exception e) {
                txMargen.setBackground(Color.white);
            }

            txNroPublicacion.setText("" + Rs.getString("nropublicacion").toString().trim());
            txPublicacion.setText("" + Rs.getDouble("precio_publicar"));
            txComision.setText("" + Rs.getDouble("comision"));
            txEnvio.setText("" + Rs.getDouble("envio"));

            //MOSTRAR CAMPOS PARA EDICIÓN DEL MINIMO
            int pruebaUusario = 85;
            int intNivelUsuario = 0;
            intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());

            if (intNivelUsuario >= pruebaUusario) {
                lbNuevoMinimo.setVisible(true);
                txNuevoMinimo.setVisible(true);
                btGuardarMinimo.setVisible(true);
                chk_minimo.setVisible(true);
            } else {
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

            PosUM = cbUnidad.getSelectedIndex();
            PosLinea = cbFamilia.getSelectedIndex();
            PosSubLinea = cbSubFamilia.getSelectedIndex();
            PosConvenio = cbConvenio.getSelectedIndex();
            PosImpuesto = cbOtroImpuesto.getSelectedIndex();

            if (cbConvenioCod.getSelectedItem().equals("2")) {

                TablaConvenio = "ferreteria";

            } else if (cbConvenioCod.getSelectedItem().equals("3")) {

                TablaConvenio = "aseo";

            } else if (cbConvenioCod.getSelectedItem().equals("4")) {

                TablaConvenio = "alimentos";

            } else if (cbConvenioCod.getSelectedItem().equals("11")) {

                TablaConvenio = "emergencia";

            } else if (cbConvenioCod.getSelectedItem().equals("7")) {

                TablaConvenio = "escritorio";

            }

            //-----------------------------  trae Transito y Ubicados-----------
            Query = "select \n"
                    + " case sum(cant) when null then 0 else sum(cant) end as cantidad\n"
                    + " from mt_productos\n"
                    + " where sku = '" + Codigo + "'\n"
                    + " and ubicacion not in  ('" + fmMain.BodegaOCDirecta() + "','" + fmMain.BodegaTransito() + "','"
                    + fmMain.BodegaAnticipada() + "','" + fmMain.BodegaNegativos() + "','" + fmMain.BodegaPositivos() + "','" + fmMain.BodegaNCP() + "')";
            //" and ubicacion not in  ('" + fmMain.BodegaTransito() + "','"  + fmMain.BodegaNCC()+ "','" + fmMain.BodegaNCP()+ "','" + fmMain.BodegaOCDirecta()+ "','" + fmMain.BodegaTransformacion()+ "')";

            Rs1 = Sql.Select(Query);

            if (Rs1.next()) {
                txUbicados.setText(String.valueOf(Rs1.getDouble("cantidad")));
            }

            Query = "select \n"
                    + " case sum(cant) when null then 0 else sum(cant) end as cantidad\n"
                    + " from mt_productos\n"
                    + " where sku = '" + Codigo + "'\n"
                    + " and ubicacion = '" + fmMain.BodegaTransito() + "'";

            Rs1 = Sql.Select(Query);

            if (Rs1.next()) {
                txTransito.setText(String.valueOf(Rs1.getDouble("cantidad")));
            }

            //------------------------------------------------------------------
            ResultSet Rsl = Sql.Select("select valor_proveedor from producto where sku = '" + Codigo + "'");
            Rsl.next();

            if (Rsl.getRow() > 0) {

                valor_vendedor.setText(Rsl.getString("valor_proveedor"));

            } else {

                valor_vendedor.setText("0");
            }

            if (lsChilecompras.getModel().getSize() == 0) {

                chkdeshabilitado.setSelected(true);

            } else {

                chkdeshabilitado.setSelected(false);
            }

//            CargaMovimientos(Codigo);
//            CargaVentas(Codigo);
//            CargaCompras(Codigo);
//            // OrdenesProveedor();
//            CargaRelacion(Codigo);
//            SetTipo(2);
//            CargaReglasLote(Codigo.trim());
//            // cargarImagenDesdeBd();
//            //CargaFechaLlegadaProveedor();
//
//            carga_montos_ventas();
//            carga_publica_ventas();
//            Codchile();
//
//            OtrosStock();
//
//            CargaWeb();
//
//            Pestanas.setEnabled(true);
//
//            System.out.println("El CONVENIO ES : " + cbConvenioCod.getSelectedItem());
//
//            carga_ubicainv(txSku.getText().trim());

            // 1. Activamos la interfaz básica inmediatamente
            SetTipo(2);
            Pestanas.setEnabled(true);
            System.out.println("El CONVENIO ES : " + cbConvenioCod.getSelectedItem());

            // 2. ¡TURBO! Lanzamos todo el resto en paralelo
            cargarDatosComplementarios(Codigo);

        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Sql.Close();
        }
    }
    
    /**
     * MÉTODO OPTIMIZADO: Carga toda la información secundaria en paralelo.
     * Esto evita que el usuario espere a que termine una consulta para empezar la siguiente.
     */
    private void cargarDatosComplementarios(String Codigo) {
        // Creamos un "equipo" de 6 hilos trabajando al mismo tiempo
        java.util.concurrent.ExecutorService executor = java.util.concurrent.Executors.newFixedThreadPool(6);

        // 1. Cargar Movimientos (Hilo 1)
        executor.submit(() -> {
            try {
                CargaMovimientos(Codigo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // 2. Cargar Ventas (Hilo 2)
        executor.submit(() -> {
            try {
                CargaVentas(Codigo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // 3. Cargar Compras (Hilo 3)
        executor.submit(() -> {
            try {
                CargaCompras(Codigo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // 4. Cargar Relaciones y Reglas (Hilo 4)
        executor.submit(() -> {
            try {
                CargaRelacion(Codigo);
                CargaReglasLote(Codigo.trim());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // 5. Cargar Stocks Externos y Ubicaciones (Hilo 5)
        executor.submit(() -> {
            try {
                OtrosStock();
                carga_ubicainv(txSku.getText().trim());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // 6. Cargar Web y Cálculos de Ventas (Hilo 6)
        executor.submit(() -> {
            try {
                Codchile();
                CargaWeb();

                // Los cálculos que tocan muchos textfields visuales los ejecutamos 
                // asegurando que la UI esté lista para recibirlos
                javax.swing.SwingUtilities.invokeLater(() -> {
                    carga_montos_ventas();
                    carga_publica_ventas();
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Cerramos el pool para liberar memoria cuando terminen
        executor.shutdown();
    }

    private void OtrosStock() {

        ExeSql_Econa SqlEcona = new ExeSql_Econa();
        ExeSqlDisosur SqlDisosur = new ExeSqlDisosur();

        ResultSet RsEcona = null;
        ResultSet RsDisosur = null;

        String StockEco = "0";
        String StockDis = "0";

        try {

            RsEcona = SqlEcona.Select("SELECT sku, stock FROM inventario\n"
                    + "WHERE sku = '" + txSku.getText().trim() + "'");

            if (SqlEcona.GetRowCount() > 0) {

                RsEcona.next();

                StockEco = RsEcona.getString("stock");

            } else {

                StockEco = "0";

            }

            txStockEcona.setText(StockEco.trim());

            RsDisosur = SqlDisosur.Select("SELECT sku, stock FROM inventario\n"
                    + "WHERE sku = '" + txSku.getText().trim() + "'");

            if (SqlDisosur.GetRowCount() > 0) {

                RsDisosur.next();

                StockDis = RsDisosur.getString("stock");

            } else {

                StockDis = "0";

            }

            txStockDisosur.setText(StockDis);

        } catch (SQLException ex) {
            Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }

    }

    private void CargaWeb() {

        try {
            ExeSql sql = new ExeSql();
            ResultSet rs = null;

            String sku = txSku.getText().trim();
            if (!sku.equals("")) {
                if (CheckIfExist(sku)) {
                    String query = "select url_luvaly, url_mercadolibre, url_yapo, pvp_coniva, ml_coniva, valor_general from producto where sku = '" + sku + "'";
                    try {
                        rs = sql.Select(query);
                        if (rs.next()) {
                            url_mercado.setText(rs.getString("url_mercadolibre"));
                            url_web.setText(rs.getString("url_luvaly"));
                            url_yapo.setText(rs.getString("url_yapo"));
                            valor_mercadolibre.setText(rs.getString("ml_coniva"));
                            valor_publico.setText(rs.getString("pvp_coniva"));
                            jLabel43.setText(rs.getString("valor_general"));
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontraron datos");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró producto");
                }
            }

            //jButton5.setEnabled(true);
            url_mercado.setEnabled(true);
            url_web.setEnabled(true);
            url_yapo.setEnabled(true);
            valor_publico.setEnabled(true);
            valor_mercadolibre.setEnabled(true);
            jLabel43.setEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void SumaAjustes() {

        ExeSql Sql = new ExeSql();
        ResultSet Rs = null;

        try {

            String Query = "select sum(a.cantidad) as cant from ajustedet_autoriza a \n"
                    + "left join ajusteenc_autoriza aj on a.folio = aj.folio \n"
                    + "where a.sku IN ('" + txSku.getText().trim() + "') \n"
                    + "and aj.autorizado = false and aj.rechazado = 0";

            Rs = Sql.Select(Query);

            if (Sql.GetRowCount() > 0) {

                Rs.next();
                lbAjustes.setText("" + Rs.getInt("cant"));

            } else {

                lbAjustes.setText("0");

            }

        } catch (SQLException ex) {
            Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void carga_publica_ventas() {

        ultcompra = 0;
        propuesta = 0;
        publicadoIVA = 0;
        publicadoNETO = 0;
        Margen2 = 0;

        ultcompra = Double.parseDouble(txPUltCompra.getText().trim().replaceAll("\\,", ""));

        propuesta = Math.round((ultcompra / 0.50) * 1.19);

        preciopublica = Double.parseDouble(txPublicacion.getText());
        comision = Double.parseDouble(txComision.getText());
        envio = Double.parseDouble(txEnvio.getText());

        publicadoIVA = Math.round(preciopublica - (comision + envio));

        publicadoNETO = Math.round(publicadoIVA / 1.19);

        Margen2 = Math.round(((publicadoNETO - ultcompra) / publicadoNETO) * 100);

        if (Margen2 < 0) {

            Margen2 = 0;

        }

        txPropuesta.setText("" + propuesta);

        txPublicadoIva.setText("" + publicadoIVA);
        txPublicadoNeto.setText("" + publicadoNETO);
        txMargen2.setText("" + Margen2);

        if (Margen2 < 30) {

            txMargen2.setForeground(Color.red);
            txMargen2.setBorder(BorderFactory.createLineBorder(Color.red, 2));

        } else if (Margen2 >= 30) {

            txMargen2.setForeground(new Color(0, 153, 51));
            txMargen2.setBorder(BorderFactory.createLineBorder(new Color(0, 153, 51), 2));

        }

    }

    private void carga_montos_ventas() {

        ExeSql Sql1 = new ExeSql();
        ExeSql Sql3 = new ExeSql();

        ResultSet Rs1;
        ResultSet Rs3;

        double valor_uc = 0;
        double vunitario = 0;
        double cost_ref = 0;
        double cost_vent_neto1 = 0;
        double cost_vent_neto2 = 0;

        double cost_vent_neto4 = 0;

        double cost_redon = 0;
        double cost_vent_iva = 0;
        double cost_vent_empresa = 0;

        try {

            valor_uc = Double.parseDouble(txPUltCompra.getText().trim().replaceAll("\\,", ""));

            Rs3 = Sql3.Select("SELECT ccd.sku, ccd.valorunitario, ccd.tipdocto, ccd.nrodocto FROM ctacteprvdet ccd\n"
                    + "WHERE ccd.sku = '" + txSku.getText().trim() + "'\n"
                    + "AND ccd.tipdocto IN ('OCP')\n"
                    + "ORDER BY ccd.nrodocto DESC\n"
                    + "LIMIT 1");
            Rs3.next();

            if (Sql3.GetRowCount() > 0) {

                vunitario = Rs3.getDouble("valorunitario");

            } else {

                vunitario = 0;

            }

            if (valor_uc >= vunitario) {

                cost_ref = valor_uc;

            } else if (vunitario >= valor_uc) {

                cost_ref = vunitario;

            }

            cost_vent_neto1 = Math.round((cost_ref / 0.94) * 1.19);

            cost_vent_empresa = Math.round((valor_uc / 0.75 * 1.19));

            lb1.setText("" + cost_vent_neto1);

            cost_redon = cost_vent_empresa % 10;   //Extrae el el utlimo digito de la cifra

            double dif = 10 - cost_redon;

            if (cost_redon >= 1) {

                cost_vent_empresa = cost_vent_empresa + dif;

            }

            lb3.setText("" + cost_vent_empresa);

            Rs1 = Sql1.Select("SELECT sku, pventa_web, pventa_web2, compra, compra2 FROM producto \n"
                    + "WHERE sku = '" + txSku.getText().trim() + "'");

            if (Sql1.GetRowCount() > 0) {

                Rs1.next();

                cost_vent_neto2 = Rs1.getDouble("pventa_web");
                cost_vent_neto4 = Rs1.getDouble("pventa_web2");

                lbWeb.setText("" + cost_vent_neto2);
                txWeb.setText("" + cost_vent_neto4);

                if (Rs1.getInt("compra2") == 3) {

                    txWeb.setBackground(Color.GREEN);

                } else {

                    txWeb.setBackground(Color.WHITE);

                }

                precioWeb = Double.parseDouble(txWeb.getText().trim());
                precioWeb2 = Double.parseDouble(txWeb.getText().trim());

                compra = Rs1.getInt("compra");

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, e);

        }

    }

    private void carga_facturas_orden(String StOrden) {
        ExeSql Sql = new ExeSql();
        ResultSet Rs, Rs1;
        String Query, QTot = "";
        DefaultTableModel TableModel = (DefaultTableModel) GrillaFacturasC.getModel();
        try {
            Query = "select c.rut,c.nrodocto, c.tipdocto from \n"
                    + "ctacteprv c\n"
                    + "where \n"
                    + "c.nrodocorigen =" + StOrden + "\n"
                    + "and c.tipdocorigen  ='OCP' and\n"
                    + "c.tipdocto ='FAP'";

//     Limpia Ordenes Encabezado   
            while (TableModel.getRowCount() > 0) {
                TableModel.removeRow(0);
            }

            Rs = Sql.Select(Query);

            while (Rs.next()) {

                TableModel.addRow(new Object[]{Rs.getString("rut").trim(),
                    Rs.getInt("nrodocto"), Rs.getString("tipdocto")});
            }
            Rs.close();
        } catch (SQLException e) {
            fmMain.Mensaje("Existe una inconsistencia en la información.");
            Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Sql.Close();
        }

    }


    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        if (Tipo == 1 || Tipo == 3) {
            if (JOptionPane.showConfirmDialog(null, "¿Cancelar sin guardar?") == JOptionPane.YES_OPTION) {
                if (Tipo == 1) {
                    SetTipo(-1);
                } else {
                    CargaProducto(txSku.getText());
                }
                SetTipo(-1);

                btAgregaID.setEnabled(true);
                btEliminaID.setEnabled(true);

            }

        } else {
            SetTipo(-1);
        }

        txWeb.setText("" + precioWeb);
        actualizaWeb = 0;
        txWeb.setBackground(new Color(240, 240, 240));

        txWeb.setEnabled(false);
        btActWeb.setEnabled(false);

        txNroPublicacion.setEnabled(false);
        txPublicacion.setEnabled(false);
        txComision.setEnabled(false);
        txEnvio.setEnabled(false);
        txidchmadre.setEnabled(false);

    }//GEN-LAST:event_btCancelarActionPerformed

    private void cbFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFamiliaActionPerformed

        if (Carga == 0) {

            Carga = 1;

        }

        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        int AuxTipo;
        if (Tipo == 2 || Tipo == -1 || Tipo == 3) {
            cbFamilia.setSelectedIndex(PosLinea);
        } else if (cbFamilia.getSelectedIndex() > -1 && Tipo != -99) {

            cbFamiliaCod.setSelectedIndex(cbFamilia.getSelectedIndex());

            // Carga Combo Linea
            if (cbFamilia.getSelectedIndex() >= 0) {
                int CodLinea = Integer.valueOf(cbFamiliaCod.getSelectedItem().toString());

                cbSubFamilia.removeAllItems();
                cbSubFamiliaCod.removeAllItems();
                cbSubFamiliaSku.removeAllItems();
                AuxTipo = Tipo;
                Tipo = -99;
                try {
                    Rs = Sql.Select("select codigo,sublinea,cod from par_sublinea where linea = " + CodLinea);
                    System.out.println("select codigo,sublinea,cod from par_sublinea where linea = " + CodLinea);
                    while (Rs.next()) {
                        cbSubFamilia.addItem(Rs.getString("sublinea"));
                        cbSubFamiliaCod.addItem(Rs.getString("codigo"));
                        cbSubFamiliaSku.addItem(Rs.getString("cod"));
                    }
                    Tipo = AuxTipo;
                } catch (SQLException ex) {
                    System.out.println(ex);
                    Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    Sql.Close();
                }
            }
            GeneraCodigo();
        }


    }//GEN-LAST:event_cbFamiliaActionPerformed


    private void btIrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIrActionPerformed

        Runnable miRunnable = new Runnable() {
            public void run() {
                try {

                    lbcargando.setEnabled(true);
                    lbcargando.setVisible(true);

                    Pestanas.setSelectedIndex(0);
                    carga_producto();
                    jButton5.setEnabled(true);

                    lbcargando.setVisible(false);
                    lbcargando.setEnabled(false);

                    carga_ubicainv(txSku.getText().trim());

                } catch (Exception e) {
                    e.printStackTrace();
                    Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        };
        Thread hilo = new Thread(miRunnable);
        hilo.start();

        lbcargando.setText("Cargando.....");
        URL urlInfo = this.getClass().getResource("/Iconos16/wait.gif");
        ImageIcon IconoInfo = new ImageIcon(urlInfo);
        lbcargando.setIcon(IconoInfo);
        lbcargando.setForeground(Color.red);
    }//GEN-LAST:event_btIrActionPerformed

    private void carga_ubicainv(String Sku) {

        try {
            ExeSql Sql = new ExeSql();
            ResultSet Rs = null;
            DefaultTableModel TableModel2 = (DefaultTableModel) Grilla_Inv.getModel();

            while (TableModel2.getRowCount() > 0) {
                TableModel2.removeRow(0);
            }

            Rs = Sql.Select("SELECT mt.ubicacion, cm.nombre, mt.sku, mt.cant, pu.unidad FROM mt_productos mt \n"
                    + "LEFT JOIN mt_codmetro cm ON mt.ubicacion = cm.codmetro "
                    + "LEFT JOIN producto p ON mt.sku = p.sku \n"
                    + "LEFT JOIN par_unidad pu ON pu.codigo = p.unidad \n"
                    + "WHERE mt.sku ='" + Sku + "' AND (mt.cant > 0 OR mt.cant < 0)");

            if (Sql.GetRowCount() > 0) {

                while (Rs.next()) {

                    TableModel2.addRow(new Object[]{Rs.getString("ubicacion"), Rs.getString("nombre"), Rs.getString("sku"), Rs.getString("cant"), Rs.getString("unidad")});

                }

            }

            Grilla_Inv.setDefaultRenderer(Object.class, new Elrender());

        } catch (SQLException ex) {
            Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void carga_producto() {
        String codbarfinal = txSku.getText().replace("'", "-");
        txSku.setText(codbarfinal.trim());

        if (!txSku.getText().isEmpty() && Tipo != 1) {

            if (CheckIfExist(txSku.getText()) || CheckIDCH(txSku.getText()) || CheckCOD(txSku.getText()) || CheckML(txSku.getText())) {

                CargaProducto(txSku.getText());

            } else {

                JOptionPane.showMessageDialog(null, "No existe producto.");
                txSku.setText("");
                Tipo = 0;
                Limpia();
                Tipo = -1;
                Edicion(false);
                Habilita(false);
                lbcargando.setEnabled(false);
            }

        } else if (!txSku.getText().isEmpty() && Tipo == 1) {

            txNombre.requestFocus();
            JOptionPane.showMessageDialog(null, "No existe producto.");
            txSku.setText("");
            Tipo = 0;
            Limpia();
            Tipo = -1;
            Edicion(false);
            Habilita(false);
            lbcargando.setEnabled(false);
        } else {

            jdBuscarProductos BP = new jdBuscarProductos(null, true);
            BP.setLocationRelativeTo(null);
            BP.setTitle("Buscar Producto");
            BP.setVisible(true);
            BP.SetCotiza(false);
            if (!"".equals(BP.GetCodigo())) {
                CargaProducto(BP.GetCodigo());
            }
        }

    }

    public void ActualizarMinimo() {
        ExeSql Sql = new ExeSql();
        ResultSet Rs = null, Rs1 = null;
        String Query;
        String Sku = txSku.getText();
        try {

            Query = "UPDATE producto SET \n"
                    + "minimo =" + txNuevoMinimo.getText() + "," + "calcula_minimo = " + chk_minimo.isSelected() + " \n"
                    + "WHERE sku = '" + txSku.getText() + "'";

            Sql.ExeSql(Query);
            Sql.Commit();
            JOptionPane.showMessageDialog(null, "Nuevo Mínimo Registrado");
            CargaProducto(Sku);
            txNuevoMinimo.setText("");
        } catch (SQLException e) {
            Sql.Rollback();
            JOptionPane.showMessageDialog(null, "Error al guardar !!!:\n" + e.getMessage());
            Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e);
        } finally {
            Sql.Close();
        }

    }

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        SetTipo(3);

        txWeb.setEnabled(true);
        txWeb.setBackground(Color.white);

        txNroPublicacion.setEnabled(true);
        txPublicacion.setEnabled(true);
        txComision.setEnabled(true);
        txEnvio.setEnabled(true);

        System.out.println(fmMain.GetUsuario());

        if (fmMain.GetUsuario().equals("CMORALES") || fmMain.GetUsuario().equals("LRUBILAR")) {

            chkDiscontinuado.setEnabled(true);

        } else {

            chkDiscontinuado.setEnabled(false);

        }

        if (fmMain.GetUsuarioEditaNomSku()) {

            txNombre.setEnabled(true);

        } else {

            txNombre.setEnabled(false);

        }


    }//GEN-LAST:event_btEditarActionPerformed

    public void CargaFechaLlegadaProveedor() {

        ExeSql sql = new ExeSql();
        ResultSet rs = null;

        String query = "select date_part('day', fecha_llegada)|| '/' || \n"
                + "date_part('month', fecha_llegada)|| '/' ||\n"
                + "date_part('year', fecha_llegada) as fecha from fechallegadaprv\n"
                + "where sku = '" + txSku.getText() + "'\n"
                + "order by fecha_llegada desc\n"
                + "limit 1";
        try {

            rs = sql.Select(query);
            rs.next();

            if (rs.getRow() > 0) {

                jtFechaLlegada.setText(rs.getString("fecha"));

            } else {

                jtFechaLlegada.setText("Sin fecha");
            }

        } catch (SQLException ex) {

            Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            sql.Close();
        }

    }

    public boolean CheckIfExist(String sku) {
        boolean existe = false;
        ExeSql sql = new ExeSql();
        ResultSet rs = null;

        String Query = "select p.sku,p.publicado, p.sincompetencia, p.desxprecio, p.notransado, p.discontinuado, p.sinstock, p.oferta_inicio, p.oferta_fin, p.oferta, p.display, p.sku,p.nombre,p.unidad,p.linea,p.sublinea,p.codbar,p.codbar2,p.vigente,p.peso,cast(p.fcreacion as date) as fcreacion,p.usuariocreacion,p.otroimpuesto,\n"
                + "i.stock,i.ocp,i.occ,i.gdc, p.pventa,p.valultcompra,p.costofinal,p.imptoiva,p.convenio,p.otroimpuesto,p.marca, p.minimo,calcula_minimo, (select sum(separado) from occhdet where sku=p.sku) as separado, pr.posicion, p.sin_publicar\n"
                + "from producto p\n"
                + "left join inventario i\n"
                + "on p.sku=i.sku\n"
                + "left join producto_posicion pr\n"
                + "on p.sku = pr.sku\n"
                + "where p.es_cotiza<>1 and p.sku='" + sku + "' or p.sku in (select sku from codbar where codbar='" + sku + "')";
        try {
            rs = sql.Select(Query);
            rs.last();

            if (rs.getRow() > 0) {

                existe = true;

            } else {

                existe = false;
            }

        } catch (SQLException ex) {

            Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return existe;
    }

    public boolean CheckIfExistDiso(String sku) {

        boolean existe = false;
        ExeSqlDisosur sql = new ExeSqlDisosur();
        ResultSet rs = null;
        String Query = "select p.sku,p.publicado, p.sincompetencia, p.desxprecio, p.notransado, p.discontinuado, p.sinstock, p.oferta_inicio, p.oferta_fin, p.oferta, p.display, p.sku,p.nombre,p.unidad,p.linea,p.sublinea,p.codbar,p.codbar2,p.vigente,p.peso,cast(p.fcreacion as date) as fcreacion,p.usuariocreacion,p.otroimpuesto,\n"
                + "i.stock,i.ocp,i.occ,i.gdc, p.pventa,p.valultcompra,p.costofinal,p.imptoiva,p.convenio,p.otroimpuesto,p.marca, p.minimo,calcula_minimo, (select sum(separado) from occhdet where sku=p.sku) as separado, pr.posicion, p.sin_publicar\n"
                + "from producto p\n"
                + "left join inventario i\n"
                + "on p.sku=i.sku\n"
                + "left join producto_posicion pr\n"
                + "on p.sku = pr.sku\n"
                + "where p.es_cotiza<>1 and p.sku='" + sku + "' or p.sku in (select sku from codbar where codbar='" + sku + "')";
        try {
            rs = sql.Select(Query);
            rs.last();

            if (rs.getRow() > 0) {

                existe = true;

            } else {

                existe = false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return existe;
    }

    public boolean CheckIDCH(String idch) {
        boolean existe = false;
        ExeSql sql = new ExeSql();
        ResultSet rs = null;

        try {
            rs = sql.Select("select sku from codchile where idch='" + idch + "'");
            if (rs.next()) {
                existe = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return existe;
    }

    public boolean CheckCOD(String cod) {
        boolean existe = false;
        ExeSql sql = new ExeSql();
        ResultSet rs = null;

        try {
            rs = sql.Select("select sku from codbar where codbar='" + cod + "'");
            if (rs.next()) {
                existe = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return existe;
    }

    public boolean CheckML(String cod) {
        boolean existe = false;
        ExeSql sql = new ExeSql();
        ResultSet rs = null;

        try {
            rs = sql.Select("select sku from producto where nropublicacion IN ('" + cod.trim() + "')");
            if (rs.next()) {
                existe = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return existe;
    }


    private void txSkuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txSkuKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btIr.doClick();
//                Runnable miRunnable = new Runnable() {
//                    public void run() {
//                        try{
//
//                            lbcargando.setEnabled(true);
//                            lbcargando.setVisible(true);
//                            
//                            
//                                carga_producto();
//                                carga_ubicainv(txSku.getText().trim());
//                             
//                                
//                            lbcargando.setVisible(false);
//                            lbcargando.setEnabled(false);
//                            //Grilla.changeSelection(0, 0 , false, false);
//
//
//
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                };
//                Thread hilo = new Thread(miRunnable);
//                hilo.start();
//
//
//                lbcargando.setText("Cargando.....");
//                URL urlInfo =  this.getClass().getResource("/Iconos16/wait.gif");
//                ImageIcon IconoInfo =  new ImageIcon(urlInfo); 
//                lbcargando.setIcon(IconoInfo);
//                lbcargando.setForeground(Color.red);
        } else if (Character.isLetter(evt.getKeyChar()) && !chkCodigo.isSelected()) {

            jdBuscarProductos BP = new jdBuscarProductos(null, true);
            BP.setLocationRelativeTo(null);
            BP.setTitle("Buscar Producto");
            BP.SetTexto(txSku.getText() + Character.toString(evt.getKeyChar()));
            //txSku.setText("");  
            BP.setVisible(true);
            BP.SetCotiza(false);

            if (!"".equals(BP.GetCodigo())) {
                Limpia();
                CargaProducto(BP.GetCodigo());

            }

        }
    }//GEN-LAST:event_txSkuKeyPressed

    private void txSkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txSkuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txSkuActionPerformed

    private void btNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNuevoActionPerformed
        if (fmMain.GetEstado(fmMain.pnPestanas.getSelectedIndex()) == 0) {
            SetTipo(1);
            txWeb.setEnabled(true);
            btAgregaID.setEnabled(false);
            btEliminaID.setEnabled(false);

        }

        txWeb.setEnabled(true);
        txWeb.setBackground(Color.white);//
        txWeb.setText("0");
        txNroPublicacion.setText("0");
        txPublicacion.setText("0");
        txComision.setText("0");
        txEnvio.setText("0");
        txPeso.setText("0");
        txLargo.setText("0");
        txAncho.setText("0");
        txAlto.setText("0");
        txDisplay.setText("2");

        txNombre.setEnabled(false);
        txDisplay.setText("");
        txDisplay.setEnabled(false);
        txidchmadre.setEnabled(false);
        chkIva.setEnabled(false);
        chkDisosur.setVisible(false);
        txPeso.setEnabled(false);
        txLargo.setEnabled(false);
        txAncho.setEnabled(false);
        txAlto.setEnabled(false);

        cbOtroImpuesto.setEnabled(false);

        chkWeb.setEnabled(false);
        chkPublicado.setEnabled(false);
        chkDesxPrecio.setEnabled(false);
        chkStock.setEnabled(false);
        chkDiscontinuado.setEnabled(false);
        chkdeshabilitado.setEnabled(false);

        txWeb.setEnabled(false);

        Pestanas.setEnabled(false);


    }//GEN-LAST:event_btNuevoActionPerformed

    private int AfectoIva() {
        if (chkIva.isSelected()) {
            return 1;
        } else {
            return 0;
        }
    }

//-----------------------------------------------------------------------------
//  BOTON GUARDAR
//-----------------------------------------------------------------------------
    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed

        ExeSql Sql = new ExeSql();
        ExeSql Sql2 = new ExeSql();
        ExeSql Sql3 = new ExeSql();

        ExeSqlDisosur diso = new ExeSqlDisosur();
        String Query, Query2;
        String Sku = txSku.getText().trim();

        if ((cbConvenio.getSelectedIndex() == -1 || cbFamilia.getSelectedIndex() == -1 || cbSubFamilia.getSelectedIndex() == -1
                || cbUnidad.getSelectedIndex() == -1) && !Sku.contains("0999999")) {

            JOptionPane.showMessageDialog(null, "Faltan datos");
            return;
        }

        if (fmMain.OkCancel("¿Guardar Cambios?") == JOptionPane.OK_OPTION) {

            boolean Publicado = chkPublicado.isSelected();
            boolean Web = chkWeb.isSelected();
            boolean DesxPrecio = chkDesxPrecio.isSelected();
            boolean NoTransado = chkNoTransado.isSelected();
            boolean EnOferta = chkOferta.isSelected();
            boolean DesHabilitado = chkdeshabilitado.isSelected();
            boolean Discontinuado = chkDiscontinuado.isSelected();
            boolean SinStock = chkStock.isSelected();
            String PPublico = txPNeto.getText();
            String Peso = txPeso.getText();

            String Largo = txLargo.getText().trim();
            String Ancho = txAncho.getText().trim();
            String Alto = txAlto.getText().trim();

            String Display = txDisplay.getText();
            String Familia;
            String SubFamilia;
            String Marca;
            String Convenio;
            String OtroImpuesto;
            fmMain.SetGuardar(Display);
            if (PPublico.isEmpty()) {
                PPublico = "0";
            }

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

            if (txNombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe definir un nombre para el producto");
                return;
            }

            if (txNroPublicacion.getText().trim().isEmpty()) {
                txNroPublicacion.setText("0");
            }

            // -------------------------------------------------------------------------
            // CASO 1: NUEVO PRODUCTO
            // -------------------------------------------------------------------------
            if (Tipo == 1) {

                try {
                    // 1. Decidimos qué query de INSERCIÓN usar según el usuario
                    if (fmMain.GetUsuario().trim().equals("LRUBILAR")) {

                        Query = "INSERT INTO producto (sku, unidad, nombre, pventa, imptoiva, linea, sublinea, peso, largo, ancho, alto, marca, display, publicado, discontinuado, "
                                + "sinstock, desxprecio, notransado, convenio, sin_publicar, pventa_web2, precio_publicar, comision, envio, nropublicacion) "
                                + "VALUES ('" + txSku.getText() + "', "
                                + cbUnidadId.getSelectedItem().toString().trim() + ","
                                + "'" + txNombre.getText().trim() + "',"
                                + PPublico + "," + AfectoIva() + "," + Familia + "," + SubFamilia + ","
                                + fmMain.SetGuardar(Peso) + "," + Largo + "," + Ancho + "," + Alto + "," + Marca + ","
                                + Display + "," + Publicado + "," + Discontinuado + "," + SinStock + "," + DesxPrecio + ","
                                + NoTransado + "," + Convenio + "," + DesHabilitado + "," + txWeb.getText().trim() + ","
                                + txPublicacion.getText().trim() + "," + txComision.getText().trim() + ","
                                + txEnvio.getText().trim() + ",'" + txNroPublicacion.getText().trim() + "')";

                        Sql.ExeSql(Query);
                        System.out.println("Paso 1: Producto insertado en tabla principal.");

                        // Lógica específica de LRUBILAR para la tabla de transformación
                        Sql.ExeSql("delete from transformacion where sku='" + txSku.getText() + "'");
                        System.out.println("Paso 2: Transformaciones antiguas eliminadas.");

                        for (int i = 0; i < GrillaRelacion.getRowCount(); i++) {
                            Sql.ExeSql("INSERT into TRANSFORMACION (sku, skurel, cantidad) VALUES ("
                                    + "'" + txSku.getText() + "',"
                                    + "'" + GrillaRelacion.getValueAt(i, 0).toString().trim() + "',"
                                    + GrillaRelacion.getValueAt(i, 2).toString() + ")");
                        }
                        System.out.println("Paso 3: Nuevas transformaciones insertadas.");

                    } else { // Si no es LRUBILAR

                        Query = "INSERT INTO producto_autoriza (sku, unidad, nombre, convenio, linea, sublinea, display, nombre_generico, marca, modelo, tallacontenido) "
                                + "VALUES ('" + txSku.getText() + "',"
                                + cbUnidadId.getSelectedItem().toString().trim() + ","
                                + "'" + txNombre.getText().trim() + "',"
                                + Convenio + "," + Familia + "," + SubFamilia + ","
                                + txDisplay.getText().trim() + ","
                                + "'" + txNombreGen.getText().trim() + "',"
                                + "'" + txMarca.getText().trim() + "',"
                                + "'" + txModelo.getText().trim() + "',"
                                + "'" + txTallaCont.getText().trim() + "')";

                        Sql.ExeSql(Query);
                        System.out.println("Paso 1: Producto insertado en tabla de autorización.");
                    }

                    // 2. Actualizamos el contador. Esto se ejecuta para AMBOS casos.
                    String queryUpdateContador = "UPDATE par_sublinea SET contador = contador + 1 WHERE codigo = " + SubFamilia;
                    Sql.ExeSql(queryUpdateContador);
                    System.out.println("Paso final: Contador de sublínea actualizado.");

                    // 3. Confirmamos la transacción completa del producto
                    Sql.Commit();

                    // ===========================================================================
                    // >>> AQUI GUARDAMOS LOS LOTES (Justo despues del Commit del producto) <<<
                    // ===========================================================================
                    GuardarReglasLote(txSku.getText().trim());
                    // ===========================================================================

                    // 4. Mostramos el mensaje de éxito y actualizamos la UI según el caso
                    if (fmMain.GetUsuario().trim().equals("LRUBILAR")) {
                        JOptionPane.showMessageDialog(null, "Producto Guardado");
                        SetTipo(-1);
                        CargaProducto(Sku); // Recargamos para ver los cambios
                    } else {
                        JOptionPane.showMessageDialog(null, "Producto Guardado para Autorización!!");
                        SetTipo(-1);
                    }

                } catch (SQLException e) {
                    Sql.Rollback();
                    JOptionPane.showMessageDialog(null, "Error al guardar el producto: " + e.getMessage());
                    Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, e);

                } finally {
                    Sql.Close();
                    diso.Close(); // Cerrar conexión disosur si se abrió
                }

                // -------------------------------------------------------------------------
                // CASO 2: EDITAR PRODUCTO (Tipo == 3)
                // -------------------------------------------------------------------------
            } else if (Tipo == 3) {

                try {
                    precioWeb = Double.parseDouble(txWeb.getText().trim());

                    if (precioWeb2 != precioWeb) {
                        compra = 0;
                        if (fmMain.GetUsuario().equals("LEORUBILAR")) {
                            compra2 = 3;
                        }
                    }

                    Query = "UPDATE producto SET\n"
                            + "  unidad= " + cbUnidadId.getSelectedItem().toString().trim()
                            + ", nombre='" + txNombre.getText().trim() + "'"
                            + ", pventa=" + PPublico
                            + ", linea=" + cbFamiliaCod.getSelectedItem().toString().trim()
                            + ", sublinea=" + cbSubFamiliaCod.getSelectedItem().toString().trim()
                            + ", peso=" + fmMain.SetGuardar(Peso)
                            + ", largo=" + Largo
                            + ", ancho=" + Ancho
                            + ", alto=" + Alto
                            + ", display=" + Display
                            + ", publicado=" + Publicado
                            + ", discontinuado=" + Discontinuado
                            + ", sinstock=" + SinStock
                            + ", desxprecio=" + DesxPrecio
                            + ", notransado=" + NoTransado
                            + ", marca=" + Marca
                            + ", convenio=" + Convenio
                            + ", sin_publicar = " + DesHabilitado
                            + ", pventa_web2 = " + txWeb.getText().trim()
                            + ", precio_publicar = " + txPublicacion.getText().trim()
                            + ", comision = " + txComision.getText().trim()
                            + ", envio = " + txEnvio.getText().trim()
                            + ", nropublicacion = '" + txNroPublicacion.getText().trim()
                            + "', compra = " + compra
                            + ", compra2 = " + compra2
                            + "  WHERE sku = '" + txSku.getText() + "'";

                    Sql.ExeSql(Query);

                    // Actualizar transformaciones
                    Sql.ExeSql("delete from transformacion where sku='" + txSku.getText() + "'");

                    for (int i = 0; i < GrillaRelacion.getRowCount(); i++) {
                        Sql.ExeSql("INSERT into TRANSFORMACION (sku,skurel,cantidad) VALUES ("
                                + "'" + txSku.getText() + "',"
                                + "'" + GrillaRelacion.getValueAt(i, 0).toString().trim() + "',"
                                + GrillaRelacion.getValueAt(i, 2).toString() + ")");
                    }

                    // Commit de la actualización principal
                    Sql.Commit();

                    // ===========================================================================
                    // >>> AQUI GUARDAMOS LOS LOTES (Justo despues del Commit del producto) <<<
                    // ===========================================================================
                    GuardarReglasLote(txSku.getText().trim());
                    // ===========================================================================

                    // Actualizar Disosur si corresponde
                    if (chkDisosur.isSelected()) {
                        Query2 = "UPDATE codchile SET cant_unidad ="; // (Parece incompleto en tu código original, lo dejo igual)

                        // Query Disosur INSERT (revisar si debería ser Update o Insert según lógica)
                        Query = "INSERT INTO producto\n"
                                + "(sku, unidad, nombre, pventa, imptoiva, linea, sublinea, peso,marca, display, publicado, discontinuado, sinstock, desxprecio, notransado, convenio, sin_publicar)\n"
                                + "VALUES \n"
                                + "('" + txSku.getText() + "', "
                                + cbUnidadId.getSelectedItem().toString().trim() + ","
                                + "'" + txNombre.getText().trim() + "',"
                                + PPublico + ","
                                + AfectoIva() + ","
                                + Familia + ","
                                + SubFamilia + ","
                                + fmMain.SetGuardar(Peso) + ","
                                + Marca + ","
                                + Display + ","
                                + Publicado + ","
                                + Discontinuado + ","
                                + SinStock + ","
                                + DesxPrecio + ","
                                + NoTransado + ","
                                + Convenio + ","
                                + DesHabilitado + ")";

                        int resultado = diso.ExeSqlInt(Query);
                        if (resultado > 0) {
                            System.out.println("Se registro en disosur");
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Producto Guardado");
                    SetTipo(-1);
                    CargaProducto(Sku); // Recargar para ver cambios reflejados

                } catch (Exception e) {
                    Sql.Rollback();
                    JOptionPane.showMessageDialog(null, "Error al guardar !!!:\n" + e.getMessage());
                    System.out.println(e);
                } finally {
                    Sql.Close();
                    diso.Close();
                }
            }

            // Deshabilitar controles post-guardado
            txWeb.setEnabled(false);
            btActWeb.setEnabled(false);
            txNroPublicacion.setEnabled(false);
            txPublicacion.setEnabled(false);
            txComision.setEnabled(false);
            txEnvio.setEnabled(false);
            txidchmadre.setEnabled(false);
        }
    }//GEN-LAST:event_btGuardarActionPerformed

    public void guardarImagen() {
        ExeSql Sql = new ExeSql();
        String qryInsAudito;
        String Query = "";
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

        if (lbImagen.getIcon() == null) {

            return;
        }

        ImageIcon icon = (ImageIcon) lbImagen.getIcon();
        BufferedImage imgproc = new BufferedImage(icon.getIconWidth(),
                icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics g = imgproc.createGraphics();
        icon.paintIcon(null, g, 0, 0);
        g.setColor(Color.WHITE);
        g.dispose();

        Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");

        System.out.println(date.format(now));
        System.out.println(hour.format(now));
        System.out.println(now);

        try {
            String ruta = "";
            String sistema = System.getProperty("os.name").toLowerCase();
            File folder = new File("");
            if (sistema.contains("win")) {
                ruta = "c:/fotosproductos/";
                folder = new File(ruta.substring(0, ruta.length() - 1));
            } else {
                ruta = "/fotosproductos/";
                folder = new File(ruta);
            }
            System.out.println("1- indica la ruta");
            System.out.println(ruta);

            System.out.println("2- pregunta Si la ruta Existe");
            if (!folder.exists()) {
                folder.mkdir();
                System.out.println("3");
            }

            System.out.println("4-Indicamos Ruta - Directorio estaba creado");
            System.out.println(ruta + sku + ".png");
            File file = new File(ruta + sku + ".png");
            System.out.println("4-1 (");
            file.setReadable(true);
            System.out.println("4-2");
            ImageIO.write((RenderedImage) imgproc, "png", file);
            System.out.println("5");

            //SubeFTP Sube = new SubeFTP();
            String laruta = ruta + sku + ".png";
            String rutafinal = sku + ".png";

            //CODIGO ACTIVAR ---------------------------------------------------------------------------
            SubeFTP.SubeArch(laruta, rutafinal);
            Query = " update producto set imagen = '\\\\\\\\192.168.0.130\\\\fotosproductos\\\\" + rutafinal + "' where sku='" + sku + "'";
            Sql.ExeSql(Query);
            //CODIGO ACTIVAR ---------------------------------------------------------------------------

            Sql.Commit();
            guardo = 1;
            //fmMain.Mensaje("Se ha guardado la imagen correctamente");
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            fmMain.Mensaje("Verifique que este creada la carpeta c:\\fotosproductos\\ y que tenga conexion al servidor 130");
        } catch (SQLException ex) {
            Logger.getLogger(jdVoucher.class.getName()).log(Level.SEVERE, null, ex);
            Sql.Rollback();
        } finally {
            Sql.Close();

        }
    }

    public void cargarImagenDesdeBd() {
        ResultSet Rs;
        ExeSql Sql = new ExeSql();
        String server, user, pass, ruta_local = "";
        int puerto = 21;
        String rutaimage = "";
        String sku = "";
        String skuBusca = txSku.getText();
        try {

//            server= "192.168.0.130";
//            user="voucher";
//            pass="V2369";
            //trae datos ftp
            server = "";
            puerto = 0;
            user = "";
            pass = "";
            Rs = Sql.Select("SELECT * from conexiones where usu='fotoproducto'");
            if (Rs.next()) {
                server = Rs.getString("serv");
                user = Rs.getString("usu");
                puerto = Rs.getInt("port");
                pass = Rs.getString("pass");
            }
            //trae datos ftp

            Rs = Sql.Select("SELECT imagen, sku from producto where sku='" + skuBusca + "';");
            Rs.next();
            if (Rs.getInt("sku") >= 1) {
                if (sku.equals("")) {
                    sku = Rs.getString("sku");
                }
                Rs = Sql.Select("SELECT imagen, sku from producto where sku='" + skuBusca + "';");
                Rs.next();
                if (Rs.getString("imagen") != null) {

                    //Verifica SO
                    String sistema = System.getProperty("os.name").toLowerCase();
                    File folder = new File("");
                    if (sistema.contains("win")) {
                        ruta_local = "c:/fotosproductos/";
                        folder = new File(ruta_local.substring(0, ruta_local.length() - 1));
                    } else {
                        ruta_local = "/fotosproductos/";
                        folder = new File(ruta_local);
                    }
                    if (!folder.exists()) {
                        folder.mkdir();
                    }

                    rutaimage = Rs.getString("imagen");
                    String archivo = rutaimage.substring(35, rutaimage.length());
                    Ftp.baja_archivo_ftp(server, puerto, user, pass, "/" + archivo, ruta_local + archivo);

                    File file = new File(ruta_local + archivo);
//                     BufferedImage read = ImageIO.read(file);
//                    Image scaledInstance = read.getScaledInstance(220, 220, Image.SCALE_DEFAULT);
//                    lbImagen.setIcon(new ImageIcon(scaledInstance));
//                    lbImagen.setText("");

                    try {
                        fis = new FileInputStream(file);
                        //necesitamos saber la cantidad de bytes
                        this.longitudBytes = (int) file.length();
                        try {
                            Image icono = ImageIO.read(file).getScaledInstance(lbImagen.getWidth(), lbImagen.getHeight(), Image.SCALE_DEFAULT);
                            lbImagen.setIcon(new ImageIcon(icono));
                            lbImagen.updateUI();

                        } catch (IOException ex) {
                        }
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }

                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            Sql.Close();

        }
    }


    private void cbUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUnidadActionPerformed
        if (Tipo == 2 || Tipo == -1)
            cbUnidad.setSelectedIndex(PosUM);
        else if (Tipo != -99)
            cbUnidadId.setSelectedIndex(cbUnidad.getSelectedIndex());
    }//GEN-LAST:event_cbUnidadActionPerformed

    private void cbSubFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSubFamiliaActionPerformed
        if (Tipo == 2 || Tipo == -1 || Tipo == 3) {
            cbSubFamilia.setSelectedIndex(PosSubLinea);
        } else if (cbSubFamilia.getSelectedIndex() >= 0 && cbSubFamiliaCod.getItemCount() > 0) {
            cbSubFamiliaCod.setSelectedIndex(cbSubFamilia.getSelectedIndex());
            GeneraCodigo();

            System.out.println("Carga ANTES ES : " + Carga);

            if (Carga == 0) {

                Carga++;

            } else if (Carga == 1) {

                Carga++;

            }

        }

        System.out.println("Carga DESPUES ES : " + Carga);

        if (Tipo == 1 && Carga > 1) {

            jdNuevoSku nsk = new jdNuevoSku(null, true);
            nsk.setLocationRelativeTo(null);
            nsk.setTitle("Nuevo Sku");
            nsk.setVisible(true);

            Carga = 1;

            txNombre.setText(nsk.GetNombreCompleto());
            txDisplay.setText(nsk.GetEmbalaje());

            txNombreGen.setText(nsk.GetNombreGenerico());
            txMarca.setText(nsk.GetMarca());
            txModelo.setText(nsk.GetModelo());
            txTallaCont.setText(nsk.GetTallaCon());

        }


    }//GEN-LAST:event_cbSubFamiliaActionPerformed

    private void cbConvenioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbConvenioActionPerformed
        if (Tipo == 2 || Tipo == -1 || Tipo == 3) {
            cbConvenio.setSelectedIndex(PosConvenio);
        } else if (Tipo == 1) {
            cbConvenioCod.setSelectedIndex(cbConvenio.getSelectedIndex());

            System.out.println("Tipo ES :" + Tipo);
            System.out.println("ENTRA a  else if(Tipo==1)");

            CargaLineas();
        } else if (Tipo != -99) {

            System.out.println("Tipo ES :" + Tipo);
            System.out.println("ENTRA a else if (Tipo != -99 )");
            cbConvenioCod.setSelectedIndex(cbConvenio.getSelectedIndex());
            GeneraCodigo();
        }

    }//GEN-LAST:event_cbConvenioActionPerformed

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btEliminarActionPerformed

    private void txPesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txPesoKeyTyped
        if (evt.getKeyChar() == ',' || evt.getKeyChar() == '.') {
            evt.consume();
            if (!txPeso.getText().contains(fmMain.GetDecimal())) {
                txPeso.setText(txPeso.getText() + fmMain.GetDecimal());
            }
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

        char c = evt.getKeyChar();
        asciivalor = (int) c;

        switch (asciivalor) {
            case 39:
            case 44:
                //case 46:
                getToolkit().beep();
                evt.consume();
                System.out.println("Ingresar sin apostrofes, comas ni puntos" + "  caracter---> " + evt.getKeyChar() + "   (-----)    codigo ascii " + asciivalor);
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
        if (Tipo != -99) {
            cbConvenioSku.setSelectedIndex(cbConvenioCod.getSelectedIndex());
        }

    }//GEN-LAST:event_cbConvenioCodActionPerformed

    private void cbFamiliaCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFamiliaCodActionPerformed
        if (Tipo != -99)
            cbFamiliaSku.setSelectedIndex(cbFamiliaCod.getSelectedIndex());
    }//GEN-LAST:event_cbFamiliaCodActionPerformed

    private void cbSubFamiliaCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSubFamiliaCodActionPerformed
        if (Tipo != -99)
            cbSubFamiliaSku.setSelectedIndex(cbSubFamiliaCod.getSelectedIndex());
    }//GEN-LAST:event_cbSubFamiliaCodActionPerformed

    private void cbOtroImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOtroImpuestoActionPerformed
        if (Tipo == 2 || Tipo == -1) {
            cbOtroImpuesto.setSelectedIndex(PosImpuesto);
        } else if (Tipo != -99) {
            cbOtroImpuestoId.setSelectedIndex(cbOtroImpuesto.getSelectedIndex());
            cbOtroImpuestoTaza.setSelectedIndex(cbOtroImpuesto.getSelectedIndex());
            txTazaImpuesto.setText(cbOtroImpuestoTaza.getSelectedItem().toString().trim() + "%");
        }

    }//GEN-LAST:event_cbOtroImpuestoActionPerformed

    private void cbOtroImpuestoIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOtroImpuestoIdActionPerformed
        if (Tipo != -99) {
            cbOtroImpuesto.setSelectedIndex(cbOtroImpuestoId.getSelectedIndex());
            cbOtroImpuestoTaza.setSelectedIndex(cbOtroImpuestoId.getSelectedIndex());
            txTazaImpuesto.setText(cbOtroImpuestoTaza.getSelectedItem().toString().trim() + "%");
        }

        cbConvenioSku.setSelectedIndex(cbConvenioCod.getSelectedIndex());
    }//GEN-LAST:event_cbOtroImpuestoIdActionPerformed

    private void MnuAbrirOCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuAbrirOCCActionPerformed

        String orden = "";

        if (GrillaVenta.getValueAt(GrillaVenta.getSelectedRow(), 4).toString().trim().contains("-")) {

            orden = GrillaVenta.getValueAt(GrillaVenta.getSelectedRow(), 4).toString().trim().split("-")[1];

        } else {

            orden = GrillaVenta.getValueAt(GrillaVenta.getSelectedRow(), 4).toString().trim();

        }

        System.out.println("LA orden ES : " + orden);

        if (orden.contains("ml") || orden.contains("web") || orden.contains("n")) {

            pfOCCliente_Trans OCC = new pfOCCliente_Trans();

            OCC.AbreOCC(GrillaVenta.getValueAt(GrillaVenta.getSelectedRow(), 1).toString().trim(), GrillaVenta.getValueAt(GrillaVenta.getSelectedRow(), 3).toString().trim(), GrillaVenta.getValueAt(GrillaVenta.getSelectedRow(), 4).toString().trim());
            pnPestanas.addTab("OC Cliente", OCC);
            PanelTab btc = new PanelTab(pnPestanas, 0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(OCC), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);

        } else {

            pfOCCliente OCC = new pfOCCliente();

            OCC.AbreOCC(GrillaVenta.getValueAt(GrillaVenta.getSelectedRow(), 1).toString().trim(), GrillaVenta.getValueAt(GrillaVenta.getSelectedRow(), 3).toString().trim(), GrillaVenta.getValueAt(GrillaVenta.getSelectedRow(), 4).toString().trim());
            pnPestanas.addTab("OC Cliente", OCC);
            PanelTab btc = new PanelTab(pnPestanas, 0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(OCC), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);

        }


    }//GEN-LAST:event_MnuAbrirOCCActionPerformed

    private void MnuAbrirOCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuAbrirOCPActionPerformed
        pfOCProveedor PrvOC = new pfOCProveedor();
        PrvOC.AbrirOCP(GrillaCompras.getValueAt(GrillaCompras.getSelectedRow(), 3).toString().trim());
        pnPestanas.addTab("OC Proveedor", PrvOC);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(PrvOC), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_MnuAbrirOCPActionPerformed

    private void btAgregaIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregaIDActionPerformed
        // TODO add your handling code here:
        if (!txSku.getText().toString().trim().equals("") || !txNombre.getText().toString().trim().equals("")) {

            jdAgregaIDCH agregarCH = new jdAgregaIDCH(null, true);
            agregarCH.setLocationRelativeTo(null);
            agregarCH.Datos(txSku.getText().toString().trim(), txNombre.getText().toString().trim(), cbConvenioCod.getSelectedItem().toString().trim(), txidchmadre.getText().trim());
            agregarCH.setTitle("Agregar ID");
            agregarCH.setVisible(true);
            ResultSet Rs, Rs2;
            ExeSql Sql = new ExeSql();
            DefaultListModel modelo2 = new DefaultListModel();
            lsChilecompras.setModel(modelo2);
            try {
                Rs = Sql.Select("select idch from codchile where sku='" + txSku.getText().trim() + "'");
                modelo2.clear();
                while (Rs.next()) {

                    modelo2.addElement(Rs.getString("idch").trim());
                }

                Rs2 = Sql.Select("select * from codchile where sku='" + txSku.getText().trim() + "' AND idch = '" + agregarCH.GetID() + "'");
                Rs2.next();

                txCantUnidad.setText(Rs2.getString("cant_unidad"));

            } catch (Exception e) {

            } finally {

                Sql.Close();
            }
        }


    }//GEN-LAST:event_btAgregaIDActionPerformed


    private void btEliminaIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminaIDActionPerformed

        if (lsChilecompras.getSelectedIndex() != -1) {
            String codigo;
            codigo = lsChilecompras.getSelectedValue().toString();
            String[] parts = codigo.split("-");

            String codigo_busca = parts[0];
            System.out.println(codigo_busca);

            if (JOptionPane.showConfirmDialog(null, "¿Desea Eliminar el ID?") == JOptionPane.YES_OPTION) {

                ResultSet Rs;
                ExeSql Sql = new ExeSql();

                ResultSet Rs3;
                ExeSql Sql3 = new ExeSql();

                try {
                    ResultSet rs = Sql.Select("select * from codchile where sku='" + txSku.getText().toString().trim() + "' and idch='" + codigo_busca + "'");
                    rs.next();
                    if (rs.getRow() > 0) {
                        int resultado = Sql.ExeSqlInt("DELETE from codchile where sku='" + txSku.getText().toString().trim() + "' and idch='" + codigo_busca + "'");
                        if (resultado > 0) {
                            Sql.Commit();
                            fmMain.Mensaje("ID ELIMINADA");
                        } else {
                            Sql.Rollback();
                            fmMain.Mensaje("Error al eliminar ID");
                        }
                    } else {
                        ResultSet rs2 = Sql.Select("select sku_rel, (select idch from codchile where sku = sku_rel) from codproducto_rel where sku = '" + txSku.getText().toString().trim() + "'");
                        rs2.next();
                        if (rs2.getRow() > 0) {
                            int resultado_2 = Sql.ExeSqlInt("DELETE from codproducto_rel where sku='" + txSku.getText().toString().trim() + "'");
                            if (resultado_2 > 0) {
                                Sql.Commit();
                                fmMain.Mensaje("ID asociada ELIMINADA");
                            } else {
                                Sql.Rollback();
                                fmMain.Mensaje("Error al eliminar ID asociada");
                            }
                        }
                    }

                    if (cbConvenioCod.getSelectedItem().equals("2")) {

                        TablaConvenio = "ferreteria";

                    } else if (cbConvenioCod.getSelectedItem().equals("3")) {

                        TablaConvenio = "aseo";

                    } else if (cbConvenioCod.getSelectedItem().equals("4")) {

                        TablaConvenio = "alimentos";

                    } else if (cbConvenioCod.getSelectedItem().equals("11")) {

                        TablaConvenio = "emergencia";

                    } else if (cbConvenioCod.getSelectedItem().equals("7")) {

                        TablaConvenio = "escritorio";

                    }

                    Rs3 = Sql3.Select("SELECT * FROM " + TablaConvenio + " WHERE id = '" + codigo_busca.trim() + "'");

                    if (Sql3.GetRowCount() > 0) {

                        Sql3.ExeSql("UPDATE " + TablaConvenio + " SET \n"
                                + "sku = '', \n"
                                + "precio_compra = 0, \n"
                                + "margen_luvaly = 0, \n"
                                + "margen_primero = 0, \n"
                                + "margen_segundo = 0, \n"
                                + "margen_tercero = 0, \n"
                                + "id_madre = 0 \n"
                                + "WHERE id = '" + codigo_busca.trim() + "'");
                        Sql3.Commit();

                    }

                } catch (Exception e) {
                    Sql.Rollback();
                    Sql3.Rollback();
                    fmMain.Mensaje("Error al eliminar: " + e);
                    return;
                } finally {
                    Sql.Close();
                    Sql3.Close();

                }
                DefaultListModel model = (DefaultListModel) lsChilecompras.getModel();
                model.remove(lsChilecompras.getSelectedIndex());
            }
        }
    }//GEN-LAST:event_btEliminaIDActionPerformed

    private void MnuCopia_OCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuCopia_OCActionPerformed
        // TODO add your handling code here:
        //Copiar Ordenes
        if ((!GrillaVenta.getValueAt(GrillaVenta.getSelectedRow(), 3).toString().trim().isEmpty()) && (!GrillaVenta.getValueAt(GrillaVenta.getSelectedRow(), 4).toString().trim().isEmpty())) {
            StringSelection Voucher = new StringSelection(GrillaVenta.getValueAt(GrillaVenta.getSelectedRow(), 3).toString().trim() + "-" + GrillaVenta.getValueAt(GrillaVenta.getSelectedRow(), 4).toString().trim());
            Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
            cb.setContents(Voucher, null);
        }
    }//GEN-LAST:event_MnuCopia_OCActionPerformed

    private void btCargarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCargarImagenActionPerformed

        String ruta = "";
        String sistema = System.getProperty("os.name").toLowerCase();

        if (sistema.contains("win")) {
            ruta = "c:/fotografias/";
        } else {
            ruta = "/fotografias/";
        }

        lbImagen.setIcon(null);
        JFileChooser j = new JFileChooser(ruta);
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);//solo archivos y no carpetas
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                fis = new FileInputStream(j.getSelectedFile());
                //necesitamos saber la cantidad de bytes
                this.longitudBytes = (int) j.getSelectedFile().length();
                try {
                    Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(lbImagen.getWidth(), lbImagen.getHeight(), Image.SCALE_DEFAULT);
                    lbImagen.setIcon(new ImageIcon(icono));
                    lbImagen.updateUI();

                } catch (IOException ex) {
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btCargarImagenActionPerformed

    private void lsChilecomprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lsChilecomprasMouseClicked
//        ExeSql sql = new ExeSql();
//        ResultSet rs = null;
//        String IDCH = lsChilecompras.getSelectedValue();
//        String codchile;
//        if(IDCH.contains("-")){
//            String[] parts = IDCH.split("-");
//            codchile = parts[0];
//        }
//        else {
//            codchile = IDCH;
//        }
//        String query = "select\n" +
//                        "c.sku, \n" +
//                        "c.notransado, \n" +
//                        "c.publicado,\n" +
//                        "c.desxprecio,\n" +
//                        "c.sinstock,\n" +
//                        "c.discontinuado,\n" +
//                        "c.sin_publicar,\n" +
//                        "c.oferta,\n" +
//                        "c.oferta_inicio,\n" +
//                        "c.oferta_fin\n" +
//                        "from codchile c\n" +
//                        "where c.idch = '"+codchile+"'";
//        try {
//            rs = sql.Select(query);
//            rs.next();
//            chkPublicado.setSelected(rs.getBoolean("publicado"));
//            chkdeshabilitado.setSelected(rs.getBoolean("sin_publicar"));
//            chkDesxPrecio.setSelected(rs.getBoolean("desxprecio"));
//            chkNoTransado.setSelected(rs.getBoolean("notransado"));
//            chkOferta.setSelected(rs.getBoolean("oferta"));
//            chkDiscontinuado.setSelected(rs.getBoolean("discontinuado"));
//            chkStock.setSelected(rs.getBoolean("sinstock"));
//            lsChilecompras.repaint();
//            
//            if (chkOferta.isSelected())
//                {
//                chkOferta.setEnabled(true);
//                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
//                
//                int oferta = Integer.valueOf(rs.getString("oferta_fin").replace("-", ""));
//                int hoy = Integer.valueOf(formato.format(Calendar.getInstance().getTime()).replace("-", ""));
//                       
//                System.out.println(oferta);
//                System.out.println(hoy);
//                                          
//                                   
//               if (oferta<hoy)
//                { 
//                   chkOferta.setSelected(false);
//                }
//               else
//               {
//                   chkOferta.setEnabled(false);
//               }
//
//                dtInicioOfer.setDate(rs.getDate("oferta_inicio"));
//                dtFinOfer.setDate(rs.getDate("oferta_fin"));
//        
//                }
//            else{
//                chkOferta.setEnabled(true);
//            }
//     
//
//        } catch (SQLException ex) {
//            Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        finally {
//            sql.Close();
//        }
//    


    }//GEN-LAST:event_lsChilecomprasMouseClicked


    private void lsChilecomprasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lsChilecomprasMousePressed
//        ExeSql sql = new ExeSql();
//        ResultSet rs = null;
//        String IDCH = lsChilecompras.getSelectedValue();
//        String codchile;
//        if(IDCH.contains("-")){
//            String[] parts = IDCH.split("-");
//            codchile = parts[0];
//        }
//        else {
//            codchile = IDCH;
//        }
//        String query = "select\n" +
//                        "c.sku, \n" +
//                        "c.notransado, \n" +
//                        "c.publicado,\n" +
//                        "c.desxprecio,\n" +
//                        "c.sinstock,\n" +
//                        "c.discontinuado,\n" +
//                        "c.sin_publicar,\n" +
//                        "c.oferta,\n" +
//                        "c.oferta_inicio,\n" +
//                        "c.oferta_fin,\n" +
//                        "c.descripcion,\n" +
//                        "c.url,\n" +
//                        "c.oferta_automatica\n" +
//                        "from codchile c\n" +
//                        "where c.idch = '"+codchile+"'";
//        try {
//            rs = sql.Select(query);
//            rs.next();
//            chkPublicado.setSelected(rs.getBoolean("publicado"));
//            chkdeshabilitado.setSelected(rs.getBoolean("sin_publicar"));
//            chkDesxPrecio.setSelected(rs.getBoolean("desxprecio"));
//            chkNoTransado.setSelected(rs.getBoolean("notransado"));
//            chkOferta.setSelected(rs.getBoolean("oferta"));
//            chkDiscontinuado.setSelected(rs.getBoolean("discontinuado"));
//            chkStock.setSelected(rs.getBoolean("sinstock"));
//            jtDescripcion.setText(rs.getString("descripcion"));
//            jtURL.setText(rs.getString("url"));
//            chbOfertaAutomatica.setSelected(rs.getBoolean("oferta_automatica"));
    ////            lsChilecompras.repaint();
//            
//            if (chkOferta.isSelected())
//                {
//                chkOferta.setEnabled(true);
//                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
//                
//                int oferta = Integer.valueOf(rs.getString("oferta_fin").replace("-", ""));
//                int hoy = Integer.valueOf(formato.format(Calendar.getInstance().getTime()).replace("-", ""));
//                       
//                System.out.println(oferta);
//                System.out.println(hoy);
//                                          
//                                   
//               if (oferta<hoy)
//                { 
//                   chkOferta.setSelected(false);
//                }
//               else
//               {
//                   chkOferta.setEnabled(false);
//               }
//
//                dtInicioOfer.setDate(rs.getDate("oferta_inicio"));
//                dtFinOfer.setDate(rs.getDate("oferta_fin"));
//        
//                }
//            else{
//                chkOferta.setEnabled(true);
//            }
//     
//
//        } catch (SQLException ex) {
//            Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        finally {
//            sql.Close();
//        }
//    
        

    }//GEN-LAST:event_lsChilecomprasMousePressed

    private void lsChilecomprasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lsChilecomprasMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_lsChilecomprasMouseReleased

    private void Codchile() {

        ExeSql sql = new ExeSql();
        ResultSet rs = null;
        String Sku = txSku.getText().toString().trim();

        try {
            String query = "select\n"
                    + "c.sku, \n"
                    + "c.notransado, \n"
                    + "c.publicado,\n"
                    + "c.desxprecio,\n"
                    + "c.sinstock,\n"
                    + "c.discontinuado,\n"
                    + "c.sin_publicar,\n"
                    + "c.oferta,\n"
                    + "c.oferta_inicio,\n"
                    + "c.oferta_fin,\n"
                    + "c.descripcion,\n"
                    + "c.url,\n"
                    + "c.oferta_automatica\n"
                    + "from codchile c\n"
                    + "where c.sku = '" + Sku + "'";

            rs = sql.Select(query);

            if (sql.GetRowCount() > 0) {

                rs.next();
                chkPublicado.setSelected(rs.getBoolean("publicado"));
                chkdeshabilitado.setSelected(rs.getBoolean("sin_publicar"));
                chkDesxPrecio.setSelected(rs.getBoolean("desxprecio"));
                chkNoTransado.setSelected(rs.getBoolean("notransado"));
                chkOferta.setSelected(rs.getBoolean("oferta"));
                chkDiscontinuado.setSelected(rs.getBoolean("discontinuado"));
                chkStock.setSelected(rs.getBoolean("sinstock"));
                jtDescripcion.setText(rs.getString("descripcion"));
                jtURL.setText(rs.getString("url"));
                chbOfertaAutomatica.setSelected(rs.getBoolean("oferta_automatica"));

            }

            System.out.println(fmMain.GetUsuario());

            if (fmMain.GetUsuario().equals("CMORALES") || fmMain.GetUsuario().equals("LRUBILAR")) {

                chkDiscontinuado.setEnabled(true);

            } else {

                chkDiscontinuado.setEnabled(false);

            }

        } catch (SQLException ex) {
            Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.Close();
        }

    }


    private void jtPosicionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtPosicionesActionPerformed

        if (jtPosiciones.isSelected()) {

            boolean res = !lsChilecompras.isSelectionEmpty();

            if (!res) {

                jtPosiciones.setSelected(false);
                fmMain.Mensaje("Debe Seleccionar un ID");
                return;
            }

            ChartPanel chartpanel = Lineas();
            chartpanel.setDomainZoomable(true);
            chartpanel.setMaximumDrawWidth(550);
            chartpanel.setMaximumDrawHeight(260);
            chartpanel.setPreferredSize(new Dimension(550, 260));  //ancho,alto

        } else {

        }
    }//GEN-LAST:event_jtPosicionesActionPerformed

    private void jtEnOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtEnOfertaActionPerformed

        if (jtEnOferta.isSelected()) {

            boolean res = !lsChilecompras.isSelectionEmpty();

            if (!res) {

                jtEnOferta.setSelected(false);
                fmMain.Mensaje("Debe Seleccionar un ID");
                return;
            }

            ChartPanel chartpanel = Barras();
            chartpanel.setDomainZoomable(true);
            chartpanel.setMaximumDrawWidth(550);
            chartpanel.setMaximumDrawHeight(260);
            chartpanel.setPreferredSize(new Dimension(550, 260));  //ancho,alto     

            chartpanel.repaint();

        } else {

        }
    }//GEN-LAST:event_jtEnOfertaActionPerformed

    private void lsChilecomprasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lsChilecomprasValueChanged

        ResultSet Rs;
        ExeSql Sql = new ExeSql();
        try {

//            Rs = Sql.Select("select * from codchile where sku='" + txSku.getText().trim() +"' AND idch = '"+lsChilecompras.getSelectedValue().toString()+"'");
            Rs = Sql.Select("select cd.*, c.id_madre from codchile cd\n"
                    + "left join " + TablaConvenio + " c on cd.sku = c.sku and CAST (cd.idch as INTEGER) = c.id\n"
                    + "where cd.sku='" + txSku.getText().trim() + "' AND cd.idch = '" + lsChilecompras.getSelectedValue().toString() + "'");

            Rs.next();

            txCantUnidad.setText(Rs.getString("cant_unidad"));
            txconvenio.setText(Rs.getString("convenio").trim());
            ucant = txCantUnidad.getText();

            txidchmadre.setText(Rs.getString("id_madre"));

        } catch (Exception e) {

        } finally {
            Sql.Close();
        }

    }//GEN-LAST:event_lsChilecomprasValueChanged

    private void jtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtCantidadActionPerformed

        if (jtCantidad.isSelected()) {

            boolean res = !lsChilecompras.isSelectionEmpty();

            if (!res) {

                fmMain.Mensaje("Debe Seleccionar un ID");
                return;
            }

            txCantUnidad.setEnabled(true);
            txCantUnidad.setEditable(true);
            jtCantidad.setText("Actualizar");

        } else {

            txCantUnidad.setEnabled(false);
            txCantUnidad.setEditable(false);
            jtCantidad.setText("Editar");

            if (txCantUnidad.getText().equals("0") || txCantUnidad.getText().equals("")) {

                txCantUnidad.setText(ucant);

                fmMain.Mensaje("La cantidad mínima debe ser 1");
                return;
            }

            ExeSql Sql = new ExeSql();
            String Query = "";

            try {

                Query = "UPDATE codchile SET \n"
                        + "cant_unidad = " + txCantUnidad.getText().trim() + " \n"
                        + "WHERE sku = '" + txSku.getText() + "' \n"
                        + "AND idch = '" + lsChilecompras.getSelectedValue().toString() + "'";

                Sql.ExeSql(Query);
                Sql.Commit();

                ActualizaCostoConvenio();

            } catch (Exception ex) {
                Sql.Rollback();
                Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);

            } finally {

                Sql.Close();
            }

        }
    }//GEN-LAST:event_jtCantidadActionPerformed

    private void ActualizaCostoConvenio() {

        ExeSql Sql = new ExeSql();
        ResultSet Rs;

        ExeSql Sql2 = new ExeSql();

        String Query = "";

        String Tabla = "";

        double ventaluv = 0;
        double margenluv = 0;

        double ventaprimero = 0;
        double margenprimero = 0;

        double ventasegundo = 0;
        double margensegundo = 0;

        double ventatercero = 0;
        double margentercero = 0;

        double ventacuarto = 0;
        double margencuarto = 0;

        double ventaquinto = 0;
        double margenquinto = 0;

        if (txconvenio.getText().trim().equals("2")) {

            Tabla = "ferreteria";

        } else if (txconvenio.getText().trim().equals("3")) {

            Tabla = "aseo";

        } else if (txconvenio.getText().trim().equals("4")) {

            Tabla = "alimentos";

        } else if (txconvenio.getText().trim().equals("11")) {

            Tabla = "emergencia";

        } else if (txconvenio.getText().trim().equals("7")) {

            Tabla = "escritorio";

        } else if (txconvenio.getText().trim().equals("9")) {

            Tabla = "insumosmed";

        }

        int unidades = Integer.valueOf(txCantUnidad.getText().trim());
        double costo = Integer.valueOf(txPUltCompra.getText().trim().replaceAll("\\,", ""));

        double totalcosto = Math.round(unidades * costo);

        try {

            Rs = Sql.Select("SELECT * FROM " + Tabla + " \n"
                    + "WHERE sku = '" + txSku.getText() + "' \n"
                    + "AND id = '" + lsChilecompras.getSelectedValue().toString() + "' \n"
                    + "AND convenio = " + Integer.valueOf(txconvenio.getText().trim()));

            if (Sql.GetRowCount() > 0) {

                Rs.next();

                ventaluv = Rs.getDouble("precio_venta");
                margenluv = Math.round(((ventaluv - totalcosto) / ventaluv) * 100);

                ventaprimero = Rs.getDouble("primero");
                margenprimero = Math.round(((ventaprimero - totalcosto) / ventaprimero) * 100);

                ventasegundo = Rs.getDouble("segundo");
                margensegundo = Math.round(((ventasegundo - totalcosto) / ventasegundo) * 100);

                ventatercero = Rs.getDouble("tercero");
                margentercero = Math.round(((ventatercero - totalcosto) / ventatercero) * 100);

                ventacuarto = Rs.getDouble("cuarto");
                margencuarto = Math.round(((ventacuarto - totalcosto) / ventacuarto) * 100);

                ventaquinto = Rs.getDouble("quinto");
                margenquinto = Math.round(((ventaquinto - totalcosto) / ventaquinto) * 100);

                Query = "UPDATE " + Tabla + " SET \n"
                        + "precio_compra = " + Math.round(totalcosto) + ", \n"
                        + "margen_luvaly = " + margenluv + ", \n"
                        + "margen_primero = " + margenprimero + ", \n"
                        + "margen_segundo = " + margensegundo + ", \n"
                        + "margen_tercero = " + margentercero + ", \n"
                        + "margen_cuarto = " + margencuarto + ", \n"
                        + "margen_quinto = " + margenquinto + " \n"
                        + "WHERE sku = '" + txSku.getText() + "' \n"
                        + "AND id = '" + lsChilecompras.getSelectedValue().toString() + "' \n"
                        + "AND convenio = " + Integer.valueOf(txconvenio.getText().trim());

                Sql2.ExeSql(Query);
                Sql2.Commit();

            }

        } catch (SQLException ex) {

            Sql2.Rollback();
            Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            Sql2.Close();

        }

    }


    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ExeSql sql = new ExeSql();
        String sku = txSku.getText();
        String valor = valor_vendedor.getText();
        ResultSet rs = null;
        int valor_num = 0;
        try {
            valor_num = Integer.valueOf(valor);
            String Query = "update producto set valor_proveedor = " + valor_num + " where sku = '" + sku + "'";
            try {
                rs = sql.Select("select * from producto where sku = '" + sku + "'");
                rs.next();
                if (rs.getRow() > 0) {
                    int resultado = sql.ExeSqlInt(Query);
                    sql.Commit();
                    if (resultado > 0) {
                        JOptionPane.showMessageDialog(null, "Se le asignó el valor: " + valor_num + " al producto: " + sku);

                    } else {
                        JOptionPane.showMessageDialog(null, "Ocurrió un error");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El producto no existe.");
                }
            } catch (SQLException ex) {
                Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                sql.Close();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El precio no es numérico");
        }


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (!skulabel.getText().equals("")) {
            jdFechaLlegadaProveedor jdc = new jdFechaLlegadaProveedor(null, true);
            jdc.setSku(skulabel.getText());
            jdc.getFechas();
            jdc.setLocationRelativeTo(null);
            jdc.setTitle("Fecha Llegada Proveedor");
            jdc.setVisible(true);//****
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese SKU válido");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void GrillaFacturasCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrillaFacturasCMouseClicked
        // TODO add your handling code here:
        //System.out.println( Grilla_Det.getValueAt(Grilla_Det.getSelectedRow(), 2).toString().trim());

        String Tipodoc = GrillaFacturasC.getValueAt(GrillaFacturasC.getSelectedRow(), 2).toString().trim();
        String nrodoc = GrillaFacturasC.getValueAt(GrillaFacturasC.getSelectedRow(), 1).toString().trim();
        String rut = GrillaFacturasC.getValueAt(GrillaFacturasC.getSelectedRow(), 0).toString().trim();

        if (Tipodoc.equals("FAP")) {
            pfFAProveedor Pro = new pfFAProveedor();
            Pro.setOpaque(false);
            pnPestanas.addTab("Factura Proveedor", Pro);
            PanelTab btc = new PanelTab(pnPestanas, 0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Pro), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
            Pro.CargaFactura(rut, nrodoc);

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

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void GrillaComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrillaComprasMouseClicked

        if (GrillaFacturasC.getSelectedRowCount() >= 0) {

            carga_facturas_orden(GrillaCompras.getValueAt(GrillaCompras.getSelectedRow(), 3).toString().trim());

        }
    }//GEN-LAST:event_GrillaComprasMouseClicked

    private void btEliminaRelacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminaRelacionActionPerformed
        if (fmMain.OkCancel("¿Eliminar Producto?") == JOptionPane.OK_OPTION) {
            DefaultTableModel TableModel = (DefaultTableModel) GrillaRelacion.getModel();
            TableModel.removeRow(GrillaRelacion.getSelectedRow());
        }
    }//GEN-LAST:event_btEliminaRelacionActionPerformed

    private void btAgregaRelacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregaRelacionActionPerformed
        jdBuscarProductosTransforma BP = new jdBuscarProductosTransforma(null, true);
        BP.setLocationRelativeTo(null);
        BP.setTitle("Buscar Producto");
        BP.setVisible(true);

        if (!BP.GetCodigo().isEmpty()) {
            String Cantidad;
            DefaultTableModel TableModel = (DefaultTableModel) GrillaRelacion.getModel();
            Cantidad = JOptionPane.showInputDialog("Cantidad");
            Cantidad = Cantidad.replace(",", ".");

            TableModel.addRow(new Object[]{BP.GetCodigo(), BP.GetNombre(), Cantidad});

        }
    }//GEN-LAST:event_btAgregaRelacionActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jdRelacionarProductos jdc = new jdRelacionarProductos(null, true);
        jdc.setLocationRelativeTo(null);
        jdc.setTitle("Relacionados - Múltiple");
        jdc.setVisible(true);//****
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jdRelacionadosReporte jdc = new jdRelacionadosReporte(null, true);
        jdc.setLocationRelativeTo(null);
        jdc.setTitle("Relacionados");
        jdc.setVisible(true);//****
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btEstablecerRelacionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEstablecerRelacionadoActionPerformed

        if (!txtCrearRelacion.getText().equals("") || !txSku.getText().equals("")) {

            String sku_rel = txtCrearRelacion.getText().trim();
            String sku = txSku.getText();
            String Query = "";
            ExeSql sql = new ExeSql();
            ExeSql sql2 = new ExeSql();
            ExeSql sql3 = new ExeSql();

            ExeSql corroborar = new ExeSql();
            ResultSet corrob = null;
            ResultSet corrob_rel = null;
            String Query_Existe = "select * from producto where sku = '" + sku + "'";
            String Query_Existe_Rel = "select * from producto where sku = '" + sku_rel + "'";
            boolean existe = false;
            boolean existe_rel = false;

            try {
                corrob = corroborar.Select(Query_Existe);
                corrob_rel = corroborar.Select(Query_Existe_Rel);
                if (corrob.next()) {
                    existe = true;
                    System.out.println(corrob.getString("sku"));
                }
                if (corrob_rel.next()) {
                    existe_rel = true;
                    System.out.println(corrob_rel.getString("sku"));
                }
                corrob.close();
                corrob_rel.close();

                if (existe == true && existe_rel == true) {//

                    ResultSet rs = null;
                    Query = "insert into codproducto_rel (sku,sku_rel,fcreacion,usuario) values ('" + sku + "','" + sku_rel + "',now(),'" + fmMain.GetUsuario() + "')";
                    String consulta = "select * from codproducto_rel where sku = '" + sku + "'";

                    try {
                        rs = sql.Select(consulta);
                        rs.last();
                        if (rs.getRow() <= 0) {
                            sql.ExeSql(Query);
                            JOptionPane.showMessageDialog(null, "Se estableció relación con SKU '" + sku_rel + "'");
                        } else {
                            JOptionPane.showMessageDialog(null, "Entrada duplucada para SKU: '" + sku + "'");
                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Error al establecer relación con SKU '" + sku_rel + "'");
                    }
                    txtCrearRelacion.setText("");

                } else if (existe == false) {
                    JOptionPane.showMessageDialog(null, "Error al encontrar producto con sku: '" + sku + "'");
                } else if (existe_rel == false) {
                    JOptionPane.showMessageDialog(null, "Error al encontrar producto con sku: '" + sku_rel + "'");
                }
            } catch (SQLException ex) {
                Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Ambos SKU deben estar escritos para relacionarlos");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btEstablecerRelacionadoActionPerformed

    private void btBuscarRelacionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarRelacionadoActionPerformed
        jdBuscarProductos BP = new jdBuscarProductos(null, true);
        BP.setLocationRelativeTo(null);
        BP.setTitle("Buscar Producto");
        BP.setVisible(true);
        BP.SetCotiza(false);
        if (!"".equals(BP.GetCodigo()))
            txtCrearRelacion.setText(BP.GetCodigo());
    }//GEN-LAST:event_btBuscarRelacionadoActionPerformed

    private void btGuardarOferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarOferActionPerformed

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        System.out.println(sdf.format(date).substring(0, 10));
        System.out.println(getFechaInicio());
        if (!getFechaInicio().substring(0, 10).equals(sdf.format(date).substring(0, 10))) {

            ResultSet Rs;
            String upOfer;
            ExeSql Sql = new ExeSql();
            String IDCH;
            if (!lsChilecompras.getSelectedValue().equals("")) {
                IDCH = lsChilecompras.getSelectedValue();
                String new_IDCH;
                if (IDCH.contains("-")) {
                    String[] parts = IDCH.split("-");
                    new_IDCH = parts[0];
                } else {
                    new_IDCH = IDCH;
                }

                try {
                    upOfer = "UPDATE codchile SET\n"
                            + "  oferta= true"
                            + ", oferta_inicio='" + getFechaInicio() + "'"
                            + ", oferta_fin='" + getFechaFin() + "'"
                            + ", oferta_conta = oferta_conta+1 "
                            + "  WHERE idch = '" + new_IDCH + "'";
                    Sql.ExeSql(upOfer);

                    Sql.Commit();
                    JOptionPane.showMessageDialog(null, "Oferta Guardada");
                    chkOferta.setEnabled(false);
                    btGuardarOfer.setEnabled(false);

                } catch (Exception e) {

                    Sql.Rollback();
                    JOptionPane.showMessageDialog(null, "Error al guardar !!!:\n" + e.getMessage());
                    System.out.println(e);

                } finally {

                    Sql.Close();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se puede ofertar el mismo día");
        }

    }//GEN-LAST:event_btGuardarOferActionPerformed

    private void dtInicioOferKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dtInicioOferKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_dtInicioOferKeyTyped

    private void dtInicioOferKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dtInicioOferKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_dtInicioOferKeyPressed

    private void dtFinOferKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dtFinOferKeyTyped
        char car = evt.getKeyChar();
        if (((car < '0') || (car > '9')) && ((car < '.') || (car > '.'))) {

            evt.consume();
        }
    }//GEN-LAST:event_dtFinOferKeyTyped

    private void dtFinOferKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dtFinOferKeyPressed

    }//GEN-LAST:event_dtFinOferKeyPressed

    private void chkOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkOfertaActionPerformed
        if (chkOferta.isSelected()) {
            dtInicioOfer.setEnabled(true);
            dtInicioOfer.setDate(Calendar.getInstance().getTime());
            dtFinOfer.setEnabled(true);
            dtFinOfer.setDate(Calendar.getInstance().getTime());
            btGuardarOfer.setEnabled(true);
        }
        if (!chkOferta.isSelected()) {
            dtInicioOfer.setEnabled(false);
            dtFinOfer.setEnabled(false);
            btGuardarOfer.setEnabled(false);
        }
    }//GEN-LAST:event_chkOfertaActionPerformed

    private void btUbicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUbicaActionPerformed
        // TODO add your handling code here:
        jd_UbicacionesP Ubicacion = new jd_UbicacionesP(null, true);
        Ubicacion.CargaBultos(txSku.getText().trim(), txNombre.getText().trim());
        Ubicacion.selecciona_reg();

        Ubicacion.setVisible(true);
        //            txtUbicacionOrig.setText(Ubicacion.GetUbicacionCod());
        //            txNombreUbicaOrig.setText(Ubicacion.GetUbicacion());
    }//GEN-LAST:event_btUbicaActionPerformed

    private void btGuardarMinimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarMinimoActionPerformed
        String NuevoMinimo = txNuevoMinimo.getText();
        if (!txNuevoMinimo.getText().equals("")) {
            if (fmMain.OkCancel("El mínimo actual de " + txNombre.getText() + " es " + txMinimo.getText() + ", ¿Quiere que el nuevo mínimo sea " + txNuevoMinimo.getText() + "?") == JOptionPane.OK_OPTION) {
                ActualizarMinimo();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar un valor al campo Nuevo Mínimo");
        }
    }//GEN-LAST:event_btGuardarMinimoActionPerformed

    private void txNuevoMinimoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNuevoMinimoKeyTyped
        char C = evt.getKeyChar();
        if (Character.isLetter(C)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Ingrese solo Números");
            txNuevoMinimo.setCursor(null);
        } else if ((int) evt.getKeyChar() >= 32 && (int) evt.getKeyChar() <= 47 || (int) evt.getKeyChar() >= 58 && (int) evt.getKeyChar() <= 64
                || (int) evt.getKeyChar() >= 91 && (int) evt.getKeyChar() <= 96 || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 255) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Ingrese solo Números");
            txNuevoMinimo.setCursor(null);
        }
    }//GEN-LAST:event_txNuevoMinimoKeyTyped

    private void txNuevoMinimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNuevoMinimoActionPerformed

    }//GEN-LAST:event_txNuevoMinimoActionPerformed

    private void txMinimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txMinimoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txMinimoActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String sku = txSku.getText();
        jdImagenProducto BPC = new jdImagenProducto(null, true);
        BPC.setLocationRelativeTo(null);
        BPC.setTitle("Imagen Producto");
        BPC.setSku(sku);
        BPC.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txPosicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txPosicionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txPosicionActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        if (lsChilecompras.getModel().getSize() == 0) {

            ExeSql sql2 = new ExeSql();

            String query2 = "update producto\n"
                    + "discontinuado = " + chkDiscontinuado.isSelected() + " \n"
                    + "where sku = '" + txSku.getText() + "'";

            try {
                sql2.ExeSql(query2);
                JOptionPane.showMessageDialog(null, "Se modificaron propiedades para Sku" + txSku.getText());
                sql2.Commit();

            } catch (SQLException ex) {
                sql2.Rollback();
                Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);

            }

        } else if (lsChilecompras.getModel().getSize() != 0) {

            try {

                if (!lsChilecompras.getSelectedValue().equals("") || lsChilecompras.getSelectedValuesList().size() != 0) {
                    String IDCH = lsChilecompras.getSelectedValue();
                    String codchile;
                    if (IDCH.contains("-")) {
                        String[] parts = IDCH.split("-");
                        codchile = parts[0];
                    } else {

                        codchile = IDCH;
                    }
                    String query = "update codchile\n"
                            + "set notransado = " + chkNoTransado.isSelected() + ",\n"
                            + "publicado = " + chkPublicado.isSelected() + ",\n"
                            + "desxprecio = " + chkDesxPrecio.isSelected() + ",\n"
                            + "discontinuado = " + chkDiscontinuado.isSelected() + ",\n"
                            + "sin_publicar = " + chkdeshabilitado.isSelected() + ",\n"
                            + "sinstock = " + chkStock.isSelected() + "\n"
                            + "where sku = '" + txSku.getText() + "'and idch = '" + codchile + "'";
                    ExeSql sql = new ExeSql();
                    try {

                        int resultado = sql.ExeSqlInt(query);

                        if (resultado > 0) {

                            JOptionPane.showMessageDialog(null, "Se modificaron propiedades para id: " + codchile + "");
                            sql.Commit();
                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
                        sql.Rollback();
                    } finally {

                        sql.Close();
                    }
                }

            } catch (NullPointerException e) {

                JOptionPane.showMessageDialog(null, "Debe seleccionar ID para poder modificar.");
            }

        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
            ExeSql sql = new ExeSql();
            String IDCH = lsChilecompras.getSelectedValue();
            String sku = txSku.getText();
            String codchile;
            if (!IDCH.equals("") && !sku.equals("")) {
                if (IDCH.contains("-")) {
                    String[] parts = IDCH.split("-");
                    codchile = parts[0];
                } else {
                    codchile = IDCH;
                }
                String query = "update codchile set\n"
                        + "descripcion = '" + jtDescripcion.getText().trim() + "',\n"
                        + "url = '" + jtURL.getText().trim() + "'\n"
                        + "where idch = '" + codchile + "' and sku = '" + sku + "'";
                try {
                    int resultado = sql.ExeSqlInt(query);
                    sql.Commit();
                    if (resultado > 0) {
                        JOptionPane.showMessageDialog(null, "Se guardaron cambios.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo guardar cambios");
                    }
                } catch (SQLException ex) {
                    sql.Rollback();
                    JOptionPane.showMessageDialog(null, "Error");
                    Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    sql.Close();
                }
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Seleccione ID1CH y asegurese que SKU esté presente.");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        StringSelection stringSelection = new StringSelection(jtURL.getText().trim());
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(stringSelection, null);

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try {
            ExeSql sql = new ExeSql();
            String IDCH = lsChilecompras.getSelectedValue();
            String sku = txSku.getText();
            String codchile;
            if (!IDCH.equals("") && !sku.equals("")) {
                if (IDCH.contains("-")) {
                    String[] parts = IDCH.split("-");
                    codchile = parts[0];
                } else {
                    codchile = IDCH;
                }
                String query = "update codchile set\n"
                        + "oferta_automatica = '" + chbOfertaAutomatica.isSelected() + "'\n"
                        + "where idch = '" + codchile + "' and sku = '" + sku + "'";
                try {
                    int resultado = sql.ExeSqlInt(query);
                    sql.Commit();
                    if (resultado > 0) {
                        JOptionPane.showMessageDialog(null, "Se guardaron cambios.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo guardar cambios");
                    }
                } catch (SQLException ex) {
                    sql.Rollback();
                    Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    sql.Close();
                }
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Seleccione IDCH y asegurese que SKU esté presente.");
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        jdCargaValores jdc = new jdCargaValores(null, true);
        jdc.setLocationRelativeTo(null);
        jdc.setTitle("Carga Valores Proveedor");
        jdc.setVisible(true);//****
    }//GEN-LAST:event_jButton10ActionPerformed

    private void chkWebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkWebActionPerformed
        ExeSql exe = new ExeSql();
        String sku = txSku.getText().trim();
        ResultSet rs = null;
        if (sku.equals("")) {
            JOptionPane.showMessageDialog(pnMenu, "Debe ingresar un SKU");
        } else {
            try {
                rs = exe.Select("select * from producto where sku = '" + sku + "'");
                rs.next();
                if (rs.getRow() > 0) {
                    rs = exe.Select("select * from codweb where sku = '" + sku + "'");
                    rs.next();
                    if (rs.getRow() > 0) {
                        int resultado = exe.ExeSqlInt("update codweb set publicado = " + chkWeb.isSelected() + " where sku = '" + sku + "'");
                        exe.Commit();
                        if (resultado > 0) {
                            JOptionPane.showMessageDialog(pnMenu, "Se cambió estado");
                        } else {
                            JOptionPane.showMessageDialog(pnMenu, "No se cambió estado");
                        }
                    } else {
                        if (JOptionPane.showConfirmDialog(pnMenu, "No existe registro en Web, ¿desea crearlo?") == 0) {
                            int resultado = exe.ExeSqlInt("insert into codweb (sku,publicado) values ('" + sku + "',true)");
                            exe.Commit();
                            if (resultado > 0) {
                                JOptionPane.showMessageDialog(pnMenu, "Se creó código web");
                            } else {
                                JOptionPane.showMessageDialog(pnMenu, "No se pudo crear código web");
                            }
                        } else {
                            JOptionPane.showMessageDialog(pnMenu, "Se canceló creación");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(pnMenu, "No existe producto '" + sku + "'");
                }
            } catch (SQLException ex) {
                Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                exe.Close();
            }

        }
    }//GEN-LAST:event_chkWebActionPerformed

    private void PestanasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PestanasMouseClicked


    }//GEN-LAST:event_PestanasMouseClicked

    private void PestanasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_PestanasStateChanged

    }//GEN-LAST:event_PestanasStateChanged

    private void PestanasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PestanasMousePressed

    }//GEN-LAST:event_PestanasMousePressed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        ExeSql sql = new ExeSql();
        String sku = txSku.getText().trim();
        if (!sku.isEmpty()) {
            if (CheckIfExist(sku)) {
                String valor = "0", valor_mercado = "0";
                if (valor_publico.getText().trim().equals("") || valor_publico.getText().trim().equals("0")) {
                    valor = "0";
                } else {
                    valor = valor_publico.getText().trim();
                }
                if (valor_mercadolibre.getText().trim().equals("") || valor_mercadolibre.getText().trim().equals("0")) {
                    valor_mercado = "0";
                } else {
                    valor_mercado = valor_mercadolibre.getText().trim();
                }

                String query = "update producto set pvp_coniva = " + valor + ","
                        + "ml_coniva = " + valor_mercado + " where sku = '" + sku + "'";
                try {
                    int resultado = sql.ExeSqlInt(query);
                    sql.Commit();
                    if (resultado > 0) {
                        JOptionPane.showMessageDialog(null, "Se guardaron los cambios.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo guardar los cambios.");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
                    sql.Rollback();
                } finally {
                    sql.Close();
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encuentra producto.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Código producto no válido.");
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        ExeSql sql = new ExeSql();
        String sku = txSku.getText().trim();
        if (!sku.isEmpty()) {
            if (CheckIfExist(sku)) {
                String url_m = url_mercado.getText().trim();
                String url_l = url_web.getText().trim();
                String url_y = url_yapo.getText().trim();
                String query = "update producto set url_luvaly = '" + url_l + "',"
                        + "url_mercadolibre = '" + url_m + "',"
                        + "url_yapo = '" + url_y + "' where sku = '" + sku + "'";
                try {
                    int resultado = sql.ExeSqlInt(query);
                    sql.Commit();
                    if (resultado > 0) {
                        JOptionPane.showMessageDialog(null, "Se guardaron los cambios.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo guardar los cambios.");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
                    sql.Rollback();
                } finally {
                    sql.Close();
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encuentra producto.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Código producto no válido.");
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void chkWeb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkWeb1ActionPerformed
        ExeSql exe = new ExeSql();
        String sku = txSku.getText().trim();
        ResultSet rs = null;
        if (sku.equals("")) {
            JOptionPane.showMessageDialog(pnMenu, "Debe ingresar un SKU");
        } else {
            try {
                rs = exe.Select("select * from producto where sku = '" + sku + "'");
                rs.next();
                if (rs.getRow() > 0) {
                    rs = exe.Select("select * from codml where sku = '" + sku + "'");
                    rs.next();
                    if (rs.getRow() > 0) {
                        int resultado = exe.ExeSqlInt("update codml set publicado = " + chkWeb.isSelected() + " where sku =  '" + sku + "'");
                        exe.Commit();
                        if (resultado > 0) {
                            JOptionPane.showMessageDialog(pnMenu, "Se cambió estado");
                        } else {
                            JOptionPane.showMessageDialog(pnMenu, "No se cambió estado");
                        }
                    } else {
                        if (JOptionPane.showConfirmDialog(pnMenu, "No existe registro en Mercado Libre, ¿desea crearlo?") == 0) {
                            int resultado = exe.ExeSqlInt("insert into codml (sku,publicado) values ('" + sku + "',true)");
                            exe.Commit();
                            if (resultado > 0) {
                                JOptionPane.showMessageDialog(pnMenu, "Se creó registro Mercado Libre");
                            } else {
                                JOptionPane.showMessageDialog(pnMenu, "No se pudo crear registro mercado libre");
                            }
                        } else {
                            JOptionPane.showMessageDialog(pnMenu, "Se canceló registro");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(pnMenu, "No existe producto '" + sku + "'");
                }
            } catch (SQLException ex) {
                Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                exe.Close();
            }

        }
    }//GEN-LAST:event_chkWeb1ActionPerformed

    private void btActWebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActWebActionPerformed

        if (txWeb.isEnabled()) {

            if (txWeb.getText().isEmpty()) {

                txWeb.setText("0");

            }

            if (Double.parseDouble(txWeb.getText().trim()) == 0) {

                fmMain.Mensaje("El Precio no puede ser 0 o vacío !!!");
                txWeb.setText("" + precioWeb);
                txWeb.requestFocus();
                actualizaWeb = 0;
                txWeb.setBackground(Color.white);

            } else {

                actualizaWeb = 1;
                txWeb.setBackground(Color.yellow);

                ActualizaWeb();

            }

        }


    }//GEN-LAST:event_btActWebActionPerformed

    private void ActualizaWeb() {

        ExeSql luvaly = new ExeSql();

        ResultSet producto_luvaly = null;
        ResultSet producto_web = null;
        ResultSet producto_precio = null;
        ResultSet producto_precio_web = null;
        ResultSet producto_madre = null;
        ResultSet producto_precio_regular = null;

        ResultSet producto_stock = null;

        ExeSql1_Mysql page = new ExeSql1_Mysql();
        ExeSql1_Mysql price = new ExeSql1_Mysql();
        ExeSql1_Mysql price2 = new ExeSql1_Mysql();
        ExeSql1_Mysql price3 = new ExeSql1_Mysql();
        ExeSql1_Mysql regular_price = new ExeSql1_Mysql();

        double precioregular = 0;

        try {

            String Sku = txSku.getText().trim();

            producto_luvaly = luvaly.Select("select c.sku, p.nombre, p.notransado from codweb c \n"
                    + "left join producto p on p.sku = c.sku \n"
                    + "where p.sku = '" + Sku + "'");

            if (luvaly.GetRowCount() > 0) {

                producto_luvaly.next();

                //Stock Luvaly ********************************************************************************
                String query_sku = "select mt.sku, case when sum(mt.cant)<0 then 0 else sum(mt.cant) end as stock\n"
                        + "from mt_productos mt left join inventario i on mt.sku=i.sku\n"
                        + "where mt.ubicacion not in ('TRAN.1009.1','TRAN.1009.2','TRAN.1002.1','TRAN.1004.1','TRAN.1005.1','TRAN.1003.1', \n"
                        + "'TRAN.1006.1','TRAN.1007.1','TRAN.1008.1','TRAN.1010.1','TRAN.1012.1')\n"
                        + "and mt.sku = '" + producto_luvaly.getString("sku") + "'\n"
                        + "group by mt.sku, i.occ";

                String stock = "";

                producto_stock = luvaly.Select(query_sku);

                if (!producto_stock.next()) {

                    stock = "0";

                } else {

                    stock = producto_stock.getString("stock").trim();
                }

                //Precio Luvaly *****************************************************************************************
                String query_sku2 = "select sku, pventa_web2\n"
                        + "from producto \n"
                        + "where sku = '" + producto_luvaly.getString("sku") + "'"; //011223005

                String precio = "0";
                String precio_actual = "";

                producto_precio = luvaly.Select(query_sku2);

                if (producto_precio.next()) {

                    //precio= producto_precio.getString("pventa_web2").trim();
                    precio = txWeb.getText().trim();

                }

                //Meta Página    
                producto_web = page.Select("select post_id,meta_value from wpkj_postmeta \n"
                        + //Se selecciona el prodcuto por su sku
                        "where meta_key='_sku' "
                        + "and meta_value='" + producto_luvaly.getString("sku") + "'");

                if (producto_web.next()) {

                    producto_precio_web = price.Select("select meta_value from wpkj_postmeta \n"
                            + //Se selecciona el precio por su ID
                            "where post_id=" + producto_web.getString("post_id") + " \n"
                            + "and meta_key='_price'");

                    if (producto_precio_web.next()) {

                        precio_actual = producto_precio_web.getString("meta_value").trim();    //Se toma el precio publicado (actual)

                        producto_precio_regular = regular_price.Select("select meta_value from wpkj_postmeta \n"
                                + //Se selecciona el precio regular por su ID
                                "where post_id=" + producto_web.getString("post_id") + " \n"
                                + "and meta_key='_regular_price'");

                        producto_precio_regular.next();

                        if (producto_precio_regular.getDouble("meta_value") <= Double.parseDouble(precio)) {

                            precioregular = 0;

                        } else {

                            precioregular = producto_precio_regular.getDouble("meta_value");

                        }

                        System.out.println("" + producto_luvaly.getString("sku") + " - " + producto_luvaly.getString("nombre") + "\n");
                        System.out.println("Precio página: " + producto_precio_web.getString("meta_value") + "\n");
                        System.out.println("Precio luvaly: " + precio + "\n");
                        System.out.println("Precio Regular página: " + producto_precio_regular.getString("meta_value") + "\n");

                        producto_madre = price.Select("select post_type from wpkj_posts \n"
                                + //Se busca el ID del SKU madre
                                "where ID=" + producto_web.getString("post_id"));

                        if (producto_madre.next()) {

                            if (producto_madre.getString("post_type").equals("product")) {

                                if (precioregular == 0) {

                                    price2.ExeSql("update wpkj_postmeta set meta_value = 0 "
                                            + " where post_id=" + producto_web.getString("post_id")
                                            + " and meta_key IN ('_regular_price') ");
                                    price2.Commit();

                                }

                                // if (Double.parseDouble(precio) < Double.parseDouble(precio_actual)){
                                precio = precio.replaceAll("\\.0", "");

                                price3.ExeSql("update wpkj_postmeta set meta_value = " + Integer.parseInt(precio)
                                        + " where post_id=" + producto_web.getString("post_id")
                                        + " and meta_key IN ('_regular_price') ");
                                price3.Commit();

                                // }
                                //precio = precio.replaceAll("\\.0", "");
                                price.ExeSql("update wpkj_postmeta set meta_value = " + Integer.parseInt(precio)
                                        + " where post_id=" + producto_web.getString("post_id")
                                        + " and meta_key IN ('_price') ");

                                price.Commit();

                            }

                        }

                    }

                    //**************************************************************************************************************************************************//  
                    int resultado2 = 0;
                    int resultado = page.ExeSqlInt("update wpkj_postmeta set meta_value = " + stock
                            + " where post_id=" + producto_web.getString("post_id")
                            + " and meta_key='_stock' ");
                    page.Commit();

                    if (resultado > 0) {

                        System.out.println("El stock ES : " + Double.valueOf(stock));

                        if (Double.valueOf(stock) > 0.0) {

                            System.out.println("Entró con Stock : " + Double.valueOf(stock));

                            resultado2 = page.ExeSqlInt("update wpkj_postmeta set meta_value = 'instock' \n"
                                    + "where post_id=" + producto_web.getString("post_id")
                                    + " and meta_key='_stock_status' ");
                            page.Commit();

                        } else if (Double.valueOf(stock) == 0.0) {

                            System.out.println("Entró con Stock con cero: " + Double.valueOf(stock));

                            resultado2 = page.ExeSqlInt("update wpkj_postmeta set meta_value = 'outofstock' "
                                    + "where post_id=" + producto_web.getString("post_id")
                                    + " and meta_key='_stock_status' ");
                            page.Commit();

                        }

                    }

                    //************************************************************************************************************************************************// 
                }  // If de precio.web

                fmMain.Mensaje("Producto Actualizado...!");
            }

        } catch (SQLException ex) {

            luvaly.Rollback();
            page.Rollback();
            price.Rollback();
            Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
            fmMain.Mensaje("Error en Conexión...!");

        } finally {
            luvaly.Close();
            page.Close();
            price.Close();

        }
    }


    private void txWebFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txWebFocusGained

        if (txWeb.isEnabled()) {

            precioWeb = Double.parseDouble(txWeb.getText().trim());
            btActWeb.setEnabled(true);

        }
    }//GEN-LAST:event_txWebFocusGained

    private void txWebKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txWebKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            btActWeb.doClick();

        }

    }//GEN-LAST:event_txWebKeyPressed

    private void chkDesxPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDesxPrecioActionPerformed

        ExeSql exe = new ExeSql();
        String sku = txSku.getText().trim();
        ResultSet rs = null;
        if (sku.equals("")) {
            JOptionPane.showMessageDialog(pnMenu, "Debe ingresar un SKU");
        } else {
            try {
                rs = exe.Select("select * from producto where sku = '" + sku + "'");
                rs.next();

                if (rs.getRow() > 0) {

                    rs = exe.Select("select * from codchile where sku = '" + sku + "'");
                    rs.next();

                    if (rs.getRow() > 0) {

                        int resultado = exe.ExeSqlInt("update codchile set desxprecio = " + chkDesxPrecio.isSelected() + " where sku =  '" + sku + "'");
                        exe.Commit();

                        if (resultado > 0) {

                            JOptionPane.showMessageDialog(pnMenu, "Se cambió estado");

                        } else {

                            JOptionPane.showMessageDialog(pnMenu, "No se cambió estado");
                        }

                    } else {

                        if (JOptionPane.showConfirmDialog(pnMenu, "No existe registro en Web, ¿desea crearlo?") == 0) {

                            int resultado = exe.ExeSqlInt("insert into codchile (sku,desxprecio) values ('" + sku + "',true)");
                            exe.Commit();

                            if (resultado > 0) {
                                JOptionPane.showMessageDialog(pnMenu, "Se creó código");

                            } else {
                                JOptionPane.showMessageDialog(pnMenu, "No se pudo crear código");
                            }

                        } else {
                            JOptionPane.showMessageDialog(pnMenu, "Se canceló creación");
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(pnMenu, "No existe producto '" + sku + "'");
                }
            } catch (SQLException ex) {
                Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                exe.Close();
            }

        }


    }//GEN-LAST:event_chkDesxPrecioActionPerformed

    private void txPublicacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txPublicacionKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            carga_publica_ventas();

            txComision.requestFocus();

        }


    }//GEN-LAST:event_txPublicacionKeyPressed

    private void txComisionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txComisionKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            carga_publica_ventas();
            txEnvio.requestFocus();

        }

    }//GEN-LAST:event_txComisionKeyPressed

    private void txEnvioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txEnvioKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            carga_publica_ventas();

        }


    }//GEN-LAST:event_txEnvioKeyPressed

    private void chkPublicadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkPublicadoActionPerformed

        ExeSql exe = new ExeSql();
        String sku = txSku.getText().trim();
        ResultSet rs = null;

        if (sku.equals("")) {
            JOptionPane.showMessageDialog(pnMenu, "Debe ingresar un SKU");
            return;
        }

        try {

            if (!lsChilecompras.getSelectedValue().equals("") || lsChilecompras.getSelectedValuesList().size() != 0) {

                String IDCH = lsChilecompras.getSelectedValue();
                String codchile;

                if (IDCH.contains("-")) {

                    String[] parts = IDCH.split("-");
                    codchile = parts[0];

                } else {

                    codchile = IDCH;
                }

                rs = exe.Select("select * from producto where sku = '" + sku + "'");
                rs.next();

                if (rs.getRow() > 0) {

                    rs = exe.Select("select * from codchile where sku = '" + sku + "'");
                    rs.next();

                    if (rs.getRow() > 0) {

                        int resultado = exe.ExeSqlInt("update codchile set publicado = " + chkPublicado.isSelected() + " where sku =  '" + sku + "' and idch = '" + codchile + "'");
                        exe.Commit();

                        if (resultado > 0) {

                            JOptionPane.showMessageDialog(pnMenu, "Se cambió estado");

                        } else {

                            JOptionPane.showMessageDialog(pnMenu, "No se cambió estado");
                        }

                    } else {

                        if (JOptionPane.showConfirmDialog(pnMenu, "No existe registro en Web, ¿desea crearlo?") == 0) {

                            int resultado = exe.ExeSqlInt("insert into codchile (sku,publicado) values ('" + sku + "',true)");
                            exe.Commit();

                            if (resultado > 0) {
                                JOptionPane.showMessageDialog(pnMenu, "Se creó código");

                            } else {
                                JOptionPane.showMessageDialog(pnMenu, "No se pudo crear código");
                            }

                        } else {
                            JOptionPane.showMessageDialog(pnMenu, "Se canceló creación");
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(pnMenu, "No existe producto '" + sku + "'");
                }

            }

        } catch (SQLException ex) {

            Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            exe.Close();
        }


    }//GEN-LAST:event_chkPublicadoActionPerformed

    private void chkDiscontinuadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDiscontinuadoActionPerformed

        ExeSql exe = new ExeSql();
        String sku = txSku.getText().trim();
        ResultSet rs = null;
        if (sku.equals("")) {
            JOptionPane.showMessageDialog(pnMenu, "Debe ingresar un SKU");
        } else {
            try {
                rs = exe.Select("select * from producto where sku = '" + sku + "'");
                rs.next();

                if (rs.getRow() > 0) {

                    rs = exe.Select("select * from codchile where sku = '" + sku + "'");
                    rs.next();

                    if (rs.getRow() > 0) {

                        int resultado = exe.ExeSqlInt("update codchile set discontinuado = " + chkDiscontinuado.isSelected() + " where sku =  '" + sku + "'");
                        exe.Commit();

                        if (resultado > 0) {

                            JOptionPane.showMessageDialog(pnMenu, "Se cambió estado");

                        } else {

                            JOptionPane.showMessageDialog(pnMenu, "No se cambió estado");
                        }

                    } else {

                        if (JOptionPane.showConfirmDialog(pnMenu, "No existe registro en Web, ¿desea crearlo?") == 0) {

                            int resultado = exe.ExeSqlInt("insert into codchile (sku,discontinuado) values ('" + sku + "',true)");
                            exe.Commit();

                            if (resultado > 0) {
                                JOptionPane.showMessageDialog(pnMenu, "Se creó código");

                            } else {
                                JOptionPane.showMessageDialog(pnMenu, "No se pudo crear código");
                            }

                        } else {
                            JOptionPane.showMessageDialog(pnMenu, "Se canceló creación");
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(pnMenu, "No existe producto '" + sku + "'");
                }
            } catch (SQLException ex) {
                Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                exe.Close();
            }

        }


    }//GEN-LAST:event_chkDiscontinuadoActionPerformed

    private void txLargoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txLargoKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            if (txLargo.getText().trim().isEmpty()) {

                txLargo.setText("0");

            }

            CalculaM3();
            txAncho.requestFocus();

        }


    }//GEN-LAST:event_txLargoKeyPressed

    private void txAnchoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txAnchoKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            if (txAncho.getText().trim().isEmpty()) {

                txAncho.setText("0");

            }

            CalculaM3();
            txAlto.requestFocus();

        }


    }//GEN-LAST:event_txAnchoKeyPressed

    private void txAltoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txAltoKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            if (txAlto.getText().trim().isEmpty()) {

                txAlto.setText("0");

            }

            CalculaM3();

        }

    }//GEN-LAST:event_txAltoKeyPressed

    private void txLargoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txLargoFocusGained

        if (txLargo.getText().trim().equals("0")) {

            txLargo.setText("");

        }

    }//GEN-LAST:event_txLargoFocusGained

    private void txLargoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txLargoFocusLost

        if (txLargo.getText().trim().isEmpty()) {

            txLargo.setText("0");

        }

    }//GEN-LAST:event_txLargoFocusLost

    private void txAnchoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txAnchoFocusGained

        if (txAncho.getText().trim().equals("0")) {

            txAncho.setText("");

        }

    }//GEN-LAST:event_txAnchoFocusGained

    private void txAltoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txAltoFocusGained

        if (txAlto.getText().trim().equals("0")) {

            txAlto.setText("");

        }


    }//GEN-LAST:event_txAltoFocusGained

    private void txAltoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txAltoFocusLost

        if (txAlto.getText().trim().isEmpty()) {

            txAlto.setText("0");

        }


    }//GEN-LAST:event_txAltoFocusLost

    private void txAnchoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txAnchoFocusLost

        if (txAncho.getText().trim().isEmpty()) {

            txAncho.setText("0");

        }


    }//GEN-LAST:event_txAnchoFocusLost

    private void btVerAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVerAuditoriaActionPerformed

        int cant = Integer.parseInt(txAuditoria.getText().trim());

        if (cant > 0) {

            jdBuscaFolioAud Fol = new jdBuscaFolioAud(null, true);
            Fol.ShowModal(txSku.getText().trim());

            if (Fol.GetEstado()) {

                AuditoriaMetro AsMetro = new AuditoriaMetro();
                pnPestanas.addTab("Ingreso Auditoria", AsMetro);
                PanelTab btc = new PanelTab(pnPestanas, 0);
                pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(AsMetro), btc);
                pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
                AsMetro.Abrir_Folio_Ext(Fol.GetNumero(), Fol.GetTipo());

            }

        }
    }//GEN-LAST:event_btVerAuditoriaActionPerformed

    private void btAjustesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAjustesActionPerformed

        jdBuscaAsjustesPend Ajs = new jdBuscaAsjustesPend(null, true);
        Ajs.ShowModal(txSku.getText().trim());

        if (Ajs.GetEstado()) {

            pfAjusteStock_Autoriza AJU = new pfAjusteStock_Autoriza();

            pnPestanas.addTab("AJUSTE CON AUTORIZACION", AJU);
            PanelTab btc = new PanelTab(pnPestanas, 0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(AJU), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
            AJU.AbrirFolio_Ext(Ajs.GetNumero());

        }


    }//GEN-LAST:event_btAjustesActionPerformed

    private void txidchmadreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txidchmadreKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txidchmadreKeyTyped

    private void btAgregaIDMadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregaIDMadreActionPerformed

        if (!txSku.getText().toString().trim().equals("") || !txNombre.getText().toString().trim().equals("")) {

            jdAgregaIDCHMADRE agregarCH = new jdAgregaIDCHMADRE(null, true);
            agregarCH.setLocationRelativeTo(null);
            agregarCH.Datos(txSku.getText().toString().trim(), txNombre.getText().toString().trim(), cbConvenioCod.getSelectedItem().toString().trim());
            agregarCH.setTitle("Agregar ID MADRE");
            agregarCH.setVisible(true);

            txidchmadre.setText(agregarCH.GetID());

        }


    }//GEN-LAST:event_btAgregaIDMadreActionPerformed

    private void btEliminaIDMadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminaIDMadreActionPerformed

        if (JOptionPane.showConfirmDialog(null, "¿Desea Eliminar el ID MADRE?") == JOptionPane.YES_OPTION) {

            if (txSku.getText().toString().trim().isEmpty()) {

                fmMain.Mensaje("Ingrese un Sku valido !!");
                return;
            }

            int conv = Integer.parseInt(cbConvenioCod.getSelectedItem().toString().trim());
            Verifica_SKU(conv, txSku.getText().toString().trim());

            if (!existe) {

                fmMain.Mensaje("Codigo No Existe en el Reporte!");
                return;

            }

            ResultSet Rs;
            ExeSql Sql = new ExeSql();
            ExeSql Sql2 = new ExeSql();

            try {

                Rs = Sql.Select("select * from codchile where sku IN ('" + txSku.getText().trim() + "')");

                if (Sql.GetRowCount() > 0) {

                    while (Rs.next()) {

                        Sql2.ExeSql("UPDATE codchile SET \n"
                                + "idch_madre = '0' \n"
                                + "WHERE sku IN ('" + txSku.getText().trim() + "')");

                    }

                    Sql2.Commit();
                    fmMain.Mensaje("ID MADRE ELIMINADA");
                    txidchmadre.setText("0");

                }

                Asociar_Al_Reporte(conv, txSku.getText().trim(), "0");

            } catch (Exception e) {

                Sql2.Rollback();
                fmMain.Mensaje("Error al eliminar: " + e);

            } finally {

                Sql.Close();
                Sql2.Close();

            }

        }


    }//GEN-LAST:event_btEliminaIDMadreActionPerformed

    private void chkdeshabilitadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkdeshabilitadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkdeshabilitadoActionPerformed

    private void Grilla_InvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Grilla_InvMouseClicked

        if (evt.getClickCount() == 2) {

            ExeSql Sql = new ExeSql();
            ResultSet Rs;

            String ubc = Grilla_Inv.getValueAt(Grilla_Inv.getSelectedRow(), 1).toString().trim();
            String sku = Grilla_Inv.getValueAt(Grilla_Inv.getSelectedRow(), 2).toString().trim();

            if (ubc.trim().equals("TRANSITO-V_ANTICIPADA-METRO 1") || ubc.trim().equals("TRANSITO-V_ANTICIPADA-SALATP") || ubc.trim().equals("TRANSITO-V_ANTICIPADA-SALATH")
                    || ubc.trim().equals("TRANSITO-VDIRECTA-METRO 1") || ubc.trim().equals("TRANSITO-V_ANTICIPADA-SALA")) {

//            if (ubc.trim().equals("TRANSITO-V_ANTICIPADA-METRO 1") || ubc.trim().equals("TRANSITO-V_ANTICIPADA-SALA") || ubc.trim().equals("TRANSITO-VDIRECTA-METRO 1") ){    
                try {

                    Rs = Sql.Select("select va.tipdocto, va.nrodocto, va.cant from venta_anticipada va\n"
                            + "where va.sku IN ('" + sku.trim() + "') and va.ubicacion IN ('" + ubc.trim() + "') and  va.estado =0 ");

                    if (Sql.GetRowCount() > 0) {

                        jdBuscaVentasAntPend BVA = new jdBuscaVentasAntPend(null, true);
                        BVA.setLocationRelativeTo(null);
                        BVA.setTitle("Buscar Ventas Anticipadas Pendientes");

                        BVA.CargaPendientes(sku.trim());
                        BVA.setVisible(true);

                    }

                } catch (SQLException ex) {
                    Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
    }//GEN-LAST:event_Grilla_InvMouseClicked

    private void txNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txNombreMouseClicked


    }//GEN-LAST:event_txNombreMouseClicked

    private void Verifica_SKU(int convenio, String sku) {

        ExeSql Sql = new ExeSql();

        ResultSet Rs;

        try {

            String tabla = "";

            if (convenio == 2) {

                tabla = "ferreteria";

            } else if (convenio == 3) {

                tabla = "aseo";

            } else if (convenio == 4) {

                tabla = "alimentos";

            } else if (convenio == 11) {

                tabla = "emergencia";

            } else if (convenio == 7) {

                tabla = "escritorio";

            }

            Rs = Sql.Select("SELECT * FROM " + tabla + " WHERE sku IN('" + sku.trim() + "')");

            if (Sql.GetRowCount() > 0) {

                existe = true;

            } else {

                existe = false;

            }

        } catch (SQLException ex) {

            Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void Asociar_Al_Reporte(int convenio, String sku, String idch) {

        ExeSql Sql = new ExeSql();
        ExeSql Sql2 = new ExeSql();
        ResultSet Rs;

        int idmadre = Integer.parseInt(idch.trim());

        try {

            String tabla = "";

            if (convenio == 2) {

                tabla = "ferreteria";

            } else if (convenio == 3) {

                tabla = "aseo";

            } else if (convenio == 4) {

                tabla = "alimentos";

            } else if (convenio == 11) {

                tabla = "emergencia";

            } else if (convenio == 7) {

                tabla = "escritorio";

            }

            Rs = Sql.Select("SELECT * FROM " + tabla + " WHERE sku IN ('" + sku.trim() + "')");

            if (Sql.GetRowCount() > 0) {

                while (Rs.next()) {

                    Sql2.ExeSql("UPDATE " + tabla + " SET \n"
                            + "id_madre = " + idmadre + " \n"
                            + "WHERE sku IN('" + sku.trim() + "')");

                }

                Sql2.Commit();

            }

        } catch (SQLException ex) {
            Sql2.Rollback();
            Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void CalculaM3() {

        largo = Double.parseDouble(txLargo.getText().trim());
        ancho = Double.parseDouble(txAncho.getText().trim());
        alto = Double.parseDouble(txAlto.getText().trim());

        largo = (largo / 100);
        ancho = (ancho / 100);
        alto = (alto / 100);

        System.out.println("largo: " + largo + "\n");
        System.out.println("ancho: " + ancho + "\n");
        System.out.println("alto: " + alto + "\n");
        TotalM3 = (largo * ancho * alto);

        decimalformat = new DecimalFormat("#.#"); //pare que muestre el entero y los decimales

        //num 1,  num 2   
        int compare = Double.compare(TotalM3, 0.000005);  //si num 1 > num 2, entonces compare = 1 ||| si num 1 == num 2, entonces compare = 0 ||| si num 1 < num 2, entonces compare = -1
        int compare2 = Double.compare(TotalM3, 0.00005);
        int compare3 = Double.compare(TotalM3, 0.0005);
        int compare4 = Double.compare(TotalM3, 0.005);

        if (compare == 0 || compare > 0) {

            if (compare2 == 0 || compare2 > 0) {

                if (compare3 == 0 || compare3 > 0) {

                    if (compare4 == 0 || compare4 > 0) {

                        decimalformat.setMaximumFractionDigits(2);

                    } else {

                        decimalformat.setMaximumFractionDigits(3);

                    }

                } else {

                    decimalformat.setMaximumFractionDigits(4);

                }

            } else {

                decimalformat.setMaximumFractionDigits(5);
            }

        } else {

            decimalformat.setMaximumFractionDigits(7);

        }

        lbM3.setText("" + decimalformat.format(TotalM3));
    }

    public static double fijarNumero(double numero, int digitos) {
        double resultado;
        resultado = numero * Math.pow(10, digitos);
        resultado = Math.round(resultado);
        resultado = resultado / Math.pow(10, digitos);
        return resultado;
    }

    public static double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado = (resultado - parteEntera) * Math.pow(10, numeroDecimales);
        resultado = Math.round(resultado);
        resultado = (resultado / Math.pow(10, numeroDecimales)) + parteEntera;
        return resultado;

    }

    public String getFechaInicio() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return (sdf.format((dtInicioOfer.getDate()).getTime()));
    }

    public String getFechaFin() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return (sdf.format((dtFinOfer.getDate()).getTime()));
    }

    public ChartPanel Lineas() {

        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        String Query = "";

        //********************************************* TABLA PARA GRAFICO ****************************************************   
        Date fech = new Date();
        String hoy = dateFormat.format(fech);
//        String fech = "27-09-2019";
        Date fech2;

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try {

            fech2 = dateFormat.parse(hoy);

            String fechahoy = dateFormat.format(fech2);
            Date fechoy = dateFormat.parse(fechahoy);

            calendario.setTime(fechoy);
            calendario2.setTime(fechoy);

            calendario.add(Calendar.DAY_OF_YEAR, 0);
            calendario2.add(Calendar.DAY_OF_YEAR, -10);

            Date nuevafecha = calendario.getTime();
            Date nuevafecha2 = calendario2.getTime();

            fechaFin = dateFormat.format(nuevafecha);
            fechaIni = dateFormat.format(nuevafecha2);

            Query = Query = "SELECT sku,posicion,fecha FROM producto_posicion_historico WHERE sku = '" + txSku.getText() + "' \n"
                    + "AND id = '" + lsChilecompras.getSelectedValue().toString() + "' \n"
                    + "AND fecha BETWEEN '" + fechaIni + "' AND '" + fechaFin + "' ORDER BY fecha ASC";

            Rs = Sql.Select(Query);
            dataset.clear();

            while (Rs.next()) {

                String fecha = dateFormat.format(Rs.getDate("fecha"));
                System.out.println(fecha);
                System.out.println(Rs.getInt("posicion"));
                dataset.addValue(Rs.getInt("posicion"), "", fecha);

            }

        } catch (Exception e) {

        } finally {

            Sql.Close();
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "",
                "", //Etiquqeta eje horizontal
                "Posiciones", //Etiqueta eje vertical
                dataset,
                PlotOrientation.VERTICAL,
                false,
                true,
                false);

        CategoryPlot plot = (CategoryPlot) barChart.getPlot();
        plot.setRangeGridlinesVisible(true);

        CategoryPlot plot2 = barChart.getCategoryPlot();
        BarRenderer bar = (BarRenderer) plot2.getRenderer();
        bar.setMaximumBarWidth(0.2);

        org.jfree.chart.axis.ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setRange(0, 11);
//        rangeAxis.setAutoRange(true);
        ChartPanel panel = new ChartPanel(barChart);

        return panel;
    }

    public ChartPanel Barras() {

        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        String Query = "";
        int oferta = 0;

        Date fech = new Date();
        String hoy = dateFormat.format(fech);
//        String fech = "27-09-2019";
        Date fech2;

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try {

            fech2 = dateFormat.parse(hoy);

            String fechahoy = dateFormat.format(fech2);
            Date fechoy = dateFormat.parse(fechahoy);

            calendario.setTime(fechoy);
            calendario1.setTime(fechoy);
            calendario2.setTime(fechoy);
            calendario3.setTime(fechoy);
            calendario4.setTime(fechoy);
            calendario5.setTime(fechoy);
            calendario6.setTime(fechoy);

            calendario.add(Calendar.DAY_OF_YEAR, 0);
            calendario1.add(Calendar.DAY_OF_YEAR, -1);
            calendario2.add(Calendar.DAY_OF_YEAR, -2);
            calendario3.add(Calendar.DAY_OF_YEAR, -3);
            calendario4.add(Calendar.DAY_OF_YEAR, -4);
            calendario5.add(Calendar.DAY_OF_YEAR, -5);
            calendario6.add(Calendar.DAY_OF_YEAR, -6);

            Date nuevafecha = calendario.getTime();
            Date nuevafecha1 = calendario1.getTime();
            Date nuevafecha2 = calendario2.getTime();
            Date nuevafecha3 = calendario3.getTime();
            Date nuevafecha4 = calendario4.getTime();
            Date nuevafecha5 = calendario5.getTime();
            Date nuevafecha6 = calendario6.getTime();

            //********************************************* TABLA PARA GRAFICO ****************************************************            
            //  tModel = (DefaultTableModel) Grilla.getModel();
            tModel.addRow(new Object[]{nuevafecha6.getTime()});
            tModel.addRow(new Object[]{nuevafecha5.getTime()});
            tModel.addRow(new Object[]{nuevafecha4.getTime()});
            tModel.addRow(new Object[]{nuevafecha3.getTime()});
            tModel.addRow(new Object[]{nuevafecha2.getTime()});
            tModel.addRow(new Object[]{nuevafecha1.getTime()});
            tModel.addRow(new Object[]{nuevafecha.getTime()});

            //**********************************************************************************************************************   
            String esoferta = "NO";
            String fecha = "";

            fechaFin = dateFormat.format(nuevafecha);

            Query = Query = "SELECT ab.tabla, ab.campo3, ab.oferta_inicio, ab.oferta_fin, cd.idch,cd.oferta \n"
                    + "FROM auditoria_bd  ab \n "
                    + "LEFT JOIN codchile cd ON ab.campo3 = cd.sku \n"
                    + "WHERE ab.campo3 = '" + txSku.getText() + "' \n"
                    + "AND cd.idch = '" + lsChilecompras.getSelectedValue().toString() + "' \n"
                    + "AND(ab.oferta_fin <= '" + fechaFin + "' OR ab.oferta_fin >= '" + fechaFin + "') ORDER BY ab.oferta_fin ASC";

            Rs = Sql.Select(Query);
            dataset.clear();

            for (int i = 0; i < Grilla.getRowCount(); i++) { //011208001

                boolean estado = false;

                long f = Long.parseLong(Grilla.getValueAt(i, 0).toString());

                Rs = Sql.Select(Query);

//                 if(Sql.GetRowCount()==0){
//                     
//                       System.out.println("NO HAY REGISTROS");
//                       
//                 }else if(Sql.GetRowCount()>0){
//                 
//                        System.out.println("HAY REGISTROS!!");
//                 
//                 }
                if (Sql.GetRowCount() > 0) {

//                    while(Rs.next()){
                    Rs.next();

                    boolean enoferta = Rs.getBoolean("oferta");
                    long fechaIni = Rs.getDate("oferta_inicio").getTime();
                    long fechaFin = Rs.getDate("oferta_fin").getTime();

                    if (enoferta) {

                        if (!estado) {

                            if (f >= fechaIni && f <= fechaFin) {

                                estado = true;
                                oferta = 5;
                                fecha = dateFormat.format(f);
                                esoferta = "SI";

                            } else {

                                estado = false;
                                oferta = 2;
                                fecha = dateFormat.format(f);
                                esoferta = "NO";

                            }

                        }

                    } else if (!enoferta) {

                        estado = false;
                        oferta = 2;
                        fecha = dateFormat.format(f);
                        esoferta = "NO";

                    }

//                    }
                    dataset.addValue(oferta, esoferta, fecha);

                } else if (Sql.GetRowCount() == 0) {

                    fecha = dateFormat.format(f);
                    dataset.addValue(2, "NO", fecha);

                }
            }

        } catch (ParseException | SQLException | NumberFormatException e) {

        } finally {

            Sql.Close();
        }

        JFreeChart barChart = ChartFactory.createBarChart("", //Titulo del gráfico
                "En Oferta", //Etiquqeta eje horizontal
                "", //Etiqueta eje vertical
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);

        CategoryPlot plot = (CategoryPlot) barChart.getPlot();
        plot.setRangeGridlinesVisible(true);

        CategoryPlot plot2 = barChart.getCategoryPlot();                            //Se configuran las barras
        BarRenderer bar = (BarRenderer) plot2.getRenderer();                        // de cada serie

        if (oferta == 2) {

            bar.setSeriesPaint(0, new Color(255, 0, 0)); // rojo                       

        } else if (oferta == 5) {

            bar.setSeriesPaint(0, new Color(255, 0, 0)); // rojo
            bar.setSeriesPaint(1, new Color(0, 255, 0)); // verde

        }

        bar.setItemMargin(-.8);                                                 //Se asigna el margen que determina el ancho de las barras

        plot2.setRenderer(bar);

        org.jfree.chart.axis.ValueAxis rangeAxis = plot.getRangeAxis();          //Se configra rango del eje Y (vertical)   
        rangeAxis.setRange(1, 5);
//        rangeAxis.setAutoRange(true);
        rangeAxis.setVisible(false);
        ChartPanel panel = new ChartPanel(barChart);

        return panel;

    }

    class Elrender extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable tabla, Object valor, boolean isSelected, boolean hasFocus, int fila, int columna) {
            super.getTableCellRendererComponent(tabla, valor, isSelected, hasFocus, fila, columna);

            if (tabla.getValueAt(fila, 0).equals(fmMain.BodegaNCP()) || tabla.getValueAt(fila, 0).equals(fmMain.BodegaNCC())) {
                if (isSelected == true) {
                    this.setBackground(Color.RED);
                    this.setForeground(Color.white);
                } else {

                    this.setForeground(Color.RED);
                    this.setBackground(Color.white);

                }
            } else {
                if (isSelected == true) {

                    this.setForeground(Color.white);
                    this.setBackground(Color.BLUE);

                } else {

                    this.setForeground(Color.black);
                    this.setBackground(Color.white);
                }
            }
            return this;
        }
    }

    private void iniciarPestanaLotes() {
        // 1. Panel Principal de la Pestaña
        javax.swing.JPanel pnPreciosLote = new javax.swing.JPanel();
        // Usamos FlowLayout ALINEADO A LA IZQUIERDA para que no estire la tabla
        pnPreciosLote.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        // 2. Panel Contenedor Vertical (Para apilar Tabla arriba y Botones abajo)
        javax.swing.JPanel pnContenedorVertical = new javax.swing.JPanel();
        pnContenedorVertical.setLayout(new javax.swing.BoxLayout(pnContenedorVertical, javax.swing.BoxLayout.Y_AXIS));

        // 3. Configurar Tabla
        grillaLotes = new javax.swing.JTable();
        modelLotes = new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Cant. Mínima", "Margen (%)", "Precio Ref."}
        ) {
            Class[] types = new Class[]{
                java.lang.Long.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean[]{false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        grillaLotes.setModel(modelLotes);

        // --- ESTÉTICA: Ajustar Anchos de Columna ---
        // Columna ID (Oculta)
        grillaLotes.getColumnModel().getColumn(0).setMinWidth(0);
        grillaLotes.getColumnModel().getColumn(0).setMaxWidth(0);
        grillaLotes.getColumnModel().getColumn(0).setWidth(0);

        // Columna Cantidad (Pequeña)
        grillaLotes.getColumnModel().getColumn(1).setPreferredWidth(90);

        // Columna Margen (Pequeña)
        grillaLotes.getColumnModel().getColumn(2).setPreferredWidth(80);

        // Columna Precio (Mediana)
        grillaLotes.getColumnModel().getColumn(3).setPreferredWidth(100);

        // ScrollPane con TAMAÑO FIJO (Aquí controlas el tamaño visual)
        javax.swing.JScrollPane scrollLotes = new javax.swing.JScrollPane();
        scrollLotes.setViewportView(grillaLotes);
        // [ANCHO, ALTO] -> Ajusta estos números a tu gusto
        scrollLotes.setPreferredSize(new java.awt.Dimension(400, 180));

        // 4. Panel de Botones
        javax.swing.JPanel pnBotonesLotes = new javax.swing.JPanel();
        // FlowLayout para centrar los botones debajo de la tabla pequeña
        pnBotonesLotes.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER));

        btAgregaLote = new javax.swing.JButton("Agregar");
        btEditarLote = new javax.swing.JButton("Editar");
        btEliminaLote = new javax.swing.JButton("Eliminar");

        // Tamaño botones más compacto
        java.awt.Dimension btnSize = new java.awt.Dimension(80, 25);
        btAgregaLote.setPreferredSize(btnSize);
        btEditarLote.setPreferredSize(btnSize);
        btEliminaLote.setPreferredSize(btnSize);

        btAgregaLote.setEnabled(false);
        btEditarLote.setEnabled(false);
        btEliminaLote.setEnabled(false);

        // Acciones (Igual que antes)
        btAgregaLote.addActionListener(evt -> mostrarDialogoRegla(-1));

        btEditarLote.addActionListener(evt -> {
            int row = grillaLotes.getSelectedRow();
            if (row >= 0) {
                mostrarDialogoRegla(row);
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "Seleccione una regla.");
            }
        });

        btEliminaLote.addActionListener(evt -> {
            int row = grillaLotes.getSelectedRow();
            if (row >= 0) {
                modelLotes.removeRow(row);
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "Seleccione una fila.");
            }
        });

        pnBotonesLotes.add(btAgregaLote);
        pnBotonesLotes.add(btEditarLote);
        pnBotonesLotes.add(btEliminaLote);

        // 5. Armado Final
        // Agregamos scroll y botones al contenedor vertical
        pnContenedorVertical.add(scrollLotes);
        pnContenedorVertical.add(javax.swing.Box.createVerticalStrut(5)); // Espacio
        pnContenedorVertical.add(pnBotonesLotes);

        // Agregamos el contenedor vertical al panel principal (que está alineado a la izquierda)
        pnPreciosLote.add(pnContenedorVertical);

        Pestanas.addTab("Precios por Lote", pnPreciosLote);
    }

// --- MÉTODO AUXILIAR PARA REUTILIZAR EL DIÁLOGO (AGREGAR/EDITAR) ---
    private void mostrarDialogoRegla(int row) {
        javax.swing.JTextField txCant = new javax.swing.JTextField();
        javax.swing.JTextField txMargen = new javax.swing.JTextField();
        // Eliminamos el checkbox 'Es Defecto' del diálogo

        if (row >= 0) {
            txCant.setText(modelLotes.getValueAt(row, 1).toString());
            txMargen.setText(modelLotes.getValueAt(row, 2).toString());
        }

        Object[] message = {
            "Cantidad Mínima:", txCant,
            "Margen % (Ej: 20):", txMargen
        };

        String titulo = (row >= 0) ? "Editar Regla" : "Nueva Regla";
        int option = javax.swing.JOptionPane.showConfirmDialog(null, message, titulo, javax.swing.JOptionPane.OK_CANCEL_OPTION);

        if (option == javax.swing.JOptionPane.OK_OPTION) {
            try {
                int cant = Integer.parseInt(txCant.getText().trim());
                double marg = Double.parseDouble(txMargen.getText().trim().replace(",", "."));

                if (cant < 0) {
                    throw new Exception("Cantidad negativa");
                }

                // Calcular el Precio Referencial visualmente (usando tu método helper calcularPrecioRef)
                double precioRef = calcularPrecioRef(marg);

                if (row >= 0) {
                    modelLotes.setValueAt(cant, row, 1);
                    modelLotes.setValueAt(marg, row, 2);
                    modelLotes.setValueAt(precioRef, row, 3); // Actualizar precio ref
                } else {
                    // ID null, Cant, Margen, PrecioRef
                    modelLotes.addRow(new Object[]{null, cant, marg, precioRef});
                }

            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(null, "Datos inválidos. Ingrese números correctos.");
            }
        }
    }

    // Cargar datos al abrir el producto
    private void CargaReglasLote(String sku) {
        ExeSql sql = new ExeSql();
        ResultSet rs = null;

        while (modelLotes.getRowCount() > 0) {
            modelLotes.removeRow(0);
        }

        try {
            // Traemos los datos, aunque 'es_regla_defecto' ya no lo mostramos
            String query = "SELECT id, cantidad_lote, margen_ganancia FROM producto_regla_lote "
                    + "WHERE sku_producto = '" + sku + "' ORDER BY cantidad_lote ASC";

            rs = sql.Select(query);

            while (rs.next()) {
                double margenBD = rs.getDouble("margen_ganancia"); // Ej: 0.20
                double margenVisual = margenBD * 100.0; // Ej: 20.0

                double precioRef = calcularPrecioRef(margenVisual);

                modelLotes.addRow(new Object[]{
                    rs.getLong("id"), // Columna 0 (Oculta)
                    rs.getInt("cantidad_lote"), // Columna 1
                    margenVisual, // Columna 2
                    precioRef // Columna 3
                });
            }

        } catch (SQLException ex) {
            Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.Close();
        }
    }

// Guardar datos al presionar Guardar
    private void GuardarReglasLote(String sku) {

        ExeSql sql = new ExeSql();
        if (grillaLotes.isEditing()) {
            grillaLotes.getCellEditor().stopCellEditing();
        }

        try {
            // 2. Conservar IDs
            StringBuilder idsConservar = new StringBuilder();
            for (int i = 0; i < modelLotes.getRowCount(); i++) {
                Object idObj = modelLotes.getValueAt(i, 0);
                if (idObj != null && !idObj.toString().isEmpty() && !idObj.toString().equals("0")) {
                    if (idsConservar.length() > 0) {
                        idsConservar.append(",");
                    }
                    idsConservar.append(idObj.toString());
                }
            }

            // 3. Borrar eliminados
            String deleteQuery;
            if (idsConservar.length() > 0) {
                deleteQuery = "DELETE FROM producto_regla_lote WHERE sku_producto = '" + sku + "' "
                        + "AND id NOT IN (" + idsConservar.toString() + ")";
            } else {
                deleteQuery = "DELETE FROM producto_regla_lote WHERE sku_producto = '" + sku + "'";
            }
            sql.ExeSql(deleteQuery);

            // 4. Insertar/Actualizar
            for (int i = 0; i < modelLotes.getRowCount(); i++) {
                Object idObj = modelLotes.getValueAt(i, 0); // ID Oculto

                int cantidad = Integer.parseInt(modelLotes.getValueAt(i, 1).toString());
                double margenVisual = Double.parseDouble(modelLotes.getValueAt(i, 2).toString());
                double margenBD = margenVisual / 100.0;

                // HARDCODED: Siempre false porque quitamos la columna
                String boolString = "false";

                if (idObj == null || idObj.toString().isEmpty() || idObj.toString().equals("0")) {
                    // INSERT
                    String insertQuery = "INSERT INTO producto_regla_lote (sku_producto, cantidad_lote, margen_ganancia, es_regla_defecto) "
                            + "VALUES ('" + sku + "', " + cantidad + ", " + margenBD + ", " + boolString + ")";
                    sql.ExeSql(insertQuery);
                } else {
                    // UPDATE
                    String updateQuery = "UPDATE producto_regla_lote SET "
                            + "cantidad_lote = " + cantidad + ", "
                            + "margen_ganancia = " + margenBD + ", "
                            + "es_regla_defecto = " + boolString + " "
                            + "WHERE id = " + idObj.toString();
                    sql.ExeSql(updateQuery);
                }
            }

            System.out.println("Lotes guardados correctamente.");

        } catch (Exception ex) {
            sql.Rollback();
            Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, ex);
            javax.swing.JOptionPane.showMessageDialog(null, "Error al guardar lotes: " + ex.getMessage());
        } finally {
            sql.Close();
        }
    }

    private double calcularPrecioRef(double margenPorcentaje) {
        try {
            // 1. Obtener Costo de la pantalla (Igual que tenías)
            String costoTexto = txPUltCompra.getText().trim();
            String costoLimpio = costoTexto.replaceAll("[^0-9]", "");

            if (costoLimpio.isEmpty()) {
                return 0.0;
            }

            // Usamos BigDecimal desde el inicio para precisión
            java.math.BigDecimal costo = new java.math.BigDecimal(costoLimpio);

            // 2. Variables
            java.math.BigDecimal ivaFactor = new java.math.BigDecimal("0.19");
            double margenDecimal = margenPorcentaje / 100.0;

            if (margenDecimal >= 1.0) {
                return 0.0;
            }

            java.math.BigDecimal divisor = java.math.BigDecimal.ONE.subtract(new java.math.BigDecimal(margenDecimal));

            // 3. Cálculo del NETO Unitario (Alta precisión interna, 8 decimales)
            // Costo / (1 - Margen)
            java.math.BigDecimal precioNetoPreciso = costo.divide(divisor, 8, java.math.RoundingMode.HALF_UP);

            // 4. SIMULACIÓN LÓGICA SII (Base Imponible + IVA)
            // Como es unitario, asumimos cantidad = 1 para la muestra visual.
            // A. Base Imponible (Neto) redondeada a 2 decimales
            java.math.BigDecimal baseImponible = precioNetoPreciso.setScale(2, java.math.RoundingMode.HALF_UP);

            // B. IVA redondeado a 2 decimales
            java.math.BigDecimal montoIva = baseImponible.multiply(ivaFactor).setScale(2, java.math.RoundingMode.HALF_UP);

            // C. Total Bruto (Suma exacta)
            java.math.BigDecimal totalBruto = baseImponible.add(montoIva);

            // 5. Retorno final redondeado a Entero (CLP)
            return totalBruto.setScale(0, java.math.RoundingMode.HALF_UP).doubleValue();

        } catch (Exception e) {
            return 0.0;
        }
    }

    private javax.swing.JTable grillaLotes;
    private javax.swing.table.DefaultTableModel modelLotes;
    private javax.swing.JButton btAgregaLote;
    private javax.swing.JButton btEliminaLote;
    private javax.swing.JButton btEditarLote;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Grilla;
    private javax.swing.JTable GrillaCompras;
    private javax.swing.JTable GrillaFacturasC;
    private javax.swing.JTable GrillaMovimientos;
    private javax.swing.JTable GrillaRelacion;
    private javax.swing.JTable GrillaVenta;
    private javax.swing.JTable Grilla_Inv;
    private javax.swing.JMenuItem MnuAbrirOCC;
    private javax.swing.JMenuItem MnuAbrirOCP;
    private javax.swing.JMenuItem MnuCopia_OC;
    private javax.swing.JPopupMenu MnuOCC;
    private javax.swing.JPopupMenu MnuOCP;
    private javax.swing.JTabbedPane Pestanas;
    private javax.swing.JButton btActWeb;
    private javax.swing.JButton btAgregaID;
    private javax.swing.JButton btAgregaIDMadre;
    private javax.swing.JButton btAgregaRelacion;
    private javax.swing.JButton btAjustes;
    private javax.swing.JButton btBuscarRelacionado;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btCargarImagen;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btEliminaID;
    private javax.swing.JButton btEliminaIDMadre;
    private javax.swing.JButton btEliminaRelacion;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btEstablecerRelacionado;
    private javax.swing.ButtonGroup btGroupMovimientos;
    private javax.swing.ButtonGroup btGroupProveedor;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btGuardarMinimo;
    private javax.swing.JButton btGuardarOfer;
    public javax.swing.JButton btIr;
    private javax.swing.JButton btNuevo;
    private javax.swing.JButton btUbica;
    private javax.swing.JButton btVerAuditoria;
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
    private javax.swing.JCheckBox chbOfertaAutomatica;
    private javax.swing.JCheckBox chkCodigo;
    private javax.swing.JCheckBox chkDesxPrecio;
    private javax.swing.JCheckBox chkDiscontinuado;
    private javax.swing.JCheckBox chkDisosur;
    private javax.swing.JCheckBox chkIva;
    private javax.swing.JCheckBox chkNoTransado;
    private javax.swing.JCheckBox chkOferta;
    private javax.swing.JCheckBox chkPublicado;
    private javax.swing.JCheckBox chkStock;
    private javax.swing.JCheckBox chkWeb;
    private javax.swing.JCheckBox chkWeb1;
    private javax.swing.JCheckBox chk_minimo;
    private javax.swing.JCheckBox chkdeshabilitado;
    private org.jdesktop.swingx.JXDatePicker dtFinOfer;
    private org.jdesktop.swingx.JXDatePicker dtInicioOfer;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
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
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JToggleButton jtCantidad;
    private javax.swing.JTextField jtDescripcion;
    private javax.swing.JToggleButton jtEnOferta;
    private javax.swing.JTextField jtFechaLlegada;
    private javax.swing.JToggleButton jtPosiciones;
    private javax.swing.JTextField jtURL;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lbAjustes;
    private javax.swing.JLabel lbImagen;
    private javax.swing.JLabel lbM3;
    private javax.swing.JLabel lbNuevoMinimo;
    private javax.swing.JLabel lbWeb;
    private javax.swing.JLabel lbcargando;
    private javax.swing.JList<String> lsChilecompras;
    private javax.swing.JList lsCodbar;
    private javax.swing.JPanel pMargen;
    private javax.swing.JPanel pnDetalle;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JLabel skulabel;
    private javax.swing.JTextField txAlto;
    private javax.swing.JTextField txAncho;
    private javax.swing.JTextField txAuditoria;
    private javax.swing.JTextField txCantUnidad;
    private javax.swing.JTextField txComision;
    private javax.swing.JTextField txCreacionFecha;
    private javax.swing.JTextField txCreacionUsuario;
    private javax.swing.JTextField txCritico;
    private javax.swing.JTextField txDisplay;
    private javax.swing.JTextField txEnvio;
    private javax.swing.JTextField txLargo;
    private javax.swing.JTextField txMarca;
    private javax.swing.JTextField txMargen;
    private javax.swing.JTextField txMargen2;
    private javax.swing.JTextField txMinimo;
    private javax.swing.JTextField txModelo;
    private javax.swing.JTextField txNombre;
    private javax.swing.JTextField txNombreGen;
    private javax.swing.JTextField txNroPublicacion;
    private javax.swing.JTextField txNuevoMinimo;
    private javax.swing.JTextField txPCosto;
    private javax.swing.JTextField txPNeto;
    private javax.swing.JTextField txPPublico;
    private javax.swing.JTextField txPUltCompra;
    private javax.swing.JTextField txPeso;
    private javax.swing.JTextField txPosicion;
    private javax.swing.JTextField txPropuesta;
    private javax.swing.JTextField txPublicacion;
    private javax.swing.JTextField txPublicadoIva;
    private javax.swing.JTextField txPublicadoNeto;
    private javax.swing.JTextField txSeparado;
    public javax.swing.JTextField txSku;
    private javax.swing.JTextField txStockDisosur;
    private javax.swing.JTextField txStockEcona;
    private javax.swing.JTextField txStockGDC;
    private javax.swing.JTextField txStockInv;
    private javax.swing.JTextField txStockOCC;
    private javax.swing.JTextField txStockOCP;
    private javax.swing.JTextField txStockTotal;
    private javax.swing.JTextField txTallaCont;
    private javax.swing.JTextField txTazaImpuesto;
    private javax.swing.JTextField txTransito;
    private javax.swing.JTextField txTransporte;
    private javax.swing.JTextField txUbicados;
    private javax.swing.JTextField txWeb;
    private javax.swing.JTextField txconvenio;
    private javax.swing.JTextField txidchmadre;
    private javax.swing.JTextField txtCrearRelacion;
    private javax.swing.JTextField url_mercado;
    private javax.swing.JTextField url_web;
    private javax.swing.JTextField url_yapo;
    private javax.swing.JTextField valor_mercadolibre;
    private javax.swing.JTextField valor_publico;
    private javax.swing.JTextField valor_vendedor;
    // End of variables declaration//GEN-END:variables
}
