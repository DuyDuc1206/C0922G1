package controller;

import model.Student;
import service.IStudentService;
import service.impl.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/home")
public class StudentServlet extends HttpServlet {
    IStudentService studentService = new StudentService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search":
                searchStudent(request, response);
                break;
            case "update":
                updateStudent(request, response);
                break;
            case "insert":
                insertStudent(request, response);
                break;
            case "delete":
                deleteStudent(request, response);
                break;
            default:
        }
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) {
        int deleteId = Integer.parseInt(request.getParameter("deleteId"));
        boolean check = studentService.delete(deleteId);
        String mess = "Delete successfully!";
        if(!check){
            mess = "Delete failed!";
        }
        request.setAttribute("mess",mess);
        List<Student> studentList = studentService.findAllStudent();
        request.setAttribute("studentList", studentList);
        try {
            request.getRequestDispatcher("/student/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void insertStudent(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String gmail = request.getParameter("gmail");
        String country = request.getParameter("country");
        Student student = new Student(name, gmail, country);
        studentService.insert(student);
        try {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String gmail = request.getParameter("gmail");
        String country = request.getParameter("country");
        Student student = new Student(id, name, gmail, country);
         studentService.update(student);
//        boolean check =
//        String mess = "Update successfully!";
//        if(!check){
//            mess="Update Failed!";
//        }
        try {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchStudent(HttpServletRequest request, HttpServletResponse response) {
        String country = request.getParameter("country");
        request.setAttribute("country", country);
        List<Student> studentList = studentService.findStudentByCountry(country);
        request.setAttribute("studentList", studentList);
        try {
            request.getRequestDispatcher("/student/list.jsp").forward(request, response); // có thể đổ qua trang search
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "update":
                showUpdateForm(request, response);
                break;
            case "insert":
                ShowInsertForm(request, response);
                break;
//            case "delete":
//                showDeleteForm(request,response);
//                break;
            default:
                showList(request, response);
                break;
        }
    }

//    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        studentService.delete(id);
//
//    }

    private void ShowInsertForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("student/add.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findStudentById(id);
        request.setAttribute("student", student);
        try {
            request.getRequestDispatcher("/student/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Student> studentList = studentService.findAllStudent();
        request.setAttribute("studentList", studentList);
        try {
            request.getRequestDispatcher("/student/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
