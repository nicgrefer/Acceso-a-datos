package xampp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/ServletConexion")
public class ServletConexion extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Connection conn;

    public ServletConexion() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/pruebas", "root", "");

            if (conn != null) {
                System.out.println("Conexion correcta a la base de datos");
                response.getWriter().append("Conexion correcta");
            } else {
                System.err.println("Conexion fallida");
                response.getWriter().append("Conexion fallida");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("No se encontró el driver MySQL");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error SQL al conectar");
        }
    }
}
