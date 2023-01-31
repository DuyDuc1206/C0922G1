<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/12/2022
  Time: 8:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
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
                    <form action="/customer?action=add" method="post">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="mb-3">
                                    <label class="form-label">Name</label>
                                    <input type="text" class="form-control" name="name" required pattern="^([A-Z][a-z]+[ ])+([A-Z][a-z]+)$">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Date Of Birth</label>
                                    <input type="date" class="form-control" name="DOB" min="2022-12-02">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Gender</label><br>
                                    <select name="gender" >
                                        <option value="Man" ${customer.gender=='Man'?"checked":""}>Man</option>
                                        <option value="Woman" ${customer.gender=='Woman'?"checked":""}>Woman</option>
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
                                    <input type="text" class="form-control" name="phoneNumber" required  >
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
                                                    ${customerType.getName()}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <button type="submit" class="btn " style="background-color:#046056;color: white;">Submit</button>
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
