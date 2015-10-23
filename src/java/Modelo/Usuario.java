/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Dao.Usuario_Dao;
import java.util.HashMap;

/**
 *
 * @author Usuario
 */
public class Usuario {


    private int _id_usuario;
    private String _userName;
    private String _pass;
    private String _categoria;
    private String _mail;
    
    
    public Usuario() {
        
    }
    
    public Usuario(String newUsername, String newPassword) {
        setUserName(newUsername);
        setPass(newPassword);
    }
    
    public Usuario(String newUsername, String newPassword, String newMail) {
        setUserName(newUsername);
        setPass(newPassword);
        setMail(newMail);
        setCategoria("cliente");
    }
    
    public int getId_usuario() {
        return _id_usuario;
    }
    public void setId_usuario(int _id_usuario) {
        this._id_usuario = _id_usuario;
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
    
    
    public boolean passwordCorrecto(String newPassword){ //Imprementar algun tipo de criterio
        return true;
    }
    
    public boolean mailCorrecto(String newMail) { //Imprementar algun tipo de criterio
        return true;
    }
    
        public Usuario validarLogIn(String newUsername, String newPassword) { //Imprementar buscar y corroborar password
            Usuario logInUser = new Usuario();
            logInUser = this.buscarUsuario(newUsername);
            if (logInUser.getPass() == newPassword){
                return logInUser;
            }
            else{
                return null;
            }     
    }
    
    ////////////////////////////////////////////// METODOS DE ALMACENAMIENTO CON Usuario_Dao DB /////////////////////////////////////////////////////////////////
    
        
    private Usuario_Dao _datos = new Usuario_Dao();
    private HashMap<Integer, Usuario> _listaUsuarios = new HashMap<Integer, Usuario>();
    
    public void agregarUsuario (Usuario user){
        if((!user.existe(user)) && (user.passwordCorrecto(user.getPass()))) {
            _datos.agregar(user);
        }
    }
    
    public void modificarUsuario (Usuario user){
        if(this.getCategoria() != "admin"){
            _datos.modificar(user);
        } 
    }
    
    public void borrarUsuario (Usuario user){
        if(this.getCategoria() != "admin"){
            _datos.borrar(user);
        } 
    }
    
    public HashMap<Integer, Usuario> dameListaTodos (){
        _listaUsuarios = _datos.DameAll();
        return _listaUsuarios;
    }
    
    public Usuario buscarUsuario (String username){
        return _datos.dameXId(username);
    }
    
    public boolean existe (Usuario user){
        return _datos.existe(user);
    }
    
    
    ////////////////////////////////////////////// METODOS DE ALMACENAMIENTO CON Usuario_Dao DB /////////////////////////////////////////////////////////////////

}
