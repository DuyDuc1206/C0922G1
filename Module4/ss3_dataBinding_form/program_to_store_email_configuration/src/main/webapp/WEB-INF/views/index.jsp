<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Email</title>
    <style>
        a {
            text-decoration: none;
        }
    </style>
</head>
<body>
<h3>Settings</h3>
<form:form modelAttribute="email" action="/create" method="post" id="myform">
    <table>
        <tr>
            <td><form:label path="language">Language </form:label></td>
            <td><form:select path="language">
                <form:options items="${languages}"></form:options>
            </form:select></td>
        </tr>
        <tr>
            <td><form:label path="sizePage">Page Size</form:label></td>
            <td>Show <form:select path="sizePage">
                <form:options items="${pageSize}"></form:options>
            </form:select> emails per page
            </td>
        </tr>
        <tr>
            <td><form:label path="spam">Spams filter</form:label></td>
            <td><form:checkbox path="spam"></form:checkbox>Enable spams filter</td>
        </tr>
        <tr>
            <td><form:label path="text">Signature</form:label></td>
            <td><form:textarea path="text" rows="5"></form:textarea></td>
        </tr>
        <tr>
            <td></td>
            <td><form:button><a href="">Cancel</a></form:button>
                <form:button>Update</form:button></td>
        </tr>
    </table>
</form:form>

</body>
</html>
