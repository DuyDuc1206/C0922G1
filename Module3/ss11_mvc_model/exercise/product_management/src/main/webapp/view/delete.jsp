<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/1/2022
  Time: 4:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DeleteProduct</title>
</head>
<body>
<h1 style="text-align: center">Xóa sản phẩm</h1>
<p>
    <a href="/home?action=list"><button>Quay lại trang List</button></a>
</p>
<form action="/home?action=delete" method="post">
    <table>
        <tr>
            <td hidden>ID</td>
            <td>Name</td>
            <td>Price</td>
        </tr>
        <tr>
            <td hidden><label>
                <input type="text" name="id" value="${product.getId()}">
            </label></td>
            <td><label>
                <input type="text" name="name" value="${product.getName()}" readonly>
            </label></td>
            <td><label>
                <input type="text" name="price" value="${product.getPrice()}" readonly>
            </label></td>
        </tr>
    </table>
    <button>Delete</button>
</form>
</body>
</html>
