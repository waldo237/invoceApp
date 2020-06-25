
package com.waldomilanes.invoice.jpacontrollers;

import com.exceptions.NonexistentEntityException;
import com.waldomilanes.invoice.pojos.Session;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.waldomilanes.invoice.pojos.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class SessionJpaController implements Serializable {

    public SessionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Session session) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            User iduser = session.getIduser();
            if (iduser != null) {
                iduser = em.getReference(iduser.getClass(), iduser.getIduser());
                session.setIduser(iduser);
            }
            em.persist(session);
            if (iduser != null) {
                iduser.getSessionCollection().add(session);
                iduser = em.merge(iduser);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Session session) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Session persistentSession = em.find(Session.class, session.getIdsession());
            User iduserOld = persistentSession.getIduser();
            User iduserNew = session.getIduser();
            if (iduserNew != null) {
                iduserNew = em.getReference(iduserNew.getClass(), iduserNew.getIduser());
                session.setIduser(iduserNew);
            }
            session = em.merge(session);
            if (iduserOld != null && !iduserOld.equals(iduserNew)) {
                iduserOld.getSessionCollection().remove(session);
                iduserOld = em.merge(iduserOld);
            }
            if (iduserNew != null && !iduserNew.equals(iduserOld)) {
                iduserNew.getSessionCollection().add(session);
                iduserNew = em.merge(iduserNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = session.getIdsession();
                if (findSession(id) == null) {
                    throw new NonexistentEntityException("The session with id " + id + " no longer exists.");
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
            Session session;
            try {
                session = em.getReference(Session.class, id);
                session.getIdsession();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The session with id " + id + " no longer exists.", enfe);
            }
            User iduser = session.getIduser();
            if (iduser != null) {
                iduser.getSessionCollection().remove(session);
                iduser = em.merge(iduser);
            }
            em.remove(session);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Session> findSessionEntities() {
        return findSessionEntities(true, -1, -1);
    }

    public List<Session> findSessionEntities(int maxResults, int firstResult) {
        return findSessionEntities(false, maxResults, firstResult);
    }

    private List<Session> findSessionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Session.class));
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

    public Session findSession(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Session.class, id);
        } finally {
            em.close();
        }
    }

    public int getSessionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Session> rt = cq.from(Session.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Number) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
