package com.waldomilanes.invoice.restcontrollers;

import com.waldomilanes.invoice.pojos.Orden;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Waldo Milanes
 */
public class OrdenRESTController {

    @Autowired
    RestTemplate template = new RestTemplate();
    public static String URL = "http://localhost:8080";

    public OrdenRESTController() {
    }

    public Orden getLastOrden(String ordenIn) {
        ResponseEntity<Orden> ordenResponse = null;
        try {
            ordenResponse = template.getForEntity(URL + "/lastorder/" + 2, Orden.class);
        } catch (RestClientException restClientException) {
        }
        return ordenResponse.getBody();
    }
    public Orden getOrdenByProducto(String ordenIn) {
        ResponseEntity<Orden> ordenResponse = null;
        try {
            ordenResponse = template.getForEntity(URL + "/orden/producto/" + ordenIn, Orden.class);
        } catch (RestClientException restClientException) {
        }
        return ordenResponse.getBody();
    }

    public List<Orden> getAllOrdens() {
        List<Orden> ordenResponse = null;
        try {
            ordenResponse = null;
            ordenResponse = Arrays.stream(template.getForObject(URL + "/allordens", Orden[].class))
                    .collect(Collectors.toList());
        } catch (RestClientException restClientException) {
        }
        return ordenResponse;
    }

    public Orden getOrden(String id) {
        ResponseEntity<Orden> ordenResponse = null;
        try {
            ordenResponse = template.getForEntity(URL + "/orden/" + id, Orden.class);
        } catch (RestClientException restClientException) {
        }
        return ordenResponse.getBody();
    }

    public void addOrden(Orden orden) {
        try {

            template.postForLocation(URL + "/addorden/", orden, Orden.class);
        } catch (RestClientException restClientException) {
            JOptionPane.showMessageDialog(null, restClientException);
        }
    }

    /**
     *
     * @param orden This is supposed to be an object that already exists you can
     * use this same class to make it happen. eg.: new
     * OrdenRESTController().getOrden(ordenid);
     */
    public void updateOrden(Orden orden) {

        final String uri = URL + "/updateorden/{id}";
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", "id");
        System.out.print(uri + orden + params);
        try {

            template.put(uri, orden, params);
        } catch (RestClientException restClientException) {
        }
    }

    public void deleteOrden(String id) throws RestClientException {
        {
            final String uri = "http://localhost:8080/deleteorden/{id}";

            Map<String, String> params = new HashMap<String, String>();
            params.put("id", id);
            try {

                template.delete(uri, params);
            } catch (RestClientException restClientException) {
            }
        }

    }

    public Orden getOrdenByUser(@PathVariable String nombre) {

        ResponseEntity<Orden> ordenResponse = null;
        try {
            ordenResponse = template.getForEntity(URL + "/orden/usuario/" + nombre, Orden.class);
        } catch (RestClientException restClientException) {
        }
        return ordenResponse.getBody();
    }

    

}
