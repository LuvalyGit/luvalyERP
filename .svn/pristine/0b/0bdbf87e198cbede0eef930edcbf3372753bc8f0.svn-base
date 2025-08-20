package Formularios;

import Conexion.Conector;
import Conexion.ExeSql;
import Dialogos.jdAutorizaPagos;
import Dialogos.jdBuscarCliPrv;
import Dialogos.jdBuscarProductos;
import Dialogos.jdCambioClave;
import Dialogos.jdCierreSueldos;
import Dialogos.jdGuiasSinFactura;
import Dialogos.jdHDRemuneraciones;
import Dialogos.jdLogin;
import PanelForm.AsignaProdInvent;
import PanelForm.AsignaProdMetro;
import PanelForm.AsignaUbicacion;
import PanelForm.AsignaUbicacion_Producto;
import PanelForm.OCP_Autoriza;
import PanelForm.PreciosDEspacho;
import PanelForm.pfActivos;
import PanelForm.pfActivosConfig;
import PanelForm.pfAdminParametros;
import PanelForm.pfAjusteStock;
import PanelForm.pfAjusteStock_Autoriza;
import PanelForm.pfAplicaNCPDescuento; 
import PanelForm.pfAutorizaAjustes;
import PanelForm.pfAutorizaOTrasnp;
import PanelForm.pfBco_Cartolas;
import PanelForm.pfBco_CartolasTC;
import PanelForm.pfPrv_CargosRecibidos;
import PanelForm.pfBco_ConciliacionEntre;
import PanelForm.pfBco_Mantenedor;
import PanelForm.pfBlogCobranza1;
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
import PanelForm.pfControlInventario;
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
import PanelForm.pfReporteMargen;
import PanelForm.pfReporteMargen_FAC_OC1;
import PanelForm.pfReportePagosPrv;
import PanelForm.pfReporteProveedorConvenio;
import PanelForm.pfReporteSeparacion;
import PanelForm.pfReporteVentasFinal;
import PanelForm.pfTransformacion;
import PanelForm.pfBuscaDoc;
import PanelForm.pfBuscaFAP;
import PanelForm.pfCompraValorizado;
import PanelForm.pfCompraVenta2;
import PanelForm.pfConsulta_VendedorCartera;
import PanelForm.pfGenerarCatalogo;
import PanelForm.pfGuiasReporteEntrega;
import PanelForm.pfGuiasSinFactura;
import PanelForm.pfInvent_Metro;
import PanelForm.pfInvent_Metro_Busqueda;
import PanelForm.pfModificarIngreso;
import PanelForm.pfNCPBusqueda;
import PanelForm.pfOCTransporte;
import PanelForm.pfOcchPortal;
import PanelForm.pfReporteDespachador;
import PanelForm.pfReportePosiciones;
import PanelForm.pfUsuarios;
import PanelForm.pf_ManteCarteraClientes;
import PanelForm.pf_Vtas_Vendedor;
import Utilidades.PanelTab;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author DavidAlcaman
 */

public class fmMain extends javax.swing.JFrame {
    static int[] PanEstado = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};//new int[10];
    private static double Sys_IVA=0;
    private static String Sys_Decimal=".";
    private static String Sys_Miles =",";
    private static int FacNewYear=0;
    
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
    private static int UsuarioCCosto;
    private static int UsuarioId;
    private static boolean Internet;
    private static int AdministraBodega;
    public static int disc =0;
    public int intNivelMnu = 0;
    public int intNivelUsuario = 0;
    public static int ccosto_usr =0;
    public static int IntPosicionFinal =-1;
    
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
        try {
            setIconImage(new ImageIcon(getClass().getResource("/Iconos/Luvaly.png")).getImage());
        } catch (Exception e) {
        }
        System.out.println(GetUsuario());
        
//        setIconImage(new ImageIcon(getClass().getResource("../Iconos/L.png")).getImage());
        muestraDatos();
    
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
        lbTituloDocumentos = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        MnuArchivo = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        mnuUsuarios = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        MnuVentas = new javax.swing.JMenu();
        OCC = new javax.swing.JMenuItem();
        GDC = new javax.swing.JMenuItem();
        FAC = new javax.swing.JMenuItem();
        NCC = new javax.swing.JMenuItem();
        FacturaExenta = new javax.swing.JMenuItem();
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
        jMenuItem71 = new javax.swing.JMenuItem();
        jSeparator16 = new javax.swing.JPopupMenu.Separator();
        jMenuItem40 = new javax.swing.JMenuItem();
        jMenuItem41 = new javax.swing.JMenuItem();
        jMenuItem45 = new javax.swing.JMenuItem();
        jSeparator17 = new javax.swing.JPopupMenu.Separator();
        jMenuItem51 = new javax.swing.JMenuItem();
        jMenuItem60 = new javax.swing.JMenuItem();
        jMenuItem61 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenuItem63 = new javax.swing.JMenuItem();
        MnuProductos = new javax.swing.JMenu();
        AbrirProducto = new javax.swing.JMenuItem();
        jMenuItem48 = new javax.swing.JMenuItem();
        jMenuItem49 = new javax.swing.JMenuItem();
        jMenuItem67 = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        AjustedeStock = new javax.swing.JMenuItem();
        jMenuItem72 = new javax.swing.JMenuItem();
        StockProducto = new javax.swing.JMenuItem();
        jMenuItem43 = new javax.swing.JMenuItem();
        jMenuItem64 = new javax.swing.JMenuItem();
        MnuClientes = new javax.swing.JMenu();
        BuscarCliente = new javax.swing.JMenuItem();
        AbrirCliente = new javax.swing.JMenuItem();
        jMenuItem47 = new javax.swing.JMenuItem();
        MnuProveedores = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mnuControlInventario = new javax.swing.JMenuItem();
        AbrirProveedor = new javax.swing.JMenuItem();
        OCP = new javax.swing.JMenuItem();
        jMenuItem66 = new javax.swing.JMenuItem();
        jMenuItem65 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        ReporteOCP = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        buscaFactura = new javax.swing.JMenuItem();
        FAP = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        mnuPagosPRV = new javax.swing.JMenuItem();
        mnuDocPendientes = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem75 = new javax.swing.JMenuItem();
        jMenuItem76 = new javax.swing.JMenuItem();
        MnuCobros = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenuItem33 = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JPopupMenu.Separator();
        jMenuItem37 = new javax.swing.JMenuItem();
        jMenuItem46 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem32 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem35 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem29 = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        jMenuItem28 = new javax.swing.JMenuItem();
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
        jMenuItem57 = new javax.swing.JMenuItem();
        jMenuItem58 = new javax.swing.JMenuItem();
        jMenuItem59 = new javax.swing.JMenuItem();

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
        fecha_version.setText("10.10.2018");
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
        jPanel4.add(lbNovedades, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 102, 489, 198));

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
                        .addComponent(lblServidor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosLayout.createSequentialGroup()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbNCC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbFAC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbGDC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbFEC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                    .addComponent(lbNDC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addComponent(lbNDC, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbFEC, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbGDC, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbFAC, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbTituloDocumentos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTituloDocumentos.setText("DOCUMENTOS DISPONIBLES");

        jButton1.setText("jButton1");
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
                            .addComponent(Calendario, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addComponent(lbTituloDocumentos)))))
                .addGap(132, 132, 132)
                .addComponent(jButton1)
                .addContainerGap(793, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(24, 24, 24)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lbTituloDocumentos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        OCC.setText("Orden de Compra de Cliente");
        OCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OCCActionPerformed(evt);
            }
        });
        MnuVentas.add(OCC);

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
        MnuVentas.add(jSeparator8);

        jMenuItem68.setText("Reporte Guias Entrega");
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

        jMenuItem71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/ok_16.png"))); // NOI18N
        jMenuItem71.setText("Autorizacion de Ajustes");
        jMenuItem71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem71ActionPerformed(evt);
            }
        });
        MnuVentas.add(jMenuItem71);
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

        jMenuItem60.setText("Ventas- Vendedor");
        jMenuItem60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem60ActionPerformed(evt);
            }
        });
        MnuVentas.add(jMenuItem60);

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
        MnuProductos.add(jSeparator12);

        AjustedeStock.setText("Ajuste Stock");
        AjustedeStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjustedeStockActionPerformed(evt);
            }
        });
        MnuProductos.add(AjustedeStock);

        jMenuItem72.setText("Ajuste con Autorizacion");
        jMenuItem72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem72ActionPerformed(evt);
            }
        });
        MnuProductos.add(jMenuItem72);

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
        AbrirCliente.setText("Abrir Ficha");
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

        jMenuItem18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/disable16.png"))); // NOI18N
        jMenuItem18.setText("Reversar Recepción");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        MnuProveedores.add(jMenuItem18);

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

        jMenuItem46.setText("Compromisos de pago");
        jMenuItem46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem46ActionPerformed(evt);
            }
        });
        MnuCobranza.add(jMenuItem46);

        jMenuBar1.add(MnuCobranza);

        jMenu4.setText("Banco");

        jMenuItem17.setText("Mantenedor");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem17);

        jMenuItem16.setText("Cartolas");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem16);

        jMenuItem32.setText("Cartolas TC");
        jMenuItem32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem32ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem32);

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

        jMenu4.add(jMenu5);

        jMenuItem35.setText("Conciliacion Cuentas");
        jMenuItem35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem35ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem35);

        jMenuBar1.add(jMenu4);

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
        jMenuItem36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem36ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem36);

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

        jMenuItem57.setText("Inventario");
        jMenuItem57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem57ActionPerformed(evt);
            }
        });
        Control.add(jMenuItem57);

        jMenuItem58.setText("Auditoria Busqueda");
        jMenuItem58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem58ActionPerformed(evt);
            }
        });
        Control.add(jMenuItem58);

        jMenuItem59.setText("Ingreso Auditoria");
        jMenuItem59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem59ActionPerformed(evt);
            }
        });
        Control.add(jMenuItem59);

        jMenuBar1.add(Control);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
