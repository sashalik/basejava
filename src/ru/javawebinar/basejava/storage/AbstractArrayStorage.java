package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());

        if (index < 0) {
            System.out.println("Resume '" + resume + "' is not contained in the array");
        } else {
            storage[index] = resume;
        }
    }

    public abstract void save(Resume resume);

    public Resume get(String uuid) {
        int index = getIndex(uuid);

        if (index < 0) {
            System.out.println("Resume '" + uuid + "' is not contained in the array");
            return null;
        }
        return storage[index];
    }

    public abstract void delete(String uuid);

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    protected abstract int getIndex(String uuid);
}
