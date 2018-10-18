package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorageResume extends AbstractStorage {

    private Map<String, Resume> storage = new HashMap<>();

    @Override
    protected void clean() {
        storage.clear();
    }

    @Override
    protected void replaceResume(Resume resume, Object index) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void saveResume(Resume resume, Object index) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getResume(Object index) {
        return storage.get(((Resume)index).getUuid());
    }

    @Override
    protected void removeResume(Object index) {
        storage.remove(((Resume)index).getUuid());
    }

    @Override
    public List<Resume> getAllResume() {
        return new ArrayList<Resume>(storage.values());
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected Resume getIndex(String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected boolean isExist(Object index) {
        return index != null;
    }
}
