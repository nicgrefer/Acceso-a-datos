
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/almacenar")
public class almacenar extends HttpServlet {
    
    // Lock para sincronización
    private final Object lock = new Object();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String numeroParam = request.getParameter("numero");
        
        if (numeroParam == null || numeroParam.isEmpty()) {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("<h3>Error: Debe proporcionar un número</h3>");
            response.getWriter().println("<p>Ejemplo: /almacenar?numero=123</p>");
            return;
        }
        
        int numero;
        try {
            numero = Integer.parseInt(numeroParam);
        } catch (NumberFormatException e) {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("<h3>Error: Debe ser un número válido</h3>");
            return;
        }
        
        ServletContext context = getServletContext();
        
        // CONTROL DE CONCURRENCIA: Sincronizamos el acceso al contexto
        synchronized (lock) {
            // Guardamos el número en el contexto
            context.setAttribute("numeroAlmacenado", numero);
            context.setAttribute("timestamp", System.currentTimeMillis());
            context.setAttribute("thread", Thread.currentThread().getName());
            
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("<h2>Número almacenado: " + numero + "</h2>");
            response.getWriter().println("<p>Thread: " + Thread.currentThread().getName() + "</p>");
            response.getWriter().println("<p>Simulando operación de 10 segundos...</p>");
            response.flushBuffer(); // Forzar envío al navegador
            
            // Simulamos una operación que tarda 10 segundos
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            response.getWriter().println("<p>Operación completada. Redirigiendo...</p>");
        }
        
        // Despachamos al segundo servlet
        request.getRequestDispatcher("/mostrar").forward(request, response);
    }
}