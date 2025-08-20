package Dialogos;

import Conexion.ExeSql;
import Formularios.fmMain;
import PanelForm.pfOCCliente_Trans;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class jdOCCAgregaProducto3 extends javax.swing.JDialog {
    private boolean Retorno;
    String RutPrv="";
    double cant_original;
    String TipDocto="";
    int ed2 = 0;
    double porcent2 = 0;
    double tporcent = 0;
    int desc = 0;
    double tdesc = 0;
    double precio = 0;
    double tlinea = 0;
    
    
    DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
    DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
    
    

    public boolean general = false;
    public void setTipDocto(String TipDocto) {
        this.TipDocto = TipDocto;
    }

   
    public jdOCCAgregaProducto3(java.awt.Frame parent, boolean modal, int ed, double porcent) {
        super(parent, modal);
        initComponents();
        
        
        separadoresPersonalizados.setDecimalSeparator('.');
    
                
        
        lbCodPrv.setVisible(false);
        chkCodPrv.setVisible(false);
        txCodPrv.setVisible(false);
        cbDescuento.setVisible(false);
        jLabel6.setVisible(false);
        jLabel7.setVisible(false);
        
        ed2= ed;
        porcent2 = porcent;
        
        
        lbDesc.setText(" % "+(porcent2*100));
        
        lbDesc.setVisible(false);
        
        
        if (ed2 == 0){
        
            btEcoDis.setEnabled(false);
            btWebTienda.setEnabled(true);
            btML.setEnabled(true);
        
        }else if (ed2 == 1){
        
           btEcoDis.setEnabled(true);
           btWebTienda.setEnabled(false);
           btML.setEnabled(false);
           
           
        }
        
        lb3.setVisible(false);
        lbVoculto.setVisible(false);
        
        
        System.out.println("EL PROCENTAJE ES : "+porcent2);
        
        
        if (fmMain.GetUsuarioVentaEmpresa()){
        
            lb4.setVisible(true);
            btEmpresa.setVisible(true);
            
            
        
        }else {
        
            lb4.setVisible(false);
            btEmpresa.setVisible(false);
        
        }
        
        
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txCodigo = new javax.swing.JTextField();
        btIr = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txNombre = new javax.swing.JTextField();
        txUnidad = new javax.swing.JTextField();
        txCantidad = new javax.swing.JTextField();
        btAceptar = new javax.swing.JButton();
        txPrecio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txUM = new javax.swing.JTextField();
        btCancelar = new javax.swing.JButton();
        cbDescuento = new javax.swing.JComboBox();
        txCodPrv = new javax.swing.JTextField();
        chkCodPrv = new javax.swing.JCheckBox();
        lbCodPrv = new javax.swing.JLabel();
        btRecalculaPrecio = new javax.swing.JToggleButton();
        chkDirecta = new javax.swing.JCheckBox();
        btEcoDis = new javax.swing.JButton();
        btWebTienda = new javax.swing.JButton();
        btML = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbDesc = new javax.swing.JLabel();
        btEmpresa = new javax.swing.JButton();
        lb4 = new javax.swing.JLabel();
        lbVoculto = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txStock = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Código");

        txCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txCodigoActionPerformed(evt);
            }
        });
        txCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txCodigoKeyPressed(evt);
            }
        });

        btIr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos22/Go.png"))); // NOI18N
        btIr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIrActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre");

        jLabel3.setText("Unidad");

        jLabel4.setText("Cantidad");

        txCantidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txCantidadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txCantidadKeyTyped(evt);
            }
        });

        btAceptar.setText("Aceptar");
        btAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptarActionPerformed(evt);
            }
        });

        txPrecio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txPrecioActionPerformed(evt);
            }
        });
        txPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txPrecioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txPrecioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txPrecioKeyTyped(evt);
            }
        });

        jLabel5.setText("Precio");

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        cbDescuento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3" }));

        txCodPrv.setEnabled(false);

        chkCodPrv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCodPrvActionPerformed(evt);
            }
        });

        lbCodPrv.setText("Codigo Proveedor");

        btRecalculaPrecio.setText("$");
        btRecalculaPrecio.setEnabled(false);
        btRecalculaPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRecalculaPrecioActionPerformed(evt);
            }
        });

        chkDirecta.setText("  Entrega Directa");
        chkDirecta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDirectaActionPerformed(evt);
            }
        });

        btEcoDis.setText("E/D");
        btEcoDis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEcoDisActionPerformed(evt);
            }
        });

        btWebTienda.setText("Web/Tienda");
        btWebTienda.setToolTipText("");
        btWebTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btWebTiendaActionPerformed(evt);
            }
        });

        btML.setText("ML");
        btML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMLActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 153));
        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setText("Se ingresará neto en la órden");

        lb1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb1.setText("0");

        lb2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb2.setText("0");

        lb3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb3.setText("0");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 153, 0));
        jLabel7.setText("Descuento");

        lbDesc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbDesc.setForeground(new java.awt.Color(51, 153, 0));
        lbDesc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDesc.setText("0");
        lbDesc.setToolTipText("");
        lbDesc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btEmpresa.setText("Empresas");
        btEmpresa.setToolTipText("");
        btEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEmpresaActionPerformed(evt);
            }
        });

        lb4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb4.setText("0");

        lbVoculto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbVoculto.setText("0");
        lbVoculto.setToolTipText("");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Stock");

        txStock.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txStock.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txStock.setText("0");
        txStock.setToolTipText("");
        txStock.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btIr, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbCodPrv)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkCodPrv)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txCodPrv, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(51, 51, 51)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(btRecalculaPrecio))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btCancelar)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(chkDirecta, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btML, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(txUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(txUM, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txStock, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(128, 128, 128)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lb1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lb2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btWebTienda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btEcoDis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btAceptar)
                                .addGap(179, 179, 179)
                                .addComponent(cbDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbVoculto, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btIr)
                    .addComponent(txCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(lbDesc)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btEcoDis, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btWebTienda, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lb4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbVoculto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btML, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkCodPrv, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbCodPrv, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txCodPrv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel2)
                            .addComponent(txNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txUM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(btRecalculaPrecio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addComponent(chkDirecta)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 26, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCodigoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btIr.doClick();
        }
    }//GEN-LAST:event_txCodigoKeyPressed
    
    
    public void SetProducto(String Codigo,String Cantidad,String Valor, Boolean dirct, Boolean desc){
        
       
        precio = 0;
        
        String cant ="";  
        
        txCodigo.setText(Codigo);
        btIr.doClick();
        txCodigo.setEditable(false);
        btIr.setEnabled(false);
        cant= fmMain.SetGuardar(Cantidad);
    
        txCantidad.setText(String.valueOf(cant));
        txPrecio.setText(String.valueOf(Valor));
        
        
                                
        
       
        
        if (Cantidad.equals(""))
            cant="0";
            cant_original=Double.valueOf(cant);
            txCantidad.requestFocus();
            btRecalculaPrecio.setEnabled(true);
        
        
        chkDirecta.setSelected(dirct);   //carga estado boolean si es directo o no
        
        
    }

//-----------------------------------------------------------------------------
//  BOTON IR
//-----------------------------------------------------------------------------
    private void btIrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIrActionPerformed
            
        if (TipDocto.equals("FAT")){
            if (cant_original > Double.valueOf(txCantidad.getText().trim())){
                fmMain.Msje("Valida Cantidad", "La cantidad no puede ser mayor a : " + cant_original, 500, 100);
                txCantidad.requestFocus();
                return;
            }
        }
        this.general = false;
        if(!txCodigo.getText().isEmpty())
           CargaProductos(txCodigo.getText());
        else{
           jdBuscarProductos2 BP = new jdBuscarProductos2(null, true);
           BP.setLocationRelativeTo(null);
           BP.setTitle("Buscar Producto");
           BP.setVisible(true);
           if(!BP.GetCodigo().isEmpty()){
              CargaProductos(BP.GetCodigo());
           }
        }
    }//GEN-LAST:event_btIrActionPerformed
//-----------------------------------------------------------------------------
//  BOTON ACEPTAR
//-----------------------------------------------------------------------------
    private void btAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptarActionPerformed
        
        
//        if (TipDocto.equals("FAT")){
//            
//            if(cant_original < Double.valueOf(txCantidad.getText().trim())){
//                fmMain.Msje("Validacion Cantidad", "La cantidad ingresada no puede ser mayor a la indicada en la Orden que es : " + cant_original, WIDTH, WIDTH);
//                txCantidad.requestFocus();
//                return;
//            }
//            
//            
//        }
        
        if(txCantidad.getText().isEmpty() || txPrecio.getText().isEmpty() || txCodigo.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Faltan Datos");
        }else{
            txCantidad.setText(fmMain.SetGuardar(txCantidad.getText()));
            
            if(jLabel6.isVisible()){
                txPrecio.setText((fmMain.SetGuardar(String.valueOf((Float.valueOf(txPrecio.getText())/1.19)))));
            }
            else {
                txPrecio.setText(fmMain.SetGuardar(txPrecio.getText()));
            }
            Retorno = true;
            
            if (chkCodPrv.isSelected()){
               
                ExeSql  Sql = new ExeSql();
                try{
                 
                    String insert_cod = "insert into codbar (sku, codbar, fecha, usuario, rutprv) values ('"+txCodigo.getText().trim()+"','"+txCodPrv.getText().trim()+"',CURRENT_DATE,'"+fmMain.GetUsuario()+"', "+RutPrv+")";
                    Sql.ExeSql(insert_cod);
                    Sql.Commit();
                    
                }
                catch (Exception e)
                    {
                    Sql.Rollback();
                    fmMain.Mensaje("Error al guardar el codigo de proveedor: "+e);
                    }
                finally{
                    Sql.Close();
                }
            }
            dispose();                   //cierra la ventana de diálogo
        }
    }//GEN-LAST:event_btAceptarActionPerformed

    private void txCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCantidadKeyTyped
      
        char c=evt.getKeyChar();   
        if(c ==',' || c=='.'){
            evt.consume();
            if(!txCantidad.getText().contains(fmMain.GetDecimal()))
                txCantidad.setText(txCantidad.getText() + fmMain.GetDecimal() );
        }
        
         if(Character.isLetter(c)) { 
              getToolkit().beep(); 
              evt.consume(); 
              System.out.println("Ingresa Solo Letras -->" + c ); 
         }  
  
      
    }//GEN-LAST:event_txCantidadKeyTyped

    private void txCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCantidadKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txPrecio.requestFocus();
        }
    }//GEN-LAST:event_txCantidadKeyPressed

    private void txPrecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txPrecioKeyPressed
        this.general = false;
        jLabel6.setVisible(false);
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                btAceptar.doClick();
        }
            
    }//GEN-LAST:event_txPrecioKeyPressed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        Retorno= false;
        dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Retorno=false;
    }//GEN-LAST:event_formWindowOpened

    private void txPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txPrecioKeyTyped
        this.general = false;  
        char c=evt.getKeyChar();  
        if(evt.getKeyChar()==',' || evt.getKeyChar()=='.'){
            evt.consume();
            if(!txPrecio.getText().contains(fmMain.GetDecimal()))
                txPrecio.setText(txPrecio.getText() + fmMain.GetDecimal() );
        }
               if(Character.isLetter(c)) { 
              getToolkit().beep(); 
              evt.consume(); 
              System.out.println("Ingresa Solo Letras -->" + c ); 
         }  
             
    }//GEN-LAST:event_txPrecioKeyTyped

    private void txPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txPrecioActionPerformed

    private void chkCodPrvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCodPrvActionPerformed
         if (chkCodPrv.isSelected())
            {
            txCodPrv.setEnabled(true);
            }
        if (!chkCodPrv.isSelected())
            {
            txCodPrv.setEnabled(false);
            }
    }//GEN-LAST:event_chkCodPrvActionPerformed

    private void btRecalculaPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRecalculaPrecioActionPerformed
        double nueva_cantidad = Double.valueOf(txCantidad.getText().trim());
        double precio = Double.valueOf(txPrecio.getText().trim());
        double nuevo_precio = precio/(nueva_cantidad/cant_original);
        txPrecio.setText(String.valueOf(nuevo_precio));
    }//GEN-LAST:event_btRecalculaPrecioActionPerformed

    private void chkDirectaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDirectaActionPerformed
        if(chkDirecta.isSelected()){
            pfOCCliente_Trans.directa = true;
        }else if(!chkDirecta.isSelected()){
            pfOCCliente_Trans.directa = false;
        }

    }//GEN-LAST:event_chkDirectaActionPerformed

    private void btEcoDisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEcoDisActionPerformed
        
        txPrecio.setText("");
        double precio = Double.parseDouble(lb1.getText().toString());
        
        txPrecio.setText(""+Math.round(precio/1.19));
        
        porcent2 = 0;
        
        lbDesc.setText(" % "+(porcent2));
        desc = 0;
        
        
    }//GEN-LAST:event_btEcoDisActionPerformed

    private void btWebTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btWebTiendaActionPerformed

        txPrecio.setText("");
        
        double precio2 = Double.parseDouble(lb2.getText().toString());
        
        txPrecio.setText(""+Math.round(precio2/1.19));
        
        desc = 1;
        
    }//GEN-LAST:event_btWebTiendaActionPerformed

    
    
    private void btMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMLActionPerformed

