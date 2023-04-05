
<%@ page import="java.sql.ResultSet" %>
<%@ page import="ojdbc.Adresses" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: xxvcccca
  Date: 3/25/2023
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<% List<Adresses> object= (List<Adresses>)request.getAttribute("studentDB");--%>
<%--    // pageContext.setAttribute("information",object, pageContext.APPLICATION_SCOPE);--%>
<%--%>--%>
<%
    List<Adresses> info= (List<Adresses>) request.getAttribute("addressDB");
%>

<div class="container-fluid">
    <table>
        <thead>
        <tr>
            <th>AddID</th>
            <th>Doono</th>
            <th>street</th>
            <th>city</th>
            <th>pincode</th>

        </tr>
        </thead>
        <tbody>
        <% for (Adresses adresses:info) {%>
        <tr>
            <tb><%=adresses.getAddId()%></tb>
            <tb><%=adresses.getDoorNo()%></tb>
            <tb><%=adresses.getStreet()%></tb>
            <tb><%=adresses.getCity()%></tb>
            <tb><%=adresses.getPin()%></tb>

        </tr>
        <%}%>
        </tbody>
    </table>
</div>
</body>
</html>
