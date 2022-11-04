package com.almendros.model.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Coders
 */
public class Conexion {
    
    private static Conexion conexion;
    private final EntityManagerFactory fabricaConexion;
    
    private Conexion() {
        fabricaConexion = Persistence.createEntityManagerFactory("SoftwareAlemendrosPU");
    }

    public static Conexion getConexion() {
        if (conexion == null) {
            conexion = new Conexion();
        }
        return conexion;
    }

    public EntityManagerFactory getFabricaConexion() {
        return fabricaConexion;
    }
    
    
    
}
