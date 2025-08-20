//
package Conexion;

import Formularios.fmMain;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author CHRv12ISTIAN DIAZ 2017  //186.67.157.227   
 * cambio1
 * cambio 2
 */
public class Conector {
    
    private final boolean Internet =fmMain.GetInternet();  
    private static String SistemaActual;    
    
////PRODUCCION//
    private final String dbPath = "jdbc:postgresql://localhost:5432/luvaly_local"; 
    private final String dbPathInternet = "jdbc:postgresql://179.57.172.101:10001/luvaly_final";  
    private final String user   = fmMain.GetUsuario().toLowerCase();
    private final String pass   = fmMain.GetPass();    

    //asigna Sistemna utilizado desde la cadena de coneccion  //3940 y 3941   
    


////ANDROID DONJACK//  
//    private final String dbPath = "jdbc:postgresql://192.168.0.150:5432/android_donjack"; 
//    private final String dbPathInternet = "jdbc:postgresql://179.57.172.101:10001/android_donjack";
//    private final String user   = fmMain.GetUsuario().toLowerCase();
//    private final String pass   = fmMain.GetPass();
//  

////  LUVALY RESPALDO//

//    private final String dbPath = "jdbc:postgresql://192.168.0.150:5432/lvl_respaldo"; 
//    private final String dbPathInternet = "jdbc:postgresql://179.57.172.101:10001/lvl_respaldo";
//    private final String user   = fmMain.GetUsuario().toLowerCase();
//    private final String pass   = fmMain.GetPass();

    
    
////  LUVALY BUSQUEDA//

//    private final String dbPath = "jdbc:postgresql://192.168.0.150:5432/lvl_busqueda"; 
//    private final String dbPathInternet = "jdbc:postgresql://179.57.172.101:10001/lvl_busqueda";
//    private final String user   = fmMain.GetUsuario().toLowerCase();
//    private final String pass   = fmMain.GetPass();    
    


    Connection conn = null;
    String Error;
    
    
    /* Constructor */
    public Conector(){
        
        String Cadena ="";
        try{
//            JOptionPane.showMessageDialog(null, "Conectando");
            // Drivers para Postgres
            Class.forName("org.postgresql.Driver");   
            
            // Conectamos
            if(!Internet){   
            
                conn = DriverManager.getConnection(dbPath,user,pass);
                Cadena = dbPath;
            
            }else{
                
                conn = DriverManager.getConnection(dbPathInternet,user,pass);
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
            return true;
        
        } catch (Exception e) {

            return false;
        }
 
    }
    
    public boolean RollBack(){
        try {
        
            conn.rollback();
            return true;
        
        }catch (Exception e) {
            
            return false;   
        }
 
    }
    
    public Statement createStatement(int Tipo, int Concurrencia)throws SQLException{
       return conn.createStatement(Tipo, Concurrencia);
    }
    
    public void Desconectar() throws SQLException{
       conn.close();
       conn = null;
    }

    public Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}   
