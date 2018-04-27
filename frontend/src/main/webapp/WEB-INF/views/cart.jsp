<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="<c:url value='/cart/clearCart'></c:url>">Clear Cart</a> <br/>
<a href="<c:url value='/cart/checkOut'></c:url>">Checkout</a> <br/>

<br/>
<c:set var="grandTotal" value="0"></c:set>

<c:forEach var="cartItem" items="${cartItemsAttribute}">
	${cartItem.product.name}, ${cartItem.quantity}, ${cartItem.totalPrice} 
		=> <a href="<c:url value='/cart/deleteCartItem/${cartItem.id}'></c:url>">remove</a> <br/>
	<c:set var="grandTotal" value="${grandTotal + cartItem.totalPrice}"></c:set>
</c:forEach>
<br/>

Grand Total : ${grandTotal} <br/>
<br/>
<a href="<c:url value='/allProducts'></c:url>">Continue Shopping</a>
</body>
</html>
