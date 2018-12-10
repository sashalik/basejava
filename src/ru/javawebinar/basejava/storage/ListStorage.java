package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {
    List<Resume> storage = new ArrayList<>();

    @Override
    protected void clean() {
        storage.clear();
    }

    @Override
    protected void replaceResume(Resume resume, Integer index) {
        storage.set(index, resume);
    }

    @Override
    protected void saveResume(Resume resume, Integer index) {
        storage.add(resume);
    }

    @Override
    protected Resume getResume(Integer index) {
        return storage.get(index);
    }

    @Override
    protected void removeResume(Integer index) {
        storage.remove((int)index);
    }

    @Override
    public List<Resume> getAllResume() {
        return storage;
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected Integer getKey(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected boolean isExist(Integer index) {
        return index >= 0;
    }
}
