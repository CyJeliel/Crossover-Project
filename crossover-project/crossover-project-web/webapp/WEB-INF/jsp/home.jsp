<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Crossover - Project</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/login.js"></script>
</head>
<body>

	<br>
	<div style="text-align: center">
		<h1>
			${testDescription}<br> <br>
		</h1>

		<form method="post" action="login">
		
			<p>${feedback}</p>
			<p>Login:</p>
			<p>
				<input type="text" name="login" />
			</p>
			<p>Password:</p>
			<p>
				<input type="password" name="password" />
			</p>
			<input type="button" onclick="check(this.form)" value="Login" />
			<p>
		</form>
	</div>
</body>
</html>