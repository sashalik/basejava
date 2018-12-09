package ru.javawebinar.basejava;

import java.io.File;
import java.io.IOException;

public class MainFile {
    // Recursive function
    private static void findFiles(File files, String shift) throws IOException {
        File[] listFile = files.listFiles();

        if (listFile != null) {
            for (File file : listFile) {
                if (file.isDirectory()) {
                    System.out.println(shift + file.getName());
                    findFiles(file, shift + " ");
                } else if (file.isFile()) {
                    System.out.println(shift + file.getName());
                }
            }
        }
    }

    public static void main(String[] args) {
        File directory = new File("C:\\LearningJava\\basejava\\src");  // Root directory

        try {
            findFiles(directory, "");
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
