package Modelo.Dao;

import java.util.ArrayList;

public interface Interface_Dao<T> {

    public T agregar(T entidad);

    public T modificar(T entidad);

    public void borrar(T entidad);

    public ArrayList<T> dameAll();

    public T dameXId(String id);

    public boolean existe(T entidad);
}
