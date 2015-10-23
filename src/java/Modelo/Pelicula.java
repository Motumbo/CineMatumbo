
package Modelo;

import Modelo.Dao.Pelicula_Dao;
import java.util.HashMap;

public class Pelicula {
    private int _id_pelicula;
    private String _nombre;
    private String _genero;
    private String _clasificiacion;
    private int _duracion;

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
    
    
    ////////////////////////////////////////////// METODOS DE ALMACENAMIENTO CON Usuario_Dao DB /////////////////////////////////////////////////////////////////
    
    
    private Pelicula_Dao _datos = new Pelicula_Dao();
    private HashMap<Integer, Pelicula> _listaUsuarios = new HashMap<Integer, Pelicula>();
    
    public void agregarPelicula (Pelicula user){
        _datos.agregar(user);
    }
    
    public void modificarPelicula (Pelicula user){
        _datos.modificar(user);      
    }
    
    public void borrarPelicula (Pelicula user){
        _datos.borrar(user); 
    }
    
    public HashMap<Integer, Pelicula> dameListaTodos (){
        _listaUsuarios = _datos.DameAll();
        return _listaUsuarios;
    }
    
    public Pelicula buscarPelicula (String username){
        return _datos.dameXId(username);
    }
    
    public boolean existe (Pelicula user){
        return _datos.existe(user);
    }
    
    
    ////////////////////////////////////////////// METODOS DE ALMACENAMIENTO CON Usuario_Dao DB /////////////////////////////////////////////////////////////////
    
    
}
