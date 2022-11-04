package com.almendros.model.entity;

import com.almendros.model.entity.Factura;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-20T17:10:14")
@StaticMetamodel(TipoVenta.class)
public class TipoVenta_ { 

    public static volatile SingularAttribute<TipoVenta, String> tipoVenta;
    public static volatile ListAttribute<TipoVenta, Factura> facturaList;
    public static volatile SingularAttribute<TipoVenta, Integer> idTipo;

}