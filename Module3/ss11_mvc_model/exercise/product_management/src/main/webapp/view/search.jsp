<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/2/2022
  Time: 2:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
</head>
<body>
<h1 style="text-align: center">Tìm kiếm sản phẩm</h1>
<p>
    <a href="/home?action=list"><button>Quay lại trang List</button></a>
</p>
<form action="/home?action=search">
    <table>
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Price</td>
            <td>Description</td>
            <td>Production</td>
        </tr>
        <tr>
            <td>${product.getId()}</td>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getDescription()}</td>
            <td>${product.getProduction()}</td>
        </tr>
    </table>
</form>
</body>
</html>
