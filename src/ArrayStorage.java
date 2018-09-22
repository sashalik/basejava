import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private static final int MAX_LENGTH = 10000;
    private Resume[] storage = new Resume[MAX_LENGTH];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        if (getIndex(resume.uuid) != -1) {
            System.out.println("Resume '" + resume + "' is already in the array");
        } else if (size == MAX_LENGTH) {
            System.out.println("The size of the array has reached acceptable limits");
        } else {
            storage[size++] = resume;
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);

        if (index == -1) {
            System.out.println("Resume '" + uuid + "' is not contained in the array");
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);

        if (index == -1) {
            System.out.println("Resume '" + uuid + "' is not contained in the array");
        } else {
            rebuildArray(index);
            size--;
        }
    }

    public void update(Resume resume) {
        int index = getIndex(resume.uuid);

        if (index == -1) {
            System.out.println("Resume '" + resume + "' is not contained in the array");
        } else {
            storage[index] = resume;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    // пересобираем массив.
    private void rebuildArray(int i) {
        System.arraycopy(storage, i + 1, storage, i, size - i);
    }

    // Метод получения индекса по поиску объекта в массиве
    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
