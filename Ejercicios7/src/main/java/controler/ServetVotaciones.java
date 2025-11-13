package controler;

import java.io.IOException;
import java.util.HashMap;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Votacion;

/**
 * Servlet implementation class ServetVotaciones
 */
@WebServlet("/ServetVotaciones")
public class ServetVotaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServetVotaciones() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext sc = getServletConfig().getServletContext();
		HashMap<String, Votacion> mapVotos = sc.getAttribute("mapVotos")!= null? 
				(HashMap<String,Votacion>)sc.getAttribute("mapVotos"): new HashMap<String,Votacion>();
		
		if (sc.getAttribute("numUsers") != null && (Integer)sc.getAttribute("numUsers")>4) {
			mapVotos = new HashMap<String, Votacion>();
			sc.removeAttribute("numUsers");
		}else {
			sc.setAttribute("numUsers", sc.getAttribute("numUsers") == null? 1: (Integer) sc.getAttribute("numUsers"+1));
			String[]candidatos = request.getParameterValues("alumno")!= null? request.getParameterValues("alumno"): new String[] {"Blancos"};
			
			for (String c : candidatos) {
				Votacion v = mapVotos.get(c)!= null ? mapVotos.get(c):new Votacion(c);
				v.setNumVotos();
				mapVotos.put(c, v);
			}
		}
		sc.setAttribute("mapVotos", mapVotos);

		response.sendRedirect("Resultados.jsp");
	}

}
