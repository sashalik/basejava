package ru.javawebinar.basejava;

import java.io.File;
import java.io.IOException;

public class MainFile {
    // Recursive function
    private static void findFiles(File file) throws IOException {
        if (file.isDirectory()) {
            File[] list = file.listFiles();
            if (list != null) {
                for (int i = 0; i < list.length; i++) {
                    findFiles(list[i]);
                }
            }
        } else {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }

    public static void main(String[] args) {
        File directory = new File("C:\\LearningJava\\basejava");  // Root directory

        try {
            findFiles(directory);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*String filePath = "..\\.gitignore";
        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }
        File dir = new File(".\\src\\ru\\javawebinar\\basejava");
        System.out.println(dir.isDirectory());

        String[] list = dir.list();
        if (list != null) {
            for (String name : dir.list()) {
                System.out.println(name);
            }
        }

        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }*/


    }
}
