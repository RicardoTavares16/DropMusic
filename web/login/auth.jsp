<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@page import="dropmusic.tmp.Person"%>

<%
    Person user = (Person) session.getAttribute("user");
    if (user == null) {
%>
<jsp:forward page="login.jsp"></jsp:forward>
<%
    }
%>
