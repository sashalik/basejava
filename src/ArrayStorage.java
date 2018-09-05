import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        return storage[getIndex(uuid)];
    }

    void delete(String uuid) {
        if (size != 0) {
            storage[getIndex(uuid)] = null;
            rebuildArray();
            size--;
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
    void rebuildArray() {

        for (int i = 0; i < storage.length; i++) {
            if (i == storage.length - 1) {
                break;
            } else if (storage[i] == null && storage[i + 1] == null) {
                break;
            } else if (storage[i] == null) {
                storage[i] = storage[i + 1];
                storage[i + 1] = null;
            }
        }
    }

    //Метод получения текущего индекса для объекта
    int getIndex(String uuid) {
        int indexBuf = 0;

        for (int i = 0; i < size; i++) {
            if (storage[i].uuid == uuid) {
                indexBuf = i;
                break;
            }
        }

        return indexBuf;
    }
}
