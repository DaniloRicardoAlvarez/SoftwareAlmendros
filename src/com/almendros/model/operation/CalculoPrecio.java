/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almendros.model.operation;

import com.almendros.model.entity.Factura;
import java.util.ArrayList;

/**
 *
 * @author Family
 */
public class CalculoPrecio {
    
    public static double iva(ArrayList<Factura> list) {
        double iva = 0;
        for (Factura objFac : list) {
            iva += objFac.getIva();
        }
        return iva;
    }
    
    public static double subTotal(ArrayList<Factura> list) {
        double sub_tatal = 0;
        for (Factura objFac : list) {
            sub_tatal += objFac.getSubTotal();
        }
        return sub_tatal;
    }
    
    public static double total(ArrayList<Factura> list) {
        double total = 0;
        for (Factura objFac : list) {
            total += objFac.getTotalFactura();
        }
        return total;
    }
    
}
