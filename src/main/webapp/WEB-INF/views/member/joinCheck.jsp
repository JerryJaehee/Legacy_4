<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
<link href="../resources/css/joinCheck.css" rel="styleSheet">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<h1>Join Check Page</h1>

	<div class="rule-container">
		<div class="rule">
			전체동의<input type="checkbox" id="checkAll">
		</div>

		<div id="rules">
			<div class="rule">
				<fieldset>
					<legend>동의1</legend>
					<input type="checkbox" class="check" value="1">
				</fieldset>
				<div></div>
			</div>

			<div class="rule">
				<fieldset>
					<legend>동의2</legend>
					<input type="checkbox" class="check" value="2">
				</fieldset>
				<div></div>
			</div>

			<div class="rule">
				<fieldset>
					<legend>동의3</legend>
					<input type="checkbox" class="check" value="3">
				</fieldset>
				<div></div>
			</div>

			<div class="rule">
				<fieldset>
					<legend>동의4</legend>
					<input type="checkbox" class="check" value="4">
				</fieldset>
				<div></div>
			</div>
		</div>
		<div class="rule">
			<button id="btn">JOIN</button>
		</div>

	</div>

	<script src="../resources/js/joinCheck.js"></script>
</body>
</html>