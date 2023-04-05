<%--
  Created by IntelliJ IDEA.
  User: xxvcccca
  Date: 3/20/2023
  Time: 2:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</head>
<body>
<!--navbar-->
<nav class="navbar navbar-expand-lg navbar-light bg-info">
    <div class="container-fluid">

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mb-2 mb-lg-4">
                <li class="nav-item">
                    <a class="nav-link active text-light" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active text-light" href="#">Help</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active text-light" href="#">Sign up</a>
                </li>

            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<!-- Marquee moving left just below Nav Bar -->
<div class="text-dark text-bg-warning h-10">
    <marquee direction="left" class="h-10 text-danger">
        <p>Bank never asks for OTP,Password,PIN or CVV number . Please remember that bank would never ask you to verify your account information through an e-mail or Call</p>
    </marquee>
</div>
<div class="container-fluid">
    <div class="row p-4">
        <!--create a form-->
        <form name="cust" class="col-lg-4 card p-4 rounded-5 text-bg-light mt-3">
            <h4 class="card-title text-dark rounded-4 text-center">Customer Login</h4>
            <div calss="form-group">
                <label>Customer ID:</label>
                <input type="text" class="form-control" placeholder="Enter your ID">
            </div>
            <div calss="form-group">
                <label>password:</label>
                <input type="text" class="form-control" placeholder="Enter password">
            </div>
            <div class="d-flex justify-content-end">

                <div class="mt-3">
                    <a href="#" class="text-decoration-none">Forgot Password?</a>
                </div>
            </div>
            <div class="d-flex justify-content-center mt-3">
                <a class="btn btn-outline-success m-3" href="home.html">Submit</a>
                <button type="reset" class="btn btn-outline-danger m-3">Reset</button>
            </div>
            <div class="justify-content-center mt-3">
                <button type="submit" calss="btn btn-outline-success m-3"></button>

            </div>
        </form>

        <form name="newcust" class="col-lg-6 card p-4 rounded-5 me-auto text-bg-light mt-3">
            <h4 class="card-title text-dark rounded-4 text-center">New customer?</h4>
            <div calss="form-group">
                <h5 class="head text-center text-danger">Welcome to Net Banking</h5><br>
                <marquee direction="up" scrollamount="1">

                    steps to login:<br>
                    1.Create a bank account with a registered mobile number<br>
                    2.Link aadahar and mobile number to your bank account<br>
                    3.Use the given customer ID for net banking<br>
                    4.Create a password of 8 characters<br>
                    5.Use the ID and password everytime you login<br>
                </marquee>
            </div>

        </form>
    </div>



</div>
</body>
</html>
