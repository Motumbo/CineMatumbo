package Controladora;

import Modelo.Funcion;
import java.util.ArrayList;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Funcion_Control", urlPatterns = {"/controlFuncion"})
public class Funcion_Control extends HttpServlet {

    private Funcion _funcion = new Funcion();
    private ArrayList _listaFunciones = new ArrayList();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
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

    private void agregar(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException{
        int idSala = Integer.parseInt(request.getParameter("idSalaAgregar"));
        int idPelicula = Integer.parseInt(request.getParameter("idPeliculaAgregar"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
        Date fechaHora = formatter.parse(request.getParameter("fechaHoraAgregar"));
        float tarifa = Float.parseFloat(request.getParameter("tarifaAgregar"));
        Funcion funcion = new Funcion(idSala, idPelicula, fechaHora, tarifa);
        getFuncion().agregarFuncion(funcion);
        response.sendRedirect("gestionFunciones.jsp");
    }
    
    private void borrar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int idFuncion = Integer.parseInt(request.getParameter("idBorrar"));
        Funcion funcion = new Funcion(idFuncion);
        getFuncion().borrarFuncion(funcion);
        response.sendRedirect("gestionFunciones.jsp");
    }
    
    private void modificar(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
        int idFuncion = Integer.parseInt(request.getParameter("idModificar"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
        Date fechaHora = formatter.parse(request.getParameter("fechaHoraModificar"));
        float tarifa = Float.parseFloat(request.getParameter("tarifaModificar"));
        Funcion funcion = new Funcion(idFuncion, fechaHora, tarifa);
        getFuncion().modificarFuncion(funcion);
        response.sendRedirect("gestionFunciones.jsp");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(Funcion_Control.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("listaFunciones", getListaFunciones());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(Funcion_Control.class.getName()).log(Level.SEVERE, null, ex);
        }
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
