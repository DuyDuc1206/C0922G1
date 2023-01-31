package controller;

import model.TComplex;
import service.ITComplexService;
import service.impl.TComplexService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TComplexServlet", value = "home")
public class TComplexServlet extends HttpServlet {
    ITComplexService itComplexService = new TComplexService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "list":
                showList(request,response);
                break;
            default:
                request.getRequestDispatcher("interface/home.jsp").forward(request,response);
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<TComplex> tComplexList= itComplexService.selectAllTComplex();
        request.setAttribute("tComplexList",tComplexList);
        try {
            request.getRequestDispatcher("TComplex/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
