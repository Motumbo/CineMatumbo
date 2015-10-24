/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Sala;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Feto
 */
public class Sala_Dao extends DB implements Interface_Dao<Sala> {

    @Override
    public Sala agregar(Sala entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sala modificar(Sala entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(Sala entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Sala> dameAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<Sala> dameSalasCine(String nombreCine) {
        ArrayList <Sala> salasDeUnCine = new ArrayList<Sala>();
            
        return salasDeUnCine;
    }
    
    @Override
    public Sala dameXId(String id) {
        Sala entidad = new Sala();
        try {
            String query = "select * from tbl_salas where nombre = ? ;"; 
            conectar();
            PreparedStatement ps = super.getConexion().prepareStatement(query);
            ps.setString(1, id.toString());
            super.setResultado(ps.executeQuery());
            while (super.getResultado().next()) {
                entidad.setId_sala(getResultado().getInt("pk_pelicula"));
                entidad.setNombre(getResultado().getString("nombre"));
                entidad.setFilas(getResultado().getInt("filas"));
                entidad.setColumnas(getResultado().getInt("columnas"));
                entidad.setTiempoLimpieza(getResultado().getInt("tiempo_limpieza"));
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (entidad);
    }

    @Override
    public boolean existe(Sala entidad) {
        String p = "";
        try {
            String query = "select nombre from tbl_salas where nombre = ? ;";
            conectar();
            PreparedStatement ps = super.getConexion().prepareStatement(query);
            ps.setString(1, entidad.getNombre());
            super.setResultado(ps.executeQuery());
            while (super.getResultado().next()) {
                p = super.getResultado().getString("nombre");
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (!"".equals(p));
    }
    
}
