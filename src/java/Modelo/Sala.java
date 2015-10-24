
package Modelo;

import Modelo.Dao.Sala_Dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sala {

    private int _id_sala;
    private String _nombre;
    private int _filas;
    private int _columnas;
    private int _tiempoLimpieza;
    private ArrayList <Funcion> _listaFunciones;

    public int getId_sala() {
        return _id_sala;
    }

    public void setId_sala(int _id_sala) {
        this._id_sala = _id_sala;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public int getFilas() {
        return _filas;
    }

    public void setFilas(int _filas) {
        this._filas = _filas;
    }

    public int getColumnas() {
        return _columnas;
    }

    public void setColumnas(int _columnas) {
        this._columnas = _columnas;
    }

    public int getTiempoLimpieza() {
        return _tiempoLimpieza;
    }

    public void setTiempoLimpieza(int _tiempoLimpieza) {
        this._tiempoLimpieza = _tiempoLimpieza;
    }

    public ArrayList <Funcion> getListaFunciones() {
        return _listaFunciones;
    }

    public void setListaFunciones(ArrayList <Funcion> _listaFunciones) {
        this._listaFunciones = _listaFunciones;
    }
    
    ////////////////////////////////////////////// METODOS DE ALMACENAMIENTO CON Sala_Dao DB /////////////////////////////////////////////////////////////////
    
    
    private Sala_Dao _datos = new Sala_Dao();
    private ArrayList<Sala> _listaSalas = new ArrayList<Sala>();
    
    public void agregarSala (Sala entidad){
        _datos.agregar(entidad);
    }
    
    public void modificarSala (Sala entidad){
        _datos.modificar(entidad);      
    }
    
    public void borrarSala (Sala entidad){
        _datos.borrar(entidad); 
    }
    
    public ArrayList<Sala> dameListaTodos (){
        _listaSalas = _datos.dameAll();
        return _listaSalas;
    }
    
    static ArrayList<Sala> DameAllSalasCine(String nombreCine) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Sala buscarSala (String nombre){
        return _datos.dameXId(nombre);
    }
    
    public boolean existe (Sala entidad){
        return _datos.existe(entidad);
    }
    
    
    ////////////////////////////////////////////// METODOS DE ALMACENAMIENTO CON Sala_Dao DB /////////////////////////////////////////////////////////////////

    
    
}
