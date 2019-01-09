package ru.javawebinar.basejava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainStreams {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 3, 2, 5);
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
        return IntStream.of(values)
                .distinct()
                .sorted()
                .reduce(0, (value1, value2) -> value1 * 10 + value2);
    }

    private static List<Integer> oddOrEven(List<Integer> integers) {
        int sum = integers.stream().mapToInt(Integer::intValue).sum();
        return integers.stream().filter(sum % 2 == 0 ?number -> number % 2 != 0 :number -> number % 2 == 0).collect(Collectors.toList());
    }
}
