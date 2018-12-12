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
<c:choose>
    <c:when test="${session.editor == true}">
        <p><a href="<s:url action="editor" />">Back Editor</a></p>
    </c:when>
    <c:otherwise>
        <p><a href="<s:url action="person" />">Back</a></p>
    </c:otherwise>
</c:choose>

<c:out value="${dropMusicBean.toShow}" />

</body>
</html>

