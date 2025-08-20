
package Dialogos;

import Conexion.ExeSql;
import static Formularios.fmMain.pnPestanas;
import PanelForm.pfClientes;
import PanelForm.pfGastosSueldos; 
import PanelForm.pfProveedores;
import Utilidades.CargaGrillas;
import Utilidades.PanelTab;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class jd_Localidades extends javax.swing.JDialog {

int Tipo;
int Elige = 0;

String RutSel;
String NomCiudad;
String NomComuna;
    public jd_Localidades(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Grilla = new javax.swing.JTable();
        btCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);

        jLabel1.setText("Filtro");

        txNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNombreActionPerformed(evt);
            }
        });
        txNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txNombreKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txNombreKeyTyped(evt);
            }
        });

        Grilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
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

        btCerrar.setText("Cerrar");
        btCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void SetTipo(int Valor){
        Tipo=Valor;
    }
    
    
    public String GetNomCiudad(){
        return NomCiudad;
    }
    
    
    public String GetNomComuna(){
        return NomComuna;
    }
    
        
    public int GetElige(){
        return Elige;
    }
    
    
    private void txNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNombreKeyReleased
       

        TableRowSorter<TableModel>sorter = new TableRowSorter<TableModel>(Grilla.getModel());
        Grilla.setRowSorter(sorter);
        String nombre = txNombre.getText().trim();
        if (nombre.length()==0)
        {
            sorter.setRowFilter(null);
            
        }
        else{
            
            sorter.setRowFilter(RowFilter.regexFilter(nombre));
            
        } 
          
        
        
        
    }//GEN-LAST:event_txNombreKeyReleased

    
    public void Carga(){
        
        DefaultTableModel tbMd = (DefaultTableModel) Grilla.getModel();

        ExeSql Sql = new ExeSql();
        ResultSet Rs = null;
        String Query = "";
        
         while(tbMd.getRowCount()>0)
            tbMd.removeRow(0);
       
            
            Query = "select \n" +
                        "case \n" +
                        "when (blue.localidad) is not null then (blue.localidad)\n" +
                        "when (ps.nombre) is not null then (ps.nombre)\n" +
                        "when (pt.ciudad) is not null then (pt.ciudad)\n" +
                        "end as ciudad\n" +
                        "from pd_zonageografica_blue blue\n" +
                        "full outer join pd_ciudades_samex ps on ps.nombre = blue.localidad\n" +
                        "full outer join pd_ciudades_tnt pt on pt.ciudad = blue.localidad \n" +
                        "group by blue.localidad, ps.nombre, pt.ciudad\n" +
                        "order by blue.localidad, ps.nombre, pt.ciudad"; 
            try {
                Rs = Sql.Select(Query);
                
                if (Sql.GetRowCount() > 0){
            
                    while (Rs.next()){
                
                        tbMd.addRow(new Object[]{Rs.getString("ciudad")});
                
                    }
                
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(jd_Localidades.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    
    }
    
    
    
    private void GrillaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrillaMouseClicked
        
        if(evt.getClickCount()==2){
            
            String Nombre = Grilla.getValueAt(Grilla.getSelectedRow(), 0).toString().trim();
                 
            if(this.getTitle() == "Buscar Ciudad"){

                NomCiudad = Nombre;
                Elige = 1;
                    
            }
            else if(this.getTitle() == "Buscar Comuna"){
                
                NomComuna = Nombre;
                Elige = 1;
            }
            

            this.dispose();
        }
    }//GEN-LAST:event_GrillaMouseClicked

    private void GrillaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GrillaKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            String Rut    = Grilla.getValueAt(Grilla.getSelectedRow(), 0).toString();
            String Nombre = Grilla.getValueAt(Grilla.getSelectedRow(), 1).toString();
            Rut = Rut.substring(0, Rut.length()-2);

            if(Nombre.length()>20) Nombre=Nombre.substring(0, 20);
            if(this.getTitle() == "Buscar Cliente" ){
                if(Tipo==0){
                    pfClientes Cli = new pfClientes();
                    Cli.setOpaque(false);
                    pnPestanas.addTab(Nombre, Cli);
                    PanelTab btc=new PanelTab(pnPestanas,0);
                    pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Cli), btc);
                    pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
                    Cli.CargaCliente(Rut);
                }
                else{
                    RutSel=Rut;
                }

            }
            else{
                if(Tipo==0){
                    pfProveedores Prv = new pfProveedores();
                    Prv.setOpaque(false);
                    pnPestanas.addTab(Nombre, Prv);
                    PanelTab btc=new PanelTab(pnPestanas,0);
                    pnPestanas.setTabComponentAt(pnPestanas.indexOfComponent(Prv), btc);
                    pnPestanas.setSelectedIndex(pnPestanas.getTabCount()-1);
                    Prv.CargaProveedor(Rut);
                }
                else
                    RutSel=Rut;
                
            }

            this.dispose();
        }
        else if(evt.getKeyCode()== KeyEvent.VK_ESCAPE){
            txNombre.requestFocus();
        }
        else if(evt.getKeyCode()== KeyEvent.VK_UP && Grilla.getSelectedRow()==0){
            txNombre.requestFocus();
        }
    }//GEN-LAST:event_GrillaKeyPressed

    private void btCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCerrarActionPerformed
        
        Elige = 0;
        dispose();
    }//GEN-LAST:event_btCerrarActionPerformed

    private void txNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNombreKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ESCAPE){
            dispose();
        }
    }//GEN-LAST:event_txNombreKeyPressed

    private void txNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNombreKeyTyped
        if (Character.isLowerCase(evt.getKeyChar()))
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));  
    }//GEN-LAST:event_txNombreKeyTyped

    private void txNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNombreActionPerformed

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
            java.util.logging.Logger.getLogger(jd_Localidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jd_Localidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jd_Localidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jd_Localidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jd_Localidades dialog = new jd_Localidades(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable Grilla;
    private javax.swing.JButton btCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txNombre;
    // End of variables declaration//GEN-END:variables
}
