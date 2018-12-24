package ru.javawebinar.basejava.storage.serializer;

import ru.javawebinar.basejava.model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class DataStreamSerializer implements StreamSerializer {
    @Override
    public Resume readResume(InputStream is) throws IOException {  // doRead
        try (DataInputStream dis = new DataInputStream(is)) {
            String uuid = dis.readUTF();
            String fullName = dis.readUTF();
            Resume resume = new Resume(uuid, fullName);

            readToMap(dis, () -> resume.addContact(ContactType.valueOf(dis.readUTF()), dis.readUTF()));
            
            readToMap(dis, () -> {
                SectionType sectionType = SectionType.valueOf(dis.readUTF());
                resume.addSection(sectionType, readSection(sectionType, dis));
            });

            return resume;
        }
    }

    @Override
    public void writeResume(Resume resume, OutputStream os) throws IOException {   // doWrite
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(resume.getUuid());
            dos.writeUTF(resume.getFullName());
            Map<ContactType, String> contacts = resume.getContacts();

            writeList(dos, contacts.entrySet(), entry -> {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            });

            writeList(dos, resume.getSections().entrySet(), entry -> {
                SectionType sectionType = entry.getKey();
                AbstractSection section = entry.getValue();
                dos.writeUTF(sectionType.name());
                switch (sectionType) {
                    case OBJECTIVE:
                    case PERSONAL:
                        dos.writeUTF(((TextSection) section).getText());
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        writeList(dos, ((ListTextSection) section).getListInfo(), dos::writeUTF);
                        break;
                    case EXPERIENCE:
                    case EDUCATION:
                        writeList(dos, ((OrganizationSection) section).getListOrganization(), org -> {
                            dos.writeUTF(org.getLink().getName());
                            dos.writeUTF(org.getLink().getUrl());
                            writeList(dos, org.getListPosition(),
                                    position -> {
                                        dos.writeUTF(position.getDateBeg().toString());
                                        dos.writeUTF(position.getDateEnd().toString());
                                        dos.writeUTF(position.getBlockHeader());
                                        dos.writeUTF(position.getBlockDesc());
                                    });
                        });
                        break;
                }
            });
        }
    }

    private AbstractSection readSection(SectionType sectionType, DataInputStream dis) throws IOException {

        switch (sectionType) {
            case OBJECTIVE:
            case PERSONAL:
                return new TextSection(dis.readUTF());
            case ACHIEVEMENT:
            case QUALIFICATIONS:
                return new ListTextSection(readList(dis, dis::readUTF));
            case EXPERIENCE:
            case EDUCATION:
                return new OrganizationSection(
                        readList(dis, () -> new Organization(
                                dis.readUTF(), dis.readUTF(), readList(dis, () -> new Organization.Position(
                                LocalDate.parse(dis.readUTF()),
                                LocalDate.parse(dis.readUTF()),
                                dis.readUTF(),
                                dis.readUTF()
                        ))
                        )));
            default:
                return null;
        }
    }

    private <T> void writeList(DataOutputStream dos, Collection<T> list, Writer<T> writer) throws IOException {
        dos.writeInt(list.size());
        for (T element : list) {
            writer.writeList(element);
        }
    }

    public interface Writer<T> {
        void writeList(T t) throws IOException;
    }

    public interface Reader<T> {
        T read() throws IOException;
    }

    public interface MapReader {
        void readMap() throws IOException;
    }

    private <T> List<T> readList(DataInputStream dis, Reader<T> reader) throws IOException {
        int size = dis.readInt();
        List<T> listElements = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            listElements.add(reader.read());
        }
        return listElements;
    }

    private void readToMap(DataInputStream dis, MapReader mapReader) throws IOException {
        int size = dis.readInt();
        for (int i = 0; i < size; i++) {
            mapReader.readMap();
        }
    }
}
