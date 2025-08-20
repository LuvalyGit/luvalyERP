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


public class jdOCCAgregaProducto extends javax.swing.JDialog {
    private boolean Retorno;
    String RutPrv="";
    double cant_original;
    String TipDocto="";

    public void setTipDocto(String TipDocto) {
        this.TipDocto = TipDocto;
    }

   
    public jdOCCAgregaProducto(java.awt.Frame parent, boolean modal) {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

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

        jLabel4.setText("Cantidad");

        txCantidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txCantidadKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txCantidadKeyPressed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btIr, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txCantidad)
                            .addComponent(txUnidad)
                            .addComponent(txPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRecalculaPrecio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txUM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(chkCodPrv)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbCodPrv, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txCodPrv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(chkDirecta, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btCancelar)
                            .addComponent(cbDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btAceptar)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btIr)
                    .addComponent(txCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(txNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txUM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lbCodPrv))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkCodPrv)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(btRecalculaPrecio)
                                .addComponent(txCodPrv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(chkDirecta)
                        .addGap(11, 11, 11)))
                .addComponent(cbDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAceptar)
                    .addComponent(btCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            Logger.getLogger(jdOCCAgregaProducto.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(jdOCCAgregaProducto.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(jdOCCAgregaProducto.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(jdOCCAgregaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdOCCAgregaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdOCCAgregaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdOCCAgregaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdOCCAgregaProducto dialog = new jdOCCAgregaProducto(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbCodPrv;
    private javax.swing.JTextField txCantidad;
    private javax.swing.JTextField txCodPrv;
    private javax.swing.JTextField txCodigo;
    private javax.swing.JTextField txNombre;
    private javax.swing.JTextField txPrecio;
    private javax.swing.JTextField txUM;
    private javax.swing.JTextField txUnidad;
    // End of variables declaration//GEN-END:variables
}
