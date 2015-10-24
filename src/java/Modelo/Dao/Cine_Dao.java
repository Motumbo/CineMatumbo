/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Cine;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Feto
 */
public class Cine_Dao extends DB implements Interface_Dao<Cine>{

    @Override
    public Cine agregar(Cine entidad) {
        if (!this.existe(entidad)) {
            try {
                String query = "insert into tbl_cines (nombre, ciudad) values(?,?)";
                conectar();
                PreparedStatement ps = getConexion().prepareStatement(query);
                ps.setString(1, entidad.getNombre());
                ps.setString(2, entidad.getCiudad());
                ps.execute();
                desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return entidad;
    }

    @Override
    public Cine modificar(Cine entidad) {
        if (this.existe(entidad)) {
            try {
                String query = "update tbl_cines set ciudad = ? where nombre = ?";
                conectar();
                PreparedStatement ps = getConexion().prepareStatement(query);
                ps.setString(1, entidad.getCiudad());
                ps.setString(2, entidad.getNombre());
                ps.execute();
                desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return entidad;
    }

    @Override
    public void borrar(Cine entidad) {
        if (!this.existe(entidad)) {
            try {
                String query = "DELETE FROM tbl_cines WHERE nombre = ?";
                conectar();
                PreparedStatement ps = getConexion().prepareStatement(query);
                ps.setString(1, entidad.getNombre());
                ps.execute();
                desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public ArrayList<Cine> dameAll() {
        ArrayList listaPeliculas = new ArrayList<Cine>();
        Cine entidad = new Cine();
        try {
            conectar();
            setSentencia(getConexion().createStatement());            
            setResultado( getSentencia().executeQuery("SELECT * FROM tbl_cines"));
            while(getResultado().next()){
                entidad.setId_cine(getResultado().getInt("pk_pelicula"));
                entidad.setNombre(getResultado().getString("nombre"));
                entidad.setCiudad(getResultado().getString("ciudad"));
                listaPeliculas.add(entidad);
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPeliculas;
    }

    @Override
    public Cine dameXId(String id) {
        Cine entidad = new Cine();
        try {
            String query = "select * from tbl_cines where nombre = ? ;"; 
            conectar();
            PreparedStatement ps = super.getConexion().prepareStatement(query);
            ps.setString(1, id.toString());
            setResultado(ps.executeQuery());
            while(getResultado().next()){
                entidad.setId_cine(getResultado().getInt("pk_pelicula"));
                entidad.setNombre(getResultado().getString("nombre"));
                entidad.setCiudad(getResultado().getString("ciudad"));
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entidad;
    }

    @Override
    public boolean existe(Cine entidad) {
        String p = "";
        try {
            String query = "select nombre from tbl_cines where nombre = ? ;";
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
