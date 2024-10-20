import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/predictor")
public class DeathPredictorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gender = request.getParameter("gender");
        int age = Integer.parseInt(request.getParameter("age"));
        String[] foodChoices = request.getParameterValues("food");
        int totalToxicLevel = 0;
        int totalEnergyLevel = 0;
        if (foodChoices != null) {
            for (String food : foodChoices) {
                switch (food) {
                    case "Broccoli":
                        totalToxicLevel += 1;
                        totalEnergyLevel += 8;
                        break;
                    case "Burger":
                        totalToxicLevel += 7;
                        totalEnergyLevel += 3;
                        break;
                    case "Salmon":
                        totalToxicLevel += 2;
                        totalEnergyLevel += 8;
                        break;
                    case "Pizza":
                        totalToxicLevel += 7;
                        totalEnergyLevel += 2;
                        break;
                    case "Spinach":
                        totalToxicLevel += 2;
                        totalEnergyLevel += 8;
                        break;
                    case "Ice Cream":
                        totalToxicLevel += 6;
                        totalEnergyLevel += 2;
                        break;
                    case "Chicken Breast":
                        totalToxicLevel += 3;
                        totalEnergyLevel += 7;
                        break;
                    case "Chocolate":
                        totalToxicLevel += 5;
                        totalEnergyLevel += 4;
                        break;
                    case "Quinoa":
                        totalToxicLevel += 2;
                        totalEnergyLevel += 9;
                        break;
                    case "French Fries":
                        totalToxicLevel += 9;
                        totalEnergyLevel += 2;
                        break;
                    case "Apple":
                        totalToxicLevel += 2;
                        totalEnergyLevel += 8;
                        break;
                    case "Soda":
                        totalToxicLevel += 7;
                        totalEnergyLevel += 3;
                        break;
                    case "Eggs":
                        totalToxicLevel += 3;
                        totalEnergyLevel += 7;
                        break;
                    case "Fried Chicken":
                        totalToxicLevel += 8;
                        totalEnergyLevel += 3;
                        break;
                    case "Avocado":
                        totalToxicLevel += 1;
                        totalEnergyLevel += 7;
                        break;
                    case "Bacon":
                        totalToxicLevel += 7;
                        totalEnergyLevel += 5;
                        break;
                    case "Oats":
                        totalToxicLevel += 3;
                        totalEnergyLevel += 8;
                        break;
                    case "Cookies":
                        totalToxicLevel += 5;
                        totalEnergyLevel += 5;
                        break;
                    case "Orange Juice":
                        totalToxicLevel += 3;
                        totalEnergyLevel += 7;
                        break;
                    case "Grilled Fish":
                        totalToxicLevel += 3;
                        totalEnergyLevel += 7;
                        break;
                }
            }
        }
        int baseAge = gender.equals("Male") ? 75 : 80;
        double yearsLeft = baseAge - age - (totalToxicLevel * 2) + (totalEnergyLevel * 0.5);
        if(yearsLeft < 0)
        {
            yearsLeft = Math.abs(yearsLeft)/2;
        }
        String jsonResponse = "{ \"yearsLeft\": " + (int) yearsLeft + " }";
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonResponse);
    }
}
