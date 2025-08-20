/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dialogos;

import Conexion.ExeSql;
import Formularios.fmMain;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author DavidAlcaman
 */
public class jdOfertados_MP extends javax.swing.JDialog {

    
    private int Convenio=0;
    private String NomConvenio = "";
    String Usuario = "";
    
    
    Date hoy = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    Calendar cal = Calendar.getInstance();
    int year  = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH)+1;
    int day = cal.get(Calendar.DAY_OF_MONTH);
    
    ArrayList<ArrayList<String>> Lista  = new ArrayList<>();
    ArrayList<ArrayList<String>> Lista2  = new ArrayList<>();
    
    static String ID = "";
    static int Correlativo = 0;
    
    
    public jdOfertados_MP(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        cal.setTime(hoy);
        cal.add(Calendar.DATE, 1);
        hoy = cal.getTime();
        
        dtFecInicio.setDate(hoy);
        dtFecInicio.getEditor().setEditable(false);     //bloquea entrada de fecha en forma manual
        
        DefaultTableCellRenderer headerRenderer1 = new DefaultTableCellRenderer();
        headerRenderer1.setBackground(new Color(255,211,140));  //Naranjo Claro
        
        DefaultTableCellRenderer headerRenderer11 = new DefaultTableCellRenderer();
        headerRenderer11.setBackground(new Color(239, 198, 46));  //Naranjo
        
        
        DefaultTableCellRenderer headerRenderer12 = new DefaultTableCellRenderer();
        headerRenderer12.setBackground(new Color(255,153,0));  //Naranjo Oscuro
        
        DefaultTableCellRenderer headerRenderer2 = new DefaultTableCellRenderer();  
        headerRenderer2.setBackground(new Color(0, 204, 255));  //Celeste Oscuro
        
        DefaultTableCellRenderer headerRenderer3 = new DefaultTableCellRenderer();
        headerRenderer3.setBackground(new Color(102, 204, 0));   //Verde Musgo
        
        DefaultTableCellRenderer headerRenderer4 = new DefaultTableCellRenderer();
        headerRenderer4.setBackground(new Color(255, 102, 51));   //Rojizo
        
        DefaultTableCellRenderer headerRenderer5 = new DefaultTableCellRenderer();
        headerRenderer5.setBackground(new Color(0,204,204));   //Calipso oscuro
        
        DefaultTableCellRenderer headerRenderer6 = new DefaultTableCellRenderer(); 
        headerRenderer6.setBackground(new Color(255,204,204));   //Rosado
        
        
        Grilla.getColumnModel().getColumn(3).setHeaderRenderer(headerRenderer1);
        Grilla.getColumnModel().getColumn(4).setHeaderRenderer(headerRenderer1);
        
        Grilla.getColumnModel().getColumn(5).setHeaderRenderer(headerRenderer11);
        Grilla.getColumnModel().getColumn(6).setHeaderRenderer(headerRenderer11);
        
        Grilla.getColumnModel().getColumn(7).setHeaderRenderer(headerRenderer12);
        Grilla.getColumnModel().getColumn(8).setHeaderRenderer(headerRenderer12);
        
        Grilla.getColumnModel().getColumn(9).setHeaderRenderer(headerRenderer2);
        Grilla.getColumnModel().getColumn(10).setHeaderRenderer(headerRenderer2);
        
        Grilla.getColumnModel().getColumn(11).setHeaderRenderer(headerRenderer3);
        Grilla.getColumnModel().getColumn(12).setHeaderRenderer(headerRenderer3);
        
        Grilla.getColumnModel().getColumn(13).setHeaderRenderer(headerRenderer4);
        Grilla.getColumnModel().getColumn(14).setHeaderRenderer(headerRenderer4);
        
        Grilla.getColumnModel().getColumn(15).setHeaderRenderer(headerRenderer5);
        Grilla.getColumnModel().getColumn(16).setHeaderRenderer(headerRenderer5);
        
        Grilla.getColumnModel().getColumn(17).setHeaderRenderer(headerRenderer6);
        Grilla.getColumnModel().getColumn(18).setHeaderRenderer(headerRenderer6);
        
        lbSubiendo.setText("");
        
        txRutMP.setVisible(false);
      
        btActualizarCotizados.setVisible(false);
       
       
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);   //controla la implementación del evento setDefaultCloseOperation de Window Listener
        
        addWindowListener(new WindowAdapter() {                  //para realizar una acción distinta 
           
            @Override                                            //cuando se cierre directamente la ventana sin elegir una opcion
            public void windowClosing(WindowEvent e) {
                      
                btActualizarCotizados.setEnabled(true);
                btActualizarCotizados.doClick();
                
            }
                
        
        });
       
    }

    
    public void SetDatos(int convenio, String texto, ArrayList<ArrayList<String>> Listapaso, String usuario){
        Convenio=convenio;
        NomConvenio=texto;
        
        Lista.clear();
        Lista = Listapaso;
        
        Usuario = usuario;
        
        System.out.println("El USUARIO ES :"+Usuario );
        
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        
        
        try {
            
            Rs = Sql.Select("select rutmp from personal \n" +
                            "where usuario IN ('"+Usuario.trim()+"')" );
            
             if (Sql.GetRowCount() > 0){ //condicional
            
                Rs.next();
                
                txRutMP.setText(Rs.getString("rutmp").trim());
                
            }    
            
            Inicializa();
            
        } catch (SQLException ex) {
            Logger.getLogger(jdOfertados_MP.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
     
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        Grilla = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        dtFecInicio = new org.jdesktop.swingx.JXDatePicker();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txDias = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txMinimo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txClaveMP = new javax.swing.JPasswordField();
        btOfertar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        lbSubiendo = new javax.swing.JLabel();
        txRutMP = new javax.swing.JTextField();
        btActualizarCotizados = new javax.swing.JButton();
        chkChrome = new javax.swing.JCheckBox();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1820, 720));

        Grilla.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Grilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Madre", "Producto", "Convenio", "Costo", "Costo+IVA", "Precio Venta", "%  Luvaly", "Venta - 5%", "Margen - 5%", "   1ro.", "% 1ro.", "   2do.", "% 2do.", "   3ro.", "% 3ro.", "   4to.", "% 4to.", "   5to.", "% 5to.", "Oferta", "% Oferta", "ID", "ucompra", "ucosto", "error"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false
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
        Grilla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GrillaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(Grilla);
        if (Grilla.getColumnModel().getColumnCount() > 0) {
            Grilla.getColumnModel().getColumn(0).setPreferredWidth(70);
            Grilla.getColumnModel().getColumn(1).setPreferredWidth(350);
            Grilla.getColumnModel().getColumn(2).setMinWidth(0);
            Grilla.getColumnModel().getColumn(2).setPreferredWidth(0);
            Grilla.getColumnModel().getColumn(2).setMaxWidth(0);
            Grilla.getColumnModel().getColumn(5).setPreferredWidth(100);
            Grilla.getColumnModel().getColumn(6).setMinWidth(60);
            Grilla.getColumnModel().getColumn(6).setPreferredWidth(60);
            Grilla.getColumnModel().getColumn(6).setMaxWidth(60);
            Grilla.getColumnModel().getColumn(7).setPreferredWidth(90);
            Grilla.getColumnModel().getColumn(8).setPreferredWidth(100);
            Grilla.getColumnModel().getColumn(21).setMinWidth(0);
            Grilla.getColumnModel().getColumn(21).setPreferredWidth(0);
            Grilla.getColumnModel().getColumn(21).setMaxWidth(0);
            Grilla.getColumnModel().getColumn(22).setMinWidth(0);
            Grilla.getColumnModel().getColumn(22).setPreferredWidth(0);
            Grilla.getColumnModel().getColumn(22).setMaxWidth(0);
            Grilla.getColumnModel().getColumn(23).setMinWidth(0);
            Grilla.getColumnModel().getColumn(23).setPreferredWidth(0);
            Grilla.getColumnModel().getColumn(23).setMaxWidth(0);
            Grilla.getColumnModel().getColumn(24).setMinWidth(40);
            Grilla.getColumnModel().getColumn(24).setPreferredWidth(40);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        dtFecInicio.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("Fecha Inicio");

        jLabel2.setText("N° de Dias");

        txDias.setText("0");
        txDias.setToolTipText("");
        txDias.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txDiasFocusLost(evt);
            }
        });
        txDias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txDiasKeyTyped(evt);
            }
        });

        jLabel3.setText("Minimo ");

        txMinimo.setText("5");
        txMinimo.setToolTipText("");
        txMinimo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txMinimoKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Clave Mercado Público  ");

        txClaveMP.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtFecInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txDias, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txClaveMP, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(dtFecInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txClaveMP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btOfertar.setText("Subir Oferta");
        btOfertar.setToolTipText("");
        btOfertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOfertarActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        lbSubiendo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbSubiendo.setText("Subiendo Ofertas");
        lbSubiendo.setToolTipText("");

        txRutMP.setToolTipText("");
        txRutMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txRutMPActionPerformed(evt);
            }
        });

        btActualizarCotizados.setText("Actualizar Cotizados");
        btActualizarCotizados.setToolTipText("");
        btActualizarCotizados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActualizarCotizadosActionPerformed(evt);
            }
        });

        chkChrome.setText("Mostrar Página");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txRutMP, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btOfertar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(chkChrome, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(109, 109, 109)
                                        .addComponent(lbSubiendo, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1058, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btActualizarCotizados, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 88, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSubiendo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btOfertar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkChrome)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txRutMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addComponent(btActualizarCotizados, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Inicializa(){
     
        DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
        
        while (TableModel.getRowCount() > 0) {
            TableModel.removeRow(0);
        }
        
        
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        
        String vcosto = "0";
        String vcostoiva = "0";
        
        String voferta = "0";
        
        String vcostovalidacion = "0";
        
        int validaiva = 0;
        
        
        System.out.println("El Tamaño de Lista.size() ES :"+Lista.size());
        
        for (int i = 0; i < (Lista.size()); i++) {
             
            if (i < (Lista.size()-i) || i == 0){ 
             
                Lista.add(new ArrayList<String>()); 
               
                try {
                    Rs = Sql.Select("select valor_costo, valor_oferta from codchile \n" +
                                    "where idch IN ('"+Lista.get(i).get(18)+"')" );  //Id hija
                    
                    
                    if (Sql.GetRowCount() > 0){
            
                        Rs.next();
                        
                        vcosto = Rs.getString("valor_costo");
                        vcostovalidacion = Rs.getString("valor_costo");
                        
                        if (vcosto.trim().equals("0")){
                        
                            vcosto = Lista.get(i).get(3);
                        
                        }
                        
                        voferta = Rs.getString("valor_oferta");
                        
                    }else{
                    
                        vcosto = Lista.get(i).get(3);
                        vcostovalidacion = "0";
                        
                        voferta = "0";
                        
                    
                    }   
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(jdOfertados_MP.class.getName()).log(Level.SEVERE, null, ex);
                }
            
               
                
                if (Lista.get(i).get(2).trim().equals("4")){  //Si es el convenio ALIMENTOS, se agrega el IVA al costo
                
                
                    double costociva =  Math.round(Double.valueOf(vcosto.trim().replaceAll("\\,","")) * 1.19);
                    vcostoiva = String.valueOf(costociva);
                    
                
                }else{
                
                    vcostoiva = vcosto;
                    
                
                }
           
                int error = 1;
                
                TableModel.addRow(new Object[]{
                            Lista.get(i).get(0),  //ID Madre
                            Lista.get(i).get(1),  //Descripcion  
                            Lista.get(i).get(2),  //Convenio
                            vcosto,
                            vcostoiva,
                            Lista.get(i).get(4),  //Venta Luvaly  
                            Lista.get(i).get(5),  //Margen Luvaly
                            Lista.get(i).get(6),  //Luvaly - Minimo
                            Lista.get(i).get(7),  //Margen Luvaly - Minimo 
                            Lista.get(i).get(8),  //Venta 1ro.  
                            Lista.get(i).get(9),  //Margen 1ro.    
                            Lista.get(i).get(10), //Venta 2do.
                            Lista.get(i).get(11), //Margen 2do.
                            Lista.get(i).get(12), //Valor 3ro.
                            Lista.get(i).get(13), //Margen 3ro.
                            Lista.get(i).get(14), //Valor 4to.
                            Lista.get(i).get(15), //Margen 4to.
                            Lista.get(i).get(16), //Valor 5to.
                            Lista.get(i).get(17), //Margen 5to
                            voferta,
                            "0 %",
                            Lista.get(i).get(18), //ID hija
                            vcostoiva, //valutlcompra para validacion
                            vcostovalidacion,  //costo oferta para validacion
                            error  //validacion posterior de error
                                             
                });
              
                
            }
            
        
        }
         
        
         
         
        double margenluvmin = 0; 
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
        
        
        double margenoferta =  0;
        
        double Minimo = Double.parseDouble(txMinimo.getText().trim())/100;
        
         
        for(int i=0; i < Grilla.getRowCount(); i++){
            
            double costo = Double.parseDouble(Grilla.getValueAt(i, 4).toString().trim().replaceAll("\\,",""));
                
            double ventaluv = Double.parseDouble(Grilla.getValueAt(i, 5).toString().trim().replaceAll("\\,",""));
            
            double ventaluvmin = Math.round(ventaluv - (ventaluv*Minimo));
            
            if (costo > 0){
                
                margenluv =  Math.round(((ventaluv - costo)  / ventaluv) * 100);
            
                margenluvmin =  Math.round(((ventaluvmin - costo)  / ventaluvmin) * 100);
                
                
                ventaprimero = Double.parseDouble(Grilla.getValueAt(i, 9).toString().trim().replaceAll("\\,",""));
                margenprimero =  Math.round(((ventaprimero - costo)  / ventaprimero) * 100);
                                
                ventasegundo = Double.parseDouble(Grilla.getValueAt(i, 11).toString().trim().replaceAll("\\,",""));
                margensegundo =  Math.round(((ventasegundo - costo)  / ventasegundo) * 100);
                                
                ventatercero = Double.parseDouble(Grilla.getValueAt(i, 13).toString().trim().replaceAll("\\,",""));
                margentercero =  Math.round(((ventatercero - costo)  / ventatercero) * 100);
                                
                ventacuarto = Double.parseDouble(Grilla.getValueAt(i, 15).toString().trim().replaceAll("\\,",""));
                margencuarto =  Math.round(((ventacuarto - costo)  / ventacuarto) * 100);
                
                ventaquinto = Double.parseDouble(Grilla.getValueAt(i, 17).toString().trim().replaceAll("\\,",""));
                margenquinto =  Math.round(((ventaquinto - costo)  / ventaquinto) * 100);
                
                
                
                
                
                
                double oferta = Double.parseDouble(Grilla.getValueAt(i, 19).toString().trim().replaceAll("\\,",""));
               
                if (oferta > 0){
                        
                    margenoferta =  Math.round(((oferta - costo)  / oferta) * 100);
                        
                
                }else if (oferta == 0) {
                
                    margenoferta =  0;
                    
                }
                
                
                
            
            }else {
            
                margenluv = 0;
                margenluvmin = 0;
                
                margenprimero = 0; 
                margensegundo = 0; 
                margentercero = 0; 
                margencuarto = 0; 
                margenquinto = 0; 
                margenoferta =  0;
            }
            
            Grilla.setValueAt(fmMain.FormatoNumeroSinDecimal(Math.round(costo)), i, 4);
            
            Grilla.setValueAt(Math.round(margenluv)+ " %", i, 6);
            
            Grilla.setValueAt(fmMain.FormatoNumeroSinDecimal(Math.round(ventaluvmin)), i, 7);
            Grilla.setValueAt(Math.round(margenluvmin)+ " %", i, 8);
            
            
            Grilla.setValueAt(Math.round(margenprimero)+ " %", i, 10);
            Grilla.setValueAt(Math.round(margensegundo)+ " %", i, 12);
            Grilla.setValueAt(Math.round(margentercero)+ " %", i, 14);
            Grilla.setValueAt(Math.round(margencuarto)+ " %", i, 16);
            Grilla.setValueAt(Math.round(margenquinto)+ " %", i, 18);
            
            Grilla.setValueAt(Math.round(margenoferta)+ " %", i, 20);
           
        } 
         
         
         
         
         
        
       /**************  ORDENAR TABLA *****************************************/  
         
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(Grilla.getModel());
        Grilla.setRowSorter(sorter);
        
        List<RowSorter.SortKey> sortKeys = new ArrayList();
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));  //Ordenar por primera columna en forma ascendente
        sorter.setSortKeys(sortKeys);
        
        
        
        Grilla.setDefaultRenderer(Object.class, new Elrender()); 
        
        
        String ID = "0";
        
        int cont = 0;
        int fila = -1;
        
        
        Lista2.clear();  //Se usa para almacenar el listado de ID Madres
        
        for(int i=0; i < Grilla.getRowCount(); i++){
            
            String ID2 = Grilla.getValueAt(i, 0).toString().trim();
                    
            if (!ID2.trim().equals(ID)){  //Si es una nueva ID Madre
        
                fila++;  //Pasa a la siguiente Fila de la Lista2
                
                Lista2.add(new ArrayList<String>());
                
                cont = 1; //el contador de ID Hijas comienza en 1
                
                Lista2.get(fila).add(0,Grilla.getValueAt(i, 0).toString().trim());  //ID Madre
                Lista2.get(fila).add(1,""+cont);    //Cuantas ID Hijas
                
              
            
            }else if (ID2.trim().equals(ID)){  //Si es la misma ID Madre
                
                cont++; //el contador de ID Hijas cuenta 1 ID hija mas
            
                Lista2.get(fila).set(1,""+cont);    //Cuantas ID Hijas
            
                //Se mantiene en la misma de fila de la Lista2
                
                
            }
            
            ID = ID2;
                
        }
        
        
        

    
    }
    
    
    
    private void GrillaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GrillaKeyPressed
       
       
       
        double costo = 0;
        double costoiva = 0;
        
        double ventaluv = 0;
        double margenluv = 0; 
        
        double ventaluvmin = 0;
        double margenluvmin = 0; 
        
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
        
        double Minimo = Double.parseDouble(txMinimo.getText().trim())/100;
        
        double costoverifica = 0;
        double costofertaverifica = 0;
                
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            
            
            costo = Double.parseDouble(Grilla.getValueAt(Grilla.getSelectedRow(), 3).toString().trim().replaceAll("\\,",""));
            
            if (Grilla.getValueAt(Grilla.getSelectedRow(), 2).toString().trim().equals("4")){  //Si es el convenio ALIMENTOS, se agrega el IVA al costo
                
                costoiva =  Math.round(costo * 1.19);
                    
                
            }else{
                
                costoiva = costo;
                    
                
            }
            
            
            Grilla.setValueAt(fmMain.FormatoNumeroSinDecimal(Math.round(costoiva)), Grilla.getSelectedRow(), 4);
            
            
            
            
            costoverifica = Double.parseDouble(Grilla.getValueAt(Grilla.getSelectedRow(), 22).toString().trim().replaceAll("\\,",""));
            costofertaverifica = Double.parseDouble(Grilla.getValueAt(Grilla.getSelectedRow(), 23).toString().trim().replaceAll("\\,",""));
            
            int columna = Grilla.getSelectedColumn(); // luego, obtengo la columna seleccionada
            
            if (columna == 3){  //Si es la columna 3 (costo) 
            
                if (costoiva > 0){
            
                    
                    if (costoiva < costoverifica){
                    
                        int res = JOptionPane.showConfirmDialog(null, "El monto es menor al costo, \n está seguro de ingresarlo?.", "Cerrar", JOptionPane.YES_OPTION);
        
                        if(res==JOptionPane.YES_OPTION){
                        
                            
                        
                        
                        }else {
                        
                            
                            Grilla.setValueAt("0", Grilla.getSelectedRow(), 3);
                            Grilla.setValueAt("0", Grilla.getSelectedRow(), 4);
                            return;
                            
                        
                        }
                    
                    
                    }
                    
                    
                    
                    
                    ventaluv = Double.parseDouble(Grilla.getValueAt(Grilla.getSelectedRow(), 5).toString().trim().replaceAll("\\,",""));
                    
                    if (costoiva > ventaluv){
                    
                        fmMain.Mensaje("El Costo no puede ser mayor que el precio de Venta !!");
                        Grilla.setValueAt("0", Grilla.getSelectedRow(), 3);
                        Grilla.setValueAt("0", Grilla.getSelectedRow(), 4);
                        return;
                    
                    }
                    
                    
                    
                    
                    margenluv =  Math.round(((ventaluv - costoiva)  / ventaluv) * 100);
                
                
                    ventaprimero = Double.parseDouble(Grilla.getValueAt(Grilla.getSelectedRow(), 9).toString().trim().replaceAll("\\,",""));
                    margenprimero =  Math.round(((ventaprimero - costoiva)  / ventaprimero) * 100);
                                
                    ventasegundo = Double.parseDouble(Grilla.getValueAt(Grilla.getSelectedRow(), 11).toString().trim().replaceAll("\\,",""));
                    margensegundo =  Math.round(((ventasegundo - costoiva)  / ventasegundo) * 100);
                                
                    ventatercero = Double.parseDouble(Grilla.getValueAt(Grilla.getSelectedRow(), 13).toString().trim().replaceAll("\\,",""));
                    margentercero =  Math.round(((ventatercero - costoiva)  / ventatercero) * 100);
                                
                    ventacuarto = Double.parseDouble(Grilla.getValueAt(Grilla.getSelectedRow(), 15).toString().trim().replaceAll("\\,",""));
                    margencuarto =  Math.round(((ventacuarto - costoiva)  / ventacuarto) * 100);
                
                    ventaquinto = Double.parseDouble(Grilla.getValueAt(Grilla.getSelectedRow(), 17).toString().trim().replaceAll("\\,",""));
                    margenquinto =  Math.round(((ventaquinto - costoiva)  / ventaquinto) * 100);
                
                    if (ventaluv > 0){
                    
                        ventaluvmin = Math.round(ventaluv - (ventaluv*Minimo));
                        margenluvmin =  Math.round(((ventaluvmin - costoiva)  / ventaluvmin) * 100);
                
                    }else if (ventaluv == 0) {
                
                        ventaluvmin = 0;
                        margenluvmin = 0;
                    
                    }
                
                }else{
                
                    margenluv = 0; 
                    margenluvmin = 0;
                    margenprimero = 0; 
                    margensegundo = 0; 
                    margentercero = 0; 
                    margencuarto = 0; 
                    margenquinto = 0; 
               
                    ventaluv = Double.parseDouble(Grilla.getValueAt(Grilla.getSelectedRow(), 5).toString().trim().replaceAll("\\,",""));
               
                    if (ventaluv > 0){
                    
                        ventaluvmin = Math.round(ventaluv - (ventaluv*Minimo));
                        margenluvmin =  Math.round(((ventaluvmin - costoiva)  / ventaluvmin) * 100);
                
                    }else if (ventaluv == 0) {
                
                        ventaluvmin = 0;
                        margenluvmin = 0;
                    
                    }
                
                }
            
            
            
                Grilla.setValueAt(Math.round(margenluv)+ " %", Grilla.getSelectedRow(), 6);
            
                Grilla.setValueAt(Math.round(margenluvmin)+ " %", Grilla.getSelectedRow(), 8);
                Grilla.setValueAt(Math.round(margenprimero)+ " %", Grilla.getSelectedRow(), 10);
                Grilla.setValueAt(Math.round(margensegundo)+ " %", Grilla.getSelectedRow(), 12);
                Grilla.setValueAt(Math.round(margentercero)+ " %", Grilla.getSelectedRow(), 14);
                Grilla.setValueAt(Math.round(margencuarto)+ " %", Grilla.getSelectedRow(), 16);
                Grilla.setValueAt(Math.round(margenquinto)+ " %", Grilla.getSelectedRow(), 18);
            
            
                Grilla.setValueAt(fmMain.FormatoNumeroSinDecimal(Math.round(costo)), Grilla.getSelectedRow(), 3);
                
                Grilla.setValueAt(fmMain.FormatoNumeroSinDecimal(Math.round(ventaluvmin)), Grilla.getSelectedRow(), 7);
            
                Grilla.changeSelection(Grilla.getSelectedRow()-1, 0, false, false);
            
            
            }else if (columna == 19){  //Si es la columna 19 (oferta)
            
                double margenoferta =  0;
                
                if (costoiva > 0){
               
                    
                    String ValidaOferta = Grilla.getValueAt(Grilla.getSelectedRow(), 19).toString().trim();
                    
                    if (ValidaOferta.trim().isEmpty()){
                        
                        Grilla.setValueAt("0", Grilla.getSelectedRow(), 19);
                    
                    }
                    
                    
                    double oferta = Double.parseDouble(Grilla.getValueAt(Grilla.getSelectedRow(), 19).toString().trim().replaceAll("\\,",""));
               
                    if (oferta > 0){
                     
                        if (oferta < costoiva){
                        
                          fmMain.Mensaje("La Oferta no puede ser menor que el Costo !!");
                          Grilla.setValueAt("0", Grilla.getSelectedRow(), 19);
                          return;
                        }
                        
                        margenoferta =  Math.round(((oferta - costoiva)  / oferta) * 100);
                        
                
                    }else if (oferta == 0) {
                
                        margenoferta =  0;
                    
                    }
                
                }else {
                
                    margenoferta =  0;
                
                }
            
                Grilla.setValueAt(Math.round(margenoferta)+ " %", Grilla.getSelectedRow(), 20);
                
            
            }    
            
        }
        
        
        
    }//GEN-LAST:event_GrillaKeyPressed

    private void GrillaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrillaMouseClicked
       
        if(evt.getClickCount()==2){
        
            int columna = Grilla.getSelectedColumn(); // obtengo la columna seleccionada
            
            
            if (columna == 3){
            
                Grilla.setValueAt("", Grilla.getSelectedRow(), 3);
                
                
            }else if (columna == 18){
            
                 System.out.println("LA columna ES :"+columna);
                
                Grilla.setValueAt("", Grilla.getSelectedRow(), 18);
            }
        
        }
        
    }//GEN-LAST:event_GrillaMouseClicked

    private void btOfertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOfertarActionPerformed
         

        
        try {
            String dias_ofertar = txDias.getText().trim();
            String fecha_inicio_ofer = sdf.format(dtFecInicio.getDate()).toString().trim();
            
            System.out.println("EL convenio ES :"+Convenio);
            
            if (Integer.valueOf(txDias.getText().trim()) <= 0 ){
                
                fmMain.Mensaje("Debe Ingresar un número de Días válido...!");
                txDias.requestFocus();
                return;
                
            }
            
            
            SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
            Date finicio = dtFecInicio.getDate();
            Date factual = new Date();
            
            String fecinicio = date.format(finicio);
            String fecactual = date.format(factual);
            
            Date finicio2 = date.parse(fecinicio);
            Date factual2 = date.parse(fecactual); 
            
            long dif = finicio2.getTime() - factual2.getTime();
            long dias =  dif /(1000*60*60*24);  //Transforma millisegundos a días
            
            System.out.println("Hay " + dias + " dia(s) de diferencia");
            
            
            if (dias <=0){
            
                fmMain.Mensaje("Fecha debe ser Mayor a la actual...!");
                return;
            
            }
            
            
            
            if (Integer.valueOf(txMinimo.getText().trim()) <= 0 ){
                
                fmMain.Mensaje("Debe Ingresar un Mínimo válido...!");
                txMinimo.requestFocus();
                return;
                
            }
            
            
            int error = 0;
            
            
            for (int i=0; i< Grilla.getRowCount();i++){
            
                int valor = Integer.valueOf(Grilla.getValueAt(i, 19).toString().trim().replaceAll("\\,", ""));
                int elcosto = Integer.valueOf(Grilla.getValueAt(i, 4).toString().trim().replaceAll("\\,", ""));
                
                
                if (elcosto <=0){
                
                    error = 1;
                    break;
                
                }
                
                
            
                if (valor <=0){
                
                    error = 2;
                    break;
                
                }
                
                
                if (valor < elcosto){
                
                    error = 3;
                    break;
                
                }
                
            
            
            }
            
            
            if (error == 1){
            
               fmMain.Mensaje("Existe una ID con costo cero...!");
               return;
                
            
            }
            
            
            
            if (error == 2){
            
               fmMain.Mensaje("Existe una ID sin precio oferta...!");
               return;
                
            
            }
            
            
            if (error == 3){
            
               fmMain.Mensaje("Existe(n) ID(s) con valor oferta menor al costo !!");
               return;
                
            
            }
           
            
            
            
            
            if (txClaveMP.getText().trim().isEmpty()){
            
               fmMain.Mensaje("Debe Ingresar Clave Mercado Público...!");
               txClaveMP.requestFocus();
               return;
            
            
            }
            
            
            
            
            lbSubiendo.setText("Subiendo Ofertas.....");
            URL urlInfo =  this.getClass().getResource("/Iconos/Carga.gif");
            ImageIcon IconoInfo =  new ImageIcon(urlInfo); 
            lbSubiendo.setIcon(IconoInfo);
            lbSubiendo.setForeground(Color.red); 
            
            Runnable miRunnable = new Runnable() {
          
                public void run() {
            
                    lbSubiendo.setVisible(true);
                    btActualizarCotizados.setEnabled(false);
                    
                    CARGA(Convenio, dias_ofertar, fecha_inicio_ofer,txRutMP.getText().trim(), txClaveMP.getText().trim() );
                        
                    //*********************************************************************************************************************//    
                        
                    
//                    btActualizarCotizados.setEnabled(true);
//                    btActualizarCotizados.doClick();
                        
                    //*********************************************************************************************************************//    

                    lbSubiendo.setVisible(false);
           
           
                }
            
            };  
        
            Thread hilo = new Thread(miRunnable);
            hilo.start();
        
            miRunnable = null;
            
           
            
           
           
        } catch (ParseException ex) {
            Logger.getLogger(jdOfertados_MP.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        
        
    }//GEN-LAST:event_btOfertarActionPerformed

    
    private void Actualiza_Cotizados(){
    
        ExeSql Sql = new ExeSql();
        ResultSet Rs = null;
        
        
        try {
            
            
            
            String Id = "";  
            String fecha_inicio = sdf.format(dtFecInicio.getDate()).toString().trim();
            int ofdias = Integer.valueOf(txDias.getText().trim());
            
            Date fechainicial = sdf.parse(fecha_inicio);
            
            //FERRETERIA = dias hábiles, (suma 1 mas),
            //ALIMENTOS  =
            //ASEO       =
            //ESCRITORIO =
            //EMERGENCIA =
            //INSUMOS MEDICOS =
            
            
            if (Convenio == 3){  //ASEO
                
                ofdias--;
                
            }
            
            
            for (int i = 0;i <= ofdias;i++){
                
                Date nuevafecha = sumarDiasAFecha(fechainicial,i);
                
                System.out.println("Dia :"+nuevafecha);
                
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(nuevafecha);
                
                int diasemana = calendar.get(Calendar.DAY_OF_WEEK);  //captura el código del dia de la semana ((2)lunes, (3)martes, etc.)
                
                System.out.println("Que Dia ES :"+diasemana);
                
                if (Convenio == 2){  //Si es FERRETERIA se suman los sábados y domingos
                    
                //        Sábado             Domingo
                    if (diasemana == 7 || diasemana == 1){
                        
                        ofdias++;
                        
                    }
                }
                
            }
            
            System.out.println("Total Dias OFERTA :"+ofdias);
            
            
            double vcosto = 0;
            double voferta = 0;
            
            
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dtFecInicio.getDate()); 
            
            
            calendar.add(Calendar.DAY_OF_YEAR, (ofdias));  
            
            
            Date fecht = calendar.getTime();
            
            String fecha_fin = sdf.format(fecht);
            
            int contador = 0;
            
            for (int i=0; i< Grilla.getRowCount();i++){
                
                Id = Grilla.getValueAt(i, 21).toString().trim();
                
                vcosto = Double.valueOf(Grilla.getValueAt(i, 4).toString().trim().replaceAll("\\,", ""));
                
                
                if (Convenio == 4){  //ALIMENTOS  se saca el iva 
               
                    vcosto = Double.valueOf(Grilla.getValueAt(i, 3).toString().trim().replaceAll("\\,", ""));
                
                }
                
                voferta = Double.valueOf(Grilla.getValueAt(i, 19).toString().trim().replaceAll("\\,", ""));
                
                String tieneerror = Grilla.getValueAt(i, 24).toString().trim();
                
                System.out.println("EL rieneerror ES : |"+tieneerror+"|");
                
                if (tieneerror.trim().equals("0")){
                    
                    Sql.ExeSql("UPDATE codchile SET \n"+
                               "oferta_automatica = true,\n"+
                               "oferta_inicio = '"+fecha_inicio.trim()+"',\n"+
                               "oferta_fin = '"+fecha_fin.trim()+"', \n"+
                               "valor_costo = "+vcosto+", \n"+
                               "valor_oferta = "+voferta+"\n"+
                               "WHERE idch IN ('"+Id.trim()+"') AND convenio = "+Convenio);
                    
                    Sql.Commit();
                    
                    contador++;
                    
                }
                
                
            }
            
            
            if (contador > 0){
            
                fmMain.Mensaje(contador+" ID Actualizadas!!");
                dispose();
            
            }else{
            
                fmMain.Mensaje(contador+" ID Actualizadas!!");
                dispose();
            
            }
        
        } catch (ParseException | SQLException ex) {
            
            Sql.Rollback();
            Logger.getLogger(jdOfertados_MP.class.getName()).log(Level.SEVERE, null, ex);
        
        }finally{
            
            Sql.Close();
        
        }
    
    
    }
    
    
    public static Date sumarDiasAFecha(Date fecha, int dias){
      
        if (dias==0) {
            return fecha;
        }    
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha); 
        calendar.add(Calendar.DAY_OF_YEAR, dias);  
        
        return calendar.getTime(); 
    }
    
    
    
    private void txDiasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txDiasFocusLost
       
        if (txDias.getText().trim().isEmpty()){
        
            txDias.setText("0");
        
        }
        
    }//GEN-LAST:event_txDiasFocusLost

    private void txDiasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txDiasKeyTyped
       
        char car = evt.getKeyChar();
            
        if(((car<'0') || (car>'9'))){
           evt.consume(); 
        }        
        
    }//GEN-LAST:event_txDiasKeyTyped

    private void txMinimoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txMinimoKeyTyped
        
        char car = evt.getKeyChar();
            
        if(((car<'0') || (car>'9'))){
           evt.consume(); 
        }        
        
    }//GEN-LAST:event_txMinimoKeyTyped

    private void txRutMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txRutMPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txRutMPActionPerformed

    private void btActualizarCotizadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActualizarCotizadosActionPerformed
        Actualiza_Cotizados();
    }//GEN-LAST:event_btActualizarCotizadosActionPerformed
    
    
    public void CARGA(int convenio, String dias_ofertar, String fecha_inicio_ofer,String RutMP, String Clave) {
        
        int codigo_convenio     = 0;
        String nombre_convenio  = "";
        String link_convenio    = "";
        String registro = "";
        String desc_convenio  = "";
        
        int fila = 1;
        int columna = 11;
        
        if (convenio==2){
            
            codigo_convenio   = 5802338 ;
            nombre_convenio   = "ferreteria2";
            link_convenio     = "conveniomarco2";
            desc_convenio     = "FERRETERIA";  
            
            fila = 1;
            columna = 11;
            
        }else if (convenio==3){
            
            codigo_convenio   = 5800319;
            nombre_convenio   = "aseo2022";
            link_convenio     = "conveniomarco";
            desc_convenio     = "ASEO";  
            
            fila = 1;
            columna = 5;
            
        }else if (convenio==4){
            
            codigo_convenio   = 5802368;
            nombre_convenio   = "alimentos2";
            link_convenio     = "conveniomarco2";
            desc_convenio     = "ALIMENTOS";  
            
            

            fila = 1;
            columna = 11;
        
        }else if (convenio==7){
            
            codigo_convenio   = 5802377; //5802330
            //nombre_convenio   = "escritorio2023";
            nombre_convenio   = "escritorio3";
            link_convenio     = "conveniomarco";
            desc_convenio     = "ESCRITORIO";  
            
            fila = 1;
            columna = 7;
            
        }else if (convenio==11){
            
            
            codigo_convenio   = 5802366;
            nombre_convenio   = "emergencias202109";
            link_convenio     = "conveniomarco2";
            desc_convenio     = "EMERGENCIA";  
            
            fila = 1;
            columna = 11;
            
            
        }
      
        registro = "Conectando a Mercado Público...\n\n";
        
        jTextArea1.setText(registro);
        
       
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");      
        
        ChromeOptions Op = new ChromeOptions();
        Op.addArguments("--window-size=1920,1080");        //ejecuta chrome de 2do. nivel pero se necista que este en pantalla completa
        //Op.addArguments("--start-maximized");           //ejecuta chrome de 2do. nivel
        Op.addArguments("--disable-gpu");           //descativa GPU (aceleración del proceso gráfico)
        //"--disable-gpu"
        
        if (!chkChrome.isSelected()){
        
           Op.addArguments("--headless");                  //ejecuta chrome de 2do. nivel
            
        }    
            
	WebDriver driver = new ChromeDriver(Op);    
//        WebDriver driver = new ChromeDriver();   //se ejecuta primer plano, visible
     
        try {       
        
            driver.get("https://www.mercadopublico.cl/"); 
        
        
            //driver.manage().window().maximize();
	  
            esperaLaCarga(driver, 6000);
            
            
            WebElement acceso = driver.findElement(By.xpath("//button[@class='btn btn-xl btn-pri'][@onclick='keycloak.login()']"));
            acceso.click();
            
            WebElement acceso1 = driver.findElement(By.xpath("//img[@class='btn-clave-unica']"));
           
            acceso1.click();
  
    //********************************************************************************************************************************//        
      

            WebElement rut = driver.findElement(By.id("uname"));     //Se posiciona sobre el cuadro de texto para ingresar el RUT
        
            rut.sendKeys(RutMP.trim());
        
            WebElement pass = driver.findElement(By.id("pword")); //esta es la pass
	
            pass.sendKeys(Clave.trim());

            WebElement acceso2 = driver.findElement(By.id("login-submit"));
            acceso2.click();

        
            registro = registro + "Iniciando Sesión...\n\n";
            jTextArea1.setText(registro);

        //  Esperar hasta que la ventana popup de el o los perfiles de usuario se carge
            WebDriverWait wait2 = new WebDriverWait(driver, 30);
            wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-dialog")));     
        

            WebElement radio1 = driver.findElement(By.id("rdbOrg1308649"));   //Se selecciona el radio button del perfil usuario por el Id del radiobutton
            radio1.click();

        
            esperaLaCarga(driver, 5000);
        
            WebElement ingresar = driver.findElement(By.xpath("//a[@class='btn btn-pri']"));
        
            ingresar.click();
       
        
            WebDriverWait wait = new WebDriverWait(driver, 300);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Convenio Marco"))));
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Convenio Marco"))));  //Espera hasta que carga Los Convenios
            WebElement linkcm  = driver.findElement(By.linkText("Convenio Marco"));
            linkcm.click();
       
        
            esperaLaCarga(driver, 3000);
        
            driver.switchTo().frame("fraDetalle");
        
            esperaLaCarga(driver,1000);
            List<WebElement> botones = driver.findElements(By.xpath("//button[@class='btn btn-pri']"));   //Se crea una lista con los botones de los convenios
            Iterator<WebElement> i = botones.iterator();

           
        
            while(i.hasNext()) { 

                WebElement anchor = i.next();
            
                if(anchor.getAttribute("onclick").contains("irTiendaExterna('https://"+link_convenio+".mercadopublico.cl/"+nombre_convenio+         //Si es el boton del convenio
                                                                            "/loginmp/account/loggedin?idConvenio="+codigo_convenio+"')")) {
                    JavascriptExecutor executor = (JavascriptExecutor)driver;
                    executor.executeScript("arguments[0].click();", anchor);
                    
                    break;

                }
        
        
            }

        
            registro = registro + "Entrando al Convenio : "+desc_convenio+" \n\n";
            jTextArea1.setText(registro);
        
            esperaLaCarga(driver, 3000);
       
//
//    //***************  Cambio de pestaña en Chrome  ******************//

        String Main = driver.getWindowHandle();


        Set<String> Pestaña = driver.getWindowHandles();

        for (String nueva : Pestaña){

            if(!nueva.equalsIgnoreCase(Main)){

                driver.switchTo().window(nueva);
                break;
            }

        }


        String url = driver.getCurrentUrl();

        System.out.println("El VALOR DE LA Url ES : "+url+"\n");

    //***************************************************************//

        esperaLaCarga(driver, 5000); 
        
        WebElement productos = driver.findElement(By.id("wk-mp-menu-mpassign-list"));   //Tag <il> que contiene el href de productos
       
        productos.click();
                                                         
        
        
//************************************************************************************//
        
        int indice = 0;
        
        
        for (int z = 0; z < (Lista2.size()); z++) {  //Recorre cada ID Madre 

            
                esperaLaCarga(driver, 3500);

                String nuevaurl = driver.getCurrentUrl();

                System.out.println("El NUEVO VALOR DE LA Url ES : "+nuevaurl+"\n\n");


                esperaLaCarga(driver, 3000);
      
                WebElement filtro = driver.findElement(By.xpath("//button[@class='action-default']"));  //Se pulsa el botón de 'Filtros'
                filtro.click();

                WebElement textid = driver.findElement(By.name("sku"));     //Se posiciona sobre el cuadro de texto para ingresar el ID MADRE
                textid.click();
   
                ID = Lista2.get(z).get(0).toString().trim();  //Se captura ID Madre
                Correlativo = Integer.valueOf(Lista2.get(z).get(1).toString().trim());  //Se captura la posicion de la ID Madre
                
                textid.sendKeys(ID);
       
 
                WebElement footer_paginas = driver.findElement(By.className("admin__data-grid-filters-footer"));
                WebElement footer_main = footer_paginas.findElement(By.className("admin__footer-main-actions"));
       
                
                esperaLaCarga(driver, 5000);
                
                WebElement aplicafiltro = footer_main.findElement(By.className("action-secondary"));  //Se aplica filtro para las busqueda del ID Madre
                aplicafiltro.click();
                
                registro = registro + "Buscando ID Madre : "+ID+"... \n\n";
                jTextArea1.setText(registro);
        
                
                esperaLaCarga(driver, 3000);

                WebElement boton = driver.findElement(By.xpath("//table/tbody/tr["+fila+"]/td["+columna+"]"));  //se posiciona en la columna 11 de la fila seleccionada [fila]
                boton.click();
                
                WebElement menud = boton.findElement(By.xpath("//button[@class='action-select']"));  //Se expande el menu del boton "Seleccione"
                menud.click();

                
                WebElement menuactive = boton.findElement(By.xpath("//ul[@class='action-menu _active']/li[2]"));  //Se elige la seguna opcion (tag <li>) del menu (tag <ul> crear oferta especial)
                menuactive.click();

                wait.until(ExpectedConditions.visibilityOf(menud.findElement(By.xpath("//div[@class='modal-inner-wrap']"))));   //Espera a que se carge el menu pop
                wait.until(ExpectedConditions.elementToBeClickable(menud.findElement(By.xpath("//div[@class='modal-inner-wrap']"))));

                WebElement divmenu = menud.findElement(By.xpath("//div[@class='modal-inner-wrap']"));    //se posiciona sobre el div que tiene los botones del menu pop

                WebElement bmenu = divmenu.findElement(By.xpath("//button[@class='action-primary action-accept']"));  //se posiciona sobre el boton aceptar del menu pop
                bmenu.click();
        
                esperaLaCarga(driver, 5000);
             
               
                if(!driver.findElements(By.xpath("//table[@class='data table wk-associated-table']")).isEmpty()) {  
                 
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='data table wk-associated-table']")));
                 
                    WebElement tablaregiones = driver.findElement(By.xpath("//table[@class='data table wk-associated-table']"));  //Se busca la tabla que contiene los precios por Región 
                 
                    wait.until(ExpectedConditions.visibilityOf(tablaregiones));
        
                    List<WebElement> filas = tablaregiones.findElements(By.tagName("tr"));  //Se capturan la cantidad de Filas (numero de precios por Region del Producto)
                    esperaLaCarga(driver, 3000);
         
                    int td = 0;
        
        
                    if (nombre_convenio.trim().contains("emergencia")){  //tiene una columna mas
        
                        td = 6;
        
                    }else {
        
                        td = 5;
        
                    }
        
                    System.out.println("EL ID MADRE ES : "+ID);
                
                
                    System.out.println("indice ES : "+indice);
                    System.out.println("Correlativo ES : "+Correlativo);
                
                
                    for (int i2 = indice; i2 < (indice+Correlativo);i2++){   //Recorre todos ID de cada ID Madre
       
                
                        for (int x = 1; x < filas.size(); x++) {  //Recorre todos los ID de las regiones de la tabla del Backoffice
            
                            tablaregiones = driver.findElement(By.xpath("//table[@class='data table wk-associated-table']"));
                            wait.until(ExpectedConditions.visibilityOf(tablaregiones));
            
            
                            WebElement region = tablaregiones.findElement(By.xpath("//table[@class='data table wk-associated-table']/tbody/tr[" + x + "]/td[2]")); //Captura descripción de la columna de la Región
            
                            String Descripcion =  Grilla.getValueAt(i2, 1).toString().trim();  //se asigna descripcion de columna Región de Luvaly
                            String PrecioOferta = Grilla.getValueAt(i2, 19).toString().trim();
                       
                            if (Descripcion.trim().equals(region.getText())){  //Si ambas descripciones son iguales
            
                                System.out.println("La Región ES : "+region.getText());
                            
                                System.out.println("La Descripcion ES : "+Descripcion);
                                                                                                                                                                       //5//                                                                   
                                WebElement preciooferta = tablaregiones.findElement(By.xpath("//table[@class='data table wk-associated-table']/tbody/tr[" + x + "]/td["+td+"]/input[@class='wk-associate-special-price validate-zero-or-greater']"));
                                preciooferta.click();
                                preciooferta.clear();
                                preciooferta.sendKeys(PrecioOferta);  //Asigna un valor Precio Oferta al campo de texto 
                                                                                                                                                                        //6//                                                                
                                WebElement fechaoferta = tablaregiones.findElement(By.xpath("//table[@class='data table wk-associated-table']/tbody/tr[" + x + "]/td["+(td+1)+"]/input[@class='wk-associate-start-date hasDatepicker _has-datepicker']"));
                                fechaoferta.click();
                                fechaoferta.clear();
                                fechaoferta.sendKeys(fecha_inicio_ofer.trim());  //Asigna un valor fecha inicio oferta al campo de texto 
            
                                                                                                                                                                       //7//                                                                                
                                WebElement diasoferta = tablaregiones.findElement(By.xpath("//table[@class='data table wk-associated-table']/tbody/tr[" + x + "]/td["+(td+2)+"]/input[@class='wk-associate-days validate-digits']"));
                                diasoferta.click();
                                diasoferta.clear();
                                diasoferta.sendKeys(dias_ofertar.trim());  //Asigna un valor de numeros de días al campo de texto 
            
                            
                                registro = registro + ""+Descripcion.trim()+" | Oferta : "+PrecioOferta+"  \n";
                                jTextArea1.setText(registro);
                                
                                
                                Grilla.setValueAt("0", i2, 24);  //ID ofertada, sin error
                                
                                
                                
                            }
        
                        }
                    
                    
                    } 
                    
        
                    WebElement bguardaroferta = driver.findElement(By.xpath("//button[@class='button wk-product-save-btn']"));  //se posiciona sobre el boton guardar oferta
                    bguardaroferta.click();
           
                    registro = registro + "Oferta(s) de "+"ID Madre : "+ID+" Subida(s) \n\n";
                    jTextArea1.setText(registro);
                    
                    
                
                }else{ 
                    
                    
                    if (driver.getPageSource().contains("Este producto no posee ofertas aprobadas o las ofertas no tienen stock.")){
                     
                        registro = registro + "la ID Madre N° "+ID+" no posee ofertas aprobadas o las ofertas no tienen stock. \n";
                        jTextArea1.setText(registro);
                        
                        System.out.println("la ID Madre N° "+ID+" no posee ofertas aprobadas o las ofertas no tienen stock.");
                    
                    }else if (driver.getPageSource().contains("El campo Precio especial debe tener")){
                     
                        registro = registro + "El campo Precio especial debe tener un porcentaje de descuento mayor o igual a 5% (ID Madre N° "+ID+").\n";
                        jTextArea1.setText(registro);
                        
                        System.out.println("El campo Precio especial debe tener un porcentaje de descuento mayor o igual a 5% (ID Madre N° "+ID+")");
                    
                    }
                    
                    
                    else{
                    
                        registro = registro + "No se pudo cargar oferta en la ID Madre N° "+ID+" \n";
                        jTextArea1.setText(registro);
                        
                        System.out.println("No se pudo cargar oferta en la ID Madre N° "+ID);
                    
                    }
                }
                
               
                indice = (indice)+Correlativo;
            }
        
            driver.close();  
            driver.quit();
            
        
        } catch (Exception ex) {
            
            Logger.getLogger(fmMain.class.getName()).log(Level.SEVERE, null, ex);
            
            registro = registro + "Hubo un error de carga del proceso automático...!! \n";
            jTextArea1.setText(registro);
           
            driver.close();
            driver.quit();
            
        } 
    
    }
    
    
    public static void esperaLaCarga(WebDriver driver, int tiempo) {
        
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
        
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete"); 
            }
        };
        
        try {
        
            Thread.sleep(tiempo);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        
        } catch (Throwable error) {
            
            System.out.println("Tiempo de espera superado"); 
            
        }
    }
    
    
    
   
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
            java.util.logging.Logger.getLogger(jdOfertados_MP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdOfertados_MP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdOfertados_MP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdOfertados_MP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdOfertados_MP dialog = new jdOfertados_MP(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    
    class Elrender extends DefaultTableCellRenderer {
         
        @Override
        public Component getTableCellRendererComponent(JTable tabla, Object valor, boolean isSelected, boolean hasFocus, int fila, int columna) {
        super.getTableCellRendererComponent(tabla,valor,isSelected, hasFocus, fila, columna);
               
        
                if (columna == 1){
                   
                       this.setHorizontalAlignment(SwingConstants.LEFT);
                   
                   
                }else if (columna == 3 || columna == 4){
               
                    if(isSelected==true){
                
                        this.setForeground(Color.white);
                        this.setBackground(Color.blue);    
                        this.setFont(new Font("Tahoma", Font.BOLD, 11));
                   
                    }else{
                   
                        this.setForeground(Color.black);   
                        this.setBackground(new Color(255,211,140)); //Naranjo Claro
                    
                   } 
                   
               
               }else if (columna == 5 || columna == 6 ){ 
               
                    
                    if(isSelected==true){
                
                        this.setForeground(Color.white);
                        this.setBackground(Color.blue);    
                        this.setFont(new Font("Tahoma", Font.BOLD, 11));
                   
                    }else{
                   
                        this.setForeground(Color.black);   
                        this.setBackground(new Color(239, 198, 46)); //Naranjo
                    
                    }
                    
                    if (columna == 6) {
                        
                        this.setHorizontalAlignment(SwingConstants.CENTER);
                     
                    }
                    
                   
               }else if (columna == 7 || columna == 8  ){
               
                   if(isSelected==true){
                
                        this.setForeground(Color.white);
                        this.setBackground(Color.blue);    
                        this.setFont(new Font("Tahoma", Font.BOLD, 11));
                   
                    }else{
                        this.setForeground(Color.black);   
                        this.setBackground(new Color(255,153,0)); //Naranjo Oscuro
                    
                    } 
                    if (columna == 8) {
                     
                         this.setHorizontalAlignment(SwingConstants.CENTER);
                     
                    }else{
                    
                        this.setHorizontalAlignment(SwingConstants.RIGHT);
                    
                    }
                    

               }else if (columna == 9 || columna == 10  ){
               
                   if(isSelected==true){
                
                        this.setForeground(Color.white);
                        this.setBackground(Color.blue);    
                        this.setFont(new Font("Tahoma", Font.BOLD, 11));
                   
                    }else{
                        this.setForeground(Color.black);   
                        this.setBackground(new Color(0, 204, 255));  //Celeste Oscuro
                    
                    } 
                    if (columna == 10) {
                     
                         this.setHorizontalAlignment(SwingConstants.CENTER);
                     
                    }else{
                    
                        this.setHorizontalAlignment(SwingConstants.RIGHT);
                    
                    }
                    

               }else if (columna == 11 || columna == 12  ){
               
                   if(isSelected==true){
                
                        this.setForeground(Color.white);
                        this.setBackground(Color.blue);    
                        this.setFont(new Font("Tahoma", Font.BOLD, 11));
                   
                    }else{
                        this.setForeground(Color.black);   
                        this.setBackground(new Color(102, 204, 0));  //Verde Musgo
                    
                    } 
                    
                    if (columna == 12) {
                     
                         this.setHorizontalAlignment(SwingConstants.CENTER);
                     
                    }else{
                    
                        this.setHorizontalAlignment(SwingConstants.RIGHT);
                    
                    }
                    

               }else if (columna == 13 || columna == 14  ){ 
               
                   if(isSelected==true){
                
                        this.setForeground(Color.white);
                        this.setBackground(Color.blue);    
                        this.setFont(new Font("Tahoma", Font.BOLD, 11));
                   
                    }else{
                        this.setForeground(Color.black);   
                        this.setBackground(new Color(255, 102, 51)); //Rojizo
                    
                    } 
                    
                    if (columna == 14) {
                     
                         this.setHorizontalAlignment(SwingConstants.CENTER);
                     
                    }else{
                    
                        this.setHorizontalAlignment(SwingConstants.RIGHT);
                    
                    }
                    

               }else if (columna == 15 || columna == 16  ){
               
                   if(isSelected==true){
                
                        this.setForeground(Color.white);
                        this.setBackground(Color.blue);    
                        this.setFont(new Font("Tahoma", Font.BOLD, 11));
                   
                    }else{
                        this.setForeground(Color.black);   
                        this.setBackground(new Color(0,204,204));  //Calipso oscuro
                    
                    } 
                    
                    if (columna == 16) {
                     
                         this.setHorizontalAlignment(SwingConstants.CENTER);
                     
                    }else{
                    
                        this.setHorizontalAlignment(SwingConstants.RIGHT);
                    
                    }
                    

               }else if (columna == 17 || columna == 18  ){
               
                   if(isSelected==true){
                
                        this.setForeground(Color.white);
                        this.setBackground(Color.blue);    
                        this.setFont(new Font("Tahoma", Font.BOLD, 11));
                   
                    }else{
                        this.setForeground(Color.black);   
                        this.setBackground(new Color(255,204,204));  //Rosado
                    
                    } 
                    
                    if (columna == 18) {
                     
                         this.setHorizontalAlignment(SwingConstants.CENTER);
                     
                    }else{
                    
                        this.setHorizontalAlignment(SwingConstants.RIGHT);
                    
                    }
                    

               }else if (columna == 19 ){
               
                   if(isSelected==true){ 
                
                        this.setForeground(Color.white);
                        this.setBackground(Color.blue);    
                        this.setFont(new Font("Tahoma", Font.BOLD, 11));
                   
                    }else{
                        this.setForeground(Color.black);   
                        this.setBackground(Color.white);
                    
                    } 
                    
                    this.setHorizontalAlignment(SwingConstants.CENTER);
                    
                    

               }else{  
               
                   
                   if(isSelected==true){
                
                    this.setForeground(Color.white);
                    this.setBackground(Color.blue);    
                    this.setFont(new Font("Tahoma", Font.BOLD, 11));
                   
                   }else{
                   
                   
                   
                    this.setForeground(Color.black);
                    this.setBackground(Color.white);
                   
                   }
                   
                  
                   this.setHorizontalAlignment(SwingConstants.RIGHT);
               
               
               }
               
               
              return this;
              
        
        }
    } 
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Grilla;
    private javax.swing.JButton btActualizarCotizados;
    private javax.swing.JButton btOfertar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chkChrome;
    private org.jdesktop.swingx.JXDatePicker dtFecInicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lbSubiendo;
    private javax.swing.JPasswordField txClaveMP;
    private javax.swing.JTextField txDias;
    private javax.swing.JTextField txMinimo;
    private javax.swing.JTextField txRutMP;
    // End of variables declaration//GEN-END:variables
}

