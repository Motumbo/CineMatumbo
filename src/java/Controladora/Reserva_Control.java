package Controladora;

import Modelo.Reserva;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Reserva_Control", urlPatterns = {"/controlReserva"})
public class Reserva_Control extends HttpServlet {

    private Reserva _reserva = new Reserva();
    private ArrayList _listaReservas = new ArrayList();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        /*
        String accion = request.getParameter("accion");

        switch (accion) {
            case "agregar":
                this.agregar(request, response);
                break;
            case "borrar":
                this.borrar(request, response);
                break;*/
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        request.setAttribute("listaReservas", getListaReservas());
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

    public Reserva getReserva() {
        return _reserva;
    }

    public void setReserva(Reserva _reserva) {
        this._reserva = _reserva;
    }

    public ArrayList getListaReservas() {
        return _listaReservas;
    }

    public void setListaReservas(ArrayList _listaReservas) {
        this._listaReservas = _listaReservas;
    }
    
}
