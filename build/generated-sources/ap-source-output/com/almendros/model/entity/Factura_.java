package com.almendros.model.entity;

import com.almendros.model.entity.Cliente;
import com.almendros.model.entity.DetalleVenta;
import com.almendros.model.entity.TipoVenta;
import com.almendros.model.entity.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-20T17:10:13")
@StaticMetamodel(Factura.class)
public class Factura_ { 

    public static volatile SingularAttribute<Factura, String> estado;
    public static volatile SingularAttribute<Factura, Date> fechaRegistro;
    public static volatile SingularAttribute<Factura, Double> adelanto;
    public static volatile SingularAttribute<Factura, Integer> codigoFactura;
    public static volatile SingularAttribute<Factura, Double> subTotal;
    public static volatile SingularAttribute<Factura, Date> fechaPago;
    public static volatile SingularAttribute<Factura, String> nombreCliente;
    public static volatile SingularAttribute<Factura, Double> totalFactura;
    public static volatile SingularAttribute<Factura, Cliente> idCliente;
    public static volatile SingularAttribute<Factura, Double> iva;
    public static volatile ListAttribute<Factura, DetalleVenta> detalleVentaList;
    public static volatile SingularAttribute<Factura, Usuario> idVendedor;
    public static volatile SingularAttribute<Factura, TipoVenta> idTipo;

}