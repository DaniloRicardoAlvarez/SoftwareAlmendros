package com.almendros.model.entity;

import com.almendros.model.entity.Factura;
import com.almendros.model.entity.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-20T17:10:14")
@StaticMetamodel(DetalleVenta.class)
public class DetalleVenta_ { 

    public static volatile SingularAttribute<DetalleVenta, Double> precioUnitario;
    public static volatile SingularAttribute<DetalleVenta, Integer> codigoVenta;
    public static volatile SingularAttribute<DetalleVenta, Factura> facturaCodigo;
    public static volatile SingularAttribute<DetalleVenta, Double> totalVenta;
    public static volatile SingularAttribute<DetalleVenta, Producto> productoCodigo;
    public static volatile SingularAttribute<DetalleVenta, Double> cantidad;

}