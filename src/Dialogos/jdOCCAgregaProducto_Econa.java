package Dialogos;

import Conexion.Econa.ExeSql_Econa;
import Conexion.ExeSql;
import Formularios.fmMain;
import PanelForm.pfOCCliente;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class jdOCCAgregaProducto_Econa extends javax.swing.JDialog {
    private boolean Retorno;
    String RutPrv="";
    double cant_original, cant_original_2;
    String TipDocto="";

    public void setTipDocto(String TipDocto) {
        this.TipDocto = TipDocto;
    }

   
    public jdOCCAgregaProducto_Econa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lbCodPrv.setVisible(false);
        chkCodPrv.setVisible(false);
        txCodPrv.setVisible(false);
        cbDescuento.setVisible(false);
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btAceptar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        cbDescuento = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txCodigo1 = new javax.swing.JTextField();
        btIr1 = new javax.swing.JButton();
        txNombre1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txUnidad1 = new javax.swing.JTextField();
        txUM1 = new javax.swing.JTextField();
        lbCodPrv1 = new javax.swing.JLabel();
        txCantidad1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txPrecio1 = new javax.swing.JTextField();
        chkDirecta1 = new javax.swing.JCheckBox();
        chkCodPrv1 = new javax.swing.JCheckBox();
        txCodPrv1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txCodigo = new javax.swing.JTextField();
        btIr = new javax.swing.JButton();
        txNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txUnidad = new javax.swing.JTextField();
        txUM = new javax.swing.JTextField();
        txCodPrv = new javax.swing.JTextField();
        chkCodPrv = new javax.swing.JCheckBox();
        chkDirecta = new javax.swing.JCheckBox();
        btRecalculaPrecio = new javax.swing.JToggleButton();
        txCantidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txPrecio = new javax.swing.JTextField();
        lbCodPrv = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

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

        cbDescuento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3" }));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Código");

        txCodigo1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txCodigo1KeyPressed(evt);
            }
        });

        btIr1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos22/Go.png"))); // NOI18N
        btIr1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIr1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Nombre");

        jLabel8.setText("Unidad");

        lbCodPrv1.setText("Codigo Proveedor");

        txCantidad1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txCantidad1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txCantidad1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txCantidad1KeyTyped(evt);
            }
        });

        jLabel9.setText("Cantidad");

        jLabel10.setText("Precio");

        txPrecio1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txPrecio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txPrecio1ActionPerformed(evt);
            }
        });
        txPrecio1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txPrecio1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txPrecio1KeyTyped(evt);
            }
        });

        chkDirecta1.setText("  Entrega Directa");
        chkDirecta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDirecta1ActionPerformed(evt);
            }
        });

        chkCodPrv1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCodPrv1ActionPerformed(evt);
            }
        });

        txCodPrv1.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btIr1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabel9)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txCantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txUnidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txPrecio1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(66, 66, 66)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(chkCodPrv1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txCodPrv1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(chkDirecta1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(lbCodPrv1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txUM1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btIr1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7)
                    .addComponent(txNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txUnidad1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txUM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbCodPrv1)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkCodPrv1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txCantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(txCodPrv1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txPrecio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(16, 16, 16))
                    .addComponent(chkDirecta1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Código");

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

        txCodPrv.setEnabled(false);

        chkCodPrv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCodPrvActionPerformed(evt);
            }
        });

        chkDirecta.setText("  Entrega Directa");
        chkDirecta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDirectaActionPerformed(evt);
            }
        });

        btRecalculaPrecio.setText("$");
        btRecalculaPrecio.setEnabled(false);
        btRecalculaPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRecalculaPrecioActionPerformed(evt);
            }
        });

        txCantidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txCantidadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txCantidadKeyTyped(evt);
            }
        });

        jLabel4.setText("Cantidad");

        jLabel5.setText("Precio");

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

        lbCodPrv.setText("Codigo Proveedor");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jLabel4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btIr, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txCantidad)
                            .addComponent(txUnidad)
                            .addComponent(txPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btRecalculaPrecio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(chkCodPrv)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txCodPrv, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(chkDirecta, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lbCodPrv)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txUM, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btIr)
                    .addComponent(txCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(txNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txUM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbCodPrv)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkCodPrv)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(btRecalculaPrecio)
                        .addComponent(txCodPrv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(16, 16, 16))
                    .addComponent(chkDirecta, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setText("Econa");

        jLabel12.setText("Luvaly");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(cbDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(219, 219, 219)
                                .addComponent(btCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btAceptar))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(cbDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btCancelar)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btAceptar)
                        .addGap(22, 22, 22))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCodigoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btIr.doClick();
        }
    }//GEN-LAST:event_txCodigoKeyPressed
    public void SetProducto(String Codigo,String Cantidad,String Valor){
    
    String cant ="";    
        txCodigo.setText(Codigo);
        btIr.doClick();
        txCodigo.setEditable(false);
        btIr.setEnabled(false);
        cant= fmMain.SetGuardar(Cantidad);
        //txCantidad.setText(String.valueOf(Cantidad));
        txCantidad.setText(String.valueOf(cant));
        txPrecio.setText(String.valueOf(Valor));
//        if (Cantidad.equals(""))
//            Cantidad="0";
//        cant_original=Double.valueOf(Cantidad.trim());
//        txCantidad.requestFocus();
        
        if (Cantidad.equals(""))
            cant="0";
        cant_original=Double.valueOf(cant);
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
           jdBuscarProductos BP = new jdBuscarProductos(null, true);
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
            txPrecio.setText(fmMain.SetGuardar(txPrecio.getText()));
            Retorno = true;
            if (chkCodPrv.isSelected())
                {
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
            pfOCCliente.directa = true;
        }else if(!chkDirecta.isSelected()){
            pfOCCliente.directa = false;
        }

    }//GEN-LAST:event_chkDirectaActionPerformed

    private void txCodigo1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCodigo1KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btIr1.doClick();
        }
    }//GEN-LAST:event_txCodigo1KeyPressed

    private void btIr1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIr1ActionPerformed
         if (TipDocto.equals("FAT")){
            if (cant_original > Double.valueOf(txCantidad1.getText().trim())){
                fmMain.Msje("Valida Cantidad", "La cantidad no puede ser mayor a : " + cant_original, 500, 100);
                txCantidad1.requestFocus();
                return;
            }
        }
        
        if(!txCodigo1.getText().isEmpty())
           CargaProductosEcona(txCodigo1.getText());
        else{
           jdBuscarProductos_Econa BP = new jdBuscarProductos_Econa(null, true);
           BP.setLocationRelativeTo(null);
           BP.setTitle("Buscar Producto");
           BP.setVisible(true);
           if(!BP.GetCodigo().isEmpty()){
              CargaProductosEcona(BP.GetCodigo());
           }
        }
    }//GEN-LAST:event_btIr1ActionPerformed

    private void txCantidad1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCantidad1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txCantidad1KeyPressed

    private void txCantidad1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCantidad1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txCantidad1KeyTyped

    private void txPrecio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txPrecio1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txPrecio1ActionPerformed

    private void txPrecio1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txPrecio1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txPrecio1KeyPressed

    private void txPrecio1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txPrecio1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txPrecio1KeyTyped

    private void chkDirecta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDirecta1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkDirecta1ActionPerformed

    private void chkCodPrv1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCodPrv1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkCodPrv1ActionPerformed

    public String GetSku(){
        return txCodigo.getText().trim();
    }
    public String GetNombre(){
        return txNombre.getText().trim();
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
                                fmMain.FormatoNumeroSinDecimal(TotLinea)};  
                                
            
        else
            return null;
    }
    public Object[] GetFilaOCP_Econa(){
        double TotLinea =  Float.parseFloat(txCantidad1.getText()) * Float.parseFloat(txPrecio1.getText());
        if(Retorno)
            return new Object[]{txCodigo1.getText(),
                                txCodPrv1.getText(),
                                txNombre1.getText(),
                                txUM1.getText(),
                                fmMain.FormatoNumero(Double.valueOf(fmMain.SetGuardar(txCantidad1.getText()))),
                                fmMain.FormatoNumero(Double.valueOf(fmMain.SetGuardar(txPrecio1.getText()))),
                                fmMain.FormatoNumeroSinDecimal(TotLinea),
                                Double.valueOf(fmMain.SetGuardar(txPrecio1.getText())),
                                Double.valueOf(fmMain.SetGuardar(txCantidad1.getText())),
                                fmMain.FormatoNumeroSinDecimal(TotLinea)};  
                                
            
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
            Logger.getLogger(jdOCCAgregaProducto_Econa.class.getName()).log(Level.SEVERE, null, ex);
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
    
//-----------------------------------------------------------------------------
//  CARGA PRODUCTOS
//-----------------------------------------------------------------------------    
    private void CargaProductos(String Codigo){
        ExeSql  Sql = new ExeSql();
        ResultSet Rs, Rs2;
        try{
            Rs = Sql.Select("select p.discontinuado, p.sku,p.nombre,u.unidad,u.um \n" +
                            "from producto p\n" +
                            "left join par_unidad u\n" +
                            "on u.codigo=p.unidad\n" +
                            "where p.sku='" + Codigo + "'");
            Rs.next();
            txCodigo.setText(Rs.getString("sku"));
            txNombre.setText(Rs.getString("nombre"));
            txUnidad.setText(Rs.getString("unidad"));
            txUM.setText(Rs.getString("um"));
            txCantidad.requestFocus();
            
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
            
            if (Rs.getBoolean("discontinuado")==true)
            {
                fmMain.disc=1;
            }
            else
            {
               fmMain.disc=0;
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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
            java.util.logging.Logger.getLogger(jdOCCAgregaProducto_Econa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdOCCAgregaProducto_Econa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdOCCAgregaProducto_Econa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdOCCAgregaProducto_Econa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdOCCAgregaProducto_Econa dialog = new jdOCCAgregaProducto_Econa(new javax.swing.JFrame(), true);
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
    private void CargaProductosEcona(String Codigo){
        ExeSql_Econa Sql = new ExeSql_Econa();
        ResultSet Rs, Rs2;
        try{
            Rs = Sql.Select("select p.discontinuado, p.sku,p.nombre,u.unidad,u.um \n" +
                            "from producto p\n" +
                            "left join par_unidad u\n" +
                            "on u.codigo=p.unidad\n" +
                            "where p.sku='" + Codigo + "'");
            Rs.next();
            txCodigo1.setText(Rs.getString("sku"));
            txNombre1.setText(Rs.getString("nombre"));
            txUnidad1.setText(Rs.getString("unidad"));
            txUM1.setText(Rs.getString("um"));
            txCantidad1.requestFocus();
            
            if (!RutPrv.equals(""))
                {
                Rs2 = Sql.Select("Select codbar from codbar where rutprv="+RutPrv+ "and sku='"+txCodigo1.getText().trim()+"'" );
                if (Rs2.next())
                    {
                    txCodPrv1.setText(Rs2.getString("codbar"));
                    }
                else {
                    txCodPrv1.setText("");
                    }
                }
            
            if (Rs.getBoolean("discontinuado")==true)
            {
                fmMain.disc=1;
            }
            else
            {
               fmMain.disc=0;
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            }finally{
            Sql.Close();
        }
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAceptar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btIr;
    private javax.swing.JButton btIr1;
    private javax.swing.JToggleButton btRecalculaPrecio;
    private javax.swing.JComboBox cbDescuento;
    private javax.swing.JCheckBox chkCodPrv;
    private javax.swing.JCheckBox chkCodPrv1;
    private javax.swing.JCheckBox chkDirecta;
    private javax.swing.JCheckBox chkDirecta1;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbCodPrv;
    private javax.swing.JLabel lbCodPrv1;
    private javax.swing.JTextField txCantidad;
    private javax.swing.JTextField txCantidad1;
    private javax.swing.JTextField txCodPrv;
    private javax.swing.JTextField txCodPrv1;
    private javax.swing.JTextField txCodigo;
    private javax.swing.JTextField txCodigo1;
    private javax.swing.JTextField txNombre;
    private javax.swing.JTextField txNombre1;
    private javax.swing.JTextField txPrecio;
    private javax.swing.JTextField txPrecio1;
    private javax.swing.JTextField txUM;
    private javax.swing.JTextField txUM1;
    private javax.swing.JTextField txUnidad;
    private javax.swing.JTextField txUnidad1;
    // End of variables declaration//GEN-END:variables
}
