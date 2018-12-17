<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>DropMusic - Manage</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>

<s:form action="make_editor" method="post">
    <s:text name="User to make editor: "/>
    <s:textfield name="user2"/>
    <button type="submit" class="pure-button pure-button-primary">Make Editor</button>
</s:form>

<p><a href="<s:url action="remove" />">Remove Artists that have 0 albums</a></p>

<p><a href="<s:url action="editor" />">Back Editor</a></p>


<script src="resources/js/jquery-3.2.1.min.js"></script>
<script src="resources/js/websocket.js"></script>
</body>
</html>
