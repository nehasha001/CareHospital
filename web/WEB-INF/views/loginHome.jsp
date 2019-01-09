<%--
  Created by IntelliJ IDEA.
  User: Neha
  Date: 8/29/2018
  Time: 1:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Home</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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

<h1>${List.get(0)}</h1>
<h1>${List.get(1)}</h1>
<h1>${List.get(2)}</h1>
<h1>${List.get(3)}</h1>


</body>
</html>
