/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.   
 */
package PanelForm;

import Conexion.ExeSql;
import Dialogos.jdAgregados_MP;
import Dialogos.jdHistorialConveniosCant;
import Dialogos.jdMarcasAgregados_MP;
import Dialogos.jdOC_PendientesFac;
import Dialogos.jdOfertados_MP;
import Dialogos.jd_Marcas;
import Formularios.fmMain;
import static Formularios.fmMain.pnPestanas;
import Utilidades.PanelTab;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.BorderLineStyle;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author Cdiaz
 */
public class pfReporteMercadoPublico extends javax.swing.JPanel {
    
    int id_proveedor;
    int inicio = 0;
    int elige = 0;
    String TablaConvenio = "";
    String SkuPas = "";
    String EncuentraIDMadre = "0";
    
    String Usuario = "";
    
    int TotalID = 0;
    int TotalLuv = 0;
    int TotalProdLuv = 0;
    
    public static Color DARK_GREEN = new Color(0,153,0);
    public static Color BLACK_GRAY = new Color(102,102,102);
    public static Color DARK_ORANGE = new Color(255,102,0);
        
    Calendar cal = Calendar.getInstance();
    int mesant = cal.get(Calendar.MONTH)+1;         // El Mes actual
    int anant = cal.get(Calendar.YEAR);             // El Año actual
        
    private final String mes = String.valueOf(mesant);       
    private final String agno = String.valueOf(anant);     
    
    SimpleDateFormat formatofecha =  new SimpleDateFormat("dd-MM-yyyy HH:mm");
    SimpleDateFormat formatofechacorto = new SimpleDateFormat("dd-MM-yyyy");
    
     ArrayList<ArrayList<String>> Lista  = new ArrayList<ArrayList<String>>();
    
   
    /**
     * Creates new form pfCompraVenta
     */
    public pfReporteMercadoPublico() {
        
        initComponents();
        
        CargaConvenios();
        
        cbConvenioId.setVisible(false);
        
        
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(239, 198, 46));
        
        DefaultTableCellRenderer headerRenderer2 = new DefaultTableCellRenderer();
        headerRenderer2.setBackground(new Color(0, 204, 255));
        
        DefaultTableCellRenderer headerRenderer3 = new DefaultTableCellRenderer();
        headerRenderer3.setBackground(new Color(102, 204, 0));
        
        DefaultTableCellRenderer headerRenderer4 = new DefaultTableCellRenderer();
        headerRenderer4.setBackground(new Color(255, 102, 51));  //[255,102,51]
        

//        for (int i = 0; i < Grilla.getModel().getColumnCount(); i++) {
//            Grilla.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
//        } 
        
        Grilla.getColumnModel().getColumn(5).setHeaderRenderer(headerRenderer);
        Grilla.getColumnModel().getColumn(6).setHeaderRenderer(headerRenderer);
        Grilla.getColumnModel().getColumn(7).setHeaderRenderer(headerRenderer);
        
        
        
        
        Grilla.getColumnModel().getColumn(8).setHeaderRenderer(headerRenderer2);
        Grilla.getColumnModel().getColumn(9).setHeaderRenderer(headerRenderer2);
        
        Grilla.getColumnModel().getColumn(10).setHeaderRenderer(headerRenderer3);
        Grilla.getColumnModel().getColumn(11).setHeaderRenderer(headerRenderer3);
        
