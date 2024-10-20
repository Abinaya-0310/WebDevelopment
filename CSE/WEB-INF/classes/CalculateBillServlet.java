import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculateBillServlet")
public class CalculateBillServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double pastaPrice = 10.0;
        double burgerPrice = 8.0;
        double pizzaPrice = 12.0;
        double coffeePrice = 5.0;

        double totalAmount = 0.0;
        String[] selectedItems = request.getParameterValues("item");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Bill Summary</h1>");
        out.println("<table border='1'>");
        out.println("<tr><th>Item</th><th>Quantity</th><th>Total</th></tr>");
        if (selectedItems != null) {
            for (String item : selectedItems) {
                switch (item) {
                    case "Pasta":
                        int pastaQty = Integer.parseInt(request.getParameter("pasta_qty"));
                        double pastaTotal = pastaPrice * pastaQty;
                        totalAmount += pastaTotal;
                        if (pastaQty > 0) out.println("<tr><td>Pasta</td><td>" + pastaQty + "</td><td>$" + pastaTotal + "</td></tr>");
                        break;
                    case "Burger":
                        int burgerQty = Integer.parseInt(request.getParameter("burger_qty"));
                        double burgerTotal = burgerPrice * burgerQty;
                        totalAmount += burgerTotal;
                        if (burgerQty > 0) out.println("<tr><td>Burger</td><td>" + burgerQty + "</td><td>$" + burgerTotal + "</td></tr>");
                        break;
                    case "Pizza":
                        int pizzaQty = Integer.parseInt(request.getParameter("pizza_qty"));
                        double pizzaTotal = pizzaPrice * pizzaQty;
                        totalAmount += pizzaTotal;
                        if (pizzaQty > 0) out.println("<tr><td>Pizza</td><td>" + pizzaQty + "</td><td>$" + pizzaTotal + "</td></tr>");
                        break;
                    case "Coffee":
                        int coffeeQty = Integer.parseInt(request.getParameter("coffee_qty"));
                        double coffeeTotal = coffeePrice * coffeeQty;
                        totalAmount += coffeeTotal;
                        if (coffeeQty > 0) out.println("<tr><td>Coffee</td><td>" + coffeeQty + "</td><td>$" + coffeeTotal + "</td></tr>");
                        break;
                }
            }
        }

        out.println("<tr><td colspan='2'>Total Amount</td><td>$" + totalAmount + "</td></tr>");
        out.println("</table>");
        out.println("<br><a href='menu.html'>Back to Menu</a>");
        out.println("</body></html>");
    }
}