public static void SetEstado(int Pos, int Estado){
    PanEstado[Pos]=Estado;
}


public void muestraDatos(){
        
        
        this.setExtendedState(MAXIMIZED_BOTH);
        intNivelMnu = 100;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (intNivelMnu > intNivelUsuario){
                    return;
        }
        lbTituloDocumentos.setVisible(true);
        buscaFactura();
        buscaNotaCredito();
        buscaFacturaExentaCliente();
        buscaGuiaDespachoCliente();
        buscaNotaCreditoCliente();
}

public void buscaFactura(){
             //BUSCA CANTIDAD FACTURAS
         
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        int ContReg=0;
        String Query = "";
        lbFAC.setText("");
        int almFAC = 0;
        try {
                Query = "SELECT *, (hasta - numero ) AS ResultadoFAC FROM par_correlativo WHERE tipo = 'FAC'";      
                Rs = Sql.Select(Query);
                while (Rs.next()){
                    ContReg ++;
                    almFAC = Rs.getInt("ResultadoFAC");
                    if(almFAC > 20){
                    lbFAC.setText("Facturas:                                    " +Rs.getString("ResultadoFAC"));
                    lbFAC.setForeground(Color.black); 
                    }else{
                    lbFAC.setText("Facturas:                                    " +Rs.getString("ResultadoFAC"));
                    lbFAC.setForeground(Color.red); 
                    }
                }  
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"No se pueden encontrar datos");
        }finally{
            Sql.Close();
        }
}

public void buscaNotaCredito(){
     //BUSCA CANTIDAD NOTAS DE CREDITO
        
        ExeSql SqlNDC = new ExeSql();
        ResultSet RsNDC;
        int ContRegNDC=0;
        String QueryNDC = "";
        lbNDC.setText("");
        int almNDC = 0;
        try {
                QueryNDC = "SELECT *, (hasta -numero) AS ResultadoNDC FROM par_correlativo WHERE tipo = 'NDC'";      
                RsNDC = SqlNDC.Select(QueryNDC);
                while (RsNDC.next()){
                    ContRegNDC ++;
                    almNDC = RsNDC.getInt("ResultadoNDC");
                    if(almNDC > 20){
                    lbNDC.setText("Notas de Debito Cliente:         "+RsNDC.getString("ResultadoNDC"));
                    lbNDC.setForeground(Color.black);
                    }else{
                    lbNDC.setText("Notas de Debito Cliente:         "+RsNDC.getString("ResultadoNDC")); 
                    lbNDC.setForeground(Color.red);
                    }
                }  
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"No se pueden encontrar datos");
        }finally{
            SqlNDC.Close();
        }
}

public void buscaFacturaExentaCliente(){
    //BUSCA CANTIDAD FACTURA EXENTA CLIENTE
        
        ExeSql SqlFEC = new ExeSql();
        ResultSet RsFEC;
        int ContRegFEC=0;
        String QueryFEC = "";
        lbFEC.setText("");
        int almFEC = 0;
        try {
                QueryFEC = "SELECT *, (hasta - numero ) AS ResultadoFEC FROM par_correlativo WHERE tipo = 'FEC'";      
                RsFEC = SqlFEC.Select(QueryFEC);
                while (RsFEC.next()){
                    ContRegFEC ++;
                    almFEC = RsFEC.getInt("ResultadoFEC");
                    if(almFEC > 20){
                        lbFEC.setText("Facturas Exenta a Cliente:    "+RsFEC.getString("ResultadoFEC"));
                        lbFEC.setForeground(Color.black);
                }else{
                        lbFEC.setText("Facturas Exenta a Cliente:    "+RsFEC.getString("ResultadoFEC"));
                        lbFEC.setForeground(Color.red);
                    }
                }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"No se pueden encontrar datos");
        }finally{
            SqlFEC.Close();
        }
}

public void buscaGuiaDespachoCliente(){
  //BUSCA CANTIDAD GUIA DESPACHO CLIENTE
        
        ExeSql SqlGDC = new ExeSql();
        ResultSet RsGDC;
        int ContRegGDC=0;
        String QueryGDC = "";
        lbGDC.setText("");
        int almGDC = 0;
        try {
                QueryGDC = "SELECT *, (hasta - numero ) AS ResultadoGDC FROM par_correlativo WHERE tipo = 'GDC'";      
                RsGDC = SqlGDC.Select(QueryGDC);
                while (RsGDC.next()){
                    ContRegGDC ++;
                    almGDC = RsGDC.getInt("ResultadoGDC");
                    if(almGDC > 20){
                        lbGDC.setText("Guias de Despacho:                 "+RsGDC.getString("ResultadoGDC"));
                        lbGDC.setForeground(Color.black);
                    }else{
                        lbGDC.setText("Guias de Despacho:                 "+RsGDC.getString("ResultadoGDC"));
                        lbGDC.setForeground(Color.red);
                    }
                }  
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"No se pueden encontrar datos");
        }finally{
            SqlGDC.Close();
        }
}

