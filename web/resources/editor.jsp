<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>DropMusic - EDITOR</title>
</head>
<body>
    <p>Welcome <span id="person-username"><c:out value="${personBean.username}" /> to DropMusic - EDITOR</span></p>

    <!--Menu-->
    <div class="pure-menu pure-menu-horizontal pure-menu-scrollable">
        <a href="<s:url action="index" />" class="pure-menu-link pure-menu-heading">Back</a>
        <ul class="pure-menu-list">

            <!-- @TODO: ter uma opção para adicionar música em que é obrigatório adicionar musica, album e artista? ou um de cada vez e ter opções de os linkar? -->

            <!--
                1 - Listar Albuns
                2 - Pesquisa
                3 - Adicionar
                4 - Gestão
            -->

            <li class="pure-menu-item"><a href="<s:url action="list_albums" />" class="pure-menu-link">List Albums</a>, list all the albums.</li>
            <li class="pure-menu-item"><a href="<s:url action="search" />" class="pure-menu-link">Search</a>, by artist or album.</li>
            <li class="pure-menu-item"><a href="<s:url action="add" />" class="pure-menu-link">Add</a>, music, album or artist</li>
            <li class="pure-menu-item"><a href="<s:url action="manage" />" class="pure-menu-link">Manage</a>, make editor.</li>
        </ul>

    </div>

    <noscript>JavaScript must be enabled for WebSockets to work.</noscript>

    <script src="resources/js/jquery-3.2.1.min.js"></script>
    <script src="resources/js/websocket.js"></script>
</body>
</html>
