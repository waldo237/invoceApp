/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waldomilanes.invoice.services;

import com.exceptions.NonexistentEntityException;
import com.waldomilanes.invoice.jpacontrollers.SessionJpaController;
import com.waldomilanes.invoice.jpacontrollers.ClienteJpaController;
import com.waldomilanes.invoice.pojos.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    public ClienteService() {
    }
    
        private final String PERSISTENCE_UNIT_NAME = "PU";
        private EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        private ClienteJpaController repository = new ClienteJpaController(emf);
        private SessionJpaController SessionControl = new SessionJpaController(emf);
        EntityManager em = emf.createEntityManager();
    
	public List<Cliente> getAllClientes(){
		List<Cliente> clientes = new ArrayList<>();
		repository.findClienteEntities()
		.forEach(clientes::add);
		return clientes;
        
	}
	public Cliente getCliente(String id){
		return repository.findCliente(Integer.parseInt(id));
                
	}
        public Cliente getClienteByName(String name){
           
            return  repository.getClienteByName(em, name);
        }
        
	public  void addCliente(Cliente cliente) {
		repository.create(cliente);
		
	}
	public void updateCliente(String id, Cliente cliente) {
		
            try {
                repository.edit(cliente);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
		
	}
	public void deleteCliente(String id) {
            
            try {
                repository.destroy(Integer.parseInt(id));
            } catch (NonexistentEntityException ex) {
                 JOptionPane.showMessageDialog(null, ex);
            }
		
	}

}
