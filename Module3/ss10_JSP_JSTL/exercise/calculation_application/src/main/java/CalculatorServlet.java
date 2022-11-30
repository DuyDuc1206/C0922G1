import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator-applications")
public class CalculatorServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float firstNumber = Float.parseFloat(request.getParameter("firstNumber"));
        float secondNumber = Float.parseFloat(request.getParameter("secondNumber"));
        char operator = request.getParameter("operator").charAt(0);
        float result = Calculator.calculatorMethod(firstNumber,secondNumber,operator);
        request.setAttribute("firstNumber",firstNumber);
        request.setAttribute("secondNumber",secondNumber);
        request.setAttribute("operator",operator);
        request.setAttribute("result",result);
        request.getRequestDispatcher("/result.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
