import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class ServletEjer1 extends HttpServlet {
    

    public ServletEjer1() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        // 1. Obtener parámetro de la URL
        String color = request.getParameter("colorFonfo");

        // 2. Si no viene nada, usar negro por defecto
        if (color == null || color.isBlank()) {
            color = "white"; 
        }

        // 3. Generar la respuesta HTML con el color dinámico
        response.getWriter().append(
            "<!DOCTYPE html>" +
            "<html>" +
            "<head>" +
            "<meta charset='UTF-8'>" +
            "<title>Servlet1</title>" +
            "<style>" +
            "body { background-color: " + color + " }" +
            "</style>" +
            "</head>" +
            "<body>" +
            "<p> El color es " + color + "</p>"+
            "<a href='ServletEjer1V2'>" +
            "  <button type='button'>Click Me</button>" +
            "</a>"+
            "</body>"+
            "</html>"
        );

        response.getWriter().close();
    }

    // Si quieres que doPost también funcione
    /*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    */
}
