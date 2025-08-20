package Dialogos;

import Conexion.Econa.ExeSql_Econa;
import Conexion.ExeSql;
import Formularios.fmMain;
import PanelForm.pfOCCliente;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class jdNCPGastos extends javax.swing.JDialog {
    private boolean Retorno;
    //private boolean Valida = false;
    String RutPrv="";
    int cant_original;
    String TipDocto="";
    int display = 0;
    
    double totalncp = 0;
    double TotalDoc = 0;
    
    int Abrir = 0;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    
    Date hoy = new Date();
    Date mesant = new Date();
    Calendar calendar = Calendar.getInstance();

    public void setTipDocto(String TipDocto) {
        this.TipDocto = TipDocto;
    }
    
    
    
    public void setAbrir(int Abre) {
        this.Abrir = Abre;
        
        System.out.println("Abrir ES :"+Abrir);
        
         if(Abrir == 1){
        
            btAceptar.setEnabled(true);
            txNroNCP.setEnabled(true);
            dtEmision.setEnabled(true);
            
            txNeto.setEnabled(true);
            txIva.setEnabled(true);
            txTotal.setEnabled(true);
            
            
        
        }else{
        
           btAceptar.setEnabled(false);
           txNroNCP.setEnabled(false);
           dtEmision.setEnabled(false);
           
           txNeto.setEnabled(false);
           txIva.setEnabled(false);
           txTotal.setEnabled(false);
           
           
        
        }
        
        
        
    }

   
    public jdNCPGastos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
      
        calendar.setTime(mesant); // Configuramos la fecha que se recibe
        calendar.add(Calendar.DAY_OF_YEAR, -30);  // numero de días a añadir, o restar en caso de días<0 
      
        System.out.println("SEGUNDO Abrir ES :"+Abrir);
        
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btAceptar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txNroDocumento = new javax.swing.JTextField();
        txTipoDoc = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txNCAnteriores = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txRut = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txNombre = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        lbFolio = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txEstado = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dtEmision = new org.jdesktop.swingx.JXDatePicker();
        jLabel14 = new javax.swing.JLabel();
        txNroNCP = new javax.swing.JTextField();
        lbNeto = new javax.swing.JLabel();
        txNeto = new javax.swing.JTextField();
        txIva = new javax.swing.JTextField();
        lbIva = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txTotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btAceptar.setText("Aceptar");
        btAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptarActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Documento de Origen"));

        jLabel3.setText("Tipo");

        jLabel4.setText("Numero");

        txNroDocumento.setEnabled(false);
        txNroDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txNroDocumentoKeyPressed(evt);
            }
        });

        txTipoDoc.setToolTipText("");
        txTipoDoc.setEnabled(false);

        jLabel7.setText("Total Montos NC Anteriores");
        jLabel7.setToolTipText("");

        txNCAnteriores.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txNCAnteriores.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txNCAnteriores.setText("0");
        txNCAnteriores.setToolTipText("");
        txNCAnteriores.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txNroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txNCAnteriores, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txNCAnteriores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txNroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Proveedor"));

        jLabel1.setText("Rut");

        txRut.setEnabled(false);
        txRut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txRutKeyPressed(evt);
            }
        });

        jLabel2.setText("Nombre");

        txNombre.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txRut, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Nota de Crédito"));

        lbFolio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbFolio.setForeground(new java.awt.Color(255, 51, 51));

        jLabel5.setText("F. Emisión");

        txEstado.setEditable(false);

        jLabel6.setText("Estado");

        jLabel14.setText("Número");

        lbNeto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbNeto.setText("Neto");

        txNeto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txNeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNetoActionPerformed(evt);
            }
        });
        txNeto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txNetoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txNetoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txNetoKeyTyped(evt);
            }
        });

        txIva.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txIva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txIvaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txIvaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txIvaKeyTyped(evt);
            }
        });

        lbIva.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbIva.setText("Iva");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Total");

        txTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txTotalKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txTotalKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txEstado)
                            .addComponent(dtEmision, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(txNroNCP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbFolio)
                        .addGap(155, 155, 155))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbNeto)
                                    .addComponent(lbIva))
                                .addGap(16, 16, 16))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txNeto)
                            .addComponent(txIva)
                            .addComponent(txTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txNroNCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(dtEmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbFolio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbNeto)
                    .addComponent(txNeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbIva)
                    .addComponent(txIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(78, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void SetDocumento(String Rut,String Nombre,String TipoDoc, String NroDoc, String Neto, String Iva, String Total, String TotalNCP){
        
        txRut.setText(Rut);
        txNombre.setText(Nombre);
        txTipoDoc.setText(TipoDoc);
        txNroDocumento.setText(NroDoc);
        txNeto.setText(Neto);
        txIva.setText(Iva);
        txTotal.setText(Total);
        TotalDoc = Double.parseDouble(Total.replaceAll("\\,", ""));
        
        txNCAnteriores.setText(fmMain.FormatoTotal(Double.parseDouble(TotalNCP)));
        totalncp = Double.parseDouble(TotalNCP);

    }
    
    
    public void SetNCP(String Rut,String Nombre,String TipoDoc, String NroDoc, String Neto, String Iva, String Total, String Estado,
                       String NroNcp, Date FechaNcp ){
        
       
            txRut.setText(Rut);
            txNombre.setText(Nombre);
            txTipoDoc.setText(TipoDoc);
            txNroDocumento.setText(NroDoc);
            
            txNroNCP.setText(NroNcp);
            
            dtEmision.setDate(FechaNcp);
            
            txNeto.setText(Neto);
            txIva.setText(Iva);
            txTotal.setText(Total);
            txEstado.setText(Estado);
            
            
            
            
        
    }
    
    

//-----------------------------------------------------------------------------
//  BOTON ACEPTAR
//-----------------------------------------------------------------------------
    private void btAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptarActionPerformed
        
        
      
            if(fmMain.OkCancel("Esta seguro que desea Guardar?") != JOptionPane.OK_OPTION){
                return;
            }
            
            
            
            if(txNroNCP.getText().isEmpty()){
                
                JOptionPane.showMessageDialog(null,"Falta Numero de la Nota de Crédito");
                return;
                
            }
            
            if(getFecha().isEmpty()) {
                
                JOptionPane.showMessageDialog(null,"Debe Especificar la fecha del documento");
                return;
                
            }
            
            if(txNeto.getText().isEmpty() || txIva.getText().isEmpty() || txTotal.getText().isEmpty()){
                
                JOptionPane.showMessageDialog(null,"Faltan Datos");
                return;
                
            }
            
            
            if(txNeto.getText().equals("0") || txIva.getText().equals("0") || txTotal.getText().equals("0")){
                
                JOptionPane.showMessageDialog(null,"Montos no pueden ser 0");
                return;
                
            }
            
            
            double Neto = Double.parseDouble(txNeto.getText().toString().trim().replaceAll("\\,", ""));
            double Iva = Double.parseDouble(txIva.getText().toString().trim().replaceAll("\\,", ""));
            double Total = Double.parseDouble(txTotal.getText().toString().trim().replaceAll("\\,", ""));
            
            
            if (Total != (Neto+Iva)){
                
                JOptionPane.showMessageDialog(null,"Los Totales no coindicen");
                return;
                
            }
            
            
            
            
            
            System.out.println("Total ES : "+Total);
            System.out.println("Total-totalncp ES : "+(TotalDoc-totalncp));
            
            if (Total > (TotalDoc-totalncp)){
            
                JOptionPane.showMessageDialog(null,"El monto es mayor al documento!");
                return;
            
            }
            
            
            
            ExeSql Sql = new ExeSql();
            
        try {    
            
            Sql.ExeSql("INSERT INTO ctacteprv \n" +
                       "(rut,tipdocto,nrodocto,femision,totalexento,totalafecto, comision, totaliva,totalotroimp,"+
                       "totaldocto,electronica,tipdocorigen,nrodocorigen,pagado,estado,autoriza)\n" +
                       "VALUES (\n" +
                       txRut.getText() + ",\n'" +
                       "NCP" +  "',\n" +
                       txNroNCP.getText() +",\n'" +
                       getFecha() + "',\n" +
                       "0,\n" +
                       fmMain.SetGuardar(txNeto.getText()) +",\n" +
                       "0,\n" +
                       fmMain.SetGuardar(txIva.getText()) + ",\n" +
                       "0,\n" +
                       fmMain.SetGuardar(txTotal.getText()) + ",\n" +
                       1 + ",\n'" +
                       txTipoDoc.getText().trim() + "',\n'" +
                       txNroDocumento.getText() + "',\n" +
                       "0,\n" +
                       "1," +
                       1 +
                       ")");
            
            
            Sql.Commit();
            
            Retorno = true;
            
            dispose();                   //cierra la ventana de diálogo
        } catch (SQLException ex) {
            
            Retorno = false;
            Sql.Rollback();
            Logger.getLogger(jdNCPGastos.class.getName()).log(Level.SEVERE, null, ex);
        
        }finally{
        
            Sql.Close();
        
        }
       
    }//GEN-LAST:event_btAceptarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        Retorno= false;
        dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Retorno=false;
    }//GEN-LAST:event_formWindowOpened

    private void txTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txTotalKeyReleased

     
    }//GEN-LAST:event_txTotalKeyReleased

    private void txIvaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txIvaKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txTotal.requestFocus();
        }
    }//GEN-LAST:event_txIvaKeyPressed

    private void txIvaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txIvaKeyReleased

    }//GEN-LAST:event_txIvaKeyReleased

    private void txIvaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txIvaKeyTyped
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txTotal.requestFocus();
        }
    }//GEN-LAST:event_txIvaKeyTyped

    private void txNetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNetoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNetoActionPerformed

    private void txNetoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNetoKeyPressed

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        
        
        double Neto = Double.parseDouble(txNeto.getText().toString());
        double iva = Math.round(Neto* 0.19); 

        
        
        
        txIva.setText(""+Math.round(iva));
                
        double Total = Neto + iva;
             
        txTotal.setText(""+Math.round(Total));
        txTotal.requestFocus();
        
        }

        
    }//GEN-LAST:event_txNetoKeyPressed

    private void txNetoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNetoKeyReleased
        double retencion = 0;

       
    }//GEN-LAST:event_txNetoKeyReleased

    private void txNetoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNetoKeyTyped
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txIva.requestFocus();
        }
    }//GEN-LAST:event_txNetoKeyTyped

    private void txNroDocumentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNroDocumentoKeyPressed
       
    }//GEN-LAST:event_txNroDocumentoKeyPressed

    private void txRutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRutKeyPressed
       
    }//GEN-LAST:event_txRutKeyPressed

    private void txTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txTotalKeyPressed
       
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        
        double Total = Double.parseDouble(txTotal.getText().toString());
        double Neto = Math.round(Total/1.19); 
        double iva = Math.round(Total-Neto); 

        
        txIva.setText(""+Math.round(iva));
        txNeto.setText(""+Math.round(Neto));
        txNeto.requestFocus();
        
        }
        
        
        
    }//GEN-LAST:event_txTotalKeyPressed

    
    public String GetNombre(){
        return txNombre.getText().trim();
    }
    
    public Boolean GetRetorno(){
        return Retorno;
    }
    
    
    public String getFecha() {
        
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return( sdf.format( (dtEmision.getDate()).getTime() ) );
        } catch (Exception e) {
            return "";
        }
                    
    }    
    
    
    
    
    
    
     
    
