<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1>automobiles list</h1>

<c:if test="${!empty listAutos}">
    <table>
        <tr>
            <th>ID</th>
            <th>Brand</th>
            <th>Model</th>
            <th>Year</th>
            <th>Cost</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>

        <c:forEach items="${listAutos}" var="auto">
            <tr>
                <td>${auto.id}</td>
                <td>${auto.makeCar}</td>
                <td>${auto.modelCar}</td>
                <td>${auto.year}</td>
                <td>${auto.cost}</td>
                <td><a href="<c:url value='/edit/${auto.id}'/>">Edit this</a> </td>
                <td><a href="<c:url value='/delete/${auto.id}'/>">Delete this</a> </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h1>Add car</h1>

<c:url var="addAction" value="/automobiles/add">
    <form:form action="${addAction}" commandName="auto">
        <table>
            <c:if test="${!empty auto.makeCar}">
                <tr>
                    <td>
                        <form:label path="id">
                            <spring:message text="ID" />
                        </form:label>
                    </td>
                    <td>
                        <form:input path="id" readonly="true" disabled="true"/>
                        <form:hidden path="id"/>
                    </td>
                </tr>
            </c:if>

            <tr>
                <td>
                    <form:label path="makeCar">
                        <spring:message text="Brand auto"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="makeCar"/>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="modelCar">
                        <spring:message text="Model car"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="modelCar"/>
                </td>
            </tr>
            
            <tr>
                <td>
                    <form:label path="year">
                        <spring:message text="year"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="year"/>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="cost">
                        <spring:message text="cost"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="cost"/>
                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <c:if test="${!empty auto.makeCar}">
                        <input type="submit" value="<spring:message text="edit car"/>" />
                    </c:if>

                    <c:if test="${!empty auto.makeCar}">
                        <input type="submit" value="<spring:message text="add car"/>" />
                    </c:if>
                </td>
            </tr>

        </table>
    </form:form>
</c:url>
</body>
</html>
