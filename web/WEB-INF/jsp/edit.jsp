<%@ page import="ru.javawebinar.basejava.model.ContactType" %>
<%@ page import="ru.javawebinar.basejava.model.SectionType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <jsp:useBean id="resume" type="ru.javawebinar.basejava.model.Resume" scope="request"/>
    <title>Резюме ${resume.fullName}</title>
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
        <table cellspacing="10">
            <c:forEach var="type" items="<%=ContactType.values()%>">
                <tr>
                    <td>
                            ${type.title}
                    </td>
                    <td>
                        <textarea name='${type}' cols=40 rows=1>${resume.getContact(type)}</textarea>
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
                        <textarea name='${type}' cols=46 rows=1>${resume.getSection(type.name())}</textarea>
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