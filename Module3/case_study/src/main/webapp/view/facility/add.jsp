<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/8/2022
  Time: 10:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Facility</title>
    <%@include file="../interface/css.jsp" %>
</head>
<body>
<%@include file="../interface/header.jsp" %>
<%@include file="../interface/navbar.jsp" %>
<div class="container p-4">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="card">
                <div class="card-body">
                    <p class="text-center fs-2 fw-bold" style="color: #CBBE73">Add Facility Form</p>
                    <form action="/facility?action=add" method="post">
                        <div class="row">
                            <div class="mb-3">
                                <label class="form-label">Facility Name</label>
                                <select name="facilityTypeID" id="element" onclick="setVisibility();">
                                    <c:forEach var="facilityType" items="${facilityTypeList}">
                                        <option selected value="${facilityType.getId()}">
                                                ${facilityType.getName()}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Name</label>
                                <input type="text" class="form-control" name="name">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Area</label>
                                <input type="number" class="form-control" name="area">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Cost</label><br>
                                <input type="number" class="form-control" name="cost">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Max people</label>
                                <input type="number" class="form-control" name="maxPeople">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Standard Room</label>
                                <input type="text" class="form-control" name="standardRoom">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Description</label>
                                <input type="text" class="form-control" name="desc">
                            </div>

                            <%--   Villa                         --%>
                            <div class="row" id="form_villa">
                                <div class="mb-3">
                                    <label class="form-label">Pool Area</label>
                                    <input type="number" class="form-control" name="poolArea">
                                </div>
                            </div>

                            <%--  House                          --%>
                            <div class="row" id="form_house" style="display: none">
                                <div class="mb-3">
                                    <label class="form-label">Number Of Floor</label><br>
                                    <input type="number" class="form-control" name="numberOfFloor">
                                </div>
                            </div>

                            <%--   Room                         --%>
                            <div class="row" id="form_room" style="display: none">
                                <div class="mb-3">
                                    <label class="form-label">Facility Free</label>
                                    <input type="text" class="form-control" name="facilityFree">
                                </div>
                            </div>
                            <%--                            --%>

                            <div class="mb-3">
                                <label class="form-label">Rent Type Name</label>
                                <select name="rentTypeId">
                                    <c:forEach var="rentType" items="${rentTypeList}">
                                        <option value="${rentType.getId()}">
                                                ${rentType.getName()}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    function setVisibility() {
        var x = document.getElementById("element").value;
        if (x == "1") {
            document.getElementById("form_villa").style.display = "block";
            document.getElementById("form_house").style.display = "block";
            document.getElementById("form_room").style.display = "none";
        } else if (x == "2") {
            document.getElementById("form_villa").style.display = "none";
            document.getElementById("form_house").style.display = "block";
            document.getElementById("form_room").style.display = "none";
        } else {
            document.getElementById("form_villa").style.display = "none";
            document.getElementById("form_house").style.display = "none";
            document.getElementById("form_room").style.display = "block";
        }
    }
</script>
<%@include file="../interface/footer.jsp" %>
</body>
</html>
