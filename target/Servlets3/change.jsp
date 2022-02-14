<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Student</title>
</head>
<body>
<p>Edit student data</p>
<form method="post">
    <label>First Name</label><br><input name="fName" value=<%= request.getParameter("currentFName")%>><br><br>
    <label>Last Name</label><br><input name="lName" value=<%= request.getParameter("currentLName")%>><br><br>
    <label>Course</label><br><select name="course">
        <option>Java</option>
        <option>JavaScript</option>
        <option>C#</option>
        <option>Kotlin</option>
        <option>C++</option>
        <option>Python</option>
    </select><br><br>
    <input type="submit" value="Update">
</form> <form action='<c:url value="hello"/>'>
    <input type="submit" value="Cancel">
</form>
</body>
</html>
