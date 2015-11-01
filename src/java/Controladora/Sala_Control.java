package Controladora;

import Modelo.Sala;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Sala_Control", urlPatterns = {"/controlSala"})

public class Sala_Control extends HttpServlet {

    private ArrayList _listaSalas = new ArrayList();
    private Sala _sala = new Sala();

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

    private void agregar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int idCine = Integer.parseInt(request.getParameter("idCineAgregar"));
        int filasSala = Integer.parseInt(request.getParameter("filasAgregar"));
        int columnasSala = Integer.parseInt(request.getParameter("columnasAgregar"));
        int tiempoLimpiezaSala = Integer.parseInt(request.getParameter("tiempoAgregar"));
        Sala sala = new Sala(request.getParameter("nombreAgregar"), filasSala, columnasSala, tiempoLimpiezaSala);
        getSala().agregarSala(sala, idCine);
        response.sendRedirect("gestionSalas.jsp");
    }
    
    private void borrar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int idSala = Integer.parseInt(request.getParameter("idBorrar"));
        Sala sala = new Sala(idSala);
        getSala().borrarSala(sala);
        response.sendRedirect("gestionSalas.jsp");
    }
    
    private void modificar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idSala = Integer.parseInt(request.getParameter("idModificar"));
        int filasSala = Integer.parseInt(request.getParameter("filasModificar"));
        int columnasSala = Integer.parseInt(request.getParameter("columnasModificar"));
        int tiempoLimpiezaSala = Integer.parseInt(request.getParameter("tiempoModificar"));
        Sala sala = new Sala(idSala, request.getParameter("nombreModificar"), filasSala, columnasSala, tiempoLimpiezaSala);
        getSala().modificarSala(sala);
        response.sendRedirect("gestionSalas.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        request.setAttribute("listaSalas", getListaSalas());
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

    public ArrayList getListaSalas() {
        setListaSalas(getSala().dameListaTodos());
        return _listaSalas;
    }

    public void setListaSalas(ArrayList listaSalas) {
        this._listaSalas = listaSalas;
    }

    public Sala getSala() {
        return _sala;
    }

    public void setSala(Sala sala) {
        this._sala = sala;
    }
}
