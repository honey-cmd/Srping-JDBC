<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact List</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js">
	
</script>
</head>
<body>
	<div class="container py-5">
		<div class="d-flex justify-content-between">
			<h3>Contact List</h3>
			<div>
				<c:url var="searchAction" value="/contact/search" />
				<form action="${searchAction}" method="GET" class="d-flex">
					<input type="text" name="keyword" class="form-control"
						placeholder="Search....." />
					<button type="submit" class="btn btn-success ml-3">Search</button>
				</form>
			</div>
			<c:url var="createAction" value="/contact/create" />
			<a class="inline-block btn btn-primary" href="${createAction}">Add
				New</a>
		</div>
		<div class="table-responsive py-5">
			<table class="table table-bordered table-striped">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Email</th>
					<th>Address</th>
					<th>Phone</th>
					<th>Action</th>
				</tr>
			<c:forEach  items="${contacts}" var="contact"  >
					<tr>
						<td>${contact.id}</td>
						<td>${contact.name}</td>
						<td>${contact.email}</td>
						<td>${contact.address}</td>
						<td>${contact.phone}</td>
						<td>
						
							<c:url var="deleteAction" value="/posts/destroy/{id}"/>
							<a class="btn btn-info" href="${editAction }">Edit</a>
							<a class="btn btn-danger" href="${deleteAction}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>