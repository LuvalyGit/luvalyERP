package Formularios;

import Conexion.Conector;
import Conexion.ExeSql;
import Dialogos.jdAutorizaPagos;
import Dialogos.jdBuscarCliPrv;
import Dialogos.jdCambioClave;
import Dialogos.jdCargaChilemat;
import Dialogos.jdCargaLibros;
import Dialogos.jdCierreSueldos;
import Dialogos.jdCompara;
import Dialogos.jdFeriado;
import Dialogos.jdFolios;
import Dialogos.jdHDRemuneraciones;
import Dialogos.jdImpresoras;
import Dialogos.jdLogin;
import Dialogos.jdMultaAutoriza;
import PanelForm.AsignaProdInvent;
import PanelForm.AsignaProdInvent_ant;
import PanelForm.AsignaUbicacion_Producto;
import PanelForm.Asociados_OCP;
import PanelForm.AuditoriaMetro;
import PanelForm.Autorizar_OCP;
import PanelForm.PreciosDEspacho;
import PanelForm.pfAbrirTicket;
import PanelForm.pfActivos;
import PanelForm.pfActivosConfig;
import PanelForm.pfAdminParametros;
import PanelForm.pfAjusteMinimos;
import PanelForm.pfAjusteStock;
import PanelForm.pfAjusteStock_Autoriza;
import PanelForm.pfAplicaNCPDescuento;
import PanelForm.pfAutorizaAjustes;
import PanelForm.pfAutorizaNCC;
import PanelForm.pfAutorizaOTrasnp;
import PanelForm.pfAutorizaSKU;
import PanelForm.pfAvanceInventarioSala;
import PanelForm.pfBOLCliente;
import PanelForm.pfBalanceGeneral;
import PanelForm.pfBco_Cartolas;
import PanelForm.pfBco_CartolasTC;
import PanelForm.pfPrv_CargosRecibidos;
import PanelForm.pfBco_ConciliacionEntre;
import PanelForm.pfBco_Mantenedor;
import PanelForm.pfBlogCobranza1;
import PanelForm.pfBoletasGarantia;
import PanelForm.pfCCCotizaCliente;
import PanelForm.pfCLI_EstadoCXC;
import PanelForm.pfCXC_Cartera;
import PanelForm.pfCXC_CartolaAbonos;
import PanelForm.pfCXC_Resultados;
import PanelForm.pfCheques;
import PanelForm.pfProductos;
import PanelForm.pfClientes;
import PanelForm.pfClientesMorosos;
import PanelForm.pfConta_Mayor;
import PanelForm.pfConta_PlandeCuentas;
import PanelForm.pfEstadoCheques;
import PanelForm.pfFACCliente;
import PanelForm.pfFACClienteExenta;
import PanelForm.pfFAProveedor;
import PanelForm.pfGDCliente;
import PanelForm.pfConta_Movimientos;
import PanelForm.pfConvenios;
import PanelForm.pfF29;
import PanelForm.pfGastos;
import PanelForm.pfGastosConfig;
import PanelForm.pfGastosRendicion;
import PanelForm.pfGastosSueldos;
import PanelForm.pfNCCCliente;
import PanelForm.pfNCPProveedor;
import PanelForm.pfNDBCliente;
import PanelForm.pfOCCReporte;
import PanelForm.pfOCC_AutorizaMargen;
import PanelForm.pfOCCliente;
import PanelForm.pfOCPReporte;
import PanelForm.pfOCProveedor;
import PanelForm.pfPRVPendientes;
import PanelForm.pfPersonal;
import PanelForm.pfProveedores;
import PanelForm.pfPrv_ReversoRecepcion;
import PanelForm.pfRepProvConv_CompraVta;
import PanelForm.pfReporteAuditoria;
import PanelForm.pfReporteMargen_FAC_OC1;
import PanelForm.pfReportePagosPrv;
import PanelForm.pfReporteSeparacion;
import PanelForm.pfTransformacion;
import PanelForm.pfBuscaDoc;
import PanelForm.pfBuscaFAP;
import PanelForm.pfCargaProductosPortal;
import PanelForm.pfCli_AbonosRecibidos;
import PanelForm.pfCompraValorizado;
import PanelForm.pfCompraVenta2;
import PanelForm.pfConsulta_VendedorCartera;
import PanelForm.pfControlAvanceInventario;
import PanelForm.pfControlAvanceTraslado;
import PanelForm.pfControlInventario_1;
import PanelForm.pfGenerarCatalogo;
import PanelForm.pfInvent_Metro_Busqueda;
import PanelForm.pfIndicadoresInventario;
import PanelForm.pfModificarIngreso;
import PanelForm.pfNCPBusqueda;
import PanelForm.pfControlNCC;
import PanelForm.pfEvaluacionesConvenios;
import PanelForm.pfFacturasACEPTA;
import PanelForm.pfFechaVencimiento;
import PanelForm.pfGDCSinFactura;
import PanelForm.pfGastoRemuneraciones;
import PanelForm.pfHipotecarios;
import PanelForm.pfIndicadoresVencimiento;
import PanelForm.pfInventarioSalaH;
import PanelForm.pfNCCCliente_Autoriza;
import PanelForm.pfNVCliente;
import PanelForm.pfOCCliente_Trans;
import PanelForm.pfOCPHistorial;
import PanelForm.pfOCTransporte;
import PanelForm.pfOcchPortal;
import PanelForm.pfProductos_Econa;
import PanelForm.pfReporteAgotados;
import PanelForm.pfReporteAjustePrecio;
import PanelForm.pfReporteCompraAgil;
import PanelForm.pfReporteDespachador;
import PanelForm.pfReporteLicitaciones;
import PanelForm.pfReporteMercadoPublico;
import PanelForm.pfReporteMovUbc;
import PanelForm.pfReporteOfertas;
import PanelForm.pfReportePosiciones;
import PanelForm.pfReportePrecio;
import PanelForm.pfReporteProveedorConvenio_2;
import PanelForm.pfReporteRecepcionados;
import PanelForm.pfReporteVentasFinal2;
import PanelForm.pfReportesMargen;
import PanelForm.pfReportesMargenProveedor;
import PanelForm.pfTickets;
import PanelForm.pfTicketsLuvaly;
import PanelForm.pfTrasladoProductos;
import PanelForm.pfUsuarios;
import PanelForm.pf_ManteCarteraClientes;
import PanelForm.pf_Compras_Cliente;
import NotaPedido.pfNotaPedido;
import Utilidades.PanelTab;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.math.BigInteger;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DavidAlcaman
 */
public class fmMain extends javax.swing.JFrame {

