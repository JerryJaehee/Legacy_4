<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook Detail Page</h1>
	
	<h3>일련번호 : ${dto.bookNumber}</h3>
	<h3>통장 이름 : ${dto.bookName}</h3>
	<h3>Contents : ${dto.bookContents}</h3>
	<h3>이자율 : ${dto.bookRate}</h3>
	<h3>판매여부 : ${dto.bookSale}</h3>
	
	<a href="./list">List</a>
	<a href="./update">Update</a>
	<a href="./delete?bookNumber=${dto.bookNumber}">Delete</a>
</body>
</html>