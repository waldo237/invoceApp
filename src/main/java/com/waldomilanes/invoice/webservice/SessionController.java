
package com.waldomilanes.invoicewebservice;

import com.waldomilanes.invoicepojos.Session;
import com.waldomilanes.invoiceservices.SessionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SessionController {
    @Autowired
    private SessionService sessionService = new SessionService();
         
        @RequestMapping("/session/usuario/{nombre}")
            public Session getSessionByUser(@PathVariable String nombre){
		return sessionService.getSessionByUser(nombre);
	}
    
        @RequestMapping("/allsessions")
        public List<Session> getAllSessions(){
             return sessionService.getAllSessions();
         }
        

         @RequestMapping("/session/{id}")
             public Session getSession(@PathVariable String id){
		return sessionService.getSession(id);
	}
	@RequestMapping(method=RequestMethod.POST, value ="/addsession")
	public void addSession(@RequestBody Session session){
		sessionService.addSession(session);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value ="/updatesession/{id}")
	public void updateSession(@RequestBody Session session, @PathVariable String id){
		sessionService.updateSession(id, session);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value ="/deletesession/{id}")
	public void deleteSession(@RequestBody Session session, @PathVariable String id){
		 sessionService.deleteSession(id);
	}

   
}
