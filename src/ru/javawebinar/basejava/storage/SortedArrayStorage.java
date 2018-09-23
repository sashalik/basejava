package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());

        if (index < 0) {
            System.out.println("Resume '" + resume + "' is not contained in the array");
        } else {
            storage[index] = resume;
        }
    }

    @Override
    public void save(Resume resume) {
        if (getIndex(resume.getUuid()) >= 0) {
            System.out.println("Resume '" + resume + "' is already in the array");
        } else if (size == STORAGE_LIMIT) {
            System.out.println("The size of the array has reached acceptable limits");
        } else {
            storage[size++] = resume;
            sortArray();
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);

        if (index < 0) {
            System.out.println("Resume '" + uuid + "' is not contained in the array");
        } else {
            rebuildArray(index);
            size--;
        }
    }

    void sortArray() {
        for (int i = size - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (storage[j].compareTo(storage[j + 1]) > 0) {
                    Resume tmp = storage[j];
                    storage[j] = storage[j + 1];
                    storage[j + 1] = tmp;
                }
            }
        }
    }

    @Override
    public Resume[] getAll() {
        return super.getAll();
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
