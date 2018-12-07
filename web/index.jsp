<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Drop Music - Login</title>
</head>
<body>

<h1>DropMusic - Login</h1>

<s:form action="login" method="post">
    <s:text name="Username:" />
    <s:textfield name="PersonBean.username" /><br>
    <s:text name="Password:" />
    <s:password name="PersonBean.password" /><br>
    <button type="submit" class="pure-button pure-button-primary">Sign in</button>
</s:form>

<h4>Login with DropBox</h4>

<h4>Sign Up</h4>
<s:form action="regist" method="post">

</s:form>

</body>
</html>