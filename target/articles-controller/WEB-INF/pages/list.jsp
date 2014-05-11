<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="stag" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Articles</title>
    <style type="text/css">
        .column {
            padding-left: 30px;
        }
    </style>
</head>
<body>
<h1>Articles</h1>


<c:choose>
    <c:when test="${not empty articles}">
        <table>
            <tr>
                <th>
                    Title
                </th>
                <th>
                    Text
                </th>
            </tr>
            <c:forEach items="${articles}" var="article">
                <tr>
                    <td class="column">${article.title}</td>
                    <td class="column">${article.text}</td>
                    <td class="column">
                        <sform:form action="/delete">
                            <input type="hidden" name="id" value="${article.id}" />
                            <input type="submit" value="Delete"/>
                        </sform:form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        There are no articles yet.
    </c:otherwise>
</c:choose>

</br>
<a href="<stag:url value="/add" />">Create article</a>

</body>
</html>
