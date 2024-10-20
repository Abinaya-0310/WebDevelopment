import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Stack;

@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Get the input expression from the request
        String expression = request.getParameter("expression");
        
        try {
            if (expression == null || expression.trim().isEmpty()) {
                throw new Exception("Empty expression");
            }

            // Evaluate the expression
            double result = evaluate(expression.trim());

            // Return the result back to the client
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><head><title>Calculator Result</title></head>");
            out.println("<body style='background-color:black;'>");
            out.println("<h1 style='color:silver;align-items:center;'>Your Result: " + result + "</h1>");
            out.println("<a href=\"calindex.html\">Go back</a>");
            out.println("</body></html>");
        } catch (Exception e) {
            // Handle any errors that occur during evaluation
            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();
            out.println("Error: " + e.getMessage());
        }
    }

    // Function to evaluate a mathematical expression
    private double evaluate(String expression) throws Exception {
        // Remove whitespace
        expression = expression.replaceAll("\\s+", "");

        // Stack for numbers
        Stack<Double> numbers = new Stack<>();
        // Stack for operators
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // If the character is a digit, parse the full number
            if (Character.isDigit(ch) || ch == '.') {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i++));
                }
                i--; // Step back one character
                numbers.push(Double.parseDouble(sb.toString()));
            } 
            // If the character is an operator
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!operators.isEmpty() && hasPrecedence(ch, operators.peek())) {
                    numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
                }
                operators.push(ch);
            } 
            else {
                throw new Exception("Invalid character in expression: " + ch);
            }
        }

        // Apply remaining operators
        while (!operators.isEmpty()) {
            numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
        }

        // The final result is the last number in the stack
        return numbers.pop();
    }

    // Function to check operator precedence
    private boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        return true;
    }

    // Function to apply an operator to two operands
    private double applyOperator(char operator, double b, double a) throws Exception {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new Exception("Cannot divide by zero");
                }
                return a / b;
            default:
                throw new Exception("Invalid operator: " + operator);
        }
    }
}
