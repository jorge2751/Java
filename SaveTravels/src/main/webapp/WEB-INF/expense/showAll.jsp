<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script> 
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="table">
		<thead>
			<th>Expense</th>
			<th>Vendor</th>
			<th>Amount</th>
			<th>Action</th>
		</thead>
		<tbody>
			<c:forEach var="expense" items="${allExpenses}">
				<tr>
					<td><a href="/expenses/display/${expense.id}"><c:out value="${expense.name}"/></a></td>
					<td><c:out value="${expense.vendor}"/></td>
					<td><c:out value="${expense.amount}"/></td>
					<td>
						<form action="/expenses/delete/${expense.id}" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <input type="submit" value="Delete">
						</form>
						<div class="btn btn-outline-warning">
							<a href="/expenses/edit/${expense.id}">Edit</a>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form:form action="/expenses/process/create" method="post" modelAttribute="expense">
	    <div class="form-group">
	        <form:label path="name">Expense Name</form:label>
	        <form:input type="text" path="name" class="form-control" />
	        <form:errors path="name"/>
	    </div>
	    <div class="form-group">
	        <form:label path="vendor">Vendor</form:label>
	        <form:input type="text" path="vendor" class="form-control" />
	        <form:errors path="vendor"/>
	    </div>
	    <div class="form-group">
	        <form:label path="amount">Amount</form:label>
	        <form:input type="number" path="amount" class="form-control" />
	        <form:errors path="amount"/>
	    </div>
	    <div class="form-group">
	        <form:label path="description">Description</form:label>
	        <form:textarea rows="5" cols="28" path="description" class="form-control"></form:textarea>
	        <form:errors path="description"/>
	    </div>
	    <input type="submit" value="Add Expense" class="btn btn-primary" />
	</form:form>
</body>
</html>