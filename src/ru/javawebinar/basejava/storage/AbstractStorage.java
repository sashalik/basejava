package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {
    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    public void clear() {
        clean();
    }

    public void update(Resume resume) {
        LOG.info("Update " + resume);
        SK searchKey = getSearchKey(resume.getUuid());
        if (!isExist(searchKey)) {
            LOG.warning("Resume '" + resume + "' is not contained in the array");
            throw new NotExistStorageException(resume.getUuid());
        }
        replaceResume(resume, searchKey);
    }

    public void save(Resume resume) {
        LOG.info("Save " + resume);
        SK searchKey = getSearchKey(resume.getUuid());
        if (isExist(searchKey)) {
            LOG.warning("Resume '" + resume + "' is already in the array");
            throw new ExistStorageException(resume.getUuid());
        }
        saveResume(resume, searchKey);
    }

    public Resume get(String uuid) {
        LOG.info("Get " + uuid);
        SK searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            LOG.warning("Resume '" + uuid + "' is not contained in the array");
            throw new NotExistStorageException(uuid);
        }
        return getResume(searchKey);
    }

    public void delete(String uuid) {
        LOG.info("Delete " + uuid);
        SK searchKey = getSearchKey(uuid);

        if (!isExist(searchKey)) {
            LOG.warning("Resume '" + uuid + "' is not contained in the array");
            throw new NotExistStorageException(uuid);
        }
        removeResume(searchKey);
    }

    public List<Resume> getAllSorted() {
        List<Resume> resumeList = getAllResume();
        Collections.sort(resumeList);
        return resumeList;
    }

    protected abstract List<Resume> getAllResume();

    public abstract int size();

    protected abstract void clean();

    protected abstract void replaceResume(Resume resume, SK searchKey);

    protected abstract void saveResume(Resume resume, SK searchKey);

    protected abstract Resume getResume(SK searchKey);

    protected abstract void removeResume(SK searchKey);

    protected abstract SK getSearchKey(String uuid);

    protected abstract boolean isExist(SK searchKey);
}
