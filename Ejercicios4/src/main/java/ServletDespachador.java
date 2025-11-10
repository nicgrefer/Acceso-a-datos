

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.IOException;


@WebServlet("/ServletDespachador")
public class ServletDespachador extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        procesarPeticion(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        procesarPeticion(request, response);
    }
    
    private void procesarPeticion(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Obtener los parámetros del formulario
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");
        
        // Establecer la codificación de caracteres
        request.setCharacterEncoding("UTF-8");
        
        // Validar que la clave sea "admin"
        if (clave != null && clave.equals("admin")) {
            // Clave correcta: guardar el usuario en el request y reenviar a ServletBienvenida
            request.setAttribute("usuario", usuario);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ServletBienvenida");
            dispatcher.forward(request, response);
        } else {
            // Clave incorrecta: reenviar a ServletError
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ServletError");
            dispatcher.forward(request, response);
        }
    }
}