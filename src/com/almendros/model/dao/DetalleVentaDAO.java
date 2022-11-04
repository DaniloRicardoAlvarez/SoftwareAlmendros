/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almendros.model.dao;

import com.almendros.model.dao.exceptions.NonexistentEntityException;
import com.almendros.model.entity.DetalleVenta;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.almendros.model.entity.Factura;
import com.almendros.model.entity.Producto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author itachi
 */
public class DetalleVentaDAO implements Serializable {

    public DetalleVentaDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DetalleVenta detalleVenta) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Factura facturaCodigo = detalleVenta.getFacturaCodigo();
            if (facturaCodigo != null) {
                facturaCodigo = em.getReference(facturaCodigo.getClass(), facturaCodigo.getCodigoFactura());
                detalleVenta.setFacturaCodigo(facturaCodigo);
            }
            Producto productoCodigo = detalleVenta.getProductoCodigo();
            if (productoCodigo != null) {
                productoCodigo = em.getReference(productoCodigo.getClass(), productoCodigo.getCodigoProducto());
                detalleVenta.setProductoCodigo(productoCodigo);
            }
            em.persist(detalleVenta);
            if (facturaCodigo != null) {
                facturaCodigo.getDetalleVentaList().add(detalleVenta);
                facturaCodigo = em.merge(facturaCodigo);
            }
            if (productoCodigo != null) {
                productoCodigo.getDetalleVentaList().add(detalleVenta);
                productoCodigo = em.merge(productoCodigo);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DetalleVenta detalleVenta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DetalleVenta persistentDetalleVenta = em.find(DetalleVenta.class, detalleVenta.getCodigoVenta());
            Factura facturaCodigoOld = persistentDetalleVenta.getFacturaCodigo();
            Factura facturaCodigoNew = detalleVenta.getFacturaCodigo();
            Producto productoCodigoOld = persistentDetalleVenta.getProductoCodigo();
            Producto productoCodigoNew = detalleVenta.getProductoCodigo();
            if (facturaCodigoNew != null) {
                facturaCodigoNew = em.getReference(facturaCodigoNew.getClass(), facturaCodigoNew.getCodigoFactura());
                detalleVenta.setFacturaCodigo(facturaCodigoNew);
            }
            if (productoCodigoNew != null) {
                productoCodigoNew = em.getReference(productoCodigoNew.getClass(), productoCodigoNew.getCodigoProducto());
                detalleVenta.setProductoCodigo(productoCodigoNew);
            }
            detalleVenta = em.merge(detalleVenta);
            if (facturaCodigoOld != null && !facturaCodigoOld.equals(facturaCodigoNew)) {
                facturaCodigoOld.getDetalleVentaList().remove(detalleVenta);
                facturaCodigoOld = em.merge(facturaCodigoOld);
            }
            if (facturaCodigoNew != null && !facturaCodigoNew.equals(facturaCodigoOld)) {
                facturaCodigoNew.getDetalleVentaList().add(detalleVenta);
                facturaCodigoNew = em.merge(facturaCodigoNew);
            }
            if (productoCodigoOld != null && !productoCodigoOld.equals(productoCodigoNew)) {
                productoCodigoOld.getDetalleVentaList().remove(detalleVenta);
                productoCodigoOld = em.merge(productoCodigoOld);
            }
            if (productoCodigoNew != null && !productoCodigoNew.equals(productoCodigoOld)) {
                productoCodigoNew.getDetalleVentaList().add(detalleVenta);
                productoCodigoNew = em.merge(productoCodigoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = detalleVenta.getCodigoVenta();
                if (findDetalleVenta(id) == null) {
                    throw new NonexistentEntityException("The detalleVenta with id " + id + " no longer exists.");
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
            DetalleVenta detalleVenta;
            try {
                detalleVenta = em.getReference(DetalleVenta.class, id);
                detalleVenta.getCodigoVenta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detalleVenta with id " + id + " no longer exists.", enfe);
            }
            Factura facturaCodigo = detalleVenta.getFacturaCodigo();
            if (facturaCodigo != null) {
                facturaCodigo.getDetalleVentaList().remove(detalleVenta);
                facturaCodigo = em.merge(facturaCodigo);
            }
            Producto productoCodigo = detalleVenta.getProductoCodigo();
            if (productoCodigo != null) {
                productoCodigo.getDetalleVentaList().remove(detalleVenta);
                productoCodigo = em.merge(productoCodigo);
            }
            em.remove(detalleVenta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DetalleVenta> findDetalleVentaEntities() {
        return findDetalleVentaEntities(true, -1, -1);
    }

    public List<DetalleVenta> findDetalleVentaEntities(int maxResults, int firstResult) {
        return findDetalleVentaEntities(false, maxResults, firstResult);
    }

    private List<DetalleVenta> findDetalleVentaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DetalleVenta.class));
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

    public DetalleVenta findDetalleVenta(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DetalleVenta.class, id);
        } finally {
            em.close();
        }
    }

    public int getDetalleVentaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DetalleVenta> rt = cq.from(DetalleVenta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
