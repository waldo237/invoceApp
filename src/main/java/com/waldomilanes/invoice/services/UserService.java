/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waldomilanes.invoice.services;

import edu.exceptions.NonexistentEntityException;
import com.waldomilanes.invoice.jpacontrollers.UserJpaController;
import com.waldomilanes.invoice.pojos.User;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.stereotype.Service;

@Service
public class UserService {
        private final String PERSISTENCE_UNIT_NAME = "PU";
        private EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        private UserJpaController repository = new UserJpaController(emf);
        EntityManager em = emf.createEntityManager();


    public UserService() {
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        repository.findUserEntities()
                .forEach(users::add);
        return users;

    }

    public User getUser(int id) {
        
        return repository.findUser(id);

    }

    public User getUserByName(String name) {

        return repository.getUserByName(em, name);
    }

    public void addUser(User user) {
        repository.create(user);

    }

    public void updateUser(User user) {
        
            try {
                repository.edit(user);
            } catch (Exception ex) {
                Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            }

    }

    public void deleteUser(int id) {

            try {
                repository.destroy(id);
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            }

    }
}
