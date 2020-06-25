package com.waldomilanes.invoice.restcontrollers;

import com.waldomilanes.invoice.pojos.OrdenDetalle;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Waldo Milanes
 */
public class OrdenDetalleRESTController {

    @Autowired
    RestTemplate template = new RestTemplate();
    public static String URL = "http://localhost:8080";

    public OrdenDetalleRESTController() {
    }

    public List<OrdenDetalle> getAllOrdenDetalles() {
        List<OrdenDetalle> ordendetalleResponse = null;
        try {
            ordendetalleResponse = null;
            ordendetalleResponse = Arrays.stream(template.getForObject(URL + "/allordendetalles", OrdenDetalle[].class))
                    .collect(Collectors.toList());
        } catch (RestClientException restClientException) {
        }
        return ordendetalleResponse;
    }

    public OrdenDetalle getOrdenDetalle(String id) {
        ResponseEntity<OrdenDetalle> ordendetalleResponse = null;
        try {
            ordendetalleResponse = template.getForEntity(URL + "/ordendetalle/" + id, OrdenDetalle.class);
        } catch (RestClientException restClientException) {
        }
        return ordendetalleResponse.getBody();
    }

    public void addOrdenDetalle(OrdenDetalle ordendetalle) {
        try {
            template.postForLocation(URL + "/addordendetalle/", ordendetalle, OrdenDetalle.class);
            
        } catch (RestClientException restClientException) {
            
        }
    }

    /**
     *
     * @param ordendetalle This is supposed to be an object that already exists
     * you can use this same class to make it happen. eg.: new
     * OrdenDetalleRESTController().getOrdenDetalle(ordendetalleid);
     */
    public void updateOrdenDetalle(OrdenDetalle ordendetalle) {

        final String uri = URL + "/updateordendetalle/{id}";
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", "id");
        System.out.print(uri + ordendetalle + params);
        try {

            template.put(uri, ordendetalle, params);
        } catch (RestClientException restClientException) {
        }
    }

    public void deleteOrdenDetalle(String id) throws RestClientException {
        {
            final String uri = "http://localhost:8080/deleteordendetalle/{id}";

            Map<String, String> params = new HashMap<String, String>();
            params.put("id", id);
            try {

                template.delete(uri, params);
            } catch (RestClientException restClientException) {
            }
        }

    }

    public OrdenDetalle getOrdenDetalleByOrden(String orden) {
        ResponseEntity<OrdenDetalle> ordendetalleResponse = null;
        try {
            ordendetalleResponse = template.getForEntity(URL + "/ordenDetalle/orden/" + orden, OrdenDetalle.class);
        } catch (RestClientException restClientException) {
        }
        return ordendetalleResponse.getBody();
    }

    public OrdenDetalle getOrdenDetalleByUser(String nombre) {
        ResponseEntity<OrdenDetalle> ordendetalleResponse = null;
        try {
            ordendetalleResponse = template.getForEntity(URL + "/ordenDetalle/usuario/" + nombre, OrdenDetalle.class);
        } catch (RestClientException restClientException) {
        }
        return ordendetalleResponse.getBody();
    }

    public static void main(String[] args){
       OrdenDetalle o = new OrdenDetalleRESTController().getOrdenDetalle("32");
       o.setCantidad(45);
        new OrdenDetalleRESTController().updateOrdenDetalle(o);
    }
}
