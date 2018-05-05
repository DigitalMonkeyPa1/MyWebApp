<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="header.jsp" %>


<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script>

$(document).ready(function()
						{
							var searchForThis = '${searchAttribute}';
							console.log("Search for this: ",searchForThis);
							var dataTableProperties = {
														"lengthMenu" : [ [5,7,-1], [5,7,"All"] ],
														"oSearch"    : { "sSearch":searchForThis }
								  				  	  };
							
    						$('#productsTable').DataTable(dataTableProperties);
						} 
				);
</script>

<title>Products List</title>
</head>

<body>
<h1>productsList.jsp</h1><br/>
<h3 id="testid">Searching for category: ${searchAttribute}</h3>
<br/>
The list of products are: <br/>
<table id="productsTable" >
<thead>
	<tr>
		<th>Id</th>
		<th>Image</th>
		<th>Name</th>
		<th>Category</th>
		<th>Description</th>
		<th>Quantity</th>
		<th>Price</th>
		<th>Actions</th>
	</tr>
</thead>
<tbody>
	<c:forEach var="p" items="${productsAttribute}">
	<tr>
	
		<td>${p.id}</td>
		<td>
		<img alt='<c:url value="/resources/images/${p.id}.png"></c:url>' 
				src='<c:url value="/resources/images/${p.id}.png"></c:url>' width="64" height="64" >
			</td>
		<td>${p.name}</td>
		<td>${p.category.name}</td>
		<td>${p.description}</td>
		<td>${p.quantity}</td>
		<td>${p.price}</td>
		<td><a href="allProducts/${p.id}"> info </a>
			<security:authorize access="hasRole('ROLE_USER')">
				,<a href="<c:url value='/cart/addToCart/${p.id}?requestedQuantity=1'></c:url>"> add to cart </a>
			</security:authorize>
			<security:authorize access="hasRole('ROLE_ADMIN')">
				,<a href='<c:url value="/admin/updateProductForm/${p.id}"></c:url>'> edit </a>
				,<a href='<c:url value="/admin/deleteProduct/${p.id}"></c:url>'> delete </a>
			</security:authorize>.
			</td>
	
	</tr>
	</c:forEach>

</tbody>
</table>

<%@ include file="footer.jsp" %>
</body>
</html>