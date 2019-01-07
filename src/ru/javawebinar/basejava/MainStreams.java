package ru.javawebinar.basejava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainStreams {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 3, 2, 6);
        int[] values = {9, 8};
        // {1, 2, 3, 3, 2, 3};       Тестовые наборы
        // {1, 9, 2, 3, 5, 7, 7, 7};
        System.out.println(minValue(values));

        integerList = oddOrEven(integerList);
        for (int i = 0; i < integerList.size(); i++) {
            System.out.println(integerList.get(i));
        }
    }

    private static int minValue(int[] values) {
        int result = 0;
        values = Arrays.stream(values).distinct().sorted().toArray();
        for (int i = 0; i < values.length; i++) {
            result = result * 10 + values[i];
        }
        return result;
    }

    private static List<Integer> oddOrEven(List<Integer> integers) {
        return integers.stream().mapToInt(Integer::intValue).sum() % 2 != 0 ? integers.stream().filter(number -> number % 2 != 0).collect(Collectors.toList()) : integers.stream().filter(number -> number % 2 == 0).collect(Collectors.toList());

    }
}
