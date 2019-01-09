<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%--
  Created by IntelliJ IDEA.
  User: Neha
  Date: 8/29/2018
  Time: 1:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Doctors</title>
    <style>p {text-align:center;} </style>


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

<sql:setDataSource var="database"
                   driver = "org.postgresql.Driver"
                   url="jdbc:postgresql://localhost:5432/postgres"
                   user="postgres" password="iHateyou7"></sql:setDataSource>

<sql:query var="doctorlist" dataSource="${database}">
    SELECT * FROM doctorsdata;
</sql:query>


<div align="center">
    <table class="table">
        <thread class="thead-dark">
        <tr>
            <th scope="col">Doctor Name</th>
            <th scope="col">Specialization</th>
            <th scope="col">Available Day</th>
            <th scope="col">Available Time</th>
        </tr>
        </thread>
        <tbody>
        <c:forEach var="user" items="${doctorlist.rows}">
            <form class="form-horizontal" action="/bookappointment" method="post">

                <tr>
                        <%--<td><c:out value="${user.docName}" /></td>--%>
                        <%--<td><c:out value="${user.specialization}" /></td>--%>
                        <%--<td><c:out value="${user.day}" /></td>--%>

                    <td><input type="hidden" value="${user.docName}" name="docName">${user.docName}</td>
                    <td><input type="hidden" value="${user.specialization}" name="specialization">${user.specialization}</td>
                    <td><input type="hidden" value="${user.day}" name="day">${user.day}</td>
                    <td><input type="hidden" value="${user.time}" name="time">${user.time}</td>


                    <td><button type="submit" class="btn btn-default">Book Appointment</button></td>
                </tr>
            </form>

        </c:forEach>
        </tbody>
    </table>

</div>



<%--<form class="form-horizontal" action="/searchDoctor" method="post">--%>

<%--<div class="form-group">--%>
<%--<label class="control-label col-sm-2" for="docName">Enter DoctorsData Name:</label>--%>
<%--<div class="col-xs-4">--%>
<%--<input type="text" class="form-control" id="docName" name="docName" placeholder="Search for DoctorsData">--%>
<%--</div>--%>
<%--</div>--%>


<%--<div class="form-group">--%>
<%--<label for="specialization" class="col-sm-2 control-label">Specialization : </label>--%>
<%--<div class="col-sm-2">--%>
<%--<select class="form-control selcls" id="specialization" name="specialization">--%>
<%--<option> --Select-- </option>--%>
<%--<option value="Psychiatry"> Psychiatry </option>--%>
<%--<option value="Skin Specialist">Skin Specialist</option>--%>
<%--<option value="Pediatric">Pediatric</option>--%>
<%--<option value="Orthopedic">Orthopedic</option>--%>
<%--</select>--%>

<%--</div>--%>
<%--</div>--%>

<%--<div class="form-group">--%>
<%--<label for="avilableDays" class="col-sm-2 control-label">Available Days : </label>--%>
<%--<div class="col-sm-2">--%>
<%--<select class="form-control selcls" id="avilableDays" name="day">--%>
<%--<option> --Select-- </option>--%>
<%--<option value="Monday"> Monday </option>--%>
<%--<option value="Tuesday"> Tuesday</option>--%>
<%--<option value="Thursday"> Thursday</option>--%>
<%--<option value="Saturday"> Saturday</option>--%>
<%--</select>--%>
<%--</div>--%>
<%--</div>--%>


<%--<div class="form-group">--%>
<%--<div class="col-sm-offset-2 col-sm-10">--%>
<%--<button type="submit" class="btn btn-default">Search</button>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</form>--%>

<%--<form class="form-horizontal" action="#" method="post">--%>



<%--<div class="form-group">--%>
<%--<label class="control-label col-sm-2" for="specialization">Enter Specialization:</label>--%>
<%--<div class="col-xs-4">--%>
<%--<input type="text" class="form-control" id="specialization" name="specialization" placeholder="Search for Specialization">--%>
<%--</div>--%>
<%--</div>--%>

<%--<div class="form-group">--%>
<%--<div class="col-sm-offset-2 col-sm-10">--%>
<%--<button type="submit" class="btn btn-default">Search</button>--%>
<%--</div>--%>
<%--</div>--%>

<%--</form>--%>








<%--<p>--%>
<%--<form>--%>
<%--<div class="row">--%>
<%--<div class="col-xs-4">--%>
<%--<input type="text" class="form-control" id="doctorName" name="doctorName" placeholder="Enter DoctorsData Name">--%>
<%--</div>--%>
<%--<div class="input-group-btn">--%>
<%--<button class="btn btn-default" type="submit">--%>
<%--<i class="glyphicon glyphicon-search"></i>--%>
<%--</button>--%>
<%--</div>--%>
<%--</div>--%>
<%--</form>--%>

<%--<p><b>Or</b></p>--%>



<%--<form>--%>
<%--<div class="row">--%>
<%--<div class="col-xs-4">--%>
<%--<input type="text" class="form-control" id="specialization" name="specialization" placeholder="Enter Specialization">--%>
<%--</div>--%>
<%--<div class="input-group-btn">--%>
<%--<button class="btn btn-default" type="submit">--%>
<%--<i class="glyphicon glyphicon-search"></i>--%>
<%--</button>--%>
<%--</div>--%>
<%--</div>--%>
<%--</form>--%>
<%--</p>--%>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>