    static int[] PanEstado = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};//new int[10];
    private static double Sys_IVA = 0;
    private static String Sys_Decimal = ".";
    private static String Sys_Miles = ",";
    private static int FacNewYear = 0;

    private static String UsuarioNombreReal;
    private static String UsuarioClave;
    private static String UsuarioNombre;
    private static boolean UsuarioAdministrador;
    private static boolean UsuarioAjuste;
    private static boolean UsuarioCobranza;
    private static boolean UsuarioTransforma;
    private static boolean UsuarioAtorizaOCP;
    private static boolean UsuarioGastos;
    private static boolean UsuarioBodega;
    private static boolean UsuarioVentaEmpresa;
    private static boolean UsuarioEligeUbicacion;
    private static boolean UsuarioConfiguracion;
    private static boolean UsuarioAuditoria;
    private static boolean UsuarioAsociaProveedor;
    private static boolean UsuarioAutorizaOcp;
    private static boolean UsuarioEditaOcp;
    private static boolean UsuarioEditaNomSku;

    private static int UsuarioCCosto;
    private static int UsuarioId;
    private static boolean Internet;
    public static int disc = 0;
    public int intNivelMnu = 0;
    public static int intNivelUsuario = 0;   //Variable nueva
    public static int ccosto_usr = 0;
    public static int IntPosicionFinal = -1;
    private static int AdministraBodega;
    public static boolean cierra = false;
    public static boolean elimina = false;

    public fmMain() {

        initComponents();
        jdLogin Login = new jdLogin(null, true);
        Login.setLocationRelativeTo(null);
        Login.setVisible(true);
        CargaVariablesSistema();
        lbNombre.setText(UsuarioNombreReal);
        String Servidor = Conector.GetSistema();
        lbTituloDocumentos.setVisible(false);
        jButton1.setVisible(false);
        lblServidor.setText(Servidor);
        jMenuItem30.setVisible(false);
        jMenu2.setVisible(false);
        jMenuItem36.setVisible(false);
        jButton3.setVisible(false);

//        BoletaCliente.setEnabled(false);
//        NotaVentaCliente.setEnabled(false);
        //      mnIndicadoresContables.setVisible(false);
        try {
            setIconImage(new ImageIcon(getClass().getResource("/Iconos/Luvaly.png")).getImage());
        } catch (Exception e) {
        }

        System.out.println(GetUsuario());

//        setIconImage(new ImageIcon(getClass().getResource("../Iconos/L.png")).getImage());
        muestraDatos();
        if (fmMain.trae_nivel(fmMain.GetUsuario()) < 90) {

            jMenuItem92.setVisible(false);          //Control Avance Inventario
            mnAjusteStock.setEnabled(false);
            jMenuItem79.setEnabled(false);
            jMenuItem80.setEnabled(false);
            jMenuItem92.setEnabled(false);

            panelDatos.setVisible(false);

            jButton2.setEnabled(false);
            jMenuItem88.setEnabled(false);
//            jMenu10.setEnabled(false);
            jMenuItem83.setEnabled(false);
            jMenuItem42.setEnabled(false);
            // jMenu10.setVisible(false);
            jMenuItem59.setVisible(false);

            NumeroTicketGeneral.setVisible(false);
        } else {
            mnInventario.setEnabled(true);
            mnAjusteStock.setEnabled(true);
            jMenuItem79.setEnabled(true);
            jMenuItem80.setEnabled(true);
            jMenuItem88.setEnabled(true);
            jMenuItem92.setEnabled(true);
            panelDatos.setVisible(true);
            jButton2.setEnabled(true);
            jMenuItem83.setEnabled(true);
            jMenuItem42.setEnabled(true);
//            jMenu10.setEnabled(true);
            //     jMenu10.setVisible(true);
            NumeroTicketGeneral.setVisible(true);
        }

        jMenuItem81.setVisible(false);
        btTicket.setVisible(false);
        jButton5.setVisible(false);
        jButton6.setVisible(false);
        AjustedeStock.setVisible(false);
        jMenuItem56.setVisible(false);
        jMenuItem60.setVisible(false);
        jMenuItem90.setVisible(false);
        mnReversaRecep.setVisible(false);

        jMenuItem93.setVisible(false);  //Gasto Remuneraciones

        jMenuItem54.setVisible(false);  // Cargar Ordenes Portal
        jMenuItem50.setVisible(false);  // Reporte Auditoria (antiguo)
        jMenuItem53.setVisible(false);  //Reporte Despachos
        jMenuItem79.setVisible(false);  //Control NCC
        jMenuItem91.setVisible(false);  //Ajuste Vencimiento
        jMenuItem77.setVisible(false);  //Reporte Precios DISOSUR

        jMenuItem97.setVisible(false);  //Historial (OCP)

        jMenuItem67.setVisible(false);  //Reporte posición

        jMenuItem85.setVisible(false);  //Ficha Producto ECONA

        jMenuItem78.setVisible(false);  //Reporte ofertas  

        jMenuItem86.setVisible(false);  //Carga productos web

        jMenuItem41.setVisible(false);  //Reporte Margen

        jMenuItem60.setVisible(false);  //Reporte Margen Proveedor

        jMenuItem61.setVisible(false);  //Administra Cartera Vendedor

        jMenuItem90.setVisible(false);  //Reporte Vencimiento Productos

        jCheckBoxMenuItem1.setVisible(false); //Busca Vendedor de CLiente

        mnMovUbc.setVisible(false);  //Movimiento de Ubicaciones

        jMenuItem64.setVisible(false); //Catálogo de Productos

        jMenuItem43.setVisible(false); //Administrar Convenios

        jMenuItem98.setVisible(false); //Feriados

        //  if (fmMain.GetUsuario().equals("ALOPEZ") || fmMain.GetUsuario().equals("LRUBILAR") ){
        if (fmMain.UsuarioAjuste) {

            AjustedeStock.setVisible(true);
            jMenuItem93.setVisible(true);  //Gasto Remuneraciones

        }

        mnEvaluaciones.setVisible(false);

        lbcargando.setVisible(false);
        lbcargando1.setVisible(false);

        if (fmMain.GetUsuario().equals("ALOPEZ") || fmMain.GetUsuario().equals("LRUBILAR") || fmMain.GetUsuario().equals("LEORUBILAR")) {

            jButton1.setVisible(true);
            // btTicket.setVisible(true);
//            jButton5.setVisible(true);
//            jButton6.setVisible(true);

            jButton3.setVisible(true);

            //     jMenuItem60.setVisible(true); //Reporte Margen Proveedor
            //mnEvaluaciones.setVisible(true);
        }

//        if (fmMain.UsuarioConfiguracion){
//            
//            
//          
//        
//        }
        jMenuItem25.setVisible(false);

        //   mnInventario.setVisible(false);              //proceso de inventario
        mnAjusteStock.setVisible(false);             //proceso de inventario
        jMenuItem58.setVisible(false);

        MenuTicket.setVisible(false);
        NumeroTicket.setVisible(false);
        NumeroTicketGeneral.setVisible(false);
        jMenu10.setVisible(false);

        //mnAutorizaSku.setVisible(false);
//        ActualizaTickets();
//        ActualizaTicketsGeneral();
//    final Runnable tarea = new Runnable() {
//        public void run() {
//            ActualizaTickets();
//            ActualizaTicketsGeneral();
//        }
//    };
//    ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();
//    timer.scheduleAtFixedRate(tarea, 1, 1, TimeUnit.HOURS);
    }

    public void ActualizaTickets() {
        ExeSql sql = new ExeSql();
        ResultSet rs = null;
        String resultado = "";
        String query = "select case when count(*) is null then 0 else count(*) end as conteo \n"
                + "from tickets_luvaly \n"
                + "where destinatario = '" + fmMain.GetUsuario() + "' and estado in (0,1)";
        try {
            rs = sql.Select(query);
            rs.next();
            resultado = rs.getString("conteo");
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(fmMain.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            sql.Close();
        }
        NumeroTicket.setText(resultado);

    }

    public void ActualizaTicketsGeneral() {

        ExeSql sql = new ExeSql();
        ResultSet rs = null;
        String resultado = "";

        String query = "select case when count(*) is null then 0 else count(*) end as conteo \n"
                + "from tickets_luvaly \n"
                + "where estado in (0,1,2)";
        try {

            rs = sql.Select(query);
            rs.next();
            resultado = rs.getString("conteo");
            rs.close();

        } catch (SQLException ex) {

            Logger.getLogger(fmMain.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            sql.Close();
        }
        NumeroTicketGeneral.setText(resultado);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jMenuItem8 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jMenuItem38 = new javax.swing.JMenuItem();
        jMenuItem39 = new javax.swing.JMenuItem();
        jMenuItem44 = new javax.swing.JMenuItem();
        jMenuItem52 = new javax.swing.JMenuItem();
        jMenuItem62 = new javax.swing.JMenuItem();
        jMenuItem34 = new javax.swing.JMenuItem();
        jMenuItem73 = new javax.swing.JMenuItem();
        jMenuItem74 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        pnPestanas = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        Calendario = new org.jdesktop.swingx.JXMonthView();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        fecha_version = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbNovedades = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbNombre = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblServidor = new javax.swing.JLabel();
        panelDatos = new javax.swing.JPanel();
        lbNDC = new javax.swing.JLabel();
        lbFEC = new javax.swing.JLabel();
        lbGDC = new javax.swing.JLabel();
        lbFAC = new javax.swing.JLabel();
        lbNCC = new javax.swing.JLabel();
        lbBOC = new javax.swing.JLabel();
        lbTituloDocumentos = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btTicket = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        lbcargando = new javax.swing.JLabel();
        lbcargando1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MnuArchivo = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        mnuUsuarios = new javax.swing.JMenuItem();
        jMenuItem98 = new javax.swing.JMenuItem();
        mnFolios = new javax.swing.JMenuItem();
        mnImpresoras = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        MnuVentas = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();
        OCC = new javax.swing.JMenuItem();
        OCC1 = new javax.swing.JMenuItem();
        GDC = new javax.swing.JMenuItem();
        FAC = new javax.swing.JMenuItem();
        NCC = new javax.swing.JMenuItem();
        FacturaExenta = new javax.swing.JMenuItem();
        BoletaCliente = new javax.swing.JMenuItem();
        NotaVentaCliente = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jMenuItem68 = new javax.swing.JMenuItem();
        jMenuItem69 = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        mnuReporteOCC = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuItem13 = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem70 = new javax.swing.JMenuItem();
        mnAutorizaAjuste = new javax.swing.JMenuItem();
        jMenuItem80 = new javax.swing.JMenuItem();
        mnAutorizaSku = new javax.swing.JMenuItem();
        jMenuItem81 = new javax.swing.JMenuItem();
        jSeparator16 = new javax.swing.JPopupMenu.Separator();
        jMenuItem40 = new javax.swing.JMenuItem();
        jMenuItem41 = new javax.swing.JMenuItem();
        jMenuItem60 = new javax.swing.JMenuItem();
        jMenuItem45 = new javax.swing.JMenuItem();
        jSeparator17 = new javax.swing.JPopupMenu.Separator();
        jMenuItem51 = new javax.swing.JMenuItem();
        mnComprasCliente = new javax.swing.JMenuItem();
        jMenuItem61 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenuItem63 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem71 = new javax.swing.JMenuItem();
        mnEvaluaciones = new javax.swing.JMenuItem();
        MnuProductos = new javax.swing.JMenu();
        AbrirProducto = new javax.swing.JMenuItem();
        jMenuItem85 = new javax.swing.JMenuItem();
        jSeparator18 = new javax.swing.JPopupMenu.Separator();
        jMenuItem48 = new javax.swing.JMenuItem();
        jMenuItem49 = new javax.swing.JMenuItem();
        jMenuItem67 = new javax.swing.JMenuItem();
        mnMercadoPublico = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        AjustedeStock = new javax.swing.JMenuItem();
        AjusteAutoriza = new javax.swing.JMenuItem();
        StockProducto = new javax.swing.JMenuItem();
        jMenuItem43 = new javax.swing.JMenuItem();
        jMenuItem64 = new javax.swing.JMenuItem();
        jMenuItem78 = new javax.swing.JMenuItem();
        jMenuItem86 = new javax.swing.JMenuItem();
        jMenuItem90 = new javax.swing.JMenuItem();
        jMenuItem57 = new javax.swing.JMenuItem();
        jMenuItem100 = new javax.swing.JMenuItem();
        mnAgotados = new javax.swing.JMenuItem();
        mnRecepcionados = new javax.swing.JMenuItem();
        mnMovUbc = new javax.swing.JMenuItem();
        MnuClientes = new javax.swing.JMenu();
        BuscarCliente = new javax.swing.JMenuItem();
        AbrirCliente = new javax.swing.JMenuItem();
        jMenuItem47 = new javax.swing.JMenuItem();
        MnuProveedores = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem101 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mnuControlInventario = new javax.swing.JMenuItem();
        AbrirProveedor = new javax.swing.JMenuItem();
        OCP = new javax.swing.JMenuItem();
        jMenuItem97 = new javax.swing.JMenuItem();
        jMenuItem66 = new javax.swing.JMenuItem();
        jMenuItem65 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        ReporteOCP = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        buscaFactura = new javax.swing.JMenuItem();
        FAP = new javax.swing.JMenuItem();
        jMenuItem96 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        mnuPagosPRV = new javax.swing.JMenuItem();
        mnuDocPendientes = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        mnReversaRecep = new javax.swing.JMenuItem();
        jMenuItem75 = new javax.swing.JMenuItem();
        jMenuItem76 = new javax.swing.JMenuItem();
        jMenuItem89 = new javax.swing.JMenuItem();
        jMenuItem102 = new javax.swing.JMenuItem();
        MnuCobros = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenuItem33 = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JPopupMenu.Separator();
        jMenuItem37 = new javax.swing.JMenuItem();
        jMenuItem88 = new javax.swing.JMenuItem();
        jMenuItem46 = new javax.swing.JMenuItem();
        jMenuItem99 = new javax.swing.JMenuItem();
        MenuBanco = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem32 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem35 = new javax.swing.JMenuItem();
        MenuBoletas = new javax.swing.JMenuItem();
        MenuHipotecarios = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem29 = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenuItem93 = new javax.swing.JMenuItem();
        jMenuItem30 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem31 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem36 = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem94 = new javax.swing.JMenuItem();
        jMenuItem95 = new javax.swing.JMenuItem();
        mnIndicadoresContables = new javax.swing.JMenu();
        mnBalanceGral = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem19 = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jMenuItem20 = new javax.swing.JMenuItem();
        Control = new javax.swing.JMenu();
        jMenuItem42 = new javax.swing.JMenuItem();
        jMenuItem53 = new javax.swing.JMenuItem();
        jMenuItem50 = new javax.swing.JMenuItem();
        jMenuItem54 = new javax.swing.JMenuItem();
        jMenuItem55 = new javax.swing.JMenuItem();
        jMenuItem56 = new javax.swing.JMenuItem();
        mnInventario = new javax.swing.JMenuItem();
        jMenuItem58 = new javax.swing.JMenuItem();
        jMenuItem59 = new javax.swing.JMenuItem();
        mnAjusteStock = new javax.swing.JMenuItem();
        jMenuItem79 = new javax.swing.JMenuItem();
        jMenuItem91 = new javax.swing.JMenuItem();
        jMenuItem92 = new javax.swing.JMenuItem();
        jMenuItem77 = new javax.swing.JMenuItem();
        mnTrasladoProductos = new javax.swing.JMenuItem();
        mnControlAvanceTraslado = new javax.swing.JMenuItem();
        mnInvSala = new javax.swing.JMenuItem();
        mnControlAvanceInvSala = new javax.swing.JMenuItem();
        MenuTicket = new javax.swing.JMenu();
        jMenuItem83 = new javax.swing.JMenuItem();
        jMenuItem84 = new javax.swing.JMenuItem();
        jMenuItem82 = new javax.swing.JMenuItem();
        NumeroTicket = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        NumeroTicketGeneral = new javax.swing.JMenu();

        jMenuItem8.setText("jMenuItem8");

        jLabel1.setText("jLabel1");

        jMenuItem38.setText("jMenuItem38");

        jMenuItem39.setText("jMenuItem39");

        jMenuItem44.setText("jMenuItem44");

        jMenuItem52.setText("jMenuItem52");

        jMenuItem62.setText("jMenuItem62");

        jMenuItem34.setText("jMenuItem34");

        jMenuItem73.setText("jMenuItem73");

        jMenuItem74.setText("jMenuItem74");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LUVALY SPA");

        jPanel1.setBackground(new java.awt.Color(212, 238, 208));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1877, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        pnPestanas.setBackground(new java.awt.Color(161, 182, 197));
        pnPestanas.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        pnPestanas.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(161, 182, 197));
        jPanel2.setName(""); // NOI18N

        Calendario.setBackground(new java.awt.Color(212, 238, 208));
        Calendario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Calendario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(212, 238, 208));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Bell MT", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/luvaly2018.png"))); // NOI18N
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 13, 186, 196));

        fecha_version.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fecha_version.setForeground(new java.awt.Color(255, 0, 0));
        fecha_version.setText("10.09.2020");
        fecha_version.setToolTipText("");
        jPanel4.add(fecha_version, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 55, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Versión");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 55, -1, -1));

        jLabel7.setFont(new java.awt.Font("Calibri", 3, 28)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("LUVALY ERP");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 13, 160, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setText("Novedades en esta version:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 81, -1, -1));

        lbNovedades.setForeground(new java.awt.Color(0, 102, 255));
        lbNovedades.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNovedades.setText("TEXTO NOVEDADES");
        lbNovedades.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel4.add(lbNovedades, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 102, 489, 130));

        jPanel3.setBackground(new java.awt.Color(212, 238, 208));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbNombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbNombre.setForeground(new java.awt.Color(0, 0, 51));
        lbNombre.setText("Usuario");

        jLabel4.setForeground(new java.awt.Color(0, 0, 51));
        jLabel4.setText("Usuario:");

        jLabel5.setForeground(new java.awt.Color(0, 0, 51));
        jLabel5.setText("Servidor:");

        lblServidor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblServidor.setForeground(new java.awt.Color(0, 0, 51));
        lblServidor.setText("Servidor");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblServidor, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblServidor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelDatos.setBackground(new java.awt.Color(161, 182, 197));

        lbNDC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        lbFEC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        lbGDC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbGDC.setText(" ");

        lbFAC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        lbNCC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        lbBOC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFAC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbFEC, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                    .addComponent(lbNDC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbGDC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbBOC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosLayout.createSequentialGroup()
                .addGap(0, 27, Short.MAX_VALUE)
                .addComponent(lbBOC, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbNDC, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbFEC, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(lbGDC, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbFAC, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lbTituloDocumentos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTituloDocumentos.setText("DOCUMENTOS DISPONIBLES");

        jButton1.setText("Actualiza Sala");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/Actualiza.png"))); // NOI18N
        jButton2.setText("Actualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btTicket.setText("ticket");
        btTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTicketActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/Actualiza.png"))); // NOI18N
        jButton4.setText("Actualizar Tickets");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("jButton5");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("jButton6");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton3.setText("Actualiza Bodega");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        lbcargando.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Carga2.gif"))); // NOI18N
        lbcargando.setText("Actualizando...");
        lbcargando.setToolTipText("");

        lbcargando1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Carga2.gif"))); // NOI18N
        lbcargando1.setText("Actualizando...");
        lbcargando1.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Calendario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addComponent(lbTituloDocumentos))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(96, 96, 96)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton5)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(87, 87, 87)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbcargando, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcargando1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(374, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbcargando))))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lbTituloDocumentos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbcargando1)))
                        .addGap(84, 84, 84)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)))
                .addContainerGap(204, Short.MAX_VALUE))
        );

        pnPestanas.addTab("Inicio", jPanel2);

        getContentPane().add(pnPestanas, java.awt.BorderLayout.CENTER);

        MnuArchivo.setText("Archivo");

        jMenu1.setText("Configuración");

        mnuUsuarios.setText("Usuarios");
        mnuUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuUsuariosActionPerformed(evt);
            }
        });
        jMenu1.add(mnuUsuarios);

        jMenuItem98.setText("Feriados");
        jMenuItem98.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem98ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem98);

        mnFolios.setText("Folios");
        mnFolios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnFoliosActionPerformed(evt);
            }
        });
        jMenu1.add(mnFolios);

        mnImpresoras.setText("Impresoras");
        mnImpresoras.setToolTipText("");
        mnImpresoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnImpresorasActionPerformed(evt);
            }
        });
        jMenu1.add(mnImpresoras);

        MnuArchivo.add(jMenu1);

        jMenuItem5.setText("Salir");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        MnuArchivo.add(jMenuItem5);

        jMenuBar1.add(MnuArchivo);

        MnuVentas.setText("Ventas");

        jMenu12.setText("Órdenes de Compra");

        OCC.setText("OC Cliente ChileCompras");
        OCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OCCActionPerformed(evt);
            }
        });
        jMenu12.add(OCC);

        OCC1.setText("OC Cliente General");
        OCC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OCC1ActionPerformed(evt);
            }
        });
        jMenu12.add(OCC1);

        MnuVentas.add(jMenu12);

        GDC.setText("Guía de Despacho Cliente");
        GDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GDCActionPerformed(evt);
            }
        });
        MnuVentas.add(GDC);

        FAC.setText("Factura a Cliente");
        FAC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FACActionPerformed(evt);
            }
        });
        MnuVentas.add(FAC);

        NCC.setText("Nota de Crédito Cliente");
        NCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NCCActionPerformed(evt);
            }
        });
        MnuVentas.add(NCC);

        FacturaExenta.setText("Factura Exenta a Cliente");
        FacturaExenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FacturaExentaActionPerformed(evt);
            }
        });
        MnuVentas.add(FacturaExenta);

        BoletaCliente.setText("Boleta Cliente");
        BoletaCliente.setToolTipText("");
        BoletaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoletaClienteActionPerformed(evt);
            }
        });
        MnuVentas.add(BoletaCliente);

        NotaVentaCliente.setText("Nota de Venta Cliente");
        NotaVentaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NotaVentaClienteActionPerformed(evt);
            }
        });
        MnuVentas.add(NotaVentaCliente);
        MnuVentas.add(jSeparator8);

        jMenuItem68.setText("Reporte Guias Sin Documentos");
        jMenuItem68.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem68ActionPerformed(evt);
            }
        });
        MnuVentas.add(jMenuItem68);

        jMenuItem69.setText("Orden de Compra Transporte");
        jMenuItem69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem69ActionPerformed(evt);
            }
        });
        MnuVentas.add(jMenuItem69);
        MnuVentas.add(jSeparator14);

        mnuReporteOCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Order24.png"))); // NOI18N
        mnuReporteOCC.setText("Reporte Ordenes de Compra");
        mnuReporteOCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuReporteOCCActionPerformed(evt);
            }
        });
        MnuVentas.add(mnuReporteOCC);
        MnuVentas.add(jSeparator9);

        jMenuItem13.setText("Nota de Débito Cliente");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        MnuVentas.add(jMenuItem13);
        MnuVentas.add(jSeparator10);

        jMenuItem26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/ok_16.png"))); // NOI18N
        jMenuItem26.setText("Autorizar Margen de OC");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        MnuVentas.add(jMenuItem26);

        jMenuItem70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/ok_16.png"))); // NOI18N
        jMenuItem70.setText("Autoriza Orden Transporte");
        jMenuItem70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem70ActionPerformed(evt);
            }
        });
        MnuVentas.add(jMenuItem70);

        mnAutorizaAjuste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/ok_16.png"))); // NOI18N
        mnAutorizaAjuste.setText("Autorizacion de Ajustes");
        mnAutorizaAjuste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAutorizaAjusteActionPerformed(evt);
            }
        });
        MnuVentas.add(mnAutorizaAjuste);

        jMenuItem80.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/billetera24.png"))); // NOI18N
        jMenuItem80.setText("Autorizar NCC");
        jMenuItem80.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem80ActionPerformed(evt);
            }
        });
        MnuVentas.add(jMenuItem80);

        mnAutorizaSku.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/ok_16.png"))); // NOI18N
        mnAutorizaSku.setText("Autoriza Nuevo Sku");
        mnAutorizaSku.setToolTipText("");
        mnAutorizaSku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAutorizaSkuActionPerformed(evt);
            }
        });
        MnuVentas.add(mnAutorizaSku);

        jMenuItem81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Editar.png"))); // NOI18N
        jMenuItem81.setText("Editar NCC Autorizable");
        jMenuItem81.setEnabled(false);
        jMenuItem81.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem81ActionPerformed(evt);
            }
        });
        MnuVentas.add(jMenuItem81);
        MnuVentas.add(jSeparator16);

        jMenuItem40.setText("Reporte de Ventas");
        jMenuItem40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem40ActionPerformed(evt);
            }
        });
        MnuVentas.add(jMenuItem40);

        jMenuItem41.setText("Reporte Margen");
        jMenuItem41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem41ActionPerformed(evt);
            }
        });
        MnuVentas.add(jMenuItem41);

        jMenuItem60.setText("Reporte Margen Proveedor");
        jMenuItem60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem60ActionPerformed(evt);
            }
        });
        MnuVentas.add(jMenuItem60);

        jMenuItem45.setText("OC / Factura");
        jMenuItem45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem45ActionPerformed(evt);
            }
        });
        MnuVentas.add(jMenuItem45);
        MnuVentas.add(jSeparator17);

        jMenuItem51.setText("Buscar Documento...");
        jMenuItem51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem51ActionPerformed(evt);
            }
        });
        MnuVentas.add(jMenuItem51);

        mnComprasCliente.setText("Compras - Cliente");
        mnComprasCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnComprasClienteActionPerformed(evt);
            }
        });
        MnuVentas.add(mnComprasCliente);

        jMenuItem61.setText("Administrar Cartera Vendedor");
        jMenuItem61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem61ActionPerformed(evt);
            }
        });
        MnuVentas.add(jMenuItem61);

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Busca Vendedor de Cliente.");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        MnuVentas.add(jCheckBoxMenuItem1);

        jMenuItem63.setText("Valor Despacho");
        jMenuItem63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem63ActionPerformed(evt);
            }
        });
        MnuVentas.add(jMenuItem63);

        jMenuItem18.setText("LICITACIONES");
        jMenuItem18.setToolTipText("");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        MnuVentas.add(jMenuItem18);

        jMenuItem71.setText("COMPRA AGIL");
        jMenuItem71.setToolTipText("");
        jMenuItem71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem71ActionPerformed(evt);
            }
        });
        MnuVentas.add(jMenuItem71);

        mnEvaluaciones.setText("EVALUACIONES");
        mnEvaluaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnEvaluacionesActionPerformed(evt);
            }
        });
        MnuVentas.add(mnEvaluaciones);

        jMenuBar1.add(MnuVentas);

        MnuProductos.setText("Productos");

        AbrirProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos22/Open.png"))); // NOI18N
        AbrirProducto.setText("Ficha de Producto");
        AbrirProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirProductoActionPerformed(evt);
            }
        });
        MnuProductos.add(AbrirProducto);

        jMenuItem85.setText("Ficha Producto Econa");
        jMenuItem85.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem85ActionPerformed(evt);
            }
        });
        MnuProductos.add(jMenuItem85);
        MnuProductos.add(jSeparator18);

        jMenuItem48.setText("Estado de Producto");
        jMenuItem48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem48ActionPerformed(evt);
            }
        });
        MnuProductos.add(jMenuItem48);

        jMenuItem49.setText("Reporte Compra-Venta");
        jMenuItem49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem49ActionPerformed(evt);
            }
        });
        MnuProductos.add(jMenuItem49);

        jMenuItem67.setText("Reporte Posición");
        jMenuItem67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem67ActionPerformed(evt);
            }
        });
        MnuProductos.add(jMenuItem67);

        mnMercadoPublico.setText("MERCADO PUBLICO");
        mnMercadoPublico.setToolTipText("");
        mnMercadoPublico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnMercadoPublicoActionPerformed(evt);
            }
        });
        MnuProductos.add(mnMercadoPublico);
        MnuProductos.add(jSeparator12);

        AjustedeStock.setText("Ajuste Stock");
        AjustedeStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjustedeStockActionPerformed(evt);
            }
        });
        MnuProductos.add(AjustedeStock);

        AjusteAutoriza.setText("Ajuste Stock c/Autorizacion");
        AjusteAutoriza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjusteAutorizaActionPerformed(evt);
            }
        });
        MnuProductos.add(AjusteAutoriza);

        StockProducto.setText("Transformacion");
        StockProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StockProductoActionPerformed(evt);
            }
        });
        MnuProductos.add(StockProducto);

        jMenuItem43.setText("Administrar Convenios");
        jMenuItem43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem43ActionPerformed(evt);
            }
        });
        MnuProductos.add(jMenuItem43);

        jMenuItem64.setText("Catalogos de Productos");
        jMenuItem64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem64ActionPerformed(evt);
            }
        });
        MnuProductos.add(jMenuItem64);

        jMenuItem78.setText("Reporte Ofertas");
        jMenuItem78.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem78ActionPerformed(evt);
            }
        });
        MnuProductos.add(jMenuItem78);

        jMenuItem86.setText("Carga Productos Web");
        jMenuItem86.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem86ActionPerformed(evt);
            }
        });
        MnuProductos.add(jMenuItem86);

        jMenuItem90.setText("Fecha Venc. Productos");
        jMenuItem90.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem90ActionPerformed(evt);
            }
        });
        MnuProductos.add(jMenuItem90);

        jMenuItem57.setText("Ajuste Minimos");
        jMenuItem57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem57ActionPerformed(evt);
            }
        });
        MnuProductos.add(jMenuItem57);

        jMenuItem100.setText("Reporte Precios");
        jMenuItem100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem100ActionPerformed(evt);
            }
        });
        MnuProductos.add(jMenuItem100);

        mnAgotados.setText("Reporte Agotados");
        mnAgotados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAgotadosActionPerformed(evt);
            }
        });
        MnuProductos.add(mnAgotados);

        mnRecepcionados.setText("Reporte Recepcionados");
        mnRecepcionados.setToolTipText("");
        mnRecepcionados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnRecepcionadosActionPerformed(evt);
            }
        });
        MnuProductos.add(mnRecepcionados);

        mnMovUbc.setText("Movimiento Ubicaciones");
        mnMovUbc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnMovUbcActionPerformed(evt);
            }
        });
        MnuProductos.add(mnMovUbc);

        jMenuBar1.add(MnuProductos);

        MnuClientes.setText("Clientes");

        BuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos22/search.png"))); // NOI18N
        BuscarCliente.setText("Buscar...");
        BuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarClienteActionPerformed(evt);
            }
        });
        MnuClientes.add(BuscarCliente);

        AbrirCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos22/Open.png"))); // NOI18N
        AbrirCliente.setText("Abrir Ficha Cliente");
        AbrirCliente.setToolTipText("");
        AbrirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirClienteActionPerformed(evt);
            }
        });
        MnuClientes.add(AbrirCliente);

        jMenuItem47.setText("Cotizacion Cliente");
        jMenuItem47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem47ActionPerformed(evt);
            }
        });
        MnuClientes.add(jMenuItem47);

        jMenuBar1.add(MnuClientes);

        MnuProveedores.setText("Proveedores");

        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/ok_16.png"))); // NOI18N
        jMenuItem15.setText("Autorizar Ordenes Proveedor");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        MnuProveedores.add(jMenuItem15);

        jMenuItem101.setText("Productos Asociados");
        jMenuItem101.setToolTipText("");
        jMenuItem101.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem101ActionPerformed(evt);
            }
        });
        MnuProveedores.add(jMenuItem101);
        MnuProveedores.add(jSeparator5);

        mnuControlInventario.setText("Control de Stock");
        mnuControlInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuControlInventarioActionPerformed(evt);
            }
        });
        MnuProveedores.add(mnuControlInventario);

        AbrirProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Provider24.png"))); // NOI18N
        AbrirProveedor.setText("Proveedor");
        AbrirProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirProveedorActionPerformed(evt);
            }
        });
        MnuProveedores.add(AbrirProveedor);

        OCP.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        OCP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/OCPoveedor16.png"))); // NOI18N
        OCP.setText("Ordenes de Compra Proveedor");
        OCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OCPActionPerformed(evt);
            }
        });
        MnuProveedores.add(OCP);

        jMenuItem97.setText("Historial");
        jMenuItem97.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem97ActionPerformed(evt);
            }
        });
        MnuProveedores.add(jMenuItem97);

        jMenuItem66.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        jMenuItem66.setText("Feria Valorizado");
        jMenuItem66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem66ActionPerformed(evt);
            }
        });
        MnuProveedores.add(jMenuItem66);

        jMenuItem65.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F11, 0));
        jMenuItem65.setText("Reporte Feria");
        jMenuItem65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem65ActionPerformed(evt);
            }
        });
        MnuProveedores.add(jMenuItem65);
        MnuProveedores.add(jSeparator3);

        ReporteOCP.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        ReporteOCP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos22/checklist22.png"))); // NOI18N
        ReporteOCP.setText("Reporte Ordenes Proveedor");
        ReporteOCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReporteOCPActionPerformed(evt);
            }
        });
        MnuProveedores.add(ReporteOCP);
        MnuProveedores.add(jSeparator4);

        buscaFactura.setText("Buscar Factura Proveedor");
        buscaFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscaFacturaActionPerformed(evt);
            }
        });
        MnuProveedores.add(buscaFactura);

        FAP.setText("Facturas Proveedor");
        FAP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FAPActionPerformed(evt);
            }
        });
        MnuProveedores.add(FAP);

        jMenuItem96.setText("Documentos Vencimiento CHILEMAT");
        jMenuItem96.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem96ActionPerformed(evt);
            }
        });
        MnuProveedores.add(jMenuItem96);

        jMenuItem27.setText("Cargos Recibidos");
        jMenuItem27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem27ActionPerformed(evt);
            }
        });
        MnuProveedores.add(jMenuItem27);

        mnuPagosPRV.setText("Pagos Proveedores");
        mnuPagosPRV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPagosPRVActionPerformed(evt);
            }
        });
        MnuProveedores.add(mnuPagosPRV);

        mnuDocPendientes.setText("Documentos Pendientes");
        mnuDocPendientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDocPendientesActionPerformed(evt);
            }
        });
        MnuProveedores.add(mnuDocPendientes);
        MnuProveedores.add(jSeparator2);

        jMenuItem4.setText("Notas de Crédito Proveedor");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        MnuProveedores.add(jMenuItem4);

        jMenu3.setText("NC Proveedor Descuento");
        jMenu3.setEnabled(false);
        jMenu3.setVisible(false);

        jMenuItem6.setText("Aplicar Descuento Nota de Crédito");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuItem7.setText("Buscar NCP no Aplicadas");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        MnuProveedores.add(jMenu3);
        MnuProveedores.add(jSeparator6);

        mnReversaRecep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/disable16.png"))); // NOI18N
        mnReversaRecep.setText("Reversar Recepción");
        mnReversaRecep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnReversaRecepActionPerformed(evt);
            }
        });
        MnuProveedores.add(mnReversaRecep);

        jMenuItem75.setText("Modificar Ingreso");
        jMenuItem75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem75ActionPerformed(evt);
            }
        });
        MnuProveedores.add(jMenuItem75);

        jMenuItem76.setText("Nota Debito Proveedor");
        jMenuItem76.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem76ActionPerformed(evt);
            }
        });
        MnuProveedores.add(jMenuItem76);

        jMenuItem89.setText("Documentos FACTURAS DEL SUR");
        jMenuItem89.setToolTipText("");
        jMenuItem89.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem89ActionPerformed(evt);
            }
        });
        MnuProveedores.add(jMenuItem89);

        jMenuItem102.setText("Reporte Ajuste Precios");
        jMenuItem102.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem102ActionPerformed(evt);
            }
        });
        MnuProveedores.add(jMenuItem102);

        jMenuBar1.add(MnuProveedores);

        MnuCobranza.setText("Cobranza");

        MnuCobros.setText("Cobranza");
        MnuCobros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuCobrosActionPerformed(evt);
            }
        });
        MnuCobranza.add(MnuCobros);

        jMenuItem9.setText("Desbloquedo");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        MnuCobranza.add(jMenuItem9);

        jMenuItem11.setText("Informe");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        MnuCobranza.add(jMenuItem11);

        jMenuItem25.setText("Abonos recibidos");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        MnuCobranza.add(jMenuItem25);

        jMenuItem33.setText("Carteras");
        jMenuItem33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem33ActionPerformed(evt);
            }
        });
        MnuCobranza.add(jMenuItem33);
        MnuCobranza.add(jSeparator15);

        jMenuItem37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/billetera24.png"))); // NOI18N
        jMenuItem37.setText("Autorizar Pago");
        jMenuItem37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem37ActionPerformed(evt);
            }
        });
        MnuCobranza.add(jMenuItem37);

        jMenuItem88.setText("Autorizar Multa");
        jMenuItem88.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem88ActionPerformed(evt);
            }
        });
        MnuCobranza.add(jMenuItem88);

        jMenuItem46.setText("Compromisos de pago");
        jMenuItem46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem46ActionPerformed(evt);
            }
        });
        MnuCobranza.add(jMenuItem46);

        jMenuItem99.setText("Abonos Recibidos");
        jMenuItem99.setToolTipText("");
        jMenuItem99.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem99ActionPerformed(evt);
            }
        });
        MnuCobranza.add(jMenuItem99);

        jMenuBar1.add(MnuCobranza);

        MenuBanco.setText("Banco");

        jMenuItem17.setText("Mantenedor");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        MenuBanco.add(jMenuItem17);

        jMenuItem16.setText("Cartolas");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        MenuBanco.add(jMenuItem16);

        jMenuItem32.setText("Cartolas TC");
        jMenuItem32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem32ActionPerformed(evt);
            }
        });
        MenuBanco.add(jMenuItem32);

        jMenu5.setText("Cheques");

        jMenuItem12.setText("Mantenedor");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem12);

        jMenuItem10.setText("Cartola");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem10);

        MenuBanco.add(jMenu5);

        jMenuItem35.setText("Conciliacion Cuentas");
        jMenuItem35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem35ActionPerformed(evt);
            }
        });
        MenuBanco.add(jMenuItem35);

        MenuBoletas.setText("Boletas de Garantía");
        MenuBoletas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBoletasActionPerformed(evt);
            }
        });
        MenuBanco.add(MenuBoletas);

        MenuHipotecarios.setText("Créditos Hipotecarios");
        MenuHipotecarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuHipotecariosActionPerformed(evt);
            }
        });
        MenuBanco.add(MenuHipotecarios);

        jMenuBar1.add(MenuBanco);

        jMenu7.setText("Contabilidad");

        jMenuItem22.setText("Plan de Cuentas");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem22);

        jMenuItem23.setText("Libro Diario");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem23);

        jMenuItem24.setText("Libro Mayor");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem24);

        jMenu8.setText("Gastos");

        jMenuItem29.setText("Configuración de Gastos");
        jMenuItem29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem29ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem29);
        jMenu8.add(jSeparator11);

        jMenuItem28.setText("Ingreso de Gastos");
        jMenuItem28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem28ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem28);

        jMenuItem93.setText("Gasto Remuneraciones");
        jMenuItem93.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem93ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem93);

        jMenuItem30.setText("Rendiciones");
        jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem30ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem30);

        jMenu7.add(jMenu8);

        jMenu9.setText("Activos");

        jMenuItem21.setText("Ingresar");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem21);

        jMenuItem31.setText("Configurar");
        jMenuItem31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem31ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem31);

        jMenu7.add(jMenu9);

        jMenu2.setText("Remuneraciones");
        jMenu2.setEnabled(false);

        jMenuItem14.setText("Personal");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem14);

        jMenuItem3.setText("Haberes / Descuentos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);
        jMenu2.add(jSeparator13);

        jMenuItem1.setText("Remuneraciones");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Cerrar Mes");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenu7.add(jMenu2);

        jMenuItem36.setText("F29");
        jMenuItem36.setEnabled(false);
        jMenuItem36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem36ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem36);

        jMenu11.setText("Impuestos Mensuales");

        jMenuItem94.setText("Carga Libros");
        jMenuItem94.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem94ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem94);

        jMenuItem95.setText("Compara Libros");
        jMenuItem95.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem95ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem95);

        jMenu7.add(jMenu11);

        mnIndicadoresContables.setText("Indicadores Contables");

        mnBalanceGral.setText("Balance General");
        mnBalanceGral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnBalanceGralActionPerformed(evt);
            }
        });
        mnIndicadoresContables.add(mnBalanceGral);

        jMenu7.add(mnIndicadoresContables);

        jMenuBar1.add(jMenu7);

        jMenu6.setText("Administracion");

        jMenuItem19.setText("Cambiar mi clave");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem19);
        jMenu6.add(jSeparator7);

        jMenuItem20.setText("Definir Parametros");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem20);

        jMenuBar1.add(jMenu6);

        Control.setText("Control");

        jMenuItem42.setText("Reporte Separacion");
        jMenuItem42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem42ActionPerformed(evt);
            }
        });
        Control.add(jMenuItem42);

        jMenuItem53.setText("Reporte Despachos");
        jMenuItem53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem53ActionPerformed(evt);
            }
        });
        Control.add(jMenuItem53);

        jMenuItem50.setText("Reporte Auditoria");
        jMenuItem50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem50ActionPerformed(evt);
            }
        });
        Control.add(jMenuItem50);

        jMenuItem54.setText("Cargar Ordenes Portal");
        jMenuItem54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem54ActionPerformed(evt);
            }
        });
        Control.add(jMenuItem54);

        jMenuItem55.setText("Ubicación de Productos");
        jMenuItem55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem55ActionPerformed(evt);
            }
        });
        Control.add(jMenuItem55);

        jMenuItem56.setText("Ingreso de Productos en Ubicacion");
        jMenuItem56.setEnabled(false);
        jMenuItem56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem56ActionPerformed(evt);
            }
        });
        Control.add(jMenuItem56);

        mnInventario.setText("Inventario");
        mnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnInventarioActionPerformed(evt);
            }
        });
        Control.add(mnInventario);

        jMenuItem58.setText("Auditoria Busqueda");
        jMenuItem58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem58ActionPerformed(evt);
            }
        });
        Control.add(jMenuItem58);

        jMenuItem59.setText("Auditoria Ubicación");
        jMenuItem59.setToolTipText("");
        jMenuItem59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem59ActionPerformed(evt);
            }
        });
        Control.add(jMenuItem59);

        mnAjusteStock.setText("Ajuste Inventario");
        mnAjusteStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAjusteStockActionPerformed(evt);
            }
        });
        Control.add(mnAjusteStock);

        jMenuItem79.setText("Control NCC");
        jMenuItem79.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem79ActionPerformed(evt);
            }
        });
        Control.add(jMenuItem79);

        jMenuItem91.setText("Ajuste Vencimiento");
        jMenuItem91.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem91ActionPerformed(evt);
            }
        });
        Control.add(jMenuItem91);

        jMenuItem92.setText("Control Avance Inventario");
        jMenuItem92.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem92ActionPerformed(evt);
            }
        });
        Control.add(jMenuItem92);

        jMenuItem77.setText("Reporte Precios DISOSUR");
        jMenuItem77.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem77ActionPerformed(evt);
            }
        });
        Control.add(jMenuItem77);

        mnTrasladoProductos.setText("TRASLADO PRODUCTOS");
        mnTrasladoProductos.setToolTipText("");
        mnTrasladoProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnTrasladoProductosActionPerformed(evt);
            }
        });
        Control.add(mnTrasladoProductos);

        mnControlAvanceTraslado.setText("Control Avance Traslado");
        mnControlAvanceTraslado.setToolTipText("");
        mnControlAvanceTraslado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnControlAvanceTrasladoActionPerformed(evt);
            }
        });
        Control.add(mnControlAvanceTraslado);

        mnInvSala.setText("INVENTARIO SALA");
        mnInvSala.setToolTipText("");
        mnInvSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnInvSalaActionPerformed(evt);
            }
        });
        Control.add(mnInvSala);

        mnControlAvanceInvSala.setText("Control Avance Inventario SALA");
        mnControlAvanceInvSala.setToolTipText("");
        mnControlAvanceInvSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnControlAvanceInvSalaActionPerformed(evt);
            }
        });
        Control.add(mnControlAvanceInvSala);

        jMenuBar1.add(Control);

        MenuTicket.setText("Tickets");

        jMenuItem83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos22/Order22.png"))); // NOI18N
        jMenuItem83.setText("Tickets");
        jMenuItem83.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem83ActionPerformed(evt);
            }
        });
        MenuTicket.add(jMenuItem83);

        jMenuItem84.setText("Abrir Ticket");
        jMenuItem84.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem84ActionPerformed(evt);
            }
        });
        MenuTicket.add(jMenuItem84);

        jMenuItem82.setText("Estado Ticket");
        jMenuItem82.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem82ActionPerformed(evt);
            }
        });
        MenuTicket.add(jMenuItem82);

        jMenuBar1.add(MenuTicket);

        NumeroTicket.setForeground(new java.awt.Color(255, 25, 25));
        NumeroTicket.setText("0");
        NumeroTicket.setEnabled(false);
        jMenuBar1.add(NumeroTicket);

        jMenu10.setText("-");
        jMenu10.setEnabled(false);
        jMenuBar1.add(jMenu10);

        NumeroTicketGeneral.setBackground(new java.awt.Color(204, 204, 204));
        NumeroTicketGeneral.setForeground(new java.awt.Color(0, 51, 204));
        NumeroTicketGeneral.setText("0");
        NumeroTicketGeneral.setEnabled(false);
        jMenuBar1.add(NumeroTicketGeneral);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public static void SetEstado(int Pos, int Estado) {
        PanEstado[Pos] = Estado;
    }

    public void muestraDatos() {

        this.setExtendedState(MAXIMIZED_BOTH);
        intNivelMnu = 100;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (intNivelMnu > intNivelUsuario) {
            return;
        }
        lbTituloDocumentos.setVisible(true);

        buscaBoleta();
        buscaFactura();
        buscaNotaCredito();
        buscaFacturaExentaCliente();
        buscaGuiaDespachoCliente();
        buscaNotaCreditoCliente();

    }

    public void buscaBoleta() {
        //BUSCA CANTIDAD BOLETAS

        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        int ContReg = 0;
        String Query = "";
        lbBOC.setText("");
        int almBOC = 0;
        try {
            Query = "SELECT *, (hasta - numero ) AS ResultadoBOC FROM par_correlativo WHERE tipo = 'BOC'";
            Rs = Sql.Select(Query);
            while (Rs.next()) {
                ContReg++;
                almBOC = Rs.getInt("ResultadoBOC");
                if (almBOC > 20) {
                    lbBOC.setText("Boletas:                                    " + Rs.getString("ResultadoBOC"));
                    lbBOC.setForeground(Color.black);
                } else {
                    lbBOC.setText("Boletas:                                    " + Rs.getString("ResultadoBOC"));
                    lbBOC.setForeground(Color.red);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pueden encontrar datos");
        } finally {
            Sql.Close();
        }
    }

    public void buscaFactura() {

        //BUSCA CANTIDAD FACTURAS   SAL.7400.1
        ExeSql Sql = new ExeSql();
        ResultSet Rs;

        int ContReg = 0;
        String Query = "";
        lbFAC.setText("");
        int almFAC = 0;

        try {

            Query = "SELECT *, (hasta - numero ) AS ResultadoFAC FROM par_correlativo WHERE tipo = 'FAC'";
            Rs = Sql.Select(Query);

            while (Rs.next()) {

                ContReg++;
                almFAC = Rs.getInt("ResultadoFAC");

                if (almFAC > 20) {

                    lbFAC.setText("Facturas:                                    " + Rs.getString("ResultadoFAC"));
                    lbFAC.setForeground(Color.black);

                } else {

                    lbFAC.setText("Facturas:                                    " + Rs.getString("ResultadoFAC"));
                    lbFAC.setForeground(Color.red);

                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pueden encontrar datos");
        } finally {
            Sql.Close();
        }
    }

    public void buscaNotaCredito() {
        //BUSCA CANTIDAD NOTAS DE CREDITO

        ExeSql SqlNDC = new ExeSql();
        ResultSet RsNDC;
        int ContRegNDC = 0;
        String QueryNDC = "";
        lbNDC.setText("");
        int almNDC = 0;

        try {

            QueryNDC = "SELECT *, (hasta -numero) AS ResultadoNDC FROM par_correlativo WHERE tipo = 'NDC'";
            RsNDC = SqlNDC.Select(QueryNDC);

            while (RsNDC.next()) {

                ContRegNDC++;
                almNDC = RsNDC.getInt("ResultadoNDC");

                if (almNDC > 20) {

                    lbNDC.setText("Notas de Debito Cliente:         " + RsNDC.getString("ResultadoNDC"));
                    lbNDC.setForeground(Color.black);

                } else {

                    lbNDC.setText("Notas de Debito Cliente:         " + RsNDC.getString("ResultadoNDC"));
                    lbNDC.setForeground(Color.red);

                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pueden encontrar datos");
        } finally {
            SqlNDC.Close();
        }
    }

    public void buscaFacturaExentaCliente() {
        //BUSCA CANTIDAD FACTURA EXENTA CLIENTE

        ExeSql SqlFEC = new ExeSql();
        ResultSet RsFEC;

        int ContRegFEC = 0;
        String QueryFEC = "";
        lbFEC.setText("");
        int almFEC = 0;

        try {

            QueryFEC = "SELECT *, (hasta - numero ) AS ResultadoFEC FROM par_correlativo WHERE tipo = 'FEC'";
            RsFEC = SqlFEC.Select(QueryFEC);

            while (RsFEC.next()) {

                ContRegFEC++;
                almFEC = RsFEC.getInt("ResultadoFEC");

                if (almFEC > 20) {
                    lbFEC.setText("Facturas Exenta a Cliente:    " + RsFEC.getString("ResultadoFEC"));
                    lbFEC.setForeground(Color.black);
                } else {
                    lbFEC.setText("Facturas Exenta a Cliente:    " + RsFEC.getString("ResultadoFEC"));
                    lbFEC.setForeground(Color.red);
                }
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "No se pueden encontrar datos");

        } finally {

            SqlFEC.Close();
        }
    }

    public void buscaGuiaDespachoCliente() {
        //BUSCA CANTIDAD GUIA DESPACHO CLIENTE

        ExeSql SqlGDC = new ExeSql();
        ResultSet RsGDC;

        int ContRegGDC = 0;
        String QueryGDC = "";
        lbGDC.setText("");
        int almGDC = 0;

        try {

            QueryGDC = "SELECT *, (hasta - numero ) AS ResultadoGDC FROM par_correlativo WHERE tipo = 'GDC'";
            RsGDC = SqlGDC.Select(QueryGDC);

            while (RsGDC.next()) {

                ContRegGDC++;
                almGDC = RsGDC.getInt("ResultadoGDC");

                if (almGDC > 20) {

                    lbGDC.setText("Guias de Despacho:                 " + RsGDC.getString("ResultadoGDC"));
                    lbGDC.setForeground(Color.black);

                } else {

                    lbGDC.setText("Guias de Despacho:                 " + RsGDC.getString("ResultadoGDC"));
                    lbGDC.setForeground(Color.red);

                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pueden encontrar datos");
        } finally {
            SqlGDC.Close();
        }
    }

    public void buscaNotaCreditoCliente() {
        //BUSCA CANTIDAD NOTA DE CREDITO CLIENTE

        ExeSql SqlNCC = new ExeSql();
        ResultSet RsNCC;

        int ContRegNCC = 0;
        String QueryNCC = "";
        lbNCC.setText("");
        int almNCC = 0;

        try {

            QueryNCC = "SELECT *, (hasta - numero ) AS ResultadoNCC FROM par_correlativo WHERE tipo = 'NCC'";
            RsNCC = SqlNCC.Select(QueryNCC);

            while (RsNCC.next()) {

                ContRegNCC++;
                almNCC = RsNCC.getInt("ResultadoNCC");

                if (almNCC > 20) {

                    lbNCC.setText("Notas de Credito Cliente:       " + RsNCC.getString("ResultadoNCC"));
                    lbNCC.setForeground(Color.black);

                } else {

                    lbNCC.setText("Notas de Credito Cliente:       " + RsNCC.getString("ResultadoNCC"));
                    lbNCC.setForeground(Color.red);

                }
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "No se pueden encontrar datos");
        } finally {

            SqlNCC.Close();
        }
    }

    public static void SetUsuario(String Nombre,
            String Usuario,
            String Clave,
            boolean EsInternet,
            boolean Admin,
            boolean Ajuste,
            boolean Cobranza,
            boolean Gastos,
            boolean Transformacion,
            boolean AdminOCP,
            boolean Bodega,
            int CCosto,
            int Id,
            int Nivel, //Variabel Nueva
            int AdminBodega,
            boolean AdminVentaEmpresa,
            boolean EligeUbicacion,
            boolean Configuracion,
            boolean Auditoria,
            boolean AsociaProv,
            boolean AutorizaOcp,
            boolean EditaOcp,
            boolean EditaNomSku
    ) {

        UsuarioNombreReal = Nombre;
        UsuarioNombre = Usuario;
        UsuarioClave = Clave;

        UsuarioAdministrador = Admin;
        UsuarioAjuste = Ajuste;
        UsuarioCobranza = Cobranza;
        UsuarioTransforma = Transformacion;
        UsuarioAtorizaOCP = AdminOCP;
        UsuarioGastos = Gastos;
        UsuarioBodega = Bodega;
        AdministraBodega = AdminBodega;
        UsuarioVentaEmpresa = AdminVentaEmpresa;
        UsuarioEligeUbicacion = EligeUbicacion;
        UsuarioConfiguracion = Configuracion;
        UsuarioAuditoria = Auditoria;
        UsuarioAsociaProveedor = AsociaProv;
        UsuarioAutorizaOcp = AutorizaOcp;
        UsuarioEditaOcp = EditaOcp;
        UsuarioEditaNomSku = EditaNomSku;

        UsuarioCCosto = CCosto;
        UsuarioId = Id;
        intNivelUsuario = Nivel;      //Codigo nuevo
        Internet = EsInternet;

    }

    public static void SetNombreUsuario(String ElNombre) {

        UsuarioNombre = ElNombre;
    }

    public static int GetFacNewYear() {

        ResultSet Rs;
        ExeSql Sql = new ExeSql();

        try {

            Rs = Sql.Select("select fac_newyear from parsys");
            Rs.next();
            return Rs.getInt("fac_newyear");
        } catch (Exception e) {

            return 0;
        } finally {
            Sql.Close();
        }
    }

    public static String BodegaTransito() {

        return "TRAN.1001.PLC";
    }

    public static String BodegaTransformacion() {

        return "TRAN.1005.1";
    }

    public static String BodegaNCC() {

        return "TRAN.1004.1";
    }

    public static String BodegaOCDirecta() {

        return "TRAN.1003.1";
    }

    public static String BodegaNCP() {

        return "TRAN.1002.1";
    }

    public static String BodegaAnticipada() {

        return "TRAN.1007.1";
    }

    public static String BodegaNegativos() {

        return "INV.1011.2";
    }

    public static String BodegaPositivos() {
        return "INV.1011.1";
    }

    public static void ErrorUsuarioLog(String Usuario, String Error) {

        ExeSql Sql = new ExeSql();

        try {

            Sql.ExeSql("insert into usuarios_eventos (usuario,tipo)values \n"
                    + "('" + Usuario + "','" + Error + "')");
            Sql.Commit();

        } catch (Exception e) {

            Sql.Rollback();

        } finally {

            Sql.Close();
        }
    }

    public static boolean GetInternet() {

        return Internet;
    }

    public static int GetAdminBodega() {

        return AdministraBodega;
    }

    public static String GetUsuario() {
        return UsuarioNombre;
    }

    public static String GetPass() {

        return UsuarioClave;
    }

    public static int GetEstado(int Pos) {

        return PanEstado[Pos];
    }

    public static void DeleteEstado(int Pos) {

        for (int i = Pos; i <= 12; i++) {

            PanEstado[i] = PanEstado[i + 1];
        }
    }

    public static String GetDecimal() {

        return Sys_Decimal;
    }

    public static String GetMiles() {

        return Sys_Miles;
    }

    public static double GetIva() {

        return Sys_IVA;
    }

    public static boolean GetUsuarioAdministrador() {

        return UsuarioAdministrador;
    }

    public static boolean GetUsuarioCobranza() {

        return UsuarioCobranza;
    }

    public static boolean GetUsuarioAjuste() {

        return UsuarioAjuste;
    }

    public static boolean GetUsuarioTransforma() {

        return UsuarioTransforma;
    }

    public static boolean GetUsuarioAdminOCP() {

        return UsuarioAtorizaOCP;
    }

    public static boolean GetUsuarioBodega() {

        return UsuarioBodega;
    }

    public static boolean GetUsuarioVentaEmpresa() {

        return UsuarioVentaEmpresa;
    }

    public static boolean GetUsuarioEligeUbicacion() {

        return UsuarioEligeUbicacion;
    }

    public static boolean GetUsuarioGastos() {

        return UsuarioGastos;
    }

    public static String GetCentrodeCosto() {
        return String.valueOf(UsuarioCCosto);
    }

    public static boolean GetUsuarioConfiguracion() {

        return UsuarioConfiguracion;
    }

    public static boolean GetUsuarioAuditoria() {

        return UsuarioAuditoria;
    }

    public static boolean GetUsuarioAsociaProveedor() {

        return UsuarioAsociaProveedor;
    }

    public static boolean GetUsuarioAutorizaOcp() {

        return UsuarioAutorizaOcp;
    }

    public static boolean GetUsuarioEditaOcp() {

        return UsuarioEditaOcp;
    }

    public static boolean GetUsuarioEditaNomSku() {

        return UsuarioEditaNomSku;
    }

    public static String GetUsuarioId() {

        return String.valueOf(UsuarioId);
    }

    public static String GetStringDeFinal(char cara, String nombrePalabra) {

        int j;
        j = 0;

        for (int i = nombrePalabra.length() - 1; i > 0; i--) {

            if (nombrePalabra.charAt(i) == cara) {

                j = i;
                break;
            }
        }

        return nombrePalabra.substring(j + 1).trim();
    }

    public static String GetStringDeInicio(char cara, String nombrePalabra) {

        int j;
        j = 0;

        for (int i = 0; i <= nombrePalabra.length(); i++) {

            if (nombrePalabra.charAt(i) == cara) {

                j = i;
                break;
            }
        }

        return nombrePalabra.substring(j + 1).trim();
    }

    public static boolean validarRut(String rut) {

        boolean validacion = false;

        try {
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dvx = rut.charAt(rut.length() - 1);
            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dvx == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }
            //fmMain.Mensaje("EL DV ES :" + (s - 1));
        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }

    public static String FormatoNumeroBig(BigInteger Numero) {
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator('.');
        simbolo.setGroupingSeparator(',');
        DecimalFormat formateador = new DecimalFormat("###,##0", simbolo);
        return formateador.format(Numero);
    }

    public static String FormatoNumeroBigLimpio(BigInteger Numero) {
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator('.');
        simbolo.setGroupingSeparator(',');
        DecimalFormat formateador = new DecimalFormat("#0", simbolo);
        return formateador.format(Numero);
    }

    public static String FormatoNumero(double Numero) {
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator('.');
        simbolo.setGroupingSeparator(',');
        DecimalFormat formateador = new DecimalFormat("###,##0.00", simbolo);
        return formateador.format(Numero);
    }

    public static String FormatoNumero1(double Numero) {

        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator('.');
        simbolo.setGroupingSeparator(',');
        DecimalFormat formateador = new DecimalFormat("###,##0.0", simbolo);
        return formateador.format(Numero);
    }

    public static String FormatoNumero2(double Numero) {
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator('.');
        simbolo.setGroupingSeparator(',');
        DecimalFormat formateador = new DecimalFormat("###,##0.000000", simbolo);
        return formateador.format(Numero);
    }

    public static String FormatoNumero31(double Numero) {
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator('.');
        simbolo.setGroupingSeparator(',');
        DecimalFormat formateador = new DecimalFormat("###,##0.00000", simbolo);
        return formateador.format(Numero);
    }

    public static String FormatoNumero32(double Numero) {
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator('.');
        simbolo.setGroupingSeparator(',');
        DecimalFormat formateador = new DecimalFormat("###,##0.000", simbolo);
        return formateador.format(Numero);
    }

    public static String FormatoNumero6(double Numero) {
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator('.');
        simbolo.setGroupingSeparator(',');
        DecimalFormat formateador = new DecimalFormat("###,##0.0000000", simbolo);
        return formateador.format(Numero);
    }

    public static String FormatoNumero5(double Numero) {
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator('.');
        simbolo.setGroupingSeparator(',');
        DecimalFormat formateador = new DecimalFormat("###,##0.00", simbolo);
        return formateador.format(Numero);
    }

    public static String FormatoNumero4(double Numero) {
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator('.');
        simbolo.setGroupingSeparator(',');
        DecimalFormat formateador = new DecimalFormat("#0.00000", simbolo);
        return formateador.format(Numero);
    }

    public static String FormatoNumeroSinDecimal(double Numero) {
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator('.');
        simbolo.setGroupingSeparator(',');
        DecimalFormat formateador = new DecimalFormat("###,##0", simbolo);
        return formateador.format(Numero);
    }

    public static String FormatoNumeroSinDecimalSinMiles(double Numero) {
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator('.');
        simbolo.setGroupingSeparator(',');
        DecimalFormat formateador = new DecimalFormat("###0", simbolo);
        return formateador.format(Numero);
    }

    public static String FormatoTotal(double Numero) {
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator('.');
        simbolo.setGroupingSeparator(',');
        DecimalFormat formateador = new DecimalFormat("###,###", simbolo);
        return formateador.format(Numero);
    }

    public static String FormatoNumeroEntero(double Numero) {
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator('.');
        simbolo.setGroupingSeparator(',');
        DecimalFormat formateador = new DecimalFormat("###,##0", simbolo);
        return formateador.format(Numero);
    }

    public static String SetGuardar(String Numero) {
        String Retorno = Numero.replace(",", "");
        Retorno = Retorno.replace(",", "");
        Retorno = Retorno.replace("$", "");
        Retorno = Retorno.replace("'", "");

        Retorno = EliminaCaracteres(Retorno, ",");

        return Retorno;
    }

    public static String FormatoNumero3(double Numero) {
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator('.');
        simbolo.setGroupingSeparator(',');

        DecimalFormat formateador = new DecimalFormat("#0.00", simbolo);
        return formateador.format(Numero);
    }

    public static String FormatoTotal3(double Numero) {
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator('.');
        simbolo.setGroupingSeparator(',');
        DecimalFormat formateador = new DecimalFormat("#", simbolo);
        return formateador.format(Numero);
    }

    public static void Msje(String Titulo, String Mensaje, int xx, int yy) {
        JOptionPane pane = new JOptionPane(Mensaje);
        JDialog dialog = pane.createDialog(Titulo);
        dialog.setLocation(xx, yy);
        dialog.setVisible(true);
    }

    public static String SetGuardarEntero(String Numero) {
        String Retorno = Numero.replace(",", "");

        Retorno = Retorno.replace(",", "");
        Retorno = Retorno.replace("$", "");
        Retorno = Retorno.replace(".", "");
        Retorno = Retorno.replace("$", "");

        Retorno = EliminaCaracteres(Retorno, ",");

        return Retorno;
    }

    public static String EliminaCaracteres(String s_cadena, String s_caracteres) {
        String nueva_cadena = "";
        Character caracter = null;
        boolean valido = true;

        /* Va recorriendo la cadena s_cadena y copia a la cadena que va a regresar,
         sólo los caracteres que no estén en la cadena s_caracteres */
        for (int i = 0; i < s_cadena.length(); i++) {
            valido = true;
            for (int j = 0; j < s_caracteres.length(); j++) {
                caracter = s_caracteres.charAt(j);

                if (s_cadena.charAt(i) == caracter) {
                    valido = false;
                    break;
                }
            }
            if (valido) {
                nueva_cadena += s_cadena.charAt(i);
            }
        }

        return nueva_cadena;
    }

    public static boolean EsLetra(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() > KeyEvent.VK_A && evt.getKeyCode() < KeyEvent.VK_Z || evt.getKeyChar() == 'ñ') {
            return true;
        } else {
            return false;
        }
    }

    public static String SetString(String Texto) {
        if (Texto.isEmpty() || Texto.trim().equals("")) {
            return "null";
        } else {
            return "'" + Texto.trim() + "'";
        }
    }

    public static void LimpiaGrilla(DefaultTableModel dfTm) {
        while (dfTm.getRowCount() > 0) {
            dfTm.removeRow(0);
        }
    }

    public static int OkCancel(String Mensaje) {
        int result = JOptionPane.showConfirmDialog(null, Mensaje,
                "Confirmar", JOptionPane.OK_CANCEL_OPTION);
        return result;
    }

    public static void Mensaje(String Mensaje) {
        int Pos = 0;
        if (Mensaje != null) {
            Pos = Mensaje.indexOf("Where");
            if (Pos > 0) {
                System.out.println(Mensaje);
                Mensaje = Mensaje.substring(0, Pos);
            }
            JOptionPane.showMessageDialog(null, Mensaje);
        }

    }

    private void CargaVariablesSistema() {
        ExeSql Sql = new ExeSql();
        try {
            ResultSet Rs = Sql.Select("select iva,decimal,fac_newyear from parsys");
            Rs.next();
            Sys_IVA = Rs.getFloat("iva") / 100;
            Sys_Decimal = Rs.getString("decimal");
            FacNewYear = Rs.getInt("fac_newyear");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Carga Variables " + e);
        } finally {
            Sql.Close();
        }

    }

    public static int trae_nivel(String Usu) {
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        String Ubica = "", Query = "";
        int i = 0;
        int Salida = 0;
        try {
            // Rs = Sql.Select("select * from pg_user where usename <> 'postgres'");
            Query = "select u.usuario,p.rut,cc.ccosto ccosto_pcc, u.nivel\n"
                    + "                from personal p\n"
                    + "                left join pacceso a on p.rut=a.rut \n"
                    + "                left join personal_ccostos cc on p.rut=cc.rut\n"
                    + "                left join usuario u on u.usuario = p.usuario\n"
                    + "                  WHERE u.usuario ='" + Usu.trim() + "'";
            Rs = Sql.Select(Query);

            if (Sql.GetRowCount() == 0) {
                Toolkit.getDefaultToolkit().beep();
                fmMain.Mensaje("No existe Usuario");
                Salida = 0;
            }

            if (Rs.next()) {
                Salida = Rs.getInt("nivel");
                ccosto_usr = Rs.getInt("ccosto_pcc");
            }

        } //try
        catch (Exception e) {
            System.out.println(e.getMessage());
        } //catch 
        finally {
            Sql.Close();
        } //Finally        

        return Salida;
    }

    public void PestanaProducto(String Codigo) {
        pfProductos Pro = new pfProductos();
        //Pro.setOpaque(false);

        pnPestanas.addTab("Nuevo Producto", Pro);

        PanelTab btc = new PanelTab(pnPestanas, 0);
        btc.setBorder(null);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Pro), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);

        Pro.txSku.requestFocus();
        if (!Codigo.isEmpty()) {
            Pro.CargaProducto(Codigo);
        }
    }
//-----------------------------------------------------------------------------
    private void AbrirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirClienteActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 5 && ccosto_usr != 3)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------   

        pfClientes Cli = new pfClientes();
//        Cli.setOpaque(false);
        pnPestanas.addTab("Nuevo Cliente", Cli);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Cli), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_AbrirClienteActionPerformed

    private void AbrirProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirProveedorActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------        

        pfProveedores Prv = new pfProveedores();
//        Prv.setOpaque(false);
        pnPestanas.addTab("Nuevo Proveedor", Prv);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Prv), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
        Prv.txRut.requestFocus();
    }//GEN-LAST:event_AbrirProveedorActionPerformed

    private void BuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarClienteActionPerformed
        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area    = 90
         Supervisores  = 80
         Normal        = 70
         Normal Vtas   = 71
         Visita        = 60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */

        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 5)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------        

        jdBuscarCliPrv BPC = new jdBuscarCliPrv(this, true);
        BPC.setLocationRelativeTo(null);
        BPC.setDefaultCloseOperation(BPC.DISPOSE_ON_CLOSE);
        BPC.setTitle("Buscar Cliente");
        BPC.SetTipo(0);
        BPC.setVisible(true);


    }//GEN-LAST:event_BuscarClienteActionPerformed

    private void OCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OCPActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area    = 90
         Supervisores  = 80
         Normal        =  70
         Normal Vtas   =  71
         Visita        = 60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------        

        pfOCProveedor PrvOC = new pfOCProveedor();
