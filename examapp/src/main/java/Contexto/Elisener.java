package Contexto;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class Elisener
 *
 */
@WebListener
public class Elisener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public Elisener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     * Cuando inicia el contexto
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	System.out.println("Arrancado el contexto de .... " 
    			+ sce.getServletContext().getContextPath()
    			+ " con el siguiente parametro de configuración " 
    			+ sce.getServletContext().getInitParameter("DATOS"));
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     * Cuando acabe el contexto
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	System.out.println("La aplicación del contexto ... "
        +sce.getServletContext().getContextPath()
		+ " con el siguiente parametro de configuración " 
		+ sce.getServletContext().getInitParameter("DATOS")
		+ " se esta deteniendo");
    }
	
}
