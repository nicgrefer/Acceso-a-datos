package controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import com.sun.swing.internal.plaf.basic.resources.basic;

@WebServlet("/ServletCotizacion")
public class ServletCotizacion extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final Object lock = new Object();
    private static String pinDiario = "123456";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        HashMap<String, Cotizacion> cotizaciones = new HashMap<>();
        cotizaciones.put("DAM", new Cotizacion("DAM", 48.5));
        cotizaciones.put("SMR", new Cotizacion("SMR", 47.5));
        cotizaciones.put("ADFI", new Cotizacion("ADFI", 30.0));
        cotizaciones.put("ADMINI", new Cotizacion("ADMINI", 45.0));
        cotizaciones.put("VENTAS", new Cotizacion("VENTAS", 19.5));
        cotizaciones.put("TURISMO", new Cotizacion("TURISMO", 19.5));
        cotizaciones.put("ISOCIAL", new Cotizacion("ISOCIAL", 37.5));
        cotizaciones.put("EDINF", new Cotizacion("EDINF", 23.0));
        cotizaciones.put("LABCIN", new Cotizacion("LABCIN", 52.0));
        cotizaciones.put("FARMACIA", new Cotizacion("FARMACIA", 35.6));
        cotizaciones.put("ATENCION", new Cotizacion("ATENCION", 35.6));
        cotizaciones.put("IA", new Cotizacion("IA", 58.0));

        synchronized (lock) {
            config.getServletContext().setAttribute("listaCotiza", cotizaciones);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
/*
        String boton = request.getParameter("boton");
        String nombre = request.getParameter("nombre");
        String codigo = request.getParameter("password");
       */ 

    	String msj = "";
        String pag = "";
        ServletContext sc = getServletConfig().getServletContext();
        HashMap<String, Cotizacion> cotizaciones = (HashMap<String, Cotizacion>) sc.getAttribute("listaCotiza");
        HttpSession sesion = new HttpSession();
        
        switch (request.getParameter("boton")) {
		case "Acceso": {
			if (!request.getParameter("nombre").isEmpty() || !request.getParameter("password").isBlank()) {
				msj = "(*) El nombre y el código pin son obligatorios";
				pag = "/Acceso.jsp";
			}else if (!request.getParameter("password").equalsIgnoreCase("123456")) {
				msj = "(*) Las credenciales son incorrectos";
				pag = "/Acceso.jsp";
			}else {
				synchronized (lock) {
					sesion.setAttrinute()
				}
			}
			break;
		}
		case "Cerrar" :{
			sesion.invalidate();
			pag = "/Acceso.jsp";
			break;
		}
		case "Enviar" : {
			Enumeration<String> parms = request.getParameterNames();
			while (parms.hasMoreElements()) {
				String type = parms.nextElement();
				String valor  = request.getParameter(type);
				Cotizacion c;
				if (!type.equals("boton")) {
					c = new Cotizacion(type, cotizaciones.get(type).getActual(),Double.valueOf(valor));
					c.setEvalua();
					cotizaciones.put(type, c);
				}
				
			}
			break;
		}
		default:
			break;
		}
        
/*
        // Si pulsó "Cerrar"
        if ("Cerrar".equals(boton)) {
            request.getSession().invalidate();
            response.sendRedirect("Acceso.jsp");
            return;
        }

        // Validación de campos obligatorios
        if (nombre == null || codigo == null || nombre.isBlank() || codigo.isBlank()) {
            request.setAttribute("mensaje", "(*) El nombre y el código pin son obligatorios");
            request.getRequestDispatcher("Acceso.jsp").forward(request, response);
            return;
        }else {
        	// Ningun dato bacio
        	if (!codigo.equals(pinDiario)) {
        		 request.setAttribute("mensaje", "(*) El nombre o el código pin son incorrectos");
                 request.getRequestDispatcher("Acceso.jsp").forward(request, response);
                 return;
        	}else {
        		request.getRequestDispatcher("Cotizacion.jsp").forward(request, response);
        	}
        }3
        */

    }
}