//        PrvOC.setOpaque(false);
        pnPestanas.addTab("OC Proveedor         ", PrvOC);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(PrvOC), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);

    }//GEN-LAST:event_OCPActionPerformed

    private void mnuControlInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuControlInventarioActionPerformed
        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area    = 90
         Supervisores  = 80
         Normal        = 70
         Normal Vtas   = 71
         Visita        = 60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */

        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
    //--------------------------------------------------------------------------------------        

        //   pfControlInventario ControlInventario = new pfControlInventario();
        pfControlInventario_1 ControlInventario = new pfControlInventario_1();
//        ControlInventario.setOpaque(false);
        pnPestanas.addTab("Control de Inventario", ControlInventario);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(ControlInventario), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_mnuControlInventarioActionPerformed

    private void mnuUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuUsuariosActionPerformed

//--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area    = 90
         Supervisores  = 80
         Normal        = 70
         Normal Vtas   = 71
         Visita        = 60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
//        intNivelMnu = 100;
//        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
//        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=4) ) && (intNivelUsuario<=80)){
//            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
//                    return;
//        }
        //--------------------------------------------------------------------------------------           
        if (!fmMain.GetUsuarioConfiguracion()) {

            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;

        }

        pfUsuarios Usuarios = new pfUsuarios();
