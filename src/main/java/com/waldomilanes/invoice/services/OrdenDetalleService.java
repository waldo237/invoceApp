/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waldomilanes.invoice.services;

import edu.exceptions.NonexistentEntityException;
import com.waldomilanes.invoice.jpacontrollers.OrdenDetalleJpaController;
import com.waldomilanes.invoice.pojos.OrdenDetalle;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import org.springframework.stereotype.Service;

@Service
public class OrdenDetalleService {

    public OrdenDetalleService() {
    }
    
        private final String PERSISTENCE_UNIT_NAME = "PU";
        private EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        private OrdenDetalleJpaController repository = new OrdenDetalleJpaController(emf);
        private OrdenDetalleJpaController OrdenDetalleControl = new OrdenDetalleJpaController(emf);
        EntityManager em = emf.createEntityManager();
    
	public List<OrdenDetalle> getAllOrdenDetalles(){
		List<OrdenDetalle> ordenDetalles = new ArrayList<>();
		repository.findOrdenDetalleEntities()
		.forEach(ordenDetalles::add);
		return ordenDetalles;
        
	}
	public OrdenDetalle getOrdenDetalle(String id){
		return repository.findOrdenDetalle(Integer.parseInt(id));
                
	}
        
	public  void addOrdenDetalle(OrdenDetalle ordenDetalle) {
		repository.create(ordenDetalle);
		
	}
	public void updateOrdenDetalle(String id, OrdenDetalle ordenDetalle) {
		
            try {
                repository.edit(ordenDetalle);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
		
	}
	public void deleteOrdenDetalle(String id) {
            
            try {
                repository.destroy(Integer.parseInt(id));
            } catch (NonexistentEntityException ex) {
                 JOptionPane.showMessageDialog(null, ex);
            }
		
	}

    public OrdenDetalle getOrdenDetalleByOrden(String numorden) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public OrdenDetalle getOrdenDetalleByUser(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