//        txPrecio.setText("");
//        
//        double precio3 = Double.parseDouble(lb3.getText().toString());
//        
//        txPrecio.setText(""+Math.round(precio3/1.19));
//        
//        porcent2 = 0;
//        
//        lbDesc.setText(" % "+(porcent2));
//        desc = 0;
        
        if (txCantidad.getText().isEmpty() || txCantidad.getText().equals("")){
        
            fmMain.Mensaje("Debe ingresar cantidad...!");
            return;
                
        }
        
        
        if (txPrecio.getText().isEmpty() || txPrecio.getText().equals("")){
        
            fmMain.Mensaje("Debe ingresar monto...!");
            return;
                
        }
        
        DecimalFormat formatodecimal = new DecimalFormat("##.000",separadoresPersonalizados);
        
        
        
        int cant = Integer.parseInt(txCantidad.getText().toString().trim());
        double precio = Double.parseDouble(txPrecio.getText().toString().trim());
        
        double total = (precio/cant)/1.19;
        
        txPrecio.setText(""+formatodecimal.format(total));
        
    }//GEN-LAST:event_btMLActionPerformed

    private void txPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txPrecioKeyReleased
        this.general = false;        // TODO add your handling code here:
    }//GEN-LAST:event_txPrecioKeyReleased

    private void txCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txCodigoActionPerformed

    private void btEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEmpresaActionPerformed
        txPrecio.setText(lb4.getText().toString().trim());
         
        simbolo.setDecimalSeparator('.');
        DecimalFormat formateador = new DecimalFormat("0.000",simbolo);
            
        double Voculto = Double.parseDouble(lbVoculto.getText().trim());
            
        txPrecio.setText(formateador.format(Voculto));
 
         
    }//GEN-LAST:event_btEmpresaActionPerformed

    public String GetSku(){
        return txCodigo.getText().trim();
    }
    public String GetPrecio(){
        return txPrecio.getText().trim();
    }
    
    public String GetCantidad(){
        return txCantidad.getText().trim();
    }
    
    
     public double GetDesp(){
        
        double tdesp =  Double.parseDouble(pfOCCliente_Trans.Despacho);
        return tdesp;
     }
     
     public Boolean GetRetorno(){
        return Retorno;
    }
     
    
    
    public double GetDesc(){
        
        double mdesc = 0;
        
        if (desc == 1){
       
         mdesc = Double.valueOf(txPrecio.getText()) * porcent2;
         
       }else if (desc == 0) {
       
          mdesc = 0;
       }  
        
        
       tdesc = mdesc;
        
       return tdesc ;
    }
    
    public double GetPorcent(){
        
        tporcent = (porcent2*100);
        
        return tporcent ;
    }
    
    public double GetTlinea(){
                
        tlinea =  Double.parseDouble(txCantidad.getText()) * (Double.parseDouble(txPrecio.getText())-tdesc);
        
        return tlinea ;
    }
    
    public double GetPrecio2(){
        
        
        double mdesc = 0;
        
        if (desc == 1){
       
         mdesc = Double.valueOf(txPrecio.getText()) * porcent2;
         
       }else if (desc == 0) {
       
          mdesc = 0;
       }  
        
       tdesc = mdesc;
        
        precio =  (Double.parseDouble(txPrecio.getText())-tdesc);
        
        return precio;
    }
    
    
    public int GetAplicaDesc(){        //Si se aplica descuento o no
               
        return desc ;
    }
    

    
