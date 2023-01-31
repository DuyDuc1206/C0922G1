<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/8/2022
  Time: 8:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Facility</title>
    <meta charset="UTF-8">
    <%@include file="/view/interface/css.jsp" %>
</head>
<body>
<%@include file="../interface/header.jsp" %>
<%@include file="../interface/navbar.jsp" %>
<div><p id="mess" class="text-center fs-5 text-danger" >${mess}</p></div>
<div class="container-fluid p-3 ">
    <p class="text-center fs-2 fw-bold" style="color: #CBBE73">All Facility Details</p>
    <a href="/facility?action=add" class="btn btn-md btn-outline-primary">ADD FACILITY <i class="fas fa-plus"></i></a>
    <table class="table table-striped table-bordered "  style="width:100% ;">
        <thead>
        <tr>
            <th scope="col">No.</th>
            <th scope="col">Name</th>
            <th scope="col">Area</th>
            <th scope="col">Cost</th>
            <th scope="col">Max People</th>
            <th scope="col">Standard Room</th>
            <th scope="col">D.O.Convenience</th>
            <th scope="col">Pool Area</th>
            <th scope="col">Number Floor</th>
            <th scope="col">Facility Free</th>
            <th scope="col">Facility Type Name</th>
            <th scope="col">Rent Type Name</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="facility" items="${facilityList}" varStatus="status">
            <tr>
                <th scope="row"><c:out value="${status.count}"/></th>
                <td><c:out value="${facility.name}"/></td>
                <td><c:out value="${facility.area}"/></td>
                <td><c:out value="${facility.cost}"/></td>
                <td><c:out value="${facility.maxPeople}"/></td>
                <td><c:out value="${facility.standardRoom}"/></td>
                <td><c:out value="${facility.descriptionOtherConvenience}"/></td>
                <td><c:out value="${facility.poolArea}"/></td>
                <td><c:out value="${facility.numberOfFloor}"/></td>
                <td><c:out value="${facility.facilityFree}"/></td>
                <td><c:out value="${facility.facilityTypeName.name}"/></td>
                <td><c:out value="${facility.rentTypeName.name}"/></td>
                <td>
                    <a href="/facility?action=edit&id=${facility.id}" class="btn btn-outline-secondary">Edit</a>
                    <button onclick="infoDelete('${facility.id}','${facility.name}')"
                            class="btn btn-md btn-danger ms-1"
                            data-bs-toggle="modal" data-bs-target="#exampleModal">Delete
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- Modal delete-->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Delete Facility</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="/facility?action=delete" method="post">
                <div class="modal-body">
                    <input hidden type="text" id="deleteId" name="id">
                    <span>Do you want to delete </span><strong class="text-danger" id="deleteName" ></strong>?
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                        <button type="submit" class="btn btn-md btn-primary">Delete</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    function infoDelete(id, name) {
        document.getElementById("deleteId").value = id;
        document.getElementById("deleteName").innerText = name;
    }
</script>

<%@include file="../interface/footer.jsp" %>
</body>
</html>
