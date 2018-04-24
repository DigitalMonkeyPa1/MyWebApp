<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="header.jsp" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Overview</title>
</head>
<body>
<h1>productOverview.jsp</h1><br/><br/>
${productAttribute.id}. ${productAttribute.name}, ${productAttribute.description},
${productAttribute.quantity}, ${productAttribute.price},
${productAttribute.category.name}-${productAttribute.category.id}<br/>
<img alt='<c:url value="/resources/images/${productAttribute.id}.png"></c:url>' 
			src='<c:url value="/resources/images/${productAttribute.id}.png"></c:url>' width="264" height="64" >

<br/>
<a href='<c:url value="/allProducts"></c:url>' > Back </a>

</body>
</html>