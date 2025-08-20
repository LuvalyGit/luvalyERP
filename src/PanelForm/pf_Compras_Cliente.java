/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelForm;

import Conexion.ExeSql;
import Formularios.fmMain;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author luvaly
 */
public class pf_Compras_Cliente extends javax.swing.JPanel {
 
    
    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();    
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
    
    public boolean Busca_Rut =false;
    public boolean   booAno = false;
    public int intNivel =0;
    public int Carga = 0;  
    
    public int ElMes = 0;  
    public int ElAgno = 0;  
    
    public int ElMes2 = 0;  
    public int ElAgno2 = 0;  
    
    
    Calendar cal = Calendar.getInstance(); 
    
    /**
     * Creates new form Roberto López
     */
    public pf_Compras_Cliente() {
        initComponents();
        
        cboAgno.setSelectedItem(Integer.toString(cal.get(Calendar.YEAR))); 
        cboMes.setSelectedIndex((cal.get(Calendar.MONTH))); 
        
        
        cboAgno2.setSelectedItem(Integer.toString(cal.get(Calendar.YEAR))); 
        cboMes2.setSelectedIndex((cal.get(Calendar.MONTH)+1)); 
       
        
        intNivel = fmMain.trae_nivel(fmMain.GetUsuario());
         
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        
        Grilla.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        Grilla.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
        Grilla.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
        Grilla.getColumnModel().getColumn(8).setCellRenderer(rightRenderer);
        
        
        btReporte.setVisible(false);
         
    }
    
    
    
    
    private void CargaGrilla(){
        
        Carga = 0;
        
        if (!txRut.getText().toString().trim().isEmpty()){
        
            CargaCCostos(txRut.getText().toString().trim());
           
        }
        
        ExeSql Sql = new ExeSql();
        ResultSet Rs;
        DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
        
        String Query = "";
        String rut = txRut.getText().trim();
        Double Total = 0.0;
        int ContReg = 0;
        
        while(TableModel.getRowCount()>0)
              TableModel.removeRow(0);     
        
        try {
            
            
            
            
            Query = "select ctd.sku, p.nombre, ct.codigo_oc,ct.occh, ctd.tipdocto, ctd.nrodocto, ct.femision, ctd.cantidad, ctd.valorunitario from ctacteclidet ctd \n" +
                            "left join producto p on p.sku = ctd.sku \n" +
                            "left join ctactecli ct on ctd.rut = ct.rut and ctd.tipdocto = ct.tipdocto and ctd.nrodocto = ct.nrodocto \n" +
                            "where ctd.rut = "+rut.trim()+" and ctd.tipdocto IN ('BOC','FAC') \n"+
                            "and (extract(year from ct.femision) >= " + ElAgno + "and extract(month from ct.femision) >= " + ElMes + ") \n"+
                            "and (extract(year from ct.femision) <= " + ElAgno2 + "and extract(month from ct.femision) <= " + ElMes2 + ") \n"+
                            "order by ctd.nrodocto desc";
            
            
            Rs = Sql.Select(Query);
            
            
            while (Rs.next()){
                
                ContReg++;
                
                TableModel.addRow(new Object[]{Rs.getString("sku").trim(), 
                                               Rs.getString("nombre").trim(), 
                                               Rs.getString("codigo_oc").trim(), 
                                               Rs.getString("occh").trim(), 
                                               Rs.getString("tipdocto").trim(), 
                                               Rs.getInt("nrodocto"), 
                                               Rs.getDate("femision"), 
                                               Rs.getInt("cantidad"), 
                                               "$ "+fmMain.FormatoTotal(Rs.getDouble("valorunitario"))
                                                                                              
                                            });
                
                
                Total  = Total  + Math.round(Rs.getDouble("valorunitario")) ;
                
            }
            
            Carga = 1;
            
        
            lblReg.setText(fmMain.FormatoTotal(ContReg));
            lbTotal.setText(fmMain.FormatoTotal(Total));
             
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);  
             Logger.getLogger(pf_Compras_Cliente.class.getName()).log(Level.SEVERE, null, e);
        } finally{
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        cbo_ccosto = new javax.swing.JComboBox();
        bt_buscar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblReg = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Grilla = new javax.swing.JTable();
        AGNO = new javax.swing.JPanel();
        cboAgno = new javax.swing.JComboBox<String>();
        cboMes = new javax.swing.JComboBox<String>();
        lblAgno = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cboMes2 = new javax.swing.JComboBox<String>();
        cboAgno2 = new javax.swing.JComboBox<String>();
        btReporte = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txRut = new javax.swing.JTextField();
        btIr = new javax.swing.JButton();
        txCliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Centro Costo");

        cbo_ccosto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione" }));
        cbo_ccosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_ccostoActionPerformed(evt);
            }
        });

        bt_buscar.setText("Buscar");
        bt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_buscarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Registros : ");

        lblReg.setText("0");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Total");

        lbTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTotal.setText("0");

        Grilla.setAutoCreateRowSorter(true);
        Grilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sku", "Producto", "CCosto", "Orden", "Tip. Doc.", "Nro. Doc", "F. Emision", "Cant.", "Precio Vta."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Grilla.setColumnSelectionAllowed(true);
        Grilla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GrillaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Grilla);
        Grilla.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (Grilla.getColumnModel().getColumnCount() > 0) {
            Grilla.getColumnModel().getColumn(0).setMinWidth(80);
            Grilla.getColumnModel().getColumn(0).setPreferredWidth(80);
            Grilla.getColumnModel().getColumn(0).setMaxWidth(80);
            Grilla.getColumnModel().getColumn(1).setPreferredWidth(200);
            Grilla.getColumnModel().getColumn(2).setMinWidth(65);
            Grilla.getColumnModel().getColumn(2).setPreferredWidth(65);
            Grilla.getColumnModel().getColumn(2).setMaxWidth(65);
            Grilla.getColumnModel().getColumn(3).setMinWidth(100);
            Grilla.getColumnModel().getColumn(3).setPreferredWidth(100);
            Grilla.getColumnModel().getColumn(3).setMaxWidth(100);
            Grilla.getColumnModel().getColumn(4).setMinWidth(60);
            Grilla.getColumnModel().getColumn(4).setPreferredWidth(60);
            Grilla.getColumnModel().getColumn(4).setMaxWidth(60);
            Grilla.getColumnModel().getColumn(5).setMinWidth(100);
            Grilla.getColumnModel().getColumn(5).setPreferredWidth(100);
            Grilla.getColumnModel().getColumn(5).setMaxWidth(100);
            Grilla.getColumnModel().getColumn(6).setMinWidth(80);
            Grilla.getColumnModel().getColumn(6).setPreferredWidth(80);
            Grilla.getColumnModel().getColumn(6).setMaxWidth(80);
            Grilla.getColumnModel().getColumn(7).setMinWidth(60);
            Grilla.getColumnModel().getColumn(7).setPreferredWidth(60);
            Grilla.getColumnModel().getColumn(7).setMaxWidth(60);
            Grilla.getColumnModel().getColumn(8).setMinWidth(100);
            Grilla.getColumnModel().getColumn(8).setPreferredWidth(100);
            Grilla.getColumnModel().getColumn(8).setMaxWidth(100);
        }

        AGNO.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        cboAgno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", " " }));
        cboAgno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboAgnoMouseClicked(evt);
            }
        });
        cboAgno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboAgnoActionPerformed(evt);
            }
        });
        cboAgno.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cboAgnoPropertyChange(evt);
            }
        });

        cboMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MES", "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE" }));
        cboMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMesActionPerformed(evt);
            }
        });

        lblAgno.setText("DESDE");

        jLabel8.setText("HASTA");

        cboMes2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MES", "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE" }));
        cboMes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMes2ActionPerformed(evt);
            }
        });

        cboAgno2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040" }));
        cboAgno2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboAgno2MouseClicked(evt);
            }
        });
        cboAgno2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboAgno2ActionPerformed(evt);
            }
        });
        cboAgno2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cboAgno2PropertyChange(evt);
            }
        });

        javax.swing.GroupLayout AGNOLayout = new javax.swing.GroupLayout(AGNO);
        AGNO.setLayout(AGNOLayout);
        AGNOLayout.setHorizontalGroup(
            AGNOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AGNOLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AGNOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(AGNOLayout.createSequentialGroup()
                        .addComponent(lblAgno, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboMes, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AGNOLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(35, 35, 35)
                        .addComponent(cboMes2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(AGNOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboAgno, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboAgno2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        AGNOLayout.setVerticalGroup(
            AGNOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AGNOLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AGNOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAgno)
                    .addComponent(cboAgno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AGNOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboMes2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboAgno2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(16, 16, 16))
        );

        btReporte.setText("Reporte ");
        btReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReporteActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("RUT Cliente");
        jLabel4.setToolTipText("");

        txRut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txRutKeyPressed(evt);
            }
        });

        btIr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos22/Go.png"))); // NOI18N
        btIr.setBorderPainted(false);
        btIr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIrActionPerformed(evt);
            }
        });

        txCliente.setEditable(false);
        txCliente.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txCliente.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Razón Social / Nombre");
        jLabel6.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(cbo_ccosto, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txRut, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(btIr, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(AGNO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(bt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(lblReg, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(758, 758, 758)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(lbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btIr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AGNO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbo_ccosto, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(lbTotal))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(lblReg)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbo_ccostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_ccostoActionPerformed
        
        DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(TableModel); 
        
        String filtro = "";
        
        if (Carga == 1){
        
            if (cbo_ccosto.getSelectedIndex()>0){
              
                Busca_Rut=false;    
              
              
                filtro = cbo_ccosto.getSelectedItem().toString().trim();
              
                if (!filtro.trim().equals("<Todos>")){
              
                  sorter.setRowFilter(RowFilter.regexFilter(filtro,2));
              
              
                }else{
              
                  sorter.setRowFilter(null);
              
                }
              
              
                Grilla.setRowSorter(sorter);
              
                //CargaOrdenes(txRut.getText().trim());
            
            }
        
        }
    }//GEN-LAST:event_cbo_ccostoActionPerformed

    private void bt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_buscarActionPerformed
        
        if (txRut.getText().isEmpty() || txRut.getText().equals("") ){
        
        
            fmMain.Mensaje("Debe elegir un Cliente...!");
            return;
            
        }
        
        
        CargaGrilla();
        
        booAno =true;
    }//GEN-LAST:event_bt_buscarActionPerformed

    private void GrillaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrillaMouseClicked

   
            
    }//GEN-LAST:event_GrillaMouseClicked

    private void cboAgnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboAgnoActionPerformed
      
        ElAgno = Integer.parseInt(cboAgno.getSelectedItem().toString().trim());
        
    }//GEN-LAST:event_cboAgnoActionPerformed

    private void cboMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMesActionPerformed
      
        String Mes = BuscaMes(cboMes.getSelectedItem().toString().trim());
        
        ElMes = Integer.parseInt(Mes.trim());
  
    }//GEN-LAST:event_cboMesActionPerformed

    private String BuscaMes(String item){
    
        String nMes = "0";
        
        if (item.trim().equals("ENERO")){
        
            nMes = "1";
            
        
        }else if (item.trim().equals("FEBRERO")){
        
        
            nMes = "2";
            
        
        }else if (item.trim().equals("MARZO")){
        
        
            nMes = "3";
            
        
        }else if (item.trim().equals("ABRIL")){
        
        
            nMes = "4";
            
        
        }else if (item.trim().equals("MAYO")){
        
        
            nMes = "5";
            
        
        }else if (item.trim().equals("JUNIO")){
        
        
            nMes = "6";
            
        
        }else if (item.trim().equals("JULIO")){
        
        
            nMes = "7";
            
        
        }else if (item.trim().equals("AGOSTO")){
        
        
            nMes = "8";
            
        
        }else if (item.trim().equals("SEPTIEMBRE")){
        
        
            nMes = "9";
            
        
        }else if (item.trim().equals("OCTUBRE")){
        
        
            nMes = "10";
            
        
        }else if (item.trim().equals("NOVIEMBRE")){
        
        
            nMes = "11";
            
        
        }else if (item.trim().equals("DICIEMBRE")){
        
        
            nMes = "12";
            
        
        }else{
                
              nMes = "0";      
                
        }
        
        
        
        return nMes;
    
    }
    
    
    private void cboAgnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboAgnoMouseClicked
        // TODO add your handling code here:
  
    }//GEN-LAST:event_cboAgnoMouseClicked

    private void cboAgnoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cboAgnoPropertyChange
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cboAgnoPropertyChange

    private void btReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReporteActionPerformed
     
    }//GEN-LAST:event_btReporteActionPerformed

    private void txRutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRutKeyPressed
       
          if(evt.getKeyCode() == KeyEvent.VK_ENTER){
          
              btIr.doClick();
          
          }
        
    }//GEN-LAST:event_txRutKeyPressed

    private void btIrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIrActionPerformed
        
         DefaultTableModel TableModel = (DefaultTableModel) Grilla.getModel();
        
        
        if (!txRut.getText().isEmpty()) {
        
            
            CargaCliente(txRut.getText());
            
            while(TableModel.getRowCount()>0)
                  TableModel.removeRow(0);     
         
        
        }else {
            
            Dialogos.jdBuscarCliPrv BPC = new Dialogos.jdBuscarCliPrv(null, true);
            BPC.setLocationRelativeTo(null);
            BPC.setTitle("Buscar Cliente");
            BPC.SetTipo(1);
            BPC.setVisible(true);
            CargaCliente(BPC.GetRut());
        
            while(TableModel.getRowCount()>0)
                  TableModel.removeRow(0);     
        
            
        }       
    }//GEN-LAST:event_btIrActionPerformed

    private void cboMes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMes2ActionPerformed
        
        String Mes2 = BuscaMes(cboMes2.getSelectedItem().toString().trim());
        
        ElMes2 = Integer.parseInt(Mes2.trim());
        
        
    }//GEN-LAST:event_cboMes2ActionPerformed

    private void cboAgno2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboAgno2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cboAgno2MouseClicked

    private void cboAgno2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboAgno2ActionPerformed
        
        ElAgno2 = Integer.parseInt(cboAgno2.getSelectedItem().toString().trim());
        
    }//GEN-LAST:event_cboAgno2ActionPerformed

    private void cboAgno2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cboAgno2PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_cboAgno2PropertyChange

    
    public void CargaCliente(String Rut){
    ExeSql  Sql = new ExeSql();
    ResultSet Rs;
    String Query = "";
    
    try{
        Rs = Sql.Select("select rut,dv,nombre\n" +
                        "from cliente\n" +
                        "where rut=" + Rut);
    
        if(Sql.GetRowCount()==0){
            fmMain.Mensaje("Rut no encontrado");
            return;
        }
        Rs.next();
        txRut.setText(Rs.getString("Rut"));
        txCliente.setText(Rs.getString("nombre").trim());
        Carga = 0;



    } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally{
        Sql.Close();
    }
    }
    
    
    public void CargaCCostos(String Rut){
    
        ExeSql  Sql = new ExeSql();
        ResultSet Rs;
        String Query = "";
    
        
         System.out.println("LA Carga ES : "+Carga);
       
            try{
        
                cbo_ccosto.removeAllItems();
        
                Query = "select DISTINCT cli.codigo_oc from clicontacto cli\n" +
                        "left join ctactecli ct on cli.rut = ct.rut and cli.codigo_oc = ct.codigo_oc\n" +
                        "where cli.rut="+Rut+" and ct.tipdocto IN ('BOC','FAC') \n" +
                        "and (extract(year from ct.femision) >= "+ElAgno+" and extract(month from ct.femision) >= "+ElMes+")\n" +
                        "and (extract(year from ct.femision) <= "+ElAgno2+" and extract(month from ct.femision) <= "+ElMes2+") ";
                    
            
                Rs = Sql.Select(Query);
        
                cbo_ccosto.addItem("Seleccione");
                cbo_ccosto.addItem("<Todos>");
                
                while(Rs.next()){
                
                    cbo_ccosto.addItem(Rs.getString("codigo_oc").trim());
                }
        

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                Logger.getLogger(pf_Compras_Cliente.class.getName()).log(Level.SEVERE, null, e);
            } finally{
                Sql.Close();
            }
    
    }
    

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AGNO;
    private javax.swing.JTable Grilla;
    private javax.swing.JButton btIr;
    private javax.swing.JButton btReporte;
    private javax.swing.JButton bt_buscar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboAgno;
    private javax.swing.JComboBox<String> cboAgno2;
    private javax.swing.JComboBox<String> cboMes;
    private javax.swing.JComboBox<String> cboMes2;
    private javax.swing.JComboBox cbo_ccosto;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JLabel lblAgno;
    private javax.swing.JLabel lblReg;
    private javax.swing.JTextField txCliente;
    private javax.swing.JTextField txRut;
    // End of variables declaration//GEN-END:variables
}
