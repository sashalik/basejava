package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    Map<String, Resume> storage = new HashMap<>();

    @Override
    protected void saveResume(Resume resume, int index) {

    }

    @Override
    protected void deleteResume(int index) {

    }

    @Override
    protected int getIndex(String uuid) {
        return 0;
    }

    @Override
    protected void clean() {

    }

    @Override
    protected void replaceResume(Resume resume, int index) {

    }

    @Override
    protected Resume getResume(int index) {
        return null;
    }

    @Override
    protected Resume[] getAllResume() {
        return new Resume[0];
    }
}