//        Usuarios.setOpaque(false);
        pnPestanas.addTab("Configuración Usuarios", Usuarios);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Usuarios), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_mnuUsuariosActionPerformed

    private void mnuDocPendientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDocPendientesActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas   =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------        

        pfPRVPendientes PrvPendientes = new pfPRVPendientes();
//        PrvPendientes.setOpaque(false);
        pnPestanas.addTab("DOCUMENTOS PENDIENTES", PrvPendientes);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(PrvPendientes), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);

    }//GEN-LAST:event_mnuDocPendientesActionPerformed

    private void FAPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FAPActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------        
        pfFAProveedor FAP = new pfFAProveedor();
//        FAP.setOpaque(false);
        pnPestanas.addTab("Factura de Proveedor", FAP);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(FAP), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_FAPActionPerformed

    private void ReporteOCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReporteOCPActionPerformed
        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */

        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------        
        pfOCPReporte repOCP = new pfOCPReporte();
//        repOCP.setOpaque(false);
        pnPestanas.addTab("ORDENES DE COMPRA PROVEEDOR", repOCP);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(repOCP), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_ReporteOCPActionPerformed

    private void mnuPagosPRVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPagosPRVActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------        

        pfReportePagosPrv repPagosPRV = new pfReportePagosPrv();
