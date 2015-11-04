package Modelo.Dao;

import Modelo.Cine;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cine_Dao extends DB implements Interface_Dao<Cine> {

    @Override
    public Cine agregar(Cine entidad) {
        if (!this.existe(entidad)) {
            try {
                String query = "INSERT INTO tbl_cines (nombre, ciudad) VALUES (?, ?)";
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
        try {
            String query = "UPDATE tbl_cines SET nombre = ?, ciudad = ? WHERE pk_cine = ?";
            conectar();
            PreparedStatement ps = getConexion().prepareStatement(query);
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getCiudad());
            ps.setInt(3, entidad.getIdCine());
            ps.execute();
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);

        }
        return entidad;
    }

    @Override
    public void borrar(Cine entidad) {
        try {
            String query = "DELETE FROM tbl_cines WHERE pk_cine = ?";
            conectar();
            PreparedStatement ps = getConexion().prepareStatement(query);
            ps.setInt(1, entidad.getIdCine());
            ps.execute();
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Cine> dameAll() {
        ArrayList listaCines = new ArrayList();
        try {
            conectar();
            setSentencia(getConexion().createStatement());
            setResultado(getSentencia().executeQuery("SELECT * FROM tbl_cines"));
            while (getResultado().next()) {
                Cine entidad = new Cine();
                entidad.setIdCine(getResultado().getInt("pk_cine"));
                entidad.setNombre(getResultado().getString("nombre"));
                entidad.setCiudad(getResultado().getString("ciudad"));
                listaCines.add(entidad);
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCines;
    }

    @Override
    public Cine dameXId(String id) {
        Cine entidad = new Cine();
        try {
            String query = "SELECT * FROM tbl_cines WHERE nombre = ?";
            conectar();
            PreparedStatement ps = getConexion().prepareStatement(query);
            ps.setString(1, id);
            setResultado(ps.executeQuery());
            while (getResultado().next()) {
                entidad.setIdCine(getResultado().getInt("pk_cine"));
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
            String query = "SELECT nombre FROM tbl_cines WHERE nombre = ?";
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
