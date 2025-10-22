import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ServletEjer3")
public class ServletEjer3 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ServletEjer3() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        StringBuilder html = new StringBuilder();
        String libro = request.getParameter("libro");
        String cantidadStr = request.getParameter("cantidad");
        String boton = request.getParameter("boton");
        int cantidad = 0;

        // Parsear cantidad
        if (cantidadStr != null && !cantidadStr.isEmpty()) {
            try {
                cantidad = Integer.parseInt(cantidadStr);
            } catch (NumberFormatException e) {
                cantidad = 0;
            }
        }

        // Si presiona "Ver compra", mostrar el resumen directamente
        if (boton != null && boton.equals("verTiket")) {
            html.append("<h1>Bienvenido a Web Librería</h1>")
                .append("<h2>Resumen de la compra</h2>")
                .append("<table border='1'>")
                .append("<tr><th>Libro</th><th>Cantidad</th><th>Precio Unitario</th><th>Subtotal</th></tr>");

            double total = 0.0;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().startsWith("compra_")) {
                        String[] compra = cookie.getValue().split("-");
                        if (compra.length >= 3) {
                            String libroCompra = compra[0];
                            int cant = Integer.parseInt(compra[1]);
                            double precioUnitario = Double.parseDouble(compra[2]);
                            double subtotal = cant * precioUnitario;
                            total += subtotal;
                            html.append("<tr>")
                                .append("<td>").append(libroCompra).append("</td>")
                                .append("<td>").append(cant).append("</td>")
                                .append("<td>").append(precioUnitario).append("</td>")
                                .append("<td>").append(subtotal).append("</td>")
                                .append("</tr>");
                        }
                    }
                }
            }
            html.append("<tr><td colspan='3'><strong>Total</strong></td><td><strong>")
                .append(String.format("%.2f", total))
                .append("</strong></td></tr>")
                .append("</table>")
                .append("<br>")
                .append("<form method='get' action='ServletEjer3'>")
                .append("<button type='submit' name='boton' value='comproMas'>Seguir comprando</button>")
                .append("</form>");
        }
        // Mostrar formulario de selección si no hay libro válido, cantidad válida o se selecciona "Seguir comprando"
        else if (libro == null || libro.isEmpty() || cantidad < 1 || (boton != null && boton.equals("comproMas"))) {
            html.append("<h1>Bienvenido a Web Librería. Seleccione el libro</h1>")
                .append("<h3>")
                .append("<form method='get' action='ServletEjer3'>")
                .append("Lista de libros <select name='libro'>")
                .append("<option value='java'>Java</option>")
                .append("<option value='c'>C</option>")
                .append("<option value='c++'>C++</option>")
                .append("<option value='vb'>VB</option>")
                .append("<option value='python'>Python</option>")
                .append("</select>")
                .append(" Unidades: <input type='text' name='cantidad'/>")
                .append(" <button type='submit'>Enviar</button>")
                .append("</form>")
                .append("</h3>");
        } else {
            // Libro y cantidad válidos seleccionados
            String precio = obtenerPrecio(libro);
            // Guardar compra en una cookie
            String valorCookie = libro + "-" + cantidad + "-" + precio;
            Cookie cookieCompra = new Cookie("compra_" + System.currentTimeMillis(), valorCookie);
            cookieCompra.setMaxAge(24 * 60 * 60); // Cookie expira en 1 día
            response.addCookie(cookieCompra);

            html.append("<h1>Bienvenidos a Web Librería. Usted seleccionó ").append(libro).append("</h1>")
                .append("<form method='get' action='ServletEjer3'>")
                .append("<button type='submit' name='boton' value='comproMas'>Seguir comprando</button>")
                .append("<button type='submit' name='boton' value='verTiket'>Ver compra</button>")
                .append("</form>");
        }

        response.getWriter().write(html.toString());
    }

    private String obtenerPrecio(String libro) {
        switch (libro) {
            case "java":
                return "25.50";
            case "c":
                return "22.00";
            case "c++":
                return "28.00";
            case "vb":
                return "20.00";
            case "python":
                return "30.00";
            default:
                return "0.00";
        }
    }
}