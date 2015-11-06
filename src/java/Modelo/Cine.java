package Modelo;

import Modelo.Dao.Cine_Dao;
import java.util.ArrayList;

public class Cine {

    private int _idCine;
    private String _nombre;
    private String _ciudad;
    private ArrayList<Sala> _listaSalas;

    public Cine() {
        setIdCine(0);
        setNombre("");
        setCiudad("");
        setListaSalas(null);
    }
    
    public Cine(String newNombre, String newCiudad){
        setIdCine(0);
        setNombre(newNombre);
        setCiudad(newCiudad);
        setListaSalas(null);
    }
    
    public Cine(int currentId, String newNombre, String newCiudad){
        setIdCine(currentId);
        setNombre(newNombre);
        setCiudad(newCiudad);
        setListaSalas(null);
    }
    
    public Cine(int currentId){
        setIdCine(currentId);
        setNombre("");
        setCiudad("");
        setListaSalas(null);
    }
    
    public int getIdCine() {
        return _idCine;
    }

    public void setIdCine(int _idCine) {
        this._idCine = _idCine;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String getCiudad() {
        return _ciudad;
    }

    public void setCiudad(String _ciudad) {
        this._ciudad = _ciudad;
    }

    public ArrayList<Sala> getListaSalas() {
        return _listaSalas;
    }

    public void setListaSalas(ArrayList<Sala> _listaSalas) {
        this._listaSalas = _listaSalas;
    }

    public void dameSalasCine() {
        setListaSalas(_sala.dameAllSalasCine(this.getIdCine()));
    }

    ////////////////////////////////////////////// METODOS DE ALMACENAMIENTO CON Cine_Dao DB /////////////////////////////////////////////////////////////////
    private Cine_Dao _datos = new Cine_Dao();
    private ArrayList<Cine> _listaCines = new ArrayList();

    private Sala _sala = new Sala();

    public void agregarCine(Cine entidad) {
        _datos.agregar(entidad);
    }

    public void modificarCine(Cine entidad) {
        _datos.modificar(entidad);
    }

    public void borrarCine(Cine entidad) {
        _datos.borrar(entidad);
    }

    public ArrayList<Cine> dameListaTodos() {
        _listaCines = _datos.dameAll();
        return _listaCines;
    }

    public Cine buscarCine(String nombre) {
        return _datos.dameXId(nombre);
    }
    
    public Cine buscarCine(int id) {
        return _datos.dameXId(id);
    }

    public boolean existe(Cine entidad) {
        return _datos.existe(entidad);
    }

    ////////////////////////////////////////////// METODOS DE ALMACENAMIENTO CON Cine_Dao DB /////////////////////////////////////////////////////////////////
}
