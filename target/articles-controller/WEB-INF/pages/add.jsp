<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="stag" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
<h1>Add new article</h1>

<sform:form action="/save" modelAttribute="article">
<table>
    <tr>
        <td>Title:</td>
        <td><sform:input path="title" /></td>
    </tr>
    <tr>
        <td>Text:</td>
        <td><sform:textarea path="text" /></td>
    </tr>
    <tr>
        <td><input type="submit" value="SAVE" /></td>
    </tr>
</table>
</sform:form>

<a href="<stag:url value="/list" />">Go to list</a>
</body>
</html>
