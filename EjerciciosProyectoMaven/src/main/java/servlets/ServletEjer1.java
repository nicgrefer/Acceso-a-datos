package servlets;
	import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletEjer1")
public class ServletEjer1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ServletEjer1() {}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");

        String idioma = request.getParameter("idioma");
        String saludo;

        if (idioma == null || idioma.isEmpty()) {
            saludo = "No has indicado idioma.";
        } else {
            switch (idioma.toLowerCase()) {
                case "es":
                    saludo = "Hola mundo";
                    break;
                case "in":
                    saludo = "Hello world";
                    break;
                case "fr":
                    saludo = "Bonjour le monde";
                    break;
                default:
                    saludo = "El idioma no está en nuestra base de datos";
            }
        }

        response.getWriter().append("<html>")
                            .append("<body>")
                            .append("<h2>" + saludo + "</h2>")
                            .append("</body>")
                            .append("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");

        String idioma = request.getParameter("idioma");
        String saludo;

        if (idioma == null) {
            saludo = "No has seleccionado idioma.";
        } else {
            switch (idioma) {
                case "es":
                    saludo = "Hola Mundo";
                    break;
                case "en":
                    saludo = "Hello World";
                    break;
                case "it":
                    saludo = "Ciao a tutti";
                    break;
                case "fr":
                    saludo = "Bonjour Tout";
                    break;
                default:
                    saludo = "Idioma no reconocido.";
            }
        }

        response.getWriter().append("<html>")
                            .append("<body>")
                            .append("<h2>" + saludo + "</h2>")
                            .append("</body>")
                            .append("</html>");
    }
    
}
