package ru.javawebinar.basejava.storage.serializer;

import ru.javawebinar.basejava.model.Resume;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface StreamSerializer {

    Resume readResume(InputStream is) throws IOException;   // doRead

    void writeResume(Resume resume, OutputStream os) throws IOException;  //doWrite
}
