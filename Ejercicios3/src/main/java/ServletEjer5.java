import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet("/ServletEjer5")
public class ServletEjer5 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ServletEjer5() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener el contexto de la aplicación
        ServletContext contexto = getServletContext();

        // Generar número aleatorio actual
        Random r = new Random();
        int numeroAleatorio = r.nextInt(10) + 1; // 1 a 10

        // Recuperar el número del contexto (si existe)
        Integer numeroContexto = (Integer) contexto.getAttribute("numeroGuardado");

        // Configurar tipo de contenido
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Si es la primera vez (no hay número en el contexto)
        if (numeroContexto == null) {
            contexto.setAttribute("numeroGuardado", numeroAleatorio);
            out.println("<h2>Primera ejecución</h2>");
            out.println("<p>Número guardado en contexto: " + numeroAleatorio + "</p>");
        } else {
            // Comparar números
            if (numeroAleatorio == numeroContexto) {
                out.println("<h2>Aleatorio: " + numeroAleatorio +
                        ". Contexto: " + numeroContexto +
                        ". Números iguales</h2>");
            } else {
                out.println("<h2>Aleatorio: " + numeroAleatorio +
                        ". Contexto: " + numeroContexto +
                        ". Números distintos</h2>");
            }

            // Actualizar el contexto con el nuevo número
            contexto.setAttribute("numeroGuardado", numeroAleatorio);
        }
    }
}