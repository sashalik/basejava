package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static ru.javawebinar.basejava.model.ContactType.*;
import static ru.javawebinar.basejava.model.SectionType.*;

public class ResumeTestData {
    private static Resume resume;
    private Map<String, Resume> storage = new HashMap<>();

    public static final String UUID_1 = "uuid1";
    public static final String UUID_2 = "uuid2";
    public static final String UUID_3 = "uuid3";
    public static final String UUID_4 = "uuid4";

    public static final String FULLNAME_1 = "gena";
    public static final String FULLNAME_2 = "vera";
    public static final String FULLNAME_3 = "dima";
    public static final String FULLNAME_4 = "serega";

    public static final Resume resume_1;
    public static final Resume resume_2;
    public static final Resume resume_3;
    public static final Resume resume_4;

    static {
        resume_1 = new Resume(UUID_1, FULLNAME_1);
        resume_1.addContact(PHONENUMBER, "444-44-44");
        resume_1.addContact(SKYPE, "gena.gena");
        resume_1.addContact(EMAIL, "gena@yandex.ru");
        resume_1.addContact(LINKEDIN, "Профиль LinkedIn");
        resume_1.addContact(GITHUB, "Профиль GitHub");
        resume_1.addContact(STACKOVERFLOW, "Профиль Stackoverflow");
        resume_1.addContact(HOMEPAGE, "Домашняя страница");

        resume_1.addSection(OBJECTIVE, new TextSection("Разработчик ПО"));
        resume_1.addSection(PERSONAL, new TextSection("Веселый, умный"));
        resume_1.addSection(ACHIEVEMENT, new ListTextSection("Научился программировать на Java"));
        resume_1.addSection(QUALIFICATIONS, new ListTextSection("Java", "JDBC", "Oracle", "MySQL"));
//
//        resume_1.addSection(EXPERIENCE,
//                new OrganizationSection(
//                        new Organization("Work 1", "",
//                                new Organization.Position(LocalDate.of(2018, 1, 1), LocalDate.now(), "Programmer", "Software developer"))));
//        resume_1.addSection(EDUCATION,
//                new OrganizationSection(
//                        new Organization("Kemerovo State University", "kemsu.ru",
//                                new Organization.Position(LocalDate.of(2005, 9, 1), LocalDate.of(2011, 7, 1), "Student", "Study"),
//                                new Organization.Position(LocalDate.of(2011, 4, 1), LocalDate.of(2011, 7, 1), "Engineer", "Support")
//                        )
//                )
//        );

        resume_2 = new Resume(UUID_2, FULLNAME_2);
        resume_2.addContact(PHONENUMBER, "444-44-44");
        resume_2.addContact(SKYPE, "vera.vera");
        resume_2.addContact(EMAIL, "vera@yandex.ru");
        resume_2.addContact(LINKEDIN, "Профиль LinkedIn");
        resume_2.addContact(GITHUB, "Профиль GitHub");
        resume_2.addContact(STACKOVERFLOW, "Профиль Stackoverflow");
        resume_2.addContact(HOMEPAGE, "Домашняя страница");

        resume_2.addSection(OBJECTIVE, new TextSection("Системный аналитик"));
        resume_2.addSection(PERSONAL, new TextSection("Красивая"));
        resume_2.addSection(ACHIEVEMENT, new ListTextSection("Уменю много говорить "));
        resume_2.addSection(QUALIFICATIONS, new ListTextSection("Java", "JDBC", "Oracle", "MySQL"));
//        resume_2.addSection(EXPERIENCE, new OrganizationSection(
//                new Organization("Work 2", "",
//                        new Organization.Position(LocalDate.of(2017, 1, 1), LocalDate.now(), "System analyst", "Software developer"))));
//        resume_2.addSection(EDUCATION,
//                new OrganizationSection(
//                        new Organization("Kemerovo State University", "kemsu.ru",
//                                new Organization.Position(LocalDate.of(2005, 9, 1), LocalDate.of(2011, 7, 1), "Student", "Study"),
//                                new Organization.Position(LocalDate.of(2011, 4, 1), LocalDate.of(2011, 7, 1), "Engineer", "Support")
//                        )
//                )
//        );

        resume_3 = new Resume(UUID_3, FULLNAME_3);
        resume_3.addContact(PHONENUMBER, "444-44-44");
        resume_3.addContact(SKYPE, "dima.dima");
        resume_3.addContact(EMAIL, "dima@yandex.ru");
        resume_3.addContact(LINKEDIN, "Профиль LinkedIn");
        resume_3.addContact(GITHUB, "Профиль GitHub");
        resume_3.addContact(STACKOVERFLOW, "Профиль Stackoverflow");
        resume_3.addContact(HOMEPAGE, "Домашняя страница");

        resume_3.addSection(OBJECTIVE, new TextSection("Системный аналитик"));
        resume_3.addSection(PERSONAL, new TextSection("Умный"));
        resume_3.addSection(ACHIEVEMENT, new ListTextSection("Мало говорю "));
        resume_3.addSection(QUALIFICATIONS, new ListTextSection("Java", "JDBC", "Oracle", "MySQL"));
//        resume_3.addSection(EXPERIENCE, new OrganizationSection(
//                new Organization("Work 3", "",
//                        new Organization.Position(LocalDate.of(2017, 1, 1), LocalDate.now(), "System analyst", "Software developer"))));
//        resume_3.addSection(EDUCATION,
//                new OrganizationSection(
//                        new Organization("Kemerovo State University", "kemsu.ru",
//                                new Organization.Position(LocalDate.of(2005, 9, 1), LocalDate.of(2011, 7, 1), "Student", "Study"),
//                                new Organization.Position(LocalDate.of(2011, 4, 1), LocalDate.of(2011, 7, 1), "Engineer", "Support")
//                        )
//                )
//        );

        resume_4 = new Resume(UUID_4, FULLNAME_4);
        resume_4.addContact(PHONENUMBER, "444-44-44");
        resume_4.addContact(SKYPE, "serega.serega");
        resume_4.addContact(EMAIL, "serega@yandex.ru");
        resume_4.addContact(LINKEDIN, "Профиль LinkedIn");
        resume_4.addContact(GITHUB, "Профиль GitHub");
        resume_4.addContact(STACKOVERFLOW, "Профиль Stackoverflow");
        resume_4.addContact(HOMEPAGE, "Домашняя страница");

        resume_4.addSection(OBJECTIVE, new TextSection("Владелец продуктв"));
        resume_4.addSection(PERSONAL, new TextSection("Заставляю проект работать и развиваться"));
        resume_4.addSection(ACHIEVEMENT, new ListTextSection("Моя команда всегда в работе и в тонусе"));
        resume_4.addSection(QUALIFICATIONS, new ListTextSection("Java", "JDBC", "Oracle", "MySQL"));
//        resume_4.addSection(EXPERIENCE, new OrganizationSection(
//                new Organization("Work 2", "",
//                        new Organization.Position(LocalDate.of(2017, 1, 1), LocalDate.now(), "Product owner", "Software developer"))));
//        resume_4.addSection(EDUCATION,
//                new OrganizationSection(
//                        new Organization("Kemerovo State University", "kemsu.ru",
//                                new Organization.Position(LocalDate.of(2005, 9, 1), LocalDate.of(2011, 7, 1), "Student", "Study"),
//                                new Organization.Position(LocalDate.of(2011, 4, 1), LocalDate.of(2011, 7, 1), "Engineer", "Support")
//                        )
//                )
//        );
    }

