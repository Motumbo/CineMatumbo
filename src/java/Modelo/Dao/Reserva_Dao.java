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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public ArrayList<Reserva> agregarListaReservas(ArrayList<Reserva> listaReservas) {
        ArrayList listaReservasExitosas = new ArrayList();
        
        // ESTA MIERDA DE METODO LLAMA A UNA TRANSACCION ALMACENADA EN EL SERVER, QUE VERIFICA SI EXISTE LA DISPONIBILIDAD Y LA GUARDA O AVISA QUE NO SE PUDO HACER.
        // LAS RESERVAS QUE FUERON EXITOSAS LAS VA GUARDANDO EN LA LISTA, PARA DISPONER DE ELLAS Y GENERAR UN TICKET DE RESERVA
        
        for (Reserva reserva : listaReservas) {
            listaReservasExitosas.add(this.agregar(reserva));
        }
        
        
        return listaReservasExitosas;
    }
    

    @Override
    public Reserva modificar(Reserva entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(Reserva entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Reserva> dameAll() {
        ArrayList listaFunciones = new ArrayList();
        try {
            conectar();
            setSentencia(getConexion().createStatement());
            setResultado(getSentencia().executeQuery("SELECT * FROM tbl_reservas"));
            while (getResultado().next()) {
                Reserva entidad = new Reserva();
                entidad.setIdReserva(getResultado().getInt("pk_reserva"));
                entidad.setAsiento(getResultado().getInt("asiento"));               
                entidad.getFuncion().setIdFuncion(getResultado().getInt("fk_funcion"));               
                entidad.getUsuarioPropietario().setIdUsuario(getResultado().getInt("fk_usuario"));
                listaFunciones.add(entidad);
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaFunciones;
    }
    
    public ArrayList<Reserva> dameMisReservasDeUnaMismaFuncion(int idUsuarioPropietario, int idFuncion) {
        ArrayList listaFunciones = new ArrayList();
        try {
            String query = "SELECT * FROM tbl_reservas where fk_propietario = ? and fk_funcion = ?";
            conectar();
            PreparedStatement ps = getConexion().prepareStatement(query);
            ps.setInt(1, idUsuarioPropietario);
            ps.setInt(2, idFuncion);
            setResultado(ps.executeQuery());
            while (getResultado().next()) {
                Reserva entidad = new Reserva();
                entidad.setIdReserva(getResultado().getInt("pk_reserva"));
                entidad.setAsiento(getResultado().getInt("asiento"));               
                entidad.getFuncion().setIdFuncion(getResultado().getInt("fk_funcion"));               
                entidad.getUsuarioPropietario().setIdUsuario(getResultado().getInt("fk_usuario"));
                listaFunciones.add(entidad);
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaFunciones;
    }
    
    public ArrayList<Reserva> dameTodasReservasDeUnaMismaFuncion(int idFuncion) {
        ArrayList listaFunciones = new ArrayList();
        try {
            String query = "SELECT * FROM tbl_reservas where fk_funcion = ?";
            conectar();
            PreparedStatement ps = getConexion().prepareStatement(query);
            ps.setInt(1, idFuncion);
            setResultado(ps.executeQuery());
            while (getResultado().next()) {
                Reserva entidad = new Reserva();
                entidad.setIdReserva(getResultado().getInt("pk_reserva"));
                entidad.setAsiento(getResultado().getInt("asiento"));               
                entidad.getFuncion().setIdFuncion(getResultado().getInt("fk_funcion"));               
                entidad.getUsuarioPropietario().setIdUsuario(getResultado().getInt("fk_usuario"));
                listaFunciones.add(entidad);
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaFunciones;
    }

    @Override
    public Reserva dameXId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    public Reserva dameXId(int id) {
        Reserva entidad = new Reserva();
        try {
            String query = "SELECT * FROM tbl_reservas WHERE pk_reserva = ?";
            conectar();
            PreparedStatement ps = getConexion().prepareStatement(query);
            ps.setInt(1, id);
            setResultado(ps.executeQuery());
            while (getResultado().next()) {
                entidad.setIdReserva(getResultado().getInt("pk_reserva"));
                entidad.setAsiento(getResultado().getInt("asiento"));
                entidad.getUsuarioPropietario().setIdUsuario(getResultado().getInt("fk_usuario"));
                entidad.getFuncion().setIdFuncion(getResultado().getInt("fk_funcion"));

            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (entidad);
    }

    @Override
    public boolean existe(Reserva entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
