package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("eeeee", "a", "ccc", "dddd", "bb");

        Comparator<String> comparator = (left, right) -> {
            System.out.println("Сравнение: '" + left + "' (длина: " + left.length() +
                    ") с '" + right + "' (длина: " + right.length() + ")");
            int result = Integer.compare(right.length(), left.length());
            System.out.println("Результат: " + result + " (" +
                    (result < 0 ? "left > right" :
                            result > 0 ? "left < right" : "left = right") + ")");
            System.out.println("---");
            return result;
        };

        strings.sort(comparator);

        System.out.println("\nОтсортированный список:");
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
