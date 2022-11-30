<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/30/2022
  Time: 11:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="row"><h2 style="text-align: center">Danh sách khách hàng</h2></div>
<table class="table table-striped table-hover " style="text-align: center;vertical-align: middle">
    <tr>
        <th>STT</th>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
    </tr>
   <c:forEach var="customerlist" items="${customerlist}" varStatus="status">
    <tr >
<%--        count là từ 1, còn index là từ 0--%>
        <td>${status.count}</td>
        <td >${customerlist.name}</td>
        <td >${customerlist.DOB}</td>
        <td >${customerlist.address}</td>
        <td ><img src="${customerlist.img}" style="width: 100px;height: 100px"></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
