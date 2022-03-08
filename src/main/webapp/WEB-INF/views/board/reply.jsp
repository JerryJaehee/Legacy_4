<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${board} Reply Page</h1>
	<form action="./reply" method="POST">
		<input type="hidden" value="${dto.num}" name="num">
		Title<input type="text" name="title" placeholder="제목"> 
		Writer<input type="text" name="writer" placeholder="작성자">
		Contents<textarea name="contents" rows="10" cols=""></textarea>
		<button type="submit">Reply</button>
	</form>



</body>
</html>