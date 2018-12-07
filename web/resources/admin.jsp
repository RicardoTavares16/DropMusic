<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>DropMusic - Admin</title>
</head>
<body>
    <p>Welcome/a <span id="person-username"><c:out value="${personBean.username}" /> to DropMusic Admin</span></p>

    <script src="resources/js/jquery-3.2.1.min.js"></script>
    <script src="resources/js/websocket.js"></script>
</body>
</html>
