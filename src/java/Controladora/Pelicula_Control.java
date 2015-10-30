package Controladora;

import Modelo.Pelicula;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "C_Peliculas", urlPatterns = {"/controlPeliculas"})

public class Pelicula_Control extends HttpServlet {

    private Pelicula _pelicula = new Pelicula();
    private ArrayList _listaPeliculas = new ArrayList();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        request.setAttribute("listaPeliculas", getListaPeliculas());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    public Pelicula getPelicula() {
        return _pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this._pelicula = pelicula;
    }

    public ArrayList getListaPeliculas() {
        setListaPeliculas(getPelicula().dameListaTodos());
        return _listaPeliculas;
    }

    public void setListaPeliculas(ArrayList listaPeliculas) {
        this._listaPeliculas = listaPeliculas;
    }
}
