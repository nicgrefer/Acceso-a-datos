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
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; margin: 40px; background-color: #f5f5f5; }");
        out.println(".container { max-width: 800px; margin: 0 auto; background: white; padding: 30px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); }");
        out.println("h1 { color: #333; border-bottom: 3px solid #4CAF50; padding-bottom: 10px; }");
        out.println("h2 { color: #555; margin-top: 30px; }");
        out.println("form { margin: 20px 0; padding: 20px; background: #f9f9f9; border-radius: 5px; }");
        out.println("label { display: block; margin: 10px 0 5px; font-weight: bold; color: #555; }");
        out.println("input[type='text'] { width: 100%; padding: 10px; border: 1px solid #ddd; border-radius: 4px; box-sizing: border-box; }");
        out.println("input[type='submit'] { background-color: #4CAF50; color: white; padding: 12px 30px; border: none; border-radius: 4px; cursor: pointer; margin-top: 15px; font-size: 16px; }");
        out.println("input[type='submit']:hover { background-color: #45a049; }");
        out.println(".tarea { padding: 15px; margin: 10px 0; background: #e8f5e9; border-left: 4px solid #4CAF50; border-radius: 4px; }");
        out.println(".tarea-id { font-weight: bold; color: #2e7d32; }");
        out.println(".empty { color: #999; font-style: italic; padding: 20px; text-align: center; }");
        out.println(".success { color: #4CAF50; padding: 10px; background: #e8f5e9; border-radius: 4px; margin: 10px 0; }");
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