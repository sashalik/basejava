package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.*;

import static ru.javawebinar.basejava.model.SectionType.*;

public class ResumeTestData {
    private static Resume resume;

    public static void main(String[] args) {
        resume = new Resume("zzz", "Григорий Кислин");

        resume.addContact(ContactType.PHONENUMBER, "+7(921) 855-0482");
        resume.addContact(ContactType.SKYPE, "grigory.kislin");
        resume.addContact(ContactType.EMAIL, "gkislin@yandex.ru");
        resume.addContact(ContactType.LINKEDIN, "Профиль LinkedIn");
        resume.addContact(ContactType.GITHUB, "Профиль GitHub");
        resume.addContact(ContactType.STACKOVERFLOW, "Профиль Stackoverflow");
        resume.addContact(ContactType.HOMEPAGE, "Домашняя страница");

        resume.addSection(OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
        resume.addSection(PERSONAL, new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));
        resume.addSection(ACHIEVEMENT, getAchievementSection());
        resume.addSection(QUALIFICATIONS, getQualificationsSection());
        resume.addSection(EXPERIENCE, getExperienceSection());
        resume.addSection(EDUCATION, getEducationSection());

        System.out.println(resume.getFullName());
        printContact();
        System.out.println("\n");
        printSection();
    }

    private static void printContact() {
        for (ContactType type : ContactType.values()) {
            System.out.println(resume.getContact(type));
        }
    }

    private static void printSection() {
        for (SectionType type : SectionType.values()) {
            System.out.println(type.getTitle() + "\n" + resume.getSection(type).toString());
        }
    }

    private static AbstractSection getAchievementSection() {
        ListTextSection listTextSection = new ListTextSection();
        listTextSection.addInfo("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. " +
                "XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. " +
                "Более 1000 выпускников.");
        listTextSection.addInfo("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, " +
                "Jira, Zendesk.");
        listTextSection.addInfo("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения " +
                "управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.");
        listTextSection.addInfo("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, " +
                "Highstock для алгоритмического трейдинга.");
        listTextSection.addInfo("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики " +
                "сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).");
        listTextSection.addInfo("Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");
        return listTextSection;
    }

