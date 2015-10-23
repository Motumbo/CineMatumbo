
package Modelo;

import java.util.List;

public class Cine {
    private int _id_cine;
    private String _nombre;
    private String _ciudad;
    private List <Sala> _listaSalas;

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

    public List <Sala> getListaSalas() {
        return _listaSalas;
    }

    public void setListaSalas(List <Sala> _listaSalas) {
        this._listaSalas = _listaSalas;
    }
}