        Grilla.getColumnModel().getColumn(12).setHeaderRenderer(headerRenderer4);
        Grilla.getColumnModel().getColumn(13).setHeaderRenderer(headerRenderer4);
        
        
        Grilla.getActionMap().put("copy", new AbstractAction(){  //Para copiar al portapapeles
      
           @Override
           public void actionPerformed(ActionEvent e) {
              
             String cellValue = Grilla.getModel().getValueAt(Grilla.getSelectedRow(), Grilla.getSelectedColumn()).toString();
             StringSelection stringSelection = new StringSelection(cellValue);
             Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, stringSelection);
           
           }
        });
        
        
       
        
        btHistorialNuevos.setEnabled(false);
       // btMarcasNuevas.setVisible(false);
       //btOfertar .setVisible(false);
        
    }
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        VerProductos = new javax.swing.JMenuItem();
        CopiarDesc = new javax.swing.JMenuItem();
        CopiarID = new javax.swing.JMenuItem();
        CopiarIDMADRE = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        cbConvenio = new javax.swing.JComboBox<String>();
        cbRegion = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        cbConvenioId = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        txFiltro = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Grilla = new javax.swing.JTable();
        lbTotal = new javax.swing.JLabel();
        lbTotalLuv = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbVerde = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbAzul = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbRojo = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lbGris = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbTodos = new javax.swing.JLabel();
        rbGris = new javax.swing.JRadioButton();
        rbVerde = new javax.swing.JRadioButton();
        rbAzul = new javax.swing.JRadioButton();
        rbRojo = new javax.swing.JRadioButton();
        rbTodos = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lbAmarillo = new javax.swing.JLabel();
        rbAmarillo = new javax.swing.JRadioButton();
        btExportar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbFechaActualizacion = new javax.swing.JLabel();
        btHistorialNuevos = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txFiltroMarcas = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btMarca = new javax.swing.JButton();
        btMarcasNuevas = new javax.swing.JButton();
        btOfertar = new javax.swing.JButton();
        rbCeleste = new javax.swing.JRadioButton();
        lbCeleste = new javax.swing.JLabel();
        lbTotalProd = new javax.swing.JLabel();
        btHistorial = new javax.swing.JButton();

        VerProductos.setText("Ver Productos");
        VerProductos.setToolTipText("");
        VerProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerProductosActionPerformed(evt);
            }
        });
        jPopupMenu1.add(VerProductos);

        CopiarDesc.setText("Copiar Descripción");
        CopiarDesc.setToolTipText("");
        CopiarDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopiarDescActionPerformed(evt);
            }
        });
        jPopupMenu1.add(CopiarDesc);

        CopiarID.setText("Copiar ID");
        CopiarID.setToolTipText("");
        CopiarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopiarIDActionPerformed(evt);
            }
        });
        jPopupMenu1.add(CopiarID);

        CopiarIDMADRE.setText("Copiar ID MADRE");
        CopiarIDMADRE.setToolTipText("");
        CopiarIDMADRE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopiarIDMADREActionPerformed(evt);
            }
        });
        jPopupMenu1.add(CopiarIDMADRE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Convenio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        cbConvenio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECCIONE CONVENIO PARA FILTRAR" }));
        cbConvenio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbConvenioActionPerformed(evt);
            }
        });

        cbRegion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECCIONE REGIÓN", "TARAPACÁ", "ANTOFAGASTA", "ATACAMA", "COQUIMBO", "VALPARAÍSO", "LIBERTADOR GRAL. BERNARDO OHIGGINS", "MAULE", "BIOBÍO", "ARAUCANÍA", "LOS LAGOS", "AISÉN", "MAGALLANES Y DE LA ANTÁRTICA CHILENA", "METROPOLITANA", "LOS RÍOS", "ARICA Y PARINACOTA", "REGIÓN DE ÑUBLE" }));
        cbRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRegionActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("REGION");
        jLabel1.setToolTipText("");

        cbConvenioId.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbConvenio, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbRegion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(116, 116, 116)
                        .addComponent(cbConvenioId, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbConvenioId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(cbRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel12.setText("FILTRO:");

        txFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txFiltroKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txFiltroKeyTyped(evt);
            }
        });

        Grilla.setAutoCreateRowSorter(true);
        Grilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Sku", "Producto", "Stock", "Pos. Luv", "$ Compra", "$ Venta", "% Mrg", "Primero", "% Mrg", "Segundo", "% Mrg", "Tercero", "% Mrg", "Marca", "Region", "filtro", "nuevo", "estado", "reg_hab", "ID MADRE", "NoVend", "Ofertar", "Cuarto", "% Mrg", "Quinto", "% Mrg", " OF", "filtroNoVend"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, true, true, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Grilla.setComponentPopupMenu(jPopupMenu1);
        Grilla.setDragEnabled(true);
        Grilla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GrillaMouseClicked(evt);
            }
        });
        Grilla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GrillaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                GrillaKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(Grilla);
        if (Grilla.getColumnModel().getColumnCount() > 0) {
            Grilla.getColumnModel().getColumn(0).setMaxWidth(80);
            Grilla.getColumnModel().getColumn(1).setMaxWidth(80);
            Grilla.getColumnModel().getColumn(2).setPreferredWidth(350);
            Grilla.getColumnModel().getColumn(3).setMaxWidth(50);
            Grilla.getColumnModel().getColumn(4).setMaxWidth(55);
            Grilla.getColumnModel().getColumn(5).setMaxWidth(70);
            Grilla.getColumnModel().getColumn(6).setMaxWidth(70);
            Grilla.getColumnModel().getColumn(7).setMaxWidth(50);
            Grilla.getColumnModel().getColumn(8).setMaxWidth(70);
            Grilla.getColumnModel().getColumn(9).setMaxWidth(50);
            Grilla.getColumnModel().getColumn(10).setMinWidth(0);
            Grilla.getColumnModel().getColumn(10).setPreferredWidth(0);
            Grilla.getColumnModel().getColumn(10).setMaxWidth(0);
            Grilla.getColumnModel().getColumn(11).setMinWidth(0);
            Grilla.getColumnModel().getColumn(11).setPreferredWidth(0);
            Grilla.getColumnModel().getColumn(11).setMaxWidth(0);
            Grilla.getColumnModel().getColumn(12).setMinWidth(0);
            Grilla.getColumnModel().getColumn(12).setPreferredWidth(0);
            Grilla.getColumnModel().getColumn(12).setMaxWidth(0);
            Grilla.getColumnModel().getColumn(13).setMinWidth(0);
            Grilla.getColumnModel().getColumn(13).setPreferredWidth(0);
            Grilla.getColumnModel().getColumn(13).setMaxWidth(0);
            Grilla.getColumnModel().getColumn(14).setMaxWidth(180);
            Grilla.getColumnModel().getColumn(16).setMinWidth(0);
            Grilla.getColumnModel().getColumn(16).setPreferredWidth(0);
            Grilla.getColumnModel().getColumn(16).setMaxWidth(0);
            Grilla.getColumnModel().getColumn(17).setMinWidth(0);
            Grilla.getColumnModel().getColumn(17).setPreferredWidth(0);
            Grilla.getColumnModel().getColumn(17).setMaxWidth(0);
            Grilla.getColumnModel().getColumn(18).setMinWidth(0);
            Grilla.getColumnModel().getColumn(18).setPreferredWidth(0);
            Grilla.getColumnModel().getColumn(18).setMaxWidth(0);
            Grilla.getColumnModel().getColumn(19).setMinWidth(0);
            Grilla.getColumnModel().getColumn(19).setPreferredWidth(0);
            Grilla.getColumnModel().getColumn(19).setMaxWidth(0);
            Grilla.getColumnModel().getColumn(20).setMaxWidth(80);
            Grilla.getColumnModel().getColumn(21).setMaxWidth(50);
            Grilla.getColumnModel().getColumn(22).setMaxWidth(50);
            Grilla.getColumnModel().getColumn(23).setMinWidth(0);
            Grilla.getColumnModel().getColumn(23).setPreferredWidth(0);
            Grilla.getColumnModel().getColumn(23).setMaxWidth(0);
            Grilla.getColumnModel().getColumn(24).setMinWidth(0);
            Grilla.getColumnModel().getColumn(24).setPreferredWidth(0);
            Grilla.getColumnModel().getColumn(24).setMaxWidth(0);
            Grilla.getColumnModel().getColumn(25).setMinWidth(0);
            Grilla.getColumnModel().getColumn(25).setPreferredWidth(0);
            Grilla.getColumnModel().getColumn(25).setMaxWidth(0);
            Grilla.getColumnModel().getColumn(26).setMinWidth(0);
            Grilla.getColumnModel().getColumn(26).setPreferredWidth(0);
            Grilla.getColumnModel().getColumn(26).setMaxWidth(0);
            Grilla.getColumnModel().getColumn(27).setMaxWidth(30);
            Grilla.getColumnModel().getColumn(28).setMinWidth(0);
            Grilla.getColumnModel().getColumn(28).setPreferredWidth(0);
            Grilla.getColumnModel().getColumn(28).setMaxWidth(0);
        }

        lbTotal.setText("Total ID Publicadas  : ");
        lbTotal.setToolTipText("");

        lbTotalLuv.setText("Total ID Luvaly        : ");

        jPanel3.setBackground(new java.awt.Color(0, 153, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setToolTipText("");
        jPanel3.setPreferredSize(new java.awt.Dimension(24, 16));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("ID Habilitados ");

        lbVerde.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbVerde.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbVerde.setText("0");
        lbVerde.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setBackground(new java.awt.Color(0, 51, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setPreferredSize(new java.awt.Dimension(24, 16));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("ID Deshabilitados x Stock");
        jLabel4.setToolTipText("");

        lbAzul.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbAzul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAzul.setText("0");
        lbAzul.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("ID No Comercializados ");

        lbRojo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbRojo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRojo.setText("0");
        lbRojo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel5.setBackground(new java.awt.Color(255, 0, 0));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setPreferredSize(new java.awt.Dimension(24, 16));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setPreferredSize(new java.awt.Dimension(24, 16));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("ID No Asociadas a Sku");

        lbGris.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbGris.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbGris.setText("0");
        lbGris.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Todos");

        lbTodos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbTodos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTodos.setText("0");
        lbTodos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonGroup1.add(rbGris);
        rbGris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbGrisActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbVerde);
        rbVerde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbVerdeActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbAzul);
        rbAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAzulActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbRojo);
        rbRojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbRojoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbTodos);
        rbTodos.setSelected(true);
        rbTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTodosActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(255, 255, 102));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setPreferredSize(new java.awt.Dimension(24, 16));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("NUEVOS ID");

        lbAmarillo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbAmarillo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAmarillo.setText("0");
        lbAmarillo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonGroup1.add(rbAmarillo);
        rbAmarillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAmarilloActionPerformed(evt);
            }
        });

        btExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/OCProveedor24.png"))); // NOI18N
        btExportar.setText("Exportar");
        btExportar.setToolTipText("");
        btExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExportarActionPerformed(evt);
            }
        });

        jLabel2.setText(" Fecha Actualizacion ");
        jLabel2.setToolTipText("");

        lbFechaActualizacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbFechaActualizacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFechaActualizacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbFechaActualizacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lbFechaActualizacionKeyPressed(evt);
            }
        });

        btHistorialNuevos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btHistorialNuevos.setText("Historial Nuevos");
        btHistorialNuevos.setToolTipText("");
        btHistorialNuevos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHistorialNuevosActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(102, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setPreferredSize(new java.awt.Dimension(24, 16));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("ID No Vendibles x Precio");
        jLabel9.setToolTipText("");

        txFiltroMarcas.setToolTipText("");
        txFiltroMarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txFiltroMarcasActionPerformed(evt);
            }
        });
        txFiltroMarcas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txFiltroMarcasKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txFiltroMarcasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txFiltroMarcasKeyTyped(evt);
            }
        });

        jLabel13.setText("FILTRO MARCAS :");

        btMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/search16.png"))); // NOI18N
        btMarca.setEnabled(false);
        btMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMarcaActionPerformed(evt);
            }
        });

        btMarcasNuevas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btMarcasNuevas.setText("MARCAS NUEVAS");
        btMarcasNuevas.setToolTipText("");
        btMarcasNuevas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMarcasNuevasActionPerformed(evt);
            }
        });

        btOfertar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btOfertar.setText("OFERTAR");
        btOfertar.setToolTipText("");
        btOfertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOfertarActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbCeleste);
        rbCeleste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCelesteActionPerformed(evt);
            }
        });

        lbCeleste.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbCeleste.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCeleste.setText("0");
        lbCeleste.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbTotalProd.setText("Total Productos Luvaly        : ");

        btHistorial.setText("Historial Productos");
        btHistorial.setToolTipText("");
        btHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHistorialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbTotalLuv, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTotalProd, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbFechaActualizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btExportar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8)))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txFiltro)
                                .addGap(149, 149, 149))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbCeleste, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbAmarillo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbAmarillo)
                                    .addComponent(rbCeleste))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btHistorialNuevos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btMarcasNuevas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(68, 68, 68)
                                .addComponent(btOfertar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbAzul, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(rbAzul))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbVerde, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbVerde))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lbGris, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbGris))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lbTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(rbTodos))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(rbRojo))))
                        .addGap(44, 44, 44))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txFiltroMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btMarca)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1586, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbTotal)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbTotalLuv))
                                    .addComponent(lbFechaActualizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbTotalProd)
                                    .addComponent(btHistorial)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lbAzul, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(rbAzul))
                                        .addGap(29, 29, 29))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lbGris, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(rbGris)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(rbVerde)
                                                    .addComponent(lbVerde, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(9, 9, 9)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(rbRojo)
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rbTodos))
                                .addGap(19, 19, 19))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(txFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(74, 74, 74)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btOfertar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lbAmarillo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(rbAmarillo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btHistorialNuevos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(11, 11, 11)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(lbCeleste, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel9))
                                            .addComponent(rbCeleste, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btMarcasNuevas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(20, 20, 20)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txFiltroMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13))
                            .addComponent(btMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    

    private void VerProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerProductosActionPerformed
         
        if (!Grilla.getValueAt(Grilla.getSelectedRow(), 1).toString().trim().equals("") || 
            !Grilla.getValueAt(Grilla.getSelectedRow(), 1).toString().trim().isEmpty() ){
        
            pfProductos Pro = new pfProductos();
            Pro.setOpaque(false);
            pnPestanas.addTab("Producto", Pro);
            PanelTab btc = new PanelTab(pnPestanas, 0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Pro), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
            Pro.txSku.requestFocus();
            Pro.CargaProducto(Grilla.getValueAt(Grilla.getSelectedRow(), 1).toString());
            
        }else {
        
              fmMain.Mensaje("No hay Sku asociado..!");
                
        }    
    }//GEN-LAST:event_VerProductosActionPerformed

    private void cbConvenioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbConvenioActionPerformed
        
        if (elige == 0){
            
            elige = 1;
            
            
        }else{
            
            cbConvenioId.setSelectedIndex(cbConvenio.getSelectedIndex());
            
            
            Buscar();
            
            
            if(cbConvenio.getSelectedIndex() != 0){
                
                btHistorialNuevos.setEnabled(true);
                btMarca.setEnabled(true);
                
                if (cbConvenio.getSelectedIndex() == 5){  //INSUMOS MEDICOS
                
                    cbRegion.setEnabled(false);
                
                }else{
                
                    cbRegion.setEnabled(true);
                
                }
                
                 actualiza_historico();
            
            }else{
            
               btHistorialNuevos.setEnabled(false); 
               btMarca.setEnabled(false);
            
            }
            
        }
        
        
        
        
        
    }//GEN-LAST:event_cbConvenioActionPerformed

    
    private void Buscar(){
    
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        
        ExeSql Sql2 = new ExeSql();
        ResultSet Rs2;
        
        DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
        
        String Tabla = "";
        
        int habil = 0;
        int deshabil = 0;
        int deshabil2 = 0;
        int nocomer = 0;
        int noasoc = 0;
        int idnuevo = 0;
        int idnovendido = 0;
        
        int contluv = 0;
        int elconvenio = 0;
        
        int total = 0;
        int filtro = 0;
        int nuevo = 0;
        
        
        double margenLuv =0;
        double margen1 =0;
        double margen2 =0;
        double margen3 =0;
        double margen4 =0;
        double margen5 =0;
        
        String estado = "";
        String reg_habil = "";
        
        
        lbTotal.setText("Total ID Publicadas  : ");
        lbTotalLuv.setText("Total ID Luvaly        : ");
        lbTotalProd.setText("Total Productos Luvaly        : ");
        
        while (TableModel.getRowCount() > 0) {
            TableModel.removeRow(0);
        }
        
             try {
                 
                if (cbConvenioId.getSelectedItem().equals("2") ){
                
                    Tabla = "ferreteria";
                    TablaConvenio = "ferreteria";
                    elconvenio = 2;
                    
                }else if (cbConvenioId.getSelectedItem().equals("3") ){
                
                    Tabla = "aseo";
                    TablaConvenio = "aseo";
                     elconvenio = 3;
                    
                }else if (cbConvenioId.getSelectedItem().equals("4") ){
                
                    Tabla = "alimentos";
                    TablaConvenio = "alimentos";
                     elconvenio = 4;
                    
                }else if (cbConvenioId.getSelectedItem().equals("11") ){
                
                    Tabla = "emergencia";
                    TablaConvenio = "emergencia";
                     elconvenio = 11;
                    
                }else if (cbConvenioId.getSelectedItem().equals("7") ){
                
                    Tabla = "escritorio";
                    TablaConvenio = "escritorio";
                     elconvenio = 7;
                    
                }else if (cbConvenioId.getSelectedItem().equals("9") ){
                
                    Tabla = "insumosmed";
                    TablaConvenio = "insumosmed";
                     elconvenio = 9;
                    
                }
                
                
                
                
                int cont = 1;
                 
                if (!cbConvenioId.getSelectedItem().equals("0") ){
                    
//                        Rs = Sql.Select("SELECT m.*,to_char(m.fecha_actualiza , 'DD-MM-YYYY HH:MI') as fecact, \n"+
//                                        "case when i.stock is null then 0 else i.stock end as stock, \n"+
//                                        "case when nc.id is null then 0 else nc.id end as nocomer, \n"+
//                                        "case when c.oferta_fin is null then '01-01-1900' \n" +
//                                        "else \n" +
//                                        "	c.oferta_fin\n" +
//                                        "end as fechafin    \n"+
//                                        "FROM "+Tabla+" m \n"+ 
//                                        "LEFT JOIN inventario i ON m.sku = i.sku \n"+
//                                        "LEFT JOIN id_nocomer nc ON m.id = nc.id AND m.convenio = nc.convenio \n"+
//                                        "LEFT JOIN codchile c ON m.id = CAST(c.idch as integer) \n"+
//                                        "ORDER BY m.id");
                        
                        
                        
                        
                        
                        Rs = Sql.Select("SELECT m.*,to_char(m.fecha_actualiza , 'DD-MM-YYYY HH:MI') as fecact, \n" +
                                        "case when i.stock is null then 0 else i.stock end as stock, \n" +
                                        "case when nc.id is null then 0 else nc.id end as nocomer, \n" +
                                        "case when c.oferta_fin is null then '01-01-1900' \n" +
                                        "else \n" +
                                        "	c.oferta_fin\n" +
                                        "end as fechafin, \n" +
                                        "case when im.id_madre is null then 0 else im.id_madre end  as idmadre   \n" +
                                        "FROM "+Tabla+" m \n" +
                                        "LEFT JOIN inventario i ON m.sku = i.sku \n" +
                                        "LEFT JOIN id_nocomer nc ON m.id = nc.id AND m.convenio = nc.convenio \n" +
                                        "LEFT JOIN codchile c ON m.id = CAST(c.idch as integer) \n" +
                                        "LEFT JOIN id_asoc_idmadre im ON m.convenio = im.convenio and  m.id = im.id \n" +
                                        "ORDER BY m.id");
                    
                    
                    
                    
                 
                    if (Sql.GetRowCount() > 0){
                 
                        while (Rs.next()){
                            
                            if (cont == 1){
                            
                                String fechaAct = Rs.getString("fecact");  //Fecha del archivo CSV
                                lbFechaActualizacion.setText(fechaAct); 
                                
                                cont++;
                            
                            }
                            
                            
                            if ((!Rs.getString("sku").trim().isEmpty() && !Rs.getString("sku").trim().contains(" ")) || 
                                  Rs.getInt("posicion") != 0  ){
                            
                                contluv++;
                            }
                            
                            
                            if (Rs.getString("estado").trim().equals("ConStock") && 
                               (!Rs.getString("sku").trim().isEmpty() && !Rs.getString("sku").trim().equals(" "))){   //habilitados (Verde)
                            
                               habil++;
                               filtro = 1;
                            
                            }else if (Rs.getString("estado").trim().equals("ConStock") &&  
                                 (Rs.getString("sku").trim().isEmpty() || Rs.getString("sku").trim().contains(" "))){  //no asociao a Sku (Gris)
                            
                               noasoc++;
                               filtro = 0;
                            
                            }else if (Rs.getString("estado").trim().equals("SinStock")){  //no habilitados x Stock(Azul)
                                                             
                                deshabil++;
                                filtro = 2;
                            
                            }else if (Rs.getString("estado").trim().equals("Nocomr")){  //no Comercializados (Rojo)
                                                             
                                nocomer++;
                                filtro = 3;
                            
                            } 
                            
                            
                            
                                
                            if (cbConvenioId.getSelectedItem().equals("3")){ //no habilitados 
            
                        
                                if (Rs.getString("estado").trim().equals("noActivo") &&  
                                   (!Rs.getString("sku").trim().isEmpty() && !Rs.getString("sku").trim().equals(" "))  ){  //no Activo Habilitado Aseo (Verde)
                                                             
                                    habil++;
                                    filtro = 1;
                        
                        
                                }else if (Rs.getString("estado").trim().equals("noActivo") &&  
                                         (Rs.getString("sku").trim().isEmpty() || Rs.getString("sku").trim().contains(" "))  ){  //no Activo no habilitado Aseo (Azul)
                                                             
                                    deshabil++;
                                    filtro = 2;
                        
                        
                                }
                            
                            
                            }
                            
                            
                            if (Rs.getInt("precio_compra") == 0){
                            
                                margenLuv = 0;
                               
                            }else if (Rs.getInt("precio_compra") > 0) {
                            
                                margenLuv = Rs.getDouble("margen_luvaly");
                            
                            }

                            
                            margen1 =Rs.getDouble("margen_primero");
                            margen2 =Rs.getDouble("margen_segundo");
                            margen3 =Rs.getDouble("margen_tercero");
                    //**************************************************************************************//        
                            margen4 = Rs.getDouble("margen_cuarto");
                            margen5 = Rs.getDouble("margen_quinto");
                    //***************************************************************************************//        
                            nuevo = Rs.getInt("nuevo");
                            
                            
                            if (nuevo == 1){  
                            
                                idnuevo++;
                            
                            }
                            
                            estado = Rs.getString("estado").trim();
                            
                            reg_habil = Rs.getString("reg_habil").trim();
                            
                            boolean nocom = false;
                            String filtronocom = "0";
                            
                            if (Rs.getString("nocomer").trim().equals("0")){
                            
                                nocom = false;
                                filtronocom = "0";
                            
                            }else{
                            
                               nocom = true; 
                               filtronocom = "1";
                               idnovendido++;
                            
                            }
                            
                           
                            int enoferta = 0;
                            
                            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                            
                            Date hoy = new Date();
                            
                            String shoy = sdf.format(hoy);
                            
                            Date dhoy = sdf.parse(shoy.trim());
                            
                            String strofer = sdf.format(Rs.getDate("fechafin"));
                            
                           
                            Date dofer = sdf.parse(strofer.trim());
                            
                            
                           // System.out.println("ID : "+Rs.getString("id").trim() + " | finoferta : "+dofer+" | hoy : "+dhoy+" | DIF :"+dofer.compareTo(dhoy));
                            
                            
                            if (dofer.compareTo(dhoy) < 0){   //si la fecha fin de la oferta es menor a hoy, ya no está en oferta
                                
                                enoferta = 0;
                            
                            }else{
                                
                                enoferta = 1;
                            
                            }
                            
                            
                            
                            
                            
                            
                            
//                            
//                            TableModel.addRow(new Object[]{
//                                                Rs.getString("id").trim(),
//                                                Rs.getString("sku").trim(),
//                                                Rs.getString("producto").trim(),
//                                                Rs.getString("stock").trim(),
//                                                Rs.getInt("posicion"),
//                                                "$ "+fmMain.FormatoNumeroSinDecimal(Math.round(Rs.getDouble("precio_compra"))),
//                                                "$ "+fmMain.FormatoNumeroSinDecimal(Math.round(Rs.getDouble("precio_venta"))),
//                                                Math.round(margenLuv)+ " %",
//                                                "$ "+fmMain.FormatoNumeroSinDecimal(Math.round(Rs.getDouble("primero"))),
//                                                Math.round(margen1)+ " %",
//                                                "$ "+fmMain.FormatoNumeroSinDecimal(Math.round(Rs.getDouble("segundo"))),
//                                                Math.round(margen2)+ " %",
//                                                "$ "+fmMain.FormatoNumeroSinDecimal(Math.round(Rs.getDouble("tercero"))),
//                                                Math.round(margen3)+ " %",
//                                                Rs.getString("marca").trim(),
//                                                Rs.getString("region").trim(),
//                                                filtro,
//                                                nuevo,
//                                                estado,
//                                                reg_habil,
//                                                Rs.getString("id_madre").trim(),
//                                                nocom,
//                                                false
//                                                
//                                             
//                            });
                            
                            
                            
                            TableModel.addRow(new Object[]{
                                                Rs.getString("id").trim(),
                                                Rs.getString("sku").trim(),
                                                Rs.getString("producto").trim(),
                                                Rs.getString("stock").trim(),
                                                Rs.getInt("posicion"),
                                                "$ "+fmMain.FormatoNumeroSinDecimal(Math.round(Rs.getDouble("precio_compra"))),
                                                "$ "+fmMain.FormatoNumeroSinDecimal(Math.round(Rs.getDouble("precio_venta"))),
                                                Math.round(margenLuv)+ " %",
                                                "$ "+fmMain.FormatoNumeroSinDecimal(Math.round(Rs.getDouble("primero"))),
                                                Math.round(margen1)+ " %",
                                                "$ "+fmMain.FormatoNumeroSinDecimal(Math.round(Rs.getDouble("segundo"))),
                                                Math.round(margen2)+ " %",
                                                "$ "+fmMain.FormatoNumeroSinDecimal(Math.round(Rs.getDouble("tercero"))),
                                                Math.round(margen3)+ " %",
                                                Rs.getString("marca").trim(),
                                                Rs.getString("region").trim(),
                                                filtro,
                                                nuevo,
                                                estado,
                                                reg_habil,
                                                //Rs.getString("id_madre").trim(),
                                                Rs.getString("idmadre").trim(),
                                                nocom,
                                                false,
                                                "$ "+fmMain.FormatoNumeroSinDecimal(Math.round(Rs.getDouble("cuarto"))),
                                                Math.round(margen4)+ " %",
                                                "$ "+fmMain.FormatoNumeroSinDecimal(Math.round(Rs.getDouble("quinto"))),
                                                Math.round(margen5)+ " %",
                                                enoferta,
                                                filtronocom
                                                
                                             
                            });
                            
                            total++; 
                 
                        }
                        
                 
                    }
                    
                    Grilla.setDefaultRenderer(Object.class, new Elrender()); 
                     
                    lbTotal.setText(lbTotal.getText()+total);
                    TotalID = total;
    
    
                    
                    
                    lbTotalLuv.setText(lbTotalLuv.getText()+contluv);
                    TotalLuv = contluv;
                    
                    Rs2 = Sql2.Select("select count(i.id) as total from id_madre i\n" +
                                      "where i.convenio = "+elconvenio);
                    
                    if(Sql2.GetRowCount() > 0){
                    
                        Rs2.next();
                    
                        lbTotalProd.setText(lbTotalProd.getText()+Rs2.getInt("total"));
                        TotalProdLuv = Rs2.getInt("total");
                    
                    }else{
                    
                        lbTotalProd.setText(lbTotalProd.getText()+0);
                        TotalProdLuv = 0;
                    
                    }
                    
                    
                    
                    
                    lbGris.setText(""+noasoc);
                    lbVerde.setText(""+habil);
                    lbAzul.setText(""+deshabil);
                    lbRojo.setText(""+nocomer);
                    lbTodos.setText(""+(noasoc+habil+deshabil+deshabil2+nocomer));
                    lbAmarillo.setText(""+idnuevo);
                    lbCeleste.setText(""+idnovendido);
                    
                    
                } 
                
             } catch (SQLException | ParseException ex) {
                 Logger.getLogger(pfReporteMercadoPublico.class.getName()).log(Level.SEVERE, null, ex);
             }
            
    
    }
    
    
    
    private void actualiza_historico(){
    
        ExeSql Sql = new ExeSql();
        ExeSql Sql2 = new ExeSql();
        ResultSet Rs;
        
        int elconvenio = 0;
        
        if (cbConvenioId.getSelectedItem().equals("2") ){
                
                    
            elconvenio = 2;
                    
        }else if (cbConvenioId.getSelectedItem().equals("3") ){
                
                    
            elconvenio = 3;
                    
        }else if (cbConvenioId.getSelectedItem().equals("4") ){
                
                    
            elconvenio = 4;
                    
        }else if (cbConvenioId.getSelectedItem().equals("11") ){
                
                    
            elconvenio = 11;
                    
        }else if (cbConvenioId.getSelectedItem().equals("7") ){
                
                    
            elconvenio = 7;
                    
        }else if (cbConvenioId.getSelectedItem().equals("9") ){
                   
            elconvenio = 9;
                    
        }
        
        String fecha = lbFechaActualizacion.getText().trim();
    
        
        try {
            
            Date fec = formatofechacorto.parse(fecha);
            String fec2 = formatofechacorto.format(fec);
            
            Rs = Sql.Select("SELECT * FROM historico_cant_id_convenios\n" +
                            "WHERE convenio = "+elconvenio+" AND fecha = '"+fec2+"' \n" +
                            "ORDER BY fecha DESC");
            
            if(Sql.GetRowCount() == 0){
        
                System.out.println("LA FECHA ES : "+fec2);
                
                Rs.next();
                
              
                int TotalNoAsoc = Integer.parseInt(lbGris.getText().trim());
                int TotalHab = Integer.parseInt(lbVerde.getText().trim());
                int TotalDeshab = Integer.parseInt(lbAzul.getText().trim());
                int TotalNoComer = Integer.parseInt(lbRojo.getText().trim());
                
                
                Sql2.ExeSql("INSERT INTO historico_cant_id_convenios \n"+
                           "(convenio, totalid,totalidluvaly, totalidmadre,totalnoasociados, totalhabilitados,totaldeshabilitados,totalnocomercializados, fecha) \n" +
                           "VALUES ("+elconvenio+","+TotalID+","+TotalLuv+","+TotalProdLuv+","+TotalNoAsoc+","+TotalHab+","+TotalDeshab+","+TotalNoComer+",'"+fec2+"') \n");
                    
                Sql2.Commit();
                
        
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(pfReporteMercadoPublico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(pfReporteMercadoPublico.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    
    
    
    
    private void txFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txFiltroKeyReleased
        
        DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(TableModel); 
        ArrayList<RowFilter<TableModel,Object>> lista = new ArrayList<RowFilter<TableModel,Object>>();  
        
        String filtraRegion =EligeRegion();
        
        String Texto = txFiltro.getText().trim();
        
        
        
        if (Texto.length()==0){
            
            lista.add(RowFilter.regexFilter(""));
            
        }else {
        
            lista.add(RowFilter.regexFilter("(?i)"+Texto));  //(?i) ignora Mayúsculas y Minúsculas
        
        
        }
        
         
        
        lista.add(RowFilter.regexFilter(filtraRegion,15));
        
        
        String filtrar ="";
        
        if (rbGris.isSelected()){
         
            filtrar ="0";
            
             lista.add(RowFilter.regexFilter(filtrar,16));
            
            
         
        }else if (rbVerde.isSelected()) {
        
            filtrar ="1";
            lista.add(RowFilter.regexFilter(filtrar,16));
        
        }else if (rbAzul.isSelected()) {
        
            filtrar ="SinStock";
        
            lista.add(RowFilter.regexFilter(filtrar,18));
            
            
        
        }else if (rbRojo.isSelected()) {
        
           filtrar ="Nocomr";
           
            lista.add(RowFilter.regexFilter(filtrar,18));
            lista.add(RowFilter.regexFilter("0",19));
                   
        
        }else if (rbTodos.isSelected()){
                
            filtrar ="";   
            
            lista.add(RowFilter.regexFilter(filtrar));
                
        }
        
        
        
         RowFilter filtroAnd = RowFilter.andFilter(lista); // and de ambos filtros
        sorter.setRowFilter(filtroAnd);
        
      //**********************************************************************************************************//
     
                                                        
        Grilla.setRowSorter(sorter);
        
        
          
    }//GEN-LAST:event_txFiltroKeyReleased

    
    private void Suma_filtro(int fila){
    
        
        int habil = 0;
        int deshabil = 0;
        int nocomer = 0;
        int noasoc = 0;
        
        for (int i = 0; i < fila; i++) {
        
        
            if (Grilla.getValueAt(i, 18).toString().trim().equals("ConStock") && !Grilla.getValueAt(i, 1).toString().trim().isEmpty() ){   //habilitados (Verde)
       
                habil++;
 
                            
            }else if (Grilla.getValueAt(i, 18).equals("ConStock") && Grilla.getValueAt(i, 1).toString().trim().isEmpty()) { //no asociao a Sku (Gris)
                           
                noasoc++;
                             
            }else if (Grilla.getValueAt(i, 18).equals("SinStock")){  //no habilitados x Stock(Azul)
                                                             
                deshabil++;
                            
            }else if (Grilla.getValueAt(i, 18).equals("Nocomr"))   {
                                                             
                nocomer++;
                            
            }
        
        
        }
        
        
        lbGris.setText(""+noasoc);
        lbVerde.setText(""+habil);
        lbAzul.setText(""+deshabil);
        lbRojo.setText(""+nocomer);
        lbTodos.setText(""+(noasoc+habil+deshabil+nocomer));
        
    
    
    }
    
    
    
    
    
    private void txFiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txFiltroKeyTyped
        // TODO add your handling code here:
        if (Character.isLowerCase(evt.getKeyChar()))
        evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
    }//GEN-LAST:event_txFiltroKeyTyped

    private void GrillaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrillaMouseClicked
       
        
        if (evt.getClickCount() == 1) {
           
            ExeSql Sql = new ExeSql();
            ResultSet Rs = null;         
           
            String ID = Grilla.getValueAt(Grilla.getSelectedRow(), 0).toString().trim();
            System.out.println("El ID ES : "+ID);
           
            int convenio = 0;
        
        
            if (cbConvenio.getSelectedIndex() == 1){  //FERRETERIA
        
                convenio = 2;
        
        
            }else if (cbConvenio.getSelectedIndex() == 2){  //ASEO
        
                convenio = 3;
        
        
            }else if (cbConvenio.getSelectedIndex() == 3){  //ALIMENTOS
        
                convenio = 4;
        
        
            }else if (cbConvenio.getSelectedIndex() == 4){  //ESCRITORIO
        
                convenio = 7;
        
            }else if (cbConvenio.getSelectedIndex() == 5){  //EMERGENCIA
                
                convenio = 11;
        
        
            }
           
           
            int columna = Grilla.getSelectedColumn(); // luego, obtengo la columna seleccionada
            
            if (columna == 21){  //Si es la columna 21 (opcion no Vendido)
              
                boolean seleccionado = (boolean) Grilla.getValueAt(Grilla.getSelectedRow(), 21);
                
                try {
                
                    
                    if (seleccionado){ 
                    
                        Sql.ExeSql("INSERT INTO id_nocomer (id,convenio) values ("+ID+","+convenio+")");
                        Sql.Commit();
                        
                        fmMain.Mensaje("Marcado como No Vendible x Precio!");
                        int idnovendido = Integer.valueOf(lbCeleste.getText().trim());
                        idnovendido++; 
                        lbCeleste.setText(""+idnovendido);
                   
                    }else{
                   
                        Sql.ExeSql("DELETE FROM id_nocomer \n"+
                                   "WHERE id = "+ID+" AND convenio ="+convenio);
                        
                        Sql.Commit();
                        fmMain.Mensaje("Desmarcado como No Vendible x Precio!");
                        
                        int idnovendido = Integer.valueOf(lbCeleste.getText().trim());
                        idnovendido--; 
                        lbCeleste.setText(""+idnovendido);
                        
                   
                    }
                   
                    Grilla.repaint();
               
                } catch (SQLException ex) {
                    
                    Sql.Rollback();
                    Logger.getLogger(pfReporteMercadoPublico.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            
            }
            
            
            if (columna == 22){  //Si es la columna 22 (Seleccionar para ofertar)
            
                 boolean seleccionado2 = (boolean) Grilla.getValueAt(Grilla.getSelectedRow(), 22);
                
                 if (seleccionado2){
                 
                    int ofertado = (int)  Grilla.getValueAt(Grilla.getSelectedRow(), 27);
                    String sku =  Grilla.getValueAt(Grilla.getSelectedRow(), 1).toString().trim();
                    String idmadre =  Grilla.getValueAt(Grilla.getSelectedRow(), 20).toString().trim();
                    
                     
                    if (ofertado == 1){
                     
                         Grilla.setValueAt(false,Grilla.getSelectedRow(), 22);
                         fmMain.Mensaje("ID tiene oferta vigente...!!");
                                 
                    }else if (sku.trim().isEmpty()){
                     
                        Grilla.setValueAt(false,Grilla.getSelectedRow(), 22);
                        fmMain.Mensaje("ID no tiene asociado Sku...!!");
                     
                    }else if (idmadre.trim().equals("0")){
                     
                        Grilla.setValueAt(false,Grilla.getSelectedRow(), 22);
                        fmMain.Mensaje("ID no tiene asociado ID Madre...!!");
                     
                    }
                    
                    
                    
                 
                }
                  
            }
           
        }
    }//GEN-LAST:event_GrillaMouseClicked

    private void rbGrisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbGrisActionPerformed
        
        DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
        
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(TableModel); 
        
        ArrayList<RowFilter<TableModel,Object>> lista = new ArrayList<RowFilter<TableModel,Object>>();  
        
        
        String filtraRegion =EligeRegion();
        
        String filtrar ="0";
        String Texto = txFiltro.getText().trim();
                
        
        //******************************************************************************************************//
        
                
        lista.add(RowFilter.regexFilter(filtrar,16));
        
        if (!Texto.trim().isEmpty()){
        
            lista.add(RowFilter.regexFilter("(?i)"+Texto,2));
        
            
        }
        
        lista.add(RowFilter.regexFilter(filtraRegion,15));
        
                                                        
        RowFilter filtroAnd = RowFilter.andFilter(lista); // and de ambos filtros
        sorter.setRowFilter(filtroAnd);
      //**********************************************************************************************************//
                                                        
        Grilla.setRowSorter(sorter);
        
        
    }//GEN-LAST:event_rbGrisActionPerformed

    private void rbTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTodosActionPerformed
        
        DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(TableModel);
        ArrayList<RowFilter<TableModel,Object>> lista = new ArrayList<RowFilter<TableModel,Object>>();  
          
        String filtraRegion =EligeRegion();
          
        String Texto = txFiltro.getText().trim();
                
        
        //******************************************************************************************************//
        
                
        lista.add(RowFilter.regexFilter(""));
        
        if (!Texto.trim().isEmpty()){
        
            lista.add(RowFilter.regexFilter("(?i)"+Texto,2));
            
        }    
           
        
        if(cbRegion.getSelectedIndex() > 0){
        
        
            lista.add(RowFilter.regexFilter(filtraRegion,15));
        
        }
        
        String TextoMarcas = txFiltroMarcas.getText().trim();
        
        
        if (TextoMarcas.length()>0){
        
           lista.add(RowFilter.regexFilter("(?i)"+TextoMarcas,14));  //(?i) ignora Mayúsculas y Minúsculas
        
        
        }
        
        
        RowFilter filtroAnd = RowFilter.andFilter(lista); // and de ambos filtros
        sorter.setRowFilter(filtroAnd);
      //**********************************************************************************************************//
        
        Grilla.setRowSorter(sorter);
        
    }//GEN-LAST:event_rbTodosActionPerformed

    private void rbVerdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbVerdeActionPerformed
        
        DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(TableModel); 
        ArrayList<RowFilter<TableModel,Object>> lista = new ArrayList<RowFilter<TableModel,Object>>();  
        
        String filtraRegion =EligeRegion();
        
        String filtrar ="1";
        String Texto = txFiltro.getText().trim();
                
        
        //******************************************************************************************************//
        
                
        lista.add(RowFilter.regexFilter(filtrar,16));
        
        if (!Texto.trim().isEmpty()){
        
            lista.add(RowFilter.regexFilter("(?i)"+Texto,2));
            
        }    
          
        
        lista.add(RowFilter.regexFilter(filtraRegion,15));
                
        RowFilter filtroAnd = RowFilter.andFilter(lista); // and de ambos filtros
        sorter.setRowFilter(filtroAnd);
      //**********************************************************************************************************//
        
         
        //sorter.setRowFilter(RowFilter.regexFilter(filtrar,16));
                                                        
        Grilla.setRowSorter(sorter);
        
    }//GEN-LAST:event_rbVerdeActionPerformed

    private void rbAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAzulActionPerformed
       
        DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(TableModel); 
        ArrayList<RowFilter<TableModel,Object>> lista = new ArrayList<RowFilter<TableModel,Object>>();  
        
        String filtraRegion =EligeRegion();
        
        String filtrar = "";
         
        filtrar ="SinStock";
        
        String Texto = txFiltro.getText().trim();
                
        
        //******************************************************************************************************//
        
                
        lista.add(RowFilter.regexFilter(filtrar,18));
        
        if (!Texto.trim().isEmpty()){
        
            lista.add(RowFilter.regexFilter("(?i)"+Texto,2));
            
        }    
          
        
        lista.add(RowFilter.regexFilter(filtraRegion,15));
        
        RowFilter filtroAnd = RowFilter.andFilter(lista); // and de ambos filtros
        sorter.setRowFilter(filtroAnd);
      //**********************************************************************************************************//
                                                       
        Grilla.setRowSorter(sorter);
        
    }//GEN-LAST:event_rbAzulActionPerformed

    private void rbRojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbRojoActionPerformed
        
        DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(TableModel); 
        ArrayList<RowFilter<TableModel,Object>> lista = new ArrayList<RowFilter<TableModel,Object>>();  
        
        String filtraRegion =EligeRegion();
        
        String filtrar ="Nocomr";
        
        
        String Texto = txFiltro.getText().trim();
                
        
        //******************************************************************************************************//
        
                
        lista.add(RowFilter.regexFilter(filtrar,18));
        lista.add(RowFilter.regexFilter("0",19));
        
        if (!Texto.trim().isEmpty()){
        
            lista.add(RowFilter.regexFilter("(?i)"+Texto,2));
            
        }  
        
        lista.add(RowFilter.regexFilter(filtraRegion,15));
                                                        
        RowFilter filtroAnd = RowFilter.andFilter(lista); // and de ambos filtros
        sorter.setRowFilter(filtroAnd);
      //**********************************************************************************************************//
     
                                                        
        Grilla.setRowSorter(sorter);
        
        
    }//GEN-LAST:event_rbRojoActionPerformed

    private void GrillaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GrillaKeyPressed
        ExeSql Sql = new ExeSql();
        ExeSql Sql2 = new ExeSql();
        ExeSql Sql3 = new ExeSql();
        ExeSql Sql4 = new ExeSql();
        ResultSet Rs,Rs2,Rs3;
        String Sku = "";
       
        String Idch = "";
        
          
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            try {
                Sku = Grilla.getValueAt(Grilla.getSelectedRow(), 1).toString().trim();
                Idch = Grilla.getValueAt(Grilla.getSelectedRow(), 0).toString().trim();
                EncuentraIDMadre = Grilla.getValueAt(Grilla.getSelectedRow(), 20).toString().trim();
                
                
                //Busca_Id_Madre(Sku.trim());
                
             
                System.out.println("EL IDCH ES : "+Idch);
                System.out.println("EL SKU ES : "+Sku);
                System.out.println("EL ID MADRE ES : "+EncuentraIDMadre);
                System.out.println("EL convenio ES : "+cbConvenioId.getSelectedItem());
                
                             
                if(Sku.trim().isEmpty()){
                    
                    Grilla.setValueAt(SkuPas.trim(), Grilla.getSelectedRow(), 1);
                    fmMain.Mensaje("Debe desasociar el Sku desde la Ficha del producto...!");
                    return;
                    
                }
                
                
                Rs = Sql.Select("SELECT * FROM codchile WHERE sku = '"+Sku+"' and idch = '"+Idch+"'");
                
                if (Sql.GetRowCount() > 0){
                
                        fmMain.Mensaje("El Codigo ya está asociado al Sku...!");
                        return;
                    
                   
                }else if (Sql.GetRowCount() == 0) {
                
                    
                    
                    Rs2 = Sql4.Select("select * from codchile where idch ='"+Idch.trim()+"'");
                    
                    
                    if (Sql4.GetRowCount() == 0){
                    
                        Sql2.ExeSql("INSERT INTO codchile (sku,idch,cant_unidad,idch_madre, convenio) \n"+
                                    "VALUES ("+ "'" + Sku + "',"+ "'" + Idch + "',"+ 1 + ",'"+EncuentraIDMadre.trim()+ "',"+cbConvenioId.getSelectedItem()+")");
                
                        Sql2.Commit();
                    
                        fmMain.Mensaje("Codigo Asociado!");
                    
                    
                    }else if (Sql4.GetRowCount() > 0) {
             
                        Sql2.ExeSql( "UPDATE codchile SET \n"+
                                     "sku = '" + Sku +"', \n"+
                                     "cant_unidad = 1, \n"+
                                     "idch_madre = '"+EncuentraIDMadre.trim()+"', \n"+
                                     "convenio = "+cbConvenioId.getSelectedItem()+" \n"+
                                     "WHERE idch = '" + Idch.trim() + "'");
                
             
                        Sql2.Commit();
             
                        fmMain.Mensaje("Codigo Asociado!");
             
                    }
                
                }

                
                Actualiza_precio_convenio(Sku, Idch, EncuentraIDMadre.trim());               
                
            } catch (SQLException ex) {
               Sql2.Rollback();
               Sql3.Rollback();
               Logger.getLogger(pfReporteMercadoPublico.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
            
               Sql2.Close();
               Sql3.Close();
            }
            
            
        }
    }//GEN-LAST:event_GrillaKeyPressed

    private void Busca_Id_Madre(String Sku){
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        
        try {
            
            
            Rs = Sql.Select("SELECT  case when idch_madre is null then '0' else idch_madre end as idch_madre  FROM codchile WHERE sku IN ('"+Sku.trim()+"') LIMIT 1");
            
            if (Sql.GetRowCount() > 0){
                
                Rs.next();
                EncuentraIDMadre = Rs.getString("idch_madre");
                
            }else{
            
                EncuentraIDMadre = "0";
                
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(pfReporteMercadoPublico.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    
    
    private void Actualiza_precio_convenio(String Sku, String ID, String IDMADRE){
    
        ExeSql Sql = new ExeSql();
        ExeSql Sql2 = new ExeSql();
        ExeSql Sql3 = new ExeSql();
        ExeSql Sql4 = new ExeSql();
        ResultSet Rs,Rs2,Rs3;
        
        
        String skug = "";
        String posicion = "";
        String valorventa = "";
        
        String ventaluv = "";
        String ventaprimero = "";
        String ventasegundo = "";
        String ventatercero = "";
        
        
        double ctotal   = 0;
        double ppluvaly = 0;
        double pprimero = 0;
        double psegundo = 0;
        double ptercero = 0;
        
        double margenluv  = 0;
        double margen1  = 0;
        double margen2  = 0;
        double margen3  = 0;
        
        int id = Integer.parseInt(ID.trim());
        int idmadre = Integer.parseInt(IDMADRE.trim());
        
        try {
           
            Rs = Sql.Select("select p.sku, p.nombre, p.valultcompra, ch.idch, ch.cant_unidad as cunidad from producto p \n" +
                            "left join codchile ch on p.sku = ch.sku\n" +
                            "where ch.idch in ('"+ID+"')");
            
            if (Sql.GetRowCount() > 0){
                
                Rs.next();
                ctotal = Rs.getDouble("valultcompra") * Rs.getInt("cunidad");
                
                skug = Grilla.getValueAt(Grilla.getSelectedRow(), 1).toString().trim();
                posicion = Grilla.getValueAt(Grilla.getSelectedRow(), 4).toString().trim();
                valorventa = Grilla.getValueAt(Grilla.getSelectedRow(), 6).toString().trim().replaceAll("\\$ ", "");
                
                
                if (skug.trim().isEmpty()){
                        
                        ppluvaly = 0;
                        margenluv = 0;
                        
                        
                        
                }else {
                    //************************************** Margen Luvaly *******************************************************************//
                        ventaluv = Grilla.getValueAt(Grilla.getSelectedRow(), 6).toString().trim().replaceAll("\\$ ", "");
                        ventaluv = ventaluv.trim().replaceAll("\\,", "");
                        
                    
                        ppluvaly = Double.parseDouble(ventaluv.trim());
                        
                        if(ppluvaly > 0){
                        
                            margenluv =  Math.round(((ppluvaly - ctotal)  / ppluvaly) * 100); 
                        
                        }else{
                        
                            margenluv = 0;
                                                        
                        }
                        
                    
                    //************************************** Margen Primera Posición *******************************************************************//    
                        ventaprimero = Grilla.getValueAt(Grilla.getSelectedRow(), 8).toString().trim().replaceAll("\\$ ", "");
                        ventaprimero = ventaprimero.trim().replaceAll("\\,", "");
                        
                        pprimero = Double.parseDouble(ventaprimero.trim());
                        
                        
                        
                        if(pprimero > 0){
                        
                            margen1 =  Math.round(((pprimero - ctotal)  / pprimero) * 100); 
                        
                        }else{
                        
                            margen1 = 0;
                                                        
                        }
                        
                        
                    //************************************** Margen Segunda Posición *******************************************************************//    
                        ventasegundo = Grilla.getValueAt(Grilla.getSelectedRow(), 10).toString().trim().replaceAll("\\$ ", "");
                        ventasegundo = ventasegundo.trim().replaceAll("\\,", "");
                        
                        psegundo = Double.parseDouble(ventasegundo.trim());
                        
                        
                        
                        if(psegundo > 0){
                        
                            margen2 =  Math.round(((psegundo - ctotal)  / psegundo) * 100); 
                        
                        }else{
                        
                            margen2 = 0;
                                                        
                        }
                        
                        
                    //************************************** Margen Tercera Posición *******************************************************************//    
                        ventatercero = Grilla.getValueAt(Grilla.getSelectedRow(), 12).toString().trim().replaceAll("\\$ ", "");
                        ventatercero = ventatercero.trim().replaceAll("\\,", "");
                        
                        ptercero = Double.parseDouble(ventatercero.trim());
                        
                        
                        
                        if(ptercero > 0){
                        
                            margen3 =  Math.round(((ptercero - ctotal)  / ptercero) * 100); 
                        
                        }else{
                        
                            margen3 = 0;
                                                        
                        }    
                        
                        
                         Rs3 = Sql3.Select("SELECT * FROM "+TablaConvenio+" WHERE id = "+id);  
                
                
                        if (Sql3.GetRowCount() > 0){
                
//                            Sql3.ExeSql("UPDATE "+TablaConvenio+" SET \n"+
//                                        "sku = '"+Sku+"', \n"+
//                                        "precio_compra = "+ctotal+", \n"+
//                                        "margen_luvaly = "+margenluv+", \n"+
//                                        "margen_primero = "+margen1+", \n"+
//                                        "margen_segundo = "+margen2+", \n"+
//                                        "margen_tercero = "+margen3+", \n"+
//                                        "id_madre = "+idmadre+" \n"+
//                                        "WHERE id = "+id);
//                            Sql3.Commit();
                            
                            
                            Sql3.ExeSql("UPDATE "+TablaConvenio+" SET \n"+
                                        "sku = '"+Sku+"' \n"+
                                        "WHERE id = "+id);
                            Sql3.Commit();
                            
                            
                
                        }
                        
                
                }
                
                
            }
        
        
        } catch (SQLException ex) {
            Logger.getLogger(pfReporteMercadoPublico.class.getName()).log(Level.SEVERE, null, ex);
        }   
    
    
    }
    
    
    
    
    private void GrillaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GrillaKeyTyped
        
        
    }//GEN-LAST:event_GrillaKeyTyped

    private void rbAmarilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAmarilloActionPerformed
        
       DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
       TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(TableModel); 
       ArrayList<RowFilter<TableModel,Object>> lista = new ArrayList<RowFilter<TableModel,Object>>();  
        
        
        
        String filtrar ="1";
        
        lista.add(RowFilter.regexFilter(filtrar,17));
        
        String Texto = txFiltroMarcas.getText().trim();
        
        
        if (Texto.length()>0){
        
           lista.add(RowFilter.regexFilter("(?i)"+Texto,14));  //(?i) ignora Mayúsculas y Minúsculas
        
        
        }
        
        RowFilter filtroAnd = RowFilter.andFilter(lista); // and de ambos filtros
         
        sorter.setRowFilter(filtroAnd); 
        
        Grilla.setRowSorter(sorter);
        
        
    }//GEN-LAST:event_rbAmarilloActionPerformed

    private void cbRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRegionActionPerformed
        
        DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(TableModel); 
        
        String filtraRegion =EligeRegion();
        String filtra ="";
        int columna = 0;
        int todos = 0;
        
        
        if (rbGris.isSelected()){
                    
            filtra = "0";
            columna = 16;
            todos = 0;
        
        }else if (rbVerde.isSelected()){
                    
            filtra = "1";
            columna = 16;
            todos = 0;
        
        }else if (rbAzul.isSelected()){
            
            
            filtra ="SinStock";
            columna = 18;
            
            todos = 0;
            
        }else if (rbRojo.isSelected()){
                    
            filtra ="Nocomr";
            columna = 18;
            todos = 0;
        
        }else if (rbTodos.isSelected()){
                    
            todos = 1;
        
        }
        
        
        if (todos == 0){
        
            ArrayList<RowFilter<TableModel,Object>> lista = new ArrayList<RowFilter<TableModel,Object>>();  
               
            lista.add(RowFilter.regexFilter(filtraRegion,15));
            lista.add(RowFilter.regexFilter(filtra,columna));
        
            RowFilter filtroAnd = RowFilter.andFilter(lista); // and de ambos filtros
                                                        
            sorter.setRowFilter(filtroAnd);
       
        }else {
        
        
             sorter.setRowFilter(RowFilter.regexFilter(filtraRegion,15));
        
        }
       
       
       Grilla.setRowSorter(sorter);
        
        
    }//GEN-LAST:event_cbRegionActionPerformed
    
    
     private String EligeRegion(){
         
         String filtraRegion ="";         
         
        
        if(cbRegion.getSelectedIndex() == 1){    //         TARAPACÁ
                   
            filtraRegion = "NO HABILITADA";
            
        
        }else if(cbRegion.getSelectedIndex() == 2){   //         ANTOFAGASTA
                   
            filtraRegion = "NO HABILITADA";
            
        
        }else if(cbRegion.getSelectedIndex() == 3){    //         ATACAMA
                   
            filtraRegion = "ATACAMA";
            
        
        }else if(cbRegion.getSelectedIndex() == 4){  //         COQUIMBO
                   
            filtraRegion = "COQUIMBO";
            
        
         }else if(cbRegion.getSelectedIndex() == 5){    //         VALPARAÍSO
                   
           filtraRegion = "VALPARAÍSO";
            
        
         }else if(cbRegion.getSelectedIndex() == 6){   //         LIBERTADOR GRAL. BERNARDO OHIGGINS
                   
           filtraRegion = "OHIGGINS";
            
        
         }else if(cbRegion.getSelectedIndex() == 7){   //         MAULE
                   
           filtraRegion = "MAULE";
            
        
         }else if(cbRegion.getSelectedIndex() == 8){   //        BIOBÍO
                   
           filtraRegion = "BIOBÍO";
            
        
         }else if(cbRegion.getSelectedIndex() == 9){    //        ARAUCANÍA
                   
           filtraRegion = "ARAUCANÍA";
            
        
         }else if(cbRegion.getSelectedIndex() == 10){   //        LOS LAGOS
                   
            filtraRegion = "LOS LAGOS";
            
        
        }else if(cbRegion.getSelectedIndex() == 11){   //        AISÉN
                   
            filtraRegion = "NO HABILITADA";
            
        
        }else if(cbRegion.getSelectedIndex() == 12){    //        MAGALLANES Y DE LA ANTÁRTICA CHILENA
                   
            filtraRegion = "NO HABILITADA";
            
        
        }else if(cbRegion.getSelectedIndex() == 13){    //        METROPOLITANA
                   
            filtraRegion = "METROPOLITANA";
            
        
        }else if(cbRegion.getSelectedIndex() == 14){   //        LOS RÍOS
                   
            filtraRegion = "LOS RÍOS";
            
        
        }else if(cbRegion.getSelectedIndex() == 15){   //        ARICA Y PARINACOTA
                   
            filtraRegion = "NO HABILITADA";
            
        
        }else if(cbRegion.getSelectedIndex() == 16){    //        REGIÓN DE ÑUBLE
                   
            filtraRegion = "ÑUBLE";
            
        
        }
         
        return filtraRegion;
     
     
     }
    
    
    
    private void btExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExportarActionPerformed
        
        String NomArchivo = JOptionPane.showInputDialog("Nombre de Archivo: ");
        
        if (NomArchivo.isEmpty() || NomArchivo.trim().equals("")){
        
            fmMain.Mensaje("Debe Ingresar un nombre!");  
            return;
        
        }
        
        
        
        File ruta = null;
        File carpeta = null;
                        
        String sSistemaOperativo = System.getProperty("os.name");               //Determina el Sistema Operativo del Equipo 
        String usuario =System.getProperty("user.name");    //   Captura el nombre del usuario del Equipo
        
            
        if (sSistemaOperativo.contains("Win")){        //Si es Windows
            
//            carpeta = new File("C:\\temp\\");  
//            
//            if (!carpeta.exists()){   
//            
//                //fmMain.Mensaje("Carpeta NO existe!!");
//                carpeta.mkdir();
//             
//            }
            
            
            System.out.println("El USUARIO ES : "+usuario);
            
           // ruta = new File("C:\\temp\\"+NomArchivo.trim()+".xls");               
            ruta = new File("C:\\Users\\"+usuario+"\\Downloads\\"+NomArchivo.trim()+".xls");            
        
        }
        
        WorkbookSettings conf = new WorkbookSettings();
        conf.setEncoding("ISO-8859-1");                                     //Se establece la norma ISO de codificación de caracteres
           
        try {
            
            WritableWorkbook libro = Workbook.createWorkbook(ruta,conf);     //Se crea libro de excel
          
            
            WritableFont Fuente = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD,false, UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
            WritableFont FuenteRojo = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD,false, UnderlineStyle.NO_UNDERLINE, Colour.RED);
            WritableFont FuenteMagenta = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD,false, UnderlineStyle.NO_UNDERLINE, Colour.VIOLET2);
            WritableFont FuenteNegro = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD,false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
            WritableFont FuenteAzul = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD,false, UnderlineStyle.NO_UNDERLINE, Colour.BLUE);
            WritableFont FuenteVerde = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD,false, UnderlineStyle.NO_UNDERLINE, Colour.GREEN);
 
            
            WritableCellFormat format = new WritableCellFormat();               //Alineación para los encabezados
            format.setAlignment(Alignment.CENTRE);
            format.setBackground(Colour.GREY_40_PERCENT);
            format.setFont(Fuente);
            format.setBorder(Border.ALL, BorderLineStyle.THIN,Colour.BLACK); //table border style
            format.setWrap(true);
            
    //************************************************************* ROJO **************************************************************//      
            WritableCellFormat formatRojo1 = new WritableCellFormat();              //Alineación para los datos texto a la izquierda
            formatRojo1.setAlignment(Alignment.LEFT);
            formatRojo1.setFont(FuenteRojo);
            formatRojo1.setBorder(Border.ALL, BorderLineStyle.THIN,Colour.BLACK); //table border style
            
            WritableCellFormat formatRojo2 = new WritableCellFormat();              //Alineación para los datos texto al centro
            formatRojo2.setAlignment(Alignment.CENTRE);
            formatRojo2.setFont(FuenteRojo);
            formatRojo2.setBorder(Border.ALL, BorderLineStyle.THIN,Colour.BLACK); //table border style
            
            
    //************************************************************* MAGENTA **************************************************************//      
            WritableCellFormat formatMagenta1 = new WritableCellFormat();              //Alineación para los datos texto a la izquierda
            formatMagenta1.setAlignment(Alignment.LEFT);
            formatMagenta1.setFont(FuenteMagenta);
            formatMagenta1.setBorder(Border.ALL, BorderLineStyle.THIN,Colour.BLACK); //table border style
            
            WritableCellFormat formatMagenta2 = new WritableCellFormat();              //Alineación para los datos texto al centro
            formatMagenta2.setAlignment(Alignment.CENTRE);
            formatMagenta2.setFont(FuenteMagenta);
            formatMagenta2.setBorder(Border.ALL, BorderLineStyle.THIN,Colour.BLACK); //table border style        
         
    
    //************************************************************* NEGRO **************************************************************//      
            WritableCellFormat formatNegro1 = new WritableCellFormat();              //Alineación para los datos texto a la izquierda
            formatNegro1.setAlignment(Alignment.LEFT);
            formatNegro1.setFont(FuenteNegro);
            formatNegro1.setBorder(Border.ALL, BorderLineStyle.THIN,Colour.BLACK); //table border style
            
            WritableCellFormat formatNegro2 = new WritableCellFormat();              //Alineación para los datos texto al centro
            formatNegro2.setAlignment(Alignment.CENTRE);
            formatNegro2.setFont(FuenteNegro);
            formatNegro2.setBorder(Border.ALL, BorderLineStyle.THIN,Colour.BLACK); //table border style        
                 
    //************************************************************* AZUL **************************************************************//      
            WritableCellFormat formatAzul1 = new WritableCellFormat();              //Alineación para los datos texto a la izquierda
            formatAzul1.setAlignment(Alignment.LEFT);
            formatAzul1.setFont(FuenteAzul);
            formatAzul1.setBorder(Border.ALL, BorderLineStyle.THIN,Colour.BLACK); //table border style
            
            WritableCellFormat formatAzul2 = new WritableCellFormat();              //Alineación para los datos texto al centro
            formatAzul2.setAlignment(Alignment.CENTRE);
            formatAzul2.setFont(FuenteAzul);
            formatAzul2.setBorder(Border.ALL, BorderLineStyle.THIN,Colour.BLACK); //table border style                
            
     //************************************************************* VERDE **************************************************************//      
            WritableCellFormat formatVerde1 = new WritableCellFormat();              //Alineación para los datos texto a la izquierda
            formatVerde1.setAlignment(Alignment.LEFT);
            formatVerde1.setFont(FuenteVerde);
            formatVerde1.setBorder(Border.ALL, BorderLineStyle.THIN,Colour.BLACK); //table border style
            
            WritableCellFormat formatVerde2 = new WritableCellFormat();              //Alineación para los datos texto al centro
            formatVerde2.setAlignment(Alignment.CENTRE);
            formatVerde2.setFont(FuenteVerde);
            formatVerde2.setBorder(Border.ALL, BorderLineStyle.THIN,Colour.BLACK); //table border style                        
            
            WritableSheet hoja = libro.createSheet("Productos", 0);     //Se le asigna nombre a la primera hoja(0) del libro excel
                       
            
            hoja.setColumnView(0, 15);     //ID                                //Ancho de la columna (en número de caracteres)
            hoja.setColumnView(1, 15);     //Sku                                
            hoja.setColumnView(2, 80);     //nombre Producto 
            hoja.setColumnView(3, 20);     //Precio de Venta
            hoja.setColumnView(4, 15);     //Region
            hoja.setColumnView(5, 20);     //Precio Primero
            hoja.setColumnView(6, 20);     //Precio Segundo
            hoja.setColumnView(7, 20);     //Precio Tercero
            hoja.setColumnView(8, 70);     //Marca
          
         
            hoja.setRowView(0,26*20);    //la altura de la fila del encabezado
            
    //********************************  Se agregan contenido a las celdas de la hoja  *******************************************        
        
            
            hoja.addCell(new jxl.write.Label(0,0,"ID",format));                //Se agrega fila con el nombre de los encabezados        
            hoja.addCell(new jxl.write.Label(1,0,"Sku",format));                //Se agrega fila con el nombre de los encabezados        
            hoja.addCell(new jxl.write.Label(2,0,"Producto",format));
            hoja.addCell(new jxl.write.Label(3,0,"Precio Luvaly",format));
            hoja.addCell(new jxl.write.Label(4,0,"Regón",format));
            hoja.addCell(new jxl.write.Label(5,0,"Primero",format));
            hoja.addCell(new jxl.write.Label(6,0,"Segundo",format));
            hoja.addCell(new jxl.write.Label(7,0,"Tercero",format));
            hoja.addCell(new jxl.write.Label(8,0,"Marca",format));
           
            
            
            WritableCellFormat format1 = null;
            WritableCellFormat format2 = null;
            
            
            for(int i=0; i < Grilla.getRowCount(); i++){ //For                  //Se agregan filas con los datos
            
                int fila = i+1;
                   
                hoja.addCell(new jxl.write.Label(0,fila,Grilla.getValueAt(i,0).toString()));
                hoja.addCell(new jxl.write.Label(1,fila,Grilla.getValueAt(i,1).toString()));
                hoja.addCell(new jxl.write.Label(2,fila,Grilla.getValueAt(i,2).toString()));
                hoja.addCell(new jxl.write.Label(3,fila,Grilla.getValueAt(i,6).toString()));
                hoja.addCell(new jxl.write.Label(4,fila,Grilla.getValueAt(i,15).toString()));
                hoja.addCell(new jxl.write.Label(5,fila,Grilla.getValueAt(i,8).toString()));
                hoja.addCell(new jxl.write.Label(6,fila,Grilla.getValueAt(i,10).toString()));
                hoja.addCell(new jxl.write.Label(7,fila,Grilla.getValueAt(i,12).toString()));
                hoja.addCell(new jxl.write.Label(8,fila,Grilla.getValueAt(i,14).toString()));
                
                
            
            }
            
            
            
    //***************************************************************************************************************************    
            libro.write();          //Se escriben el contenido en el libro
            libro.close();          //se cierra el libro
            
            fmMain.Mensaje("Archivo : "+NomArchivo.trim()+".xls \n creado con éxito");
            
        } catch (WriteException | IOException ex) {
            Logger.getLogger(pfReporteMercadoPublico.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
        
        
    }//GEN-LAST:event_btExportarActionPerformed

    private void CopiarDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopiarDescActionPerformed
        
        if(!Grilla.getValueAt(Grilla.getSelectedRow(), 2).toString().trim().isEmpty()){
            StringSelection Voucher = new StringSelection(Grilla.getValueAt(Grilla.getSelectedRow(), 2).toString().trim());
            Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
            cb.setContents(Voucher, null);
           
//            Action paste = new DefaultEditorKit.PasteAction();
//            paste.putValue(Action.NAME, "Paste");
//            paste.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control V"));
            txFiltro.setText("");
            txFiltro.paste();
            txFiltro.requestFocus();
            
            
            
            
        }
    }//GEN-LAST:event_CopiarDescActionPerformed

    private void CopiarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopiarIDActionPerformed
        
        if(!Grilla.getValueAt(Grilla.getSelectedRow(), 0).toString().trim().isEmpty()){
            StringSelection Voucher = new StringSelection(Grilla.getValueAt(Grilla.getSelectedRow(), 0).toString().trim());
            Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
            cb.setContents(Voucher, null);
           
        }    
        
    }//GEN-LAST:event_CopiarIDActionPerformed

    private void lbFechaActualizacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbFechaActualizacionKeyPressed
       
        
        
        
        
    }//GEN-LAST:event_lbFechaActualizacionKeyPressed

    private void CopiarIDMADREActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopiarIDMADREActionPerformed
        
        if(!Grilla.getValueAt(Grilla.getSelectedRow(), 20).toString().trim().isEmpty()){
            StringSelection Voucher = new StringSelection(Grilla.getValueAt(Grilla.getSelectedRow(), 20).toString().trim());
            Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
            cb.setContents(Voucher, null);
           
        }    
    }//GEN-LAST:event_CopiarIDMADREActionPerformed

    private void btHistorialNuevosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHistorialNuevosActionPerformed
       
        int convenio = 0;
        String Texto = "";
        
        if (cbConvenio.getSelectedIndex() == 1){  //FERRETERIA
        
            convenio = 2;
            Texto = "Agregados Ferreteria";
        
        }else if (cbConvenio.getSelectedIndex() == 2){  //ASEO
        
            convenio = 3;
            Texto = "Agregados Aseo";
        
        }else if (cbConvenio.getSelectedIndex() == 3){  //ALIMENTOS
        
            convenio = 4;
            Texto = "Agregados Alimentos";
        
        }else if (cbConvenio.getSelectedIndex() == 4){  //ESCRITORIO
        
            convenio = 7;
            Texto = "Agregados Escritorio";
            
        
        
        }else if (cbConvenio.getSelectedIndex() == 5){  //INSUMOS MEDICOS
                
            convenio = 9;
            Texto = "Agregados Insumos Médicos";
        
        }else if (cbConvenio.getSelectedIndex() == 6){  //EMERGENCIA
                
            convenio = 11;
            Texto = "Agregados Emergencia";
        
        }
        
        
        jdAgregados_MP MP = new jdAgregados_MP(null, true);
        MP.setLocationRelativeTo(null);
        MP.setTitle(Texto);
        MP.SetDatos(convenio, Texto);
        MP.setVisible(true);
        
                
        
    }//GEN-LAST:event_btHistorialNuevosActionPerformed

    private void btMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMarcaActionPerformed

        
        int convenio = 0;
        String Texto = "";
        
        if (cbConvenio.getSelectedIndex() == 1){  //FERRETERIA
        
            convenio = 2;
            Texto = "Marcas Ferreteria";
        
        }else if (cbConvenio.getSelectedIndex() == 2){  //ASEO
        
            convenio = 3;
            Texto = "Marcas Aseo";
        
        }else if (cbConvenio.getSelectedIndex() == 3){  //ALIMENTOS
        
            convenio = 4;
            Texto = "Marcas Alimentos";
        
        }else if (cbConvenio.getSelectedIndex() == 4){  //ESCRITORIO
        
            convenio = 7;
            Texto = "Marcas Escritorio";
            
        
        
        }else if (cbConvenio.getSelectedIndex() == 5){  //INSUMOS MEDICOS
                
            convenio = 9;
            Texto = "Marcas Insumos Médicos";
        
        }else if (cbConvenio.getSelectedIndex() == 6){  //EMERGENCIA
                
            convenio = 11;
            Texto = "Marcas Emergencia";
        
        }
        
        
        
        jd_Marcas Marcas = new jd_Marcas(null, true);
        Marcas.setLocationRelativeTo(null);
        Marcas.setTitle(Texto);
        Marcas.SetConvenio(convenio);
        Marcas.Carga();
        Marcas.setVisible(true);

        if (Marcas.GetElige() == 1){

            txFiltroMarcas.setText(Marcas.GetNomMarca().trim());
            txFiltroMarcas.requestFocus();
             DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(TableModel); 
            ArrayList<RowFilter<TableModel,Object>> lista = new ArrayList<RowFilter<TableModel,Object>>();  
        
            String Texto2 = txFiltroMarcas.getText().trim();
        
        
        
            if (Texto2.length()==0){
            
                lista.add(RowFilter.regexFilter(""));
            
            }else {
        
                lista.add(RowFilter.regexFilter("(?i)"+Texto2,14));  //(?i) ignora Mayúsculas y Minúsculas
        
        
            }
            
            
            RowFilter filtroAnd = RowFilter.andFilter(lista); // and de ambos filtros
            sorter.setRowFilter(filtroAnd);
        
      //**********************************************************************************************************//
     
                                                        
        Grilla.setRowSorter(sorter);
            

        }

    }//GEN-LAST:event_btMarcaActionPerformed

    private void txFiltroMarcasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txFiltroMarcasKeyPressed
        
        
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
        
            DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(TableModel); 
            ArrayList<RowFilter<TableModel,Object>> lista = new ArrayList<RowFilter<TableModel,Object>>();  
        
            String Texto = txFiltroMarcas.getText().trim();
        
        
        
            if (Texto.length()==0){
            
                lista.add(RowFilter.regexFilter(""));
            
            }else {
        
                lista.add(RowFilter.regexFilter("(?i)"+Texto,14));  //(?i) ignora Mayúsculas y Minúsculas
        
        
            }
            
            
            RowFilter filtroAnd = RowFilter.andFilter(lista); // and de ambos filtros
            sorter.setRowFilter(filtroAnd);
        
      //**********************************************************************************************************//
     
                                                        
        Grilla.setRowSorter(sorter);
            
            
        
        }
    }//GEN-LAST:event_txFiltroMarcasKeyPressed

    private void txFiltroMarcasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txFiltroMarcasKeyTyped
       
        if (Character.isLowerCase(evt.getKeyChar())){
        
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
        
    }//GEN-LAST:event_txFiltroMarcasKeyTyped

    private void txFiltroMarcasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txFiltroMarcasKeyReleased
        
            DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(TableModel); 
            ArrayList<RowFilter<TableModel,Object>> lista = new ArrayList<RowFilter<TableModel,Object>>();  
        
            String Texto = txFiltroMarcas.getText().trim();
        
        
        
            if (Texto.length()==0){
            
                lista.add(RowFilter.regexFilter(""));
            
            }else {
        
                lista.add(RowFilter.regexFilter("(?i)"+Texto,14));  //(?i) ignora Mayúsculas y Minúsculas
        
        
            }
            
            
            RowFilter filtroAnd = RowFilter.andFilter(lista); // and de ambos filtros
            sorter.setRowFilter(filtroAnd);
        
      //**********************************************************************************************************//
     
                                                        
        Grilla.setRowSorter(sorter);
        
        
    }//GEN-LAST:event_txFiltroMarcasKeyReleased

    private void btMarcasNuevasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMarcasNuevasActionPerformed
        
         int convenio = 0;
        String Texto = "";
        
        if (cbConvenio.getSelectedIndex() == 1){  //FERRETERIA
        
            convenio = 2;
            Texto = "Marcas Agregados Ferreteria";
        
        }else if (cbConvenio.getSelectedIndex() == 2){  //ASEO
        
            convenio = 3;
            Texto = "Marcas Agregados Aseo";
        
        }else if (cbConvenio.getSelectedIndex() == 3){  //ALIMENTOS
        
            convenio = 4;
            Texto = "Marcas Agregados Alimentos";
        
        }else if (cbConvenio.getSelectedIndex() == 4){  //ESCRITORIO
        
            convenio = 7;
            Texto = "Marcas Agregados Escritorio";
            
        
        
        }else if (cbConvenio.getSelectedIndex() == 5){  //INSUMOS MEDICOS
                
            convenio = 9;
            Texto = "Marcas Agregados Insumos Médicos";
        
        }else if (cbConvenio.getSelectedIndex() == 6){  //EMERGENCIA
                
            convenio = 11;
            Texto = "Marcas Agregados Emergencia";
        
        }
        
        
        jdMarcasAgregados_MP MP = new jdMarcasAgregados_MP(null, true);
        MP.setLocationRelativeTo(null);
        MP.setTitle(Texto);
        MP.SetDatos(convenio, Texto);
        MP.setVisible(true);
        
        
        if (MP.GetElige() == 1){

            txFiltroMarcas.setText(MP.GetNomMarca().trim());
            txFiltroMarcas.requestFocus();
             DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(TableModel); 
            ArrayList<RowFilter<TableModel,Object>> lista = new ArrayList<RowFilter<TableModel,Object>>();  
        
            String Texto2 = txFiltroMarcas.getText().trim();
        
        
        
            if (Texto2.length()==0){
            
                lista.add(RowFilter.regexFilter(""));
            
            }else {
        
                lista.add(RowFilter.regexFilter("(?i)"+Texto2,14));  //(?i) ignora Mayúsculas y Minúsculas
        
        
            }
            
            
            RowFilter filtroAnd = RowFilter.andFilter(lista); // and de ambos filtros
            sorter.setRowFilter(filtroAnd);
        
      //**********************************************************************************************************//
     
                                                        
            Grilla.setRowSorter(sorter);
            

        }
        
        
        
        
    }//GEN-LAST:event_btMarcasNuevasActionPerformed

    private void txFiltroMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txFiltroMarcasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txFiltroMarcasActionPerformed

    private void btOfertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOfertarActionPerformed
        
        int convenio = 0;
        String Texto = "";
        boolean seleccionado = false;
        
        if (cbConvenio.getSelectedIndex() == 1){  //FERRETERIA
        
            convenio = 2;
            Texto = "Ofertados Ferreteria";
        
        }else if (cbConvenio.getSelectedIndex() == 2){  //ASEO
        
            convenio = 3;
            Texto = "Ofertados Aseo";
        
        }else if (cbConvenio.getSelectedIndex() == 3){  //ALIMENTOS
        
            convenio = 4;
            Texto = "Ofertados Alimentos";
        
        }else if (cbConvenio.getSelectedIndex() == 4){  //ESCRITORIO
        
            convenio = 7;
            Texto = "Ofertados Escritorio";
            
        
        
        }else if (cbConvenio.getSelectedIndex() == 5){  //INSUMOS MEDICOS
                
            convenio = 9;
            Texto = "Ofertados Insumos Médicos";
        
        }else if (cbConvenio.getSelectedIndex() == 6){  //EMERGENCIA
                
            convenio = 11;
            Texto = "Ofertados Emergencia";
        
        }
        
        Lista.clear();
        
        int fila = 0;
        
        
        for(int i=0; i < Grilla.getRowCount(); i++){
        
            seleccionado = (boolean) Grilla.getValueAt(i, 22);
            
            
            if (seleccionado){ 
                
                Lista.add(new ArrayList<String>());
                
                Lista.get(fila).add(0,Grilla.getValueAt(i, 20).toString().trim());  //ID Madre
                Lista.get(fila).add(1,Grilla.getValueAt(i, 2).toString().trim());    //DESCRIPCION
                Lista.get(fila).add(2,String.valueOf(convenio));    //Convenio
                Lista.get(fila).add(3,Grilla.getValueAt(i, 5).toString().trim().replaceAll("\\$ ", ""));   //Compra
                Lista.get(fila).add(4,Grilla.getValueAt(i, 6).toString().trim().replaceAll("\\$ ", ""));   //Venta Luvaly 
                Lista.get(fila).add(5,Grilla.getValueAt(i, 7).toString().trim());   //Margen Luvaly
                Lista.get(fila).add(6,"0");   //Venta Luvaly - Minimo
                Lista.get(fila).add(7,"0");   //Margen Luvaly - Minimo
                Lista.get(fila).add(8,Grilla.getValueAt(i, 8).toString().trim().replaceAll("\\$ ", ""));   //Primero
                Lista.get(fila).add(9,Grilla.getValueAt(i, 9).toString().trim());  //Margen Primero
                Lista.get(fila).add(10,Grilla.getValueAt(i, 10).toString().trim().replaceAll("\\$ ", ""));  //Segundo
                Lista.get(fila).add(11,Grilla.getValueAt(i, 11).toString().trim());  //Margen Segundo 
                Lista.get(fila).add(12,Grilla.getValueAt(i, 12).toString().trim().replaceAll("\\$ ", "")); //Tercero
                Lista.get(fila).add(13,Grilla.getValueAt(i, 13).toString().trim());  //Margen Tercero 
                Lista.get(fila).add(14,Grilla.getValueAt(i, 23).toString().trim().replaceAll("\\$ ", ""));  //Cuarto
                Lista.get(fila).add(15,Grilla.getValueAt(i, 24).toString().trim());  //Margen Cuarto
                Lista.get(fila).add(16,Grilla.getValueAt(i, 25).toString().trim().replaceAll("\\$ ", ""));  //Quinto
                Lista.get(fila).add(17,Grilla.getValueAt(i, 26).toString().trim());  //Margen Quinto
                Lista.get(fila).add(18,Grilla.getValueAt(i, 0).toString().trim());  //ID
                Lista.get(fila).add(19,Grilla.getValueAt(i, 0).toString().trim());  //ValUltcompra para validacion
                Lista.get(fila).add(20,Grilla.getValueAt(i, 0).toString().trim());  //Ultima costo oferta para validacion
                                
                fila++;
                
               
                
            }
        
            
        }
        
        
        
        System.out.println("El Tamaño de Primera Lista.size() ES :"+Lista.size() );
        
        
        jdOfertados_MP OF = new jdOfertados_MP(null, true);
        OF.setLocationRelativeTo(null);
        OF.setTitle(Texto);
        OF.SetDatos(convenio, Texto, Lista, Usuario);
        OF.setVisible(true);
        
        
        
    }//GEN-LAST:event_btOfertarActionPerformed

    private void rbCelesteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCelesteActionPerformed
        
        
        DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(TableModel); 
        ArrayList<RowFilter<TableModel,Object>> lista = new ArrayList<RowFilter<TableModel,Object>>();  
        
        
        
        String filtrar = "1";
        
        lista.add(RowFilter.regexFilter(filtrar,28));
        
        String Texto = txFiltroMarcas.getText().trim();
        
        
        if (Texto.length()>0){
        
           lista.add(RowFilter.regexFilter("(?i)"+Texto,14));  //(?i) ignora Mayúsculas y Minúsculas
        
        
        }
        
        RowFilter filtroAnd = RowFilter.andFilter(lista); // and de ambos filtros
         
        sorter.setRowFilter(filtroAnd); 
        
        Grilla.setRowSorter(sorter);
        
    }//GEN-LAST:event_rbCelesteActionPerformed

    private void btHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHistorialActionPerformed
        
         int convenio = 0;
        String Texto = "";
        
        if (cbConvenio.getSelectedIndex() == 1){  //FERRETERIA
        
            convenio = 2;
            Texto = "Historial Cantidad Producto Convenio Ferreteria";
        
        }else if (cbConvenio.getSelectedIndex() == 2){  //ASEO
        
            convenio = 3;
            Texto = "Historial Cantidad Producto Convenio Aseo";
        
        }else if (cbConvenio.getSelectedIndex() == 3){  //ALIMENTOS
        
            convenio = 4;
            Texto = "Historial Cantidad Producto Convenio Alimentos";
        
        }else if (cbConvenio.getSelectedIndex() == 4){  //ESCRITORIO
        
            convenio = 7;
            Texto = "Historial Cantidad Producto Convenio Escritorio";
            
        }else if (cbConvenio.getSelectedIndex() == 5){  //INSUMOS MEDICOS
                
            convenio = 9;
            Texto = "Historial Cantidad Producto Convenio Médicos";
        
        }else if (cbConvenio.getSelectedIndex() == 6){  //EMERGENCIA
                
            convenio = 11;
            Texto = "Historial Cantidad Producto Convenio Emergencia";
        
        }
        
        
        
        
        jdHistorialConveniosCant HC = new jdHistorialConveniosCant(null, true);
        HC.setLocationRelativeTo(null);
        HC.setLocation(450, 200);
        HC.setTitle("");
        HC.SetDatos(convenio, "");
        HC.setVisible(true);
        
        
    }//GEN-LAST:event_btHistorialActionPerformed
     
    
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
     
    private void CargaConvenios(){
        
        ResultSet Rs;
        ExeSql Sql = new ExeSql();
        
        try{
            
            cbConvenio.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
            cbConvenioId.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
            
            cbConvenio.addItem("SELECCIONE CONVENIO PARA FILTRAR");
            cbConvenioId.addItem("0");
            
            Rs = Sql.Select("select codigo,convenio\n" +
                            "from par_convenio where codigo in ('2','3','4','11','7','9') order by codigo");
                    
            while(Rs.next()){
            
                cbConvenio.addItem(Rs.getString("convenio"));
                cbConvenioId.addItem(String.valueOf(Rs.getInt("codigo")));
            }
        
            cbConvenio.setSelectedIndex(0);
        }catch(Exception e){
            
            fmMain.Mensaje("Error al cargar los convenios "+e);
        
        }finally{
            Sql.Close();
        }
    }
    
    
    
    public void SetUsuario(String usuario)
    {
        Usuario = usuario;
        
    } 
    
    
    
    
    class Elrender extends DefaultTableCellRenderer {
         
        @Override
        public Component getTableCellRendererComponent(JTable tabla, Object valor, boolean isSelected, boolean hasFocus, int fila, int columna) {
            
            super.getTableCellRendererComponent(tabla,valor,isSelected, hasFocus, fila, columna);
            
            if (columna == 5 || columna == 6 || columna == 8 || columna == 10 || columna == 12){
                
                this.setHorizontalAlignment(RIGHT);
                
            }else if (columna == 7 || columna == 9 || columna == 11 || columna == 13) {    
                
                this.setHorizontalAlignment(CENTER);
                
            }else{
                this.setHorizontalAlignment(LEADING);
            }
            

            
            if( tabla.getValueAt(fila,18).toString().trim().equals("ConStock") && 
               (!tabla.getValueAt(fila,1).toString().trim().isEmpty() && !tabla.getValueAt(fila,1).toString().trim().contains(" "))){
            
            
                 if(isSelected==true){
                
                    this.setForeground(Color.white);
                    this.setBackground(Color.blue);    
                    this.setFont(new Font("Tahoma", Font.BOLD, 11));
                 
                 }else{
                  
                    this.setForeground(DARK_GREEN); 
                    this.setBackground(Color.white);   
                    
                    this.setFont(new Font("Tahoma", Font.BOLD, 11));
                 }
            
            }else if (tabla.getValueAt(fila,18).toString().trim().equals("SinStock")){ //no habilitados
                
                
                 if(isSelected==true){
                    
                    this.setForeground(Color.white);
                    this.setBackground(Color.blue);   
                     this.setFont(new Font("Tahoma", Font.BOLD, 11));
                    
                
                }else {
                
                    this.setForeground(Color.blue);    
                    this.setBackground(Color.white);   
                    this.setFont(new Font("Tahoma", Font.BOLD, 11));
                
                }
            
            }else  if (tabla.getValueAt(fila,18).toString().trim().equals("Nocomr")){   //no comerializados
                
                    if(isSelected==true){
                
                        this.setForeground(Color.white);
                        this.setBackground(Color.blue);   
                        this.setFont(new Font("Tahoma", Font.BOLD, 11));
                    
                
                    }else {
                                
                        this.setForeground(Color.red); 
                        this.setBackground(Color.white);   
                        this.setFont(new Font("Tahoma", Font.BOLD, 11));
                    }
                
                
            
            }else if( tabla.getValueAt(fila,18).toString().trim().equals("ConStock") && 
                     (tabla.getValueAt(fila,1).toString().trim().isEmpty() || tabla.getValueAt(fila,1).toString().trim().contains(" "))){
            
                if(isSelected==true){
                
                    this.setForeground(Color.white);
                    this.setBackground(Color.blue);       
                    this.setFont(new Font("Tahoma", Font.BOLD, 11));
                    
                
                }else {
                
                    this.setForeground(BLACK_GRAY); 
                    this.setBackground(Color.white);   
                    this.setFont(new Font("Tahoma", Font.BOLD, 11));
                } 
            
            }else{          // Todos
                
                if(isSelected==true){
                
                    this.setForeground(Color.white);
                    this.setBackground(Color.blue);   
                    
                }else{
                
                    this.setForeground(Color.black);
                    this.setBackground(Color.white);   
                    
                }
            }
            
            
            
            if (cbConvenioId.getSelectedItem().equals("3")){ //no habilitados aseo
                
                    
                    if( tabla.getValueAt(fila,18).toString().trim().equals("noActivo") && 
                        (!tabla.getValueAt(fila,1).toString().trim().isEmpty() && !tabla.getValueAt(fila,1).toString().trim().equals(" "))){    
                    
                        
                         if(isSelected==true){
                    
                            this.setForeground(Color.white);
                            this.setBackground(Color.blue);   
                            this.setFont(new Font("Tahoma", Font.BOLD, 11));
                    
                
                        }else {
                
                            this.setForeground(DARK_GREEN);    
                            this.setBackground(Color.white);   
                            this.setFont(new Font("Tahoma", Font.BOLD, 11));
                
                        }
                    
                    
                    }else if( tabla.getValueAt(fila,18).toString().trim().equals("noActivo") && 
                        (tabla.getValueAt(fila,1).toString().trim().isEmpty() || tabla.getValueAt(fila,1).toString().trim().contains(" "))){    
                    
                        
                         if(isSelected==true){
                    
                            this.setForeground(Color.white);
                            this.setBackground(Color.blue);   
                            this.setFont(new Font("Tahoma", Font.BOLD, 11));
                    
                
                        }else {
                
                            this.setForeground(Color.blue);    
                            this.setBackground(Color.white);   
                            this.setFont(new Font("Tahoma", Font.BOLD, 11));
                
                        }
                    
                    
                    }
                
            
            
            }
            
            
            
            
            
            if (tabla.getValueAt(fila,17).toString().trim().equals("1")){       //ID Nuevo
            
                
                if(isSelected==true){
                
                        this.setForeground(Color.yellow);
                        this.setBackground(BLACK_GRAY);       
                        this.setFont(new Font("Tahoma", Font.BOLD, 11));
                    
                
                }else {
                
                        this.setBackground(Color.yellow);   
                        this.setFont(new Font("Tahoma", Font.BOLD, 11));
                } 
            
            }
            
            
             if ((boolean) tabla.getValueAt(fila,21)){       //ID no Ofertar
                
                this.setForeground(Color.BLACK);
                this.setBackground(Color.CYAN);       
                this.setFont(new Font("Tahoma", Font.BOLD, 11));
            
            }
             
             
             
             if (valor instanceof Integer){
           
                int bvalor = (int)valor;
         
                if (columna == 27){
                
                    if (bvalor == 1){
             
                     this.setBackground(Color.ORANGE);
                     this.setForeground(Color.ORANGE);
             
                    }else{
                   
                        this.setBackground(Color.white);
                        this.setForeground(Color.white);
            
                    }
                }
            }
            
            
            return this;
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CopiarDesc;
    private javax.swing.JMenuItem CopiarID;
    private javax.swing.JMenuItem CopiarIDMADRE;
    private javax.swing.JTable Grilla;
    private javax.swing.JMenuItem VerProductos;
    private javax.swing.JButton btExportar;
    private javax.swing.JButton btHistorial;
    private javax.swing.JButton btHistorialNuevos;
    private javax.swing.JButton btMarca;
    private javax.swing.JButton btMarcasNuevas;
    private javax.swing.JButton btOfertar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbConvenio;
    private javax.swing.JComboBox cbConvenioId;
    private javax.swing.JComboBox cbRegion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbAmarillo;
    private javax.swing.JLabel lbAzul;
    private javax.swing.JLabel lbCeleste;
    private javax.swing.JLabel lbFechaActualizacion;
    private javax.swing.JLabel lbGris;
    private javax.swing.JLabel lbRojo;
    private javax.swing.JLabel lbTodos;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JLabel lbTotalLuv;
    private javax.swing.JLabel lbTotalProd;
    private javax.swing.JLabel lbVerde;
    private javax.swing.JRadioButton rbAmarillo;
    private javax.swing.JRadioButton rbAzul;
    private javax.swing.JRadioButton rbCeleste;
    private javax.swing.JRadioButton rbGris;
    private javax.swing.JRadioButton rbRojo;
    private javax.swing.JRadioButton rbTodos;
    private javax.swing.JRadioButton rbVerde;
    private javax.swing.JTextField txFiltro;
    private javax.swing.JTextField txFiltroMarcas;
    // End of variables declaration//GEN-END:variables
}
