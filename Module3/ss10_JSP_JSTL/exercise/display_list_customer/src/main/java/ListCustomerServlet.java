import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListCustomerServlet", urlPatterns = "/list-customer")
public class ListCustomerServlet extends HttpServlet {
    private static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer("Duc", "1990-05-05", "Đà Nẵng", "https://images.pexels.com/photos/4173168/pexels-photo-4173168.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));
        customerList.add(new Customer("Dung", "1993-12-12", "Vinh", "https://images.pexels.com/photos/532220/pexels-photo-532220.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        customerList.add(new Customer("Duy", "2010-06-05", "Hà Nội", "https://images.pexels.com/photos/927022/pexels-photo-927022.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        customerList.add(new Customer("Dương", "2000-01-01", "Sài Gòn", "https://images.pexels.com/photos/716411/pexels-photo-716411.jpeg?auto=compress&cs=tinysrgb&w=1600"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerlist", customerList);
        request.getRequestDispatcher("/home.jsp").forward(request,response);
    }
}
