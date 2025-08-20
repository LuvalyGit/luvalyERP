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


public class jdOCPAgregaProducto extends javax.swing.JDialog {
    private boolean Retorno;
    private boolean Valida = false;
    String RutPrv="";
    int cant_original;
    String TipDocto="";
    int display = 0;
    
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    
    Date hoy = new Date();
    Date mesant = new Date();
    Calendar calendar = Calendar.getInstance();

    public void setTipDocto(String TipDocto) {
        this.TipDocto = TipDocto;
    }

   
    public jdOCPAgregaProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lbCodPrv.setVisible(false);
        chkCodPrv.setVisible(false);
        txCodPrv.setVisible(false);
        cbDescuento.setVisible(false);
        
        
      
	
      calendar.setTime(mesant); // Configuramos la fecha que se recibe
      calendar.add(Calendar.DAY_OF_YEAR, -30);  // numero de días a añadir, o restar en caso de días<0 
      
      
     
        
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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbVpromedio = new javax.swing.JLabel();
        lbMargen = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbEmbalaje = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbVdias = new javax.swing.JLabel();
        lbStock = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbUCompra = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Código");

        txCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txCodigoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txCodigoKeyTyped(evt);
            }
        });

        btIr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos22/Go.png"))); // NOI18N
        btIr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIrActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Unidad");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Cantidad");

        txCantidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txCantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txCantidadFocusLost(evt);
            }
        });
        txCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txCantidadActionPerformed(evt);
            }
        });
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txPrecioKeyTyped(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Precio");

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        cbDescuento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3" }));

        txCodPrv.setEnabled(false);
        txCodPrv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txCodPrvKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txCodPrvKeyTyped(evt);
            }
        });

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

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Venta Promedio Mercado Público");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Margen %");

        lbVpromedio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbVpromedio.setText("0");
        lbVpromedio.setToolTipText("");
        lbVpromedio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbMargen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMargen.setText("0");
        lbMargen.setToolTipText("");
        lbMargen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setText("Embalaje : ");

        lbEmbalaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEmbalaje.setText("0");
        lbEmbalaje.setToolTipText("");
        lbEmbalaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setText("Ventas en 30 días ");
        jLabel9.setToolTipText("");

        jLabel10.setText("Unidades");

        lbVdias.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbVdias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbVdias.setText("0");
        lbVdias.setToolTipText("");
        lbVdias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lbStock.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbStock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStock.setText("0");
        lbStock.setToolTipText("");
        lbStock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Stock");

        jLabel12.setText("U. Compra :");

        lbUCompra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbUCompra.setText("0");
        lbUCompra.setToolTipText("");
        lbUCompra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(btCancelar))
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 63, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btIr, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(72, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbMargen, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(chkDirecta, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel9)
                                                .addGap(4, 4, 4)
                                                .addComponent(lbVdias, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addComponent(txUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(txUM, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addComponent(txPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btRecalculaPrecio)))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(chkCodPrv))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(txCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, Short.MAX_VALUE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(lbCodPrv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txCodPrv, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(30, 30, 30))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(btAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(lbStock, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbEmbalaje, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbUCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addGap(0, 169, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbVpromedio, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btIr)
                    .addComponent(txCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txUM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(btRecalculaPrecio)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(lbStock, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(lbEmbalaje, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(lbUCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbVpromedio)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(lbVdias, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lbCodPrv)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txCodPrv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkCodPrv))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lbMargen))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkDirecta)
                        .addGap(60, 60, 60))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCodigoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btIr.doClick();
        }
    }//GEN-LAST:event_txCodigoKeyPressed
    public void SetProducto(String Codigo,String Cantidad,String Valor, String CodPrv){
    
        int cant =0;    
        txCodigo.setText(Codigo);
        btIr.doClick();
        txCodigo.setEditable(false);
        btIr.setEnabled(false);
        System.out.println("Cantidad ES : "+Cantidad);
        
        Cantidad = Cantidad.replaceAll("\\,", "");
        
        String[] tcant = Cantidad.split("\\.",2);
        
        System.out.println("tcant[0] ES : "+tcant[0]);
        
        
        cant= Integer.parseInt(tcant[0].trim());
        //txCantidad.setText(String.valueOf(Cantidad));
        txCantidad.setText(String.valueOf(cant));
        txPrecio.setText(String.valueOf(Valor));
        
        
        chkCodPrv.setSelected(true);
        txCodPrv.setEnabled(true);
        
        txCodPrv.setText(CodPrv);
//        if (Cantidad.equals(""))
//            Cantidad="0";
//        cant_original=Double.valueOf(Cantidad.trim());
//        txCantidad.requestFocus();
        
//        if (Cantidad.equals(""))
//            cant="0";
        cant_original=cant;
        txCantidad.requestFocus();
        btRecalculaPrecio.setEnabled(true);
        

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
        
        if(txCantidad.getText().isEmpty() || txPrecio.getText().isEmpty() || txCodigo.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Faltan Datos");
                return;
        
        }
        
        int cantfinal = 0;
        int cantidad = Integer.parseInt(txCantidad.getText().toString().trim());
        
        display = Integer.parseInt(lbEmbalaje.getText().trim());
        
        System.out.println("display ES : "+display);
          
        if (display == 0){
        
            display = 1;
        
        }
        
        
        cantfinal = Math.round(cantidad / display) * display;
        
        System.out.println("cantinal ES : "+cantfinal);
        
        
        
        if (!fmMain.GetUsuario().equals("LRUBILAR")){
            
            if (cantidad != cantfinal){
            
                //fmMain.Mensaje("La Cantidad debe ser "+Math.round(cantfinal) );  
                fmMain.Mensaje("La Cantidad debe ser múltiplo del embalaje ("+display+")");  
                txCantidad.requestFocus();
                txCantidad.setText("");
                Valida= false;
                return;
            
            }else {
            
                Valida = true;
            
            }
        } else {
        
           Valida = true; 
            
        }   
        
        
        
        
        
        
        
        
        
        
        
            
        if (!txCodPrv.getText().trim().isEmpty()){
            
                ExeSql Sql = new ExeSql();  
                ResultSet Rs = null;
                
                
                try {
            
                    Rs = Sql.Select("SELECT sku, codbar FROM codbar WHERE sku NOT IN ('"+txCodigo.getText().trim()+"') \n"+
                                    "AND codbar IN ('"+txCodPrv.getText().trim()+"') AND rutprv = "+RutPrv);
                
                    if(Sql.GetRowCount() > 0){
                    
                        Rs.next();
                    
                        fmMain.Mensaje("El Codigo de Proveddor ya está asociado al Sku : "+Rs.getString("sku").trim());
                        return;
                    
                    }
            
                
            
                } catch (SQLException ex) {
                    Logger.getLogger(jdOCPAgregaProducto.class.getName()).log(Level.SEVERE, null, ex);
                }
                    finally {
                    Sql.Close();
                }
            
            
            }
            
            
        
            txCantidad.setText(fmMain.SetGuardar(txCantidad.getText()));
            txPrecio.setText(fmMain.SetGuardar(txPrecio.getText()));   
            Retorno = true;

            dispose();                   //cierra la ventana de diálogo
       
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
       
    }//GEN-LAST:event_txPrecioActionPerformed

    private void chkCodPrvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCodPrvActionPerformed
        if (chkCodPrv.isSelected()){
             
            txCodPrv.setEnabled(true);
            txCodPrv.requestFocus();
        }
        
        if (!chkCodPrv.isSelected()){
            
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
            pfOCCliente.directa = true;
        }else if(!chkDirecta.isSelected()){
            pfOCCliente.directa = false;
        }

    }//GEN-LAST:event_chkDirectaActionPerformed

    private void txCantidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txCantidadFocusLost
        
        double cantfinal = 0;
        double cantidad = Double.parseDouble(txCantidad.getText().toString().trim());
            
        cantfinal = Math.round(cantidad / display) * display;
        
        if (cantfinal < 1){
        
            cantfinal = display;
            
        }
            
            
        System.out.println("EL display ES : "+display);
            
        System.out.println("LA cantidad ES : "+cantidad);
          
        System.out.println("LA cantfinal ES : "+cantfinal);
            
        System.out.println("EL USUARIO ES : "+fmMain.GetUsuario());  
            
        
        if (!fmMain.GetUsuario().equals("LRUBILAR")){
            
            if (cantidad != cantfinal){
            
                //fmMain.Mensaje("La Cantidad debe ser "+Math.round(cantfinal) );  
                fmMain.Mensaje("La Cantidad debe ser múltiplo del embalaje ("+display+")");  
                txCantidad.requestFocus();
                txCantidad.setText("");
                Valida= false;
                return;
            
            }else {
            
                Valida = true;
            
            }
        } else {
        
           Valida = true; 
            
        }   