public void buscaNotaCreditoCliente(){
      //BUSCA CANTIDAD NOTA DE CREDITO CLIENTE
        
        ExeSql SqlNCC = new ExeSql();
        ResultSet RsNCC;
        int ContRegNCC=0;
        String QueryNCC = "";
        lbNCC.setText("");
        int almNCC = 0;
        try {
                QueryNCC = "SELECT *, (hasta - numero ) AS ResultadoNCC FROM par_correlativo WHERE tipo = 'NCC'";      
                RsNCC = SqlNCC.Select(QueryNCC);
                while (RsNCC.next()){
                    ContRegNCC ++;
                    almNCC = RsNCC.getInt("ResultadoNCC");
                    if(almNCC > 20){
                        lbNCC.setText("Notas de Credito Cliente:       "+RsNCC.getString("ResultadoNCC"));
                        lbNCC.setForeground(Color.black);
                    }else{
                        lbNCC.setText("Notas de Credito Cliente:       "+RsNCC.getString("ResultadoNCC"));
                        lbNCC.setForeground(Color.red);
                    }
                }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"No se pueden encontrar datos");
        }finally{
            SqlNCC.Close();
        }
}


public static void SetUsuario(String Nombre, String Usuario,String Clave,boolean EsInternet, boolean Admin, boolean Ajuste, boolean Cobranza, boolean Gastos, boolean Transformacion,boolean AdminOCP,boolean Bodega,int CCosto,int Id, int AdminBodega){
    UsuarioNombreReal     = Nombre;
    UsuarioNombre         = Usuario;
    UsuarioClave          = Clave;

    UsuarioAdministrador    = Admin;
    UsuarioAjuste           = Ajuste;
    UsuarioCobranza         = Cobranza;
    UsuarioTransforma       = Transformacion;
    UsuarioAtorizaOCP       = AdminOCP;
    UsuarioGastos           = Gastos;
    UsuarioBodega           = Bodega;
    AdministraBodega        = AdminBodega;
    
    UsuarioCCosto           = CCosto;
    UsuarioId               = Id;
    
    Internet                = EsInternet;
    
}
public static void SetNombreUsuario(String ElNombre){
    UsuarioNombre = ElNombre;
}


public static int GetFacNewYear(){
    ResultSet Rs;
    ExeSql Sql = new ExeSql();
    try {
        Rs= Sql.Select("select fac_newyear from parsys");
        Rs.next();
        return Rs.getInt("fac_newyear");
    } catch (Exception e) {
        return 0;
    }finally{
        Sql.Close();
    }
}

public static String BodegaTransito(){
    return "TRAN.1001.1";
}
public static String BodegaTransformacion(){
    return "TRAN.1005.1";
}

public static String BodegaNCC(){
    return "TRAN.1004.1";
}

public static String BodegaOCDirecta(){
    return "TRAN.1003.1";
}

public static String BodegaNCP(){
    return "TRAN.1002.1";
}

public static String BodegaAnticipada(){
    return "TRAN.1007.1";
}
public static String BodegaNegativos(){
    return "INV.1011.2";
}
public static String BodegaPositivos(){
    return "INV.1011.1";
}


public static void ErrorUsuarioLog(String Usuario,String Error){
    ExeSql Sql = new ExeSql();
    
    try {
        Sql.ExeSql("insert into usuarios_eventos (usuario,tipo)values \n" + 
                   "('" + Usuario + "','" + Error + "')");
        Sql.Commit();
    } catch (Exception e) {
        Sql.Rollback();
    } finally {
        Sql.Close();
    }
}
public static boolean GetInternet(){
    return Internet;
}
public static String GetUsuario(){
    return UsuarioNombre;
}
public static String GetPass(){
    return UsuarioClave;
}
public static int GetEstado(int Pos){
    return PanEstado[Pos];
}
public static void DeleteEstado(int Pos){
   for(int i=Pos ; i<= 12 ; i++) {
       PanEstado[i]=PanEstado[i+1];
   }
}
public static String GetDecimal(){
    return Sys_Decimal;
}
public static String GetMiles(){
    return Sys_Miles;
}
public static double GetIva(){
    return Sys_IVA;
}
public static boolean GetUsuarioAdministrador(){
    return UsuarioAdministrador;
}
public static boolean GetUsuarioCobranza(){
    return UsuarioCobranza;
}
public static boolean GetUsuarioAjuste(){
    return UsuarioAjuste;
}

public static boolean GetUsuarioTransforma(){
    return UsuarioTransforma;
}
public static boolean GetUsuarioAdminOCP(){
    return UsuarioAtorizaOCP;
}

public static boolean GetUsuarioBodega(){
    return UsuarioBodega;
}

public static boolean GetUsuarioGastos(){
    return UsuarioGastos;
}
public static String GetCentrodeCosto(){
    return String.valueOf(UsuarioCCosto);
}
public static String GetUsuarioId(){
    return String.valueOf(UsuarioId);
}

public static int GetAdminBodega(){
    return AdministraBodega;
}



public static String GetStringDeFinal(char cara , String nombrePalabra )
{
 int j;   
 j=0;
       for(int i=nombrePalabra.length()-1; i >0 ; i-- ){
        if( nombrePalabra.charAt(i)== cara){
            j=i;
           break;
        }
      }   
     return nombrePalabra.substring(j+1).trim();
}

public static String GetStringDeInicio(char cara , String nombrePalabra )
{
 int j;   
 j=0;
       for(int i=0; i <=nombrePalabra.length() ; i++ ){
        if( nombrePalabra.charAt(i)== cara){
            j=i;
           break;
        }
      }   
     
     return nombrePalabra.substring(j+1).trim();
}


