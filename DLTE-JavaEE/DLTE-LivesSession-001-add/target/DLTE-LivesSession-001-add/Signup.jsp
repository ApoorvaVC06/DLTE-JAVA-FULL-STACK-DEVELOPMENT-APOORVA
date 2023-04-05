<%--
  Created by IntelliJ IDEA.
  User: xxvcccca
  Date: 3/29/2023
  Time: 12:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

<style>
    body{
        background: linear-gradient(45deg,lightgray,lightskyblue);
    }

</style>
<body>
<h2 class="text-center text-dark">Signup here</h2>
<div class="container mt-7">
    <form action="signup" method="post" class="card p-2 text-bg-info">

        <div class="form-group">
            <label>Full Name:</label>
            <input name="name" type="text" class="form-control" placeholder="Enter name">
        </div>
        <div class="form-group">
            <label>Email ID:</label>
            <input name="email" type="text" class="form-control" placeholder="Enter email">
        </div>
        <div class="form-group">
            <label>PAN-card number::</label>
            <input name="pan" type="text" class="form-control" placeholder="Enter pan">
        </div>
        <div class="form-group">
            <label>Contact number:</label>
            <input name="contact" type="text" class="form-control" placeholder="Enter number">
        </div>
        <div class="form-group">
            <label>Set Pin:</label>
            <input name="pin" type="text" class="form-control" placeholder="Enter pin">
        </div>
        <div class="d-flex justify-content-center">
            <button class="btn btn-outline-success m-3" type="submit" onclick="window.location.href='login.jsp'">submit</button>
            <button type="reset" class="btn btn-outline-danger m-3">reset</button>

        </div>

    </form>
</div>
</body>
</html>
