package Modelo;

import Modelo.Dao.Funcion_Dao;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Funcion {

    private int _idFuncion;
    private int _idSalaAlQuePertenece;
    private Pelicula _pelicula;
    private Timestamp _fechaHoraInicio;

    public int getIdFuncion() {
        return _idFuncion;
    }
    public void setIdFuncion(int _idFuncion) {
        this._idFuncion = _idFuncion;
    }

    public int getIdSalaAlQuePertenece() {
        return _idSalaAlQuePertenece;
    }
    public void setIdSalaAlQuePertenece(int _idSalaAlQuePertenece) {
        this._idSalaAlQuePertenece = _idSalaAlQuePertenece;
    }
    
    public Pelicula getPelicula() {
        return _pelicula;
    }
    public void setPelicula(Pelicula _pelicula) {
        this._pelicula = _pelicula;
    }

    public Timestamp getFechaHoraInicio() {
        return _fechaHoraInicio;
    }
    public void setFechaHoraInicio(Timestamp _fechaHoraInicio) {
        this._fechaHoraInicio = _fechaHoraInicio;
    }

    
    ////////////////////////////////////////////// METODOS DE ALMACENAMIENTO CON Funcion_Dao DB /////////////////////////////////////////////////////////////////
    
    private Funcion_Dao _datos = new Funcion_Dao();
    private ArrayList _listaUsuarios = new ArrayList();

    public void agregarUsuario(Funcion funcion) {
        if (!funcion.existe(funcion)) {
            _datos.agregar(funcion);
        }
    }

    public void modificarUsuario(Funcion funcion) {
        _datos.modificar(funcion);        
    }

    public void borrarUsuario(Funcion funcion) {       
        _datos.borrar(funcion);        
    }

    public ArrayList dameListaTodos() {
        _listaUsuarios = _datos.dameAll();
        return _listaUsuarios;
    }

    public Funcion buscarUsuario(String username) {
        return _datos.dameXId(username);
    }

    public boolean existe(Funcion user) {
        return _datos.existe(user);
    }

    ////////////////////////////////////////////// METODOS DE ALMACENAMIENTO CON Usuario_Dao DB /////////////////////////////////////////////////////////////////



}