public static boolean validarRut(String rut) {

        boolean validacion = false;
        try {
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }
public static String FormatoNumeroBig(BigInteger Numero){
    DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
    simbolo.setDecimalSeparator('.');
    simbolo.setGroupingSeparator(',');
    DecimalFormat formateador = new DecimalFormat("###,##0",simbolo);
    return formateador.format(Numero);
}
public static String FormatoNumeroBigLimpio(BigInteger Numero){
    DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
    simbolo.setDecimalSeparator('.');
    simbolo.setGroupingSeparator(',');
    DecimalFormat formateador = new DecimalFormat("#0",simbolo);
    return formateador.format(Numero);
}
public static String FormatoNumero(double Numero){
    DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
    simbolo.setDecimalSeparator('.');
    simbolo.setGroupingSeparator(',');
    DecimalFormat formateador = new DecimalFormat("###,##0.00",simbolo);
    return formateador.format(Numero);
}

public static String FormatoNumeroSinDecimal(double Numero){
    DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
    simbolo.setDecimalSeparator('.');
    simbolo.setGroupingSeparator(',');
    DecimalFormat formateador = new DecimalFormat("###,##0",simbolo);
    return formateador.format(Numero);
}

public static String FormatoTotal(double Numero){
    DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
    simbolo.setDecimalSeparator('.');
    simbolo.setGroupingSeparator(',');
    DecimalFormat formateador = new DecimalFormat("###,###",simbolo);
    return formateador.format(Numero);
}
public static String SetGuardar(String Numero){
    String Retorno=Numero.replace(",", "");
    Retorno=Retorno.replace(",", "");
    Retorno=Retorno.replace("$", "");
    
    Retorno = EliminaCaracteres(Retorno,",");
    
    return Retorno;
}

 public static void Msje (String Titulo, String Mensaje, int xx , int yy){
            JOptionPane pane = new JOptionPane(Mensaje);  
            JDialog dialog = pane.createDialog(Titulo);  
            dialog.setLocation(xx, yy);  
            dialog.setVisible(true);  
 }


public static String SetGuardarEntero(String Numero){
    String Retorno=Numero.replace(",", "");
    
    Retorno=Retorno.replace(",", "");
    Retorno=Retorno.replace("$", "");
    Retorno=Retorno.replace(".", "");
    Retorno=Retorno.replace("$", "");
    
    Retorno = EliminaCaracteres(Retorno,",");
    
    return Retorno;
}
public static String EliminaCaracteres(String s_cadena, String s_caracteres)
{
  String nueva_cadena = "";
  Character caracter = null;
  boolean valido = true;
 
  /* Va recorriendo la cadena s_cadena y copia a la cadena que va a regresar,
     sólo los caracteres que no estén en la cadena s_caracteres */
  for (int i=0; i<s_cadena.length(); i++)
      {
       valido = true;
       for (int j=0; j<s_caracteres.length(); j++)
           {
            caracter = s_caracteres.charAt(j);
 
            if (s_cadena.charAt(i) == caracter)
               {
                valido = false;
                break;
               }
           }
       if (valido)
           nueva_cadena += s_cadena.charAt(i);
      }
 
  return nueva_cadena;
}
public static boolean EsLetra(java.awt.event.KeyEvent evt){
    if(evt.getKeyCode() > KeyEvent.VK_A && evt.getKeyCode() < KeyEvent.VK_Z || evt.getKeyChar()=='ñ')
        return true;
    else
        return false;
}
public static String SetString(String Texto){
    if(Texto.isEmpty() || Texto.trim().equals(""))
        return "null";
    else
        return "'" + Texto.trim() +"'";
}

public static void LimpiaGrilla(DefaultTableModel dfTm){
    while(dfTm.getRowCount()>0)
        dfTm.removeRow(0);
}
public static int OkCancel(String Mensaje){
    int result = JOptionPane.showConfirmDialog(null, Mensaje,
        "Confirmar", JOptionPane.OK_CANCEL_OPTION);
    return result;
}

public static void Mensaje(String Mensaje){
    int Pos = 0;
    if(Mensaje != null){
        Pos=Mensaje.indexOf("Where");
    if(Pos>0){
        System.out.println(Mensaje);
        Mensaje = Mensaje.substring(0, Pos);
    }
    JOptionPane.showMessageDialog(null, Mensaje);
    }
        
}

private void CargaVariablesSistema(){
    ExeSql  Sql = new ExeSql();
    try {
        ResultSet Rs= Sql.Select("select iva,decimal,fac_newyear from parsys");
        Rs.next();
        Sys_IVA = Rs.getFloat("iva")/100;
        Sys_Decimal = Rs.getString("decimal");
        FacNewYear = Rs.getInt("fac_newyear");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Carga Variables " + e);
        } finally{
        Sql.Close();
    }
    
}



public static int  trae_nivel(String Usu){
   ExeSql Sql = new ExeSql();
        ResultSet Rs;
        String Ubica="", Query="";
        int i =0;
        int Salida=0;
        try {
                // Rs = Sql.Select("select * from pg_user where usename <> 'postgres'");
                 Query = "select u.usuario,p.rut,cc.ccosto ccosto_pcc, u.nivel\n" +
"                from personal p\n" +
"                left join pacceso a on p.rut=a.rut \n" +
"                left join personal_ccostos cc on p.rut=cc.rut\n" +
"                left join usuario u on u.usuario = p.usuario\n" +
"                  WHERE u.usuario ='" + Usu.trim() +"'";
                  Rs = Sql.Select(Query );

                   if(Sql.GetRowCount()==0){  
                         Toolkit.getDefaultToolkit().beep();  
                      fmMain.Mensaje("No existe Usuario" );
                      Salida= 0;
                     }      

                 if (Rs.next()){
                     Salida= Rs.getInt("nivel");
                     ccosto_usr = Rs.getInt("ccosto_pcc");
                 }
                        
            } //try
          catch (Exception e) {
            System.out.println(e.getMessage());
           } //catch 
            finally{
            Sql.Close();
            } //Finally        
    
    return Salida;
}

   public void PestanaProducto(String Codigo){
        pfProductos Pro = new pfProductos();
        //Pro.setOpaque(false);
        
        pnPestanas.addTab("Nuevo Producto", Pro);
        
        PanelTab btc=new PanelTab(pnPestanas,0);
        btc.setBorder(null);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Pro), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
        
        Pro.txSku.requestFocus();
        if(!Codigo.isEmpty()){
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=5 && ccosto_usr!=3 ) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------   
        
        pfClientes Cli = new pfClientes();
//        Cli.setOpaque(false);
        pnPestanas.addTab("Nuevo Cliente", Cli);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Cli), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
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
        if (intNivelMnu > intNivelUsuario ){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------        
        
        pfProveedores Prv = new pfProveedores();
//        Prv.setOpaque(false);
        pnPestanas.addTab("Nuevo Proveedor", Prv);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Prv), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
        Prv.txRut.requestFocus();
    }//GEN-LAST:event_AbrirProveedorActionPerformed

    private void BuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarClienteActionPerformed
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=5) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
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
             Admin Area     = 90
             Supervisores   = 80
             Normal        =  70
             Normal Vtas        =  71
             Visita =         60
         Cada menu del sistema tendra un valor de acuerdo al nivel que quiero que acceda.        
         */    
        
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (intNivelMnu > intNivelUsuario ){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------        
        
        pfOCProveedor PrvOC = new pfOCProveedor();
//        PrvOC.setOpaque(false);
        pnPestanas.addTab("OC Proveedor         ", PrvOC);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(PrvOC), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
        
    }//GEN-LAST:event_OCPActionPerformed

    private void mnuControlInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuControlInventarioActionPerformed
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
        if (intNivelMnu > intNivelUsuario ){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------        
                
        
        
        pfControlInventario ControlInventario = new pfControlInventario();
//        ControlInventario.setOpaque(false);
        pnPestanas.addTab("Control de Inventario", ControlInventario);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(ControlInventario), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
    }//GEN-LAST:event_mnuControlInventarioActionPerformed

    private void mnuUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuUsuariosActionPerformed

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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=4) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------           
        
        
        pfUsuarios Usuarios = new pfUsuarios();
//        Usuarios.setOpaque(false);
        pnPestanas.addTab("Configuración Usuarios", Usuarios);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Usuarios), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
    }//GEN-LAST:event_mnuUsuariosActionPerformed

    private void mnuDocPendientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDocPendientesActionPerformed

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
        if (intNivelMnu > intNivelUsuario ){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------        
        
        pfPRVPendientes PrvPendientes = new pfPRVPendientes();
//        PrvPendientes.setOpaque(false);
        pnPestanas.addTab("ORDENES DE COMPRA CLIENTE", PrvPendientes);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(PrvPendientes), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
        
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
        if (intNivelMnu > intNivelUsuario ){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------        
        pfFAProveedor FAP = new pfFAProveedor();
//        FAP.setOpaque(false);
        pnPestanas.addTab("Factura de Proveedor", FAP);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(FAP), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
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
        if (intNivelMnu > intNivelUsuario ){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------        
        pfOCPReporte repOCP = new pfOCPReporte();
//        repOCP.setOpaque(false);
        pnPestanas.addTab("ORDENES DE COMPRA PROVEEDOR", repOCP);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(repOCP), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
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
        if (intNivelMnu > intNivelUsuario ){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------        
        
        pfReportePagosPrv repPagosPRV = new pfReportePagosPrv();
//        repPagosPRV.setOpaque(false);
        pnPestanas.addTab("Pago Proveedores", repPagosPRV);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(repPagosPRV), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
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
        if (intNivelMnu > intNivelUsuario ){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------        
        
        pfNCPProveedor NCP = new pfNCPProveedor();
        
////        NCP.setOpaque(false);
        pnPestanas.addTab("NC Proveedor", NCP);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(NCP), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        
        pfAplicaNCPDescuento NCP = new pfAplicaNCPDescuento();
//        NCP.setOpaque(false);
        pnPestanas.addTab("Aplicar NCP", NCP);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(NCP), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=3) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------    

//        if(UsuarioCobranza){
        
            pfCLI_EstadoCXC CxC = new pfCLI_EstadoCXC();
//            CxC.setOpaque(false);
            pnPestanas.addTab("Cuentas por Cobrar", CxC);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(CxC), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=4) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------  
        
        
        pfEstadoCheques EstadoCheque = new pfEstadoCheques();
//        EstadoCheque.setOpaque(false);
        pnPestanas.addTab("Cartola de Cheques", EstadoCheque);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(EstadoCheque), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
        
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=4) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------  
        
        
        
        pfCheques Cheques = new pfCheques();
//        Cheques.setOpaque(false);
        pnPestanas.addTab("Cartola de Cheques", Cheques);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Cheques), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=3) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------    


