/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecs;

import ecs.exceptions.NonexistentEntityException;
import ecs.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author dosunmu5
 */
public class SubmissionJpaController implements Serializable {

    public SubmissionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Submission submission) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(submission);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSubmission(submission.getModuleCode()) != null) {
                throw new PreexistingEntityException("Submission " + submission + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Submission submission) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            submission = em.merge(submission);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = submission.getModuleCode();
                if (findSubmission(id) == null) {
                    throw new NonexistentEntityException("The submission with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Submission submission;
            try {
                submission = em.getReference(Submission.class, id);
                submission.getModuleCode();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The submission with id " + id + " no longer exists.", enfe);
            }
            em.remove(submission);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Submission> findSubmissionEntities() {
        return findSubmissionEntities(true, -1, -1);
    }

    public List<Submission> findSubmissionEntities(int maxResults, int firstResult) {
        return findSubmissionEntities(false, maxResults, firstResult);
    }

    private List<Submission> findSubmissionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Submission.class));
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

    public Submission findSubmission(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Submission.class, id);
        } finally {
            em.close();
        }
    }

    public int getSubmissionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Submission> rt = cq.from(Submission.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
