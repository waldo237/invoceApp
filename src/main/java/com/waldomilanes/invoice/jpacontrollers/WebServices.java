/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waldomilanes.invoice.jpacontrollers;


import java.io.IOException;
import java.util.Map;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.waldomilanes.invoice.pojos.User;
import java.io.IOException;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import java.util.Map;
import javax.swing.JOptionPane;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import static javax.ws.rs.client.Entity.entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.codec.binary.Base64;
//import org.apache.commons.httpclient.params.HttpConnectionParams;
/**
*
* @author Usuario
*/

public class WebServices {
    private javax.ws.rs.client.WebTarget webTarget;
    private javax.ws.rs.client.Client client;
    public static String token = "";
    public static String url;//"http://199.217.112.100:8080/abacus/appws/";

    public WebServices() {
           
    }
    
    
    public String buscar(String json, String uri) throws IOException {
        json = convertirJson(json, token);
        uri = url + uri ;

       
        client = ClientBuilder.newClient();
        webTarget = client.target(uri);

        //POST
        Form frm = new Form();
        frm.param("dato", json);
        frm.param("token", "Kjdujeydhd88dndh");
        frm.param("id", "123456");
        Response response = null;
        try {
            response = webTarget.request(MediaType.TEXT_PLAIN).post(Entity.form(frm));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Conectando al servidor: \n" + e.getMessage(), "Informacion", JOptionPane.ERROR_MESSAGE);
        }
        
        String respuesta = response.readEntity(String.class);
        if (respuesta.equals("")) {
            JOptionPane.showMessageDialog(null, "Error Conectando al servidor \n", "Informacion", JOptionPane.ERROR_MESSAGE);
            return "";
        }

        if (!verificarRespuesta(respuesta)) {
            return respuesta = "";
        }
        respuesta = respuesta.replace("\\\"", "\"");

        return respuesta;
    }
     public String convertirJson(String json, String token) {
        json = "{\"f_key\":\"" + token + "\",\"f_data\":{" + json + "}}";
        //System.err.println("josn " + json);
        json = Base64.encodeBase64String(json.getBytes());
        return json;
    }
     
     public boolean verificarRespuesta(String json) throws IOException {
        boolean paso = true;
        Map<String, Object> map;
        ObjectMapper mapper = new ObjectMapper();
        json = json.replace(":NONE}", ":\"NONE\"}");
        json = json.replace("\\\"", "\"");
        map = mapper.readValue(json, new TypeReference<Map<String, Object>>() {
        });
        String r = "" + map.get("f_key");

        if (r.equals("-1")) {
            JOptionPane.showMessageDialog(null, "La empresa no esta activa.", "Informacion", JOptionPane.ERROR_MESSAGE);
            paso = false;
        } else if (r.equals("-2")) {
            JOptionPane.showMessageDialog(null, "El Usuario ha sido desactivado y/o contraseña e usuario es incorrecto.", "Informacion", JOptionPane.ERROR_MESSAGE);
            paso = false;
        } else if (r.equals("-3")) {
            JOptionPane.showMessageDialog(null, "La Sessión a caducado.", "Informacion", JOptionPane.ERROR_MESSAGE);
            paso = false;
        }else if (r.equals("-4")) {
            JOptionPane.showMessageDialog(null, "Existe una session abierta dae este usuario.", "Informacion", JOptionPane.ERROR_MESSAGE);
            paso = false;
        }  
        
        return paso;
    }
     
      public String getRnc(String json) {
        client = ClientBuilder.newClient();
        //03100802283
        webTarget = client.target("http://jqmicro.com/rnc/run.php?rnc=" + json);
        String respuesta = "";
        try {
            respuesta = webTarget.request(MediaType.TEXT_PLAIN).get(String.class);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Conectando al servidor: \n" + e.getMessage(), "Informacion", JOptionPane.ERROR_MESSAGE);
        }

        if (respuesta.equals("")) {
            JOptionPane.showMessageDialog(null, "Error Conectando al servidor \n", "Informacion", JOptionPane.ERROR_MESSAGE);
            return "";
        }

        //System.err.println("Json -> " + respuesta);
        return respuesta;
    }
    
}