//if(UsuarioCobranza){
            pfClientesMorosos Morosos = new pfClientesMorosos();
//            Morosos.setOpaque(false);
            pnPestanas.addTab("Clientes Morosos", Morosos);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Morosos), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=3) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------   	




//if(GetUsuarioAdministrador()){
             pfCXC_Resultados cxcr = new pfCXC_Resultados();
            pnPestanas.addTab("Parametros", cxcr);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(cxcr), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
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

        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=6) ) && (intNivelUsuario<85)){
        
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------       

//        if(GetUsuarioAdminOCP()){
            OCP_Autoriza OCC = new OCP_Autoriza();
//            OCC.setOpaque(false);
            pnPestanas.addTab("Autoriza OCP", OCC);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(OCC), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=4) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------  
        
//        if(GetUsuarioAdministrador()){
            pfBco_Cartolas BcoCartola = new pfBco_Cartolas();
//            BcoCartola.setOpaque(false);
            pnPestanas.addTab("Cartolas Bancarias", BcoCartola);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(BcoCartola), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
//        }
//        else{
//               fmMain.Mensaje("Usuario no autorizado");
//        }
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
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

    if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=6) ) && (intNivelUsuario<=80)){
         
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------       
        

//if(GetUsuarioAjuste()){
            pfPrv_ReversoRecepcion Reverso = new pfPrv_ReversoRecepcion();
//            Reverso.setOpaque(false);
            pnPestanas.addTab("Reverso Recepción", Reverso);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Reverso), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
//        }    
//        else{
//            Mensaje("Usuario no autorizado");
//        }
            
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        jdCambioClave Clave = new jdCambioClave(this,true);
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=4) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------           
            
        
        
//if(GetUsuarioAdministrador()){
            pfAdminParametros Admin = new pfAdminParametros();
//            Admin.setOpaque(false);
            pnPestanas.addTab("Parametros", Admin);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Admin), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=4) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------  
        
        
        
        
        
//        if(GetUsuarioAdministrador()){
            pfConta_PlandeCuentas Plan = new pfConta_PlandeCuentas();

            pnPestanas.addTab("Plan de Cuentas Contables", Plan);
            
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Plan), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
            pnPestanas.setBackgroundAt(pnPestanas.getTabCount()-1, new Color(139,215,116));
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=4) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------   
        
        
//        if(GetUsuarioAdministrador()){
            pfConta_Movimientos Plan = new pfConta_Movimientos();
//            Plan.setOpaque(false);
            pnPestanas.addTab("Libro Diario", Plan);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Plan), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=4) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------   
        
        
        
//        if(GetUsuarioAdministrador()){
            pfConta_Mayor Mayor = new pfConta_Mayor();
            pnPestanas.addTab("Libro Mayor", Mayor);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Mayor), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=4) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------  
        
        
//        if(GetUsuarioAdministrador()){
           pfBco_Mantenedor BcoMan = new pfBco_Mantenedor();
            pnPestanas.addTab("Mantenedor de Bancos", BcoMan);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(BcoMan), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=3) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------  





//       if(GetUsuarioCobranza()){
            pfCXC_CartolaAbonos Abonos = new pfCXC_CartolaAbonos();
            pnPestanas.addTab("Abonos Recibidos", Abonos);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Abonos), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=4) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------  


//if(GetUsuarioAdministrador()){
            pfPrv_CargosRecibidos Concilia = new pfPrv_CargosRecibidos();
            pnPestanas.addTab("Cargos Recibidos", Concilia);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Concilia), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
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
        
        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=4) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------   
        
        //if(GetUsuarioGastos()){
            pfGastos Gastos = new pfGastos();
            pnPestanas.addTab("Ingreso de Gastos", Gastos);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Gastos), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=4) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------           
        
        
        
        //if(GetUsuarioGastos() || GetUsuarioAdministrador()){
            pfGastosConfig Gastos = new pfGastosConfig();
            pnPestanas.addTab("Configuración de Gastos", Gastos);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Gastos), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=4) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------   
        
        
        //if(GetUsuarioAdministrador()){
            pfGastosRendicion Gastos = new pfGastosRendicion();
            pnPestanas.addTab("Rendiciones", Gastos);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Gastos), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=7) ) && (intNivelUsuario<=70)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------         

//if(GetUsuarioTransforma()){
            pfTransformacion Trans = new pfTransformacion();
            pnPestanas.addTab("Transformación", Trans);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Trans), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
//        }
//        else{
//            fmMain.Mensaje("Usuario no autorizado");
//        }

    }//GEN-LAST:event_StockProductoActionPerformed

    private void AjustedeStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjustedeStockActionPerformed

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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=7) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------   
        
        pfAjusteStock AJU = new pfAjusteStock();
        //            AJU.setOpaque(false);
        pnPestanas.addTab("AJUSTE", AJU);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(AJU), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
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
        
        
        
        
        if (intNivelMnu > intNivelUsuario ){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------
        
        
        pfProductos Pro = new pfProductos();
        pnPestanas.addTab("Ficha Producto", Pro);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Pro), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
        Pro.txSku.requestFocus();
    }  
//GEN-FIRST:event_AbrirProductoActionPerformed
//GEN-LAST:event_AbrirProductoActionPerformed

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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=4) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------           
        
        //if(GetUsuarioGastos()){
            pfGastosSueldos Sueldos = new pfGastosSueldos();
            pnPestanas.addTab("Remuneraciones", Sueldos);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Sueldos), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=4) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------           
        
        
        
//        if(GetUsuarioGastos()){
            jdCierreSueldos Cierre = new jdCierreSueldos(null,true);
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=4) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------           
        
        
        
    //    if(GetUsuarioGastos()){
            jdHDRemuneraciones HaberDescuento = new jdHDRemuneraciones(null,true);
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=4) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=4) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------             
        
//if(GetUsuarioGastos() || GetUsuarioAdministrador()){
            pfActivosConfig Activos = new pfActivosConfig();
            pnPestanas.addTab("Configuración de Activos", Activos);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Activos), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
//        }    
//        else{
//            Mensaje("Usuario no autorizado");
//        }
    }//GEN-LAST:event_jMenuItem31ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        if(GetUsuarioGastos() || GetUsuarioAdministrador()){
            pfActivos Activos = new pfActivos();
            pnPestanas.addTab("Configuración de Activos", Activos);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Activos), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
        }    
        else{
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=4) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------  



