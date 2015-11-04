/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Funcion;
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
public class Funcion_Dao extends DB implements Interface_Dao<Funcion>{

    @Override
    public Funcion agregar(Funcion entidad) {
        if (!this.existe(entidad)) {
            try {
                String query = "INSERT INTO tbl_funciones (horario_inicio, fk_sala, fk_pelicula) values(?, ?, ?)";
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
    public Funcion modificar(Funcion entidad) {
        try {
            String query = "SELECT * FROM tbl_funciones WHERE horario_inicio = ?";
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
    public void borrar(Funcion entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Funcion> dameAll() {
        ArrayList listaFunciones = new ArrayList();
        try {
            conectar();
            setSentencia(getConexion().createStatement());
            setResultado(getSentencia().executeQuery("SELECT * FROM tbl_funciones"));
            while (getResultado().next()) {
                Funcion entidad = new Funcion();
                entidad.setIdFuncion(getResultado().getInt("pk_funcion"));
                entidad.setIdSalaAlQuePertenece(getResultado().getInt("fk_sala"));
                entidad.getPelicula().setIdPelicula(getResultado().getInt("fk_pelicula"));
                entidad.setFechaHoraInicio(getResultado().getTimestamp("horario_inicio")); //ESTE GET.TIMESTAMP RECIBE UN INT COMO PARAMETRO
                listaFunciones.add(entidad);
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaFunciones;
    }

    @Override
    public Funcion dameXId(String id) {     /////////////////////// CUAL VA A SER EL ARGUMENTO DE BUSQUEDA DE UNA FUNCION??????????
        Funcion entidad = new Funcion();
        try {
            String query = "SELECT * FROM tbl_funciones WHERE horario_inicio = ?";
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
    
    public Funcion dameXId(int idSala, int idPelicula) { 
        Funcion entidad = new Funcion();
        try {
            String query = "SELECT * FROM tbl_funciones where fk_sala = ? and where fk_pelicula";
            conectar();
            PreparedStatement ps = getConexion().prepareStatement(query);
            ps.setInt(1, idSala);
            ps.setInt(2, idPelicula);
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
    
    public ArrayList<Funcion> dameFuncionesXHorario(Timestamp horarioInicioFuncion) {
        ArrayList listaFunciones = new ArrayList();
        try {
            String query = "SELECT * FROM tbl_funciones where horario_inicio = ?";
            conectar();
            PreparedStatement ps = getConexion().prepareStatement(query);
            ps.setTimestamp(1, horarioInicioFuncion);
            setResultado(ps.executeQuery());
            while (getResultado().next()) {
                Funcion entidad = new Funcion();
                entidad.setIdFuncion(getResultado().getInt("pk_funcion"));
                entidad.setIdSalaAlQuePertenece(getResultado().getInt("fk_sala"));
                entidad.getPelicula().setIdPelicula(getResultado().getInt("fk_pelicula"));
                entidad.setFechaHoraInicio(getResultado().getTimestamp("horario_inicio")); //ESTE GET.TIMESTAMP RECIBE UN INT COMO PARAMETRO
                listaFunciones.add(entidad);
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaFunciones;
    }
    
    public ArrayList<Funcion> dameFuncionesXPelicula(int idPelicula) {
        ArrayList listaFunciones = new ArrayList();
        try {
            String query = "SELECT * FROM tbl_funciones where fk_pelicula = ?";
            conectar();
            PreparedStatement ps = getConexion().prepareStatement(query);
            ps.setInt(1, idPelicula);
            setResultado(ps.executeQuery());
            while (getResultado().next()) {
                Funcion entidad = new Funcion();
                entidad.setIdFuncion(getResultado().getInt("pk_funcion"));
                entidad.setIdSalaAlQuePertenece(getResultado().getInt("fk_sala"));
                entidad.getPelicula().setIdPelicula(getResultado().getInt("fk_pelicula"));
                entidad.setFechaHoraInicio(getResultado().getTimestamp("horario_inicio")); //ESTE GET.TIMESTAMP RECIBE UN INT COMO PARAMETRO
                listaFunciones.add(entidad);
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaFunciones;
    }
    
    public ArrayList<Funcion> dameFuncionesXPelicula(String nombrePelicula) {
        ArrayList listaFunciones = new ArrayList();
        try {
            String query = "SELECT * FROM tbl_funciones where fk_pelicula = (Select pk_pelicula from tbl_peliculas where nombre = ?)"; // VERIFICAR ESTA ASQUEROSIDAD
            conectar();
            PreparedStatement ps = getConexion().prepareStatement(query);
            ps.setString(1, nombrePelicula);
            setResultado(ps.executeQuery());
            while (getResultado().next()) {
                Funcion entidad = new Funcion();
                entidad.setIdFuncion(getResultado().getInt("pk_funcion"));
                entidad.setIdSalaAlQuePertenece(getResultado().getInt("fk_sala"));
                entidad.getPelicula().setIdPelicula(getResultado().getInt("fk_pelicula"));
                entidad.setFechaHoraInicio(getResultado().getTimestamp("horario_inicio")); //ESTE GET.TIMESTAMP RECIBE UN INT COMO PARAMETRO
                listaFunciones.add(entidad);
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaFunciones;
    }
    
    public ArrayList<Funcion> dameFuncionesXCine(int idCine) {
        ArrayList listaFunciones = new ArrayList();
        try {
            String query = "SELECT * FROM tbl_funciones where fk_cine = ?"; // NOOOOOO ACA HAY QUE BUSCAR DE OTRA MANERA
            conectar();
            PreparedStatement ps = getConexion().prepareStatement(query);
            ps.setInt(1, idCine);
            setResultado(ps.executeQuery());
            while (getResultado().next()) {
                Funcion entidad = new Funcion();
                entidad.setIdFuncion(getResultado().getInt("pk_funcion"));
                entidad.setIdSalaAlQuePertenece(getResultado().getInt("fk_sala"));
                entidad.getPelicula().setIdPelicula(getResultado().getInt("fk_pelicula"));
                entidad.setFechaHoraInicio(getResultado().getTimestamp("horario_inicio")); //ESTE GET.TIMESTAMP RECIBE UN INT COMO PARAMETRO
                listaFunciones.add(entidad);
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaFunciones;
    }
    
    public ArrayList<Funcion> dameFuncionesXSala(int idSala) {
        ArrayList listaFunciones = new ArrayList();
        try {
            String query = "SELECT * FROM tbl_funciones where fk_sala = ?";
            conectar();
            PreparedStatement ps = getConexion().prepareStatement(query);
            ps.setInt(1, idSala);
            setResultado(ps.executeQuery());
            while (getResultado().next()) {
                Funcion entidad = new Funcion();
                entidad.setIdFuncion(getResultado().getInt("pk_funcion"));
                entidad.setIdSalaAlQuePertenece(getResultado().getInt("fk_sala"));
                entidad.getPelicula().setIdPelicula(getResultado().getInt("fk_pelicula"));
                entidad.setFechaHoraInicio(getResultado().getTimestamp("horario_inicio")); //ESTE GET.TIMESTAMP RECIBE UN INT COMO PARAMETRO
                listaFunciones.add(entidad);
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaFunciones;
    }

    @Override
    public boolean existe(Funcion entidad) {
        String p = "";
        try {
            String query = "SELECT * FROM tbl_funciones WHERE fk_sala = ? and fk_pelicula = ? and horario_inicio = ?";
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
