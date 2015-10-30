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
