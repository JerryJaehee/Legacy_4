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
	
	<h3>글 제목 : ${dto.title}</h3>
	<h3>글 내용 : ${dto.contents}</h3>
	<h3>작성자 : ${dto.writer}</h3>
	<h3>작성일 : ${dto.regDate}</h3>
	<div>
		<c:forEach items="${dto.fileDTOs}" var="f">
			<a href="./fileDown?fileNum=${f.fileNum}">${f.oriName}</a>		
		</c:forEach>
	</div>
	
	<hr>
	
	<div>
		<input type="hidden" name="num" value="${dto.num}" id="num">
		<input type="text" readonly name="writer" value="${member.id}" id="writer"> 
		<textarea rows="" cols="" name="contents" id="contents"></textarea>
		<button type="button" id="reply">REPLY</button>
	</div>
	
	<table id="replyResult">
	
	</table>
	
	<a href="./list">List</a>
	<!-- 작성자만 수정과 삭제가 가능하게끔  -->
	<c:if test="${member.id eq dto.writer}">
		<a href="./delete?num=${dto.num}">Delete</a>
		<a href="./update?num=${dto.num}">update</a>
	</c:if>
	<c:if test="${board ne 'notice'}">
		<a href="./reply?num=${dto.num}">Reply</a>
	</c:if>
	<script src="../resources/js/noticeReply.js"></script>
</body>
</html>