<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Crossover - Project</title>
</head>
<body>

	<br>
	<div style="text-align: center">
		<h1>Question ${question.number} - ${question.title}</h1>

		<p>${question.description }</p>

		<form method="post" action="login">
			<c:forEach var="answer" items="${question.answers}">

				<form:radiobutton path="answer" value="${answer.id}" />${answer.description}
			
		</c:forEach>
		</form>
	</div>
</body>
</html>