
package Modelo;

import Modelo.Dao.Pelicula_Dao;
import java.util.ArrayList;
import java.util.HashMap;

public class Pelicula {
    private int _id_pelicula;
    private String _nombre;
    private String _genero;
    private String _clasificiacion;
    private int _duracion;  //Cambiar tipo de atributo por Time(deprecated) o Calendar

    public String getNombre() {
        return _nombre;
    }
    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String getGenero() {
        return _genero;
    }
    public void setGenero(String _genero) {
        this._genero = _genero;
    }

    public String getClasificiacion() {
        return _clasificiacion;
    }
    public void setClasificiacion(String _clasificiacion) {
        this._clasificiacion = _clasificiacion;
    }

    public int getDuracion() {
        return _duracion;
    }
    public void setDuracion(int _duracion) {
        this._duracion = _duracion;
    }

    public int getId_pelicula() {
        return _id_pelicula;
    }

    public void setId_pelicula(int _id_pelicula) {
        this._id_pelicula = _id_pelicula;
    }
    
    
    ////////////////////////////////////////////// METODOS DE ALMACENAMIENTO CON Pelicula_Dao DB /////////////////////////////////////////////////////////////////
    
    
    private Pelicula_Dao _datos = new Pelicula_Dao();
    private ArrayList<Pelicula> _listaPeliculas = new ArrayList<Pelicula>();
    
    public void agregarPelicula (Pelicula entidad){
        _datos.agregar(entidad);
    }
    
    public void modificarPelicula (Pelicula entidad){
        _datos.modificar(entidad);      
    }
    
    public void borrarPelicula (Pelicula entidad){
        _datos.borrar(entidad); 
    }
    
    public ArrayList<Pelicula> dameListaTodos (){
        _listaPeliculas = _datos.dameAll();
        return _listaPeliculas;
    }
    
    public Pelicula buscarPelicula (String nombre){
        return _datos.dameXId(nombre);
    }
    
    public boolean existe (Pelicula entidad){
        return _datos.existe(entidad);
    }
    
    
    ////////////////////////////////////////////// METODOS DE ALMACENAMIENTO CON Pelicula_Dao DB /////////////////////////////////////////////////////////////////
    
    
}
