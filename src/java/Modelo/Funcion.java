package Modelo;

import Modelo.Dao.Funcion_Dao;
import java.util.ArrayList;
import java.util.Date;

public class Funcion {

    private int _idFuncion;
    private int _idSalaAlQuePertenece;
    private Pelicula _pelicula;
    private Date _fechaHoraInicio;
    private Float _tarifa;

    public Funcion(){
        setIdFuncion(0);
        setIdSalaAlQuePertenece(0);
        setPelicula(null);
        setFechaHoraInicio(null);
        setTarifa(null);
    }
    
     public Funcion(int idFuncion){
        setIdFuncion(idFuncion);
        setIdSalaAlQuePertenece(0);
        setPelicula(null);
        setFechaHoraInicio(null);
        setTarifa(null);
    }
    
    public Funcion(int idSala, int idPelicula, Date newFechaHora, float newTarifa){
        setIdFuncion(0);
        setIdSalaAlQuePertenece(idSala);
        setPelicula(new Pelicula().buscarPelicula(idPelicula));
        setFechaHoraInicio(newFechaHora);
        setTarifa(newTarifa);
    }
    
    public Funcion(int idFuncion, Date newFechaHora, float newTarifa){
        setIdFuncion(idFuncion);
        setIdSalaAlQuePertenece(0);
        setPelicula(null);
        setFechaHoraInicio(newFechaHora);
        setTarifa(newTarifa);
    }
    
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

    public Date getFechaHoraInicio() {
        return _fechaHoraInicio;
    }
    public void setFechaHoraInicio(Date _fechaHoraInicio) {
        this._fechaHoraInicio = _fechaHoraInicio;
    }

    public Float getTarifa() {
        return _tarifa;
    }
    public void setTarifa(Float _tarifa) {
        this._tarifa = _tarifa;
    }
    
    
    ////////////////////////////////////////////// METODOS DE ALMACENAMIENTO CON Funcion_Dao DB /////////////////////////////////////////////////////////////////
    
    private Funcion_Dao _datos = new Funcion_Dao();
    private ArrayList _listaFunciones = new ArrayList();

    public void agregarFuncion(Funcion funcion) {
        if (!funcion.existe(funcion)) {
            _datos.agregar(funcion);
        }
    }

    public void modificarFuncion(Funcion funcion) {
        _datos.modificar(funcion);        
    }

    public void borrarFuncion(Funcion funcion) {       
        _datos.borrar(funcion);        
    }

    public ArrayList dameListaTodos() {
        _listaFunciones = _datos.dameAll();
        return _listaFunciones;
    }

    public Funcion buscarFunciones(String idString) {
        return _datos.dameXId(idString);
    }

    public boolean existe(Funcion user) {
        return _datos.existe(user);
    }

    ////////////////////////////////////////////// METODOS DE ALMACENAMIENTO CON Funcion_Dao DB /////////////////////////////////////////////////////////////////

}
