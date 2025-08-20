/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author luvaly
 */
public class DocElect {
    
public static String carpeta  = "facturas";    

public static String    BuscaArchivos(File ruta, String docElec){
        String nombre="";
        ArrayList <String> Lista  = new ArrayList();
          File archivos[]= ruta.listFiles();
          if (archivos != null){
            for(int i =0; i<archivos.length; i++){
              if (archivos[i].isDirectory()){
                  BuscaArchivos(archivos[i], docElec);
              }
              else
              {
                  Lista.add(archivos[i].getName());
                  if(archivos[i].getName().contains(docElec)){
                      nombre = archivos[i].getName();
                      System.out.println("Archivo Encontrado " + nombre );
                      break;
                  }
              }    
          } //end for
      } // end if
       return nombre;
        
    }// Fin Busca Archivos    

}
