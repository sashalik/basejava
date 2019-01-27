<%@ page import="ru.javawebinar.basejava.model.ListTextSection" %>
<%@ page import="ru.javawebinar.basejava.model.TextSection" %>
<%@ page import="ru.javawebinar.basejava.model.OrganizationSection" %>
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
    <h2>${resume.fullName}&nbsp;<a href="resume?uuid=${resume.uuid}&action=edit"><img src="img/pencil.png"></a></h2>
    <p>
        <c:forEach var="contactEntry" items="${resume.contacts}">
            <jsp:useBean id="contactEntry"
                         type="java.util.Map.Entry<ru.javawebinar.basejava.model.ContactType, java.lang.String>"/>
                <%=contactEntry.getKey().toHtml(contactEntry.getValue())%><br/>
        </c:forEach>
    <p>
    <p>
    <table>
        <c:forEach var="sectionEntry" items="${resume.sections}">
            <jsp:useBean id="sectionEntry"
                         type="java.util.Map.Entry<ru.javawebinar.basejava.model.SectionType, ru.javawebinar.basejava.model.AbstractSection>"/>
            <tr>
                <td>
                    <h2><%=sectionEntry.getKey().getTitle() + ":"%>
                    </h2>
                </td>
            </tr>
            <c:choose>
                <c:when test="${sectionEntry.getKey() == 'OBJECTIVE' || sectionEntry.getKey() == 'PERSONAL'}">
                    <tr>
                        <td>
                            <%=((TextSection) sectionEntry.getValue()).getText()%>
                        </td>
                    </tr>
                </c:when>
                <c:when test="${sectionEntry.getKey() == 'ACHIEVEMENT' || sectionEntry.getKey() == 'QUALIFICATIONS'}">
                    <tr>
                        <td>
                            <%=((ListTextSection) sectionEntry.getValue()).getListInfo().toString()%>
                        </td>
                    </tr>
                </c:when>
                <c:when test="${sectionEntry.getKey() == 'EXPERIENCE' || sectionEntry.getKey() == 'EDUCATION'}">
                    <c:forEach var="organization"
                               items="<%=((OrganizationSection) sectionEntry.getValue()).getListOrganization()%>">
                        <tr>
                            <td>
                                    ${organization.getUrl()}
                            </td>
                        </tr>
                        <c:forEach var="position" items="${organization.listPosition}">
                            <jsp:useBean id="position" type="ru.javawebinar.basejava.model.Organization.Position"/>
                            <tr>
                                <td>
                                    <%=position.getDateBeg() + " - " + position.getDateEnd()%>
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