//        if(GetUsuarioAdministrador()){
            pfBco_CartolasTC BcoCartola = new pfBco_CartolasTC();
//            BcoCartola.setOpaque(false);
            pnPestanas.addTab("Cartolas TC", BcoCartola);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(BcoCartola), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=4) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------             
        
        
        //if(GetUsuarioGastos() || GetUsuarioAdministrador()){
            pfPersonal Activos = new pfPersonal();
            pnPestanas.addTab("Personal Luvaly", Activos);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Activos), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=3) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------  

//        if(GetUsuarioAdministrador()|| GetUsuarioCobranza()){
            pfCXC_Cartera Activos = new pfCXC_Cartera();
            pnPestanas.addTab("Cartera de Clientes", Activos);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Activos), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=4) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------          
        
        
//        if(GetUsuarioAdministrador()){
            pfBco_ConciliacionEntre ConciliaEntre = new pfBco_ConciliacionEntre();
            pnPestanas.addTab("Conciliacón Entre Cuentas", ConciliaEntre);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(ConciliaEntre), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=4) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------         
        
        
        
        
        //if(GetUsuarioAdministrador()){
            pfF29 F29 = new pfF29();
            pnPestanas.addTab("F29", F29);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(F29), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
//        }    
//        else{
//            Mensaje("Usuario no autorizado");
//        }
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=3) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------  
        
        
       // if(GetUsuarioAdministrador()){
            jdAutorizaPagos AutoPago = new jdAutorizaPagos(null,true);
            AutoPago.setTitle("Autorizacion de Pagos Clientes");
            AutoPago.setLocationRelativeTo(null);
            AutoPago.setVisible(true);
            
//        }    
//        else{
//            Mensaje("Usuario no autorizado");
//        }
    }//GEN-LAST:event_jMenuItem37ActionPerformed

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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=7) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------           
            pfReporteSeparacion RepoSeparacion = new pfReporteSeparacion();
            pnPestanas.addTab("Reporte Separacion", RepoSeparacion);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(RepoSeparacion), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=6) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------   
        //if(GetUsuarioAdministrador()){
        pfConvenios AdConvenio = new pfConvenios();
        pnPestanas.addTab("Crear Convenios", AdConvenio);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(AdConvenio), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
//        }
//                else{
//            Mensaje("Usuario no autorizado");
//        }
    }//GEN-LAST:event_jMenuItem43ActionPerformed

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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=3) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------       
        
        
        pfBlogCobranza1 RepCobranza = new pfBlogCobranza1();
        pnPestanas.addTab("Blog Cobranzas Clientes", RepCobranza);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(RepCobranza), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
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
        if (((intNivelMnu > intNivelUsuario )|| ((ccosto_usr!=5) && (ccosto_usr!=6))) && (intNivelUsuario<80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------   
        
        pfCCCotizaCliente cotizacli = new pfCCCotizaCliente();
        pnPestanas.addTab("Cotizacion Clientes", cotizacli);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(cotizacli), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
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
        if (intNivelMnu > intNivelUsuario){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------
        pfReporteProveedorConvenio report = new pfReporteProveedorConvenio();
        pnPestanas.addTab("Estado Productos", report);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(report), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
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
        if (intNivelMnu > intNivelUsuario){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------
        
        
        pfRepProvConv_CompraVta compraventa = new pfRepProvConv_CompraVta();
        pnPestanas.addTab("Reporte Compra-Venta", compraventa);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(compraventa), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
    }//GEN-LAST:event_jMenuItem49ActionPerformed

    private void jMenuItem50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem50ActionPerformed
        // TODO add your handling code here:
        
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=7) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------  
        
     //   if(GetUsuarioAdministrador() || GetUsuarioBodega()){
         pfReporteAuditoria ReporteAuditoria = new pfReporteAuditoria();
        pnPestanas.addTab("Reporte Auditoria",  ReporteAuditoria);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(ReporteAuditoria), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
//        }
//        else{
//            Mensaje("Usuario no autorizado");
//        }
    }//GEN-LAST:event_jMenuItem50ActionPerformed

    private void jMenuItem53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem53ActionPerformed
        // TODO add your handling code here:
        
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=7) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------  
        
          pfReporteDespachador RepoDespachador = new pfReporteDespachador();
            pnPestanas.addTab("Reporte Despachador", RepoDespachador);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(RepoDespachador), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
    }//GEN-LAST:event_jMenuItem53ActionPerformed

    private void jMenuItem54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem54ActionPerformed
        // TODO add your handling code here:
        
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=7) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------  
        
        //if(GetUsuarioAdministrador() ){
            pfOcchPortal OP = new pfOcchPortal();
        pnPestanas.addTab("Ordenes Portal",  OP);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(OP), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
//        }
//        else{
//            Mensaje("Usuario no autorizado");
//        }
    }//GEN-LAST:event_jMenuItem54ActionPerformed

    private void jMenuItem55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem55ActionPerformed
        // TODO add your handling code here:
     
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
        if ((((intNivelMnu > intNivelUsuario ) && (!fmMain.UsuarioBodega ))     || (ccosto_usr!=7) ) && (intNivelUsuario<=80)  ){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------  
        
        //if(GetUsuarioAdministrador() || GetUsuarioBodega() ){
        AsignaUbicacion_Producto  AsUbica= new AsignaUbicacion_Producto();
        pnPestanas.addTab("Ubicacion de Productos",  AsUbica);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(AsUbica), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
        AsUbica.limpia_all();
         AsUbica.set_ubicacion(fmMain.BodegaTransito());
        AsUbica.enter_ubicacion();
//        }
//        else{
//            Mensaje("Usuario no autorizado");
//        }
        
    }//GEN-LAST:event_jMenuItem55ActionPerformed

    private void jMenuItem56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem56ActionPerformed
        // TODO add your handling code here:
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

    private void jMenuItem57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem57ActionPerformed
        // TODO add your handling code here:
        
                // TODO add your handling code here:
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=7) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------   

       //if(GetUsuarioAdministrador()){
        AsignaProdInvent AsMetro= new AsignaProdInvent();
        pnPestanas.addTab("Ingreso de INVENTARIO.",  AsMetro);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(AsMetro), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
        AsMetro.limpia_all();
//        }
//        else{
//            Mensaje("Usuario no autorizado");
//        }
    }//GEN-LAST:event_jMenuItem57ActionPerformed

    private void jMenuItem58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem58ActionPerformed

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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=7) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------          
        
       // if(GetUsuarioAdministrador()){
            pfInvent_Metro_Busqueda AsMetro= new pfInvent_Metro_Busqueda();
            pnPestanas.addTab("Auditoria Busqueda Folios",  AsMetro);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(AsMetro), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
            //AsMetro.limpia_all();
//        }
//        else{
//            Mensaje("Usuario no autorizado");
//        }
    }//GEN-LAST:event_jMenuItem58ActionPerformed

    private void jMenuItem59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem59ActionPerformed
        // TODO add your handling code here:
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=7) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------  
         //if(GetUsuarioAdministrador()){
            pfInvent_Metro AsMetro= new pfInvent_Metro();
            pnPestanas.addTab("Ingreso Auditoria",  AsMetro);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(AsMetro), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
            AsMetro.limpia_all();
