<%--
  Created by IntelliJ IDEA.
  User: ort
  Date: 2018-12-24
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="user" class="ua.nure.brykovets.dmytro.usermanagement.User" scope="session"/>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">

    <title>Edit user | User Management</title>
</head>
<body>

<div class="ui centered grid container" style="margin-top: 2rem;">

    <div class="eight wide column">

        <h1>User details</h1>

        <form action="<%=request.getContextPath()%>/details" method="post">

            <table class="ui basic table">
                <tbody>
                <tr>
                    <td>First Name</td>
                    <td><strong>${user.firstName}</strong></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><strong>${user.lastName}</strong></td>
                </tr>
                <tr>
                    <td>Date of birth</td>
                    <td><strong>${user.dateOfBirth}</strong></td>
                </tr>
                </tbody>
            </table>

            <input class="ui button" type="submit" name="okButton" value="OK">
        </form>

    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
</body>
</html>
