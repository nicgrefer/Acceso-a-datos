package controler;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Incidencia;

/**
 * Servlet implementation class ServletIncidencia
 */
@WebServlet("/ServletIncidencia")
public class ServletIncidencia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletIncidencia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Incidencia> listaIncidencias = getServletContext().getAttribute("listInc") != null?
				(ArrayList<Incidencia>)getServletContext().getAttribute("listInc") : new ArrayList<Incidencia>();
		
		String page = "";
		switch (request.getParameter("boton") ) {
		case "Confirmar": {
			if (!request.getParameter("tema").isBlank() && !request.getParameter("descripcion").isBlank()) {
				if (listaIncidencias.size()<20) {
					Incidencia inc = new Incidencia(request.getParameter("tema"), request.getParameter("descripcion"));
					inc.setCodigo();
					listaIncidencias.add(inc);
					getServletContext().setAttribute("listInc", listaIncidencias);
					request.setAttribute("codigoInc", inc.getCodigo());
				}else {
					request.setAttribute("codigoInc", "0");
				}
			}else{// No introducr tema y descripcion
				request.setAttribute("error", true);
			}
			page = "Incidencia.jsp";
			break;
		}
		case "Consultar": {
			page = "ConsultarIncidencia.jsp";
			break;
		}case "Volver": {
			page = "AltaIncidencia.jsp";
			break;
		}
		
		default:
			break;
		}
		
	}

}
