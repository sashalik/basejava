<%@ page import="ru.javawebinar.basejava.model.ContactType" %>
<%@ page import="ru.javawebinar.basejava.model.OrganizationSection" %>
<%@ page import="ru.javawebinar.basejava.model.SectionType" %>
<%@ page import="ru.javawebinar.basejava.util.DateUtil" %>
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
                        <input name='${type.name()}' size=37 value=${resume.getContact(type)}>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <h3>Секции:</h3>
        <table cellspacing="10">
            <c:forEach var="type" items="<%=SectionType.values()%>">
                <c:set var="section" value="${resume.getSection(type)}"/>
                <jsp:useBean id="section" type="ru.javawebinar.basejava.model.AbstractSection"/>
                <h2><a>${type.title}</a></h2>
                <c:choose>
                    <c:when test="${type=='OBJECTIVE' || type=='PERSONAL'}">
                        <textarea name='${type}' cols=65 rows=5><%=section%></textarea>
                    </c:when>
                    <c:when test="${type=='QUALIFICATIONS' || type=='ACHIEVEMENT'}">
                        <textarea name='${type}' cols=65 rows=5><%=section%></textarea>
                    </c:when>
                    <c:when test="${type=='EXPERIENCE' || type=='EDUCATION'}">
                        <c:forEach var="organization" items="<%=((OrganizationSection) section).getListOrganization()%>"
                                   varStatus="counter">
                            <table cellspacing="6">
                                <tr>
                                    <td>Организация</td>
                                    <td><input type="text" name='${type}' size=47 value="${organization.link.name}">
                                    </td>
                                </tr>
                                <tr>
                                    <td>Сайт</td>
                                    <td><input type="text" name='${type}url' size=47 value="${organization.link.url}">
                                    </td>
                                </tr>
                            </table>
                            <br>
                            <div>
                                <c:forEach var="pos" items="${organization.listPosition}">
                                    <jsp:useBean id="pos" type="ru.javawebinar.basejava.model.Organization.Position"/>
                                    <table cellpadding="7" cellspacing="0">
                                        <tr>
                                            <td colspan="1" align="left" width=50%>Начальная дата:</td>
                                            <td>
                                                <input type="text" name="${type}${counter.index}startDate" size=10
                                                       value="<%=DateUtil.format(pos.getDateBeg())%>"
                                                       placeholder="MM/yyyy">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Конечная дата:</td>
                                            <td>
                                                <input type="text" name="${type}${counter.index}endDate" size=10
                                                       value="<%=DateUtil.format(pos.getDateEnd())%>"
                                                       placeholder="MM/yyyy">
                                        </tr>
                                        <tr>
                                            <td>Должность:</td>
                                            <td><input type="text" name='${type}${counter.index}title' size=75
                                                       value="${pos.blockHeader}">
                                        </tr>
                                        <tr>
                                            <td>Описание:</td>
                                            <td><textarea name="${type}${counter.index}description" rows=5
                                                          cols=75>${pos.blockDesc}</textarea></td>
                                        </tr>
                                    </table>
                                </c:forEach>
                            </div>
                        </c:forEach>
                    </c:when>
                </c:choose>
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