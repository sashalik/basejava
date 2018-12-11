package ru.javawebinar.basejava.storage;

import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.ResumeTestData;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.*;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static ru.javawebinar.basejava.model.ContactType.*;
import static ru.javawebinar.basejava.model.SectionType.*;
//import static org.junit.Assert.assertSame;

public class AbstractStorageTest {
    protected static final File STORAGE_DIR = new File("C:\\LearningJava\\basejava\\storage");

    protected Storage storage;
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
        resume_1 = ResumeTestData.getResume();

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
        resume_2.addSection(EXPERIENCE, new OrganizationSection(
                new Organization("Work 2", "",
                        new Organization.Position("01.01.2017", "Now", "System analyst", "Software developer"))));
        resume_2.addSection(EDUCATION,
                new OrganizationSection(
                        new Organization("Kemerovo State University", "kemsu.ru",
                                new Organization.Position("01.09.2005", "01.07.2011", "Student", "Study"),
                                new Organization.Position("01.04.2011", "01.07.2011", "Engineer", "Support")
                        )
                )
        );

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
        resume_3.addSection(EXPERIENCE, new OrganizationSection(
                new Organization("Work 3", "",
                        new Organization.Position("01.01.2017", "Now", "System analyst", "Software developer"))));
        resume_3.addSection(EDUCATION,
                new OrganizationSection(
                        new Organization("Kemerovo State University", "kemsu.ru",
                                new Organization.Position("01.09.2005", "01.07.2011", "Student", "Study"),
                                new Organization.Position("01.04.2011", "01.07.2011", "Engineer", "Support")
                        )
                )
        );

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
        resume_4.addSection(EXPERIENCE, new OrganizationSection(
                new Organization("Work 2", "",
                        new Organization.Position("01.01.2017", "Now", "Product owner", "Software developer"))));
        resume_4.addSection(EDUCATION,
                new OrganizationSection(
                        new Organization("Kemerovo State University", "kemsu.ru",
                                new Organization.Position("01.09.2005", "01.07.2011", "Student", "Study"),
                                new Organization.Position("01.04.2011", "01.07.2011", "Engineer", "Support")
                        )
                )
        );
    }


    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(resume_1);
        storage.save(resume_2);
        storage.save(resume_3);
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        sizeCheck(0);
    }

    @Test
    public void update() throws Exception {
        Resume resume = new Resume(UUID_2, FULLNAME_2);
        storage.update(resume);
        assertSame(storage.get(UUID_2), resume);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        storage.get("valera");
    }

    @Test
    public void save() throws Exception {
        storage.save(resume_4);
        sizeCheck(4);
        contentCheck(resume_4);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(resume_1);
    }


    @Test
    public void get() throws Exception {
        contentCheck(resume_1);
        contentCheck(resume_2);
        contentCheck(resume_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(UUID_1);
        sizeCheck(2);
        storage.get(UUID_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete("dummy");
    }

    @Test
    public void getAllSorted() throws Exception {
        List<Resume> actualList = storage.getAllSorted();
        assertEquals(3, actualList.size());
        List<Resume> listResume = Arrays.asList(resume_1, resume_2, resume_3);
        Collections.sort(listResume);
        assertEquals(listResume, actualList);
    }

    @Test
    public void size() throws Exception {
        sizeCheck(3);
    }

    private void contentCheck(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }

    private void sizeCheck(int size) {
        assertEquals(size, storage.size());
    }
}