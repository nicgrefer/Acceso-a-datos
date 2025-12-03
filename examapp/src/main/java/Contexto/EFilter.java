package Contexto;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import java.util.Map;

@WebFilter("/*")
public class EFilter extends HttpFilter implements Filter {

    public EFilter() {
        super();
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        StringBuilder buffer = new StringBuilder();
        Map<String, String[]> params = request.getParameterMap();

        for (Map.Entry<String, String[]> entry : params.entrySet()) {

            String key = entry.getKey();
            buffer.append(key).append("=");

            String[] val = entry.getValue();
            for (String v : val) {
                buffer.append(v).append("|");
            }

            buffer.append("  ");
        }

        if (buffer.length() > 0) {
            System.out.println("La petición tiene los siguientes parámetros: " + buffer);
        }

        chain.doFilter(request, response);
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }

}
