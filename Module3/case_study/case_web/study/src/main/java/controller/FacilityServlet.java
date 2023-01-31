package controller;

import model.facility.Facility;
import model.facility.FacilityType;
import model.facility.RentType;
import service.facility.IFacilityService;
import service.facility.IFacilityTypeService;
import service.facility.IRentTypeService;
import service.facility.impl.FacilityService;
import service.facility.impl.FacilityTypeService;
import service.facility.impl.RentTypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet", value = "/facility")
public class FacilityServlet extends HttpServlet {
    IFacilityService facilityService = new FacilityService();
    IFacilityTypeService facilityTypeService = new FacilityTypeService();
    IRentTypeService rentTypeService = new RentTypeService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addFacility(request, response);
                break;
            case "edit":
                editFacility(request, response);
                break;
            case "delete":
                deleteFacility(request, response);
                break;
            default:
        }
    }

    private void addFacility(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        String standardRoom = request.getParameter("standardRoom");
        String desc = request.getParameter("desc");
        Double poolArea;
        if (request.getParameter("poolArea") == null) {
            poolArea = null;
        } else {
            poolArea = Double.parseDouble(request.getParameter("poolArea"));
        }
        Integer numberOfFloor;
        if (request.getParameter("numberOfFloor") == null) {
            numberOfFloor = null;
        } else {
            numberOfFloor = Integer.parseInt(request.getParameter("numberOfFloor"));
        }
        String facilityFree = request.getParameter("facilityFree");
        int renTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
        int facilityTypeId = Integer.parseInt(request.getParameter("facilityTypeID"));
        Facility facility = new Facility(name, area, cost, maxPeople, standardRoom, desc, poolArea, numberOfFloor, facilityFree, renTypeId, facilityTypeId);
        boolean check = facilityService.addFacility(facility);
        String mess = "Delete Facility Successfully!";
        if (!check) {
            mess = "Delete Failed!";
        }
        request.setAttribute("mess", mess);
        showFacilityList(request, response);
    }

    private void editFacility(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int max_people = Integer.parseInt(request.getParameter("max_people"));
        String standard = request.getParameter("standard");
        String desc = request.getParameter("desc");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int numberFloor = Integer.parseInt(request.getParameter("numberFloor"));
        String facilityFree = request.getParameter("facilityFree");
        int rentId = Integer.parseInt(request.getParameter("rentId"));
        int facilityTypeId = Integer.parseInt(request.getParameter("facilityTypeId"));
        Facility facility = new Facility(id, name, area, cost, max_people, standard, desc, poolArea, numberFloor, facilityFree, rentId, facilityTypeId);
        boolean check = facilityService.updateFacility(facility);
        String messEdit = "Updated Successfully!";
        if (!check){
            messEdit = "Updated Failed!";
        }
        request.setAttribute("messEdit",messEdit);
        showFacilityList(request, response);
    }

    private void deleteFacility(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean check = facilityService.deleteFacility(id);
        String mess = "Delete Facility Successfully!";
        if (!check) {
            mess = "Delete Failed!";
        }
        request.setAttribute("mess", mess);
        showFacilityList(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showAddForm(request, response);
                break;
            case "edit":
                showUpdateForm(request, response);
                break;
            default:
                showFacilityList(request, response);

        }
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) {
        List<FacilityType> facilityTypeList = facilityTypeService.selectAllFacilityType();
        request.setAttribute("facilityTypeList", facilityTypeList);
        List<RentType> rentTypeList = rentTypeService.selectAllRentType();
        request.setAttribute("rentTypeList", rentTypeList);
        try {
            request.getRequestDispatcher("/view/facility/add.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Facility facility = facilityService.seclectFacilityById(id);
        List<FacilityType> facilityTypeList = facilityTypeService.selectAllFacilityType();
        List<RentType> rentTypeList = rentTypeService.selectAllRentType();
        request.setAttribute("facilityTypeList", facilityTypeList);
        request.setAttribute("rentTypeList", rentTypeList);
        request.setAttribute("facility", facility);
        try {
            request.getRequestDispatcher("/view/facility/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFacilityList(HttpServletRequest request, HttpServletResponse response) {
        List<Facility> facilityList = facilityService.selectAllService();
        request.setAttribute("facilityList", facilityList);
        try {
            request.getRequestDispatcher("view/facility/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
