import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Connection conn = null;
        PreparedStatement stmt = null;
        int rowsInserted = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_db", "root", "");
            String sql = "INSERT INTO Users (name, email, password) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            rowsInserted = stmt.executeUpdate();
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            
            // Send the response back to the client
            if (rowsInserted > 0) {
                response.sendRedirect("login.html");
            } else {
                out.println("<h1>Registration failed. Please try again.</h1>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1>Database error: " + e.getMessage() + "</h1>");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1>MySQL JDBC Driver not found!</h1>");
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
