
package PanelForm;

import Conexion.ExeSql;
import Formularios.fmMain;
import static Formularios.fmMain.pnPestanas;
import Utilidades.PanelTab;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author Roberto Lopez
 */
public class pfFechaVencimiento extends javax.swing.JPanel {
    
    DefaultTableModel TModelo;
    Date hoy = new Date();
   
    Calendar cal = Calendar.getInstance();
    int mesant = cal.get(Calendar.MONTH)+1;         // El Mes actual
    int anant = cal.get(Calendar.YEAR);             // El Año actual
        
    private String mes = String.valueOf(mesant);       
    private String agno = String.valueOf(anant);     
   
   
    int verde, azul, negro, magenta, rojo, total = 0;
    int verde1, azul1, negro1, magenta1, rojo1, total1 = 0;
   
    String Fecha = "";
    SimpleDateFormat FormatoFecha = new SimpleDateFormat("dd-MM-yyyy");
   
    public static Color DARK_GREEN = new Color(0,153,0);
    
    
    
    public pfFechaVencimiento() {          
        
        initComponents();
        TModelo = (DefaultTableModel) Grilla.getModel();
        btCargar.setVisible(false);
        btCargar.doClick();
        
     }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btCargar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Grilla = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        txFiltro = new javax.swing.JTextField();
        cbFiltro = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblAzul = new javax.swing.JLabel();
        lblVerde = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblNegro = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lblMagenta = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblRojo = new javax.swing.JLabel();
        btExportar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblRojo1 = new javax.swing.JLabel();
        lblMagenta1 = new javax.swing.JLabel();
        lblNegro1 = new javax.swing.JLabel();
        lblAzul1 = new javax.swing.JLabel();
        lblVerde1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1233, 660));
        setMinimumSize(new java.awt.Dimension(0, 0));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1233, 660));

        btCargar.setText("Cargar");
        btCargar.setToolTipText("");
        btCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCargarActionPerformed(evt);
            }
        });

        Grilla.setAutoCreateRowSorter(true);
        Grilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Item", "Producto", "Fecha Venc.", "Cantidad", "Id Venc.", "Nro. Dias Venc."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

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
            Grilla.getColumnModel().getColumn(0).setMinWidth(85);
            Grilla.getColumnModel().getColumn(0).setPreferredWidth(85);
            Grilla.getColumnModel().getColumn(0).setMaxWidth(85);
            Grilla.getColumnModel().getColumn(2).setMinWidth(85);
            Grilla.getColumnModel().getColumn(2).setPreferredWidth(85);
            Grilla.getColumnModel().getColumn(2).setMaxWidth(85);
            Grilla.getColumnModel().getColumn(3).setMinWidth(75);
            Grilla.getColumnModel().getColumn(3).setPreferredWidth(75);
            Grilla.getColumnModel().getColumn(3).setMaxWidth(75);
            Grilla.getColumnModel().getColumn(4).setMinWidth(80);
            Grilla.getColumnModel().getColumn(4).setPreferredWidth(80);
            Grilla.getColumnModel().getColumn(4).setMaxWidth(80);
            Grilla.getColumnModel().getColumn(5).setMinWidth(90);
            Grilla.getColumnModel().getColumn(5).setPreferredWidth(90);
            Grilla.getColumnModel().getColumn(5).setMaxWidth(90);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 949, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/search16.png"))); // NOI18N
        jLabel14.setText("BUSCAR:");

        txFiltro.setEnabled(false);
        txFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txFiltroKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txFiltroKeyTyped(evt);
            }
        });

        cbFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "< 0  Hasta 7 dias", "Entre 8 y 30 dias", "Entre 31 y 60 dias", "Entre 61 y 90 dias", "91 dias o mas" }));
        cbFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFiltroActionPerformed(evt);
            }
        });

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/search16.png"))); // NOI18N
        jLabel15.setText("FILTRO:");

        jPanel2.setBackground(new java.awt.Color(0, 204, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setPreferredSize(new java.awt.Dimension(24, 16));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(51, 153, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setPreferredSize(new java.awt.Dimension(24, 20));

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("91 dias o Mas");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Entre 61 y 90 dias");

        lblAzul.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAzul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAzul.setText("0");
        lblAzul.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblVerde.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblVerde.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVerde.setText("0");
        lblVerde.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setPreferredSize(new java.awt.Dimension(24, 20));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Entre 31 y 60 dias");

        lblNegro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNegro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNegro.setText("0");
        lblNegro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Entre 8 y 30 dias");

        jPanel8.setBackground(new java.awt.Color(255, 102, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setPreferredSize(new java.awt.Dimension(24, 20));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        lblMagenta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblMagenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMagenta.setText("0");
        lblMagenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel9.setBackground(new java.awt.Color(255, 0, 0));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.setPreferredSize(new java.awt.Dimension(24, 20));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("< 0 hasta 7 dias");

        lblRojo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRojo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRojo.setText("0");
        lblRojo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btExportar.setText("Exportar");
        btExportar.setToolTipText("");
        btExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExportarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Items");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cantidad x Item");

        lblRojo1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRojo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRojo1.setText("0");
        lblRojo1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblMagenta1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblMagenta1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMagenta1.setText("0");
        lblMagenta1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblNegro1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNegro1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNegro1.setText("0");
        lblNegro1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblAzul1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAzul1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAzul1.setText("0");
        lblAzul1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblVerde1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblVerde1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVerde1.setText("0");
        lblVerde1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(178, 178, 178))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(txFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbFiltro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(195, 195, 195)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblVerde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblMagenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblRojo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblAzul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblNegro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblRojo1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lblVerde1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblAzul1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblNegro1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblMagenta1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(9, 9, 9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(txFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(cbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(btExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btCargar)))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblMagenta, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblMagenta1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNegro, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblAzul, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblAzul1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(1, 1, 1))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblVerde, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblVerde1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblRojo1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(lblNegro1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCargarActionPerformed
        
       try {
           ExeSql Sql  = new ExeSql();
           ResultSet Rs;
           String Query = "";
           
           txFiltro.setEnabled(true);
           
           verde = 0;
           azul = 0;
           negro = 0;
           magenta = 0;
           rojo = 0;
           total = 0;
            
           verde1 = 0;
           azul1 = 0;
           negro1 = 0;
           magenta1 = 0;
           rojo1 = 0;
           total1 = 0;
           
           while(TModelo.getRowCount()>0){
               
               TModelo.removeRow(0);
           }
           
           
            Query = "SELECT p.nombre,pv.*, pr.nombre AS proveedor FROM producto_venc pv \n"+
                    "LEFT JOIN producto p ON pv.sku = p.sku \n"+
                    "LEFT JOIN proveedor pr ON pv.rut = pr.rut \n"+
                    "ORDER BY pv.fecha_venc";
           
          
           
           Rs = Sql.Select(Query);
           
           while(Rs.next()){
                
                String sfecha = FormatoFecha.format( Rs.getDate("fecha_venc"));
                String sfechahoy = FormatoFecha.format(hoy);
                Date fecha = FormatoFecha.parse(sfecha);
                Date fechahoy = FormatoFecha.parse(sfechahoy);
                long fec = calculaDias(fecha);
                long fhoy = calculaDias(fechahoy);
                int dias = (int) ((fec - fhoy) / (86400000));
               
                
                
                
                 if (cbFiltro.getSelectedIndex() == 0){
                
                        TModelo.addRow(new Object[]{Rs.getString("sku"), 
                                                    Rs.getString("nombre"), 
                                                    Rs.getDate("fecha_venc"),
                                                    Rs.getString("cantidad_venc"),     
                                                    Rs.getString("id_venc"),
                                                    dias
                                  
             
                        }); 
                            
                           int cantidad = Rs.getInt("cantidad_venc");
                           
                           if(dias <=0 || dias <=7 ){
                           
                              rojo++;  
                              rojo1 = rojo1 + cantidad;
                           
                           }else if(dias >=8 && dias <=30 ){ 
                           
                              magenta++;
                              magenta1 = magenta1 + cantidad;
                               
                           
                           }else if(dias >=31 && dias <=60 ){ 
                           
                               negro++;
                               negro1 = negro1 + cantidad;
                           
                           }else if(dias >=61 && dias <=90 ){ 
                           
                               azul++;
                               azul1 = azul1 + cantidad;
                           
                           }else  if(dias >=91 ){ 
                           
                               verde++;
                               verde1 = verde1 + cantidad;
                           
                           }
                        
                       
                        
                        
                    
                    
                }else if (cbFiltro.getSelectedIndex() == 1){
                
                    
                    if(dias <=0 || dias <=7 ){
                    
                        TModelo.addRow(new Object[]{Rs.getString("sku"), 
                                                    Rs.getString("nombre"), 
                                                    Rs.getDate("fecha_venc"),
                                                    Rs.getString("cantidad_venc"),     
                                                    Rs.getString("id_venc"),
                                                    dias
                                  
             
                        }); 
                        
                        int cantidad = Rs.getInt("cantidad_venc");
                        rojo++;
                        rojo1 = rojo1 + cantidad;
                
                    }
                
                }else if (cbFiltro.getSelectedIndex() == 2){
                
                    if(dias >=8 && dias <=30 ){ 
                    
                         TModelo.addRow(new Object[]{Rs.getString("sku"), 
                                                    Rs.getString("nombre"), 
                                                    Rs.getDate("fecha_venc"),
                                                    Rs.getString("cantidad_venc"),     
                                                    Rs.getString("id_venc"),
                                                    dias
                                  
             
                        }); 
                    
                       int cantidad = Rs.getInt("cantidad_venc");  
                       magenta++; 
                       magenta1 = magenta1 + cantidad;
                    }
                
                }else if (cbFiltro.getSelectedIndex() == 3){
                
                    if(dias >=31 && dias <=60 ){ 
                    
                         TModelo.addRow(new Object[]{Rs.getString("sku"), 
                                                    Rs.getString("nombre"), 
                                                    Rs.getDate("fecha_venc"),
                                                    Rs.getString("cantidad_venc"),     
                                                    Rs.getString("id_venc"),
                                                    dias
                                  
             
                        }); 
                        
                        int cantidad = Rs.getInt("cantidad_venc"); 
                        negro++; 
                        negro1 = negro1 + cantidad;
                    
                    }
                
                }else if (cbFiltro.getSelectedIndex() == 4){
                
                    if(dias >=61 && dias <=90 ){ 
                    
                         TModelo.addRow(new Object[]{Rs.getString("sku"), 
                                                    Rs.getString("nombre"), 
                                                    Rs.getDate("fecha_venc"),
                                                    Rs.getString("cantidad_venc"),     
                                                    Rs.getString("id_venc"),
                                                    dias
                                  
             
                        }); 
                    
                        int cantidad = Rs.getInt("cantidad_venc");  
                        azul++;
                        azul1 = azul1 + cantidad;
                         
                    }
                
                }else if (cbFiltro.getSelectedIndex() == 5){
                
                    if(dias >=91 ){ 
                    
                         TModelo.addRow(new Object[]{Rs.getString("sku"), 
                                                    Rs.getString("nombre"), 
                                                    Rs.getDate("fecha_venc"),
                                                    Rs.getString("cantidad_venc"),     
                                                    Rs.getString("id_venc"),
                                                    dias
                                  
             
                        }); 
                    
                        int cantidad = Rs.getInt("cantidad_venc");   
                        verde++;
                        verde1 = verde1 + cantidad;
                    }
                
                }
                 
                 
            
            
            }
           Grilla.setDefaultRenderer(Object.class, new TableCellRendererFacturas());
           Grilla.repaint();
           
           
           lblRojo.setText(""+rojo);
           lblMagenta.setText(""+magenta);
           lblNegro.setText(""+negro);
           lblAzul.setText(""+azul);
           lblVerde.setText(""+verde);
           
           
           lblRojo1.setText(""+rojo1);
           lblMagenta1.setText(""+magenta1);
           lblNegro1.setText(""+negro1);
           lblAzul1.setText(""+azul1);
           lblVerde1.setText(""+verde1);
           
           
        
          
       } catch (SQLException | ParseException ex) {
           Logger.getLogger(pfFechaVencimiento.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        
    }//GEN-LAST:event_btCargarActionPerformed

    private void txFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txFiltroKeyReleased
       
        TableRowSorter<TableModel>sorter = new TableRowSorter<>(Grilla.getModel());
        Grilla.setRowSorter(sorter);
        String filtro = txFiltro.getText().trim();
       
        if (filtro.length()==0)
        {
            sorter.setRowFilter(null);
        }else{
//            int cant=0;
//            int ev=0;
//            String precio = "";
            sorter.setRowFilter(RowFilter.regexFilter(filtro));
        }
    }//GEN-LAST:event_txFiltroKeyReleased

    private void txFiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txFiltroKeyTyped
        
        if (Character.isLowerCase(evt.getKeyChar()))
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        
    }//GEN-LAST:event_txFiltroKeyTyped

    private void cbFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFiltroActionPerformed
        btCargar.doClick();
    }//GEN-LAST:event_cbFiltroActionPerformed

    private void btExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExportarActionPerformed
        
        File ruta = null;
        File carpeta = null;
                        
        String sSistemaOperativo = System.getProperty("os.name");               //Determina el Sistema Operativo del Equipo 
            
        if (sSistemaOperativo.contains("Win")){        //Si es Windows
            
            carpeta = new File("C:\\temp\\");
            
            if (!carpeta.exists()){
            
                //fmMain.Mensaje("Carpeta NO existe!!");
                carpeta.mkdir();
             
            }
            
            ruta = new File("C:\\temp\\Fechas_Vencimiento"+mes+agno+".xls");               
        
        }else{      //Si es Linux
           
            String NombreMetodo = "getUsername";
            String claseNombre = "com.sun.security.auth.module.UnixSystem";
            Object usuario = null;
            
            if( claseNombre != null ){            //Obtiene el nombre de usuaio de Linux //
                
                try{
                    Class<?> NombreClase = Class.forName(claseNombre);
                    Method metodo = NombreClase.getDeclaredMethod( NombreMetodo );
                    usuario = NombreClase.newInstance();
                    //fmMain.Mensaje(""+method.invoke(usuario));
                    usuario = metodo.invoke(usuario).toString();
                    
                }catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException |
                         InvocationTargetException | NoSuchMethodException | SecurityException ex) {
                    
                    Logger.getLogger(pfFechaVencimiento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            carpeta = new File("/home/"+usuario+"/Escritorio/temp/");  
            
            if (!carpeta.exists()){
               
                carpeta.mkdir();
            }
            
            ruta = new File("/home/"+usuario+"/Escritorio/temp/Fechas_Vencimiento"+mes+agno+".xls");  
            
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
            
            WritableSheet hoja = libro.createSheet("Fechas de Vencimiento", 0);     //Se le asigna nombre a la primera hoja(0) del libro excel
                       
            hoja.setColumnView(0, 15);     //Sku                                //Ancho de la columna (en número de caracteres)
            hoja.setColumnView(1, 80);     //nombre Producto 
            hoja.setColumnView(2, 20);     //Fecha Vencimiento 
            hoja.setColumnView(3, 15);     //Cantidad 
            hoja.setColumnView(4, 15);     //Id Vencimiento 
            hoja.setColumnView(5, 15);     //Nro. Dias 
            
         
            hoja.setRowView(0,26*20);    //la altura de la fila del encabezado
            
    //********************************  Se agregan contenido a las celdas de la hoja  *******************************************        
        
            
            hoja.addCell(new jxl.write.Label(0,0,"Item",format));                //Se agrega fila con el nombre de los encabezados        
            hoja.addCell(new jxl.write.Label(1,0,"Producto",format));
            hoja.addCell(new jxl.write.Label(2,0,"Fecha Vencimiento",format));
            hoja.addCell(new jxl.write.Label(3,0,"Cantidad",format));
            hoja.addCell(new jxl.write.Label(4,0,"Id Vencimiento",format));
            hoja.addCell(new jxl.write.Label(5,0,"Nro. Dias",format));
            
            
            WritableCellFormat format1 = null;
            WritableCellFormat format2 = null;
            
            
            for(int i=0; i < Grilla.getRowCount(); i++){ //For                  //Se agregan filas con los datos
            
                int fila = i+1;
                int dias = Integer.parseInt(Grilla.getValueAt(i,5).toString());
                
                
                if(dias <=0 || dias <=7 ){
                   
                    format1 = formatRojo1;
                    format2 = formatRojo2;
                
                }else if(dias >=8 && dias <=30 ){
                    
                     format1 = formatMagenta1;
                     format2 = formatMagenta2;
                                
                }else if(dias >=31 && dias <=60 ){
                    
                     format1 = formatNegro1;
                     format2 = formatNegro2;
                
                }else if(dias >=61 && dias <=90 ){
                
                     format1 = formatAzul1;
                     format2 = formatAzul2;
                
                }else if(dias >=91 ){
                
                    format1 = formatVerde1;
                    format2 = formatVerde2;
                
                
                }
                   
                hoja.addCell(new jxl.write.Label(0,fila,Grilla.getValueAt(i,0).toString(),format1));
                hoja.addCell(new jxl.write.Label(1,fila,Grilla.getValueAt(i,1).toString(),format1));
                hoja.addCell(new jxl.write.Label(2,fila,Grilla.getValueAt(i,2).toString(),format2));
                hoja.addCell(new jxl.write.Label(3,fila,Grilla.getValueAt(i,3).toString(),format2));
                hoja.addCell(new jxl.write.Label(4,fila,Grilla.getValueAt(i,4).toString(),format2));
                hoja.addCell(new jxl.write.Label(5,fila,Grilla.getValueAt(i,5).toString(),format2));
                
            
            }
            
            
            
    //***************************************************************************************************************************    
            libro.write();          //Se escriben el contenido en el libro
            libro.close();          //se cierra el libro
            
            fmMain.Mensaje("Archivo : Fechas_Vencimiento"+mes+agno+".xls \n creado con éxito");
            
        } catch (WriteException | IOException ex) {
            Logger.getLogger(pfFechaVencimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
        
        
    }//GEN-LAST:event_btExportarActionPerformed

    private void GrillaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrillaMouseClicked
        
        if(evt.getClickCount()==2){
         
             pfProductos Pro = new pfProductos();
            Pro.setOpaque(false);
            pnPestanas.addTab("Producto", Pro);
            PanelTab btc = new PanelTab(pnPestanas, 0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Pro), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
            Pro.txSku.requestFocus();
            Pro.CargaProducto(Grilla.getValueAt(Grilla.getSelectedRow(), 0).toString().trim());        //
         
        }
        
    }//GEN-LAST:event_GrillaMouseClicked

    private long calculaDias(Date fecha){
    
    
        Calendar fecCal = Calendar.getInstance();
            
        fecCal.setTime(fecha);
            
        int agno =  fecCal.get(Calendar.YEAR);
        int mes =  fecCal.get(Calendar.MONTH)+1;
        int dia =  fecCal.get(Calendar.DAY_OF_MONTH);
            
            
        fecCal.set(agno,mes,dia);
        fecCal.set(Calendar.HOUR, 0);
        fecCal.set(Calendar.HOUR_OF_DAY, 0);
        fecCal.set(Calendar.MINUTE, 0);
        fecCal.set(Calendar.SECOND, 0);
        
        long diasfec = fecCal.getTimeInMillis();
    
        return diasfec;
    
    }
    
    
    
    public class TableCellRendererFacturas extends DefaultTableCellRenderer {
    
    private Component c;
    
    @Override
    public Component getTableCellRendererComponent(JTable tabla, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                
        c = super.getTableCellRendererComponent(tabla, value, isSelected, hasFocus, row, column); //Para cambiar la fila 
        
        
        
        int dias = Integer.parseInt(tabla.getValueAt(row, 5).toString());
        
        if(dias <=0 || dias <=7 ){
        
           if(isSelected==true){
                
              this.setBackground(Color.red);
              this.setForeground(Color.white);    
                
           }else{
                
                this.setForeground(Color.red);
                this.setBackground(Color.white);
                
           }
            
        }else if(dias >=8 && dias <=30 ){
        
           if(isSelected==true){
                
              this.setBackground(Color.magenta);
              this.setForeground(Color.white);    
               this.setFont(this.getFont().deriveFont(Font.BOLD));
                
           }else{
                
                this.setForeground(Color.magenta);
                this.setBackground(Color.white);
                 this.setFont(this.getFont().deriveFont(Font.BOLD));
                
           }
            
        }else if(dias >=31 && dias <=60 ){
        
           if(isSelected==true){
                
              this.setBackground(Color.black);
              this.setForeground(Color.white);    
              
                
           }else{
                
                this.setForeground(Color.black);
                this.setBackground(Color.white);
              
           }
            
        }else if(dias >=61 && dias <=90 ){
        
           if(isSelected==true){
                
              this.setBackground(Color.blue);
              this.setForeground(Color.white);    
                
           }else{
                
                this.setForeground(Color.blue);
                this.setBackground(Color.white);
                
           }
            
        }else if(dias >=91 ){
        
           if(isSelected==true){
                
              this.setBackground(DARK_GREEN);
              this.setForeground(Color.white);    
                
           }else{
                
                this.setForeground(DARK_GREEN);
                this.setBackground(Color.white);
                
           }
            
        }
        
        return c;
        
    }

}
   
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Grilla;
    private javax.swing.JButton btCargar;
    private javax.swing.JButton btExportar;
    private javax.swing.JComboBox cbFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAzul;
    private javax.swing.JLabel lblAzul1;
    private javax.swing.JLabel lblMagenta;
    private javax.swing.JLabel lblMagenta1;
    private javax.swing.JLabel lblNegro;
    private javax.swing.JLabel lblNegro1;
    private javax.swing.JLabel lblRojo;
    private javax.swing.JLabel lblRojo1;
    private javax.swing.JLabel lblVerde;
    private javax.swing.JLabel lblVerde1;
    private javax.swing.JTextField txFiltro;
    // End of variables declaration//GEN-END:variables
}
