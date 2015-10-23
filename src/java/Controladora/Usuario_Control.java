/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Modelo.Dao.DB;
import Modelo.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Feto
 */

@WebServlet(name = "LogIn", urlPatterns =
{
    "/LogIn"
})

public class Usuario_Control extends HttpServlet{
    
        private Usuario _usuarioConectado = new Usuario();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession(true);        
        String accion = request.getParameter("accion"); 
        
        if (accion.equals("login")){  //SI EL USUARIO ELIGE EL BOTON ID:loginw
            login(request, session, response);
        }
        else if(accion.equals("registro")){
            registrarse(request, session, response);
        } 
    }

    private void registrarse(HttpServletRequest request, HttpSession session, HttpServletResponse response) throws IOException {
        Usuario user = new Usuario(request.getParameter("usuario"), request.getParameter("pasword"), request.getParameter("mail"));
        if(user != null){
            session.setAttribute("usuario", user);
            response.sendRedirect("mainMenu.jsp");
        }
        else{
            response.sendRedirect("login.jsp");
        }
    }

    private void login(HttpServletRequest request, HttpSession session, HttpServletResponse response) throws IOException {
        Usuario user = new Usuario(request.getParameter("usuario"), request.getParameter("pasword")); //acomodar esto, no necesito crearlo con sus datos.
        user = user.validarLogIn(request.getParameter("usuario"), request.getParameter("pasword"));
        if(user != null){
            session.setAttribute("usuario", user);
            response.sendRedirect("mainMenu.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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


    
}
