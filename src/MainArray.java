import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Interactive test for ArrayStorage implementation
 * (just run, no need to understand)
 */
public class MainArray {
    private final static ArrayStorage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Resume r;
        while (true) {
            System.out.print("Введите одну из команд - (list | save uuid | update uuid newuuid | delete uuid | get uuid | clear | exit): ");
            String[] params = reader.readLine().trim().toLowerCase().split(" ");
            if (params.length < 1 || params.length > 3) {
                System.out.println("Неверная команда.");
                continue;
            }
            String uuid = null;
            String newUuid = null;
            if (params.length == 2) {
                uuid = params[1].intern();
            }
            if (params.length == 3) {
                uuid = params[1].intern();
                newUuid = params[2].intern();
            }
            switch (params[0]) {
                case "list":
                    printAll();
                    break;
                case "size":
                    System.out.println(ARRAY_STORAGE.size());
                    break;
                case "save":
                    if (ARRAY_STORAGE.getIndex(uuid) != -1) {
                        System.out.println("Resume '" + uuid + "' is already in the array");
                        printAll();
                        break;
                    } else if (ARRAY_STORAGE.size() == 10000) {
                        System.out.println("The size of the array has reached acceptable limits");
                        printAll();
                        break;
                    } else {
                        r = new Resume();
                        r.uuid = uuid;
                        ARRAY_STORAGE.save(r);
                        printAll();
                        break;
                    }
                case "update":
                    if (ARRAY_STORAGE.getIndex(uuid) == -1) {
                        System.out.println("Resume '" + uuid + "' is not contained in the array");
                        printAll();
                        break;
                    } else if (newUuid == null) {
                        System.out.println("No new value specified for the change");
                        printAll();
                        break;
                    } else if (ARRAY_STORAGE.getIndex(newUuid) != -1) {
                        System.out.println("The Resume '" + uuid + "' cannot be updated. The array already has an element with '" + newUuid + "'.");
                        printAll();
                        break;
                    } else {
                        r = new Resume();
                        r.uuid = uuid;
                        ARRAY_STORAGE.update(r, newUuid);
                        printAll();
                        break;
                    }
                case "delete":
                    if (ARRAY_STORAGE.getIndex(uuid) == -1) {
                        System.out.println("Resume '" + uuid + "' is not contained in the array");
                        printAll();
                        break;
                    } else {
                        ARRAY_STORAGE.delete(uuid);
                        printAll();
                        break;
                    }
                case "get":
                    if (ARRAY_STORAGE.getIndex(uuid) == -1) {
                        System.out.println("Resume '" + uuid + "' is not contained in the array");
                        printAll();
                        break;
                    } else {
                        System.out.println(ARRAY_STORAGE.get(uuid));
                        break;
                    }
                case "clear":
                    ARRAY_STORAGE.clear();
                    printAll();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Неверная команда.");
                    break;
            }
        }
    }

    static void printAll() {
        Resume[] all = ARRAY_STORAGE.getAll();
        System.out.println("----------------------------");
        if (all.length == 0) {
            System.out.println("Empty");
        } else {
            for (Resume r : all) {
                System.out.println(r);
            }
        }
        System.out.println("----------------------------");
    }
}