//-----------------------------------------------------------------------------
//  RETORNA FILA
//-----------------------------------------------------------------------------    
    public Object[] GetFila(){
        
        
        double mdesc = 0;
        double precio = 0;
        
       double dif = Double.valueOf(txCantidad.getText()) - Double.valueOf(pfOCCliente_Trans.Despacho);
       
       if (desc == 1){
       
         mdesc = Double.valueOf(txPrecio.getText()) * porcent2;
         
       }else if (desc == 0) {
       
          mdesc = 0;
       }  
       
       //double TotLinea =  Double.parseDouble(txCantidad.getText()) * Double.parseDouble(txPrecio.getText());
       double TotLinea =  Double.parseDouble(txCantidad.getText()) * (Double.parseDouble(txPrecio.getText())-mdesc);
       precio =  (Double.parseDouble(txPrecio.getText())-mdesc);
       
        Object[] obj = null;
        if(Retorno) {
            if((Double.valueOf(pfOCCliente_Trans.Despacho) > Double.valueOf(txCantidad.getText())))
                JOptionPane.showMessageDialog(rootPane, "Cantidad no puede ser menor a despachado.");
            else 
                obj = new Object[]{txCodigo.getText(),
                                txNombre.getText(),
                                txUM.getText(),
                                fmMain.FormatoNumero(Double.valueOf(txCantidad.getText())),
                                fmMain.FormatoNumero(Double.valueOf(pfOCCliente_Trans.Despacho)),
                                fmMain.FormatoNumero(dif),
                                fmMain.FormatoNumero(Double.valueOf(txPrecio.getText())),
                                (porcent2*100),
//                              cbDescuento.getSelectedIndex(),
                                mdesc,
                                //Double.valueOf(txPrecio.getText()) * cbDescuento.getSelectedIndex() /100,
                                fmMain.FormatoNumero(TotLinea),
                                fmMain.FormatoNumero(precio),
                                //Double.valueOf(txPrecio.getText()),
                                pfOCCliente_Trans.directa,
                                fmMain.FormatoNumero(TotLinea*1.19),
                                pfOCCliente_Trans.esdesc,
                                fmMain.FormatoNumero(Double.valueOf(txCantidad.getText()))
                };   
        }

        else
            return null;
        return obj;
    }
