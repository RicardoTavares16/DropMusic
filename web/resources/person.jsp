<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>DropMusic</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
    <p>Welcome <span id="person-username"><c:out value="${session.username}" /> to DropMusic</span></p>

    <!--Menu-->
    <div class="pure-menu pure-menu-horizontal pure-menu-scrollable">
        <a href="<s:url action="index" />" class="pure-menu-link pure-menu-heading">Back</a>
        <ul class="pure-menu-list">
            <!--
                1 - Listar Albuns
                2 - Pesquisa
            -->
            <li class="pure-menu-item"><a href="<s:url action="list_albums" />" class="pure-menu-link">List Albums</a>, list all the albums.</li>
        </ul>

        <s:form action="search_by_album" method="post">
            <s:text name="Album to search"/>
            <s:textfield name="albumName"/>
            <button type="submit" class="pure-button pure-button-primary">Search Album</button>
        </s:form>

        <s:form action="search_by_artist" method="post">
            <s:text name="Artist to search"/>
            <s:textfield name="artistName"/>
            <button type="submit" class="pure-button pure-button-primary">Search Artist</button>
        </s:form>
    </div>

    <p><a href="<s:url action="dropbox" />">Dropbox</a></p>

    <noscript>JavaScript must be enabled for WebSockets to work.</noscript>

    <script src="resources/js/jquery-3.2.1.min.js"></script>
    <script src="resources/js/websocket.js"></script>
</body>
</html>
