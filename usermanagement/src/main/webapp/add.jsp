<%--
  Created by IntelliJ IDEA.
  User: ort
  Date: 2018-12-24
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">

    <title>Add user | User Management</title>
</head>
<body>

<div class="ui centered grid container" style="margin-top: 2rem;">

    <div class="eight wide column">

        <h1>Add user</h1>

        <form class="ui form" action="<%=request.getContextPath()%>/add" method="post">

            <div class="field">
                <label>First Name</label>
                <input type="text" name="firstName">
            </div>

            <div class="field">
                <label>Last Name</label>
                <input type="text" name="lastName">
            </div>

            <div class="field">
                <label>Date of birth</label>
                <input type="date" name="dateOfBirth">
            </div>

            <input class="ui button" type="submit" name="okButton" value="OK">
            <input class="ui button" type="submit" name="cancelButton" value="Cancel">
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
