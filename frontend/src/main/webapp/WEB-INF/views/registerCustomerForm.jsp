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

<c:url var="url" value="/registerCustomer"></c:url>
<form:form modelAttribute="customerAttribute" action="${url}">

<form:label path="id"></form:label>
<form:hidden path="id"/>

<form:label path="firstName">Enter FirstName</form:label>
<form:input path="firstName"/>

<form:label path="lastName">Enter LastName</form:label>
<form:input path="lastName"/>

<form:label path="mobileNumber">Enter MobileNumber</form:label>
<form:input path="mobileNumber"/>

<hr>
<p align="center"><b>Login credentials</b><br></p>
<form:label path="user.email">Enter Email </form:label>
<form:input path="user.email"/>

<form:label path="user.password">Enter password</form:label>
<form:input path="user.password"/>

<hr>
<p align="center"><b>Billing Address</b><br></p>

<form:label path="billingAddress.doorNumber">Enter DoorNumber</form:label>
<form:input path="billingAddress.doorNumber"/>

<form:label path="billingAddress.street">Enter Street</form:label>
<form:input path="billingAddress.street"/>

<form:label path="billingAddress.city">Enter City</form:label>
<form:input path="billingAddress.city"/>

<form:label path="billingAddress.state">Enter State</form:label>
<form:input path="billingAddress.state"/>

<form:label path="billingAddress.country">Enter Country</form:label>
<form:input path="billingAddress.country"/>

<form:label path="billingAddress.zipcode">Enter ZipCode</form:label>
<form:input path="billingAddress.zipcode"/>

<hr>
<p align="center"><b>Shipping Address</b></p>	

<form:label path="shippingAddress.doorNumber">Enter DoorNumber</form:label>
<form:input path="shippingAddress.doorNumber"/>

<form:label path="shippingAddress.street">Enter Street</form:label>
<form:input path="shippingAddress.street"/>

<form:label path="shippingAddress.city">Enter City</form:label>
<form:input path="shippingAddress.city"/>

<form:label path="shippingAddress.state">Enter State</form:label>
<form:input path="shippingAddress.state"/>

<form:label path="shippingAddress.country">Enter Country</form:label>
<form:input path="shippingAddress.country"/>

<form:label path="shippingAddress.zipcode">Enter ZipCode</form:label>
<form:input path="shippingAddress.zipcode"/>

<button type="submit">Register</button>
</form:form>

</body>
</html>
