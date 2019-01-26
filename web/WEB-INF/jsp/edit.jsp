<%@ page import="ru.javawebinar.basejava.model.ContactType" %>
<%@ page import="ru.javawebinar.basejava.model.SectionType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <jsp:useBean id="resume" type="ru.javawebinar.basejava.model.Resume" scope="request"/>
    <title>Резюме ${resume.fullName}</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<section>
    <form method="post" action="resume" enctype="application/x-www-form-urlencoded">
        <input type="hidden" name="uuid" value="${resume.uuid}">
        <h3>Имя:</h3>
        <table>
            <tr>
                <td>
                    <input type="text" name="fullName" size=10 value="${resume.fullName}">
                </td>
            </tr>
        </table>

        <h3>Контакты:</h3>
        <table cellspacing="10">
            <c:forEach var="type" items="<%=ContactType.values()%>">
                <tr>
                    <td>
                            ${type.title}
                    </td>
                    <td>
                        <input type="text" name="${type.name()}" size=30 value="${resume.getContact(type)}">
                    </td>
                </tr>
            </c:forEach>
        </table>

        <h3>Секции:</h3>
        <table cellspacing="10">
            <c:forEach var="type" items="<%=SectionType.values()%>">
                <tr>
                    <td>
                            ${type.title}
                    </td>
                    <td>
                        <input type="text" name="${type.name()}" size=120 value="${resume.getSection(type.name())}">
                    </td>
                </tr>
            </c:forEach>
        </table>
        <hr>
        <button type="submit">Сохранить</button>
        <button onclick="window.history.back()">Отменить</button>
    </form>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>