    private static AbstractSection getQualificationsSection() {
        ListTextSection listTextSection = new ListTextSection();
        listTextSection.addInfo("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        listTextSection.addInfo("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        listTextSection.addInfo("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle");
        listTextSection.addInfo("MySQL, SQLite, MS SQL, HSQLDB");
        listTextSection.addInfo("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy");
        listTextSection.addInfo("XML/XSD/XSLT, SQL, C/C++, Unix shell scripts,");
        listTextSection.addInfo("Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, " +
                "GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).");
        listTextSection.addInfo("Python: Django.");
        listTextSection.addInfo("JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js");
        listTextSection.addInfo("Scala: SBT, Play2, Specs2, Anorm, Spray, Akka");
        listTextSection.addInfo("Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, " +
                "ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.");
        listTextSection.addInfo("Инструменты: Maven + plugin development, Gradle, настройка Ngnix");
        listTextSection.addInfo("Администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer.");
        listTextSection.addInfo("Отличное знание и опыт применения концепций ООП, SOA, шаблонов");
        listTextSection.addInfo("проектрирования, архитектурных шаблонов, UML, функционального программирования");
        listTextSection.addInfo("Родной русский, английский \"upper intermediate\"");
        return listTextSection;
    }

    private static AbstractSection getExperienceSection() {
        OrganizationSection organizationSection = new OrganizationSection();

        ListOrganizations listOrganizations1 = new ListOrganizations("Java Online Projects", "");
        Organization organization1 = new Organization();
        organization1.setPeriod("10/2013", "Сейчас");
        organization1.setTitle("Автор проекта.");
        organization1.setDescription("Создание, организация и проведение Java онлайн проектов и стажировок.");
        listOrganizations1.addBlock(organization1);
        organizationSection.addInfo(listOrganizations1);

        ListOrganizations listOrganizations2 = new ListOrganizations("Wrike", "");
        Organization organization2 = new Organization();
        organization2.setPeriod("10/2014", "01/2016");
        organization2.setTitle("Старший разработчик (backend)");
        organization2.setDescription("Проектирование и разработка онлайн платформы управления проектами Wrike " +
                "(Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.");
        listOrganizations2.addBlock(organization2);
        organizationSection.addInfo(listOrganizations2);

        ListOrganizations listOrganizations3 = new ListOrganizations("RIT Center", "");
        Organization organization3 = new Organization();
        organization3.setPeriod("04/2012", "10/2014");
        organization3.setTitle("Java архитектор");
        organization3.setDescription("Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы" +
                " (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: " +
                "CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера " +
                "документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, " +
                "Unix shell remote scripting via ssh tunnels, PL/Python");
        listOrganizations3.addBlock(organization3);
        organizationSection.addInfo(listOrganizations3);

        ListOrganizations listOrganizations4 = new ListOrganizations("Luxoft (Deutsche Bank)", "");
        Organization organization4 = new Organization();
        organization4.setPeriod("12/2010", "04/2012");
        organization4.setTitle("Ведущий программист");
        organization4.setDescription("Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. " +
                "Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, " +
                "Commet, HTML5.");
        listOrganizations4.addBlock(organization4);
        organizationSection.addInfo(listOrganizations4);

        ListOrganizations listOrganizations5 = new ListOrganizations("Yota", "");
        Organization organization5 = new Organization();
        organization5.setPeriod("06/2008", "12/2010");
        organization5.setTitle("Ведущий специалист");
        organization5.setDescription("Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). " +
                "Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)");
        listOrganizations5.addBlock(organization5);
        organizationSection.addInfo(listOrganizations5);

        ListOrganizations listOrganizations6 = new ListOrganizations("Enkata", "");
        Organization organization6 = new Organization();
        organization6.setPeriod("03/2007", "06/2008");
        organization6.setTitle("Разработчик ПО");
        organization6.setDescription("Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).");
        listOrganizations6.addBlock(organization6);
        organizationSection.addInfo(listOrganizations6);

        ListOrganizations listOrganizations7 = new ListOrganizations("Siemens AG", "");
        Organization organization7 = new Organization();
        organization7.setPeriod("01/2005", "02/2007");
        organization7.setTitle("Разработчик ПО");
        organization7.setDescription("Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).");
        listOrganizations7.addBlock(organization7);
        organizationSection.addInfo(listOrganizations7);

        ListOrganizations listOrganizations8 = new ListOrganizations("Alcatel", "");
        Organization organization8 = new Organization();
        organization8.setPeriod("09/1997", "01/2005");
        organization8.setTitle("Инженер по аппаратному и программному тестированию");
        organization8.setDescription("Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).");
        listOrganizations8.addBlock(organization8);
        organizationSection.addInfo(listOrganizations8);
        return organizationSection;
    }

    private static AbstractSection getEducationSection() {
        OrganizationSection organizationSection = new OrganizationSection();

        ListOrganizations listOrganizations1 = new ListOrganizations("Coursera", "");
        Organization organization1 = new Organization();
        organization1.setPeriod("03/2013", "05/2013");
        organization1.setTitle("\"Functional Programming Principles in Scala\" by Martin Odersky");
        organization1.setDescription("");
        listOrganizations1.addBlock(organization1);
        organizationSection.addInfo(listOrganizations1);

        ListOrganizations listOrganizations2 = new ListOrganizations("Luxoft", "");
        Organization organization2 = new Organization();
        organization2.setPeriod("03/2011", "04/2011");
        organization2.setTitle("Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"");
        organization2.setDescription("");
        listOrganizations2.addBlock(organization2);
        organizationSection.addInfo(listOrganizations2);

        ListOrganizations listOrganizations3 = new ListOrganizations("Siemens AG", "");
        Organization organization3 = new Organization();
        organization3.setPeriod("01/2005", "04/2005");
        organization3.setTitle("3 месяца обучения мобильным IN сетям (Берлин)");
        organization3.setDescription("");
        listOrganizations3.addBlock(organization3);
        organizationSection.addInfo(listOrganizations3);

        ListOrganizations listOrganizations4 = new ListOrganizations("Alcatel", "");
        Organization organization4 = new Organization();
        organization4.setPeriod("09/1997", "03/1998");
        organization4.setTitle("6 месяцев обучения цифровым телефонным сетям (Москва)");
        organization4.setDescription("");
        listOrganizations4.addBlock(organization4);
        organizationSection.addInfo(listOrganizations4);

        ListOrganizations listOrganizations5 = new ListOrganizations("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "");
        Organization organization51 = new Organization();
        organization51.setPeriod("09/1993", "07/1996");
        organization51.setTitle("Аспирантура (программист С, С++)");
        organization51.setDescription("");
        listOrganizations5.addBlock(organization51);

        Organization organization52 = new Organization();
        organization52.setPeriod("09/1987", "07/1993");
        organization52.setTitle("Инженер (программист Fortran, C)");
        organization52.setDescription("");
        listOrganizations5.addBlock(organization52);
        organizationSection.addInfo(listOrganizations5);

        ListOrganizations listOrganizations6 = new ListOrganizations("Заочная физико-техническая школа при МФТИ", "");
        Organization organization6 = new Organization();
        organization6.setPeriod("09/1984", "06/1987");
        organization6.setTitle("Закончил с отличием");
        organization6.setDescription("");
        listOrganizations6.addBlock(organization6);
        organizationSection.addInfo(listOrganizations6);
        return organizationSection;
    }

}
