package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());

        if (index >= 0) {
            System.out.println("Resume '" + resume + "' is already in the array");
        } else if (size == STORAGE_LIMIT) {
            System.out.println("The size of the array has reached acceptable limits");
        } else {
            rebuildArray(-index - 1, "Save");
            storage[-index - 1] = resume;
            size++;
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);

        if (index < 0) {
            System.out.println("Resume '" + uuid + "' is not contained in the array");
        } else {
            rebuildArray(index, "Del");
            size--;
        }
    }

    // пересобираем массив.
    private void rebuildArray(int i, String action) {
        if (action.equals("Save")) {
            System.arraycopy(storage, i, storage, i + 1, size - i);
        }

        if (action.equals("Del")) {
            System.arraycopy(storage, i + 1, storage, i, size - i-1);
        }
    }


    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
