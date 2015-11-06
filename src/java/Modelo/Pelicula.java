package Modelo;

import Modelo.Dao.Pelicula_Dao;
import java.util.ArrayList;

public class Pelicula {

    private int _idPelicula;
    private String _nombre;
    private String _genero;
    private String _clasificacion;
    private int _duracion;
    private String _imagen;

    public Pelicula(){
        setIdPelicula(0);
        setNombre("");
        setGenero("");
        setClasificacion("");
        setDuracion(0);
        setImagen("");
    }
    
    public Pelicula(int currentId){
        setIdPelicula(currentId);
        setNombre("");
        setGenero("");
        setClasificacion("");
        setDuracion(0);
        setImagen("");
    }
    
    public Pelicula(String newNombre, String newGenero, String newClasificacion, int newDuracion, String newImagen){
        setIdPelicula(0);
        setNombre(newNombre);
        setGenero(newGenero);
        setClasificacion(newClasificacion);
        setDuracion(newDuracion);
        setImagen(newImagen);
    }
    
    public Pelicula(int currentId, String newNombre, String newGenero, String newClasificacion, int newDuracion, String newImagen){
        setIdPelicula(currentId);
        setNombre(newNombre);
        setGenero(newGenero);
        setClasificacion(newClasificacion);
        setDuracion(newDuracion);
        setImagen(newImagen);
    }
    
    public int getIdPelicula() {
        return _idPelicula;
    }

    public void setIdPelicula(int _idPelicula) {
        this._idPelicula = _idPelicula;
    }

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

    public String getClasificacion() {
        return _clasificacion;
    }

    public void setClasificacion(String _clasificacion) {
        this._clasificacion = _clasificacion;
    }

    public int getDuracion() {
        return _duracion;
    }

    public void setDuracion(int _duracion) {
        this._duracion = _duracion;
    }

    public String getImagen() {
        return _imagen;
    }

    public void setImagen(String _imagen) {
        this._imagen = _imagen;
    }

    ////////////////////////////////////////////// METODOS DE ALMACENAMIENTO CON Pelicula_Dao DB /////////////////////////////////////////////////////////////////
    private Pelicula_Dao _datos = new Pelicula_Dao();
    private ArrayList<Pelicula> _listaPeliculas = new ArrayList();

    public void agregarPelicula(Pelicula entidad) {
        _datos.agregar(entidad);
    }

    public void modificarPelicula(Pelicula entidad) {
        _datos.modificar(entidad);
    }

    public void borrarPelicula(Pelicula entidad) {
        _datos.borrar(entidad);
    }

    public ArrayList<Pelicula> dameListaTodos() {
        _listaPeliculas = _datos.dameAll();
        return _listaPeliculas;
    }

    public Pelicula buscarPelicula(String nombre) {
        return _datos.dameXId(nombre);
    }

    public Pelicula buscarPelicula(int id) {
        return _datos.dameXId(id);
    }
    
    public boolean existe(Pelicula entidad) {
        return _datos.existe(entidad);
    }

    ////////////////////////////////////////////// METODOS DE ALMACENAMIENTO CON Pelicula_Dao DB /////////////////////////////////////////////////////////////////
}
