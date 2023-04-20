<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
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

	<form:form action="/expenses/process/edit/${expense.id}" method="post" modelAttribute="expense">
		<input type="hidden" name="_method" value="put">
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
	    <input type="submit" value="Submit" class="btn btn-primary" />
	</form:form>

	<div class="btn btn-outline-warning">
		<a href="/expenses/all">Back to Main</a>
	</div>
	
</body>
</html>