//        repPagosPRV.setOpaque(false);
        pnPestanas.addTab("Pago Proveedores", repPagosPRV);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(repPagosPRV), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_mnuPagosPRVActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------        

        pfNCPProveedor NCP = new pfNCPProveedor();

////        NCP.setOpaque(false);
        pnPestanas.addTab("NC Proveedor", NCP);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(NCP), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed

        pfAplicaNCPDescuento NCP = new pfAplicaNCPDescuento();
//        NCP.setOpaque(false);
        pnPestanas.addTab("Aplicar NCP", NCP);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(NCP), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void MnuCobrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuCobrosActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 3)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------    

//        if(UsuarioCobranza){
        pfCLI_EstadoCXC CxC = new pfCLI_EstadoCXC();
//            CxC.setOpaque(false);
        pnPestanas.addTab("Cuentas por Cobrar", CxC);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(CxC), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
        //      }

    }//GEN-LAST:event_MnuCobrosActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 4)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------  

        pfEstadoCheques EstadoCheque = new pfEstadoCheques();
//        EstadoCheque.setOpaque(false);
        pnPestanas.addTab("Cartola de Cheques", EstadoCheque);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(EstadoCheque), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);

    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 4)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------  

        pfCheques Cheques = new pfCheques();
//        Cheques.setOpaque(false);
        pnPestanas.addTab("Cartola de Cheques", Cheques);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Cheques), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 3)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------    

//if(UsuarioCobranza){
        pfClientesMorosos Morosos = new pfClientesMorosos();
//            Morosos.setOpaque(false);
        pnPestanas.addTab("Clientes Morosos", Morosos);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Morosos), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
        //}

    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        System.exit(1);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 3)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------   	

//if(GetUsuarioAdministrador()){
        pfCXC_Resultados cxcr = new pfCXC_Resultados();
        pnPestanas.addTab("Parametros", cxcr);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(cxcr), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
//        }    
//        else{
//            Mensaje("Usuario no autorizado");
//        }

    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed

    //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        //intNivelMnu = 80;
//        intNivelMnu = 70;
//        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (!fmMain.GetUsuarioAutorizaOcp()) {

            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;

        }

//        
//        
//        
//        
//        //if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=6) ) && (intNivelUsuario<85)){
//        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=6) ) && (intNivelUsuario<70)){
//        
//            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
//                    return;
//        }
//    //--------------------------------------------------------------------------------------       
//        if(GetUsuarioAdminOCP()){
        //OCP_Autoriza OCC = new OCP_Autoriza();
        Autorizar_OCP OCC = new Autorizar_OCP();
//            OCC.setOpaque(false);
        pnPestanas.addTab("Autoriza OCP", OCC);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(OCC), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
//        }
//        else{
//               fmMain.Mensaje("Usuario no autorizado");
//        }


    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 4)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------  

//        if(GetUsuarioAdministrador()){
        pfBco_Cartolas BcoCartola = new pfBco_Cartolas();
//            BcoCartola.setOpaque(false);
        pnPestanas.addTab("Cartolas Bancarias", BcoCartola);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(BcoCartola), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
//        }
//        else{
//               fmMain.Mensaje("Usuario no autorizado");
//        }
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void mnReversaRecepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnReversaRecepActionPerformed
        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */

        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());

//if ((((intNivelMnu >= intNivelUsuario ) && (!fmMain.UsuarioAtorizaOCP )) || (ccosto_usr!=6) ) && (intNivelUsuario<=80)  ){    
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 6)) && (intNivelUsuario <= 80)) {

            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------       

//if(GetUsuarioAjuste()){
        pfPrv_ReversoRecepcion Reverso = new pfPrv_ReversoRecepcion();
//            Reverso.setOpaque(false);
        pnPestanas.addTab("Reverso Recepción", Reverso);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Reverso), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
//        }    
//        else{
//            Mensaje("Usuario no autorizado");
//        }

    }//GEN-LAST:event_mnReversaRecepActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        jdCambioClave Clave = new jdCambioClave(this, true);
        Clave.setLocationRelativeTo(null);
        Clave.setDefaultCloseOperation(Clave.DISPOSE_ON_CLOSE);
        Clave.setTitle("Cambiar Mi Clave");
        Clave.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 100;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 4)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------           

//if(GetUsuarioAdministrador()){
        pfAdminParametros Admin = new pfAdminParametros();
//            Admin.setOpaque(false);
        pnPestanas.addTab("Parametros", Admin);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Admin), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
//        }    
//        else{
//            Mensaje("Usuario no autorizado");
//        }
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 4)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------  

//        if(GetUsuarioAdministrador()){
        pfConta_PlandeCuentas Plan = new pfConta_PlandeCuentas();

        pnPestanas.addTab("Plan de Cuentas Contables", Plan);

        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Plan), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
        pnPestanas.setBackgroundAt(pnPestanas.getTabCount() - 1, new Color(139, 215, 116));
        pnPestanas.repaint();
//        }    
//        else{
//            Mensaje("Usuario no autorizado");
//        }
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 4)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------   

//        if(GetUsuarioAdministrador()){
        pfConta_Movimientos Plan = new pfConta_Movimientos();
//            Plan.setOpaque(false);
        pnPestanas.addTab("Libro Diario", Plan);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Plan), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
//        }    
//        else{
//            Mensaje("Usuario no autorizado");
//        }
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 4)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------   

//        if(GetUsuarioAdministrador()){
        pfConta_Mayor Mayor = new pfConta_Mayor();
        pnPestanas.addTab("Libro Mayor", Mayor);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Mayor), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
//        }    
//        else{
//            Mensaje("Usuario no autorizado");
//        }
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 4)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------  

//        if(GetUsuarioAdministrador()){
        pfBco_Mantenedor BcoMan = new pfBco_Mantenedor();
        pnPestanas.addTab("Mantenedor de Bancos", BcoMan);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(BcoMan), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
//        }    
//        else{
//            Mensaje("Usuario no autorizado");
//        }
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
//--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */

        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 3)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------  

//       if(GetUsuarioCobranza()){
        pfCXC_CartolaAbonos Abonos = new pfCXC_CartolaAbonos();
        pnPestanas.addTab("Abonos Recibidos", Abonos);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Abonos), btc); ///
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
//        }    
//        else{
//            Mensaje("Usuario no autorizado");
//        } // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem25ActionPerformed

    private void jMenuItem27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem27ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 4)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------  

//if(GetUsuarioAdministrador()){
        pfPrv_CargosRecibidos Concilia = new pfPrv_CargosRecibidos();
        pnPestanas.addTab("Cargos Recibidos", Concilia);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Concilia), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
//        }    
//        else{
//            Mensaje("Usuario no autorizado");
//        }
    }//GEN-LAST:event_jMenuItem27ActionPerformed

    private void jMenuItem28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem28ActionPerformed
        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */

//        intNivelMnu = 80;
//        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
//        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=4) ) && (intNivelUsuario<=80)){
//            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
//                    return;
//        }
        //--------------------------------------------------------------------------------------   
        //if(GetUsuarioGastos()){
        pfGastos Gastos = new pfGastos();
        pnPestanas.addTab("Ingreso de Gastos", Gastos);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Gastos), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
//        }    
//        else{
//            Mensaje("Usuario no autorizado");
//        }
    }//GEN-LAST:event_jMenuItem28ActionPerformed

    private void jMenuItem29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem29ActionPerformed
        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */

        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 4)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
    //--------------------------------------------------------------------------------------           

        //if(GetUsuarioGastos() || GetUsuarioAdministrador()){
        pfGastosConfig Gastos = new pfGastosConfig();
        pnPestanas.addTab("Configuración de Gastos", Gastos);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Gastos), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
//        }    
//        else{
//            Mensaje("Usuario no autorizado");
//        }
    }//GEN-LAST:event_jMenuItem29ActionPerformed

    private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem30ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 4)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
    //--------------------------------------------------------------------------------------   

        //if(GetUsuarioAdministrador()){
        pfGastosRendicion Gastos = new pfGastosRendicion();
        pnPestanas.addTab("Rendiciones", Gastos);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Gastos), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
//        }    
//        else{
//            Mensaje("Usuario no autorizado");
//        }
    }//GEN-LAST:event_jMenuItem30ActionPerformed

    private void StockProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StockProductoActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 7)) && (intNivelUsuario <= 70)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------         

//if(GetUsuarioTransforma()){
        pfTransformacion Trans = new pfTransformacion();
        pnPestanas.addTab("Transformación", Trans);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Trans), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
//        }
//        else{
//            fmMain.Mensaje("Usuario no autorizado");
//        }

    }//GEN-LAST:event_StockProductoActionPerformed

    private void AjustedeStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjustedeStockActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador =  100
         Admin Area     =  90
         Supervisores   =  80
         Normal         =  70
         Normal Vtas    =  71
         Visita         =  60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());

        //--------------------------------------------------------------------------------------   
        pfAjusteStock AJU = new pfAjusteStock();
        pnPestanas.addTab("AJUSTE", AJU);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(AJU), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_AjustedeStockActionPerformed
    private void AbrirProductoActionPerformed(java.awt.event.ActionEvent evt) {

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());

        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------

        pfProductos Pro = new pfProductos();
        pnPestanas.addTab("Ficha Producto", Pro);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Pro), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
        Pro.txSku.requestFocus();
    }
//GEN-FIRST:event_AbrirProductoActionPerformed
//GEN-LAST:event_AbrirProductoActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 100;

        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
    //--------------------------------------------------------------------------------------

        //if(GetUsuarioAdminOCP()){
        pfOCC_AutorizaMargen Margen = new pfOCC_AutorizaMargen();
        pnPestanas.addTab("Autorizar Margenes", Margen);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Margen), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
        /*}
         else{
         Mensaje("Usuario no autorizado");
         }*/
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        pfNDBCliente NDC = new pfNDBCliente();
        //        NDC.setOpaque(false);
        pnPestanas.addTab("NOTA DE DÉBITO", NDC);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(NDC), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void mnuReporteOCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuReporteOCCActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------

        pfOCCReporte repOCC = new pfOCCReporte();
        //        repOCC.setOpaque(false);
        pnPestanas.addTab("ORDENES DE COMPRA CLIENTE", repOCC);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(repOCC), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_mnuReporteOCCActionPerformed

    private void FacturaExentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FacturaExentaActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------
        pfFACClienteExenta FAC = new pfFACClienteExenta();
        //        FAC.setOpaque(false);
        pnPestanas.addTab("FACTURA EXENTA", FAC);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(FAC), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_FacturaExentaActionPerformed

    private void NCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NCCActionPerformed
        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------

        pfNCCCliente NCC = new pfNCCCliente();
        //        NCC.setOpaque(false);
        pnPestanas.addTab("NOTA DE CRÉDITO", NCC);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(NCC), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_NCCActionPerformed

    private void FACActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FACActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------

        pfFACCliente FAC = new pfFACCliente();
        //        FAC.setOpaque(false);
        pnPestanas.addTab("FACTURA", FAC);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(FAC), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_FACActionPerformed

    private void GDCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GDCActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------

        pfGDCliente GDC = new pfGDCliente();
        //        GDC.setOpaque(false);
        pnPestanas.addTab("GUÍA DE DESPACHO", GDC);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(GDC), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_GDCActionPerformed

    private void OCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OCCActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------

        pfOCCliente OCC = new pfOCCliente();
        //        OCC.setOpaque(false);
        pnPestanas.addTab("OC Cliente", OCC);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(OCC), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
        PanEstado[pnPestanas.getTabCount() - 1] = 0;

    }//GEN-LAST:event_OCCActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        //--------------------------------------------------------------------------------------
        /*
         Valida el nivel de usuario
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.
         */

        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 4)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------
        //if(GetUsuarioGastos()){
        pfGastosSueldos Sueldos = new pfGastosSueldos();
        pnPestanas.addTab("Remuneraciones", Sueldos);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Sueldos), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
//        }    
//        else{
//            Mensaje("Usuario no autorizado");
//        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 4)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------           

//        if(GetUsuarioGastos()){
        jdCierreSueldos Cierre = new jdCierreSueldos(null, true);
        Cierre.setTitle("Cierre de Remuneraciones");
        Cierre.setLocationRelativeTo(null);
        Cierre.setVisible(true);
