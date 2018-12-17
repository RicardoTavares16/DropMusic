<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>DropMusic - Search Album</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<!--
se editor -> editor.jsp, se person -> person.jsp
-->
<c:choose>
    <c:when test="${session.editor == true}">
        <p><a href="<s:url action="editor" />">Back Editor</a></p>


        <h3>Edit Album Name:</h3>
        <s:form action="edit_name" method="post">
            <s:text name="New name: "/>
            <s:textfield name="newName"/>
            <button type="submit" class="pure-button pure-button-primary">Edit Name</button>
        </s:form>

        <h3>Edit Album Details:</h3>
        <s:form action="edit_details" method="post">
            <s:text name="New Details: "/>
            <s:textfield name="newDetails"/>
            <button type="submit" class="pure-button pure-button-primary">Edit Name</button>
        </s:form>

    </c:when>
    <c:otherwise>
        <p><a href="<s:url action="person" />">Back</a></p>
    </c:otherwise>
</c:choose>

<h3>Album details and Critics: </h3><br>

<c:out value="${dropMusicBean.toShow}"/>

</body>
</html>
