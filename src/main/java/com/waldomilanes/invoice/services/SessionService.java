/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waldomilanes.invoice.services;

import com.exceptions.NonexistentEntityException;
import com.waldomilanes.invoice.jpacontrollers.SessionJpaController;
import com.waldomilanes.invoice.jpacontrollers.SessionJpaController;
import com.waldomilanes.invoice.pojos.Session;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    public SessionService() {
    }
    
        private final String PERSISTENCE_UNIT_NAME = "PU";
        private EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        private SessionJpaController repository = new SessionJpaController(emf);
        private SessionJpaController SessionControl = new SessionJpaController(emf);
        EntityManager em = emf.createEntityManager();
    
	public List<Session> getAllSessions(){
		List<Session> sessions = new ArrayList<>();
		repository.findSessionEntities()
		.forEach(sessions::add);
		return sessions;
        
	}
	public Session getSession(String id){
		return repository.findSession(Integer.parseInt(id));
                
	}
        
	public  void addSession(Session session) {
		repository.create(session);
		
	}
	public void updateSession(String id, Session session) {
		
            try {
                repository.edit(session);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
		
	}
	public void deleteSession(String id) {
            
            try {
                repository.destroy(Integer.parseInt(id));
            } catch (NonexistentEntityException ex) {
                 JOptionPane.showMessageDialog(null, ex);
            }
		
	}

    public Session getSessionByUser(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
