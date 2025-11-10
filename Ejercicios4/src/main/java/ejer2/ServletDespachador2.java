package ejer2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletDespachador2")
public class ServletDespachador2 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        
        String tablaStr = request.getParameter("tabla");
        String color = request.getParameter("color");
        
        if (tablaStr == null || tablaStr.isEmpty()) {
            String mensaje = "No has elegido ninguna tabla. Elige una tabla por favor.";
            request.setAttribute("mensaje", mensaje);
            RequestDispatcher dispatcher = request.getRequestDispatcher("ejer2/ServletError");
            dispatcher.forward(request, response);
        } else {
            int tabla = Integer.parseInt(tablaStr);
            request.setAttribute("tabla", tabla);
            request.setAttribute("color", color);
            RequestDispatcher dispatcher = request.getRequestDispatcher("ejer2/ServletTablas");
            dispatcher.forward(request, response);
        }
    }
}