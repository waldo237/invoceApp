/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waldomilanes.invoice.jpacontrollers;

import com.exceptions.NonexistentEntityException;
import com.waldomilanes.invoice.pojos.OrdenDetalle;
import com.waldomilanes.invoice.utilities.DBType;
import com.waldomilanes.invoice.utilities.DBUtil;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;

/**
 *
 * @author Instructor
 */
public class OrdenDetalleJpaController implements Serializable {

    public OrdenDetalleJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(OrdenDetalle detalle) {
            String sql = "INSERT INTO public.orden_detalle(no_orden, idproducto, cantidad, precio, costo, tax)"
                    + " VALUES (?, ?, ?, ?, ?, ?);";
            int devuelta = 0;
            try (Connection conn = DBUtil.getConnection(DBType.ITLA);
                    PreparedStatement stm = conn.prepareStatement(sql);) {
                
                stm.setInt(1, detalle.getNoOrden());
                stm.setString(2, detalle.getIdproducto());
                stm.setInt(3, detalle.getCantidad());
                stm.setBigDecimal(4, detalle.getPrecio());
                stm.setBigDecimal(5, detalle.getCosto());
                stm.setBigDecimal(6, detalle.getTax());
                
                devuelta = stm.executeUpdate();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
         
        }

    public void edit(OrdenDetalle ordenDetalle) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ordenDetalle = em.merge(ordenDetalle);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ordenDetalle.getNoOrden();
                if (findOrdenDetalle(id) == null) {
                    throw new NonexistentEntityException("The ordenDetalle with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OrdenDetalle ordenDetalle;
            try {
                ordenDetalle = em.getReference(OrdenDetalle.class, id);
                ordenDetalle.getNoOrden();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ordenDetalle with id " + id + " no longer exists.", enfe);
            }
            em.remove(ordenDetalle);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<OrdenDetalle> findOrdenDetalleEntities() {
        return findOrdenDetalleEntities(true, -1, -1);
    }

    public List<OrdenDetalle> findOrdenDetalleEntities(int maxResults, int firstResult) {
        return findOrdenDetalleEntities(false, maxResults, firstResult);
    }

    private List<OrdenDetalle> findOrdenDetalleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(OrdenDetalle.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public OrdenDetalle findOrdenDetalle(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(OrdenDetalle.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrdenDetalleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<OrdenDetalle> rt = cq.from(OrdenDetalle.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Number) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
