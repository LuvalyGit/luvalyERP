/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package PanelForm;

import Conexion.ExeSql;
import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 *
 * @author Marcelo Leiva
 */
public class pfReporteBitacora extends javax.swing.JPanel {
// Modelo de datos

    private DefaultTableModel modelo;

    /**
     * Creates new form pfReporteBitacora
     */
    public pfReporteBitacora() {
        initComponents();
        iniciarConfiguracion();
    }

    private void iniciarConfiguracion() {
        // 1. Configurar Fechas por defecto (Hoy)
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String hoy = sdf.format(new Date());
        txtFechaDesde.setText(hoy); // O el primer día del mes si prefieres
        txtFechaHasta.setText(hoy);

        // 2. Configurar la Tabla (Modelo NO editable)
        modelo = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "ID", "Fecha", "Módulo", "Acción", "Operador", "Autorizó", "Ref. (SKU/ID)", "Detalle"
                }
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Nadie edita el reporte
            }
        };
        grilla.setModel(modelo);

        // 3. ESTÉTICA: Anchos de columna
        grilla.getColumnModel().getColumn(0).setPreferredWidth(50);  // ID
        grilla.getColumnModel().getColumn(1).setPreferredWidth(130); // Fecha
        grilla.getColumnModel().getColumn(2).setPreferredWidth(90);  // Módulo
        grilla.getColumnModel().getColumn(7).setPreferredWidth(300); // Detalle (Ancho)

        // 4. ESTÉTICA PRO: Filas cebradas (Zebra Striping)
        // Esto hace que la tabla se vea muy moderna
        grilla.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    // Filas pares blancas, impares gris muy claro
                    c.setBackground(row % 2 == 0 ? Color.WHITE : new Color(245, 245, 245));
                }
                return c;
            }
        });
        grilla.setRowHeight(25); // Un poco más alto para que respire el texto

        // 5. Acción del Botón
        btnBuscar.addActionListener(evt -> buscarReporte());

        // Cargar datos iniciales (opcional)
        // buscarReporte(); 
    }

    private void buscarReporte() {
        ExeSql sql = new ExeSql();
        modelo.setRowCount(0);

        try {
            // 1. Lista de condiciones
            ArrayList<String> condiciones = new ArrayList<>();

            // 2. AGREGAMOS FILTROS (Una línea por cada uno, ¡sin ifs visibles!)
            // Filtro Usuario: Buscamos parcial con LIKE
            agregarFiltro(condiciones, txtUsuario.getText(), "UPPER(usuario_operador) LIKE '%%%s%%'");

            // Filtro Módulo: Búsqueda exacta
            agregarFiltro(condiciones, cmbModulo.getSelectedItem().toString(), "modulo = '%s'");

            // Filtro Referencia: Búsqueda parcial
            agregarFiltro(condiciones, txtReferencia.getText(), "UPPER(referencia_id) LIKE '%%%s%%'");

            // Filtro Fechas (Este es especial por ser rango, lo dejamos manual o hacemos otro helper)
            String f1 = txtFechaDesde.getText().trim();
            String f2 = txtFechaHasta.getText().trim();
            if (!f1.isEmpty() && !f2.isEmpty()) {
                condiciones.add("fecha::date BETWEEN '" + f1 + "' AND '" + f2 + "'");
            }

            // 3. Construcción del SQL
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM sistema_bitacora");

            if (!condiciones.isEmpty()) {
                query.append(" WHERE ");
                query.append(String.join(" AND ", condiciones)); // Magia: Une todo con AND
            }

            query.append(" ORDER BY id DESC");

            // 4. Ejecución (Esto sigue igual)
            ResultSet rs = sql.Select(query.toString());
            int contador = 0;

            while (rs.next()) {
                String autoriza = rs.getString("usuario_autoriza");
                modelo.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("fecha").substring(0, 19),
                    rs.getString("modulo"),
                    rs.getString("accion"),
                    rs.getString("usuario_operador"),
                    (autoriza == null) ? "-" : autoriza,
                    rs.getString("referencia_id"),
                    rs.getString("detalle")
                });
                contador++;
            }
            lblTotal.setText("Registros: " + contador);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sql.Close();
        }
    }

    /**
     * Método mágico para limpiar el código. Solo agrega la condición si el
     * valor no está vacío y no es "TODOS".
     */
    private void agregarFiltro(ArrayList<String> lista, String valorRaw, String plantillaSql) {
        if (valorRaw == null) {
            return;
        }
        String valor = valorRaw.trim().toUpperCase(); // Limpiamos espacios y mayúsculas aquí mismo

        // Validamos que sirva (Que no esté vacío y no sea el default de los combos)
        if (!valor.isEmpty() && !valor.equals("TODOS")) {
            // Reemplazamos el marcador "%s" por el valor real
            // Ejemplo: "modulo = '%s'"  -->  "modulo = 'INVENTARIO'"
            lista.add(String.format(plantillaSql, valor));
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFechaDesde = new javax.swing.JTextField();
        txtFechaHasta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbModulo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtReferencia = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        grilla = new javax.swing.JTable();
        lblTotal = new javax.swing.JLabel();
        btnExportar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("REPORTE BITÁCORA LUVALY");

        jLabel2.setText("Desde");

        jLabel3.setText("Hasta");

        jLabel4.setText("Módulo");

        cmbModulo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE", "UBICACIÓN DE PRODUCTOS" }));
        cmbModulo.setToolTipText("");

        jLabel5.setText("Usuario");

        jLabel6.setText("Referencia");

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.setToolTipText("");

        grilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(grilla);

        lblTotal.setText("Registros encontrados: 0");

        btnExportar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnExportar.setText("Exportar a EXCEL");
        btnExportar.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbModulo, 0, 1, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(366, 366, 366)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1041, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblTotal)
                .addGap(18, 18, 18)
                .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(cmbModulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal)
                    .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(174, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.NORTH);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1053, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        add(jPanel2, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnExportar;
    private javax.swing.JComboBox<String> cmbModulo;
    private javax.swing.JTable grilla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTextField txtFechaDesde;
    private javax.swing.JTextField txtFechaHasta;
    private javax.swing.JTextField txtReferencia;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
