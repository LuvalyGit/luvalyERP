/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import Conexion.ExeSql;
import Formularios.fmMain;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import org.apache.commons.net.ftp.FTP;  
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 *
 * @author Cdiaz
 */
public class SubeFTP {
  
    public static void SubeArch (String ruta, String rutafinal) throws SocketException, UnknownHostException, IOException
    {
        ResultSet Rs;
        ExeSql Sql = new ExeSql();
        String server,user,pass,ruta_local="";
        int puerto =21;
        String rutaimage="";
        try {

//            server= "192.168.0.130";
//            user="voucher";
//            pass="V2369";
            
            
           //trae datos ftp
            server="";
            puerto=0;
            user=""; 
            pass="";
            	Rs = Sql.Select("SELECT * from conexiones where usu='fotoproducto'");
                if (Rs.next())
                {
                    if(!fmMain.GetInternet()){
                        server = Rs.getString("serv");
                        user  = Rs.getString("usu");
                        puerto  = Rs.getInt("port");
                        pass = Rs.getString("pass");
                    }
                    else {
                        server = "186.67.157.227";
                        user  = Rs.getString("usu");
                        puerto  = 21;
                        pass = Rs.getString("pass");
                    }
                }
           //trae datos ftp
            
            
            
            FTPClient ftpClient = new FTPClient();
            ftpClient.connect(InetAddress.getByName(server));
            ftpClient.login(user,pass);
            
            //Verificar conexión con el servidor.
            
            int reply = ftpClient.getReplyCode();
            
            System.out.println("Respuesta recibida de conexión FTP:" + reply);
            
            if(FTPReply.isPositiveCompletion(reply))
            {
                System.out.println("Conectado Satisfactoriamente");    
            }
            else
                {
                    System.out.println("Imposible conectarse al servidor");
                }
           
           
            //Activar que se envie cualquier tipo de archivo
            
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            
            BufferedInputStream buffIn = null;
            buffIn = new BufferedInputStream(new FileInputStream(ruta));//Ruta del archivo para enviar
            ftpClient.enterLocalPassiveMode();
            ftpClient.storeFile(rutafinal, buffIn);//Ruta completa de alojamiento en el FTP
            
           
            
            buffIn.close(); //Cerrar envio de arcivos al FTP
            ftpClient.logout(); //Cerrar sesión
            ftpClient.disconnect();//Desconectarse del servidor
        }
        catch(Exception e)
                {
                    System.out.println(e.getMessage());
                    System.out.println("Algo malo sucedió");
                }
    }
    
    public static void SubeArch_ticket (String ruta, String rutafinal,String nombre, String nombre_nuevo) throws SocketException, UnknownHostException, IOException
    {
        ResultSet Rs;
        ExeSql Sql = new ExeSql();
        String server,user,pass,ruta_local="";
        int puerto =21;
        String rutaimage="";
        try {

//            server= "192.168.0.130";
//            user="voucher";
//            pass="V2369";
            
            
           //trae datos ftp
            server="";
            puerto=0;
            user=""; 
            pass="";
            	Rs = Sql.Select("SELECT * from conexiones where tipo='tickets'");
                if (Rs.next())
                {
                    if(!fmMain.GetInternet()){
                        server = Rs.getString("serv");
                        user  = Rs.getString("usu");
                        puerto  = Rs.getInt("port");
                        pass = Rs.getString("pass");
                    }
                    else {
                        server = "186.67.157.227";
                        user  = Rs.getString("usu");
                        puerto  = 21;
                        pass = Rs.getString("pass");
                    }
                }
           //trae datos ftp
            
            
            
            FTPClient ftpClient = new FTPClient();
            ftpClient.connect(InetAddress.getByName(server));
            ftpClient.login(user,pass);
            
            //Verificar conexión con el servidor.
            
            int reply = ftpClient.getReplyCode();
            
            System.out.println("Respuesta recibida de conexión FTP:" + reply);
            
            if(FTPReply.isPositiveCompletion(reply))
            {
                System.out.println("Conectado Satisfactoriamente");    
            }
            else
                {
                    System.out.println("Imposible conectarse al servidor");
                }
           
           
            //Activar que se envie cualquier tipo de archivo
            
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            
            BufferedInputStream buffIn = null;
            buffIn = new BufferedInputStream(new FileInputStream(ruta));//Ruta del archivo para enviar
            ftpClient.enterLocalPassiveMode();
            ftpClient.storeFile(rutafinal, buffIn);//Ruta completa de alojamiento en el FTP
            ftpClient.rename(nombre,nombre_nuevo);
           
            
            buffIn.close(); //Cerrar envio de arcivos al FTP
            ftpClient.logout(); //Cerrar sesión
            ftpClient.disconnect();//Desconectarse del servidor
        }
        catch(Exception e)
                {
                    System.out.println(e.getMessage());
                    System.out.println("Algo malo sucedió");
                }
    }
    
