package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    List<Resume> storage = new ArrayList<>();

    @Override
    protected void clean() {
        storage.clear();
    }

    @Override
    protected void replaceResume(Resume resume, Object index) {
        storage.set((int) index, resume);
    }

    @Override
    protected void saveResume(Resume resume, Object index) {
        storage.add(resume);
    }

    @Override
    protected Resume getResume(Object index) {
        return storage.get((int) index);
    }

    @Override
    protected void removeResume(Object index) {
        storage.remove((int) index);
    }

    @Override
    protected Resume[] getAllResume() {
        Resume[] resume = storage.toArray(new Resume[storage.size()]);
        return resume;

    }

    @Override
    protected int getSizeStorage() {
        return storage.size();
    }

    @Override
    protected Object getIndex(String uuid) {

        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected boolean getContent(Object index) {
        return (int) index >= 0;
    }
}
