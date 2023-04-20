<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<h1>Expense Details</h1>
	<h2>Expense Name: <c:out value="${expense.name}"/></h2>
	<h2>Description: <c:out value="${expense.description}"/></h2>
	<h2>Vendor: <c:out value="${expense.vendor}"/></h2>
	<h2>Amount: <c:out value="${expense.amount}"/></h2>
	<div class="btn btn-outline-warning">
		<a href="/expenses/all">Back to Main</a>
	</div>
</body>
</html>