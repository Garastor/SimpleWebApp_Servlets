<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Taras
  Date: 25.11.2021
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Student</title>
</head>
<body>
<p>Complete the form for add the new student</p><br>

<form method="post" >
    <label>First Name</label><br>
        <input name="fName"><br><br>

    <label>Last Name</label><br>
        <input name="lName"><br><br>

    <label>Course</label><br>
        <select name="course">
            <option>Java</option>
            <option>JavaScript</option>
            <option>C#</option>
            <option>Kotlin</option>
            <option>C++</option>
            <option>Python</option>
        </select><br><br>

    <input type="submit" value="Save">
</form>

<form action='<c:url value="hello"/>'>
    <input type="submit" value="Cancel">
</form>

</body>
</html>
