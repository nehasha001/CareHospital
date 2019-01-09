<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Neha
  Date: 8/29/2018
  Time: 1:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Change/Delete Appointments</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://m  axcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Hospital</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="/">Home</a></li>

            <li><a href="/doctors">Doctors</a></li>
            <li><a href="/myAppointments">My Appointments</a></li>
            <li><a href="/myAppointments">Delete Appointments</a> </li>

        </ul>


        <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> ${login.userName} </li>
        </ul>
    </div>
</nav>

<div align="center">
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Doctor Name</th>
            <th scope="col">Specialization</th>
            <th scope="col">Available Day</th>
            <th scope="col">Available Time</th>
        </tr>
        </thead>
        <tbody>
        <%--<c:forEach var="doctorsData" items="${doctors}">--%>
        <form class="form-horizontal" action="/deleteAppointment">

            <tr>
                <%--<td><c:out value="${user.docName}" /></td>--%>
                <%--<td><c:out value="${user.specialization}" /></td>--%>
                <%--<td><c:out value="${user.day}" /></td>--%>

                <td><input type="hidden" value="${doctors.docName}" name="docName">${doctors.docName}</td>
                <td><input type="hidden" value="${doctors.specialization}" name="specialization">${doctors.specialization}</td>
                <td><input type="hidden" value="${doctors.day}" name="day">${doctors.day}</td>
                <td><input type="hidden" value="${doctors.time}" name="time">${doctors.time}</td>


                <td><button type="submit" class="btn btn-default">Delete Appointment</button></td>
            </tr>
        </form>

        <%--</c:forEach>--%>
        </tbody>
    </table>
</div>


</body>
</html>