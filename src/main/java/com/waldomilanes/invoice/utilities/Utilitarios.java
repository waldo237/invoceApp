/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waldomilanes.invoice.utilities;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Base64;

/**
 *
 * @author Programacion
 */
public class Utilitarios {
    
    public static Request Base64Topeticion(String base){
        String st = base64ToString(base);
        System.out.println(st);
         Request res=new Request();
         Gson gs=new Gson();
         res=gs.fromJson(st, Request.class);
         return res;
    }
    
    
    
    public static void logging(String st){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("d:/prueba.txt");
            fichero.write(st);
          
        } catch (Exception e) {
            e.printStackTrace();
    }
    }
    
    public static String convertBase64(String s){
        byte[] sb = s.getBytes();
        String codificado = Base64.getEncoder().encodeToString(sb);
        return codificado;
 
    }
    
     public static String convertBase64(byte[] s){
        String codificado = Base64.getEncoder().encodeToString(s);
        return codificado;        
    }
     
    
    public static String base64ToString(String s){
        byte[] des = Base64.getDecoder().decode(s.getBytes());
        return (new String(des));        
    }
     
        
    public static String comilla(String s){
        return "\""+s+"\"";
    }
    
      public static String comilla(Object s){
        return "\""+s+"\"";
    }
      

    public static String resulsetTojson(ResultSet rs)throws SQLException {
        
       String js="";
       String fila;
       
         try{              
           ResultSetMetaData col = rs.getMetaData();
           String[] campos= new String[col.getColumnCount()];
           
          for (int i=1; i<=col.getColumnCount();i++)
          {
              campos[i-1] = col.getColumnLabel(i);
          }
          
          while (rs.next()) {
              fila="{";
             for (int i=0; i<col.getColumnCount();i++)
             {
              fila+=campos[i]+":"+comilla(rs.getObject(i+1))+",";
             }
             fila=fila.substring(0,fila.length()-1);
             fila+="},"; js+=fila;
            
          }
          js="["+js.substring(0,js.length()-1)+"]";
          return js;
        }catch(SQLException e) {
            throw e;
        }

    }    
  
}
