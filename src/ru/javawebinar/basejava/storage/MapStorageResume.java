package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorageResume extends AbstractStorage<Resume> {

    private Map<String, Resume> storage = new HashMap<>();

    @Override
    protected void clean() {
        storage.clear();
    }

    @Override
    protected void replaceResume(Resume resume, Resume index) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void saveResume(Resume resume, Resume index) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getResume(Resume index) {
        return storage.get(index.getUuid());
    }

    @Override
    protected void removeResume(Resume index) {
        storage.remove(index.getUuid());
    }

    @Override
    public List<Resume> getAllResume() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected Resume getSearchKey(String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected boolean isExist(Resume index) {
        return index != null;
    }
}
