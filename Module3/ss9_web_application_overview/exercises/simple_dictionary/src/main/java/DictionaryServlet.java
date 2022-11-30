import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "DictionaryServlet", urlPatterns = "/dictionary")
public class DictionaryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> dic = new HashMap<>();
        dic.put("hello", "xin chào");
        dic.put("book", "sách");
        dic.put("phone", "điện thoại");
        dic.put("computer", "máy tính");
        String word = request.getParameter("value");
        String result =dic.get(word);
        if (result!=null){
            request.setAttribute("word", result);
            request.getRequestDispatcher("Result.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
