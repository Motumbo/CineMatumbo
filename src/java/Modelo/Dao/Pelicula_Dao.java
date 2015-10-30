package Modelo.Dao;

import Modelo.Pelicula;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pelicula_Dao extends DB implements Interface_Dao<Pelicula> {

    @Override
    public Pelicula agregar(Pelicula entidad) {
        if (!this.existe(entidad)) {
            try {
                String query = "INSERT INTO tbl_peliculas (nombre, genero, clasificacion, duracion, imagen) VALUES (?, ?, ?, ?, ?)";
                conectar();
                PreparedStatement ps = getConexion().prepareStatement(query);
                ps.setString(1, entidad.getNombre());
                ps.setString(2, entidad.getGenero());
                ps.setString(3, entidad.getClasificacion());
                ps.setInt(4, entidad.getDuracion());
                ps.setString(5, entidad.getImagen());
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
                String query = "UPDATE tbl_peliculas SET nombre = ?, genero = ?, clasificacion = ?, duracion = ?, imagen = ? WHERE pk_pelicula = ?";
                conectar();
                PreparedStatement ps = getConexion().prepareStatement(query);
                ps.setString(1, entidad.getNombre());
                ps.setString(2, entidad.getGenero());
                ps.setString(3, entidad.getClasificacion());
                ps.setInt(4, entidad.getDuracion());
                ps.setString(5, entidad.getImagen());
                ps.setInt(6, entidad.getIdPelicula());
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
                String query = "DELETE FROM tbl_peliculas WHERE pk_pelicula = ?";
                conectar();
                PreparedStatement ps = getConexion().prepareStatement(query);
                ps.setInt(1, entidad.getIdPelicula());
                ps.execute();
                desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public ArrayList<Pelicula> dameAll() {
        ArrayList<Pelicula> listaPeliculas = new ArrayList();
        try {
            conectar();
            setSentencia(getConexion().createStatement());
            setResultado(getSentencia().executeQuery("SELECT * FROM tbl_peliculas"));
            while (getResultado().next()) { 
                Pelicula entidad = new Pelicula();
                entidad.setIdPelicula(getResultado().getInt("pk_pelicula"));
                entidad.setNombre(getResultado().getString("nombre"));
                entidad.setGenero(getResultado().getString("genero"));
                entidad.setClasificacion(getResultado().getString("clasificacion"));
                entidad.setDuracion(getResultado().getInt("duracion"));
                entidad.setImagen(getResultado().getString("imagen"));
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
            String query = "SELECT * FROM tbl_peliculas WHERE nombre = ?";
            conectar();
            PreparedStatement ps = getConexion().prepareStatement(query);
            ps.setString(1, id);
            setResultado(ps.executeQuery());
            while (getResultado().next()) {
                entidad.setIdPelicula(getResultado().getInt("pk_pelicula"));
                entidad.setNombre(getResultado().getString("nombre"));
                entidad.setGenero(getResultado().getString("genero"));
                entidad.setClasificacion(getResultado().getString("clasificacion"));
                entidad.setDuracion(getResultado().getInt("duracion"));
                entidad.setImagen(getResultado().getString("imagen"));
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
            String query = "SELECT nombre FROM tbl_peliculas WHERE nombre = ?";
            conectar();
            PreparedStatement ps = getConexion().prepareStatement(query);
            ps.setString(1, entidad.getNombre());
            setResultado(ps.executeQuery());
            while (getResultado().next()) {
                p = getResultado().getString("nombre");
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (!"".equals(p));
    }

}
