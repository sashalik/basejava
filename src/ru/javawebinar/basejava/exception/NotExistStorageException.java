package ru.javawebinar.basejava.exception;

public class NotExistStorageException extends StorageException {
    public NotExistStorageException(String uuid) {
        super("Resume '" + uuid + "' is not contained in the array",uuid);
    }
}
