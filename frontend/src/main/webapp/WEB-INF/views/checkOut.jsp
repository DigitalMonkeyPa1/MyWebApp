<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Thankyou for shopping with us ${userNameAttribute}!</h1><br/><br/>
<h3>Your product will be delivered soon to the following shipping address:</h3><br/>
${shippingAddressAttribute.doorNumber},${shippingAddressAttribute.street},<br/>
${shippingAddressAttribute.city},${shippingAddressAttribute.state},<br/>
${shippingAddressAttribute.country} - ${shippingAddressAttribute.zipcode}.<br/>
<br/><br/>
<h4><a href="<c:url value='/'></c:url>">Back to Home</a></h4>
</body>
</html>