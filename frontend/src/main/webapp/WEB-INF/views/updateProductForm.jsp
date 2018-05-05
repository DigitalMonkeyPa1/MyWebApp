<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="header.jsp" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Product Form</title>
</head>
<body>
<h1>updateProductForm.jsp</h1><br/><br/>
Enter product details<br/>
-----------------------------<br/>
<c:url value='/admin/updateProduct' var="myurl"></c:url>
<form:form action="${myurl}" modelAttribute="productAttribute" role="form" enctype="multipart/form-data">
<form:hidden path="id"/>
<form:label path="name">Name : </form:label><form:input path="name"/>
<form:errors path="name"  cssStyle="color:red"></form:errors><br/>
<form:label path="description">Description : </form:label><br/><form:textarea path="description"/>
<form:errors path="description" cssStyle="color:red"></form:errors><br/>
<form:label path="quantity">Quantity : </form:label><form:input path="quantity"/>
<form:errors path="quantity" cssStyle="color:red"></form:errors><br/>
<form:label path="price">Price : </form:label><form:input path="price"/>
<form:errors path="price" cssStyle="color:red"></form:errors><br/>

<form:label path="category.id">Category</form:label>
<form:select path="category.id">
	<c:forEach items="${categoriesAttribute}" var="cat">
		<form:option value="${cat.id}">${cat.name}</form:option>
	</c:forEach>
</form:select><br/>

<form:label path="image">Image : </form:label><br/>
<img alt='<c:url value="/resources/images/${productAttribute.id}.png"></c:url>' 
			src='<c:url value="/resources/images/${productAttribute.id}.png"></c:url>' width="264" height="64" ><br/>
<form:input path="image" type="file"/><br/>

<br/>
<input type="submit" value="Update Product">
</form:form>
<br/>
<a href='<c:url value="/allProducts" ></c:url>'>Back</a><br/>

<%@ include file="footer.jsp" %>
</body>
</html>