<%--
  Created by IntelliJ IDEA.
  User: xxvcccca
  Date: 3/26/2023
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
<style>
    body{
        background: linear-gradient(45deg,lightpink,lavender);
    }

    button{
        height:100px;
          width:250px;
    }
</style>
<body>
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
    if(session.getAttribute("student")!=null){
%>
<div class="card-lg-7 card-center justify-content-center p-3 m-5 rounded-5">
<div class="text-center text-dark">
    <h2 class="text-center mt-5">Select an option</h2>
    <div>
<button class="btn btn-outline-danger m-5 mb-4" onclick="window.location.href='details';">
    Student details
</button>
    </div>
    <div>
<button class="btn btn-outline-primary m-5 mb-4" onclick="window.location.href='insertDetails.jsp';">
    Add student
</button>
    </div>

</div>
</div>
<form action="logout"><button style="height:25px;width:30px" class="btn btn-outline-primary">Logout</button></form>
<%}
else{
    response.sendRedirect("index.jsp");
}%>
</body>
</html>
