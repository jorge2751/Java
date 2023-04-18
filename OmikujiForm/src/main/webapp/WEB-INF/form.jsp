<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji!</title>
</head>
<body>
	<h1>Send an Omikuji!</h1>
	<form action="/omikuji/show">
		<p>Pick any number from 5 to 25</p>
		<input type="number" name="num" />
		<p>Enter the name of any city</p>
		<input type="text" name="city" />
		<p>Enter the name of any real person</p>
		<input type="text" name="person" />
		<p>Enter professional endeavor or hobby</p>
		<input type="text" name="hobby" />
		<p>Enter a type of living thing</p>
		<input type="text" name="thing" />
		<p>Say something nice to someone</p>
		<textarea name="nice" cols="33" rows="5"></textarea>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>