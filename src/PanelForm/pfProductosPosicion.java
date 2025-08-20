/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelForm;

import Conexion.ExeSql;
import static Formularios.fmMain.pnPestanas;
import PanelForm.pfProductos;
import Utilidades.PanelTab;
import java.awt.event.KeyEvent;
import static java.lang.Double.isNaN;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.commons.math3.util.Precision;


/**
 *
 * @author informatica
 */
public class pfProductosPosicion extends javax.swing.JPanel {

    String posicion;
    String fecha;
    String convenio;
    
    DecimalFormat formateador = new DecimalFormat("###,###");
    
    public pfProductosPosicion() {
        initComponents();
    }
    
    
    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    } 
    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public void SetData(String posicion, String fecha,String convenio) {
        this.posicion = posicion;
        this.fecha = fecha;
        this.convenio = convenio;
        posicion_label.setText(getPosicion());
        fecha_label.setText(getFecha());
        CargaProducto();
    }
    
    public void CargaProducto() {
        
        ExeSql sql = new ExeSql();
        ResultSet rs = null;
        String Query = "";
        String Query2 = "";
        
       
        
        Query = "SELECT asd.cant_unidad AS cunidad, asd.precio_primero as pprimero,asd.costofinal AS cfinal, asd.id AS pid, asd.posicion as pos, asd.sku, asd.nombre, CASE when asd.conteo is null then '0' else asd.conteo END as conteo,asd.conv, asd.id \n" +
                "FROM \n" +
                "  (select ph.precio_primero,p.costofinal, cc.cant_unidad, ph.posicion as conteo, ph.posicion, p.sku , resultado.fecha, ph.convenio, ph.id, p.nombre, par.convenio as conv,\n" +
                "  CASE	\n" +
                "    when date_part('dow', to_timestamp(to_char(resultado.fecha,'yyyy-MM-dd'),'yyyy-MM-dd')) = 1 then 'Lunes' || ' ' || resultado.fecha \n" +
                "    when date_part('dow', to_timestamp(to_char(resultado.fecha,'yyyy-MM-dd'),'yyyy-MM-dd')) = 2 then 'Martes' || ' ' || resultado.fecha \n" +
                "    when date_part('dow', to_timestamp(to_char(resultado.fecha,'yyyy-MM-dd'),'yyyy-MM-dd')) = 3 then 'Miercoles' || ' ' || resultado.fecha \n" +
                "    when date_part('dow', to_timestamp(to_char(resultado.fecha,'yyyy-MM-dd'),'yyyy-MM-dd')) = 4 then 'Jueves' || ' ' || resultado.fecha \n" +
                "    when date_part('dow', to_timestamp(to_char(resultado.fecha,'yyyy-MM-dd'),'yyyy-MM-dd')) = 5 then 'Viernes' || ' ' || resultado.fecha \n" +
                "    when date_part('dow', to_timestamp(to_char(resultado.fecha,'yyyy-MM-dd'),'yyyy-MM-dd')) = 6 then 'Sábado' || ' ' || resultado.fecha \n" +
                "    when date_part('dow', to_timestamp(to_char(resultado.fecha,'yyyy-MM-dd'),'yyyy-MM-dd')) = 0 then 'Domingo'  || ' ' || resultado.fecha \n" +
                "  END AS dia,\n" +
                "\n" +
                "  CASE \n" +
                "  	when date_part('dow', resultado.fecha) = 6 OR date_part('dow', resultado.fecha) = 0\n" +
                "  	then 'Fin de Semana'\n" +
                "  	else 'Día de Semana'\n" +
                "  END AS dia_semanacase,\n" +
                "  CASE \n" +
                "    when to_date(to_char(resultado.fecha,'YYYY/MM/DD'),'YYYY/MM/DD') in (select fecha_feriado from feriados)\n" +
                "    then 'Feriado'\n" +
                "    else 'No feriado'\n" +
                "  END AS feriado_check\n" +
                "    \n" +
                "  from codproducto_rel cre\n" +
                "RIGHT JOIN producto p on p.sku = cre.sku\n" +
                "LEFT JOIN codchile cc on cc.sku = p.sku or cc.sku = cre.sku_rel\n" +
                "LEFT JOIN producto_posicion_historico ph on ph.id = cc.idch\n" +
                "LEFT JOIN par_convenio par on par.codigo = p.convenio\n"+
                "LEFT JOIN (select to_timestamp(to_char(generate_series((date '"+getFecha()+"')/**Rango Inicial**/,(date '"+getFecha()+"')/**Rango Final**/,interval '1 day'),'yyyy-MM-dd'),'yyyy-MM-dd') as fecha) resultado \n" +
                " on resultado.fecha = to_timestamp(to_char(ph.fecha,'yyyy-MM-dd'),'yyyy-MM-dd')\n" +
                " where to_timestamp(to_char(ph.fecha,'yyyy-MM-dd'),'yyyy-MM-dd') in (select generate_series((date '"+getFecha()+"')/**Rango Inicial**/,(date '"+getFecha()+"')/**Rango Final**/,interval '1 day'))\n" +
                " and to_timestamp(to_char(ph.fecha,'yyyy-MM-dd'),'yyyy-MM-dd') not in (select to_timestamp(to_char(fecha_feriado,'yyyy-MM-dd'),'yyyy-MM-dd') from feriados ) and p.es_cotiza = 0 and p.publicado is true\n";
                
        
                if (getPosicion().equals("11")){
                
                  Query = Query + " and ph.posicion >= "+ Integer.parseInt(getPosicion()) +" \n";
                
                }else {
                
                   Query = Query + " and ph.posicion = "+getPosicion()+"\n";
                
                }
                if(!getConvenio().equals("1")){
                    Query = Query + " and ph.convenio = "+getConvenio()+"\n";
                }
                Query = Query + "  ORDER BY ph.posicion) as asd\n" +

                "WHERE asd.dia_semanacase = 'Día de Semana'\n" +
                "";
            
                
               Query2 = "SELECT \n"+
                        "p.convenio, \n"+
                        "p.sku, \n"+
                        "CASE \n"+ 
                        "WHEN cc.idch IS NULL \n"+
                        "THEN '0' \n"+
                        "ELSE cc.idch \n"+
                        "END as pid, \n"+
                        "p.nombre, \n"+
                        "CASE \n"+ 
                        "WHEN pp.posicion IS NULL \n"+
                        "THEN '0' \n"+
                        "ELSE pp.posicion \n"+
                        "END as pos, \n"+
                        "CASE \n"+ 
                        "WHEN p.costofinal IS NULL \n"+
                        "THEN '0' \n"+
                        "ELSE p.costofinal \n"+
                        "END as cfinal, \n"+
                        "CASE \n"+
                        "WHEN pp.precio_primero IS NULL \n"+
                        "THEN '0' \n"+
                        "ELSE pp.precio_primero \n"+
                        "END as pprimero, \n"+
                        "CASE \n"+
                        "WHEN cc.cant_unidad IS NULL \n"+
                        "THEN '1' \n"+
                        "ELSE cc.cant_unidad \n"+
                        "END as cunidad \n"+
                        "FROM codchile cc \n"+
                        "LEFT JOIN producto_posicion_historico pp on pp.id = cc.idch and pp.fecha::date = '"+getFecha()+"' \n"+
                        "LEFT JOIN producto p on cc.sku = p.sku \n"+
                        "WHERE p.convenio = "+getConvenio()+" \n" +
                        "AND pp.posicion IS NULL";
        
        try{
            
            if(!posicion_label.getText().equals("0")){                  //para los productos que tiene posición        
                
                rs = sql.Select(Query);                 
            
            }else if(posicion_label.getText().equals("0")){             //para los productos que no tiene posición (posicion 0)
            
               rs = sql.Select(Query2);
            }    
            
            DefaultTableModel model = (DefaultTableModel) Grilla.getModel();
            
            while(model.getRowCount()>0){
               model.removeRow(0);
            }
            
            int conteo = 0;
            
            for(int i = 0; rs.next(); i++){
                
              double ctotal = rs.getDouble("cfinal") * rs.getInt("cunidad");
                
              double margen = ((rs.getDouble("pprimero") - ctotal)/rs.getDouble("pprimero"))*100;
                    
              if (margen <= 0 || isNaN(margen)){    //Si es menor o igual a cero |o| no es un numero
                        
                 margen = 0;
              }
                
              model.addRow(new Object[]{
                                rs.getString("pos"),
                                rs.getString("sku"),
                                rs.getString("pid"),
                                rs.getString("nombre"),
                                "$ "+formateador.format(rs.getDouble("pprimero")),
                                "$ "+formateador.format(ctotal),
                                "% "+Precision.round(margen,2)
              });
                
              conteo = conteo + 1;
            }
            
            cantidad_label.setText(String.valueOf(conteo));
            
            
        }catch (SQLException ex) {
            
            Logger.getLogger(pfProductosPosicion.class.getName()).log(Level.SEVERE, null, ex);
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

        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        posicion_label = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fecha_label = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cantidad_label = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txSku = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Grilla = new javax.swing.JTable();

        jMenuItem2.setText("Ver Producto");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItem2);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Información", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel1.setText("Posición:");

        posicion_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        posicion_label.setText("0");

        jLabel2.setText("Fecha:");

        fecha_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fecha_label.setText("0");

        jLabel3.setText("Cantidad:");

        cantidad_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cantidad_label.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(posicion_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fecha_label, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(54, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cantidad_label, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(posicion_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fecha_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cantidad_label))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Filtro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txSku, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txSku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Grilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Posición", "SKU", "ID", "Nombre", "Precio Primero", "Costo Final", "Margen"
            }
        ));
        Grilla.setComponentPopupMenu(jPopupMenu2);
        Grilla.setDoubleBuffered(true);
        Grilla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GrillaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Grilla);
        if (Grilla.getColumnModel().getColumnCount() > 0) {
            Grilla.getColumnModel().getColumn(0).setMinWidth(60);
            Grilla.getColumnModel().getColumn(0).setPreferredWidth(60);
            Grilla.getColumnModel().getColumn(0).setMaxWidth(60);
            Grilla.getColumnModel().getColumn(1).setMinWidth(100);
            Grilla.getColumnModel().getColumn(1).setPreferredWidth(100);
            Grilla.getColumnModel().getColumn(1).setMaxWidth(100);
            Grilla.getColumnModel().getColumn(2).setMinWidth(100);
            Grilla.getColumnModel().getColumn(2).setPreferredWidth(100);
            Grilla.getColumnModel().getColumn(2).setMaxWidth(100);
            Grilla.getColumnModel().getColumn(4).setMinWidth(150);
            Grilla.getColumnModel().getColumn(4).setPreferredWidth(150);
            Grilla.getColumnModel().getColumn(4).setMaxWidth(150);
            Grilla.getColumnModel().getColumn(5).setMinWidth(150);
            Grilla.getColumnModel().getColumn(5).setPreferredWidth(150);
            Grilla.getColumnModel().getColumn(5).setMaxWidth(150);
            Grilla.getColumnModel().getColumn(6).setMinWidth(150);
            Grilla.getColumnModel().getColumn(6).setPreferredWidth(150);
            Grilla.getColumnModel().getColumn(6).setMaxWidth(150);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 159, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

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

    private void txSkuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txSkuKeyTyped
        // TODO add your handling code here:
        if (Character.isLowerCase(evt.getKeyChar()))
        evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
    }//GEN-LAST:event_txSkuKeyTyped

    private void GrillaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrillaMouseClicked
      
    }//GEN-LAST:event_GrillaMouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
         System.out.println( Grilla.getValueAt(Grilla.getSelectedRow(), 1).toString().trim());
        pfProductos Pro = new pfProductos();
        Pro.setOpaque(false);
        pnPestanas.addTab("Producto", Pro);
        PanelTab btc = new PanelTab(pnPestanas, 0);
        pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Pro), btc);
        pnPestanas.setSelectedIndex(pnPestanas.getTabCount() - 1);
        Pro.txSku.requestFocus();
        Pro.CargaProducto(Grilla.getValueAt(Grilla.getSelectedRow(), 1).toString().trim());
    }//GEN-LAST:event_jMenuItem2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Grilla;
    private javax.swing.JLabel cantidad_label;
    private javax.swing.JLabel fecha_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel posicion_label;
    private javax.swing.JTextField txSku;
    // End of variables declaration//GEN-END:variables
}
