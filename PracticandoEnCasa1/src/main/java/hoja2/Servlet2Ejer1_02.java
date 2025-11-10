package hoja2;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Servlet2Ejer1_02
 */
@WebServlet("/Servlet2Ejer1_02")
public class Servlet2Ejer1_02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String paramColor;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2Ejer1_02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		paramColor = config.getServletContext().getInitParameter("paramColor");
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		
		String color = request.getParameter("color");
		
		if (color == null) {
			color = paramColor;
		}
		
		response.getWriter().append("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Document</title>\r\n"
				+ "    <style>\r\n"
				+ "        body {\r\n"
				+ "			background-color: " + color + ";"
				+ "        }\r\n"
				+ "    </style>\r\n"
				+ "</head>\r\n"
				+ "\r\n"
				+ "<body>\r\n"
				+ "    \r\n"
				+ "</body>\r\n"
				+ "</html>");
	}

}