    public static void SubeArch_imagen_producto (String ruta, String rutafinal,String nombre, String nombre_nuevo) throws SocketException, UnknownHostException, IOException
    {
        ResultSet Rs;
        ExeSql Sql = new ExeSql();
        String server,user,pass,ruta_local="";
        int puerto =21;
        String rutaimage="";
        try {

//            server= "192.168.0.130";
//            user="voucher";
//            pass="V2369";
            
            
           //trae datos ftp
            server="";
            puerto=0;
            user=""; 
            pass="";
            	Rs = Sql.Select("SELECT * from conexiones where tipo='producto'");
                if (Rs.next())
                {
                    if(!fmMain.GetInternet()){
                        server = Rs.getString("serv");
                        user  = Rs.getString("usu");
                        puerto  = Rs.getInt("port");
                        pass = Rs.getString("pass");
                    }
                    else {
                        server = "186.67.157.227";
                        user  = Rs.getString("usu");
                        puerto  = 21;
                        pass = Rs.getString("pass");
                    }
                }
           //trae datos ftp
            
            
            
            FTPClient ftpClient = new FTPClient();
            ftpClient.connect(InetAddress.getByName(server));
            ftpClient.login(user,pass);
            
            //Verificar conexión con el servidor.
            
            int reply = ftpClient.getReplyCode();
            
            System.out.println("Respuesta recibida de conexión FTP:" + reply);
            
            if(FTPReply.isPositiveCompletion(reply))
            {
                System.out.println("Conectado Satisfactoriamente");    
            }
            else
                {
                    System.out.println("Imposible conectarse al servidor");
                }
           
           
            //Activar que se envie cualquier tipo de archivo
            
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            
            BufferedInputStream buffIn = null;
            buffIn = new BufferedInputStream(new FileInputStream(ruta));//Ruta del archivo para enviar
            ftpClient.enterLocalPassiveMode();
            ftpClient.storeFile(rutafinal, buffIn);//Ruta completa de alojamiento en el FTP
            ftpClient.rename(nombre,nombre_nuevo);
           
            
            buffIn.close(); //Cerrar envio de arcivos al FTP
            ftpClient.logout(); //Cerrar sesión
            ftpClient.disconnect();//Desconectarse del servidor
        }
        catch(Exception e)
                {
                    System.out.println(e.getMessage());
                    System.out.println("Algo malo sucedió");
                }
    }
    
