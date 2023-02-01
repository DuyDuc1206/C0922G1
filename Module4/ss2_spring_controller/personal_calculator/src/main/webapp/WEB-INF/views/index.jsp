<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/1/2023
  Time: 10:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>calculator</title>
  </head>
  <body>
  <h3>Calculator</h3>
  <form action="/result">
    <input type="text" placeholder="0" name="number1">
    <input type="text" placeholder="0" name="number2">
    <select name="operation" id="" onchange="this.form.submit()">
      <option selected>Select</option>
      <option value="+">Addition</option>
      <option value="-">Subtraction</option>
      <option value="*">Multiplication</option>
      <option value="/" >Division</option>
    </select>
  </form>
  <h3>Result ${cal}: ${result}</h3>
  </body>
</html>
