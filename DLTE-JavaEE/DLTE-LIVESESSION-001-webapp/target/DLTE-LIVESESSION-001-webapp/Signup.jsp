<%--
  Created by IntelliJ IDEA.
  User: xxvcccca
  Date: 3/28/2023
  Time: 11:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>signup page</title>
</head>
<style>
    body{
        background: linear-gradient(45deg,lightgray,lightskyblue);
    }

</style>
<body>
<div class="container">
<form class="card p-2 text-bg-info">

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

</form>
</div>
</body>
</html>
