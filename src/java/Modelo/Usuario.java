package Modelo;

import Modelo.Dao.Usuario_Dao;
import java.util.ArrayList;

public class Usuario {

    private int _idUsuario;
    private String _userName;
    private String _pass;
    private String _categoria;
    private String _mail;

    public Usuario() {
        setIdUsuario(0);
        setUserName("");
        setPass("");
        setCategoria("");
        setMail("");
    }

    public Usuario(String newUsername, String newPassword) {
        setIdUsuario(0);
        setUserName(newUsername);
        setPass(newPassword);
        setCategoria("");
        setMail("");
    }

    public Usuario(String newUsername, String newPassword, String newMail) {
        setIdUsuario(0);
        setUserName(newUsername);
        setPass(newPassword);
        setCategoria("cliente");
        setMail(newMail);
    }

    public int getIdUsuario() {
        return _idUsuario;
    }

    public void setIdUsuario(int _idUsuario) {
        this._idUsuario = _idUsuario;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        this._userName = userName;
    }

    public String getPass() {
        return _pass;
    }

    public void setPass(String pass) {
        this._pass = pass;
    }

    public String getCategoria() {
        return _categoria;
    }

    public void setCategoria(String _categoria) {
        this._categoria = _categoria;
    }

    public String getMail() {
        return _mail;
    }

    public void setMail(String _mail) {
        this._mail = _mail;
    }

    public Usuario validarLogIn(String newUsername, String newPassword) {
        Usuario logInUser = new Usuario();
        logInUser = this.buscarUsuario(newUsername);
        if (logInUser.getPass() == newPassword) {
            return logInUser;
        } else {
            return null;
        }
    }

    ////////////////////////////////////////////// METODOS DE ALMACENAMIENTO CON Usuario_Dao DB /////////////////////////////////////////////////////////////////
    private Usuario_Dao _datos = new Usuario_Dao();
    private ArrayList<Usuario> _listaUsuarios = new ArrayList<Usuario>();

    public void agregarUsuario(Usuario user) {
        if (!user.existe(user)) {
            _datos.agregar(user);
        }
    }

    public void modificarUsuario(Usuario user) {
        if (this.getCategoria() != "admin") {
            _datos.modificar(user);
        }
    }

    public void borrarUsuario(Usuario user) {
        if (this.getCategoria() != "admin") {
            _datos.borrar(user);
        }
    }

    public ArrayList<Usuario> dameListaTodos() {
        _listaUsuarios = _datos.dameAll();
        return _listaUsuarios;
    }

    public Usuario buscarUsuario(String username) {
        return _datos.dameXId(username);
    }

    public boolean existe(Usuario user) {
        return _datos.existe(user);
    }

    ////////////////////////////////////////////// METODOS DE ALMACENAMIENTO CON Usuario_Dao DB /////////////////////////////////////////////////////////////////
}
