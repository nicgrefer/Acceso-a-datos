import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ServletEjer6
 */
@WebServlet("/ServletEjer6")
public class ServletEjer6 extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEjer6() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String funcion = request.getParameter("galleta");
        String nombre = request.getParameter("nombre");
        
        Cookie[] cookies = request.getCookies();
        
        // Si no hay función seleccionada, mostrar solo el formulario
        if (funcion == null) {
            out.println("<html><head><title>Gestión de Galletas</title></head><body>");
            out.println("<h2>Gestión de Galletas</h2>");
            out.println("<form method='get'>");
            out.println("<fieldset>");
            out.println("<p>¿Qué galleta quieres? <input type='text' name='nombre'></p>");
            out.println("<input type='radio' id='mostrar' name='galleta' value='mostrar'>");
            out.println("<label for='mostrar'>Mostrar Galletas</label><br>");
            out.println("<input type='radio' id='cocinar' name='galleta' value='cocinar'>");
            out.println("<label for='cocinar'>Cocinar Galletas</label><br>");
            out.println("<input type='radio' id='comer' name='galleta' value='comer'>");
            out.println("<label for='comer'>Comer Galletas</label><br><br>");
            out.println("<button type='submit'>Oído Cocina</button>");
            out.println("</fieldset>");
            out.println("</form>");
            out.println("</body></html>");
            return;
        }
        
        // Validar que se ha introducido un nombre para cocinar o comer
        if ((funcion.equals("cocinar") || funcion.equals("comer")) && 
            (nombre == null || nombre.trim().isEmpty())) {
            out.println("<html><head><title>Mensaje</title></head><body>");
            out.println("<h2>No has elegido galleta</h2>");
            out.println("<br><a href='ServletEjer6'>&lt;&lt;Volver</a>");
            out.println("</body></html>");
            return;
        }
        
        // MOSTRAR GALLETAS
        if (funcion.equals("mostrar")) {
            out.println("<html><head><title>Mostrar Galletas</title></head><body>");
            out.println("<h2>Galletas Disponibles</h2>");
            
            boolean hayGalletas = false;
            
            if (cookies != null) {
                out.println("<ul>");
                for (Cookie cookie : cookies) {
                    if (cookie.getName().startsWith("galleta_")) {
                        out.println("<li>" + cookie.getValue() + "</li>");
                        hayGalletas = true;
                    }
                }
                out.println("</ul>");
            }
            
            if (!hayGalletas) {
                out.println("<p>No hay galletas disponibles.</p>");
            }
            
            out.println("<br><a href='ServletEjer6'>&lt;&lt;Volver</a>");
            out.println("</body></html>");
            
        // COCINAR GALLETA
        } else if (funcion.equals("cocinar")) {
            out.println("<html><head><title>Cocinar Galleta</title></head><body>");
            
            boolean existe = false;
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("galleta_" + nombre)) {
                        existe = true;
                        break;
                    }
                }
            }
            
            if (existe) {
                out.println("<h2>La galleta '" + nombre + "' ya existe</h2>");
            } else {
                Cookie nuevaGalleta = new Cookie("galleta_" + nombre, nombre);
                nuevaGalleta.setMaxAge(60 * 60 * 24 * 7); // 7 días
                nuevaGalleta.setPath("/");
                response.addCookie(nuevaGalleta);
                
                out.println("<h2>Galleta '" + nombre + "' cocinada con éxito</h2>");
            }
            
            out.println("<br><a href='ServletEjer6'>&lt;&lt;Volver</a>");
            out.println("</body></html>");
            
        // COMER GALLETA
        } else if (funcion.equals("comer")) {
            out.println("<html><head><title>Comer Galleta</title></head><body>");
            
            boolean encontrada = false;
            
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("galleta_" + nombre)) {
                        cookie.setMaxAge(0);
                        cookie.setPath("/");
                        response.addCookie(cookie);
                        encontrada = true;
                        break;
                    }
                }
            }
            
            if (encontrada) {
                out.println("<h2>Galleta '" + nombre + "' comida con éxito</h2>");
            } else {
                out.println("<h2>No se encontró la galleta '" + nombre + "'</h2>");
            }
            
            out.println("<br><a href='ServletEjer6'>&lt;&lt;Volver</a>");
            out.println("</body></html>");
            
        } else {
            out.println("<html><head><title>Mensaje</title></head><body>");
            out.println("<h2>Opción no válida</h2>");
            out.println("<br><a href='ServletEjer6'>&lt;&lt;Volver</a>");
            out.println("</body></html>");
        }
    }
}