<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>

<body>

<form action='<c:url value="create"/>'>
	<input type="submit" value="Add Student">
</form>

<table>
	<tr> <th>First Name</th> <th>Last Name</th> <th>Course</th><th></th> </tr>

<c:forEach items="${students}" var="stud">
	<tr><td>${stud.fName}</td>
		<td>${stud.lName}</td>
		<td>${stud.course}</td>
		<td>
			<a href='<c:url value="edit?id=${stud.id}&currentFName=${stud.fName}&currentLName=${stud.lName}&currentCourse=${stud.course}"/>'>Edit</a>
			<form method="post" action="delete" style="display:inline;">
				<input type="hidden" name="id" value="${stud.id}">
				<input type="submit" value="Delete">
			</form>
		</td>
	</tr>
</c:forEach>
</table>

</body>
</html>
