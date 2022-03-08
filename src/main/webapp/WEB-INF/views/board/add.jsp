<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${board} add Page</h1>
	<form action="./add" method="POST">
		<input type="text" name="title" placeholder="제목"> 
		<textarea name="contents" rows="10" cols=""></textarea>
		<input type="text" name="writer" placeholder="작성자">
		<input type="submit" value="add">
	</form>



</body>
</html>