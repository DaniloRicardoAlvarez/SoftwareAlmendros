package com.almendros.model.entity;

import com.almendros.model.entity.Categoria;
import com.almendros.model.entity.DetalleVenta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-20T17:10:13")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> caracteristicas;
    public static volatile SingularAttribute<Producto, Integer> estado;
    public static volatile ListAttribute<Producto, DetalleVenta> detalleVentaList;
    public static volatile SingularAttribute<Producto, String> producto;
    public static volatile SingularAttribute<Producto, Integer> codigoProducto;
    public static volatile SingularAttribute<Producto, Integer> stock;
    public static volatile SingularAttribute<Producto, Categoria> idCategoria;

}