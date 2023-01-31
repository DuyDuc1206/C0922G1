<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/12/2022
  Time: 8:21 AM
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
                    <p class="text-center fs-2 fw-bold" style="color: #CBBE73">Edit Customer Form</p>
                    <form action="/customer?action=update" method="post">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="mb-3" hidden>
                                    <label class="form-label">Id</label>
                                    <input type="text" class="form-control" name="id"
                                           value="<c:out value='${customer.getId()}' />">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Name</label>
                                    <input type="text" class="form-control" name="name" required
                                           pattern="^([A-Z][a-z]+[ ])+([A-Z][a-z]+)$"
                                           value="<c:out value='${customer.getName()}' />">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">DOB</label>
                                    <input type="date" class="form-control" name="DOB"
                                           value="<c:out value='${customer. getDateOfBirth()}' />">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Gender:</label> <br>
                                    <td><select class="form-control"  name="gender">
                                        <option value="Woman" ${customer.getGender()=='Woman' ? "selected" : ""} >
                                            Woman
                                        </option>
                                        <option value="Man" ${customer.getGender()=='Man' ? "selected" : ""}>Man
                                        </option>
                                    </select>
                                    </td>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">id Card</label>
                                    <input type="number" class="form-control" name="idCard" required
                                           value="<c:out value='${customer.getIdCard()}' />">
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="mb-3">
                                    <label class="form-label">Phone Number</label>
                                    <input type="number" class="form-control" name="phoneNumber" required
                                           value="<c:out value='${customer.getPhoneNumber()}' />">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Email</label>
                                    <input type="text" class="form-control" name="email" required
                                           value="<c:out value='${customer.getEmail()}' />">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Address</label>
                                    <input type="text" class="form-control" name="address"
                                           value="<c:out value='${customer.getAddress()}' />">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Customer Type Name</label><br>
                                    <select name="customerTypeId">
                                        <c:forEach var="customerType" items="${customerTypeList}">
                                            <option value="${customerType.getId()}" ${customerType.getId() == customer.getCustomerTypeId()?'selected':''}>${customerType.getName()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <button class="btn " type="submit" style="background-color:#046056;color: white">Submit
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
