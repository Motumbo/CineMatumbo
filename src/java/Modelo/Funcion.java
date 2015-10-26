package Modelo;

import java.sql.Timestamp;

class Funcion {

    private int _idFuncion;
    private Pelicula _pelicula;
    private Timestamp _fechaHoraInicio;

    public int getIdFuncion() {
        return _idFuncion;
    }

    public void setIdFuncion(int _idFuncion) {
        this._idFuncion = _idFuncion;
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

}
