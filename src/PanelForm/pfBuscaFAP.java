/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelForm;

import Conexion.ExeSql;
import Dialogos.jdAbrirOCCDirecto;
import Dialogos.jdAddDatosPersona;
import Dialogos.jdBuscarCliPrv;
import Dialogos.jdDiasOCP;
import Formularios.fmMain;
import static Formularios.fmMain.pnPestanas;
import Utilidades.ComboCodigos;
import Utilidades.PanelTab;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author luvaly
 */
public class pfBuscaFAP extends javax.swing.JPanel {

    /**
     * Creates new form pfBuscaFAP
     */
    public pfBuscaFAP() {
        initComponents();
        BuscarCargar();
    }
    
    public void buscaBlanco(){
        //
        //Busca todos los datos para que al ingresar a la pestaña y al apretar limpiar muestre todas las facturas.
        //
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        int ContReg=0;
        String Query, Fecha_pago, Nombre, Estado = "";
        DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
        
         while(TableModel.getRowCount()>0)
             TableModel.removeRow(0);
        
        try {        
                  Query = "SELECT  c.femision,\n" +
                          "        c.rut,\n" +
                          "        p.nombre,\n" +
                          "        c.tipdocto,\n" +
                          "        c.nrodocto,\n" +
                          "        c.totalafecto,\n" +
                          "        c.totaliva,\n" +
                          "        c.totaldocto,\n" +
                          "        c.pagado,\n" +
                          "        (c.totaldocto - c.pagado) AS Resultado,\n" +
                          "        c.autoriza,\n" +
                          "        d.fpago,\n" +
                          "        CASE d.estado\n" +
                          "         when 0 then 'Pendiente'\n" +
                          "         when 1 then 'Pagado'\n" +
                          "         when 2 then 'Pagado Parcial'\n" +
                          "       end as estado,"
                          + "g.nombre as tipopago \n "+
                          " FROM ctacteprv c\n" +
                          "      LEFT JOIN proveedor p on p.rut = c.rut\n" +
                          "      LEFT JOIN prv_cuentasxpagar d\n" +
                          "      ON d.rut = c.rut AND\n" +
                          "       d.tipdocto = c.tipdocto AND\n" +
                          "       d.nrodocto = c.nrodocto\n"
                          + "left join par_general g on g.codigo = d.tipopago and g.tipo='TIPOPAGOPRV'\n" +
                          " WHERE c.tipdocto IN ('FAP', 'FAG');";
                
                  
                Rs = Sql.Select(Query);
                
                while (Rs.next()){
                    ContReg ++;

                        TableModel.addRow(new Object[]{
                            Rs.getString("rut").trim(),
                            Rs.getString("nombre").trim(),
                            Rs.getDate("femision"),
                            Rs.getDate("fpago"),
                            Rs.getString("nrodocto").trim(),
                            Rs.getString("tipdocto").trim(),
                            Rs.getString("totalafecto").trim(),
                            Rs.getString("totaliva").trim(),
                            Rs.getString("totaldocto").trim(),
                            Rs.getString("pagado"),
                            Rs.getString("Resultado"),
                            Rs.getBoolean("autoriza"),
                            Rs.getString("estado"),
                            Rs.getString("tipopago")
                        });
                            
                }
                lbCantidad.setText(String.valueOf(ContReg));
               
        
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"No se pueden encontrar datos");
        }finally{
            Sql.Close();
        }
    }

    public void BuscarCargar(){
        Runnable miRunnable = new Runnable() {
            public void run() {
                try{
                    Grilla.clearSelection();
                    lbcargando.setVisible(true);

                    buscaBlanco();

                    lbcargando.setVisible(false);
                    //Grilla.changeSelection(0, 0 , false, false);

                    
                } catch (Exception e) {
                    e.printStackTrace();
                    
                }
                
            }
        };
        Thread hilo = new Thread(miRunnable);
        hilo.start();
        lbcargando.setText("Cargando.....");
        URL urlInfo =  this.getClass().getResource("/Iconos16/wait.gif");
        ImageIcon IconoInfo =  new ImageIcon(urlInfo); 
        lbcargando.setIcon(IconoInfo);
        lbcargando.setForeground(Color.red);
    }
    public void BuscarBotonRut(){
        Runnable miRunnable = new Runnable() {
            public void run() {
                try{
                    Grilla.clearSelection();
                    lbcargando.setVisible(true);

                    mostrarDatosRut();

                    lbcargando.setVisible(false);
                    //Grilla.changeSelection(0, 0 , false, false);

                    
                } catch (Exception e) {
                    e.printStackTrace();
                    
                }
                
            }
        };
        Thread hilo = new Thread(miRunnable);
        hilo.start();
        lbcargando.setText("Cargando.....");
        URL urlInfo =  this.getClass().getResource("/Iconos16/wait.gif");
        ImageIcon IconoInfo =  new ImageIcon(urlInfo); 
        lbcargando.setIcon(IconoInfo);
        lbcargando.setForeground(Color.red);
    }
    public void BuscarBotonNombre(){
        Runnable miRunnable = new Runnable() {
            public void run() {
                try{
                    Grilla.clearSelection();
                    lbcargando.setVisible(true);

                    mostrarDatosNombre();

                    lbcargando.setVisible(false);
                    //Grilla.changeSelection(0, 0 , false, false);

                    
                } catch (Exception e) {
                    e.printStackTrace();
                    
                }
                
            }
        };
        Thread hilo = new Thread(miRunnable);
        hilo.start();
        lbcargando.setText("Cargando.....");
        URL urlInfo =  this.getClass().getResource("/Iconos16/wait.gif");
        ImageIcon IconoInfo =  new ImageIcon(urlInfo); 
        lbcargando.setIcon(IconoInfo);
        lbcargando.setForeground(Color.red);
    }
    public void BuscarBotonNumero(){
        Runnable miRunnable = new Runnable() {
            public void run() {
                try{
                    Grilla.clearSelection();
                    lbcargando.setVisible(true);

                    mostrarDatosNumero();

                    lbcargando.setVisible(false);
                    //Grilla.changeSelection(0, 0 , false, false);

                    
                } catch (Exception e) {
                    e.printStackTrace();
                    
                }
                
            }
        };
        Thread hilo = new Thread(miRunnable);
        hilo.start();
        lbcargando.setText("Cargando.....");
        URL urlInfo =  this.getClass().getResource("/Iconos16/wait.gif");
        ImageIcon IconoInfo =  new ImageIcon(urlInfo); 
        lbcargando.setIcon(IconoInfo);
        lbcargando.setForeground(Color.red);
    }
    public void mostrarDatosNumero(){
        //
        //Muestra las facturas segun el numero de documento ingresado.
        //
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        int ContReg=0;
        String Query = "";
        String nombres = txNFact.getText().trim();
        DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
        txNFact.setText(nombres);

        while(TableModel.getRowCount()>0)
        TableModel.removeRow(0);
        
        try {
                 Query = "SELECT c.femision,\n" +
                          "        c.rut,\n" +
                          "        p.nombre,\n" +
                          "        c.tipdocto,\n" +
                          "        c.nrodocto,\n" +
                          "        c.totalafecto,\n" +
                          "        c.totaliva,\n" +
                          "        c.totaldocto,\n" +
                          "        c.pagado,\n" +
                          "        (c.totaldocto - c.pagado) AS Resultado,\n" +
                          "        c.autoriza,\n" +
                          "        d.fpago,\n" +
                          "        CASE d.estado\n" +
                          "         when 0 then 'Pendiente'\n" +
                          "         when 1 then 'Pagado'\n" +
                          "         when 2 then 'Pagado Parcial'\n" +
                          "       end as estado,"
                          + "g.nombre as tipopago \n "+
                          " FROM ctacteprv c\n" +
                          "      inner JOIN proveedor p on p.rut = c.rut\n" +
                          "      INNER JOIN prv_cuentasxpagar d\n" +
                          "      ON d.rut = c.rut AND\n" +
                          "       d.tipdocto = c.tipdocto AND\n" +
                          "       d.nrodocto = c.nrodocto\n" 
                         + "left join par_general g on g.codigo = d.tipopago and g.tipo='TIPOPAGOPRV'\n" +
                          " WHERE c.tipdocto IN ('FAP', 'FAG') AND c.nrodocto ="+ nombres +";";

                Rs = Sql.Select(Query);
                    
                
                while (Rs.next()){
                    ContReg ++;
                        TableModel.addRow(new Object[]{
                            Rs.getString("rut").trim(),
                            Rs.getString("nombre").trim(),
                            Rs.getDate("femision"),
                            Rs.getDate("fpago"),
                            Rs.getString("nrodocto").trim(),
                            Rs.getString("tipdocto").trim(),
                            Rs.getDouble("totalafecto"),
                            Rs.getDouble("totaliva"),
                            Rs.getDouble("totaldocto"),
                            Rs.getDouble("pagado"),
                            Rs.getDouble("Resultado"),
                            Rs.getBoolean("autoriza"),
                            Rs.getString("estado").trim(),
                            Rs.getString("tipopago")
                        });
                }  
                lbCantidad.setText(String.valueOf(ContReg));
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"No se pueden encontrar datos");
             buscaBlanco();
        }finally{
            Sql.Close();
        }
    }
    
    public void mostrarDatosNombre(){
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        int ContReg=0;
        String Query = "";
        String nombres = txNombre.getText().toUpperCase().trim();
        DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
        txNombre.setText(nombres);

        while(TableModel.getRowCount()>0)
        TableModel.removeRow(0);
        
        try {
                Query =   "SELECT c.femision,\n" +
                          "        c.rut,\n" +
                          "        p.nombre,\n" +
                          "        c.tipdocto,\n" +
                          "        c.nrodocto,\n" +
                          "        c.totalafecto,\n" +
                          "        c.totaliva,\n" +
                          "        c.totaldocto,\n" +
                          "        c.pagado,\n" +
                          "        (c.totaldocto - c.pagado) AS Resultado,\n" +
                          "        c.autoriza,\n" +
                          "        d.fpago,\n" +
                          "        CASE d.estado\n" +
                          "         when 0 then 'Pendiente'\n" +
                          "         when 1 then 'Pagado'\n" +
                          "         when 2 then 'Pagado Parcial'\n" +
                          "       end as estado,"
                          + "g.nombre as tipopago \n "+
                          " FROM ctacteprv c\n" +
                          "      inner JOIN proveedor p on p.rut = c.rut\n" +
                          "      INNER JOIN prv_cuentasxpagar d\n" +
                          "      ON d.rut = c.rut AND\n" +
                          "       d.tipdocto = c.tipdocto AND\n" +
                          "       d.nrodocto = c.nrodocto\n" +
                         "left join par_general g on g.codigo = d.tipopago and g.tipo='TIPOPAGOPRV'\n" +
                          " WHERE c.tipdocto IN ('FAP', 'FAG') AND p.nombre like '%"+ nombres +"%';";
                Rs = Sql.Select(Query);
                    
                
                while (Rs.next()){
                    ContReg ++;
                        TableModel.addRow(new Object[]{
                            Rs.getString("rut").trim(),
                            Rs.getString("nombre").trim(),
                            Rs.getDate("femision"),
                            Rs.getDate("fpago"),
                            Rs.getString("nrodocto").trim(),
                            Rs.getString("tipdocto").trim(),
                            Rs.getDouble("totalafecto"),
                            Rs.getDouble("totaliva"),
                            Rs.getDouble("totaldocto"),
                            Rs.getDouble("pagado"),
                            Rs.getDouble("Resultado"),
                            Rs.getBoolean("autoriza"),
                            Rs.getString("estado").trim(),
                            Rs.getString("tipopago")
                        });
                }  
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"No se pueden encontrar datos");
             buscaBlanco();
        }finally{
            Sql.Close();
        }
    }
    
    public void mostrarDatosRut(){
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        int ContReg=0;
        String Query = "";
        String nombres = txRut.getText().trim();
        DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
        txRut.setText(nombres);

        while(TableModel.getRowCount()>0)
        TableModel.removeRow(0);
        
        try {
                        Query = "SELECT c.femision,\n" +
                          "        c.rut,\n" +
                          "        p.nombre,\n" +
                          "        c.tipdocto,\n" +
                          "        c.nrodocto,\n" +
                          "        c.totalafecto,\n" +
                          "        c.totaliva,\n" +
                          "        c.totaldocto,\n" +
                          "        c.pagado,\n" +
                          "        (c.totaldocto - c.pagado) AS Resultado,\n" +
                          "        c.autoriza,\n" +
                          "        d.fpago,\n" +
                          "        CASE d.estado\n" +
                          "         when 0 then 'Pendiente'\n" +
                          "         when 1 then 'Pagado'\n" +
                          "         when 2 then 'Pagado Parcial'\n" +
                          "       end as estado,"
                          + "g.nombre as tipopago \n "+
                          " FROM ctacteprv c\n" +
                          "      inner JOIN proveedor p on p.rut = c.rut\n" +
                          "      INNER JOIN prv_cuentasxpagar d\n" +
                          "      ON d.rut = c.rut AND\n" +
                          "       d.tipdocto = c.tipdocto AND\n" +
                          "       d.nrodocto = c.nrodocto\n" +
                          "left join par_general g on g.codigo = d.tipopago and g.tipo='TIPOPAGOPRV'\n" +
                          " WHERE c.tipdocto IN ('FAP', 'FAG') AND c.rut="+ nombres +";";
                 Rs = Sql.Select(Query);
                    
                
                while (Rs.next()){
                    ContReg ++;
                        TableModel.addRow(new Object[]{
                            Rs.getString("rut").trim(),
                            Rs.getString("nombre").trim(),
                            Rs.getDate("femision"),
                            Rs.getDate("fpago"),
                            Rs.getString("nrodocto").trim(),
                            Rs.getString("tipdocto").trim(),
                            Rs.getDouble("totalafecto"),
                            Rs.getDouble("totaliva"),
                            Rs.getDouble("totaldocto"),
                            Rs.getDouble("pagado"),
                            Rs.getDouble("Resultado"),
                            Rs.getBoolean("autoriza"),
                            Rs.getString("estado").trim(),
                            Rs.getString("tipopago")
                        });
                }  
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"No se pueden encontrar datos");
            buscaBlanco();
        }finally{
            Sql.Close();
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        MnuPagos = new javax.swing.JMenuItem();
        MnuFactura = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        Grilla = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txSku = new javax.swing.JTextField();
        lbcargando = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbCantidad = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jLabel2 = new javax.swing.JLabel();
        txNFact = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txNombre = new javax.swing.JTextField();
        btBuscarNombre = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txRut = new javax.swing.JTextField();
        btBuscaRut = new javax.swing.JButton();
        buLimpiar = new javax.swing.JButton();

        MnuPagos.setText("Pagos Proveedor");
        MnuPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuPagosActionPerformed(evt);
            }
        });
        jPopupMenu1.add(MnuPagos);

        MnuFactura.setLabel("Factura");
        MnuFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuFacturaActionPerformed(evt);
            }
        });
        jPopupMenu1.add(MnuFactura);
        MnuFactura.getAccessibleContext().setAccessibleName("Factura\n");

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Grilla.setAutoCreateRowSorter(true);
        Grilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Rut", "Nombre", "Fecha Emision", "Fecha Pagada", "Número Fact.", "Tipo", "Neto", "Iva", "Total", "Pagado", "Diferencia", "Autorizado", "Estado Fact.", "Tipo Pago"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true, true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Grilla.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(Grilla);
        if (Grilla.getColumnModel().getColumnCount() > 0) {
            Grilla.getColumnModel().getColumn(0).setMinWidth(80);
            Grilla.getColumnModel().getColumn(0).setPreferredWidth(80);
            Grilla.getColumnModel().getColumn(0).setMaxWidth(80);
            Grilla.getColumnModel().getColumn(1).setMinWidth(300);
            Grilla.getColumnModel().getColumn(1).setPreferredWidth(300);
            Grilla.getColumnModel().getColumn(1).setMaxWidth(350);
            Grilla.getColumnModel().getColumn(2).setMinWidth(90);
            Grilla.getColumnModel().getColumn(2).setPreferredWidth(90);
            Grilla.getColumnModel().getColumn(2).setMaxWidth(90);
            Grilla.getColumnModel().getColumn(3).setMinWidth(90);
            Grilla.getColumnModel().getColumn(3).setPreferredWidth(90);
            Grilla.getColumnModel().getColumn(3).setMaxWidth(90);
            Grilla.getColumnModel().getColumn(4).setMinWidth(80);
            Grilla.getColumnModel().getColumn(4).setPreferredWidth(80);
            Grilla.getColumnModel().getColumn(4).setMaxWidth(80);
            Grilla.getColumnModel().getColumn(12).setMinWidth(80);
            Grilla.getColumnModel().getColumn(12).setPreferredWidth(80);
            Grilla.getColumnModel().getColumn(12).setMaxWidth(80);
            Grilla.getColumnModel().getColumn(13).setMinWidth(100);
            Grilla.getColumnModel().getColumn(13).setPreferredWidth(100);
            Grilla.getColumnModel().getColumn(13).setMaxWidth(100);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 1150, 330));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setText("FILTRO:");

        txSku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txSkuKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txSkuKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txSkuKeyTyped(evt);
            }
        });

        lbcargando.setText("Cargando");

        jLabel4.setText("Cantidad:");

        lbCantidad.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txSku, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbcargando)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txSku, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbcargando)
                    .addComponent(jLabel4)
                    .addComponent(lbCantidad))
                .addContainerGap())
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 450, 120));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setAlignmentX(0.0F);
        jPanel2.setAlignmentY(0.0F);

        jXLabel1.setForeground(new java.awt.Color(0, 51, 0));
        jXLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/OCCliente24.png"))); // NOI18N
        jXLabel1.setText("BUSCAR FACTURA ");
        jXLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel2.setText("Número Factura");

        txNFact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNFactActionPerformed(evt);
            }
        });
        txNFact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txNFactKeyPressed(evt);
            }
        });

        btBuscar.setText("Buscar Número");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre Cliente");

        txNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNombreActionPerformed(evt);
            }
        });
        txNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txNombreKeyPressed(evt);
            }
        });

        btBuscarNombre.setText("Buscar Nombre");
        btBuscarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarNombreActionPerformed(evt);
            }
        });

        jLabel1.setText("Rut Cliente");

        txRut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txRutKeyPressed(evt);
            }
        });

        btBuscaRut.setText("Buscar Rut");
        btBuscaRut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscaRutActionPerformed(evt);
            }
        });

        buLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/erase16.png"))); // NOI18N
        buLimpiar.setText("Limpiar");
        buLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txNFact, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txRut, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btBuscaRut, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buLimpiar))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(txNFact, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txRut, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscaRut, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 690, 120));
    }// </editor-fold>//GEN-END:initComponents