//        }
//        else{
//            Mensaje("Usuario no autorizado");
//        }
    }//GEN-LAST:event_jMenuItem59ActionPerformed

    private void buscaFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaFacturaActionPerformed
        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=4) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------        
            pfBuscaFAP BusFap= new pfBuscaFAP();
            pnPestanas.addTab("Consulta de Vendedor ",  BusFap);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(BusFap), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
        
    }//GEN-LAST:event_buscaFacturaActionPerformed

    private void jMenuItem64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem64ActionPerformed
        // TODO add your handling code here:
        
          intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=5) ) && (intNivelUsuario<=80))
        {
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
        
        
        
        //if (fmMain.GetUsuario().equals("CRAMIREZ")|| fmMain.GetUsuario().equals("CDIAZ")   ){
          pfGenerarCatalogo FAC = new pfGenerarCatalogo();
        //        FAC.setOpaque(false);
        pnPestanas.addTab("CATALOGO", FAC);
        FAC.Setea_numero();
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(FAC), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
        //}
//        else
//        {
//            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
//                    return;
//        }
    }//GEN-LAST:event_jMenuItem64ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          //Verifica SO
        String ruta_local="";
        String carpeta = "blue5";
                    String sistema = System.getProperty("os.name").toLowerCase();
                    
                    File f = new File("");
                    if (sistema.contains("win"))
                    {
                         ruta_local = "c:/" + carpeta + "/";
                         f = new File(ruta_local.substring(0,ruta_local.length()-1));
                    }
                    else{
                          ruta_local = "/" + carpeta + "/";
                          //folder = new File(ruta_local);
                          f = new File(ruta_local);
                    }
//                    if (!folder.exists())
//                    {
//                        folder.mkdir();
//                    }
                    if(!f.isDirectory()) {
                    String newFolder = ruta_local; //cualquierCarpeta es el nombre de la Carpeta que vamos a crear
                    
                    File myNewFolder = new File(newFolder);
                    myNewFolder.mkdirs(); //creamos la carpeta
                   }
                    else
                   {
                          System.out.println("La carpeta ya estaba creada");
                   }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem65ActionPerformed
        

        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=6) ) && (intNivelUsuario<85)){
        
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------       

//        if(GetUsuarioAdminOCP()){
           
          pfCompraVenta2 fc = new pfCompraVenta2();
//            OCC.setOpaque(false);
            pnPestanas.addTab("Reporte Feria",fc);
            PanelTab btc = new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(fc), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);

        
        
    }//GEN-LAST:event_jMenuItem65ActionPerformed

    private void jMenuItem66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem66ActionPerformed
        intNivelMnu = 80;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=6) ) && (intNivelUsuario<85)){
        
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------       

//        if(GetUsuarioAdminOCP()){
           
          pfCompraValorizado fv = new pfCompraValorizado();
//            OCC.setOpaque(false);
            pnPestanas.addTab("Reporte Feria Valorizado",fv);
            PanelTab btc = new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(fv), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
    }//GEN-LAST:event_jMenuItem66ActionPerformed

    private void jMenuItem67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem67ActionPerformed
    // TODO add your handling code here:
    intNivelMnu = 85;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=5) ) && (intNivelUsuario<85)){
        
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
    //--------------------------------------------------------------------------------------       

//        if(GetUsuarioAdminOCP()){
           
          pfReportePosiciones rp = new pfReportePosiciones();
//            OCC.setOpaque(false);
            pnPestanas.addTab(" Reporte Posición ",rp);
            PanelTab btc = new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(rp), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);    
    }//GEN-LAST:event_jMenuItem67ActionPerformed


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        muestraDatos();
    }//GEN-LAST:event_jButton2ActionPerformed

/*
    private void jMenuItem72ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem72ActionPerformed
        intNivelMnu = 100;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=3) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
        else {
            pfNCPBusqueda Nota = new pfNCPBusqueda();
            pnPestanas.addTab("Notas Débito", Nota);
            PanelTab btc = new PanelTab(pnPestanas, 0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Nota), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
        }
    }//GEN-LAST:event_jMenuItem72ActionPerformed
*/
    private void jMenuItem75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem75ActionPerformed
        // TODO add your handling code here:
        
          pfModificarIngreso mod = new pfModificarIngreso();
        mod.SetUsuario(GetUsuario());
        pnPestanas.addTab("Modificar Ingreso", mod);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(mod), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
    }//GEN-LAST:event_jMenuItem75ActionPerformed

    private void jMenuItem76ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem76ActionPerformed
        // TODO add your handling code here:
               intNivelMnu = 100;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=3) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
                    return;
        }
        else {
            pfNCPBusqueda Nota = new pfNCPBusqueda();
            pnPestanas.addTab("Notas Débito", Nota);
            PanelTab btc = new PanelTab(pnPestanas, 0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Nota), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
        }
    }//GEN-LAST:event_jMenuItem76ActionPerformed

    private void jMenuItem63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem63ActionPerformed
        //        intNivelMnu = 70;
        //        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        //        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=5) ) && (intNivelUsuario<=80)){
            //            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
            //                    return;
            //        }
        //--------------------------------------------------------------------------------------
        PreciosDEspacho VtaVen= new PreciosDEspacho();
        pnPestanas.addTab("Valor Despacho por Comuna",  VtaVen);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(VtaVen), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);

    }//GEN-LAST:event_jMenuItem63ActionPerformed

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=5) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
            return;
        }
        //--------------------------------------------------------------------------------------
        pfConsulta_VendedorCartera VtaVen= new pfConsulta_VendedorCartera();
        pnPestanas.addTab("Consulta de Vendedor ",  VtaVen);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(VtaVen), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);

    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void jMenuItem61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem61ActionPerformed
        // TODO add your handling code here:
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
        if (intNivelMnu > intNivelUsuario){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
            return;
        }
        //--------------------------------------------------------------------------------------
        pf_ManteCarteraClientes CartVen= new pf_ManteCarteraClientes();
        pnPestanas.addTab("Administrador Cartera Vendedor",  CartVen);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(CartVen), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
    }//GEN-LAST:event_jMenuItem61ActionPerformed

    private void jMenuItem60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem60ActionPerformed
        // TODO add your handling code here:
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
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=5) ) && (intNivelUsuario<=80)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
            return;
        }

        //--------------------------------------------------------------------------------------
        pf_Vtas_Vendedor VtaVen= new pf_Vtas_Vendedor();
        pnPestanas.addTab("Reporte O/C  por Vendedor ",  VtaVen);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(VtaVen), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);

    }//GEN-LAST:event_jMenuItem60ActionPerformed

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
        if (intNivelMnu > intNivelUsuario){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
            return;
        }
        //--------------------------------------------------------------------------------------

        pfBuscaDoc buscaDoc = new pfBuscaDoc();
        pnPestanas.addTab("Buscar Documento",  buscaDoc);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(buscaDoc), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
    }//GEN-LAST:event_jMenuItem51ActionPerformed

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
        if (intNivelMnu > intNivelUsuario){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
            return;
        }
        //--------------------------------------------------------------------------------------

        //if(GetUsuarioAdministrador()){
            pfReporteMargen_FAC_OC1 facOC = new pfReporteMargen_FAC_OC1();
            pnPestanas.addTab("OC / Facturado", facOC);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(facOC), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
            //        }
        //                else{
            //            Mensaje("Usuario no autorizado");
            //        }
    }//GEN-LAST:event_jMenuItem45ActionPerformed

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
        if (intNivelMnu > intNivelUsuario){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
            return;
        }
        //--------------------------------------------------------------------------------------

        //        if(GetUsuarioAdministrador()){
            pfReporteMargen RepoMargen = new pfReporteMargen();
            pnPestanas.addTab("Reporte de Margen", RepoMargen);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(RepoMargen), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
            //        }
        //        else{
            //            Mensaje("Usuario no autorizado");
            //        }
    }//GEN-LAST:event_jMenuItem41ActionPerformed

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
        if (intNivelMnu > intNivelUsuario){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
            return;
        }
        //--------------------------------------------------------------------------------------

        //if(GetUsuarioAdministrador()){
            pfReporteVentasFinal RepoVenta = new pfReporteVentasFinal();
            pnPestanas.addTab("Reporte de Ventas", RepoVenta);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(RepoVenta), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);

            //        }
        //        else{
            //            Mensaje("Usuario no autorizado");
            //        }
    }//GEN-LAST:event_jMenuItem40ActionPerformed

