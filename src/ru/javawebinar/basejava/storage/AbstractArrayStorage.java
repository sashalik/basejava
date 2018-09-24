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

        if (index == -1) {
            System.out.println("Resume '" + resume + "' is not contained in the array");
        } else {
            storage[index] = resume;
        }
    }

    public void save(Resume resume) {
        if (getIndex(resume.getUuid()) != -1) {
            System.out.println("Resume '" + resume + "' is already in the array");
        } else if (size == STORAGE_LIMIT) {
            System.out.println("The size of the array has reached acceptable limits");
        } else {
            storage[size++] = resume;
        }
    }

    public int size() {
        return size;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);

        if (index == -1) {
            System.out.println("Resume '" + uuid + "' is not contained in the array");
        } else {
            rebuildArray(index, "Del");
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    // пересобираем массив.
    protected void rebuildArray(int i, String action) {
        if (action.equals("Save")) {
            System.arraycopy(storage, i, storage, i + 1, size - i);
        }

        if (action.equals("Del")) {
             System.arraycopy(storage, i + 1, storage, i, size - i);
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);

        if (index == -1) {
            System.out.println("Resume '" + uuid + "' is not contained in the array");
            return null;
        }
        return storage[index];
    }

    protected abstract int getIndex(String uuid);
}
