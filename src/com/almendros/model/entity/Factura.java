/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almendros.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author itachi
 */
@Entity
@Table(name = "Facturas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
    ,
    @NamedQuery(name = "Factura.findByCodigoFactura", query = "SELECT f FROM Factura f WHERE f.codigoFactura = :codigoFactura")
    ,
    @NamedQuery(name = "Factura.findByFechaPago", query = "SELECT f FROM Factura f WHERE f.fechaPago = :fechaPago")
    ,
    @NamedQuery(name = "Factura.findByFechaRegistro", query = "SELECT f FROM Factura f WHERE f.fechaRegistro = :fechaRegistro")
    ,
    @NamedQuery(name = "Factura.findByNombreCliente", query = "SELECT f FROM Factura f WHERE f.nombreCliente = :nombreCliente")
    ,
    @NamedQuery(name = "Factura.findByEstado", query = "SELECT f FROM Factura f WHERE f.estado = :estado")
    ,
    @NamedQuery(name = "Factura.findByAdelanto", query = "SELECT f FROM Factura f WHERE f.adelanto = :adelanto")
    ,
    @NamedQuery(name = "Factura.findBySubTotal", query = "SELECT f FROM Factura f WHERE f.subTotal = :subTotal")
    ,
    @NamedQuery(name = "Factura.findByIva", query = "SELECT f FROM Factura f WHERE f.iva = :iva")
    ,
    @NamedQuery(name = "Factura.findByTotalFactura", query = "SELECT f FROM Factura f WHERE f.totalFactura = :totalFactura")

// SELECT * FROM 'facturas' WHERE MONTH(fecha_pago) = MONTH('2019-07-02')
})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_factura")
    private Integer codigoFactura;
    @Column(name = "fecha_pago")
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @Column(name = "nombre_cliente")
    private String nombreCliente;
    @Column(name = "estado")
    private String estado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "adelanto")
    private Double adelanto;
    @Column(name = "sub_total")
    private Double subTotal;
    @Column(name = "iva")
    private Double iva;
    @Basic(optional = false)
    @Column(name = "total_factura")
    private double totalFactura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturaCodigo")
    private List<DetalleVenta> detalleVentaList;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo")
    @ManyToOne(optional = false)
    private TipoVenta idTipo;
    @JoinColumn(name = "id_vendedor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario idVendedor;

    public Factura() {
    }

    public Factura(Integer codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public Factura(Integer codigoFactura, String nombreCliente, double totalFactura) {
        this.codigoFactura = codigoFactura;
        this.nombreCliente = nombreCliente;
        this.totalFactura = totalFactura;
    }

    public Integer getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(Integer codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getAdelanto() {
        return adelanto;
    }

    public void setAdelanto(Double adelanto) {
        this.adelanto = adelanto;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public double getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(double totalFactura) {
        this.totalFactura = totalFactura;
    }

    @XmlTransient
    public List<DetalleVenta> getDetalleVentaList() {
        return detalleVentaList;
    }

    public void setDetalleVentaList(List<DetalleVenta> detalleVentaList) {
        this.detalleVentaList = detalleVentaList;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public TipoVenta getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(TipoVenta idTipo) {
        this.idTipo = idTipo;
    }

    public Usuario getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Usuario idVendedor) {
        this.idVendedor = idVendedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoFactura != null ? codigoFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.codigoFactura == null && other.codigoFactura != null) || (this.codigoFactura != null && !this.codigoFactura.equals(other.codigoFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.almendros.model.entity.Factura[ codigoFactura=" + codigoFactura + " ]";
    }

    public Vector<String> convertirVector() {
        Vector<String> datos = new Vector<>();
        datos.add(String.valueOf(codigoFactura));
        datos.add((idTipo.getTipoVenta()));
        Date fec = new java.sql.Date(fechaPago.getTime());
        datos.add(fec.toString());
        datos.add(subTotal.toString());
        datos.add(iva.toString());
        datos.add(String.valueOf(totalFactura));
        return datos;
    }

    public Vector<String> convertirVectorFactura() {
        Vector<String> datos = new Vector<>();
        datos.add(String.valueOf(codigoFactura));
        datos.add(idCliente.getId());
        datos.add(idCliente.getTipoId());
        datos.add(idCliente.getNombre());
        datos.add(estado);
        datos.add(String.valueOf(totalFactura));
        datos.add(adelanto.toString());
        datos.add(String.valueOf(totalFactura - adelanto));
        return datos;
    }

}
