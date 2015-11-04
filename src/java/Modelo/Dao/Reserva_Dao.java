/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Reserva;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Feto
 */
public class Reserva_Dao extends DB implements Interface_Dao<Reserva>{

    @Override
    public Reserva agregar(Reserva entidad) {
         if (!this.existe(entidad)) {
            try {
                String query = "INSERT INTO tbl_reservas (horario_inicio, fk_sala, fk_pelicula) values(?, ?, ?)";
                conectar();
                PreparedStatement ps = getConexion().prepareStatement(query);
                ps.setTimestamp(1, entidad.getFechaHoraInicio());
                ps.setInt(2, entidad.getIdSalaAlQuePertenece());
                ps.setInt(3, entidad.getPelicula().getIdPelicula());
                ps.execute();
                desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return entidad;
    }

    @Override
    public Reserva modificar(Reserva entidad) {
        try {
            String query = "SELECT * FROM tbl_reservas WHERE horario_inicio = ?";
            conectar();
            PreparedStatement ps = getConexion().prepareStatement(query);
            ps.setInt(1, entidad.getIdFuncion());
            setResultado(ps.executeQuery());
            while (getResultado().next()) {
                entidad.setIdFuncion(getResultado().getInt("pk_funcion"));
                entidad.setFechaHoraInicio(getResultado().getTimestamp("horario_inicio")); //ESTE GET.TIMESTAMP RECIBE UN INT COMO PARAMETRO
                entidad.setIdSalaAlQuePertenece(getResultado().getInt("fk_sala"));
                entidad.getPelicula().setIdPelicula((getResultado().getInt("fk_pelicula"))); 
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (entidad);
    }

    @Override
    public void borrar(Reserva entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Reserva> dameAll() {
        ArrayList listaReservaciones = new ArrayList();
        try {
            conectar();
            setSentencia(getConexion().createStatement());
            setResultado(getSentencia().executeQuery("SELECT * FROM tbl_reservas"));
            while (getResultado().next()) {
                Reserva entidad = new Reserva();
                entidad.setIdFuncion(getResultado().getInt("pk_funcion"));
                entidad.setIdSalaAlQuePertenece(getResultado().getInt("fk_sala"));
                entidad.getPelicula().setIdPelicula(getResultado().getInt("fk_pelicula"));
                entidad.setFechaHoraInicio(getResultado().getTimestamp("horario_inicio")); //ESTE GET.TIMESTAMP RECIBE UN INT COMO PARAMETRO
                listaReservaciones.add(entidad);
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaReservaciones;
    }

    @Override
    public Reserva dameXId(String id) {
        Reserva entidad = new Reserva();
        try {
            String query = "SELECT * FROM tbl_reservas WHERE horario_inicio = ?";
            conectar();
            PreparedStatement ps = getConexion().prepareStatement(query);
            ps.setString(1, id);
            setResultado(ps.executeQuery());
            while (getResultado().next()) {
                entidad.setIdFuncion(getResultado().getInt("pk_funcion"));
                entidad.setFechaHoraInicio(getResultado().getTimestamp("horario_inicio")); //ESTE GET.TIMESTAMP RECIBE UN INT COMO PARAMETRO
                entidad.setIdSalaAlQuePertenece(getResultado().getInt("fk_sala"));
                entidad.getPelicula().setIdPelicula((getResultado().getInt("fk_pelicula"))); 
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (entidad);
    }

    @Override
    public boolean existe(Reserva entidad) {
        String p = "";
        try {
            String query = "SELECT * FROM tbl_reservas WHERE fk_sala = ? and fk_pelicula = ? and horario_inicio = ?";
            conectar();
            PreparedStatement ps = getConexion().prepareStatement(query);
            
            ps.setInt(1, entidad.getIdSalaAlQuePertenece());
            ps.setInt(2, entidad.getPelicula().getIdPelicula());
            ps.setTimestamp(3, entidad.getFechaHoraInicio());
            
            setResultado(ps.executeQuery());
            while (getResultado().next()) {
                p = String.valueOf(getResultado().getInt("pk_funcion"));
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (!"".equals(p));
    }
    
}
