
<%@ page import="java.sql.ResultSet" %>
<%@ page import="javaee.Adresses" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: xxvcccca
  Date: 3/25/2023
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">


<body>
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
    if(session.getAttribute("student")!=null){
%>
<%--<% List<Adresses> object= (List<Adresses>)request.getAttribute("studentDB");--%>
<%--    // pageContext.setAttribute("information",object, pageContext.APPLICATION_SCOPE);--%>
<%--%>--%>
<%
    List<Adresses> info= (List<Adresses>) request.getAttribute("addressDB");
%>
<% Adresses address =new Adresses(); %>
<div class="container">
    <div class="row justify-content-center">
        <div class="d-flex justify-content-end mt-5">
            <a href="logout" class="btn btn-outline-danger"><i class="bi bi-box-arrow-left">Logout</i></a>
        </div>
        <div class="row justify-content-center">
            <h1 class="rounded-4 bg-success text-dark text-center mt-3 ">Current Address</h1>
        </div>
        <div class = " card bg-info mt-2 rounded-4 p-2  col-lg-5 col-md-8 col-sm-12">
            <ul>
                <li>Door Number : <%=address.getDoorNo()%></li>
                <li>Street : <%=address.getStreet()%></li>
                <li>City : <%=address.getCity()%></li>
                <li>Pin code : <%=address.getAddId()%></li>
            </ul>
        </div>
    </div>
</div>
<div class="container">
    <div class="row justify-content-center">
        <div class="d-flex justify-content-end mt-5">
            <a href="logout" class="btn btn-outline-danger"><i class="bi bi-box-arrow-left">Logout</i></a>
        </div>
        <div class="row justify-content-center">
            <h1 class="rounded-4 bg-success text-dark text-center mt-3 ">Current Address</h1>
        </div>
        <div class = " card bg-info mt-2 rounded-4 p-2  col-lg-5 col-md-8 col-sm-12">
            <ul>
                <li>Door Number : <%=address.getDoorNo()%></li>
                <li>Street : <%=address.getStreet()%></li>
                <li>City : <%=address.getCity()%></li>
                <li>Pin code : <%=address.getAddId()%></li>
            </ul>
        </div>
    </div>
</div>





<form action="logout"><button class="btn btn-outline-primary">Logout</button></form>
<%}
else{
    response.sendRedirect("index.jsp");
}%>
</body>
</html>
