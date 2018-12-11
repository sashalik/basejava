package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorage extends AbstractStorage<String> {

    private Map<String, Resume> storage = new HashMap<>();

    @Override
    protected void clean() {
        storage.clear();
    }

    @Override
    protected void replaceResume(Resume resume, String index) {
        storage.replace(index, resume);
    }

    @Override
    protected void saveResume(Resume resume, String index) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getResume(String index) {
        return storage.get(index);
    }

    @Override
    protected void removeResume(String index) {
        storage.remove(index);
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
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(String index) {
        return storage.containsKey(index);
    }
}
