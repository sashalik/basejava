package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<I> implements Storage {
    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    public void clear() {
        clean();
    }

    public void update(Resume resume) {
        LOG.info("Update " + resume);
        I index = getIndex(resume.getUuid());
        if (!isExist(index)) {
            LOG.warning("Resume '" + resume + "' is not contained in the array");
            throw new NotExistStorageException(resume.getUuid());
        }
        replaceResume(resume, index);
    }

    public void save(Resume resume) {
        LOG.info("Save " + resume);
        I index = getIndex(resume.getUuid());
        if (isExist(index)) {
            LOG.warning("Resume '" + resume + "' is already in the array");
            throw new ExistStorageException(resume.getUuid());
        }
        saveResume(resume, index);
    }

    public Resume get(String uuid) {
        LOG.info("Get " + uuid);
        I index = getIndex(uuid);
        if (!isExist(index)) {
            LOG.warning("Resume '" + uuid + "' is not contained in the array");
            throw new NotExistStorageException(uuid);
        }
        return getResume(index);
    }

    public void delete(String uuid) {
        LOG.info("Delete " + uuid);
        I index = getIndex(uuid);

        if (!isExist(index)) {
            LOG.warning("Resume '" + uuid + "' is not contained in the array");
            throw new NotExistStorageException(uuid);
        }
        removeResume(index);
    }

    public List<Resume> getAllSorted() {
        List<Resume> resumeList = getAllResume();
        Collections.sort(resumeList);
        return resumeList;
    }

    protected abstract List<Resume> getAllResume();

    public abstract int size();

    protected abstract void clean();

    protected abstract void replaceResume(Resume resume, I index);

    protected abstract void saveResume(Resume resume, I index);

    protected abstract Resume getResume(I index);

    protected abstract void removeResume(I index);

    protected abstract I getIndex(String uuid);

    protected abstract boolean isExist(I index);
}
