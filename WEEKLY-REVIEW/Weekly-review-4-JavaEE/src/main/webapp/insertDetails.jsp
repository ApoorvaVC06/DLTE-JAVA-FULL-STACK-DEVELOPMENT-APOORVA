<%--
  Created by IntelliJ IDEA.
  User: xxvcccca
  Date: 3/23/2023
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  isELIgnored="false" language="java" %>
<html>
<head>
    <title>Student details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</head>
<style>
    body{
        background: linear-gradient(45deg,lightpink,lavender);
    }

</style>
<body>
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
    if(session.getAttribute("student")!=null){
%>

<div class="container text-bg-muted text-light py-2">

    <header class="text-center text-dark">
        <h3>Fill student details</h3>
    </header>

</div>
<section class="container">
    <form action="insert" method="post" class="card p-2 text-bg-info">
        <div class="form-group">
            <label>Registration number:</label>
            <input name="RegistrationNumber" type="text" class="form-control" placeholder="Enter register number">
        </div>
        <div class="form-group">
            <label>Name:</label>
            <input name="Name" type="text" class="form-control" placeholder="Enter student name">
        </div>
        <div class="form-group">
            <label>Student age:</label>
            <input name="StudentAge" type="text" class="form-control" placeholder="Enter age">
        </div>
        <div class="form-group">
            <label>Email:</label>
            <input name="Email" type="text" class="form-control" placeholder="Enter email">
        </div>

        <label>Gender</label>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
            <label>Male</label>

        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="flexRadioDefault"  checked>
            <label>Female</label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" checked>
            <label>Others</label>
        </div>
        </div>
        <div class="form-group">
            <h4>Current address</h4>
            <label>DoorNo:</label>
            <input name="curDoorNo" type="text" class="form-control" placeholder="Enter the door no">
        </div>
        <div class="form-group">
            <label>Street</label>
            <input name="curStreet" type="text" class="form-control" placeholder="Enter street">
        </div>
        <div class="form-group">
            <label>City</label>
            <input name="curCity" type="text" class="form-control" placeholder="Enter city">
        </div>
        <div class="form-group">
            <label>Pincode</label>
            <input name="curPincode" type="text" class="form-control" placeholder="Enter pincode">
        </div>
        <div class="form-group">
            <h4>Permanent address</h4>
            <label>Permanent DoorNo:</label>
            <input name="perDoorNo" type="text" class="form-control" placeholder="Enter permamnent door no">
        </div>
        <div class="form-group">
            <label>Permanent Street</label>
            <input name="perStreet" type="text" class="form-control" placeholder="Enter permanent street">
        </div>
        <div class="form-group">
            <label>Permanent City</label>
            <input name="perCity" type="text" class="form-control" placeholder="Enter permanent street">
        </div>
        <div class="form-group">
            <label>Permanent Pincode</label>
            <input name="perPincode" type="text" class="form-control" placeholder="Enter permanent street">
        </div>
        <div class="d-flex justify-content-end">
            <button type="submit" class="btn btn-success m-3" value="add">Submit</button>
            <button type="reset" class="btn btn-danger m-3">Reset</button>

        </div>

    </form>
    <form action="logout"><button class="btn btn-outline-primary">Logout</button></form>
</section>
<%}
else{
    response.sendRedirect("index.jsp");
}%>
</body>

</html>
