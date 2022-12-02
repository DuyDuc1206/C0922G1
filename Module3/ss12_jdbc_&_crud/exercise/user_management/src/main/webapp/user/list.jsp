<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/2/2022
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="home?action=insert">Add New User</a>
    </h2>
</center>
<form class="d-flex" action="/home?action=search" method="post">
    <input class="form-control me-2" type="search" name="country" value="${countrySave}" placeholder="Tìm kiếm theo quốc gia" aria-label="Search">
    <button class="btn btn-outline-success" type="submit" style="background-color: #b8daff ">Tìm </button>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List Of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
                <td>
                    <a href="/home?action=edit&id=${user.id}">Edit</a>
                    <a href="/home?action=delete&id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
