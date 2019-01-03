<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Player</title>
</head>
<body>

<h1>FILL OUT TEAM INFORMATION</h1>
	
	<h3>Choose Team Players</h3>
	<form action="submitPlayers" method="post">

		<c:forEach items="${list}" var="player">
			<input type="checkbox" name=teamPlayers value=${player.id}>${player.name}<br>
		</c:forEach>
		<input type="submit" value="Select Players">
	</form>
	
	<form action="addTeam" method="post">
		<fieldset>
			<table>
				<tr>
					<td>Choose Team Id:</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>Choose Team Name:</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>Select State:</td>
					<td><input type="text" name="age"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Confirm & Checkout"></td>
				</tr>
			</table>
		</fieldset>
	</form>

	
</body>
</html>