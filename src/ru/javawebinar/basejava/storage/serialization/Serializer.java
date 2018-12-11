package ru.javawebinar.basejava.storage.serialization;

import ru.javawebinar.basejava.model.Resume;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface Serializer {

    Resume readResume(InputStream is) throws IOException;

    void writeResume(Resume resume, OutputStream os) throws IOException;
}
