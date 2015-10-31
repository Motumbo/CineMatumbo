package Modelo.Dao;

import Modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario_Dao extends DB implements Interface_Dao<Usuario> {

    @Override
    public Usuario agregar(Usuario entidad) {
        if (!this.existe(entidad)) {
            try {
                String query = "INSERT INTO tbl_usuarios (username, password, categoria, email) values(?, ?, ?, ?)";
                conectar();
                PreparedStatement ps = getConexion().prepareStatement(query);
                ps.setString(1, entidad.getUserName());
                ps.setString(2, entidad.getPass());
                ps.setString(3, entidad.getCategoria());
                ps.setString(4, entidad.getMail());
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
        if (!this.existe(entidad)) {
            try {
                String query = "UPDATE tbl_usuarios SET username = ?, password = ?, email = ? WHERE pk_usuario = ?";
                conectar();
                PreparedStatement ps = getConexion().prepareStatement(query);
                ps.setString(1, entidad.getUserName());
                ps.setString(2, entidad.getPass());
                ps.setString(3, entidad.getMail());
                ps.setInt(4, entidad.getIdUsuario());
                ps.execute();
                desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return entidad;
    }

    public Usuario modificarDesdeGestion(Usuario entidad) {
        try {
            String query = "UPDATE tbl_usuarios SET username = ?, categoria = ?, email = ? WHERE pk_usuario = ?";
            conectar();
            PreparedStatement ps = getConexion().prepareStatement(query);
            ps.setString(1, entidad.getUserName());
            ps.setString(2, entidad.getCategoria());
            ps.setString(3, entidad.getMail());
            ps.setInt(4, entidad.getIdUsuario());
            ps.execute();
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entidad;
    }

    @Override
    public void borrar(Usuario entidad) {
        if (!this.existe(entidad)) {
            try {
                String query = "DELETE FROM tbl_usuarios WHERE pk_usuario = ?";
                conectar();
                PreparedStatement ps = getConexion().prepareStatement(query);
                ps.setInt(1, entidad.getIdUsuario());
                ps.execute();
                desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public ArrayList<Usuario> dameAll() {
        ArrayList listaUsuarios = new ArrayList();
        try {
            conectar();
            setSentencia(getConexion().createStatement());
            setResultado(getSentencia().executeQuery("SELECT * FROM tbl_usuarios"));
            while (getResultado().next()) {
                Usuario entidad = new Usuario();
                entidad.setIdUsuario(getResultado().getInt("pk_usuario"));
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
    public Usuario dameXId(String id) {
        Usuario entidad = new Usuario();
        try {
            String query = "SELECT * FROM tbl_usuarios WHERE username = ?";
            conectar();
            PreparedStatement ps = getConexion().prepareStatement(query);
            ps.setString(1, id);
            setResultado(ps.executeQuery());
            while (getResultado().next()) {
                entidad.setIdUsuario(getResultado().getInt("pk_usuario"));
                entidad.setUserName(getResultado().getString("username"));
                entidad.setPass(getResultado().getString("password"));
                entidad.setCategoria(getResultado().getString("categoria"));
                entidad.setMail(getResultado().getString("email"));
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (entidad);
    }

    public Usuario dameXId(int id) {
        Usuario entidad = new Usuario();
        try {
            String query = "SELECT * FROM tbl_usuarios WHERE pk_usuario = ?";
            conectar();
            PreparedStatement ps = getConexion().prepareStatement(query);
            ps.setInt(1, id);
            setResultado(ps.executeQuery());
            while (getResultado().next()) {
                entidad.setIdUsuario(getResultado().getInt("pk_usuario"));
                entidad.setUserName(getResultado().getString("username"));
                entidad.setPass(getResultado().getString("password"));
                entidad.setCategoria(getResultado().getString("categoria"));
                entidad.setMail(getResultado().getString("email"));
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (entidad);
    }

    @Override
    public boolean existe(Usuario entidad) {
        String p = "";
        try {
            String query = "SELECT * FROM tbl_usuarios WHERE username = ?";
            conectar();
            PreparedStatement ps = getConexion().prepareStatement(query);
            ps.setString(1, entidad.getUserName());
            setResultado(ps.executeQuery());
            while (getResultado().next()) {
            p = getResultado().getString("username");
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (!"".equals(p));
    }

}
