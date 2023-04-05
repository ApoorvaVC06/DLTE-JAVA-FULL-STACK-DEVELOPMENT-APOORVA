<%@ page import="java.util.List" %>
<%@ page import="ojdbc.Students" %>
<%@ page import="ojdbc.Students" %><%--
  Created by IntelliJ IDEA.
  User: xxvcccca
  Date: 3/23/2023
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>student</title>
</head>
<style>
    body{
        background: linear-gradient(45deg,blue,black);
    }
</style>
<body>
<% List<Students> object= (List<Students>)request.getAttribute("studentDB");
 // pageContext.setAttribute("information",object, pageContext.APPLICATION_SCOPE);
    %>
<div class="container-fluid">
    <table>
        <thead>
        <tr>
            <th>Register Number</th>
            <th>Student Name</th>
            <th>Student Age</th>
            <th>Student Email</th>
        </tr>
        </thead>
        <tbody>
        <% for (Students students:object){ %>
        <tr>
            <tb><%=students.getRegisterNumber()%></tb>
            <tb><%=students.getName()%></tb>
            <tb><%=students.getAge()%></tb>
            <tb><%=students.getEmail()%></tb>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>
<a href="index.jsp">go back to the index page </a>
</body>
</html>
