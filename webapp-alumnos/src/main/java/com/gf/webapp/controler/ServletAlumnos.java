package com.gf.webapp.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.gf.webapp.In.AlumnoLN;
import com.gf.webapp.entity.Alumno;

/**
 * Servlet implementation class ServletAlumnos
 */
@WebServlet("/ServletAlumnos")
public class ServletAlumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlumnos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String b =  request.getParameter("boton");
		String envio = "";
		
		if ("Alta".equalsIgnoreCase(b)) {
			envio = "AltaAlumno.jsp";
		} else if ("Baja".equalsIgnoreCase(b)) {
			envio = "BajaAlumno.jsp";
		} else if ("Actualizar".equalsIgnoreCase(b)) {
			envio = "ActualizaAlumno.jsp";
		} else if ("Consulta".equalsIgnoreCase(b)) {
			envio = "ConsultaAlumno.jsp";
		}
		request.getRequestDispatcher(envio).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bt = request.getParameter("boton");
		boolean error  = false;
		String msg = "";
		String page = "";
		
		// REcogida de los parametros del formulario
		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellidos");
		String ciclo = request.getParameter("ciclo");
		String curso = request.getParameter("curso");
		Alumno al = new Alumno(nombre,apellido,curso,ciclo);
		
		try {
		switch (bt) {
			case "Alta": {
				// LLamada al LN
				msg = AlumnoLN.alta(al);
				page= "Menu.jsp";
				break;
			}
		}
		}catch (Exception e) {
			error = true;
			System.err.println("ServletAlumnos: Se ha producido un error");
			e.printStackTrace();
		}finally {
			if ("Valor".equals(bt)) {
				page = "Menu.jsp";
			}else {
				if (error) {
					msg= "Error al realizar el/la " + bt;
				}
				request.setAttribute("mesnaje", msg);
			}
			request.getRequestDispatcher(page).forward(request, response);
		}
		
	}
	

}
