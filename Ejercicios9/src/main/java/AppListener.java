

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class AppListener
 *
 */
@WebListener
public class AppListener implements ServletContextListener {
    private static final String ARCHIVO_TAREAS = "tareas.dat";
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        HashMap<String, Tarea> notificaciones = new HashMap<>();
        
        // Intentar cargar tareas del archivo
        String rutaArchivo = context.getRealPath("/WEB-INF/" + ARCHIVO_TAREAS);
        File fichero = new File(rutaArchivo);
        
        if (fichero.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(fichero))) {
                notificaciones = (HashMap<String, Tarea>) ois.readObject();
                System.out.println("===========================================");
                System.out.println("Tareas cargadas desde el archivo:");
                System.out.println("===========================================");
                if (notificaciones.isEmpty()) {
                    System.out.println("No hay tareas guardadas");
                } else {
                    for (Tarea tarea : notificaciones.values()) {
                        System.out.println(tarea);
                    }
                }
                System.out.println("===========================================");
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error al cargar tareas: " + e.getMessage());
            }
        } else {
            System.out.println("No existe archivo de tareas previas. Iniciando vacío.");
        }
        
        context.setAttribute("notificaciones", notificaciones);
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        HashMap<String, Tarea> notificaciones = 
            (HashMap<String, Tarea>) context.getAttribute("notificaciones");
        
        // Guardar tareas en el archivo
        String rutaArchivo = context.getRealPath("/WEB-INF/" + ARCHIVO_TAREAS);
        File fichero = new File(rutaArchivo);
        
        // Crear directorio si no existe
        fichero.getParentFile().mkdirs();
        
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(fichero))) {
            oos.writeObject(notificaciones);
            System.out.println("===========================================");
            System.out.println("Tareas guardadas correctamente en el archivo");
            System.out.println("Total de tareas: " + notificaciones.size());
            System.out.println("===========================================");
        } catch (IOException e) {
            System.err.println("Error al guardar tareas: " + e.getMessage());
        }
    }
}