//        }    
//        else{
//            Mensaje("Usuario no autorizado");
//        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 4)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
    //--------------------------------------------------------------------------------------           

        //    if(GetUsuarioGastos()){
        jdHDRemuneraciones HaberDescuento = new jdHDRemuneraciones(null, true);
        HaberDescuento.setLocationRelativeTo(null);
        HaberDescuento.setVisible(true);
//        }    
//        else{
//            Mensaje("Usuario no autorizado");
//        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 4)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
    //--------------------------------------------------------------------------------------         

        // if (GetUsuarioGastos()) {
        pfActivos Activos = new pfActivos();
        pnPestanas.addTab("Ingreso de Activos", Activos);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Activos), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
//        } else {
//            Mensaje("Usuario no autorizado");
//        }        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem31ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 4)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------             

//if(GetUsuarioGastos() || GetUsuarioAdministrador()){
        pfActivosConfig Activos = new pfActivosConfig();
        pnPestanas.addTab("Configuración de Activos", Activos);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Activos), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
//        }    
//        else{
//            Mensaje("Usuario no autorizado");
//        }
    }//GEN-LAST:event_jMenuItem31ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        if (GetUsuarioGastos() || GetUsuarioAdministrador()) {
            pfActivos Activos = new pfActivos();
            pnPestanas.addTab("Configuración de Activos", Activos);
            PanelTab btc = new PanelTab(pnPestanas, 0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Activos), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
        } else {
            Mensaje("Usuario no autorizado");
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem32ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 4)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------  

//        if(GetUsuarioAdministrador()){
        pfBco_CartolasTC BcoCartola = new pfBco_CartolasTC();
//            BcoCartola.setOpaque(false);
        pnPestanas.addTab("Cartolas TC", BcoCartola);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(BcoCartola), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
//        }
//        else{
//               fmMain.Mensaje("Usuario no autorizado");
//        }
    }//GEN-LAST:event_jMenuItem32ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed

        //--------------------------------------------------------------------------------------
        /*
         Valida el nivel de usuario
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.
         */
        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 4)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------
        //if(GetUsuarioGastos() || GetUsuarioAdministrador()){
        pfPersonal Activos = new pfPersonal();
        pnPestanas.addTab("Personal Luvaly", Activos);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Activos), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
//        }    
//        else{
//            Mensaje("Usuario no autorizado");
//        }
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem33ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 3)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------  

//        if(GetUsuarioAdministrador()|| GetUsuarioCobranza()){
        pfCXC_Cartera Activos = new pfCXC_Cartera();
        pnPestanas.addTab("Cartera de Clientes", Activos);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Activos), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
//        }
//        else{
//            Mensaje("Usuario no autorizado");
//        }
    }//GEN-LAST:event_jMenuItem33ActionPerformed

    private void jMenuItem35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem35ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 4)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------          

//        if(GetUsuarioAdministrador()){
        pfBco_ConciliacionEntre ConciliaEntre = new pfBco_ConciliacionEntre();
        pnPestanas.addTab("Conciliacón Entre Cuentas", ConciliaEntre);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(ConciliaEntre), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
//        }    
//        else{
//            Mensaje("Usuario no autorizado");
//        }
    }//GEN-LAST:event_jMenuItem35ActionPerformed

    private void jMenuItem36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem36ActionPerformed
        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */

        intNivelMnu = 100;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 4)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------         

        pfF29 F29 = new pfF29();
        pnPestanas.addTab("F29", F29);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(F29), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);

    }//GEN-LAST:event_jMenuItem36ActionPerformed

    private void jMenuItem37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem37ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 100;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 3)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
    //--------------------------------------------------------------------------------------  

        // if(GetUsuarioAdministrador()){
        jdAutorizaPagos AutoPago = new jdAutorizaPagos(null, true);
        AutoPago.setTitle("Autorizacion de Pagos Clientes");
        AutoPago.setLocationRelativeTo(null);
        AutoPago.setVisible(true);

//        }    
//        else{
//            Mensaje("Usuario no autorizado");
//        }
    }//GEN-LAST:event_jMenuItem37ActionPerformed

    private void jMenuItem40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem40ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 100;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());

        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
    //--------------------------------------------------------------------------------------

        //if(GetUsuarioAdministrador()){
        pfReporteVentasFinal2 RepoVenta = new pfReporteVentasFinal2();
        pnPestanas.addTab("Reporte de Ventas", RepoVenta);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(RepoVenta), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);

//        }    
//        else{
//            Mensaje("Usuario no autorizado");
//        }
    }//GEN-LAST:event_jMenuItem40ActionPerformed

    private void jMenuItem41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem41ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 100;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------

        pfReportesMargen RepoMargen = new pfReportesMargen();

        pnPestanas.addTab("Reporte de Margen", RepoMargen);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(RepoMargen), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);

    }//GEN-LAST:event_jMenuItem41ActionPerformed

    private void jMenuItem42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem42ActionPerformed
        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */

        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 7)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------           
        pfReporteSeparacion RepoSeparacion = new pfReporteSeparacion();
        pnPestanas.addTab("Reporte Separacion", RepoSeparacion);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(RepoSeparacion), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_jMenuItem42ActionPerformed

    private void jMenuItem43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem43ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 6)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------   

        pfConvenios AdConvenio = new pfConvenios();
        pnPestanas.addTab("Crear Convenios", AdConvenio);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(AdConvenio), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);

    }//GEN-LAST:event_jMenuItem43ActionPerformed

    private void jMenuItem45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem45ActionPerformed
        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 90;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
    //--------------------------------------------------------------------------------------

        //if(GetUsuarioAdministrador()){
        pfReporteMargen_FAC_OC1 facOC = new pfReporteMargen_FAC_OC1();
        pnPestanas.addTab("OC / Facturado", facOC);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(facOC), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
//        }
//                else{
//            Mensaje("Usuario no autorizado");
//        }
    }//GEN-LAST:event_jMenuItem45ActionPerformed

    private void jMenuItem46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem46ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 3)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------       

        pfBlogCobranza1 RepCobranza = new pfBlogCobranza1();
        pnPestanas.addTab("Blog Cobranzas Clientes", RepCobranza);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(RepCobranza), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_jMenuItem46ActionPerformed

    private void jMenuItem47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem47ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || ((ccosto_usr != 5) && (ccosto_usr != 6))) && (intNivelUsuario < 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------   

        pfCCCotizaCliente cotizacli = new pfCCCotizaCliente();
        pnPestanas.addTab("Cotizacion Clientes", cotizacli);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(cotizacli), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_jMenuItem47ActionPerformed

    private void jMenuItem48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem48ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------
        //pfReporteProveedorConvenio report = new pfReporteProveedorConvenio();
        pfReporteProveedorConvenio_2 report = new pfReporteProveedorConvenio_2();
        pnPestanas.addTab("Estado Productos", report);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(report), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_jMenuItem48ActionPerformed

    private void jMenuItem49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem49ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------

        pfRepProvConv_CompraVta compraventa = new pfRepProvConv_CompraVta();
        pnPestanas.addTab("Reporte Compra-Venta", compraventa);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(compraventa), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_jMenuItem49ActionPerformed

    private void jMenuItem50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem50ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 7)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
    //--------------------------------------------------------------------------------------  

        //   if(GetUsuarioAdministrador() || GetUsuarioBodega()){
        pfReporteAuditoria ReporteAuditoria = new pfReporteAuditoria();
        pnPestanas.addTab("Reporte Auditoria", ReporteAuditoria);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(ReporteAuditoria), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
//        }
//        else{
//            Mensaje("Usuario no autorizado");
//        }
    }//GEN-LAST:event_jMenuItem50ActionPerformed

    private void jMenuItem51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem51ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 60;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------

        pfBuscaDoc buscaDoc = new pfBuscaDoc();
        pnPestanas.addTab("Buscar Documento", buscaDoc);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(buscaDoc), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_jMenuItem51ActionPerformed

    private void jMenuItem53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem53ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 7)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------  

        pfReporteDespachador RepoDespachador = new pfReporteDespachador();
        pnPestanas.addTab("Reporte Despachador", RepoDespachador);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(RepoDespachador), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_jMenuItem53ActionPerformed

    private void jMenuItem54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem54ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 100;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 7)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------  

        pfOcchPortal OP = new pfOcchPortal();
        pnPestanas.addTab("Ordenes Portal", OP);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(OP), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);

    }//GEN-LAST:event_jMenuItem54ActionPerformed

    private void jMenuItem55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem55ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
//        intNivelMnu = 70;
//        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
//        if ((((intNivelMnu > intNivelUsuario ) && (!fmMain.UsuarioBodega ))     || (ccosto_usr!=7) ) && (intNivelUsuario<=80)  ){
//            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
//                    return;
//      
        AsignaUbicacion_Producto AsUbica = new AsignaUbicacion_Producto();
        pnPestanas.addTab("Ubicacion de Productos", AsUbica);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(AsUbica), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
        AsUbica.limpia_all();

//        AsUbica.set_ubicacion(fmMain.BodegaTransito());
//        AsUbica.enter_ubicacion();

    }//GEN-LAST:event_jMenuItem55ActionPerformed

    private void jMenuItem56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem56ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
//        intNivelMnu = 100;
//        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
//        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=7) ) && (intNivelUsuario<=80)){
//            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
//                    return;
//        }
//    //--------------------------------------------------------------------------------------   
//        
//        
//        //if(GetUsuarioAdministrador() ){
//            AsignaProdMetro AsMetro= new AsignaProdMetro();
//            pnPestanas.addTab("Ingreso de Productos en Ubicacion ",  AsMetro);
//            PanelTab btc=new PanelTab(pnPestanas,0);
//            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(AsMetro), btc);
//            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
//            AsMetro.limpia_all();
//        }
//        else{
//            Mensaje("Usuario no autorizado");
//        }
    }//GEN-LAST:event_jMenuItem56ActionPerformed

    private void mnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnInventarioActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador   = 100
         Admin Area      =  90
         Supervisores    =  80
         Normal          =  70
         Normal Vtas     =  71
         Visita          =  60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        AsignaProdInvent AsMetro = new AsignaProdInvent();
        pnPestanas.addTab("Ingreso de INVENTARIO.", AsMetro);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(AsMetro), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
        AsMetro.limpia_all();

    }//GEN-LAST:event_mnInventarioActionPerformed

    private void jMenuItem58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem58ActionPerformed

//--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador  = 100
         Admin Area     =  90
         Supervisores   =  80
         Normal         =  70
         Normal Vtas    =  71
         Visita         =  60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 7)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
    //--------------------------------------------------------------------------------------          

        // if(GetUsuarioAdministrador()){
        pfInvent_Metro_Busqueda AsMetro = new pfInvent_Metro_Busqueda();
        pnPestanas.addTab("Auditoria Busqueda Folios", AsMetro);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(AsMetro), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
        //AsMetro.limpia_all();
//        }
//        else{
//            Mensaje("Usuario no autorizado");
//        }
    }//GEN-LAST:event_jMenuItem58ActionPerformed

    private void jMenuItem59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem59ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 7)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------  
        //if(GetUsuarioAdministrador()){
        //pfInvent_Metro AsMetro= new pfInvent_Metro();
        AuditoriaMetro AsMetro = new AuditoriaMetro();
        pnPestanas.addTab("Ingreso Auditoria", AsMetro);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(AsMetro), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
        //AsMetro.limpia_all();
//        }
//        else{
//            Mensaje("Usuario no autorizado");
//        }
    }//GEN-LAST:event_jMenuItem59ActionPerformed

    private void mnComprasClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnComprasClienteActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 5)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }

        //--------------------------------------------------------------------------------------        
        pf_Compras_Cliente VtaVen = new pf_Compras_Cliente();
        pnPestanas.addTab("Compras por Cliente", VtaVen);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(VtaVen), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);


    }//GEN-LAST:event_mnComprasClienteActionPerformed

    private void jMenuItem61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem61ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 90;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------
        pf_ManteCarteraClientes CartVen = new pf_ManteCarteraClientes();
        pnPestanas.addTab("Administrador Cartera Vendedor", CartVen);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(CartVen), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_jMenuItem61ActionPerformed

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 5)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------        
        pfConsulta_VendedorCartera VtaVen = new pfConsulta_VendedorCartera();
        pnPestanas.addTab("Consulta de Vendedor ", VtaVen);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(VtaVen), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);


    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void buscaFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaFacturaActionPerformed
        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 4)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------        
        pfBuscaFAP BusFap = new pfBuscaFAP();
        pnPestanas.addTab("Consulta de Vendedor ", BusFap);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(BusFap), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);

    }//GEN-LAST:event_buscaFacturaActionPerformed

    private void jMenuItem63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem63ActionPerformed
//        intNivelMnu = 70;
//        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
//        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=5) ) && (intNivelUsuario<=80)){
//            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
//                    return;
//        }
        //--------------------------------------------------------------------------------------        
        PreciosDEspacho VtaVen = new PreciosDEspacho();
        pnPestanas.addTab("Valor Despacho por Comuna", VtaVen);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(VtaVen), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);

    }//GEN-LAST:event_jMenuItem63ActionPerformed

    private void jMenuItem64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem64ActionPerformed

        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());

        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 5)) && (intNivelUsuario <= 80)) {

            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }

        pfGenerarCatalogo FAC = new pfGenerarCatalogo();

        pnPestanas.addTab("CATALOGO", FAC);
        FAC.Setea_numero();
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(FAC), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);

    }//GEN-LAST:event_jMenuItem64ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        lbcargando1.setText("Cargando.....");
        URL urlInfo = this.getClass().getResource("/Iconos/Carga2.gif");
        ImageIcon IconoInfo = new ImageIcon(urlInfo);
        lbcargando1.setIcon(IconoInfo);
        lbcargando1.setForeground(Color.red);

        Runnable miRunnable = new Runnable() {

            public void run() {

                try {

                    lbcargando1.setVisible(true);

                    ActualizaSala();

                    lbcargando1.setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        };

        Thread hilo = new Thread(miRunnable);
        hilo.start();

        miRunnable = null;


    }//GEN-LAST:event_jButton1ActionPerformed

    private void ActualizaSala() {

        ExeSql Sql = new ExeSql();
        ExeSql Sql2 = new ExeSql();

        ResultSet Rs;
        ResultSet Rs2;

        try {

            Rs = Sql.Select("select mt.sku, sum(mt.cant) as cant from mt_productos mt\n"
                    + "where (mt.ubicacion LIKE 'SAL.%' or mt.ubicacion LIKE 'LVLB2%' or mt.ubicacion LIKE '%BOD 2%'  \n"
                    + "or mt.ubicacion IN ('TRAN.1001.1')) \n"
                    + "and mt.cant > 0 \n"
                    + "group by mt.sku\n"
                    + "order by mt.sku");

            if (Sql.GetRowCount() > 0) {

                while (Rs.next()) {

                    String Sku = Rs.getString("sku");
                    int cant = Rs.getInt("cant");

                    Rs2 = Sql2.Select("select * from mt_inventario_salah \n"
                            + "where sku IN ('" + Sku.trim() + "')");

                    if (Sql2.GetRowCount() > 0) {

                        Rs2.next();

                        Sql.ExeSql("UPDATE mt_inventario_salah SET \n"
                                + "sistema = " + cant + " \n"
                                + "WHERE sku IN ('" + Sku.trim() + "')");

                    } else if (Sql2.GetRowCount() == 0) {

                        Sql.ExeSql("INSERT INTO mt_inventario_salah \n"
                                + "(sku,usuario,sistema) \n"
                                + "VALUES ('" + Sku.trim() + "','admin'," + cant + ")");
                    }

                }

                Sql.Commit();

            }

        } catch (Exception e) {
            Sql.Rollback();
            JOptionPane.showMessageDialog(null, e);
        } finally {

            Sql.Close();

        }

        BuscaAuditoriaSala();

    }

    private void BuscaAuditoriaSala() {

        ExeSql Sql = new ExeSql();
        ExeSql Sql2 = new ExeSql();
        ExeSql Sql3 = new ExeSql();

        ResultSet Rs;
        ResultSet Rs2;
        ResultSet Rs3;

        try {

            Rs = Sql.Select("select au.sku, (sum(au.diferencia)*-1) as cant from mt_auditoria_ubicaciones au\n"
                    + "where au.diferencia < 0\n"
                    + "group by au.sku\n"
                    + "order by au.sku");

            if (Sql.GetRowCount() > 0) {

                while (Rs.next()) {

                    String Sku = Rs.getString("sku");
                    int cant = Rs.getInt("cant");

                    Rs2 = Sql2.Select("select * from mt_inventario_salah \n"
                            + "where sku IN ('" + Sku.trim() + "')");

                    if (Sql2.GetRowCount() > 0) {

                        Rs2.next();

                        Sql.ExeSql("UPDATE mt_inventario_salah SET \n"
                                + "sistema =  sistema + " + cant + " \n"
                                + "WHERE sku IN ('" + Sku.trim() + "')");

                    } else if (Sql2.GetRowCount() == 0) {

                        Sql.ExeSql("INSERT INTO mt_inventario_salah \n"
                                + "(sku,usuario,sistema) \n"
                                + "VALUES ('" + Sku.trim() + "','admin'," + cant + ")");
                    }

                }

                Sql.Commit();

            }

            System.out.println("Proceso Terminado !!!");

        } catch (Exception e) {
            Sql.Rollback();
            JOptionPane.showMessageDialog(null, e);
        } finally {

            Sql.Close();

        }

    }

    public static String Regiones(String region) {

        String regionfinal = "0";

        if (region.trim().equals("1")) {

            regionfinal = "I Región";

        } else if (region.trim().equals("15")) {

            regionfinal = "XV Región";

        } else if (region.trim().equals("2")) {

            regionfinal = "II Región";

        } else if (region.trim().equals("3")) {

            regionfinal = "III Región";

        } else if (region.trim().equals("4")) {

            regionfinal = "IV Región";

        } else if (region.trim().equals("5")) {

            regionfinal = "V Región";

        } else if (region.trim().equals("13")) {

            regionfinal = "Región MP";

        } else if (region.trim().equals("6")) {

            regionfinal = "VI Región";

        } else if (region.trim().equals("7")) {

            regionfinal = "VII Región";

        } else if (region.trim().equals("16")) {

            regionfinal = "XVI Región";

        } else if (region.trim().equals("8")) {

            regionfinal = "VIII Región";

        } else if (region.trim().equals("9")) {

            regionfinal = "IX Región";

        } else if (region.trim().equals("14")) {

            regionfinal = "XIV Región";

        } else if (region.trim().equals("10")) {

            regionfinal = "X Región";

        } else if (region.trim().equals("11")) {

            regionfinal = "XI Región";

        } else if (region.trim().equals("12")) {

            regionfinal = "XII Región";

        }

        return regionfinal;

    }


    private void jMenuItem65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem65ActionPerformed

        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 6)) && (intNivelUsuario < 85)) {

            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------       

//        if(GetUsuarioAdminOCP()){
        pfCompraVenta2 fc = new pfCompraVenta2();
//            OCC.setOpaque(false);
        pnPestanas.addTab("Reporte Feria", fc);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(fc), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);


    }//GEN-LAST:event_jMenuItem65ActionPerformed

    private void jMenuItem66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem66ActionPerformed
        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 6)) && (intNivelUsuario < 85)) {

            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------       

//        if(GetUsuarioAdminOCP()){
        pfCompraValorizado fv = new pfCompraValorizado();
//            OCC.setOpaque(false);
        pnPestanas.addTab("Reporte Feria Valorizado", fv);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(fv), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_jMenuItem66ActionPerformed

    private void jMenuItem67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem67ActionPerformed
        // TODO add your handling code here:
        intNivelMnu = 85;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 5)) && (intNivelUsuario < 85)) {

            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------       

//        if(GetUsuarioAdminOCP()){
        pfReportePosiciones rp = new pfReportePosiciones();
//            OCC.setOpaque(false);
        pnPestanas.addTab(" Reporte Posición ", rp);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(rp), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_jMenuItem67ActionPerformed

    private void jMenuItem68ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem68ActionPerformed
        // TODO add your handling code here:
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 5)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------  

        pfGDCSinFactura GRE = new pfGDCSinFactura(intNivelUsuario);//Se le pasa el nivel de usuario a la clase para manejo
        pnPestanas.addTab("Reporte Guias sin Documentos", GRE);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(GRE), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_jMenuItem68ActionPerformed

    private void jMenuItem69ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem69ActionPerformed
        // TODO add your handling code here:
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 5)) && (intNivelUsuario < 70)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------       

        pfOCTransporte ot = new pfOCTransporte();
        pnPestanas.addTab("Orden de Compra Transporte", ot);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(ot), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_jMenuItem69ActionPerformed

    private void jMenuItem70ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem70ActionPerformed
        // TODO add your handling code here:
        //------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 100;

        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------

        pfAutorizaOTrasnp MargenT = new pfAutorizaOTrasnp();
        pnPestanas.addTab("Autorizar Orden Transporte", MargenT);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(MargenT), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_jMenuItem70ActionPerformed

    private void jMenuItem72ActionPerformed(java.awt.event.ActionEvent evt) {

        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());

        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 7)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------   

        pfNotaPedido notaPedido = new pfNotaPedido();
        pnPestanas.addTab("NOTA DE PEDIDO", notaPedido);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(notaPedido), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }


    private void mnAutorizaAjusteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAutorizaAjusteActionPerformed
        if (!fmMain.GetUsuarioAjuste()) {

            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }

        //--------------------------------------------------------------------------------------
        pfAutorizaAjustes Aut_Ajustes = new pfAutorizaAjustes();
        pnPestanas.addTab("Autorizar Ajustes", Aut_Ajustes);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Aut_Ajustes), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_mnAutorizaAjusteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        muestraDatos();
        ActualizaTickets();
        ActualizaTicketsGeneral();
    }//GEN-LAST:event_jButton2ActionPerformed


    private void AjusteAutorizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjusteAutorizaActionPerformed
        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());

