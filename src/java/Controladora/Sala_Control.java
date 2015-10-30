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
