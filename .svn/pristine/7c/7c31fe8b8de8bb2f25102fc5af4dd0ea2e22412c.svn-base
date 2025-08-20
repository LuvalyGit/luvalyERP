/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dialogos;

import Conexion.ExeSql;
import Utilidades.TableCellRendererFeriado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author infornatica
 */
public class jdFechaFeriados extends javax.swing.JDialog {

    /**
     * Creates new form jdFechaFeriados
     */
    public jdFechaFeriados(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // Configuramos la fecha que se recibe


        calendar.add(Calendar.DAY_OF_MONTH, 10); 
        dtDesde.setDate(date);//Se establece fecha actual
        dtHasta.setDate(calendar.getTime());//Se establece fecha más 10 días
        listdias.setSelectedIndex(0);
        
        
    }
    public String getDesde() {//Conversion de fecha
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return( sdf.format( (dtDesde.getDate()).getTime() ) );
    }
    public String getHasta() {//Conversion de fecha
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return( sdf.format( (dtHasta.getDate()).getTime() ) );
    }
    
    public void CargaDiasHabiles() {//Carga días hábiles según filtro
        ExeSql sql = new ExeSql();
        String Query = "";
        ResultSet rs = null;
        Query = "select \n" +
            "	resultado.fecha, feri.descripcion,\n" +
            "	case \n" +
            "    	when to_date(to_char(resultado.fecha,'YYYY/MM/DD'),'YYYY/MM/DD') in (select fecha_feriado from feriados)\n" +
            "        then 'Feriado'\n" +
            "        else 'No feriado'\n" +
            "    end as feriado_check, \n" +
            "    resultado.dia_semana,\n" +
            " CASE	\n" +
           "when date_part('dow', resultado.fecha) = 1 then 'Lunes'\n" +
            "when date_part('dow', resultado.fecha) = 2 then 'Martes'\n" +
            "when date_part('dow', resultado.fecha) = 3 then 'Miercoles'\n" +
            "when date_part('dow', resultado.fecha) = 4 then 'Jueves'\n" +
            "when date_part('dow', resultado.fecha) = 5 then 'Viernes'\n" +
            "when date_part('dow', resultado.fecha) = 6 then 'Sábado'\n" +
            "when date_part('dow', resultado.fecha) = 0 then 'Domingo'\n" +
            "END AS dia\n"+
            "from \n" +
            "	(select	\n" +
            "    	f.fecha,\n" +
            "		case \n" +
            "          	when date_part('dow', f.fecha) = 6 OR date_part('dow', f.fecha) = 0\n" +
            "			then 'Fin de Semana'\n" +
            "            else 'Día de Semana'\n" +
            "    	END as dia_semana\n" +
            "	from \n" +
            " 		(select generate_series((date '"+getDesde()+"'),(date '"+getHasta()+"'),interval '1 day') as fecha) as f) as resultado\n"+
            "   left join feriados feri on feri.fecha_feriado = to_date(to_char(resultado.fecha,'YYYY/MM/DD'),'YYYY/MM/DD')\n"
                + "where resultado.fecha is not null\n";
            if(fdschbox.isSelected()){
                Query = Query + "and resultado.dia_semana = 'Día de Semana' \n";
            }
            if(rbSinFeriados.isSelected()){
                Query = Query + "and to_date(to_char(resultado.fecha,'YYYY/MM/DD'),'YYYY/MM/DD') not in (select fecha_feriado from feriados)\n";
            }

            if(rbSoloFeriados.isSelected()){
                Query = Query + "and to_date(to_char(resultado.fecha,'YYYY/MM/DD'),'YYYY/MM/DD') in (select fecha_feriado from feriados)\n";
            }
            if(!listdias.isSelectionEmpty()){
                Query = Query + "and date_part('dow', resultado.fecha) >= "+listdias.getSelectedIndex()+"\n";
            }
            if(!listdias.isSelectedIndex(0)){
                Query = Query + " and date_part('dow', resultado.fecha) < 6";
            }
        
        try {
            rs = sql.Select(Query);
            int cantidad = 0;
            int totales = 0;
            int feriados = 0;
            rs.beforeFirst();
            DefaultTableModel model = (DefaultTableModel) DiaGrilla.getModel();
            while(model.getRowCount()>0){
                model.removeRow(0);
            }
            rs.last();
            int posicion = rs.getRow();
            rs.beforeFirst();
            if(posicion > 0){
                System.out.println(rs.getRow());
                for(int i = 0; rs.next();i++){
                    model.addRow(new Object[]{
                        rs.getString("fecha"),
                        rs.getString("dia_semana"),
                        rs.getString("feriado_check"),
                        rs.getString("descripcion"),
                        rs.getString("dia")
                    });
                    if(rs.getString("dia_semana").equals("Día de Semana") && rs.getString("feriado_check").equals("No feriado") ){//Si es día de semana y no es feriado, se toma como día hábil
                        cantidad = cantidad + 1;
                    }   
                    if(rs.getString("feriado_check").equals("Feriado")){//Si es feriado se suma al conteo de feriados
                        feriados = feriados + 1;
                    }
                    totales = i + 1;
                }  
            }
            
            else {
                JOptionPane.showMessageDialog(rootPane,"No hay datos que mostrar.");
            }
            rs.first();
            for(int i = 0; rs.next(); i++){
                
                
            }
            //Se muestran los resultados
            diashabiles.setText(""+cantidad);
            diastotales.setText(""+totales);
            feriadostotales.setText(""+feriados);
            DiaGrilla.setDefaultRenderer(Object.class, new TableCellRendererFeriado());
            DiaGrilla.repaint();
        } catch (SQLException ex) {
            Logger.getLogger(jdFechaFeriados.class.getName()).log(Level.SEVERE, null, ex);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        dtDesde = new org.jdesktop.swingx.JXDatePicker();
        dtHasta = new org.jdesktop.swingx.JXDatePicker();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        fdschbox = new javax.swing.JCheckBox();
        rbSinFeriados = new javax.swing.JRadioButton();
        rbSoloFeriados = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listdias = new javax.swing.JList<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        diashabiles = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DiaGrilla = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        diastotales = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        feriadostotales = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "FECHA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        dtDesde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtDesdeActionPerformed(evt);
            }
        });

        dtHasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtHastaActionPerformed(evt);
            }
        });

        jLabel2.setText("Hasta");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos16/search16.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Desde");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dtDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dtDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(40, 40, 40))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "FILTROS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        fdschbox.setText("No contar Fines de Semana");

        buttonGroup1.add(rbSinFeriados);
        rbSinFeriados.setText("Sin Feriados");

        buttonGroup1.add(rbSoloFeriados);
        rbSoloFeriados.setText("Solo Feriados");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Todos");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "DÍA ORIGEN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        listdias.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Ninguno", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listdias);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fdschbox)
                    .addComponent(rbSinFeriados)
                    .addComponent(jRadioButton1)
                    .addComponent(rbSoloFeriados))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fdschbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbSinFeriados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbSoloFeriados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "DÍAS HÁBILES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Días hábiles: ");

        diashabiles.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        diashabiles.setText("0");

        DiaGrilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Día", "Día de Semana", "Feriado", "Nombre Feriado", "Día"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(DiaGrilla);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Días Total: ");

        diastotales.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        diastotales.setText("0");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Feriados: ");

        feriadostotales.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        feriadostotales.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(diashabiles)
                        .addGap(81, 81, 81)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(diastotales)
                        .addGap(52, 52, 52)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(feriadostotales)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(diashabiles)
                    .addComponent(jLabel4)
                    .addComponent(diastotales)
                    .addComponent(jLabel5)
                    .addComponent(feriadostotales))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dtDesdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtDesdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dtDesdeActionPerformed

    private void dtHastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtHastaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dtHastaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CargaDiasHabiles();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(jdFechaFeriados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdFechaFeriados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdFechaFeriados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdFechaFeriados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdFechaFeriados dialog = new jdFechaFeriados(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable DiaGrilla;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel diashabiles;
    private javax.swing.JLabel diastotales;
    private org.jdesktop.swingx.JXDatePicker dtDesde;
    private org.jdesktop.swingx.JXDatePicker dtHasta;
    private javax.swing.JCheckBox fdschbox;
    private javax.swing.JLabel feriadostotales;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listdias;
    private javax.swing.JRadioButton rbSinFeriados;
    private javax.swing.JRadioButton rbSoloFeriados;
    // End of variables declaration//GEN-END:variables
}
