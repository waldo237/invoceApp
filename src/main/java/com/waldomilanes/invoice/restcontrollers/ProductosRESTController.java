package com.waldomilanes.invoice.restcontrollers;

import com.waldomilanes.invoice.pojos.Productos;
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
public class ProductosRESTController {

    @Autowired
    RestTemplate template = new RestTemplate();
    public static String URL = "http://localhost:8080";

    public ProductosRESTController() {
    }

    public Productos getProductoByName(String productoIn) {
        ResponseEntity<Productos> productoResponse = null;
        try {
            productoResponse = template.getForEntity(URL + "/productos/nombre/" + productoIn, Productos.class);
        } catch (RestClientException restClientException) {
        }
        return productoResponse.getBody();
    }

    public List<Productos> getAllProductos() {
        List<Productos> productoResponse = null;
        try {
            productoResponse = null;
            productoResponse = Arrays.stream(template.getForObject(URL + "/allproductos", Productos[].class))
                    .collect(Collectors.toList());
        } catch (RestClientException restClientException) {
        }
         return productoResponse;
    }

    public Productos getProducto(String id) {
        ResponseEntity<Productos> productoResponse = null;
        try {
            productoResponse = template.getForEntity(URL + "/producto/" + id, Productos.class);
        } catch (RestClientException restClientException) {
        }
        return productoResponse.getBody();
    }

    public void addProducto(Productos producto) {
        try {
            
            template.postForLocation(URL + "/addproducto/", producto, Productos.class);
        } catch (RestClientException restClientException) {
        }
    }
    /**
     * 
     * @param producto This is supposed to be an object that already exists you can 
     * use this same class to make it happen. eg.: new ProductoRESTController().getProducto(productoid);
     */
    public void updateProducto(Productos producto) {

        final String uri = URL + "/updateproducto/{id}";
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", "id");
        System.out.print(uri + producto + params);
        try {
            
            template.put(uri, producto, params);
        } catch (RestClientException restClientException) {
        }
    }

    public void deleteProducto(String id) throws RestClientException {
        {
            final String uri = "http://localhost:8080/deleteproducto/{id}";

            Map<String, String> params = new HashMap<String, String>();
            params.put("id", id);
            try {
                
                template.delete(uri, params);
            } catch (RestClientException restClientException) {
            }
        }

    }
    public Productos getProductosByDescription( String des){
        ResponseEntity<Productos> productoResponse = null;
        try {
            productoResponse = template.getForEntity(URL + "productos/descripcion/" + des, Productos.class);
        } catch (RestClientException restClientException) {
        }
        return productoResponse.getBody();
    }



}
