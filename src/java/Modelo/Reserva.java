
package Modelo;

import java.sql.Timestamp;

public class Reserva {
    private int _id_reserva;
    private Float _tarifa;
    private Timestamp _fechaYhora;
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

    public Timestamp getFechaYhora() {
        return _fechaYhora;
    }
    public void setFechaYhora(Timestamp _fechaYhora) {
        this._fechaYhora = _fechaYhora;
    }

    public Usuario getPropietario() {
        return _propietario;
    }
    public void setPropietario(Usuario  _propietario) {
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

    public int getId_reserva() {
        return _id_reserva;
    }

    public void setId_reserva(int _id_reserva) {
        this._id_reserva = _id_reserva;
    }
}
