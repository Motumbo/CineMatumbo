package Controladora;

import Modelo.Funcion;
import java.util.ArrayList;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Funcion_Control", urlPatterns = {"/controlFunciones"})
public class Funcion_Control extends HttpServlet {

    private Funcion _funcion = new Funcion();
    private ArrayList _listaFunciones = new ArrayList();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        request.setAttribute("listaFunciones", getListaFunciones());
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

    public Funcion getFuncion() {
        return _funcion;
    }

    public void setFuncion(Funcion _funcion) {
        this._funcion = _funcion;
    }

    public ArrayList getListaFunciones() {
        setListaFunciones(getFuncion().dameListaTodos());
        return _listaFunciones;
    }

    public void setListaFunciones(ArrayList _listaFunciones) {
        this._listaFunciones = _listaFunciones;
    }

}
