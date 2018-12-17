<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Drop Music - Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>

<h1>DropMusic</h1>
<p class="form-group">
<h4>Sign In</h4>
<s:form action="login" method="post">
    <s:text name="Username"/><br>
    <s:textfield name="username"/><br>
    <s:text name="Password"/><br>
    <s:password name="password"/><br>
    <button type="submit" class="pure-button pure-button-primary">Sign In</button>
</s:form>
</p>

<p class="form-group">
<h4>Sign Up</h4>
<s:form action="regist" method="post">
    <s:text name="Username"/><br>
    <s:textfield name="username"/><br>
    <s:text name="Password"/><br>
    <s:password name="password"/><br>
    <button type="submit" class="pure-button pure-button-primary">Sign Up</button>
</s:form>
</p>

</body>
</html>