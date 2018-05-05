<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<html>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
<link   rel="stylesheet"       href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple Online Shopping</title>
</head>
<body>

<a href="<c:url value="/home"></c:url>">Home</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="<c:url value='/allProducts'></c:url>">All Products</a>

<security:authorize access="hasRole('ROLE_ADMIN')">
&nbsp;&nbsp;&nbsp;&nbsp;
	<a href='<c:url value="/admin/addProductForm"></c:url>'> Add Product </a>
</security:authorize>

<security:authorize access="hasRole('ROLE_USER')">
	&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="<c:url value='/cart/purchaseDetails'></c:url>"> View Cart </a>
</security:authorize>

<c:if test="${pageContext.request.userPrincipal.name == null}">
	&nbsp;&nbsp;&nbsp;&nbsp;
	<a href='<c:url value="/customerRegistrationForm"></c:url>' > Sign Up </a>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<a href='<c:url value="/login"></c:url>' > Sign In </a>
</c:if>

<c:if test="${pageContext.request.userPrincipal.name != null}">
	&nbsp;&nbsp;&nbsp;&nbsp;
	<a href='<c:url value="/j_spring_security_logout"></c:url>' > Logout </a>
</c:if>

<br/>
<hr>
Categories :
<ul>
	<li><a href='<c:url value="/searchByCategory?searchCategory=Fruits"></c:url>' >Fruits</a></li>
	<li><a href='<c:url value="/searchByCategory?searchCategory=Vegetables"></c:url>' >Vegetables</a></li>
	<li><a href='<c:url value="/searchByCategory?searchCategory=Games"></c:url>' >Games</a></li>
	<li><a href='<c:url value="/searchByCategory?searchCategory=Toys"></c:url>' >Toys</a></li>
</ul>

<hr>

</body>

</html>