//        if (fmMain.GetUsuario().equals("BODEGA1")){
//        
//            fmMain.Mensaje("No está autorizado!!");
//            return;
//        
//        }
        //--------------------------------------------------------------------------------------   
        pfAjusteStock_Autoriza AJU = new pfAjusteStock_Autoriza();

        pnPestanas.addTab("AJUSTE CON AUTORIZACION", AJU);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(AJU), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_AjusteAutorizaActionPerformed

    private void jMenuItem75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem75ActionPerformed

        pfModificarIngreso mod = new pfModificarIngreso();
        mod.SetUsuario(GetUsuario());
        pnPestanas.addTab("Modificar Ingreso", mod);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(mod), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_jMenuItem75ActionPerformed

    private void jMenuItem76ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem76ActionPerformed

        intNivelMnu = 100;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 3)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        } else {
            pfNCPBusqueda Nota = new pfNCPBusqueda();
            pnPestanas.addTab("Notas Débito", Nota);
            PanelTab btc = new PanelTab(pnPestanas, 0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Nota), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
        }
    }//GEN-LAST:event_jMenuItem76ActionPerformed

    private void jMenuItem78ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem78ActionPerformed

        intNivelMnu = 100;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        } else {
            pfReporteOfertas Nota = new pfReporteOfertas();
            pnPestanas.addTab("Reporte Ofertas", Nota);
            PanelTab btc = new PanelTab(pnPestanas, 0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Nota), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
        }
    }//GEN-LAST:event_jMenuItem78ActionPerformed

    private void mnAjusteStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAjusteStockActionPerformed
        pfIndicadoresInventario AsInd = new pfIndicadoresInventario();
        pnPestanas.addTab("Indicadores de INVENTARIO.", AsInd);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(AsInd), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
        //AsInd.limpia_all();
    }//GEN-LAST:event_mnAjusteStockActionPerformed

    private void jMenuItem79ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem79ActionPerformed
        // TODO add your handling code here:
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 7)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------
        pfControlNCC control = new pfControlNCC();
        pnPestanas.addTab("Control NCC", control);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(control), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_jMenuItem79ActionPerformed

    private void jMenuItem80ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem80ActionPerformed
        pfAutorizaNCC ncc = new pfAutorizaNCC();
        pnPestanas.addTab("Autoriza NCC", ncc);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(ncc), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_jMenuItem80ActionPerformed

    private void jMenuItem81ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem81ActionPerformed
        pfNCCCliente_Autoriza ncc = new pfNCCCliente_Autoriza();
        pnPestanas.addTab("Autoriza NCC", ncc);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(ncc), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_jMenuItem81ActionPerformed

    private void jMenuItem82ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem82ActionPerformed
        pfTicketsLuvaly ticket = new pfTicketsLuvaly();
        pnPestanas.addTab("Enviar Ticket", ticket);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(ticket), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_jMenuItem82ActionPerformed

    private void jMenuItem83ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem83ActionPerformed
        pfTickets ticket = new pfTickets();
        pnPestanas.addTab("Tickets Luvaly", ticket);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(ticket), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_jMenuItem83ActionPerformed

    private void jMenuItem84ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem84ActionPerformed
        pfAbrirTicket ticket = new pfAbrirTicket();
        pnPestanas.addTab("Abrir Ticket", ticket);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(ticket), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_jMenuItem84ActionPerformed

    private void btTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTicketActionPerformed
        ActualizaTickets();        // TODO add your handling code here:
    }//GEN-LAST:event_btTicketActionPerformed

    private void jMenuItem85ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem85ActionPerformed

        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());

        if (intNivelMnu > intNivelUsuario) {

            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------

        pfProductos_Econa Pro = new pfProductos_Econa();
        pnPestanas.addTab("Ficha Producto Econa", Pro);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Pro), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
        Pro.txSku.requestFocus();
    }//GEN-LAST:event_jMenuItem85ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ActualizaTickets();
        ActualizaTicketsGeneral();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem86ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem86ActionPerformed

        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());

        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------

        pfCargaProductosPortal CargaPro = new pfCargaProductosPortal();
        pnPestanas.addTab("Carga Productos al Portal", CargaPro);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(CargaPro), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);


    }//GEN-LAST:event_jMenuItem86ActionPerformed

    private void jMenuItem89ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem89ActionPerformed
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());

        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------

        pfFacturasACEPTA CargaFac = new pfFacturasACEPTA();
        pnPestanas.addTab("Carga Documentos de ACEPTA", CargaFac);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(CargaFac), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_jMenuItem89ActionPerformed

    private void jMenuItem88ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem88ActionPerformed
        jdMultaAutoriza PagaMulta = new jdMultaAutoriza(null, true);

        PagaMulta.setLocationRelativeTo(null);
        PagaMulta.setVisible(true);
        PagaMulta.setTitle("Pagar con Multa");
    }//GEN-LAST:event_jMenuItem88ActionPerformed

    private void jMenuItem90ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem90ActionPerformed

        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());

        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------

        pfFechaVencimiento FecVenc = new pfFechaVencimiento();
        pnPestanas.addTab("Fecha Vencimiento Productos", FecVenc);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(FecVenc), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);


    }//GEN-LAST:event_jMenuItem90ActionPerformed

    private void jMenuItem91ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem91ActionPerformed

        pfIndicadoresVencimiento Ivenc = new pfIndicadoresVencimiento();
        pnPestanas.addTab("Ajuste Fechas de Vencimiento", Ivenc);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Ivenc), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
        //AsInd.limpia_all();

    }//GEN-LAST:event_jMenuItem91ActionPerformed

    private void jMenuItem92ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem92ActionPerformed
        pfControlAvanceInventario Avance = new pfControlAvanceInventario();
        pnPestanas.addTab("Control Avance Inventario", Avance);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Avance), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_jMenuItem92ActionPerformed

    private void jMenuItem93ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem93ActionPerformed
        pfGastoRemuneraciones GastosRem = new pfGastoRemuneraciones();
        pnPestanas.addTab("Gastos Remuneraciones", GastosRem);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(GastosRem), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_jMenuItem93ActionPerformed

    private void jMenuItem94ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem94ActionPerformed
        jdCargaLibros Libros = new jdCargaLibros(null, true);
        Libros.setLocationRelativeTo(null);
        Libros.setTitle("Carga Libros Compras y Ventas");
        Libros.setVisible(true);
    }//GEN-LAST:event_jMenuItem94ActionPerformed

    private void jMenuItem95ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem95ActionPerformed

        jdCompara Comparar = new jdCompara(null, true);
        Comparar.setLocationRelativeTo(null);
        Comparar.setTitle("Comparar Libros Compras y Ventas");
        Comparar.setVisible(true);

    }//GEN-LAST:event_jMenuItem95ActionPerformed

    private void jMenuItem96ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem96ActionPerformed

        jdCargaChilemat CargaChilemat = new jdCargaChilemat(null, true);
        CargaChilemat.setLocationRelativeTo(null);
        CargaChilemat.setTitle("Carga Vencimiento CHILEMAT");
        CargaChilemat.setVisible(true);


    }//GEN-LAST:event_jMenuItem96ActionPerformed

    private void MenuBoletasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBoletasActionPerformed

        pfBoletasGarantia Boletas = new pfBoletasGarantia();
        pnPestanas.addTab("Ingreso Boletas de Garantía", Boletas);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Boletas), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);

    }//GEN-LAST:event_MenuBoletasActionPerformed

    private void MenuHipotecariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuHipotecariosActionPerformed

        pfHipotecarios Hipotecario = new pfHipotecarios();
        pnPestanas.addTab("Créditos Hipotecarios", Hipotecario);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Hipotecario), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);


    }//GEN-LAST:event_MenuHipotecariosActionPerformed

    private void jMenuItem97ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem97ActionPerformed
        pfOCPHistorial historial = new pfOCPHistorial();
        pnPestanas.addTab("Historial OCP", historial);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(historial), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_jMenuItem97ActionPerformed

    private void OCC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OCC1ActionPerformed
        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------

        pfOCCliente_Trans OCC = new pfOCCliente_Trans();
        //        OCC.setOpaque(false);
        pnPestanas.addTab("OC Cliente", OCC);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(OCC), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
        PanEstado[pnPestanas.getTabCount() - 1] = 0;

    }//GEN-LAST:event_OCC1ActionPerformed

    private void jMenuItem98ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem98ActionPerformed
        jdFeriado AutoPago = new jdFeriado(null, true);
        AutoPago.setTitle("Feriados");
        AutoPago.setLocationRelativeTo(null);
        AutoPago.setVisible(true);

    }//GEN-LAST:event_jMenuItem98ActionPerformed

    private void BoletaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoletaClienteActionPerformed

        //--------------------------------------------------------------------------------------
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());

        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------

        pfBOLCliente BOC = new pfBOLCliente();
        //        FAC.setOpaque(false);
        pnPestanas.addTab("BOLETA", BOC);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(BOC), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);


    }//GEN-LAST:event_BoletaClienteActionPerformed

    private void NotaVentaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotaVentaClienteActionPerformed

        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------

        pfNVCliente NVC = new pfNVCliente();
        pnPestanas.addTab("NOTA DE VENTA CLIENTES", NVC);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(NVC), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);


    }//GEN-LAST:event_NotaVentaClienteActionPerformed

    private void jMenuItem99ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem99ActionPerformed
        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 4)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }

        //--------------------------------------------------------------------------------------  
        pfCli_AbonosRecibidos Concilia = new pfCli_AbonosRecibidos();
        pnPestanas.addTab("Abonos Recibidos", Concilia);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Concilia), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_jMenuItem99ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        ExeSql Sql = new ExeSql();
        ExeSql Sql2 = new ExeSql();
        ExeSql Sql3 = new ExeSql();

        ResultSet Rs;
        ResultSet Rs3;

        String Tabla = "aseo";
        String Convenio = "3";

        try {

            Rs = Sql.Select("select pv.sku from producto_valores pv\n"
                    + "where pv.minimo is null \n"
                    + "order by pv.sku");

//                 Rs = Sql.Select("select i.sku from inventario_sala i\n" +
//                                 "order by i.sku");
//                Rs = Sql.Select("select mt.sku from mt_productos mt\n" +
//                                "where (mt.ubicacion like '%SAL%' or ubicacion IN ('TRAN.1007.2'))  \n" +
//                                "group by mt.sku\n" +
//                                "order by mt.sku");
            if (Sql.GetRowCount() > 0) {

                while (Rs.next()) {

                    String SKU = Rs.getString("sku").trim();

//                        Rs3 = Sql3.Select("select count(mt.sku) existe from mt_productos mt\n" +
//                                          "where (mt.ubicacion like '%SAL%' or ubicacion IN ('TRAN.1007.2'))  \n" +
//                                          "and mt.sku IN ('"+SKU.trim()+"')");
//                         Rs3 = Sql3.Select("select count(pv.sku) existe from producto_valores pv\n" +
//                                           "where pv.sku IN ('"+SKU.trim()+"')");
//                         Rs3 = Sql3.Select("select count(i.sku) existe from inventario_sala i\n" +
//                                           "where i.sku IN ('"+SKU.trim()+"')");
//                        Rs3 = Sql3.Select("select sum(mt.cant) as stock from mt_productos mt\n" +
//                                          "where (mt.ubicacion like '%SAL%' or ubicacion IN ('TRAN.1007.2'))\n" +
//                                          "and mt.sku IN ('"+SKU.trim()+"')  \n" +
//                                          "group by mt.sku\n" +
//                                          "order by mt.sku");
                    Rs3 = Sql3.Select("select p.display from producto p \n"
                            + "where p.sku IN ('" + SKU.trim() + "')");

                    if (Sql3.GetRowCount() > 0) {

                        Rs3.next();
                        double embalaje = Rs3.getDouble("display");

                        Sql2.ExeSql("UPDATE producto_valores SET \n"
                                + "minimo = " + embalaje + " \n"
                                + "WHERE sku IN ('" + SKU.trim() + "') \n"
                                + "AND minimo is null");

                        Sql2.Commit();

                    }

                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(fmMain.class.getName()).log(Level.SEVERE, null, ex);
            Sql2.Rollback();

        } finally {

            Sql2.Close();

        }


    }//GEN-LAST:event_jButton5ActionPerformed


    private void mnFoliosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnFoliosActionPerformed

        //--------------------------------------------------------------------------------------
            /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area    = 90
         Supervisores  = 80
         Normal        = 70
         Normal Vtas   = 71
         Visita        = 60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 100;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 4)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------           

        jdFolios Folios = new jdFolios(null, true);
        Folios.setTitle("Folios");
        Folios.setLocationRelativeTo(null);
        Folios.setVisible(true);


    }//GEN-LAST:event_mnFoliosActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed


    }//GEN-LAST:event_jButton6ActionPerformed

    private void mnBalanceGralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnBalanceGralActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area    = 90
         Supervisores  = 80
         Normal        =  70
         Normal Vtas   =  71
         Visita        = 60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 100;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------        

        pfBalanceGeneral BG = new pfBalanceGeneral();
//        PrvOC.setOpaque(false);
        pnPestanas.addTab("Balance General ", BG);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(BG), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);


    }//GEN-LAST:event_mnBalanceGralActionPerformed

    private void jMenuItem57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem57ActionPerformed

         //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        //intNivelMnu = 80;
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());

        //if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=6) ) && (intNivelUsuario<85)){
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 6)) && (intNivelUsuario < 70)) {

            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------       

//        if(GetUsuarioAdminOCP()){
        //OCP_Autoriza OCC = new OCP_Autoriza();
        pfAjusteMinimos Minimos = new pfAjusteMinimos();
//            OCC.setOpaque(false);
        pnPestanas.addTab("Ajuste Minimos", Minimos);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Minimos), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
//        }
//        else{
//               fmMain.Mensaje("Usuario no autorizado");
//        }


    }//GEN-LAST:event_jMenuItem57ActionPerformed

    private void jMenuItem77ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem77ActionPerformed
//         intNivelMnu = 100;
//        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
//        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=4) ) && (intNivelUsuario<=80)){
//            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
//                    return;
//        }
//
//  //--------------------------------------------------------------------------------------  
//            pfReportePrecios RPrecios = new pfReportePrecios();
//            pnPestanas.addTab("Reporte Precios", RPrecios);
//            PanelTab btc=new PanelTab(pnPestanas,0);
//            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(RPrecios), btc);
//            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
    }//GEN-LAST:event_jMenuItem77ActionPerformed

    private void jMenuItem100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem100ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 100;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------

//        if(GetUsuarioAdministrador()){
        pfReportePrecio RepoPrecio = new pfReportePrecio();
        pnPestanas.addTab("Reporte de Precios", RepoPrecio);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(RepoPrecio), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
