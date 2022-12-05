<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/4/2022
  Time: 11:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Search Student</title>
    <%@include file="css.jsp"%>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="card">
                <div class="card-body">
                    <p class="text-center fs-3">Student</p>
                    <form action="/home?action=search" method="post">
                        <table>
                            <tr>
                                <th></th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Country</th>
                            </tr>
                            <c:forEach var="student" items="${studentList}" varStatus="status">
                                <tr>
                                    <td><c:out value="${status.count}"/></td>
                                    <td><c:out value="${student.name}"/></td>
                                    <td><c:out value="${student.gmail}"/></td>
                                    <td><c:out value="${student.country}"/></td>
                                </tr>
                            </c:forEach>
                        </table>
                        <a href="index.jsp" class="btn btn-sm btn-primary">List student</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
