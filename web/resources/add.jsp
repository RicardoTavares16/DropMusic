<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>DropMusic - Search Artist</title>
</head>
<body>
<!-- se editor -> editor.jsp, se person -> person.jsp -->


<s:form action="add_music" method="post">
    <s:text name="Music to add"/>
    <s:textfield name="musicToAdd"/>
    <button type="submit" class="pure-button pure-button-primary">Add Music</button>
</s:form>


<s:form action="add_album" method="post">
    <s:text name="Album to add"/>
    <s:textfield name="albumToAdd"/>
    <button type="submit" class="pure-button pure-button-primary">Add Album</button>
</s:form>


<s:form action="add_artist" method="post">
    <s:text name="Artist to add"/>
    <s:textfield name="artistToAdd"/>
    <button type="submit" class="pure-button pure-button-primary">Add Artist</button>
</s:form>


<c:choose>
    <c:when test="${session.editor == true}">
        <p><a href="<s:url action="editor" />">Back Editor</a></p>
    </c:when>
    <c:otherwise>
        <p><a href="<s:url action="person" />">Back</a></p>
    </c:otherwise>
</c:choose>

</body>
</html>
