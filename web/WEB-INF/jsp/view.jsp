<%@ page import="ru.javawebinar.basejava.model.ListTextSection" %>
<%@ page import="ru.javawebinar.basejava.model.OrganizationSection" %>
<%@ page import="ru.javawebinar.basejava.model.TextSection" %>
<%@ page import="ru.javawebinar.basejava.util.HtmlUtil" %>
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
<div class="blockView">
    <!-- Контакты -->
    <h2>${resume.fullName}&nbsp;<a href="resume?uuid=${resume.uuid}&action=edit"><img src="img/pencil.png"></a></h2>
    <p>
        <c:forEach var="contactEntry" items="${resume.contacts}">
            <jsp:useBean id="contactEntry"
                         type="java.util.Map.Entry<ru.javawebinar.basejava.model.ContactType, java.lang.String>"/>
                <%=contactEntry.getKey().toHtml(contactEntry.getValue())%><br/>
        </c:forEach>
    <p>
    <p>
    <!-- Секции -->
    <table>
        <c:forEach var="sectionEntry" items="${resume.sections}">
            <jsp:useBean id="sectionEntry"
                         type="java.util.Map.Entry<ru.javawebinar.basejava.model.SectionType, ru.javawebinar.basejava.model.AbstractSection>"/>
            <c:choose>
                <c:when test="${!sectionEntry.getValue().toString().equals('') }">
                    <tr>
                        <td>
                            <h2><%=sectionEntry.getKey().getTitle() + ":"%>
                            </h2>
                        </td>
                    </tr>
                </c:when>
            </c:choose>
            <c:choose>
                <c:when test="${sectionEntry.getKey() == 'OBJECTIVE' || sectionEntry.getKey() == 'PERSONAL'}">
                    <tr>
                        <td>
                            <%=((TextSection) sectionEntry.getValue()).getText().replace('"',' ')%>
                        </td>
                    </tr>
                </c:when>
                <c:when test="${sectionEntry.getKey() == 'ACHIEVEMENT' || sectionEntry.getKey() == 'QUALIFICATIONS'}">
                    <tr>
                        <td>
                            <c:forEach var="item"
                                       items="<%=((ListTextSection) sectionEntry.getValue()).getListInfo()%>">
                                <li>${item}</li>
                            </c:forEach>
                        </td>
                    </tr>
                </c:when>
                <c:when test="${sectionEntry.getKey() == 'EXPERIENCE' || sectionEntry.getKey() == 'EDUCATION'}">
                    <c:forEach var="organization"
                               items="<%=((OrganizationSection) sectionEntry.getValue()).getListOrganization()%>">
                        <tr>
                            <td>
                                    ${organization.link.name}
                            </td>
                            <td>
                                    ${organization.getUrl()}
                            </td>
                        </tr>
                        <c:forEach var="position" items="${organization.listPosition}">
                            <jsp:useBean id="position" type="ru.javawebinar.basejava.model.Organization.Position"/>
                            <tr>
                                <td>
                                    <%=HtmlUtil.formatDates(position)%>
                                </td>
                                <td><b>${position.blockHeader}</b><br>${position.blockDesc}</td>
                            </tr>
                        </c:forEach>
                    </c:forEach>
                </c:when>
            </c:choose>
        </c:forEach>
    </table>
    <p>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>