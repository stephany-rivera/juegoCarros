/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.sofka.persistencia;

import co.com.sofka.cargame.domain.juego.GanadoresBD;
import co.com.sofka.persistencia.exceptions.NonexistentEntityException;
import co.com.sofka.persistencia.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * 
 * @author Stephany Rivera <anie.12106@gmail.com>
 */
public class GanadoresBDJpaController implements Serializable {

    public GanadoresBDJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public GanadoresBDJpaController(){
        emf=Persistence.createEntityManagerFactory("co.com.sofka1.0-PU");
    
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(GanadoresBD ganadoresBD) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ganadoresBD);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findGanadoresBD(ganadoresBD.getId()) != null) {
                throw new PreexistingEntityException("GanadoresBD " + ganadoresBD + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(GanadoresBD ganadoresBD) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ganadoresBD = em.merge(ganadoresBD);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = ganadoresBD.getId();
                if (findGanadoresBD(id) == null) {
                    throw new NonexistentEntityException("The ganadoresBD with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            GanadoresBD ganadoresBD;
            try {
                ganadoresBD = em.getReference(GanadoresBD.class, id);
                ganadoresBD.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ganadoresBD with id " + id + " no longer exists.", enfe);
            }
            em.remove(ganadoresBD);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<GanadoresBD> findGanadoresBDEntities() {
        return findGanadoresBDEntities(true, -1, -1);
    }

    public List<GanadoresBD> findGanadoresBDEntities(int maxResults, int firstResult) {
        return findGanadoresBDEntities(false, maxResults, firstResult);
    }

    private List<GanadoresBD> findGanadoresBDEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(GanadoresBD.class));
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

    public GanadoresBD findGanadoresBD(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(GanadoresBD.class, id);
        } finally {
            em.close();
        }
    }

    public int getGanadoresBDCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<GanadoresBD> rt = cq.from(GanadoresBD.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
