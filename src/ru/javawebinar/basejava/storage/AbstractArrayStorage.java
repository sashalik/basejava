package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clean() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void replaceResume(Resume resume, Object index) {
        storage[(int) index] = resume;
    }

    @Override
    public void saveResume(Resume resume, Object index) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("The size of the array has reached acceptable limits", resume.getUuid());
        } else {
            saveResume(resume, (int) index);
            size++;
        }
    }

    @Override
    public Resume getResume(Object index) {

        return storage[(int) index];
    }

    public void removeResume(Object index) {
        deleteResume((int) index);
        storage[--size] = null;
    }

    @Override
    public Resume[] getAllResume() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    public int getSizeStorage() {
        return size;
    }

    @Override
    public boolean getContent(Object index) {
        return (int) index >= 0;
    }

    protected abstract void saveResume(Resume resume, int index);

    protected abstract void deleteResume(int index);
}
