/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Pelicula;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Feto
 */

public class Pelicula_Dao extends DB implements Interface_Dao<Pelicula>{

    @Override
    public Pelicula agregar(Pelicula entidad) {
        if (!this.existe(entidad)) {
            try {
                String query = "insert into tbl_peliculas (nombre, genero, clasificaion, duracion) values(?,?,?,?)";
                conectar();
                PreparedStatement ps = getConexion().prepareStatement(query);
                ps.setString(1, entidad.getNombre());
                ps.setString(2, entidad.getGenero());
                ps.setString(3, entidad.getClasificiacion());
                ps.setInt(4, entidad.getDuracion());  //ESTO VA A TRAER PROBLEMAS PORQUE EL TIPO DE DATO EN LA DB ES UN TIME Y EN MODELO.PELICULA ES UN INT
                ps.execute();
                desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return entidad;
    }

    @Override
    public Pelicula modificar(Pelicula entidad) {
        if (this.existe(entidad)) {
            try {
                String query = "update tbl_peliculas set genero = ? and set clasificacion = ? and set duracion = ? where nombre = ?";
                conectar();
                PreparedStatement ps = getConexion().prepareStatement(query);
                ps.setString(1, entidad.getGenero());
                ps.setString(2, entidad.getClasificiacion());
                ps.setInt(3, entidad.getDuracion());
                ps.setString(4, entidad.getNombre());
                ps.execute();
                desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return entidad;
    }

    @Override
    public void borrar(Pelicula entidad) {
        if (!this.existe(entidad)) {
            try {
                String query = "DELETE FROM tbl_peliculas WHERE nombre = ?";
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
    public ArrayList<Pelicula> dameAll() {
        ArrayList <Pelicula> listaPeliculas = new ArrayList();
        Pelicula entidad = new Pelicula();
        try {
            conectar();
            setSentencia(getConexion().createStatement());            
            setResultado( getSentencia().executeQuery("SELECT * FROM tbl_peliculas"));
            while(getResultado().next()){
                entidad.setId_pelicula(getResultado().getInt("pk_pelicula"));
                entidad.setNombre(getResultado().getString("nombre"));
                entidad.setGenero(getResultado().getString("genero"));
                entidad.setClasificiacion(getResultado().getString("clasificacion"));
                entidad.setDuracion(getResultado().getInt("duracion"));
                listaPeliculas.add(entidad);
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPeliculas;
    }

    @Override
    public Pelicula dameXId(String id) {
        Pelicula entidad = new Pelicula();
        try {
            String query = "select * from tbl_peliculas where nombre = ? ;"; 
            conectar();
            PreparedStatement ps = super.getConexion().prepareStatement(query);
            ps.setString(1, id.toString());
            super.setResultado(ps.executeQuery());
            while (super.getResultado().next()) {
                entidad.setId_pelicula(getResultado().getInt("pk_pelicula"));
                entidad.setNombre(getResultado().getString("nombre"));
                entidad.setGenero(getResultado().getString("genero"));
                entidad.setClasificiacion(getResultado().getString("clasificacion"));
                entidad.setDuracion(getResultado().getInt("duracion"));
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (entidad);
    }

    @Override
    public boolean existe(Pelicula entidad) {
        String p = "";
        try {
            String query = "select nombre from tbl_peliculas where nombre = ? ;";
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
