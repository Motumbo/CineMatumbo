
package Modelo;

import Modelo.Dao.Cine_Dao;
import java.util.ArrayList;
import java.util.HashMap;


public class Cine {
    private int _id_cine;
    private String _nombre;
    private String _ciudad;
    private ArrayList <Sala> _listaSalas;

    public int getId_cine() {
        return _id_cine;
    }

    public void setId_cine(int _id_cine) {
        this._id_cine = _id_cine;
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

    public ArrayList <Sala> getListaSalas() {
        return _listaSalas;
    }

    public void setListaSalas(ArrayList <Sala> _listaSalas) {
        this._listaSalas = _listaSalas;
    }
    
    public void dameSalasCine (){
        setListaSalas(Sala.DameAllSalasCine(this.getNombre()));
    }
    
    ////////////////////////////////////////////// METODOS DE ALMACENAMIENTO CON Cine_Dao DB /////////////////////////////////////////////////////////////////
    
    
    private Cine_Dao _datos = new Cine_Dao();
    private ArrayList<Cine> _listaCines = new ArrayList<Cine>();
    
    public void agregarCine (Cine entidad){
        _datos.agregar(entidad);
    }
    
    public void modificarCine (Cine entidad){
        _datos.modificar(entidad);      
    }
    
    public void borrarCine (Cine entidad){
        _datos.borrar(entidad); 
    }
    
    public ArrayList<Cine> dameListaTodos (){
        _listaCines = _datos.dameAll();
        return _listaCines;
    }
    
    public Cine buscarCine (String nombre){
        return _datos.dameXId(nombre);
    }
    
    public boolean existe (Cine entidad){
        return _datos.existe(entidad);
    }
    
    ////////////////////////////////////////////// METODOS DE ALMACENAMIENTO CON Cine_Dao DB /////////////////////////////////////////////////////////////////

    
    
    
}
