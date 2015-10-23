
package Modelo;

import java.sql.Timestamp;

class Funcion {
    private int _id_funcion;
    private Pelicula _pelicula;
    private Timestamp _horarioInicio;

    public int getId_funcion() {
        return _id_funcion;
    }

    public void setId_funcion(int _id_funcion) {
        this._id_funcion = _id_funcion;
    }

    public Pelicula getPelicula() {
        return _pelicula;
    }

    public void setPelicula(Pelicula _pelicula) {
        this._pelicula = _pelicula;
    }

    public Timestamp getHorarioInicio() {
        return _horarioInicio;
    }

    public void setHorarioInicio(Timestamp _horarioInicio) {
        this._horarioInicio = _horarioInicio;
    }
    
}
