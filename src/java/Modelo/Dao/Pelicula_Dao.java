/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Pelicula;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Feto
 */

public class Pelicula_Dao extends DB implements Interface_Dao<Integer, Pelicula>{

    @Override
    public Pelicula agregar(Pelicula entidad) {
        if (!this.existe(entidad)) {
            try {
                String query = "insert into tbl_usuario (username, password, categoria) values(?,?,?)";//CAMBIAR STRING QUERY MySQL
                conectar();
                PreparedStatement ps = getConexion().prepareStatement(query);
                ps.setString(1, entidad.getUserName());
                ps.setString(2, entidad.getPass());
                ps.setString(3, entidad.getCategoria());
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
                String query = "update tbl_usuario set password = ? and set categoria = ? where username = ?";//CAMBIAR STRING QUERY MySQL
                conectar();
                PreparedStatement ps = getConexion().prepareStatement(query);
                ps.setString(1, entidad.getPass());
                ps.setString(2, entidad.getCategoria());
                ps.setString(3, entidad.getUserName());  
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
                String query = "DELETE FROM tbl_usuarios WHERE username = ?";//CAMBIAR STRING QUERY MySQL
                conectar();
                PreparedStatement ps = getConexion().prepareStatement(query);
                ps.setString(1, entidad.getUserName());
                ps.execute();
                desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public HashMap<Integer, Pelicula> DameAll() {
        HashMap tablaHash = new HashMap();
        Pelicula user = new Pelicula();
        try {
            conectar();
            setSentencia(getConexion().createStatement());            
            setResultado( getSentencia().executeQuery("SELECT * FROM tbl_usuarios"));//CAMBIAR STRING QUERY MySQL
            while(getResultado().next()){
                
                user.setId_usuario(getResultado().getInt("pk_usuario"));
                user.setUserName(getResultado().getString("username"));
                user.setCategoria(getResultado().getString("categoria"));
                
                tablaHash.put(user.getId_usuario(), user);
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tablaHash;
    }

    @Override
    public Pelicula dameXId(String id) {
        Pelicula user = new Pelicula();
        try {
            String query = "select username from tbl_usuarios where username = ? ;"; //CAMBIAR STRING QUERY MySQL
            conectar();
            PreparedStatement ps = super.getConexion().prepareStatement(query);
            ps.setString(1, id.toString());
            super.setResultado(ps.executeQuery());
            while (super.getResultado().next()) {
                user.setUserName(super.getResultado().getString("username"));
                user.setPass(super.getResultado().getString("password"));
                user.setCategoria(super.getResultado().getString("categoria"));
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (user);
    }

    @Override
    public boolean existe(Pelicula entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
