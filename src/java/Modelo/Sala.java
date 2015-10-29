package Modelo;

import Modelo.Dao.Sala_Dao;
import java.util.ArrayList;

public class Sala {

    private int _idSala;
    private String _nombre;
    private int _filas;
    private int _columnas;
    private int _tiempoLimpieza;
    private ArrayList<Funcion> _listaFunciones;

    public int getIdSala() {
        return _idSala;
    }

    public void setIdSala(int _idSala) {
        this._idSala = _idSala;
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

    public ArrayList<Funcion> getListaFunciones() {
        return _listaFunciones;
    }

    public void setListaFunciones(ArrayList<Funcion> _listaFunciones) {
        this._listaFunciones = _listaFunciones;
    }

    ////////////////////////////////////////////// METODOS DE ALMACENAMIENTO CON Sala_Dao DB /////////////////////////////////////////////////////////////////
    private Sala_Dao _datos = new Sala_Dao();
    private ArrayList<Sala> _listaSalas = new ArrayList();

    public void agregarSala(Sala entidad) {
        _datos.agregar(entidad);
    }

    public void modificarSala(Sala entidad) {
        _datos.modificar(entidad);
    }

    public void borrarSala(Sala entidad) {
        _datos.borrar(entidad);
    }

    public ArrayList<Sala> dameListaTodos() {
        _listaSalas = _datos.dameAll();
        return _listaSalas;
    }

    public ArrayList<Sala> DameAllSalasCine(int id_Cine) {
        _listaSalas = _datos.dameSalasCine(id_Cine);
        return _listaSalas;
    }

    public Sala buscarSala(String nombre) {
        return _datos.dameXId(nombre);
    }

    public boolean existe(Sala entidad) {
        return _datos.existe(entidad);
    }

    ////////////////////////////////////////////// METODOS DE ALMACENAMIENTO CON Sala_Dao DB /////////////////////////////////////////////////////////////////
}
