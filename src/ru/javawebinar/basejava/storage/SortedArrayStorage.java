package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    private static final Comparator<Resume> RESUME_COMPARATOR = (o1, o2) -> o1.getUuid().compareTo(o2.getUuid());

    @Override
    public void saveResume(Resume resume, int index) {
        int indexBuf = -index - 1;

        System.arraycopy(storage, indexBuf, storage, indexBuf + 1, size - indexBuf);
        storage[indexBuf] = resume;
    }

    @Override
    public void deleteResume(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - index - 1);
    }

    @Override
    protected Integer getIndex(String uuid) {
        return Arrays.binarySearch(storage, 0, size, new Resume(uuid, null), RESUME_COMPARATOR);
    }
}
