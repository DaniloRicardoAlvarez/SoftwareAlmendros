/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almendros.model.entity;

import java.io.Serializable;
import java.util.Vector;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author itachi
 */
@Entity
@Table(name = "DetalleVentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleVenta.findAll", query = "SELECT d FROM DetalleVenta d"),
    @NamedQuery(name = "DetalleVenta.findByCodigoVenta", query = "SELECT d FROM DetalleVenta d WHERE d.codigoVenta = :codigoVenta"),
    @NamedQuery(name = "DetalleVenta.findByPrecioUnitario", query = "SELECT d FROM DetalleVenta d WHERE d.precioUnitario = :precioUnitario"),
    @NamedQuery(name = "DetalleVenta.findByCantidad", query = "SELECT d FROM DetalleVenta d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleVenta.findByTotalVenta", query = "SELECT d FROM DetalleVenta d WHERE d.totalVenta = :totalVenta")})
public class DetalleVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_venta")
    private Integer codigoVenta;
    @Basic(optional = false)
    @Column(name = "precio_unitario")
    private double precioUnitario;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private double cantidad;
    @Basic(optional = false)
    @Column(name = "total_venta")
    private double totalVenta;
    @JoinColumn(name = "factura_codigo", referencedColumnName = "codigo_factura")
    @ManyToOne(optional = false)
    private Factura facturaCodigo;
    @JoinColumn(name = "producto_codigo", referencedColumnName = "codigo_producto")
    @ManyToOne(optional = false)
    private Producto productoCodigo;

    public DetalleVenta() {
    }

    public DetalleVenta(Integer codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public DetalleVenta(Integer codigoVenta, double precioUnitario, double cantidad, double totalVenta) {
        this.codigoVenta = codigoVenta;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.totalVenta = totalVenta;
    }

    public Integer getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(Integer codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public Factura getFacturaCodigo() {
        return facturaCodigo;
    }

    public void setFacturaCodigo(Factura facturaCodigo) {
        this.facturaCodigo = facturaCodigo;
    }

    public Producto getProductoCodigo() {
        return productoCodigo;
    }

    public void setProductoCodigo(Producto productoCodigo) {
        this.productoCodigo = productoCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoVenta != null ? codigoVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleVenta)) {
            return false;
        }
        DetalleVenta other = (DetalleVenta) object;
        if ((this.codigoVenta == null && other.codigoVenta != null) || (this.codigoVenta != null && !this.codigoVenta.equals(other.codigoVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.almendros.model.entity.DetalleVenta[ codigoVenta=" + codigoVenta + " ]";
    }
    
    public Vector<String> convertirVector() {
        Vector<String> datos = new Vector<>();
        datos.add(productoCodigo.getCodigoProducto().toString());
        datos.add(String.valueOf(cantidad));
        datos.add(productoCodigo.getCaracteristicas());
        datos.add(String.valueOf(precioUnitario));
        datos.add(String.valueOf(totalVenta));
        return datos;        
    }
    
}
