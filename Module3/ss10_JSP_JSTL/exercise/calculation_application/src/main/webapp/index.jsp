<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/30/2022
  Time: 11:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>Simple Calculator</h2>
  <form action="/calculator-applications" method="post">
  <pre>First operand:    <input type="text" name="firstNumber"></pre>
  <pre>Operator:         <select name="operator">
    <option value="+">Addition</option>
    <option value="-">Subtraction</option>
    <option value="*">Multiplication</option>
    <option value="/">Division</option>
  </select></pre>
  <pre>Second operand    <input type="text" name="secondNumber"></pre>
    <button type="submit">Calculator</button>
  </form>
  </body>
</html>
