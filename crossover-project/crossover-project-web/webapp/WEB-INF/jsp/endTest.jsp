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

		<form:form method="post" action="testExam/reviewQuestion"
			commandName="testExam">

				Review your answers: 
				<form:select path="chosenQuestion.id">
					  <form:options items="${testExam.questionsMap}" />
				       </form:select>
			<input type="submit" value="Go" />

		</form:form>
		<form:form method="post" action="testExam" commandName="testExam">

			<p>Would you like to finish the Test?</p>

			<input type="hidden" value="$(id)">
			<input type="submit" value="End Test" />

		</form:form>
	</div>
</body>
</html>