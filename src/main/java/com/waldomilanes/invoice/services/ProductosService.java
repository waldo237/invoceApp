/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waldomilanes.invoice.services;

import com.exceptions.NonexistentEntityException;
import com.waldomilanes.invoice.jpacontrollers.SessionJpaController;
import com.waldomilanes.invoice.jpacontrollers.ProductosJpaController;
import com.waldomilanes.invoice.pojos.Productos;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import org.springframework.stereotype.Service;

@Service
public class ProductosService {

    public ProductosService() {
    }
    
        private final String PERSISTENCE_UNIT_NAME = "PU";
        private EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        private ProductosJpaController repository = new ProductosJpaController(emf);
        private SessionJpaController SessionControl = new SessionJpaController(emf);
        EntityManager em = emf.createEntityManager();
    
	public List<Productos> getAllProductoss(){
		List<Productos> productoss = new ArrayList<>();
		repository.findProductosEntities()
		.forEach(productoss::add);
		return productoss;
        
	}
	public Productos getProductos(String id){
		return repository.findProductos(id);
                
	}
        public Productos getProductosByName(String name){
           
            return  repository.getProductosByName(em, name);
        }
        
	public  void addProductos(Productos productos) throws Exception {
		repository.create(productos);
		
	}
	public void updateProductos(String id, Productos productos) {
		
            try {
                repository.edit(productos);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
		
	}
	public void deleteProductos(String id) {
            
            try {
                repository.destroy(id);
            } catch (NonexistentEntityException ex) {
                 JOptionPane.showMessageDialog(null, ex);
            }
		
	}

    public Productos getProductosByDescripcion(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Productos getProductosByDescription(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
