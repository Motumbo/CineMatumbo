package Modelo;

import Modelo.Dao.Reserva_Dao;
import java.util.ArrayList;

public class Reserva {

    private int _idReserva;
    private Usuario _usuarioPropietario;
    private Funcion _funcion;
    private int _asiento;

    public Reserva() {
        setIdReserva(0);
        setAsiento(0);
        setUsuarioPropietario(new Usuario());
        setFuncion(new Funcion());
    }

    public Reserva(Usuario usuarioPropietario, Funcion funcion, int numeroAsiento) {
        setIdReserva(0);
        setUsuarioPropietario(usuarioPropietario);
        setFuncion(funcion);
        setAsiento(numeroAsiento);
    }

    public Usuario getUsuarioPropietario() {
        return _usuarioPropietario;
    }

    public void setUsuarioPropietario(Usuario _propietario) {
        this._usuarioPropietario = _propietario;
    }

    public Funcion getFuncion() {
        return _funcion;
    }

    public void setFuncion(Funcion _funcion) {
        this._funcion = _funcion;
    }

    public int getAsiento() {
        return _asiento;
    }

    public void setAsiento(int _asiento) {
        this._asiento = _asiento;
    }

    public int getIdReserva() {
        return _idReserva;
    }

    public void setIdReserva(int _idReserva) {
        this._idReserva = _idReserva;
    }

    ////////////////////////////////////////////// METODOS DE ALMACENAMIENTO CON Reserva_Dao DB /////////////////////////////////////////////////////////////////
    private Reserva_Dao _datos = new Reserva_Dao();
    private ArrayList _listaReservas = new ArrayList();

    public void agregarUsuario(Reserva reserva) {
        if (!reserva.existe(reserva)) {
            _datos.agregar(reserva);
        }
    }

    public void modificarUsuario(Reserva reserva) {
        _datos.modificar(reserva);
    }

    public void borrarUsuario(Reserva reserva) {
        _datos.borrar(reserva);
    }

    public ArrayList dameListaTodos() {
        _listaReservas = _datos.dameAll();
        for (int i = 0; i < _listaReservas.size(); i++) {
            Reserva reserva = (Reserva) _listaReservas.get(i);
            reserva.setFuncion(reserva.getFuncion().buscarFunciones(reserva.getFuncion().getIdFuncion()));
            reserva.getFuncion().setPelicula(reserva.getFuncion().getPelicula().buscarPelicula(reserva.getFuncion().getPelicula().getIdPelicula()));
            reserva.setUsuarioPropietario(reserva.getUsuarioPropietario().buscarUsuario(reserva.getUsuarioPropietario().getIdUsuario()));
        }
        return _listaReservas;
    }

    public ArrayList dameMisReservasActivas(int idUsuario) {
        _listaReservas = _datos.dameMisReservasActivas(idUsuario);
        for (int i = 0; i < _listaReservas.size(); i++) {
            Reserva reserva = (Reserva) _listaReservas.get(i);
            reserva.setFuncion(reserva.getFuncion().buscarFunciones(reserva.getFuncion().getIdFuncion()));
            reserva.getFuncion().setPelicula(reserva.getFuncion().getPelicula().buscarPelicula(reserva.getFuncion().getPelicula().getIdPelicula()));
            reserva.setUsuarioPropietario(reserva.getUsuarioPropietario().buscarUsuario(idUsuario));
        }
        return _listaReservas;
    }

    public Reserva buscarReserva(String idString) {
        return _datos.dameXId(idString);
    }

    public Reserva buscarReservaXId(int idReserva) {
        return _datos.dameXId(idReserva);
    }

    public boolean existe(Reserva reserva) {
        return _datos.existe(reserva);
    }

    ////////////////////////////////////////////// METODOS DE ALMACENAMIENTO CON Reserva_Dao DB /////////////////////////////////////////////////////////////////
}
