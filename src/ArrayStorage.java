import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume resume) {
        int i = getIndex(resume.uuid);
        if (i == -1) {
            storage[size] = resume;
            size++;
        }
    }

    Resume get(String uuid) {
        int i = getIndex(uuid);
        if (i == -1) {
            return null;
        } else {
            return storage[i];
        }
    }

    void delete(String uuid) {
        int i = getIndex(uuid);
        if (i != -1) {
            storage[i] = null;
            rebuildArray(i);
            size--;
        }
    }

    void update(Resume resume, String newUuid){
        int i = getIndex(resume.uuid);
        if (i !=-1){
            resume.uuid = newUuid;
            storage[i] = resume;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }

    // пересобираем массив.
    void rebuildArray(int i) {
        System.arraycopy(storage, i + 1, storage, i, size - i);
    }

    //Метод получения текущего индекса для объекта
    int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid == uuid) {
                return i;
            }
        }
        return -1;
    }
}
