import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        Arrays.fill(storage,null);
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        return storage[getIndex(uuid)];
    }

    void delete(String uuid) {
        if (size != 0){
        storage[getIndex(uuid)] = null;
        rebuildArray();
        size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage,size);
    }

    int size(){
        return size;
    }

    // пересобираем массив.
    void rebuildArray(){
        Resume[] arrayBuf = new Resume[10000];
        int indexBuf = 0;

        for(int i = 0; i < storage.length; i++) {
            if (storage[i] != null){
                arrayBuf[indexBuf] = storage[i];
                indexBuf++;
            }
        }

        clear();
        System.arraycopy(arrayBuf,0,storage,0,arrayBuf.length);
        Arrays.fill(arrayBuf,null);
    }

    //Метод получения текущего индекса для объекта
    int getIndex(String uuid){
        int indexBuf = -1;

        for (int i = 0; i < size; i++){
            if (storage[i].uuid == uuid) {
                indexBuf = i;
                break;
            }
        }

        return indexBuf;
    }
}