//            
            
            
    }//GEN-LAST:event_txCantidadFocusLost

    private void txCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txCantidadActionPerformed

    private void txCodPrvKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCodPrvKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txCodPrvKeyReleased

    private void txCodPrvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCodPrvKeyTyped
        
        char keyChar = evt.getKeyChar();
        
        if (Character.isLowerCase(keyChar)) {
            evt.setKeyChar(Character.toUpperCase(keyChar));
        }
        
    }//GEN-LAST:event_txCodPrvKeyTyped

    private void txCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCodigoKeyTyped
      
        char keyChar = evt.getKeyChar();
        
        if (Character.isLowerCase(keyChar)) {
            evt.setKeyChar(Character.toUpperCase(keyChar));
        }
    }//GEN-LAST:event_txCodigoKeyTyped

    public String GetSku(){
        return txCodigo.getText().trim();
    }
    public String GetNombre(){
        return txNombre.getText().trim();
    }
    
    public Boolean GetRetorno(){
        return Retorno;
    }
    
    
    public String GetPrecio(){
        return txPrecio.getText().trim();
    }
    
    public String GetCantidad(){
        return txCantidad.getText().trim();
    }
    
    
    public String GetCodPrv(){
        return txCodPrv.getText().trim();
    }
    
     
    
//-----------------------------------------------------------------------------
//  RETORNA FILA
//-----------------------------------------------------------------------------    
    public Object[] GetFila(){
        double TotLinea =  Float.parseFloat(txCantidad.getText()) * Float.parseFloat(txPrecio.getText());
        if(Retorno)
            return new Object[]{txCodigo.getText(),
                                txNombre.getText(),
                                txUM.getText(),
                                fmMain.FormatoNumero(Double.valueOf(txCantidad.getText())),
                                0,
                                fmMain.FormatoNumero(Double.valueOf(txCantidad.getText())),
                                fmMain.FormatoNumero(Double.valueOf(txPrecio.getText())),
                                cbDescuento.getSelectedIndex(),
                                Double.valueOf(txPrecio.getText()) * cbDescuento.getSelectedIndex() /100,
                                fmMain.FormatoNumero(TotLinea),
                                Double.valueOf(txPrecio.getText()),
                                pfOCCliente.directa};   
            
        else
            return null;
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
                                Double.valueOf(fmMain.SetGuardar(txCantidad.getText())),
                                0,
                                "","","",
                                0
                                
                              
                                };  
                                
            
        else
            return null;
    }
    public Object[] GetFilaOCP_Porcentaje(){
        double TotLinea =  Float.parseFloat(txCantidad.getText()) * Float.parseFloat(txPrecio.getText());
        ExeSql sql = new ExeSql();
        ResultSet rs = null;
        String sku = txCodigo.getText();
        int porcentaje = 0;
        String porcent = "0";
        String query = "select porcentaje from prv_producto_porcentaje where sku = '"+sku+"'";
        try {
            rs = sql.Select(query);
            rs.next();
            if(rs.getRow()>0){
                porcentaje = rs.getInt("porcentaje");
                porcent = "0."+(100 - porcentaje); 
            }
            else {
                porcentaje = 1;
                porcent = "1";
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(jdOCPAgregaProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            sql.Close();
        }
        
        
        
        
        double ConPorcentaje = ((TotLinea/Double.parseDouble(porcent)));
        System.out.println("porcentaje: "+ConPorcentaje+"");
        if(Retorno)
            return new Object[]{txCodigo.getText(),
                                txCodPrv.getText(),
                                txNombre.getText(),
                                txUM.getText(),
                                fmMain.FormatoNumero(Double.valueOf(fmMain.SetGuardar(txCantidad.getText()))),
                                fmMain.FormatoNumero(Double.valueOf(fmMain.SetGuardar(txPrecio.getText()))),
                                fmMain.FormatoNumeroSinDecimal(TotLinea),
                                Double.valueOf(fmMain.SetGuardar(txPrecio.getText())),
                                Double.valueOf(fmMain.SetGuardar(txCantidad.getText())),
                                (fmMain.FormatoTotal(ConPorcentaje)),
                                porcent};                       
        else
            return null;
    }
    
    public Object[] GetFilaOCP_Porcentaje_Rel(String sku_rel){
        double TotLinea =  Float.parseFloat(txCantidad.getText()) * Float.parseFloat(txPrecio.getText());
        ExeSql sql = new ExeSql();
        ExeSql_Econa econa = new ExeSql_Econa();
        ResultSet eco = null;
        String sku_ = "0", nombre_ = "0";
        ResultSet rs = null;
        String sku = txCodigo.getText();
        int porcentaje = 0;
        String porcent = "0";
        String query = "select porcentaje from prv_producto_porcentaje where sku = '"+sku+"'";
        try {
            
            if(rs.getRow()>0){
                porcentaje = rs.getInt("porcentaje");
                porcent = "0."+(100 - porcentaje); 
            }
            else {
                porcentaje = 1;
                porcent = "1";
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(jdOCPAgregaProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            sql.Close();
        }
        
        try {
            eco = econa.Select("select sku, nombre from producto where rel_luvaly = '"+sku_rel+"'");
            rs = sql.Select(query);
            rs.next();
            if(rs.getRow()>0){
                sku_ = rs.getString("sku");
                nombre_ = rs.getString("nombre");
            }
            else {
                sku_ = "0";
                nombre_ = "0";
            }
        } catch (SQLException ex) {
            Logger.getLogger(jdOCPAgregaProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
        double ConPorcentaje = ((TotLinea/Double.parseDouble(porcent)));
        System.out.println("porcentaje: "+ConPorcentaje+"");
        if(Retorno)
            return new Object[]{txCodigo.getText(),
                                txCodPrv.getText(),
                                txNombre.getText(),
                                txUM.getText(),
                                fmMain.FormatoNumero(Double.valueOf(fmMain.SetGuardar(txCantidad.getText()))),
                                fmMain.FormatoNumero(Double.valueOf(fmMain.SetGuardar(txPrecio.getText()))),
                                fmMain.FormatoNumeroSinDecimal(TotLinea),
                                Double.valueOf(fmMain.SetGuardar(txPrecio.getText())),
                                Double.valueOf(fmMain.SetGuardar(txCantidad.getText())),
                                (fmMain.FormatoTotal(ConPorcentaje)),
                                porcent, sku_, nombre_};                       
        else
            return null;
    }
    
//-----------------------------------------------------------------------------
//  CARGA PRODUCTOS
//-----------------------------------------------------------------------------    
    private void CargaProductos(String Codigo){
        
        ExeSql  Sql = new ExeSql();
        ExeSql  Sql3 = new ExeSql();
        ExeSql  Sql4 = new ExeSql();
        ResultSet Rs, Rs2, Rs3, Rs4;
        
        String Sku = Codigo;
        
        try{
            
            if (!RutPrv.equals("")){
            
                 Rs2 = Sql.Select("Select codbar, sku, \n"+
                                  "case when rutprv is null then 0 else rutprv end as Rut  from codbar where (sku='"+Codigo.trim()+"' or codbar ='"+Codigo.trim()+"')");
                        
                
                if (Sql.GetRowCount()>0){
                    
                    while (Rs2.next()){
                    
                        
                        if (Rs2.getInt("Rut") != 0) {
                        
                            if (Rs2.getString("Rut").trim().equals(RutPrv)){
                    
                                txCodPrv.setText(Rs2.getString("codbar"));  //011002014
                                Sku = Rs2.getString("sku").trim();
                                break;
                    
                            }else {
                                                            
                                Sku = Rs2.getString("sku").trim();
                            
                            }
                        }else {
                        
                          Sku = Rs2.getString("sku").trim();
                        
                        }    
                    
                    }
                    
                }else {
                    
                    txCodPrv.setText("");
                    
                    
                    Rs4 = Sql4.Select("select idch, sku from codchile where sku='" + Codigo +"' or idch='"+ Codigo + "'" );
                    
                    if (Rs4.next()){
                        
                        Codigo = Rs4.getString("sku").trim();
                       
                    }
                    
                    
                 
                    Rs3 = Sql3.Select("Select sku from producto where sku='"+Codigo.trim()+"'" );
                
                    if (Rs3.next()){
                    
                        Sku = Rs3.getString("sku").trim();
                    
                    }else{
                    
                        fmMain.Mensaje("Código no encontrado...");
                        txCodigo.setText("");
                        txCodigo.requestFocus();
                        return;
                        
                    
                    }
                    
                }
            }
            
            
            Rs = Sql.Select("select p.discontinuado, p.sku,p.nombre, p.display,u.unidad,u.um, \n"+
                            "case i.stock when null then 0 else i.stock end as stock, p.valultcompra \n" +
                            "from producto p\n" +
                            "left join par_unidad u on u.codigo=p.unidad\n" +
                            "left join inventario i on p.sku=i.sku\n" +
                            "where p.sku='" + Sku + "'");
            Rs.next();
            txCodigo.setText(Rs.getString("sku"));
            txNombre.setText(Rs.getString("nombre"));
            txUnidad.setText(Rs.getString("unidad"));
            txUM.setText(Rs.getString("um"));
            lbEmbalaje.setText(Rs.getString("display"));
            display = Rs.getInt("display");
            lbUCompra.setText(""+Math.round(Rs.getDouble("valultcompra")));
        
            lbStock.setText(Rs.getString("stock"));
            lbStock.setForeground(new Color(0,153,51)); 
            lbStock.setBorder(BorderFactory.createLineBorder(new Color(0,153,51), 2));
            txCantidad.requestFocus();
            
            if (Rs.getBoolean("discontinuado")==true){
                
                fmMain.disc=1;
            
            }else{
               
                fmMain.disc=0;
            }
         
            CalculaVentaPromedio(txCodigo.getText().trim());
            CalculaVenta30Dias(txCodigo.getText().trim());   
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            }finally{
            Sql.Close();
        }
        
    }
    
    private void CalculaVenta30Dias(String Sku){
    
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        int Total = 0;
        
        
        String Desde = dateFormat.format(calendar.getTime());
        String Hasta = dateFormat.format(hoy).toString();
      
        System.out.println("HOY :"+Hasta);
        System.out.println("30 Dias :"+Desde);
        
        try {
            
            Rs = Sql.Select("select case when sum(ct.cantidad) is null then 0 else sum(ct.cantidad) END as total  from ctacteclidet ct\n"+
                            "left join ctactecli c on ct.rut = c.rut and ct.tipdocto = c.tipdocto and ct.nrodocto = c.nrodocto\n" +
                            "where ct.sku = '"+Sku+"' and ct.tipdocto IN ('BOC','FAC') and c.femision between '"+Desde+"' and '"+Hasta+"'");  
            
            if (Sql.GetRowCount() > 0){
            
                Rs.next();
                                
          
              Total = Rs.getInt("total");
          
                
                
               System.out.println("LA cantidad ES : "+Total);
          
                
               lbVdias.setText(""+Total);
               lbVdias.setForeground(new Color(0,153,51)); 
               lbVdias.setBorder(BorderFactory.createLineBorder(new Color(0,153,51), 2));
                             
                
            }else {
            
                lbVpromedio.setText("0");
                lbMargen.setText("0");
                lbVdias.setText("0");
                lbVdias.setForeground(new Color(0,153,51)); 
            
            
            }
//            GrillaProductos.setDefaultRenderer(Object.class, new Elrender()); 
//            GrillaProductos.repaint();
//           
            
        } catch (SQLException e) {
            System.out.println(e);
            Logger.getLogger(jdOCPAgregaProducto.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            Sql.Close();
        }
        
        
    
    
    }
    
    
    
    
    private void CalculaCantidad(String Sku){
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        int occ= 0;
        int stock = 0;
        int ocp = 0;
        display = 0;
        int subt1 = 0;
       
        
        try {
            
            Rs = Sql.Select("select i.sku,p.nombre, i.occ, i.stock, i.ocp,\n" +
                            "case when p.display is null then 0 else p.display end \n" +
                            "from inventario i\n" +
                            "left join producto p ON i.sku = p.sku \n" +
                            "where i.sku = '"+Sku+"'"
                            );
            
            if (Sql.GetRowCount() > 0){
            
                Rs.next();
                                
                occ= (Rs.getInt("occ")*-1);
                stock = Rs.getInt("stock");
                ocp = Rs.getInt("ocp");
                display = Rs.getInt("display");
                
                
                System.out.println("LA occ ES : "+occ);
          
                System.out.println("EL stock ES : "+stock);
            
                System.out.println("LA ocp ES : "+ocp);
                
                System.out.println("EL display ES : "+display);
            
                
                
                
                subt1 = occ - (stock+ocp);
                
                 
                if (subt1 < 0){
                
                    subt1 = subt1 * -1;
                
                }
                
                
                
                txCantidad.setText(""+subt1);
                      
                
                
            }
//            GrillaProductos.setDefaultRenderer(Object.class, new Elrender()); 
//            GrillaProductos.repaint();
//           
            
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            Sql.Close();
        }
        
    }
    
    
    private void CalculaVentaPromedio(String Sku){
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        double cantidad = 0;
        double totlinea = 0;
        double valultcompra = 0;
        double ventapromedio = 0;
        double margen = 0;
        
       
        
        try {
            
            Rs = Sql.Select("SELECT p.sku, ocd.cantidad, ocd.totlinea, p.valultcompra FROM producto p\n" +
                            "LEFT JOIN occhdet ocd ON p.sku = ocd.sku\n" +
                            "LEFT JOIN occh oc ON ocd.rut = oc.rut AND ocd.codigo_oc = oc.codigo_oc AND ocd.orden = oc.orden\n" +
                            "WHERE p.sku = '"+Sku+"' AND ocd.despachado = ocd.cantidad \n"+
                            "AND (ocd.orden LIKE '%ag%'  OR ocd.orden LIKE '%cm%' OR ocd.orden LIKE '%se%' )\n" +
                            "ORDER BY oc.femision DESC LIMIT 2 ");  
            
            if (Sql.GetRowCount() > 0){
            
                while (Rs.next()) {
                                
                cantidad = cantidad + Rs.getInt("cantidad");
                totlinea = totlinea + Rs.getInt("totlinea");
                valultcompra = Rs.getInt("valultcompra");
                
                
                System.out.println("LA cantidad ES : "+cantidad);
          
                System.out.println("EL totlinea ES : "+totlinea);
                    
                System.out.println("EL valultcompra ES : "+valultcompra);  
              
                      
                }
                
                ventapromedio = totlinea / cantidad;
                margen = ((ventapromedio - valultcompra )/ventapromedio)*100;
              
                
                lbVpromedio.setText(""+Math.round(ventapromedio));
                lbMargen.setText(""+Math.round(margen));

               
                
            }else {
            
                lbVpromedio.setText("0");
                lbMargen.setText("0");
            
            
            }
//            GrillaProductos.setDefaultRenderer(Object.class, new Elrender()); 
//            GrillaProductos.repaint();
//           
            
        } catch (SQLException e) {
            System.out.println(e);
            Logger.getLogger(jdOCPAgregaProducto.class.getName()).log(Level.SEVERE, null, e);
        }finally{
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
            java.util.logging.Logger.getLogger(jdOCPAgregaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdOCPAgregaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdOCPAgregaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdOCPAgregaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdOCPAgregaProducto dialog = new jdOCPAgregaProducto(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btIr;
    private javax.swing.JToggleButton btRecalculaPrecio;
    private javax.swing.JComboBox cbDescuento;
    private javax.swing.JCheckBox chkCodPrv;
    private javax.swing.JCheckBox chkDirecta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbCodPrv;
    private javax.swing.JLabel lbEmbalaje;
    private javax.swing.JLabel lbMargen;
    private javax.swing.JLabel lbStock;
    private javax.swing.JLabel lbUCompra;
    private javax.swing.JLabel lbVdias;
    private javax.swing.JLabel lbVpromedio;
    private javax.swing.JTextField txCantidad;
    private javax.swing.JTextField txCodPrv;
    private javax.swing.JTextField txCodigo;
    private javax.swing.JTextField txNombre;
    private javax.swing.JTextField txPrecio;
    private javax.swing.JTextField txUM;
    private javax.swing.JTextField txUnidad;
    // End of variables declaration//GEN-END:variables
}
