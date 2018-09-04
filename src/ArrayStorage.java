import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage,null);
    }

    void save(Resume r) {
        storage[size()] = r;
    }

    Resume get(String uuid) {
        return storage[getIndex(uuid)];
    }

    void delete(String uuid) {
        storage[getIndex(uuid)] = null;
        sortArray();
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {

        return Arrays.copyOf(storage,size());
        //return new Resume[0];
    }

    int size(){

        int size = 0;

        while(storage[size] != null)
        {
            size++;
        }

        return size;
    }

    // Метод сортировки массива, чтобы сразу
    void sortArray(){
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

        for (int i = 0; i < size(); i++){
            if (storage[i].uuid == uuid) {
                indexBuf = i;
                break;
            }
        }

        return indexBuf;
    }
}
