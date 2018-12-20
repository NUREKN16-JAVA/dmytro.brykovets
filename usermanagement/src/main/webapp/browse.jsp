<%--
  Created by IntelliJ IDEA.
  User: ort
  Date: 2018-12-20
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User management | Browse</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/browse.jsp" method="post">
    <table id="usersTable">
        <thead>
        <tr>
            <th></th>
            <th>First name</th>
            <th>Last name</th>
            <th>Date of birth</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <c:forEach var="user" items="$(sessionScope.users)">
                <td><input type="radio" id="id" name="id" value="$(user.id)"></td>
                <td>$(user.firstName)</td>
                <td>$(user.lastName)</td>
                <td>$(user.dateOfBirth)</td>
            </c:forEach>
        </tr>
        </tbody>
    </table>
    <input type="submit" name="addButton" value="Add">
    <input type="submit" name="editButton" value="Edit">
    <input type="submit" name="deleteButton" value="Delete">
    <input type="submit" name="detailsButton" value="Details">
</form>
</body>
</html>
