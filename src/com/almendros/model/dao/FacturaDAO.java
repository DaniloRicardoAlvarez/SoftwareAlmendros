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
import com.almendros.model.entity.Cliente;
import com.almendros.model.entity.TipoVenta;
import com.almendros.model.entity.Usuario;
import com.almendros.model.entity.DetalleVenta;
import com.almendros.model.entity.Factura;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Coders
 */
public class FacturaDAO implements Serializable {

    public FacturaDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Factura factura) {
        if (factura.getDetalleVentaList() == null) {
            factura.setDetalleVentaList(new ArrayList<DetalleVenta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente idCliente = factura.getIdCliente();
            if (idCliente != null) {
                idCliente = em.getReference(idCliente.getClass(), idCliente.getCodigoCliente());
                factura.setIdCliente(idCliente);
            }
            TipoVenta idTipo = factura.getIdTipo();
            if (idTipo != null) {
                idTipo = em.getReference(idTipo.getClass(), idTipo.getIdTipo());
                factura.setIdTipo(idTipo);
            }
            Usuario idVendedor = factura.getIdVendedor();
            if (idVendedor != null) {
                idVendedor = em.getReference(idVendedor.getClass(), idVendedor.getCodigoUsuario());
                factura.setIdVendedor(idVendedor);
            }
            List<DetalleVenta> attachedDetalleVentaList = new ArrayList<DetalleVenta>();
            for (DetalleVenta detalleVentaListDetalleVentaToAttach : factura.getDetalleVentaList()) {
                detalleVentaListDetalleVentaToAttach = em.getReference(detalleVentaListDetalleVentaToAttach.getClass(), detalleVentaListDetalleVentaToAttach.getCodigoVenta());
                attachedDetalleVentaList.add(detalleVentaListDetalleVentaToAttach);
            }
            factura.setDetalleVentaList(attachedDetalleVentaList);
            em.persist(factura);
            if (idCliente != null) {
                idCliente.getFacturaList().add(factura);
                idCliente = em.merge(idCliente);
            }
            if (idTipo != null) {
                idTipo.getFacturaList().add(factura);
                idTipo = em.merge(idTipo);
            }
            if (idVendedor != null) {
                idVendedor.getFacturaList().add(factura);
                idVendedor = em.merge(idVendedor);
            }
            for (DetalleVenta detalleVentaListDetalleVenta : factura.getDetalleVentaList()) {
                Factura oldFacturaCodigoOfDetalleVentaListDetalleVenta = detalleVentaListDetalleVenta.getFacturaCodigo();
                detalleVentaListDetalleVenta.setFacturaCodigo(factura);
                detalleVentaListDetalleVenta = em.merge(detalleVentaListDetalleVenta);
                if (oldFacturaCodigoOfDetalleVentaListDetalleVenta != null) {
                    oldFacturaCodigoOfDetalleVentaListDetalleVenta.getDetalleVentaList().remove(detalleVentaListDetalleVenta);
                    oldFacturaCodigoOfDetalleVentaListDetalleVenta = em.merge(oldFacturaCodigoOfDetalleVentaListDetalleVenta);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Factura factura) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Factura persistentFactura = em.find(Factura.class, factura.getCodigoFactura());
            Cliente idClienteOld = persistentFactura.getIdCliente();
            Cliente idClienteNew = factura.getIdCliente();
            TipoVenta idTipoOld = persistentFactura.getIdTipo();
            TipoVenta idTipoNew = factura.getIdTipo();
            Usuario idVendedorOld = persistentFactura.getIdVendedor();
            Usuario idVendedorNew = factura.getIdVendedor();
            List<DetalleVenta> detalleVentaListOld = persistentFactura.getDetalleVentaList();
            List<DetalleVenta> detalleVentaListNew = factura.getDetalleVentaList();
            List<String> illegalOrphanMessages = null;
            for (DetalleVenta detalleVentaListOldDetalleVenta : detalleVentaListOld) {
                if (!detalleVentaListNew.contains(detalleVentaListOldDetalleVenta)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain DetalleVenta " + detalleVentaListOldDetalleVenta + " since its facturaCodigo field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idClienteNew != null) {
                idClienteNew = em.getReference(idClienteNew.getClass(), idClienteNew.getCodigoCliente());
                factura.setIdCliente(idClienteNew);
            }
            if (idTipoNew != null) {
                idTipoNew = em.getReference(idTipoNew.getClass(), idTipoNew.getIdTipo());
                factura.setIdTipo(idTipoNew);
            }
            if (idVendedorNew != null) {
                idVendedorNew = em.getReference(idVendedorNew.getClass(), idVendedorNew.getCodigoUsuario());
                factura.setIdVendedor(idVendedorNew);
            }
            List<DetalleVenta> attachedDetalleVentaListNew = new ArrayList<DetalleVenta>();
            for (DetalleVenta detalleVentaListNewDetalleVentaToAttach : detalleVentaListNew) {
                detalleVentaListNewDetalleVentaToAttach = em.getReference(detalleVentaListNewDetalleVentaToAttach.getClass(), detalleVentaListNewDetalleVentaToAttach.getCodigoVenta());
                attachedDetalleVentaListNew.add(detalleVentaListNewDetalleVentaToAttach);
            }
            detalleVentaListNew = attachedDetalleVentaListNew;
            factura.setDetalleVentaList(detalleVentaListNew);
            factura = em.merge(factura);
            if (idClienteOld != null && !idClienteOld.equals(idClienteNew)) {
                idClienteOld.getFacturaList().remove(factura);
                idClienteOld = em.merge(idClienteOld);
            }
            if (idClienteNew != null && !idClienteNew.equals(idClienteOld)) {
                idClienteNew.getFacturaList().add(factura);
                idClienteNew = em.merge(idClienteNew);
            }
            if (idTipoOld != null && !idTipoOld.equals(idTipoNew)) {
                idTipoOld.getFacturaList().remove(factura);
                idTipoOld = em.merge(idTipoOld);
            }
            if (idTipoNew != null && !idTipoNew.equals(idTipoOld)) {
                idTipoNew.getFacturaList().add(factura);
                idTipoNew = em.merge(idTipoNew);
            }
            if (idVendedorOld != null && !idVendedorOld.equals(idVendedorNew)) {
                idVendedorOld.getFacturaList().remove(factura);
                idVendedorOld = em.merge(idVendedorOld);
            }
            if (idVendedorNew != null && !idVendedorNew.equals(idVendedorOld)) {
                idVendedorNew.getFacturaList().add(factura);
                idVendedorNew = em.merge(idVendedorNew);
            }
            for (DetalleVenta detalleVentaListNewDetalleVenta : detalleVentaListNew) {
                if (!detalleVentaListOld.contains(detalleVentaListNewDetalleVenta)) {
                    Factura oldFacturaCodigoOfDetalleVentaListNewDetalleVenta = detalleVentaListNewDetalleVenta.getFacturaCodigo();
                    detalleVentaListNewDetalleVenta.setFacturaCodigo(factura);
                    detalleVentaListNewDetalleVenta = em.merge(detalleVentaListNewDetalleVenta);
                    if (oldFacturaCodigoOfDetalleVentaListNewDetalleVenta != null && !oldFacturaCodigoOfDetalleVentaListNewDetalleVenta.equals(factura)) {
                        oldFacturaCodigoOfDetalleVentaListNewDetalleVenta.getDetalleVentaList().remove(detalleVentaListNewDetalleVenta);
                        oldFacturaCodigoOfDetalleVentaListNewDetalleVenta = em.merge(oldFacturaCodigoOfDetalleVentaListNewDetalleVenta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = factura.getCodigoFactura();
                if (findFactura(id) == null) {
                    throw new NonexistentEntityException("The factura with id " + id + " no longer exists.");
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
            Factura factura;
            try {
                factura = em.getReference(Factura.class, id);
                factura.getCodigoFactura();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The factura with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<DetalleVenta> detalleVentaListOrphanCheck = factura.getDetalleVentaList();
            for (DetalleVenta detalleVentaListOrphanCheckDetalleVenta : detalleVentaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Factura (" + factura + ") cannot be destroyed since the DetalleVenta " + detalleVentaListOrphanCheckDetalleVenta + " in its detalleVentaList field has a non-nullable facturaCodigo field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Cliente idCliente = factura.getIdCliente();
            if (idCliente != null) {
                idCliente.getFacturaList().remove(factura);
                idCliente = em.merge(idCliente);
            }
            TipoVenta idTipo = factura.getIdTipo();
            if (idTipo != null) {
                idTipo.getFacturaList().remove(factura);
                idTipo = em.merge(idTipo);
            }
            Usuario idVendedor = factura.getIdVendedor();
            if (idVendedor != null) {
                idVendedor.getFacturaList().remove(factura);
                idVendedor = em.merge(idVendedor);
            }
            em.remove(factura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Factura> findFacturaEntities() {
        return findFacturaEntities(true, -1, -1);
    }

    public List<Factura> findFacturaEntities(int maxResults, int firstResult) {
        return findFacturaEntities(false, maxResults, firstResult);
    }

    private List<Factura> findFacturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Factura.class));
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

    public Factura findFactura(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Factura.class, id);
        } finally {
            em.close();
        }
    }

    public int getFacturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Factura> rt = cq.from(Factura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public String autoIncrement() {

        EntityManager em = getEntityManager();
        //SELECT AUTO_INCREMENT FROM `information_schema`.`tables` WHERE TABLE_SCHEMA = "ALMENDROS" AND TABLE_NAME = "Clientes"

        String sql = "SELECT AUTO_INCREMENT FROM information_schema.tables WHERE TABLE_SCHEMA = \"ALMENDROS\" AND TABLE_NAME = \"Facturas\"";

        Query query = em.createNativeQuery(sql);

        String ai = (String) query.getSingleResult().toString();

        return ai;
    }

    public List<Factura> listaFecha(Date date) {
        EntityManager em = getEntityManager();
        List<Factura> list = null;
        try {
            list = em.createNamedQuery("Factura.findByFechaPago", Factura.class).setParameter("fechaPago", date).getResultList();
        } catch (Exception e) {
            list = new ArrayList<>();
            return list;
        }
        return list;
    }

    public List<Factura> listaMesAnioTodas(int year, int month) {

        EntityManager em = getEntityManager();

        List<Factura> list;

        String sql = "SELECT * FROM Facturas f WHERE YEAR(f.fecha_pago) = '" + year + "' AND MONTH(f.fecha_pago) = '" + month + "'";

        try {
            Query query = em.createNativeQuery(sql, Factura.class);
            list = query.getResultList();

        } catch (Exception e) {
            list = new ArrayList<>();
            return list;
        }

        return list;
    }

    public List<Factura> listaMesAnioConIva(int year, int month) {

        EntityManager em = getEntityManager();

        List<Factura> list = null;

        String sql = "SELECT * FROM Facturas f WHERE YEAR(f.fecha_pago) = '" + year + "' AND MONTH(f.fecha_pago) = '" + month + "' AND iva > 0";

        try {
            Query query = em.createNativeQuery(sql, Factura.class);
            list = query.getResultList();
        } catch (Exception e) {
            list = new ArrayList<>();
            return list;
        }

        return list;
    }

    public List<Factura> listaMesAnioSinIva(int year, int month) {

        EntityManager em = getEntityManager();

        List<Factura> list = null;

        String sql = "SELECT * FROM Facturas f WHERE YEAR(f.fecha_pago) = '" + year + "' AND MONTH(f.fecha_pago) = '" + month + "' AND iva = 0";

        try {
            Query query = em.createNativeQuery(sql, Factura.class);
            list = query.getResultList();
        } catch (Exception e) {
            list = new ArrayList<>();
            return list;
        }

        return list;
    }

}
