package Modelo.Dao;

import Modelo.Sala;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sala_Dao extends DB implements Interface_Dao<Sala> {

    @Override
    public Sala agregar(Sala entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Sala agregar(Sala entidad, int id_cine) {
        if (!this.nombreRepetidoSalaEnUnMismoCine(entidad, id_cine)) {
            try {
                String query = "INSERT INTO tbl_salas (nombre, filas, columnas, tiempo_limpieza, fk_cine) VALUES (?, ?, ?, ?, ?)";
                conectar();
                PreparedStatement ps = getConexion().prepareStatement(query);
                ps.setString(1, entidad.getNombre());
                ps.setInt(2, entidad.getFilas());
                ps.setInt(3, entidad.getColumnas());
                ps.setInt(4, entidad.getTiempoLimpieza());
                ps.setInt(5, id_cine);
                ps.execute();
                desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return entidad;
    }

    @Override
    public Sala modificar(Sala entidad) { //ESTO NO FUNCIONA PORQUE NO SABE IDENTIFICAR DE QUE CINE ES, Y LOS NOMBRES DE LAS SALAS PUEDEN ESTAR REPETIDOS
        if (this.existe(entidad)) {
            try {
                String query = "UPDATE tbl_salas SET nombre = ?, filas = ?, columnas = ?, tiempo_limpieza = ? WHERE pk_sala = ?";
                conectar();
                PreparedStatement ps = getConexion().prepareStatement(query);
                ps.setString(1, entidad.getNombre());
                ps.setInt(2, entidad.getFilas());
                ps.setInt(3, entidad.getColumnas());
                ps.setInt(4, entidad.getTiempoLimpieza());
                ps.setInt(5, entidad.getIdSala());
                ps.execute();
                desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return entidad;
    }

    @Override
    public void borrar(Sala entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Sala> dameAll() {
        ArrayList listaSalas = new ArrayList<Sala>();
        Sala entidad = new Sala();
        try {
            conectar();
            setSentencia(getConexion().createStatement());
            setResultado(getSentencia().executeQuery("SELECT * FROM tbl_salas"));
            while (getResultado().next()) {
                entidad.setIdSala(getResultado().getInt("pk_sala"));
                entidad.setNombre(getResultado().getString("nombre"));
                entidad.setFilas(getResultado().getInt("filas"));
                entidad.setColumnas(getResultado().getInt("columnas"));
                entidad.setTiempoLimpieza(getResultado().getInt("tiempo_limpieza"));
                listaSalas.add(entidad);
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaSalas;
    }

    public ArrayList<Sala> dameSalasCine(int fk_IdCine) {
        ArrayList<Sala> salasDeUnCine = new ArrayList<Sala>();
        Sala entidad = new Sala();
        try {
            String query = "SELECT * FROM tbl_salas WHERE fk_cine = ?";
            conectar();
            PreparedStatement ps = getConexion().prepareStatement(query);
            ps.setInt(1, fk_IdCine);
            setResultado(ps.executeQuery());
            while (getResultado().next()) {
                entidad.setIdSala(getResultado().getInt("pk_sala"));
                entidad.setNombre(getResultado().getString("nombre"));
                entidad.setFilas(getResultado().getInt("filas"));
                entidad.setColumnas(getResultado().getInt("columnas"));
                entidad.setTiempoLimpieza(getResultado().getInt("tiempo_limpieza"));
                salasDeUnCine.add(entidad);
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salasDeUnCine;
    }

    @Override
    public Sala dameXId(String id) {
        Sala entidad = new Sala();
        try {
            String query = "SELECT * FROM tbl_salas WHERE nombre = ? ";
            conectar();
            PreparedStatement ps = getConexion().prepareStatement(query);
            ps.setString(1, id);
            setResultado(ps.executeQuery());
            while (getResultado().next()) {
                entidad.setIdSala(getResultado().getInt("pk_sala"));
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
            String query = "SELECT nombre FROM tbl_salas WHERE nombre = ? ";
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

    public boolean nombreRepetidoSalaEnUnMismoCine(Sala entidad, int id_cine) {
        String p = "";
        try {
            String query = "SELECT nombre FROM tbl_salas WHERE nombre = ? AND fk_cine = ? ";
            conectar();
            PreparedStatement ps = getConexion().prepareStatement(query);
            ps.setString(1, entidad.getNombre());
            ps.setInt(2, id_cine);
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
