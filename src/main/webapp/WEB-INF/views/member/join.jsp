<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member Join Page</h1>
	<div>
		<form action="./join" method="post" id="frm">
			<fieldset>
				<legend>ID</legend>
				<input type="text" name="id" id="idx">
				<div id="idResult"></div>
			</fieldset>
			<fieldset>
				<legend>Password</legend>
				<input type="password" id="pw" name="pw" placeholder="8글자 이상 12글자 이하">
				<div id="pwResult"></div>
			</fieldset>
			<fieldset>
				<legend>Password 확인</legend>
				<input type="password" id="pw2" name="pw2" placeholder="8글자 이상 12글자 이하">
				<div id="pwResult2"></div>
			</fieldset>
			<fieldset>
				<legend>이름</legend>
				<input type="text" name="name" id="name">
			</fieldset>
			<fieldset>
				<legend>핸드폰 번호</legend>
				<input type="text" name="phone" id="phone">
			</fieldset>
			<fieldset>
				<legend>이메일 주소</legend>
				<input type="email" name="email" id="email">
			</fieldset>
			<fieldset>
				<button type="button" id="btn">JOIN</button>
			</fieldset>
		
		</form>
	</div>
	
	<script type="text/javascript" src="../resources/js/join2.js"></script>
	
</body>
</html>