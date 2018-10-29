package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clean() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void replaceResume(Resume resume, Integer index) {
        storage[index] = resume;
    }

    @Override
    public void saveResume(Resume resume, Integer index) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("The size of the array has reached acceptable limits", resume.getUuid());
        } else {
            saveResume(resume, (int) index);
            size++;
        }
    }

    @Override
    public Resume getResume(Integer index) {

        return storage[index];
    }

    public void removeResume(Integer index) {
        deleteResume(index);
        storage[--size] = null;
    }

    @Override
    public List<Resume> getAllResume() {
        return Arrays.asList(Arrays.copyOf(storage, size));
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isExist(Integer index) {
        return (int) index >= 0;
    }

    protected abstract void saveResume(Resume resume, int index);

    protected abstract void deleteResume(int index);
}