//GEN-FIRST:event_jMenuItem71ActionPerformed
 
//GEN-LAST:event_jMenuItem71ActionPerformed

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
        if (intNivelMnu > intNivelUsuario   ){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
            return;
        }
        //--------------------------------------------------------------------------------------

        pfAutorizaOTrasnp MargenT = new pfAutorizaOTrasnp();
        pnPestanas.addTab("Autorizar Orden Transporte", MargenT);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(MargenT), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
    }//GEN-LAST:event_jMenuItem70ActionPerformed

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
        if (intNivelMnu > intNivelUsuario   ){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
            return;
        }
        //--------------------------------------------------------------------------------------

        //if(GetUsuarioAdminOCP()){
            pfOCC_AutorizaMargen Margen = new pfOCC_AutorizaMargen();
            pnPestanas.addTab("Autorizar Margenes", Margen);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Margen), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
            /*}
        else{
            Mensaje("Usuario no autorizado");
        }*/
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        pfNDBCliente NDC = new pfNDBCliente();
        //        NDC.setOpaque(false);
        pnPestanas.addTab("NOTA DE DÉBITO", NDC);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(NDC), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
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
        if (intNivelMnu > intNivelUsuario){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
            return;
        }
        //--------------------------------------------------------------------------------------

        pfOCCReporte repOCC = new pfOCCReporte();
        //        repOCC.setOpaque(false);
        pnPestanas.addTab("ORDENES DE COMPRA CLIENTE", repOCC);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(repOCC), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
    }//GEN-LAST:event_mnuReporteOCCActionPerformed

    private void jMenuItem69ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem69ActionPerformed
        // TODO add your handling code here:
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=5) ) && (intNivelUsuario<70)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
            return;
        }
        //--------------------------------------------------------------------------------------

        pfOCTransporte ot = new pfOCTransporte();
        pnPestanas.addTab("Orden de Compra Transporte",ot);
        PanelTab btc = new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(ot), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
    }//GEN-LAST:event_jMenuItem69ActionPerformed

    private void jMenuItem68ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem68ActionPerformed
        // TODO add your handling code here:
        intNivelMnu = 70;
        intNivelUsuario = fmMain.trae_nivel(fmMain.GetUsuario());
        if (((intNivelMnu > intNivelUsuario )|| (ccosto_usr!=5) ) && (intNivelUsuario<70)){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
            return;
        }
        //--------------------------------------------------------------------------------------

        pfGuiasReporteEntrega GRE = new pfGuiasReporteEntrega(intNivelUsuario);//Se le pasa el nivel de usuario a la clase para manejo
        pnPestanas.addTab("Guias Reporte Entrega", GRE);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(GRE), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
    }//GEN-LAST:event_jMenuItem68ActionPerformed

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
        if (intNivelMnu > intNivelUsuario){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
            return;
        }
        //--------------------------------------------------------------------------------------
        pfFACClienteExenta FAC = new pfFACClienteExenta();
        //        FAC.setOpaque(false);
        pnPestanas.addTab("FACTURA EXENTA", FAC);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(FAC), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
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
        if (intNivelMnu > intNivelUsuario){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
            return;
        }
        //--------------------------------------------------------------------------------------

        pfNCCCliente NCC = new pfNCCCliente();
        //        NCC.setOpaque(false);
        pnPestanas.addTab("NOTA DE CRÉDITO", NCC);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(NCC), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
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
        if (intNivelMnu > intNivelUsuario){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
            return;
        }
        //--------------------------------------------------------------------------------------

        pfFACCliente FAC = new pfFACCliente();
        //        FAC.setOpaque(false);
        pnPestanas.addTab("FACTURA", FAC);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(FAC), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
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
        if (intNivelMnu > intNivelUsuario){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
            return;
        }
        //--------------------------------------------------------------------------------------

        pfGDCliente GDC = new pfGDCliente();
        //        GDC.setOpaque(false);
        pnPestanas.addTab("GUÍA DE DESPACHO", GDC);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(GDC), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
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
        if (intNivelMnu > intNivelUsuario){
            fmMain.Mensaje("Usuario: " + fmMain.GetUsuario() + " no esta autorizado") ;
            return;
        }
        //--------------------------------------------------------------------------------------

        pfOCCliente OCC = new pfOCCliente();
        //        OCC.setOpaque(false);
        pnPestanas.addTab("OC Cliente", OCC);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(OCC), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
        PanEstado[pnPestanas.getTabCount()-1]=0;
    }//GEN-LAST:event_OCCActionPerformed


    
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
                if ("Nimbus".equals(info.getName())) {
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
    private javax.swing.JMenuItem AjustedeStock;
    private javax.swing.JMenuItem BuscarCliente;
    private org.jdesktop.swingx.JXMonthView Calendario;
    private javax.swing.JMenu Control;
    private javax.swing.JMenuItem FAC;
    private javax.swing.JMenuItem FAP;
    private javax.swing.JMenuItem FacturaExenta;
    private javax.swing.JMenuItem GDC;
    private javax.swing.JMenu MnuArchivo;
    private javax.swing.JMenu MnuClientes;
    public final javax.swing.JMenu MnuCobranza = new javax.swing.JMenu();
    private javax.swing.JMenuItem MnuCobros;
    private javax.swing.JMenu MnuProductos;
    private javax.swing.JMenu MnuProveedores;
    private javax.swing.JMenu MnuVentas;
    private javax.swing.JMenuItem NCC;
    private javax.swing.JMenuItem OCC;
    private javax.swing.JMenuItem OCP;
    private javax.swing.JMenuItem ReporteOCP;
    private javax.swing.JMenuItem StockProducto;
    private javax.swing.JMenuItem buscaFactura;
    private javax.swing.JLabel fecha_version;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
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
    private javax.swing.JMenuItem jMenuItem72;
    private javax.swing.JMenuItem jMenuItem73;
    private javax.swing.JMenuItem jMenuItem74;
    private javax.swing.JMenuItem jMenuItem75;
    private javax.swing.JMenuItem jMenuItem76;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
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
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JLabel lbFAC;
    private javax.swing.JLabel lbFEC;
    private javax.swing.JLabel lbGDC;
    private javax.swing.JLabel lbNCC;
    private javax.swing.JLabel lbNDC;
    private javax.swing.JLabel lbNombre;
    public static javax.swing.JLabel lbNovedades;
    private javax.swing.JLabel lbTituloDocumentos;
    private javax.swing.JLabel lblServidor;
    private javax.swing.JMenuItem mnuControlInventario;
    private javax.swing.JMenuItem mnuDocPendientes;
    private javax.swing.JMenuItem mnuPagosPRV;
    private javax.swing.JMenuItem mnuReporteOCC;
    private javax.swing.JMenuItem mnuUsuarios;
    private javax.swing.JPanel panelDatos;
    public static javax.swing.JTabbedPane pnPestanas;
    // End of variables declaration//GEN-END:variables
}
