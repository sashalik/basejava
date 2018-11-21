package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File> {
    private File directory;

    protected AbstractFileStorage(File directory) {
        Objects.requireNonNull(directory, "directory must not be null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not readable/writable");
        }
        this.directory = directory;
    }

    @Override
    protected List<Resume> getAllResume() {
        return getAllFileResume();
    }

    @Override
    public int size() {
        return directory.listFiles() == null ? 0 : directory.listFiles().length;
    }

    @Override
    protected void clean() {
        File[] listFiles = directory.listFiles();
        if (listFiles != null) {
            Arrays.stream(listFiles).forEach(File::delete);
        }
    }

    @Override
    protected void replaceResume(Resume resume, File file) {
        try {
            file.createNewFile();
            writeResume(resume, file);
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(), e);
        }
    }

    @Override
    protected void saveResume(Resume resume, File file) {
        try {
            file.createNewFile();
            writeResume(resume, file);
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(), e);
        }
    }

    @Override
    protected Resume getResume(File file) {
        return readFileResume(file);
    }

    @Override
    protected void removeResume(File file) {
        removeFileResume(file);
    }

    @Override
    protected File getIndex(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    protected abstract void removeFileResume(File file);

    protected abstract List<Resume> getAllFileResume();

    protected abstract Resume readFileResume(File file);

    protected abstract void writeResume(Resume resume, File file) throws IOException;


}
