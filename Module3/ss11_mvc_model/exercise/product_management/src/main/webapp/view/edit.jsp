<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/2/2022
  Time: 12:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EidtProduct</title>
</head>
<body>
<h1 style="text-align: center">Sửa Thông Tin sản phẩm</h1>
<p>
    <a href="/home?action=list"><button>Quay lại trang List</button></a>
</p>

<form action="/home?action=edit" method="post">
    <table>
        <tr>
            <td hidden>ID</td>
            <td>Name</td>
            <td>Price</td>
            <td>Description</td>
            <td>Production</td>
        </tr>
        <tr>
            <td hidden><input type="text" name="id" value="${product.getId()}"></td>
            <td><input type="text" name="name" value="${product.getName()}"></td>
            <td><input type="text" name="price" value="${product.getPrice()}" ></td>
            <td><input type="text" name="price" value="${product.getDescription()}" ></td>
            <td><input type="text" name="price" value="${product.getProduction()}" ></td>
        </tr>
    </table>
    <button type="submit">Edit</button>
</form>
</body>
</html>
