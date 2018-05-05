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

<br/>
<c:set var="grandTotal" value="0"></c:set>
<table>
<thead>
	<tr>
		<th>Product</th> <th>Quantity</th> <th>Total Price</th> <th>Action</th>
	</tr>
</thead>
<tbody>
<c:forEach var="cartItem" items="${cartItemsAttribute}">
	<tr>
		<td>${cartItem.product.name}</td><td>${cartItem.quantity}</td><td>${cartItem.totalPrice}</td>
		<td><a href="<c:url value='/cart/deleteCartItem/${cartItem.id}'></c:url>">remove</a></td>
		<c:set var="grandTotal" value="${grandTotal + cartItem.totalPrice}"></c:set>
	</tr>
</c:forEach>
</tbody>
</table>

<br/>
Grand Total : ${grandTotal} <br/>
<a href="<c:url value='/cart/clearCart'></c:url>">Clear Cart</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="<c:url value='/cart/checkOut'></c:url>">Checkout</a> <br/>

<br/>
<a href="<c:url value='/allProducts'></c:url>">Continue Shopping</a>

<%@include file="footer.jsp" %>
</body>
</html>