//        }    
//        else{
//            Mensaje("Usuario no autorizado");
//        }


    }//GEN-LAST:event_jMenuItem100ActionPerformed

    private void jMenuItem101ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem101ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Normal Vtas        =  71
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());

        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 6)) && (intNivelUsuario < 70)) {

            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------       
        Asociados_OCP ASP = new Asociados_OCP();

        pnPestanas.addTab("Productos Asociados a Proveedor", ASP);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(ASP), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);


    }//GEN-LAST:event_jMenuItem101ActionPerformed

    private void mnMercadoPublicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnMercadoPublicoActionPerformed

        intNivelMnu = 85;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());

        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 5)) && (intNivelUsuario < 85)) {

            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------       

        pfReporteMercadoPublico rpmp = new pfReporteMercadoPublico();

        pnPestanas.addTab(" Reporte Mercado Publico ", rpmp);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(rpmp), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);

        rpmp.SetUsuario(fmMain.GetUsuario().trim());

    }//GEN-LAST:event_mnMercadoPublicoActionPerformed

    private void jMenuItem60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem60ActionPerformed

        //--------------------------------------------------------------------------------------
        /*     
         Valida el nivel de usuario 
         Administrador = 100
         Admin Area     = 90
         Supervisores   = 80
         Normal        =  70
         Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */
        intNivelMnu = 100;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------

        pfReportesMargenProveedor RepoMargen = new pfReportesMargenProveedor();

        pnPestanas.addTab("Reporte de Margen", RepoMargen);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(RepoMargen), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);


    }//GEN-LAST:event_jMenuItem60ActionPerformed

    private void mnAgotadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAgotadosActionPerformed

        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------

//        if(GetUsuarioAdministrador()){
        pfReporteAgotados Agotados = new pfReporteAgotados();
        pnPestanas.addTab("Reporte de Productos Agotados", Agotados);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Agotados), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);


    }//GEN-LAST:event_mnAgotadosActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed

        intNivelMnu = 85;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());

        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 5)) && (intNivelUsuario < 85)) {

            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------       

        pfReporteLicitaciones rlic = new pfReporteLicitaciones();

        pnPestanas.addTab(" Reporte Licitaciones ", rlic);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(rlic), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);


    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem71ActionPerformed

        intNivelMnu = 85;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());

        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 5)) && (intNivelUsuario < 85)) {

            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------       

        pfReporteCompraAgil Agil = new pfReporteCompraAgil();

        pnPestanas.addTab(" Reporte Compra Agil ", Agil);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Agil), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);


    }//GEN-LAST:event_jMenuItem71ActionPerformed

    private void mnImpresorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnImpresorasActionPerformed

        intNivelMnu = 70;

        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------

        jdImpresoras Imp = new jdImpresoras(null, false);
        Imp.setLocationRelativeTo(null);
        Imp.setTitle("IMPRESORAS");
        Imp.setVisible(true);


    }//GEN-LAST:event_mnImpresorasActionPerformed

    private void mnMovUbcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnMovUbcActionPerformed

        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------

//        if(GetUsuarioAdministrador()){
        pfReporteMovUbc MovUbc = new pfReporteMovUbc();
        pnPestanas.addTab("Reporte Movimiento de Ubicaciones", MovUbc);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(MovUbc), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);


    }//GEN-LAST:event_mnMovUbcActionPerformed

    private void jMenuItem102ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem102ActionPerformed

        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 7)) && (intNivelUsuario <= 80)) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------           
        pfReporteAjustePrecio AjustePrecio = new pfReporteAjustePrecio();
        pnPestanas.addTab("Reporte Ajuste de Precios", AjustePrecio);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(AjustePrecio), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);


    }//GEN-LAST:event_jMenuItem102ActionPerformed

    private void mnEvaluacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnEvaluacionesActionPerformed

        intNivelMnu = 85;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());

        if (((intNivelMnu > intNivelUsuario) || (ccosto_usr != 5)) && (intNivelUsuario < 85)) {

            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------       

        pfEvaluacionesConvenios econv = new pfEvaluacionesConvenios();

        pnPestanas.addTab("Evaluaciones Convenios", econv);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(econv), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);


    }//GEN-LAST:event_mnEvaluacionesActionPerformed

    private void mnRecepcionadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnRecepcionadosActionPerformed

        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (intNivelMnu > intNivelUsuario) {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado");
            return;
        }
        //--------------------------------------------------------------------------------------

//        if(GetUsuarioAdministrador()){
        pfReporteRecepcionados Recepcionados = new pfReporteRecepcionados();
        pnPestanas.addTab("Reporte de Productos Recepcionados", Recepcionados);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Recepcionados), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);


    }//GEN-LAST:event_mnRecepcionadosActionPerformed

    private void mnAutorizaSkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAutorizaSkuActionPerformed

        pfAutorizaSKU sku = new pfAutorizaSKU();
        pnPestanas.addTab("Autoriza Nuevo Sku", sku);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(sku), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);


    }//GEN-LAST:event_mnAutorizaSkuActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        lbcargando.setText("Cargando.....");
        URL urlInfo = this.getClass().getResource("/Iconos/Carga2.gif");
        ImageIcon IconoInfo = new ImageIcon(urlInfo);
        lbcargando.setIcon(IconoInfo);
        lbcargando.setForeground(Color.red);

        Runnable miRunnable = new Runnable() {

            public void run() {

                try {

                    lbcargando.setVisible(true);

                    ActualizaBodega();

                    lbcargando.setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        };

        Thread hilo = new Thread(miRunnable);
        hilo.start();

        miRunnable = null;


    }//GEN-LAST:event_jButton3ActionPerformed

    private void ActualizaBodega() {

        ExeSql Sql = new ExeSql();
        ExeSql Sql2 = new ExeSql();
        ExeSql Sql3 = new ExeSql();

        ResultSet Rs;
        ResultSet Rs2;
        ResultSet Rs3;

        try {

            Rs = Sql.Select("select mt.sku, sum(mt.cant) as cant from mt_productos mt\n"
                    + "where (mt.ubicacion LIKE '%LVLB1%' or mt.ubicacion LIKE '%LVLB3%' \n"
                    + "or mt.ubicacion IN ('TRAN.1001.1','TRAN.1010.1','TRAN.1009.1','TRAN.1005.1','TRAN.1004.1','TRAN.1000.1','TRAN.10009.1'))\n"
                    + "and mt.cant > 0\n"
                    + "group by mt.sku\n"
                    + "order by mt.sku");

            if (Sql.GetRowCount() > 0) {

                while (Rs.next()) {

                    String Sku = Rs.getString("sku");
                    int cant = Rs.getInt("cant");

                    Rs2 = Sql2.Select("select * from mt_traslado_productos \n"
                            + "where sku IN ('" + Sku.trim() + "')");

                    if (Sql2.GetRowCount() > 0) {

                        Rs2.next();

                        Sql.ExeSql("UPDATE mt_traslado_productos SET \n"
                                + "sistema = " + cant + " \n"
                                + "WHERE sku IN ('" + Sku.trim() + "')");

                    } else if (Sql2.GetRowCount() == 0) {

                        Sql.ExeSql("INSERT INTO mt_traslado_productos \n"
                                + "(sku,usuario,sistema) \n"
                                + "VALUES ('" + Sku.trim() + "','admin'," + cant + ")");
                    }

                }

                Sql.Commit();

            }

        } catch (Exception e) {
            Sql.Rollback();
            JOptionPane.showMessageDialog(null, e);
        } finally {

            Sql.Close();

        }

        BuscaAuditoria();

    }

    private void BuscaAuditoria() {

        ExeSql Sql = new ExeSql();
        ExeSql Sql2 = new ExeSql();
        ExeSql Sql3 = new ExeSql();

        ResultSet Rs;
        ResultSet Rs2;
        ResultSet Rs3;

        try {

            Rs = Sql.Select("select au.sku, (sum(au.diferencia)*-1) as cant from mt_auditoria_ubicaciones au\n"
                    + "where au.diferencia < 0\n"
                    + "group by au.sku\n"
                    + "order by au.sku");

            if (Sql.GetRowCount() > 0) {

                while (Rs.next()) {

                    String Sku = Rs.getString("sku");
                    int cant = Rs.getInt("cant");

                    Rs2 = Sql2.Select("select * from mt_traslado_productos \n"
                            + "where sku IN ('" + Sku.trim() + "')");

                    if (Sql2.GetRowCount() > 0) {

                        Rs2.next();

                        Sql.ExeSql("UPDATE mt_traslado_productos SET \n"
                                + "sistema =  sistema + " + cant + " \n"
                                + "WHERE sku IN ('" + Sku.trim() + "')");

                    } else if (Sql2.GetRowCount() == 0) {

                        Sql.ExeSql("INSERT INTO mt_traslado_productos \n"
                                + "(sku,usuario,sistema) \n"
                                + "VALUES ('" + Sku.trim() + "','admin'," + cant + ")");
                    }

                }

                Sql.Commit();

            }

            System.out.println("Proceso Terminado !!!");

        } catch (Exception e) {

            Sql.Rollback();
            JOptionPane.showMessageDialog(null, e);

        } finally {

            Sql.Close();

        }

    }


    private void mnTrasladoProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnTrasladoProductosActionPerformed

        pfTrasladoProductos AsMetro = new pfTrasladoProductos();
        pnPestanas.addTab("Traslado de Productos", AsMetro);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(AsMetro), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);


    }//GEN-LAST:event_mnTrasladoProductosActionPerformed

    private void mnControlAvanceTrasladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnControlAvanceTrasladoActionPerformed

        pfControlAvanceTraslado Avance = new pfControlAvanceTraslado();
        pnPestanas.addTab("Control Avance Traslado", Avance);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Avance), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);

    }//GEN-LAST:event_mnControlAvanceTrasladoActionPerformed

    private void mnInvSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnInvSalaActionPerformed

        pfInventarioSalaH AsMetro = new pfInventarioSalaH();
        pnPestanas.addTab("Inventario Sala Huerfanos", AsMetro);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(AsMetro), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
    }//GEN-LAST:event_mnInvSalaActionPerformed

    private void mnControlAvanceInvSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnControlAvanceInvSalaActionPerformed

        pfAvanceInventarioSala Avance = new pfAvanceInventarioSala();
        pnPestanas.addTab("Control Avance Inventario SALA H", Avance);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Avance), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);

    }//GEN-LAST:event_mnControlAvanceInvSalaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fmMain().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AbrirCliente;
    private javax.swing.JMenuItem AbrirProducto;
    private javax.swing.JMenuItem AbrirProveedor;
    private javax.swing.JMenuItem AjusteAutoriza;
    private javax.swing.JMenuItem AjustedeStock;
    private javax.swing.JMenuItem BoletaCliente;
    private javax.swing.JMenuItem BuscarCliente;
    private org.jdesktop.swingx.JXMonthView Calendario;
    private javax.swing.JMenu Control;
    private javax.swing.JMenuItem FAC;
    private javax.swing.JMenuItem FAP;
    private javax.swing.JMenuItem FacturaExenta;
    private javax.swing.JMenuItem GDC;
    private javax.swing.JMenu MenuBanco;
    private javax.swing.JMenuItem MenuBoletas;
    private javax.swing.JMenuItem MenuHipotecarios;
    private javax.swing.JMenu MenuTicket;
    private javax.swing.JMenu MnuArchivo;
    private javax.swing.JMenu MnuClientes;
    public final javax.swing.JMenu MnuCobranza = new javax.swing.JMenu();
    private javax.swing.JMenuItem MnuCobros;
    private javax.swing.JMenu MnuProductos;
    private javax.swing.JMenu MnuProveedores;
    private javax.swing.JMenu MnuVentas;
    private javax.swing.JMenuItem NCC;
    private javax.swing.JMenuItem NotaVentaCliente;
    private javax.swing.JMenu NumeroTicket;
    private javax.swing.JMenu NumeroTicketGeneral;
    private javax.swing.JMenuItem OCC;
    private javax.swing.JMenuItem OCC1;
    private javax.swing.JMenuItem OCP;
    private javax.swing.JMenuItem ReporteOCP;
    private javax.swing.JMenuItem StockProducto;
    public static javax.swing.JButton btTicket;
    private javax.swing.JMenuItem buscaFactura;
    private javax.swing.JLabel fecha_version;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem100;
    private javax.swing.JMenuItem jMenuItem101;
    private javax.swing.JMenuItem jMenuItem102;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem31;
    private javax.swing.JMenuItem jMenuItem32;
    private javax.swing.JMenuItem jMenuItem33;
    private javax.swing.JMenuItem jMenuItem34;
    private javax.swing.JMenuItem jMenuItem35;
    private javax.swing.JMenuItem jMenuItem36;
    private javax.swing.JMenuItem jMenuItem37;
    private javax.swing.JMenuItem jMenuItem38;
    private javax.swing.JMenuItem jMenuItem39;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem40;
    private javax.swing.JMenuItem jMenuItem41;
    private javax.swing.JMenuItem jMenuItem42;
    private javax.swing.JMenuItem jMenuItem43;
    private javax.swing.JMenuItem jMenuItem44;
    private javax.swing.JMenuItem jMenuItem45;
    private javax.swing.JMenuItem jMenuItem46;
    private javax.swing.JMenuItem jMenuItem47;
    private javax.swing.JMenuItem jMenuItem48;
    private javax.swing.JMenuItem jMenuItem49;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem50;
    private javax.swing.JMenuItem jMenuItem51;
    private javax.swing.JMenuItem jMenuItem52;
    private javax.swing.JMenuItem jMenuItem53;
    private javax.swing.JMenuItem jMenuItem54;
    private javax.swing.JMenuItem jMenuItem55;
    private javax.swing.JMenuItem jMenuItem56;
    private javax.swing.JMenuItem jMenuItem57;
    private javax.swing.JMenuItem jMenuItem58;
    private javax.swing.JMenuItem jMenuItem59;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem60;
    private javax.swing.JMenuItem jMenuItem61;
    private javax.swing.JMenuItem jMenuItem62;
    private javax.swing.JMenuItem jMenuItem63;
    private javax.swing.JMenuItem jMenuItem64;
    private javax.swing.JMenuItem jMenuItem65;
    private javax.swing.JMenuItem jMenuItem66;
    private javax.swing.JMenuItem jMenuItem67;
    private javax.swing.JMenuItem jMenuItem68;
    private javax.swing.JMenuItem jMenuItem69;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem70;
    private javax.swing.JMenuItem jMenuItem71;
    private javax.swing.JMenuItem jMenuItem73;
    private javax.swing.JMenuItem jMenuItem74;
    private javax.swing.JMenuItem jMenuItem75;
    private javax.swing.JMenuItem jMenuItem76;
    private javax.swing.JMenuItem jMenuItem77;
    private javax.swing.JMenuItem jMenuItem78;
    private javax.swing.JMenuItem jMenuItem79;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem80;
    private javax.swing.JMenuItem jMenuItem81;
    private javax.swing.JMenuItem jMenuItem82;
    private javax.swing.JMenuItem jMenuItem83;
    private javax.swing.JMenuItem jMenuItem84;
    private javax.swing.JMenuItem jMenuItem85;
    private javax.swing.JMenuItem jMenuItem86;
    private javax.swing.JMenuItem jMenuItem88;
    private javax.swing.JMenuItem jMenuItem89;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuItem90;
    private javax.swing.JMenuItem jMenuItem91;
    private javax.swing.JMenuItem jMenuItem92;
    private javax.swing.JMenuItem jMenuItem93;
    private javax.swing.JMenuItem jMenuItem94;
    private javax.swing.JMenuItem jMenuItem95;
    private javax.swing.JMenuItem jMenuItem96;
    private javax.swing.JMenuItem jMenuItem97;
    private javax.swing.JMenuItem jMenuItem98;
    private javax.swing.JMenuItem jMenuItem99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator15;
    private javax.swing.JPopupMenu.Separator jSeparator16;
    private javax.swing.JPopupMenu.Separator jSeparator17;
    private javax.swing.JPopupMenu.Separator jSeparator18;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JLabel lbBOC;
    private javax.swing.JLabel lbFAC;
    private javax.swing.JLabel lbFEC;
    private javax.swing.JLabel lbGDC;
    private javax.swing.JLabel lbNCC;
    private javax.swing.JLabel lbNDC;
    private javax.swing.JLabel lbNombre;
    public static javax.swing.JLabel lbNovedades;
    private javax.swing.JLabel lbTituloDocumentos;
    private javax.swing.JLabel lbcargando;
    private javax.swing.JLabel lbcargando1;
    private javax.swing.JLabel lblServidor;
    private javax.swing.JMenuItem mnAgotados;
    private javax.swing.JMenuItem mnAjusteStock;
    private javax.swing.JMenuItem mnAutorizaAjuste;
    private javax.swing.JMenuItem mnAutorizaSku;
    private javax.swing.JMenuItem mnBalanceGral;
    private javax.swing.JMenuItem mnComprasCliente;
    private javax.swing.JMenuItem mnControlAvanceInvSala;
    private javax.swing.JMenuItem mnControlAvanceTraslado;
    private javax.swing.JMenuItem mnEvaluaciones;
    private javax.swing.JMenuItem mnFolios;
    private javax.swing.JMenuItem mnImpresoras;
    private javax.swing.JMenu mnIndicadoresContables;
    private javax.swing.JMenuItem mnInvSala;
    private javax.swing.JMenuItem mnInventario;
    private javax.swing.JMenuItem mnMercadoPublico;
    private javax.swing.JMenuItem mnMovUbc;
    private javax.swing.JMenuItem mnRecepcionados;
    private javax.swing.JMenuItem mnReversaRecep;
    private javax.swing.JMenuItem mnTrasladoProductos;
    private javax.swing.JMenuItem mnuControlInventario;
    private javax.swing.JMenuItem mnuDocPendientes;
    private javax.swing.JMenuItem mnuPagosPRV;
    private javax.swing.JMenuItem mnuReporteOCC;
    private javax.swing.JMenuItem mnuUsuarios;
    private javax.swing.JPanel panelDatos;
    public static javax.swing.JTabbedPane pnPestanas;
    // End of variables declaration//GEN-END:variables
}
