<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<h3>Contact List</h3>
		<c:url value="/contact/lists" var="actionUrl"></c:url>
		<form method="Post" action="${actionUrl}">
			<div class="form-group mb-3 col-5">
				<label for="Name">Name</label> 
				<input type="text" class="form-control" id="name" placeholder="Enter Name" />
			</div>
			<div class="form-group mb-3 col-5">
				<label for="email">Email</label> 
				<input type="text" class="form-control" id="email" placeholder="Enter email" />
			</div>
				<div class="form-group mb-3 col-5">
				<label for="address">Address</label> 
				<input type="text" class="form-control" id="address" placeholder="Enter address" />
			</div>
				<div class="form-group mb-3 col-5">
				<label for="phone">Phone</label> 
				<input type="text" class="form-control" id="phone" placeholder="Enter phone" />
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>