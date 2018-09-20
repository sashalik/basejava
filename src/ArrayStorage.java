import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {

        if (getIndex(resume) != -1) {
            System.out.println("Resume '" + resume + "' is already in the array");
        } else if (this.size() == 10000) {
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
        int index = getIndex(resume);

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

    //Метод получения текущего индекса по uuid
    private int getIndex(String uuid) {

        for (int i = 0; i < size; i++) {
            if (storage[i].uuid == uuid) {
                return i;
            }
        }
        return -1;
    }

    // Метод получени индекса по поиску объекта в массиве
    private int getIndex(Resume resume) {
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(resume)) {
                return i;
            }
        }
        return -1;
    }
}
