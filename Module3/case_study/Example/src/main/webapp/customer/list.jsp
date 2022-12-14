<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/11/2022
  Time: 12:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Customer</title>
    <%@include file="../interface/css.jsp" %>

</head>
<body>
<%@include file="../interface/header.jsp" %>
<%@include file="../interface/navbar.jsp" %>
<div class="container-fluid p-3">
    <p class="text-center fs-2 fw-bold" style="color: #CBBE73">All Customer Details</p>
    <a href="?action=add" class="btn btn-outline-primary">
        ADD CUSTOMER <i class="fas fa-plus"></i>
    </a>
    <table>
        <thead>
        <tr>
            <th scope="col">No.</th>
            <th scope="col">Name</th>
            <th scope="col">DOB</th>
            <th scope="col">Gender</th>
            <th scope="col">Id Card</th>
            <th scope="col">Phone Number</th>
            <th scope="col">Email</th>
            <th scope="col">Address</th>
            <th scope="col">Customer Type Name</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${customerList}" varStatus="status">
            <tr>
                <th scope="row"><c:out value="${status.count}"/> </th>
                <td><c:out value="${customer.getId()}"/> </td>
                <td><c:out value="${customer.getName()}"/> </td>
                <td><c:out value="${customer.getDateOfBirth()}"/> </td>
                <c:if test="${customer.gender}">
                    <td>Nam</td>
                </c:if>
                <c:if test="${!customer.gender}">
                    <td>Nữ</td>
                </c:if>
                <td><c:out value="${customer.getIdCard()}"/></td>
                <td><c:out value="${customer.getPhoneNumber()}"/></td>
                <td><c:out value="${customer.getEmail()}"/></td>
                <td><c:out value="${customer.getAddress()}"/></td>
                <td><c:out value="${customer.getCustomerTypeName().getName()}"/></td>
                <td>
                    <a href="?action=edit&id=${customer.getId()}" class="btn btn-outline-secondary">
                        <i class="fas fa-edit"></i>
                    </a>
                    <button onclick="infoDelete('${customer.getId()}','${customer.getName()}')"
                            class="btn btn-md btn-danger ms-1"
                            data-bs-toggle="modal" data-bs-target="#exampleModal"><i class="fas fa-trash-alt"></i>
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@include file="../interface/footer.jsp" %>
</body>
</html>
