<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Notice Detail Page</h1>
	
	<h3>글 번호 : ${dto.num}</h3>
	<h3>글 제목 : ${dto.title}</h3>
	<h3>글 내용 : ${dto.contents}</h3>
	<h3>작성자 : ${dto.writer}</h3>
	<h3>작성일 : ${dto.regDate}</h3>
	<h3>조회수 : ${dto.hit}</h3>
	
	<a href="./list">List</a>
</body>
</html>