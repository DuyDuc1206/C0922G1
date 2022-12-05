<%@ page import="java.sql.Connection" %>
<%@ page import="repository.BaseRepository" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/3/2022
  Time: 10:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student Management</title>
    <%@include file="/student/css.jsp" %>
</head>
<body class="bg-light">
<%@include file="/student/navbar.jsp" %>
<%--Kiểm tra kết nối--%>
<%--<% Connection connection=BaseRepository.getConnection();--%>
<%--    System.out.println(connection);%>--%>
<div class="container p-5">
    <p class="text-center fs-1">All Student Details</p>
    <p>${mess}</p>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">No.</th>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
            <th scope="col">Country</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="student" items="${studentList}" varStatus="status">
            <tr>
                <td><c:out value="${status.count}"/></td>
                <td hidden><c:out value="${student.id}"/></td>
                <td><c:out value="${student.name}"/></td>
                <td><c:out value="${student.gmail}"/></td>
                <td><c:out value="${student.country}"/></td>
                <td>
                    <a href="/home?action=update&id=${student.id}" class="btn btn-sm btn-primary">Edit</a>
                    <button onclick="infoDelete('${student.id}','${student.name}')" class="btn btn-sm btn-danger ms-1"
                       data-bs-toggle="modal" data-bs-target="#exampleModal">Delete</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Delete Student</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="/home?action=delete" method="post">
            <div class="modal-body">
                <input hidden type="text" id="deleteId" name="deleteId">
                <span>Do you want to delete </span><span id="deleteName"></span>?
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
</body>
</html>