//-----------------------------------------------------------------------------
//  RETORNA FILA
//-----------------------------------------------------------------------------    
//    public Object[] GetFila(){
//        double TotLinea =  Float.parseFloat(txCantidad.getText()) * Float.parseFloat(txPrecio.getText());
//        if(Retorno)
//            return new Object[]{txCodigo.getText(),
//                                txNombre.getText(),
//                                txUM.getText(),
//                                fmMain.FormatoNumero(Double.valueOf(txCantidad.getText())),
//                                0,
//                                fmMain.FormatoNumero(Double.valueOf(txCantidad.getText())),
//                                fmMain.FormatoNumero(Double.valueOf(txPrecio.getText())),
//                                cbDescuento.getSelectedIndex(),
//                                Double.valueOf(txPrecio.getText()) * cbDescuento.getSelectedIndex() /100,
//                                fmMain.FormatoNumero(TotLinea),
//                                Double.valueOf(txPrecio.getText()),
//                                pfOCCliente.directa};   
//            
//        else
//            return null;
//    }

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
            java.util.logging.Logger.getLogger(jdNCPGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdNCPGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdNCPGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdNCPGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdNCPGastos dialog = new jdNCPGastos(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAceptar;
    private javax.swing.JButton btCancelar;
    private org.jdesktop.swingx.JXDatePicker dtEmision;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lbFolio;
    private javax.swing.JLabel lbIva;
    private javax.swing.JLabel lbNeto;
    private javax.swing.JTextField txEstado;
    private javax.swing.JTextField txIva;
    private javax.swing.JTextField txNCAnteriores;
    private javax.swing.JTextField txNeto;
    private javax.swing.JTextField txNombre;
    private javax.swing.JTextField txNroDocumento;
    private javax.swing.JTextField txNroNCP;
    private javax.swing.JTextField txRut;
    private javax.swing.JTextField txTipoDoc;
    private javax.swing.JTextField txTotal;
    // End of variables declaration//GEN-END:variables
}
