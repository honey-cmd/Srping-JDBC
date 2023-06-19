<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js">
	
</script>
</head>
<body>
	<div class="container py-5">
		<h3>Contact Edit</h3>
		<c:url value="/edit" var="updateDb"></c:url>
		<form:form method="POST" action="${updateDb}" modelAttribute="updateForm">
			<form:hidden path="id"/>
			<div class="form-group mb-3 col-5">
				<form:label path="name">Name</form:label>
				<form:input path="name" class="form-control" placeholder="Enter Name"/>
				<form:errors path="name"></form:errors>
			</div>
			
			<div class="form-group mb-3 col-5">
				<form:label path="email">Email</form:label>
				<form:input path="email" class="form-control" placeholder="Enter Email"/>
				<form:errors path="email"></form:errors>
			</div>
			<div class="form-group mb-3 col-5">
				<form:label path="address">Address</form:label>
				<form:input path="address" class="form-control" placeholder="Enter Address"/>
				<form:errors path="address"></form:errors>
			</div>
			<div class="form-group mb-3 col-5">
				<form:label path="phone">Phone</form:label>
				<form:input path="phone" class="form-control" placeholder="Enter Phone"/>
				<form:errors path="phone"></form:errors>
			</div>
			
			
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>
</body>
</html>