/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author David Alcaman
 */
public class LogError {
    public static void Guardar(String Origen,String Mensaje)
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        Date fecha1 = new Date ();
        SimpleDateFormat sdf = new SimpleDateFormat("[yyyy-MM-dd][HH:mm:ss]");
        try
        {
            fichero = new FileWriter("LogLuvalyERP.txt",true);
            pw = new PrintWriter(fichero);
 
            
                pw.println(sdf.format(fecha1) + "[" + Origen + "] " + Mensaje);
                System.out.println(sdf.format(fecha1) + "[" + Origen + "] " + Mensaje);
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
}
