<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/6/2022
  Time: 11:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Customer</title>
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
                    <p class="text-center fs-2">Edit Customer Form</p>
                    <form action="/furama?action=edit" method="post">
                        <div class="row">
                            <div class="col-lg-6">
                                <div hidden class="mb-3">
                                    <label class="form-label">Id</label>
                                    <input type="text" class="form-control" name="id"
                                           value="<c:out value='${customer.id}' />">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Name</label>
                                    <input type="text" class="form-control" name="name"
                                           value="<c:out value='${customer.customerName}' />">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">DOB</label>
                                    <input type="date" class="form-control" name="DOB"
                                           value="<c:out value='${customer.dateOfBirth}' />">
                                </div>
                                <div class="mb-3">
                                    <label>Gender:</label> <br>
                                    <td><input type="radio" name="gender" size="50"
                                               value="true" ${customer.isGender()==true?"checked":""}>Man
                                        <input type="radio" name="gender" size="50"
                                               value="false" ${customer.isGender()==false?"checked":""}>Woman
                                    </td>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">id Card</label>
                                    <input type="text" class="form-control" name="idCard"
                                           value="<c:out value='${customer.idCard}' />">
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="mb-3">
                                    <label class="form-label">Phone Number</label>
                                    <input type="text" class="form-control" name="phoneNumber"
                                           value="<c:out value='${customer.phoneNumber}' />">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Email</label>
                                    <input type="text" class="form-control" name="email"
                                           value="<c:out value='${customer.email}' />">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Address</label>
                                    <input type="text" class="form-control" name="address"
                                           value="<c:out value='${customer.address}' />">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Customer Type Name</label><br>
                                    <select name="customerTypeId">
                                        <c:forEach var="customerType" items="${customerTypeList}">
                                            <option value="${customerType.getId()}">${customerType.getCustomerTypeName()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
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
