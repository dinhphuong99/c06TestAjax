<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
    <form:form modelAttribute="objEmail" action="/email/send-info" method="post">
        <div>
            <div style="">
                <label for="languages">Languages</label>
                <select id="languages" name="languages">
                    <c:forEach items="${listLanguages}" var="item">
                        <option value="${item}">${item}</option>
                    </c:forEach>
<%--                    <option value="English">English</option>--%>
<%--                    <option value="Vietnamese" selected>Vietnamese</option>--%>
<%--                    <option value="Japanese">Japanese</option>--%>
<%--                    <option value="Chinese">Chinese</option>--%>
                </select>
            </div>
        </div>
        <div>
            <input type="submit" value="Save">
        </div>
    </form:form>
</body>
</html>
