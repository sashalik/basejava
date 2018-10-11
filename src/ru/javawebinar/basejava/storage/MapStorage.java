package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    private Map<String, Resume> storage = new HashMap<>();

    @Override
    protected void clean() {
        storage.clear();
    }

    @Override
    protected void replaceResume(Resume resume, Object index) {
        storage.replace(index.toString(), resume);
    }

    @Override
    protected void saveResume(Resume resume, Object index) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getResume(Object index) {
        return storage.get(index.toString());
    }

    @Override
    protected void removeResume(Object index) {
        storage.remove(index.toString());
    }

    @Override
    protected Resume[] getAllResume() {
        Resume[] resume = new Resume[storage.size()];
        int index = 0;

        for (Map.Entry<String, Resume> entry : storage.entrySet()) {
            resume[index] = entry.getValue();
            index++;
        }
        return resume;
    }

    @Override
    protected int getSizeStorage() {
        return storage.size();
    }

    @Override
    protected Object getIndex(String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected boolean getContent(Object index) {
        return index != null;
    }
}
