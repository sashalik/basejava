package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {
    public void clear() {
        clean();
    }

    public void update(Resume resume) {
        Object index = getIndex(resume.getUuid());
        if (!getContent(index)) {
            throw new NotExistStorageException(resume.getUuid());
        }
        replaceResume(resume, index);
    }

    public void save(Resume resume) {
        Object index = getIndex(resume.getUuid());
        if (getContent(index)) {
            throw new ExistStorageException(resume.getUuid());
        }
        saveResume(resume, index);
    }

    public Resume get(String uuid) {
        Object index = getIndex(uuid);
        if (!getContent(index)) {
            throw new NotExistStorageException(uuid);
        }
        return getResume(index);
    }

    public void delete(String uuid) {
        Object index = getIndex(uuid);

        if (!getContent(index)) {
            throw new NotExistStorageException(uuid);
        }
        removeResume(index);
    }

    public Resume[] getAll() {
        return getAllResume();
    }

    public int size() {
        return getSizeStorage();
    }

    protected abstract void clean();

    protected abstract void replaceResume(Resume resume, Object index);

    protected abstract void saveResume(Resume resume, Object index);

    protected abstract Resume getResume(Object index);

    protected abstract void removeResume(Object index);

    protected abstract Resume[] getAllResume();

    protected abstract int getSizeStorage();

    protected abstract Object getIndex(String uuid);

    protected abstract boolean getContent(Object index);
}
