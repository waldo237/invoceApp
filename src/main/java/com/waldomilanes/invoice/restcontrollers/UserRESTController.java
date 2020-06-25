package com.waldomilanes.invoice.restcontrollers;

import com.waldomilanes.invoice.pojos.User;
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
public class UserRESTController {

    @Autowired
    RestTemplate template = new RestTemplate();
    public static String URL = "http://localhost:8080";

    public UserRESTController() {
    }

    public User getUserByName(String userIn) {
        ResponseEntity<User> userResponse = null;
        try {
            userResponse = template.getForEntity(URL + "/findbyname/" + userIn, User.class);
        } catch (RestClientException restClientException) {
        }
        return userResponse.getBody();
    }

    public List<User> getAllUsers() {
        List<User> userResponse = null;
        try {
            userResponse = null;
            userResponse = Arrays.stream(template.getForObject(URL + "/allusers", User[].class))
                    .collect(Collectors.toList());
        } catch (RestClientException restClientException) {
        }
         return userResponse;
    }

    public User getUser(String id) {
        ResponseEntity<User> userResponse = null;
        try {
            userResponse = template.getForEntity(URL + "/user/" + id, User.class);
        } catch (RestClientException restClientException) {
        }
        return userResponse.getBody();
    }

    public void addUser(User user) {
        try {
            
            template.postForLocation(URL + "/adduser/", user, User.class);
        } catch (RestClientException restClientException) {
        }
    }
    /**
     * 
     * @param user This is supposed to be an object that already exists you can 
     * use this same class to make it happen. eg.: new UserRESTController().getUser(userid);
     */
    public void updateUser(User user) {

        final String uri = URL + "/updateuser/{id}";
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", "id");
        System.out.print(uri + user + params);
        try {
            
            template.put(uri, user, params);
        } catch (RestClientException restClientException) {
        }
    }

    public void deleteUser(String id) throws RestClientException {
        {
            final String uri = "http://localhost:8080/deleteuser/{id}";

            Map<String, String> params = new HashMap<String, String>();
            params.put("id", id);
            try {
                
                template.delete(uri, id);
            } catch (RestClientException restClientException) {
            }
        }

    }
    public static void main (String []args){
        
           new ClienteRESTController().deleteCliente("13");
    
        }
}