//-----------------------------------------------------------------------------
//  RETORNA FILA
//-----------------------------------------------------------------------------    
    public Object[] GetFilaNCC(){
        double TotLinea =  Float.parseFloat(txCantidad.getText()) * Float.parseFloat(txPrecio.getText());
        if(Retorno)
            return new Object[]{txCodigo.getText(),
                                txNombre.getText(),
                                txUM.getText(),
                                fmMain.FormatoNumero(Double.valueOf(txCantidad.getText())),
                                fmMain.FormatoNumero(Double.valueOf(txPrecio.getText())),
                                fmMain.FormatoNumero(TotLinea),
                                Double.valueOf(txPrecio.getText())};   
            
        else
            return null;
    }    
 //-----------------------------------------------------------------------------
//  RETORNA FILA OCP
//-----------------------------------------------------------------------------    
    public Object[] GetFilaOCP(){
        double TotLinea =  Float.parseFloat(txCantidad.getText()) * Float.parseFloat(txPrecio.getText());
        if(Retorno)
            return new Object[]{txCodigo.getText(),
                                txCodPrv.getText(),
                                txNombre.getText(),
                                txUM.getText(),
                                fmMain.FormatoNumero(Double.valueOf(fmMain.SetGuardar(txCantidad.getText()))),
                                fmMain.FormatoNumero(Double.valueOf(fmMain.SetGuardar(txPrecio.getText()))),
                                fmMain.FormatoNumeroSinDecimal(TotLinea),
                                Double.valueOf(fmMain.SetGuardar(txPrecio.getText())),
                                Double.valueOf(fmMain.SetGuardar(txCantidad.getText()))};  
                                
            
        else
            return null;
    }
    
