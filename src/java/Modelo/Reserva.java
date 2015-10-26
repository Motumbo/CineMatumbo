package Modelo;

import java.sql.Timestamp;

public class Reserva {

    private int _idReserva;
    private Float _tarifa;
    private Timestamp _fechaHora;
    private Usuario _propietario;
    private int _asiento;
    private String _nombrePelicula;
    private String _nombreCine;
    private String _nombreSala;

    public Float getTarifa() {
        return _tarifa;
    }

    public void setTarifa(Float _tarifa) {
        this._tarifa = _tarifa;
    }

    public Timestamp getFechaHora() {
        return _fechaHora;
    }

    public void setFechaHora(Timestamp _fechaHora) {
        this._fechaHora = _fechaHora;
    }

    public Usuario getPropietario() {
        return _propietario;
    }

    public void setPropietario(Usuario _propietario) {
        this._propietario = _propietario;
    }

    public int getAsiento() {
        return _asiento;
    }

    public void setAsiento(int _asiento) {
        this._asiento = _asiento;
    }

    public String getNombrePelicula() {
        return _nombrePelicula;
    }

    public void setNombrePelicula(String _nombrePelicula) {
        this._nombrePelicula = _nombrePelicula;
    }

    public String getNombreCine() {
        return _nombreCine;
    }

    public void setNombreCine(String _nombreCine) {
        this._nombreCine = _nombreCine;
    }

    public String getNombreSala() {
        return _nombreSala;
    }

    public void setNombreSala(String _nombreSala) {
        this._nombreSala = _nombreSala;
    }

    public int getIdReserva() {
        return _idReserva;
    }

    public void setIdReserva(int _idReserva) {
        this._idReserva = _idReserva;
    }
}