    public static void SubeArch_imagen_multa (String ruta, String rutafinal,String nombre) throws SocketException, UnknownHostException, IOException
    {
        ResultSet Rs;
        ExeSql Sql = new ExeSql();
        String server,user,pass,ruta_local="";
        int puerto =21;
        String rutaimage="";
        try {

//            server= "192.168.0.130";
//            user="voucher";
//            pass="V2369";
            
            
           //trae datos ftp
            server="";
            puerto=0;
            user=""; 
            pass="";
            	Rs = Sql.Select("SELECT * from conexiones where tipo='multa'");
                if (Rs.next())
                {
                    if(!fmMain.GetInternet()){
                        server = Rs.getString("serv");
                        user  = Rs.getString("usu");
                        puerto  = Rs.getInt("port");
                        pass = Rs.getString("pass");
                    }
                    else {
                        server = "186.67.157.227";
                        user  = Rs.getString("usu");
                        puerto  = 21;
                        pass = Rs.getString("pass");
                    }
                }
           //trae datos ftp
            
            
            
            FTPClient ftpClient = new FTPClient();
            ftpClient.connect(InetAddress.getByName(server));
            ftpClient.login(user,pass);
            
            //Verificar conexión con el servidor.
            
            int reply = ftpClient.getReplyCode();
            
            System.out.println("Respuesta recibida de conexión FTP:" + reply);
            
            if(FTPReply.isPositiveCompletion(reply))
            {
                System.out.println("Conectado Satisfactoriamente");    
            }
            else
                {
                    System.out.println("Imposible conectarse al servidor");
                }
           
           
            //Activar que se envie cualquier tipo de archivo
            
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            
            BufferedInputStream buffIn = null;
            buffIn = new BufferedInputStream(new FileInputStream(ruta));//Ruta del archivo para enviar
            ftpClient.enterLocalPassiveMode();
            ftpClient.storeFile(rutafinal, buffIn);//Ruta completa de alojamiento en el FTP
           
            
            buffIn.close(); //Cerrar envio de arcivos al FTP
            ftpClient.logout(); //Cerrar sesión
            ftpClient.disconnect();//Desconectarse del servidor
        }
        catch(Exception e)
                {
                    System.out.println(e.getMessage());
                    System.out.println("Algo malo sucedió");
                }
    }
    public static void SubeArch_imagen_multa_transferencia (String ruta, String rutafinal,String nombre) throws SocketException, UnknownHostException, IOException
    {
        ResultSet Rs;
        ExeSql Sql = new ExeSql();
        String server,user,pass,ruta_local="";
        int puerto =21;
        String rutaimage="";
        try {

//            server= "192.168.0.130";
//            user="voucher";
//            pass="V2369";
            
            
           //trae datos ftp
            server="";
            puerto=0;
            user=""; 
            pass="";
            	Rs = Sql.Select("SELECT * from conexiones where tipo='multa_tran'");
                if (Rs.next())
                {
                    if(!fmMain.GetInternet()){
                        server = Rs.getString("serv");
                        user  = Rs.getString("usu");
                        puerto  = Rs.getInt("port");
                        pass = Rs.getString("pass");
                    }
                    else {
                        server = "186.67.157.227";
                        user  = Rs.getString("usu");
                        puerto  = 21;
                        pass = Rs.getString("pass");
                    }
                }
           //trae datos ftp
            
            
            
            FTPClient ftpClient = new FTPClient();
            ftpClient.connect(InetAddress.getByName(server));
            ftpClient.login(user,pass);
            
            //Verificar conexión con el servidor.
            
            int reply = ftpClient.getReplyCode();
            
            System.out.println("Respuesta recibida de conexión FTP:" + reply);
            
            if(FTPReply.isPositiveCompletion(reply))
            {
                System.out.println("Conectado Satisfactoriamente");    
            }
            else
                {
                    System.out.println("Imposible conectarse al servidor");
                }
           
           
            //Activar que se envie cualquier tipo de archivo
            
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            
            BufferedInputStream buffIn = null;
            buffIn = new BufferedInputStream(new FileInputStream(ruta));//Ruta del archivo para enviar
            ftpClient.enterLocalPassiveMode();
            ftpClient.storeFile(rutafinal, buffIn);//Ruta completa de alojamiento en el FTP
           
            
            buffIn.close(); //Cerrar envio de arcivos al FTP
            ftpClient.logout(); //Cerrar sesión
            ftpClient.disconnect();//Desconectarse del servidor
        }
        catch(Exception e)
                {
                    System.out.println(e.getMessage());
                    System.out.println("Algo malo sucedió");
                }
    }
    public static void SubeArch_con (String ruta, String rutafinal, int conection) throws SocketException, UnknownHostException, IOException
    {
        ResultSet Rs;
        ExeSql Sql = new ExeSql();
        String server,user,pass,ruta_local="";
        int puerto =21;
        String rutaimage="";
        try {

            
//            server= "192.168.0.130";
//            user="voucher";
//            pass="V2369";
           //trae datos ftp
            server="";
            puerto=0;
            user=""; 
            pass="";
            switch (conection) {//Filtro según tipo transporte.
                case 7:
                    Rs = Sql.Select("SELECT * from conexiones where tipo='blue'");//Blue
                    if (Rs.next())
                    {
                        if(!fmMain.GetInternet()){
                        server = Rs.getString("serv");
                        user  = Rs.getString("usu");
                        puerto  = Rs.getInt("port");
                        pass = Rs.getString("pass");
                    }
                    else {
                        server = "186.67.157.227";
                        user  = Rs.getString("usu");
                        puerto  = 21;
                        pass = Rs.getString("pass");
                    }
                    }   break;
            //trae datos ftp
                case 1:
                    Rs = Sql.Select("SELECT * from conexiones where tipo='vou_tnt'");//TNT
                    if (Rs.next())
                    {
                        if(!fmMain.GetInternet()){
                        server = Rs.getString("serv");
                        user  = Rs.getString("usu");
                        puerto  = Rs.getInt("port");
                        pass = Rs.getString("pass");
                    }
                    else {
                        server = "186.67.157.227";
                        user  = Rs.getString("usu");
                        puerto  = 21;
                        pass = Rs.getString("pass");
                    }
                    }   break;
                default:
                    Rs = Sql.Select("SELECT * from conexiones where tipo='ftp'");//El resto
                    if (Rs.next())
                    {
                        if(!fmMain.GetInternet()){
                        server = Rs.getString("serv");
                        user  = Rs.getString("usu");
                        puerto  = Rs.getInt("port");
                        pass = Rs.getString("pass");
                    }
                    else {
                        server = "186.67.157.227";
                        user  = Rs.getString("usu");
                        puerto  = 21;
                        pass = Rs.getString("pass");
                    }
                    }   break;
            }
            
            
            
            FTPClient ftpClient = new FTPClient();
            ftpClient.connect(InetAddress.getByName(server));
            ftpClient.login(user,pass);
            
            //Verificar conexión con el servidor.
            
            int reply = ftpClient.getReplyCode();
            
            System.out.println("Respuesta recibida de conexión FTP:" + reply);
            
            if(FTPReply.isPositiveCompletion(reply))
            {
                System.out.println("Conectado Satisfactoriamente");    
            }
            else
                {
                    System.out.println("Imposible conectarse al servidor");
                }
           
           
            //Activar que se envie cualquier tipo de archivo
            
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            
            BufferedInputStream buffIn = null;
            buffIn = new BufferedInputStream(new FileInputStream(ruta));//Ruta del archivo para enviar
            ftpClient.enterLocalPassiveMode();
            ftpClient.storeFile(rutafinal, buffIn);//Ruta completa de alojamiento en el FTP
            
            System.out.println(ruta);
            System.out.println(rutafinal);
            
            buffIn.close(); //Cerrar envio de arcivos al FTP
            ftpClient.logout(); //Cerrar sesión
            ftpClient.disconnect();//Desconectarse del servidor
        }
        catch(Exception e)
                {
                    System.out.println(e.getMessage());
                    System.out.println("Algo malo sucedió");
                }
    }
    
    
    
    
}

