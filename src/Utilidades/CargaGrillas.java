
package Utilidades;
import javax.swing.table.DefaultTableModel;
import Conexion.ExeSql;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


public class CargaGrillas {
    private ExeSql  Sql = new ExeSql();
    
    public DefaultTableModel returndata(String query){
    DefaultTableModel model = new MiTableModel(){
            public boolean isCellEditable(int row, int column) {
            return false; //Esto hace que las celdas de la tabla no sean editables
    };

};
                  
        try {
            ResultSet Rs;
            ResultSetMetaData RsMd;
            Rs = Sql.Select(query);
            RsMd = Rs.getMetaData();
            int ContCol = RsMd.getColumnCount();
            Object[] objeto = new Object[ContCol];
            for (int i = 0; i < ContCol; i++) {
                objeto[i] = RsMd.getColumnLabel(i + 1).toUpperCase().trim();
            }
            model.setColumnIdentifiers(objeto);
            while (Rs.next()) {
                Object[] datosFila = new Object[model.getColumnCount()];
                for (int i = 0; i < model.getColumnCount(); i++) {
                    datosFila[i] = Rs.getObject(i + 1);
                }
                model.addRow(datosFila);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            Sql.Close();
        }
    return model;
    }
}

