import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ServletEjer7")
public class ServletEjer7 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public ServletEjer7() {
        super();
    }

    @Override
    public void init() throws ServletException {
        // Inicializar el contexto con contadores individuales
        ServletContext context = getServletContext();
        if (context.getAttribute("contadorFiebre") == null) {
            context.setAttribute("contadorFiebre", 0);
            context.setAttribute("contadorTos", 0);
            context.setAttribute("contadorDiarrea", 0);
            context.setAttribute("contadorOlfato", 0);
            context.setAttribute("contadorDolor", 0);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        // Verificar si el usuario ya realizó el test mediante cookies
        Cookie[] cookies = request.getCookies();
        boolean yaRealizado = false;
        
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("testRealizado") && 
                    cookie.getValue().equals("true")) {
                    yaRealizado = true;
                    break;
                }
            }
        }
        
        // Si ya realizó el test, mostrar mensaje y no procesar
        if (yaRealizado) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang='es'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>Test COVID-19 - Error</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; }");
            out.println("h3 { margin-bottom: 5px; }");
            out.println("hr { border: 2px solid blue; }");
            out.println(".mensaje-error { color: red; font-weight: bold; margin: 20px 0; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>TEST COVID-19</h3>");
            out.println("<hr>");
            out.println("<p class='mensaje-error'>Usted ya ha realizado el test. No puede repetirlo.</p>");
            out.println("<hr>");
            out.println("</body>");
            out.println("</html>");
            return;
        }
        
        // Obtener los síntomas seleccionados
        String[] sintomas = request.getParameterValues("sintoma");
        
        // Obtener el contexto
        ServletContext context = getServletContext();
        
        // Actualizar las estadísticas si se seleccionaron síntomas
        if (sintomas != null && sintomas.length > 0) {
            for (String sintoma : sintomas) {
                if (sintoma.equals("fiebre")) {
                    int contador = (Integer) context.getAttribute("contadorFiebre");
                    context.setAttribute("contadorFiebre", contador + 1);
                } else if (sintoma.equals("tos seca")) {
                    int contador = (Integer) context.getAttribute("contadorTos");
                    context.setAttribute("contadorTos", contador + 1);
                } else if (sintoma.equals("diarrea")) {
                    int contador = (Integer) context.getAttribute("contadorDiarrea");
                    context.setAttribute("contadorDiarrea", contador + 1);
                } else if (sintoma.equals("perdida de olfato")) {
                    int contador = (Integer) context.getAttribute("contadorOlfato");
                    context.setAttribute("contadorOlfato", contador + 1);
                } else if (sintoma.equals("dolor muscular")) {
                    int contador = (Integer) context.getAttribute("contadorDolor");
                    context.setAttribute("contadorDolor", contador + 1);
                }
            }
            
            // Crear cookie para indicar que ya realizó el test
            Cookie cookie = new Cookie("testRealizado", "true");
            cookie.setMaxAge(60 * 60 * 24); // 24 horas
            response.addCookie(cookie);
        }
        
        // Obtener los contadores actualizados
        int contadorFiebre = (Integer) context.getAttribute("contadorFiebre");
        int contadorTos = (Integer) context.getAttribute("contadorTos");
        int contadorDiarrea = (Integer) context.getAttribute("contadorDiarrea");
        int contadorOlfato = (Integer) context.getAttribute("contadorOlfato");
        int contadorDolor = (Integer) context.getAttribute("contadorDolor");
        
        // Generar la página HTML con la tabla de resultados
        out.println("<!DOCTYPE html>");
        out.println("<html lang='es'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Test COVID-19 - Resultados</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; }");
        out.println("h3 { margin-bottom: 5px; }");
        out.println("hr { border: 2px solid blue; }");
        out.println("table { border-collapse: collapse; margin-top: 20px; width: 50%; }");
        out.println("th, td { border: 1px solid black; padding: 8px; text-align: left; }");
        out.println("th { background-color: #4CAF50; color: white; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>TEST COVID-19 - ESTADÍSTICAS</h3>");
        out.println("<hr>");
        
        if (sintomas != null && sintomas.length > 0) {
            out.println("<p>Gracias por completar el test. Sus datos han sido registrados.</p>");
        }
        
        out.println("<table>");
        out.println("<tr><th>Síntomas</th><th>Número Personas</th></tr>");
        out.println("<tr><td>Fiebre</td><td>" + contadorFiebre + "</td></tr>");
        out.println("<tr><td>Tos Seca</td><td>" + contadorTos + "</td></tr>");
        out.println("<tr><td>Diarrea</td><td>" + contadorDiarrea + "</td></tr>");
        out.println("<tr><td>Perdida de Olfato</td><td>" + contadorOlfato + "</td></tr>");
        out.println("<tr><td>Dolor Muscular</td><td>" + contadorDolor + "</td></tr>");
        out.println("</table>");
        out.println("<hr>");
        out.println("</body>");
        out.println("</html>");
    }
}