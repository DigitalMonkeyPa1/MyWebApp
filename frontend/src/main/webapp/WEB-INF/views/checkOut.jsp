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

<h1>Thankyou for shopping with us ${userAttribute.customer.firstName} !</h1>
<br/>
<h3>Your order is:</h3>
<c:set var="grandTotal" value="0"></c:set>
<table>
<thead>
	<tr>
		<th>Product</th> <th>Quantity</th> <th>Total Price</th>
	</tr>
</thead>
<tbody>
	<c:forEach var="cartItem" items="${userAttribute.cartItems}" >
		<tr>
			<td>${cartItem.product.name}</td><td>${cartItem.quantity}</td><td>${cartItem.totalPrice}</td>
			<c:set var="grandTotal" value="${grandTotal + cartItem.totalPrice}"></c:set>
		</tr>
	</c:forEach>
</tbody>
</table>

<br/>
Grand Total : ${grandTotal}<br/>
<br/>

<h3>Your order will be delivered soon to the following shipping address:</h3><br/>
${userAttribute.customer.shippingAddress.doorNumber},&nbsp;${userAttribute.customer.shippingAddress.street},<br/>
${userAttribute.customer.shippingAddress.city},&nbsp;${userAttribute.customer.shippingAddress.state},<br/>
${userAttribute.customer.shippingAddress.country}&nbsp;-&nbsp;${userAttribute.customer.shippingAddress.zipcode}.<br/>
<br/><br/>
<h4><a href="<c:url value='/'></c:url>">Back to Home</a></h4>

<%@include file="footer.jsp" %>
</body>
</html>