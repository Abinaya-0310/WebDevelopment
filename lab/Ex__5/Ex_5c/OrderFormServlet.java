import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/OrderFormServlet")
public class OrderFormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String cuisine = request.getParameter("cuisine");
        String quantity = request.getParameter("quantity");
        String sessionTracking = request.getParameter("sessionTracking");

        // Process based on the selected session tracking method
        switch (sessionTracking) {
            case "cookies":
                handleCookiesSession(request, response, name, cuisine, quantity);
                break;
            case "hiddenFields":
                handleHiddenFieldsSession(request, response, name, cuisine, quantity);
                break;
            case "urlRewriting":
                handleUrlRewritingSession(request, response, name, cuisine, quantity);
                break;
            case "httpSession":
                handleHttpSession(request, response, name, cuisine, quantity);
                break;
            default:
                response.getWriter().println("Invalid session tracking method");
        }
    }

    // Method to handle Cookies session tracking
    private void handleCookiesSession(HttpServletRequest request, HttpServletResponse response, String name, String cuisine, String quantity) throws IOException {
        Cookie nameCookie = new Cookie("name", name);
        Cookie cuisineCookie = new Cookie("cuisine", cuisine);
        Cookie quantityCookie = new Cookie("quantity", quantity);

        response.addCookie(nameCookie);
        response.addCookie(cuisineCookie);
        response.addCookie(quantityCookie);

        response.sendRedirect("cookiesConfirmation");
    }

    // Method to handle Hidden Fields session tracking
    private void handleHiddenFieldsSession(HttpServletRequest request, HttpServletResponse response, String name, String cuisine, String quantity) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<form action='hiddenFieldsConfirmation' method='post'>");
        response.getWriter().println("<input type='hidden' name='name' value='" + name + "'>");
        response.getWriter().println("<input type='hidden' name='cuisine' value='" + cuisine + "'>");
        response.getWriter().println("<input type='hidden' name='quantity' value='" + quantity + "'>");
        response.getWriter().println("<input type='submit' value='Confirm Order'>");
        response.getWriter().println("</form></body></html>");
    }

    // Method to handle URL Rewriting session tracking
    private void handleUrlRewritingSession(HttpServletRequest request, HttpServletResponse response, String name, String cuisine, String quantity) throws IOException {
        response.sendRedirect("urlRewritingConfirmation?name=" + name + "&cuisine=" + cuisine + "&quantity=" + quantity);
    }

    // Method to handle HttpSession session tracking
    private void handleHttpSession(HttpServletRequest request, HttpServletResponse response, String name, String cuisine, String quantity) throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute("name", name);
        session.setAttribute("cuisine", cuisine);
        session.setAttribute("quantity", quantity);

        response.sendRedirect("sessionConfirmation");
    }
}
