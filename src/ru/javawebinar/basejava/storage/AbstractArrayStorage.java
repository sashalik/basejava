package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {
    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    @Override
    public void clean() {
        Arrays.fill(storage, 0, size, null);
    }

    public void replaceResume(Resume resume, int index) {
        storage[index] = resume;
    }

    @Override
    public Resume getResume(int index) {
        return storage[index];
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAllResume() {
        return Arrays.copyOf(storage, size);
    }

}
