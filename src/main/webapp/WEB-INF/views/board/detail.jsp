<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
<link href="../resources/css/table.css" rel="styleSheet" />
<link href="../resources/css/list.css" rel="styleSheet" />
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<h1>${board} Detail Page</h1>
	
	<h3>글 번호 : ${dto.num}</h3>
	<h3>글 제목 : ${dto.title}</h3>
	<h3>글 내용 : ${dto.contents}</h3>
	<h3>작성자 : ${dto.writer}</h3>
	<h3>작성일 : ${dto.regDate}</h3>
	<h3>조회수 : ${dto.hit}</h3>
	<div>
		<c:forEach items="${dto.fileDTOs}" var="f">
			<a href="./fileDown?fileNum=${f.fileNum}">${f.oriName}</a>		
		</c:forEach>
	</div>
	<a href="./list">List</a>
	<a href="./update?num=${dto.num}">Update</a>
	<a href="./delete?num=${dto.num}">Delete</a>
		<c:if test="${board ne 'notice'}">
		<a href="./reply?num=${dto.num}">Reply</a>
	</c:if>
</body>
</html>