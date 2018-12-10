package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FileStorage extends AbstractStorage<File> {
    private File directory;

    private Serializer serializer;

    protected FileStorage(File directory, Serializer serializer) {
        Objects.requireNonNull(directory, "directory must not be null");
        this.serializer = serializer;
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
            serializer.writeResume(resume, new FileOutputStream(file));
        } catch (IOException e) {
            throw new StorageException("Error writing file" + file.getAbsolutePath(), file.getName(), e);
        }
    }

    @Override
    protected void saveResume(Resume resume, File file) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new StorageException("Error creating file" + file.getAbsolutePath(), file.getName(), e);
        }
        replaceResume(resume, file);
    }

    @Override
    protected Resume getResume(File file) {
        try {
            return serializer.readResume(new BufferedInputStream(new FileInputStream(file)));
        } catch (IOException e) {
            throw new StorageException("File read error", file.getName(), e);
        }
    }

    @Override
    protected void removeResume(File file) {
        if (!file.delete()) {
            throw new StorageException("File delete error", file.getName());
        }
    }

    @Override
    protected File getKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    protected List<Resume> getAllFileResume() {
        File[] files = directory.listFiles();
        if (files == null) {
            throw new StorageException("Directory read error", "");
        }
        List<Resume> list = new ArrayList<>(files.length);
        for (File file : files) {
            list.add(getResume(file));
        }
        return list;
    }
}
