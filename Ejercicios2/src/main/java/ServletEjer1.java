

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ServletEjer1
 */
@WebServlet("/ServletEjer1")
public class ServletEjer1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public String colorContext;
	
    public ServletEjer1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		colorContext= config.getInitParameter("color");
		getServletContext().setAttribute("color", colorContext);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nuevoColor = request.getParameter("color");
        if (nuevoColor != null && !nuevoColor.isEmpty()) {
            colorContext = nuevoColor;
            getServletContext().setAttribute("color", colorContext);
        }

        response.setContentType("text/html;charset=UTF-8");

        response.getWriter()
            .append("<html>")
            .append("<head><title>Color Servlet</title></head>")
            .append("<body style='background-color:" + colorContext + ";'>")
            .append("<h1>Color actual: " + colorContext + "</h1>")
            .append("<form action='ServletEjer1V2' method='get'>")
            .append("<button type='submit'>Ir al segundo servlet</button>")
            .append("</form>")
            .append("</body>")
            .append("</html>");
    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
