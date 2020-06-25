package com.waldomilanes.invoice.restcontrollers;

import com.waldomilanes.invoice.pojos.Cliente;
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
public class ClienteRESTController {

    @Autowired
    RestTemplate template = new RestTemplate();
    public static String URL = "http://localhost:8080";

    public ClienteRESTController() {
    }

    public Cliente getClienteByName(String clienteIn) {
        ResponseEntity<Cliente> clienteResponse = null;
        try {
            clienteResponse = template.getForEntity(URL + "/cliente/nombre/" + clienteIn, Cliente.class);
        } catch (RestClientException restClientException) {
        }
        return clienteResponse.getBody();
    }

    public List<Cliente> getAllClientes() {
        List<Cliente> clienteResponse = null;
        try {
            clienteResponse = null;
            clienteResponse = Arrays.stream(template.getForObject(URL + "/allclientes", Cliente[].class))
                    .collect(Collectors.toList());
        } catch (RestClientException restClientException) {
        }
         return clienteResponse;
    }

    public Cliente getCliente(String id) {
        ResponseEntity<Cliente> clienteResponse = null;
        try {
            clienteResponse = template.getForEntity(URL + "/cliente/" + id, Cliente.class);
        } catch (RestClientException restClientException) {
        }
        return clienteResponse.getBody();
    }

    public void addCliente(Cliente cliente) {
        try {
            
            template.postForLocation(URL + "/addcliente/", cliente, Cliente.class);
        } catch (RestClientException restClientException) {
        }
    }
    /**
     * 
     * @param cliente This is supposed to be an object that already exists you can 
     * use this same class to make it happen. eg.: new ClienteRESTController().getCliente(clienteid);
     */
    public void updateCliente(Cliente cliente) {

        final String uri = URL + "/updatecliente/{id}";
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", "id");
        System.out.print(uri + cliente + params);
        try {
            
            template.put(uri, cliente, params);
        } catch (RestClientException restClientException) {
        }
    }

    public void deleteCliente(String id) throws RestClientException {
        {
            final String uri = "http://localhost:8080/deletecliente/{id}";

            Map<String, String> params = new HashMap<String, String>();
            params.put("id", id);
            try {
                
                template.delete(uri, params);
            } catch (RestClientException restClientException) {
            }
        }

    }
}
