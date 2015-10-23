
package Modelo;

import java.util.List;

public class Sala {
    private int _id_sala;
    private String _nombre;
    private int _filas;
    private int _columnas;
    private int _tiempoLimpieza;
    private List <Funcion> _listaFunciones;

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

    public List <Funcion> getListaFunciones() {
        return _listaFunciones;
    }

    public void setListaFunciones(List <Funcion> _listaFunciones) {
        this._listaFunciones = _listaFunciones;
    }
}
