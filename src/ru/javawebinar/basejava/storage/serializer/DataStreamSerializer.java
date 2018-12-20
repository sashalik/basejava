package ru.javawebinar.basejava.storage.serializer;

import ru.javawebinar.basejava.model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataStreamSerializer implements StreamSerializer {
    @Override
    public Resume readResume(InputStream is) throws IOException {  // doRead
        try (DataInputStream dis = new DataInputStream(is)) {
            String uuid = dis.readUTF();
            String fullName = dis.readUTF();
            Resume resume = new Resume(uuid, fullName);
            int size = dis.readInt();

            for (int i = 0; i < size; i++) {
                resume.addContact(ContactType.valueOf(dis.readUTF()), dis.readUTF());
            }

            size = dis.readInt();

            for (int i = 0; i < size; i++) {
                SectionType sectionType = SectionType.valueOf(dis.readUTF());
                resume.addSection(sectionType, readSection(sectionType, dis));
            }

            return resume;
        }
    }

    private AbstractSection readSection(SectionType sectionType, DataInputStream dis) throws IOException {
        int size;

        switch (sectionType) {
            case OBJECTIVE:
            case PERSONAL:
                return new TextSection(dis.readUTF());
            case ACHIEVEMENT:
            case QUALIFICATIONS:
                size = dis.readInt();
                String[] listQualifications = new String[size];
                for (int i = 0; i < size; i++) {
                    listQualifications[i] = dis.readUTF();
                }
                return new ListTextSection(listQualifications);
            case EXPERIENCE:
            case EDUCATION:
                size = dis.readInt();
                ArrayList<Organization> listEducation = new ArrayList<>(size);
                for (int i = 0; i < size; i++) {
                    Organization organization = new Organization(dis.readUTF(), dis.readUTF());
                    int sizeListPosition = dis.readInt();
                    for (int y = 0; y < sizeListPosition; y++) {
                        organization.addPosition(new Organization.Position(LocalDate.parse(dis.readUTF()), LocalDate.parse(dis.readUTF()), dis.readUTF(), dis.readUTF()));
                    }
                    listEducation.add(organization);
                }
                return new OrganizationSection(listEducation);
            default:
                return null;
        }
    }

    @Override
    public void writeResume(Resume resume, OutputStream os) throws IOException {   // doWrite
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(resume.getUuid());
            dos.writeUTF(resume.getFullName());
            Map<ContactType, String> contacts = resume.getContacts();
            dos.writeInt(contacts.size());

            for (Map.Entry<ContactType, String> entry : resume.getContacts().entrySet()) {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            }

            Map<SectionType, AbstractSection> sections = resume.getSections();
            dos.writeInt(sections.size());

            for (Map.Entry<SectionType, AbstractSection> entry : resume.getSections().entrySet()) {
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
                        /*List<String> listQualifications = ((ListTextSection) section).getListInfo();
                        dos.writeInt(listQualifications.size());
                        for (String info : listQualifications) {
                            dos.writeUTF(info);
                        }*/
                        writeList(dos, ((ListTextSection) section).getListInfo());
                        break;
                    case EXPERIENCE:
                    case EDUCATION:
                        List<Organization> listEducation = ((OrganizationSection) section).getListOrganization();
                        dos.writeInt(listEducation.size());
                        //writeList(dos, listEducation);
                        for (Organization org : listEducation) {
                            dos.writeUTF(org.getLink().getName());
                            dos.writeUTF(org.getLink().getUrl());

                            List<Organization.Position> listPosition = org.getListPosition();
                            dos.writeInt(listPosition.size());

                            //writeList(dos, listPosition);
                            for (Organization.Position position : listPosition) {
                                dos.writeUTF(position.getDateBeg().toString());
                                dos.writeUTF(position.getDateEnd().toString());
                                dos.writeUTF(position.getBlockHeader());
                                dos.writeUTF(position.getBlockDesc());
                            }
                        }
                        break;
                }

            }

        }
    }

    private <T> void writeList(DataOutputStream dos, List<T> list) throws IOException {
        dos.writeInt(list.size());
        for (T element : list) {
            dos.writeUTF(element.toString());
        }
    }
}
