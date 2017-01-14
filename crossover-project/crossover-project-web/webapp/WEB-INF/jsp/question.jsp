<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

		<form:form method="post" action="question" commandName="question">
				
				<input type="hidden" name="id" value="${question.id}">
				
				<form:radiobuttons  items="${question.answersMap}"  path="chosenAnswer.id"  />

				<br />
				<br />
				
			<input type="submit"  value="Next Question" />

		</form:form>
	</div>
</body>
</html>