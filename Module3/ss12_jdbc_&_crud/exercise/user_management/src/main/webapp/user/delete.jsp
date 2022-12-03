<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/3/2022
  Time: 5:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete User</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/home">List All Users</a>
    </h2>
</center>
<form action="/home?action=delete" method="post">
    <table>
        <tr>
            <td hidden>ID</td>
            <td>Name</td>
            <td>Email</td>
            <td>Country</td>
        </tr>
        <tr>
            <td hidden><label>
                <input type="text" name="id" value="${user.getId()}">
            </label></td>
            <td><label>
                <input type="text" name="name" value="${user.getName()}" readonly>
            </label></td>
            <td><label>
                <input type="text" name="price" value="${user.getEmail()}" readonly>
            </label></td>
            <td><label>
                <input type="text" name="country" value="${user.getCountry()}" readonly>
            </label></td>
            <td><button>Delete</button></td>
        </tr>
    </table>
</form>
</body>
</html>
