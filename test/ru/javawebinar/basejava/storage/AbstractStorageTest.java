package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AbstractStorageTest {

    protected Storage storage;
    public static final String UUID_1 = "uuid1";
    public static final String UUID_2 = "uuid2";
    public static final String UUID_3 = "uuid3";
    public static final String UUID_4 = "uuid4";

    public static final String FULLNAME_1 = "gena";
    public static final String FULLNAME_2 = "vera";
    public static final String FULLNAME_3 = "dima";
    public static final String FULLNAME_4 = "serega";

    public static final Resume resume_1 = new Resume(UUID_1, FULLNAME_1);
    public static final Resume resume_2 = new Resume(UUID_2, FULLNAME_2);
    public static final Resume resume_3 = new Resume(UUID_3, FULLNAME_3);
    public static final Resume resume_4 = new Resume(UUID_4, FULLNAME_4);

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
        Assert.assertSame(storage.get(resume_2.getUuid()), resume);
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
        List<Resume> storageTemp = storage.getAllSorted();
        Assert.assertEquals(3, storageTemp.size());
        List<Resume> listResume = Arrays.asList(resume_1, resume_2, resume_3);
        Collections.sort(listResume);
        Assert.assertEquals(storageTemp, listResume);
    }

    @Test
    public void size() throws Exception {
        sizeCheck(3);
    }

    private void contentCheck(Resume resume) {
        Assert.assertEquals(resume, storage.get(resume.getUuid()));
    }

    private void sizeCheck(int size) {
        Assert.assertEquals(size, storage.size());
    }
}