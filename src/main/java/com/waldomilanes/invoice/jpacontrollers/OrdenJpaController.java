/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waldomilanes.invoice.jpacontrollers;

import com.exceptions.NonexistentEntityException;
import com.waldomilanes.invoice.pojos.Orden;
import com.waldomilanes.invoice.pojos.OrdenDetalle;
import com.waldomilanes.invoice.utilities.DBType;
import com.waldomilanes.invoice.utilities.DBUtil;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class OrdenJpaController implements Serializable {

    public OrdenJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Orden orden) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(orden);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Orden orden) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            orden = em.merge(orden);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = orden.getNoOrden();
                if (findOrden(id) == null) {
                    throw new NonexistentEntityException("The orden with id " + id + " no longer exists.");
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
            Orden orden;
            try {
                orden = em.getReference(Orden.class, id);
                orden.getNoOrden();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The orden with id " + id + " no longer exists.", enfe);
            }
            em.remove(orden);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Orden> findOrdenEntities() {
        return findOrdenEntities(true, -1, -1);
    }

    public List<Orden> findOrdenEntities(int maxResults, int firstResult) {
        return findOrdenEntities(false, maxResults, firstResult);
    }

    private List<Orden> findOrdenEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Orden.class));
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

    public Orden findOrden(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Orden.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrdenCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Orden> rt = cq.from(Orden.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Number) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    

       public  Orden lastOrdenGenerator() {
            String sql = "SELECT no_orden, fecha, idcliente, comentario FROM public.orden ORDER BY no_orden DESC LIMIT 1;";
            Orden orden = new Orden();
        
            try (Connection BaseDatos = DBUtil.getConnection(DBType.ITLA);
                   Statement st = BaseDatos.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);) {
               
                ResultSet rs = st.executeQuery(sql);
                ResultSetMetaData col = rs.getMetaData();
                while (rs.next()) {
                    orden.setNoOrden(rs.getInt("no_orden"));
                    orden.setFecha(new Date());
                    orden.setIdcliente(rs.getInt("idcliente"));
                    orden.setComentario("comentario");
                    
                }
                if (!rs.first()) {
                    JOptionPane.showConfirmDialog(null, "Lo sentimos, los valores"
                            + "que busca no esta en la base de datos",
                            "Valor no encontrado", JOptionPane.WARNING_MESSAGE);
                }
            } catch (SQLException e) {
                try {
                    throw e;
                } catch (SQLException ex) {
                    Logger.getLogger(OrdenJpaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return orden;
       
    }
   public static boolean OrdenDetalleUpdate(OrdenDetalle detalle, int index) throws Exception {
            boolean confirm = false;
            String sql = "SELECT no_orden, idproducto, cantidad, precio, costo, tax "
                    + "  FROM public.orden_detalle WHERE no_orden = ?;";
            ResultSet rs = null;
            try (Connection conn = DBUtil.getConnection(DBType.ITLA);
                    PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);) {
                stmt.setInt(1, index);
                rs = stmt.executeQuery();
                if (rs.next()) {
                    rs.updateInt(1, detalle.getNoOrden());
                    rs.updateString(2, detalle.getIdproducto());
                    rs.updateInt(3, detalle.getCantidad());
                    rs.updateBigDecimal(4, detalle.getPrecio());
                    rs.updateBigDecimal(5, detalle.getCosto());
                    rs.updateBigDecimal(6, detalle.getTax());
                    rs.updateRow();
                    confirm = true;
                } else {
                    confirm = false;
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error con la base de tados" + ex);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Asegurese que los valores que inserto son correctos.");
            } finally {
                if (rs != null) {
                    rs.close();
                }
            }
            return confirm;
        }
    public static boolean DetalleDelete(int Id) throws Exception {
            String sql = "DELETE FROM public.orden_detalle WHERE no_orden = ?;";
            try (Connection conn = DBUtil.getConnection(DBType.ITLA);
                    PreparedStatement stmt = conn.prepareStatement(sql);) {
                stmt.setInt(1, Id);
                stmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
                return false;
            }
        }
    
    
}
