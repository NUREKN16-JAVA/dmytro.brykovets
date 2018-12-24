<%--
  Created by IntelliJ IDEA.
  User: ort
  Date: 2018-12-20
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">

    <title>User management | Browse</title>
</head>
<body>

<div class="ui centered grid container" style="margin-top: 2rem;">

    <div class="eight wide column">

        <h1>Browse users</h1>

        <form class="ui form" action="<%=request.getContextPath() %>/browse" method="post">
            <table class="ui single line selectable table" id="usersTable">
                <thead>
                <tr>
                    <th></th>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Date of birth</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${sessionScope.users}">
                    <tr>
                        <td><input type="radio" id="id" name="id" value="${user.id}"></td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.dateOfBirth}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <input class="ui button" type="submit" name="addButton" value="Add">
            <input class="ui button" type="submit" name="editButton" value="Edit">
            <input class="ui button" type="submit" name="deleteButton" value="Delete">
            <input class="ui button" type="submit" name="detailsButton" value="Details">
        </form>

    </div>

</div>

<c:if test="${requestScope.error != null}">
    <script>
        alert("${requestScope.error}")
    </script>
</c:if>

<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
</body>
</html>
