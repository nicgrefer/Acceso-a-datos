package Contexto;

import java.util.Date;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class Sesiones
 *
 */
@WebListener
public class EListenerSesiones implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public EListenerSesiones() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	HttpSession session = se.getSession();
    	System.out.println("A las "+ new Date(System.currentTimeMillis()).toString() 
    			+ " se creó la desion con el id " + session.getId());
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	HttpSession session = se.getSession();
    	System.out.println("A las "+ new Date(System.currentTimeMillis()).toString() 
    			+ " se destruyo la desion con el id " + session.getId());
    }
	
}
