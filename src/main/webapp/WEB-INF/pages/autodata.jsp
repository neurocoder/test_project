<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>autodata</title>
</head>
<body>
<h1>Car details</h1>

<table>
    <tr>
        <th>ID</th>
        <th>Brand</th>
        <th>Model</th>
        <th>Year</th>
        <th>Cost</th>
    </tr>
    <tr>
        <td>${auto.id}</td>
        <td>${auto.makeCar}</td>
        <td>${auto.modelCar}</td>
        <td>${auto.year}</td>
        <td>${auto.cost}</td>
    </tr>
</table>
</body>
</html>
