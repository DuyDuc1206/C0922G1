<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/2/2022
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Search User</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/home">List All Users</a>
    </h2>
</center>
<form method="post" action="/home?action=search">
    <table border="1" cellpadding="5">
        <caption><h2>List Of Users</h2></caption>
        <tr>
            <th>STT</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
        </tr>
        <c:forEach var="user" items="${userList}" varStatus="status">
            <tr>
                <td><c:out value="${status.count}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
            </tr>
        </c:forEach>
    </table>
</form>

</body>
</html>
