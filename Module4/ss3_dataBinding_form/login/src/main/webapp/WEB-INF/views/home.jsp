<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/2/2023
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<form:form modelAttribute="login" action="login" method="post">
<fieldset>
    <legend>Login</legend>
    <table>
        <tr>
            <td><form:label path="account">Account:</form:label></td>
            <td><form:input path="account"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="password">Password:</form:label></td>
            <td><form:password path="password"></form:password></td>
        </tr>
        <tr>
            <td></td>
            <td><form:button>Login</form:button></td>
        </tr>
    </table>
</fieldset>
</form:form>
</body>
</html>
