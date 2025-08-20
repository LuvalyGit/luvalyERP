
package Conexion.Econa;

import Formularios.fmMain;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author CHRv12ISTIAN DIAZ 2017
 * cambio1
 * cambio 2
 */
public class Conector_Econa {
    private final boolean Internet =fmMain.GetInternet();
    private static String SistemaActual;    
    
    

   //PRODUCCION//
    private final String dbPath = "jdbc:postgresql://192.168.0.150:5432/econa_final"; 
    private final String dbPathInternet = "jdbc:postgresql://179.57.172.101:10001/econa_final"; 
    private final String user   = fmMain.GetUsuario().toLowerCase();
    private final String pass   = fmMain.GetPass();
    
    
 //   ECONA PRUEBAS//
//    private final String dbPath = "jdbc:postgresql://192.168.0.150:5432/econa_pruebas"; 
//    private final String dbPathInternet = "jdbc:postgresql://179.57.172.101:10001/econa_pruebas"; 
//    private final String user   = fmMain.GetUsuario().toLowerCase();
//    private final String pass   = fmMain.GetPass();
    
    


    //asigna Sistemna utilizado desde la cadena de coneccion
    

    
    //PRUEBA Androide
//    private final String dbPath = "jdbc:postgresql://192.168.0.150:5432/android"; 
//    private final String dbPathInternet = "jdbc:postgresql://186.67.157.227:5432/android"; 
//    private final String user   = fmMain.GetUsuario().toLowerCase();
//    private final String pass   = fmMain.GetPass();

//    //PRUEBA Test
//    private final String dbPath = "jdbc:postgresql://192.168.0.150:5432/test"; 
//    private final String dbPathInternet = "jdbc:postgresql://186.67.157.227:5432/test"; 
//    private final String user   = fmMain.GetUsuario().toLowerCase();
//    private final String pass   = fmMain.GetPass();


    
    
    Connection conn = null;
    String Error;
    
    
    /* Constructor */
    public Conector_Econa(){
        String Cadena ="";
        try{
//            JOptionPane.showMessageDialog(null, "Conectando");
            // Drivers para Postgres
            Class.forName("org.postgresql.Driver");
            
            // Conectamos
            if(!Internet){
                conn = DriverManager.getConnection(dbPath,user,pass);
                Cadena = dbPath;
            }
            else
            {
                conn = DriverManager.getConnection(dbPathInternet,user,pass);
                conn.setTransactionIsolation(conn.TRANSACTION_SERIALIZABLE);
                conn.setAutoCommit(false);
                Cadena = dbPathInternet;
            }
            if(conn!=null){
//                JOptionPane.showMessageDialog(null, "Conectado a la Base de Datos");
//                System.out.println("conectado a Base de Datos");
                SetSistema(fmMain.GetStringDeFinal('/', Cadena));
            }
            else
                JOptionPane.showMessageDialog(null, "No Se pudo conectar");
            }catch(SQLException | ClassNotFoundException e){
//         JOptionPane.showMessageDialog(null, e);
                fmMain.Mensaje(e.getMessage());
                Error=e.getMessage();
                conn = null;
    }
 }

public static void SetSistema(String sis){
    SistemaActual = sis;
}    

public static String  GetSistema(){
    return SistemaActual;
}    

//Retorno la conexion
   public Connection getConnection(){
       return conn;
   }
   public String GetError(){
       return Error;
   }
    public boolean Commit(){
        try {
            conn.commit();
//            Desconectar();
            return true;
        } catch (Exception e) {
            //fmMain.Mensaje(e.getMessage());
            return false;
        }
 
   }
    public boolean RollBack(){
        try {
            conn.rollback();
            return true;
        } catch (Exception e) {
            //fmMain.Mensaje(e.getMessage());
               return false;
        }
 
   }
    public Statement createStatement(int Tipo, int Concurrencia)throws SQLException{
       return conn.createStatement(Tipo, Concurrencia);
   }
   public void Desconectar() throws SQLException{
       conn.close();
       conn = null;
//       System.out.println("Conexion Cerrada");
   }
}   
