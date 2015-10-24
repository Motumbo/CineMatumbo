/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Feto
 */
public class Usuario_Dao extends DB implements Interface_Dao<Integer, Usuario>{

    @Override
    public Usuario agregar(Usuario entidad) {
        if (!this.existe(entidad)) {
            try {
                String query = "insert into tbl_usuarios (username, password, categoria) values(?,?,?)";
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
    public Usuario modificar(Usuario entidad) {
        if (this.existe(entidad)) {
            try {
                String query = "update tbl_usuarios set password = ? and set categoria = ? where username = ?";
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
    public void borrar(Usuario entidad) {      
        if (!this.existe(entidad)) {
            try {
                String query = "DELETE FROM tbl_usuarios WHERE username = ?";
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
    public HashMap<Integer, Usuario> DameAll() {
        HashMap tablaHash = new HashMap();
        Usuario user = new Usuario();
        try {
            conectar();
            setSentencia(getConexion().createStatement());            
            setResultado( getSentencia().executeQuery("SELECT * FROM tbl_usuarios"));
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
    public Usuario dameXId(String id) {
        Usuario user = new Usuario();
        try {
            String query = "select username from tbl_usuarios where username = ? ;";
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
    public boolean existe(Usuario entidad) {
        String p = "";
        try {
            String query = "select username from tbl_usuarios where username = ? ;";
            conectar();
            PreparedStatement ps = super.getConexion().prepareStatement(query);
            ps.setString(1, entidad.getUserName());
            super.setResultado(ps.executeQuery());
            while (super.getResultado().next()) {
                p = super.getResultado().getString("username");
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (!"".equals(p));
    }

}
