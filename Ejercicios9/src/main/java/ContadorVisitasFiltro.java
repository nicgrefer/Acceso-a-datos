import java.io.IOException;
import java.util.HashMap;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class ContadorVisitasFiltro implements Filter {
    private static final String ATRIBUTO_VISITAS = "contadorVisitas";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext context = filterConfig.getServletContext();
        // Inicializar el HashMap si no existe
        if (context.getAttribute(ATRIBUTO_VISITAS) == null) {
            context.setAttribute(ATRIBUTO_VISITAS, new HashMap<String, Integer>());
            System.out.println("Filtro de contador de visitas inicializado");
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        ServletContext context = request.getServletContext();
        
        // Construir la URL completa
        String url = httpRequest.getScheme() + "://" +
                     httpRequest.getServerName() + ":" +
                     httpRequest.getServerPort() +
                     httpRequest.getRequestURI();
        
        // Obtener el HashMap del contexto
        HashMap<String, Integer> contadorVisitas = 
            (HashMap<String, Integer>) context.getAttribute(ATRIBUTO_VISITAS);
        
        // Incrementar el contador para esta URL
        synchronized (contadorVisitas) {
            Integer visitas = contadorVisitas.get(url);
            if (visitas == null) {
                contadorVisitas.put(url, 1);
            } else {
                contadorVisitas.put(url, visitas + 1);
            }
        }
        
        // Continuar con la cadena de filtros
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("Filtro de contador de visitas destruido");
    }
}