<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<h1>Notice List Page</h1>

		<table>
		<thead>
			<tr>
				<th>글번호</th><th>글제목</th><th>작성자</th>				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.list}" var="notice">
			<tr>
				<td><a href="./detail?num=${notice.num}">${notice.num}</a></td>
				<td>${notice.title}</td>
				<td>${notice.writer}</td>
			</tr>
			</c:forEach>
		</tbody>
		</table>
		
		<a href="./add">ADD</a>
</body>
</html>