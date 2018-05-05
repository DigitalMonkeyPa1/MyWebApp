<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>login.jsp</h1><br/><br/>
<h2>Login Page</h2><br/>

<c:if test="${errorAttribute!=null}"> <span>${error}</span> </c:if>

<c:if test="${logoutMsgAttribute!=null}"> <span>${logoutMsgAttribute}</span> </c:if>

<form action='<c:url value="/j_spring_security_check" ></c:url>' method="post">
	Enter email: <input type="text" name="j_username"/> <br/>
	Enter password: <input type="text" name="j_password" /> <br/>
	<input type="submit" value="Login"> <br/>
</form>

<%@ include file="footer.jsp" %>
</body>
</html>
