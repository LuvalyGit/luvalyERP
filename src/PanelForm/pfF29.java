/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelForm;

import Conexion.ExeSql;
import Formularios.fmMain;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David Alcaman
 */
public class pfF29 extends javax.swing.JPanel {
private static JTable t;
    /**
     * Creates new form pfUsuarios
     */
    public pfF29() {
        initComponents();
        
        cbAgno.setSelectedIndex(1);
        cbAgno.setEnabled(true);
        
     
    }
    
    public void CargaDatos(){
        
        ResultSet Rs,Rs1, Rs2;
        ExeSql Sql = new ExeSql();
        DefaultTableModel Modelo = (DefaultTableModel) Grilla.getModel();
        String agno = cbAgno.getSelectedItem().toString();
        
        Modelo.setColumnCount(2);
        
       
        
        try{
        double totiva=0;
        double totppm=0;
        double totimpuesto=0;
        double totretencion=0;
        double totpagado=0;
        double totventas=0;
        double totmargen=0;
            
        for(int x=1; x<13; x++){
            
        double afecto=0;
        double afectocompra=0;
        double exento=0;
        double ncc=0;
        double ncccompra=0;
        double venta=0;
        double compra=0;
        double iva=0;
        double ivacompra=0;
        double ppm=0;
        double ivaventa=0;
        double margen=0;
        double pagado=0;
        String mes="";
        double impsueldo=0;
        
       
        Rs2 = Sql.Select("select count(monto) as cuantos from psueldosdet where codigo=19 and agno="+agno+" and mes="+x);
        Rs2.next();
        if (Rs2.getInt("cuantos")>=1)
        {        
        Rs2 = Sql.Select("select sum((monto)) as impsueldo from psueldosdet where codigo=19 and agno="+agno+" and mes="+x);
        Rs2.next();
        impsueldo = Double.valueOf(Rs2.getString("impsueldo"));
        }
        else{
            impsueldo=0;
        }
   // COMPRAS --------------------------------------------------------------------------------
        Rs1 = Sql.Select("select c.tipdocto, c.totalexento,c.totalafecto, c.totaliva \n" +
                        "from ctacteprv c \n" +
                        "where extract(year from c.femision)="+agno+" \n " +
                        "and extract(MONTH from c.femision)="+x+" \n " +
                        "and c .tipdocto in ('FAP','FAG','NCP')");

         while(Rs1.next()){
             if (Rs1.getString("tipdocto").equals("FAP") || Rs1.getString("tipdocto").equals("FAG"))
                {
                 afectocompra = afectocompra+Double.valueOf(Rs1.getString("totaliva"));
                }

             if (Rs1.getString("tipdocto").equals("NCP"))
                {
                 ncccompra = ncccompra + Double.valueOf(Rs1.getString("totaliva"));
                }
         } 
        
    // VENTAS-------------------------------------------------------------------------------------------    
        Rs = Sql.Select("select c.tipdocto, c.totalexento,c.totalafecto, c.totaliva\n" +
                        "from ctactecli c\n" +
                        "where extract(year from c.femision)="+agno+"\n" +
                        "and extract(MONTH from c.femision)="+x+"\n" +
                        "and c .tipdocto in ('FAC','FEC','FMC','NCC','NDC')");
         while(Rs.next()){
             if (Rs.getString("tipdocto").equals("FAC"))
                {
                 afecto = afecto+Double.valueOf(Rs.getString("totalafecto"));
                }
             if (Rs.getString("tipdocto").equals("FEC"))
                {
                 exento = exento + Double.valueOf(Rs.getString("totalexento"));
                }
             if (Rs.getString("tipdocto").equals("NCC"))
                {
                 ncc = ncc + Double.valueOf(Rs.getString("totalafecto"));
                }
         } 
         venta= exento+afecto-ncc;
         compra= afectocompra-ncccompra;
         ivacompra = compra;
         System.out.println("IVA COMPRA:" +compra);
         iva=((afecto*0.19)-(ncc*0.19))-ivacompra;
         ppm=(venta*1/100);
         pagado=iva+ppm+impsueldo;
         ivaventa=iva/venta;
         margen=((iva/0.19)/venta);
         
         if(x==1){mes="ENERO";}
         if(x==2){mes="FEBRERO";}
         if(x==3){mes="MARZO";}
         if(x==4){mes="ABRIL";}
         if(x==5){mes="MAYO";}
         if(x==6){mes="JUNIO";}
         if(x==7){mes="JULIO";}
         if(x==8){mes="AGOSTO";}
         if(x==9){mes="SEPTIEMBRE";}
         if(x==10){mes="OCTUBRE";}
         if(x==11){mes="NOVIEMBRE";}
         if(x==12){mes="DICIEMBRE";}
         System.out.println(mes);
        totiva+=iva; 
        totppm+=ppm; 
        totimpuesto+=impsueldo;
        totpagado += pagado;
        totventas+=ivaventa;
        totmargen+=margen;
        
        Modelo.addColumn(mes, new String[]{String.valueOf(Math.round(iva)),String.valueOf(Math.round(ppm)),
                                String.valueOf(Math.round(impsueldo)),"",String.valueOf(Math.round(pagado)),
                                String.valueOf(Math.round(ivaventa*10000.00)/100.00), String.valueOf(Math.round(margen*10000.00)/100.00)});
           
        
        }
        txIva.setText(String.valueOf(Math.round(totiva)));
        txPPM.setText(String.valueOf(Math.round(totppm)));
        txImpuestos.setText(String.valueOf(Math.round(totimpuesto)));
        txPagado.setText(String.valueOf(Math.round(totpagado)));
        txVentas.setText(String.valueOf((Math.round(totventas*10000.00)/100.00)/12));
        txMargen.setText(String.valueOf((Math.round(totmargen*10000.00)/100.00)/12));
        txRetencion.setText(String.valueOf(Math.round(totretencion)));
            
        }
        catch (Exception e)
        {
        fmMain.Mensaje("Error al cargar: "+e);
        }
        finally{
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

        pnMenu = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Grilla = new javax.swing.JTable();
        cbAgno = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txIva = new javax.swing.JTextField();
        txPPM = new javax.swing.JTextField();
        txImpuestos = new javax.swing.JTextField();
        txRetencion = new javax.swing.JTextField();
        txPagado = new javax.swing.JTextField();
        txVentas = new javax.swing.JTextField();
        txMargen = new javax.swing.JTextField();

        pnMenu.setBackground(new java.awt.Color(220, 215, 226));

        jPanel2.setBackground(new java.awt.Color(220, 215, 226));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("F29"));

        Grilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"089", "IVA"},
                {"062", "PPM"},
                {"048", "Ret.Impuesto a la renta"},
                {"151", "Ret. 10% terceros"},
                {null, "Pagado"},
                {null, "%IVA/Vtas"},
                {null, "Margen Vta.Estimado"}
            },
            new String [] {
                "CODIGO SII", "TIPO"
            }
        ));
        jScrollPane1.setViewportView(Grilla);
        if (Grilla.getColumnModel().getColumnCount() > 0) {
            Grilla.getColumnModel().getColumn(0).setMinWidth(30);
            Grilla.getColumnModel().getColumn(0).setPreferredWidth(60);
            Grilla.getColumnModel().getColumn(0).setMaxWidth(60);
            Grilla.getColumnModel().getColumn(1).setMinWidth(120);
            Grilla.getColumnModel().getColumn(1).setPreferredWidth(120);
            Grilla.getColumnModel().getColumn(1).setMaxWidth(120);
        }

        cbAgno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025" }));
        cbAgno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAgnoActionPerformed(evt);
            }
        });

        jLabel1.setText("AÑO:");

        jLabel2.setText("TOTAL IVA:");

        jLabel3.setText("TOTAL PPM:");

        jLabel4.setText("TOTAL IMP.TRABAJADORES:");

        jLabel5.setText("TOTAL RETENCION 10% TERCEROS:");

        jLabel6.setText("TOTAL PAGADO:");

        jLabel7.setText("TOTAL % IVA/VTAS:");

        jLabel9.setText("TOTAL MARGEN VTA.ESTIMADO:");

        txIva.setText(" ");
        txIva.setEnabled(false);

        txPPM.setEnabled(false);

        txImpuestos.setEnabled(false);

        txRetencion.setEnabled(false);

        txPagado.setEnabled(false);

        txVentas.setEnabled(false);

        txMargen.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addGap(38, 38, 38))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(24, 24, 24)
                        .addComponent(cbAgno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txImpuestos)
                    .addComponent(txPPM, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txIva, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(txRetencion))
                .addGap(71, 71, 71)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txPagado, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(txVentas)
                    .addComponent(txMargen))
                .addContainerGap(474, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAgno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(txIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txPagado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(txPPM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(txImpuestos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txMargen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txRetencion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(460, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnMenuLayout = new javax.swing.GroupLayout(pnMenu);
        pnMenu.setLayout(pnMenuLayout);
        pnMenuLayout.setHorizontalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnMenuLayout.setVerticalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbAgnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAgnoActionPerformed
        CargaDatos();
    }//GEN-LAST:event_cbAgnoActionPerformed
 
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Grilla;
    private javax.swing.JComboBox<String> cbAgno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JTextField txImpuestos;
    private javax.swing.JTextField txIva;
    private javax.swing.JTextField txMargen;
    private javax.swing.JTextField txPPM;
    private javax.swing.JTextField txPagado;
    private javax.swing.JTextField txRetencion;
    private javax.swing.JTextField txVentas;
    // End of variables declaration//GEN-END:variables
}
