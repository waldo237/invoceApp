package com.waldomilanes.invoice.restcontrollers;

import com.waldomilanes.invoice.pojos.Session;
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
public class SessionRESTController {

    @Autowired
    RestTemplate template = new RestTemplate();
    public static String URL = "http://localhost:8080";

    public SessionRESTController() {
    }
    //under construction
    public Session getSessionByUser(String usuario) {
        ResponseEntity<Session> sessionsResponse = null;
        try {
            sessionsResponse = template.getForEntity(URL + "/session/usuario/" + usuario, Session.class);
        } catch (RestClientException restClientException) {
        }
        return sessionsResponse.getBody();
    }

    public List<Session> getAllSessions() {
        List<Session> sessionsResponse = null;
        try {
            sessionsResponse = null;
            sessionsResponse = Arrays.stream(template.getForObject(URL + "/allsessions", Session[].class))
                    .collect(Collectors.toList());
        } catch (RestClientException restClientException) {
        }
         return sessionsResponse;
    }

    public Session getSession(String id) {
        ResponseEntity<Session> sessionResponse = null;
        try {
            sessionResponse = template.getForEntity(URL + "/session/" + id, Session.class);
        } catch (RestClientException restClientException) {
        }
        return sessionResponse.getBody();
    }

    public void addSession(Session session) {
        try {
            
            template.postForLocation(URL + "/addsession/", session, Session.class);
        } catch (RestClientException restClientException) {
        }
    }
    /**
     * 
     * @param session This is supposed to be an object that already exists you can 
     * use this same class to make it happen. eg.: new SessionRESTController().getSession(sessionid);
     */
    public void updateSession(Session session) {

        final String uri = URL + "/updatesession/{id}";
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", "id");
        System.out.print(uri + session + params);
        try {
            
            template.put(uri, session, params);
        } catch (RestClientException restClientException) {
        }
    }

    public void deleteSession(String id) throws RestClientException {
        {
            final String uri = "/http://localhost:8080deletesession/{id}";

            Map<String, String> params = new HashMap<String, String>();
            params.put("id", id);
            try {
                
                template.delete(uri, params);
            } catch (RestClientException restClientException) {
            }
        }

    }

}
