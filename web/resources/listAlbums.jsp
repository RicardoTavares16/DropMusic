<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>DropMusic - List Albums</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<h1><p>List Albuns</p></h1>

<div class="row">
    <div class="col-sm-6 text-center">
        <h3>Albums</h3>
        <c:forEach items="${dropMusicBean.getAlbuns}" var="album">
            <a href="<s:url action="review">
        <s:param name="albumName">${album}</s:param>
    </s:url>"><c:out value="${album}"/><br></a>

        </c:forEach>
    </div>

    <div class="col-sm-6">
        <h3>Details</h3>
        <c:forEach items="${dropMusicBean.getAlbumDetails}" var="details">
            <c:out value="${details}"/><br>
        </c:forEach>
    </div>
</div>
<!-- se editor -> editor.jsp, se person -> person.jsp -->
<c:choose>
    <c:when test="${session.editor == true}">
        <p><a href="<s:url action="editor" />">Back Editor</a></p>
    </c:when>
    <c:otherwise>
        <p><a href="<s:url action="person" />">Back</a></p>
    </c:otherwise>
</c:choose>


<noscript>JavaScript must be enabled for WebSockets to work.</noscript>

<script src="resources/js/jquery-3.2.1.min.js"></script>
<script src="resources/js/websocket.js"></script>

</body>
</html>
