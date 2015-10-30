/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Funcion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                entidad.setIdFuncion(getResultado().getInt("pk_usuario"));
                entidad.setUserName(getResultado().getString("username"));
                entidad.setCategoria(getResultado().getString("categoria"));
                entidad.setMail(getResultado().getString("email"));
                listaUsuarios.add(entidad);
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaUsuarios;
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
                entidad.setFechaHoraInicio(getResultado().getTimestam("horario_inicio"))  /////////NO EXISTE UN GET TIMESTAMP QUE RECIBA UN TIMESTAMP COMO PARAMETRO DE ENTRADA
                entidad.setIdSalaAlQuePertenece(getResultado().getInt("fk_sala"));
                entidad.getPelicula().setIdPelicula((getResultado().getInt("fk_pelicula"))); 
//                      Î
// A ver si te das cuenta como mierda tuve que hacer aca para asignarle la mierda de id de la pelicula a tu mierda de funcion, directamente cambia la clase porongaes y ponele un id_Pelicula, que no necesita mas que eso.

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
            String query = "SELECT * FROM tbl_funciones WHERE horario_inicio = ?";
            conectar();
            PreparedStatement ps = getConexion().prepareStatement(query);
            ps.setString(1, id);
            setResultado(ps.executeQuery());
            while (getResultado().next()) {
                entidad.setIdFuncion(getResultado().getInt("pk_funcion"));
                entidad.setFechaHoraInicio(getResultado().getTimestam("horario_inicio"))  /////////NO EXISTE UN GET TIMESTAMP QUE RECIBA UN TIMESTAMP COMO PARAMETRO DE ENTRADA
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
