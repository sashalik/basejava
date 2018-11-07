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

        resume.addSection(OBJECTIVE, new SimpleSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
        resume.addSection(PERSONAL, new SimpleSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));
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
            System.out.println(type.getTitle()+"\n"+resume.getSection(type).toString());
        }
    }

    private static Section getAchievementSection() {
        StringSection stringSection = new StringSection("");
        stringSection.addInfo("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. " +
                "XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. " +
                "Более 1000 выпускников.");
        stringSection.addInfo("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, " +
                "Jira, Zendesk.");
        stringSection.addInfo("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения " +
                "управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.");
        stringSection.addInfo("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, " +
                "Highstock для алгоритмического трейдинга.");
        stringSection.addInfo("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики " +
                "сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).");
        stringSection.addInfo("Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");
        return stringSection;
    }

    private static Section getQualificationsSection() {
        StringSection stringSection = new StringSection("");
        stringSection.addInfo("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        stringSection.addInfo("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        stringSection.addInfo("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle");
        stringSection.addInfo("MySQL, SQLite, MS SQL, HSQLDB");
        stringSection.addInfo("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy");
        stringSection.addInfo("XML/XSD/XSLT, SQL, C/C++, Unix shell scripts,");
        stringSection.addInfo("Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, " +
                "GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).");
        stringSection.addInfo("Python: Django.");
        stringSection.addInfo("JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js");
        stringSection.addInfo("Scala: SBT, Play2, Specs2, Anorm, Spray, Akka");
        stringSection.addInfo("Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, " +
                "ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.");
        stringSection.addInfo("Инструменты: Maven + plugin development, Gradle, настройка Ngnix");
        stringSection.addInfo("Администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer.");
        stringSection.addInfo("Отличное знание и опыт применения концепций ООП, SOA, шаблонов");
        stringSection.addInfo("проектрирования, архитектурных шаблонов, UML, функционального программирования");
        stringSection.addInfo("Родной русский, английский \"upper intermediate\"");
        return stringSection;
    }

    private static Section getExperienceSection() {
        ObjectSection objectSection = new ObjectSection("");

        ListBlock listBlock1 = new ListBlock("Java Online Projects");
        Block block1 = new Block();
        block1.setPeriod("10/2013", "Сейчас");
        block1.setBlockHeader("Автор проекта.");
        block1.setBlockDesc("Создание, организация и проведение Java онлайн проектов и стажировок.");
        listBlock1.addBlock(block1);
        objectSection.addInfo(listBlock1);

        ListBlock listBlock2 = new ListBlock("Wrike");
        Block block2 = new Block();
        block2.setPeriod("10/2014", "01/2016");
        block2.setBlockHeader("Старший разработчик (backend)");
        block2.setBlockDesc("Проектирование и разработка онлайн платформы управления проектами Wrike " +
                "(Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.");
        listBlock2.addBlock(block2);
        objectSection.addInfo(listBlock2);

        ListBlock listBlock3 = new ListBlock("RIT Center");
        Block block3 = new Block();
        block3.setPeriod("04/2012", "10/2014");
        block3.setBlockHeader("Java архитектор");
        block3.setBlockDesc("Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы" +
                " (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: " +
                "CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера " +
                "документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, " +
                "Unix shell remote scripting via ssh tunnels, PL/Python");
        listBlock3.addBlock(block3);
        objectSection.addInfo(listBlock3);

        ListBlock listBlock4 = new ListBlock("Luxoft (Deutsche Bank)");
        Block block4 = new Block();
        block4.setPeriod("12/2010", "04/2012");
        block4.setBlockHeader("Ведущий программист");
        block4.setBlockDesc("Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. " +
                "Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, " +
                "Commet, HTML5.");
        listBlock4.addBlock(block4);
        objectSection.addInfo(listBlock4);

        ListBlock listBlock5 = new ListBlock("Yota");
        Block block5 = new Block();
        block5.setPeriod("06/2008", "12/2010");
        block5.setBlockHeader("Ведущий специалист");
        block5.setBlockDesc("Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). " +
                "Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)");
        listBlock5.addBlock(block5);
        objectSection.addInfo(listBlock5);

        ListBlock listBlock6 = new ListBlock("Enkata");
        Block block6 = new Block();
        block6.setPeriod("03/2007", "06/2008");
        block6.setBlockHeader("Разработчик ПО");
        block6.setBlockDesc("Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).");
        listBlock6.addBlock(block6);
        objectSection.addInfo(listBlock6);

        ListBlock listBlock7 = new ListBlock("Siemens AG");
        Block block7 = new Block();
        block7.setPeriod("01/2005", "02/2007");
        block7.setBlockHeader("Разработчик ПО");
        block7.setBlockDesc("Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).");
        listBlock7.addBlock(block7);
        objectSection.addInfo(listBlock7);

        ListBlock listBlock8 = new ListBlock("Alcatel");
        Block block8 = new Block();
        block8.setPeriod("09/1997", "01/2005");
        block8.setBlockHeader("Инженер по аппаратному и программному тестированию");
        block8.setBlockDesc("Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).");
        listBlock8.addBlock(block8);
        objectSection.addInfo(listBlock8);
        return objectSection;
    }

    private static Section getEducationSection() {
        ObjectSection objectSection = new ObjectSection("");

        ListBlock listBlock1 = new ListBlock("Coursera");
        Block block1 = new Block();
        block1.setPeriod("03/2013", "05/2013");
        block1.setBlockHeader("\"Functional Programming Principles in Scala\" by Martin Odersky");
        block1.setBlockDesc("");
        listBlock1.addBlock(block1);
        objectSection.addInfo(listBlock1);

        ListBlock listBlock2 = new ListBlock("Luxoft");
        Block block2 = new Block();
        block2.setPeriod("03/2011", "04/2011");
        block2.setBlockHeader("Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"");
        block2.setBlockDesc("");
        listBlock2.addBlock(block2);
        objectSection.addInfo(listBlock2);

        ListBlock listBlock3 = new ListBlock("Siemens AG");
        Block block3 = new Block();
        block3.setPeriod("01/2005", "04/2005");
        block3.setBlockHeader("3 месяца обучения мобильным IN сетям (Берлин)");
        block3.setBlockDesc("");
        listBlock3.addBlock(block3);
        objectSection.addInfo(listBlock3);

        ListBlock listBlock4 = new ListBlock("Alcatel");
        Block block4 = new Block();
        block4.setPeriod("09/1997", "03/1998");
        block4.setBlockHeader("6 месяцев обучения цифровым телефонным сетям (Москва)");
        block4.setBlockDesc("");
        listBlock4.addBlock(block4);
        objectSection.addInfo(listBlock4);

        ListBlock listBlock5 = new ListBlock("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики");
        Block block51 = new Block();
        block51.setPeriod("09/1993", "07/1996");
        block51.setBlockHeader("Аспирантура (программист С, С++)");
        block51.setBlockDesc("");
        listBlock5.addBlock(block51);

        Block block52 = new Block();
        block52.setPeriod("09/1987", "07/1993");
        block52.setBlockHeader("Инженер (программист Fortran, C)");
        block52.setBlockDesc("");
        listBlock5.addBlock(block52);
        objectSection.addInfo(listBlock5);

        ListBlock listBlock6 = new ListBlock("Заочная физико-техническая школа при МФТИ");
        Block block6 = new Block();
        block6.setPeriod("09/1984", "06/1987");
        block6.setBlockHeader("Закончил с отличием");
        block6.setBlockDesc("");
        listBlock6.addBlock(block6);
        objectSection.addInfo(listBlock6);
        return objectSection;
    }

}
