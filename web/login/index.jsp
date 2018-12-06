<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<jsp:include page="auth.jsp"></jsp:include>


Hello <%=session.getAttribute("user") %>!
<br />
<br />
<br />
<!--<a href="chat.dropmusic.jsp">Enter chat!</a> ENTRA PROGRAMA-->