package com.waldomilanes.invoice.restcontrollers;

import com.waldomilanes.invoice.jpacontrollers.Decision;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Waldo Milanes
 */
public class ModeloRESTController {

    @Autowired
    RestTemplate template = new RestTemplate();
    public static String URL = "http://localhost:8080";

    public ModeloRESTController() {
    }

    public DefaultTableModel getDefaultTableModelAll(Decision sql) {
        ResponseEntity<DefaultTableModel> modeloResponse = null;
        
        try {
            modeloResponse = template.getForEntity(URL + "/modelostring/"+sql.name(), DefaultTableModel.class);
        } catch (RestClientException restClientException) {
        }
        return modeloResponse.getBody();
    }


    public DefaultTableModel getDefaultTableModelInt(Decision sql,String id) {
        ResponseEntity<DefaultTableModel> modeloResponse = null;
        try {
            modeloResponse = template.getForEntity(URL + "/modeloint/" +sql.name()+"/"+ id, DefaultTableModel.class);
        } catch (RestClientException restClientException) {
        }
        return modeloResponse.getBody();
    }
    public DefaultTableModel getDefaultTableModelFree(Decision sql,String free) {
        ResponseEntity<DefaultTableModel> modeloResponse = null;
        try {
            modeloResponse = template.getForEntity(URL + "/modelofree/" +sql.name()+"/"+ free, DefaultTableModel.class);
        } catch (RestClientException restClientException) {
        }
        return modeloResponse.getBody();
    }
}
