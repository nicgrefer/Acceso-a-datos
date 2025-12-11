import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Servlet implementation class ServletEjer1
 */
@WebServlet("/ServletEjer1")
public class ServletEjer1 extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEjer1() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        HashMap<String, Tarea> notificaciones = 
            (HashMap<String, Tarea>) getServletContext().getAttribute("notificaciones");
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Gestión de Tareas</title>");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h1>Sistema de Gestión de Tareas</h1>");
        
        // Mostrar mensaje de éxito si se agregó una tarea
        String mensaje = request.getParameter("msg");
        if ("ok".equals(mensaje)) {
            out.println("<div class='success'>✓ Tarea agregada correctamente</div>");
        }
        
        // Formulario para agregar tareas
        // CORRECCIÓN: Cambiar action='tareas' por action='ServletEjer1'
        out.println("<form method='post' action='ServletEjer1'>");
        out.println("<label for='id'>Identificador de Tarea (T1, T2, ...):</label>");
        out.println("<input type='text' id='id' name='id' required placeholder='Ej: T1'>");
        out.println("<label for='descripcion'>Descripción:</label>");
        out.println("<input type='text' id='descripcion' name='descripcion' required placeholder='Descripción de la tarea'>");
        out.println("<input type='submit' value='Agregar Tarea'>");
        out.println("</form>");
        
        // Mostrar tareas existentes
        out.println("<h2>Tareas Registradas (" + notificaciones.size() + ")</h2>");
        
        if (notificaciones.isEmpty()) {
            out.println("<div class='empty'>No hay tareas registradas todavía</div>");
        } else {
            for (Tarea tarea : notificaciones.values()) {
                out.println("<div class='tarea'>");
                out.println("<span class='tarea-id'>" + tarea.getId() + "</span>: ");
                out.println(tarea.getDescripcion());
                out.println("</div>");
            }
        }
        
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String id = request.getParameter("id");
        String descripcion = request.getParameter("descripcion");
        
        HashMap<String, Tarea> notificaciones = 
            (HashMap<String, Tarea>) getServletContext().getAttribute("notificaciones");
        
        Tarea nuevaTarea = new Tarea(id, descripcion);
        notificaciones.put(id, nuevaTarea);
        

        response.sendRedirect("ServletEjer1?msg=ok");
    }
}