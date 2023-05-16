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
<div class="container my-3">
    <p id="mess" class="text-center fs-5" style="color: red;">${mess}</p>
</div>
<div class="container-fluid p-3">
    <p class="text-center fs-2 fw-bold" style="color: #CBBE73">All Customer Details</p>
    <a href="?action=add" class="btn btn-outline-primary">
        ADD CUSTOMER <i class="fas fa-plus"></i>
    </a>
    <table id="tableCustomer" class="table table-striped table-bordered " style="width:100% ;">
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
                <th scope="row"><c:out value="${status.count}"/></th>
                <td><c:out value="${customer.getName()}"/></td>
                <td><c:out value="${customer.getDateOfBirth()}"/></td>
                <td><c:out value="${customer.getGender()}"/></td>
                    <%--                <c:if test="${customer.getGender()}">--%>
                    <%--                    <td>Nam</td>--%>
                    <%--                </c:if>--%>
                    <%--                <c:if test="${!customer.getGender()}">--%>
                    <%--                    <td>Nữ</td>--%>
                    <%--                </c:if>--%>
                <td><c:out value="${customer.getIdCard()}"/></td>
                <td><c:out value="${customer.getPhoneNumber()}"/></td>
                <td><c:out value="${customer.getEmail()}"/></td>
                <td><c:out value="${customer.getAddress()}"/></td>
                <td><c:out value="${customer.getCustomerTypeName().getName()}"/></td>
                <td>
                    <a href="?action=update&id=${customer.getId()}" class="btn btn-outline-secondary">
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

<!-- Modal delete-->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Delete Customer</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="/customer?action=delete" method="post">
                <div class="modal-body">
                    <input hidden type="text" id="deleteId" name="deleteId">
                    <span>Do you want to delete </span><span id="deleteName" class="text-danger"></span>?
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                        <button type="submit" class="btn btn-md btn-primary">Delete</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>

<script>
    function infoDelete(id, name) {
        document.getElementById("deleteId").value = id;
        document.getElementById("deleteName").innerText = name;
    }

    setTimeout(function () {
        document.getElementById('mess').style.display = 'none';
    }, 3000);

    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 10
        });
    });
</script>
<%@include file="../interface/footer.jsp" %>
</body>
</html>
