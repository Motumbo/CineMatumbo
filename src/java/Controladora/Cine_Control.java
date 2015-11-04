package Controladora;

import Modelo.Cine;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Cine_Control", urlPatterns = {"/controlCine"})
public class Cine_Control extends HttpServlet {

    private ArrayList _listaCines = new ArrayList();
    private Cine _cine = new Cine();

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
        Cine cine = new Cine(request.getParameter("nombreAgregar"), request.getParameter("ciudadAgregar"));
        getCine().agregarCine(cine);
        response.sendRedirect("gestionCines.jsp");
    }

    private void borrar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idCine = Integer.parseInt(request.getParameter("idBorrar"));
        Cine cine = new Cine(idCine);
        getCine().borrarCine(cine);
        response.sendRedirect("gestionCines.jsp");
    }

    private void modificar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idCine = Integer.parseInt(request.getParameter("idModificar"));
        Cine cine = new Cine(idCine, request.getParameter("nombreModificar"), request.getParameter("ciudadModificar"));
        getCine().modificarCine(cine);
        response.sendRedirect("gestionCines.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        request.setAttribute("listaCines", getListaCines());
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

    public ArrayList getListaCines() {
        setListaCines(getCine().dameListaTodos());
        return _listaCines;
    }

    public void setListaCines(ArrayList listaCines) {
        this._listaCines = listaCines;
    }

    public Cine getCine() {
        return _cine;
    }

    public void setCine(Cine cine) {
        this._cine = cine;
    }
}
