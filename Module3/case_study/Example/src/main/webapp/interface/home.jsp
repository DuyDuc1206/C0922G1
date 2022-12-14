<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
    <%@include file="css.jsp"%>
</head>
<body>
<%@include file="header.jsp"%>
<%@include file="navbar.jsp"%>
<div class="row container-fluid ">
    <div class="col-lg-3">
        <ul class="list-group">
            <li class="list-group-item active" aria-current="true"
                style="text-align: center; background-color: #046056">Products
            </li>
            <li class="list-group-item">A first item</li>
            <li class="list-group-item">A second item</li>
            <li class="list-group-item">A third item</li>
            <li class="list-group-item">And a fourth one</li>
        </ul>
    </div>
    <div id="carouselExampleIndicators" class="carousel slide col-lg-9" data-bs-ride="carousel">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
        </div>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="https://furamavietnam.com/wp-content/uploads/2018/10/Vietnam_Danang_Furama_Resort_Exterior_Courtyard-1.jpg" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
                <img src="https://danangfantasticity.com/wp-content/uploads/2015/12/furama-resort-da-nang-thumb.jpg" class="d-block w-100" alt="...">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
