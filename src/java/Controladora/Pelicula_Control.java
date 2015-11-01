package Controladora;

import Modelo.Pelicula;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "C_Peliculas", urlPatterns = {"/controlPelicula"})

public class Pelicula_Control extends HttpServlet {

    private Pelicula _pelicula = new Pelicula();
    private ArrayList _listaPeliculas = new ArrayList();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");

        switch (accion) {
            case "agregar":
                this.agregar(request, response);
                break;
            case "modificar":
                this.modificar(request, response);
                break;
            case "borrar":
                this.borrar(request, response);
                break;
        }
    }

    private void agregar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int duracion = Integer.parseInt(request.getParameter("duracionAgregar"));
        Pelicula pelicula = new Pelicula(request.getParameter("nombreAgregar"), request.getParameter("generoAgregar"),
                request.getParameter("clasificacionAgregar"), duracion, request.getParameter("imagenAgregar"));
        getPelicula().agregarPelicula(pelicula);
        response.sendRedirect("gestionPeliculas.jsp");
    }

    private void borrar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idPelicula = Integer.parseInt(request.getParameter("idBorrar"));
        Pelicula pelicula = new Pelicula(idPelicula);
        getPelicula().borrarPelicula(pelicula);
        response.sendRedirect("gestionPeliculas.jsp");
    }

    private void modificar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idPelicula = Integer.parseInt(request.getParameter("idModificar"));
        int duracion = Integer.parseInt(request.getParameter("duracionModificar"));
        Pelicula pelicula = new Pelicula(idPelicula,request.getParameter("nombreModificar"), request.getParameter("generoModificar"),
                request.getParameter("clasificacionModificar"), duracion, request.getParameter("imagenModificar"));
        getPelicula().modificarPelicula(pelicula);
        response.sendRedirect("gestionPeliculas.jsp");
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
