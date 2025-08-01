package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i] != null && value[i].equals(key)) {
                result = i;
                break;
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException("Элемент не найден: " + key);
        }
        return result;
    }

     public static void main(String[] args) {
        String[] array = {"apple", "banana", "cherry"};
        String key = "banana";

        try {
            int index = indexOf(array, key);
            System.out.println("Индекс элемента '" + key + "': " + index);
        } catch (ElementNotFoundException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

       String missingKey = "grape";
        try {
            int index = indexOf(array, missingKey);
            System.out.println("Индекс элемента '" + missingKey + "': " + index);
        } catch (ElementNotFoundException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}