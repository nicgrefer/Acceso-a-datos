package hoja1;

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
    public ServletEjer1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		String accion = request.getParameter("boton");
		String lengua = request.getParameter("idioma");
		

        response.getWriter().append("<html><body>");

        if ("saludo".equals(accion)) {
        	if (lengua.isEmpty()) {
        		response.getWriter().append("<h2>No seleccionastes ningun idioma</h2>");
        	}else {
        		switch (lengua) {
					case "es": {
						response.getWriter().append("<h2>Hola mundo</h2>");
						return;
					}
					case "ing":{
						response.getWriter().append("<h2>Hellow word</h2>");
						return;
					}
					case "fr":{
						response.getWriter().append("<h2>Hola mundo en frances</h2>");
					}
        		}
        	}
        	
        }else {

        response.getWriter().append("<form method='get'>"
                + "<button type='submit' name='boton' value='saludo'>Salúdame</button>"
        		+ "<br/>"
        		+ "idioma (es,ing, fr) <input type='text' name='idioma'/>"
                + "</form>");
        }
        response.getWriter().append("</body></html>");
        
        response.getWriter().close();
        
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
;