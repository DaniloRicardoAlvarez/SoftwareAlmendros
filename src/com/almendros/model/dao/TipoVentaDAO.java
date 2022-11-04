/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almendros.model.dao;

import com.almendros.model.dao.exceptions.IllegalOrphanException;
import com.almendros.model.dao.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.almendros.model.entity.Factura;
import com.almendros.model.entity.TipoVenta;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author itachi
 */
public class TipoVentaDAO implements Serializable {

    public TipoVentaDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoVenta tipoVenta) {
        if (tipoVenta.getFacturaList() == null) {
            tipoVenta.setFacturaList(new ArrayList<Factura>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Factura> attachedFacturaList = new ArrayList<Factura>();
            for (Factura facturaListFacturaToAttach : tipoVenta.getFacturaList()) {
                facturaListFacturaToAttach = em.getReference(facturaListFacturaToAttach.getClass(), facturaListFacturaToAttach.getCodigoFactura());
                attachedFacturaList.add(facturaListFacturaToAttach);
            }
            tipoVenta.setFacturaList(attachedFacturaList);
            em.persist(tipoVenta);
            for (Factura facturaListFactura : tipoVenta.getFacturaList()) {
                TipoVenta oldIdTipoOfFacturaListFactura = facturaListFactura.getIdTipo();
                facturaListFactura.setIdTipo(tipoVenta);
                facturaListFactura = em.merge(facturaListFactura);
                if (oldIdTipoOfFacturaListFactura != null) {
                    oldIdTipoOfFacturaListFactura.getFacturaList().remove(facturaListFactura);
                    oldIdTipoOfFacturaListFactura = em.merge(oldIdTipoOfFacturaListFactura);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoVenta tipoVenta) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoVenta persistentTipoVenta = em.find(TipoVenta.class, tipoVenta.getIdTipo());
            List<Factura> facturaListOld = persistentTipoVenta.getFacturaList();
            List<Factura> facturaListNew = tipoVenta.getFacturaList();
            List<String> illegalOrphanMessages = null;
            for (Factura facturaListOldFactura : facturaListOld) {
                if (!facturaListNew.contains(facturaListOldFactura)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factura " + facturaListOldFactura + " since its idTipo field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Factura> attachedFacturaListNew = new ArrayList<Factura>();
            for (Factura facturaListNewFacturaToAttach : facturaListNew) {
                facturaListNewFacturaToAttach = em.getReference(facturaListNewFacturaToAttach.getClass(), facturaListNewFacturaToAttach.getCodigoFactura());
                attachedFacturaListNew.add(facturaListNewFacturaToAttach);
            }
            facturaListNew = attachedFacturaListNew;
            tipoVenta.setFacturaList(facturaListNew);
            tipoVenta = em.merge(tipoVenta);
            for (Factura facturaListNewFactura : facturaListNew) {
                if (!facturaListOld.contains(facturaListNewFactura)) {
                    TipoVenta oldIdTipoOfFacturaListNewFactura = facturaListNewFactura.getIdTipo();
                    facturaListNewFactura.setIdTipo(tipoVenta);
                    facturaListNewFactura = em.merge(facturaListNewFactura);
                    if (oldIdTipoOfFacturaListNewFactura != null && !oldIdTipoOfFacturaListNewFactura.equals(tipoVenta)) {
                        oldIdTipoOfFacturaListNewFactura.getFacturaList().remove(facturaListNewFactura);
                        oldIdTipoOfFacturaListNewFactura = em.merge(oldIdTipoOfFacturaListNewFactura);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tipoVenta.getIdTipo();
                if (findTipoVenta(id) == null) {
                    throw new NonexistentEntityException("The tipoVenta with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoVenta tipoVenta;
            try {
                tipoVenta = em.getReference(TipoVenta.class, id);
                tipoVenta.getIdTipo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoVenta with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Factura> facturaListOrphanCheck = tipoVenta.getFacturaList();
            for (Factura facturaListOrphanCheckFactura : facturaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This TipoVenta (" + tipoVenta + ") cannot be destroyed since the Factura " + facturaListOrphanCheckFactura + " in its facturaList field has a non-nullable idTipo field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(tipoVenta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoVenta> findTipoVentaEntities() {
        return findTipoVentaEntities(true, -1, -1);
    }

    public List<TipoVenta> findTipoVentaEntities(int maxResults, int firstResult) {
        return findTipoVentaEntities(false, maxResults, firstResult);
    }

    private List<TipoVenta> findTipoVentaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoVenta.class));
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

    public TipoVenta findTipoVenta(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoVenta.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoVentaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoVenta> rt = cq.from(TipoVenta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
