package controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Servlet implementation class ServletCotizacion
 */
@WebServlet("/ServletCotizacion")
public class ServletCotizacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCotizacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    
    private Object lock = new Object();
    
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		HashMap<String, Cotizacion> cotizaciones = new HashMap<String, Cotizacion>();
		cotizaciones.put("DAM", new Cotizacion("DAM", 48.5));
		cotizaciones.put("SMR", new Cotizacion("SMR", 47.5));
		cotizaciones.put("ADFI", new Cotizacion("ADFI", 30.0));
		cotizaciones.put("ADMINI", new Cotizacion("ADMINI", 45.0));
		cotizaciones.put("VENTAS", new Cotizacion("VENTAS", 19.5));
		cotizaciones.put("TURISMO", new Cotizacion("TURISMO", 19.5));
		cotizaciones.put("ISOCIAL", new Cotizacion("ISOCIAL", 37.5));
		cotizaciones.put("EDINF", new Cotizacion("EDINF", 23.0));
		cotizaciones.put("LABCIN", new Cotizacion("LABCIN", 52.0));
		cotizaciones.put("FARMACIA", new Cotizacion("FARMACIA",35.6));
		cotizaciones.put("ATENCION", new Cotizacion("ATENCION", 35.6));
		cotizaciones.put("IA", new Cotizacion("IA", 58.0));
		synchronized (lock) { // Bloque par que no haya problemas de concurrencia al carat los datos
						     // y así un proceso nuevo no "machaca" la concurrencia
			config.getServletContext().setAttribute("listaCotiza", cotizaciones);
		}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