//-----------------------------------------------------------------------------
//  CARGA PRODUCTOS
//-----------------------------------------------------------------------------    
    private void CargaProductos(String Codigo){
        ExeSql  Sql = new ExeSql();
        ExeSql  Sql3 = new ExeSql();
        ResultSet Rs, Rs2, Rs3;
        
        double valor_uc = 0;
        double vunitario = 0;
        double cost_ref = 0;
        double cost_vweb = 0;
        double cost_vent_neto1 = 0;
        double cost_vent_neto2 = 0;
        double cost_vent_neto3 = 0;
        
        double cost_redon_empresa = 0;
        double cost_vent_empresa = 0;
    
        
        try{
            Rs = Sql.Select("select distinct(p.sku),p.valultcompra, cc.discontinuado ,p.nombre,u.unidad,u.um, p.pventa_web2, p.valultcompra,i.stock \n" +
                            "from producto p\n" +
                            "left join par_unidad u\n" +
                            "on u.codigo=p.unidad\n" +
                            "left join codchile cc on cc.sku = p.sku\n" +
                            "left join inventario i on p.sku=i.sku\n" +
                            "where (p.sku='" + Codigo + "' or p.sku in (select sku from codchile where idch='" + Codigo + "')  or p.sku in (select sku from codbar where codbar = '"+ Codigo +"'))");
            Rs.next();
            
            if (Rs.getBoolean("discontinuado")==true){
                
                fmMain.disc=1;
                fmMain.Mensaje("No se puede agregar, producto discontinuado");
                txCodigo.setText("");
                return;
                
            }else{
               
                fmMain.disc=0;
            }
            
            
            
            txCodigo.setText(Rs.getString("sku"));
            txNombre.setText(Rs.getString("nombre"));
            txUnidad.setText(Rs.getString("unidad"));
            txUM.setText(Rs.getString("um"));
            txStock.setText(Rs.getString("stock").trim());
            
            
            txCantidad.requestFocus();
            
             cost_vent_empresa = Math.round(Rs.getDouble("valultcompra")/0.75*1.19); 
            
            
            
            if (!RutPrv.equals(""))
                {
                Rs2 = Sql.Select("Select codbar from codbar where rutprv="+RutPrv+ "and sku='"+txCodigo.getText().trim()+"'" );
                if (Rs2.next())
                    {
                    txCodPrv.setText(Rs2.getString("codbar"));
                    }
                else {
                    txCodPrv.setText("");
                    }
                }
           
            
            valor_uc = Rs.getDouble("valultcompra");
            Double vempresa = (Rs.getDouble("valultcompra")/0.75);
            cost_vweb = Rs.getDouble("pventa_web2");
            
            Rs3 = Sql3.Select("SELECT ccd.sku, ccd.valorunitario, ccd.tipdocto, ccd.nrodocto FROM ctacteprvdet ccd\n" +
                              "WHERE ccd.sku = '"+txCodigo.getText().trim()+"'\n" +
                              "AND ccd.tipdocto IN ('OCP')\n" +
                              "ORDER BY ccd.nrodocto DESC\n" +
                              "LIMIT 1");
            Rs3.next();
            
            if (Sql3.GetRowCount() > 0){
            
                vunitario = Rs3.getDouble("valorunitario");
            
            }else{
            
                vunitario = 0;
            
            }
            
            
            if (valor_uc >= vunitario ){
            
                cost_ref = valor_uc;
                
            
            }else if (vunitario >= valor_uc) {
            
                cost_ref = vunitario;      
            
            }
            
           
            cost_vent_neto1 = Math.round(cost_ref/0.94);
            cost_vent_neto2 = Math.round(cost_vweb);
            cost_vent_neto3 = Math.round(cost_ref/0.5);
            
            lb1.setText(""+Math.round(cost_vent_neto1*1.19));
            lb2.setText(""+Math.round(cost_vent_neto2));
            lb3.setText(""+Math.round(cost_vent_neto3*1.19));
            
            
            
//            cost_redon_empresa = vempresa%10;   //Extrae el el utlimo digito de la cifra
//            double dif2 = 10-cost_redon_empresa;
//                
//                
//            if (cost_redon_empresa >= 1){
//            
//                vempresa = vempresa + dif2;
//                
//            }
            
            lb4.setText(""+Math.round(vempresa));
            
    //******************************************************************************************************//        
           
            
            cost_redon_empresa = cost_vent_empresa%10;   //Extrae el el utlimo digito de la cifra
            

            
                double dif2 = 10-cost_redon_empresa;
            
                if (cost_redon_empresa >= 1){
            
                   cost_vent_empresa = cost_vent_empresa + dif2;
                
                }
            
                
            cost_vent_empresa = (cost_vent_empresa / 1.19);    
            
            lbVoculto.setText(""+cost_vent_empresa);
            lb4.setText("$ "+fmMain.FormatoNumeroSinDecimal(cost_vent_empresa));
            
           
            
    //******************************************************************************************************//                      
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally{
            jLabel6.setVisible(false);
            general = false;
            Sql.Close();
        }
        
        
    }
    public void Activa_Prv(String rutp)
    {
        RutPrv=rutp;
        lbCodPrv.setVisible(true);
        chkCodPrv.setVisible(true);
        txCodPrv.setVisible(true);
    }

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
            java.util.logging.Logger.getLogger(jdOCCAgregaProducto2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdOCCAgregaProducto2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdOCCAgregaProducto2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdOCCAgregaProducto2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdOCCAgregaProducto2 dialog = new jdOCCAgregaProducto2(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btEcoDis;
    private javax.swing.JButton btEmpresa;
    private javax.swing.JButton btIr;
    private javax.swing.JButton btML;
    private javax.swing.JToggleButton btRecalculaPrecio;
    private javax.swing.JButton btWebTienda;
    private javax.swing.JComboBox cbDescuento;
    private javax.swing.JCheckBox chkCodPrv;
    private javax.swing.JCheckBox chkDirecta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lbCodPrv;
    private javax.swing.JLabel lbDesc;
    private javax.swing.JLabel lbVoculto;
    private javax.swing.JTextField txCantidad;
    private javax.swing.JTextField txCodPrv;
    private javax.swing.JTextField txCodigo;
    private javax.swing.JTextField txNombre;
    private javax.swing.JTextField txPrecio;
    private javax.swing.JTextField txStock;
    private javax.swing.JTextField txUM;
    private javax.swing.JTextField txUnidad;
    // End of variables declaration//GEN-END:variables
}
