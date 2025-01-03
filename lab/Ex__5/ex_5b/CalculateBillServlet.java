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
        // Prices for each dish
        double[] prices = {
            100, 150, 130, 120, 150, 100, 200, 150, 200, 120, 
            150, 100, 100, 120, 150, 100, 150, 200, 100, 100, 
            80, 100, 150, 200, 80, 100, 150, 100, 120, 200, 
            100, 80, 80, 120, 100, 150, 100, 150, 80, 200, 
            120, 100, 100, 90, 100, 150, 100
        };
        
        String[] items = {
            "Pizza", "Spaghetti", "Truffle Pasta", "Mushroom Risotto", "Moussaka", "Greek Salad", "Spanakopita", 
            "Dolmades", "Paella", "Patatas Bravas", "Gazpacho", "Churros", "Sausage", "Currywurst", "Schnitzel", 
            "Tom Yum Goong", "Pad Thai", "Khao Pad", "Sushi", "Spring Roll", "Mapo Tofu", "Borshch", "Deruny", 
            "Holubtsi", "French Onion Soup", "Croissant", "Chocolate Truffle", "Tacos", "Guacamole", "Enchiladas", 
            "Noodles", "Spring Roll", "Mapo Tofu", "Biriyani", "Butter Chicken", "Tandoori Chicken", "Cheese Burger", 
            "Apple Pie", "Hot Dog", "Khachapuri", "Shaslik", "Kharcho", "Dumplings", "Blini", "Fish and Chips", 
            "Shepherd's Pie", "Yorkshire Pudding"
        };

        double totalAmount = 0.0;
        String[] selectedItems = request.getParameterValues("item");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Bill Summary</h1>");
        out.println("<table border='1'>");
        out.println("<tr><th>Item</th><th>Quantity</th><th>Total</th></tr>");

        if (selectedItems != null) {
            for (int i = 0; i < items.length; i++) {
                String item = items[i];
                double itemPrice = prices[i];
                String itemQtyParam = item.toLowerCase().replaceAll(" ", "_") + "_qty";
                
                if (isItemSelected(selectedItems, item)) {
                    int quantity = Integer.parseInt(request.getParameter(itemQtyParam));
                    double itemTotal = itemPrice * quantity;
                    totalAmount += itemTotal;
                    
                    if (quantity > 0) {
                        out.println("<tr><td>" + item + "</td><td>" + quantity + "</td><td>₹" + itemTotal + "</td></tr>");
                    }
                }
            }
        }

        out.println("<tr><td colspan='2'>Total Amount</td><td>₹" + totalAmount + "</td></tr>");
        out.println("</table>");
        out.println("<br><a href='menu.html'>Back to Menu</a>");
        out.println("</body></html>");
    }

    // Helper method to check if an item is selected
    private boolean isItemSelected(String[] selectedItems, String item) {
        for (String selectedItem : selectedItems) {
            if (selectedItem.equalsIgnoreCase(item)) {
                return true;
            }
        }
        return false;
    }
}