//-----------------------------------------------------------------------------
//  BOTON BUSCAR
//-----------------------------------------------------------------------------
    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        //Llama a mostrar factura segun el numeor ingresado
        
        BuscarBotonNumero();
    }//GEN-LAST:event_btBuscarActionPerformed
//-----------------------------------------------------------------------------
//  BOTON LIMPIAR
//-----------------------------------------------------------------------------
    private void buLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buLimpiarActionPerformed
       //Limpia campos y muestra todas las facturas.
       
        BuscarCargar();
        txNFact.setText("");
        txNombre.setText("");
        txRut.setText("");
    }//GEN-LAST:event_buLimpiarActionPerformed

    private void MnuFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuFacturaActionPerformed
        // TODO add your handling code here:
        String StrRut,StrNrodocto;
        pfFAProveedor FAP = new pfFAProveedor();
        pnPestanas.addTab("Factura de Proveedor", FAP);
        PanelTab btc=new PanelTab(pnPestanas,0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(FAP), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
        
        StrRut= Grilla.getValueAt(Grilla.getSelectedRow(), 0).toString().trim();
        StrNrodocto =Grilla.getValueAt(Grilla.getSelectedRow(), 3).toString().trim();
        
        
        if (!StrRut.equals("") && !StrNrodocto.equals("")){
            FAP.CargaFactura(StrRut, StrNrodocto);
            
        }

    }//GEN-LAST:event_MnuFacturaActionPerformed

    private void txNFactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNFactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNFactActionPerformed

    private void txNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNombreActionPerformed

    private void btBuscarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarNombreActionPerformed
        BuscarBotonNombre();
    }//GEN-LAST:event_btBuscarNombreActionPerformed

    private void btBuscaRutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscaRutActionPerformed
       BuscarBotonRut();
    }//GEN-LAST:event_btBuscaRutActionPerformed

    private void txNFactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNFactKeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode() == KeyEvent.VK_ENTER){
             btBuscar.doClick();
         }
        
        
    }//GEN-LAST:event_txNFactKeyPressed

    private void txNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNombreKeyPressed
        // TODO add your handling code here:
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
             btBuscarNombre.doClick();
         }
        
    }//GEN-LAST:event_txNombreKeyPressed

    private void txRutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRutKeyPressed
        // TODO add your handling code here:
              if(evt.getKeyCode() == KeyEvent.VK_ENTER){
             btBuscaRut.doClick();
         }
    }//GEN-LAST:event_txRutKeyPressed

    private void MnuPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuPagosActionPerformed
       if(Grilla.getValueAt(Grilla.getSelectedRow(), 5).toString().trim().equals("FAP")){
            String StrRut;
            pfReportePagosPrv repPagosPRV = new pfReportePagosPrv();;
            pnPestanas.addTab("Pago Proveedores", repPagosPRV);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(repPagosPRV), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
        
            StrRut= Grilla.getValueAt(Grilla.getSelectedRow(), 0).toString().trim();
        
        
            if (!StrRut.equals("")){
            repPagosPRV.CargaProveedor(StrRut);
            }
            
        }else{
            String StrRut, StrCodigo, StrTipo;
            pfGastos reGastos = new pfGastos();;
            pnPestanas.addTab("Consulta de Vendedor", reGastos);
            PanelTab btc=new PanelTab(pnPestanas,0);
            pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(reGastos), btc);
            pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
        
            StrRut= Grilla.getValueAt(Grilla.getSelectedRow(), 0).toString().trim();
            StrCodigo = Grilla.getValueAt(Grilla.getSelectedRow(), 4).toString().trim();
            StrTipo = Grilla.getValueAt(Grilla.getSelectedRow(), 5).toString().trim();
        
            if (!StrRut.equals("")){
            reGastos.AbrirDocumento(StrRut, StrCodigo, StrTipo);
            }
       }
    }//GEN-LAST:event_MnuPagosActionPerformed

    private void txSkuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txSkuKeyPressed

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            TableRowSorter<TableModel>sorter = new TableRowSorter<TableModel>(Grilla.getModel());
            Grilla.setRowSorter(sorter);
            String sku = txSku.getText().trim();
            if (sku.length()==0)
            {
                sorter.setRowFilter(null);
            }
            else{
                int cant=0;
                int ev=0;
                String precio = "";
                sorter.setRowFilter(RowFilter.regexFilter(sku));
            }
        }
    }//GEN-LAST:event_txSkuKeyPressed

    private void txSkuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txSkuKeyTyped
        // TODO add your handling code here:
        if (Character.isLowerCase(evt.getKeyChar()))
        evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
    }//GEN-LAST:event_txSkuKeyTyped

    private void txSkuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txSkuKeyReleased
        TableRowSorter<TableModel>sorter = new TableRowSorter<TableModel>(Grilla.getModel());
        Grilla.setRowSorter(sorter);
        String sku = txSku.getText().trim();
        if (sku.length()==0)
        {
            sorter.setRowFilter(null);
        }
        else{
            int cant=0;
            int ev=0;
            String precio = "";
            sorter.setRowFilter(RowFilter.regexFilter(sku));
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txSkuKeyReleased

    

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Grilla;
    private javax.swing.JMenuItem MnuFactura;
    private javax.swing.JMenuItem MnuPagos;
    private javax.swing.JButton btBuscaRut;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btBuscarNombre;
    private javax.swing.JButton buLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private javax.swing.JLabel lbCantidad;
    private javax.swing.JLabel lbcargando;
    private javax.swing.JTextField txNFact;
    private javax.swing.JTextField txNombre;
    private javax.swing.JTextField txRut;
    private javax.swing.JTextField txSku;
    // End of variables declaration//GEN-END:variables
}
