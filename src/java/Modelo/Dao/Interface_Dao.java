/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import java.util.ArrayList;


/**
 *
 * @author Feto
 */
public interface Interface_Dao <T> {
          
    public T agregar(T entidad);
    public T modificar(T entidad);
    public void borrar(T entidad);
    public ArrayList <T> dameAll();
    public T dameXId(String id);
    public boolean existe(T entidad);
}
