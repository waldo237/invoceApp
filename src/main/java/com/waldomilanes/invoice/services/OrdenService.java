/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waldomilanes.invoice.services;

import edu.exceptions.NonexistentEntityException;
import com.waldomilanes.invoice.jpacontrollers.OrdenJpaController;
import com.waldomilanes.invoice.pojos.Orden;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import org.springframework.stereotype.Service;

@Service
public class OrdenService {

    public OrdenService() {
    }
    
        private final String PERSISTENCE_UNIT_NAME = "PU";
        private EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        private OrdenJpaController repository = new OrdenJpaController(emf);
        private OrdenJpaController OrdenControl = new OrdenJpaController(emf);
        EntityManager em = emf.createEntityManager();
    
	public List<Orden> getAllOrdens(){
		List<Orden> ordens = new ArrayList<>();
		repository.findOrdenEntities()
		.forEach(ordens::add);
		return ordens;
        
	}
	public Orden getOrden(String id){
		return repository.findOrden(Integer.parseInt(id));
                
	}
        
	public  void addOrden(Orden orden) {
		repository.create(orden);
		
	}
	public void updateOrden(String id, Orden orden) {
		
            try {
                repository.edit(orden);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
		
	}
	public void deleteOrden(String id) {
            
            try {
                repository.destroy(Integer.parseInt(id));
            } catch (NonexistentEntityException ex) {
                 JOptionPane.showMessageDialog(null, ex);
            }
		
	}
         public  Orden getLastOrden( String name){
             Orden ultima = null;
             ultima = repository.lastOrdenGenerator();
        return ultima;
         }
    public Orden getOrdenByUser(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Orden getOrdenByProducto(String producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