    public ResumeTestData() {
        storage.put(UUID_1, resume_1);
        storage.put(UUID_2, resume_2);
        storage.put(UUID_3, resume_3);
        storage.put(UUID_4, resume_4);
    }

    public Resume getResume(String uuid) {
        return storage.get(uuid);
    }

   /* public static void main(String[] args) {
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
    }*/

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
        return new ListTextSection("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. " +
                "XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. " +
                "Более 1000 выпускников.",
                "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, " +
                        "Jira, Zendesk.",
                "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения " +
                        "управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.",
                "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, " +
                        "Highstock для алгоритмического трейдинга.",
                "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики " +
                        "сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).",
                "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");
    }

    private static AbstractSection getQualificationsSection() {
        return new ListTextSection(
                "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2",
                "Version control: Subversion, Git, Mercury, ClearCase, Perforce",
                "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle",
                "MySQL, SQLite, MS SQL, HSQLDB",
                "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy",
                "XML/XSD/XSLT, SQL, C/C++, Unix shell scripts,",
                "Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, " +
                        "GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).",
                "Python: Django.",
                "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js",
                "Scala: SBT, Play2, Specs2, Anorm, Spray, Akka",
                "Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, " +
                        "ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.",
                "Инструменты: Maven + plugin development, Gradle, настройка Ngnix",
                "Администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer.",
                "Отличное знание и опыт применения концепций ООП, SOA, шаблонов",
                "проектрирования, архитектурных шаблонов, UML, функционального программирования",
                "Родной русский, английский \"upper intermediate\"");
    }

    private static AbstractSection getExperienceSection() {
        Organization organization1 = new Organization("Java Online Projects", "");
        organization1.addPosition(new Organization.Position(LocalDate.of(2013, 10, 1), LocalDate.now(), "Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок."));

        Organization organization2 = new Organization("Wrike", "");
        organization2.addPosition(new Organization.Position(LocalDate.of(2014, 10, 1), LocalDate.of(2016, 1, 1), "Старший разработчик (backend)", "Проектирование и разработка онлайн платформы управления проектами Wrike " +
                "(Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO."));

        Organization organization3 = new Organization("RIT Center", "");
        organization3.addPosition(new Organization.Position(LocalDate.of(2012, 4, 1), LocalDate.of(2014, 10, 1), "Java архитектор", "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы" +
                " (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: " +
                "CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера " +
                "документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, " +
                "Unix shell remote scripting via ssh tunnels, PL/Python"));

        Organization organization4 = new Organization("Luxoft (Deutsche Bank)", "");
        organization4.addPosition(new Organization.Position(LocalDate.of(2010, 12, 1), LocalDate.of(2012, 4, 1), "Ведущий программист", "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. " +
                "Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, " +
                "Commet, HTML5."));

        Organization organization5 = new Organization("Yota", "");
        organization5.addPosition(new Organization.Position(LocalDate.of(2008, 6, 1), LocalDate.of(2010, 12, 1), "Ведущий специалист", "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). " +
                "Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)"));

        Organization organization6 = new Organization("Enkata", "");
        organization6.addPosition(new Organization.Position(LocalDate.of(2007, 3, 1), LocalDate.of(2008, 6, 1), "Разработчик ПО", "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining)."));

        Organization organization7 = new Organization("Siemens AG", "");
        organization7.addPosition(new Organization.Position(LocalDate.of(2005, 1, 1), LocalDate.of(2007, 2, 1), "Разработчик ПО", "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix)."));

        Organization organization8 = new Organization("Alcatel", "");
        organization8.addPosition(new Organization.Position(LocalDate.of(1997, 9, 1), LocalDate.of(2005, 1, 1), "Инженер по аппаратному и программному тестированию", "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM)."));

        OrganizationSection organizationSection = new OrganizationSection(organization1, organization2, organization3, organization4, organization5, organization6, organization7, organization8);

        return organizationSection;
    }

    private static AbstractSection getEducationSection() {
        Organization organization1 = new Organization("Coursera", "");
        organization1.addPosition(new Organization.Position(LocalDate.of(2013, 3, 1), LocalDate.of(2013, 5, 1), "\"Functional Programming Principles in Scala\" by Martin Odersky", ""));

        Organization organization2 = new Organization("Luxoft", "");
        organization2.addPosition(new Organization.Position(LocalDate.of(2011, 3, 1), LocalDate.of(2011, 4, 1), "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"", ""));

        Organization organization3 = new Organization("Siemens AG", "");
        organization3.addPosition(new Organization.Position(LocalDate.of(2005, 1, 1), LocalDate.of(2005, 4, 1), "3 месяца обучения мобильным IN сетям (Берлин)", ""));

        Organization organization4 = new Organization("Alcatel", "");
        organization4.addPosition(new Organization.Position(LocalDate.of(1997, 9, 1), LocalDate.of(1998, 3, 1), "6 месяцев обучения цифровым телефонным сетям (Москва)", ""));

        Organization organization5 = new Organization("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "");
        organization5.addPosition(new Organization.Position(LocalDate.of(1993, 9, 1), LocalDate.of(1996, 7, 1), "Аспирантура (программист С, С++)", ""));
        organization5.addPosition(new Organization.Position(LocalDate.of(1987, 9, 1), LocalDate.of(1993, 7, 1), "Инженер (программист Fortran, C)", ""));

        Organization organization6 = new Organization("Заочная физико-техническая школа при МФТИ", "");
        organization6.addPosition(new Organization.Position(LocalDate.of(1984, 9, 1), LocalDate.of(1987, 6, 1), "Закончил с отличием", ""));

        OrganizationSection organizationSection = new OrganizationSection(organization1, organization2, organization3, organization4, organization5, organization6);

        return organizationSection;
    }
}
