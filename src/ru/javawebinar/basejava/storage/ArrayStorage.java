package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());

        if (index >= 0) {
            System.out.println("Resume '" + resume + "' is already in the array");
        } else if (size == STORAGE_LIMIT) {
            System.out.println("The size of the array has reached acceptable limits");
        } else {
            storage[size++] = resume;
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

    // пересобираем массив.
    private void rebuildArray(int i) {
        System.arraycopy(storage, i + 1, storage, i, size - i);
    }


    // Метод получения индекса по поиску объекта в массиве
    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
