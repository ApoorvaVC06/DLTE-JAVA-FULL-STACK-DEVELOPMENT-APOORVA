<%@ page import="oracle.jdbc.OracleDriver" %>
<%@ page import="java.sql.*" %>
<%@ page import="javaee.Students" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: xxvcccca
  Date: 3/27/2023
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<style>
    body{
        background: linear-gradient(45deg,lightpink,lavender);
    }
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
<body>
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
    if(session.getAttribute("student")!=null){
%>

<% List<Students> studentList = (List<Students>)request.getAttribute("studentDB");
  // pageContext.setAttribute("list",studentList, pageContext.APPLICATION_SCOPE);%>
<div class="container">
    <h2 class="text-dark text-center">Student details</h2>
    <div class="d-flex justify-content-end mt-5">
    </div>
    <div class=" row justify-content-center mt-3">
        <table class="table table-bordered table-hover table-sm">
            <thead>
            <tr class="bg-info">
                <th>Register number</th><th>Name</th><th>Age</th><th>Email</th><th>Address Type</th><th>Remove student</th>
            </tr>
            </thead>
            <tbody>
            <% for(Students student:studentList){  %>
            <tr class="bg-light">
                <td><%=student.getRegisterNumber() %></td>
                <td><%=student.getName() %></td>
                <td><%=student.getAge() %></td>
                <td><%=student.getEmail() %></td>
                <td><a href="viewAddress.jsp" class="btn btn-outline-warning"><i class="bi bi-geo-alt-fill">Current</i></a> <a href="viewAddress.jsp" class="btn btn-outline-success"><i class="bi bi-geo-alt-fill">Permanent</i></a> </td>
                <td> <a class="btn btn-outline-danger">
                    <i class="bi bi-trash3-fill">Delete student</i></a>
                </td>
            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
    <div class="d-flex justify-content-end p-5 mt-4">
        <a href="insertDetails.jsp" class="btn btn-outline-success"><i class="bi bi-database-fill-add">Add new Student</i></a>
    </div>
</div>
<a href="index.jsp" class="btn btn-outline-primary m-3"><i class="bi bi-box-arrow-left">Logout</i></a>
<%}else{
response.sendRedirect("index.jsp");
}%>
</body>
</html>
