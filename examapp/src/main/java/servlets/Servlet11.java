package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Servlet11
 */
@WebServlet("/Servlet11")
public class Servlet11 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int val;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet11() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    private final Object lock = new Object();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//protected synchronized void.... aquí no porque pararia todo el proceso 
		// TODO Auto-generated method stub
		
/*		
 * 		opcion 1 No adecuada porque machaca el valor	

		int val = Integer.parseInt(request.getParameter("param"));
		
		System.out.println("Thtrad:" + Thread.currentThread().getName()+ " es el valor " + val);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/

		// Opcion correcta porque mantiene el valor por la concurrencia
		try {
			synchronized (lock) { // al meterlo aqui solo detenemos estas pocas lineas del codigo haciendo que el resto del codigo del 
								  // doGet se realize y al liberarse esto entra el siguienta
				val = Integer.parseInt(request.getParameter("param"));
				System.out.println("Thtrad:" + Thread.currentThread().getName()+ " es el valor " + val);
				Thread.sleep(10000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thtrad:" + Thread.currentThread().getName()+ " es el valor " + val);
		
	}

}
