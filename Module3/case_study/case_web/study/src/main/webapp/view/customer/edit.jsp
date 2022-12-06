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
</head>
<body>
<%@include file="../interface/header.jsp" %>
<div class="container p-4">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="card">
                <div class="card-body">
                    <p class="text-center fs-2">Edit Customer Form</p>
                    <form action="" method="post">
                        <div class="col-lg-6">
                            <div class="mb-3">
                                <label class="form-label">Name</label>
                                <input type="text" class="form-control" name="name"
                                       value="<c:out value='${customer.customerName}' />">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">DOB</label>
                                <input type="text" class="form-control" name="name"
                                       value="<c:out value='${customer.dayOfBirth}' />">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Gender</label>
                                <input type="text" class="form-control" name="name"
                                       value="<c:out value='${customer.gender}' />">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">id Card</label>
                                <input type="text" class="form-control" name="name"
                                       value="<c:out value='${customer.idCard}' />">
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="mb-3">
                                <label class="form-label">Phone Number</label>
                                <input type="text" class="form-control" name="name"
                                       value="<c:out value='${customer.phoneNumber}' />">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Email</label>
                                <input type="text" class="form-control" name="name"
                                       value="<c:out value='${customer.email}' />">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Address</label>
                                <input type="text" class="form-control" name="name"
                                       value="<c:out value='${customer.address}' />">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Customer Type Name</label>
                                <input type="text" class="form-control" name="name"
                                       value="<c:out value='${customer.customerTypeName}' />">
                            </div>
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
