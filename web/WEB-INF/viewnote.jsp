<%-- 
   
    Author     : 842458
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1><br>
        <h2>View Note</h2><br>
        <%
            if(request.getAttribute("data")!=null){
                ArrayList<String> data=(ArrayList<String>)request.getAttribute("data");
        %>
        <h3>Title:</h3><span><%= data.get(0)%></span>
        <h3>Contents:</h3><span><%= data.get(1)%></span><br>
        <a href="editnote.jsp">Edit</a>
        <%}%>
    </body>
</html>
