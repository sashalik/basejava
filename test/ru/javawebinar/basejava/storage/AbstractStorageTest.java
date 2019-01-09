package ru.javawebinar.basejava.storage;

import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.Config;
import ru.javawebinar.basejava.ResumeTestData;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AbstractStorageTest {
    protected static final File STORAGE_DIR = Config.get().getStorageDir();
    ;

    protected Storage storage;
    protected ResumeTestData resumeTestData;


    public AbstractStorageTest(Storage storage) {
        resumeTestData = new ResumeTestData();
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(resumeTestData.getResume("uuid1"));
        storage.save(resumeTestData.getResume("uuid2"));
        storage.save(resumeTestData.getResume("uuid3"));
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        sizeCheck(0);
    }

    @Test
    public void update() throws Exception {
        Resume resume = resumeTestData.getResume("uuid2");
        storage.update(resume);
        assertTrue(resume.equals(storage.get("uuid2")));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        storage.get("valera");
    }

    @Test
    public void save() throws Exception {
        Resume resume = resumeTestData.getResume("uuid4");
        storage.save(resume);
        sizeCheck(4);
        contentCheck(resume);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(resumeTestData.getResume("uuid1"));
    }

    @Test
    public void get() throws Exception {
        contentCheck(resumeTestData.getResume("uuid1"));
        contentCheck(resumeTestData.getResume("uuid2"));
        contentCheck(resumeTestData.getResume("uuid3"));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete("uuid1");
        sizeCheck(2);
        storage.get("uuid1");
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete("dummy");
    }

    @Test
    public void getAllSorted() throws Exception {
        List<Resume> actualList = storage.getAllSorted();
        assertEquals(3, actualList.size());
        List<Resume> listResume = Arrays.asList(resumeTestData.getResume("uuid1"), resumeTestData.getResume("uuid2"), resumeTestData.getResume("uuid3"));
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