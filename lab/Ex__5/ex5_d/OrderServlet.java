import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class OrderServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Connection conn = null;
        PreparedStatement stmt = null;
        PrintWriter out = response.getWriter();
        int userId = Integer.parseInt(request.getParameter("user_id"));
        String orderDetails = request.getParameter("order_details");
        double totalPrice = Double.parseDouble(request.getParameter("total_price"));

        try {
            Class.forName("com.mysql.jdbc.Driver"); // Updated driver for MySQL 8 and above
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_db", "root", "");

            if (conn != null) {
                out.println("<h1>Connection Successful!</h1>");
            }
            String sql = "INSERT INTO Orders (user_id, order_details, total_price, order_date) VALUES (?, ?, ?, NOW())";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            stmt.setString(2, orderDetails);
            stmt.setDouble(3, totalPrice);
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                out.println("<h2>Order placed successfully!</h2>");
            } else {
                out.println("<h2>Failed to place the order. Please try again.</h2>");
            }

        } catch (Exception e) {
            out.println("<h2>Database Error: " + e.getMessage() + "</h2>");
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                out.println("<h2>Failed to close resources: " + e.getMessage() + "</h2>");
            }
        }
    }
}
