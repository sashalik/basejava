package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    private static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getUuid);

    @Override
    public void saveResume(Resume resume, int index) {
        System.arraycopy(storage, -index - 1, storage, -index - 1 + 1, size - (-index - 1));
        storage[-index - 1] = resume;
    }

    @Override
    public void deleteResume(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - index - 1);
    }

    @Override
    protected Integer getKey(String uuid) {
        return Arrays.binarySearch(storage, 0, size, new Resume(uuid, null), RESUME_COMPARATOR);
    }
}
