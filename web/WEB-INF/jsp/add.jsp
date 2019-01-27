<%@ page import="ru.javawebinar.basejava.model.ContactType" %>
<%@ page import="ru.javawebinar.basejava.model.SectionType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <jsp:useBean id="resume" type="ru.javawebinar.basejava.model.Resume" scope="request"/>
    <title>Добавление резюме</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<div class="blockEdit">
    <form method="post" action="resume" enctype="application/x-www-form-urlencoded">
        <input type="hidden" name="uuid" value="${resume.uuid}">
        <h3>Имя:</h3>
        <table>
            <tr>
                <td>
                    <input type="text" name="fullName" size=63 value="${resume.fullName}">
                </td>
            </tr>
        </table>

        <h3>Контакты:</h3>
        <table cellspacing="6">
            <c:forEach var="type" items="<%=ContactType.values()%>">
                <tr>
                    <td>
                            ${type.title}
                    </td>
                    <td>
                        <input type="text" name="${type.name()}" size=39 value="">
                    </td>
                </tr>
            </c:forEach>
        </table>

        <h3>Секции:</h3>
        <table cellspacing="6">
            <c:forEach var="type" items="<%=SectionType.values()%>">
                <tr>
                    <td>
                            ${type.title}
                    </td>
                    <td>
                        <input type="text" name="${type.name()}" size=45 value="">
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div class="buttons">
            <button type="submit">Сохранить</button>
            <button onclick="window.history.back()">Отменить</button>
        </div>
    </form>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>