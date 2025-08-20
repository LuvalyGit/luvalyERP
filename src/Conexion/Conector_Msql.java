    package Conexion;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author DAL
 */
public class Conector_Msql {
    
    private final int Internet = 0;
    
   //conector Produccion
     //private final String dbPathInternet = "jdbc:mysql://51.38.21.102:3306/luvaly_wp53186"; 
     private final String dbPathInternet = "jdbc:mariadb://213.158.86.23:3306/luvaly_wp53186"; 
     private final String user   = "luvaly_wp53186"; 
     private final String pass   = "C2Y[p2.SG0";


    Connection conn = null;
    
    
    /* Constructor */
    public Conector_Msql(){ 
        try{
//            JOptionPane.showMessageDialog(null, "Conectando");
            // Drivers para Postgres
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Conectamos

            conn = DriverManager.getConnection(dbPathInternet,user,pass);
            conn.setAutoCommit(false);
            if(conn!=null){
//                JOptionPane.showMessageDialog(null, "Conectado a la Base de Datos");
//                System.out.println("conectado a Base de Datos");
            }
            else
                JOptionPane.showMessageDialog(null, "No Se pudo conectar");
        }catch(SQLException | ClassNotFoundException e){
//         JOptionPane.showMessageDialog(null, e);
                System.out.println(e);
                conn = null;
        }
    }
   
//Retorno la conexion
   public Connection getConnection(){
       return conn;
   }

    public boolean Commit(){
        try {
            conn.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
 
   }
    public boolean RollBack(){
        try {
            conn.rollback();
            return true;
        } catch (Exception e) {
            return false;
        }
 
    }
    
    public Statement createStatement(int Tipo, int Concurrencia)throws SQLException{
       return conn.createStatement(Tipo, Concurrencia);
    }
   
    public void Desconectar(){
       conn = null;

    }
}   