/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelForm;

import Conexion.ExeSql;

import Formularios.fmMain;
import static Formularios.fmMain.intNivelUsuario;
import Utilidades.ComboCodigos;
import Utilidades.Combo_CodStr;
import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
/**
 *
 * @author informática
 */
public class pfControlAvanceTraslado extends javax.swing.JPanel {
    public static Color DARK_GREEN = new Color(0,153,0);
    DecimalFormat formateador = new DecimalFormat("###,###");
    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
    String Sku = "";
   
    public pfControlAvanceTraslado() {
        initComponents();
       
      
        jPanelHasta.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
       
        Carga_Indicadores();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanelHasta = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Grilla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jPanelHasta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel4.setText("ITEMS CONTADOS");
        jLabel4.setToolTipText("");

        jLabel5.setText("SKU POR CONTAR");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("0");
        jLabel8.setToolTipText("");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("0");
        jLabel7.setToolTipText("");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("ITEMS POR CONTAR");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("0");
        jLabel14.setToolTipText("");
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("0");
        jLabel15.setToolTipText("");
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText(" PORCENTAJE DE AVANCE");

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("% Avance Items");
        jLabel18.setToolTipText("");

        jLabel19.setText("SKU CONTADOS");
        jLabel19.setToolTipText("");

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("% Avance Sku");

        Grilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Usuario", "Items Contados", "Sku Contados"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Grilla);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelHastaLayout = new javax.swing.GroupLayout(jPanelHasta);
        jPanelHasta.setLayout(jPanelHastaLayout);
        jPanelHastaLayout.setHorizontalGroup(
            jPanelHastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHastaLayout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelHastaLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );
        jPanelHastaLayout.setVerticalGroup(
            jPanelHastaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHastaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(702, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 58, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Carga_Indicadores();
    }//GEN-LAST:event_jButton1ActionPerformed
    private void Carga_Indicadores(){
        ExeSql Sql = new ExeSql();
        ResultSet Rs, Rs2, Rs3,Rs31, Rs4, Rs5, Rs6, Rs7, Rs8, Rs9 = null;
        
        
        String Query, Query2, Query3,Query31, Query4, Query5, Query6, Query7, Query8, Query9 ;
        
        double items, items2, items3 = 0;
        double sku, sku2, sku3 = 0;
        
              
        
     
        try{
            
            //************* TOTAL ITEMS CONTADOS ************//
            
            Query = "select sum(mt.cant) itemscontados \n" +
                    "from mt_productos mt \n" +
                    "where mt.ubicacion LIKE '%BOD.%'";
            
            Rs = Sql.Select(Query);
            Rs.next();
            items = Rs.getDouble("itemscontados");
            
            jLabel7.setText(fmMain.FormatoNumeroSinDecimal(items));
            
            
            
            //************* TOTAL SKU CONTADOS************//
            
            Query2 = "select DISTINCT count (mt.sku) skucontados from mt_productos mt\n" +
                     "where mt.ubicacion LIKE '%BOD.%'"; 
            
            Rs2 = Sql.Select(Query2);
            Rs2.next();
            sku = Rs2.getDouble("skucontados");
            jLabel8.setText(fmMain.FormatoNumeroSinDecimal(sku));
            
            
            
            
            //************* TOTAL ITEMS POR CONTAR ************//
            
            
            Query3 = "select round(sum(mt.cant)) itemsporcontar from mt_productos mt\n" +
                     "where (mt.ubicacion LIKE '%LVLB1%' or mt.ubicacion LIKE '%LVLB3%'\n" +
                     "or mt.ubicacion IN ('TRAN.1001.1','TRAN.1010.1','TRAN.1009.1','TRAN.1005.1','TRAN.1004.1','TRAN.1000.1','TRAN.10009.1'))\n" +
                     "and mt.cant > 0 ";
            
            
            Rs3 = Sql.Select(Query3);
            Rs3.next();
            items2 = Rs3.getDouble("itemsporcontar");
            
            
            
            jLabel14.setText(fmMain.FormatoNumeroSinDecimal(items2));
            
            
            
            
            //************* TOTAL SKU POR CONTAR ************//
            
            Query4 = "select DISTINCT count(mt.sku) skuporcontar from mt_productos mt\n" +
                     "where (mt.ubicacion LIKE '%LVLB1%' or mt.ubicacion LIKE '%LVLB3%'\n" +
                     "or mt.ubicacion IN ('TRAN.1001.1','TRAN.1010.1','TRAN.1009.1','TRAN.1005.1','TRAN.1004.1','TRAN.1000.1','TRAN.10009.1'))\n" +
                     "and mt.cant > 0 ";
            
            Rs4 = Sql.Select(Query4);
            Rs4.next();
            sku2 = Rs4.getDouble("skuporcontar");
            jLabel15.setText(fmMain.FormatoNumeroSinDecimal(sku2));
            
            
        //************************* AVANCE **********************************//
            
           double avanceitems = (items / (items+items2))*100;
           
            
            double avancesku = (sku / (sku+sku2))*100;
            
             
            jLabel10.setText("% "+fmMain.FormatoNumero32(avanceitems));
            jLabel11.setText("% "+fmMain.FormatoNumero32(avancesku));
            
            AvanceUsuarios();
        
 
         }
        catch (Exception e) {
            System.out.println(e.getMessage());
            Logger.getLogger(pfProductos.class.getName()).log(Level.SEVERE, null, e);
           
        }
        
    }
 
    
    private void AvanceUsuarios(){
        
        ExeSql Sql = new ExeSql();
        ExeSql Sql2 = new ExeSql();
        ResultSet Rs, Rs2 = null;
    
        DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
        
        while(TableModel.getRowCount()>0){
            TableModel.removeRow(0);
        }
        
        String Query, Query2 ;
         
        
            
        try {
            
                 Query =  "select mt.usuario, sum(mt.cant) itemscontados, p.alias \n" +
                          "from mt_productos mt \n" +
                          "left join personal p on mt.usuario = p.usuario\n" +
                          "where mt.ubicacion LIKE '%BOD.%'\n" +
                          "group by mt.usuario, p.alias";
                 
                Rs = Sql.Select(Query);
                
                if (Sql.GetRowCount() > 0){
                
                    while (Rs.next()){
                    
                         TableModel.addRow(new Object[]{Rs.getString("alias"),
                                                       Rs.getInt("itemscontados")
                                                       
                        });
                    
                    
                    }
                
                
                }
                
                
                Query2 =  "select DISTINCT mt.usuario, count (mt.sku) skucontados, p.alias  from mt_productos mt\n" +
                          "left join personal p on mt.usuario = p.usuario\n" +
                          "where mt.ubicacion LIKE '%BOD.%'\n" +
                          "group by mt.usuario, p.alias";
                
                
                Rs2 = Sql2.Select(Query2);
                
                if (Sql2.GetRowCount() > 0){
                
                    while (Rs2.next()){
                    
                         String alias = Rs2.getString("alias");
                         int skucontados = Rs2.getInt("skucontados");
                         
                         
                         for (int i = 0; i < Grilla.getRowCount(); i++) {
                             
                             if (Grilla.getValueAt(i, 0).equals(alias.trim())) {
            
                                    Grilla.setValueAt(skucontados, i, 2);
                             
                             
                             }
                         
                         
                         }
                    
                    
                    }
                
                
                }
        
        } catch (SQLException ex) {
            Logger.getLogger(pfControlAvanceTraslado.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Grilla;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelHasta;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    
}
