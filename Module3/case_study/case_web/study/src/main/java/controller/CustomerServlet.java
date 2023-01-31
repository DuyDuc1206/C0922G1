package controller;

import model.customer.Customer;
import model.customer.CustomerType;
import repository.customer.ICustomerTypeRepository;
import repository.customer.impl.CustomerTypeRepository;
import service.customer.ICustomerService;
import service.customer.impl.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CustomerServlet", value = "/furama")
public class CustomerServlet extends HttpServlet {
    private ICustomerService customerService = new CustomerService();
    private ICustomerTypeRepository customerTypeRepository = new CustomerTypeRepository();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "delete":
                deleteCustomer(request, response);
                break;
            case "edit":
                updateCustomer(request, response);
                break;
            case "add":
                addCustomer(request, response);
                break;
            case "search":
                searchCustomer(request, response);
                break;
            default:
        }
    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        request.setAttribute("name", name);
        String address = request.getParameter("address");
        request.setAttribute("address", address);

        List<Customer> customerList = customerService.selectCustomerByCondition(name, address);
        request.setAttribute("customerList", customerList);
        try {
            request.getRequestDispatcher("/view/customer/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String DOB = request.getParameter("DOB");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int idType = Integer.parseInt(request.getParameter("idType"));
        Customer customer = new Customer(name, DOB, gender, idCard, phoneNumber, email, address, idType);
        Map<String, String> errorMap = customerService.insertCustomer(customer);
        String mess = "Add Successfully!";
        if (!errorMap.isEmpty()) {
            mess = "Add Failed!";
        }
        LocalDate nowDate = LocalDate.now();
        int nowYear = nowDate.getYear();
        LocalDate endOfYear = LocalDate.of(nowYear,12,31);
        request.setAttribute("endOfYear",endOfYear);
        request.setAttribute("mess", mess);
        request.setAttribute("errorMap",errorMap);
        request.setAttribute("customer",customer);
        showListCustomer(request, response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String DOB = request.getParameter("DOB");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        Customer customer = new Customer(id, name, DOB, gender, idCard, phoneNumber, email, address, customerTypeId);
        boolean check = customerService.updateCustomer(customer);
        String mess = "Updated Successfully!";
        if (!check) {
            mess = "Update Failed!";
        }
        request.setAttribute("mess", mess);
        showListCustomer(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int deleteId = Integer.parseInt(request.getParameter("deleteId"));
        boolean check = customerService.deleteCustomer(deleteId);
        String mess = "Deleted Successfully!";
        if (!check) {
            mess = "Delete Failed!";
        }
        request.setAttribute("mess", mess);
        showListCustomer(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "list":
                showListCustomer(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "add":
                showAddForm(request, response);
                break;
            default:
                request.getRequestDispatcher("view/interface/home.jsp").forward(request, response);
        }
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = customerTypeRepository.selectAllCustomerType();
        request.setAttribute("customerTypeList", customerTypeList);
        try {
            request.getRequestDispatcher("view/customer/add.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.selectCustomerById(id);
        List<CustomerType> customerTypeList = customerTypeRepository.selectAllCustomerType();
        request.setAttribute("customerTypeList", customerTypeList);
        request.setAttribute("customer", customer);
        try {
            request.getRequestDispatcher("view/customer/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.selectAllCustomer();
        request.setAttribute("customerList", customerList);
        try {
            request.getRequestDispatcher("/view/customer/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
