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

        Organization organization1 = new Organization("Java Online Projects", "");
        organization1.addPosition(new Organization.Position("10/2013", "Сейчас", "Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок."));
        organizationSection.addOrganization(organization1);

        Organization organizations2 = new Organization("Wrike", "");
        organizations2.addPosition(new Organization.Position("10/2014", "01/2016", "Старший разработчик (backend)", "Проектирование и разработка онлайн платформы управления проектами Wrike " +
                "(Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO."));
        organizationSection.addOrganization(organizations2);


        Organization organizations3 = new Organization("RIT Center", "");
        organizations3.addPosition(new Organization.Position("04/2012", "10/2014", "Java архитектор", "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы" +
                " (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: " +
                "CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера " +
                "документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, " +
                "Unix shell remote scripting via ssh tunnels, PL/Python"));
        organizationSection.addOrganization(organizations3);

        Organization organizations4 = new Organization("Luxoft (Deutsche Bank)", "");
        organizations4.addPosition(new Organization.Position("12/2010", "04/2012", "Ведущий программист", "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. " +
                "Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, " +
                "Commet, HTML5."));
        organizationSection.addOrganization(organizations4);

        Organization organizations5 = new Organization("Yota", "");
        organizations5.addPosition(new Organization.Position("06/2008", "12/2010", "Ведущий специалист", "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). " +
                "Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)"));
        organizationSection.addOrganization(organizations5);

        Organization organizations6 = new Organization("Enkata", "");
        organizations6.addPosition(new Organization.Position("03/2007", "06/2008", "Разработчик ПО", "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining)."));
        organizationSection.addOrganization(organizations6);

        Organization organizations7 = new Organization("Siemens AG", "");
        organizations7.addPosition(new Organization.Position("01/2005", "02/2007", "Разработчик ПО", "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix)."));
        organizationSection.addOrganization(organizations7);

        Organization organizations8 = new Organization("Alcatel", "");
        organizations8.addPosition(new Organization.Position("09/1997", "01/2005", "Инженер по аппаратному и программному тестированию", "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM)."));
        organizationSection.addOrganization(organizations8);

        return organizationSection;
    }

    private static AbstractSection getEducationSection() {
        OrganizationSection organizationSection = new OrganizationSection();

        Organization organization1 = new Organization("Coursera", "");
        organization1.addPosition(new Organization.Position("03/2013", "05/2013", "\"Functional Programming Principles in Scala\" by Martin Odersky", ""));
        organizationSection.addOrganization(organization1);

        Organization organization2 = new Organization("Luxoft", "");
        organization2.addPosition(new Organization.Position("03/2011", "04/2011", "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"", ""));
        organizationSection.addOrganization(organization2);


        Organization organization3 = new Organization("Siemens AG", "");
        organization3.addPosition(new Organization.Position("01/2005", "04/2005", "3 месяца обучения мобильным IN сетям (Берлин)", ""));
        organizationSection.addOrganization(organization3);


        Organization organization4 = new Organization("Alcatel", "");
        organization4.addPosition(new Organization.Position("09/1997", "03/1998", "6 месяцев обучения цифровым телефонным сетям (Москва)", ""));
        organizationSection.addOrganization(organization4);

        Organization organization5 = new Organization("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "");
        organization5.addPosition(new Organization.Position("09/1993", "07/1996", "Аспирантура (программист С, С++)", ""));
        organization5.addPosition(new Organization.Position("09/1987", "07/1993", "Инженер (программист Fortran, C)", ""));
        organizationSection.addOrganization(organization5);

        Organization organization6 = new Organization("Заочная физико-техническая школа при МФТИ", "");
        organization6.addPosition(new Organization.Position("09/1984", "06/1987", "Закончил с отличием", ""));
        organizationSection.addOrganization(organization6);

        return organizationSection;
    }

}
