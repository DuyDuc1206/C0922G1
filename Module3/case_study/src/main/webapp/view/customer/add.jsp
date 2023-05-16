<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/6/2022
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Customer</title>
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
                    <p class="text-center fs-2 fw-bold" style="color: #CBBE73">Add Customer Form</p>
                    <form action="/furama?action=add" method="post">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="mb-3">
                                    <label class="form-label">Name</label>
                                    <input type="text" class="form-control" name="name" value="${customer.getName()}">
                                </div>
                                <p class="text-danger">${!errorMap.isEmpty()?errorMap.get("name"):""} </p>
                                <div class="mb-3">
                                    <label class="form-label">Date Of Birth</label>
                                    <input type="date" class="form-control" name="DOB"
                                           value="${customer !=null?customer.getDateOfBirth():""}"
                                           min="1930-01-01" max="${endOfYear}">
                                </div>
                                <p class="text-danger">${!errorMap.isEmpty()?errorMap.get("birthday"):""}</p>
                                <div class="mb-3">
                                    <label class="form-label">Gender</label><br>
                                    <select name="gender">
                                        <option value="true" ${customer.gender==true?"checked":""}>Man</option>
                                        <option value="false" ${customer.gender==false?"checked":""}>Woman</option>
                                    </select>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">ID Card</label>
                                    <input type="text" class="form-control" name="idCard">
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="mb-3">
                                    <label class="form-label">Phone Number</label>
                                    <input type="text" class="form-control" name="phoneNumber">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Email</label>
                                    <input type="text" class="form-control" name="email">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Address</label>
                                    <input type="text" class="form-control" name="address">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Customer Type Name</label><br>
                                    <select name="idType">
                                        <c:forEach var="customerType" items="${customerTypeList}">
                                            <option value="${customerType.getId()}">
                                                    ${customerType.getCustomerTypeName()}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <button type="submit" class="btn " style="background-color:#046056;color: white;">Submit
                            </button>
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
