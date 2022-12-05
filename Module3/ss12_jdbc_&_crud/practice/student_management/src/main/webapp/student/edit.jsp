<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/3/2022
  Time: 11:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/student/css.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>

<div class="container p-4">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="card">
                <div class="card-body">
                    <p class="fs-3 text-center">Edit Form</p>
<%--                    <p>${mess}</p>--%>
                    <form method="post" >
                        <div class="mb-3">
                            <label class="form-label">Name</label>
                            <input type="text" class="form-control" name="name" value="<c:out value='${student.name}' />">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Gmail</label>
                            <input type="text" class="form-control" name="gmail"  value="<c:out value='${student.gmail}' />" >
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Country</label>
                            <input type="text" class="form-control" name="country" value="<c:out value='${student.country}'/>">
                        </div>
                        <button type="submit" class="btn btn-primary col-md-12">Update</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
