package Modelo;

import Modelo.Dao.Reserva_Dao;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Reserva {

    private int _idReserva;
    private Usuario _propietario;
    private Funcion _funcion;
    private int _asiento;

    
    

    public Usuario getPropietario() {
        return _propietario;
    }
    public void setPropietario(Usuario _propietario) {
        this._propietario = _propietario;
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
        return _listaReservas;
    }

    public Reserva buscarReserva(String idString) {
        return _datos.dameXId(idString);
    }

    public boolean existe(Reserva reserva) {
        return _datos.existe(reserva);
    }

    ////////////////////////////////////////////// METODOS DE ALMACENAMIENTO CON Reserva_Dao DB /////////////////////////////////////////////////////////////////



    
}
