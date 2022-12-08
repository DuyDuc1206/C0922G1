<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/8/2022
  Time: 10:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Facility</title>
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
                    <p class="text-center fs-2 fw-bold " style="color: #CBBE73">Edit Facility Form</p>
                    <form action="/facility?action=edit" method="post">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="mb-3">
                                    <label class="form-label">Name</label>
                                    <input type="text" class="form-control" name="name"
                                    value="<c:out value='${facility.name}'/>">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Area</label>
                                    <input type="number" class="form-control" name="area"
                                           value="<c:out value='${facility.area}'/>">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Cost</label>
                                    <input type="number" class="form-control" name="cost"
                                           value="<c:out value='${facility.cost}'/>">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Max People</label>
                                    <input type="number" class="form-control" name="max_people"
                                           value="<c:out value='${facility.maxPeople}'/>">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Standard Room</label>
                                    <input type="text" class="form-control" name="standard"
                                           value="<c:out value='${facility.standardRoom}'/>">
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="mb-3">
                                    <label class="form-label">Pool Area</label>
                                    <input type="number" class="form-control" name="poolArea"
                                           value="<c:out value='${facility.poolArea}'/>">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Number Of Floor</label>
                                    <input type="number" class="form-control" name="numberFloor"
                                           value="<c:out value='${facility.numberOfFloor}'/>">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Facility Free</label>
                                    <input type="text" class="form-control" name="facilityFree"
                                           value="<c:out value='${facility.facilityFree}'/>">
                                </div>
                                <div class="mb-3">
                                    <label class="col-form-label">Rent Type Name</label>
                                    <select class="form-control" name="rentId">
                                        <c:forEach var="rentType" items="${rentTypeList}">
                                            <option value="${rentType.getId()}">${rentType.getName()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="mb-3">
                                    <label class="col-form-label">Facility Type Name</label>
                                    <select class="form-control" name="facilityTypeId">
                                        <c:forEach var="facilityType" items="${facilityTypeList}">
                                        <option value="${facilityType.getId()}">${facilityType.getName()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Description</label>
                                <input type="text" class="form-control" name="desc"
                                       value="<c:out value='${facility.descriptionOtherConvenience}'/>">
                            </div>
                            <button class="btn btn-primary" type="submit">Submit</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="../interface/footer.jsp" %>
</body>
</html>
