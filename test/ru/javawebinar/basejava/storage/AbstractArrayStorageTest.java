package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractArrayStorageTest {
    private Storage storage;
    public static final String UUID_1 = "uuid1";
    public static final String UUID_2 = "uuid2";
    public static final String UUID_3 = "uuid3";
    public static final String UUID_4 = "uuid4";

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        sizeCheck(0);
    }

    @Test
    public void update() throws Exception {
        storage.update(new Resume(UUID_2));
        contentCheck(new Resume(UUID_2));
    }

    @Test
    public void save() throws Exception {
        storage.save(new Resume(UUID_4));
        sizeCheck(4);
        contentCheck(new Resume(UUID_4));
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
       storage.save(new Resume(UUID_1));
    }

    @Test(expected = StorageException.class)
    public void arrayOverflow() {
        try {
            for(int i = 4; i <=10000; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException e) {
            Assert.fail();
        }
        storage.save(new Resume());
    }

    @Test
    public void get() throws Exception {
        contentCheck(new Resume(UUID_1));
        contentCheck(new Resume(UUID_2));
        contentCheck(new Resume(UUID_3));
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
    public void getAll() throws Exception {
        Resume[] storageTemp = storage.getAll();
        Assert.assertEquals(3, storageTemp.length);
        contentCheck(new Resume(UUID_1));
        contentCheck(new Resume(UUID_2));
        contentCheck(new Resume(UUID_3));
    }

    @Test
    public void size() throws Exception {
        sizeCheck(3);
    }

    private void sizeCheck(int size) {
        Assert.assertEquals(size, storage.size());
    }

    private void contentCheck(Resume resume) {
        Assert.assertEquals(resume, storage.get(resume.getUuid()));
    }
}