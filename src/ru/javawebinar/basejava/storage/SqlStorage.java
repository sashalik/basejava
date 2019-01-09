package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.sql.SqlHelper;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SqlStorage implements Storage {
    public final SqlHelper sqlHelper;

    public SqlStorage(String dbUrl, String dbUser, String dbPassword) {
        sqlHelper = new SqlHelper(() -> DriverManager.getConnection(dbUrl, dbUser, dbPassword));
    }

    @Override
    public void clear() {
        sqlHelper.executeQuery("DELETE FROM resume", PreparedStatement::execute);
    }

    @Override
    public Resume get(String uuid) {
        return sqlHelper.executeQuery("SELECT * FROM resume r WHERE r.uuid =?", st -> {
            st.setString(1, uuid);
            ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                throw new NotExistStorageException(uuid);
            }
            return new Resume(uuid, rs.getString("full_name"));
        });
    }

    @Override
    public void update(Resume r) {
        sqlHelper.executeQuery("UPDATE resume SET full_name = ? where uuid = ?", st -> {
            st.setString(1, r.getFullName());
            st.setString(2, r.getUuid());
            st.execute();
            return null;
        });
    }

    @Override
    public void save(Resume r) {
        sqlHelper.executeQuery("INSERT INTO resume (uuid, full_name) VALUES (?,?)", st -> {
            st.setString(1, r.getUuid());
            st.setString(2, r.getFullName());
            st.execute();
            return null;
        });
    }

    @Override
    public void delete(String uuid) {
        sqlHelper.executeQuery("DELETE FROM resume r where r.uuid = ?", st -> {
            st.setString(1, uuid);
            return null;
        });
    }

    @Override
    public List<Resume> getAllSorted() {
        return sqlHelper.executeQuery("SELECT * FROM resume r ORDER BY full_name,uuid", st -> {
            ResultSet rs = st.executeQuery();
            List<Resume> listResumes = new ArrayList<>();
            while (rs.next()) {
                listResumes.add(new Resume(rs.getString("uuid"), rs.getString("full_name")));
            }
            return listResumes;
        });
    }

    @Override
    public int size() {
        return sqlHelper.executeQuery("SELECT count(*) FROM resume", st -> {
            ResultSet rs = st.executeQuery();
            return rs.next() ? rs.getInt(1) : 0;
        });
    }
}
